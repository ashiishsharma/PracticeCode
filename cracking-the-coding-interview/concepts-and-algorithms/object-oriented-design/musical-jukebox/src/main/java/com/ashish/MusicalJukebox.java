package com.ashish;

/**
 * Created by shshaash on 6/8/2017.
 */
public class MusicalJukebox {

    private Display jukeBoxDisplay;
    private CoinSlot jukeBoxCoinSlot;
    private MusicPlayer jukeBoxMusicPlayer;
    private boolean isCoinInserted;

    public MusicalJukebox(){
        jukeBoxDisplay = new Display();
        jukeBoxCoinSlot = new CoinSlot();
        jukeBoxMusicPlayer = new MusicPlayer();
        isCoinInserted = false;
    }

    public void insertCoin(int coin){
        isCoinInserted = jukeBoxCoinSlot.insertCoin(coin);
        musicalJukeBoxController();
    }

    private void musicalJukeBoxController(){
            if(isCoinInserted) {
                jukeBoxDisplay.print("Select the song to play from the displayed list");
                int selectedSong = jukeBoxDisplay.getSelectedSong();
                jukeBoxMusicPlayer.play(1);
                jukeBoxDisplay.print("Bye Bye ...");
            }

    }
}
