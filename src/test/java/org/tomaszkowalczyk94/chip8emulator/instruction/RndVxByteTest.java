package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.*;

public class RndVxByteTest {

    @Test
    public void execute() {
        Cpu cpu = new Cpu();
        XBit16 instruction = XBit16.valueOfUnsigned(0x3A00);

        new RndVxByte().execute(instruction, cpu);

        assertEquals(0x202, cpu.getRegisters().programCounter);
    }
}