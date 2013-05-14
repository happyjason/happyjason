<jsp:directive.include file="/WEB-INF/view/jsp/common/header.jsp" />
<%@ page import="org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices" %>
<%@ page import="javax.servlet.http.Cookie" %>

<%
if (request.getSession(false) != null) {
    session.invalidate();
}
Cookie terminate = new Cookie(TokenBasedRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY, null);
String contextPath = request.getContextPath();
terminate.setPath(contextPath != null && contextPath.length() > 0 ? contextPath : "/");
terminate.setMaxAge(0);
response.addCookie(terminate);
%>
<jsp:directive.include file="/WEB-INF/view/jsp/common/footer.jsp" />