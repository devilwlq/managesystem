package com.my.pro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 班级
 * 
 * @author
 *
 */
@Entity
@Table(name = "class_room")
public class ClassRoom {

	private Integer id;

	private String name;

	private Zy zy;// 专业

	private Integer isDelete;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "zy_id")
	public Zy getZy() {
		return zy;
	}

	public void setZy(Zy zy) {
		this.zy = zy;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}
