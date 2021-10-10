<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>User Login</title>

</head>
<body>
<%@include file="../nav.jsp"%>

<div class="container">
   <div class="row justify-content-center mt-5 pt-5">
       <div class="col-6">
           <form action="signin" method="post">
               ${error}
               <div class="mb-3">
                   <label class="form-label">Username</label>
                   <input type="text" class="form-control" name="username" placeholder="username" required>

               </div>
               <div class="mb-3">
                   <label class="form-label">Password</label>
                   <input type="password" class="form-control" name="password" placeholder="password" required>
               </div>
               <button type="submit" class="btn btn-primary">Sign In</button>
           </form>
       </div>
   </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
