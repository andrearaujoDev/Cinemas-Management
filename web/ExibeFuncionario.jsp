<%-- 
    Document   : ExibeFuncionario
    Created on : 12/11/2018, 11:59:05
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
        <title>Lista de Funcionarios</title>
    </head>
    <body>
        </br>
        <header>
            <div class="container">
                <div class="row">
                    <div align="center" class="col">
                        <form action="SvDeleteFuncionario" method="POST">
                            <input type="text" name="id_fun" placeholder="Id do funcionario" style="border-color: red"/>
                            <input class="btn btn-outline-danger" type="submit" name="deletar" value="Deletar"/>
                        </form>
                    </div>
                    <div class="col-2">
                        <input class="btn btn-outline-warning" type="submit" name="voltar" value="Voltar Pagina" onclick="window.location.href='Gerencia_Funcionario.jsp';"/>
                    </div>
                </div>
            </div>    
        </header>
        </br>
        <% 
            Controle_Funcionario ctrlFun = new Controle_Funcionario();
            for(Funcionario f : ctrlFun.selecionarTodos()){
        %>
        <div class="card" style="width: 20rem; float: left ; position: relative;" >
                <img img class="card-img-top" width="200px" height="200px" src="images/default-funcionario.png" alt='Funcionario'>
                <div class='card-body'>
                    <h5 class='card-title'> <%=f.getNome() %>  </h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Id :</strong> <i> <%= f.getId_funcionario() %> </i></li>
                    <li class="list-group-item"><strong>Data de Nascimento :</strong> <i> <%= f.getData_nasc() %> </i></li>
                    <li class="list-group-item"><strong>Função :</strong> <i> <%= f.getFuncao() %> </i></li>
                    <li class="list-group-item"><strong>Carteira de Trabalho :</strong> <i> <%= f.getNum_car_trab() %></i></li>
                    <li class="list-group-item"><strong>Problema de Saude :</strong> <i> <%= f.getProblema_de_saude() %></i></li>
                    <li class="list-group-item"><strong>Salario :</strong> <i> <%= f.getSalario() %></i></li>
                </ul>
        </div>   
        <% } %>
        </br>
    </body>
     
</html>
