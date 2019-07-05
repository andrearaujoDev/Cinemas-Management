package util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection conexao;
    String db = "controlcinema"; 
    String url = "jdbc:mysql://127.0.0.1/" + db;
    String user = "root";
    String password = "";
  

   public Conexao(){

   }

   public Connection conectar(){
       Connection link = null;
       try{
           Class.forName("org.gjt.mm.mysql.Driver");
           link = (Connection) DriverManager.getConnection(this.url,this.user,this.password);
           System.out.println("Conexão feita corretamente");
       }catch(ClassNotFoundException | SQLException ex){
           System.out.println("Erro ao criar conexão com banco : " + ex.getMessage());
       }
       return link;
    }
   
   public void encerrarConexao(){
        try{
            conexao.close();
            System.out.println("Conexão feita corretamente");
        }catch(SQLException ex){
            System.out.println("Erro no fechamento do banco" +ex.getMessage());
        }
    }
}
