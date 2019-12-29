package com.my.pro.action;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.my.pro.utils.MapUtils;
import com.my.pro.utils.Pager;
import com.my.pro.utils.UserUtils;
import com.opensymphony.xwork2.ModelDriven;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2015年12月24日 下午1:46:33 - 2017年04月14日 21时44分17秒
 */

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction implements ModelDriven<User>{
	
	private static final long serialVersionUID = 1L;


	
	//==========model==============
	  private User user;
		@Override
		public User getModel() {
			if(user==null) user = new User();
			return user;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private UserService userService;
	@Autowired
	private ClassRoomService classRoomService;
	
	//依赖注入 end  dao/service/===
	
	//-------------------------华丽分割线---------------------------------------------
	
	//============自定义参数start=============
	
	//============自定义参数end=============

	
	//-------------------------华丽分割线---------------------------------------------
	
	//============文件上传start=======================================================
	
	
	private File file;
	//提交过来的file的名字
    private String fileFileName;
    //提交过来的file的MIME类型
    private String fileContentType;
    public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	 //============文件上传end=========================================================
	public String jsonAction() {
		  // dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据
		  jsonMap.clear();
		  jsonMap.put("success", true);
		  return JSON_TYPE;
	}
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============公=======共=======方=======法==========区=========start============//
	/**
	 * 列表分页查询private String userName;//登陆
	private String passWord;//密码
	private String phone;//手机
	private String realName;//真实
	private Date createTime;
	 */
	public String user(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from User where 1=1 and isDelete = 0");
		if(user!=null && user.getRealName() !=null && !"".equals(user.getRealName())){
			sb.append("  and realName like :realName ");
			alias.put("realName", "%" +user.getRealName()+ "%" );
		}
		sb = sb.append("order by id desc");
		Pager<User> pagers = userService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", user);
		return SUCCESS;
    }
	
	public String user2(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from User where 1=1 and isDelete = 0");
		if(user!=null && user.getRealName() !=null && !"".equals(user.getRealName())){
			sb.append("  and realName like :realName ");
			alias.put("realName", "%" +user.getRealName()+ "%" );
		}
		sb = sb.append("order by id desc");
		Pager<User> pagers = userService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", user);
		return SUCCESS;
    }
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String add(){
		List<ClassRoom> listByAlias = classRoomService.listByAlias("from ClassRoom where 1=1 and isDelete = 0", null);
		ActionContext.getContext().put("bjs", listByAlias);
		return SUCCESS;
	}
	
	/**
	 * 执行添加
	 * @return
	 */
	public String exAdd(){
		user.setIsDelete(0);
		userService.save(user);
		ActionContext.getContext().put("url", "/user_user.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		User n = userService.getById(UserUtils.getLoginId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
		/*User n = userService.getById(user.getId());
		Map<String, Object> map = MapUtils.getMap();
		map.put("pass", n.getPassWord());
		map.put("phone", n.getPhone());
		map.put("realName", n.getRealName());
		map.put("name", n.getUserName());
		jsonMap.put("Obj", map);
		return "json";*/
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		User n = userService.getById(user.getId());
		List<ClassRoom> listByAlias = classRoomService.listByAlias("from ClassRoom where 1=1 and isDelete = 0", null);
		ActionContext.getContext().put("bjs", listByAlias);
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	public String update2(){
		return SUCCESS;
	}
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		User n = userService.getById(user.getId());
		n.setClassroom(user.getClassroom());
		n.setPassWord(user.getPassWord());
		n.setPhone(user.getPassWord());
		n.setRealName(user.getRealName());
		n.setSex(user.getSex());
		n.setUserName(user.getUserName());
		userService.update(n);
		ActionContext.getContext().put("url", "/user_user.do");
		return "redirect";
	}
	
	public void export() throws IOException {
		  Map<String,Object> alias = new HashMap<String,Object>();
			StringBuffer sb = new StringBuffer();
			sb = sb.append("from User where 1=1 and isDelete = 0");
			if(user!=null && user.getRealName() !=null && !"".equals(user.getRealName())){
				sb.append("  and realName like :realName ");
				alias.put("realName", "%" +user.getRealName()+ "%" );
			}
			sb = sb.append("order by id desc");
			List<User> list = userService.listByAlias(sb.toString(),alias);
	        // 生成Workbook
	        HSSFWorkbook wb = new HSSFWorkbook();
	        // 追加Sheet
	        Sheet sheet = wb.createSheet("Sheet");
	        // 总列数
	        Integer CountColumnNum = 7;
	        Cell[] firstCell = new Cell[CountColumnNum];
	        String[] firstCellNames = new String[CountColumnNum];
	     /*   <th width="">学号</th>
	        <th>真实名</th>
	        <th>性别</th>
	        <th>所属学院</th>
	        <th>所属专业</th>
	        <th>所属班级</th>
	        <th>联系电话</th>*/
	        firstCellNames[0] = "学号";
	        firstCellNames[1] = "真实名称";
	        firstCellNames[2] = "性别";
	        firstCellNames[3] = "所属学院";
	        firstCellNames[4] = "所属专业";
	        firstCellNames[5] = "所属班级";
	        firstCellNames[6] = "联系电话";
	        // 插入行
	        Row firstRow = sheet.createRow(0);
	        for (int j = 0; j < CountColumnNum; j++) {
	            firstCell[j] = firstRow.createCell(j);
	            firstCell[j].setCellValue(new HSSFRichTextString(firstCellNames[j]));
	        }
	        BigDecimal bd;
	        for (int i = 0; i < list.size(); i++) {
	            // 创建一行
	            Row row = sheet.createRow(i + 1);
	            Cell id = row.createCell(0);
	            id.setCellValue(list.get(i).getUserName().toString());

	            Cell zzs = row.createCell(1);
	            zzs.setCellValue(list.get(i).getRealName().toString());

	            
	            Cell xh = row.createCell(2);
	            if(list.get(i).getSex() == 1){
	            	xh.setCellValue("男");
	            }else{
	            	xh.setCellValue("女");
	            }
	            Cell gh = row.createCell(3);
	            gh.setCellValue(list.get(i).getClassroom().getZy().getXy().getName().toString());
	            Cell gh2 = row.createCell(4);
	            gh2.setCellValue(list.get(i).getClassroom().getZy().getName().toString());
	            
	            Cell gh4 = row.createCell(5);
	            gh4.setCellValue(list.get(i).getClassroom().getName().toString());
	            Cell gh5 = row.createCell(6);
	            gh5.setCellValue(list.get(i).getPhone().toString());
	            
	        }
	        // 创建文件输出流，准备输出电子表格
	        HttpServletResponse response = ServletActionContext.getResponse();
	        response.setContentType("application/vnd.ms-excel");//response.setContentType("application/vnd.ms-excel");
	        response.setHeader("Content-disposition", "attachment;filename=export.xls");
	        OutputStream out = response.getOutputStream();
	        wb.write(out);
	        out.flush();
	        out.close();
	    }
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		User n = userService.getById(user.getId());
		n.setIsDelete(1);
		userService.update(n);
		ActionContext.getContext().put("url", "/user_user.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
