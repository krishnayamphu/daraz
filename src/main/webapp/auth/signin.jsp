<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Signin User</title>

</head>
<body>

<%@include file="../nav.jsp"%>

<div class="container">
<div class="row justify-content-center">
    <div class="col-6">
        <h5 class="pt-4">Sign In</h5>
        <form class="row g-3" action="signin" method="post">
            <div class="col-12">
                <%@include file="../include/error.jsp"%>
            </div>
            <div class="col-12">
                <label class="form-label">Ussername</label>
                <input type="text" class="form-control" name="username" required>
            </div>
            <div class="col-12">
                <label class="form-label">Password</label>
                <input type="password" class="form-control" name="password" required>
            </div>
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Sign In</button>
            </div>
        </form>

    </div>
</div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
