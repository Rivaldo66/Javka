import Data_Layer.SQL;
import Logical_Layer.DataRepository;
import Logical_Layer.DataService;
import Logical_Layer.LogControler;
import Presentation_Layer.GAME;
import Presentation_Layer.GUI;
import Presentation_Layer.LOG;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Program extends Application{

	public static void main(String[] args) {

		SQL connServer = new SQL();
		connServer.dbConnect(
				"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Pawel; password=mama");
		//connServer.dbConnect(
				//"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Damian; password=Worrior");

		//GUI gra = new GUI();
		//DataRepository tata2 = new DataRepository(connServer);
		//DataService mama2 = new DataService(tata2);
		
		//gra.runLogFrame();
		//LogControler checkLog = new LogControler(tata2,gra);
		launch(args);

	}
	
	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

}
