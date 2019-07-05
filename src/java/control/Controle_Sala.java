package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Sala;
import util.Conexao;


public class Controle_Sala {
    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    
    public boolean inserir(Sala sala){
        sSQL = "insert into sala (nome,tipo_de_sala,status_sala,capacidade_maxima,som,video)" + 
                    "values(?,?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, sala.getNome());
            pst.setString(2, sala.getTipo_de_sala());
            pst.setString(3, sala.getStatus_sala());
            pst.setInt(4, sala.getCapacidade_maxima());
            pst.setString(5, sala.getSom());
            pst.setString(6, sala.getVideo());
                       
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
    
    public boolean editar(Sala sala,int id_sala){
        sSQL = "update sala set nome=?,tipo_de_sala=?,status_sala=?,capacidade_maxima=?,som=?,video=?"
                + "where id_sala = ?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, sala.getNome());
            pst.setString(2, sala.getTipo_de_sala());
            pst.setString(3, sala.getStatus_sala());
            pst.setInt(4, sala.getCapacidade_maxima());
            pst.setString(5, sala.getSom());
            pst.setString(6, sala.getVideo());
            pst.setInt(7, id_sala);
            
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
    
    public boolean deletar(int id_sala){
        sSQL = "delete from sala where id_sala=?";
        try{
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, id_sala);
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
    
     public ArrayList<Sala> selecionarTodos(){
        Conexao con = new Conexao();
        String sql = "select * from sala";
        ArrayList<Sala> modelo = new ArrayList<Sala>();
        try{
            PreparedStatement sentenca = con.conectar().prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            
            while (rs.next()){
                Sala sala = new Sala();
                sala.setId_sala(rs.getInt("id_sala"));
                sala.setNome(rs.getString("nome"));
                sala.setTipo_de_sala(rs.getString("tipo_de_sala"));
                sala.setStatus_sala(rs.getString("status_sala"));
                sala.setCapacidade_maxima(rs.getInt("capacidade_maxima"));           
                sala.setSom(rs.getString("som"));
                sala.setVideo(rs.getString("video"));
                modelo.add(sala);
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
