package com.learn.e04.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.learn.e05.datetime.Tablet;

public class NIO2Exercise {



	public static Map<String, LocalDate> getExpiredTablets() {
		Path path = Paths.get("data","InputFile.txt");
		try {
			return Files.lines(path).map(NIO2Exercise::parseValue).filter(tab -> tab.getExpiryDate().isBefore(LocalDate.now())).collect(Collectors.toMap(Tablet::getTabletName, Tablet::getExpiryDate));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static Tablet parseValue(String line) {
		String[] args = line.split(",");
		Date manufactureDate = null;
		LocalDate expiryDate = null;
		try {
			manufactureDate = new SimpleDateFormat("dd/MM/yyy").parse(args[3]);
			expiryDate = LocalDate.parse(args[4],DateTimeFormatter.ofPattern("dd/MM/yyy"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return  new Tablet(args[0], args[1], manufactureDate, expiryDate);
	}

	public static List<String> getListOfJavaFiles() {
		Path path = Paths.get("");
		try {
			return Files.walk(path).filter(Files::isRegularFile)
					.filter(f -> f.getFileName().toString().contains(".java")).map(p -> p.toFile().getName())
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean fileSearch(String filename,String absoultePath) {
		Path path = Paths.get(absoultePath);
		try {
			return Files.walk(path).filter(Files::isRegularFile)
					.filter(f -> f.getFileName().toString().equals(filename)).findFirst().isPresent();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public static void main(String[] args) {
//		getListOfJavaFiles().forEach(System.out::println);
		System.out.println(fileSearch("SpecialStreamsExercise.java", "/home/ubuntu/git/java8-exercises-boilerplate"));
	}

}
