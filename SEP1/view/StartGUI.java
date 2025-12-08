package view; // or the correct package for StartGUI

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import model.ModelManager;

// IMPORT YOUR TABS
import view.UsersTab;
import view.TasksTab;
import view.TradesTab;
import view.GreenTasksTab;

public class StartGUI extends Application {

  public void start(Stage stage) {
    ModelManager model = new ModelManager(
        "users.xml",
        "tasks.xml",
        "greentasks.xml",
        "trades.xml"
    );

    TabPane tabs = new TabPane();
    tabs.getTabs().add(new UsersTab(model).getTab());
    tabs.getTabs().add(new TasksTab(model).getTab());
    tabs.getTabs().add(new TradesTab(model).getTab());
    tabs.getTabs().add(new GreenTasksTab(model).getTab());

    Scene scene = new Scene(tabs, 800, 600);
    stage.setScene(scene);
    stage.setTitle("Bob's System");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
