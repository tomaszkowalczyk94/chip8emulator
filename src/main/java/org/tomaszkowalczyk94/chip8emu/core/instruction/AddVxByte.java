package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

public class AddVxByte extends AbstractInstruction {
    public void execute(XBit16 instruction, Chip8 chip8) {
//        int x = getFrom11And8Bits(instruction).getSignedValue();
//        XBit8 kkByte = getLast8Bits(instruction);
//
//        chip8.getRegisters().generalPurpose[x] = (byte)(chip8.getRegisters().generalPurpose[x] + kkByte.getSignedValue());
//
//        chip8.getRegisters().programCounter += 2;
    }
}
