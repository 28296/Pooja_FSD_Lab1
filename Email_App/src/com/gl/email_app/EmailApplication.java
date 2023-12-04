package com.gl.email_app;

import java.util.Scanner;

public class EmailApplication {

	public void init() 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your First Name");
		String firstName = input.nextLine();
		
		System.out.println("Enter your Last Name");
		String lastName = input.nextLine();
		
		System.out.println("Enter your department");
		System.out.println("specify the following department code values");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. HumanResource");
		System.out.println("4. Legal");
		
		int departmentCode = input.nextInt();
		
		if(EmailAppUtils.validateDepartmentCode(departmentCode))
		{
		
			CredentialServiceImpl serviceObj = new CredentialServiceImpl();
			String emailAddress = serviceObj.generateEmailAddress(firstName,lastName, departmentCode);
			
			String password = serviceObj.generatePassword();
			
			Employee employee = new Employee(firstName,lastName,emailAddress,password);
			
			serviceObj.showCredentials(employee);
		
		}else {
			System.out.println("Invalid Department Code");
			System.out.println("Enter a department code between 1 and 4");
			System.out.println("Please try again..");
		}
		
	}
}
