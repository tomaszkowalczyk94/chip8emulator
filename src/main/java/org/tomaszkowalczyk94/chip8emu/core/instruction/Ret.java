package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

public class Ret extends AbstractInstruction {
    public void execute(XBit16 instruction, Cpu cpu) {

        byte high = cpu.getMemory().read(cpu.getRegisters().stackPointer);
        byte low = cpu.getMemory().read(cpu.getRegisters().stackPointer+1);
        XBit16 newProgramCounterValue = XBit16.valueOfHighAndLow(XBit8.valueOfSigned(high), XBit8.valueOfSigned(low));

        cpu.getRegisters().programCounter = newProgramCounterValue.getUnsignedValue();

        cpu.getRegisters().stackPointer -= 2;
    }
}
