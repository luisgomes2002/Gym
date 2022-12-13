package Class;

public class Cliente
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
    private String treino;
    public String peso;
    public String altura;   
    private String foco;

    public Cliente(int id, String nome, int tel, String nascimento, String email, String endereco, int cpf, String sexo, String nacionalidade, String treino, String peso, String altura, String foco)
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
        this.treino = treino;
        this.peso = peso;
        this.altura = altura;
        this.foco = foco;
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

    public String getTreino()
    {
        return treino;
    }

    public void setTreino(String treino)
    {
        this.treino = treino;
    }

    public String getPeso()
    {
        return peso;
    }

    public void setPeso(String peso)
    {
        this.peso = peso;
    }

    public String getAltura()
    {
        return altura;
    }

    public void setAltura(String altura)
    {
        this.altura = altura;
    }

    public String getFoco()
    {
        return foco;
    }

    public void setFoco(String foco)
    {
        this.foco = foco;
    }
}
