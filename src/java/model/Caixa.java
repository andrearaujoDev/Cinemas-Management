package model;

public class Caixa {
    private int id_caixa;
    private Funcionario funcionario = new Funcionario();
    private Sessao sessao = new Sessao();
    private int ingressos_vendidos;
    private float valor_total;
    
    public Caixa(){
        
    }

    public Caixa(int ingressos_vendidos, float valor_total) {
        this.ingressos_vendidos = ingressos_vendidos;
        this.valor_total = valor_total;
    }

    public Caixa(int id_caixa, int ingressos_vendidos, float valor_total) {
        this.id_caixa = id_caixa;
        this.ingressos_vendidos = ingressos_vendidos;
        this.valor_total = valor_total;
    }

    public int getId_caixa() {
        return id_caixa;
    }

    public void setId_caixa(int id_caixa) {
        this.id_caixa = id_caixa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public int getIngressos_vendidos() {
        return ingressos_vendidos;
    }

    public void setIngressos_vendidos(int ingressos_vendidos) {
        this.ingressos_vendidos = ingressos_vendidos;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }
}
