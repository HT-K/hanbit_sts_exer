/*package com.hanbit.web.util;

*//**
13,700
1,233,639
29
* *//*

public class MoneyExpr {
   public static void main(String[] args) {
      String money = "100000";
      int mon = money.length();
      for(int i= mon-3 ;i>0 ; i-=3)
      {
         String temp1 = money.substring(0, i);
         String temp2 = money.substring(i);
         money = temp1+ ","+ temp2;
         
      }
      System.out.println("값은 : "+ money +"원");
   }
}*/

package com.hanbit.web.util;

import java.text.DecimalFormat;

/**
 * 13,700
 */
public class MoneyExpr {
	public static void main(String[] args) {
		 DecimalFormat df = new DecimalFormat("#,###");
		 System.out.println(df.format(984984984));
	}
	/*public static String parsingMoney(String money){
		
		
		 DecimalFormat df = new DecimalFormat("#,###");
		 System.out.println(df.format(984984984));
		 
		 int result = money.length() % 3;
		 if(result == 0){
			 result = money.length() / 2;
		 }
		 int len = money.length();
		String start =	money.substring(0, result);
		while(result < len){
			start += ","+money.substring(result,result+3);
			result += 3;
		}
		return start;
	}*/

}