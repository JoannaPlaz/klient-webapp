<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Klient detail</title>

</head>
<body>
<h1>Details information about student with id: <c:out value="${requestScope.klientDetails.id}"/></h1>
<jsp:include page="/menu.jsp"/>

<br/>

<table>
    <tr>
        <td>Imie:</td>
        <td><c:out value="${requestScope.klientDetails.imie}"/></td>
    </tr>
    <tr>
        <td>Nazwisko:</td>
        <td><c:out value="${requestScope.klientDetails.nazwisko}"/></td>
    </tr>
    <tr>
        <td>Ocena:</td>
        <td><c:out value="${requestScope.klientDetails.ocenaKlienta}"/></td>
    </tr>
    <tr>
        <td>L.aut</td>
        <td><c:out value="${requestScope.klientDetails.iloscSamochodow}"/></td>
    </tr>
    <tr>
        <td>Napiwki</td>
        <td><c:out value="${requestScope.klientDetails.czyDajeNapiwki}"/></td>
    </tr>
</table>
<br/>
<a href="/zlecenie/add?klientId=<c:out value="${requestScope.klientDetails.id}"/>">Dodaj zlecenie (temu klientowi)</a>

<table style="border: 1px solid">
    <thead>
    <tr>
        <td>Id</td>
        <td>Usluga</td>
        <td>Cena</td>
        <td>Data dodania</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="zlecenie" items="${requestScope.klientDetails.zlecenieList}">
        <tr>
            <td><c:out value="${zlecenie.id}"/></td>
            <td><c:out value="${zlecenie.usluga}"/></td>
            <td><c:out value="${zlecenie.cena}"/></td>
            <td><c:out value="${zlecenie.dataDodania}"/></td>

            <td>
                <a href="/zlecenie/delete?zlecenieId=<c:out value="${zlecenie.id}"/>">Usun zlecenie</a>
            </td>
            <td>
                <a href="/zlecenie/edit?zlecenieId=<c:out value="${zlecenie.id}"/>">Edytuj zlecenie</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>