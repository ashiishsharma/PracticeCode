package com.ashish;

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
        PlayingCard acePlayingCard = getPlayingCard(playingCardType, PlayingCardName.Ace);
        PlayingCard twoPlayingCard = getPlayingCard(playingCardType, PlayingCardName.Two);
        PlayingCard threePlayingCard = getPlayingCard(playingCardType, PlayingCardName.Three);
        PlayingCard fourPlayingCard = getPlayingCard(playingCardType, PlayingCardName.Four);
        PlayingCard fivePlayingCard = getPlayingCard(playingCardType, PlayingCardName.Five);
        PlayingCard sixPlayingCard = getPlayingCard(playingCardType, PlayingCardName.Six);
        PlayingCard sevenPlayingCard = getPlayingCard(playingCardType, PlayingCardName.Seven);
        PlayingCard eightPlayingCard = getPlayingCard(playingCardType, PlayingCardName.Eight);
        PlayingCard ninePlayingCard = getPlayingCard(playingCardType, PlayingCardName.Nine);
        PlayingCard tenPlayingCard = getPlayingCard(playingCardType, PlayingCardName.Ten);
        PlayingCard jackPlayingCard = getPlayingCard(playingCardType, PlayingCardName.Jack);
        PlayingCard queenPlayingCard = getPlayingCard(playingCardType, PlayingCardName.Queen);
        PlayingCard kingPlayingCard = getPlayingCard(playingCardType, PlayingCardName.King);

        List playingCards = new ArrayList();
        playingCards.add(acePlayingCard);
        playingCards.add(twoPlayingCard);
        playingCards.add(threePlayingCard);
        playingCards.add(fourPlayingCard);
        playingCards.add(fivePlayingCard);
        playingCards.add(sixPlayingCard);
        playingCards.add(sevenPlayingCard);
        playingCards.add(eightPlayingCard);
        playingCards.add(ninePlayingCard);
        playingCards.add(tenPlayingCard);
        playingCards.add(jackPlayingCard);
        playingCards.add(queenPlayingCard);
        playingCards.add(kingPlayingCard);
        return playingCards;
    }

    private PlayingCard getPlayingCard(PlayingCardType playingCardType, PlayingCardName playingCardName) {
        return new PlayingCard(playingCardType, playingCardName);
    }
}
