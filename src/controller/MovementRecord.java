package controller;

import java.time.LocalDate;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Movement;


public class MovementRecord {

	private Main main;
	
	
	public void setMain(Main main) {
		this.main=main;
	}	
	
	@FXML
	Label amountLabel;
	
	@FXML
	TableView<Movement> movementsTable;
	
	@FXML
	TableColumn<Movement, LocalDate> dateColumn;
	
	@FXML
	TableColumn<Movement,Integer> typeColumn;
	
	@FXML
	TableColumn<Movement, String> descriptionColumn;
	
	@FXML
	TableColumn<Movement, Double> amountColumn;
	
	@FXML
	DatePicker minDate;
	
	@FXML
	DatePicker maxDate;
	
	
	@FXML
	public void initialize() {
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		
	
	}
	@FXML
	public void deleteMovement() {
		Movement movements = movementsTable.getSelectionModel().getSelectedItem();
		main.removeMovement(movements);
	}
	
	public void refresh() {
		movementsTable.setItems(main.getData());
	}
	
	/*
	public void recalculate() {
		amountLabel.setText("$" + main.refreshBalance());
	}*/
	
	
	@FXML
	public void applyFilter() {
		try {
			LocalDate min= minDate.getValue();
			LocalDate max= maxDate.getValue();
			main.applyFilter(min, max);
		}catch(Exception e) {
				
		}
	}
	@FXML
	public void deleteFilter() {
		try {
			
			main.deleteFilter();
		}catch(Exception e) {
				
		}
	}	
	
}