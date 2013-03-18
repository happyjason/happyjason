<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="postProfile.title"/></title>
    <meta name="menu" content="PostMenu"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="postList.posts"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="span2">
    <h2><fmt:message key="postProfile.heading"/></h2>
    <c:choose>
        <c:when test="${param.from == 'list'}">
            <p><fmt:message key="postProfile.send.message"/></p>
        </c:when>
        <c:otherwise>
            <p><fmt:message key="postProfile.message"/></p>
        </c:otherwise>
    </c:choose>
</div>
<div class="span7">
    <spring:bind path="post.*">
        <c:if test="${not empty status.errorMessages}">
            <div class="alert alert-error fade in">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br/>
                </c:forEach>
            </div>
        </c:if>
    </spring:bind>

    <form:form commandName="post" method="post" action="profile" id="postForm" autocomplete="off"
               cssClass="well form-horizontal" onsubmit="return validatePostForm(this)">
        <form:hidden path="id"/>
        <form:hidden path="version"/>
        <input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>
        
		<spring:bind path="post.name">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="postForm.name"/>
            <div class="controls">
            	<div class="input-prepend">
	            	<c:choose>
				        <c:when test="${param.method == 'Add'}">
				            <form:input path="name" id="name"/>
				        </c:when>
				        <c:otherwise>
				            <form:input path="name" id="name" disabled="true"/>
				        </c:otherwise>
	    			</c:choose>
	                <form:errors path="name" cssClass="help-inline"/>
                </div>
            </div>
        </fieldset>
        
        <spring:bind path="post.requirement">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="postForm.requirement"/>
            <div class="controls">
            	<div class="input">
                	<form:input path="requirement" id="requirement"/>
                	<form:errors path="requirement" cssClass="help-inline"/>
                </div>
            </div>
        </fieldset>
        <spring:bind path="post.responsibility">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="postForm.responsibility"/>
            <div class="controls">
            	<div class="input">
					<form:input path="responsibility" id="responsibility" />
                	<form:errors path="responsibility" cssClass="help-inline"/>
				</div>
            </div>
        </fieldset>
        <fieldset class="form-actions">
            <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.send"/>
            </button>
            <button type="submit" class="btn" name="cancel" onclick="bCancel=true">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </button>
        </fieldset>
    </form:form>
</div>

<c:set var="scripts" scope="request">
<script type="text/javascript">
    function passwordChanged(passwordField) {
        if (passwordField.id == "password") {
            var origPassword = "${user.password}";
        } else if (passwordField.id == "confirmPassword") {
            var origPassword = "${user.confirmPassword}";
        }

        if (passwordField.value != origPassword) {
            createFormElement("input", "hidden",  "encryptPass", "encryptPass",
                              "true", passwordField.form);
        }
    }

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
    return validateUser(theForm);
}
</script>
</c:set>

<v:javascript formName="user" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>

