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
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="${ctx}/resource/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l">
<!--   <a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a>  -->
&nbsp;&nbsp;<a class="button button-little bg-red" href="${ctx}/login_tuichu.do"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>后台管理</h2>
  <ul style="display:block">
  
<c:if test="${roleId == 1 }">
     <li><a href="${ctx}/xy_xy.do" target="right"><span class="icon-caret-right"></span>学院管理</a></li>
     <li><a href="${ctx}/zy_zy.do" target="right"><span class="icon-caret-right"></span>专业管理</a></li>
     <li><a href="${ctx}/classRoom_classRoom.do" target="right"><span class="icon-caret-right"></span>班级管理</a></li>
      <li><a href="${ctx}/xk_xk.do" target="right"><span class="icon-caret-right"></span>学科管理</a></li> 
      
       <li><a href="${ctx}/user_user.do" target="right"><span class="icon-caret-right"></span>学生管理</a></li> 
       
    <li><a href="${ctx}/teacher_teacher.do" target="right"><span class="icon-caret-right"></span>教师管理</a></li>
</c:if>
   <c:if test="${roleId == 2 }">
   <li><a href="${ctx}/user_user2.do" target="right"><span class="icon-caret-right"></span>学生信息查询</a></li> 
   <li><a href="${ctx}/cj_cj.do" target="right"><span class="icon-caret-right"></span>成绩管理</a></li> 
  </c:if>
   <c:if test="${roleId == 3 }">
    
     <li><a href="${ctx}/cj_cj2.do" target="right"><span class="icon-caret-right"></span>成绩查询</a></li> 
     <li><a href="${ctx}/user_view.do" target="right"><span class="icon-caret-right"></span>个人信息</a></li>
     <li><a href="${ctx}/user_update2.do" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    </c:if>
  </ul>   
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="##" id="a_leader_txt">首页</a></li>
<!--   <li><b>当前语言：</b><span style="color:red;">中文</php></span> -->
<!--   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li> -->
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="${ctx}/manage_welcome.do" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
</body>
</html>