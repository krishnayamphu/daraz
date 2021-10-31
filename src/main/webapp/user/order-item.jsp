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
    <div class="row">
        <div class="col-12">
            <h5 class="py-3">Order Details</h5>
            <%@include file="../include/success.jsp" %>
            <%@include file="../include/error.jsp" %>
            <table class="table table-bordered">
                <tr>
                    <td>
                        Order #${order.id}
                        <small class="text-muted">Placed on ${order.createdAt}</small>
                    </td>
                    <td><span class="text-muted">Total</span> Rs. 100</td>
                </tr>
                </tbody>
            </table>

            <table class="table table-bordered">
                <thead>
                <tr>
                    <th colspan="3">Product Details</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${orderItems}">
                    <tr>
                        <td><img width="50" src="${rootPath}/uploads/${item.getProduct().getImage()}"
                                 alt="">${item.getProduct().getName()}</td>
                        <td>Rs. ${item.getPrice()}</td>
                        <td><span class="text-muted">Qty:</span> ${item.getQty()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="row">
                <div class="col-6">
                    <table class="table table-borderless">
                        <tr class="bg-light text-muted">
                            <td colspan="2">
                                <label class="form-label">Billing Address</label>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <label class="form-label">Fullname</label>
                                <input type="text" class="form-control form-control-sm" name="name"
                                       value="${CurrentUser.getFirstname()} ${CurrentUser.getLastname()}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <label class="form-label">Email</label>
                                <input type="email" class="form-control form-control-sm" name="email"
                                       value="${CurrentUser.getEmail()}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <label class="form-label">Mobile</label>
                                <input type="text" class="form-control form-control-sm" name="mobile"
                                       value="${CurrentUser.getContact()}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <label class="form-label">Address</label>
                                <input type="text" class="form-control form-control-sm" name="address"
                                       value="${CurrentUser.getAddress()}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <form action="${rootPath}/payment" method="get">
                                    <input type="hidden" name="oid" value="${order.id}">
                                    <button class="btn btn-sm btn-success w-100" type="submit">PROCEED TO PAY</button>
                                </form>
                                  </td>
                        </tr>
                    </table>
                </div>
                <div class="col-6">
                    <h5 class="pt-3 text-muted">Total Summary</h5>
                    <form action="${rootPath}/payment" method="get">
                        <table class="table table-borderless">
                            <tr>
                                <td>Subtotal</td>
                                <td>Rs. ${subTotal}</td>
                            </tr>
                            <tr>
                                <td>Shipping Fee</td>
                                <td> Rs. 237</td>
                            </tr>
                            <tr>
                                <td>Total</td>
                                <td> Rs. ${subTotal}</td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>


        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
