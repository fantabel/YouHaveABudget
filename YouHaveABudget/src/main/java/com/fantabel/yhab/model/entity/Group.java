package com.fantabel.yhab.model.entity;

import java.util.UUID;

public class Group {
	private UUID id;

	public String getId() {
		return id.toString();
	}

	public void setId(String id) {
		this.id = UUID.fromString(id);
	}

}
