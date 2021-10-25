<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Darazz - ${product.getName()}</title>

</head>
<body>
<%@include file="nav.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-3">
            <img class="img-fluid" src="${pageContext.servletContext.contextPath}/uploads/${product.image}" alt="${product.image}">
        </div>
        <div class="col-6">
            <div class="row">
                <h3 class="text-uppercase">${product.name}</h3>
                <p class="card-text">${product.salesPrice}</p>
                <p class="card-text"><del>${product.regularPrice}</del></p>
                <form action="">
                    <input type="hidden" name="id" value="${product.id}">
                    <div class="input-group mb-3">
                        <span class="input-group-text">Quantity</span>
                        <input type="number" value="1" class="form-control" aria-label="Amount (to the nearest dollar)">
                    </div>
                    <div class="input-group mb-3">
                        <button type="submit" class="btn btn-primary mb-3">Buy Now</button>
                        <button type="button" onclick="getUser('${user}')" class="btn btn-danger mb-3">Add to Cart</button>
                    </div>
                </form>
            </div>
            <div class="row">
                <div class="col">
                    <h4>Product details of ${product.name}</h4>
                    <p>
                        ${product.description}
                    </p>
                </div>
            </div>

        </div>
        <div class="col-3"></div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script>
function getUser(user) {
    if(user==="")
    {
        window.location.replace("http://localhost:8080/daraz/signin");
        console.log(user)
    }else{
        alert("working");
        console.log(user)
    }

}
</script>

</body>
</html>
