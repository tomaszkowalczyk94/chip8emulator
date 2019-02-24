package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

public class ShrVxVy extends AbstractInstruction {
    public void execute(XBit16 instruction, Chip8 chip8) {
//        int x = getFrom11And8Bits(instruction).getSignedValue();
//
//        byte xValue = chip8.getRegisters().generalPurpose[x];
//
//        chip8.getRegisters().generalPurpose[0xF] = (byte)(xValue & 1);
//
//        chip8.getRegisters().generalPurpose[x] = (byte)(xValue>>1);
//
//        chip8.getRegisters().programCounter += 2;
    }
}
