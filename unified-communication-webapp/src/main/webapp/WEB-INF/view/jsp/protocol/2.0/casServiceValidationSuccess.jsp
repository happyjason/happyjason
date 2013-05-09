<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<cas:serviceResponse xmlns:cas='http://www.ammob.com/auth'>
	<cas:authenticationSuccess>
		<cas:user>${fn:escapeXml(assertion.chainedAuthentications[fn:length(assertion.chainedAuthentications)-1].principal.id)}</cas:user>
		<c:if test="${not empty pgtIou}">
			<cas:proxyGrantingTicket>${pgtIou}</cas:proxyGrantingTicket>
		</c:if>
		<c:if test="${fn:length(assertion.chainedAuthentications) > 1}">
			<cas:proxies>
				<c:forEach var="proxy" items="${assertion.chainedAuthentications}"
					varStatus="loopStatus" begin="0"
					end="${fn:length(assertion.chainedAuthentications)-2}" step="1">
					<cas:proxy>${fn:escapeXml(proxy.principal.id)}</cas:proxy>
				</c:forEach>
			</cas:proxies>
		</c:if>
		<cas:attributes>
			<c:forEach var="auth" items="${assertion.chainedAuthentications}">
				<c:forEach var="attr" items="${auth.principal.attributes}">
					<c:choose>
						<c:when test="${fn:escapeXml(attr.key) eq 'vidyo'}">
							<cas:vidyo-member>
								<c:forEach var="member" items="${attr.value}">
									<cas:${fn:escapeXml(member.key)}>${fn:escapeXml(member.value)}</cas:${fn:escapeXml(member.key)}>
								</c:forEach>
							</cas:vidyo-member>
						</c:when>
						<c:otherwise>
							<cas: ${fn:escapeXml(attr.key)}>${fn:escapeXml(attr.value)}</cas:${fn:escapeXml(attr.key)}>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:forEach>
		</cas:attributes>
	</cas:authenticationSuccess>
</cas:serviceResponse>