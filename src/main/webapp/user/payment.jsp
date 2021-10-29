<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp" %>
</head>
<body>
<%@include file="../nav.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-8">
            <h5 class="py-3">Select Payment Method</h5>
            <%@include file="../include/success.jsp" %>
            <%@include file="../include/error.jsp" %>
            <form action="${rootPath}/order" method="post">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="pmt" value="1" checked>
                    <label class="form-check-label">Cash on delivery</label>
                </div>
                <button type="submit">Confirm Order</button>
            </form>

        </div>
        <div class="col-4">
            <h5 class="pt-3 text-muted">Order Summary</h5>
            <table class="table table-borderless">
                <tr>
                    <td>Subtotal (${cartCount} items)</td>
                    <td>Rs. ${orderItem.getTotalAmount()}</td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td> Rs. ${orderItem.getTotalAmount()}</td>
                </tr>
            </table>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
