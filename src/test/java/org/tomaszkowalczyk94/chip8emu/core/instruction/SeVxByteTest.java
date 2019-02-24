package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

import static org.junit.Assert.assertEquals;

public class SeVxByteTest {

    @Test
    public void execute1Equal() {
        Chip8 cpu = new Chip8();
        cpu.getRegisters().generalPurpose[0xF] = XBit8.valueOfUnsigned(0xAA);
        XBit16 instruction = XBit16.valueOfUnsigned(0x3FAA);

        new SeVxByte().execute(instruction, cpu);

        assertEquals(0x204, cpu.getRegisters().pc.getUnsignedValue());
}

    @Test
    public void execute2NotEqual() {
        Chip8 cpu = new Chip8();
        cpu.getRegisters().generalPurpose[0xF] = XBit8.valueOfUnsigned(0xAF);
        XBit16 instruction = XBit16.valueOfUnsigned(0x3FAA);

        new SeVxByte().execute(instruction, cpu);

        assertEquals(0x202, cpu.getRegisters().pc.getUnsignedValue());
    }
}