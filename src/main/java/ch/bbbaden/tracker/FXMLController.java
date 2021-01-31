package ch.bbbaden.tracker;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {

    WebScraper w = new WebScraper();
    serializer s = new serializer();
    ObservableMap<String, Product> trackedProducts =s.productSerializeDataIn();

    @FXML
    private Button button;
    @FXML
    private TextField txtUrlInput;
    @FXML
    private ListView<?> lstvProducts;
    @FXML
    private TableView<Product> tblView;
    @FXML
    private TableColumn<Product, String> columnName;
    
    @FXML
    private TableColumn<Product, LocalDate> columnStartDate;

    @FXML
    private void addProduct(ActionEvent event) {
        String url = txtUrlInput.getText();

        if (trackedProducts.containsKey(url)) {
            System.out.println("This Product is already tracked");
        } else {
            trackedProducts.put(url, new Product(w.getName(url)));
        }

    }

    @FXML
    private void show(ActionEvent event) {
        printAllTrackedProducts();
    }

    @FXML
    private void scrapeData(ActionEvent event) {
        update();
    }

    public void printAllTrackedProducts() {
        //clear consoler
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }

        Product product;
        for (Map.Entry<String, Product> entry : trackedProducts.entrySet()) {
            product = entry.getValue();

            System.out.println("====================");
            System.out.println("====================");
            System.out.println("====================");
            System.out.println(product.getName());

            for (Snapshot snapshot : product.getProductSnapshotList()) {
                System.out.println("Preis: " + snapshot.price + "/// Zeit: " + snapshot.getTime());
            }

        }
    }

    public void update() {
        Product product;
        for (Map.Entry<String, Product> entry : trackedProducts.entrySet()) {
            product = entry.getValue();

            product.getProductSnapshotList().add(new Snapshot(w.getCurrentPrice(entry.getKey()), System.currentTimeMillis()));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void saveProducts(ActionEvent event) {
        s.productSerializeDataOut(trackedProducts);
    }

}
