package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.ModelManager;

public class MainTab extends BorderPane
{
  public MainTab(ModelManager model)
  {
    // Big tab container
    TabPane tabPane = new TabPane();

    // Create each tab using your existing tab classes
    Tab usersTab = new UsersTab(model).getTab();
    Tab tasksTab = new TasksTab(model).getTab();
    Tab tradesTab = new TradesTab(model).getTab();
    Tab greenTasksTab = new GreenTasksTab(model).getTab();

    // Add them into the main pane
    tabPane.getTabs().addAll(usersTab, tasksTab, tradesTab, greenTasksTab);

    // Attach to layout
    this.setCenter(tabPane);
  }
}
