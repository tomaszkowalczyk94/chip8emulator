package org.tomaszkowalczyk94.chip8emu.core;

import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

import java.util.Arrays;

public class Registers {

    public XBit8[] generalPurpose = new XBit8[16];

    public byte delayTimer = 0;

    public byte soundTimer = 0;

    public XBit16 pc = XBit16.valueOfUnsigned(0x200);

    public XBit16 i = XBit16.valueOfUnsigned(0x200);

    public Registers() {
        Arrays.setAll(generalPurpose, p -> XBit8.valueOfSigned(0));
    }
}
