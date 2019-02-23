package org.tomaszkowalczyk94.chip8emu.core;

import org.tomaszkowalczyk94.xbit.XBit8;

public class Memory {

    public final static int MEMORY_SIZE = 4090;

    protected byte[] memory;

    public Memory() {
        memory = new byte[MEMORY_SIZE];

//        short[] sprites = new short[] {
//                    0xF0, 0x90, 0x90, 0x90, 0xF0, // 0
//                    0x20, 0x60, 0x20, 0x20, 0x70, // 1
//                    0xF0, 0x10, 0xF0, 0x80, 0xF0, // 2
//                    0xF0, 0x10, 0xF0, 0x10, 0xF0, // 3
//                    0x90, 0x90, 0xF0, 0x10, 0x10, // 4
//                    0xF0, 0x80, 0xF0, 0x10, 0xF0, // 5
//                    0xF0, 0x80, 0xF0, 0x90, 0xF0, // 6
//                    0xF0, 0x10, 0x20, 0x40, 0x40, // 7
//                    0xF0, 0x90, 0xF0, 0x90, 0xF0, // 8
//                    0xF0, 0x90, 0xF0, 0x10, 0xF0, // 9
//                    0xF0, 0x90, 0xF0, 0x90, 0x90, // A
//                    0xE0, 0x90, 0xE0, 0x90, 0xE0, // B
//                    0xF0, 0x80, 0x80, 0x80, 0xF0, // C
//                    0xE0, 0x90, 0x90, 0x90, 0xE0, // D
//                    0xF0, 0x80, 0xF0, 0x80, 0xF0, // E
//                    0xF0, 0x80, 0xF0, 0x80, 0x80  // F
//        };
//
//        for(int i=0; i<80; i++) {
//            memory[i] = (byte)sprites[i];
//        }


//        -- Assembled Statements --
//        0x0200 A20A  start LOADI   sprite  # Load the sprite location into index
//        0x0202 600A         LOAD    r0,$A  # Load 10 into register 0
//        0x0204 6105         LOAD    r1,$5  # Load 5 into register 1
//        0x0206 D017         DRAW r0,r1,$7  # Draw 7-byte sprite at r0, r1
//        0x0208 1208    end  JUMP      end  # Loop infinitely
//        0x020A 007C sprite   FCB      $7C  # Capital letter E
//        0x020B 0040          FCB      $40  #
//        0x020C 0040          FCB      $40  #
//        0x020D 007C          FCB      $7C  #
//        0x020E 0040          FCB      $40  #
//        0x020F 0040          FCB      $40  #
//        0x0210 007C          FCB      $7C  #


//        memory[0x200] = (byte)0xA0;
//        memory[0x201] = (byte)0x00;
//        memory[0x202] = (byte)0x60;
//        memory[0x203] = (byte)0x0A;
//        memory[0x204] = (byte)0x61;
//        memory[0x205] = (byte)0x05;
//        memory[0x206] = (byte)0xD0;
//        memory[0x207] = (byte)0x17;

    }

    public XBit8 read(int address) {
        if(address>MEMORY_SIZE) {
            throw new RuntimeException("address is too big");
        }

        return XBit8.valueOfSigned(memory[address]);
    }

    public void write(int address, XBit8 value) {
        if(address>MEMORY_SIZE) {
            throw new RuntimeException("address is too big");
        }

        memory[address] = (byte)value.getSignedValue();
    }
}
