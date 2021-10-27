<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <%@include file="../head.jsp" %>
</head>
<body>
<%@include file="../nav.jsp" %>

<div class="container">
    <div class="row justify-content-between py-3">
        <div class="col"><h5>Category Details</h5></div>
        <div class="col">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" href="${rootPath}/admin/category">
                        <i class="fa fa-eye"></i>
                        All Categories
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-3">
            <%@include file="../sidebar.jsp" %>
        </div>
        <div class="col-9">
            <form class="row g-3" action="category-edit" method="post">
                <div class="col-12">
                    <%@include file="../success.jsp" %>
                    <%@include file="../error.jsp" %>
                    <input type="hidden" name="id" value="${category.id}">
                </div>

                <div class="col-12">
                    <label class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" value="${category.name}" required>
                </div>
                <div class="col-12">
                    <label class="form-label">Description</label>
                    <textarea class="form-control" name="desc" cols="30" rows="10">${category.description}</textarea>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Update</button>
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
