<%-- 
    Document   : sidebar1
    Created on : 28-apr-2016, 16.01.21
    Author     : casur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- Prima barra laterale (sinistra) -->
    <div id="sidebar1">
        <ul>
            <li id="navigazione">
                <h2 class="icon-title">Navigazione</h2>
                <!-- Elenco con link alle altre pagine -->
                <ul>
                    <li><a href="descrizione.jsp">Home</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="cliente.jsp">Cliente</a></li>
                    <li><a href="venditore.jsp">Venditore</a></li>
                </ul>
            </li>
            <li id="altri">
                <h2 class="icon-title">Affiliati</h2>
                <!-- Elenco con link ad altri siti -->
                <ul>
                    <li><a href="http://www.legaseriea.it/">Lega Serie A</a></li>
                    <li><a href="http://www.risultati.it/">Risultati Live</a></li>
                </ul>
            </li>
        </ul>
    </div>
</html>
