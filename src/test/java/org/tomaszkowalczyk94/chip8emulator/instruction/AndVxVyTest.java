package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.*;

public class AndVxVyTest {

    @Test
    public void execute() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xA] = (byte)0x0F;
        cpu.getRegisters().generalPurpose[0xF] = (byte)0xF0;
        XBit16 instruction = XBit16.valueOfUnsigned(0x8AF2);

        new AndVxVy().execute(instruction, cpu);

        assertEquals(0, cpu.getRegisters().generalPurpose[0xA]);
        assertEquals(0x202, cpu.getRegisters().programCounter);
    }
}