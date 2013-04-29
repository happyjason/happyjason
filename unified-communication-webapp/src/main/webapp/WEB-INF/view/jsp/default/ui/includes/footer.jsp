<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/jquery-ui.min.js"></script>
<script type="text/javascript" src="<c:url value="/js/cas.js" />"></script>
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