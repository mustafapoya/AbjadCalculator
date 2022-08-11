package net.golbarg.abjad;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AbjadController {
	@FXML
	private Label lblText;

	@FXML
	private TextField txtText;

	@FXML
	private Button btnCalculate;

	@FXML
	Label lblResult;
	@FXML
	TextField txtResult;

	@FXML
	Label lblDetails;

	@FXML
	TableView<Abjad> tableDetails;

	@FXML
	TableColumn<Abjad, String> columnCharacter;
	@FXML
	TableColumn<Abjad, Integer> columnValue;

	ObservableList<Abjad> tableList = FXCollections.observableArrayList();

	@FXML
	private void initialize() {

		columnCharacter.setCellValueFactory(new PropertyValueFactory<>("character"));
		columnValue.setCellValueFactory(new PropertyValueFactory<>("value"));

		btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String text = txtText.getText().trim();
				txtResult.setText(String.valueOf(calculateAbjadOf(text)));

			}
		});

		tableList.addAll(allAbjads());
		tableDetails.getItems().addAll(tableList);
	}

	public static int calculateAbjadOf(String text) {
		int result = 0;

		ArrayList<Abjad> characterList = allAbjads();

		for (int i = 0; i < text.length(); i++) {
			int value = 0;
			for (int j = 0; j < characterList.size(); j++) {
				if (characterList.get(j).getCharacter() == text.charAt(i)) {
					value = characterList.get(j).getValue();
					result += value;
					continue;
				}
			}
		}
		return result;
	}

	public static ArrayList<Abjad> allAbjads() {
		ArrayList<Abjad> result = new ArrayList<>();
		result.add(new Abjad('ا', 1));
		result.add(new Abjad('أ', 1));
		result.add(new Abjad('ب', 2));
		result.add(new Abjad('پ', 2));
		result.add(new Abjad('ج', 3));
		result.add(new Abjad('چ', 3));
		result.add(new Abjad('د', 4));
		result.add(new Abjad('ه', 5));
		result.add(new Abjad('و', 6));
		result.add(new Abjad('ز', 7));
		result.add(new Abjad('ح', 8));
		result.add(new Abjad('ط', 9));
		result.add(new Abjad('ی', 10));
		result.add(new Abjad('ي', 10));
		result.add(new Abjad('گ', 20));
		result.add(new Abjad('ک', 20));
		result.add(new Abjad('ژ', 7));
		result.add(new Abjad('ل', 30));
		result.add(new Abjad('م', 40));
		result.add(new Abjad('ن', 50));
		result.add(new Abjad('س', 60));
		result.add(new Abjad('ع', 70));
		result.add(new Abjad('ف', 80));
		result.add(new Abjad('ص', 90));
		result.add(new Abjad('ق', 100));
		result.add(new Abjad('ر', 200));
		result.add(new Abjad('ش', 300));
		result.add(new Abjad('ت', 400));
		result.add(new Abjad('ث', 500));
		result.add(new Abjad('خ', 600));
		result.add(new Abjad('ذ', 700));
		result.add(new Abjad('ض', 800));
		result.add(new Abjad('ظ', 900));
		result.add(new Abjad('غ', 1000));
		return result;
	}
}
