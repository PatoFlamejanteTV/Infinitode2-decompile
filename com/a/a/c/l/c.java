/*    */ package com.a.a.c.l;
/*    */ 
/*    */ import com.a.a.c.j;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class c
/*    */ {
/*    */   private c a;
/*    */   private Class<?> b;
/*    */   private ArrayList<k> c;
/*    */   
/*    */   public c(Class<?> paramClass) {
/* 21 */     this(null, paramClass);
/*    */   }
/*    */   
/*    */   private c(c paramc, Class<?> paramClass) {
/* 25 */     this.a = paramc;
/* 26 */     this.b = paramClass;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final c a(Class<?> paramClass) {
/* 33 */     return new c(this, paramClass);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(k paramk) {
/* 42 */     if (this.c == null) {
/* 43 */       this.c = new ArrayList<>();
/*    */     }
/* 45 */     this.c.add(paramk);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(j paramj) {
/* 55 */     if (this.c != null) {
/* 56 */       for (Iterator<k> iterator = this.c.iterator(); iterator.hasNext();) {
/* 57 */         (k = iterator.next()).e(paramj);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final c b(Class<?> paramClass) {
/* 64 */     if (this.b == paramClass) return this; 
/* 65 */     for (c c1 = this.a; c1 != null; c1 = c1.a) {
/* 66 */       if (c1.b == paramClass) {
/* 67 */         return c1;
/*    */       }
/*    */     } 
/* 70 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/*    */     StringBuilder stringBuilder;
/* 76 */     (stringBuilder = new StringBuilder()).append("[ClassStack (self-refs: ")
/* 77 */       .append((this.c == null) ? "0" : String.valueOf(this.c.size()))
/* 78 */       .append(')');
/*    */     
/* 80 */     for (c c1 = this; c1 != null; c1 = c1.a) {
/* 81 */       stringBuilder.append(' ').append(c1.b.getName());
/*    */     }
/* 83 */     stringBuilder.append(']');
/* 84 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */