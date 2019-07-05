/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Filmes;

import control.Controle_Filme;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Filme;

/**
 *
 * @author arauj
 */
public class SvCad_Edit_Filme extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         Controle_Filme ctrlFun = new Controle_Filme();
        
        if(request.getParameter("id_filme").equals("")){
            Filme filme = new Filme(request.getParameter("nome"),
                                              request.getParameter("genero"),
                                              request.getParameter("duracao"),
                                              request.getParameter("datalancamento"),
                                              request.getParameter("produtora"),
                                              request.getParameter("classificacao"));
    
            ctrlFun.inserir(filme);
        
        response.sendRedirect("Gerencia_Filme.jsp");
        }else{
            Filme filme = new Filme(request.getParameter("nome"),
                                              request.getParameter("genero"),
                                              request.getParameter("duracao"),
                                              request.getParameter("datalancamento"),
                                              request.getParameter("produtora"),
                                              request.getParameter("classificacao"));
            
            int id_filme = Integer.parseInt(request.getParameter("id_filme"));
            ctrlFun.editar(filme, id_filme);
            response.sendRedirect("Gerencia_Filme.jsp");
        }
      
    }

    

}
