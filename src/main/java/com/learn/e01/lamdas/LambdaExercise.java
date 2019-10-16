package com.learn.e01.lamdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LambdaExercise {

	static List<String> countries = new ArrayList<>(Arrays.asList("Afghanistan", "Albania", "Algeria", "Andorra",
			"Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan"));
	static Map<String, String> countryCaptials = new LinkedHashMap<>();

	public static void displayCountries() {
		countries.forEach(System.out::println);
	}

	public static void displayCountryCapitals() {
		countryCaptials.forEach((k, v) -> System.out.println("Key -> " + k + " Value -> " + v));
	}

	public static void sortCountriesByName() {
		Collections.sort(countries, (o1, o2) -> o2.compareToIgnoreCase(o1));
		displayCountries();
	}

	public static void sortCountriesBylength() {
		Collections.sort(countries, (o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareToIgnoreCase(o2);
			}
			return o1.length() - o2.length();

		});
		displayCountries();
	}

	public static void removeCountry() {
		countries.removeIf(country -> country.length() > 6);
		displayCountries();
	}

	public static void main(String[] args) {
		System.out.println("======================DISPLAY COUNTRIES=====================");
		displayCountries();
		System.out.println("======================DISPLAY COUNTRIES AND CAPTIALS=====================");
		displayCountryCapitals();
		System.out.println("======================DISPLAY COUNTRIES DESC ORDER=====================");
		sortCountriesByName();
		System.out.println("======================DISPLAY COUNTRIES BY LENGTH=====================");
		sortCountriesBylength();
		System.out.println("======================DISPLAY COUNTRIES REMOVED SOME COUNTIRES LENGTH ABOVE 6=====================");
		removeCountry();
	}
}
