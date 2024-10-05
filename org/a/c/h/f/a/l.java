/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class l
/*     */ {
/*     */   private final d a;
/*     */   
/*     */   public l() {
/*  42 */     this.a = new d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public l(d paramd) {
/*  51 */     this.a = paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f a() {
/*     */     b b;
/*  71 */     if ((b = this.a.a(j.ac)) == null)
/*     */     {
/*  73 */       return null;
/*     */     }
/*  75 */     return f.a(b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<String> b() {
/*  84 */     ArrayList<String> arrayList = new ArrayList();
/*     */     a a;
/*  86 */     if ((a = (a)this.a.a(j.ae)) == null)
/*     */     {
/*  88 */       return arrayList;
/*     */     }
/*  90 */     for (b b : a)
/*     */     {
/*  92 */       arrayList.add(((j)b).a());
/*     */     }
/*  94 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 100 */     StringBuilder stringBuilder = new StringBuilder("Process{");
/*     */     
/*     */     try {
/* 103 */       stringBuilder.append(a());
/* 104 */       for (String str : b())
/*     */       {
/* 106 */         stringBuilder.append(" \"");
/* 107 */         stringBuilder.append(str);
/* 108 */         stringBuilder.append('"');
/*     */       }
/*     */     
/* 111 */     } catch (IOException iOException) {
/*     */       
/* 113 */       stringBuilder.append("ERROR");
/*     */     } 
/* 115 */     stringBuilder.append('}');
/* 116 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */