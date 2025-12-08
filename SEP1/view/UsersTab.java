package view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.*;

import java.util.List;

public class UsersTab {
  private final ModelManager model;

  public UsersTab(ModelManager model) {
    this.model = model;
  }

  public Tab getTab() {
    Tab tab = new Tab("Users");
    tab.setClosable(false);

    // Table
    TableView<User> table = new TableView<>();
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    TableColumn<User, String> nameCol = new TableColumn<>("Name");
    nameCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getName()));

    TableColumn<User, Number> balanceCol = new TableColumn<>("Balance");
    balanceCol.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getBalance()));

    TableColumn<User, Boolean> activityCol = new TableColumn<>("Active");
    activityCol.setCellValueFactory(c -> new javafx.beans.property.SimpleBooleanProperty(c.getValue().getActivity()));

    TableColumn<User, Number> boostCol = new TableColumn<>("Boost %");
    boostCol.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getBoost()));

    table.getColumns().addAll(nameCol, balanceCol, activityCol, boostCol);

    // Controls
    TextField nameField = new TextField(); nameField.setPromptText("Name");
    TextField balanceField = new TextField(); balanceField.setPromptText("Balance");
    CheckBox activeBox = new CheckBox("Active");
    TextField boostField = new TextField(); boostField.setPromptText("Boost %");

    Button addBtn = new Button("Add User");
    addBtn.setOnAction(e -> {
      try {
        String name = nameField.getText().trim();
        int balance = Integer.parseInt(balanceField.getText().trim());
        boolean active = activeBox.isSelected();
        int boost = Integer.parseInt(boostField.getText().trim());

        if (name.isEmpty()) return;

        model.addUser(new User(name, balance, active, boost));
        refreshTable(table);
        nameField.clear(); balanceField.clear(); activeBox.setSelected(false); boostField.clear();
      } catch (Exception ex) {
        showAlert("Input error", "Balance and Boost must be integers.");
      }
    });

    Button removeBtn = new Button("Remove Selected");
    removeBtn.setOnAction(e -> {
      User sel = table.getSelectionModel().getSelectedItem();
      if (sel != null) {
        model.removeUser(sel.getName());
        refreshTable(table);
      }
    });

    HBox controls = new HBox(8, nameField, balanceField, activeBox, boostField, addBtn, removeBtn);
    controls.setPadding(new Insets(10));

    VBox root = new VBox(8, table, controls);
    root.setPadding(new Insets(10));

    refreshTable(table);

    tab.setContent(root);
    return tab;
  }

  private void refreshTable(TableView<User> table) {
    UserList ul = model.getAllUsers();
    // requires UserList to provide getAll() returning List<User>
    List<User> list = ul.getAll(); // ensure you added getAll() to UserList
    table.setItems(FXCollections.observableArrayList(list));
  }

  private void showAlert(String title, String message) {
    Alert a = new Alert(Alert.AlertType.INFORMATION);
    a.setTitle(title);
    a.setHeaderText(null);
    a.setContentText(message);
    a.showAndWait();
  }
}
