<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="tenantProfile.title"/></title>
    <meta name="menu" content="TenantMenu"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="tenantList.tenant"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="span2">
    <h2><fmt:message key="tenantProfile.heading"/></h2>
    <c:choose>
        <c:when test="${param.from == 'list'}">
            <p><fmt:message key="tenantProfile.admin.message"/></p>
        </c:when>
        <c:otherwise>
            <p><fmt:message key="tenantProfile.message"/></p>
        </c:otherwise>
    </c:choose>
</div>
<div class="span7">
    <spring:bind path="tenant.*">
        <c:if test="${not empty status.errorMessages}">
            <div class="alert alert-error fade in">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br/>
                </c:forEach>
            </div>
        </c:if>
    </spring:bind>

    <form:form commandName="tenant" method="post" action="profile" id="tenantForm" autocomplete="off"
               cssClass="well form-horizontal" onsubmit="return validateTenant(this)">
        <form:hidden path="id"/>
        <form:hidden path="version"/>
        <input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

        <c:if test="${empty tenant.version}">
            <input type="hidden" name="encryptPass" value="true"/>
        </c:if>

        <spring:bind path="tenant.name">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.name"/>
            <div class="controls">
                <form:input path="name" id="name"/>
                <form:errors path="name" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.url">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.url"/>
            <div class="controls">
                <form:input path="url" id="url" />
                <form:errors path="url" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.vidyoReplayUrl">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.vidyoReplayUrl"/>
            <div class="controls">
                <form:input path="vidyoReplayUrl" id="vidyoReplayUrl" />
                <form:errors path="vidyoReplayUrl" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.description">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.description"/>
            <div class="controls">
                <form:input path="description" id="description"/>
                <form:errors path="description" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.installNumber">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.installNumber"/>
            <div class="controls">
                <form:input path="installNumber" id="installNumber" maxlength="50"/>
                <form:errors path="installNumber" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.seatNumber">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.seatNumber"/>
            <div class="controls">
                <form:input path="seatNumber" id="seatNumber"/>
                <form:errors path="seatNumber" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.lineNumber">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.lineNumber"/>
            <div class="controls">
                <form:input path="lineNumber" id="lineNumber"/>
                <form:errors path="lineNumber" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.executiveNumber">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.executiveNumber"/>
            <div class="controls">
                <form:input path="executiveNumber" id="executiveNumber"/>
                <form:errors path="executiveNumber" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.vidyoRoomNumber">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.vidyoRoomNumber"/>
            <div class="controls">
                <form:input path="vidyoRoomNumber" id="vidyoRoomNumber"/>
                <form:errors path="vidyoRoomNumber" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.vidyoPanoramaNumber">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.vidyoPanoramaNumber"/>
            <div class="controls">
                <form:input path="vidyoPanoramaNumber" id="vidyoPanoramaNumber"/>
                <form:errors path="vidyoPanoramaNumber" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.dialIn">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.dialIn"/>
            <div class="controls">
                <form:input path="dialIn" id="dialIn"/>
                <form:errors path="dialIn" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.extensionPrefix">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.extensionPrefix"/>
            <div class="controls">
                <form:input path="extensionPrefix" id="extensionPrefix"/>
                <form:errors path="extensionPrefix" cssClass="help-inline"/>
            </div>
        </fieldset>
        <fieldset class="control-group">
            <appfuse:label styleClass="control-label" key="tenantForm.adminName"/>
            <div class="controls">
                <form:input path="adminName" id="adminName"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.adminPassword">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.adminPassword"/>
            <div class="controls">
                <form:password path="adminPassword" id="adminPassword" showPassword="true"/>
                <form:errors path="adminPassword" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="tenant.cdrPassword">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="tenantForm.cdrPassword"/>
            <div class="controls">
                <form:password path="cdrPassword" id="cdrPassword" showPassword="true"/>
                <form:errors path="cdrPassword" cssClass="help-inline"/>
            </div>
        </fieldset>
	<c:choose>
    <c:when test="${param.from == 'list' or param.method == 'Add'}">
        <fieldset class="control-group">
            <label class="control-label"><fmt:message key="tenantProfile.accountSettings"/></label>
            <div class="controls">
                <label class="checkbox inline">
                    <form:checkbox path="enabled" id="enabled"/>
                    <fmt:message key="tenantForm.enabled"/>
                </label>

                <label class="checkbox inline">
                    <form:checkbox path="cdr" id="cdr"/>
                    <fmt:message key="tenantForm.cdr"/>
                </label>

                <label class="checkbox inline">
                    <form:checkbox path="license" id="license"/>
                    <fmt:message key="tenantForm.license"/>
                </label>
            </div>
        </fieldset>
    </c:when>
</c:choose>
        <fieldset class="form-actions">
            <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </button>

            <c:if test="${param.from == 'list' and param.method != 'Add'}">
              <button type="submit" class="btn" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                  <i class="icon-trash"></i> <fmt:message key="button.delete"/>
              </button>
            </c:if>

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

