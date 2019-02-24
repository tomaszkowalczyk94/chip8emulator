package org.tomaszkowalczyk94.chip8emu.core.screen;

/**
 * Class which is drawing display output in the console.
 */
public class ConsoleDrawer implements Drawer {

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(boolean[][] pixels) {

        if(pixels.length != 64 || pixels[0].length != 32) {
            throw new IllegalArgumentException();
        }

        for(int y=0; y<32; y++) {
            for(int x=0; x<64; x++) {
                    if(pixels[x][y]) {
                        System.out.print('\u25A0');
                    } else {
                        System.out.print('\u25A2');
                    }

            }
            System.out.println("");
        }
    }
}
