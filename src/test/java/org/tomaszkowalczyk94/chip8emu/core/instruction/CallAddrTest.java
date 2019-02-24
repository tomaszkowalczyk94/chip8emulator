package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CallAddrTest {

    @Test
    public void execute() {
        Chip8 cpu = new Chip8();

        XBit16 instruction = XBit16.valueOfUnsigned(0xAAA);
        new CallAddr().execute(instruction, cpu);

        assertEquals(1, cpu.getStack().size());
        assertEquals(0x200, cpu.getStack().peek().getUnsignedValue());


        assertEquals(0xAAA, cpu.getRegisters().pc.getUnsignedValue());

    }

}