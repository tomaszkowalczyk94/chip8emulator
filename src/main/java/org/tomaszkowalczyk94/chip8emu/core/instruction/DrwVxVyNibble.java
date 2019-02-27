package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.chip8emu.core.screen.ScreenManager;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;
import org.tomaszkowalczyk94.xbit.XBitUtils;

/**
 * Dxyn - DRW Vx, Vy, nibble
 * Display n-byte sprite starting at memory location I at (Vx, Vy), set VF = collision.
 *
 * The interpreter reads n bytes from memory, starting at the address stored in I. These bytes are then displayed as
 * sprites on screen at coordinates (Vx, Vy). Sprites are XORed onto the existing screen. If this causes any pixels to
 * be erased, VF is set to 1, otherwise it is set to 0. If the sprite is positioned so part of it is outside
 * the coordinates of the display, it wraps around to the opposite side of the screen. See instruction 8xy3 for more
 * information on XOR, and section 2.4, Display, for more information on the Chip-8 screen and sprites.
 */
public class DrwVxVyNibble extends AbstractInstruction {

    /**
     * {@inheritDoc}
     */
    public void execute(XBit16 instruction, Chip8 chip8) {
        int regxId = instruction.getValueOfBits(11, 8);
        int regyId = instruction.getValueOfBits(7, 4);
        int n = instruction.getValueOfBits(3, 0);

        int xPos = chip8.getRegisters().generalPurpose[regxId].getUnsignedValue();
        int yPos = chip8.getRegisters().generalPurpose[regyId].getUnsignedValue();

        chip8.getRegisters().generalPurpose[0xF] = XBit8.valueOfUnsigned(0);
        drawSprite(chip8, xPos, yPos, n);

        chip8.getRegisters().pc = XBitUtils.incrementBy(
                chip8.getRegisters().pc,
                2
        );
    }

    /**
     * Drawing sprite in display in the given position
     *
     * @param chip8
     * @param xPos horizontal position of sprite in display. The top of display have 0 value.
     * @param yPos vertical position of sprite in display. TMost on the left have 0 value.
     * @param n count of bytes with a sprite
     */
    private void drawSprite(Chip8 chip8, int xPos, int yPos, int n) {
        ScreenManager screenManager = chip8.getScreenManager();

        int iValue = chip8.getRegisters().i.getUnsignedValue();

        for (int memorySpriteAddress = iValue; memorySpriteAddress < iValue + n; memorySpriteAddress++) {

            XBit8 spriteByte = chip8.getMemory().read(memorySpriteAddress);

            for (int bitIndex = 7; bitIndex >= 0; bitIndex--) {

                int positionXInDisplay = calculatePositionXInDisplay(xPos, bitIndex);
                int positionYInDisplay = calculatePositionYInDisplay(yPos, iValue, memorySpriteAddress);


                boolean oldPixelValue = screenManager.getPixel(positionXInDisplay, positionYInDisplay);
                boolean newPixelValue = chip8.getScreenManager().setPixel(positionXInDisplay, positionYInDisplay, spriteByte.getBit(bitIndex));

                if (oldPixelValue && !newPixelValue) {
                    chip8.getRegisters().generalPurpose[0xF] = XBit8.valueOfUnsigned(1);
                }
            }

        }
    }

    /**
     * calculate horizontal position of pixel in display
     *
     * @param xPos     horizontal position of sprite in display (where will be put pixel (0,0) of sprite)
     * @param bitIndex index of bit, in sprite. First index have number 7, the last 0.
     */
    private int calculatePositionXInDisplay(int xPos, int bitIndex) {
        return (xPos + 7 - bitIndex)%64;
    }

    /**
     * calculate vartical position of pixel in display
     *
     * @param yPos                       vertical position of sprite in display (where will be put pixel (0,0) of sprite)
     * @param firstSpriteMemoryAddress   address of first byte of sprite
     * @param currentSpriteMemoryAddress address of sprite's byte, for withch will be calculated vertical position
     *                                   of pixel in display
     * @return vertical position of pixel in display
     */
    private int calculatePositionYInDisplay(
            int yPos,
            int firstSpriteMemoryAddress,
            int currentSpriteMemoryAddress
    ) {
        return (currentSpriteMemoryAddress - firstSpriteMemoryAddress + yPos)%63;
    }

}
