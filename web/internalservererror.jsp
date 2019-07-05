<%-- 
    Document   : internalservererror
    Created on : 14/11/2018, 08:03:09
    Author     : arauj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Internal Server Error</title>
        <style>
            .imagemcentral{
                background-image: url("images/500-Internal-Server-Error.png");
                background-size: 100%;
                background-repeat: no-repeat;
                width: 500px;
                height: 500px;
                position: relative;
                top: 100px;
                left: 420px; 
            }
        </style>
    </head>
    <body>
        <h1 align="center">Ops...Houve algum erro inesperado no servidor</h1>
        <div class="imagemcentral">
            
        </div>
        <div align="center" style=" position: absolute; width: 500px ; left: 420px; top: 450px">
            <a class="btn btn-primary btn-lg btn-block" href="principalPage.jsp" role="button">Redirecionar para Principal</a>
        </div>
        
    </body>
</html>
