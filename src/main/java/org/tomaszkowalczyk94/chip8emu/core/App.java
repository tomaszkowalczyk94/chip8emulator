package org.tomaszkowalczyk94.chip8emu.core;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Cpu cpu = new Cpu();

        cpu.run();



    }
}
