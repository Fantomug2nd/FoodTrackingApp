<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>

<fmt:setBundle basename="messages" />

<html>
<head>
    <title>FoodTracking</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet" type="text/css"/>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

    <script src="${pageContext.request.contextPath}/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>



</head>
<body style="background-color:#FFD772;">
<!-- Navigation -->


<jsp:include page="include/navbar.jsp"/>

<form method="get" action="${pageContext.request.contextPath}/app/statistics">
    <div class="form-row justify-content-center">

        <div class="col-auto">
            <label for="checkInInput">Choose Day</label>
            <input class="form-control" type="date" name="date" id="checkInInput" required>
        </div>

        <div class="col-auto">
            <button type="submit" style="margin-top: 30px;" class="btn btn-primary">Ok</button>
        </div>
    </div>
</form>

<c:choose>
<c:when test="${empty records}">
<div class="card" >
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Daily intake</h3>
    <div class="card-body">
        <div id="table1" class="table-editable">
      <span class="table-add float-right mb-3 mr-2"><a href="#!" class="text-success"><i class="fas fa-plus fa-2x"
                                                                                         aria-hidden="true"></i></a></span>
            <table class="table table-bordered table-responsive-md table-striped text-center">
                <tr>
                    <th class="text-center">NO RECORDS ON THIS DAY</th>
                </tr>
            </table>
        </div>
    </div>
</div>
</c:when>
<c:otherwise>
<div class="card" >
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Daily intake</h3>
    <div class="card-body">
        <div id="table" class="table-editable">
      <span class="table-add float-right mb-3 mr-2"><a href="#!" class="text-success"><i class="fas fa-plus fa-2x"
                                                                                         aria-hidden="true"></i></a></span>
            <table class="table table-bordered table-responsive-md table-striped text-center">
                <tr>
                    <th class="text-center align-middle">Name</th>
                    <th class="text-center align-middle">Portions</th>
                    <th class="text-center align-middle">Calories, cal</th>

                </tr>
                <c:forEach var="record" items="${records}" >
                    <tr>
                        <td class="pt-3-half align-middle" ><c:out value="${record.food.name}" /></td>
                        <td class="pt-3-half align-middle" ><c:out value="${record.portions}" /></td>
                        <td class="pt-3-half align-middle" ><c:out value="${record.food.calories*record.portions}" /></td>

                    </tr>
                </c:forEach>
                <tr>
                    <th class="text-center">Total intake, cal</th>
                    <th class="text-center">Goal, cal</th>
                    <th class="text-center">Result</th>
                 </tr>
                <tr>
                    <td class="pt-3-half" ><c:out value="${totalIntake}" /></td>
                    <td class="pt-3-half" ><c:out value="${goalIntake}" /></td>
                    <td>
                        <c:choose>
                            <c:when test="${intakeIsOk}">
                                <div class="alert alert-success " role="alert">
                                    Calories balance is OK
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="alert alert-danger " role="alert">
                                    Your intake is bigger than your goal!!!
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</c:otherwise>
</c:choose>






<jsp:include page="include/footer.jsp"/>

</body>
</html>