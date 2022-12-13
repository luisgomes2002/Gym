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


public class ListaFuncionariosController implements Initializable
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
    private Button bntDeExcluir;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField cargoEdit;

    @FXML
    private TextField emailEdit;

    @FXML
    private TextField enderecoEdit;

    @FXML
    private TextField idEdit;

    @FXML
    private TextField salarioEdit;

    @FXML
    private TextField telEdit;

    
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
    void excluirFuncionario(ActionEvent event)
    {
        String query = "DELETE FROM funcionario WHERE id = " + idEdit.getText() + "";
    	executeQuery(query);
    	showFuncionario();
    }

    private void executeQuery(String query)
    {
		Connection c = getConnection();
		Statement st;
		try
		{
			st = c.createStatement();
			st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

    @FXML
    void editarFuncionario(ActionEvent event)
    {
    	try
    	{
    		Driver driver = new Driver();
    		DriverManager.registerDriver(driver);
    		
    		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
    		
    		PreparedStatement stmt = c.prepareStatement("UPDATE gymdatabase.funcionario SET telefone = ?, email = ?, endereco = ?, cargo = ?, salario = ? WHERE id = ?");
    		
    		stmt.setString(1, telEdit.getText());//番号　do krl
    		stmt.setString(2, emailEdit.getText());
    		stmt.setString(3, enderecoEdit.getText());
    		stmt.setString(4, cargoEdit.getText());
            stmt.setString(5, salarioEdit.getText());//sa porra esta pedindo salario e o numero 
    		stmt.setString(6, idEdit.getText());
    		
    		int rowsAffected = stmt.executeUpdate();
    		
    		if(rowsAffected > 0)
    		{
    			System.out.println("Mudou");
    		}
    		else
    		{
    			System.out.println("AAAAAAAAAAA");
    		}
    		
    		showFuncionario();

            telEdit.setText("");
            emailEdit.setText("");
            enderecoEdit.setText("");
            cargoEdit.setText("");
            salarioEdit.setText("");
            idEdit.setText("");	
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
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