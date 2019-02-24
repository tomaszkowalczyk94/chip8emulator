package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

/**
 * 1nnn - JP addr<br>
 * Jump to location nnn.<br>
 *<br>
 * The interpreter sets the program counter to nnn.
 */
public class JpAddr extends AbstractInstruction {

    public void execute(XBit16 instruction, Chip8 chip8) {
        int valueOfBits = instruction.getValueOfBits(11, 0);

        chip8.getRegisters().pc = XBit16.valueOfUnsigned(valueOfBits);
    }
}
