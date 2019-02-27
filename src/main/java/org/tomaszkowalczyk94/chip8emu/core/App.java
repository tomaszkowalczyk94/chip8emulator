package org.tomaszkowalczyk94.chip8emu.core;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Chip8 chip8 = new Chip8();

        chip8.runInstructions(100);
    }
}
