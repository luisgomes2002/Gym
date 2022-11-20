

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class GymAppController
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    

    public void swichToGymApp(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/GymApp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void casdastraClien(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/CadrastroCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void casdastraFunci(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/CadastroFuncionario.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void listClient(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/ListaClientes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void listFunc(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/ListaFuncionarios.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void listTreino(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/ListaDeTreino.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sair(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 440, 350);
        stage.setScene(scene);
        stage.show();
    }
}
