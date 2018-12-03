package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.*;

public class SeVxByteTest {

    @Test
    public void execute1Equal() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xF] = (byte)0xAA;
        XBit16 instruction = XBit16.valueOfUnsigned(0x3FAA);

        new SeVxByte().execute(instruction, cpu);

        assertEquals(0x204, cpu.getRegisters().programCounter);
    }

    @Test
    public void execute2NotEqual() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xF] = (byte)0xAF;
        XBit16 instruction = XBit16.valueOfUnsigned(0x3FAA);

        new SeVxByte().execute(instruction, cpu);

        assertEquals(0x202, cpu.getRegisters().programCounter);
    }
}