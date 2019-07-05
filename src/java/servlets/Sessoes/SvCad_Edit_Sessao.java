/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Sessoes;

import control.Controle_Filme;
import control.Controle_Funcionario;
import control.Controle_Sala;
import control.Controle_Sessao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Filme;
import model.Funcionario;
import model.Sala;
import model.Sessao;

/**
 *
 * @author arauj
 */
public class SvCad_Edit_Sessao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       Controle_Sessao ctrlsessao = new Controle_Sessao();
       Controle_Sala ctrlSala = new Controle_Sala();
       Controle_Filme ctrlFilme = new Controle_Filme();
       Controle_Funcionario ctrlFun = new Controle_Funcionario(); 
       
       int id_sala = 1;
       int id_filme = 1;
       int id_funcionario = 1;
       
       if(request.getParameter("id_sessao").equals("")){
            Sessao sessao = new Sessao(request.getParameter("nome"),
                                              request.getParameter("data_sessao"),
                                              request.getParameter("horario_sessao"),
                                              Float.parseFloat(request.getParameter("valor_sessao")));
            
            Sala sala = new Sala();
            
            for(Sala s : ctrlSala.selecionarTodos()){
                if(request.getParameter("sala").equals(s.getNome())){
                    id_sala = s.getId_sala();
                     System.out.println("Id da sala : "  + id_sala);
                }
            }
            
            sala.setId_sala(id_sala);
            
            Filme filme = new Filme();
            
            for(Filme fil : ctrlFilme.selecionarTodos()){
                if(request.getParameter("filme").equals(fil.getNome())){
                    id_filme = fil.getId_filme();
                }
            }
            
            filme.setId_filme(id_filme);
            
            Funcionario funcionario = new Funcionario();
            
            for(Funcionario f : ctrlFun.selecionarTodos()){
                if(request.getParameter("funcionario").equals(f.getNome())){
                    id_funcionario = f.getId_funcionario();
                }
            }
            
            funcionario.setId_funcionario(id_funcionario);
            
            sessao.setSala(sala);
            sessao.setFilme(filme);
            sessao.setFuncionario(funcionario);
            
            ctrlsessao.inserir(sessao);
        
            response.sendRedirect("Gerencia_Sessao.jsp");
        }else{
           Sessao sessao = new Sessao(request.getParameter("nome"),
                                              request.getParameter("data_sessao"),
                                              request.getParameter("horario_sessao"),
                                              Float.parseFloat(request.getParameter("valor_sessao")));
           
           Sala sala = new Sala();
            
            for(Sala s : ctrlSala.selecionarTodos()){
                if(request.getParameter("sala").equals(s.getNome())){
                    id_sala = s.getId_sala();
                }
            }
            
            sala.setId_sala(id_sala);
            
            Filme filme = new Filme();
            
            for(Filme fil : ctrlFilme.selecionarTodos()){
                if(request.getParameter("filme").equals(fil.getNome())){
                    id_filme = fil.getId_filme();
                }
            }
            
            filme.setId_filme(id_filme);
            
            Funcionario funcionario = new Funcionario();
            
            for(Funcionario f : ctrlFun.selecionarTodos()){
                if(request.getParameter("funcionario").equals(f.getNome())){
                    id_funcionario = f.getId_funcionario();
                }
            }
            
            funcionario.setId_funcionario(id_funcionario);
            
            sessao.setSala(sala);
            sessao.setFilme(filme);
            sessao.setFuncionario(funcionario);
            
            int id_sessao = Integer.parseInt(request.getParameter("id_sessao"));
            System.out.println("Id da Sessao : " + id_sessao);
            ctrlsessao.editar(sessao, id_sessao);
        
            response.sendRedirect("Gerencia_Sessao.jsp");
        }
       
    }


}
