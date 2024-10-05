/*     */ package org.a.c.b;
/*     */ 
/*     */ import java.io.OutputStream;
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
/*     */ public final class c
/*     */   extends b
/*     */ {
/*  32 */   private static byte[] c = new byte[] { 116, 114, 117, 101 };
/*     */ 
/*     */ 
/*     */   
/*  36 */   private static byte[] d = new byte[] { 102, 97, 108, 115, 101 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   public static final c a = new c(true);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   public static final c b = new c(false);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean e;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private c(boolean paramBoolean) {
/*  57 */     this.e = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a() {
/*  67 */     return this.e;
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
/*     */   public static c b(boolean paramBoolean) {
/*  89 */     return paramBoolean ? a : b;
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
/*     */   public final Object a(u paramu) {
/* 114 */     return paramu.a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 125 */     return String.valueOf(this.e);
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
/*     */   public final void a(OutputStream paramOutputStream) {
/* 137 */     if (this.e) {
/*     */       
/* 139 */       paramOutputStream.write(c);
/*     */       
/*     */       return;
/*     */     } 
/* 143 */     paramOutputStream.write(d);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */