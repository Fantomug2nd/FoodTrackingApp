<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>

<fmt:setBundle basename="messages" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <jsp:include page="${pageContext.request.contextPath}/css/bootstrap_min.jsp"/>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header"><fmt:message key="signup.register"/></div>
                <div class="card-body">
                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/app/signUp">

                        <div class="form-group">
                            <label for="name" class="cols-sm-2 control-label"><fmt:message key="signup.name"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa"
                                                                       aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="name" id="name"
                                           placeholder="<fmt:message key="signup.enter_name"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="surname" class="cols-sm-2 control-label"><fmt:message key="signup.surname"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa"
                                                                       aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="surname" id="surname"
                                           placeholder="<fmt:message key="signup.enter_surname"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="age" class="cols-sm-2 control-label"><fmt:message key="signup.age"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                                    <input type="number" min="1" max="150" class="form-control" name="age" id="age"
                                           placeholder="<fmt:message key="signup.enter_age"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="height" class="cols-sm-2 control-label"><fmt:message key="signup.height"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                                    <input type="number" min="1" max="230" class="form-control" name="height" id="height"
                                           placeholder="<fmt:message key="signup.enter_height"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="weight" class="cols-sm-2 control-label"><fmt:message key="calculator.weight"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                                    <input type="number" min="1" max="300" class="form-control" name="weight" id="weight"
                                           placeholder="<fmt:message key="food.enter_weight"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="login" class="cols-sm-2 control-label"><fmt:message key="signup.login"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="login" id="login"
                                           placeholder="<fmt:message key="signup.enter_login"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label"><fmt:message key="signup.password"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="password" id="password"
                                           placeholder="<fmt:message key="signup.enter_password"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="confirm" class="cols-sm-2 control-label"><fmt:message key="signup.confirmation"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="confirm" id="confirm"
                                           placeholder="<fmt:message key="signup.confirmation"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="confirm" class="cols-sm-2 control-label"><fmt:message key="signup.lifestyle"/></label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <select class="form-control" name="lifestyle" id="lifestyle"/>
                                        <option><fmt:message key="lifestyle.sedentary"/></option>
                                        <option><fmt:message key="lifestyle.light"/></option>
                                        <option><fmt:message key="lifestyle.moderate"/></option>
                                        <option><fmt:message key="lifestyle.active"/></option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group ">
                            <input type="submit" class="btn btn-success btn-lg btn-block login-button"
                                   value="<fmt:message key="signup.register"/>"/>
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