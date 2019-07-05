<%-- 
    Document   : Gerencia_Consumo
    Created on : 12/11/2018, 09:04:23
    Author     : arauj
--%>

<%@page import="model.Funcionario"%>
<%@page import="control.Controle_Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Gerenciar Funcionario</title>
        <style>
            body{
                background-image: url("images/ice-cream-cone-1274894_1920.jpg");
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
            <h1 align="center"> Gerenciamento de Consumos </h1>
        </div>
        <div id="alinhamentocentral" >
            <div class="container">
                <form action="SvCad_Edit_Consumo" method="POST">
                    <div class="row">
                        <div class="col-4">
                            <input type="number" class="form-control" name='id_consumo' placeholder="(ID do Consumo)Exclusivo para Edição">
                        </div>
                    </div>
                    </br>
                    <div class="row">
                        <div class="col">
                            <input type="text" class="form-control" name='nome_produto' placeholder="Nome do Produto">
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name='nome_bebida' placeholder="Nome da Bebida">
                        </div>
                       
                    </div>
                    </br>
                    <div class="row">
                         <div class="col">
                            <input type="number" step="0.01" class="form-control" name='preco' placeholder="Preço" required>
                        </div>
                        <div class="col">
                            <select class="form-control" name="funcionario" >
                                <option value="" selected disabled hidden>Selecione o Funcionario</option>
                                <% Controle_Funcionario ctrlFun = new Controle_Funcionario();
                                    for(Funcionario f : ctrlFun.selecionarTodos()){ %>
                                        <option> <%= f.getNome() %></option>
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
                        <form  action='ExibeConsumo.jsp' method='GET'>  
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

