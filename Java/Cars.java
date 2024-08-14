package com.cathaybk.practice.nt50354.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
	public static void main(String[] args) {// 這裡確認 要用TRY WITH RESOURCE存起來
		try (InputStreamReader isr = new InputStreamReader(
				new FileInputStream("C:/Users/Admin/Desktop/Java班/教材/Java/cars.csv"));) {
			BufferedReader reader = new BufferedReader(isr);

			String line = null;
			try {
				line = reader.readLine();
				// 可直接另外直接存標題，可以後續運用在其他標題
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] header = line.split(",");
			List<Map<String, String>> carslist = new ArrayList<>();

			while ((line = reader.readLine()) != null) {
				String[] item = line.split(",");

				Map<String, String> carsMap = new LinkedHashMap<>();

				carsMap.put(header[0], item[0]);

				carsMap.put(header[1], item[1]);

				carsMap.put(header[2], item[2]);

				carsMap.put(header[3], item[3]);

				carslist.add(carsMap);

			}
			Collections.sort(carslist, new Comparator<Map<String, String>>() {
				@Override
				public int compare(Map<String, String> car1, Map<String, String> car2) {

					BigDecimal price1 = new BigDecimal(car1.get("Price"));

					BigDecimal price2 = new BigDecimal(car2.get("Price"));

					return price2.compareTo(price1);
				}
			});
			try (BufferedWriter writer = new BufferedWriter(
					new FileWriter("C:/Users/Admin/Desktop/Java班/教材/Java/cars2.csv"))) {

				writer.write("MANUFACTURER,TYPE,MIN_PRICE,PRICE");

				writer.newLine();

				for (Map<String, String> car : carslist) {
					StringBuilder sb = new StringBuilder();
					sb.append(car.get("Manufacturer")).append(',').append(car.get("Type")).append(',')
							.append(car.get("Min.Price")).append(',').append(car.get("Price"));
					writer.write(sb.toString());// JOIN效能是差的，使用SB較佳

					writer.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			Stream<Map<String, String>> carStream = carslist.stream();

			Map<String, List<Map<String, String>>> manufacturerGroups = carStream
					.collect(Collectors.groupingBy(car -> car.get("Manufacturer")));

			BigDecimal totalMinPrice = BigDecimal.ZERO;

			BigDecimal totalPrice = BigDecimal.ZERO;

			System.out.printf("%-12s %-7s %9s %5s%n", "MANUFACTURER", "TYPE", "MIN_PRICE", "PRICE");

			for (String manufacturer : manufacturerGroups.keySet()) {

				List<Map<String, String>> carsByManufacturer = manufacturerGroups.get(manufacturer);

				BigDecimal manufacturerMinPriceTotal = BigDecimal.ZERO;

				BigDecimal manufacturerPriceTotal = BigDecimal.ZERO;

				for (Map<String, String> car : carsByManufacturer) {

					BigDecimal minPrice = new BigDecimal(car.get("Min.Price"));

					BigDecimal price = new BigDecimal(car.get("Price"));

					System.out.printf("%-12s %-7s %9s %5s%n", car.get("Manufacturer"), car.get("Type"), minPrice,
							price);

					manufacturerMinPriceTotal = manufacturerMinPriceTotal.add(minPrice);

					manufacturerPriceTotal = manufacturerPriceTotal.add(price);
				}

				System.out.printf("小計\t%22s %5s%n", manufacturerMinPriceTotal, manufacturerPriceTotal);

				totalMinPrice = totalMinPrice.add(manufacturerMinPriceTotal);

				totalPrice = totalPrice.add(manufacturerPriceTotal);
			}
			System.out.printf("合計\t%22s %5s%n", totalMinPrice, totalPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}