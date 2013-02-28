<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="signup.title"/></title>
</head>

<body class="signup"/>

<div class="span2">
    <h2><fmt:message key="signup.heading"/></h2>
    <p><fmt:message key="signup.message"/></p>
</div>
<div class="span7">
    <spring:bind path="userForm.*">
        <c:if test="${not empty status.errorMessages}">
            <div class="alert alert-error fade in">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br/>
                </c:forEach>
            </div>
        </c:if>
    </spring:bind>

    <form:form commandName="userForm" method="post" action="signup" id="signupForm" autocomplete="off"
               cssClass="well form-horizontal" onsubmit="return validateUserForm(this)">
        <spring:bind path="userForm.username">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="userForm.username"/>
            <div class="controls">
                <form:input path="username" id="username"/>
                <form:errors path="username" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="userForm.password">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="userForm.password"/>
            <div class="controls">
                <form:password path="password" id="password" showPassword="true"/>
                <form:errors path="password" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="userForm.confirmPassword">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="userForm.confirmPassword"/>
            <div class="controls">
                <form:password path="confirmPassword" id="confirmPassword" showPassword="true"/>
                <form:errors path="confirmPassword" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="userForm.firstName">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="userForm.firstName"/>
            <div class="controls">
                <form:input path="firstName" id="firstName" maxlength="50"/>
                <form:errors path="firstName" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="userForm.lastName">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="userForm.lastName"/>
            <div class="controls">
                <form:input path="lastName" id="lastName" maxlength="50"/>
                <form:errors path="lastName" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="userForm.email">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="userForm.email"/>
            <div class="controls">
                <form:input path="email" id="email"/>
                <form:errors path="email" cssClass="help-inline"/>
            </div>
        </fieldset>
        <fieldset class="control-group">
            <appfuse:label styleClass="control-label" key="userForm.phoneNumber"/>
            <div class="controls">
                <form:input path="phoneNumber" id="phoneNumber"/>
            </div>
        </fieldset>
        <fieldset class="control-group">
            <appfuse:label styleClass="control-label" key="userForm.website"/>
            <div class="controls">
                <form:input path="website" id="website"/>
            </div>
        </fieldset>
        <fieldset>
            <legend class="accordion-heading">
                <a data-toggle="collapse" href="#collapse-address"><fmt:message key="userForm.address.address"/></a>
            </legend>
            <div id="collapse-address" class="accordion-body collapse">
                <fieldset class="control-group">
                    <appfuse:label styleClass="control-label" key="userForm.address.address"/>
                    <div class="controls">
                        <form:input path="address.address" id="address.address"/>
                    </div>
                </fieldset>
                <fieldset class="control-group">
                    <appfuse:label styleClass="control-label" key="userForm.address.city"/>
                    <div class="controls">
                        <form:input path="address.city" id="address.city"/>
                    </div>
                </fieldset>
                <fieldset class="control-group">
                    <appfuse:label styleClass="control-label" key="userForm.address.province"/>
                    <div class="controls">
                        <form:input path="address.province" id="address.province"/>
                    </div>
                </fieldset>
                <fieldset class="control-group">
                    <appfuse:label styleClass="control-label" key="userForm.address.postalCode"/>
                    <div class="controls">
                        <form:input path="address.postalCode" id="address.postalCode"/>
                    </div>
                </fieldset>
                <fieldset class="control-group">
                    <appfuse:label styleClass="control-label" key="userForm.address.country"/>
                    <div class="controls">
                        <appfuse:country name="address.country" prompt="" default="${userForm.address.country}"/>
                    </div>
                </fieldset>
            </div>
        </fieldset>
        <fieldset class="form-actions">
            <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.register"/>
            </button>
            <button type="submit" class="btn" name="cancel" onclick="bCancel=true">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </button>
        </fieldset>
    </form:form>
</div>

<c:set var="scripts" scope="request">
<v:javascript formName="userForm" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['signupForm']).focus();
    });
</script>
</c:set>