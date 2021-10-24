<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Darazz - Home</title>

</head>
<body>
<%@include file="nav.jsp"%>
<div class="container">
    <h1>Homepage</h1>
    <div class="row row-cols-1 row-cols-md-4 row-cols-lg-6 g-4">
        <c:forEach var="product" items="${products}">
            <div class="col">
                <div class="card">
                    <a href="${pageContext.servletContext.contextPath}/single?id=${product.id}">
                    <img src="${pageContext.servletContext.contextPath}/uploads/${product.image}" class="card-img-top" alt="${file.getName()}">
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">${product.salesPrice}</p>
                        <p class="card-text"><del>${product.regularPrice}</del></p>
<%--                        <a href="#" class="btn btn-primary">Go somewhere</a>--%>
                    </div>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
