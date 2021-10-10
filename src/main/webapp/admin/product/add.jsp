<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Add Product</title>

</head>
<body>

<%@include file="../nav.jsp"%>

<div class="container">
    <div class="row justify-content-between py-3">
        <div class="col"><h5>Add Product</h5></div>
        <div class="col">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="products"><i class="fa fa-eye"></i> All
                        Products</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <%@include file="../sidebar.jsp" %>
        </div>
        <div class="col-9">
            <form class="row g-3" action="product-add" method="post">

                <div class="col-12">${err}</div>
                <div class="col-12">
                    <label class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" required>
                </div>
                <div class="col-4">
                    <label class="form-label">SKU</label>
                    <input type="text" class="form-control" name="sku" required>
                </div>
                <div class="col-4">
                    <label class="form-label">Regular Price</label>
                    <input type="number" class="form-control" name="rg_price" required>
                </div>
                <div class="col-4">
                    <label class="form-label">Sales Price</label>
                    <input type="number" class="form-control" name="sa_price" required>
                </div>
                <div class="col-12">
                    <label class="form-label">Description</label>
                    <textarea class="form-control" name="desc" cols="30" rows="10"></textarea>
                </div>
                <div class="col-4">
                    <label class="form-label">Category</label>
                    <select class="form-select" aria-label="Default select example" name="cat_id">
                        <option selected>select category</option>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-4">
                    <label class="form-label">Image</label>
                    <div class="input-group mb-3">
                        <button class="btn btn-outline-secondary" type="button" data-bs-toggle="modal"
                                data-bs-target="#modalImg" id="button-addon1">Choose</button>
                        <input type="text" class="form-control" id="imgName" name="image">

                        <!-- Modal -->
                        <div class="modal fade" id="modalImg" tabindex="-1" aria-labelledby="modalImg"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">All Media Files</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="row row-cols-1 row-cols-md-4 row-cols-lg-4 g-4">
                                                <c:forEach var="file" items="${files}">
                                                    <div class="col">
                                                        <div class="card">
                                                            <img onclick="document.getElementById('currentImgName').value='${file.getName()}'" src="${pageContext.servletContext.contextPath}/uploads/${file.getName()}" class="card-img-top" alt="${file.getName()}">
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <div class="input-group mb-3">
                                                <input type="text" class="form-control" id="currentImgName">
                                            </div>
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                            </button>
                                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="document.getElementById('imgName').value=document.getElementById('currentImgName').value">Select</button>
                                        </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Create</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
