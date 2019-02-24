package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.assertEquals;

public class RetTest {

    @Test
    public void execute() {

        Chip8 cpu = new Chip8();
        cpu.getStack().push(XBit16.valueOfUnsigned(0xFF0));

        XBit16 instruction = XBit16.valueOfUnsigned(0x00EE);
        new Ret().execute(instruction, cpu);

        assertEquals(0, cpu.getStack().size());
        assertEquals(0xFF2, cpu.getRegisters().pc.getUnsignedValue());


    }
}