<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <h3>Update this project</h3><br>
    <form action="${"/updateProject"}" method="post">
        <input type="hidden" name="id" value="${project.id}">
        <div class="mb-3">
            <label for="nameProject" class="form-label">Name: </label>
            <input type="text" value="${project.name}" name="nameProject" class="form-control" id="nameProject">
        </div>
        <div class="mb-3">
            <label for="descriptionProject" class="form-label">Description: </label>
            <input type="text" value="${project.description}" name="descriptionProject" class="form-control" id="descriptionProject">
        </div>
        <div class="mb-3">
            <label for="linkProject" class="form-label">Link: </label>
            <input type="text" value="${project.link}" name="linkProject" class="form-control" id="linkProject">
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
<jsp:include page="script.jsp"></jsp:include>
</html>