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
        musicalJukeBox.insertCoin(1);

        musicalJukeBox.insertCoin(2);
    }

    @Test
    public void testDisplay(){
        Display display = new Display();
        display.print("Insert coin to unlock");

    }

    @Test
    public void testCoinSlot(){
        CoinSlot coinSlot = new CoinSlot();
        coinSlot.insertCoin(1);
    }

    @Test
    public void testMusicPlayer(){
        MusicPlayer musicPlayer = new MusicPlayer();
        int selectedSongNumber = 2;
        musicPlayer.play(selectedSongNumber);
    }
}
