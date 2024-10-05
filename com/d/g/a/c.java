/*    */ package com.d.g.a;
/*    */ 
/*    */ import com.d.d.f;
/*    */ import com.d.e.aa;
/*    */ import com.d.m.l;
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.InputStream;
/*    */ 
/*    */ public final class c
/*    */   implements f<InputStream> {
/*    */   private final String a;
/*    */   private final aa b;
/*    */   
/*    */   public c(aa paramaa, String paramString) {
/* 15 */     this.a = paramString;
/* 16 */     this.b = paramaa;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private InputStream b() {
/*    */     byte[] arrayOfByte;
/* 23 */     if ((arrayOfByte = this.b.n().d(this.a)) == null) {
/* 24 */       l.c("Could not load @font-face font: " + this.a);
/* 25 */       return null;
/*    */     } 
/*    */     
/* 28 */     return new ByteArrayInputStream(arrayOfByte);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\g\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */