package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

/**
 * 5xy0 - SE Vx, Vy<br />
 * Skip next instruction if Vx = Vy.<br />
 * <br />
 * The interpreter compares register Vx to register Vy, and if they are equal, increments the program counter by 2.
 */
public class SeVxVy extends AbstractInstruction {

    public void execute(XBit16 instruction, Chip8 chip8) {
        int x = instruction.getValueOfBits(11, 8);
        int y = instruction.getValueOfBits(7, 4);

        if(chip8.getRegisters().generalPurpose[x].getUnsignedValue() == chip8.getRegisters().generalPurpose[y].getUnsignedValue()) {
            incrementPc(chip8);
        }
        incrementPc(chip8);
    }
}
