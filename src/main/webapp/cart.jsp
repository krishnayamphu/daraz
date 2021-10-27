<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="include/head.jsp"%>
</head>
<body>
<%@include file="nav.jsp"%>
<div class="container">
    <h5 class="py-3">All Items</h5>

    <table class="table table-bordered">
        <%@include file="include/success.jsp"%>
        <%@include file="include/error.jsp"%>
        <thead>
        <tr>
            <th>SN</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${cartItems}" varStatus="i">
            <tr>
                <th>${i.count}</th>
                <td><img width="50px" height="50px" src="${rootPath}/uploads/${item.getImage()}" alt="${item.getName()}"> ${item.getName()}</td>
                <td>${item.getPrice()}</td>
                <td>${item.getQty()}</td>
                <td>${item.getTotal()}</td>
                <td>
                    <a class="btn btn-primary" href="single?pid=${item.getProductId()}">
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                    </a>
                    <!-- Button trigger modal -->
                    <button type="button"
                            class="btn btn-danger"
                            data-bs-toggle="modal"
                            data-bs-target="#modal${item.getProductId()}">
                        <i class="fa fa-trash-o" aria-hidden="true"></i>
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="modal${item.getProductId()}" tabindex="-1">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="${rootPath}/cart-del" method="post">
                                    <input type="hidden" value="${item.getProductId()}" name="pid">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Deleting Item</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <p class="modal-title">Are you sure delete this Item?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                            Cancel
                                        </button>
                                        <button type="submit" class="btn btn-danger">Confirm</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>