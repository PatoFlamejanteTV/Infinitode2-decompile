/*     */ package com.a.a.c.d;
/*     */ 
/*     */ import com.a.a.b.j;
/*     */ import com.a.a.b.l;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class g
/*     */   extends f
/*     */ {
/*     */   private Collection<Object> b;
/*     */   private transient String c;
/*     */   
/*     */   protected g(l paraml, String paramString1, j paramj, Class<?> paramClass, String paramString2, Collection<Object> paramCollection) {
/*  52 */     super(paraml, paramString1, paramj);
/*     */ 
/*     */     
/*  55 */     this.b = paramCollection;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String e() {
/*     */     String str;
/*  85 */     if ((str = this.c) == null && this.b != null) {
/*  86 */       StringBuilder stringBuilder = new StringBuilder(100);
/*     */       int i;
/*  88 */       if ((i = this.b.size()) == 1) {
/*  89 */         stringBuilder.append(" (one known property: \"");
/*  90 */         stringBuilder.append(String.valueOf(this.b.iterator().next()));
/*  91 */         stringBuilder.append('"');
/*     */       } else {
/*  93 */         stringBuilder.append(" (").append(i).append(" known properties: ");
/*  94 */         Iterator iterator = this.b.iterator();
/*  95 */         while (iterator.hasNext()) {
/*  96 */           stringBuilder.append('"');
/*  97 */           stringBuilder.append(String.valueOf(iterator.next()));
/*  98 */           stringBuilder.append('"');
/*     */           
/* 100 */           if (stringBuilder.length() > 1000) {
/* 101 */             stringBuilder.append(" [truncated]");
/*     */             break;
/*     */           } 
/* 104 */           if (iterator.hasNext()) {
/* 105 */             stringBuilder.append(", ");
/*     */           }
/*     */         } 
/*     */       } 
/* 109 */       stringBuilder.append("])");
/* 110 */       this.c = str = stringBuilder.toString();
/*     */     } 
/* 112 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\d\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */