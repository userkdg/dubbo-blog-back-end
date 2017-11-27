package com.isun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="acct_role",schema = "icm",catalog = "db_mvn")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AcctRole {
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false,length=36,unique = true)
	private String id;
	
	@Column(name="role_name")
	private String roleName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
