<%-- 
    Document   : Gerencia_Filme
    Created on : 12/11/2018, 09:04:04
    Author     : arauj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Gerenciar Filmes</title>
        <style>
            body{
                background-image: url("images/house-2616607_1920.jpg");
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
            <h1 align="center"> Gerenciamento de Filmes </h1>
        </div>
        <div id="alinhamentocentral" >
            <div class="container">
                <form action="SvCad_Edit_Filme" method="POST">
                    <div class="row">
                        <div class="col-4">
                            <input type="number" class="form-control" name='id_filme' placeholder="(ID do Filme)Exclusivo para Edição">
                        </div>
                    </div>
                    </br>
                    <div class="row">
                        <div class="col">
                            <input type="text" class="form-control" name='nome' placeholder="Nome" required>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name='genero' placeholder="Genero" required>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name='duracao' placeholder="Duração em Minutos" required>
                        </div>
                    </div>
                    </br>
                    <div class="row">
                        <div class="col">
                            <input type="text" class="form-control" name='datalancamento' placeholder="Data de Lançamento" required>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name='produtora' placeholder="Produtora" required>
                        </div>
                        <div class="col">
                            <input type="number" class="form-control" name='classificacao' placeholder="Classificação Indicativa"required> 
                        </div>
                        </td>
                    </div>
                    </br>
                    </br>
                    <div class="row">
                        <div class="col">
                            <button type="submit" class="btn btn-primary btn-lg btn-block" name='cadastrar-editar'>Cadastrar/Editar</button>
                        </div>
                </form>
                    <div class="col">
                        <form  action='ExibeFilme.jsp' method='GET'>  
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

