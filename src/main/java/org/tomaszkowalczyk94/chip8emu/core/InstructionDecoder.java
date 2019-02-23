package org.tomaszkowalczyk94.chip8emu.core;

import org.tomaszkowalczyk94.chip8emu.core.instruction.*;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

public class InstructionDecoder {

    public AbstractInstruction decode(XBit16 instruction) {
        int first4Bits = getFirst4Bits(instruction);

        switch (first4Bits) {
            case 0x0:
                return decode0address(instruction);
            case 0x1:
                return new JpAddr();
            case 0x2:
                return new CallAddr();
            case 0x3:
                return new SeVxByte();
            case 0x4:
                return new SneVxByte();
            case 0x5:
                return new SeVxVy();
            case 0x6:
                return new LdVxByte();
            case 0x7:
                return new AddVxByte();
            case 0x8:
                return decode7address(instruction);
            case 0x9:
                return new SneVxVy();
            case 0xA:
                return new LdIAddr();
            case 0xB:
                return new JpV0Addr();
            case 0xC:
                return new RndVxByte();
            case 0xD:
                return new DrwVxVyNibble();
            case 0xE:
                return decodeEaddress(instruction);
            case 0xF:
                return decodeFaddress(instruction);
        }

        throw new RuntimeException("invalid instruction");
    }




    private AbstractInstruction decode0address(XBit16 instruction) {

        if(instruction.getUnsignedValue() == 0x00E0) return new Cls();
        if(instruction.getUnsignedValue() == 0x00EE) return new Ret();
        return new SysAddr();
    }

    private AbstractInstruction decode7address(XBit16 instruction) {

        int last4Bits = getLast4Bits(instruction);

        switch (last4Bits) {
            case 0x0:
                return new LdVxVy();
            case 0x1:
                return new OrVxVy();
            case 0x2:
                return new AndVxVy();
            case 0x3:
                return new XorVxVy();
            case 0x4:
                return new AddVxVy();
            case 0x5:
                return new SubVxVy();
            case 0x6:
                return new ShrVxVy();
            case 0x7:
                return new SubnVxVy();
            case 0xE:
                return new ShlVxVy();
        }

        throw new RuntimeException("invalid instruction");
    }

    private AbstractInstruction decodeEaddress(XBit16 instruction) {
        int lowByte = instruction.getSecondByte().getUnsignedValue();
        switch (lowByte) {
            case 0x9E:
                return new SkpVx();
            case 0xA1:
                return new SknpVx();
        }

        throw new RuntimeException("invalid instruction");
    }

    private AbstractInstruction decodeFaddress(XBit16 instruction) {
        int lowByte = instruction.getSecondByte().getUnsignedValue();
        switch (lowByte) {
            case 0x07:
                return new LdVxDt();
            case 0x0A:
                return new LdVxK();
            case 0x15:
                return new LdDtVx();
            case 0x18:
                return new LdStVx();
            case 0x1E:
                return new AddIVx();
            case 0x29:
                return new LdFVx();
            case 0x33:
                return new LdBVx();
            case 0x55:
                return new LdIVx();
            case 0x65:
                return new LdVxI();
        }

        throw new RuntimeException("invalid instruction");
    }


    private int getFirst4Bits(XBit16 instruction) {
        XBit8 ret = XBit8.valueOfBooleanArray(new boolean[]{
                false, false, false, false,
                instruction.getBit(15),
                instruction.getBit(14),
                instruction.getBit(13),
                instruction.getBit(12)
        });

        return ret.getSignedValue();
    }

    private int getLast4Bits(XBit16 instruction) {
        XBit8 ret = XBit8.valueOfBooleanArray(new boolean[]{
                false, false, false, false,
                instruction.getBit(3),
                instruction.getBit(2),
                instruction.getBit(1),
                instruction.getBit(0)
        });

        return ret.getSignedValue();
    }

}

// ABCD