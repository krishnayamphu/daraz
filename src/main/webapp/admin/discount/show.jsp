<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Coupon Details</title>

</head>
<body>

<%@include file="../nav.jsp"%>

<div class="container">
    <div class="row justify-content-between py-3">
        <div class="col"><h5>Coupon Details</h5></div>
        <div class="col">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${rootPath}/admin/coupons"><i class="fa fa-eye"></i> All
                        Coupons</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <%@include file="../sidebar.jsp" %>
        </div>
        <div class="col-9">
            <form class="row g-3" action="${rootPath}/admin/discount-edit" method="post">
                <input type="hidden" name="id" value="${coupon.id}">
                <div class="col-12">
                    <%@include file="../success.jsp" %>
                    <%@include file="../error.jsp"%>
                </div>
                <div class="col-12">
                    <label class="form-label">Code</label>
                    <input type="text" class="form-control" name="code" value="${coupon.code}" required>
                </div>
                <div class="col-12">
                    <label class="form-label">Discription</label>
                    <textarea name="desc" class="form-control" rows="5">${coupon.description}</textarea>
                </div>
                <div class="col-6">
                    <label class="form-label">Discount Type</label>
                    <select class="form-select" aria-label="Default select example" name="discount_type">
                        <option selected>Percentage discount</option>
                    </select>
                </div>
                <div class="col-6">
                    <label class="form-label">Discount Percentage</label>
                    <input type="number" class="form-control" name="discount_percentage" value="${coupon.discountPercentage}" required>
                </div>
                <div class="col-6">
                    <label class="form-label">Minimum Spend</label>
                    <input type="number" class="form-control" name="min_spend" value="${coupon.minSpendAmount}" required>
                </div>
                <div class="col-6">
                    <label class="form-label">Expired Date</label>
                    <input type="date" class="form-control" name="expired_date" value="${coupon.expiredAt}" required>
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
