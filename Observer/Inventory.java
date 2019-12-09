import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<AdditionObserver> additionObservers = new ArrayList<>();
    private List<RemovalObserver> removalObservers = new ArrayList<>();
    private List<Integer> aItems = new ArrayList<>();

    public void addAddition(AdditionObserver pObserver) {
        additionObservers.add(pObserver);
    }

    public void addRemoval(RemovalObserver pObserver) {
        removalObservers.add(pObserver);
    }

    public void removeAddition(AdditionObserver pObserver) {
        additionObservers.remove(pObserver);
    }

    public void removeRemoval(RemovalObserver pObserver) {
        removalObservers.remove(pObserver);
    }

    public void addItem(int item) {
        aItems.add(item);
        notifyAdditionObservers(item);
    }

    public void removeItem(int item) {
        aItems.remove(item);
        notifyRemovalObservers(item);
    }

    private void notifyAdditionObservers(int item) {
        for (AdditionObserver observer : additionObservers) {
            observer.newItem(item);
        }
    }

    private void notifyRemovalObservers(int item) {
        for (RemovalObserver observer : removalObservers) {
            observer.itemRemoved(item);
        }
    }

    public static void main(String[] args)
    {
        Inventory inventory = new Inventory();
        PieChart pieChart = new PieChart();
        ListView listView = new ListView();
        TransactionLog logger = new TransactionLog();
        inventory.addAddition(pieChart);
        inventory.addAddition(listView);
        inventory.addAddition(logger);
        inventory.addRemoval(pieChart);
        inventory.addRemoval(listView);
        int item1 = 1;
        int item2 = 2;
        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.removeItem(item1);
    }

}

