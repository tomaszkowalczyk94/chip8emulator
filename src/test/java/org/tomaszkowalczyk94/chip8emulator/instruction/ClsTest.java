package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ClsTest {

    @Test
    public void execute() {

        Cpu cpu = new Cpu();
        cpu.screen[100] = true;

        Cls cls = new Cls();

        XBit16 instruction = XBit16.valueOfUnsigned(0x00E0);
        cls.execute(instruction, cpu);

        assertEquals(false, cpu.screen[100]);
        assertEquals(0x202, cpu.getRegisters().programCounter);
    }
}