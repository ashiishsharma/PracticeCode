package com.ashish;

import com.ashish.card.deck.PlayingCardDeck;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 8.1
 * <p>
 * Design the data structures for a generic deck of cards.
 * Explain how you would subclass the data structures to implement blackjack.
 * <p>
 *
 * @author Ashish Sharma on 4/5/2017.
 *         <p>
 * @since 4/5/2017.
 */
public class DeckOfCardsTest {

    @BeforeMethod
    public void initialize() {

    }

    @Test
    public void testDeckOfCards() {
        PlayingCardDeck playingCards = new PlayingCardDeck();
    }

    /**
     * Implement BlackJack after reading on the rules of the Games
     */
    @Test
    public void blackJack() {
        Assert.assertTrue(true, "Implement BlackJack after reading on the rules of the Games");
    }
}
