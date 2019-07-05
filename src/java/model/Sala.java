package model;

public class Sala {
    private int id_sala;
    private String nome;
    private String tipo_de_sala;
    private String status_sala;
    private int capacidade_maxima;
    private String som;
    private String video;
    
    public Sala(){
        
    }

    public Sala(String nome, String tipo_de_sala, String status_sala, int capacidade_maxima, String som, String video) {
        this.nome = nome;
        this.tipo_de_sala = tipo_de_sala;
        this.status_sala = status_sala;
        this.capacidade_maxima = capacidade_maxima;
        this.som = som;
        this.video = video;
    }
    
    

    public Sala(int id_sala, String nome, String tipo_de_sala, String status_sala, int capacidade_maxima, String som, String video) {
        this.id_sala = id_sala;
        this.nome = nome;
        this.tipo_de_sala = tipo_de_sala;
        this.status_sala = status_sala;
        this.capacidade_maxima = capacidade_maxima;
        this.som = som;
        this.video = video;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_de_sala() {
        return tipo_de_sala;
    }

    public void setTipo_de_sala(String tipo_de_sala) {
        this.tipo_de_sala = tipo_de_sala;
    }

    public String getStatus_sala() {
        return status_sala;
    }

    public void setStatus_sala(String status_sala) {
        this.status_sala = status_sala;
    }

    public int getCapacidade_maxima() {
        return capacidade_maxima;
    }

    public void setCapacidade_maxima(int capacidade_maxima) {
        this.capacidade_maxima = capacidade_maxima;
    }

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
