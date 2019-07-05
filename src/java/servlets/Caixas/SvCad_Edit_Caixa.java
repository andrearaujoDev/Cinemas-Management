/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Caixas;

import control.Controle_Caixa;
import control.Controle_Funcionario;
import control.Controle_Sessao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Caixa;
import model.Funcionario;
import model.Sessao;

/**
 *
 * @author arauj
 */
public class SvCad_Edit_Caixa extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controle_Caixa ctrlcaixa = new Controle_Caixa();
        Controle_Sessao ctrlsessao = new Controle_Sessao();
        Controle_Funcionario ctrlFun = new Controle_Funcionario(); 
       
       int id_sessao = 1;
       int id_funcionario = 1;
       
       if(request.getParameter("id_caixa").equals("")){
           System.out.println("entrou no IF"); 
           
           Caixa caixa = new Caixa(Integer.parseInt(request.getParameter("ingressosvendidos")),
                                    Float.parseFloat(request.getParameter("valortotal")));
            
            
            Funcionario funcionario = new Funcionario();
            
            for(Funcionario f : ctrlFun.selecionarTodos()){
                if(request.getParameter("funcionario").equals(f.getNome())){
                    id_funcionario = f.getId_funcionario();
                }
            }
            
            funcionario.setId_funcionario(id_funcionario);
            caixa.setFuncionario(funcionario);
            
            Sessao sessao = new Sessao();
            
            for(Sessao s : ctrlsessao.selecionarTodos()){
                if(request.getParameter("sessao").equals(s.getNome())){
                    id_sessao = s.getId_sessao();
                }
            }
            
            sessao.setId_sessao(id_sessao);
            caixa.setSessao(sessao);
            
            ctrlcaixa.inserir(caixa);
        
            response.sendRedirect("Gerencia_Caixa.jsp");
        }else{
           System.out.println("caiu no else");
           Caixa caixa = new Caixa(Integer.parseInt(request.getParameter("ingressosvendidos")),
                                    Float.parseFloat(request.getParameter("valortotal")));
            
            
            Funcionario funcionario = new Funcionario();
            
            for(Funcionario f : ctrlFun.selecionarTodos()){
                if(request.getParameter("funcionario").equals(f.getNome())){
                    id_funcionario = f.getId_funcionario();
                }
            }
            
            funcionario.setId_funcionario(id_funcionario);
            caixa.setFuncionario(funcionario);
            
            Sessao sessao = new Sessao();
            
            for(Sessao s : ctrlsessao.selecionarTodos()){
                if(request.getParameter("sessao").equals(s.getNome())){
                    id_sessao = s.getId_sessao();
                }
            }
            
            sessao.setId_sessao(id_sessao);
            caixa.setSessao(sessao);
                       
            int id_caixa = Integer.parseInt(request.getParameter("id_caixa"));
            System.out.println("Id da Sessao : " + id_caixa);
            ctrlcaixa.editar(caixa, id_caixa);
        
            response.sendRedirect("Gerencia_Caixa.jsp");
       }
    }

}
