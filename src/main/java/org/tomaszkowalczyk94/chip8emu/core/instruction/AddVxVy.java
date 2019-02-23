package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

public class AddVxVy extends AbstractInstruction {
    public void execute(XBit16 instruction, Cpu cpu) {
        int x = getFrom11And8Bits(instruction).getSignedValue();
        int y = getFrom7And4Bits(instruction).getSignedValue();

        XBit8 xRegister = XBit8.valueOfSigned(cpu.getRegisters().generalPurpose[x]);
        XBit8 yRegister = XBit8.valueOfSigned(cpu.getRegisters().generalPurpose[y]);

        int addBuffor = xRegister.getUnsignedValue() + yRegister.getUnsignedValue();

        cpu.getRegisters().generalPurpose[x] = (byte)XBit16.valueOfUnsigned(addBuffor).getSecondByte().getSignedValue();

        if(addBuffor>255) {
            cpu.getRegisters().generalPurpose[0xF] = 1;
        } else {
            cpu.getRegisters().generalPurpose[0xF] = 0;
        }

        cpu.getRegisters().programCounter += 2;
    }
}
