/*    */ package org.b.a.a;
/*    */ 
/*    */ import org.b.a.c;
/*    */ import org.b.a.d;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class e
/*    */   implements b
/*    */ {
/*    */   public final c a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*    */     int j;
/* 17 */     if ((j = paramInt1 + 4) >= paramCharSequence.length() || !b(paramCharSequence, paramInt1)) {
/* 18 */       return null;
/*    */     }
/*    */ 
/*    */     
/* 22 */     if ((paramInt1 = b(paramCharSequence, paramInt1, paramInt2)) == -1) {
/* 23 */       return null;
/*    */     }
/*    */     
/*    */     int i;
/* 27 */     if ((i = a(paramCharSequence, j)) == -1) {
/* 28 */       return null;
/*    */     }
/*    */     
/* 31 */     return new a(d.c, paramInt1, i + 1);
/*    */   }
/*    */   
/*    */   private static int b(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 35 */     if (paramInt1 == paramInt2) {
/* 36 */       return paramInt1;
/*    */     }
/*    */ 
/*    */     
/* 40 */     if (a(paramCharSequence.charAt(paramInt1 - 1))) {
/* 41 */       return paramInt1;
/*    */     }
/*    */     
/* 44 */     return -1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static int a(CharSequence paramCharSequence, int paramInt) {
/* 52 */     int i = c.a(paramCharSequence, paramInt), j = i;
/* 53 */     while (--j > paramInt) {
/* 54 */       if (paramCharSequence.charAt(j) == '.' && j > paramInt) return i;
/*    */     
/*    */     } 
/* 57 */     return -1;
/*    */   }
/*    */   
/*    */   private static boolean a(char paramChar) {
/* 61 */     return (paramChar != '.' && !c.c(paramChar));
/*    */   }
/*    */   
/*    */   private static boolean b(CharSequence paramCharSequence, int paramInt) {
/* 65 */     if (paramCharSequence
/* 66 */       .charAt(paramInt + 1) == 'w' && paramCharSequence
/* 67 */       .charAt(paramInt + 2) == 'w' && paramCharSequence
/* 68 */       .charAt(paramInt + 3) == '.') return true; 
/*    */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\b\a\a\e.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */