<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!doctype html>
<html>

    <jsp:include page="header.jsp"></jsp:include>

    <body>
        <jsp:include page="navbar.jsp"></jsp:include>

        <c:if test="${operation != null}">
            <div class="alert alert-success" role="alert">
                <p>${operation}</p>
            </div>
        </c:if>

        <div class="text-center">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Link</th>
                        <sec:authorize access="hasAnyRole('ADMIN', 'USER')">
                            <th scope="col">Actions</th>
                        </sec:authorize>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ListProjects}" var="project">
                        <tr>
                            <td>${project.name}</td>
                            <td>${project.description}</td>
                            <td><a href="${project.link}">link repository</a></td>
                            <sec:authorize access="hasAnyRole('ADMIN', 'USER')">
                            <td>
                                <a href="/deleteProject?id=<c:out value="${project.id}"/>"><span class="bi bi-trash" style="font-size: 1rem; color: rgb(255, 0, 0);"></span></a>
                                <a href="/updateProject?id=<c:out value="${project.id}"/>"><span class="bi bi-pencil-fill" style="font-size: 1rem; color: rgb(0, 0, 255);"></span></a>
                            </td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>

    <jsp:include page="script.jsp"></jsp:include>

</html>