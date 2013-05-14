<jsp:directive.include file="/WEB-INF/view/jsp/common/header.jsp" />

<head>
    <title><fmt:message key="page.home.title"/></title>
    <meta name="menu" content="HomeMenu"/>
</head>
<body class="home">

<h2><fmt:message key="page.home.heading"/></h2>
<p><fmt:message key="page.home.message"/></p>

<ul class="glassList">
    <li>
        <a href="<c:url value='/userform'/>"><fmt:message key="menu.user"/></a>
    </li>
    <li>
        <a href="<c:url value='/fileupload'/>"><fmt:message key="menu.selectFile"/></a>
    </li>
</ul>
</body>
