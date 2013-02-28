<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="login.title"/></title>
    <meta name="menu" content="Login"/>
</head>
<body id="login">

<form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"
    onsubmit="saveUsername(this);return validateForm(this)" class="form-signin" autocomplete="off">
    <h2 class="form-signin-heading">
        <fmt:message key="login.heading"/>
    </h2>
<c:if test="${param.error != null}">
    <div class="alert alert-error fade in">
        <fmt:message key="errors.password.mismatch"/>
    </div>
</c:if>
    <input type="text" name="j_username" id="j_username" class="input-block-level"
           placeholder="<fmt:message key="label.username"/>" required tabindex="1">
    <input type="password" class="input-block-level" name="j_password" id="j_password" tabindex="2"
           placeholder="<fmt:message key="label.password"/>" required>

<c:if test="${appConfig['rememberMeEnabled']}">
    <label class="checkbox" for="rememberMe">
        <input type="checkbox" class="checkbox" name="_spring_security_remember_me" id="rememberMe" tabindex="3"/>
        <fmt:message key="login.rememberMe"/></label>
</c:if>

    <button type="submit" class="btn btn-large btn-primary" name="login" tabindex="4">
        <fmt:message key='button.login'/>
    </button>
</form>

<p>
    <fmt:message key="login.signup">
        <fmt:param><c:url value="/signup"/></fmt:param>
    </fmt:message>
</p>

<c:set var="scripts" scope="request">
<script type="text/javascript">
if ($.cookie("username") != null && $.cookie("username") != "") {
	$("#j_username").val($.cookie("username"));
	$("#j_password").focus();
} else {
	$("#j_username").focus();
}

function saveUsername(theForm) {
	$.cookie("username", theForm.j_username.value, {
		expires : 30,
		path : "<c:url value="/"/>"
	});
}

function validateForm(form) {
	var valid = validateRequired(form);
	if (valid == false) {
		$(".control-group").addClass('error');
	}
	return valid;
}

function passwordHint() {
	if ($("#j_username").val().length == 0) {
		alert('<fmt:message key="errors.required"><fmt:param><fmt:message key="label.username"/></fmt:param></fmt:message>');
		$("#j_username").focus();
	} else {
		location.href = "<c:url value='/passwordHint'/>?username=" + $("#j_username").val();
	}
}

function required() {
	this.aa = new Array(
			"j_username",
			'<fmt:message key="errors.required"><fmt:param><fmt:message key="label.username"/></fmt:param></fmt:message>',
			new Function("varName", " return this[varName];"));
	this.ab = new Array(
			"j_password",
			'<fmt:message key="errors.required"><fmt:param><fmt:message key="label.password"/></fmt:param></fmt:message>',
			new Function("varName", " return this[varName];"));
}
</script>
</c:set>

<p><fmt:message key="login.passwordHint"/></p>
</body>