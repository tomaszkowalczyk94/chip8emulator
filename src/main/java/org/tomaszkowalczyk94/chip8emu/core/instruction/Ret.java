package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

/**
 * 00EE - RET<br />
 * Return from a subroutine. <br />
 * <br />
 * The interpreter sets the program counter to the address at the top of the stack, then subtracts 1 from the stack pointer.
 */
public class Ret extends AbstractInstruction {

    /**
     * {@inheritDoc}
     */
    public void execute(XBit16 instruction, Chip8 chip8) {
        chip8.getRegisters().pc = chip8.getStack().pop();
        incrementPc(chip8);
    }
}
