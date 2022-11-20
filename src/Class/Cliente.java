package Class;

public class Cliente
{
    private String nome;
    private int tel;
    private int nascimento;
    private String email;
    private String endereco;
    private int cpf;
    private int id;
    private String sexo;
    private String nacionalidade;
    private String treino;

    public Cliente(String nome, int tel, int nascimento, String email, String endereco, int cpf, int id, String sexo, String nacionalidade, String treino)
    {
        this.nome = nome;
        this.tel = tel;
        this.nascimento = nascimento;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
        this.id = id;
        this.sexo = sexo;
        this.nacionalidade = nacionalidade;
        this.treino = treino;
    }

    public Cliente()
    {

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
    public int getnascimento()
    {
        return nascimento;
    }
    public void setnascimento(int nascimento)
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

    public int getNascimento()
    {
        return nascimento;
    }

    public void setNascimento(int nascimento)
    {
        this.nascimento = nascimento;
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

}



