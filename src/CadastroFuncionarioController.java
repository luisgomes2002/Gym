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

public class CadastroFuncionarioController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField CargoFuncionario;

    @FXML
    private Button bntVoltar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField cpfFunc;

    @FXML
    private TextField emailFunci;

    @FXML
    private TextField enderecoFuncio;

    @FXML
    private TextField nacionalidadeFunc;

    @FXML
    private TextField nascimentoFunci;

    @FXML
    private TextField nomeFunci;

    @FXML
    private TextField salarioFuncionario;

    @FXML
    private TextField sexoFunc;

    @FXML
    private TextField telefFunc;

    @FXML
    void fazerCadastroFuncionario(ActionEvent event)
    {
        try
        {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
            PreparedStatement stmt = c.prepareStatement("INSERT INTO gymdatabase.funcionario (nome,"
            		+ " nascimento, "
            		+ "cpf, "
            		+ "endereco, "
            		+ "email, telefone, "
            		+ "sexo, "
            		+ "nascionalidade, "
            		+ "cargo, "
            		+ "salario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, nomeFunci.getText());
            stmt.setString(2, nascimentoFunci.getText());
            stmt.setString(3, cpfFunc.getText());
            stmt.setString(4, enderecoFuncio.getText());
            stmt.setString(5, emailFunci.getText());
            stmt.setString(6, telefFunc.getText());
            stmt.setString(7, sexoFunc.getText());
            stmt.setString(8, nacionalidadeFunc.getText());
            stmt.setString(9, CargoFuncionario.getText());
            stmt.setString(10, salarioFuncionario.getText());

            int rowsAffected = stmt.executeUpdate();
            
            if(rowsAffected > 0) 
            {
           	 System.out.println("Usuario codastrado em!!!");
            }
            else
            {
           	 System.out.println("Foi n em!!!");
            }
            
            nomeFunci.setText("");
            nascimentoFunci.setText("");
            cpfFunc.setText("");
            enderecoFuncio.setText("");
            emailFunci.setText("");
            telefFunc.setText("");
            sexoFunc.setText("");
            nacionalidadeFunc.setText("");
            CargoFuncionario.setText("");
            salarioFuncionario.setText("");
        
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
            System.out.println("Erro na conexao com o banco de dados");
        }
    }

    
    @FXML
    void swichToGymApp(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/GymApp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();    
    }

}
