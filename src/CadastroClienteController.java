import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class CadastroClienteController extends LoginController
{  
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button bntVoltar;

    @FXML
    private Button btnCadastrar;

	@FXML
	private TextField cpfCliente;

    @FXML
    private TextField emailCliente;

    @FXML
    private TextField enderecoCliente;

    @FXML
    private TextField nacionalidadeCliente;

    @FXML
    private TextField nascimentoCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TextField sexoCliente;

    @FXML
    private TextField telefCliente;

    @FXML
    private TextField tipoTreinoCliente;

    @FXML
    void fazerCadastroCliente(ActionEvent event) throws SQLException
    {       
    	try
        {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
            PreparedStatement stmt = c.prepareStatement("INSERT INTO gymdatabase.cliente (nome, "
                + "nascimento, "
                + "cpf, "
                + "endereco,"
                + "email, "
                + "telefone, "
                + "sexo, "
                + "nascionalidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, nomeCliente.getText());
            stmt.setString(2, nascimentoCliente.getText());
            stmt.setString(3, cpfCliente.getText());
            stmt.setString(4, enderecoCliente.getText());
            stmt.setString(5, emailCliente.getText());
            stmt.setString(6, telefCliente.getText());
            stmt.setString(7, sexoCliente.getText());
            stmt.setString(8, nacionalidadeCliente.getText());
            
            int rowsAffected = stmt.executeUpdate();
            
            if(rowsAffected > 0) 
            {
                System.out.println("Usuario codastrado em!!!");
            }
            else
            {
                System.out.println("Foi n em!!!");
            }
            
            nomeCliente.setText("");
            nascimentoCliente.setText("");
            cpfCliente.setText("");
            enderecoCliente.setText("");
            emailCliente.setText("");
            telefCliente.setText("");
            sexoCliente.setText("");
            nacionalidadeCliente.setText("");
            tipoTreinoCliente.setText("");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Erro na conexao com o banco de dados, fazerCadastroCliente");
        }
    }

    @FXML
    void swichToGymApp(ActionEvent event) throws IOException
    { 
        root = FXMLLoader.load(getClass().getResource("interface/GymApp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);  
        stage.setScene(scene);
        stage.show();    
    }
}