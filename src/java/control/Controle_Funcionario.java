package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionario;
import util.Conexao;

public class Controle_Funcionario {
    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    
    public boolean inserir(Funcionario funcionario){
        sSQL = "insert into funcionario (nome,data_nasc,funcao,num_car_trab,problema_de_saude,salario)" + 
                    "values(?,?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getData_nasc());
            pst.setString(3, funcionario.getFuncao());
            pst.setString(4, funcionario.getNum_car_trab());
            pst.setString(5, funcionario.getProblema_de_saude());
            pst.setFloat(6, funcionario.getSalario());
                       
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
    
    public boolean editar(Funcionario funcionario,int id_funcionario){
        sSQL = "update funcionario set nome=?,data_nasc=?,funcao=?,num_car_trab=?,problema_de_saude=?,salario=?"
                + "where id_funcionario = ?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getData_nasc());
            pst.setString(3, funcionario.getFuncao());
            pst.setString(4, funcionario.getNum_car_trab());
            pst.setString(5, funcionario.getProblema_de_saude());
            pst.setFloat(6, funcionario.getSalario());
            pst.setInt(7, id_funcionario);
            
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
    
    public boolean deletar(int id_funcionario){
        sSQL += "delete from funcionario where id_funcionario=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, id_funcionario);
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
    
    public ArrayList<Funcionario> selecionarTodos(){
        Conexao con = new Conexao();
        String sql = "select * from funcionario";
        ArrayList<Funcionario> modelo = new ArrayList<Funcionario>();
        try{
            PreparedStatement sentenca = con.conectar().prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            
            while (rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setData_nasc(rs.getString("data_nasc"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setNum_car_trab(rs.getString("num_car_trab"));           
                funcionario.setProblema_de_saude(rs.getString("problema_de_saude"));
                funcionario.setSalario(rs.getFloat("salario"));
                modelo.add(funcionario);
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
