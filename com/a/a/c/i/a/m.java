/*    */ package com.a.a.c.i.a;
/*    */ 
/*    */ import com.a.a.c.b.q;
/*    */ import com.a.a.c.d;
/*    */ import com.a.a.c.i.c;
/*    */ import com.a.a.c.j;
/*    */ import com.a.a.c.l.o;
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
/*    */ public final class m
/*    */   extends k
/*    */ {
/*    */   private String c;
/*    */   private String d;
/*    */   
/*    */   private m(j paramj, o paramo, c paramc) {
/* 30 */     super(paramj, paramo, paramc);
/*    */     String str;
/*    */     int i;
/* 33 */     if ((i = (str = paramj.b().getName()).lastIndexOf('.')) < 0) {
/* 34 */       this.c = "";
/* 35 */       this.d = "."; return;
/*    */     } 
/* 37 */     this.d = str.substring(0, i + 1);
/* 38 */     this.c = str.substring(0, i);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static m b(j paramj, q<?> paramq, c paramc) {
/* 44 */     return new m(paramj, paramq.p(), paramc);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final String a(Object paramObject) {
/* 54 */     if ((paramObject = paramObject.getClass().getName()).startsWith(this.d))
/*    */     {
/* 56 */       return paramObject.substring(this.d.length() - 1);
/*    */     }
/* 58 */     return (String)paramObject;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected final j a(String paramString, d paramd) {
/* 64 */     if (paramString.startsWith(".")) {
/* 65 */       StringBuilder stringBuilder = new StringBuilder(paramString.length() + this.c.length());
/* 66 */       if (this.c.isEmpty()) {
/*    */         
/* 68 */         stringBuilder.append(paramString.substring(1));
/*    */       } else {
/*    */         
/* 71 */         stringBuilder.append(this.c).append(paramString);
/*    */       } 
/* 73 */       paramString = stringBuilder.toString();
/*    */     } 
/* 75 */     return super.a(paramString, paramd);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */