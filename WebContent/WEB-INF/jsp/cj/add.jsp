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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加成绩</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="" id=""  enctype="multipart/form-data">   
      <div class="form-group">
        <div class="label">
          <label>学号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="code" id="code" value="" data-validate="required:请输入登录名" />         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>得分：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="code" id="df" value="" data-validate="required:请输入成绩" />         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
          <div class="label">
            <label>学科：</label>
          </div>
          <div class="field">
            <select id="xk" class="input w50">
              <option value="">请选择分类</option>
               <c:forEach items="${xks}" var="data" varStatus="l">
                  <option value="${data.id}">${data.name}</option>
              </c:forEach>
            </select>
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
		var code = $("#code").val();
		var xk = $("#xk").val();
		var df = $("#df").val();
			$.ajax({  
			    type: "POST",  
			    url: "cj_exAdd.do?code="+code+"&xk.id="+xk+"&df="+df,  
			    dataType:"json",  
			    contentType : 'application/json;charset=utf-8', //设置请求头信息  
			    success: function(data){
			    	if(data.res==1){
			    		window.location.href=ctx+"/cj_cj.do";
			    	}else{
			    		alert("该学生不存在");
			    	}
			    },  
			    error: function(res){  
			    	$("#result2").val("请求出错");
			    }  
			}); 
		
	});
	
	
});
</script>
</html>