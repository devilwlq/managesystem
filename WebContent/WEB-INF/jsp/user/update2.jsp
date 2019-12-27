<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
   <title>后台管理中心</title>  
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
     <script src="${ctx}/resource/js/pintuer.js"></script>  
</head>
<style>
    .file1 {
        position: relative;
        display: inline-block;
        background: #D0EEFF;
        border: 1px solid #99D3F5;
        border-radius: 4px;
        padding: 4px 12px;
        overflow: hidden;
        color: #1E88C7;
        text-decoration: none;
        text-indent: 0;
        line-height: 20px;
    }
    .file1 input {
        position: absolute;
        font-size: 100px;
        right: 0;
        top: 0;
        opacity: 0;
    }
    .file1:hover {
        background: #AADFFD;
        border-color: #78C3F3;
        color: #004974;
        text-decoration: none;
    }
</style>
<body>

<script>
function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}
</script>
<div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改密码</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="" enctype="multipart/form-data">   
      <div class="form-group">
        <div class="label">
          <label>原始密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="" value="" id="passWord" data-validate="required:请输入原始密码" />         
          <div class="tips"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>新密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="" value="" id="newPass" data-validate="required:请输入新密码" />         
          <div class="tips"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>确认密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="" value="" id="newPass2" data-validate="required:请输入确认密码" />         
          <div class="tips"></div>
        </div>
      </div> 
     <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="button" id="queryInfo"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
<script type="text/javascript">
$("#zp1").on("change","input[type='file']",function(){
    var filePath = $(this).val();
    var filePath = filePath.split('\\');
    var filePath = filePath[filePath.length-1];
    $('#file').val(filePath);
})

</script>
<script type="text/javascript">
$(function(){
	$("#queryInfo").click(function(){
		var passWord = $("#passWord").val();
		var newPass = $("#newPass").val();
		var newPass2 = $("#newPass2").val();
		
		if(passWord == null || passWord ==""){
			alert("原始密码不能为空");
			return;
		}
		if(newPass == null || newPass ==""){
			alert("新密码不能为空");
			return;
		}
		if(newPass2 == null || newPass2 ==""){
			alert("重复密码不能为空");
			return;
		}
		if(passWord == newPass){
			alert("新密码和原始密码不能一致");
			return;
		}
		if(newPass2 != newPass){
			alert("两次密码输入不一致");
			return;
		}
		$.ajax({  
		    type: "POST",  
		    url:"login_xiugai.do?passWord="+$("#passWord").val()+"&newPass="+$("#newPass").val(),  
		    dataType:"json",  
		    contentType : 'application/json;charset=utf-8', //设置请求头信息  
		    success: function(data){
		    	if(data.res == 1){
		    		alert("修改成功");
		    		window.top.location.href="login_tuichu.do";
		    	}else{
		    	   alert(data.mess);
		    	}
		    },  
		    error: function(res){  
		    }  
		}); 
	
});
});
</script>
</html>