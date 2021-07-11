package com.brand;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.brand.controller.EmployeeController;

@SpringBootApplication
public class BootMiniProj1Application {

	public static void main(String[] args) {
		System.out.println("Enter No. of designations");
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		String desArr[] = null;
		if (count > 0) {
			desArr = new String[count];
			for (int i = 0; i < count; i++) {
				System.out.println("Enter designation : ");
				desArr[i] = scan.next();
			}

			ApplicationContext ctx = SpringApplication.run(BootMiniProj1Application.class, args);
			EmployeeController ctrl = ctx.getBean("controller",EmployeeController.class);
			try {
				ctrl.getEmployee(desArr);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Internal error occurred ::" + e.getMessage());
			}
		} else {
			System.out.println("Invalid designation count...Please try again");
		}
	}
}
