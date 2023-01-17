<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <p>Are you sure you want to delete this skill?</p>
    <form action="${"/deleteSkill"}" method="post">
        <input type="hidden" name="id" value="${skill.id}">
        <div class="mb-3">
            <label for="skillName" class="form-label">Name: </label>
            <input type="text" name="skillName" value="${skill.name}" class="form-control" id="skillName">
        </div>
        <div class="mb-3">
            <label for="skillDescription" class="form-label">Description: </label>
            <input type="text" name="skillDescription" value="${skill.description}" class="form-control" id="skillDescription">
        </div>
        <div class="mb-3">
            <label for="skillCategory" class="form-label">Category: </label>
            <input type="text" name="skillCategory" value="${skill.category.name}" class="form-control" id="skillCategory">
        </div>
        <button type="submit" class="btn btn-primary">Delete</button>
    </form>
</div>
<br><br>
</body>
<jsp:include page="script.jsp"></jsp:include>
</html>