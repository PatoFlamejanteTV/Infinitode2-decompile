/*    */ package com.a.a.c.c;
/*    */ 
/*    */ import com.a.a.b.c.a.e;
/*    */ import com.a.a.b.j;
/*    */ import com.a.a.b.l;
/*    */ import com.a.a.c.c.a.z;
/*    */ import com.a.a.c.l;
/*    */ import java.io.Closeable;
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
/*    */ public final class w
/*    */   extends l
/*    */ {
/*    */   private z b;
/*    */   private List<e> c;
/*    */   
/*    */   public w(l paraml, String paramString, j paramj, z paramz) {
/* 28 */     super((Closeable)paraml, paramString, paramj);
/* 29 */     this.b = paramz;
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
/*    */   public final z d() {
/* 47 */     return this.b;
/*    */   }
/*    */   
/*    */   public final Object f() {
/* 51 */     return (this.b.a()).a;
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
/*    */   public final String getMessage() {
/* 65 */     String str = super.getMessage();
/* 66 */     if (this.c == null) {
/* 67 */       return str;
/*    */     }
/*    */     
/* 70 */     StringBuilder stringBuilder = new StringBuilder(str);
/* 71 */     Iterator<e> iterator = this.c.iterator();
/* 72 */     if (iterator.hasNext()) {
/* 73 */       e e = iterator.next();
/* 74 */       throw null;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 79 */     stringBuilder.append('.');
/* 80 */     return stringBuilder.toString();
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
/*    */   private synchronized w g() {
/* 94 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */