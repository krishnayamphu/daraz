<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Add Category</title>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <div class="container">
        <a class="navbar-brand" href="/darazz">DARAZZ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/darazz">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="users">Admin Users</a>
                </li>
            </ul>

            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">${user}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
    <div class="row justify-content-between py-3">
        <div class="col"><h5>Add Category</h5></div>
        <div class="col">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="category"><i class="fa fa-eye"></i> All
                        Categories</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <%@include file="../sidebar.jsp" %>
        </div>
        <div class="col-9">
            <form class="row g-3" action="category-add" method="post">

                <div class="col-12">${err}</div>
                <div class="col-12">
                    <label class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" required>
                </div>
                <div class="col-12">
                    <label class="form-label">Description</label>
                    <textarea class="form-control" name="desc" cols="30" rows="10"></textarea>
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
