package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

public class OrVxVy extends AbstractInstruction {
    public void execute(XBit16 instruction, Chip8 chip8) {
//
//        int x = getFrom11And8Bits(instruction).getSignedValue();
//        int y = getFrom7And4Bits(instruction).getSignedValue();
//
//        chip8.getRegisters().generalPurpose[x] = (byte) (chip8.getRegisters().generalPurpose[x] | chip8.getRegisters().generalPurpose[y]);
//        chip8.getRegisters().programCounter += 2;
    }
}
