package org.tomaszkowalczyk94.chip8emu.core.screen;

import lombok.Getter;

/**
 * Manage pixels off screen.
 */
public class ScreenManager {

    @Getter boolean[][] screen = new boolean[64][32];

    /**
     * setting pixel on inherit array. Dont display the change. Only setting internal state.
     * @param x vertical index, Can be from 0 to 64
     * @param y horizontal index. Can be from 0 to 32
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
