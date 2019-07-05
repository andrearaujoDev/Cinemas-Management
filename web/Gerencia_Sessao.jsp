<%-- 
    Document   : Gerencia_Sessao
    Created on : 12/11/2018, 09:04:37
    Author     : arauj
--%>

<%@page import="model.Funcionario"%>
<%@page import="control.Controle_Funcionario"%>
<%@page import="model.Filme"%>
<%@page import="control.Controle_Filme"%>
<%@page import="model.Sala"%>
<%@page import="control.Controle_Sala"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Gerenciar Sessões</title>
        <style>
            body{
                background-image: url("images/frog-1672887_1920.jpg");
                background-attachment: fixed;
                background-size: 100%;
                background-repeat: no-repeat;
            }
            footer {
                position: fixed;
                left: 0;
                bottom: 0;
                width: 100%;
                background-color: blue;
                opacity: 0.5;
                color: white;
                text-align: center;
            }

            #titulo{
                position: fixed;
                top: 10px;
                width: 100%;
                background-color: blue;
                opacity: 0.5;
                color: white;
                text-align: center;  
            }

            #alinhamentocentral{
                position: relative;
                top: 210px;
                left: auto; 
            }
        </style>
    </head>
    <body>
        <div ID="titulo">
            <h1 align="center"> Gerenciamento de Sessões </h1>
        </div>
        <div id="alinhamentocentral" >
            <div class="container">
                <form action="SvCad_Edit_Sessao" method="POST">
                    <div class="row">
                        <div class="col-4">
                            <input type="number" class="form-control" name='id_sessao' placeholder="(ID da Sessao)Exclusivo para Edição">
                        </div>
                    </div>
                    </br>
                    <div class="row">
                        <div class="col">
                            <input type="text" class="form-control" name='nome' placeholder="Nome" required>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name='data_sessao' placeholder="Data da Sessão" required>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name='horario_sessao' placeholder="Horario" required>
                        </div>
                    </div>
                    </br>
                    <div class="row">
                        <div class="col">
                            <input type="number" step="0.01" class="form-control" name='valor_sessao' placeholder="Valor" required>
                        </div>
                       
                        <div class="col">
                            <select class="form-control" name="sala">
                                <option value="" selected disabled hidden>Selecione a Sala</option>
                                <% Controle_Sala ctrlSala = new Controle_Sala();
                                    for(Sala s : ctrlSala.selecionarTodos()){ %>
                                        <option> <%= s.getNome() %></option>
                                <% } %>
                            </select>
                        </div>
                        
                        <div class="col">
                            <select class="form-control" name="filme">
                                <option  selected disabled hidden>Selecione o Filme("IA"Tem vida propria)</option>
                                <% Controle_Filme ctrlFilme = new Controle_Filme();
                                    for(Filme f : ctrlFilme.selecionarTodos()){ %>
                                        <option> <%= f.getNome() %></option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                        </br>
                    <div class="row">
                        <div class="col">
                            <select class="form-control" name="funcionario">
                                <option value="" selected disabled hidden>Selecione o Funcionario</option>
                                <% Controle_Funcionario ctrlFun = new Controle_Funcionario();
                                    for(Funcionario fun : ctrlFun.selecionarTodos()){ %>
                                        <option> <%= fun.getNome() %></option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                    </br>
                    </br>
                    <div class="row">
                        <div class="col">
                            <button type="submit" class="btn btn-primary btn-lg btn-block" name='cadastrar-editar'>Cadastrar/Editar</button>
                        </div>
                </form>
                    <div class="col">
                        <form  action='ExibeSessao.jsp' method='GET'>  
                            <button type="submit" class="btn btn-primary btn-lg btn-block" name='exibir'>Exibir</button>
                        </form>
                    </div>
                    </div>
            </div>
        </div>  
        <footer class="page-footer font-small blue">
            </br>
            <div>
                <input class="btn btn-warning" type="submit" name="voltar" value="Voltar Pagina" onclick="window.location.href='principalPage.jsp';"/>
            </div>
            <div class="footer-copyright text-center py-3">© 2018 Copyright:
                <a href="https://www.instagram.com/andrearaujo98/"> André Araujo</a>
            </div>
        </footer>
    </body>
</html>

