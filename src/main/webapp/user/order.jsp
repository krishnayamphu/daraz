<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp" %>
</head>
<body>
<%@include file="../nav.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-8">
            <h5 class="py-3">My Orders</h5>
            <%@include file="../include/success.jsp" %>
            <%@include file="../include/error.jsp" %>
            <c:forEach var="item" items="${orders}">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Order #<a href="${rootPath}/orderItem?id=${item.getId()}">${item.getId()}</a></th>
                    <th>
                        <c:choose>
                            <c:when test="${item.orderStatusId==1}">
                                <a href="#">PAY NOW</a>
                            </c:when>
                            <c:otherwise>
                                <a href="#">MANAGE</a>
                            </c:otherwise>
                        </c:choose>


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
        <div class="col-4">
            <h5 class="pt-3 text-muted">Order Summary</h5>
            <form action="${rootPath}/payment" method="get">
                <table class="table table-borderless">
                    <tr>
                        <td>Subtotal (${cartCount} items)</td>
                        <td>Rs. ${subTotal}</td>
                    </tr>
                    <tr>
                        <td>Shipping Fee</td>
                        <td> Rs. 237</td>
                    </tr>
                    <tr>
                        <td><input class="form-control form-control-sm" type="text" placeholder="Enter discount code">
                        </td>
                        <td>
                            <button class="btn btn-sm btn-info w-100">Apply</button>
                        </td>
                    </tr>
                    <tr>
                        <td>Total</td>
                        <td>
                            <input class="form-control" type="hidden" value="${subTotal}" name="total">
                            Rs. ${subTotal}
                        </td>
                    </tr>
                    <tr class="bg-light text-muted">
                        <td colspan="2">
                            <label class="form-label">Billing Address</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="form-label">Fullname</label>
                            <input type="text" class="form-control form-control-sm" name="name" value="${CurrentUser.getFirstname()} ${CurrentUser.getLastname()}" required>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="form-label">Email</label>
                            <input type="email" class="form-control form-control-sm" name="email" value="${CurrentUser.getEmail()}" required>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="form-label">Mobile</label>
                            <input type="text" class="form-control form-control-sm" name="mobile" value="${CurrentUser.getContact()}" required>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="form-label">Address</label>
                            <input type="text" class="form-control form-control-sm" name="address" value="${CurrentUser.getAddress()}" required>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button class="btn btn-sm btn-success w-100" type="submit">PROCEED TO PAY</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
