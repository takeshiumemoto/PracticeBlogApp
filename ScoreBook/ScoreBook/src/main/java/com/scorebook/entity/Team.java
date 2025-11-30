package com.scorebook.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Entity
@Table(name="team")
public class Team {
	public Long id;
	public String name;
}
