<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="container">
        <h3>Create a new project</h3><br>
        <form action="${"/createProject"}" method="post">
            <div class="mb-3">
                <label for="nameProject" class="form-label">Name: </label>
                <input type="text" name="nameProject" class="form-control" id="nameProject">
            </div>
            <div class="mb-3">
                <label for="descriptionProject" class="form-label">Description: </label>
                <input type="text" name="descriptionProject" class="form-control" id="descriptionProject">
            </div>
            <div class="mb-3">
                <label for="linkProject" class="form-label">Link: </label>
                <input type="text" name="linkProject" class="form-control" id="linkProject">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    </body>
    <jsp:include page="script.jsp"></jsp:include>
</html>