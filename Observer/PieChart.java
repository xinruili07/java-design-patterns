import java.util.ArrayList;
import java.util.List;

public class PieChart implements AdditionObserver, RemovalObserver {


    @Override
    public void newItem(int item) {
       System.out.println("Item " + item + " added to PieChart!");
    }

    @Override
    public void itemRemoved(int item) {
        System.out.println("Item " + item + " removed from PieChart!");
    }
}
