<%-- 
    Document   : principalPage
    Created on : 11/11/2018, 14:28:26
    Author     : arauj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/StylePrincipalPage.css" rel="stylesheet" type="text/css">
        <title>Control's Cinema</title>
    </head>
    <body>
        <div ID="titulo">
            <h1 align="center"> Control's Cinema</h1>
        </div>
        <div id="alinhamentocentral">
            <div class="container">
                    <div class="row">
                        <div class="col">
                            <a class="btn btn-primary btn-lg btn-block" href="Gerencia_Funcionario.jsp" role="button">Funcionario</a>
                        </div>
                        <div class="col">
                            <a class="btn btn-primary btn-lg btn-block" href="Gerencia_Sala.jsp" role="button">Sala</a>
                        </div>
                    </div>
                    </br>
                    <div class="row">
                        <div class="col">
                           <a class="btn btn-primary btn-lg btn-block" href="Gerencia_Filme.jsp" role="button">Filme</a>
                        </div>
                        <div class="col">
                           <a class="btn btn-primary btn-lg btn-block" href="Gerencia_Consumo.jsp" role="button">Consumo</a>
                        </div>                
                    </div>
                    </br>
                    <div class="row">
                        <div class="col align-center-1"> 
                            <a class="btn btn-primary btn-lg btn-block" href="Gerencia_Sessao.jsp" role="button">Iniciar Sessão</a>
                        </div>
                    </div> 
                    </br>
                    <div class="row">
                        <div class="col">
                            <a class="btn btn-primary btn-lg btn-block" href="Gerencia_Caixa.jsp" role="button">Cadastrar Caixa</a>
                        </div>
                  </div>    
            </div>
        </div>  
        <footer class="page-footer font-small blue">
            <div class="footer-copyright text-center py-3">© 2018 Copyright:
                <a href="https://www.instagram.com/andrearaujo98/"> André Araujo</a>
            </div>
        </footer>
    </body>
</html>
