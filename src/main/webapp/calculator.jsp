<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>FoodTracking</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet" type="text/css"/>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

    <script src="${pageContext.request.contextPath}/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="table.js"></script>
</head>
<body style="background-color:#FFD772;">
<!-- Navigation -->


<jsp:include page="include/navbar.jsp"/>


<!-- Full Page Image Header with Vertically Centered Content -->
<form class="form-inline  mt-5 justify-content-sm-center " action="${pageContext.request.contextPath}/app/add">
    <div class=" form-group " >
        <label class ="font-weight-bold" for="exampleFormControlSelect1">Select food</label>
        <select class="form-control " id="exampleFormControlSelect1" name="food">
            <c:forEach var="foodItem" items="${food}">
                <option value="<c:out value="${foodItem.id}"/>"><c:out value="${foodItem.name}"></c:out></option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group mx-sm-3 for Number of portions">
        <input type="number" min="1" class="form-control " id="inputPassword2" placeholder="Number of portions" required name="portions">
    </div>
    <button type="submit" class="btn btn-success btn-lg ">Add</button>
</form>


<div class="card" >
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Calculator</h3>
    <div class="card-body">
        <div id="table" class="table-editable">
      <span class="table-add float-right mb-3 mr-2"><a href="#!" class="text-success"><i class="fas fa-plus fa-2x"
                                                                                         aria-hidden="true"></i></a></span>
            <table class="table table-bordered table-responsive-md table-striped text-center">
                <tr>
                    <th class="text-center">Name</th>
                    <th class="text-center">Carbs</th>
                    <th class="text-center">Fat</th>
                    <th class="text-center">Protein</th>
                    <th class="text-center">Calories</th>
                    <th class="text-center">Weight</th>
                    <th class="text-center">Portions</th>

                </tr>
                <c:forEach var="record" items="${records}" >
                    <tr>
                        <td class="pt-3-half" ><c:out value="${record.food.name}"/> </td>
                        <td class="pt-3-half" ><c:out value="${record.food.carbs}"/> </td>
                        <td class="pt-3-half" ><c:out value="${record.food.fat}"/> </td>
                        <td class="pt-3-half" ><c:out value="${record.food.protein}"/> </td>
                        <td class="pt-3-half" ><c:out value="${record.food.calories}"/> </td>
                        <td class="pt-3-half" ><c:out value="${record.food.weight}"/> </td>
                        <td class="pt-3-half"  ><c:out value="${record.portions}" /></td>
                        <%--<td>
                            <span class="table-remove"><button type="button" class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
                        </td>--%>
                    </tr>
                   </c:forEach>
                <tr><td ></td></tr>

                <tr>
                    <th class="pt-3-half" >Total </th>
                    <c:forEach var="i" items="${res}" >
                        <th class="pt-3-half" ><c:out value="${i}"/> </th>
                    </c:forEach>
                    <th class="pt-3-half" >Goal </th>
                    <th class="pt-3-half" ><c:out value="${res[3]}"/> </th>
                </tr>
            </table>
        </div>
    </div>
</div>
<!-- Editable table -->

<%--
<form class="form-inline justify-content-center font-weight-bold">
    <div class="form-group mb-2">
        <label for="result" class="sr-only">Result:</label>
        <input type="text" readonly class="form-control-plaintext" id="result" value="Result:">
    </div>
    <div class="form-group mb-2">
        <label for="intake" class="sr-only">Intake/Goal</label>
        <input type="text" readonly class="form-control-plaintext" id="intake" value="Intake/Goal">
    </div>
    <div class="form-group mb-2">
        <label for="status" class="sr-only"><Status></Status></label>
        <input type="text" readonly class="form-control-plaintext" id="status" value="Status:">
    </div>
    <div class="form-group mb-2">
        <label for="statusResult" class="sr-only">Alert</label>
        <input type="text" readonly class="form-control-plaintext" id="statusResult" value="Alert">
    </div>
</form>--%>






<jsp:include page="include/footer.jsp"/>

</body>
</html>