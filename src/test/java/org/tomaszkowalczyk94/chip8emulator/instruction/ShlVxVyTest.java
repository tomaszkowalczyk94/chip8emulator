package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.*;

public class ShlVxVyTest {

    @Test
    public void execute() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xA] = (byte)0b00001111;
        XBit16 instruction = XBit16.valueOfUnsigned(0x8AB6);

        new ShlVxVy().execute(instruction, cpu);

        assertEquals(0b00011110, cpu.getRegisters().generalPurpose[0xA]);
        assertEquals(0, cpu.getRegisters().generalPurpose[0xF]);
        assertEquals(0x202, cpu.getRegisters().programCounter);
    }

    @Test
    public void execute2() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xA] = (byte)0b10001111;
        XBit16 instruction = XBit16.valueOfUnsigned(0x8AB6);

        new ShlVxVy().execute(instruction, cpu);

        assertEquals(0b00011110, cpu.getRegisters().generalPurpose[0xA]);
        assertEquals(1, cpu.getRegisters().generalPurpose[0xF]);
        assertEquals(0x202, cpu.getRegisters().programCounter);
    }
}