package Class;

public class Funcionario
{	//variaveis
	private int id;
    private String nome;
    private int tel;
    private String nascimento;
    private String email;
    private String endereco;
    private int cpf;
    private String sexo;
    private String nacionalidade;
    private String cargo;
    private String salario;
	private String login;
    private String senha;

	public Funcionario(int id, String nome, int tel, String nascimento, String email, String endereco, int cpf,
	String sexo, String nacionalidade, String cargo, String salario, String login, String senha)
	{
		this.id = id;
		this.nome = nome;
		this.tel = tel;
		this.nascimento = nascimento;
		this.email = email;
		this.endereco = endereco;
		this.cpf = cpf;
		this.sexo = sexo;
		this.nacionalidade = nacionalidade;
		this.cargo = cargo;
		this.salario = salario;
		this.login = login;
		this.senha = senha;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public int getTel()
	{
		return tel;
	}

	public void setTel(int tel)
	{
		this.tel = tel;
	}

	public String getNascimento()
	{
		return nascimento;
	}

	public void setNascimento(String nascimento)
	{
		this.nascimento = nascimento;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEndereco()
	{
		return endereco;
	}

	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}

	public int getCpf()
	{
		return cpf;
	}

	public void setCpf(int cpf)
	{
		this.cpf = cpf;
	}

	public String getSexo()
	{
		return sexo;
	}

	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}

	public String getNacionalidade()
	{
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade)
	{
		this.nacionalidade = nacionalidade;
	}

	public String getCargo()
	{
		return cargo;
	}

	public void setCargo(String cargo)
	{
		this.cargo = cargo;
	}

	public String getSalario()
	{
		return salario;
	}

	public void setSalario(String salario)
	{
		this.salario = salario;
	}
    
	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	
}
    
    