public enum Rank
{ ACE, TWO, THREE, FOUR, FIVE, SIX,
    SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    @Override
    public String toString()
    {
        return name().substring(0, 1) + name().substring(1).toLowerCase();
    }
}