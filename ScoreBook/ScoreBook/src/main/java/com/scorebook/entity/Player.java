package com.scorebook.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Entity
@Table(name="player")
public class Player {
	public Long id;
	public Long teamId;
	public String name;
	public Integer number;
	public String position;
}
