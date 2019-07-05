<%-- 
    Document   : ExibeFilme
    Created on : 12/11/2018, 22:10:22
    Author     : arauj
--%>

<%@page import="model.Filme"%>
<%@page import="control.Controle_Filme"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Lista de Filmes</title>
    </head>
    <body>
        </br>
        <header>
            <div class="container">
                <div class="row">
                    <div align="center" class="col">
                        <form action="SvDeleteFilme" method="POST">
                            <input type="text" name="id_filme" placeholder="Id do Filme" style="border-color: red"/>
                            <input class="btn btn-outline-danger" type="submit" name="deletar" value="Deletar"/>
                        </form>
                    </div>
                    <div class="col-2">
                        <input class="btn btn-outline-warning" type="submit" name="voltar" value="Voltar Pagina" onclick="window.location.href='Gerencia_Filme.jsp';"/>
                    </div>
                </div>
            </div>    
        </header>
        </br>
        <% 
            Controle_Filme ctrlFilme = new Controle_Filme();
            for(Filme f : ctrlFilme.selecionarTodos()){
        %>
        <div class="card" style="width: 20rem; float: left ; position: relative;" >
                <img img class="card-img-top" width="200px" height="200px" src="images/default-filme.png" alt='Filme'>
                <div class='card-body'>
                    <h5 class='card-title'> <%= f.getNome() %>  </h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Id :</strong> <i> <%= f.getId_filme() %> </i></li>
                    <li class="list-group-item"><strong>Genero :</strong> <i> <%= f.getGenero() %> </i></li>
                    <li class="list-group-item"><strong>Duração em Minutos :</strong> <i> <%= f.getDuracao_em_minutos() %> </i></li>
                    <li class="list-group-item"><strong>Data de Lançamento :</strong> <i> <%= f.getData_lancamento() %></i></li>
                    <li class="list-group-item"><strong>Produtora :</strong> <i> <%= f.getProdutora() %></i></li>
                    <li class="list-group-item"><strong>Classificação :</strong> <i> <%= f.getClassificacao() %></i></li>
                </ul>
        </div>   
        <% } %>
        </br>
    </body>
</html>
