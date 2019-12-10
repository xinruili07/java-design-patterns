import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Hand implements HandView {
    private ArrayList<Card> aCards = new ArrayList<>();
    private int maxCards;


    /**
     * @param pMaxCards: The maximum number of cards in a hand
     * @pre pMaxCards > 0
     **/
    public Hand(int pMaxCards) {
        assert pMaxCards > 0;
        maxCards = pMaxCards;
    }

    /**
     * @param card: Card added to the hand
     * @pre card != null
     * @pre !isFull
     */
    public void add(Card card) {
        assert card != null;
        assert !isFull();

        aCards.add(card);
    }

    public Iterator<Card> getCards() {
        return aCards.iterator();
    }

    /**
     * @param card: Card to be removed from the hand
     * @pre card != null
     */
    public void remove(Card card) {
        assert card != null;
        aCards.remove(card);
    }

    public boolean contains(Card card) {
        assert card != null;
        return aCards.contains(card);
    }

    public boolean isEmpty() {
        return aCards.size() == 0;
    }

    public int size() {
        return aCards.size();
    }



    public boolean isFull() {
        return aCards.size() == maxCards;
    }

    @Override
    public int compareTo(HandView pHand) {
        return aCards.size() - pHand.size();
    }

    @Override
    public Iterator<Card> iterator() {
        return aCards.iterator();
    }
    public static Comparator<Hand> createAscendingComparator()
    {
        return new Comparator<Hand>() {

            @Override
            public int compare(Hand pHand1, Hand pHand2)
            {
                return pHand1.aCards.size() - pHand2.aCards.size();
            }};
    }

    public static Comparator<Hand> createDescendingComparator()
    {
        return new Comparator<Hand>() {

            @Override
            public int compare(Hand pHand1, Hand pHand2)
            {
                return pHand2.aCards.size() - pHand1.aCards.size();
            }};
    }

    public static Comparator<Hand> createByRankComparator(Rank pRank) {
        return new Comparator<Hand>() {
            @Override
            public int compare(Hand pHand1, Hand pHand2) {
                return countCards(pHand1, pRank) - countCards(pHand2, pRank);
            }

            private int countCards(Hand pHand, Rank pRank) {
                int count = 0;
                for (Card card : pHand) {
                    if (card.getRank() == pRank) {
                        count++;
                    }
                }
                return count;
            }
        };

    }

    @Override
    public boolean equals(Object o) {
        if (o == null ) {
            return false;
        }

        if (o == this) {
            return true;
        }

        else if( o.getClass() != getClass()) // Ensures the objects are of the same class
        {
            return false;
        }

        else {
            return (size() == ((Hand) o).size());
        }
    }

    @Override
    public int hashCode() {
        return aCards.hashCode();
    }

    @Override
    public Hand clone() {
        try {
            Hand clone = (Hand) super.clone();
            clone.aCards = new ArrayList<>();

            for (Card card : aCards) {
                clone.aCards.add(card);
            }

            return clone;
        }
        catch(CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
