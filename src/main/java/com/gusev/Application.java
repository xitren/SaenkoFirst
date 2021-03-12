package com.gusev;

import com.gusev.fx.UpperController;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application extends AbstractJavaFxApplicationSupport {

	@Value("${ui.title:Neuromancer}")//
	private String windowTitle;

	@Qualifier("crm")
	@Autowired
	private ControllersConfiguration.ViewHolder view;

	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		stage.setTitle(windowTitle);
		stage.setScene(new Scene(view.getView()));
		stage.setResizable(true);
		stage.setMaximized(true);
		stage.centerOnScreen();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
				System.exit(0);
			}
		});
		stage.show();
	}

	public static void main(String[] args) {
		launchApp(Application.class, args);
	}

}
