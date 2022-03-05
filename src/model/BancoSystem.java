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
	
	public void applyFilter(LocalDate minDate, LocalDate maxDate) {

        LocalDate finalMin = minDate == null ? LocalDate.MIN : minDate;
        LocalDate finalMax = maxDate == null ? LocalDate.MAX : maxDate;

        filteredItems.setPredicate(item -> !finalMin.isAfter(item.getDate()) && !finalMax.isBefore(item.getDate()));
    }

    public void deleteFilter() {
        filteredItems.setPredicate(item -> true);
    }
    
}
