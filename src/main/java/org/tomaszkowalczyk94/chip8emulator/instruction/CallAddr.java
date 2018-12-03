package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

public class CallAddr extends AbstractInstruction {

    public void execute(XBit16 instruction, Cpu cpu) {
        cpu.getRegisters().stackPointer += 2;


        XBit16 programCounter = XBit16.valueOfUnsigned(cpu.getRegisters().programCounter);

        cpu.getMemory().write(cpu.getRegisters().stackPointer, programCounter.getHighByte());
        cpu.getMemory().write(cpu.getRegisters().stackPointer+1, programCounter.getLowByte());

        cpu.getRegisters().programCounter = getLast12Bits(instruction).getUnsignedValue();
    }

}
