<%@ page import="pl.sda.javagdy2.database.EntityDao" %>
<%@ page import="pl.sda.javagdy2.database.model.Klient" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: joanna.plazynska
  Date: 23.04.2020
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Lista Klientow</title>
</head>
<body>
<jsp:include page="/menu.jsp"/>


<table>
    <style>
        table {border-collapse: collapse; border: 1px solid black; position:center }
        td {border: 1px solid black;text-align: center}
        tr {border: 1px solid black;text-align: center}
        th {border: 1px solid black;text-align: center; background: aqua}
        caption {border: 1px solid black;text-align: center; background: chartreuse; text-decoration-color: #bdb76b}
    </style>

    <caption align="center">Lista Klientow</caption>

    <thead>
    <tr>
        <td>Id</td>
        <td>Imie</td>
        <td>Nazwisko</td>
        <td>Ocena</td>
        <td>L.aut</td>
        <td>Napiwiki</td>
    </tr>
    </thead>

    <tbody>

    <c:forEach var="klient" items="${requestScope.klients}">
        <tr>
            <td><c:out value="${klient.id}"/></td>
            <td><c:out value="${klient.imie}"/></td>
            <td><c:out value="${klient.nazwisko}"/></td>
            <td><c:out value="${klient.ocenaKlienta}"/></td>
            <td><c:out value="${klient.iloscSamochodow}"/></td>
            <td><c:out value="${klient.czyDajeNapiwki}"/></td>

            <td>
                <a href="/klient/remove?identToRemove=<c:out value="${klient.id}"/>">Usuń</a>
            </td>
            <td>
                <a href="/klient/detail?identifier=<c:out value="${klient.id}"/>">Szczegoly</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
<%--<%--%>
<%--    EntityDao dao = new EntityDao();--%>
<%--    List<Klient> listaklientow = dao.list(Klient.class);--%>

<%--    out.print("<th>Id</th>");--%>
<%--    out.print("<th>Imię</th>");--%>
<%--    out.print("<th>Nazwisko</th>");--%>
<%--    out.print("<th>Ocena</th>");--%>
<%--    out.print("<th>L.aut</th>");--%>
<%--    out.print("<th>Napiwki</th>");--%>
<%--    for (Klient klient: listaklientow) {--%>
<%--        out.print("<tr><td width: 50px> " + klient.getId()+ "</td>"+"\t"--%>
<%--                + "<td>"+ klient.getImie()+"</td>"+ "\t"--%>
<%--                + "<td>"+ klient.getNazwisko()+"</td>"+"\t"--%>
<%--                + "<td>"+ klient.getOcenaKlienta() + "</td>"+"\t"--%>
<%--                + "<td>"+ klient.getIloscSamochodow() + "</td>"+"\t"--%>
<%--                + "<td>"+ klient.isCzyDajeNapiwki() + "</td></tr><br/>");--%>

<%--    }--%>
<%--%>--%>
</table>
</body>
</html>
