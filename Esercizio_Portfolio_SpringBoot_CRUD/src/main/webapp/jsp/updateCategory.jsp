<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <h3>Update this category</h3><br>
    <form action="${"/updateCategory"}" method="post">
        <input type="hidden" name="id" value="${category.id}">
        <div class="mb-3">
            <label for="nameCategory" class="form-label">Name: </label>
            <input type="text" value="${category.name}" name="nameCategory" class="form-control" id="nameCategory">
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
<jsp:include page="script.jsp"></jsp:include>
</html>