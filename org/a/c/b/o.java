/*     */ package org.a.c.b;
/*     */ 
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.List;
/*     */ import org.a.c.c.l;
/*     */ import org.a.c.d.c;
/*     */ import org.a.c.d.e;
/*     */ import org.a.c.d.g;
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
/*     */ public final class o
/*     */   extends FilterOutputStream
/*     */ {
/*     */   private final List<l> a;
/*     */   private final d b;
/*     */   private final g c;
/*     */   private e d;
/*     */   
/*     */   o(List<l> paramList, d paramd, OutputStream paramOutputStream, g paramg) {
/*  56 */     super(paramOutputStream);
/*  57 */     this.a = paramList;
/*  58 */     this.b = paramd;
/*  59 */     this.c = paramg;
/*     */     
/*  61 */     if (paramList.isEmpty()) {
/*     */       
/*  63 */       this.d = null;
/*     */       
/*     */       return;
/*     */     } 
/*  67 */     this.d = paramg.d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(byte[] paramArrayOfbyte) {
/*  74 */     if (this.d != null) {
/*     */       
/*  76 */       this.d.a(paramArrayOfbyte);
/*     */       
/*     */       return;
/*     */     } 
/*  80 */     super.write(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  87 */     if (this.d != null) {
/*     */       
/*  89 */       this.d.b(paramArrayOfbyte, paramInt1, paramInt2);
/*     */       
/*     */       return;
/*     */     } 
/*  93 */     super.write(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(int paramInt) {
/* 100 */     if (this.d != null) {
/*     */       
/* 102 */       this.d.a(paramInt);
/*     */       
/*     */       return;
/*     */     } 
/* 106 */     super.write(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void flush() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void close() {
/*     */     try {
/* 119 */       if (this.d != null) {
/*     */         
/*     */         try {
/*     */ 
/*     */           
/* 124 */           for (int i = this.a.size() - 1; i >= 0; i--)
/*     */           {
/* 126 */             c c = new c(this.d);
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
/*     */           }
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
/*     */         }
/*     */         finally {
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
/* 170 */           this.d.close();
/* 171 */           this.d = null;
/*     */         } 
/*     */       }
/*     */       
/*     */       return;
/*     */     } finally {
/* 177 */       super.close();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */