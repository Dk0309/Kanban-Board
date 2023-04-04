package com.project.LayOutService.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class WorkSpace {
	
	@Id
	private String workSpaceName;
	private List<Pillar> pillars;
	
	public WorkSpace() {
		super();
	}

	public WorkSpace(String workSpaceName, List<Pillar> pillars) {
		super();
		this.workSpaceName = workSpaceName;
		this.pillars = pillars;
	}

	public String getWorkSpaceName() {
		return workSpaceName;
	}

	public void setWorkSpaceName(String workSpaceName) {
		this.workSpaceName = workSpaceName;
	}

	public List<Pillar> getPillars() {
		return pillars;
	}

	public void setPillars(List<Pillar> pillars) {
		this.pillars = pillars;
	}

	@Override
	public String toString() {
		return "WorkSpace [workSpaceName=" + workSpaceName + ", pillars=" + pillars + "]";
	}
	
	
	

}
