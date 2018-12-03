package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.*;

public class LdVxVyTest {

    @Test
    public void execute() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xF] = (byte)0xFF;

        XBit16 instruction = XBit16.valueOfUnsigned(0x8AF0);

        new LdVxVy().execute(instruction, cpu);

        assertEquals((byte)0xFF, cpu.getRegisters().generalPurpose[0xA]);
        assertEquals(0x202, cpu.getRegisters().programCounter);
    }
}