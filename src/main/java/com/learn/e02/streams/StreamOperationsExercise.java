package com.learn.e02.streams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOperationsExercise {
	static List<Player> players;

	static {
		players = new ArrayList<>();
		players.add(new Player("AAA", 1000, 1500L, 30L, new Country(1, "AUS")));
		players.add(new Player("BBB", 700, 3000L, 50L, new Country(2, "AUS")));
		players.add(new Player("CCC", 40, 1000L, 60L, new Country(3, "IND")));
		players.add(new Player("DDD", 1400, 6000L, 50L, new Country(4, "ENG")));
		players.add(new Player("EEE", 23, 9000L, 20L, new Country(5, "SA")));
	}

	public static void displayPlayers() {
		players.stream().map(p -> p.getPlayerName()).forEach(System.out::println);
	}

	public static void displayPlayersForCountry(String country) {
		System.out.print(players.stream()
				.filter(p -> p.getRuns() > 100 && p.getCountry().getCountryName().equalsIgnoreCase(country))
				.max((o1, o2) -> o1.getHighestScore().compareTo(o2.getHighestScore())).get());
	}

	public static LinkedList<Player> getPlayerNames() {
		return new LinkedList<>(players.stream().filter(p -> p.getRuns() > 5000)
				.sorted((o1, o2) -> o2.getRuns().compareTo(o1.getRuns())).collect(Collectors.toList()));
	}

	public static Double getAverageRunsByCountry(String country) {
		return players.stream().filter(p -> p.getCountry().getCountryName().equalsIgnoreCase(country))
				.mapToLong(v -> v.getRuns()).average().getAsDouble();
	}

	public static List<String> getPlayerNamesSorted() {
		return players.stream()
				.sorted((o1, o2) -> o1.getCountry().getCountryName().compareTo(o2.getCountry().getCountryName()))
				.sorted((o1, o2) -> o2.getHighestScore().compareTo(o1.getHighestScore())).map(v -> v.getPlayerName())
				.collect(Collectors.toList());
	}

	public static Map<Country, List<String>> getPlayerCountry() {

		return players.stream().filter(f -> f.getMatchesPlayed() > 200).collect(Collectors
				.groupingBy(Player::getCountry, Collectors.mapping(Player::getPlayerName, Collectors.toList())));
	}

	public static void main(String[] args) {
		// displayPlayers();
		// displayPlayersForCountry("AUS");
		// getPlayerNames().forEach(System.out::println);
		// getAverageRunsByCountry("AUS");
//		getPlayerNamesSorted().forEach(System.out::println);
		getPlayerCountry().forEach((k,v) -> System.out.println("Key -> "+k+" Value -> "  +v));
	}
}
