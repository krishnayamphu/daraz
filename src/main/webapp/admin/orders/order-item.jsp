<%@ page import="java.util.List" %>
<%@ page import="com.aptech.dao.ProductDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>All Order Items</title>

</head>
<body>

<%@include file="../nav.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-8">
            <div class="row justify-content-between">
                <h5 class="py-3">Order Summary</h5>
            </div>

            <%@include file="../success.jsp" %>
            <%@include file="../error.jsp" %>
            <table class="table table-bordered">
                <tr>
                    <td>
                        Order #${order.id}
                        <small class="text-muted">Placed on ${order.createdAt}</small>
                    </td>
                    <td><span class="text-muted">Total</span> Rs. ${order.totalAmount}</td>
                </tr>
                </tbody>
            </table>

            <table class="table table-bordered">
                <thead>
                <tr>
                    <th colspan="3">Items</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${orderItems}">
                    <tr>
                        <td><img width="50" class="me-2" src="${rootPath}/uploads/${item.getProduct().getImage()}"
                                 alt="">${item.getProduct().getName()}</td>
                        <td>Rs. ${item.getPrice()}</td>
                        <td><span class="text-muted">Qty:</span> ${item.getQty()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-4">
            <h6 class="bg-light text-muted my-4 p-2">Billing Address</h6>
            <div class="row mb-3">
                <div class="col-4">Fullname</div>
                <div class="col-8">${order.name} </div>
            </div>
            <div class="row mb-3">
                <div class="col-4">Mobile</div>
                <div class="col-8">${order.mobile} </div>
            </div>
            <div class="row mb-3">
                <div class="col-4">Email</div>
                <div class="col-8">${order.email} </div>
            </div>
            <div class="row mb-3">
                <div class="col-4">Address</div>
                <div class="col-8">${order.address} </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <c:if test="${order.orderStatusId==2}">
                <form action="${rootPath}/order-cancel" method="post">
                    <input type="hidden" name="oid" value="${order.id}">
                    <button class="btn btn-sm btn-warning" type="submit">Cancel Order</button>
                </form>
            </c:if>
        </div>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
