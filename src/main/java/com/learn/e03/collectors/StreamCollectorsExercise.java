package com.learn.e03.collectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.learn.e02.streams.Country;
import com.learn.e02.streams.Player;

public class StreamCollectorsExercise {

	static List<Player> players;

	static {
		players = new ArrayList<>();
		players.add(new Player("AAA", 1000, 1500L, 30L, new Country(1, "AUS")));
		players.add(new Player("BBB", 700, 3000L, 50L, new Country(2, "AUS")));
		players.add(new Player("CCC", 40, 1000L, 60L, new Country(3, "IND")));
		players.add(new Player("DDD", 1400, 6000L, 50L, new Country(4, "ENG")));
		players.add(new Player("EEE", 23, 9000L, 20L, new Country(5, "SA")));
	}

	public static Map<String, List<Player>> getPlayersByCountry() {
		return players.stream().collect(Collectors.groupingBy(p -> p.getCountry().getCountryName()));
	}

	public static Map<String, List<String>> getPlayerNamesByCountry() {
		return players.stream().filter(p -> p.getMatchesPlayed() > 100).collect(Collectors.groupingBy(
				p -> p.getCountry().getCountryName(), Collectors.mapping(Player::getPlayerName, Collectors.toList())));
	}

	public static LinkedHashMap<String, Long> getTotalPlayersByCountry() {
		return players.stream().collect(
				Collectors.groupingBy(p -> p.getCountry().getCountryName(), LinkedHashMap::new, Collectors.counting()));
	}

	public static Map<String, Long> getTotalRunsByCountry() {
		return players.stream().collect(
				Collectors.groupingBy(p -> p.getCountry().getCountryName(), Collectors.summingLong(Player::getRuns)));
	}
	
	public static Map<String, List<Player>> getMaxScoreByCountry() {
		return players.stream().sorted((p1,p2) -> p1.getHighestScore().compareTo(p2.getHighestScore())).collect(
				Collectors.groupingBy(p -> p.getCountry().getCountryName()));
	}
	
	public static Map<String, String> getPlayerNamesStringByCountry() {
		return players.stream().collect(
				Collectors.groupingBy(p -> p.getCountry().getCountryName(), Collectors.mapping(Player::getPlayerName, Collectors.joining(","))));
	}
	
	public static void main(String[] args) {
		getPlayersByCountry().forEach((k, v) -> System.out.println("Key -> " + k + " Value -> " + v));
		getPlayerNamesByCountry().forEach((k, v) -> System.out.println("Key -> " + k + " Value -> " + v));
		getTotalPlayersByCountry().forEach((k, v) -> System.out.println("Key -> " + k + " Value -> " + v));
		getTotalRunsByCountry().forEach((k, v) -> System.out.println("Key -> " + k + " Value -> " + v));
		getMaxScoreByCountry().forEach((k, v) -> System.out.println("Key -> " + k + " Value -> " + v));
		getPlayerNamesStringByCountry().forEach((k, v) -> System.out.println("Key -> " + k + " Value -> " + v));
	}
}
