<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <th scope="col">Nome</th>
                        <th scope="col">Descrizione</th>
                        <th scope="col">Categoria</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ListSkills}" var="skill">
                        <tr>
                            <td>${skill.name}</td>
                            <td>${skill.description}</td>
                            <td>${skill.category.name}</td>
                            <td>
                                <a href="/deleteSkill?id=<c:out value="${skill.id}"/>"><span class="bi bi-trash" style="font-size: 1rem; color: rgb(255, 0, 0);"></span></a>
                                <a href="/updateSkill?id=<c:out value="${skill.id}"/>"><span class="bi bi-pencil-fill" style="font-size: 1rem; color: rgb(0, 0, 255);"></span></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>

    <jsp:include page="script.jsp"></jsp:include>

</html>
