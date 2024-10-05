/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
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
/*     */ public final class ao
/*     */   implements Closeable
/*     */ {
/*     */   private final ak a;
/*     */   private final int b;
/*     */   private final long[] c;
/*     */   
/*     */   public ao(File paramFile) {
/*  45 */     this(new ah(paramFile, "r"));
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
/*     */   private ao(ak paramak) {
/*  67 */     this.a = paramak;
/*     */     
/*     */     String str;
/*     */     
/*  71 */     if (!(str = paramak.m()).equals("ttcf"))
/*     */     {
/*  73 */       throw new IOException("Missing TTC header");
/*     */     }
/*  75 */     float f = paramak.h();
/*  76 */     this.b = (int)paramak.k();
/*  77 */     this.c = new long[this.b];
/*  78 */     for (byte b = 0; b < this.b; b++)
/*     */     {
/*  80 */       this.c[b] = paramak.k();
/*     */     }
/*  82 */     if (f >= 2.0F) {
/*     */ 
/*     */       
/*  85 */       paramak.c();
/*  86 */       paramak.c();
/*  87 */       paramak.c();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(a parama) {
/*  99 */     for (byte b = 0; b < this.b; b++) {
/*     */       
/* 101 */       ap ap = a(b);
/* 102 */       parama.a(ap);
/*     */     } 
/*     */   }
/*     */   
/*     */   private ap a(int paramInt) {
/*     */     al al;
/* 108 */     this.a.a(this.c[paramInt]);
/*     */     
/* 110 */     if (this.a.m().equals("OTTO")) {
/*     */       
/* 112 */       al = new ab(false, true);
/*     */     }
/*     */     else {
/*     */       
/* 116 */       al = new al(false, true);
/*     */     } 
/* 118 */     this.a.a(this.c[paramInt]);
/* 119 */     return al.b(new aj(this.a));
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
/*     */   public final ap a(String paramString) {
/* 131 */     for (byte b = 0; b < this.b; b++) {
/*     */       ap ap;
/*     */       
/* 134 */       if ((ap = a(b)).b().equals(paramString))
/*     */       {
/* 136 */         return ap;
/*     */       }
/*     */     } 
/* 139 */     return null;
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
/*     */   public final void close() {
/* 153 */     this.a.close();
/*     */   }
/*     */   
/*     */   public static interface a {
/*     */     void a(ap param1ap);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */