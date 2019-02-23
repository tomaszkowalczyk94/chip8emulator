package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Cpu;
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


    public void execute(XBit16 instruction, Cpu cpu) {
        int regxId = instruction.getValueOfBits(11, 8);
        int regyId = instruction.getValueOfBits(7, 4);
        int n = instruction.getValueOfBits(3, 0);

        int xPos = cpu.getRegisters().generalPurpose[regxId].getUnsignedValue();
        int yPos = cpu.getRegisters().generalPurpose[regyId].getUnsignedValue();

        cpu.getRegisters().generalPurpose[0xF] = XBit8.valueOfUnsigned(0);
        drawSprite(cpu, xPos, yPos, n);



        //cpu.getScreenManager().setPixel()


//
//        drawExtendedSprite(xPos, yPos, cpu);
//
        cpu.getRegisters().pc = XBitUtils.incrementBy(
                cpu.getRegisters().pc,
                2
        );
    }

    private void drawSprite(Cpu cpu, int xPos, int yPos, int n) {
        ScreenManager screenManager = cpu.getScreenManager();

        int iValue = cpu.getRegisters().i.getUnsignedValue();

        for(int memorySpriteAddress = iValue; memorySpriteAddress < iValue+n; memorySpriteAddress++) {

            XBit8 spriteByte = cpu.getMemory().read(memorySpriteAddress);

            for(int bitIndex = 7; bitIndex>=0; bitIndex--) {

                int positionXInDisplay = calculatePositionXInDisplay(xPos, bitIndex);
                int positionYInDisplay = calculatePositionYInDisplay(yPos, iValue, memorySpriteAddress);


                boolean oldPixelValue = screenManager.getPixel(positionXInDisplay, positionYInDisplay);
                boolean newPixelValue = cpu.getScreenManager().setPixel(positionXInDisplay, positionYInDisplay, spriteByte.getBit(bitIndex));

                if(oldPixelValue && !newPixelValue) {
                    cpu.getRegisters().generalPurpose[0xF] = XBit8.valueOfUnsigned(1);
                }
            }

        }
    }

    private int calculatePositionXInDisplay(int xPos, int bitIndex) {
        return xPos + 7-bitIndex;
    }

    private int calculatePositionYInDisplay(
            int yPos,
            int firstSpriteMemoryAddress,
            int currentSpriteMemoryAddress
    ) {
        return currentSpriteMemoryAddress-firstSpriteMemoryAddress+yPos;
    }

//    private void drawExtendedSprite(int xPos, int yPos, Cpu cpu) {
//        for (int yIndex = 0; yIndex < 16; yIndex++) {
//            for (int xByte = 0; xByte < 2; xByte++) {
//                short colorByte = cpu.getMemory().read(cpu.getRegisters().index + (yIndex * 2) + xByte);
//                int yCoord = yPos + yIndex;
//                yCoord = yCoord % 32;
//
//                int mask = 0x80;
//
//                for (int xIndex = 0; xIndex < 8; xIndex++) {
//                    int xCoord = xPos + xIndex + (xByte * 8);
//                    xCoord = xCoord % 64;
//
//                    boolean turnOn = (colorByte & mask) > 0;
//                    boolean currentOn = cpu.getPixel(xCoord, yCoord);
//
//                    if (turnOn && currentOn) {
//                        cpu.getRegisters().generalPurpose[0xF] |= 1;
//                        turnOn = false;
//                    } else if (!turnOn && currentOn) {
//                        turnOn = true;
//                    }
//
//                    cpu.drawPixel(xCoord, yCoord, turnOn);
//                    mask = mask >> 1;
//                }
//            }
//        }
//    }
}
