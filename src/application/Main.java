package application;
	
import javafx.geometry.Insets;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25,25,25,25));
			
			Scene scene = new Scene(grid,800,600);

			
			Text titleText = new Text("Quick Maths!");
			titleText.setFont(Font.font("Tahoma", FontWeight.BOLD,35));
			grid.add(titleText, 0, 0,2,1);
			
			Text subText = new Text("Quick Maths is an application to instantly find the price per measurement of an item when it is not displayed.");
			subText.setFont(Font.font("Tahoma", FontWeight.NORMAL,12));
			grid.add(subText, 1, 1, 2, 1);
			
			Label price = new Label("Price:");
			price.setFont(Font.font("Tahoma",FontWeight.NORMAL,15));
			grid.add(price, 1, 2);
			
			TextField priceField = new TextField();
			grid.add(priceField, 1, 3);
			
			
			
			Label measurement = new Label("Measurement: ");
			measurement.setFont(Font.font("Tahoma",FontWeight.NORMAL,15));
			grid.add(measurement, 1, 4);
			
			TextField measField = new TextField();
			grid.add(measField, 1, 5);
			
			
			
			Button calc = new Button("Calculate");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_CENTER);
			hbBtn.getChildren().add(calc);
			grid.add(hbBtn, 1, 6);
			
			final Text calcTarget = new Text();
			grid.add(calcTarget, 1, 7);
			
			
			
			calc.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					double x = Double.parseDouble(measField.getText());
					double y = Double.parseDouble(priceField.getText());
					
					double d = y/x;
					double roundedD = Math.round(d * 100) / 100.0;
					String pricePer = new String("$" + roundedD + "per measurement");
					
					calc.setText(pricePer);
				}
			});
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Quick Maths!");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
