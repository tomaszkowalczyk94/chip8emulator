package org.tomaszkowalczyk94.chip8emu.core.instruction;

public class AddVxVyTest {
//
//    @Test
//    public void execute1() {
//        Chip8 cpu = new Chip8();
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
//        Chip8 cpu = new Chip8();
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