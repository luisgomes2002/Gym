import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class CadastroClienteController
{  
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button btnCadastrarCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    void fazerCadastroCliente(ActionEvent event)
    {
        try
        {
            Connection con;
            Statement st;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastrocliente","root","");
            st = (Statement) con.createStatement();
            ((java.sql.Statement) st).executeUpdate("Insert into cliente values('" + nomeCliente.getText() + "')");
            nomeCliente.setText("");
            nomeCliente.requestFocus();
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("O diver nao esta na biblioteca");
        }
        catch(SQLException ex)
        {
            System.out.println("Erro na conexap com o banco de dados");
        }

    }
    

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
}
