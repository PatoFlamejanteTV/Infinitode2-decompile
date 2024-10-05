/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.b;
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
/*     */ 
/*     */ 
/*     */ public final class k
/*     */ {
/*     */   private final d a;
/*     */   
/*     */   public k() {
/*  44 */     this.a = new d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k(d paramd) {
/*  53 */     this.a = paramd;
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
/*     */   public final Map<String, u> a() {
/*  72 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     d d1;
/*  74 */     if ((d1 = (d)this.a.a(j.aa)) == null) {
/*     */       
/*  76 */       d1 = new d();
/*  77 */       this.a.a(j.aa, (b)d1);
/*     */     } 
/*  79 */     for (j j : d1.d()) {
/*     */       
/*  81 */       b b = d1.a(j);
/*  82 */       hashMap.put(j.a(), f.a(b));
/*     */     } 
/*  84 */     return (Map<String, u>)new b(hashMap, d1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final l b() {
/*     */     d d1;
/*  94 */     if ((d1 = (d)this.a.a(j.cV)) == null)
/*     */     {
/*  96 */       return null;
/*     */     }
/*  98 */     return new l(d1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 107 */     return "NChannel".equals(this.a.g(j.dE));
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
/*     */   
/*     */   public final String toString() {
/*     */     StringBuilder stringBuilder;
/* 128 */     (stringBuilder = new StringBuilder(this.a.g(j.dE))).append('{');
/*     */     l l;
/* 130 */     if ((l = b()) != null) {
/*     */       
/* 132 */       stringBuilder.append(b());
/* 133 */       stringBuilder.append(' ');
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 139 */       Map<String, u> map = a();
/* 140 */       stringBuilder.append("Colorants{");
/* 141 */       for (Map.Entry<String, u> entry : map.entrySet()) {
/*     */         
/* 143 */         stringBuilder.append('"');
/* 144 */         stringBuilder.append((String)entry.getKey());
/* 145 */         stringBuilder.append("\": ");
/* 146 */         stringBuilder.append(entry.getValue());
/* 147 */         stringBuilder.append(' ');
/*     */       } 
/* 149 */       stringBuilder.append('}');
/*     */     }
/* 151 */     catch (IOException iOException) {
/*     */       
/* 153 */       stringBuilder.append("ERROR");
/*     */     } 
/* 155 */     stringBuilder.append('}');
/* 156 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */