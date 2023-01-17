<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <p>Are you sure you want to delete this project?</p>
    <form action="${"/deleteProject"}" method="post">
        <input type="hidden" name="id" value="${project.id}">
        <div class="mb-3">
            <label for="projectName" class="form-label">Name: </label>
            <input type="text" name="projectName" value="${skill.name}" class="form-control" id="projectName">
        </div>
        <div class="mb-3">
            <label for="projectDescription" class="form-label">Description: </label>
            <input type="text" name="projectDescription" value="${project.description}" class="form-control" id="projectDescription">
        </div>
        <div class="mb-3">
            <label for="projectLink" class="form-label">Link: </label>
            <input type="text" name="projectLink" value="${project.link}" class="form-control" id="projectLink">
        </div>
        <button type="submit" class="btn btn-primary">Delete</button>
    </form>
</div>
<br><br>
</body>
<jsp:include page="script.jsp"></jsp:include>
</html>