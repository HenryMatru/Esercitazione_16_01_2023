<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <h3>Update this skill</h3><br>
    <form action="${"/updateSkill"}" method="post">
        <input type="hidden" name="id" value="${skill.id}">
        <div class="mb-3">
            <label for="nameSkill" class="form-label">Name: </label>
            <input type="text" value="${skill.name}" name="nameSkill" class="form-control" id="nameSkill">
        </div>
        <div class="mb-3">
            <label for="descriptionSkill" class="form-label">Description: </label>
            <input type="text" value="${skill.description}" name="descriptionSkill" class="form-control" id="descriptionSkill">
        </div>
        <div class="mb-3">
            <label for="categorySkill" class="form-label">Category: </label>
            <select class="form-select" aria-label="Default select example" value="${skill.category.name}" name="categorySkill" id="categorySkill">
                <c:forEach items="${ListCategories}" var="category">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
<jsp:include page="script.jsp"></jsp:include>
</html>