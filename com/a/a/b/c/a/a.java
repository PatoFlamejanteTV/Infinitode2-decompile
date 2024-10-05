/*    */ package com.a.a.b.c.a;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class a
/*    */ {
/* 70 */   static final byte[] a = new byte[128];
/*    */   static {
/*    */     char c;
/* 73 */     for (c = Character.MIN_VALUE; c < a.length; c = (char)(c + 1)) {
/* 74 */       a[c] = -1;
/*    */     }
/* 76 */     for (c = '0'; c <= '9'; c = (char)(c + 1)) {
/* 77 */       a[c] = (byte)(c - 48);
/*    */     }
/* 79 */     for (c = 'A'; c <= 'F'; c = (char)(c + 1)) {
/* 80 */       a[c] = (byte)(c - 65 + 10);
/*    */     }
/* 82 */     for (c = 'a'; c <= 'f'; c = (char)(c + 1)) {
/* 83 */       a[c] = (byte)(c - 97 + 10);
/*    */     }
/* 85 */     for (c = '.'; c <= '.'; c = '/')
/* 86 */       a[46] = -4; 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */