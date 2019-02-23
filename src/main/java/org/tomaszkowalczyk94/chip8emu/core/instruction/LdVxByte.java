package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

public class LdVxByte extends AbstractInstruction {
    public void execute(XBit16 instruction, Cpu cpu) {
//        int x = getFrom11And8Bits(instruction).getSignedValue();
//        XBit8 kkByte = getLast8Bits(instruction);
//
//        cpu.getRegisters().generalPurpose[x] = (byte)kkByte.getSignedValue();
//
//        cpu.getRegisters().programCounter += 2;
    }
}
