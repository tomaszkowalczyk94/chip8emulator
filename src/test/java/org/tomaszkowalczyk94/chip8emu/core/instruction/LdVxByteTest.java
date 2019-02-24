package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.assertEquals;

public class LdVxByteTest {

    @Test
    public void execute() {
        Chip8 cpu = new Chip8();
        XBit16 instruction = XBit16.valueOfUnsigned(0x6AFF);

        new LdVxByte().execute(instruction, cpu);

        //FF binary is -1 in u2
        assertEquals(0xFF, cpu.getRegisters().generalPurpose[0xA].getUnsignedValue());
        assertEquals(0x202, cpu.getRegisters().pc.getUnsignedValue());
    }
}