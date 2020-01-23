package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Name: JiaJia liu
 * Email: jpl5840@psu.edu
 * Course: IST 311
 * Assignment: IA01
 */

public class Main
{
  public static Scanner scnr = new Scanner(System.in);

  public static void main(String[] args) {

    double grade;
    //Two lists for Valid Grades and Invalid Grades
    List<Double> GradeList = new ArrayList<>();
    List<Double> NoGradeList = new ArrayList<>();

    //initialized max and min for highest and lowest grades
    double max = 0;
    double min = 100;

    //use while loop to allow user to input grades and setting limits on inputting the grades
    while (true) {
      //user input the grades
      System.out.print("Enter the grade, -1 to Finish\n");
      grade = scnr.nextDouble();
      //Grade should be between 0 - 100
      if ((grade >= 0) && (grade <= 100)) {
        //to determine the highest and lowest grade in the Valid Grades list
        if (grade > max) {
          max = grade;
        }
        if ((grade < min) && (grade != -1)) {
          min = grade;
        }
        //adding grades into the Valid Grades list
        GradeList.add(grade);
      }
      //Renter in the grade that is less than -1 and greater 100, or is -1
      else if ((grade < -1) || (grade > 100) && (grade != -1)) {
        System.out.print("Error.  Grade must be between 0 and 100; or -1 to finish\n");
        NoGradeList.add(grade);
        System.out.print("Enter the grade, -1 to Finish\n");
        grade = scnr.nextDouble();

      }
      //Enter -1 to display number of valid and invalid grades lists, display these two lists, and show highest, lowest, and average grades
      else if (grade == -1) {
        for (int i = 0; i < GradeList.size(); i++) {
          if (GradeList.get(i) >= 0 && GradeList.get(i) <= 100) {
            int GradeNum = GradeList.size();
            int NoGradeNum = NoGradeList.size();
            //total number of valid and invalid grades lists
            System.out.println("\nYou entered " + GradeNum + " valid Grades.");
            System.out.println("You entered " + NoGradeNum + " invalid Grades.\n");

            //highest score
            System.out.println("\nHighest Grade: " + max);
            assignGrade(max);
            //lowest score
            System.out.println("\nLowest Grade: " + min);
            assignGrade(min);

            //calcuating average score
            double sumGrades = 0;
            for (double sum : GradeList) {
              sumGrades = sumGrades + sum;
            }
            //show average score
            System.out.println("\nAverage Grade: " + sumGrades / GradeNum);
            assignGrade(sumGrades / GradeNum);

            //display the Valid Grades list
            System.out.println("\nHere are the " + GradeNum + " valid Grades:");
            for (double ScoreList : GradeList) {
              System.out.println(ScoreList);
            }

            //display the Invalid Grades List
            System.out.println("\nHere are the " + NoGradeNum + " invalid Grades: ");
            for (double NoScoreList : NoGradeList) {
              System.out.println(NoScoreList);
            }
          }
        }
        break;
      }
    }
  }

  //Calculating and display the letter grade method
  public static void assignGrade(double score) {
    if (score >= 93.0 && score <= 100) {
      System.out.print(score + "(A)");
    }
    else if (score >= 90.0 && score <= 92.9) {
      System.out.print(score + "(A-)");
    }
    else if (score >= 87.0 && score <= 89.9) {
      System.out.print(score + "(B+)");
    }
    else if (score >= 83.0 && score <= 86.9) {
      System.out.print(score + "(B-)");
    }
    else if (score >= 77.0 && score <= 79.9) {
      System.out.print(score + "(C+)");
    }
    else if (score >= 70.0 && score <= 76.9) {
      System.out.print(score + "(C)");
    }
    else if (score >= 60.0 && score <= 69.9) {
      System.out.print(score + "(D)");
    }
    else if (score >= 00.0 && score <= 59.9) {
      System.out.print(score + "(F)");
    }
  }
}
