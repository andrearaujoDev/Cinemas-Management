<%-- 
    Document   : index
    Created on : 08/11/2018, 20:50:41
    Author     : arauj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='pt-br'>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/styles.css" rel="stylesheet" type="text/css">
        <title>Autenticação</title>
    </head>
    <body>
        <div class="alinhamentocentral">
            <div class="container">
                <form action="svAutenticacao" method="POST">
                    <div class="row">
                        <div class="form-group">
                            <input type="text" class="form-control" name="login" placeholder="Login">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <input type="password" class="form-control" name="senha" placeholder="Senha">
                        </div>
                    </div>
                    <div class="row"> 
                        <div class="col">
                            <input type="submit" class="btn btn-primary btn-lg btn-block" name="logar" value="Logar"/>
                        </div>
                    </div>
                </form>   
            </div>
        </div>  
    </body>
</html>
