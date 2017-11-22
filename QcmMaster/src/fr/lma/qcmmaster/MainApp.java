package fr.lma.qcmmaster;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;

	private BorderPane rootLayout;

	@Override
	public void start(final Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("QcmMaster");

		initRootLayout();

		showMainViewOverview();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			final Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the person overview inside the root layout.
	 */
	public void showMainViewOverview() {
		try {
			// Load mainView overview.
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/mainView.fxml"));
			final AnchorPane mainView = (AnchorPane) loader.load();

			// Set mainView overview into the center of root layout.
			rootLayout.setCenter(mainView);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 *
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(final String[] args) {
		launch(args);
	}
}