/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Funcionarios;

import control.Controle_Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

/**
 *
 * @author arauj
 */
public class SvCad_Edit_Funcionario extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controle_Funcionario ctrlFun = new Controle_Funcionario();
        
        if(request.getParameter("id_fun").equals("")){
            Funcionario fun = new Funcionario(request.getParameter("nome"),
                                              request.getParameter("nascimento"),
                                              request.getParameter("funcao"),
                                              request.getParameter("numerocarteira"),
                                              request.getParameter("problemasaude"),
                                              Float.parseFloat(request.getParameter("salario")));
    
            ctrlFun.inserir(fun);
        
        response.sendRedirect("Gerencia_Funcionario.jsp");
        }else{
            Funcionario fun = new Funcionario(request.getParameter("nome"),
                                             request.getParameter("nascimento"),
                                             request.getParameter("funcao"),
                                             request.getParameter("numerocarteira"),
                                             request.getParameter("problemasaude"),
                                             Float.parseFloat(request.getParameter("salario")));
            
            int id_fun = Integer.parseInt(request.getParameter("id_fun"));
            ctrlFun.editar(fun, id_fun);
        
            response.sendRedirect("Gerencia_Funcionario.jsp");
        }
        
        
        
    }

   
    
}
