import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a deck of playing cards. In this version, the cards in the 
 * deck are stored in a list and the list of cards in the deck can 
 * be obtained by client code using an immutable wrapper object.
 */
public class Deck
{
    private List<Card> aCards = new ArrayList<>();
    private List<Observer> aObservers = new ArrayList<>();
    /**
     * Creates a new deck of 52 cards, shuffled.
     */
    public Deck()
    {
        shuffle();
    }

    /**
     * Reinitializes the deck with all 52 cards, and shuffles them.
     */
    public void shuffle()
    {
        aCards.clear();
        for( Suit suit : Suit.values() )
        {
            for( Rank rank : Rank.values() )
            {
                aCards.add( new Card( rank, suit ));
            }
        }
        Collections.shuffle(aCards);
    }

    /**
     * Places pCard on top of the deck.
     * @param pCard The card to place on top
     * of the deck.
     * @pre pCard !=null
     */
    public void push(Card pCard)
    {
        assert pCard != null;
        aCards.add(pCard);
        for (Observer o : aObservers) {
            o.cardAdded(pCard);
        }
    }

    /**
     * Draws a card from the deck: removes the card from the top
     * of the deck and returns it.
     * @return The card drawn.
     * @pre !isEmpty()
     */
    public Card draw()
    {
        assert !isEmpty();
        Card pCard = aCards.remove(aCards.size() - 1);
        for (Observer o : aObservers) {
            o.cardDrawn(pCard);
        }

        return pCard;

    }

    /**
     * @return True if and only if there are no cards in the deck.
     */
    public boolean isEmpty()
    {
        return aCards.isEmpty();
    }

    /**
     * @return An unmodifiable list of all the cards in the deck.
     */
    public List<Card> getCards()
    {
        return Collections.unmodifiableList(aCards);
    }

    // Observer design
    public void addObserver(Observer o) {
        aObservers.add(o);
    }

    public void removeObserver(Observer o) {
        aObservers.remove(o);
    }


}