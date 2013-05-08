<%@ include file="/common/taglibs.jsp"%>
<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
<c:choose>
	<c:when test="${empty pageContext.request.remoteUser}">   
		<span>HI</span>, Please Login.
	</c:when>
	<c:otherwise>
		<span>HI</span>, ${pageContext.request.remoteUser}
	</c:otherwise>
</c:choose>
<div class="menu_wrap">
	<ul class="nav sf-menu sf-js-enabled">
	    <c:if test="${empty pageContext.request.remoteUser}">
	        <li class="menu-level-1 active">
	            <a href="<c:url value="/login"/>"><fmt:message key="login.title"/></a>
	        </li>
	    </c:if>
	    <menu:displayMenu name="HomeMenu"/>
	    <menu:displayMenu name="UserMenu"/>
	   	<!--<menu:displayMenu name="TenantMenu"/>-->
	    <%-- <menu:displayMenu name="PortalMenu"/> --%>
	    <c:if test="${!empty pageContext.request.remoteUser}">
	        <li><a href="javascript:void(0);" id="index"><fmt:message key="screen.menu.label.name"/></a></li>
			<li><a href="javascript:void(0);" id="myroom"><fmt:message key="screen.menu.label.mine"/></a></li>
			<li><a href="javascript:void(0);" id="call"><fmt:message key="screen.menu.label.groupcall"/></a></li>
			<li><a href="javascript:void(0);" id="current_call"><fmt:message key="screen.menu.label.currentcal"/></a></li>
	    </c:if>
	    <menu:displayMenu name="PostMenu"/>
	    <menu:displayMenu name="AdminMenu"/>
	    <menu:displayMenu name="Logout"/>
	</ul>
</div>
</menu:useMenuDisplayer>
