package org.tomaszkowalczyk94.chip8emulator;

import lombok.Data;
import org.tomaszkowalczyk94.chip8emulator.instruction.AbstractInstruction;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

@Data
public class Cpu {

    Memory memory = new Memory();
    Registers registers = new Registers();
    InstructionDecoder instructionDecoder = new InstructionDecoder();

    public boolean[] screen = new boolean[64 * 32];

    public Cpu() {



    }

    public void run() {
        while (true) {
            XBit16 opcode = fetch();
            AbstractInstruction instruction = instructionDecoder.decode(opcode);
            instruction.execute(opcode, this);

            draw();

            System.out.println("STOP DRAWING");
        }
    }

    protected XBit16 fetch() {

        XBit16 pcValue = XBit16.valueOfSigned(registers.programCounter);
        byte hightOperand = memory.read(pcValue.getSignedValue());
        byte lowOperand = memory.read(pcValue.getUnsignedValue()+1);

        return XBit16.valueOfHighAndLow(
                XBit8.valueOfSigned(hightOperand),
                XBit8.valueOfSigned(lowOperand)
        );
    }

    public void drawPixel(int x, int y, boolean turnOn) {
        screen[y*32+x] = turnOn;
    }

    public boolean getPixel(int x, int y) {
        return screen[y*32+x];
    }

    protected void draw() {

        for(int y=0; y<32; y++) {
            for (int x = 0; x<64; x++) {
                if(screen[y*32+x]) {
                    System.out.print('\u25A0');
                } else {
                    System.out.print('\u25A2');
                }

            }
            System.out.println("");
        }


//        for (int x = 0; x<64; x++) {
//
////            for(int y=0; y<32; y++) {
////                if(screen[x*63+y]) {
////                    System.out.print("x");
////                } else {
////                    System.out.print("x");
////                }
////            }
//            System.out.println("");
//
//        }

    }


}
