package com.learn.e03.collectors;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpecialStreamsExercise {

	public static LinkedList<Integer> getSquaresOfThree() {
		return new LinkedList<>(
				IntStream.range(20, 50).filter(i -> i % 3 == 0).boxed().map(p -> p * p).collect(Collectors.toList()));

	}

	public static List<Integer> getMultiplesOfFive() {
		return IntStream.iterate(5, i -> i + 5).limit(20).boxed().collect(Collectors.toList());
	}

	public static void main(String[] args) {
		getSquaresOfThree().forEach(System.out::println);
		getMultiplesOfFive().forEach(System.out::println);
	}

}
