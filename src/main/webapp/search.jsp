<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="include/head.jsp"%>
</head>
<body>
<%@include file="nav.jsp"%>
<div class="container">
    <h1>Search Results</h1>
    <div class="row row-cols-1 row-cols-md-4 row-cols-lg-6 g-4">
        <c:forEach var="product" items="${products}">
            <div class="col">
                <div class="card">
                    <a href="${rootPath}/single?id=${product.id}">
                        <img src="${rootPath}/uploads/${product.image}" class="card-img-top" alt="${file.getName()}">
                    </a>
                    <div class="card-body">
                        <a href="${rootPath}/single?pid=${product.id}">

                            <h5 class="card-title">${product.name}</h5>
                        </a>
                        <p class="card-text">${product.salesPrice}</p>
                        <p class="card-text text-muted"><del>${product.regularPrice}</del></p>
                            <%--                        <a href="#" class="btn btn-primary">Go somewhere</a>--%>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
