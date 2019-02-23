package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

public class JpAddr extends AbstractInstruction {

    public void execute(XBit16 instruction, Cpu cpu) {
        XBit16 last12Bits = this.getLast12Bits(instruction);

        cpu.getRegisters().programCounter = last12Bits.getUnsignedValue();
    }
}
