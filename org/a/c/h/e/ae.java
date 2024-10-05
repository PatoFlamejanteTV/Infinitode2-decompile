/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.b.a;
/*     */ import org.a.b.b;
/*     */ import org.a.b.g.a;
/*     */ import org.a.b.g.d;
/*     */ import org.a.b.h.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.a.i;
/*     */ import org.a.c.h.e.a.c;
/*     */ import org.a.c.h.e.a.h;
/*     */ import org.a.c.h.e.a.i;
/*     */ import org.a.c.h.e.a.j;
/*     */ import org.a.c.h.e.a.k;
/*     */ import org.a.c.h.e.a.l;
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
/*     */ public class ae
/*     */   extends aa
/*     */ {
/*  60 */   private static final a s = c.a(ae.class);
/*     */   
/*     */   private static final Map<String, String> t;
/*     */ 
/*     */   
/*     */   static {
/*  66 */     (t = new HashMap<String, String>()).put("ff", "f_f");
/*  67 */     t.put("ffi", "f_f_i");
/*  68 */     t.put("ffl", "f_f_l");
/*  69 */     t.put("fi", "f_i");
/*  70 */     t.put("fl", "f_l");
/*  71 */     t.put("st", "s_t");
/*  72 */     t.put("IJ", "I_J");
/*  73 */     t.put("ij", "i_j");
/*  74 */     t.put("ellipsis", "elipsis");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  79 */   public static final ae e = new ae("Times-Roman");
/*  80 */   public static final ae f = new ae("Times-Bold");
/*  81 */   public static final ae g = new ae("Times-Italic");
/*  82 */   public static final ae h = new ae("Times-BoldItalic");
/*  83 */   public static final ae i = new ae("Helvetica");
/*  84 */   public static final ae j = new ae("Helvetica-Bold");
/*  85 */   public static final ae k = new ae("Helvetica-Oblique");
/*  86 */   public static final ae l = new ae("Helvetica-BoldOblique");
/*  87 */   public static final ae m = new ae("Courier");
/*  88 */   public static final ae n = new ae("Courier-Bold");
/*  89 */   public static final ae o = new ae("Courier-Oblique");
/*  90 */   public static final ae p = new ae("Courier-BoldOblique");
/*  91 */   public static final ae q = new ae("Symbol");
/*  92 */   public static final ae r = new ae("ZapfDingbats");
/*     */ 
/*     */ 
/*     */   
/*     */   private final d u;
/*     */ 
/*     */ 
/*     */   
/*     */   private final b v;
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean w;
/*     */ 
/*     */ 
/*     */   
/*     */   private d x;
/*     */ 
/*     */   
/*     */   private final AffineTransform y;
/*     */ 
/*     */   
/*     */   private a z;
/*     */ 
/*     */   
/*     */   private final Map<Integer, byte[]> A;
/*     */ 
/*     */ 
/*     */   
/*     */   private ae(String paramString) {
/* 122 */     super(paramString);
/*     */     
/* 124 */     this.b.a(j.dE, (b)j.dP);
/* 125 */     this.b.a(j.v, paramString);
/* 126 */     if ("ZapfDingbats".equals(paramString)) {
/*     */       
/* 128 */       this.c = (c)l.c;
/*     */     }
/* 130 */     else if ("Symbol".equals(paramString)) {
/*     */       
/* 132 */       this.c = (c)i.c;
/*     */     }
/*     */     else {
/*     */       
/* 136 */       this.c = (c)k.c;
/* 137 */       this.b.a(j.aR, (b)j.ec);
/*     */     } 
/*     */ 
/*     */     
/* 141 */     this.A = (Map)new ConcurrentHashMap<Integer, byte>();
/*     */ 
/*     */     
/* 144 */     this.u = null;
/*     */     
/* 146 */     m<b> m = l.a().b(s(), 
/* 147 */         b());
/* 148 */     this.v = m.c();
/*     */     
/* 150 */     if (m.d()) {
/*     */       String str;
/*     */ 
/*     */       
/*     */       try {
/* 155 */         str = this.v.b();
/*     */       }
/* 157 */       catch (IOException iOException) {
/*     */         
/* 159 */         str = "?";
/*     */       } 
/* 161 */       (new StringBuilder("Using fallback font ")).append(str).append(" for base font ").append(s());
/*     */     } 
/* 163 */     this.w = false;
/*     */     
/* 165 */     this.y = new AffineTransform();
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
/*     */   public ae(d paramd) {
/* 218 */     super(paramd);
/* 219 */     this.A = (Map)new HashMap<Integer, byte>();
/*     */     
/* 221 */     v v = b();
/* 222 */     d d1 = null;
/*     */     
/* 224 */     if (v != null) {
/*     */       i i;
/*     */ 
/*     */       
/* 228 */       if ((i = v.q()) != null)
/*     */       {
/* 230 */         throw new IllegalArgumentException("Use PDType1CFont for FontFile3");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 235 */       if ((i = v.o()) != null) {
/*     */         try {
/*     */           p p;
/*     */ 
/*     */           
/* 240 */           int k = (p = i.a()).j(j.bY);
/* 241 */           int j = p.j(j.bZ);
/*     */ 
/*     */           
/* 244 */           byte[] arrayOfByte = i.g();
/* 245 */           k = a(arrayOfByte, k);
/* 246 */           j = a(arrayOfByte, k, j);
/*     */           
/* 248 */           if (arrayOfByte.length > 0 && (arrayOfByte[0] & 0xFF) == 128)
/*     */           {
/*     */             
/* 251 */             d1 = d.a(arrayOfByte);
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 256 */             byte[] arrayOfByte1 = Arrays.copyOfRange(arrayOfByte, 0, k);
/* 257 */             arrayOfByte = Arrays.copyOfRange(arrayOfByte, k, k + j);
/*     */ 
/*     */             
/* 260 */             if (k > 0 && j > 0)
/*     */             {
/* 262 */               d1 = d.a(arrayOfByte1, arrayOfByte);
/*     */             }
/*     */           }
/*     */         
/* 266 */         } catch (a a1) {
/*     */           
/* 268 */           (new StringBuilder("Can't read damaged embedded Type1 font ")).append(v.g());
/*     */         
/*     */         }
/* 271 */         catch (IOException iOException) {
/*     */           
/* 273 */           (new StringBuilder("Can't read the embedded Type1 font ")).append(v.g());
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 278 */     this.w = (d1 != null);
/*     */     
/* 280 */     this.u = d1;
/*     */ 
/*     */     
/* 283 */     if (this.u != null) {
/*     */       
/* 285 */       this.v = (b)this.u;
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 290 */       m<b> m = l.a().b(s(), v);
/* 291 */       this.v = m.c();
/*     */       
/* 293 */       if (m.d())
/*     */       {
/* 295 */         (new StringBuilder("Using fallback font ")).append(this.v.b()).append(" for ").append(s());
/*     */       }
/*     */     } 
/* 298 */     l();
/* 299 */     this.y = h().a();
/* 300 */     this.y.scale(1000.0D, 1000.0D);
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
/*     */   private int a(byte[] paramArrayOfbyte, int paramInt) {
/*     */     int i;
/* 315 */     if ((i = Math.max(0, paramInt - 4)) <= 0 || i > paramArrayOfbyte.length - 4)
/*     */     {
/* 317 */       i = paramArrayOfbyte.length - 4;
/*     */     }
/*     */ 
/*     */     
/* 321 */     if ((i = b(paramArrayOfbyte, i)) == 0 && paramInt > 0)
/*     */     {
/*     */       
/* 324 */       i = b(paramArrayOfbyte, paramArrayOfbyte.length - 4);
/*     */     }
/*     */     
/* 327 */     if (paramInt - i != 0 && i > 0) {
/*     */       
/* 329 */       if (s.c())
/*     */       {
/* 331 */         (new StringBuilder("Ignored invalid Length1 ")).append(paramInt).append(" for Type 1 font ").append(d());
/*     */       }
/* 333 */       return i;
/*     */     } 
/*     */     
/* 336 */     return paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int b(byte[] paramArrayOfbyte, int paramInt) {
/* 341 */     paramInt = paramInt;
/* 342 */     while (paramInt > 0) {
/*     */       
/* 344 */       if (paramArrayOfbyte[paramInt] == 101 && paramArrayOfbyte[paramInt + 1] == 120 && paramArrayOfbyte[paramInt + 2] == 101 && paramArrayOfbyte[paramInt + 3] == 99) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 349 */         paramInt += 4;
/*     */         
/* 351 */         while (paramInt < paramArrayOfbyte.length && (paramArrayOfbyte[paramInt] == 13 || paramArrayOfbyte[paramInt] == 10 || paramArrayOfbyte[paramInt] == 32 || paramArrayOfbyte[paramInt] == 9))
/*     */         {
/*     */ 
/*     */           
/* 355 */           paramInt++;
/*     */         }
/*     */         break;
/*     */       } 
/* 359 */       paramInt--;
/*     */     } 
/* 361 */     return paramInt;
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
/*     */   private int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 377 */     if (paramInt2 < 0 || paramInt2 > paramArrayOfbyte.length - paramInt1) {
/*     */       
/* 379 */       (new StringBuilder("Ignored invalid Length2 ")).append(paramInt2).append(" for Type 1 font ").append(d());
/* 380 */       return paramArrayOfbyte.length - paramInt1;
/*     */     } 
/* 382 */     return paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String s() {
/* 390 */     return this.b.g(j.v);
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
/*     */   protected final byte[] d(int paramInt) {
/*     */     byte[] arrayOfByte2;
/* 413 */     if ((arrayOfByte2 = this.A.get(Integer.valueOf(paramInt))) != null)
/*     */     {
/* 415 */       return arrayOfByte2;
/*     */     }
/*     */     
/* 418 */     String str = o().a(paramInt);
/* 419 */     if (i()) {
/*     */ 
/*     */ 
/*     */       
/* 423 */       if (!this.c.a(str))
/*     */       {
/* 425 */         throw new IllegalArgumentException(
/* 426 */             String.format("U+%04X ('%s') is not available in this font %s encoding: %s", new Object[] {
/* 427 */                 Integer.valueOf(paramInt), str, d(), this.c.a()
/*     */               })); } 
/* 429 */       if (".notdef".equals(str))
/*     */       {
/* 431 */         throw new IllegalArgumentException(
/* 432 */             String.format("No glyph for U+%04X in font %s", new Object[] { Integer.valueOf(paramInt), d() }));
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 437 */       if (!this.c.a(str))
/*     */       {
/* 439 */         throw new IllegalArgumentException(
/* 440 */             String.format("U+%04X ('%s') is not available in this font %s (generic: %s) encoding: %s", new Object[] {
/* 441 */                 Integer.valueOf(paramInt), str, d(), this.v.b(), this.c.a()
/*     */               }));
/*     */       }
/*     */       
/*     */       String str1;
/* 446 */       if ((str1 = c(str)).equals(".notdef") || !this.v.b(str1))
/*     */       {
/* 448 */         throw new IllegalArgumentException(
/* 449 */             String.format("No glyph for U+%04X in font %s (generic: %s)", new Object[] { Integer.valueOf(paramInt), d(), this.v.b() }));
/*     */       }
/*     */     } 
/*     */     
/*     */     Map<?, Integer> map;
/* 454 */     int i = ((Integer)(map = this.c.e()).get(str)).intValue();
/* 455 */     byte[] arrayOfByte1 = { (byte)i };
/* 456 */     this.A.put(Integer.valueOf(paramInt), arrayOfByte1);
/* 457 */     return arrayOfByte1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float c(int paramInt) {
/* 463 */     String str = g(paramInt);
/*     */ 
/*     */     
/* 466 */     if (!this.w && ".notdef".equals(str))
/*     */     {
/* 468 */       return 250.0F;
/*     */     }
/* 470 */     float f = this.v.a(str);
/*     */     
/* 472 */     Point2D.Float float_ = new Point2D.Float(f, 0.0F);
/* 473 */     this.y.transform(float_, float_);
/* 474 */     return (float)float_.getX();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 480 */     return this.w;
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
/*     */   public final int a(InputStream paramInputStream) {
/* 499 */     return paramInputStream.read();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final c m() {
/* 505 */     if (!c() && a() != null)
/*     */     {
/*     */       
/* 508 */       return (c)new j(a());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 513 */     if (this.v instanceof a)
/*     */     {
/* 515 */       return (c)j.a(((a)this.v).a());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 520 */     return (c)h.c;
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
/*     */   public final String d() {
/* 542 */     return s();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final a e() {
/* 548 */     if (this.z == null)
/*     */     {
/* 550 */       this.z = t();
/*     */     }
/* 552 */     return this.z;
/*     */   }
/*     */   
/*     */   private a t() {
/*     */     h h;
/* 557 */     if (b() != null && (
/*     */       
/* 559 */       h = b().j()) != null && (h
/* 560 */       .c() != 0.0F || h.d() != 0.0F || h
/* 561 */       .e() != 0.0F || h.g() != 0.0F))
/*     */     {
/* 563 */       return new a(h.c(), h.d(), h
/* 564 */           .e(), h.g());
/*     */     }
/*     */     
/* 567 */     return this.v.c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String g(int paramInt) {
/* 573 */     String str = n().a(paramInt);
/* 574 */     return c(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String c(String paramString) {
/* 583 */     if (c() || this.v.b(paramString))
/*     */     {
/* 585 */       return paramString;
/*     */     }
/*     */     
/*     */     String str;
/*     */     
/* 590 */     if ((str = t.get(paramString)) != null && !paramString.equals(".notdef") && this.v.b(str))
/*     */     {
/* 592 */       return str;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 597 */     if ((str = o().a(paramString)) != null && str.length() == 1) {
/*     */       
/* 599 */       str = l.a(str.codePointAt(0));
/* 600 */       if (this.v.b(str))
/*     */       {
/* 602 */         return str;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 609 */       if ("SymbolMT".equals(this.v.b())) {
/*     */         Integer integer;
/*     */         
/* 612 */         if ((integer = (Integer)i.c.e().get(paramString)) != null) {
/*     */           
/* 614 */           str = l.a(integer.intValue() + 61440);
/* 615 */           if (this.v.b(str))
/*     */           {
/* 617 */             return str;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 623 */     return ".notdef";
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
/*     */   public final d h() {
/* 650 */     if (this.x == null) {
/*     */ 
/*     */ 
/*     */       
/* 654 */       List<Number> list = null;
/*     */       
/*     */       try {
/* 657 */         list = this.v.d();
/*     */       }
/* 659 */       catch (IOException iOException) {
/*     */         
/* 661 */         this.x = a;
/*     */       } 
/*     */       
/* 664 */       if (list != null && list.size() == 6) {
/*     */         
/* 666 */         this
/*     */ 
/*     */           
/* 669 */           .x = new d(((Number)list.get(0)).floatValue(), ((Number)list.get(1)).floatValue(), ((Number)list.get(2)).floatValue(), ((Number)list.get(3)).floatValue(), ((Number)list.get(4)).floatValue(), ((Number)list.get(5)).floatValue());
/*     */       }
/*     */       else {
/*     */         
/* 673 */         return super.h();
/*     */       } 
/*     */     } 
/* 676 */     return this.x;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */