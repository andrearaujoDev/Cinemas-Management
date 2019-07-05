package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Consumo;
import model.Funcionario;
import util.Conexao;

public class Controle_Consumo {
    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    
    public boolean inserir(Consumo consumo){
        sSQL = "insert into consumo (nome_produto,nome_bebida,preco,id_funcionario)" + 
                    "values(?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, consumo.getNome_produto());
            pst.setString(2, consumo.getNome_bebida());
            pst.setFloat(3, consumo.getPreco());
            pst.setInt(4, consumo.getFuncionario().getId_funcionario());
                       
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
    
    public boolean editar(Consumo consumo,int id_consumo){
        sSQL = "update consumo set nome_produto = ? , nome_bebida = ? , preco = ? , id_funcionario = ? "
                + " where id_consumo = ?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, consumo.getNome_produto());
            pst.setString(2, consumo.getNome_bebida());
            pst.setFloat(3, consumo.getPreco());
            pst.setInt(4, consumo.getFuncionario().getId_funcionario());
            pst.setInt(5, id_consumo);
            
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
    
    public boolean deletar(int id_consumo){
        sSQL = "delete from consumo where id_consumo=?";
        try{
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, id_consumo);
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
    
     public ArrayList<Consumo> selecionarTodos(){
        Conexao con = new Conexao();
        String sql = "select consumo.id_consumo,"
                   + "nome_produto,"
                   + "nome_bebida,"
                   + "preco,"
                   + "funcionario.nome as nome" 
                   + " from consumo inner join funcionario on consumo.id_funcionario = funcionario.id_funcionario";
        
        ArrayList<Consumo> modelo = new ArrayList<Consumo>();
        try{
            PreparedStatement sentenca = con.conectar().prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            
            while (rs.next()){
                Consumo consumo = new Consumo();
                consumo.setId_consumo(rs.getInt("id_consumo"));
                consumo.setNome_produto(rs.getString("nome_produto"));
                consumo.setNome_bebida(rs.getString("nome_bebida"));
                consumo.setPreco(rs.getFloat("preco"));
                
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                consumo.setFuncionario(funcionario);
                modelo.add(consumo);
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
