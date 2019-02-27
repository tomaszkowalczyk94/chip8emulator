package org.tomaszkowalczyk94.chip8emu.core;

import lombok.Data;
import org.tomaszkowalczyk94.chip8emu.core.instruction.AbstractInstruction;
import org.tomaszkowalczyk94.chip8emu.core.screen.ConsoleDrawer;
import org.tomaszkowalczyk94.chip8emu.core.screen.Drawer;
import org.tomaszkowalczyk94.chip8emu.core.screen.ScreenManager;
import org.tomaszkowalczyk94.xbit.XBit16;
import org.tomaszkowalczyk94.xbit.XBit8;
import org.tomaszkowalczyk94.xbit.XBitUtils;

import java.util.Stack;

/**
 * The main class of emulator.
 * {@link Chip8} class stores memory and registers values. Have method which can run emulation.
 * This class executes drawing pixels on screen.
 */
@Data
public class Chip8 {

    Memory memory = new Memory();
    Registers registers = new Registers();
    InstructionDecoder instructionDecoder = new InstructionDecoder();
    ScreenManager screenManager = new ScreenManager();

    Drawer drawer = new ConsoleDrawer();

    Stack<XBit16> stack = new Stack<>();

    public Chip8() {

    }

    public void runTo(XBit16 address) {
        while (registers.pc.getUnsignedValue() != address.getUnsignedValue()) {
            runOneInstruction();
        }
    }

    public void runInstructions(int countOfInstructionsToRun) {
        for (int i = 0 ; i<countOfInstructionsToRun; i++) {
            runOneInstruction();
        }
    }

    public void runOneInstruction() {
        XBit16 opcode = fetch();
        AbstractInstruction instruction = instructionDecoder.decode(opcode);
        instruction.execute(opcode, this);

        drawer.draw(screenManager.getScreen());
    }

    private XBit16 fetch() {

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
