package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;

public class DrwVxVyNibble extends AbstractInstruction {
    public void execute(XBit16 instruction, Cpu cpu) {
        XBit8 x = getFrom11And8Bits(instruction);
        XBit8 y = getFrom7And4Bits(instruction);

        int xPos = cpu.getRegisters().generalPurpose[x.getUnsignedValue()];
        int yPos = cpu.getRegisters().generalPurpose[y.getUnsignedValue()];

        drawExtendedSprite(xPos, yPos, cpu);

        cpu.getRegisters().programCounter += 2;
    }

    private void drawExtendedSprite(int xPos, int yPos, Cpu cpu) {
        for (int yIndex = 0; yIndex < 16; yIndex++) {
            for (int xByte = 0; xByte < 2; xByte++) {
                short colorByte = cpu.getMemory().read(cpu.getRegisters().index + (yIndex * 2) + xByte);
                int yCoord = yPos + yIndex;
                yCoord = yCoord % 32;

                int mask = 0x80;

                for (int xIndex = 0; xIndex < 8; xIndex++) {
                    int xCoord = xPos + xIndex + (xByte * 8);
                    xCoord = xCoord % 64;

                    boolean turnOn = (colorByte & mask) > 0;
                    boolean currentOn = cpu.getPixel(xCoord, yCoord);

                    if (turnOn && currentOn) {
                        cpu.getRegisters().generalPurpose[0xF] |= 1;
                        turnOn = false;
                    } else if (!turnOn && currentOn) {
                        turnOn = true;
                    }

                    cpu.drawPixel(xCoord, yCoord, turnOn);
                    mask = mask >> 1;
                }
            }
        }
    }
}
