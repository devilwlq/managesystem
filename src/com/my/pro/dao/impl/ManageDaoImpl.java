package com.my.pro.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.my.pro.base.impl.BaseDaoImpl;
import com.my.pro.dao.ManageDao;
import com.my.pro.model.Manage;
import com.my.pro.utils.Pager;



@Repository("manageDao")
@SuppressWarnings("unchecked")
public class ManageDaoImpl extends BaseDaoImpl<Manage>  implements ManageDao{

	public Manage login(Manage manage) {
		String hql = "from Manage bean where bean.name =:userName and bean.passWord= :passWord";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("userName", manage.getName());
		q.setParameter("passWord", manage.getPassWord());
		return (Manage)q.uniqueResult();
	}
//======================================================================================================
	public Pager<Manage> list() {
		String hql = "from Manage where type = 2 ";
		return findByAlias(hql, null);
	}
	public Pager<Manage> listBy(String name) {
		
//		sb.append("  and name like :name");
//		alias.put("name", "%" +manage.getName()+ "%");
		String hql = "from Manage  where  type = 2 and realName like :name ";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("name", "%" +name+ "%");
		return findByAlias(hql, alias);
	}

}
