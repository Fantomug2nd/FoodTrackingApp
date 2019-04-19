<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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




<jsp:include page="include/footer.jsp"/>

</body>
</html>