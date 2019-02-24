package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.junit.Test;
import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.chip8emu.core.Memory;
import org.tomaszkowalczyk94.chip8emu.core.screen.ConsoleDrawer;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

import static org.junit.Assert.*;

public class DrwVxVyNibbleTest {

    @Test
    public void execute() {
        Chip8 chip8 = new Chip8();
        Memory mem = chip8.getMemory();

        chip8.getRegisters().generalPurpose[0x0] = XBit8.valueOfUnsigned(0);
        chip8.getRegisters().generalPurpose[0x1] = XBit8.valueOfUnsigned(0);
        chip8.getRegisters().i = XBit16.valueOfUnsigned(0x021A);


        mem.write(0x21A, XBit8.valueOfUnsigned(0b10000000));
        mem.write(0x21B, XBit8.valueOfUnsigned(0b01000000));
        mem.write(0x21C, XBit8.valueOfUnsigned(0b00100000));
        mem.write(0x21D, XBit8.valueOfUnsigned(0b00010000)); //simple sprite

        //sprite
        XBit16 instruction = XBit16.valueOfUnsigned(0xD014); //Dxyn - Draw sprite in I..I+4 at (V0,V1)
        new DrwVxVyNibble().execute(instruction, chip8);

        assertEquals( 0x202 , chip8.getRegisters().pc.getUnsignedValue());

        assertEquals( true , chip8.getScreenManager().getPixel(0, 0));
        assertEquals( true , chip8.getScreenManager().getPixel(1, 1));
        assertEquals( true , chip8.getScreenManager().getPixel(2, 2));
        assertEquals( true , chip8.getScreenManager().getPixel(3, 3));

        assertEquals( false , chip8.getScreenManager().getPixel(0, 1));
        assertEquals( false , chip8.getScreenManager().getPixel(1, 0));
        assertEquals( false , chip8.getScreenManager().getPixel(1, 2));
        assertEquals( false , chip8.getScreenManager().getPixel(2, 1));
        assertEquals( false , chip8.getScreenManager().getPixel(2, 3));
        assertEquals( false , chip8.getScreenManager().getPixel(3, 2));

        ConsoleDrawer drawer = new ConsoleDrawer();
        drawer.draw(chip8.getScreenManager().getScreen());
    }
}