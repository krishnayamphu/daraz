<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <div class="container">
        <a class="navbar-brand" href="${rootPath}">DARAZZ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="${rootPath}">Home</a>
                </li>
            </ul>
            <form action="${rootPath}/search" class="d-flex mb-0">
                <input name="s" class="form-control search-box me-2" type="search" placeholder="Search">
                <button class="btn btn-search" type="submit">Search</button>
            </form>
            <ul class="navbar-nav mb-2 mb-lg-0">
                <c:choose>
                    <c:when test="${sessionScope.user==null}">
                        <li class="nav-item">
                            <a class="nav-link" href="${rootPath}/signin">Sign in</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${rootPath}/signup">Sign up</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="${rootPath}/cart"><i class="fa fa-shopping-cart"></i> Cart
                                <span class="bg-warning rounded-pill text-white px-2">${cartCount}</span></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                    ${CurrentUser.getFirstname()} ${CurrentUser.getLastname()}
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="${rootPath}/user/profile">Profile</a></li>
                                <li><a class="dropdown-item" href="${rootPath}/order">My Orders</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li>
                                    <form id="usrform" action="${rootPath}/signout" method="post">
                                        <a class="dropdown-item" href="javascript:0"
                                           onclick="document.getElementById('usrform').submit();">Sign out</a>
                                    </form>
                                </li>

                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div>
</nav>

