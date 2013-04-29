<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>
<html lang="en">
<head>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <c:if test="${not empty requestScope['isMobile'] and not empty mobileCss}">
		<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<!--<link type="text/css" rel="stylesheet" media="screen" href="<c:url value="/css/fss-framework-1.1.2.css" />" />
		<link type="text/css" rel="stylesheet" href="<c:url value="/css/fss-mobile-${requestScope['browserType']}-layout.css" />" />
		<link type="text/css" rel="stylesheet" href="${mobileCss}" />-->
    </c:if>
    <spring:theme code="standard.custom.css.file" var="customCssFile" />
    <link type="text/css" rel="stylesheet" href="<c:url value="${customCssFile}" />" />
    <link rel="icon" href="<c:url value="/images/favicon.ico"/>"/>
    <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-2.2.1.min.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-responsive-2.2.1.min.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/style.css'/>" />
    
	<link href="http://css.vcccdn.com/qjb/1.0.0/chinaunicom/screen.css" rel="stylesheet" type="text/css" />
	<link href="http://css.vcccdn.com/qjb/1.0.0/chinaunicom/style.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="<c:url value='http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-2.2.1.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/plugins/jquery.cookie.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/script.js'/>"></script>
    <decorator:head/>
    <!--[if IE 6]>
		<script src="http://js.vcccdn.com/qjb/chinaunicom/DD_belatedPNG.js"></script>
		<script>DD_belatedPNG.fix('.ind_left_topbg,.ind_left_footbg,.login_from_bg,.login_main_top,.login_main_footer,.login_main_2');</script>
	<![endif]-->
</head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>
    <c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>
    <!--//header--> 
	<header id="header">
		<div class="header">
			<div class="main_center">
				<div class="logo_left"></div>
				<div class="logo_right">
					<nav id="main_menu">
						<%@ include file="/common/menu.jsp" %>
					</nav>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</header>
	
    <div class="content">
        <%@ include file="/common/messages.jsp" %>
        <div class="row-fluid">
            <decorator:body/>

            <c:if test="${currentMenu == 'AdminMenu'}">
                <div class="span2">
                <menu:useMenuDisplayer name="Velocity" config="navlistMenu.vm" permissions="rolesAdapter">
                    <menu:displayMenu name="AdminMenu"/>
                </menu:useMenuDisplayer>
                </div>
            </c:if>
        </div>
    </div>

    <footer id="footer" class="footer">
			<div class="main_center">
				| <a href=""><fmt:message key="screen.footer.label.invite.email"/></a> 
				| <a href=""><fmt:message key="screen.footer.label.help"/></a> 
				| <a href=""><fmt:message key="screen.footer.label.about.me"/></a> 
				| <a href=""><fmt:message key="screen.footer.label.contact.me"/></a>
				| <a href=""><fmt:message key="screen.footer.label.terms.service"/></a> |
			</div>
    </footer>
<%= (request.getAttribute("scripts") != null) ?  request.getAttribute("scripts") : "" %>
</body>
</html>
