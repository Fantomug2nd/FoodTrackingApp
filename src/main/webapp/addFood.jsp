<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle var="link" basename="message" scope="session"/>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>FoodTrackingApp</title>
    <jsp:include page="${pageContext.request.contextPath}/css/bootstrap_min.jsp"/>
</head>
<body>
<jsp:include page="include/navbar.jsp"/>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header"> <fmt:message key="food.add_food" bundle="${link}"/></div>
                <div class="card-body">
                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/app/addFood/submit">
                        <%--    message--%>


                                <c:if test="${isSubmitted eq true}">
                                    <div class="alert alert-success text-center" role="alert">
                                        Food have been successfully added to your list<br>
                                        Check it out.
                                    </div>
                                </c:if>
                                <c:if test="${error eq true}">
                                    <div class="alert alert-success text-center" role="alert">
                                        Food have been successfully added to your list<br>
                                        Check it out.
                                    </div>
                                </c:if>

                            <div class="form-group">
                            <label for="name" class="cols-sm-2 control-label"><fmt:message key="food.name"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa"
                                                                       aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="name" id="name"
                                           placeholder="<fmt:message key="food.enter_name"/>"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="carbs" class="cols-sm-2 control-label"><fmt:message key="food.carbs"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                                    <input type="number" min="0"  class="form-control" name="carbs" id="carbs"
                                           placeholder="<fmt:message key="food.enter_carbs"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="fat" class="cols-sm-2 control-label"><fmt:message key="food.fat"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                                    <input type="number" min="0"  class="form-control" name="fat" id="fat"
                                           placeholder="<fmt:message key="food.enter_fat"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="protein" class="cols-sm-2 control-label"><fmt:message key="food.protein"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                                    <input type="number" min="0"  class="form-control" name="protein" id="protein"
                                           placeholder="<fmt:message key="food.enter_protein"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="calories" class="cols-sm-2 control-label"><fmt:message key="food.calories"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                                    <input type="number" min="0" class="form-control" name="calories" id="calories"
                                           placeholder="<fmt:message key="food.enter_calories"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="weight" class="cols-sm-2 control-label"><fmt:message key="food.weight"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                                    <input type="number" min="1" class="form-control" name="weight" id="weight"
                                           placeholder="<fmt:message key="food.enter_weight"/>"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group ">
                            <input type="submit" class="btn btn-success btn-lg btn-block login-button"
                                   value="<fmt:message key="food.add_food"/>"/>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/include/footer.jsp"/>
</body>
</html>