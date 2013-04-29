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
	        <li class="active">
	            <a href="<c:url value="/login"/>"><fmt:message key="login.title"/></a>
	        </li>
	    </c:if>
	    <menu:displayMenu name="HomeMenu"/>
	    <menu:displayMenu name="UserMenu"/>
	   	<!--<menu:displayMenu name="TenantMenu"/>-->
	    <menu:displayMenu name="PortalMenu"/>
	    <menu:displayMenu name="PostMenu"/>
	    <menu:displayMenu name="AdminMenu"/>
	    <menu:displayMenu name="Logout"/>
	</ul>
</div>
</menu:useMenuDisplayer>
