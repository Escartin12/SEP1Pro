package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

public class GreenTasksTab {

  private ModelManager model;

  public GreenTasksTab(ModelManager model) {
    this.model = model;
  }

  public Tab getTab() {
    Tab tab = new Tab("Green Tasks");

    TableView<GreenTask> table = new TableView<>();

    TableColumn<GreenTask, String> descCol = new TableColumn<>("Description");
    descCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getDescription()));

    TableColumn<GreenTask, Number> rewardCol = new TableColumn<>("Reward");
    rewardCol.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getReward()));

    table.getColumns().addAll(descCol, rewardCol);

    refresh(table);

    TextField descField = new TextField();
    descField.setPromptText("Description");

    TextField rewardField = new TextField();
    rewardField.setPromptText("Reward");

    Button addBtn = new Button("Add Green Task");
    addBtn.setOnAction(e -> {
      try {
        String d = descField.getText();
        int r = Integer.parseInt(rewardField.getText());
        model.addGreenTask(new GreenTask(d, r));
        refresh(table);
        descField.clear();
        rewardField.clear();
      } catch (Exception ex) { }
    });

    Button removeBtn = new Button("Remove Selected");
    removeBtn.setOnAction(e -> {
      GreenTask selected = table.getSelectionModel().getSelectedItem();
      if (selected != null) {
        model.removeGreenTask(selected.getDescription());
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

  private void refresh(TableView<GreenTask> table) {
    ObservableList<GreenTask> list =
        FXCollections.observableArrayList(model.getAllGreenTasks().getAll());
    table.setItems(list);
  }
}
