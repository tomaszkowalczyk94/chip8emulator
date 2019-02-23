package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

import static org.junit.Assert.*;

public class AddVxVyTest {
//
//    @Test
//    public void execute1() {
//        Cpu cpu = new Cpu();
//        cpu.getRegisters().generalPurpose[0xA] = (byte)0xFF;
//        cpu.getRegisters().generalPurpose[0xB] = (byte)0x01;
//        XBit16 instruction = XBit16.valueOfUnsigned(0x7AB4);
//
//        new AddVxVy().execute(instruction, cpu);
//
//        assertEquals(0, cpu.getRegisters().generalPurpose[0xA]);
//        assertEquals((byte)0x01, cpu.getRegisters().generalPurpose[0xF]);
//        assertEquals(0x202, cpu.getRegisters().programCounter);
//    }
//
//    @Test
//    public void execute2() {
//        Cpu cpu = new Cpu();
//        cpu.getRegisters().generalPurpose[0xA] = (byte)0xFF;
//        cpu.getRegisters().generalPurpose[0xB] = (byte)0xFF;
//        XBit16 instruction = XBit16.valueOfUnsigned(0x7AB4);
//
//        new AddVxVy().execute(instruction, cpu);
//
//        assertEquals(0xFE, XBit8.valueOfSigned(cpu.getRegisters().generalPurpose[0xA]).getUnsignedValue());
//        assertEquals((byte)0x01, cpu.getRegisters().generalPurpose[0xF]);
//        assertEquals(0x202, cpu.getRegisters().programCounter);
//    }
}