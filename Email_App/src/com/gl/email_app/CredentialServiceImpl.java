package com.gl.email_app;

public class CredentialServiceImpl implements ICredentialService  {

	
	@Override
	public String generateEmailAddress(String firstName,String lastName ,int departmentCode) {
		// TODO Auto-generated method stub
		
		StringBuilder emailBuilder = new StringBuilder();
		emailBuilder.append(firstName);
		emailBuilder.append(".");
		emailBuilder.append(lastName);
		emailBuilder.append("@");
		
		if(departmentCode == 1)
			emailBuilder.append("tech");
		else if(departmentCode == 2)
			emailBuilder.append("admin");
		else if(departmentCode == 3)
			emailBuilder.append("hr");
		else if(departmentCode == 4)
			emailBuilder.append("legal");
		
		emailBuilder.append(".");
		emailBuilder.append("gl.com");
		
		return emailBuilder.toString();
	}

	@Override
	public String generatePassword() {
		// TODO Auto-generated method stub
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialChars = "@!#$%^&*{}:<>?";
		
		StringBuilder passwordBuilder = new StringBuilder();
		
		for(int i=0;i<=2;i++)
		{
			java.util.Random randomObj = new java.util.Random();
			int randomValue = randomObj.nextInt(capitalLetters.length());
			char chars = capitalLetters.charAt(randomValue);
			passwordBuilder.append(chars);
		}
		for(int i=0;i<=2;i++)
		{
			java.util.Random randomObj = new java.util.Random();
			int randomValue = randomObj.nextInt(smallLetters.length());
			char randomCharValue = smallLetters.charAt(randomValue);
			passwordBuilder.append(randomCharValue);
		}
		for(int i=0;i<=2;i++)
		{
			java.util.Random randomObj = new java.util.Random();
			int randomValue = randomObj.nextInt(numbers.length());
			char randomCharValue = numbers.charAt(randomValue);
			passwordBuilder.append(randomCharValue);
		}
		for(int i=0;i<=2;i++)
		{
			java.util.Random randomObj = new java.util.Random();
			int randomValue = randomObj.nextInt(specialChars.length());
			char randomCharValue = specialChars.charAt(randomValue);
			passwordBuilder.append(randomCharValue);
		}
		return passwordBuilder.toString();
	}
	
	@Override
	public void showCredentials(Employee employee) {
		// TODO Auto-generated method stub

		System.out.println("Dear " + employee.getFirstName()
				+ ", your generated credentials are as follows");
		
		System.out.println("Email        --->  " + employee.getEmailAddress());
		System.out.println("Password     --->  " + employee.getPassword());		
	
	}
	
	

}
