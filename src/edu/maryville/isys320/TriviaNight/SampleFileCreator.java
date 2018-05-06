package edu.maryville.isys320.TriviaNight;

import java.io.*;
import java.util.Scanner;
/*
 * Before start the program please make sure 'data' folder must be empty other wise result may wrong or error may occur.
 */
public class SampleFileCreator {

	public static void main(String[] args) {
		int totalRound = 0;
		//System.out.println("please enter the number of round");
		System.out.println("NOTE : Before start the program please make sure 'data' folder must be empty other wise result may wrong or error may occur. ");
		Scanner inputCategory = new Scanner(System.in);
		Scanner questionNum = new Scanner(System.in);
		boolean isContinue = true;
		int totalQuestionNum = 0 ;					
		do{
			System.out.print("Please enter Number of questions for each 10 categories : ");
			if(questionNum.hasNextInt()){
				isContinue = false;
				totalQuestionNum = questionNum.nextInt();
			} else {
				System.out.println("!!!! Invalid input, number of questions must be integer !!!  ");
				questionNum.next();
			}
		}while(isContinue);
		for (int round = 1; round <= 10; round++) {
			// Get the output file name and round number
			//String fileName = "category_name_" + round + ".txt";
			String catName = "";
			System.out.print("please enter category name "+round+": ");
			//input = new Scanner(System.in);
			if(inputCategory.hasNext()){
				catName = inputCategory.nextLine();
			} 
			String fileName = "data/" + catName + ".txt";
			String roundNumber = String.valueOf(round);
			File f = new File(fileName);

			//System.out.println("Creating file: " + f.getAbsolutePath());
			
			
			// Create the output file, overwrite it if it exists
			PrintStream s;
			try {
				s = new PrintStream(f);
				for (int i = 1; i <= totalQuestionNum; i++) {
					s.println("Question " + i + " of "+totalQuestionNum);
					s.println("Answer " + i + " of "+totalQuestionNum);
					s.println();
				}

				// flush the output file, to ensure the last thing written is capture in the
				// file.
				s.flush();

				// close the output file.
				s.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}