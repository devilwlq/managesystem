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
 * @date 2015骞�12鏈�24鏃� 涓嬪崍1:46:33 - 2017骞�04鏈�14鏃� 21鏃�44鍒�17绉�
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
	 * 渚濊禆娉ㄥ叆 start dao/service/===
	 */
	@Autowired
	private UserService userService;
	@Autowired
	private ClassRoomService classRoomService;
	

	
	private File file;
	
    private String fileFileName;
   
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
	 //============end=========================================================
	public String jsonAction() {
		 
		  jsonMap.clear();
		  jsonMap.put("success", true);
		  return JSON_TYPE;
	}
	
	/**
	 * 鍒楄〃鍒嗛〉鏌ヨprivate String userName;//鐧婚檰
	private String passWord;//瀵嗙爜
	private String phone;//鎵嬫満
	private String realName;//鐪熷疄
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
	 * 
	 * @return
	 */
	public String add(){
		List<ClassRoom> listByAlias = classRoomService.listByAlias("from ClassRoom where 1=1 and isDelete = 0", null);
		ActionContext.getContext().put("bjs", listByAlias);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 */
	public String exAdd(){
		user.setIsDelete(0);
		userService.save(user);
		ActionContext.getContext().put("url", "/user_user.do");
		return "redirect";
	}
	
	/**
	 * 
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
	 * 
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
	 * 
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
	        // 鐢熸垚Workbook
	        HSSFWorkbook wb = new HSSFWorkbook();
	        // 杩藉姞Sheet
	        Sheet sheet = wb.createSheet("Sheet");
	        // 鎬诲垪鏁�
	        Integer CountColumnNum = 7;
	        Cell[] firstCell = new Cell[CountColumnNum];
	        String[] firstCellNames = new String[CountColumnNum];
	     /*   <th width="">瀛﹀彿</th>
	        <th>鐪熷疄鍚�</th>
	        <th>鎬у埆</th>
	        <th>鎵�灞炲闄�</th>
	        <th>鎵�灞炰笓涓�</th>
	        <th>鎵�灞炵彮绾�</th>
	        <th>鑱旂郴鐢佃瘽</th>*/
	        firstCellNames[0] = "瀛﹀彿";
	        firstCellNames[1] = "鐪熷疄鍚嶇О";
	        firstCellNames[2] = "鎬у埆";
	        firstCellNames[3] = "鎵�灞炲闄�";
	        firstCellNames[4] = "鎵�灞炰笓涓�";
	        firstCellNames[5] = "鎵�灞炵彮绾�";
	        firstCellNames[6] = "鑱旂郴鐢佃瘽";
	        // 鎻掑叆琛�
	        Row firstRow = sheet.createRow(0);
	        for (int j = 0; j < CountColumnNum; j++) {
	            firstCell[j] = firstRow.createCell(j);
	            firstCell[j].setCellValue(new HSSFRichTextString(firstCellNames[j]));
	        }
	        BigDecimal bd;
	        for (int i = 0; i < list.size(); i++) {
	            // 鍒涘缓涓�琛�
	            Row row = sheet.createRow(i + 1);
	            Cell id = row.createCell(0);
	            id.setCellValue(list.get(i).getUserName().toString());

	            Cell zzs = row.createCell(1);
	            zzs.setCellValue(list.get(i).getRealName().toString());

	            
	            Cell xh = row.createCell(2);
	            if(list.get(i).getSex() == 1){
	            	xh.setCellValue("鐢�");
	            }else{
	            	xh.setCellValue("濂�");
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
	        // 鍒涘缓鏂囦欢杈撳嚭娴侊紝鍑嗗杈撳嚭鐢靛瓙琛ㄦ牸
	        HttpServletResponse response = ServletActionContext.getResponse();
	        response.setContentType("application/vnd.ms-excel");//response.setContentType("application/vnd.ms-excel");
	        response.setHeader("Content-disposition", "attachment;filename=export.xls");
	        OutputStream out = response.getOutputStream();
	        wb.write(out);
	        out.flush();
	        out.close();
	    }
	/**
	 * 鍒犻櫎
	 * @return
	 */
	public String delete(){
		User n = userService.getById(user.getId());
		n.setIsDelete(1);
		userService.update(n);
		ActionContext.getContext().put("url", "/user_user.do");
		return "redirect";
	}
	
	//=============鍏�=======鍏�=======鏂�=======娉�==========鍖�=========end============//
	
	 //-------------------------鍗庝附鍒嗗壊绾�---------------------------------------------//
	
	 //=============鑷�=======瀹�=======涔�=========鏂�=======娉�==========鍖�=========start============//
	
	
	
	
	//=============鑷�=======瀹�=======涔�=========鏂�=======娉�==========鍖�=========end============//
		
	
	
}
