package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

import static org.junit.Assert.*;

public class RetTest {

    @Test
    public void execute() {

        Cpu cpu = new Cpu();
        cpu.getMemory().write(0x0050, XBit8.valueOfUnsigned(255));
        cpu.getMemory().write(0x0051, XBit8.valueOfUnsigned(255));
        cpu.getRegisters().stackPointer = 0x0050;


        XBit16 instruction = XBit16.valueOfUnsigned(0x00EE);
        new Ret().execute(instruction, cpu);

        assertEquals(0x004E, cpu.getRegisters().stackPointer);
        assertEquals(0xFFFF, cpu.getRegisters().programCounter);


    }
}