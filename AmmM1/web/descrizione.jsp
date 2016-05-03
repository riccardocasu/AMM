<%-- 
    Document   : descrizione
    Created on : 28-apr-2016, 15.46.09
    Author     : casur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>      
        <title>FootballShop</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Compra e vendi divise e gadget della tua squadra preferita di Serie A a prezzi bassissimi!">
        <meta name="author" content="Riccardo Casu">
        <meta name="keywords" content="Football, calcio, compra, ,vendi, maglie, divise, gadget, Serie A"> 
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div id="page">
            <jsp:include page="header.jsp"/>
            <jsp:include page="sidebar1.jsp"/>
            <jsp:include page="sidebar2.jsp"/>
            
            <!-- Colonna centrale -->
            <div id="content">
                <h2 class="icon-title" id="Chi_siamo">Chi Siamo</h2>
                <p>
                    Benvenuto su FootballShop! Compra divise e accessori della tua squadra preferita di Serie A a prezzi bassissimi! 
                    E' anche possibile vendere le proprie maglie nell'apposita sezione. Buona navigazione!
                </p>                                    
                <h2 class="icon-title" id='In_vendita'>Prodotti in Vendita</h2>
                <!-- Sommario -->
                <ul>
                    <li><a href="#MaglieGara">Maglie da gara</a></li>
                    <li><a href="#MaglieAllenamento">Maglie da allenamento</a></li>
                    <li><a href="#Pantaloncini">Pantaloncini</a></li>
                    <li><a href="#Scarpe">Scarpe</a></li>
                    <li><a href="#Palloni">Palloni</a></li>                            
                    <li><a href="#Gadget">Gadget</a></li>                            
                </ul> 
                <h3 id='MaglieGara'>Maglie da gara</h3>
                <p>
                    Sono disponibili le maglie da gara (casa e trasferta) di tutte e 20 le squadre del campionato di Serie A TIM: Juventus, Napoli, Roma, Inter, Fiorentina, Milan,
                    Sassuolo, Lazio, Bologna, Chievo, Empoli, Genoa, Torino, Sampdoria, Atalanta, Udinese, Palermo, Frosinone, Carpi, Verona.
                </p>                
                <h3 id='MaglieAllenamento'>Maglie da allenamento</h3>
                <p>
                    In questa sezione è possibile comprare maglie da allenamento.
                </p>                
                <h3 id='Pantaloncini'>Pantaloncini</h3>
                <p>
                    In questa sezione si possono acquistare pantaloncini da gara della tua squadra preferita.
                </p>                
                <h3 id='Scarpe'>Scarpe</h3>
                <p>
                    Sono disponibili sia scarpe da calcio che scarpe da calcio a 5.
                </p>
                <h3 id='Palloni'>Palloni</h3>
                <p>
                    Disponibili palloni da calcio e da calcio a 5.
                </p>                
                <h3 id='Gadget'>Gadget</h3>
                <p>
                    In questa sezione trovi fantastici gadget come portachiavi, orologi, cappelli, sciarpe e tanto altro!
                </p>                 
            </div>
            <!-- Blocco vuoto ("clear") -->
            <div style="clear: both; width: 0px; height: 0px;"></div> 
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
