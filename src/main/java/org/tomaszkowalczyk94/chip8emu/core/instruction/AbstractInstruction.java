package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Cpu;

import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

/**
 * http://devernay.free.fr/hacks/chip8/C8TECH10.HTM#00E0
 */
abstract public class AbstractInstruction {

    /**
     * Executing the given instruction. All instructions have 2 bytes.
     * @param instruction
     * @param cpu
     */
    abstract public void execute(XBit16 instruction, Cpu cpu);

    protected XBit16 getLast12Bits(XBit16 instruction) {
        return XBit16.valueOfSigned(instruction.getSignedValue() & 0x0FFF);
    }

    protected XBit8 getFrom11And8Bits(XBit16 instruction) {
        return XBit8.valueOfSigned( (instruction.getSignedValue() & 0x0F00)>>>8 );
    }

    protected XBit8 getFrom7And4Bits(XBit16 instruction) {
        return XBit8.valueOfSigned( (instruction.getSignedValue() & 0x00F0)>>>4 );
    }

    protected XBit8 getLast8Bits(XBit16 instruction) {
        return XBit8.valueOfSigned( (byte)(instruction.getSignedValue() & 0xFF));
    }

}


