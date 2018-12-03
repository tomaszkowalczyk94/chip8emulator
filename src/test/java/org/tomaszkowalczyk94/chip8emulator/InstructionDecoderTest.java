package org.tomaszkowalczyk94.chip8emulator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.tomaszkowalczyk94.chip8emulator.instruction.*;
import org.tomaszkowalczyk94.xbit.XBit16;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class InstructionDecoderTest {

    InstructionDecoder instructionDecoder = new InstructionDecoder();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { XBit16.valueOfUnsigned(0x00E0), Cls.class},
                { XBit16.valueOfUnsigned(0x00EE), Ret.class},
                { XBit16.valueOfUnsigned(0x00E1), SysAddr.class},
                { XBit16.valueOfUnsigned(0x1001), JpAddr.class},
                { XBit16.valueOfUnsigned(0x2AAA), CallAddr.class},
                { XBit16.valueOfUnsigned(0x3AA1), SeVxByte.class},
                { XBit16.valueOfUnsigned(0x4A1A), SneVxByte.class},
                { XBit16.valueOfUnsigned(0x5A1A), SeVxVy.class},
                { XBit16.valueOfUnsigned(0x6A1A), LdVxByte.class},
                { XBit16.valueOfUnsigned(0x7110), AddVxByte.class},

                { XBit16.valueOfUnsigned(0x8000), LdVxVy.class},
                { XBit16.valueOfUnsigned(0x8001), OrVxVy.class},
                { XBit16.valueOfUnsigned(0x8002), AndVxVy.class},
                { XBit16.valueOfUnsigned(0x8003), XorVxVy.class},
                { XBit16.valueOfUnsigned(0x8004), AddVxVy.class},
                { XBit16.valueOfUnsigned(0x8005), SubVxVy.class},
                { XBit16.valueOfUnsigned(0x8006), ShrVxVy.class},
                { XBit16.valueOfUnsigned(0x8007), SubnVxVy.class},
                { XBit16.valueOfUnsigned(0x800E), ShlVxVy.class},

                { XBit16.valueOfUnsigned(0x9AA0), SneVxVy.class},
                { XBit16.valueOfUnsigned(0xAAA0), LdIAddr.class},
                { XBit16.valueOfUnsigned(0xBAA0), JpV0Addr.class},
                { XBit16.valueOfUnsigned(0xCAA0), RndVxByte.class},
                { XBit16.valueOfUnsigned(0xDAA0), DrwVxVyNibble.class},

                { XBit16.valueOfUnsigned(0xE09E), SkpVx.class},
                { XBit16.valueOfUnsigned(0xE0A1), SknpVx.class},

                { XBit16.valueOfUnsigned(0xF007), LdVxDt.class},
                { XBit16.valueOfUnsigned(0xF00A), LdVxK.class},
                { XBit16.valueOfUnsigned(0xF015), LdDtVx.class},
                { XBit16.valueOfUnsigned(0xF018), LdStVx.class},
                { XBit16.valueOfUnsigned(0xF01E), AddIVx.class},
                { XBit16.valueOfUnsigned(0xF029), LdFVx.class},
                { XBit16.valueOfUnsigned(0xF033), LdBVx.class},
                { XBit16.valueOfUnsigned(0xF055), LdIVx.class},
                { XBit16.valueOfUnsigned(0xF065), LdVxI.class},

        });
    }

    private XBit16 instruction;
    Class expectedClass;

    public InstructionDecoderTest(XBit16 instruction, Class expectedClass) {
        this.instruction = instruction;
        this.expectedClass = expectedClass;
    }


    @Test
    public void decode() {
        AbstractInstruction decodedInstruction = instructionDecoder.decode(instruction);

        assertEquals(expectedClass, decodedInstruction.getClass());

    }
}