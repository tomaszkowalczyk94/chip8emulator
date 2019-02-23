package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

import static org.junit.Assert.*;

public class SubVxVyTest {

    @Test
    public void execute() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xA] = (byte)0xFF;
        cpu.getRegisters().generalPurpose[0xB] = (byte)0x01;
        XBit16 instruction = XBit16.valueOfUnsigned(0x7AB5);

        new SubVxVy().execute(instruction, cpu);

        assertEquals(0xFE, XBit8.valueOfSigned(cpu.getRegisters().generalPurpose[0xA]).getUnsignedValue());
        assertEquals(0x202, cpu.getRegisters().programCounter);
    }
}