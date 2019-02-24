package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ClsTest {

    @Test
    public void execute() {

        Chip8 cpu = new Chip8();
        cpu.getScreenManager().setPixel(0, 0, true);

        Cls cls = new Cls();

        cls.execute(null, cpu);

        assertFalse(cpu.getScreenManager().getPixel(0, 0));
        assertEquals(0x202, cpu.getRegisters().pc.getUnsignedValue());
    }
}