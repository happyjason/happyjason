<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="portalList.title"/></title>
    <meta name="menu" content="PortalMenu"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="portalList.portal"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="span2">
    <h2><fmt:message key="portalProfile.heading"/></h2>
    <c:choose>
        <c:when test="${param.from == 'list'}">
            <p><fmt:message key="portalProfile.admin.message"/></p>
        </c:when>
        <c:otherwise>
            <p><fmt:message key="portalProfile.message"/></p>
        </c:otherwise>
    </c:choose>
</div>
<div class="span7">
    <spring:bind path="portal.*">
        <c:if test="${not empty status.errorMessages}">
            <div class="alert alert-error fade in">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br/>
                </c:forEach>
            </div>
        </c:if>
    </spring:bind>

    <form:form commandName="portal" method="post" action="profile" id="portalForm" autocomplete="off"
               cssClass="well form-horizontal" onsubmit="return validateTenant(this)">
        <form:hidden path="id"/>


        <spring:bind path="portal.portalName">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="portalForm.portalName"/>
            <div class="controls">
                <form:input path="portalName" id="name"/>
                <form:errors path="portalName" cssClass="help-inline"/>
            </div>
        </fieldset>
        <spring:bind path="portal.portalUrl">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="portalForm.portalUrl"/>
            <div class="controls">
                <form:input path="portalUrl" id="url" />
                <form:errors path="portalUrl" cssClass="help-inline"/>
            </div>
        </fieldset>
  
        <spring:bind path="portal.portalPassword">
        <fieldset class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="portalForm.portalPassword"/>
            <div class="controls">
                <form:password path="portalPassword" id="portalPassword" showPassword="true"/>
                <form:errors path="portalPassword" cssClass="help-inline"/>
            </div>
        </fieldset>
	
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

