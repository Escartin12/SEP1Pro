package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

public class TradesTab {

  private ModelManager model;

  public TradesTab(ModelManager model) {
    this.model = model;
  }

  public Tab getTab() {
    Tab tab = new Tab("Trades");

    TableView<TradeOffer> table = new TableView<>();

    TableColumn<TradeOffer, String> descCol = new TableColumn<>("Description");
    descCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getDescription()));

    TableColumn<TradeOffer, Number> priceCol = new TableColumn<>("Price");
    priceCol.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getPrice()));

    TableColumn<TradeOffer, String> sellerCol = new TableColumn<>("Seller");
    sellerCol.setCellValueFactory(c ->
        new javafx.beans.property.SimpleStringProperty(c.getValue().getUser().getName()));

    table.getColumns().addAll(descCol, priceCol, sellerCol);

    refresh(table);

    TextField descField = new TextField();
    descField.setPromptText("Description");

    TextField priceField = new TextField();
    priceField.setPromptText("Price");

    ComboBox<User> userBox = new ComboBox<>();
    userBox.setItems(FXCollections.observableArrayList(model.getAllUsers().getAll()));
    userBox.setPromptText("Select Seller");

    Button addBtn = new Button("Add Offer");
    addBtn.setOnAction(e -> {
      try {
        String d = descField.getText();
        int p = Integer.parseInt(priceField.getText());
        User u = userBox.getValue();
        if (u == null) return;

        model.addTradeOffer(new TradeOffer(d, p, u));
        refresh(table);
        descField.clear();
        priceField.clear();
      } catch (Exception ignored) {}
    });

    Button removeBtn = new Button("Remove Selected");
    removeBtn.setOnAction(e -> {
      TradeOffer t = table.getSelectionModel().getSelectedItem();
      if (t != null) {
        model.removeTradeOffer(t.getDescription());
        refresh(table);
      }
    });

    HBox input = new HBox(10, descField, priceField, userBox, addBtn, removeBtn);
    VBox root = new VBox(10, table, input);
    root.setPadding(new Insets(10));

    tab.setContent(root);
    tab.setClosable(false);
    return tab;
  }

  private void refresh(TableView<TradeOffer> table) {
    ObservableList<TradeOffer> list =
        FXCollections.observableArrayList(model.getAllTradeOffers().getAll());
    table.setItems(list);
  }
}
