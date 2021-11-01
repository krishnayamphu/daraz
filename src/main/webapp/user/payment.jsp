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
            <%@include file="../include/error.jsp" %>
            <div class="card mt-5">
                <div class="card-body">
                    <h6 class="text-uppercase text-muted mb-3">Select Payment Method</h6>
                    <form action="${rootPath}/payment" method="post">
                        <input type="hidden" name="oid" value="${oid}">
                        <div class="row">
                            <div class="col-12 mb-3">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="pmt" value="1" checked>
                                    <label class="form-check-label">Cash on Delivery</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="pmt" value="2">
                                    <label class="form-check-label">ESEWA</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <button class="btn btn-success" type="submit">Confirm Order</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-4">
            <h5 class="pt-5 text-muted">Order Summary</h5>
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
