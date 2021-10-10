<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Signup User</title>

</head>
<body>

<%@include file="../nav.jsp"%>

<div class="container">
    <div class="row justify-content-between py-3">
        <div class="col"> <h5>Sign up</h5></div>
    </div>

<div class="row">
    <div class="col-12">
        <form class="row g-3" action="signup" method="post">
            <div class="col-12">${errUser}</div>
            <div class="col-md-6">
                <label class="form-label">Firstname</label>
                <input type="text" class="form-control" name="fname" required>
            </div>
            <div class="col-md-6">
                <label class="form-label">Lastname</label>
                <input type="text" class="form-control" name="lname" required>
            </div>
            <div class="col-12">
                <label class="form-label">Username</label>
                <input type="text" class="form-control" name="username" required>
            </div>
            <div class="col-md-6">
                <label class="form-label">Password</label>
                <input type="password" class="form-control" name="password" required>
            </div>
            <div class="col-md-6">
                <label class="form-label">Confirmed Password</label>
                <input type="password" class="form-control" name="cpassword" required>
            </div>
            <div class="col-12">
                ${err}
            </div>
            <div class="col-12">
                <label class="form-label">Email</label>
                <input type="email" class="form-control" name="email" required>
            </div>
            <div class="col-md-6">
                <label class="form-label">Contact</label>
                <input type="text" class="form-control" name="contact" required>
            </div>
            <div class="col-md-6">
                <div> <label class="form-label">Gender</label></div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" value="m" checked>
                    <label class="form-check-label">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" value="f">
                    <label class="form-check-label">Female</label>
                </div>
            </div>

            <div class="col-12">
                <label class="form-label">Address</label>
                <input type="text" class="form-control" name="address" placeholder="City, State " required>
            </div>

            <div class="col-12">
                <button type="submit" class="btn btn-primary">Sign up</button>
            </div>
        </form>

    </div>
</div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
