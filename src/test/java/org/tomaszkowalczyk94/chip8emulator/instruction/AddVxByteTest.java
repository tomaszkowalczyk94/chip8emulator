package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.*;

public class AddVxByteTest {

    @Test
    public void execute() {
        Cpu cpu = new Cpu();
        cpu.getRegisters().generalPurpose[0xF] = (byte)0xFF;

        XBit16 instruction = XBit16.valueOfUnsigned(0x7AFF);

        new AddVxByte().execute(instruction, cpu);

        assertEquals((byte)0xFF, cpu.getRegisters().generalPurpose[0xF]);
        assertEquals(0x202, cpu.getRegisters().programCounter);
    }
}