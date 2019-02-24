package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

public class SubnVxVy extends AbstractInstruction {
    public void execute(XBit16 instruction, Chip8 chip8) {
//        int x = getFrom11And8Bits(instruction).getSignedValue();
//        int y = getFrom7And4Bits(instruction).getSignedValue();
//
//        XBit8 xRegister = XBit8.valueOfSigned(chip8.getRegisters().generalPurpose[x]);
//        XBit8 yRegister = XBit8.valueOfSigned(chip8.getRegisters().generalPurpose[y]);
//
//        int subBuff = yRegister.getSignedValue() - xRegister.getSignedValue();
//
//        chip8.getRegisters().generalPurpose[x] = (byte)XBit16.valueOfSigned(subBuff).getSecondByte().getSignedValue();
//
//        if(yRegister.getSignedValue() > xRegister.getSignedValue()) {
//            chip8.getRegisters().generalPurpose[0xF] = 1;
//        } else {
//            chip8.getRegisters().generalPurpose[0xF] = 0;
//        }
//
//        chip8.getRegisters().programCounter += 2;
    }
}
