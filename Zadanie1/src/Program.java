import java.sql.SQLException;
import Data_Layer.SQL;
import Data_Layer.User;
import Presentation_Layer.GUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Program extends Application{
	
	private static SQL sql;
	private static GUI gui;

	public static void main(String[] args) {

		sql = new SQL();
		//sql.dbConnect(
				//"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Pawel; password=mama");
		sql.dbConnect(
				"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Damian; password=Worrior");

		gui = new GUI();
		//DataRepository tata2 = new DataRepository(connServer);
		//DataService mama2 = new DataService(tata2);
		
		//gra.runLogFrame();
		//LogControler checkLog = new LogControler(tata2,gra);
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) {
        primaryStage.setTitle("LOGIN PANEL");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        Button btn = new Button("Sign in");
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            public void handle(ActionEvent e) {
            	User user = new User();
            	user.setLogin(userTextField.getText());
            	user.setPassword(pwBox.getText());
            	//narazie w bazce jest jeden uzytkownik tylko: login Damian i haslo Damian
            	try {
					if(userCheck(user)){
						actiontarget.setFill(Color.FIREBRICK);
						actiontarget.setText("Zapraszamy do gry :)");
						//odpalanie okna gry
						gui.runGameFrame();
					}
					else{
						actiontarget.setFill(Color.FIREBRICK);
						actiontarget.setText("Coœ posz³o nie tak :(");
					}
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
            }
        });
        
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public boolean userCheck(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean result;
		
		if(!sql.getUserDao().queryForAll().isEmpty()) { 
			result = true;
		}
		else{
			result = false;
		}
		return result;
	}

}
