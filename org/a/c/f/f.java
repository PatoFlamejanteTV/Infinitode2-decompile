/*     */ package org.a.c.f;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.e;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.d.e;
/*     */ import org.a.c.d.g;
/*     */ import org.a.c.h.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */   extends b
/*     */ {
/*  38 */   private static final a f = c.a(f.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f(e parame, String paramString1, InputStream paramInputStream, String paramString2, g paramg) {
/* 125 */     super(parame, paramString1, paramInputStream, paramString2);
/* 126 */     this.d = parame.c();
/* 127 */     a(paramg);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(g paramg) {
/*     */     String str;
/* 133 */     if ((str = System.getProperty("org.apache.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange")) != null) {
/*     */       
/*     */       try {
/*     */         
/* 137 */         e(Integer.parseInt(str));
/*     */       }
/* 139 */       catch (NumberFormatException numberFormatException) {
/*     */         
/* 141 */         (new StringBuilder("System property org.apache.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange does not contain an integer value, but: '")).append(str).append("'");
/*     */       } 
/*     */     }
/*     */     
/* 145 */     this.b = new e(paramg);
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
/*     */   public final b w() {
/*     */     b b1;
/* 159 */     (b1 = new b(t(), this.c, v())).a(u());
/* 160 */     return b1;
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
/*     */   private void y() {
/* 173 */     d d1 = p();
/*     */     
/*     */     b b2;
/* 176 */     if (!(b2 = b(d1) instanceof d))
/*     */     {
/* 178 */       throw new IOException("Expected root dictionary, but got this: " + b2);
/*     */     }
/* 180 */     d d2 = (d)b2;
/*     */     
/* 182 */     if (q() && !d2.o(j.dN))
/*     */     {
/* 184 */       d2.a(j.dN, (b)j.N);
/*     */     }
/*     */     
/* 187 */     a(d2, (j[])null);
/*     */     
/*     */     b b1;
/* 190 */     if (b1 = d1.a(j.bI) instanceof d)
/*     */     {
/* 192 */       a((d)b1, (j[])null);
/*     */     }
/*     */     
/* 195 */     a(d2);
/* 196 */     if (!(d2.a(j.cL) instanceof d))
/*     */     {
/* 198 */       throw new IOException("Page tree root must be a dictionary");
/*     */     }
/*     */     
/* 201 */     this.e = true;
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
/*     */   public final void x() {
/*     */     try {
/* 219 */       if (!r() && !s())
/*     */       {
/* 221 */         throw new IOException("Error: Header doesn't contain versioninfo");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } finally {
/* 232 */       if (this.b != null) {
/*     */         
/* 234 */         am.a((Closeable)this.b);
/* 235 */         this.b = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\f\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */