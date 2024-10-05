/*     */ package org.a.c.b;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.c.j;
/*     */ import org.a.c.c.l;
/*     */ import org.a.c.c.m;
/*     */ import org.a.c.d.c;
/*     */ import org.a.c.d.d;
/*     */ import org.a.c.d.e;
/*     */ import org.a.c.d.f;
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
/*     */ public class p
/*     */   extends d
/*     */   implements Closeable
/*     */ {
/*     */   private e b;
/*     */   private final g c;
/*     */   private boolean d;
/*  49 */   private static final a e = c.a(p.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public p() {
/*  61 */     this(g.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public p(g paramg) {
/*  71 */     a(j.bX, 0);
/*  72 */     this.c = (paramg != null) ? paramg : g.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void q() {
/*  81 */     if (this.b != null && this.b.d())
/*     */     {
/*  83 */       throw new IOException("COSStream has been closed and cannot be read. Perhaps its enclosing PDDocument has been closed?");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(boolean paramBoolean) {
/* 114 */     if (this.b == null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 121 */       this.b = this.c.d();
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
/*     */   public final InputStream j() {
/* 133 */     q();
/* 134 */     if (this.d)
/*     */     {
/* 136 */       throw new IllegalStateException("Cannot read while there is an open stream writer");
/*     */     }
/* 138 */     b(true);
/* 139 */     return (InputStream)new c(this.b);
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
/*     */   public final g k() {
/* 163 */     return a(j.a);
/*     */   }
/*     */ 
/*     */   
/*     */   private g a(j paramj) {
/* 168 */     q();
/* 169 */     if (this.d)
/*     */     {
/* 171 */       throw new IllegalStateException("Cannot read while there is an open stream writer");
/*     */     }
/* 173 */     b(true);
/* 174 */     c c = new c(this.b);
/* 175 */     return g.a(r(), this, (InputStream)c, this.c, paramj);
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
/*     */   public final OutputStream l() {
/* 199 */     return a((b)null);
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
/*     */   public final OutputStream a(b paramb) {
/* 211 */     q();
/* 212 */     if (this.d)
/*     */     {
/* 214 */       throw new IllegalStateException("Cannot have more than one open stream writer.");
/*     */     }
/*     */     
/* 217 */     if (paramb != null)
/*     */     {
/* 219 */       a(j.aY, paramb);
/*     */     }
/* 221 */     am.a((Closeable)this.b);
/* 222 */     this.b = this.c.d();
/* 223 */     d d1 = new d((f)this.b);
/* 224 */     o o = new o(r(), this, (OutputStream)d1, this.c);
/* 225 */     this.d = true;
/* 226 */     return new q(this, o);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final OutputStream m() {
/* 267 */     q();
/* 268 */     if (this.d)
/*     */     {
/* 270 */       throw new IllegalStateException("Cannot have more than one open stream writer.");
/*     */     }
/* 272 */     am.a((Closeable)this.b);
/* 273 */     this.b = this.c.d();
/* 274 */     d d1 = new d((f)this.b);
/* 275 */     this.d = true;
/* 276 */     return new r(this, (OutputStream)d1);
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
/*     */   private List<l> r() {
/* 299 */     ArrayList<l> arrayList = new ArrayList();
/*     */     b b;
/* 301 */     if (b = o() instanceof j) {
/*     */       
/* 303 */       arrayList.add(m.a.a((j)b));
/*     */     }
/* 305 */     else if (b instanceof a) {
/*     */       
/* 307 */       b = b;
/* 308 */       for (byte b1 = 0; b1 < b.b(); b1++) {
/*     */         
/* 310 */         j j = (j)b.b(b1);
/* 311 */         arrayList.add(m.a.a(j));
/*     */       } 
/*     */     } 
/* 314 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long n() {
/* 324 */     if (this.d)
/*     */     {
/* 326 */       throw new IllegalStateException("There is an open OutputStream associated with this COSStream. It must be closed before queryinglength of this COSStream.");
/*     */     }
/*     */ 
/*     */     
/* 330 */     return b(j.bX, 0);
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
/*     */   public final b o() {
/* 344 */     return a(j.aY);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String p() {
/* 380 */     null = new ByteArrayOutputStream();
/* 381 */     g g1 = null;
/*     */ 
/*     */     
/*     */     try {
/* 385 */       am.a(g1 = k(), null);
/*     */     }
/* 387 */     catch (IOException iOException) {
/*     */       
/* 389 */       return "";
/*     */     }
/*     */     finally {
/*     */       
/* 393 */       am.a(g1);
/*     */     } 
/*     */     s s;
/* 396 */     return (s = new s(SYNTHETIC_LOCAL_VARIABLE_1.toByteArray())).b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(u paramu) {
/* 402 */     return paramu.a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 409 */     if (this.b != null)
/*     */     {
/* 411 */       this.b.close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */