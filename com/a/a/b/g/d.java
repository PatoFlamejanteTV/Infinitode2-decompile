/*    */ package com.a.a.b.g;
/*    */ 
/*    */ import com.a.a.b.h;
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
/*    */ public final class d
/*    */   extends e.c
/*    */ {
/*    */   private static String b;
/*    */   
/*    */   static {
/*    */     String str;
/*    */     try {
/* 22 */       str = System.getProperty("line.separator");
/* 23 */     } catch (Throwable throwable) {
/* 24 */       str = "\n";
/*    */     } 
/* 26 */     b = str;
/*    */   }
/*    */   
/* 29 */   public static final d a = new d("  ", b);
/*    */ 
/*    */ 
/*    */   
/*    */   private final char[] c;
/*    */ 
/*    */   
/*    */   private final int d;
/*    */ 
/*    */   
/*    */   private final String e;
/*    */ 
/*    */ 
/*    */   
/*    */   public d() {
/* 44 */     this("  ", b);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private d(String paramString1, String paramString2) {
/* 56 */     this.d = paramString1.length();
/*    */     
/* 58 */     this.c = new char[paramString1.length() << 4];
/* 59 */     int i = 0;
/* 60 */     for (byte b = 0; b < 16; b++) {
/* 61 */       paramString1.getChars(0, paramString1.length(), this.c, i);
/* 62 */       i += paramString1.length();
/*    */     } 
/*    */     
/* 65 */     this.e = paramString2;
/*    */   }
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
/*    */   public final boolean a() {
/* 85 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void a(h paramh, int paramInt) {
/* 90 */     paramh.c(this.e);
/* 91 */     if (paramInt > 0) {
/* 92 */       paramInt *= this.d;
/* 93 */       while (paramInt > this.c.length) {
/* 94 */         paramh.b(this.c, 0, this.c.length);
/* 95 */         paramInt -= this.c.length;
/*    */       } 
/* 97 */       paramh.b(this.c, 0, paramInt);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\g\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */