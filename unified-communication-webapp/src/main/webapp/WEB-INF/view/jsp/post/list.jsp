<jsp:directive.include file="/WEB-INF/view/jsp/common/header.jsp" />
<head>
    <title><fmt:message key="postList.title"/></title>
    <meta name="menu" content="PostMenu"/>
</head>

<c:if test="${not empty searchError}">
    <div class="alert alert-error fade in">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="${searchError}"/>
    </div>
</c:if>

<div class="span12">
    <h2><fmt:message key="postList.heading"/></h2>

    <form method="get" action="${ctx}/post" id="searchForm" class="form-search">
	    <div id="search" class="input-append">
	        <input type="text" size="20" name="q" id="query" value="${param.q}"
	               placeholder="<fmt:message key="search.enterTerms"/>" class="input-medium search-query"/>
	        <button id="button.search" class="btn" type="submit">
	            <i class="icon-search"></i> <fmt:message key="button.search"/>
	        </button>
	    </div>
    </form>

    <div id="actions" class="form-actions">
        <a class="btn btn-primary" href="<c:url value='/post/profile?method=Add&from=list'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>

        <a class="btn" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

    <display:table name="postList" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" 
    	id="posts" pagesize="25" class="table table-condensed table-striped table-hover" export="true">
        <display:column property="id" sortable="true" titleKey="postForm.id" style="width: 4%"
        	url="/post/profile?from=list" paramId="id" paramProperty="id" escapeXml="true"/>
        <display:column property="name" sortable="true" titleKey="postForm.name" style="width: 12%"
        	maxWords="80" url="/post/profile?from=list" paramId="id" paramProperty="id" escapeXml="true"/>
        <display:column property="responsibility" sortable="true" titleKey="postForm.responsibility" 
        	maxWords="120" escapeXml="true"/>
        <display:column property="requirement" sortable="true" titleKey="postForm.requirement"
        	maxWords="120" autolink="true"/>
        <display:column style="width: 8%" href="post/profile?method=Del" 
        	paramId="id" paramProperty="id">
			<button class="btn btn-small">
       			<fmt:message key='button.delete'/>
   			</button>
    	</display:column>
    	<display:column style="width: 8%" href="post/notification" 
        	paramId="id" paramProperty="id">
			<button class="btn btn-small">
       			<fmt:message key='button.notification'/>
   			</button>
    	</display:column>
        <display:column property="enabled" titleKey="post.enabled" media="csv xml excel pdf"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="postList.posts"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="postList.posts"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="Post List.xls"/>
        <display:setProperty name="export.csv.filename" value="Post List.csv"/>
        <display:setProperty name="export.pdf.filename" value="Post List.pdf"/>
    </display:table>
</div>