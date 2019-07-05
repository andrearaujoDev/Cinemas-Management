package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Filme;
import util.Conexao;

public class Controle_Filme {
    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    
    public boolean inserir(Filme filme){
        sSQL = "insert into filme (nome,genero,duracao_em_minutos,data_lancamento,produtora,classificacao)" + 
                    "values(?,?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, filme.getNome());
            pst.setString(2, filme.getGenero());
            pst.setString(3, filme.getDuracao_em_minutos());
            pst.setString(4, filme.getData_lancamento());
            pst.setString(5, filme.getProdutora());
            pst.setString(6, filme.getClassificacao());
                       
            int n = pst.executeUpdate();
            if(n != 0){
                return true;
            }else{
                return false;
            }
            
        }catch(Exception e){
            System.out.println("Erro : " + e.getMessage());
            return false;
        }
    }
    
    public boolean editar(Filme filme,int id_filme){
        sSQL = "update filme set nome=?,genero=?,duracao_em_minutos=?,data_lancamento=?,produtora=?,classificacao=?"
                + "where id_filme = ?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, filme.getNome());
            pst.setString(2, filme.getGenero());
            pst.setString(3, filme.getDuracao_em_minutos());
            pst.setString(4, filme.getData_lancamento());
            pst.setString(5, filme.getProdutora());
            pst.setString(6, filme.getClassificacao());
            pst.setInt(7, id_filme);
            
            int n = pst.executeUpdate();
            if(n != 0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            System.out.println("Erro : " + e.getMessage());
            return false;
        }
     }
    
    public boolean deletar(int id_filme){
        sSQL = "delete from filme where id_filme=?";
        try{
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, id_filme);
            
            this.desabilitarCheckForeign();
            int n = pst.executeUpdate();
            this.HabilitaCheckForeign();
            if(n != 0){
                return true;
            }else{
                return false;
            }
        
        }catch(Exception e){
            System.out.println("Erro : " + e.getMessage());
            return false;
        }
    }
    
     public ArrayList<Filme> selecionarTodos(){
        Conexao con = new Conexao();
        String sql = "select * from filme";
        ArrayList<Filme> modelo = new ArrayList<Filme>();
        try{
            PreparedStatement sentenca = con.conectar().prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            
            while (rs.next()){
                Filme filme = new Filme();
                filme.setId_filme(rs.getInt("id_filme"));
                filme.setNome(rs.getString("nome"));
                filme.setGenero(rs.getString("genero"));
                filme.setDuracao_em_minutos(rs.getString("duracao_em_minutos"));
                filme.setData_lancamento(rs.getString("data_lancamento"));
                filme.setProdutora(rs.getString("produtora"));           
                filme.setClassificacao(rs.getString("classificacao"));
                modelo.add(filme);
            }
        }catch(SQLException e){
            System.out.println("Erro : " + e.getMessage());
        }
        return modelo;
    }
     
    public void desabilitarCheckForeign() {
        sSQL = "SET foreign_key_checks = 0";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.executeQuery();
        }catch(Exception e){
            System.out.println("Erro : " + e.getMessage());
        }
    }
    
    public void HabilitaCheckForeign() {
        sSQL = "SET foreign_key_checks = 1";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.executeQuery();
        }catch(Exception e){
            System.out.println("Erro : " + e.getMessage());
        }
    } 
}
