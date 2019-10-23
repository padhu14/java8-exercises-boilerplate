package com.learn.e05.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DateTimeExercise {

	private List<Tablet> tablets;

	public DateTimeExercise() {
		tablets = new ArrayList<>();
		tablets.add(new Tablet("CROCIN", "APEX", Date.from(Instant.now()), LocalDate.of(2019, 06, 14)));
		tablets.add(new Tablet("ovamin", "FORTEX", new Date(2012, 10, 17), LocalDate.of(2020, 10, 14)));
		tablets.add(new Tablet("CROCIN2", "APEX", Date.from(Instant.now()), LocalDate.of(2019, 01, 14)));
	}

	public List<String> getExpiringTables(int months) {
		return tablets.stream().filter(tab -> tab.getExpiryDate().isBefore(LocalDate.now().plusMonths(months)))
				.map(tab -> tab.getTabletName()).collect(Collectors.toList());
	}

	public List<Tablet> getExpiringTabletsSorted() {
		tablets.sort((t1, t2) -> t2.getExpiryDate().compareTo(t1.getExpiryDate()));
		return tablets;
	}

	public Map<String, Period> getTabletExpiryPeriod() {
		return tablets.stream().collect(Collectors.toMap(Tablet::getTabletName, t -> Period.between(t.getExpiryDate(),
				t.getManufactureDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())));
	}

	public Map<String, List<String>> getSameYearExpiry() {
		return tablets.stream().filter(tab -> tab.getExpiryDate().getYear() == LocalDate.now().getYear())
				.collect(Collectors.groupingBy(Tablet::getManufacturer,
						Collectors.mapping(Tablet::getTabletName, Collectors.toList())));
	}

	public static void main(String[] args) {
		DateTimeExercise dateTimeExercise = new DateTimeExercise();
		// dateTimeExercise.getExpiringTables(10).forEach(System.out::println);
		// dateTimeExercise.getExpiringTabletsSorted().forEach(System.out::println);
		dateTimeExercise.getTabletExpiryPeriod()
				.forEach((k, v) -> System.out.println("key -> " + k + " value -> " + v));
		dateTimeExercise.getSameYearExpiry().forEach((k, v) -> System.out.println("key -> " + k + " value -> " + v));
	}
}
