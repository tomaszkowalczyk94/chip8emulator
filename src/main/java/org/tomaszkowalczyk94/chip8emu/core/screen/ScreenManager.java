package org.tomaszkowalczyk94.chip8emu.core.screen;

import lombok.Getter;

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


}
