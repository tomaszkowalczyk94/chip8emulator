package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;

public class CallAddr extends AbstractInstruction {

    public void execute(XBit16 instruction, Chip8 chip8) {
//        chip8.getRegisters().stackPointer += 2;
//
//
//        XBit16 programCounter = XBit16.valueOfUnsigned(chip8.getRegisters().programCounter);
//
//        chip8.getMemory().write(chip8.getRegisters().stackPointer, programCounter.getFirstByte());
//        chip8.getMemory().write(chip8.getRegisters().stackPointer+1, programCounter.getSecondByte());
//
//        chip8.getRegisters().programCounter = getLast12Bits(instruction).getUnsignedValue();
    }

}
