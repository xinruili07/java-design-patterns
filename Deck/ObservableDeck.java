public class ObservableDeck implements Observer {
    private int size = -1;

    @Override
    public void cardAdded(Card pCard) {
        // empty
    }

    @Override
    public void cardDrawn(Card pCard) {
        System.out.println(pCard + " was drawn");
    }

    @Override
    public void shuffled() {
        //empty
    }

    public void print() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Observer o = new ObservableDeck();
    }
}
