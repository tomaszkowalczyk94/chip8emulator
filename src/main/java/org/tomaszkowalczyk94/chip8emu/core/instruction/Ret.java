package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

public class Ret extends AbstractInstruction {
    public void execute(XBit16 instruction, Chip8 chip8) {
//
//        byte high = chip8.getMemory().read(chip8.getRegisters().stackPointer);
//        byte low = chip8.getMemory().read(chip8.getRegisters().stackPointer+1);
//        XBit16 newProgramCounterValue = XBit16.valueOfHighAndLow(XBit8.valueOfSigned(high), XBit8.valueOfSigned(low));
//
//        chip8.getRegisters().programCounter = newProgramCounterValue.getUnsignedValue();
//
//        chip8.getRegisters().stackPointer -= 2;
    }
}
