package com.learn.e02.streams;

public class Player {

	private String playerName;
	private Integer matchesPlayed;
	private Long runs;
	private Long highestScore;
	private Country country;
	
	public Player() {
		
	}

	public Player(String playerName, Integer matchesPlayed, Long runs, Long highestScore, Country country) {
		super();
		this.playerName = playerName;
		this.matchesPlayed = matchesPlayed;
		this.runs = runs;
		this.highestScore = highestScore;
		this.country = country;
	}



	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Integer getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(Integer matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public Long getRuns() {
		return runs;
	}

	public void setRuns(Long runs) {
		this.runs = runs;
	}

	public Long getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(Long highestScore) {
		this.highestScore = highestScore;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", matchesPlayed=" + matchesPlayed + ", runs=" + runs
				+ ", highestScore=" + highestScore + ", country=" + country + "]";
	}
	
	
	

}
