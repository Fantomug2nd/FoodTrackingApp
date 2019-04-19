<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <a class="navbar-brand my-0 mr-md-auto font-weight-normal" href="${pageContext.request.contextPath}/">
        <img src="${pageContext.request.contextPath}/img/logo.gif" width="60" height="60" alt="">
    </a>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="${pageContext.request.contextPath}/app/calculator">Calculator</a>
        <a class="p-2 text-dark" href="${pageContext.request.contextPath}/app/statistics">Statistics</a>

    </nav>
    <c:choose>
        <c:when test="${not empty navbarPath}">
            <jsp:include page="${navbarPath}"/>
        </c:when>
        <c:otherwise>
            <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/signIn.jsp"
               style="margin-left: 10px">Sign in</a>
        </c:otherwise>
    </c:choose>
</div>
