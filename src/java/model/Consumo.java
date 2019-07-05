package model;

public class Consumo {
    private int id_consumo;
    private String nome_produto;
    private String nome_bebida;
    private float preco;
    private Funcionario funcionario = new Funcionario();
    
    
    public Consumo(){
        
    }

    public Consumo(String nome_produto, String nome_bebida, float preco) {
        this.nome_produto = nome_produto;
        this.nome_bebida = nome_bebida;
        this.preco = preco;
    }

    public Consumo(int id_consumo, String nome_produto, String nome_bebida, float preco) {
        this.id_consumo = id_consumo;
        this.nome_produto = nome_produto;
        this.nome_bebida = nome_bebida;
        this.preco = preco;
    }

    public int getId_consumo() {
        return id_consumo;
    }

    public void setId_consumo(int id_consumo) {
        this.id_consumo = id_consumo;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getNome_bebida() {
        return nome_bebida;
    }

    public void setNome_bebida(String nome_bebida) {
        this.nome_bebida = nome_bebida;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
