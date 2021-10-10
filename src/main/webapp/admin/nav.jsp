<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.servletContext.contextPath}">DARAZZ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/admin/dashboard">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/admin/users">Admin Users</a>
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

