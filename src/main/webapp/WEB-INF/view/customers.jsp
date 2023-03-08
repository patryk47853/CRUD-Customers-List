<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"
    />

</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Customers</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <form:form action="search" method="get">
            <input type="search" name="customerName" />
            <input type="submit" value="Search" class="add-button">
        </form:form>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <c:forEach var="myCustomer" items="${customers}">

                <c:url var="deleteLink" value="/home/deleteCustomer">
                    <c:param name="customerId" value="${myCustomer.id}"/>
                </c:url>
                <tr>
                    <td>${myCustomer.firstName}</td>
                    <td>${myCustomer.lastName}</td>
                    <td>${myCustomer.email}</td>
                    <td> <a href="${deleteLink}"
                       onclick="return confirm('Are you sure you want to delete ${myCustomer.firstName} from database?');"
                    >Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <input type="button" value="Add customer"
               onclick="window.location.href='addCustomer'; return false;"
               class="add-button"
               />
    </div>

</div>

</body>
</html>
