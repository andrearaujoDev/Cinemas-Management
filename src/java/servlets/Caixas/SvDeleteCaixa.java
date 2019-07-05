/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Caixas;

import control.Controle_Caixa;
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
public class SvDeleteCaixa extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      int id_caixa = Integer.parseInt(request.getParameter("id_caixa"));
      
      Controle_Caixa ctrlcaixa = new Controle_Caixa();
      
      ctrlcaixa.deletar(id_caixa);
      
      response.sendRedirect("ExibeCaixa.jsp");
        
    }

 

}
