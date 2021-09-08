import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Student
{
	private String firstName;
	private String lastName;
	private int idNum;
	private double gpa;
	private int numCredits;
	private static int nextID = 1;

	public Student(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		gpa = 0;
		numCredits = 0;
		idNum = nextID;
		nextID++;
	}
	public void addCourse(int numCredits, String grade)
	{
		double numGrade = 0;
		switch(grade)
		{
			case "A": numGrade = 4.00;
				  break;
			case "A-": numGrade = 3.70;
				   break;
			case "B+": numGrade = 3.30;
				   break;
			case "B": numGrade = 3.00;
				  break;
			case "B-": numGrade = 2.70;
				   break;
			case "C+": numGrade = 2.30;
				   break;
			case "C": numGrade = 2.00;
				  break;
			case "C-": numGrade = 1.70;
				   break;
			case "D+": numGrade = 1.30;
				   break;
			case "D": numGrade = 1.00;
				  break;
			case "F": numGrade = 0.00;
				  break;
			default: System.out.println("Invalid grade.");
				 break;
		}
		gpa = (gpa * this.numCredits + numGrade * numCredits) / (this.numCredits + numCredits);
		this.numCredits += numCredits;
	}
	public void report()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(firstName + " " + lastName);
		System.out.println("ID Number: " + idNum + "\nGPA: " + df.format(gpa) + "\nNumber of Credits: " + numCredits);
		System.out.println();
	}
	public boolean canGraduate()
	{
		if (numCredits >= 120 && gpa >= 2.00)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

