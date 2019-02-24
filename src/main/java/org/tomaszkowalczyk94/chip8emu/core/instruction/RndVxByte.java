package org.tomaszkowalczyk94.chip8emu.core.instruction;

import org.tomaszkowalczyk94.chip8emu.core.Chip8;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

import java.util.Random;

/**
 * Cxkk - RND Vx, byte<br />
 * Set Vx = random byte AND kk.<br />
 * <br />
 * The interpreter generates a random number from 0 to 255, which is then ANDed with the value kk.
 * The results are stored in Vx. See instruction 8xy2 for more information on AND.
 */
public class RndVxByte extends AbstractInstruction{

    /**
     * {@inheritDoc}
     */
    public void execute(XBit16 instruction, Chip8 chip8) {

        XBit8 x = XBit8.valueOfUnsigned(instruction.getValueOfBits(11, 8));
        XBit8 kk = XBit8.valueOfUnsigned(instruction.getValueOfBits(7, 0));

        Random generator = new Random();

        int randValue = generator.nextInt(255);

        XBit8 newValue = XBit8.valueOfSigned((byte) XBit8.valueOfSigned(kk.getSignedValue() & (byte) randValue).getSignedValue());
        chip8.getRegisters().generalPurpose[x.getSignedValue()] = newValue;

        incrementPc(chip8);
    }
}
