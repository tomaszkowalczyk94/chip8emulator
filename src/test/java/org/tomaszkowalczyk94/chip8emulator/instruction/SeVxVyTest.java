package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.*;

public class SeVxVyTest {

    @Test
    public void execute1Equal() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xA] = (byte)0xAA;
        cpu.getRegisters().generalPurpose[0xB] = (byte)0xAA;
        XBit16 instruction = XBit16.valueOfUnsigned(0x5AB0);

        new SeVxVy().execute(instruction, cpu);

        assertEquals(0x204, cpu.getRegisters().programCounter);
    }

    @Test
    public void execute2NotEqual() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xA] = (byte)0xAA;
        cpu.getRegisters().generalPurpose[0xB] = (byte)0xFF;
        XBit16 instruction = XBit16.valueOfUnsigned(0x5AB0);

        new SeVxVy().execute(instruction, cpu);

        assertEquals(0x202, cpu.getRegisters().programCounter);
    }
}