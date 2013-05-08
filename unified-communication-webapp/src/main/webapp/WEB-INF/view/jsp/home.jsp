<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="home.title" /></title>
<meta name="menu" content="HomeMenu" />
</head>
<body class="home">
	<%
		try {
			//AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
			CasAuthenticationToken token = (CasAuthenticationToken) request.getUserPrincipal();
			String loginName = token.getName();//获取用户名
			String prin = token.getPrincipal().toString();//获取用户名
			System.out.print(loginName);
			System.out.print(prin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
	<div class="ind_bg1">
		<div class="ind_bg2">
			<div class="main_center">
				<div class="ind_left">
					<div class="ind_left_topbg"></div>
					<div class="ind_left_bg">
						<div class="ind_left_title">
							<div class="ind_left_title_top"></div>
							<ul>
								<li rel="0" class="left_title_active"><div>
										<a href="javascript:void(0);" class="icons-ico1"></a>
									</div></li>
								<li rel="1"><div>
										<a href="javascript:void(0);" class="icons-ico2"></a>
									</div></li>
								<li rel="2" class="left_title_width"><div>
										<a href="javascript:void(0);" class="icons-ico3"></a>
									</div></li>
							</ul>
						</div>
						<div class="search">
							<input type="text" name="" value="" class="search_txt">
							<input type="sumbit" name="" value="" class="search_btn">
								<img src="http://img.vcccdn.com/chinaunicom/allen/1.0.0/icon/txt-clear.jpg"
								class="search_clear" />
							<div class="clear"></div>
						</div>

						<div class="left_list">
							<div class="user_list">
								<ul id="index_user_list"></ul>
							</div>
							<div class="user_loding">
								<img src="http://img.vcccdn.com/chinaunicom/allen/1.0.0/waiting.gif" />
							</div>
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
					    <!-- 我的会议室 -->
						<div class="ind_right_content_group" style="display: none;">
							<div class="ind_right_title">
								<fmt:message key="screen.vidyo.label.myroom"/><br> 
								<fmt:message key="screen.vidyo.label.roomstate"/>:<span>Null</span>
								<div class="join_room">
									<span></span>
									<div class="join_room_name"><fmt:message key="screen.vidyo.label.joinroom"/></div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="ind_right_content">
								<div class="ind_right_content_left"></div>
								<div class="ind_right_content_right">
									<div class="ind_right_content_title"><fmt:message key="screen.vidyo.label.roomurl"/>:</div>
									<div class="ind_right_content_txt">
										<input type="text" name="" value="">
									</div>
									<div class="ind_right_content_link">
										<a href=""><fmt:message key="screen.vidyo.label.roomurl.add"/></a>
										<a href=""><fmt:message key="screen.vidyo.label.roomurl.del"/></a>
										<a href=""><fmt:message key="screen.vidyo.label.roomurl.copy"/></a>
										<a href=""><fmt:message key="screen.vidyo.label.roomurl.add"/></a>
									</div>
									<div class="ind_right_content_password">
										<div class="ind_right_content_password_title">
											<fmt:message key="screen.vidyo.label.locks.room"/>
										</div>
										<div class="ind_right_content_txt ind_right_content_password_txt">
											<input type="text" name="" value="">
										</div>
										<div class="ind_right_content_link ind_right_content_password_btn">
											<a href=""><fmt:message key="button.setting.password"/></a>
										</div>
										<div class="clear"></div>
									</div>
								</div>
								<div class="clear"></div>
							</div>
						</div>
						<!-- 当前会议室 -->
						<div class="ind_right_content_group" style="display: none;">
							<div class="ind_right_title">
								<fmt:message key="screen.vidyo.label.curroom"/><br> 
								<fmt:message key="screen.vidyo.label.roomstate"/>:<span>Null</span>
							</div>
							<div class="ind_right_content">
								<div class="ind_right_logo">
									<img src="http://img.vcccdn.com/chinaunicom/allen/1.0.0/pic-1.jpg" />
								</div>
								<div id="vidyo_status">
									<fmt:message key="screen.warn.label.client"/>
									<a href=""><img src="http://img.vcccdn.com/chinaunicom/allen/1.0.0/download.jpg" /></a>
								</div>
							</div>
						</div>
						<!-- 用户设置 -->
						<div class="ind_right_content_group" style="display: none;">
							<div class="ind_right_title ind_right_title_sz_top">
								<span><fmt:message key="screen.menu.label.setting"/></span>
							</div>
							<div class="ind_right_content">
								<div class="ind_right_content_sz_firsttop">
									<div class="ind_right_content_label">
										<fmt:message key="screen.vidyo.label.usertype"/>:
									</div>
									<div class="ind_right_content_drop">
										<div id="select01" class="selectbox">
											<div class="cartes">
												<input type="text" name="" value="Normal" class="listTxt">
											</div>
											<div class="lists">
												<ul class="list"></ul>
											</div>
										</div>
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label">
										<fmt:message key="label.username"/>:
									</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="" class="site_txt">
									</div>
									<div class="clear"></div>
								</div>
								<div class="ind_right_content_sz_top">
									<div class="ind_right_content_label">
										<fmt:message key="label.password"/>:
									</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="" class="site_txt">
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label">
										<fmt:message key="label.password.confirm"/>:
									</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="" class="site_txt">
									</div>
									<div class="clear"></div>
								</div>

								<div class="ind_right_content_sz_top">
									<div class="ind_right_content_label">
										<fmt:message key="label.displayname"/>:
									</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="" class="site_txt">
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label">
										<fmt:message key="label.email"/>:
									</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="" class="site_txt">
									</div>
									<div class="clear"></div>
								</div>

								<div class="ind_right_content_sz_top">
									<div class="ind_right_content_label">
										<fmt:message key="label.extension"/>:
									</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="021"
											class="site_txt site_txt_fjh" disabled><input
											type="text" name="" value="" class="site_txt site_txt_fjh_kd">
									</div>
									<div class="clear"></div>
								</div>
								<div class="ind_right_content_sz_top">
									<div class="ind_right_content_label">
										<fmt:message key="label.group"/>:
									</div>
									<div class="ind_right_content_drop">
										<div id="select02" class="selectbox">
											<div class="cartes">
												<input type="text" name="" value="Default" class="listTxt">
											</div>
											<div class="lists">
												<ul class="list"></ul>
											</div>
										</div>
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label"><fmt:message key="label.proxy"/>:</div>
									<div class="ind_right_content_drop">
										<div id="select03" class="selectbox">
											<div class="cartes">
												<input type="text" name="" value="vidyoproxy"
													class="listTxt">
											</div>
											<div class="lists">
												<ul class="list"></ul>
											</div>
										</div>
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label"><fmt:message key="label.location"/>:</div>
									<div class="ind_right_content_drop">
										<div id="select04" class="selectbox">
											<div class="cartes">
												<input type="text" name="" value="Default" class="listTxt">
											</div>
											<div class="lists">
												<ul class="list"></ul>
											</div>
										</div>
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label"><fmt:message key="label.language"/>:</div>
									<div class="ind_right_content_drop">
										<div id="select05" class="selectbox">
											<div class="cartes">
												<input type="text" name="" value="" class="listTxt">
											</div>
											<div class="lists">
												<ul class="list">
													<li><fmt:message key="label.language"/></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label">
										<fmt:message key="label.description"/>:
									</div>
									<div class="ind_right_content_drop">
										<textarea name="" class="site_textarea"></textarea>
									</div>
									<div class="clear"></div>
								</div>

								<div class="ind_right_content_sz_top">
									<div class="ind_right_content_label"></div>
									<div class="ind_right_content_drop">
										<input type="submit" name="" value="<fmt:message key="label.save"/>" class="site_btn_1">
										<input type="submit" name="" value="<fmt:message key="label.cancel"/>" class="site_btn_2">
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
						<!-- 当前会议室 -->
						<div class="ind_right_content_group" style="display: none;">
							<div class="ind_right_title">
								<fmt:message key="screen.vidyo.label.curroom"/><br> 
								<fmt:message key="screen.vidyo.label.roomstate"/>:<span>Null</span>
								<div class="join_room join_room_link">
									<a href=""><fmt:message key="button.leave"/></a>
									<a href=""><fmt:message key="button.lock"/></a>
								</div>
							</div>
							<div class="ind_right_content">
								<div class="ind_right_hys">
									<div class="ind_right_hys_left">
										<a href="javascript:void(0);" class="ind_right_hys_list_add private"></a>
										<div id="room_user_list_load">
											<img src="http://img.vcccdn.com/chinaunicom/allen/1.0.0/waiting.gif"/>
										</div>
										<ul id="room_member_list"></ul>
									</div>
									<div class="ind_right_hys_right">
										<textarea name="" class="ind_right_hys_right_textarea"
											disabled></textarea>
										<input type="text" name="" value=""
											class="ind_right_hys_right_search_txt" disabled> <input
											type="submit" name="" value="<fmt:message key="button.send"/>"
											class="ind_right_hys_right_search_btn" disabled>
										<div class="clear"></div>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
						<div class="ind_right_content_group" style="display: none;">
							<div class="ind_right_title ind_right_title_sz_top">
								<span>我的会议室</span>
								<div class="join_room my_room_icon">
									<span></span>
									<div class="join_room_name">新建群组</div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="ind_right_content">
								<div class="ind_right_hys">
									<div class="ind_right_myroom_left">
										<div class="ind_right_myroom_title">会议群组</div>
										<a href=""
											class="ind_right_hys_list_add ind_right_hys_list_add1"></a>
										<div class="ind_right_myroom_left_list"></div>
									</div>
									<div class="ind_right_myroom_right">
										<div class="ind_right_myroom_title">群组人员</div>
										<a href="" class="ind_right_hys_list_add"></a>
										<div class="ind_right_myroom_right_list"></div>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
						<div class="ind_right_content_group" style="display: none;">
							<div class="ind_right_title ind_right_title_sz_top">
								<span>我的会议室</span>
							</div>
							<div class="ind_right_content">
								<div class="ind_right_content_jg"></div>
								<div class="ind_right_hy_status">
									<div class="ind_right_hy_status_title">
										<div class="ind_right_hy_status_title1">名称</div>
										<div class="ind_right_hy_status_title_line"></div>
										<div class="ind_right_hy_status_title1">分机号</div>
										<div class="clear"></div>
									</div>
									<div class="ind_right_hy_status_main"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="ind_right_foot_bg"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<script src="http://js.vcccdn.com/qjb/chinaunicom/vidyo.js"></script>
</body>