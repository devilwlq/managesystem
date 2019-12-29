package com.my.pro.action;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
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
 * 
 */

@Controller("cjAction")
@Scope("prototype")
public class CjAction extends BaseAction implements ModelDriven<Cj>{
	
	private static final long serialVersionUID = 1L;


	
	//==========model==============
	  private Cj cj;
		@Override
		public Cj getModel() {
			if(cj==null) cj = new Cj();
			return cj;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private CjService cjService;
	
	@Autowired
	private XkService xkService;
	//依赖注入 end  dao/service/===
	
	//-------------------------华丽分割线---------------------------------------------
	
	//============自定义参数start=============
	
	//============自定义参数end=============

	
	//-------------------------华丽分割线---------------------------------------------
	
	//============文件上传start=======================================================
	@Autowired
	private UserService userService;
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
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
	

	/**
	 * 列表分页查询
	 */
	public String cj(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Cj where 1=1 and teacher.id="+UserUtils.getLoginId());
		
		sb = sb.append(" order by id desc");
		Pager<Cj> pagers = cjService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", cj);
		return SUCCESS;
    }
	
	public String cj2(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Cj where 1=1 and user.id="+UserUtils.getLoginId());
		if(cj!=null && cj.getXk() !=null && !"".equals(cj.getXk().getName())){
			sb.append("  and xk.nam like :realName ");
			alias.put("realName", "%" +cj.getXk().getName()+ "%" );
		}
		sb = sb.append(" order by id desc");
		Pager<Cj> pagers = cjService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", cj);
		return SUCCESS;
    }
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String add(){
		List<Xk> listByAlias = xkService.listByAlias("from Xk where 1=1 and isDelete = 0", null);
		ActionContext.getContext().put("xks", listByAlias);
		return SUCCESS;
	}
	
	/**
	 * 执行添加
	 * @return
	 */
	public String exAdd(){
		//
		List<User> listByAlias = userService.listByAlias("from User where userName="+code, null);
		if(!isEmpty(listByAlias)){
			User user = listByAlias.get(0);
			cj.setUser(user);
			Teacher t = new Teacher();
			t.setId(UserUtils.getLoginId());
			cj.setTeacher(t);
			cjService.save(cj);
			jsonMap.put("res", 1);
		}else{
			jsonMap.put("res", 2);
		}
		
		
		return "json";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		Cj n = cjService.getById(cj.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		List<Xk> listByAlias = xkService.listByAlias("from Xk where 1=1 and isDelete = 0", null);
		ActionContext.getContext().put("xks", listByAlias);
		Cj n = cjService.getById(cj.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		Cj n = cjService.getById(cj.getId());
		n.setDf(cj.getDf());
		n.setXk(cj.getXk());
		cjService.update(n);
		ActionContext.getContext().put("url", "/cj_cj.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		cjService.delete(cj.getId());
		ActionContext.getContext().put("url", "/cj_cj.do");
		return "redirect";
	}
	
	
	
	
}
