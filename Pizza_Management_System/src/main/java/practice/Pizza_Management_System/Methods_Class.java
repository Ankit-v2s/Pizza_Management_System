package practice.Pizza_Management_System;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Methods_Class {
	Scanner sc = new Scanner(System.in);
	int order_id = 101, quantity, count = 0;
	String pizza_name;
	double price, amt;
	boolean flag = true;

	public Pizza take_Order() {
		System.out.println("Enter Pizza Name");
		pizza_name = sc.next();
		System.out.println("Enter Quantity");
		quantity = sc.nextInt();
		System.out.println("Enter price of pizza");
		price = sc.nextDouble();
		amt = price * quantity;

		Pizza take_order = new Pizza();
		take_order.setOrder_Id(order_id);
		take_order.setPizza_Name(pizza_name);
		take_order.setQuantity(quantity);
		take_order.setPrice(price);
		take_order.setAmount(amt);

		order_id++;
		return take_order;
	}

	public void writer(ArrayList<Pizza> list) throws IOException {
		String[] columns = { "Order_Id", "Pizza Name", "Quantity", "Price", "Amount" };

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Pizza");
		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
		}

		int rowNum = 1;
		for (Pizza pizza : list) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(pizza.getOrder_Id());

			row.createCell(1).setCellValue(pizza.getPizza_Name());
			
			row.createCell(2).setCellValue(pizza.getQuantity());

			row.createCell(3).setCellValue(pizza.getPrice());

			row.createCell(4).setCellValue(pizza.getAmount());
		}

		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
	}

	public void view_Orders(ArrayList<Pizza> list) {
		for (Pizza p : list) {
			if (count == 0) {
				System.out.println("Order_Id \tPizza Name \tQuantity \tPrice \tAmount");
			}
			System.out.println(p.getOrder_Id() + "\t" + p.getPizza_Name() + "\t" + p.getQuantity() + "\tRs. "
					+ p.getPrice() + "\tRs. " + p.getAmount());
			count++;
			flag = false;
		}
		if (flag) {
			System.out.println("No orders available");
		}
	}

	public void delete_Order(ArrayList<Pizza> list, int del_Order) {
		for (Pizza p : list) {
			if (del_Order == p.getOrder_Id()) {
				list.remove(p);
				System.out.println(del_Order + " is removed");
				flag = false;
			}
		}
		if (flag) {
			System.out.println(del_Order + " not found");
		}
	}

	public void search_Order(ArrayList<Pizza> list, int search_Order) {
		for (Pizza p : list) {
			if (search_Order == p.getOrder_Id()) {
				System.out.println("Order_Id \tPizza Name \tQuantity \tPrice \tAmount");
				System.out.println(p.getOrder_Id() + "\t" + p.getPizza_Name() + "\t" + p.getQuantity() + "\tRs. "
						+ p.getPrice() + "\tRs. " + p.getAmount());
				flag = false;
			}
		}
		if (flag) {
			System.out.println(search_Order + " not found");
		}
	}
}
