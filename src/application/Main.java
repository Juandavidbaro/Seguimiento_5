package application;
	
import java.io.IOException;
import java.time.LocalDate;

import controller.LoginController;
import controller.MainController;
import controller.MovementRecord;
import controller.RegisterController;
import javafx.application.Application;
import javafx.collections.transformation.FilteredList;
import javafx.stage.Stage;
import model.BancoSystem;
import model.Movement;
import model.Users;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private BancoSystem bancosystem;
	private Users users;	
	private Stage currentStage;
	
	@Override
	public void start(Stage primaryStage) {
		
		users = new Users();
		users.addUser("admin", "1234"); //TODO delete
		bancosystem=new BancoSystem();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Login.fxml"));
			
			BorderPane root;
			root = (BorderPane)loader.load();
			LoginController controller = loader.getController();
			controller.setMain(this);
			controller.setUsers(users);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage = stage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showMainView() {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MainP.fxml"));
			BorderPane root = (BorderPane)loader.load();
			
			MainController controller = loader.getController();
			controller.setMain(this);
			
			Scene scene = new Scene(root); //Contenido de la ventana
			
			Stage stage = new Stage(); // Ventana
			stage.setScene(scene);
			currentStage.close();
			stage.show();
			currentStage = stage;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void logOut() {
		currentStage.close();
		showMainView();
	}
	
	public void showRegisterSameStage() {
		try {
			
			FXMLLoader loader =new FXMLLoader(getClass().getResource("../ui/Register.fxml"));
			
			BorderPane root2 = (BorderPane)loader.load();
			
			RegisterController controller = loader.getController();
			controller.setMain(this);
			
			Stage stage = currentStage;			
			
			BorderPane root = (BorderPane)stage.getScene().getRoot();
			root.setLeft(root2);
			stage.show();	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void showRegisterListSameStage() {
		try {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("../ui/ShowRegister.fxml"));
			
			BorderPane root2 = (BorderPane)loader.load();
			
			MovementRecord controller = loader.getController();
			controller.setMain(this);
			controller.refresh();
			Stage stage = currentStage;			
			
			BorderPane root = (BorderPane)stage.getScene().getRoot();
			root.setLeft(root2);
			stage.show();			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void addMovement(LocalDate date ,int type, String description, double amount) {
		bancosystem.addMovement(date,type,description,amount);
	}
	public void removeMovement(Movement movement) {
		bancosystem.removeMovement(movement);
	}
	public FilteredList<Movement> getData(){
		return bancosystem.getData();
	}
	
	public void applyFilter(LocalDate minDate, LocalDate maxDate) {
        bancosystem.applyFilter(minDate, maxDate);
    }

    public void deleteFilter() {
        bancosystem.deleteFilter();
    }  
   
	
}
