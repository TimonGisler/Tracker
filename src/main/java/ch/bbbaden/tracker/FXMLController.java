package ch.bbbaden.tracker;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {

    WebScraper w = new WebScraper();
    HashMap<String, Product> trackedProducts = new HashMap<String, Product>();

    @FXML
    private Button button;
    @FXML
    private TextField txtUrlInput;

    @FXML
    private void addProduct(ActionEvent event) {
        String url = txtUrlInput.getText();

        System.out.println("You clicked me!");

        trackedProducts.put(url, new Product(w.getName(url, false)));

    }

    public void update() {
        Product product;
        for (Map.Entry<String, Product> entry : trackedProducts.entrySet()) {
            product = entry.getValue();
            
            
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
