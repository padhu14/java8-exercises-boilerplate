package com.learn.e05.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingDaysExercise {

	public static List<String> getNextMonthsWorkingDays() {

		return Stream.iterate(LocalDate.now(), (d) -> d.plusDays(1))
				.filter(d -> !d.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !d.getDayOfWeek().equals(DayOfWeek.SUNDAY)).limit(30)
				.map(d -> d.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))).collect(Collectors.toList());
	}
	
	public static List<String> getBusSchedule(String start, Duration frequency) {
		return Stream.iterate(LocalTime.parse(start), d -> d.plus(frequency))
				.map(d -> d.format(DateTimeFormatter.ofPattern("hh:mm"))).limit(50).collect(Collectors.toList());
	}

	public static void main(String[] args) {

		getNextMonthsWorkingDays().forEach(System.out::println);
		getBusSchedule("10:15", Duration.ofMinutes(10)).forEach(System.out::println);

	}
}
