<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setBundle basename="message" />
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <a class="navbar-brand my-0 mr-md-auto font-weight-normal" href="${pageContext.request.contextPath}/">
        <img src="${pageContext.request.contextPath}/img/logo.gif" width="60" height="60" alt="">
    </a>

    <a class="navbar-brand font-weight-normal" href="?locale=en">
        <img src="${pageContext.request.contextPath}/img/eng.png" width="40" height="30" alt="">
    </a>

    <a class="navbar-brand font-weight-normal" href="?locale=uk">
        <img src="${pageContext.request.contextPath}/img/ukr.png" width="40" height="30" alt="">
    </a>
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
