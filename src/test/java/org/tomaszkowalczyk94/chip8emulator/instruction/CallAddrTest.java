package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

import static org.junit.Assert.*;

public class CallAddrTest {

    @Test
    public void execute() {
        Cpu cpu = new Cpu();

        XBit16 instruction = XBit16.valueOfUnsigned(0x2AAA);
        new CallAddr().execute(instruction, cpu);

        assertEquals(0x0054, cpu.getRegisters().stackPointer);

        assertEquals(0x2, cpu.getMemory().read(0x0054));
        assertEquals(0x00, cpu.getMemory().read(0x0055));

        assertEquals(0xAAA, cpu.getRegisters().programCounter);

    }

}