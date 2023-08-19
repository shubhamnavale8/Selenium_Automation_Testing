package com.seleniumtesting.seleniumMavenProject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        // FakeLeadData ld=new FakeLeadData(11);         // --->()insert the number of row of lead data from excel sheet
		//  String firstName=ld.firstName(),lastName=ld.lastName(),company=ld.company(),email=ld.email(),phone=ld.phone();	 
		//  System.out.println(ld.firstName());
		//  System.out.println(ld.lastName());
		//  System.out.println(ld.company());
		//  System.out.println(ld.email());
		//  System.out.println(ld.phone());

		int value = 15;
        assert value >= 20 : " Underweight";
        System.out.println("value is " + value);
    }
}
