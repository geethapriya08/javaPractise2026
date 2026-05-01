package com.impJavaPractice.app;

public class GitPractise1 {

	void practiseMethod1() {
		System.out.println("This is for Practise");
		System.out.println("New change");
		System.out.println(" This line belongs to Anil");
	}

	void add() {
		int a = 1;
		int b = 3;

		int c = a + b;
		int d=c;
		System.out.println("Print d"+ d);
		System.out.println("Addition : " + c);
		System.out.println("This is to test git merge conflicts");
<<<<<<< HEAD
		System.out.println("This is new line1");
=======
		System.out.println(" As per your change request, I have updated the code.");
>>>>>>> bba29c8ae2d4aac078477ef5a21cb3376ada6487
	}

}
