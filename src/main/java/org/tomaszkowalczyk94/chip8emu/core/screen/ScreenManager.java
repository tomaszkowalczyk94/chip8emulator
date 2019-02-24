package org.tomaszkowalczyk94.chip8emu.core.screen;

import lombok.Getter;

/**
 * Manage pixels off screen.
 */
public class ScreenManager {

    @Getter boolean[][] screen = new boolean[64][32];

    /**
     *
     * @param x
     * @param y
     * @return new pixel value
     */
    public boolean setPixel(int x, int y, boolean turnOn) {
        screen[x][y] = turnOn^screen[x][y];
        return screen[x][y];
    }

    public boolean getPixel(int x, int y) {
        return screen[x][y];
    }

    /**
     * set all displey pixels to unset
     */
    public void clear() {
        for(int y=0; y<32; y++) {
            for(int x=0; x<64; x++) {
                screen[x][y] = false;

            }
        }
    }

}
