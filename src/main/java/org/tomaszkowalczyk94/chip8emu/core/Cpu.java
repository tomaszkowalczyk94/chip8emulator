package org.tomaszkowalczyk94.chip8emu.core;

import lombok.Data;
import org.tomaszkowalczyk94.chip8emu.core.instruction.AbstractInstruction;
import org.tomaszkowalczyk94.chip8emu.core.screen.ConsoleDrawer;
import org.tomaszkowalczyk94.chip8emu.core.screen.Drawer;
import org.tomaszkowalczyk94.chip8emu.core.screen.ScreenManager;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;
import org.tomaszkowalczyk94.xbit.XBitUtils;

@Data
public class Cpu {

    Memory memory = new Memory();
    Registers registers = new Registers();
    InstructionDecoder instructionDecoder = new InstructionDecoder();
    ScreenManager screenManager = new ScreenManager();

    Drawer drawer = new ConsoleDrawer();


    public Cpu() {

    }

    public void run() {
        while (true) {
            XBit16 opcode = fetch();
            AbstractInstruction instruction = instructionDecoder.decode(opcode);
            instruction.execute(opcode, this);

            drawer.draw(screenManager.getScreen());

        }
    }

    protected XBit16 fetch() {

        XBit16 pcValue = registers.pc;
        XBit8 highOperand = memory.read(pcValue.getUnsignedValue());
        XBit8 lowOperand = memory.read(
                XBitUtils.increment(pcValue).getUnsignedValue()
        );

        return XBit16.valueOfHighAndLow(
                highOperand,
                lowOperand
        );
    }






}
