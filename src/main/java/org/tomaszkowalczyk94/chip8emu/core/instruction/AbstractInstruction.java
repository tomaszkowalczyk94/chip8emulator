package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;

import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;
import org.tomaszkowalczyk94.xbit.XBitUtils;

/**
 * http://devernay.free.fr/hacks/chip8/C8TECH10.HTM#00E0
 */
abstract public class AbstractInstruction {

    /**
     * Executing the given instruction. All instructions have 2 bytes.
     * @param instruction Two bytes instruction to execute
     * @param chip8 Object with state of machine, registers, memory etc. which will be changed after execution instruction.
     */
    abstract public void execute(XBit16 instruction, Chip8 chip8);

//    protected XBit16 getLast12Bits(XBit16 instruction) {
//        return XBit16.valueOfSigned(instruction.getSignedValue() & 0x0FFF);
//    }
//
//    protected XBit8 getFrom11And8Bits(XBit16 instruction) {
//        return XBit8.valueOfSigned( (instruction.getSignedValue() & 0x0F00)>>>8 );
//    }
//
//    protected XBit8 getFrom7And4Bits(XBit16 instruction) {
//        return XBit8.valueOfSigned( (instruction.getSignedValue() & 0x00F0)>>>4 );
//    }
//
//    protected XBit8 getLast8Bits(XBit16 instruction) {
//        return XBit8.valueOfSigned( (byte)(instruction.getSignedValue() & 0xFF));
//    }

    /**
     * Increment register PC by 2 (all chip8 instructions are two bytes)
     * @param chip8 machine wich will be PC incremented.
     */
    protected void incrementPc(Chip8 chip8) {
        chip8.getRegisters().pc = XBitUtils.incrementBy(
                chip8.getRegisters().pc,
                2
        );
    }
}


