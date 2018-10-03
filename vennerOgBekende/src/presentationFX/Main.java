package presentationFX;

import java.awt.TextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.VennerOgBekendte;
import logic.VennerOgBekendteFactory;

public class Main extends Application {
	private TableView table = new TableView();

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) {

		VennerOgBekendte vennerOgBekendte = new VennerOgBekendteFactory().makeVennerOgBekendte();

		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane);
		stage.setTitle("venner og bekendte");
		stage.setWidth(300);
		stage.setHeight(500);

		GridPane botgridPane = new GridPane();
		botgridPane.setPadding(new Insets(10, 10, 10, 10));
		botgridPane.setVgap(5);
		botgridPane.setHgap(5);
		botgridPane.setAlignment(Pos.BOTTOM_CENTER);

		GridPane sidegridPane = new GridPane();
		sidegridPane.setPadding(new Insets(10, 10, 10, 10));
		sidegridPane.setVgap(5);
		sidegridPane.setVgap(5);
		sidegridPane.setAlignment(Pos.CENTER_LEFT);

//		TextField textName = new TextField();
//		textName.setPromptText("Enter a name.");
//		textName.setPrefColumnCount(15);
		
		VBox root = new VBox(20);
		root.setPadding(new Insets(50,50,50,50));
		
		Label txt = new Label("normal TextFields");
		
		TextField textName = new TextField();
		
//		root.getChildren().addAll(txt,textName);
		

		final Label label = new Label("Venne Liste");
		label.setFont(new Font("Arial", 20));

		Button button1 = new Button("Button1");
		Button button2 = new Button("Button2");
		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
//				response.setText("You pressed Up.");
			}
		});
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
//	11			response.setText("You pressed Down.");
			}
		});

		table.setEditable(true);

		TableColumn navn = new TableColumn("Navn");
		TableColumn email = new TableColumn("Email");
		TableColumn telefon = new TableColumn("Telefon nr");

		table.getColumns().addAll(navn, email, telefon);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);

		borderPane.setCenter(vbox);
		botgridPane.add(button1, 0, 0);
		botgridPane.add(button2, 1, 0);
		borderPane.setBottom(botgridPane);
		borderPane.setLeft(sidegridPane);
//		sidegridPane.add(textName, 0, 0);

		stage.setScene(scene);
		stage.show();
	}
}
