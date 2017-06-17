package com.ashish;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 8.3
 * <p>
 * Design a musical jukebox using object-oriented principles.
 * <p>
 *
 * @author Ashish Sharma on 6/8/2017.
 *         <p>
 * @since 6/8/2017.
 */
public class MusicalJukeboxTest {

    @BeforeMethod
    public void initialize(){

    }

    @Test
    public void testMusicalJukeBox(){
        MusicalJukebox musicalJukeBox = new MusicalJukebox();
    }
}
