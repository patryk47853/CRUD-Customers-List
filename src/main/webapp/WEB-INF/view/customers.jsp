<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>

            <c:forEach var="myCustomer" items="${customers}">
                <tr>
                    <td>${myCustomer.firstName}</td>
                    <td>${myCustomer.lastName}</td>
                    <td>${myCustomer.email}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

</body>
</html>
