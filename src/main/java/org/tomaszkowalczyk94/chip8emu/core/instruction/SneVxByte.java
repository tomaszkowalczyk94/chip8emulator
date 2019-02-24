package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

/**
 * 4xkk - SNE Vx, byte<br />
 * Skip next instruction if Vx != kk.<br />
 *<br />
 * The interpreter compares register Vx to kk, and if they are not equal, increments the program counter by 2.
 */
public class SneVxByte extends AbstractInstruction {
    /**
     * {@inheritDoc}
     */
    public void execute(XBit16 instruction, Chip8 chip8) {
        int x = instruction.getValueOfBits(11, 8);
        int kk = instruction.getValueOfBits(7, 0);

        if(chip8.getRegisters().generalPurpose[x].getUnsignedValue() != kk) {
            incrementPc(chip8);
        }
        incrementPc(chip8);
    }
}
