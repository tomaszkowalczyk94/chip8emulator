package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

public class SeVxByte extends AbstractInstruction {

    public void execute(XBit16 instruction, Chip8 chip8) {
//        int x = getFrom11And8Bits(instruction).getSignedValue();
//        int kk = getLast8Bits(instruction).getSignedValue();
//
//        if(chip8.getRegisters().generalPurpose[x] == kk) {
//            chip8.getRegisters().programCounter += 4;
//            return;
//        }
//        chip8.getRegisters().programCounter += 2;
    }
}
