package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

public class SeVxByte extends AbstractInstruction {

    public void execute(XBit16 instruction, Cpu cpu) {
//        int x = getFrom11And8Bits(instruction).getSignedValue();
//        int kk = getLast8Bits(instruction).getSignedValue();
//
//        if(cpu.getRegisters().generalPurpose[x] == kk) {
//            cpu.getRegisters().programCounter += 4;
//            return;
//        }
//        cpu.getRegisters().programCounter += 2;
    }
}
