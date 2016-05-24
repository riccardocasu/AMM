<%-- 
    Document   : modificaoggetto
    Created on : 24-mag-2016, 22.03.44
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
                <h3>Modifica l'oggetto selezionato:</h3>                
               
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
                            <input class ="pulsante" type="submit" name="Modifica" value="Modifica">
                            <button name="Controller" type="submit" value="controller"><a href="controller.jsp">MyAccount</a></button>
                        </div>
                    </div>
                    </form>               
            </div>
            
            <div style="clear: both; width: 0px; height: 0px;"></div>
            
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
