/*    */ package com.d.c.e;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Locale;
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
/*    */ public final class b
/*    */   implements e
/*    */ {
/* 27 */   private final List<String> a = new ArrayList<>(1);
/* 28 */   private final List<d> b = new ArrayList<>();
/*    */   private final int c;
/*    */   
/*    */   public b(int paramInt) {
/* 32 */     this.c = paramInt;
/*    */   }
/*    */   
/*    */   public final void a(String paramString) {
/* 36 */     this.a.add(paramString);
/*    */   }
/*    */   
/*    */   public final boolean b(String paramString) {
/* 40 */     if (paramString.equalsIgnoreCase("all") || this.a.contains("all")) {
/* 41 */       return true;
/*    */     }
/* 43 */     return this.a.contains(paramString.toLowerCase(Locale.US));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(d paramd) {
/* 49 */     this.b.add(paramd);
/*    */   }
/*    */   
/*    */   public final List<d> b() {
/* 53 */     return this.b;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int a() {
/* 58 */     return this.c;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\e\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */