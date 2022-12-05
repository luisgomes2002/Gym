import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import Class.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class ListaFuncionarioController implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<Funcionario, String> Cargo;

    @FXML
    private TableColumn<Funcionario, Integer> Cpf;

    @FXML
    private TableColumn<Funcionario, String> Email;

    @FXML
    private TableColumn<Funcionario, String> Endereco;

    @FXML
    private TableColumn<Funcionario, Integer> ID;

    @FXML
    private TableColumn<Funcionario, String> Nacionalidade;

    @FXML
    private TableColumn<Funcionario, String> Nascimento;

    @FXML
    private TableColumn<Funcionario, String> Nome;

    @FXML
    private TableColumn<Funcionario, String> Salario;

    @FXML
    private TableColumn<Funcionario, String> Sexo;

    @FXML
    private TableColumn<Funcionario, Integer> Telefone;
    
    @FXML
    private TableView<Funcionario> tableViewFuncionarios;

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
		Nome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
		Telefone.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("tel"));
		Nascimento.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nascimento"));
		Email.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("email"));
		Endereco.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("endereco"));
		Cpf.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("cpf"));
		Sexo.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("sexo"));
		Nacionalidade.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nacionalidade"));
		Cargo.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cargo"));
		Salario.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("salario"));//float mudar
		
		tableViewFuncionarios.setItems(list);
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
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    

}
