package model;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class BancoSystem {
	
	private ObservableList<Movement> allItems = FXCollections.observableArrayList();
	private FilteredList<Movement> filteredItems = new FilteredList<>(allItems);
	
	public void addMovement(LocalDate date ,int type, String description, double amount) {
		Movement movement = new Movement (date ,type, description, amount);
		allItems.add(movement);
	}
	
	public void removeMovement(Movement movement) {
		allItems.remove(movement);
	}
	public FilteredList<Movement> getData(){
		return filteredItems;
	}
	/*
	public void applyFilter(LocalDate minDate, LocalDate maxDate) {
        bancoSystem.applyFilter(minDate, maxDate);
    }

    public void deleteFilter() {
        walletSystem.deleteFilter();
    }
    */
}
