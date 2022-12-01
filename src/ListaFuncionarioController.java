import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import com.mysql.cj.jdbc.Driver;

import Class.Cliente;
import Class.Funcionario;
import Class.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ListaFuncionarioController implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<Funcionario, Integer> ID;
    
    @FXML
    private TableColumn<Funcionario, String> cargo;

    @FXML
    private TableColumn<Funcionario, Integer> cpf;

    @FXML
    private TableColumn<Funcionario, String> email;

    @FXML
    private TableColumn<Funcionario, String> endereco;

    @FXML
    private TableColumn<Funcionario, String> nacionalidade;

    @FXML
    private TableColumn<Funcionario, String> nascimento;

    @FXML
    private TableColumn<Funcionario, String> nome;

    @FXML
    private TableColumn<Funcionario, String> salario;

    @FXML
    private TableColumn<Funcionario, String> sexo;

    @FXML
    private TableColumn<Funcionario, Integer> telefone;
    
    @FXML
    private TableView<Funcionario> tableViewFuincionarios;
    
    @FXML
    private TextField barraDePesquisa;

    @FXML
    private Button bntDeExcluir;

    @FXML
    private Button bntDePesquisa;

    @FXML
    private Button btnVoltar;
    

    public Connection getConnection()
    {
    	Connection c;
    	try
		{
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
			return c;		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
    	
    }
    
    public ObservableList<Funcionario> getFuncionarioList()
    {
		ObservableList<Funcionario> funcionarioList = FXCollections.observableArrayList();
    	Connection c = getConnection();
    	String query = "SELECT * FROM funcionario";
    	Statement stmt;
    	ResultSet rs;
    	
    	try
    	{
    		stmt = c.createStatement();
    		rs = stmt.executeQuery(query);   
    		Funcionario funcionario;
    		
    		while(rs.next())
    		{
    			funcionario = new Funcionario(rs.getInt("id"), 
    					rs.getString("nome"),
    					rs.getInt("telefone"), 
    					rs.getString("nascimento"), 
    					rs.getString("email"), 
    					rs.getString("endereco"),
    					rs.getInt("cpf"),
    					rs.getString("sexo"), 
    					rs.getString("nascionalidade"), 
    					rs.getString("cargo"),
    					rs.getString("salario"));
    			
    			funcionarioList.add(funcionario);
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return funcionarioList;
    }

    public void showFuncionario()
    {
		ObservableList<Funcionario> list = getFuncionarioList();
	
		ID.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("id"));
		nome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
		telefone.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("tel"));
		nascimento.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nascimento"));
		email.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("email"));
		endereco.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("endereco"));
		cpf.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("cpf"));
		sexo.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("sexo"));
		nacionalidade.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nacionalidade"));
		cargo.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cargo"));
		salario.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("salario"));
		
		tableViewFuincionarios.setItems(list);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
    	showFuncionario();
    }
    
    @FXML
    void excluirCliente(ActionEvent event)
    {
        
    }

    @FXML
    void pesquisarFuncionario(ActionEvent event)
    {
        
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
