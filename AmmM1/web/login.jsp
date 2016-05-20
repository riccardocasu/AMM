<%-- 
    Document   : login
    Created on : 28-apr-2016, 15.58.38
    Author     : casur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Titolo e metainformazioni -->
        <title>FootballShop - Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Login a FootballShop. Compra e vendi divise e gadget della tua squadra preferita di Serie A a prezzi bassissimi!" >
	<meta name="author" content="Riccardo Casu">
        <meta name="keywords" content="Football, calcio, compra, ,vendi, maglie, divise, gadget, Serie A, login">
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
                <h1>FootballShop - Login</h1>
                <!-- Form per il login -->
                <form method="post" action="login.html">
                    <div class="login_form">
                        <label for="user">Username</label>
                        <input type="text" name="user" id="user"/>
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password"/>            
                        <div class="Box_pulsanti">
                            <p>${messaggio}</p>
                            <input class="pulsante" type="submit" name="Submit" value="Accedi">
                            <input class="pulsante" type='reset' name="Reset" value='Reset'/>
                        </div>
                    </div>
                </form>                
            </div>
            <!-- Blocco vuoto ("clear") -->
            <div style="clear: both; width: 0px; height: 0px;"></div>
            
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
