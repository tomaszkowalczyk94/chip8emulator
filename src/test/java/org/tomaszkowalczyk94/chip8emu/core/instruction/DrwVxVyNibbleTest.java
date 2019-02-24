package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Cpu;
import org.tomaszkowalczyk94.chip8emu.core.Memory;
import org.tomaszkowalczyk94.chip8emu.core.screen.ConsoleDrawer;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

import static org.junit.Assert.*;

public class DrwVxVyNibbleTest {

    @Test
    public void execute() {
        Cpu cpu = new Cpu();
        Memory mem = cpu.getMemory();

        cpu.getRegisters().generalPurpose[0x0] = XBit8.valueOfUnsigned(0);
        cpu.getRegisters().generalPurpose[0x1] = XBit8.valueOfUnsigned(0);
        cpu.getRegisters().i = XBit16.valueOfUnsigned(0x021A);


        mem.write(0x21A, XBit8.valueOfUnsigned(0b10000000));
        mem.write(0x21B, XBit8.valueOfUnsigned(0b01000000));
        mem.write(0x21C, XBit8.valueOfUnsigned(0b00100000));
        mem.write(0x21D, XBit8.valueOfUnsigned(0b00010000)); //simple sprite

        //sprite
        XBit16 instruction = XBit16.valueOfUnsigned(0xD014); //Dxyn - Draw sprite in I..I+4 at (V0,V1)
        new DrwVxVyNibble().execute(instruction, cpu);

        assertEquals( 0x202 ,cpu.getRegisters().pc.getUnsignedValue());

        assertEquals( true ,cpu.getScreenManager().getPixel(0, 0));
        assertEquals( true ,cpu.getScreenManager().getPixel(1, 1));
        assertEquals( true ,cpu.getScreenManager().getPixel(2, 2));
        assertEquals( true ,cpu.getScreenManager().getPixel(3, 3));

        assertEquals( false ,cpu.getScreenManager().getPixel(0, 1));
        assertEquals( false ,cpu.getScreenManager().getPixel(1, 0));
        assertEquals( false ,cpu.getScreenManager().getPixel(1, 2));
        assertEquals( false ,cpu.getScreenManager().getPixel(2, 1));
        assertEquals( false ,cpu.getScreenManager().getPixel(2, 3));
        assertEquals( false ,cpu.getScreenManager().getPixel(3, 2));

        ConsoleDrawer drawer = new ConsoleDrawer();
        drawer.draw(cpu.getScreenManager().getScreen());
    }
}