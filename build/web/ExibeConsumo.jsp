<%-- 
    Document   : ExibeConsumo
    Created on : 12/11/2018, 22:11:03
    Author     : arauj
--%>

<%@page import="model.Consumo"%>
<%@page import="control.Controle_Consumo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Lista de Consumos</title>
    </head>
    <body>
        </br>
        <header>
            <div class="container">
                <div class="row">
                    <div align="center" class="col">
                        <form action="SvDeleteConsumo" method="POST">
                            <input type="text" name="id_consumo" placeholder="Id do Consumo" style="border-color: red"/>
                            <input class="btn btn-outline-danger" type="submit" name="deletar" value="Deletar"/>
                        </form>
                    </div>
                    <div class="col-2">
                        <input class="btn btn-outline-warning" type="submit" name="voltar" value="Voltar Pagina" onclick="window.location.href='Gerencia_Consumo.jsp';"/>
                    </div>
                </div>
            </div>    
        </header>
        </br>
        <% 
            Controle_Consumo ctrlconsumo = new Controle_Consumo();
            for(Consumo c : ctrlconsumo.selecionarTodos()){
        %>
        <div class="card" style="width: 20rem; float: left ; position: relative;" >
                <img img class="card-img-top" width="200px" height="200px" src="images/default-filme.png" alt='Consumo'>
                <div class='card-body'>
                    <h5 class='card-title'> <%= c.getNome_produto() %>  </h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Id :</strong> <i> <%= c.getId_consumo() %> </i></li>
                    <li class="list-group-item"><strong>Nome da Bebida :</strong> <i> <%= c.getNome_bebida() %> </i></li>
                    <li class="list-group-item"><strong>Preço :</strong> <i> <%= c.getPreco() %> </i></li>
                    <li class="list-group-item"><strong>Vendido P/Funcionario :</strong> <i> <%= c.getFuncionario().getNome() %></i></li>
                </ul>
        </div>   
        <% } %>
        </br>
    </body>
</html>
