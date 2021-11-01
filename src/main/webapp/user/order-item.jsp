<%@ page import="com.aptech.models.Product" %>
<%@ page import="com.aptech.dao.ProductDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp" %>
</head>
<body>
<%@include file="../nav.jsp" %>
<div class="container">
    <form action="${rootPath}/orderItem" method="post">
        <input type="hidden" name="oid" value="${order.id}">
        <div class="row">
            <div class="col-9">
                <div class="row justify-content-between">
                    <h5 class="py-3">Order Details</h5>

                </div>

                <%@include file="../include/success.jsp" %>
                <%@include file="../include/error.jsp" %>
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
            <div class="col-3">
                <h5 class="py-3 text-muted">Total Summary</h5>
                <table class="table table-borderless">
                    <tr>
                        <td>Subtotal</td>
                        <td>Rs. ${order.totalAmount}</td>
                    </tr>
                    <tr>
                        <td>Shipping Fee</td>
                        <td> Rs. 237</td>
                    </tr>
                    <tr>
                        <th>Total</th>
                        <th> Rs. ${order.totalAmount}</th>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <h6 class="bg-light text-muted p-1">Billing Address</h6>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-6">
                <label class="form-label">Fullname</label>
                <input type="text" class="form-control form-control-sm" name="name" value="${order.name}">
            </div>
            <div class="col-6">
                <label class="form-label">Mobile</label>
                <input type="text" class="form-control form-control-sm" name="mobile"
                       value="${order.mobile}">
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-6">
                <label class="form-label">Email</label>
                <input type="email" class="form-control form-control-sm" name="email"
                       value="${order.email}">
            </div>
            <div class="col-6">
                <label class="form-label">Address</label>
                <input type="text" class="form-control form-control-sm" name="address"
                       value="${order.address}">
            </div>
        </div>
        <div class="row mb-3">
            <div class="col">
                <button class="btn btn-sm btn-success" type="submit">PROCEED TO PAY</button>
            </div>
        </div>
    </form>
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
