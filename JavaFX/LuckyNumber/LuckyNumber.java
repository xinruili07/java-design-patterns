import java.time.LocalDateTime;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Martin P. Robillard
 *
 * Class to demonstrate the Observer design pattern 
 * in Java. Note that there are many ways to implement an
 * Observer design pattern, and that this is just one of them.
 */
public class LuckyNumber extends Application
{
	public static final int WIDTH = 200;
	
	private static final int GAP = 10;
	private static final int MARGIN = 20;
	
	/**
	 * Launches the application.
	 * @param pArgs This program takes no argument.
	 */
	public static void main(String[] pArgs) 
	{
        launch(pArgs);
    }
    
    @Override
    public void start(Stage pPrimaryStage) 
    {
    	Model model = new Model();
    	
    	GridPane root = createPane(); // The root of the GUI component graph
    	root.add(new SliderPanel(model), 0, 0, 1, 1);
    	root.add(new IntegerPanel(model), 0, 1, 1, 1);
    	root.add(new TextPanel(model), 0, 2, 1, 1);
    	root.add(new RomanNumeralPanel(model), 0, 3, 1, 1);

    	pPrimaryStage.setTitle("Lucky Number");
    	pPrimaryStage.setResizable(false);
        pPrimaryStage.setScene(new Scene(root));
        pPrimaryStage.show();
    }
    
    /*
     * Helper method to hid the details of creating
     * a nice looking grid.
     */
    private static GridPane createPane()
    {
    	GridPane root = new GridPane();
    	root.setHgap(GAP);
    	root.setVgap(GAP);
    	root.setPadding(new Insets(MARGIN));
    	return root;
    }
}

/**
 * Concrete observer that displays the model
 * data in a slider.
 */
class SliderPanel extends HBox implements Observer
{
	private Slider aSlider = createSlider();
	private Model aModel;

	/**
	 * @param pModel The model observed by this panel.
	 */
	SliderPanel(Model pModel)
	{
		aModel = pModel;
		aModel.addObserver(this);
		aSlider.setValue(aModel.getNumber());
		getChildren().add(aSlider);
		Button button = new Button("Notify");
		getChildren().add(button);

		aSlider.valueProperty().addListener(new ChangeListener<Number>()
		{
			public void changed(ObservableValue<? extends Number> pValue, Number pOld, Number pNew) 
			{
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						aModel.setNumber(pNew.intValue());
					}
				});
			}
		});
	}

	@Override
	public void newNumber(int pNumber)
	{
		aSlider.setValue(pNumber);
	}
	
	private static Slider createSlider()
	{
		// CSOFF:
		Slider slider = new Slider(1, 10, 5);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMinWidth(LuckyNumber.WIDTH);
		slider.setMajorTickUnit(1);
		slider.setBlockIncrement(1);
		slider.setMinorTickCount(0);
		slider.setSnapToTicks(true); 
		// CSON:
		return slider;
	}
}

/**
 * Concrete observer that displays the model data
 * as a integer in a text field.
 */
class IntegerPanel extends HBox implements Observer
{
	private TextField aText = new TextField();
	private Model aModel;
	
	/**
	 * @param pModel The model observed by this panel.
	 */
	IntegerPanel(Model pModel)
	{
		aModel = pModel;
		aModel.addObserver(this);
		aText.setMinWidth(LuckyNumber.WIDTH); 
		aText.setText(new Integer(aModel.getNumber()).toString());
		getChildren().add(aText);
		Button button = new Button("Notify");
		getChildren().add(button);

		aText.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent pEvent)
			{
				int lInteger = 1;
				try
				{
					lInteger = Integer.parseInt(aText.getText());

				}
				catch(NumberFormatException pException )
				{
					// Just ignore. We'll use 1 instead.
				}
				int finalLInteger = lInteger;
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						aModel.setNumber(finalLInteger);
					}
				});

			}
		});
	}	

	@Override
	public void newNumber(int pNumber)
	{
		aText.setText(new Integer(pNumber).toString());
	}
}

class RomanNumeralPanel extends HBox implements Observer {
	private TextField aText = new TextField();
	private Model aModel;

	RomanNumeralPanel(Model pModel) {
		aModel = pModel;
		aModel.addObserver(this);
		aText.setMinWidth(LuckyNumber.WIDTH);
		aText.setText(GFG.printRoman(aModel.getNumber()));
		getChildren().add(aText);
		Button button = new Button("Notify");
		getChildren().add(button);

		aText.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String roman = "I";
				roman = aText.getText();
				RomanToNumeral ob = new RomanToNumeral();

				String finalRoman = roman;
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						aModel.setNumber(ob.romanToDecimal(finalRoman));
					}
				});

			}

		});
	}
	@Override
	public void newNumber(int pNumber) {
		aText.setText(GFG.printRoman(pNumber));
	}
}
/**
 * Concrete observer that displays the model data
 * as a written-out number in a text field.
 */
class TextPanel extends HBox implements Observer
{
	private static final String[] LABELS = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
	
	private TextField aText = new TextField();
	private Model aModel;
	
	/**
	 * @param pModel The model observed by this panel.
	 */
	TextPanel(Model pModel)
	{
		aModel = pModel;
		aModel.addObserver(this);
		aText.setMinWidth(LuckyNumber.WIDTH);
		aText.setText(LABELS[aModel.getNumber()]);
		getChildren().add(aText);
		Button button = new Button("Notify");
		getChildren().add(button);
		
		
		aText.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent pEvent)
			{
				int lIndex = 0;
				for( int i = 0; i < LABELS.length; i++)
				{
					if(aText.getText().equalsIgnoreCase(LABELS[i]))
					{
						lIndex = i;
						break;
					}
				}

				int finalLIndex = lIndex;
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						aModel.setNumber(finalLIndex);
					}
				});

			}
		});
	}

	@Override
	public void newNumber(int pNumber)
	{
		aText.setText(LABELS[pNumber]);
		
	}
}

/**
 * The observable object.
 */
class Model
{
	private static final int DEFAULT = 5;
	private static final int MAX = 10;
	
	private ArrayList<Observer> aObservers = new ArrayList<Observer>();
	private int aNumber = DEFAULT;
	
	public void addObserver(Observer pObserver)
	{
		aObservers.add(pObserver);
	}
	
	private void notifyObservers()
	{
		for(Observer observer : aObservers)
		{
			observer.newNumber(aNumber);
		}
	}
	
	public void setNumber(int pNumber)
	{
		if( pNumber < 0 )
		{
			aNumber = 0;
		}
		else if( pNumber > MAX )
		{
			aNumber = MAX;
		}
		else
		{
			aNumber = pNumber;
		}
		notifyObservers();
	}
	
	public int getNumber()
	{
		return aNumber;
	}
}

/**
 * Abstract observer role for the model.
 */
interface Observer
{
	void newNumber(int pNumber);
}
