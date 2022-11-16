import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    private Button bntVoltar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField nomeCliente;

    @FXML
    void fazerCadastroCliente(ActionEvent event)
    {
        Connection conexao = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastrocliente","root","");
            ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM cliente");
            
            nomeCliente.setText("");
            while(rsCliente.next())
            {
                System.out.println("Nome: " + rsCliente.getString("nome"));
            }
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

}
