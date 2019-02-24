package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.assertEquals;

public class LdIAddrTest extends AbstractInstructionTest {

    @Test
    public void execute() {
        Chip8 cpu = new Chip8();
        LdIAddr ldIAddr = new LdIAddr();

        XBit16 instruction = XBit16.valueOfUnsigned(0xA001);
        ldIAddr.execute(instruction, cpu);

        assertEquals(0x001, cpu.getRegisters().i.getUnsignedValue());
        assertEquals(0x202, cpu.getRegisters().pc.getUnsignedValue());
    }
}