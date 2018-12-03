package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.*;

public class JpAddrTest {

    @Test
    public void execute() {

        Cpu cpu = new Cpu();

        XBit16 instruction = XBit16.valueOfUnsigned(0x1AAA);
        new JpAddr().execute(instruction, cpu);

        assertEquals( 0x0AAA ,cpu.getRegisters().programCounter);

    }
}