package com.hanbit.web.util;

/**
13,700
1,233,639
29
* */

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
}