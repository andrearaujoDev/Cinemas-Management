/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Funcionarios;

import control.Controle_Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arauj
 */
public class SvDeleteFuncionario extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
      int id_fun = Integer.parseInt(request.getParameter("id_fun"));
      
      Controle_Funcionario ctrlfun = new Controle_Funcionario();
      
      ctrlfun.deletar(id_fun);
      
      response.sendRedirect("ExibeFuncionario.jsp");
      
      
    }

  

}
