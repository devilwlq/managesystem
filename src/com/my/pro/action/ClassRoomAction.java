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

@Controller("classRoomAction")
@Scope("prototype")
public class ClassRoomAction extends BaseAction implements ModelDriven<ClassRoom>{
	
	private static final long serialVersionUID = 1L;


	
	//==========model==============
	  private ClassRoom classRoom;
		@Override
		public ClassRoom getModel() {
			if(classRoom==null) classRoom = new ClassRoom();
			return classRoom;	
		}
		//==========model==============
	/**
	 *  start dao/service/===
	 */
	@Autowired
	private ClassRoomService classRoomService;
	
	@Autowired
	private ZyService zyService;
	
	//依赖注入 end  dao/service/===
	
	//--------------------------------------------------------------------
	
	//============start=============
	
	//===========end=============

	
	//------------------------------------------------------------------
	
	//============start=======================================================
	
	
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
	 //===========end=========================================================
	public String jsonAction() {
		  // dataMap
		  jsonMap.clear();
		  jsonMap.put("success", true);
		  return JSON_TYPE;
	}
	 //----------------------------------------------------------------------//
	
	 //====================start============//
	/**
	 * 
	 */
	public String classRoom(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from ClassRoom where 1=1 and isDelete = 0 ");
		if(classRoom!=null && classRoom.getName() !=null && !"".equals(classRoom.getName())){
			sb.append("  and name like :realName ");
			alias.put("realName", "%" +classRoom.getName()+ "%" );
		}
		sb = sb.append("order by id desc");
		Pager<ClassRoom> pagers = classRoomService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", classRoom);
		return SUCCESS;
    }
	
	/**
	 *
	 * @return
	 */
	public String add(){
		List<Zy> listByAlias = zyService.listByAlias("from Zy where 1=1 and isDelete = 0 ", null);
		ActionContext.getContext().put("zys", listByAlias);
		return SUCCESS;
	}
	
	/**
	 *
	 * @return
	 */
	public String exAdd(){
		classRoom.setIsDelete(0);
		classRoomService.save(classRoom);
		ActionContext.getContext().put("url", "/classRoom_classRoom.do");
		return "redirect";
	}
	
	/**
	 * 
	 * @return
	 */
	public String view(){
		ClassRoom n = classRoomService.getById(classRoom.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 */
	public String update(){
		List<Zy> listByAlias = zyService.listByAlias("from Zy where 1=1 and isDelete = 0 ", null);
		ActionContext.getContext().put("zys", listByAlias);
		ClassRoom n = classRoomService.getById(classRoom.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 *
	 * @return
	 */
	public String exUpdate(){
		ClassRoom n = classRoomService.getById(classRoom.getId());
		n.setName(classRoom.getName());
		n.setZy(classRoom.getZy());
		classRoomService.update(n);
		ActionContext.getContext().put("url", "/classRoom_classRoom.do");
		return "redirect";
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String delete(){
		ClassRoom n = classRoomService.getById(classRoom.getId());
		n.setIsDelete(1);
		classRoomService.update(n);
		ActionContext.getContext().put("url", "/classRoom_classRoom.do");
		return "redirect";
	}
	
	//======================end============//
	
	 //---------------------------------------------------------------------//
	
	 //======================start============//
	
	
	
	
	//======================end============//
		
	
	
}
