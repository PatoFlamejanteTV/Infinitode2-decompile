/*     */ package org.a.c.h.a.b.a;
/*     */ 
/*     */ import java.util.Stack;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public final class e
/*     */   extends h.a
/*     */ {
/*  30 */   private final d a = new d();
/*  31 */   private final Stack<d> b = new Stack<d>();
/*     */ 
/*     */   
/*     */   private e() {
/*  35 */     this.b.push(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d a() {
/*  44 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static d a(CharSequence paramCharSequence) {
/*  55 */     e e1 = new e();
/*  56 */     h.a(paramCharSequence, e1);
/*  57 */     return e1.a();
/*     */   }
/*     */ 
/*     */   
/*     */   private d b() {
/*  62 */     return this.b.peek();
/*     */   }
/*     */   
/*  65 */   private static final Pattern c = Pattern.compile("[\\+\\-]?\\d+");
/*  66 */   private static final Pattern d = Pattern.compile("[\\-]?\\d*\\.\\d*([Ee]\\-?\\d+)?");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(CharSequence paramCharSequence) {
/*  72 */     paramCharSequence = paramCharSequence.toString();
/*  73 */     a((String)paramCharSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(String paramString) {
/*  78 */     if ("{".equals(paramString)) {
/*     */       
/*  80 */       d d1 = new d();
/*  81 */       b().a(d1);
/*  82 */       this.b.push(d1); return;
/*     */     } 
/*  84 */     if ("}".equals(paramString)) {
/*     */       
/*  86 */       this.b.pop();
/*     */       
/*     */       return;
/*     */     } 
/*     */     Matcher matcher;
/*  91 */     if ((matcher = c.matcher(paramString)).matches()) {
/*     */       
/*  93 */       b().a(b(paramString));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  98 */     if ((matcher = d.matcher(paramString)).matches()) {
/*     */       
/* 100 */       b().a(c(paramString));
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 106 */     b().a(paramString);
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
/*     */   private static int b(String paramString) {
/* 118 */     return Integer.parseInt(paramString.startsWith("+") ? paramString.substring(1) : paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static float c(String paramString) {
/* 128 */     return Float.parseFloat(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */