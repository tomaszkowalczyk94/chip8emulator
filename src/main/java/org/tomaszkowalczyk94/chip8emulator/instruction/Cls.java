package org.tomaszkowalczyk94.chip8emulator.instruction;

import org.tomaszkowalczyk94.chip8emulator.Cpu;
import org.tomaszkowalczyk94.xbit.XBit16;

public class Cls extends AbstractInstruction {
    public void execute(XBit16 instruction, Cpu cpu) {

        for(int i = 0; i<cpu.screen.length ; i++) {
            cpu.screen[i] = false;
        }
        cpu.getRegisters().programCounter += 2;
    }
}
