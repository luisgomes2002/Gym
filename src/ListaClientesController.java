import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ListaClientesController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField barraDePesquisa;

    @FXML
    private Button bntDeExcluir;

    @FXML
    private Button bntDePesquisa;

    @FXML
    private Button btnVoltar;

    @FXML
    void swichToGymApp(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("GymApp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

}

