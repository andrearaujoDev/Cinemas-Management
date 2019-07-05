package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Caixa;
import model.Funcionario;
import model.Sessao;
import util.Conexao;

public class Controle_Caixa {
    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    
    public boolean inserir(Caixa caixa){
        sSQL = "insert into caixa ( id_sessao , id_funcionario , ingressos_vendidos , valor_total )" + 
                    " values(?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, caixa.getSessao().getId_sessao());
            pst.setInt(2, caixa.getFuncionario().getId_funcionario());
            pst.setInt(3, caixa.getIngressos_vendidos());
            pst.setFloat(4, caixa.getValor_total());
                       
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
    
    public boolean editar(Caixa caixa,int id_caixa){
        sSQL = "update caixa set caixa.id_sessao = ? , caixa.id_funcionario = ? , caixa.ingressos_vendidos = ? , caixa.valor_total = ? where id_caixa = ? ";
               
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, caixa.getSessao().getId_sessao());
            pst.setInt(2, caixa.getFuncionario().getId_funcionario());
            pst.setInt(3, caixa.getIngressos_vendidos());
            pst.setFloat(4, caixa.getValor_total());
            pst.setInt(5, id_caixa);
            
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
    
    public boolean deletar(int id_caixa){
        sSQL = "delete from caixa where id_caixa=?";
        try{
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, id_caixa);
            
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
    
     public ArrayList<Caixa> selecionarTodos(){
        Conexao con = new Conexao();
        String sql = "select caixa.id_caixa,sessao.nome as Sessao,funcionario.nome as Funcionario,ingressos_vendidos,valor_total "
                   + " from ((caixa inner join sessao on caixa.id_sessao = sessao.id_sessao)"
                   + " inner join funcionario on caixa.id_funcionario = funcionario.id_funcionario)";
        
        ArrayList<Caixa> modelo = new ArrayList<Caixa>();
        try{
            PreparedStatement sentenca = con.conectar().prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            
            while (rs.next()){
                Caixa caixa = new Caixa();
                caixa.setId_caixa(rs.getInt("id_caixa"));
                
                Sessao sessao = new Sessao();
                sessao.setNome(rs.getString("Sessao"));
                caixa.setSessao(sessao);
                
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("Funcionario"));
                caixa.setFuncionario(funcionario);
                
                caixa.setIngressos_vendidos(rs.getInt("ingressos_vendidos"));
                caixa.setValor_total(rs.getFloat("valor_total"));
                
                modelo.add(caixa);
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
