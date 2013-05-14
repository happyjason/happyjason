<jsp:directive.include file="/WEB-INF/view/jsp/common/header.jsp" />
<head>
    <title><fmt:message key="postProfile.title"/></title>
    <meta name="menu" content="PostMenu"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-datepicker.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-timepicker.css'/>" />
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-datepicker.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-timepicker.js'/>"></script>
</head>

<c:set var="delObject" scope="request"><fmt:message key="postList.post"/></c:set>
<script type="text/javascript">
$(function(){
	$(".timepicker-default").timepicker(); 
	$("#appointmentDate").datepicker({
		format: 'yyyy-mm-dd'
	});
});
</script>

<div class="span2">
    <h2><fmt:message key="postProfile.heading"/></h2>
    <p><fmt:message key="postProfile.send.message"/></p>
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

    <form:form commandName="post" method="post" action="notification" id="inviteForm" autocomplete="on"
               cssClass="well form-horizontal" onsubmit="return validateInviteForm(this)">
        <form:hidden path="id"/>
        <form:hidden path="name"/>
        <form:hidden path="version"/>
        <form:hidden path="requirement"/>
        <form:hidden path="responsibility"/>
        <input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

        <spring:bind path="post.recipients">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="postForm.recipients"/>
            <div class="controls">
            	<div class="input-prepend">
            		<span class="add-on"><i class="icon-user"></i></span>
                	<form:input path="recipients" id="recipients"/>
                	<form:errors path="recipients" cssClass="help-inline"/>
                </div>
            </div>
        </fieldset>
        <spring:bind path="post.recipientsEmail">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="postForm.recipientsEmail"/>
            <div class="controls">
            	<div class="input-prepend">
					<span class="add-on"><i class="icon-envelope"></i></span>
					<form:input path="recipientsEmail" id="recipientsEmail" />
                	<form:errors path="recipientsEmail" cssClass="help-inline"/>
				</div>
            </div>
        </fieldset>
        <spring:bind path="post.appointment">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="postForm.appointment"/>
            <div class="controls">
            	<div class="input-prepend bootstrap-datepicker-component">
            		<span class="add-on"><i class="icon-calendar"></i></span>
                	<form:input path="appointmentDate" id="appointmentDate"/>
                </div>
                <div class="input-prepend bootstrap-timepicker-component" style="padding-left:40px">
                	<span class="add-on"><i class="icon-time"></i></span>
                	<form:input path="appointmentTime" id="appointmentTime" class="timepicker-default input-small"/>
                	<form:errors path="appointment" cssClass="help-inline"/>
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
<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
    return validateInviteForm(theForm);
}
</script>
</c:set>

<v:javascript formName="invite1Form" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>

