package com.learn.e05.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BankDepositExercise {

	public static String getMaturityDate(String investmentDate, Period duration) {
		return LocalDate.parse(investmentDate).plus(duration).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
	}

	public static String getInvestmentPeriod(String investmentDate, String maturityDate) {
		Period duration = Period.between(LocalDate.parse(investmentDate),LocalDate.parse(maturityDate));
		return "<" + duration.getYears() + " years," + duration.getMonths() + "  months>";
	}

	public static void main(String[] args) {
		System.out.println(getMaturityDate("2019-12-06", Period.of(2, 10, 2)));
		System.out.println(getInvestmentPeriod("2019-12-06", "2022-10-08"));
	}
}
