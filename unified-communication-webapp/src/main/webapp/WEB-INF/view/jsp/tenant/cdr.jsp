<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="conferenceCallList.title"/></title>
    <meta name="menu" content="TenantMenu"/>
</head>

<c:if test="${not empty error}">
    <div class="alert alert-error fade in">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="${error}"/>
    </div>
</c:if>

<div class="span10">
    <h2><fmt:message key="conferenceCallList.heading"/></h2>

    <form method="get" action="${ctx}/tenant" id="searchForm" class="form-search">
    <div id="search" class="input-append">
        <input type="text" size="20" name="q" id="query" value="${param.q}"
               placeholder="<fmt:message key="search.enterTerms"/>" class="input-medium search-query"/>
        <button id="button.search" class="btn" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <div id="actions" class="form-actions">
        <a class="btn" href="<c:url value='/tenant'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

    <display:table name="conferenceCallList" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" 
    	id="conferenceCalls" pagesize="25" class="table table-condensed table-striped table-hover" export="true">
        <display:column property="callId" sortable="true" titleKey="conferenceCallForm.id" style="width: 4%"/>
        <display:column property="uniqueCallId" sortable="true" titleKey="conferenceCallForm.uniqueCallId" style="width: 4%"/>
        <display:column property="conferenceName" sortable="true" titleKey="conferenceCallForm.conferenceName"  style="width: 8%"/>
        <display:column property="conferenceType" sortable="true" titleKey="conferenceCallForm.conferenceType" style="width: 8%"/>
        <display:column property="tenantName" sortable="true" titleKey="conferenceCallForm.tenantName" style="width: 8%"/>
		<display:column property="callerId" sortable="true" titleKey="conferenceCallForm.callerId" style="width: 8%"/>
		<display:column property="callerName" sortable="true" titleKey="conferenceCallForm.callerName" style="width: 8%"/>
		<display:column property="callState" sortable="true" titleKey="conferenceCallForm.callState" style="width: 8%"/>
		<display:column property="joinTime" sortable="true" titleKey="conferenceCallForm.joinTime" style="width: 8%"/>
		<display:column property="leaveTime" sortable="true" titleKey="conferenceCallForm.leaveTime" style="width: 8%"/>
		<display:column property="direction" sortable="true" titleKey="conferenceCallForm.direction" style="width: 8%"/>
		<display:column property="endpointType" sortable="true" titleKey="conferenceCallForm.endpointType" style="width: 8%"/>
        
        <display:setProperty name="paging.banner.item_name"><fmt:message key="conferenceCallForm.conferenceCalls"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="conferenceCallForm.conferenceCalls"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="ConferenceCall List.xls"/>
        <display:setProperty name="export.csv.filename" value="ConferenceCall List.csv"/>
        <display:setProperty name="export.pdf.filename" value="ConferenceCall List.pdf"/>
    </display:table>
</div>