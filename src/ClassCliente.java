public class ClassCliente
{
    private String nome;
    private int tel;
    private int idade;
    private String email;
    private String endereco;
    private int cpf;

    public ClassCliente(String nome, int tel, int idade, String email, String endereco, int cpf)
    {
        this.nome = nome;
        this.tel = tel;
        this.idade = idade;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public ClassCliente()
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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel)
    {
        this.tel = tel;
    }

    public int getIdade()
    {
        return idade;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
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
    
}



