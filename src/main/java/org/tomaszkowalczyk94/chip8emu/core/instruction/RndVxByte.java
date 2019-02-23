package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

import java.util.Random;

public class RndVxByte extends AbstractInstruction{
    public void execute(XBit16 instruction, Cpu cpu) {

        XBit8 x = getFrom11And8Bits(instruction);
        XBit8 kk = getLast8Bits(instruction);

        Random generator = new Random();

        int randValue = generator.nextInt(255);

        cpu.getRegisters().generalPurpose[x.getSignedValue()] = (byte)XBit8.valueOfSigned(kk.getSignedValue() & randValue).getSignedValue();

        cpu.getRegisters().programCounter += 2;
    }
}
