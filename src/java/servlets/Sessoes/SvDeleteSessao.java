/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Sessoes;

import control.Controle_Sessao;
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
public class SvDeleteSessao extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      int id_sessao = Integer.parseInt(request.getParameter("id_sessao"));
      
      Controle_Sessao ctrlsessao = new Controle_Sessao();
      
      ctrlsessao.deletar(id_sessao);
      
      response.sendRedirect("ExibeSessao.jsp");
        
    }

   

}
