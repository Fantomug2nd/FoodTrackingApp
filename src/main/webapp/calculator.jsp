


<html >
<head>
    <title>FoodTracking</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet" type="text/css"/>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="messages" />
</head>
<body style="background-color:#FFD772;">
<!-- Navigation -->


<jsp:include page="include/navbar.jsp"/>


<!-- Full Page Image Header with Vertically Centered Content -->
<form class="form-inline  mt-5 justify-content-sm-center " action="${pageContext.request.contextPath}/app/add">
    <div class=" form-group " >
        <label class ="font-weight-bold" for="exampleFormControlSelect1"><fmt:message key="calculator.select_food"/></label>
        <select class="form-control " id="exampleFormControlSelect1" name="food">
            <c:forEach var="foodItem" items="${food}">
                <option value="<c:out value="${foodItem.id}"/>"><c:out value="${foodItem.name}"></c:out>, <c:out value="${foodItem.weight}"></c:out>g,
                    <c:out value="${foodItem.calories}"></c:out>cal</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group mx-sm-3 for Number of portions">
        <input type="number" min="1" class="form-control " id="inputPassword2" placeholder="<fmt:message key="calculator.number_of_portions"/>" required name="portions">
    </div>
    <button type="submit" class="btn btn-success btn-lg "><fmt:message key="calculator.add"/></button>
</form>


<div class="card" >
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4"><fmt:message key="calculator"/></h3>
    <div class="card-body">
        <div id="table" class="table-editable">
      <span class="table-add float-right mb-3 mr-2"><a href="#!" class="text-success"><i class="fas fa-plus fa-2x"
                                                                                         aria-hidden="true"></i></a></span>
            <table class="table table-bordered table-responsive-md table-striped text-center">
                <tr>
                    <th class="text-center"><fmt:message key="calculator.name"/></th>
                    <th class="text-center"><fmt:message key="calculator.carbs"/></th>
                    <th class="text-center"><fmt:message key="calculator.fat"/></th>
                    <th class="text-center"><fmt:message key="calculator.protein"/></th>
                    <th class="text-center"><fmt:message key="calculator.calories"/></th>
                    <th class="text-center"><fmt:message key="calculator.weight"/></th>
                    <th class="text-center"><fmt:message key="calculator.portions"/></th>
                    <th class="text-center"><fmt:message key="calculator.update"/></th>
                    <th class="text-center"><fmt:message key="calculator.remove"/></th>

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
                        <td>
                            <form class="form-inline" action="${pageContext.request.contextPath}/app/updateRecord">
                                <div class="input-group">
                                            <input type="number" min="1"  required class="form-control" name="updatedPortions" id="updatedPortions"
                                                   placeholder="<fmt:message key="calculator.number_of_portions"/>"/>
                                </div>

                                <button type="submit" name="recordId" class="btn btn-success btn-rounded  my-0" value="<c:out value="${record.id}"/>"><fmt:message key="calculator.update"/></button>
                            </form>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/app/removeRecord">
                                <button type="submit" name="recordId" class="btn btn-danger btn-rounded btn-sm my-0" value="<c:out value="${record.id}"/>"><fmt:message key="calculator.remove"/></button>
                            </form>
                        </td>
                    </tr>
                   </c:forEach>
                <tr><td ></td></tr>

                <tr>
                    <th class="pt-3-half" ><fmt:message key="calculator.total"/> </th>
                    <c:forEach var="i" items="${res}" >
                        <th class="pt-3-half" ><c:out value="${i}"/> </th>
                    </c:forEach>
                    <th class="pt-3-half" ><fmt:message key="calculator.goal"/> </th>
                    <th class="pt-3-half" ><c:out value="${res[4]}"/> </th>
                </tr>
            </table>
        </div>
    </div>
</div>




<c:choose>
    <c:when test="${intakeIsOk}">
        <div class="alert alert-success mt-2 col-md-12" role="alert">
            <fmt:message key="alert.ok"/>        </div>
    </c:when>
    <c:otherwise>
        <div class="alert alert-danger justify-content-center mt-2 col-md-12 font-weight-bold" role="alert">
            <fmt:message key="alert.danger"/>
        </div>
    </c:otherwise>
</c:choose>

<jsp:include page="include/footer.jsp"/>

</body>
</html>