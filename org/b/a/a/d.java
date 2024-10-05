/*    */ package org.b.a.a;
/*    */ 
/*    */ import org.b.a.c;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class d
/*    */   implements b
/*    */ {
/*    */   public final c a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 15 */     int j = paramCharSequence.length();
/*    */     int k;
/* 17 */     if ((k = paramInt1 + 3) >= j || paramCharSequence.charAt(paramInt1 + 1) != '/' || paramCharSequence.charAt(paramInt1 + 2) != '/') {
/* 18 */       return null;
/*    */     }
/*    */ 
/*    */     
/* 22 */     if ((paramInt1 = b(paramCharSequence, paramInt1 - 1, paramInt2)) == -1) {
/* 23 */       return null;
/*    */     }
/*    */     
/* 26 */     int i = c.a(paramCharSequence, k);
/*    */     
/* 28 */     return new a((org.b.a.d)org.b.a.d.a, paramInt1, i + 1);
/*    */   }
/*    */ 
/*    */   
/*    */   private static int b(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 33 */     int i = -1;
/* 34 */     int j = -1;
/* 35 */     for (paramInt1 = paramInt1; paramInt1 >= paramInt2; paramInt1--) {
/*    */       char c;
/* 37 */       if (c.a(c = paramCharSequence.charAt(paramInt1))) {
/* 38 */         i = paramInt1; continue;
/* 39 */       }  if (c.b(c)) {
/* 40 */         j = paramInt1; continue;
/* 41 */       }  if (a(c)) {
/*    */         continue;
/*    */       }
/*    */     } 
/* 45 */     if (i > 0 && i - 1 == j)
/*    */     {
/*    */       
/* 48 */       i = -1;
/*    */     }
/* 50 */     return i;
/*    */   }
/*    */   
/*    */   private static boolean a(char paramChar) {
/* 54 */     switch (paramChar) {
/*    */       case '+':
/*    */       case '-':
/*    */       case '.':
/* 58 */         return true;
/*    */     } 
/* 60 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\b\a\a\d.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */