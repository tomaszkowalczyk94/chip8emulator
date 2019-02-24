package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

/**
 * 00E0 - CLS
 * Clear the display.
 */
public class Cls extends AbstractInstruction {
    public void execute(XBit16 instruction, Chip8 chip8) {

        chip8.getScreenManager().clear();
        incrementPc(chip8);

    }
}
