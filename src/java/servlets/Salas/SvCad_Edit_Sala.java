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
import model.Sala;

/**
 *
 * @author arauj
 */
public class SvCad_Edit_Sala extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         Controle_Sala ctrlSala = new Controle_Sala();
        
        if(request.getParameter("id_sala").equals("")){
            Sala filme = new Sala(request.getParameter("nome"),
                                              request.getParameter("tipodesala"),
                                              request.getParameter("statussala"),
                                              Integer.parseInt(request.getParameter("capacidademaxima")),
                                              request.getParameter("som"),
                                              request.getParameter("video"));
    
            ctrlSala.inserir(filme);
        
        response.sendRedirect("Gerencia_Sala.jsp");
        }else{
            Sala filme = new Sala(request.getParameter("nome"),
                                              request.getParameter("tipodesala"),
                                              request.getParameter("statussala"),
                                              Integer.parseInt(request.getParameter("capacidademaxima")),
                                              request.getParameter("som"),
                                              request.getParameter("video"));
            
            int id_sala = Integer.parseInt(request.getParameter("id_sala"));
            ctrlSala.editar(filme, id_sala);
            response.sendRedirect("Gerencia_Sala.jsp");
        }
    }

    

}
