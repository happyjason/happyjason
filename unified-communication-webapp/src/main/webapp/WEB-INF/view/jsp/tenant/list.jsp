<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="tenantList.title"/></title>
    <meta name="menu" content="TenantMenu"/>
</head>

<c:if test="${not empty searchError}">
    <div class="alert alert-error fade in">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="${searchError}"/>
    </div>
</c:if>

<div class="span12">
    <h2><fmt:message key="tenantList.heading"/></h2>

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
        <a class="btn btn-primary" href="<c:url value='/tenant/profile?method=Add&from=list'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>

        <a class="btn" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

    <display:table name="tenantList" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" 
    	id="tenants" pagesize="25" class="table table-condensed table-striped table-hover" export="true">
        <display:column property="id" sortable="true" titleKey="tenantForm.id" style="width: 5%"
        	url="/tenant/profile?from=list" paramId="id" paramProperty="id" escapeXml="true"/>
        <display:column property="name" sortable="true" titleKey="tenantForm.name" style="width: 12%"
        	url="/tenant/profile?from=list" paramId="id" paramProperty="id" escapeXml="true"/>
        <display:column property="url" sortable="true" titleKey="tenantForm.url"  style="width: 24%"
        	escapeXml="true"/>
        <display:column property="description" sortable="true" titleKey="tenantForm.description" style="width: 32%" 
        	autolink="true" media="html"/>
        <display:column sortProperty="enabled" sortable="true" titleKey="tenantForm.enabled" style="width: 8%; padding-left: 12px" 
        	media="html">
            <input type="checkbox" disabled="disabled" <c:if test="${tenants.enabled}">checked="checked"</c:if>/>
        </display:column>
        <display:column titleKey="tenantForm.license" style="width: 5%" 
        	href="tenant/manage" paramId="id" paramProperty="id">
			<c:if test="${tenants.license}">
				<button class="btn btn-small btn-primary">
        			<fmt:message key='button.manage'/>
    			</button>
			</c:if>
    	</display:column>
    	<display:column titleKey="tenantForm.cdr" style="width: 5%" 
        	href="tenant/cdr" paramId="id" paramProperty="id">
			<c:if test="${tenants.cdr}">
				<button class="btn btn-small">
        			<fmt:message key='button.view'/>
    			</button>
			</c:if>
    	</display:column>
    	<display:column titleKey="tenantForm.paymentDays" style="width: 5%" 
        	href="tenant/upload" paramId="id" paramProperty="id">
			<c:if test="${tenants.cdr}">
				<button class="btn btn-small">
        			<fmt:message key='button.synchro'/>
    			</button>
			</c:if>
    	</display:column>
        <display:column property="enabled" titleKey="tenantForm.enabled" media="csv xml excel pdf"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="tenantList.tenants"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="tenantList.tenants"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="Tenant List.xls"/>
        <display:setProperty name="export.csv.filename" value="Tenant List.csv"/>
        <display:setProperty name="export.pdf.filename" value="Tenant List.pdf"/>
    </display:table>
</div>
