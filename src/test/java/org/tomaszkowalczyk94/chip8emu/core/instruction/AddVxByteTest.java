package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

import static org.junit.Assert.assertEquals;

public class AddVxByteTest {

    @Test
    public void execute() {
        Chip8 cpu = new Chip8();
        cpu.getRegisters().generalPurpose[0xF] = XBit8.valueOfUnsigned(0xFF);

        XBit16 instruction = XBit16.valueOfUnsigned(0x7AFF);

        new AddVxByte().execute(instruction, cpu);

        assertEquals(0xFF, cpu.getRegisters().generalPurpose[0xF].getUnsignedValue());
        assertEquals(0x202, cpu.getRegisters().pc.getUnsignedValue());
    }
}