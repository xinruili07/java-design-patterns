public class ListView implements AdditionObserver, RemovalObserver {

    @Override
    public void newItem(int item) {
        System.out.println("Item " + item + " added to ListView");
    }

    @Override
    public void itemRemoved(int item) {
        System.out.println("Item " + item + " removed from ListView");
    }
}
