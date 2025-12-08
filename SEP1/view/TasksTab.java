package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import model.ModelManager;

public class TasksTab {

  private ModelManager model;

  public TasksTab(ModelManager model) {
    this.model = model;
  }

  public Tab getTab() {
    Tab tab = new Tab("Tasks");

    TableView<Task> table = new TableView<>();

    TableColumn<Task, String> descCol = new TableColumn<>("Description");
    descCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getDescription()));

    TableColumn<Task, Number> rewardCol = new TableColumn<>("Reward");
    rewardCol.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getReward()));

    table.getColumns().addAll(descCol, rewardCol);

    refresh(table);

    TextField descField = new TextField();
    descField.setPromptText("Description");

    TextField rewardField = new TextField();
    rewardField.setPromptText("Reward");

    Button addBtn = new Button("Add Task");
    addBtn.setOnAction(e -> {
      try {
        String d = descField.getText();
        int r = Integer.parseInt(rewardField.getText());
        model.addTask(new Task(d, r));
        refresh(table);
        descField.clear();
        rewardField.clear();
      } catch (Exception ex) {
        System.out.println("Invalid input");
      }
    });

    Button removeBtn = new Button("Remove Selected");
    removeBtn.setOnAction(e -> {
      Task selected = table.getSelectionModel().getSelectedItem();
      if (selected != null) {
        model.removeTask(selected.getDescription());
        refresh(table);
      }
    });

    HBox input = new HBox(10, descField, rewardField, addBtn, removeBtn);
    VBox root = new VBox(10, table, input);
    root.setPadding(new Insets(10));

    tab.setContent(root);
    tab.setClosable(false);
    return tab;
  }

  private void refresh(TableView<Task> table)
  {
    ObservableList<Task> list = FXCollections.observableArrayList(
        model.getAllTasks().getAll());
    table.setItems(list);
  }

}
