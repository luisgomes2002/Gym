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
        Parent root = FXMLLoader.load(getClass().getResource("GymApp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void casdastraClien(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("CadrastroCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void casdastraFunci(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("CadastroFuncionario.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void excluir(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Excluir.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void listClient(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ListaClientes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void listFunc(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ListaFuncionarios.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void listTreino(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ListaDeTreino.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void unicClienFunc(ActionEvent event) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("UnicoCF.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sair(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 440, 350);
        stage.setScene(scene);
        stage.show();
    }
}
