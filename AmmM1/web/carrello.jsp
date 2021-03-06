<%-- 
    Document   : carrello
    Created on : 13-mag-2016, 16.40.22
    Author     : Riccardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrello</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Riccardo Casu">
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div id="page">
            <jsp:include page="header.jsp"/>
            <jsp:include page="sidebar1.jsp"/>
            <jsp:include page="sidebar2.jsp"/>
            
            <div id="content">
                <h2>
                    Carrello
                </h2>
                
                <ul>
                <li>${oggetto.getNome()}</li>
                <li><image src="${oggetto.getUrlImmagine()}" width="300" heigth="300"></li>
                <li>${oggetto.getDescrizione()}</li>
                <li>${oggetto.getPrezzo()}</li>
                <li> ${oggetto.getQuantita()}</li>
                </ul>
                <button name="Submit" type="submit" value="conferma"><a href="cliente.html?idoggVenduto=${oggetto.getId()}">CONFERMA ACQUISTO</a></button>
                <p>${pagato}</p>
            </div>
            
            <div style="clear: both; width: 0px; height: 0px;"></div>
            
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>