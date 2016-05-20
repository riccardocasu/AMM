<%-- 
    Document   : cliente
    Created on : 28-apr-2016, 15.56.37
    Author     : casur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Titolo e metainformazioni -->
        <title>FootballShop - Area Clienti</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Compra e vendi divise e gadget della tua squadra preferita di Serie A a prezzi bassissimi!">
        <meta name="author" content="Riccardo Casu">
        <meta name="keywords" content="Football, calcio, compra, maglie, divise, gadget, Serie A">
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <c:choose>
        <c:when test="${loggedIn == true && cliente.getId()==id}">
                
        <div id="page">
            <jsp:include page="header.jsp"/>
            <jsp:include page="sidebar1.jsp"/>
            <jsp:include page="sidebar2.jsp"/>
            
            <!-- Colonna centrale -->
            <div id="content">               
                <h1 id="titolo">FootballShop - Area Clienti</h1> 
                <!-- Box per gestire l'overflow della tabella -->
                <div id="box_tabella">
                    <!-- Inizio tabella -->
                    <table> 
                        <!-- Intestazione tabella -->
                        <tr>
                            <th>Nome</th>
                            <th>Foto</th>
                            <th>Disponibili</th>
                            <th>Prezzo</th>
                            <th>Compra</th>
                        </tr>
                        
                        <c:forEach var="oggetto" items="${objectSale}">                              
                        <c:choose>
                            <c:when test="${oggetto.getId()%2==0}">
                                <tr class="pari">
                            </c:when>
                            <c:otherwise>
                                <tr class="dispari">
                            </c:otherwise>
                        </c:choose>                       
                        
                                    <td>${oggetto.getNome()}</td>
                                    <td>
                                        <img src="${oggetto.getUrlImmagine()}" title="${oggetto.getNome()}" 
                                                 alt="${oggetto.getNome()}" width="100" height="100">
                                    </td>
                                    <td>${oggetto.getQuantita()}</td>
                                    <td>${oggetto.getPrezzo()}</td>
                                    <td><a href="cliente.html?idOggetto=${oggetto.getId()}"><img src="images/carrello.png" width="50" height="50" title="Aggiungi al carrello" alt="Aggiungi oggetto al carrello"></a></td> 
                                </tr>
                        </c:forEach>                        
                    </table>
                </div>
            </div>                    
            
            <!-- Blocco vuoto ("clear") -->
            <div style="clear: both; width: 0px; height: 0px;"></div>
            
            <jsp:include page="footer.jsp"/>
        </div>
        
        </c:when>
        <c:otherwise>
            <jsp:include page="accesso_negato.jsp"/>
        </c:otherwise>            
        </c:choose>  
    </body>
</html>
