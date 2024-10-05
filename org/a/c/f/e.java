/*     */ package org.a.c.f;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.m;
/*     */ import org.a.c.b.p;
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
/*     */ public class e
/*     */   extends a
/*     */ {
/*  41 */   private static final a c = c.a(e.class);
/*     */   
/*  43 */   private List<m> d = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final p e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e(p paramp, org.a.c.b.e parame) {
/*  55 */     super(new d((InputStream)paramp.k()));
/*  56 */     this.e = paramp;
/*  57 */     this.b = parame;
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
/*     */   public final void p() {
/*     */     try {
/*     */       int i;
/*  72 */       if ((i = this.e.a("N")) == -1)
/*     */       {
/*  74 */         throw new IOException("/N entry missing in object stream");
/*     */       }
/*  76 */       ArrayList<Long> arrayList = new ArrayList(i);
/*  77 */       this.d = new ArrayList<m>(i);
/*  78 */       for (byte b1 = 0; b1 < i; b1++) {
/*     */         
/*  80 */         long l = m();
/*     */         
/*  82 */         o();
/*  83 */         arrayList.add(Long.valueOf(l));
/*     */       } 
/*     */ 
/*     */       
/*  87 */       byte b2 = 0; b b;
/*  88 */       while ((b = f()) != null) {
/*     */         m m;
/*     */         
/*  91 */         (m = new m(b)).a(0);
/*  92 */         if (b2 >= arrayList.size()) {
/*     */           
/*  94 */           (new StringBuilder("/ObjStm (object stream) has more objects than /N ")).append(i);
/*     */           break;
/*     */         } 
/*  97 */         m.a(((Long)arrayList.get(b2)).longValue());
/*  98 */         this.d.add(m);
/*  99 */         if (c.a())
/*     */         {
/* 101 */           (new StringBuilder("parsed=")).append(m);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 106 */         if (!this.a.d() && this.a.c() == 101)
/*     */         {
/* 108 */           h();
/*     */         }
/* 110 */         b2++;
/*     */       } 
/*     */       
/*     */       return;
/*     */     } finally {
/* 115 */       this.a.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<m> q() {
/* 126 */     return this.d;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */