<jsp:directive.include file="/WEB-INF/view/jsp/common/header.jsp" />
<head>
<title><fmt:message key="page.conference.title" /></title>
<meta name="menu" content="ConferenceMenu" />
</head>
<body class="home">
<div class="ind_left">
	<div class="ind_left_topbg"></div>
	<div class="ind_left_bg">
		<div class="ind_left_title">
			<div class="ind_left_title_top"></div>
			<ul>
				<li rel="0" class="left_title_active"><div><a href="javascript:void(0);" class="icons-ico1"></a></div></li>
				<li rel="1"><div><a href="javascript:void(0);" class="icons-ico2"></a></div></li>
				<li rel="2" class="left_title_width"><div><a href="javascript:void(0);" class="icons-ico3"></a></div></li>
			</ul>
		</div>
		<div class="search">
			<input type="text" name="" value="" class="search_txt">
			<input type="submit" name="" value="" class="search_btn">
			<img src="http://img.vcccdn.com/chinaunicom/allen/1.0.0/icon/txt-clear.jpg" class="search_clear"/>
			<div class="clear"></div>
		</div>

		<div class="left_list">
			<div class="user_list"><ul id="index_user_list"></ul></div>
			<div class="user_loding"><img src="http://img.vcccdn.com/chinaunicom/allen/1.0.0/waiting.gif"/></div>
			<a href="javascript:void(0);" class="left_list_previous"></a>
			<a href="javascript:void(0);" class="left_list_next"></a>
			<div class="clear"></div>
		</div>
	</div>
	<div class="ind_left_footbg"></div>
</div>
<div class="ind_right">
	<div class="ind_right_top_bg"></div>
	<div class="ind_right_bg">
		<div id="function_menu">
			<div class="function_menu">
				<ul>
					<li><a href="javascript:void(0);" id="home_page"><fmt:message key="screen.menu.label.conference.home"/></a></li>
					<li><a href="javascript:void(0);" id="myroom_page"><fmt:message key="screen.menu.label.conference.mine"/></a></li>
					<li> <a href="javascript:void(0);" id="call_page"><fmt:message key="screen.menu.label.conference.call"/></a></li>
					<li> <a href="javascript:void(0);" id="current_call_page"><fmt:message key="screen.menu.label.conference.current"/></a></li>
					<li> <a href="javascript:void(0);" id="meeting_list_page"><fmt:message key="screen.menu.label.conference.list"/></a></li>
					<li> <a href="javascript:void(0);" id="install_page"><fmt:message key="screen.menu.label.conference.setting"/></a></li>
					<li class="clear"></li>
				</ul>
			</div>
		</div>
		<div id="ind_right_content_group"></div>
	</div>
	<div class="ind_right_foot_bg"></div>
</div>
<div class="clear"></div>
<script src="http://js.vcccdn.com/qjb/chinaunicom/vidyo.js"></script>
</body>