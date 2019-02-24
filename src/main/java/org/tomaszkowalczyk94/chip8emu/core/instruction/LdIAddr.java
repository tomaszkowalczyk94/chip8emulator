package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

/**
 * Annn - LD I, addr<br />
 * Set I = nnn.<br />
 * <br />
 * The value of register I is set to nnn.
 */
public class LdIAddr extends AbstractInstruction {

    public void execute(XBit16 instruction, Chip8 chip8) {

        int last12Bits = instruction.getValueOfBits(11, 0);

        chip8.getRegisters().i = XBit16.valueOfUnsigned(last12Bits);
        incrementPc(chip8);
    }
}
