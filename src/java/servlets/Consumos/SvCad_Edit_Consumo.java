/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Consumos;

import control.Controle_Consumo;
import control.Controle_Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Consumo;
import model.Funcionario;

/**
 *
 * @author arauj
 */
public class SvCad_Edit_Consumo extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       Controle_Consumo ctrlConsumo = new Controle_Consumo();
       Controle_Funcionario ctrlFun = new Controle_Funcionario(); 
       
       int id_funcionario = 1;
       
       if(request.getParameter("id_consumo").equals("")){
            Consumo consumo = new Consumo(request.getParameter("nome_produto"),
                                              request.getParameter("nome_bebida"),
                                              Float.parseFloat(request.getParameter("preco")));
            
            Funcionario funcionario = new Funcionario();
            
            for(Funcionario f : ctrlFun.selecionarTodos()){
                if(request.getParameter("funcionario").equals(f.getNome())){
                    id_funcionario = f.getId_funcionario();
                }
            }
            
            funcionario.setId_funcionario(id_funcionario);
            
            consumo.setFuncionario(funcionario);
            
            ctrlConsumo.inserir(consumo);
        
        response.sendRedirect("Gerencia_Consumo.jsp");
        }else{
           Consumo consumo = new Consumo(request.getParameter("nome_produto"),
                                              request.getParameter("nome_bebida"),
                                              Float.parseFloat(request.getParameter("preco")));
           
           Funcionario funcionario = new Funcionario();
            
            for(Funcionario f : ctrlFun.selecionarTodos()){
                if(request.getParameter("funcionario").equals(f.getNome())){
                    id_funcionario = f.getId_funcionario();
                }
            }
            
            funcionario.setId_funcionario(id_funcionario);
            
            consumo.setFuncionario(funcionario);
            
            int id_consumo = Integer.parseInt(request.getParameter("id_consumo"));
            ctrlConsumo.editar(consumo, id_consumo);
        
            response.sendRedirect("Gerencia_Consumo.jsp");
        }
    }


}
