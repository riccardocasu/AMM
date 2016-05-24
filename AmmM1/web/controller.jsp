<%-- 
    Document   : controller
    Created on : 24-mag-2016, 21.47.48
    Author     : casur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserimento Confermato</title>
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
            <h3>
                Lista dei tuoi articoli
            </h3>
            <table> <!-- Tabella contenente i prodotto acquistabili dai clienti -->
                <tr>
                    <th>Foto</th>
                    <th>Nome</th>
                    <th>Descrizione</th>
                    <th>Prezzo</th>
                    <th>Elimina</th>
                    <th>Modifica</th>
                </tr>
                <c:forEach var="oggetto" items="${venditore.getOggettiVenditore()}">
                    <c:choose>
                        <c:when test="${oggetto.getId()%2 != 0}">
                            <tr class="dispari">
                        </c:when>
                            <c:otherwise>
                                <tr class="pari">
                            </c:otherwise>
                    </c:choose>
                        <td><img title="${oggetto.getNome()}" alt="Foto ${oggetto.getNome()}" src="${oggetto.getUrlImmagine()}" width="100" height="100"></td>
                        <td>${oggetto.getNome()}</td>
                        <td> ${oggetto.getPrezzo()} </td>
                        <td> ${oggetto.getQuantity()}</td>
                        <td><button type='submit'  name="Elimina"><a href="venditore.html?idOggettodaEliminare=${oggetto.getId()}">Elimina</a></button></td>
                        <td><button type='submit' name="Modifica"><a href="venditore.html?idOggettodaModificare=${oggetto.getId()}">Modifica</a></button></td>
                                </tr>
                </c:forEach>
            </table>
                
            
    </div>
            
            <div style="clear: both; width: 0px; height: 0px;"></div>
            
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
