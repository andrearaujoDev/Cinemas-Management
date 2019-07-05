/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Consumos;

import control.Controle_Consumo;
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
public class SvDeleteConsumo extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      int id_consumo = Integer.parseInt(request.getParameter("id_consumo"));
      
      Controle_Consumo ctrlconsumo = new Controle_Consumo();
      
      ctrlconsumo.deletar(id_consumo);
      
      response.sendRedirect("ExibeConsumo.jsp");
        
    }


}
