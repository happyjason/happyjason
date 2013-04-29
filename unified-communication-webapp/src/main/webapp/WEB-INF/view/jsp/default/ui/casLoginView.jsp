<jsp:directive.include file="includes/header.jsp" />
<head>
    <title><fmt:message key="home.title"/></title>
    <meta name="menu" content="HomeMenu"/>
</head>
<body class="home">
	<div class="login_bg">
		<div class="login_main">
			<div class="login_main_1"></div>
			<div class="login_main_top"></div>
			<div class="login_main_2">
				<div class="login_title"><spring:message code="login.title" /></div>
				<form:form method="post" id="fm1" cssClass="fm-v clearfix" 
					commandName="${commandName}" htmlEscape="true">
					<form:errors path="*" id="msg" cssClass="alert alert-error" element="div" />
					<div class="login_from login_from_z_index">
						<div id="select06" class="selectbox">
							<div class="cartes">
								<span class="login_from_picbig"></span>
								<form:input cssClass="login_txt listTxt" cssErrorClass="alert-error" id="serverUrl" 
									size="25" tabindex="1" path="serverUrl" autocomplete="true" 
									htmlEscape="true" value="http://v.seekoom.com"/>
							</div>
							<div class="lists">
								<ul class="list">
									<li>http://v.seekoom.com</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="login_from  login_from_margintop">
						<span class="login_from_position_picbig"></span>
						<spring:message code="screen.welcome.label.netid" var="userNameAccess" />
						<spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
						<form:input cssClass="login_txt required" cssErrorClass="alert-error" id="username"
							size="25" tabindex="2" accesskey="${userNameAccessKey}" path="username" 
							autocomplete="false" htmlEscape="true" placeholder="${userNameAccess}"/>
					</div>
					<div class="login_from login_from_margintop">
						<span class="login_from_position_picbig login_from_position_picbig1"></span>
						<spring:message code="screen.welcome.label.password" var="passwordAccess" />
						<spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" />
						<form:password cssClass="login_txt required" cssErrorClass="alert-error" id="password" 
							size="25" tabindex="3" accesskey="${passwordAccessKey}" path="password" 
							autocomplete="off" htmlEscape="true" placeholder="${passwordAccess}"/>
					</div>
					<div class="login_from login_from_margintop">
						<div class="login_checkbox1">
							<span class="check_bg1"></span>
							<input type="hidden" name="rememberMe" id="rememberMe" value="false" />
							<i><spring:message code="login.rememberMe" /></i>
							<div class="clear"></div>
						</div>
					</div>
					<div class="login_from login_from_margintop">
						<input type="hidden" name="lt" value="${loginTicket}" />
						<input type="hidden" name="execution" value="${flowExecutionKey}" />
						<input type="hidden" name="_eventId" value="submit" />
						<input class="login_from_btn" name="submit" accesskey="l"
							value="<spring:message code="screen.welcome.button.login" />"
							tabindex="4" type="submit" />
					</div>
				</form:form>
			</div>
			<div class="login_main_footer"></div>
		</div>
	</div>
	<jsp:directive.include file="includes/footer.jsp" />
</body>
