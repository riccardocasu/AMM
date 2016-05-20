<%-- 
    Document   : venditore
    Created on : 28-apr-2016, 15.57.11
    Author     : casur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Titolo e metainformazioni -->
        <title>FootballShop - Vendi i tuoi oggetti</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Compra e vendi divise e gadget della tua squadra preferita di Serie A a prezzi bassissimi!">
        <meta name="author" content="Riccardo Casu">
        <meta name="keywords" content="Football, calcio, vendi, maglie, divise, gadget, Serie A">
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <c:choose>
        <c:when test="${loggedIn == true && venditore.getId()==id}">
        
        <div id="page">
            <jsp:include page="header.jsp"/>
            <jsp:include page="sidebar1.jsp"/>
            <jsp:include page="sidebar2.jsp"/>
            
            <!-- Colonna centrale -->
            <div id="content">                
                <h1 id="titolo">FootballShop - Vendi i tuoi oggetti</h1>
                <form method="post" action="venditore.html">
                    <div class="venditore_form">
                        <!-- Inserimento del nome dell'oggetto da vendere -->            
                        <label for='nomeoggetto'>Nome oggetto: </label>
                        <input type="text" name="nomeoggetto" id="nomeoggetto"/>            
                        <!-- Inserimento dell'url dell'immagine descrittiva dell'oggetto da vendere -->            
                        <label for='img_url'>URL immagine descrittiva: </label>
                        <input type="url" name="img_url" id="img_url"/>            
                        <!-- Inserimento della descrizione dell'oggetto da vendere -->            
                        <label for="descrizione"> Descrizione dell'oggetto: </label>
                        <textarea rows="5" cols="25" name="info_ogg" id="info_ogg"></textarea>            
                        <!-- Inserimento del prezzo dell'oggetto da vendere -->            
                        <label for="prezzo">Prezzo: €</label>
                        <input type="number" min="0" step="0.01" name="prezzo" id="prezzo" />            
                        <!-- Inserimento della quantità di oggetti disponibili -->            
                        <label for='quantita'>Quantità: </label>
                        <input type='number' name='quantita' id='quantita' min='1'/>
                        <div class="Box_pulsanti">
                            <!-- Pulsanti submit e reset -->            
                            <input class="pulsante" type="submit" name="Submit" value="Conferma"/>
                            <input class="pulsante" type="reset" value="Reset" value='Reset'/>
                        </div>
                    </div>
                </form>                    
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