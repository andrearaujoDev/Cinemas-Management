/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Salas;

import control.Controle_Sala;
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
public class SvDeleteSala extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      int id_sala = Integer.parseInt(request.getParameter("id_sala"));
      
      Controle_Sala ctrlsala = new Controle_Sala();
      
      ctrlsala.deletar(id_sala);
      
      response.sendRedirect("ExibeSala.jsp");
        
    }

   

}
