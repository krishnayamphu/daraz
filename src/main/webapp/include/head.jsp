<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="${rootPath}/assets/css/style.css">
<title>
    <c:choose>
        <c:when test="${pageTitle==null}">
            ${site.getBrand()}
        </c:when>
        <c:otherwise>
            ${site.getBrand()} - ${pageTitle}
        </c:otherwise>
    </c:choose>
</title>