<jsp:directive.include file="includes/header.jsp" />
<head>
    <title><fmt:message key="home.title"/></title>
    <meta name="menu" content="HomeMenu"/>
</head>
<body class="home">
	<div class="login_bg">
		<div class="login_main">
			<div class="login_main_1"></div>
			<div class="login_main_top"></div>
			<div class="login_main_2">
				<div class="login_title"><spring:message code="login.title" /></div>
				<form:form method="post" id="fm1" cssClass="fm-v clearfix" 
					commandName="${commandName}" htmlEscape="true">
					<form:errors path="*" id="msg" cssClass="alert alert-error" element="div" />
					<div class="login_from login_from_z_index">
						<div id="select06" class="selectbox">
							<div class="cartes">
								<span class="login_from_picbig"></span>
								<form:input cssClass="login_txt listTxt" cssErrorClass="alert-error" id="url" 
									size="25" tabindex="1" path="url" autocomplete="true" 
									htmlEscape="true" value="http://v.seekoom.com"/>
							</div>
							<div class="lists">
								<ul class="list">
									<li>http://demo.10010zj.com.cn</li>
									<li>http://v.seekoom.com</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="login_from  login_from_margintop">
						<span class="login_from_position_picbig"></span>
						<spring:message code="label.username" var="userNameAccess" />
						<form:input cssClass="login_txt required" cssErrorClass="alert-error" id="username"
							size="25" tabindex="2" path="username" autocomplete="false" htmlEscape="true" 
							placeholder="${userNameAccess}"/>
					</div>
					<div class="login_from login_from_margintop">
						<span class="login_from_position_picbig login_from_position_picbig1"></span>
						<spring:message code="label.password" var="passwordAccess" />
						<form:password cssClass="login_txt required" cssErrorClass="alert-error" id="password" 
							size="25" tabindex="3" path="password" autocomplete="off" htmlEscape="true" 
							placeholder="${passwordAccess}"/>
					</div>
					<div class="login_from login_from_margintop">
						<div class="login_checkbox1">
							<span class="check_bg1"></span>
							<input type="hidden" name="rememberMe" id="rememberMe" value="false" />
							<i><spring:message code="login.rememberMe" /></i>
							<div class="clear"></div>
						</div>
					</div>
					<div class="login_from login_from_margintop">
						<input type="hidden" name="lt" value="${loginTicket}" />
						<input type="hidden" name="execution" value="${flowExecutionKey}" />
						<input type="hidden" name="_eventId" value="submit" />
						<input class="login_from_btn" name="submit" accesskey="l"
							value="<spring:message code="button.login" />"
							tabindex="4" type="submit" />
					</div>
				</form:form>
			</div>
			<div class="login_main_footer"></div>
		</div>
	</div>
	<jsp:directive.include file="includes/footer.jsp" />
	<script>
		$(document).ready(function(){
		
			$(".login_checkbox1").click(function(){
				var check_status=$(this).children("span").attr("class");
				if(check_status==='check_bg1'){
					$(this).children("span").attr("class","").addClass("check_bg2");
				}
				else{
					$(this).children("span").attr("class","").addClass("check_bg1");
				}
			}); 
		
			var height=$(window).height();
			$(".login_bg").css("height",height-112+"px");	
		
			$(window).resize(function() {
				var height=$(window).height();
				$(".login_bg").css("height",height-112+"px");
			});
		
		});
		</script>
		<script type="text/javascript" src="http://js.vcccdn.com/qjb/chinaunicom/jQSelect.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
		    $("#select06").jQSelect({}); 
		}); 
		</script>
</body>