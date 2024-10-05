/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.List;
/*     */ import org.a.a.a.c;
/*     */ import org.a.b.b;
/*     */ import org.a.b.b.i;
/*     */ import org.a.b.b.l;
/*     */ import org.a.b.b.o;
/*     */ import org.a.b.b.w;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.a.i;
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
/*     */ public class p
/*     */   extends o
/*     */ {
/*  52 */   private static final org.a.a.a.a b = c.a(p.class);
/*     */ 
/*     */   
/*     */   private final org.a.b.b.a c;
/*     */ 
/*     */   
/*     */   private final b d;
/*     */ 
/*     */   
/*     */   private final boolean e;
/*     */ 
/*     */   
/*     */   private d f;
/*     */ 
/*     */   
/*     */   private final AffineTransform g;
/*     */ 
/*     */   
/*     */   private org.a.b.h.a h;
/*     */ 
/*     */ 
/*     */   
/*     */   public p(d paramd, ac paramac) {
/*  75 */     super(paramd, paramac);
/*     */     byte[] arrayOfByte;
/*  77 */     v v = c();
/*  78 */     paramac = null;
/*  79 */     if (v != null) {
/*     */       i i1;
/*     */       
/*  82 */       if ((i1 = v.q()) != null)
/*     */       {
/*  84 */         arrayOfByte = am.a((InputStream)i1.c());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  89 */     i i = null;
/*  90 */     if (arrayOfByte != null && arrayOfByte.length > 0 && (arrayOfByte[0] & 0xFF) == 37) {
/*     */ 
/*     */       
/*  93 */       (new StringBuilder("Found PFB but expected embedded CFF font ")).append(v.g());
/*     */     
/*     */     }
/*  96 */     else if (arrayOfByte != null) {
/*     */       
/*  98 */       l l = new l();
/*     */       
/*     */       try {
/* 101 */         i = l.a(arrayOfByte, new a((byte)0)).get(0);
/*     */       }
/* 103 */       catch (IOException iOException) {
/*     */         
/* 105 */         (new StringBuilder("Can't read the embedded CFF font ")).append(v.g());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 110 */     if (i != null) {
/*     */ 
/*     */       
/* 113 */       if (i instanceof org.a.b.b.a) {
/*     */         
/* 115 */         this.c = (org.a.b.b.a)i;
/* 116 */         this.d = null;
/*     */       }
/*     */       else {
/*     */         
/* 120 */         this.c = null;
/* 121 */         this.d = (b)i;
/*     */       } 
/* 123 */       i();
/* 124 */       this.e = true;
/*     */     } else {
/*     */       b b1;
/*     */ 
/*     */ 
/*     */       
/*     */       a a1;
/*     */ 
/*     */ 
/*     */       
/* 134 */       if ((a1 = l.a().a(a(), c(), h())).b()) {
/*     */ 
/*     */         
/* 137 */         if (i = a1.c().a().a() instanceof org.a.b.b.a)
/*     */         {
/* 139 */           this.c = (org.a.b.b.a)i;
/* 140 */           this.d = null;
/* 141 */           org.a.b.b.a a2 = this.c;
/*     */         
/*     */         }
/*     */         else
/*     */         {
/* 146 */           o o1 = (o)i;
/* 147 */           this.c = null;
/* 148 */           this.d = (b)o1;
/* 149 */           o1 = o1;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 154 */         this.c = null;
/* 155 */         this.d = a1.a();
/* 156 */         b1 = this.d;
/*     */       } 
/*     */       
/* 159 */       if (a1.d())
/*     */       {
/* 161 */         (new StringBuilder("Using fallback ")).append(b1.b()).append(" for CID-keyed font ")
/* 162 */           .append(a());
/*     */       }
/* 164 */       this.e = false;
/*     */     } 
/*     */     
/* 167 */     this.g = d().a();
/* 168 */     this.g.scale(1000.0D, 1000.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final d d() {
/* 174 */     if (this.f == null) {
/*     */       List<Number> list;
/*     */       
/* 177 */       if (this.c != null) {
/*     */         
/* 179 */         list = this.c.d();
/*     */       } else {
/*     */ 
/*     */         
/*     */         try {
/*     */           
/* 185 */           list = this.d.d();
/*     */         }
/* 187 */         catch (IOException iOException) {
/*     */           
/* 189 */           return new d(0.001F, 0.0F, 0.0F, 0.001F, 0.0F, 0.0F);
/*     */         } 
/*     */       } 
/*     */       
/* 193 */       if (list != null && list.size() == 6) {
/*     */         
/* 195 */         this
/*     */           
/* 197 */           .f = new d(((Number)list.get(0)).floatValue(), ((Number)list.get(1)).floatValue(), ((Number)list.get(2)).floatValue(), ((Number)list.get(3)).floatValue(), ((Number)list.get(4)).floatValue(), ((Number)list.get(5)).floatValue());
/*     */       }
/*     */       else {
/*     */         
/* 201 */         this.f = new d(0.001F, 0.0F, 0.0F, 0.001F, 0.0F, 0.0F);
/*     */       } 
/*     */     } 
/* 204 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class a
/*     */     implements l.a
/*     */   {
/*     */     private a(p this$0) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final org.a.b.h.a e() {
/* 220 */     if (this.h == null)
/*     */     {
/* 222 */       this.h = j();
/*     */     }
/* 224 */     return this.h;
/*     */   }
/*     */   
/*     */   private org.a.b.h.a j() {
/*     */     h h;
/* 229 */     if (c() != null && ((
/*     */       
/* 231 */       h = c().j()).c() != 0.0F || h.d() != 0.0F || h
/* 232 */       .e() != 0.0F || h.g() != 0.0F)) {
/* 233 */       return new org.a.b.h.a(h.c(), h.d(), h
/* 234 */           .e(), h.g());
/*     */     }
/*     */     
/* 237 */     if (this.c != null)
/*     */     {
/* 239 */       return this.c.c();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 245 */       return this.d.c();
/*     */     }
/* 247 */     catch (IOException iOException) {
/*     */       
/* 249 */       return new org.a.b.h.a();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private w e(int paramInt) {
/* 297 */     if (this.c != null)
/*     */     {
/* 299 */       return (w)this.c.b(paramInt);
/*     */     }
/* 301 */     if (this.d instanceof o)
/*     */     {
/* 303 */       return ((o)this.d).c(paramInt);
/*     */     }
/*     */ 
/*     */     
/* 307 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String f(int paramInt) {
/*     */     String str;
/* 318 */     if ((str = this.a.e(paramInt)) == null)
/*     */     {
/* 320 */       return ".notdef";
/*     */     }
/* 322 */     return l.a(str.codePointAt(0));
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
/*     */   public final int c(int paramInt) {
/* 377 */     return this.a.l().b(paramInt);
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
/*     */   public final byte[] d(int paramInt) {
/* 402 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public final float b(int paramInt) {
/*     */     float f;
/* 408 */     int i = c(paramInt);
/*     */     
/* 410 */     if (this.c != null) {
/*     */       
/* 412 */       f = e(i).a();
/*     */     }
/* 414 */     else if (this.e && this.d instanceof o) {
/*     */       
/* 416 */       f = ((o)this.d).c(i).a();
/*     */     }
/*     */     else {
/*     */       
/* 420 */       f = this.d.a(f(f));
/*     */     } 
/*     */     
/* 423 */     Point2D.Float float_ = new Point2D.Float(f, 0.0F);
/* 424 */     this.g.transform(float_, float_);
/* 425 */     return (float)float_.getX();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean g() {
/* 431 */     return this.e;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */