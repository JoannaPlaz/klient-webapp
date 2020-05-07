<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--dzięki poniższej linii możliwe jest wywoływanie funkcji/tagów html z jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--dzięki lini poniżej możliwe jest wykonywanie dyrektyw z użyciem zmiennych adresując je przez ${}--%>
<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zlecenie Form</title>
</head>
<body>
<h1>Zlecenie uslugi dla klienta: <c:out value="${requestScope.klient_identifier}"/></h1>
<jsp:include page="/menu.jsp"/>
<br/>
<%--formularz zawiera 3 pola: ocena, przedmiot i identyfikator studenta któremu dodajemy ocenę. --%>
<form action="${requestScope.zlecenieToEdit==null? '/zlecenie/add' : '/zlecenie/edit'}" method="post">
    <input type="hidden" name="klientZlecenia" value="<c:out value="${requestScope.klient_identifier}"/>">
    <input type="hidden" name="editedZlecenie" value="${requestScope.zlecenieToEdit.id}">
    Usluga:
    <select name="usluga">
        <c:forEach var="uslugi" items="${requestScope.uslugi}">
            <option value="${uslugi}" ${uslugi == requestScope.zlecenieToEdit.usluga? 'selected': ''}>${uslugi.opis}</option>
        </c:forEach>
    </select>
    <br/>
    Ocena: <input type="number"step="0.5" min="0" name="cena" value="${requestScope.zlecenieToEdit.cena}"/>
    <br/>
    <input type="submit">
</form>
</body>
</html>
