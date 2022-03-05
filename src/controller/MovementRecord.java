package controller;

import java.time.LocalDate;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
	
	
	public void recalculate() {
		amountLabel.setText("$" + main.refreshBalance());
	}
	
	public void applyFilter(LocalDate minDate, LocalDate maxDate) {

        LocalDate finalMin = minDate == null ? LocalDate.MIN : minDate;
        LocalDate finalMax = maxDate == null ? LocalDate.MAX : maxDate;

        filteredItems.setPredicate(item -> !finalMin.isAfter(item.getDate()) && !finalMax.isBefore(item.getDate()));
    }
	
	public void deleteFilter() {
        filteredItems.setPredicate(item -> true);
    }
	
}