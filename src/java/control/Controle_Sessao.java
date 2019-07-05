package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Filme;
import model.Funcionario;
import model.Sala;
import model.Sessao;
import util.Conexao;

public class Controle_Sessao {
    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    
    public boolean inserir(Sessao sessao){
        sSQL = "insert into sessao (nome,id_sala,id_filme,id_funcionario,data_sessao,horario_sessao,valor_sessao)" + 
                    "values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, sessao.getNome());
            pst.setInt(2, sessao.getSala().getId_sala());
            pst.setInt(3, sessao.getFilme().getId_filme());
            pst.setInt(4, sessao.getFuncionario().getId_funcionario());
            pst.setString(5, sessao.getData_sessao());
            pst.setString(6, sessao.getHorario_sessao());
            pst.setFloat(7, sessao.getValor_sessao());
                       
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
    
    public boolean editar(Sessao sessao,int id_sessao){
        sSQL = "update sessao set nome = ? , id_sala = ? , id_filme = ? , id_funcionario = ? , data_sessao = ? , horario_sessao = ? , valor_sessao = ? "
                + " where id_sessao = ?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, sessao.getNome());
            pst.setInt(2, sessao.getSala().getId_sala());
            pst.setInt(3, sessao.getFilme().getId_filme());
            pst.setInt(4, sessao.getFuncionario().getId_funcionario());
            pst.setString(5, sessao.getData_sessao());
            pst.setString(6, sessao.getHorario_sessao());
            pst.setFloat(7, sessao.getValor_sessao());
            pst.setInt(8, id_sessao);
            
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
    
    public boolean deletar(int id_sessao){
        sSQL = "delete from sessao where id_sessao=?";
        try{
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, id_sessao);
            
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
    
     public ArrayList<Sessao> selecionarTodos(){
        Conexao con = new Conexao();
        String sql = "select sessao.id_sessao,sessao.nome,sala.nome as Sala,filme.nome as Filme,data_sessao,horario_sessao,valor_sessao,funcionario.nome as Funcionario" 
                    + " from (((sessao inner join sala on sessao.id_sala = sala.id_sala) inner join filme on sessao.id_filme = filme.id_filme) "
                    + " inner join funcionario on sessao.id_funcionario = funcionario.id_funcionario)";
        
        ArrayList<Sessao> modelo = new ArrayList<Sessao>();
        try{
            PreparedStatement sentenca = con.conectar().prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            
            while (rs.next()){
                Sessao sessao = new Sessao();
                sessao.setId_sessao(rs.getInt("id_sessao"));
                sessao.setNome(rs.getString("nome"));
                Sala sala = new Sala();
                sala.setNome(rs.getString("Sala"));
                sessao.setSala(sala);
                
                Filme filme = new Filme();
                filme.setNome(rs.getString("Filme"));
                sessao.setFilme(filme);
                
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("Funcionario"));
                sessao.setFuncionario(funcionario);
                
                sessao.setData_sessao(rs.getString("data_sessao"));
                sessao.setHorario_sessao(rs.getString("horario_sessao"));
                sessao.setValor_sessao(rs.getFloat("valor_sessao"));
                
                modelo.add(sessao);
            }
        }catch(SQLException e){
            System.out.println("Erro Ao Listar : " + e.getMessage());
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
