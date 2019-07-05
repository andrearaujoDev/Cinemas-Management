<%-- 
    Document   : ExibeSala
    Created on : 12/11/2018, 22:10:44
    Author     : arauj
--%>

<%@page import="model.Sala"%>
<%@page import="control.Controle_Sala"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Lista de Salas</title>
    </head>
    <body>
        </br>
        <header>
            <div class="container">
                <div class="row">
                    <div align="center" class="col">
                        <form action="SvDeleteSala" method="POST">
                            <input type="text" name="id_sala" placeholder="Id da Sala" style="border-color: red"/>
                            <input class="btn btn-outline-danger" type="submit" name="deletar" value="Deletar"/>
                        </form>
                    </div>
                    <div class="col-2">
                        <input class="btn btn-outline-warning" type="submit" name="voltar" value="Voltar Pagina" onclick="window.location.href='Gerencia_Sala.jsp';"/>
                    </div>
                </div>
            </div>    
        </header>
        </br>
        <% 
            Controle_Sala ctrlsala = new Controle_Sala();
            for(Sala s : ctrlsala.selecionarTodos()){
        %>
        <div class="card" style="width: 20rem; float: left ; position: relative;" >
                <img img class="card-img-top" width="200px" height="200px" src="images/default-sala1.jpg" alt='Sala'>
                <div class='card-body'>
                    <h5 class='card-title'> <%= s.getNome() %>  </h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Id :</strong> <i> <%= s.getId_sala() %> </i></li>
                    <li class="list-group-item"><strong>Tipo :</strong> <i> <%= s.getTipo_de_sala() %> </i></li>
                    <li class="list-group-item"><strong>Status :</strong> <i> <%= s.getStatus_sala() %> </i></li>
                    <li class="list-group-item"><strong>Capacidade Maxima :</strong> <i> <%= s.getCapacidade_maxima() %></i></li>
                    <li class="list-group-item"><strong>Tipo de Som :</strong> <i> <%= s.getSom() %></i></li>
                    <li class="list-group-item"><strong>Tipo de Video :</strong> <i> <%= s.getVideo() %></i></li>
                </ul>
        </div>   
        <% } %>
        </br>
    </body>
</html>
