package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;
import org.tomaszkowalczyk94.xbit.XBitUtils;

/**
 * 7xkk - ADD Vx, byte<br />
 * Set Vx = Vx + kk.<br />
 * <br />
 * Adds the value kk to the value of register Vx, then stores the result in Vx.
 */
public class AddVxByte extends AbstractInstruction {

    /**
     * {@inheritDoc}
     */
    public void execute(XBit16 instruction, Chip8 chip8) {
        int x = instruction.getValueOfBits(11, 8);
        XBit8 kkByte = XBit8.valueOfUnsigned(instruction.getValueOfBits(7, 0));

        chip8.getRegisters().generalPurpose[x] = XBitUtils.and8bit(
                chip8.getRegisters().generalPurpose[x],
                kkByte
        );

        incrementPc(chip8);
    }
}
