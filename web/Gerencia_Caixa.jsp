<%-- 
    Document   : Gerencia_Caixa
    Created on : 12/11/2018, 09:04:57
    Author     : arauj
--%>

<%@page import="model.Sessao"%>
<%@page import="control.Controle_Sessao"%>
<%@page import="model.Funcionario"%>
<%@page import="control.Controle_Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Gerenciar Caixa</title>
        <style>
            body{
                background-image: url("images/bitcoin-3083578_1920.jpg");
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
            <h1 align="center"> Gerenciamento de Caixas </h1>
        </div>
        <div id="alinhamentocentral" >
            <div class="container">
                <form action="SvCad_Edit_Caixa" method="POST">
                    <div class="row">
                        <div class="col-4">
                            <input type="number" class="form-control" name='id_caixa' placeholder="(ID do Caixa)Exclusivo para Edição">
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
                        <div class="col">
                            <select class="form-control" name="sessao">
                                <option value="" selected disabled hidden>Selecione a Sessão</option>
                                <% Controle_Sessao ctrlSessao = new Controle_Sessao();
                                    for(Sessao s : ctrlSessao.selecionarTodos()){ %>
                                        <option> <%= s.getNome() %></option>
                                <% } %>
                            </select>
                        </div>
                        <div class="col">
                            <input type="number" class="form-control" name='ingressosvendidos' placeholder="Ingressos Vendidos" required>
                        </div>
                    </div>
                    </br>
                    <div class="row">
                        <div class="col">
                            <input type="number" step="0.01" class="form-control" name='valortotal' placeholder="Valor Total" required>
                        </div>
                    </div>
                        </br>
                    </br>
                    </br>
                    <div class="row">
                        <div class="col">
                            <button type="submit" class="btn btn-primary btn-lg btn-block" name='cadastrar-editar'>Cadastrar/Editar</button>
                        </div>
                </form>
                    <div class="col">
                        <form  action='ExibeCaixa.jsp' method='GET'>  
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

