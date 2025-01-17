package application.view.UserGameLibraryPage;

import application.Main;
import application.model.local_impl.game.Game;
import application.model.local_impl.game.Genre;
import application.viewModel.mystiverse.subMystiversePages.AllGamesPageAnchorViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class UserGameLibraryAddGamePage {

	@FXML
	private ListView<Game> gamesListView;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private ContextMenu addGameToLibraryContextMenu;

	@FXML
	private MenuItem addToLikedMenuItem;

	@FXML
	private MenuItem addToDislikedMenuItem;

	@FXML
	private MenuItem addToOwnedMenuItem;

	@FXML
	private ComboBox<Genre> genresComboBox;

	@FXML
	private TextField searchTextField;

	@FXML
	private Button addToLikedButton;

	@FXML
	private Button addToDislikedButton;

	@FXML
	private Button addToOwnedButton;

	@FXML
	private ImageView gameImageView;

	@FXML
	private TextArea descriptionTextArea;

	private AllGamesPageAnchorViewModel viewModel;

	/**
	 * Creates a new UserGameLibraryAddGamePage
	 * 
	 */
	public UserGameLibraryAddGamePage() {
		this.viewModel = new AllGamesPageAnchorViewModel();
	}

	@FXML
	void initialize() {
		this.validateFXML();
		this.setupSearchbar();
		this.setupGenresComboBox();
		this.setupListView();
		this.setupImageView();
		this.setupGameDescTextBox();
		this.setupButtons();
		this.setupContextMenu();
	}

	private void setupButtons() {
		this.addToLikedButton.setOnAction((event) -> {
			this.viewModel.addGameToInterestedList(this.gamesListView.getSelectionModel().getSelectedItem());
			var errorPopUp = new Alert(AlertType.CONFIRMATION);
			errorPopUp.setContentText("Selected game was added to your liked games !");
			errorPopUp.showAndWait();
		});
		this.addToDislikedButton.setOnAction((event) -> {
			this.viewModel.addGameToDislikedList(this.gamesListView.getSelectionModel().getSelectedItem());
			var errorPopUp = new Alert(AlertType.CONFIRMATION);
			errorPopUp.setContentText("Selected game was added to your disliked games !");
			errorPopUp.showAndWait();
		});
		this.addToOwnedButton.setOnAction((event) -> {
			this.viewModel.addGameToOwnedList(this.gamesListView.getSelectionModel().getSelectedItem());
			var errorPopUp = new Alert(AlertType.CONFIRMATION);
			errorPopUp.setContentText("Selected game was added to your owned games !");
			errorPopUp.showAndWait();
		});
	}

	private void setupImageView() {
		this.gameImageView.imageProperty().bindBidirectional(this.viewModel.getImageProperty());
	}

	private void setupGameDescTextBox() {
		this.descriptionTextArea.textProperty().bindBidirectional(this.viewModel.getGameDescStringProperty());
	}

	private void setupSearchbar() {
		this.searchTextField.setOnKeyReleased((event) -> {
			this.gamesListView.getItems()
					.setAll(this.viewModel.filterOnSearch(this.searchTextField.getText(), Main.getGames()));
		});
	}

	private void setupGenresComboBox() {
		this.genresComboBox.getItems().setAll(Genre.values());
		this.genresComboBox.setOnAction((event) -> {
			var selectedGenre = this.genresComboBox.getValue();
			this.gamesListView.getItems().setAll(this.viewModel.searchForGenre(selectedGenre, Main.getGames()));
		});
	}

	private void setupListView() {
		this.gamesListView.getItems().setAll(Main.getGames());
		this.gamesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				this.viewModel.setImage(newValue.getGamePhoto());
				this.viewModel.setGameDesc(newValue.getDescription());
			}
		});
	}

	private void setupContextMenu() {
		this.addToLikedMenuItem.setOnAction((event) -> {
			this.viewModel.addGameToInterestedList(this.gamesListView.getSelectionModel().getSelectedItem());
			var errorPopUp = new Alert(AlertType.CONFIRMATION);
			errorPopUp.setContentText("Selected game was added to your liked games !");
			errorPopUp.showAndWait();
		});
		this.addToDislikedMenuItem.setOnAction((event) -> {
			this.viewModel.addGameToDislikedList(this.gamesListView.getSelectionModel().getSelectedItem());
			var errorPopUp = new Alert(AlertType.CONFIRMATION);
			errorPopUp.setContentText("Selected game was added to your disliked games !");
			errorPopUp.showAndWait();
		});
		this.addToOwnedMenuItem.setOnAction((event) -> {
			this.viewModel.addGameToOwnedList(this.gamesListView.getSelectionModel().getSelectedItem());
			var errorPopUp = new Alert(AlertType.CONFIRMATION);
			errorPopUp.setContentText("Selected game was added to your owned games !");
			errorPopUp.showAndWait();
		});
	}

	private void validateFXML() {
		assert this.addGameToLibraryContextMenu != null
				: "fx:id=\"addGameToLibraryContextMenu\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
		assert this.addToDislikedButton != null
				: "fx:id=\"addToDislikedButton\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
		assert this.addToDislikedMenuItem != null
				: "fx:id=\"addToDislikedMenuItem\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
		assert this.addToLikedButton != null
				: "fx:id=\"addToLikedButton\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
		assert this.addToLikedMenuItem != null
				: "fx:id=\"addToLikedMenuItem\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
		assert this.addToOwnedButton != null
				: "fx:id=\"addToOwnedButton\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
		assert this.addToOwnedMenuItem != null
				: "fx:id=\"addToOwnedMenuItem\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
		assert this.anchorPane != null
				: "fx:id=\"anchorPane\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
		assert this.gameImageView != null
				: "fx:id=\"gameImageView\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
		assert this.gamesListView != null
				: "fx:id=\"gamesListView\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
		assert this.genresComboBox != null
				: "fx:id=\"genresComboBox\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
		assert this.searchTextField != null
				: "fx:id=\"searchTextField\" was not injected: check your FXML file 'UserGameLibraryAddGamePage.fxml'.";
	}

}
