<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp" %>
</head>
<body>
<%@include file="../nav.jsp" %>
<div class="container">
    <h5 class="py-3">My Orders</h5>
    <%@include file="../include/success.jsp" %>
    <%@include file="../include/error.jsp" %>
    <div class="row">
        <div class="col-12">
            <c:forEach var="item" items="${orders}">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th colspan="3">Order #<a href="${rootPath}/orderItem?id=${item.id}">${item.id}</a></th>
                        <th>
                            <c:choose>
                                <c:when test="${item.orderStatusId==1}">
                                    <a href="${rootPath}/orderItem?id=${item.id}">PAY NOW</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${rootPath}/orderItem?id=${item.id}">MANAGE</a>
                                </c:otherwise>
                            </c:choose>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <small class="text-muted">
                                Placed on: <em>${item.createdAt}</em><br>
                                    ${item.name}<br>
                                Mobile: ${item.mobile}<br>
                                    ${item.address}
                            </small>
                        </td>
                        <td>
                            <small class="text-muted">Total Amount: Rs. ${item.totalAmount}</small>
                        </td>
                        <td>
                            <small class="text-muted rounded-pill bg-grey-50 p-1 d-inline-block">
                                <c:choose>
                                    <c:when test="${item.orderStatusId==1}">
                                       Pending to Pay
                                    </c:when>
                                    <c:when test="${item.orderStatusId==2}">
                                        In Progress
                                    </c:when>
                                    <c:when test="${item.orderStatusId==3}">
                                        On the Way
                                    </c:when>
                                    <c:when test="${item.orderStatusId==4}">
                                       Delivered
                                    </c:when>
                                    <c:when test="${item.orderStatusId==5}">
                                        Cancellation in Progress
                                    </c:when>
                                    <c:otherwise>
                                        Cancelled
                                    </c:otherwise>
                                </c:choose>
                            </small>
                        </td>
                        <td>
                            <small class="text-muted">Delivered on: </small>
                        </td>
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
