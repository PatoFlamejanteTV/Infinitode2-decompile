/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.b.c.a;
/*     */ import org.a.b.h.a;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.g;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.h.a.a;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.e.a.d;
/*     */ import org.a.c.i.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class u
/*     */   implements c
/*     */ {
/*  53 */   private static final a c = c.a(u.class);
/*  54 */   protected static final d a = new d(0.001F, 0.0F, 0.0F, 0.001F, 0.0F, 0.0F);
/*     */ 
/*     */   
/*     */   protected final d b;
/*     */ 
/*     */   
/*     */   private final a d;
/*     */ 
/*     */   
/*     */   private final l e;
/*     */ 
/*     */   
/*     */   private v f;
/*     */ 
/*     */   
/*     */   private List<Float> g;
/*     */   
/*     */   private final Map<Integer, Float> h;
/*     */ 
/*     */   
/*     */   u() {
/*  75 */     this.b = new d();
/*  76 */     this.b.a(j.dN, (b)j.be);
/*  77 */     this.d = null;
/*  78 */     this.f = null;
/*  79 */     this.e = null;
/*  80 */     this.h = new HashMap<Integer, Float>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   u(String paramString) {
/*  88 */     this.b = new d();
/*  89 */     this.b.a(j.dN, (b)j.be);
/*  90 */     this.d = null;
/*  91 */     this.e = ah.a(paramString);
/*  92 */     if (this.e == null)
/*     */     {
/*  94 */       throw new IllegalArgumentException("No AFM for font " + paramString);
/*     */     }
/*  96 */     this.f = l.a(this.e);
/*     */     
/*  98 */     this.h = new ConcurrentHashMap<Integer, Float>();
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
/*     */   protected u(d paramd) {
/* 110 */     this.b = paramd;
/* 111 */     this.h = new HashMap<Integer, Float>();
/*     */ 
/*     */     
/* 114 */     this.e = ah.a(d());
/* 115 */     this.f = l();
/* 116 */     this.d = m();
/*     */   }
/*     */ 
/*     */   
/*     */   private v l() {
/*     */     d d1;
/* 122 */     if ((d1 = (d)this.b.a(j.bg)) != null)
/*     */     {
/* 124 */       return new v(d1);
/*     */     }
/* 126 */     if (this.e != null)
/*     */     {
/*     */       
/* 129 */       return l.a(this.e);
/*     */     }
/*     */ 
/*     */     
/* 133 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private a m() {
/*     */     b b;
/* 140 */     if ((b = this.b.a(j.dJ)) == null)
/*     */     {
/* 142 */       return null;
/*     */     }
/*     */     
/* 145 */     a a1 = null;
/*     */ 
/*     */     
/*     */     try {
/* 149 */       if ((a1 = a(b)) != null && !a1.b())
/*     */       {
/* 151 */         (new StringBuilder("Invalid ToUnicode CMap in font ")).append(d());
/* 152 */         String str1 = (a1.c() != null) ? a1.c() : "";
/* 153 */         String str2 = (a1.e() != null) ? a1.e() : "";
/* 154 */         b b1 = this.b.a(j.aR);
/* 155 */         if (str1.contains("Identity") || str2
/* 156 */           .contains("Identity") || j.bC
/* 157 */           .equals(b1) || j.bD
/* 158 */           .equals(b1))
/*     */         {
/*     */           
/* 161 */           a1 = c.a(j.bC.a());
/*     */         }
/*     */       }
/*     */     
/* 165 */     } catch (IOException iOException) {
/*     */       
/* 167 */       (new StringBuilder("Could not read ToUnicode CMap in font ")).append(d());
/*     */     } 
/* 169 */     return a1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final l a() {
/* 177 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public v b() {
/* 183 */     return this.f;
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
/*     */   protected static a a(b paramb) {
/* 201 */     if (paramb instanceof j) {
/*     */       String str;
/*     */ 
/*     */       
/* 205 */       return c.a(str = ((j)paramb).a());
/*     */     } 
/* 207 */     if (paramb instanceof p) {
/*     */ 
/*     */       
/* 210 */       g g = null;
/*     */ 
/*     */       
/*     */       try {
/* 214 */         return c.a((InputStream)(g = ((p)paramb).k()));
/*     */       }
/*     */       finally {
/*     */         
/* 218 */         am.a((Closeable)g);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 223 */     throw new IOException("Expected Name or Stream");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d n() {
/* 230 */     return this.b;
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
/*     */   public float a(int paramInt) {
/*     */     Float float_;
/* 255 */     if ((float_ = this.h.get(Integer.valueOf(paramInt))) != null)
/*     */     {
/* 257 */       return float_.floatValue();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 267 */     if (this.b.a(j.eb) != null || this.b.o(j.ck)) {
/*     */       
/* 269 */       int i = this.b.b(j.ba, -1);
/* 270 */       int j = this.b.b(j.bW, -1);
/* 271 */       int k = g().size();
/* 272 */       int m = paramInt - i;
/* 273 */       if (k > 0 && paramInt >= i && paramInt <= j && m < k) {
/*     */         Float float_1;
/*     */         
/* 276 */         if ((float_1 = g().get(m)) == null)
/*     */         {
/* 278 */           float_1 = Float.valueOf(0.0F);
/*     */         }
/* 280 */         this.h.put(Integer.valueOf(paramInt), float_1);
/* 281 */         return float_1.floatValue();
/*     */       } 
/*     */       
/*     */       v v1;
/* 285 */       if ((v1 = b()) != null) {
/*     */ 
/*     */         
/* 288 */         Float float_1 = Float.valueOf(v1.n());
/* 289 */         this.h.put(Integer.valueOf(paramInt), float_1);
/* 290 */         return float_1.floatValue();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 295 */     if (i()) {
/*     */       
/* 297 */       float_ = Float.valueOf(b(paramInt));
/* 298 */       this.h.put(Integer.valueOf(paramInt), float_);
/* 299 */       return float_.floatValue();
/*     */     } 
/*     */ 
/*     */     
/* 303 */     float_ = Float.valueOf(c(paramInt));
/* 304 */     this.h.put(Integer.valueOf(paramInt), float_);
/* 305 */     return float_.floatValue();
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
/*     */   public final byte[] a(String paramString) {
/* 335 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 336 */     int i = 0;
/* 337 */     while (i < paramString.length()) {
/*     */       
/* 339 */       int j = paramString.codePointAt(i);
/*     */ 
/*     */       
/* 342 */       byte[] arrayOfByte = d(j);
/* 343 */       byteArrayOutputStream.write(arrayOfByte);
/*     */       
/* 345 */       i += Character.charCount(j);
/*     */     } 
/* 347 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public float b(String paramString) {
/* 373 */     byte[] arrayOfByte = a(paramString);
/* 374 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
/*     */     
/* 376 */     float f = 0.0F;
/* 377 */     while (byteArrayInputStream.available() > 0) {
/*     */       
/* 379 */       int i = a(byteArrayInputStream);
/* 380 */       f += a(i);
/*     */     } 
/*     */     
/* 383 */     return f;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String a(int paramInt, d paramd) {
/* 449 */     return e(paramInt);
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
/*     */   public String e(int paramInt) {
/* 461 */     if (this.d != null) {
/*     */       
/* 463 */       if (this.d.c() != null && this.d
/* 464 */         .c().startsWith("Identity-") && (this.b
/* 465 */         .a(j.dJ) instanceof j || 
/* 466 */         !this.d.b()))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 473 */         return new String(new char[] { (char)paramInt });
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 478 */       return this.d.a(paramInt);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 484 */     return null;
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
/*     */   protected final List<Float> g() {
/* 518 */     if (this.g == null) {
/*     */       a a1;
/*     */       
/* 521 */       if ((a1 = (a)this.b.a(j.eb)) != null) {
/*     */         
/* 523 */         this.g = a.b(a1);
/*     */       }
/*     */       else {
/*     */         
/* 527 */         this.g = Collections.emptyList();
/*     */       } 
/*     */     } 
/* 530 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public d h() {
/* 536 */     return a;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean i() {
/* 597 */     if (c())
/*     */     {
/* 599 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 603 */     return ah.b(d());
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
/*     */   public boolean equals(Object paramObject) {
/* 631 */     return (paramObject instanceof u && ((u)paramObject).n() == n());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 637 */     return n().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 643 */     return getClass().getSimpleName() + " " + d();
/*     */   }
/*     */   
/*     */   protected abstract float b(int paramInt);
/*     */   
/*     */   public abstract float c(int paramInt);
/*     */   
/*     */   public abstract boolean c();
/*     */   
/*     */   protected abstract byte[] d(int paramInt);
/*     */   
/*     */   public abstract int a(InputStream paramInputStream);
/*     */   
/*     */   public abstract String d();
/*     */   
/*     */   public abstract a e();
/*     */   
/*     */   public abstract void f(int paramInt);
/*     */   
/*     */   public abstract void j();
/*     */   
/*     */   public abstract boolean k();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */