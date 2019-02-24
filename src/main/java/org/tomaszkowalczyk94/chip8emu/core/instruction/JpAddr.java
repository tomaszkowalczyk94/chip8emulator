package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

public class JpAddr extends AbstractInstruction {

    public void execute(XBit16 instruction, Chip8 chip8) {
//        XBit16 last12Bits = this.getLast12Bits(instruction);
//
//        chip8.getRegisters().programCounter = last12Bits.getUnsignedValue();
    }
}
