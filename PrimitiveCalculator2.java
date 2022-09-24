// Author: Jonny Chen
// Instructor: Meisam Amjad
// 09/24/2020

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class PrimitiveCalculator2 {
    public static void main(String[]args) throws FileNotFoundException {

        String infile;
        Scanner keyboardReader = new Scanner(System.in);
        
        System.out.println("Enter input file name: ");
        infile = keyboardReader.next();
        try {
            Scanner in = new Scanner(new File(infile));
            int number = 0;
            int result = 0;        

            for (int count = 1; in.hasNextLine(); count++) {
                String line = in.nextLine();
                Scanner lineF = new Scanner(line);
                String op = lineF.next();
                int total = lineF.nextInt();
                System.out.printf("Result of Line %d: ", count);
                
                try {
                    while (lineF.hasNext()) {
                        if (op.equals("+")) {
                            while (lineF.hasNext()) {
                                total += lineF.nextInt();
                            }
                        } else if (op.equals("-")) {
                            while (lineF.hasNext()) {
                                total -= lineF.nextInt();
                            }
                        } else if (op.equals("*")) {
                            while (lineF.hasNext()) {
                                total *= lineF.nextInt();
                            }
                        } else if (op.equals("/")) {
                            while (lineF.hasNext()) {
                                total /= lineF.nextInt();
                            }
                        }         
                    } //end of while loop
                    System.out.printf("%d\n", total);
                } catch (InputMismatchException e) {
                    System.out.printf("Non-integer input on this Line\n");
                } catch (ArithmeticException e) {
                    System.out.printf("Error: %s\n",
                        e.getMessage());
                }   
            }  //end of for loop
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }               
    } //End of main method       
} //End of Class