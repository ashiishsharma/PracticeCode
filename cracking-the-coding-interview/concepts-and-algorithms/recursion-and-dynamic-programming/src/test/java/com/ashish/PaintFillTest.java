package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.10
 * <p>
 * <B>Paint Fill:</B>
 * <p>
 * Implement the "paint fill" function that one might see on many image editing programs.
 * That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
 * fill in the surrounding area until the color changes from the original color.
 *
 * <B>Solution</B>
 * Apply BFS or DFS
 *
 * @author Ashish Sharma on 03/05/2019.
 * @since 03/05/2019.
 */
public class PaintFillTest {

    private PaintFill paintFill;

    @BeforeMethod
    public void init() {
        paintFill = new PaintFill();
    }

    @Test
    public void testPaintFill() {
        PaintFill.Color[][] colorScreen = new PaintFill.Color[][]{{PaintFill.Color.Black, PaintFill.Color.Black, PaintFill.Color.Black}
                , {PaintFill.Color.Black, PaintFill.Color.Black, PaintFill.Color.Black},
                {PaintFill.Color.Black, PaintFill.Color.Black, PaintFill.Color.Red}};

        System.out.println(Arrays.deepToString(colorScreen));
        System.out.println(paintFill.paintFill(colorScreen,1,2,PaintFill.Color.Green));
        System.out.println(Arrays.deepToString(colorScreen));
    }
}
