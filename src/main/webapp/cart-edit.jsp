<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="include/head.jsp"%>
</head>
<body>
<%@include file="nav.jsp"%>
<div class="container">
    <h5>Update Item</h5>
    <div class="row mt-5">
        <div class="col-3">
            <img class="img-fluid" src="${rootPath}/uploads/${product.image}" alt="${product.image}">
        </div>
        <div class="col-6">
            <div class="card border-0 mb-3">
                <h3 class="text-uppercase">${product.name}</h3>
                <p class="card-text"><strong>${product.salesPrice}</strong> <del>${product.regularPrice}</del></p>
                <p class="card-text"></p>
            </div>
            <form action="${rootPath}/cart-edit" method="post">
                <input type="hidden" name="pid" value="${product.id}">
                <input type="hidden" name="price" value="${product.salesPrice}">
                <div class="input-group mb-4">
                    <span class="input-group-text">Quantity</span>
                    <input type="number" name="qty" value="${cart.qty}" class="form-control">
                </div>
                <div class="input-group mb-3">
                    <button type="submit" class="btn btn-danger mb-3">Update Cart</button>
                </div>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
