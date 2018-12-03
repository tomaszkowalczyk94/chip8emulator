package org.tomaszkowalczyk94.chip8emulator;

import lombok.Data;
import org.tomaszkowalczyk94.xbit.XBit16;

public class Registers {

    public byte[] generalPurpose = new byte[16];

    public int index = 0;

    public int stackPointer = 0x0052;

    public byte delayTimer = 0;

    public byte soundTimer = 0;

    public int programCounter = 0x200;

}
