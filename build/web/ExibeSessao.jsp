<%-- 
    Document   : ExibeSessao
    Created on : 12/11/2018, 22:11:35
    Author     : arauj
--%>

<%@page import="model.Sessao"%>
<%@page import="control.Controle_Sessao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Lista de Sessões</title>
    </head>
    <body>
        </br>
        <header>
            <div class="container">
                <div class="row">
                    <div align="center" class="col">
                        <form action="SvDeleteSessao" method="POST">
                            <input type="text" name="id_sessao" placeholder="Id da Sessão" style="border-color: red"/>
                            <input class="btn btn-outline-danger" type="submit" name="deletar" value="Deletar"/>
                        </form>
                    </div>
                    <div class="col-2">
                        <input class="btn btn-outline-warning" type="submit" name="voltar" value="Voltar Pagina" onclick="window.location.href='Gerencia_Sessao.jsp';"/>
                    </div>
                </div>
            </div>    
        </header>
        </br>
        <% 
            Controle_Sessao ctrlsessao = new Controle_Sessao();
            for(Sessao s : ctrlsessao.selecionarTodos()){
        %>
        <div class="card" style="width: 20rem; float: left ; position: relative;" >
                <img img class="card-img-top" width="200px" height="200px" src="images/default-sessao.png" alt='Sessão'>
                <div class='card-body'>
                    <h5 class='card-title'> <%= s.getNome() %>  </h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Id :</strong> <i> <%= s.getId_sessao() %> </i></li>
                    <li class="list-group-item"><strong>Sala :</strong> <i> <%= s.getSala().getNome() %> </i></li>
                    <li class="list-group-item"><strong>Nome do Filme :</strong> <i> <%= s.getFilme().getNome() %> </i></li>
                    <li class="list-group-item"><strong>Data da Sessão :</strong> <i> <%= s.getData_sessao() %></i></li>
                    <li class="list-group-item"><strong>Horario :</strong> <i> <%= s.getHorario_sessao() %></i></li>
                    <li class="list-group-item"><strong>Valor da Sessão :</strong> <i> <%= s.getValor_sessao() %></i></li>
                    <li class="list-group-item"><strong>Funcionario responsavel :</strong> <i> <%= s.getFuncionario().getNome() %></i></li>
                </ul>
        </div>   
        <% } %>
        </br>
    </body>
</html>
