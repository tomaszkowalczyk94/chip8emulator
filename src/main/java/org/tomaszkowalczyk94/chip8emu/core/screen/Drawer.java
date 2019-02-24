package org.tomaszkowalczyk94.chip8emu.core.screen;


import org.tomaszkowalczyk94.chip8emu.core.Chip8;

/**
 * Interface for method of drawing result of emulation. Chip8 have 64x32 monochrome display.
 * You can draw pixels in a lot of ways, for example in a console, or by using something graphical library.
 * The Drawer's object you can in {@link Chip8#setDrawer(Drawer)} method
 */
public interface Drawer {

    /**
     * Display given pixels array
     * @param pixels two dimensions array with pixels. Pixel can be set (tru value) of unset false value.
     *               array must be 64x32 size.
     */
    void draw(boolean[][] pixels);

}
