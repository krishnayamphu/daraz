<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>All Media</title>

</head>
<body>


<%@include file="../admin/nav.jsp"%>

<div class="container">
    <div class="row justify-content-between py-3">
        <div class="col"><h5>All Media</h5></div>
    </div>

    <div class="row">
        <div class="col">
            ${err}
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <%@include file="../admin/sidebar.jsp" %>
        </div>
        <div class="col-9">
            <form  class="row g-3" method="POST" enctype="multipart/form-data" action="media">
                <div class="col-auto">
                    <input class="form-control" type="file" id="formFile" name="myfile" required>
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-primary mb-3">Upload</button>
                </div>
            </form>
            <hr>
            <div class="row row-cols-1 row-cols-md-4 row-cols-lg-6 g-4">
                <c:forEach var="file" items="${files}">
                    <div class="col">
                        <div class="card">
                            <img src="${pageContext.servletContext.contextPath}/uploads/${file.getName()}" class="card-img-top" alt="${file.getName()}">
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
