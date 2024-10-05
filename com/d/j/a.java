/*     */ package com.d.j;
/*     */ 
/*     */ import com.d.m.l;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import org.xml.sax.InputSource;
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
/*     */ public abstract class a
/*     */ {
/*     */   private final a a;
/*     */   private InputSource b;
/*     */   private InputStream c;
/*     */   private Reader d;
/*     */   private long e;
/*     */   
/*     */   enum a
/*     */   {
/*  36 */     a, b, c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a(a parama) {
/*  47 */     System.currentTimeMillis();
/*  48 */     this.a = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(InputSource paramInputSource) {
/*  55 */     this(a.c);
/*  56 */     this.b = paramInputSource;
/*     */   }
/*     */   
/*     */   public a(Reader paramReader) {
/*  60 */     this(a.a);
/*  61 */     this.d = paramReader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final InputSource a() {
/*  70 */     if (this.a == a.b && this.b == null)
/*     */     {
/*  72 */       this.b = new InputSource(new BufferedInputStream(this.c));
/*     */     }
/*  74 */     return this.b;
/*     */   }
/*     */   
/*     */   public final Reader b() {
/*  78 */     if (this.a == a.b && this.d == null) {
/*     */       
/*     */       try {
/*  81 */         this.d = new InputStreamReader(this.c, "UTF-8");
/*  82 */       } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  83 */         l.a("Could not create reader for stream", unsupportedEncodingException);
/*     */       } 
/*     */     }
/*  86 */     return this.d;
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
/*     */   public final long c() {
/*  99 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   final void a(long paramLong) {
/* 104 */     this.e = paramLong;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\j\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */