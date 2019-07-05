<%-- 
    Document   : ExibeCaixa
    Created on : 12/11/2018, 22:11:17
    Author     : arauj
--%>

<%@page import="model.Caixa"%>
<%@page import="control.Controle_Caixa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Lista de Caixas</title>
    </head>
   <body>
        </br>
        <header>
            <div class="container">
                <div class="row">
                    <div align="center" class="col">
                        <form action="SvDeleteCaixa" method="POST">
                            <input type="number" name="id_caixa" placeholder="Id do Caixa" style="border-color: red"/>
                            <input class="btn btn-outline-danger" type="submit" name="deletar" value="Deletar"/>
                        </form>
                    </div>
                    <div class="col-2">
                        <input class="btn btn-outline-warning" type="submit" name="voltar" value="Voltar Pagina" onclick="window.location.href='Gerencia_Caixa.jsp';"/>
                    </div>
                </div>
            </div>    
        </header>
        </br>
        <% 
            Controle_Caixa ctrlsessao = new Controle_Caixa();
            for(Caixa c : ctrlsessao.selecionarTodos()){
        %>
        <div class="card" style="width: 20rem; float: left ; position: relative;" >
                <img img class="card-img-top" width="200px" height="200px" src="images/default-caixa.jpg" alt='Caixa'>
                <div class='card-body'>
                    <h5 class='card-title'> <%= "Caixa " + c.getId_caixa() %>  </h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Id :</strong> <i> <%= c.getId_caixa() %> </i></li>
                    <li class="list-group-item"><strong>Sessão referente :</strong> <i> <%= c.getSessao().getNome() %> </i></li>
                    <li class="list-group-item"><strong>Funcionario responsavel :</strong> <i> <%= c.getFuncionario().getNome() %> </i></li>
                    <li class="list-group-item"><strong>Ingressos Vendidos :</strong> <i> <%= c.getIngressos_vendidos() %></i></li>
                    <li class="list-group-item"><strong>Valor total do caixa :</strong> <i> <%= c.getValor_total() %></i></li>
                </ul>
        </div>   
        <% } %>
        </br>
    </body>
</html>
