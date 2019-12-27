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
<body>
<form method="post" action="${ctx}/user_user.do" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
      <li>
           <a class="button border-main icon-plus-square-o" href="${ctx }/user_add.do"> 添加学生</a> 
            <a class="button border-main icon-plus-square-o" href="${ctx }/user_export.do"> 导出学生</a>
        </li>
        <li>
          <input type="text" placeholder="请输入姓名" name="realName"  value="${User.realName}" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
<!-- 
	private String userName;//登陆
	private String passWord;//密码
	private String phone;//手机
	private String realName;//真实
	private Integer sex;//1男 2女
	private Integer age;//
	
	private ClassRoom classroom;-->
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th width="">学号</th>
        <th>真实名</th>
        <th>性别</th>
        <th>所属学院</th>
        <th>所属专业</th>
        <th>所属班级</th>
        <th>联系电话</th>
        <th width="310">操作</th>
      </tr>
        <c:forEach items="${pagers.datas}" var="data" varStatus="l">
        <tr>
           <td>${data.id}</td>
           <td>${data.userName}</td>
           <td>${data.realName }</td>
           <td>
           <c:if test="${data.sex == 1 }">
                                  男
           </c:if>
            <c:if test="${data.sex == 2 }">
                                  女
           </c:if>
           </td>
            <td>${data.classroom.zy.xy.name }</td>
             <td>${data.classroom.zy.name }</td>
              <td>${data.classroom.name }</td>
           <td>${data.phone }</td>
          
           <td>
              <div class="button-group"> <a class="button border-main" href="${ctx}/user_update.do?id=${data.id}"><span class="icon-edit"></span>修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del('${data.id}')"><span class="icon-trash-o"></span> 删除</a> </div>
           </td>
        </tr>
       </c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist">
        <!-- 分页开始 -->
			      <pg:pager  url="${ctx}/user_user.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
			        <pg:param name="realName" value="${User.realName}"/>
			        
					<pg:last>  
						共${pagers.total}记录,共${pageNumber}页,  
					</pg:last>  
						当前第${curPage}页 
			        <pg:first>  
			    		<a href="${pageUrl}">首页</a>  
					</pg:first>  
					<pg:prev>  
			    		<a href="${pageUrl}">上一页</a>  
					</pg:prev>  
			       	<pg:pages>  
			        	<c:choose>  
			            	<c:when test="${curPage eq pageNumber}">  
			                	<font color="red">[${pageNumber }]</font>  
			            	</c:when>  
			            	<c:otherwise>  
			               		<a href="${pageUrl}">${pageNumber}</a>  
			            	</c:otherwise>  
			        	</c:choose>  
			    	</pg:pages>
			             
			        <pg:next>  
			    		<a href="${pageUrl}">下一页</a>  
					</pg:next>  
					<pg:last>  
						<c:choose>  
			            	<c:when test="${curPage eq pageNumber}">  
			                	<font color="red">尾页</font>  
			            	</c:when>  
			            	<c:otherwise>  
			               		<a href="${pageUrl}">尾页</a>  
			            	</c:otherwise>  
			        	</c:choose> 
			    		  
					</pg:last>
				</pg:pager>
				 </div></td>
                    <!-- 分页结束 -->
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

//搜索
function changesearch(){	
		$("#listform").submit();
}

//单个删除
function del(id){
	if(confirm("您确定要删除吗?")){
		window.location.href="${ctx}/user_delete.do?id="+id;
	}
}

</script>
</body>
</html>