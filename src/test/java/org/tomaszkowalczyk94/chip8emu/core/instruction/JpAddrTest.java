package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.assertEquals;

public class JpAddrTest {

    @Test
    public void execute() {

        Chip8 cpu = new Chip8();

        XBit16 instruction = XBit16.valueOfUnsigned(0x1AAA);
        new JpAddr().execute(instruction, cpu);

        assertEquals( 0x0AAA ,cpu.getRegisters().pc.getUnsignedValue());

    }
}