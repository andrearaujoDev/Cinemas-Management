package model;

public class Filme {
    private int id_filme;
    private String nome;
    private String genero;
    private String duracao_em_minutos;
    private String data_lancamento;
    private String produtora;
    private String classificacao;
    
    public Filme(){
        
    }

    public Filme(String nome, String genero, String duracao_em_minutos, String data_lancamento, String produtora, String classificacao) {
        this.nome = nome;
        this.genero = genero;
        this.duracao_em_minutos = duracao_em_minutos;
        this.data_lancamento = data_lancamento;
        this.produtora = produtora;
        this.classificacao = classificacao;
    }
    
    
    
    public Filme(int id_filme, String nome, String genero, String duracao_em_minutos, String data_lancamento, String produtora, String classificacao) {
        this.id_filme = id_filme;
        this.nome = nome;
        this.genero = genero;
        this.duracao_em_minutos = duracao_em_minutos;
        this.data_lancamento = data_lancamento;
        this.produtora = produtora;
        this.classificacao = classificacao;
    }

    public int getId_filme() {
        return id_filme;
    }

    public void setId_filme(int id_filme) {
        this.id_filme = id_filme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracao_em_minutos() {
        return duracao_em_minutos;
    }

    public void setDuracao_em_minutos(String duracao_em_minutos) {
        this.duracao_em_minutos = duracao_em_minutos;
    }

    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
}
