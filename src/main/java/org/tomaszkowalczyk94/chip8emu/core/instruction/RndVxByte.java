package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

public class RndVxByte extends AbstractInstruction{
    public void execute(XBit16 instruction, Chip8 chip8) {
//
//        XBit8 x = getFrom11And8Bits(instruction);
//        XBit8 kk = getLast8Bits(instruction);
//
//        Random generator = new Random();
//
//        int randValue = generator.nextInt(255);
//
//        chip8.getRegisters().generalPurpose[x.getSignedValue()] = (byte)XBit8.valueOfSigned(kk.getSignedValue() & randValue).getSignedValue();
//
//        chip8.getRegisters().programCounter += 2;
    }
}
