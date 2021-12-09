<%@ page import="java.util.List" %>
<%@ page import="com.aptech.dao.ProductDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Products</title>

</head>
<body>

<%@include file="../nav.jsp" %>


<div class="container">
    <div class="row justify-content-between py-3">
        <div class="col"><h5>All Products</h5></div>
        <div class="col">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="product-add"><i class="fa fa-book"></i> Add
                        Product</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col">
            ${err}
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <%@include file="../sidebar.jsp" %>
        </div>
        <div class="col-9">
            <table class="table table-bordered ">
                <thead>
                <tr>
                    <th>SN</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Regular Price</th>
                    <th>Sales Price</th>
                    <th>Category</th>
                    <th>Created Date</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${products}" varStatus="i">
                    <tr>
                        <th>${i.count}</th>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.regularPrice}</td>
                        <td>${product.salesPrice}</td>
                        <td>
                            <c:forEach var="category" items="${product.getCategories(product.id)}">
                                ${category}
                            </c:forEach>
                        </td>
                        <td>${product.createdAt}</td>
                        <td>
                            <a class="btn btn-primary" href="product-edit?id=${product.id}"><i
                                    class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                    data-bs-target="#modal${product.id}">
                                <i class="fa fa-trash-o" aria-hidden="true"></i>
                            </button>
                        </td>


                        <!-- Modal -->
                        <div class="modal fade" id="modal${product.id}" tabindex="-1"
                             aria-labelledby="modal${product.id}"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="modal${product.id}">Deleting Item</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <p class="modal-title" id="modal${product.id}">Are you sure delete this
                                            Item?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                            Cancel
                                        </button>
                                        <form action="${rootPath}/admin/product-del" method="post">
                                            <input type="hidden" value="${product.id}" name="id">
                                            <button type="submit" class="btn btn-danger">Confirm</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
