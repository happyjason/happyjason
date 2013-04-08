<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/common/init.jsp" %>

<%
String jSecurityCheck = "j_security_check";

if (!ServerDetector.isWebSphere()) {
	jSecurityCheck = themeDisplay.getPathMain() + "/portal/" + jSecurityCheck;
}

String jUserName = (String)session.getAttribute("j_username");
String jPassword = (String)session.getAttribute("j_password");

if (PropsValues.PORTAL_JAAS_ENABLE && (user != null)) {
	if (PropsValues.PORTAL_JAAS_AUTH_TYPE.equals("emailAddress")) {
		jUserName = user.getEmailAddress();
	}
	else if (PropsValues.PORTAL_JAAS_AUTH_TYPE.equals("screenName")) {
		jUserName = user.getScreenName();
	}
	else if (PropsValues.PORTAL_JAAS_AUTH_TYPE.equals("login")) {
		jUserName = user.getLogin();
	}
}
%>

<c:choose>
	<c:when test="<%= Validator.isNotNull(jUserName) && Validator.isNotNull(jPassword) %>">
		<html dir="<liferay-ui:message key="lang.dir" />">

		<head>
			<meta content="<%= ContentTypes.TEXT_HTML_UTF8 %>" http-equiv="content-type" />
			<meta content="no-cache" http-equiv="Cache-Control" />
			<meta content="no-cache" http-equiv="Pragma" />
			<meta content="0" http-equiv="Expires" />
			<script src="<%= themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() %>/misc/xp_progress.js" type="text/javascript"></script>
		</head>

		<body onLoad="setTimeout('document.fm.submit()', 100);">

		<center>
<div class="login_center login_bg1">
    <div class="login_bg2">
        <div class="login_logo"><img src="http://img.vcccdn.com/platform/login/allen/1.0.0/login_logo.png"/></div>
        <div class="login_form">
            <div class="login_form_title"><span>登录</span> 最专业的企业协作平台</div>
            <form class="form-horizontal">
                <div class="control-group">
                    <div class="controls controls_position">
                        <span class="controls_position_pic"><i class="controls_position_picbig"></i></span>
                        <input type="text" id="inputEmail" placeholder="Email">
                    </div>
                </div>
                <div class="control-group control-group-top controls_position">
                    <div class="controls">
                        <span class="controls_position_pic"><i class="controls_position_picbig"></i></span>
                        <input type="password" id="inputPassword" placeholder="Password">
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="controls_font">
                            <a href="">忘记密码？</a>
                            <div class="controls_checkbox"><input type="checkbox" name="" > 保持登录状态</div>
                        </div>
                        <button type="submit" class="btn btn-info login_btn login_btn_font">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
		<table border="0" cellpadding="0" cellspacing="0" height="100%" width="600">
		<tr>
			<td align="center" valign="middle">
				<form action="<%= jSecurityCheck %>" method="post" name="fm">
				<input name="j_username" type="hidden" value="<%= HtmlUtil.escapeAttribute(jUserName) %>" />
				<input name="j_password" type="hidden" value="<%= HtmlUtil.escapeAttribute(jPassword) %>" />
				</form>

				<font face="Verdana, Tahoma, Arial" size="3">
				<strong><liferay-ui:message key="processing-login" /></strong>
				</font><br /><br />

				<script type="text/javascript">
					var progressBar = createBar(300, 15, "#FFFFFF", 1, "#000000", "", 85, 7, 3, "");
				</script>
			</td>
		</tr>
		</table>

		</center>

		</body>

		</html>

		<%
		session.removeAttribute("j_username");
		session.removeAttribute("j_password");

		SessionMessages.clear(request);
		SessionErrors.clear(request);
		%>

	</c:when>
	<c:otherwise>

		<!--
		This only happens if you're logged in and the server is rebooted and
		the user's old session is not recovered. Forward the user to the default
		page instead of posting to the protected page with invalid credentials.
		-->

		<%
		try {
			session.invalidate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		%>

		<html dir="<liferay-ui:message key="lang.dir" />">

		<head>
			<title></title>
			<meta content="0; url=<%= themeDisplay.getPathMain() %>" http-equiv="refresh" />
			<meta content="no-cache" http-equiv="Cache-Control" />
			<meta content="no-cache" http-equiv="Pragma" />
			<meta content="0" http-equiv="Expires" />
		</head>

		<body onLoad="javascript:location.replace('<%= themeDisplay.getPathMain() %>')">

		</body>

		</html>
	</c:otherwise>
</c:choose>