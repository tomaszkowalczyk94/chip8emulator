package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

public class CallAddr extends AbstractInstruction {

    public void execute(XBit16 instruction, Cpu cpu) {
        cpu.getRegisters().stackPointer += 2;


        XBit16 programCounter = XBit16.valueOfUnsigned(cpu.getRegisters().programCounter);

        cpu.getMemory().write(cpu.getRegisters().stackPointer, programCounter.getFirstByte());
        cpu.getMemory().write(cpu.getRegisters().stackPointer+1, programCounter.getSecondByte());

        cpu.getRegisters().programCounter = getLast12Bits(instruction).getUnsignedValue();
    }

}
