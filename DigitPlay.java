/*
 * This Java program takes a positive integer of type long
 * and prints the following about its digits:
 *
 *     + the number of digits
 *     + the smallest digit
 *     + the largest digit
 *     + the range of the digits
 *     + the sum of the digits
 *     + the average of the digits (digit 0 is included)
 *     + the product of the digits (digit 0 is excluded)
 *
 * @creator gdt
 * @created 02018.12.08
 * @assignment #DigitPlay: implement the  play()  method
 */

/*
Description: The program does what is stated above. It provides information about the digits in that number. 

Edited by: John Cody
Edited on: 02019.01.30
*/

public class DigitPlay {

   public static final String INDENT = "\n   ";

   public static void main(String[] argv) {
      long[] data = { 5, 42, Byte.MAX_VALUE, 1024, Short.MAX_VALUE,
                      Integer.MAX_VALUE, Long.MAX_VALUE };
      for (int i = 0; i < data.length; i++)
         print(play(new Result(data[i])));
   }

   public static void print(Result r) {
      System.out.print("number: " + r.number +
                        INDENT + "   # of digits: " + r.ndigits +
                        INDENT + "smallest digit: " + r.min + 
                        INDENT + " largest digit: " + r.max + 
                        INDENT + "   digit range: " + r.range + 
                        INDENT + "     digit sum: " + r.sum + 
                        INDENT + " digit average: " + r.avg + 
                        INDENT + " digit product: " + r.product);
      if (r.has0) System.out.print(" (no multiply by 0)");
      System.out.println("\n");
   }

   static class Result {
      public long number;
      public int ndigits;
      public int min = 10;
      public int max = -1;
      public int range;
      public int sum;
      public long product = 1;
      public double avg;
      public boolean has0;
      public Result(long n) { number = n; }
   }

   /** 
    * TBI (To Be Implemented)...
    *
    * Using a number stored a Result object, this method fills in 
    * the following information about the digits of the number: 
    * # of digits; smallest digit; largest digit; digit range; 
    * digit sum; digit average; flag if number contains a 0;
    * digit product that excludes multiplying by 0 digits
    *
    * @param Result object r to fill in for r.number
    * @return the filled in Result object r
    */
   public static Result play(Result r) {
       
       int digits, min, max, sum = 0; 
       long num = r.number, product = 1;
       r.has0 = false;
       
       
       for(digits = 0; num > 0; digits++) {
           num = num/10;
       }
       
       int number[] = new int[digits];
       num = r.number;
       
       for(int i = 0; i < digits; i++) {
           number[digits - i - 1] = (int)(num % 10);
           num /= 10;
       }
       
       min = number[0];
       max = number[0];
       
       for(int i = 0; i < digits; i++) {
           if(min > number[i]) {
               min = number[i];
           }
           if(max < number[i]) {
               max = number[i];
           }
           sum += number[i];
           if(number[i] == 0) {
               r.has0 = true;
           }
           else {
               product *= number[i];
           }
       }
       
       r.ndigits = digits;
       r.min = min;
       r.max = max;
       r.range = max - min;
       r.sum = sum;
       r.product = product;
       r.avg = sum/(digits*1.0);
       
      return r;
   }
}