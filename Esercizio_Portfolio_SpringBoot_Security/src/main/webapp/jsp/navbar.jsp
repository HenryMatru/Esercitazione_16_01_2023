<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="${"/"}">My Portfolio Website</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${"/"}">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${"/skills"}">Skills</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${"/projects"}">Projects</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${"/categories"}">Categories</a>
                </li>
                <sec:authorize access="hasAnyRole('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${"/createProject"}">Create Project</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${"/createSkill"}">Create Skill</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${"/createCategory"}">Create Category</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${"/logout"}">Logout</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${"/login"}">Login</a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>