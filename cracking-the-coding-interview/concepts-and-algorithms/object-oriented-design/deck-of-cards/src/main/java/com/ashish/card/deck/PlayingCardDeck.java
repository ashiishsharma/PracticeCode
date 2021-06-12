package com.ashish.card.deck;

import com.ashish.card.PlayingCard;
import com.ashish.card.PlayingCardName;
import com.ashish.card.PlayingCardType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shshaash on 4/5/2017.
 */
public class PlayingCardDeck {

    private List<PlayingCard> heartPlayingCards;
    private List<PlayingCard> spadePlayingCards;
    private List<PlayingCard> diamondPlayingCards;
    private List<PlayingCard> clubPlayingCards;
    private List<PlayingCard> playingCardList;

    public List<PlayingCard> getHeartPlayingCards() {
        return heartPlayingCards;
    }

    public List<PlayingCard> getSpadePlayingCards() {
        return spadePlayingCards;
    }

    public List<PlayingCard> getDiamondPlayingCards() {
        return diamondPlayingCards;
    }

    public List<PlayingCard> getClubPlayingCards() {
        return clubPlayingCards;
    }

    public List<PlayingCard> getPlayingCardList() {
        return playingCardList;
    }


    public PlayingCardDeck() {
        clubPlayingCards = getPlayingCards(PlayingCardType.Club);
        diamondPlayingCards = getPlayingCards(PlayingCardType.Diamond);
        spadePlayingCards = getPlayingCards(PlayingCardType.Spade);
        heartPlayingCards = getPlayingCards(PlayingCardType.Heart);

        playingCardList = new ArrayList();

        playingCardList.addAll(clubPlayingCards);
        playingCardList.addAll(diamondPlayingCards);
        playingCardList.addAll(spadePlayingCards);
        playingCardList.addAll(heartPlayingCards);
    }

    private List<PlayingCard> getPlayingCards(PlayingCardType playingCardType) {
        List playingCards = new ArrayList();
        for(PlayingCardName playingCardName : PlayingCardName.values()){
            PlayingCard playingCard = getPlayingCard(playingCardType, playingCardName);
            playingCards.add(playingCard);
        }
        return playingCards;
    }

    private PlayingCard getPlayingCard(PlayingCardType playingCardType, PlayingCardName playingCardName) {
        return new PlayingCard(playingCardType, playingCardName);
    }
}
