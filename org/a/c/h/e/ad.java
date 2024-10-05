/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.a.a.a.c;
/*     */ import org.a.b.b;
/*     */ import org.a.b.b.l;
/*     */ import org.a.b.b.o;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.a.i;
/*     */ import org.a.c.h.e.a.c;
/*     */ import org.a.c.h.e.a.h;
/*     */ import org.a.c.h.e.a.j;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ad
/*     */   extends aa
/*     */ {
/*  56 */   private static final org.a.a.a.a e = c.a(ad.class);
/*     */ 
/*     */   
/*     */   private d f;
/*     */ 
/*     */   
/*     */   private final AffineTransform g;
/*     */ 
/*     */   
/*     */   private final o h;
/*     */ 
/*     */   
/*     */   private final b i;
/*     */ 
/*     */   
/*     */   private final boolean j;
/*     */   
/*     */   private org.a.b.h.a k;
/*     */ 
/*     */   
/*     */   public ad(d paramd) {
/*  77 */     super(paramd);
/*     */     
/*  79 */     v v = b();
/*  80 */     byte[] arrayOfByte = null;
/*  81 */     if (v != null) {
/*     */       i i;
/*     */       
/*  84 */       if ((i = v.q()) != null)
/*     */       {
/*     */         
/*  87 */         if ((arrayOfByte = am.a((InputStream)i.c())).length == 0) {
/*     */           
/*  89 */           (new StringBuilder("Invalid data for embedded Type1C font ")).append(d());
/*  90 */           arrayOfByte = null;
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  96 */     o o1 = null;
/*     */     
/*     */     try {
/*  99 */       if (arrayOfByte != null) {
/*     */         l l;
/*     */ 
/*     */         
/* 103 */         o1 = (l = new l()).a(arrayOfByte, new a((byte)0)).get(0);
/*     */       }
/*     */     
/* 106 */     } catch (IOException iOException) {
/*     */       
/* 108 */       (new StringBuilder("Can't read the embedded Type1C font ")).append(d());
/*     */     } 
/*     */ 
/*     */     
/* 112 */     this.h = o1;
/*     */     
/* 114 */     if (this.h != null) {
/*     */       
/* 116 */       this.i = (b)this.h;
/* 117 */       this.j = true;
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 122 */       m<b> m = l.a().b(s(), v);
/* 123 */       this.i = m.c();
/*     */       
/* 125 */       if (m.d())
/*     */       {
/* 127 */         (new StringBuilder("Using fallback font ")).append(this.i.b()).append(" for ").append(s());
/*     */       }
/* 129 */       this.j = false;
/*     */     } 
/* 131 */     l();
/* 132 */     this.g = h().a();
/* 133 */     this.g.scale(1000.0D, 1000.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class a
/*     */     implements l.a
/*     */   {
/*     */     private a(ad this$0) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String s() {
/* 157 */     return this.b.g(j.v);
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
/*     */   public final String d() {
/* 183 */     return s();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final org.a.b.h.a e() {
/* 189 */     if (this.k == null)
/*     */     {
/* 191 */       this.k = t();
/*     */     }
/* 193 */     return this.k;
/*     */   }
/*     */   
/*     */   private org.a.b.h.a t() {
/*     */     h h;
/* 198 */     if (b() != null && (
/*     */       
/* 200 */       h = b().j()) != null && (h
/* 201 */       .c() != 0.0F || h.d() != 0.0F || h
/* 202 */       .e() != 0.0F || h.g() != 0.0F))
/*     */     {
/* 204 */       return new org.a.b.h.a(h.c(), h.d(), h
/* 205 */           .e(), h.g());
/*     */     }
/*     */     
/* 208 */     return this.i.c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String g(int paramInt) {
/* 214 */     return n().a(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final c m() {
/* 220 */     if (!c() && a() != null)
/*     */     {
/*     */       
/* 223 */       return (c)new j(a());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 228 */     if (this.i instanceof org.a.b.a)
/*     */     {
/* 230 */       return (c)j.a(((org.a.b.a)this.i).a());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 235 */     return (c)h.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(InputStream paramInputStream) {
/* 243 */     return paramInputStream.read();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final d h() {
/* 249 */     if (this.f == null) {
/*     */       
/* 251 */       List<Number> list = null;
/*     */       
/*     */       try {
/* 254 */         list = this.i.d();
/*     */       }
/* 256 */       catch (IOException iOException) {
/*     */         
/* 258 */         this.f = a;
/*     */       } 
/*     */       
/* 261 */       if (list != null && list.size() == 6) {
/*     */         
/* 263 */         this
/*     */ 
/*     */           
/* 266 */           .f = new d(((Number)list.get(0)).floatValue(), ((Number)list.get(1)).floatValue(), ((Number)list.get(2)).floatValue(), ((Number)list.get(3)).floatValue(), ((Number)list.get(4)).floatValue(), ((Number)list.get(5)).floatValue());
/*     */       }
/*     */       else {
/*     */         
/* 270 */         return super.h();
/*     */       } 
/*     */     } 
/* 273 */     return this.f;
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
/*     */   public final float c(int paramInt) {
/* 285 */     String str = g(paramInt);
/* 286 */     str = c(str);
/* 287 */     float f = this.i.a(str);
/*     */     
/* 289 */     Point2D.Float float_ = new Point2D.Float(f, 0.0F);
/* 290 */     this.g.transform(float_, float_);
/* 291 */     return (float)float_.getX();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 297 */     return this.j;
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
/*     */   protected final byte[] d(int paramInt) {
/* 316 */     String str1 = o().a(paramInt);
/* 317 */     if (!this.c.a(str1))
/*     */     {
/* 319 */       throw new IllegalArgumentException(
/* 320 */           String.format("U+%04X ('%s') is not available in this font's encoding: %s", new Object[] {
/* 321 */               Integer.valueOf(paramInt), str1, this.c.a()
/*     */             }));
/*     */     }
/* 324 */     String str2 = c(str1);
/*     */     
/* 326 */     Map map = this.c.e();
/*     */     
/* 328 */     if (str2.equals(".notdef") || !this.i.b(str2))
/*     */     {
/* 330 */       throw new IllegalArgumentException(
/* 331 */           String.format("No glyph for U+%04X in font %s", new Object[] { Integer.valueOf(paramInt), d() }));
/*     */     }
/*     */     
/* 334 */     paramInt = ((Integer)map.get(str1)).intValue();
/* 335 */     return new byte[] { (byte)paramInt };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float b(String paramString) {
/* 341 */     float f = 0.0F;
/* 342 */     for (byte b1 = 0; b1 < paramString.length(); b1++) {
/*     */       
/* 344 */       int i = paramString.codePointAt(b1);
/* 345 */       String str = o().a(i);
/* 346 */       f += this.h.c(str).a();
/*     */     } 
/* 348 */     return f;
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
/*     */   private String c(String paramString) {
/* 384 */     if (c() || this.i.b(paramString))
/*     */     {
/* 386 */       return paramString;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 392 */     if ((paramString = o().a(paramString)) != null && paramString.length() == 1) {
/*     */       
/* 394 */       paramString = l.a(paramString.codePointAt(0));
/* 395 */       if (this.i.b(paramString))
/*     */       {
/* 397 */         return paramString;
/*     */       }
/*     */     } 
/*     */     
/* 401 */     return ".notdef";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */