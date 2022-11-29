package Class;

public class Funcionario
{
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
    private float salaro;
    
    public Funcionario(int id, String nome, int tel, String nascimento, String email, String endereco, int cpf, String sexo, String nacionalidade, String cargo, float salario)
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
        this.salaro = salario;
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
	
	public float getSalaro()
	{
		return salaro;
	}
	
	public void setSalaro(float salaro)
	{
		this.salaro = salaro;
	}
	
}