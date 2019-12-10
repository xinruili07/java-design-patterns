public interface HandView extends Comparable<HandView>, Iterable<Card> , Cloneable{
    public boolean contains(Card card);
    public boolean isEmpty();
    public int size();

}
