<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="portalList.title"/></title>
    <meta name="menu" content="PortalMenu"/>
</head>

<c:if test="${not empty searchError}">
    <div class="alert alert-error fade in">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="${searchError}"/>
    </div>
</c:if>

<div class="span12">
    <h2><fmt:message key="portalList.heading"/></h2>

    <form method="get" action="${ctx}/portal" id="searchForm" class="form-search">
    <div id="search" class="input-append">
        <input type="text" size="20" name="q" id="query" value="${param.q}"
               placeholder="<fmt:message key="search.enterTerms"/>" class="input-medium search-query"/>
        <button id="button.search" class="btn" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <div id="actions" class="form-actions">
        <a class="btn btn-primary" href="<c:url value='/portal/profile?method=Add&from=list'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>

        <a class="btn" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

    <display:table name="portalList" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" 
    	id="tenants" pagesize="25" class="table table-condensed table-striped table-hover" export="true">
    	
        <display:column property="id" sortable="true" titleKey="portalForm.id" style="width: 5%"
        	url="/portal/profile?from=list" paramId="id" paramProperty="id" escapeXml="true"/>
        <display:column property="portalName" sortable="true" titleKey="portalForm.portalName" style="width: 12%"
        	url="/portal/profile?from=list" paramId="id" paramProperty="id" escapeXml="true"/>
        <display:column property="portalUrl" sortable="true" titleKey="portalForm.portalUrl"  style="width: 24%"
        	escapeXml="true"/>
       
        <display:column titleKey="portalProfile.addTenant" style="width: 5%" 
        	href="/tenant/profile?method=Add&from=list"  paramId="portal_id" paramProperty="id">
			
				<button class="btn btn-small btn-primary">
        			<fmt:message key='button.add'/>
    			</button>
			
    	</display:column>
    <display:column titleKey="portalProfile.listTenant" style="width: 5%" 
        	href="portal/profile?method=listTenant" paramId="portal_id" paramProperty="id">
		
				<button class="btn btn-small btn-primary">
        			<fmt:message key='button.view'/>
    			</button>
	
    	</display:column>
  
        <display:setProperty name="paging.banner.item_name"><fmt:message key="tenantList.tenants"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="tenantList.tenants"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="Tenant List.xls"/>
        <display:setProperty name="export.csv.filename" value="Tenant List.csv"/>
        <display:setProperty name="export.pdf.filename" value="Tenant List.pdf"/>
    </display:table>
</div>
