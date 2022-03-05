package practice.Pizza_Management_System;

import java.io.IOException;
import java.util.*;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	ArrayList<Pizza> list=new ArrayList<Pizza>();
    	Scanner sc=new Scanner(System.in);
    	Methods_Class methods=new Methods_Class();
    	int ch;
    	do {
    		System.out.println("*******Pizza Management System*******");
			System.out.println("1.Take Order \n2.View Order \n3.Delete Order \n4.Search Order \n0.Exit");
			System.out.println("Enter your Choice");
			ch=sc.nextInt();
			switch (ch) {
			case 1://Add Order
				Pizza pizza=methods.take_Order();
				list.add(pizza);
				methods.writer(list);
				break;
				
			case 2://View Order
				methods.view_Orders(list);
				break;
			
			case 3://Delete Order
				System.out.println("Enter Order ID");
				int del_Order=sc.nextInt();
				methods.delete_Order(list,del_Order);
				break;
			
			case 4://Search Order
				System.out.println("Enter Order ID");
				int search_Order=sc.nextInt();
				methods.search_Order(list,search_Order);
				break;
			
			case 0://exit
				System.out.println("Thank You!");
				System.exit(ch);
				break;
			
			default://Wrong Selection
				System.out.println("Select correct option");
				break;
			}
    	}
    	while(ch!=0);
    }
}
