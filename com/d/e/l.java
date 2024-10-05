/*    */ package com.d.e;
/*    */ 
/*    */ import com.d.c.a.c;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class l
/*    */ {
/*    */   private c a;
/*    */   private int b;
/*    */   private List c;
/*    */   private String d;
/*    */   
/*    */   public l(int paramInt, c paramc) {
/* 34 */     this.b = paramInt;
/* 35 */     this.a = paramc;
/*    */   }
/*    */   
/*    */   public l(List paramList, String paramString, c paramc) {
/* 39 */     this.c = paramList;
/* 40 */     this.d = paramString;
/* 41 */     this.a = paramc;
/*    */   }
/*    */   
/*    */   private static String a(int paramInt) {
/* 45 */     int[] arrayOfInt = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
/* 46 */     String[] arrayOfString = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
/* 47 */     StringBuilder stringBuilder = new StringBuilder();
/* 48 */     for (byte b = 0; b < 13; b++) {
/* 49 */       int i = paramInt / arrayOfInt[b];
/* 50 */       for (byte b1 = 0; b1 < i; b1++) {
/* 51 */         stringBuilder.append(arrayOfString[b]);
/*    */       }
/* 53 */       paramInt -= arrayOfInt[b] * i;
/*    */     } 
/* 55 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   public static String a(c paramc, int paramInt) {
/*    */     String str;
/* 60 */     if (paramc == c.ah || paramc == c.af) {
/* 61 */       str = b(paramInt).toLowerCase();
/* 62 */     } else if (str == c.bm || str == c.bl) {
/* 63 */       str = b(paramInt).toUpperCase();
/* 64 */     } else if (str == c.ai) {
/* 65 */       str = a(paramInt).toLowerCase();
/* 66 */     } else if (str == c.bn) {
/* 67 */       str = a(paramInt).toUpperCase();
/* 68 */     } else if (str == c.w) {
/* 69 */       str = ((paramInt >= 10) ? "" : "0") + paramInt;
/*    */     } else {
/* 71 */       str = Integer.toString(paramInt);
/*    */     } 
/* 73 */     return str;
/*    */   }
/*    */ 
/*    */   
/*    */   private static String b(int paramInt) {
/* 78 */     String str = "";
/* 79 */     paramInt--;
/* 80 */     while (paramInt >= 0) {
/* 81 */       int i = paramInt % 26;
/* 82 */       paramInt = paramInt / 26 - 1;
/* 83 */       str = (char)(i + 65) + str;
/*    */     } 
/* 85 */     return str;
/*    */   }
/*    */   public final String a() {
/* 88 */     if (this.c == null) {
/* 89 */       return a(this.a, this.b);
/*    */     }
/* 91 */     StringBuilder stringBuilder = new StringBuilder();
/* 92 */     for (Iterator<Integer> iterator = this.c.iterator(); iterator.hasNext(); ) {
/* 93 */       Integer integer = iterator.next();
/* 94 */       stringBuilder.append(a(this.a, integer.intValue()));
/* 95 */       if (iterator.hasNext()) stringBuilder.append(this.d); 
/*    */     } 
/* 97 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */