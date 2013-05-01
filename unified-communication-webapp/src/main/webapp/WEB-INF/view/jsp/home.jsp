<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="home.title" /></title>
<meta name="menu" content="HomeMenu" />
</head>
<body class="home">
<%
try{
	//AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
	CasAuthenticationToken principal = (CasAuthenticationToken) request.getUserPrincipal();
	String loginName = principal.getName();//获取用户名
	System.out.print(loginName);
} catch (Exception e){
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
							<input type="text" name="" value="" class="search_txt"> <input
								type="sumbit" name="" value="" class="search_btn"> <img
								src="http://img.vcccdn.com/chinaunicom/allen/1.0.0/icon/txt-clear.jpg"
								class="search_clear" />
							<div class="clear"></div>
						</div>

						<div class="left_list">
							<div class="user_list">
								<ul id="index_user_list"></ul>
							</div>
							<div class="user_loding">
								<img
									src="http://img.vcccdn.com/chinaunicom/allen/1.0.0/waiting.gif" />
							</div>
							<a href="javascript:void(0);" class="left_list_previous"></a> <a
								href="javascript:void(0);" class="left_list_next"></a>
							<div class="clear"></div>
						</div>
					</div>
					<div class="ind_left_footbg"></div>
				</div>
				<div class="ind_right">
					<div class="ind_right_top_bg"></div>
					<div class="ind_right_bg">
						<div class="ind_right_content_group" style="display: none;">
							<div class="ind_right_title">
								我的会议室<br> 房间状态：<span>空闲</span>
								<div class="join_room">
									<span></span>
									<div class="join_room_name">进入会议室</div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="ind_right_content">
								<div class="ind_right_content_left"></div>
								<div class="ind_right_content_right">
									<div class="ind_right_content_title">会议室链接：</div>
									<div class="ind_right_content_txt">
										<input type="text" name="" value="">
									</div>
									<div class="ind_right_content_link">
										<a href="">创建新链接</a><a href="">删除链接</a><a href="">复制链接</a><a
											href="">创建新链接</a>
									</div>
									<div class="ind_right_content_password">
										<div class="ind_right_content_password_title">设置会议室密码</div>
										<div
											class="ind_right_content_txt ind_right_content_password_txt">
											<input type="text" name="" value="">
										</div>
										<div
											class="ind_right_content_link ind_right_content_password_btn">
											<a href="">设置密码</a>
										</div>
										<div class="clear"></div>
									</div>
								</div>
								<div class="clear"></div>
							</div>
						</div>
						<div class="ind_right_content_group" style="display: none;">
							<div class="ind_right_title">
								当前会议：无<br> 房间状态：<span>空闲</span>
							</div>
							<div class="ind_right_content">
								<div class="ind_right_logo">
									<img
										src="http://img.vcccdn.com/chinaunicom/allen/1.0.0/pic-1.jpg" />
								</div>
								<div id="vidyo_status">
									您的客户端未打开或网络连接出现问题,<br>请下载安装客户端并刷新页面。 <a href=""><img
										src="http://img.vcccdn.com/chinaunicom/allen/1.0.0/download.jpg" /></a>
								</div>
							</div>
						</div>

						<div class="ind_right_content_group" style="display: none;">
							<div class="ind_right_title ind_right_title_sz_top">
								<span>设置</span>
							</div>
							<div class="ind_right_content">
								<div class="ind_right_content_sz_firsttop">
									<div class="ind_right_content_label">用户类型：</div>
									<div class="ind_right_content_drop">
										<div id="select01" class="selectbox">
											<div class="cartes">
												<input type="text" name="" value="Normal" class="listTxt">
											</div>
											<div class="lists">
												<ul class="list">
													<li>Normal1</li>
													<li>Normal2</li>
													<li>Normal3</li>
													<li>Normal4</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label">用户名：</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="" class="site_txt">
									</div>
									<div class="clear"></div>
								</div>

								<div class="ind_right_content_sz_top">
									<div class="ind_right_content_label">密码：</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="" class="site_txt">
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label">验证密码：</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="" class="site_txt">
									</div>
									<div class="clear"></div>
								</div>

								<div class="ind_right_content_sz_top">
									<div class="ind_right_content_label">显示名称：</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="" class="site_txt">
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label">电子邮件地址：</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="" class="site_txt">
									</div>
									<div class="clear"></div>
								</div>

								<div class="ind_right_content_sz_top">
									<div class="ind_right_content_label">分机号：</div>
									<div class="ind_right_content_drop">
										<input type="text" name="" value="021"
											class="site_txt site_txt_fjh" disabled><input
											type="text" name="" value="" class="site_txt site_txt_fjh_kd">
									</div>
									<div class="clear"></div>
								</div>
								<div class="ind_right_content_sz_top">
									<div class="ind_right_content_label">组：</div>
									<div class="ind_right_content_drop">
										<div id="select02" class="selectbox">
											<div class="cartes">
												<input type="text" name="" value="Default" class="listTxt">
											</div>
											<div class="lists">
												<ul class="list">
													<li>Default1</li>
													<li>Default2</li>
													<li>Default3</li>
													<li>Default4</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label">代理：</div>
									<div class="ind_right_content_drop">
										<div id="select03" class="selectbox">
											<div class="cartes">
												<input type="text" name="" value="vidyoproxy"
													class="listTxt">
											</div>
											<div class="lists">
												<ul class="list">
													<li>vidyoproxy1</li>
													<li>vidyoprox2</li>
													<li>vidyoprox3</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label">位置标签：</div>
									<div class="ind_right_content_drop">
										<div id="select04" class="selectbox">
											<div class="cartes">
												<input type="text" name="" value="Default" class="listTxt">
											</div>
											<div class="lists">
												<ul class="list">
													<li>Default1</li>
													<li>Default2</li>
													<li>Default3</li>
													<li>Default4</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label">语音首选项：</div>
									<div class="ind_right_content_drop">
										<div id="select05" class="selectbox">
											<div class="cartes">
												<input type="text" name="" value="简体中文" class="listTxt">
											</div>
											<div class="lists">
												<ul class="list">
													<li>简体中文</li>
													<li>繁体中文</li>
													<li>English</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="clear"></div>
									<div class="ind_right_content_label">说明：</div>
									<div class="ind_right_content_drop">
										<textarea name="" class="site_textarea"></textarea>
									</div>
									<div class="clear"></div>
								</div>

								<div class="ind_right_content_sz_top">
									<div class="ind_right_content_label"></div>
									<div class="ind_right_content_drop">
										<input type="submit" name="" value="确定" class="site_btn_1"><input
											type="submit" name="" value="取消" class="site_btn_2">
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>

						<div class="ind_right_content_group" style="display: none;">
							<div class="ind_right_title">
								当前会议：无<br> 房间状态：<span>空闲</span>
								<div class="join_room join_room_link">
									<a href="">断开房间</a> <a href="">锁定房间</a>
								</div>
							</div>
							<div class="ind_right_content">
								<div class="ind_right_hys">
									<div class="ind_right_hys_left">
										<a href="" class="ind_right_hys_list_add"></a>
										<ul>
											<li>
												<div class="ind_right_hys_left_icon icons-status-Busy"></div>
												<div class="ind_right_hys_left_main">
													<div class="ind_right_hys_left_main_name">徐方龙</div>
													<div class="ind_right_hys_left_main_link">
														<a href="" class="ind_right_hys_banmai icons-banmai"></a>
														<a href="" class="ind_right_hys_video icons-video"></a> <a
															href="" class="ind_right_hys_close icons-close"></a>
													</div>
												</div>
												<div class="clear"></div>
											</li>
											<li>
												<div class="ind_right_hys_left_icon icons-status-Busy"></div>
												<div class="ind_right_hys_left_main">
													<div class="ind_right_hys_left_main_name">徐方龙</div>
													<div class="ind_right_hys_left_main_link">
														<a href="" class="ind_right_hys_banmai icons-banmai"></a>
														<a href="" class="ind_right_hys_video icons-video"></a> <a
															href="" class="ind_right_hys_close icons-close"></a>
													</div>
												</div>
												<div class="clear"></div>
											</li>
											<li>
												<div class="ind_right_hys_left_icon icons-status-Busy"></div>
												<div class="ind_right_hys_left_main">
													<div class="ind_right_hys_left_main_name">徐方龙</div>
													<div class="ind_right_hys_left_main_link">
														<a href="" class="ind_right_hys_banmai icons-banmai"></a>
														<a href="" class="ind_right_hys_video icons-video"></a> <a
															href="" class="ind_right_hys_close icons-close"></a>
													</div>
												</div>
												<div class="clear"></div>
											</li>
										</ul>
									</div>
									<div class="ind_right_hys_right">
										<textarea name="" class="ind_right_hys_right_textarea"
											disabled></textarea>
										<input type="text" name="" value=""
											class="ind_right_hys_right_search_txt" disabled> <input
											type="submit" name="" value="发送"
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
										<div class="ind_right_myroom_left_list">
											<ul>
												<li>
													<div
														class="icons-status-icon1 ind_right_myroom_left_list_icon"></div>
													<div class="ind_right_myroom_left_list_name">徐方龙</div>
													<div class="clear"></div> <a href=""
													class="ind_right_myroom_left_list_del"></a>
												</li>
												<li>
													<div
														class="icons-status-icon1 ind_right_myroom_left_list_icon"></div>
													<div class="ind_right_myroom_left_list_name">徐方龙</div>
													<div class="clear"></div> <a href=""
													class="ind_right_myroom_left_list_del"></a>
												</li>
												<li>
													<div
														class="icons-status-icon1 ind_right_myroom_left_list_icon"></div>
													<div class="ind_right_myroom_left_list_name">徐方龙</div>
													<div class="clear"></div> <a href=""
													class="ind_right_myroom_left_list_del"></a>
												</li>
											</ul>
										</div>
									</div>
									<div class="ind_right_myroom_right">
										<div class="ind_right_myroom_title">群组人员</div>
										<a href="" class="ind_right_hys_list_add"></a>
										<div class="ind_right_myroom_right_list">
											<ul>
												<li>
													<div class="myroom_right_list_icon icons-status-Online"></div>
													<div class="myroom_right_list_name">徐方龙</div>
													<div class="clear"></div>
												</li>
												<li>
													<div class="myroom_right_list_icon icons-status-Online"></div>
													<div class="myroom_right_list_name">徐方龙</div>
													<div class="clear"></div>
												</li>
												<li>
													<div class="myroom_right_list_icon icons-status-Online"></div>
													<div class="myroom_right_list_name">徐方龙</div>
													<div class="clear"></div>
												</li>
												<li>
													<div class="myroom_right_list_icon icons-status-Online"></div>
													<div class="myroom_right_list_name">徐方龙</div>
													<div class="clear"></div>
												</li>
												<li>
													<div class="myroom_right_list_icon icons-status-Online"></div>
													<div class="myroom_right_list_name">徐方龙</div>
													<div class="clear"></div>
												</li>
												<li>
													<div class="myroom_right_list_icon icons-status-Online"></div>
													<div class="myroom_right_list_name">徐方龙</div>
													<div class="clear"></div>
												</li>
												<div class="clear"></div>
											</ul>
										</div>
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

									<div class="ind_right_hy_status_main">
										<ul>
											<li><a class="" href=""></a> <span
												class="ind_right_hy_status_main_icon1"></span>
												<div class="ind_right_hy_status_main_name">hotmob@Default_xufanglong@Default:2
													(点到点）</div>
												<div class="clear"></div>
												<div class="ind_right_hy_status_main_list">
													<ul>
														<li>
															<div class="status_main_list_name">徐方龙</div>
															<div class="status_main_list_name_line"></div>
															<div class="status_main_list_name">02119896</div>
															<div class="clear"></div>
														</li>
														<li>
															<div class="status_main_list_name">徐方龙</div>
															<div class="status_main_list_name_line"></div>
															<div class="status_main_list_name">02119896</div>
															<div class="clear"></div>
														</li>
														<li>
															<div class="status_main_list_name">徐方龙</div>
															<div class="status_main_list_name_line"></div>
															<div class="status_main_list_name">02119896</div>
															<div class="clear"></div>
														</li>
													</ul>
												</div></li>
											<li><a class="" href=""></a> <span
												class="ind_right_hy_status_main_icon1"></span>
												<div class="ind_right_hy_status_main_name">hotmob@Default_xufanglong@Default:2
													(点到点）</div>
												<div class="clear"></div>
												<div class="ind_right_hy_status_main_list">
													<ul>
														<li>
															<div class="status_main_list_name">徐方龙</div>
															<div class="status_main_list_name_line"></div>
															<div class="status_main_list_name">02119896</div>
															<div class="clear"></div>
														</li>
														<li>
															<div class="status_main_list_name">徐方龙</div>
															<div class="status_main_list_name_line"></div>
															<div class="status_main_list_name">02119896</div>
															<div class="clear"></div>
														</li>
													</ul>
												</div></li>
										</ul>
									</div>
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
</body>
<script src="http://js.vcccdn.com/qjb/chinaunicom/wTimer-1.0.2/wTimer.js"></script>
<script type="text/javascript">
$(document).ready(function(){
var	url='http://app.lan.seekoom.com/rest_s.php?limit=25&sortBy=member';
var start=0;
var _n=25;
var limit=0;
var minheight=450;
var old_user_list=null;
var name_color_Online="name_color_online";
var name_color_Offline="name_color_offline";

client_status();
function client_status(){
	$.ajax({
	    url: 'http://127.0.0.1:63457', //访问路径
	    type: 'post', //传值的方式
	    async: 'true',//同步
	    complete: function (XMLHttpRequest, textStatus) {//访问失败时调用的函数      
	       $("#vidyo_status").css("display","block");                   
	    }
	}); 
}

//窗体加载初始显示页面
$(".ind_right_content_group").eq(1).show();

$("#site").click(function(){
	$(".ind_right_content_group").hide();
	$(".ind_right_content_group").eq(2).show();
});

$("#index").click(function(){
	$(".ind_right_content_group").hide();
	$(".ind_right_content_group").eq(1).show();
});

$("#myroom").click(function(){
	$(".ind_right_content_group").hide();
	$(".ind_right_content_group").eq(3).show();
});

$("#call").click(function(){
	$(".ind_right_content_group").hide();
	$(".ind_right_content_group").eq(4).show();
});

$("#current_call").click(function(){
	$(".ind_right_content_group").hide();
	$(".ind_right_content_group").eq(5).show();
});

/*绘制列表*/
for(var t=0;t<_n;t++)
{
	$("#index_user_list").append("<li id=index_user_list_li_"+ t +" style='display:none;'><div class='left_list_status' id='index_user_list_li_icon_"+ t + "'></div><div class='left_list_name' id='index_user_list_li_name_"+ t + "'></div><div class='clear'></div></li>");
}

/*左侧用户列表点击事件*/
$("#index_user_list li").css("cursor","pointer");
$("#index_user_list li").click(function(){
	$(".ind_right_content_group").hide();
	$(".ind_right_content_group").eq(3).show();
});

/*定时刷新*/
var timer = new wTimer({
    fps:0.1,
    run: function()
    {
        user_print(url);
        client_status();
    }
});

timer.start();

/*左侧用户列表方法*/
function user_print(url){	
	var height=$(window).height();
	if (height<minheight){
		height=minheight;
	}
	$(".ind_left_bg").css("height",height-132+"px");
	$(".ind_right_content").css("height",height-201+"px");

	$(".ind_right_hys_left").css("height",height-240+"px");
	$(".ind_right_hys_right_textarea").css("height",height-320+"px");
	$(".ind_right_myroom_left,.ind_right_myroom_right").css("height",height-240+"px");

	var ul_height=height-214;	
	_n=Math.floor(ul_height/45);
	$(".user_list").css("height",_n*45+"px");
	if (_n<5){_n=5}
	var i=0;

	if(start<=0)
	{
		start=0;
		$(".left_list_previous").css("display","none");
	}
	else{
		$(".left_list_previous").css("display","block");
	}

	$.ajax({
		type: "GET",
		async:false,
		url: url,
		dataType:"text",
		success:function(response){	
			response = $.parseJSON(response); 
			//alert(response);
			if(!old_user_list){  // init
				$(".user_loding").css("display","none");
				i=0;	
				$.each(response, function(key, val) {
					limit=response.length;
					if(i>=_n){
						return false;
					}
					uesr_list_li(val,i);
					$("#index_user_list_li_name_" + i).append(val.displayName);
					i=i+1;
				})
				old_user_list=response;		
			} else {  // 重繪
				i=0;
				$.each(response, function(key, val) {	
					limit=response.length;
					if(i>=_n){
						return false;
					}
					if(old_user_list[i]!=response[i] || i>=_n-1){
						uesr_list_li(val,i);
						$("#index_user_list_li_name_" + i).html("");
						$("#index_user_list_li_name_" + i).append(val.displayName);
					}
					i=i+1;
				});
				if(response.length < old_user_list.length) {
					for(;i<old_user_list.length-response.length;i++){
						if(i>=_n){
							return false;
						}
						$("#index_user_list_li_icon_" + i).attr('class','').addClass("left_list_status");
						$("#index_user_list_li_name_" + i).html("");
					}
				}
				old_user_list=response;	
			}
		}
	});

	if(limit>_n){
		$(".left_list_next").css("display","block");
	}else{
		$(".left_list_next").css("display","none");
	}

}

/*窗体分辨率改变时*/
$(window).resize(function() {
	start=0;
	var type=$(".left_title_active").attr("rel");
	if(type==='0'){
		url='http://app.lan.seekoom.com/rest_s.php?limit=25&sortBy=member';
	}else if(type==='1'){
		url='http://app.lan.seekoom.com/rest_s.php?limit=25&sortBy=member';
	}else{
		url='http://app.lan.seekoom.com/rest_s.php?limit=25&sortBy=member';
	}
	user_print(url);
});

/*公用的列表绘制*/
function uesr_list_li(val,i){
	$("#index_user_list_li_" + i).css("display","block");
	if(val.MemberStatus==='Offline'||val.MemberStatus==='Online'||val.MemberStatus==='Busy'){
		$("#index_user_list_li_icon_" + i).attr('class','').addClass("left_list_status icons-status-"+val.MemberStatus);
	}else{
		$("#index_user_list_li_icon_" + i).addClass("icons-status-Offline");
	}
	
	if(val.MemberStatus==='Online'||val.MemberStatus==='Busy'){
		$("#index_user_list_li_name_" + i).attr('class','').addClass("left_list_name "+name_color_Online);
	}else{
		$("#index_user_list_li_name_" + i).attr('class','').addClass("left_list_name "+name_color_Offline);
	}
	$("#index_user_list_li_name_" + i).html("");
}

/*选项卡点击*/
var $current=$(".ind_left_title li")
$current.click(function(){
	var index=$current.index(this);
	$(this).addClass("left_title_active").siblings().removeClass("left_title_active");
	var type=$(".left_title_active").attr("rel");
	start=0;
	limit=0;
	if(type==='0'){
		url='http://app.lan.seekoom.com/rest_s.php?limit=25&sortBy=member';
	}else if(type==='1'){
		url='http://app.lan.seekoom.com/rest_s.php?limit=25&sortBy=member';
	}else{
		url='http://app.lan.seekoom.com/rest_s.php?limit=25&sortBy=member';
	}
	user_print(url);
}); 

/*上一页*/
$(".left_list_previous").click(function(){
	var type=$(".left_title_active").attr("rel");
	start=start-_n;
	url=url+'&start='+start;
	user_print(url);
}); 

/*下一页*/
$(".left_list_next").click(function(){
	var type=$(".left_title_active").attr("rel");
	start=start+_n;
	url=url+'&start='+start;
	user_print(url);
}); 

/*搜索框内容清除*/
$(".search_clear").click(function(){
	$(".search_txt").val("");
}); 

/*当前会议室左侧列表效果*/
$(".ind_right_hys_left li").hover(
function(){
	$(this).attr("class","ind_right_hys_active");		
},function(){
	$(this).attr("class","");
});

/*我的房间左侧列表效果*/
$(".ind_right_myroom_left_list li").hover(
function(){
	$(this).attr("class","ind_right_myroom_left_list_active");		
},function(){
	$(this).attr("class","");
});

/*房间链接状态效果*/
$('.ind_right_hy_status_main .ind_right_hy_status_main_list li:last').css("border-bottom","0px");
$(".ind_right_hy_status_main_list").hide();
$(".ind_right_hy_status_main li").css("cursor","pointer");
$(".ind_right_hy_status_main li").click(function(){
	var span_icon=$(this).children("span").attr("class");
	if(span_icon==='ind_right_hy_status_main_icon1'){
		$(this).children("span").attr("class","").addClass("ind_right_hy_status_main_icon2");
	}
	else{
		$(this).children("span").attr("class","").addClass("ind_right_hy_status_main_icon1");
	}
	$(this).find(".ind_right_hy_status_main_list").slideToggle("fast");
});

});
</script>
<script type="text/javascript" src="http://js.vcccdn.com/qjb/chinaunicom/jQSelect.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#select01").jQSelect({});
    $("#select02").jQSelect({});  
    $("#select03").jQSelect({});  
    $("#select04").jQSelect({});  
    $("#select05").jQSelect({});    
}); 
</script>
