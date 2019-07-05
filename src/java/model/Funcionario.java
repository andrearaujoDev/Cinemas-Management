package model;

public class Funcionario {
    private int id_funcionario;
    private String nome;
    private String data_nasc;
    private String funcao;
    private String num_car_trab;
    private String problema_de_saude;
    private float salario;
    
    public Funcionario(){
        
    }

    public Funcionario(String nome, String data_nasc, String funcao, String num_car_trab, String problema_de_saude, float salario) {
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.funcao = funcao;
        this.num_car_trab = num_car_trab;
        this.problema_de_saude = problema_de_saude;
        this.salario = salario;
    }
    
    
    
    public Funcionario(int id_funcionario, String nome, String data_nasc, String funcao, String num_car_trab, String problema_de_saude, float salario) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.funcao = funcao;
        this.num_car_trab = num_car_trab;
        this.problema_de_saude = problema_de_saude;
        this.salario = salario;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNum_car_trab() {
        return num_car_trab;
    }

    public void setNum_car_trab(String num_car_trab) {
        this.num_car_trab = num_car_trab;
    }

    public String getProblema_de_saude() {
        return problema_de_saude;
    }

    public void setProblema_de_saude(String problema_de_saude) {
        this.problema_de_saude = problema_de_saude;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    
}
