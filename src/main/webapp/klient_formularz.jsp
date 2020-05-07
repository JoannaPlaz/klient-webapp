<%--
  Created by IntelliJ IDEA.
  User: joanna.plazynska
  Date: 22.04.2020
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz klienta</title>
</head>
<body>

<h1>Klient form</h1>

<jsp:include page="/menu.jsp"/>

<form action="/klient/add" method="post">
    Imie:<input type="text" name="imie">
    <br/>
    Nazwisko:<input type="text" name="nazwisko">
    <br/>
    czyDajeNapiwki:<input type="checkbox" name="czyDajeNapiwki">
    <br/>
    iloscSamochodow:<input type="number" name="iloscSamochodow">
    <br/>
    ocenaKlienta:<input type="number" min="0" max="10" name="ocenaKlienta">
    <br/>
    <input type="submit">
</form>

</body>
</html>
