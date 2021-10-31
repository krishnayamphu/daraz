<%@ page import="java.util.List" %>
<%@ page import="com.aptech.dao.ProductDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>All Orders</title>

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
                        <th>Order #<a href="${rootPath}/orderItem?id=${item.getId()}">${item.getId()}</a></th>
                        <th>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${item.getName()}</td>
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
