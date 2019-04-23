
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div style=" min-height: calc(100vh - 130px);">
    <jsp:include page="include/navbar.jsp"/>
</div>

<!-- Full Page Image Header with Vertically Centered Content -->

<jsp:include page="include/footer.jsp"/>

</body>
</html>