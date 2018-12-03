package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

public class LdIAddr extends AbstractInstruction {

    public void execute(XBit16 instruction, Cpu cpu) {

        XBit16 last12Bits = getLast12Bits(instruction);

        cpu.getRegisters().index = last12Bits.getUnsignedValue();
        cpu.getRegisters().programCounter += 2;
    }
}
