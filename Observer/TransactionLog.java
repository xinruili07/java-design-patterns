public class TransactionLog implements AdditionObserver {

    @Override
    public void newItem(int item) {
        System.out.println("Item " + item + " added to transaction log!");
    }
}
