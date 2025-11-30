package com.scorebook.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Entity
@Table(name="game")
public class Game {
	public Long id;
	public java.time.LocalDate gameDate;
	public Long teamHome;
	public Long teamAway;
	public Integer scoreHome;
	public Integer scoreaAway;
}
