package com.leadtone.riders.entity.admin;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.collect.Lists;
import com.leadtone.riders.entity.User;

/**
 * 开发团队.
 * 
 * @author calvin
 */
@Entity
@Table(name = "ss_group")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Group extends IdEntity {

	private String name;
	private Admin master;
	private List<Admin> adminList = Lists.newArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@OneToOne
	@JoinColumn(name = "master_id")
	public Admin getMaster() {
		return master;
	}

	public void setMaster(Admin master) {
		this.master = master;
	}

	@OneToMany(mappedBy = "team")
	public List<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Admin> userList) {
		this.adminList = userList;
	}
}
