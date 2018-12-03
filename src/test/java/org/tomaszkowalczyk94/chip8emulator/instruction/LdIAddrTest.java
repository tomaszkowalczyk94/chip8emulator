package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.*;

public class LdIAddrTest extends AbstractInstructionTest {

    @Test
    public void execute() {
        Cpu cpu = new Cpu();
        LdIAddr ldIAddr = new LdIAddr();

        XBit16 instruction = XBit16.valueOfUnsigned(0xA001);
        ldIAddr.execute(instruction, cpu);

        assertEquals(0x001, cpu.getRegisters().index);
        assertEquals(0x202, cpu.getRegisters().programCounter);
    }
}