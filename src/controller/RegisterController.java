package controller;

import java.time.LocalDate;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class RegisterController {
	
	private Main main;
	@FXML
	TextField amount;
	
	@FXML
	TextField description;
	
	@FXML
	DatePicker date;
	
	@FXML
	Button save;
	
	@FXML
	RadioButton income;
	
	@FXML
	RadioButton expense;
	
	
	
	@FXML
	public void addMovement() {
		try {
			
			int type = 0;
			if(expense.isSelected()==true)
			{
				type=1;
			}
			if(income.isSelected()==true)
			{
			 type=2;
			}
			
			double amount2 = Double.parseDouble(amount.getText());
			
			LocalDate date2 = date.getValue();
			
			main.addMovement(date2 ,type, description.getText(), amount2);
			main.logOut();
		}catch(NumberFormatException e) {
			
		}
	}	
	
	public void setMain(Main main) {
		this.main=main;
	}
	
}
