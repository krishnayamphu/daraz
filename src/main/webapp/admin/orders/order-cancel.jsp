<%@ page import="java.util.List" %>
<%@ page import="com.aptech.dao.ProductDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%@include file="../head.jsp"%>
</head>
<body>

<%@include file="../nav.jsp"%>

<div class="container">
    <div class="row justify-content-between py-3">
        <div class="col"><h5>All Orders</h5></div>
    </div>

    <div class="row">
        <div class="col-3">
            <%@include file="../sidebar.jsp"%>
        </div>
        <div class="col-9">
            <c:forEach var="item" items="${orders}">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>#OrderID</th>
                        <th>Total</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.getTotalAmount()}</td>
                    </tr>
                    </tbody>
                </table>
            </c:forEach>
        </div>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
