package com.ashish.card;

/**
 * Created by shshaash on 4/5/2017.
 */
public class PlayingCard {

    private PlayingCardType playingCardType;
    private PlayingCardName playingCardName;

    public PlayingCard(PlayingCardType playingCardType, PlayingCardName playingCardName) {
        this.playingCardType = playingCardType;
        this.playingCardName = playingCardName;
    }

    public PlayingCardName getPlayingCardName() {
        return playingCardName;
    }

    public PlayingCardType getPlayingCardType() {
        return playingCardType;
    }
}
