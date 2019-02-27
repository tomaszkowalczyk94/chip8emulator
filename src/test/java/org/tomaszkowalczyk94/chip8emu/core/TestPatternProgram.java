package org.tomaszkowalczyk94.chip8emu.core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.tomaszkowalczyk94.chip8emu.core.screen.Drawer;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

/**
 * Test program, which is drawing simple pattern on display.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestPatternProgram {

    @Mock
    Drawer drawer;

    @Test
    public void execute() {
        Chip8 chip8 = new Chip8();
        chip8.setDrawer(drawer);

        loadTestProgram(chip8);
        chip8.runTo(XBit16.valueOfUnsigned(0x218));

        for(int x = 3; x<64; x+=4) {
            for(int y=3; y<32; y+=4) {
                Assert.assertTrue(chip8.getScreenManager().getPixel(x,y));
            }
        }

        Assert.assertFalse(chip8.getScreenManager().getPixel(2,3));
        Assert.assertFalse(chip8.getScreenManager().getPixel(4,3));
        Assert.assertFalse(chip8.getScreenManager().getPixel(3,4));
        Assert.assertFalse(chip8.getScreenManager().getPixel(3,2));
    }

    private void loadTestProgram(Chip8 chip8) {
        load2b(chip8, 0x200, 0xA21E);
        load2b(chip8, 0x202, 0xC201);
        load2b(chip8, 0x204, 0x3201);
        load2b(chip8, 0x206, 0xA21A);
        load2b(chip8, 0x208, 0xD014);
        load2b(chip8, 0x20A, 0x7004);
        load2b(chip8, 0x20C, 0x3040);
        load2b(chip8, 0x20E, 0x1200);
        load2b(chip8, 0x210, 0x6000);
        load2b(chip8, 0x212, 0x7104);
        load2b(chip8, 0x214, 0x3120);
        load2b(chip8, 0x216, 0x1200);
        load2b(chip8, 0x218, 0x1218);

        load2b(chip8, 0x21A, 0x8040);
        load2b(chip8, 0x21C, 0x2010);
        load2b(chip8, 0x21E, 0x2040);
        load2b(chip8, 0x220, 0x8010);
        load2b(chip8, 0x220, 0x8010);
    }

    private void load2b(Chip8 chip8, int address, int value) {

        XBit8 firstByte = XBit16.valueOfUnsigned(value).getFirstByte();
        XBit8 secondByte = XBit16.valueOfUnsigned(value).getSecondByte();

        chip8.memory.write(address,firstByte);
        chip8.memory.write(address + 1, secondByte);
    }


}
