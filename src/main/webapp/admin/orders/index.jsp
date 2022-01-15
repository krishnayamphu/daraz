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

<%@include file="../nav.jsp" %>


<div class="container">
    <div class="row justify-content-between py-3">
        <div class="col"><h5>All Orders</h5></div>
    </div>

    <div class="row">
        <div class="col-3">
            <%@include file="../sidebar.jsp" %>
        </div>
        <div class="col-9">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>OrderID #</th>
                    <th>Total Amount</th>
                    <th> Order Date</th>
                    <th> Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${orders}">
                    <tr>
                        <td><a href="${rootPath}/admin/orderItem?id=${item.id}">${item.id}</a></td>
                        <td>${item.getTotalAmount()}</td>
                        <td>${item.createdAt}</td>
                        <td>
                            <a class="btn btn-info" href="${rootPath}/admin/orderItem?id=${item.id}">Process</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
