<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
    <div class="container">
        <p>Are you sure you want to delete this category?</p>
        <form action="${"/deleteCategory"}" method="post">
            <input type="hidden" name="id" value="${category.id}">
            <div class="mb-3">
                <label for="categoryName" class="form-label">Name: </label>
                <input type="text" name="categoryName" value="${category.name}" class="form-control" id="categoryName">
            </div>
            <button type="submit" class="btn btn-primary">Delete</button>
        </form>
    </div>
<br><br>
</body>
<jsp:include page="script.jsp"></jsp:include>
</html>