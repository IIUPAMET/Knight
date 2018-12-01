<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:directive.page contentType="text/html;charset=UTF-8"/>
<html lang="en"
      xmlns:display="http://www.w3.org/1999/xhtml"
      xmlns:width="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <fmt:setBundle basename="messages_${sessionScope.lang}" var="lang"/>
    <fmt:requestEncoding value="UTF-8"/>
</head>
<body>

<div class="wrapper">
    <form method="get" action="">
        <input type="hidden" name="command" value="SessionStart">
        <input type="submit" name="lang" value="ua">
        <input type="submit" name="lang" value="en">
    </form>
    <div class="left_block">
        <table>
            <tr>
                <th><fmt:message key="Name" bundle="${lang}"/></th>
                <th><fmt:message key="Price" bundle="${lang}"/></th>
                <th><fmt:message key="Weight" bundle="${lang}"/></th>
                <th><fmt:message key="Move" bundle="${lang}"/></th>
            </tr>
            <c:forEach var="t" items="${sessionScope.list}">
                <form method="get" action="">
                    <input type="hidden" name="command" value="Equip">
                    <tr>
                        <td><c:out value="${t.name}"/></td>
                        <td>${t.price}</td>
                        <td>${t.weight}</td>
                        <td>
                            <button type="submit" name="delete" value="${t.id}"><fmt:message key="Move" bundle="${lang}"/></button>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </div>
    <br/>
    <div class="right_block">
        <form method="get" action="">
            <input type="hidden" name="command" value="Add">
            <fmt:message key="Name" bundle="${lang}"/>: <input type="text" name="name"><br/>
            <label style="width: 150px "><fmt:message key="Weight" bundle="${lang}"/>: </label> <input type="text"
                                                                                                       name="weight"><br/>
            <label style="width: 150px"><fmt:message key="Price" bundle="${lang}"/>: </label> <input type="text"
                                                                                                     name="price"><br/>
            <button type="submit"><fmt:message key="Add" bundle="${lang}"/></button>
            <br/>

        </form>
        <form method="get" action="">
            <input type="hidden" name="command" value="Filter">

            <label style="width: 150px"><fmt:message key="Price" bundle="${lang}"/></label>
            <input type="text" name="minWeight">
            <input type="text" name="maxWeight"><br/>
            <button type="submit"><fmt:message key="Filter" bundle="${lang}"/></button>

        </form>
        <form method="get" action="">
            <input type="hidden" name="command" value="SortByPrice">
            <button type="submit"><fmt:message key="SortByPrice" bundle="${lang}"/></button>
        </form>

        <h2><fmt:message key="Price" bundle="${lang}"/><p>${requestScope.sumWeight}</p></h2>
        <table>
            <tr>
                <th>id</th>
                <th><fmt:message key="Name" bundle="${lang}"/></th>
                <th><fmt:message key="Price" bundle="${lang}"/></th>
                <th><fmt:message key="Weight" bundle="${lang}"/></th>
            </tr>
            <c:forEach var="e" items="${sessionScope.equipment}">
                <tr>
                    <td>${e.id}</td>
                    <td><c:out value="${e.name}"/></td>
                    <td>${e.price}</td>
                    <td>${e.weight}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
