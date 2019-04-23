<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value = "uk_UA"/>

<fmt:setBundle basename="messages" />
<c:if test="${not empty param.invalidCredentials}">
    <% response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); %>
</c:if>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signin.css">
    <jsp:include page="${pageContext.request.contextPath}/css/bootstrap_min.jsp"/>
    <title>Sign in</title>
</head>
<body style="background-color: #F5F5F5;">
<form class="form-signin" method="post" action="${pageContext.request.contextPath}/app/signIn">
    <div class="container"><h1 class="h3 mb-3 font-weight-normal text-center"><fmt:message key="signin.welcome"/></h1>
        <%--    Error message--%>
        <c:if test="${not empty param.invalidCredentials and param.invalidCredentials eq true}">
            <div class="alert alert-danger text-center" role="alert">
                <fmt:message key="signin"/>
            </div>
        </c:if>
        <%--    Input fields--%>
        <label for="inputLogin" class="sr-only"><fmt:message key="signin.login"/></label>
        <input type="text" id="inputLogin" class="form-control" placeholder="<fmt:message key="signin.login"/>" name="login"
               required
               autofocus
               value="<c:out value="${param.login}" />"
        >
        <label for="inputPassword" class="sr-only"><fmt:message key="signin.password"/></label>
        <input type="password" id="inputPassword" class="form-control" placeholder="<fmt:message key="signin.password"/>" name="password"
               required>
        <div class="text-center mb-3">
            <a href="${pageContext.request.contextPath}/signUp.jsp" class="text-center"><fmt:message key="signin.signup"/></a>
        </div>
        <%--        Sign in button--%>
        <button class="btn btn-lg btn-success btn-block" type="submit"><fmt:message key="signin"/></button>
    </div>
</form>
</body>
</html>