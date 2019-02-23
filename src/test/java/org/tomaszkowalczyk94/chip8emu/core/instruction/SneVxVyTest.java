package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.assertEquals;

public class SneVxVyTest {

    @Test
    public void execute() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xA] = (byte)0xAA;
        cpu.getRegisters().generalPurpose[0xB] = (byte)0xAA;
        XBit16 instruction = XBit16.valueOfUnsigned(0x9AB0);

        new SneVxVy().execute(instruction, cpu);

        assertEquals(0x202, cpu.getRegisters().programCounter);
    }

    @Test
    public void execute2() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xA] = (byte)0xAA;
        cpu.getRegisters().generalPurpose[0xB] = (byte)0xAB;
        XBit16 instruction = XBit16.valueOfUnsigned(0x9AB0);

        new SneVxVy().execute(instruction, cpu);

        assertEquals(0x204, cpu.getRegisters().programCounter);
    }
}