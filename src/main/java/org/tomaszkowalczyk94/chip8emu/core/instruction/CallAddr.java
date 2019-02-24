package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

/**
 * 2nnn - CALL addr<br />
 * Call subroutine at nnn.<br />
 * <br />
 * The interpreter increments the stack pointer, then puts the current PC on the top of the stack. The PC is then set to nnn.
 */
public class CallAddr extends AbstractInstruction {

    /**
     *  {@inheritDoc}
     */
    public void execute(XBit16 instruction, Chip8 chip8) {

        chip8.getStack().push(
                chip8.getRegisters().pc
        );

        chip8.getRegisters().pc = XBit16.valueOfUnsigned(
                instruction.getValueOfBits(11, 0)
        );
    }

}
