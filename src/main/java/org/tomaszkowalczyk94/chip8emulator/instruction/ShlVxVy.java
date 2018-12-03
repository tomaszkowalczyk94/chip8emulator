package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

public class ShlVxVy extends AbstractInstruction {
    public void execute(XBit16 instruction, Cpu cpu) {
        int x = getFrom11And8Bits(instruction).getSignedValue();

        byte xValue = cpu.getRegisters().generalPurpose[x];

        cpu.getRegisters().generalPurpose[0xF] = (byte)((xValue>>7) & 1);

        cpu.getRegisters().generalPurpose[x] = (byte)(xValue<<1);

        cpu.getRegisters().programCounter += 2;
    }
}