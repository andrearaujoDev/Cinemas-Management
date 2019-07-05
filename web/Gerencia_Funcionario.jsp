<%-- 
    Document   : Cadastro_Funcionario
    Created on : 12/11/2018, 08:50:04
    Author     : arauj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Gerenciar Funcionario</title>
        <style>
            body{
                background-image: url("images/popcorn-1433326_1920.jpg");
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
            <h1 align="center"> Gerenciamento de Funcionarios </h1>
        </div>
        <div id="alinhamentocentral" >
            <div class="container">
                <form action="SvCad_Edit_Funcionario" method="POST">
                    <div class="row">
                        <div class="col-4">
                            <input type="number" class="form-control" name='id_fun' placeholder="(ID do funcionario)Exclusivo para Edição">
                        </div>
                    </div>
                    </br>
                    <div class="row">
                        <div class="col">
                            <input type="text" class="form-control" name='nome' placeholder="Nome" required>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name='nascimento' placeholder="Data de Nascimento" required>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name='funcao' placeholder="Função" required>
                        </div>
                    </div>
                    </br>
                    <div class="row">
                        <div class="col">
                            <input type="text" class="form-control" name='numerocarteira' placeholder="Numero Carteira de Trabalho" required>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name='problemasaude' placeholder="Problema de Saude" required>
                        </div>
                        <div class="col">
                            <input type="number" step="0.01" class="form-control" name='salario' placeholder="Salario"required> 
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
                        <form  action='ExibeFuncionario.jsp' method='GET'>  
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
