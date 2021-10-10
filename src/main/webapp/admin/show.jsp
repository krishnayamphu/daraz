<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Edit Admin User</title>

</head>
<body>

<%@include file="nav.jsp"%>

<div class="container">
    <div class="row justify-content-between py-3">
        <div class="col"> <h5>User Details</h5></div>
        <div class="col">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="users"><i class="fa fa-eye"></i> All Users</a>
                </li>
            </ul>
        </div>
    </div>


    <form class="row g-3" action="admin-add" method="post">
        ${errUser}
    <div class="col-12"> </div>
        <div class="col-md-6">
            <label class="form-label">Firstname</label>
            <input type="text" class="form-control" name="fname" value="${admin.firstname}" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Lastname</label>
            <input type="text" class="form-control" name="lname" value="${admin.lastname}" required>
        </div>
        <div class="col-12">
            <label class="form-label">Username</label>
            <input type="text" class="form-control" name="username" value="${admin.username}" required>
        </div>
        <div class="col-12">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" name="email" value="${admin.email}" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Contact</label>
            <input type="text" class="form-control" name="contact" value="${admin.contact}" required>
        </div>
        <div class="col-md-6">
           <div> <label class="form-label">Gender</label></div>
            <c:choose>
                <c:when test="${admin.gender == 'm'}">

                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="m" checked>
                        <label class="form-check-label">Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="f">
                        <label class="form-check-label">Female</label>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="m">
                        <label class="form-check-label">Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="f" checked>
                        <label class="form-check-label">Female</label>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="col-12">
            <label class="form-label">Address</label>
            <input type="text" class="form-control" name="address" placeholder="City, State " value="${admin.address}" required>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </form>


</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
