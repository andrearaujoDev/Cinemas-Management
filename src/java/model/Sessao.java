package model;

public class Sessao {
    private int id_sessao;
    private String nome;
    private Sala sala = new Sala();
    private Filme filme = new Filme();
    private Funcionario funcionario = new Funcionario();
    private String data_sessao;
    private String horario_sessao;
    private float valor_sessao;
    
    public Sessao(){
        
    }

    public Sessao(String nome, String data_sessao, String horario_sessao, float valor_sessao) {
        this.nome = nome;
        this.data_sessao = data_sessao;
        this.horario_sessao = horario_sessao;
        this.valor_sessao = valor_sessao;
    }

    public Sessao(int id_sessao,String nome , String data_sessao, String horario_sessao, float valor_sessao) {
        this.id_sessao = id_sessao;
        this.nome = nome;
        this.data_sessao = data_sessao;
        this.horario_sessao = horario_sessao;
        this.valor_sessao = valor_sessao;
    }

    public int getId_sessao() {
        return id_sessao;
    }

    public void setId_sessao(int id_sessao) {
        this.id_sessao = id_sessao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getData_sessao() {
        return data_sessao;
    }

    public void setData_sessao(String data_sessao) {
        this.data_sessao = data_sessao;
    }

    public String getHorario_sessao() {
        return horario_sessao;
    }

    public void setHorario_sessao(String horario_sessao) {
        this.horario_sessao = horario_sessao;
    }

    public float getValor_sessao() {
        return valor_sessao;
    }

    public void setValor_sessao(float valor_sessao) {
        this.valor_sessao = valor_sessao;
    }
    
    
    
    
}
