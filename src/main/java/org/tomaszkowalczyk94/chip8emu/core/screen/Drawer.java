package org.tomaszkowalczyk94.chip8emu.core.screen;


/**
 * Interface for method of drawing result of emulation. Chip8 have 64x32 monochrome display.
 * You can draw pixels in a lot of ways, for example in a console, or by using something graphical library.
 * The Drawer's object you can in {@link org.tomaszkowalczyk94.chip8emu.core.Cpu#setDrawer(Drawer)} method
 */
public interface Drawer {

    /**
     * Display given pixels array
     * @param pixels
     */
    void draw(boolean[][] pixels);

}
