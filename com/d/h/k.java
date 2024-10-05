/*     */ package com.d.h;
/*     */ 
/*     */ import com.d.c.f.d;
/*     */ import com.d.d.l;
/*     */ import com.d.d.n;
/*     */ import com.d.e.aa;
/*     */ import com.d.h.a.a;
/*     */ import com.d.h.a.b;
/*     */ import com.d.i.aa;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.c;
/*     */ import com.d.i.f;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Area;
/*     */ import java.awt.geom.PathIterator;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.e;
/*     */ import org.a.c.h.g.a.c;
/*     */ import org.a.c.h.g.a.f;
/*     */ import org.a.c.h.g.a.o;
/*     */ import org.a.c.h.g.b.e;
/*     */ import org.a.c.h.g.b.r;
/*     */ import org.a.c.h.g.d.a.d;
/*     */ import org.w3c.dom.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public final class k
/*     */ {
/*     */   private final Map<e, Set<String>> a;
/*     */   private final aa b;
/*     */   private final float c;
/*     */   private final f d;
/*     */   private final m e;
/*     */   private final List<b> f;
/*     */   
/*     */   public k(aa paramaa, float paramFloat, f paramf, m paramm) {
/*  53 */     this.b = paramaa;
/*  54 */     this.c = paramFloat;
/*  55 */     this.d = paramf;
/*  56 */     this.e = paramm;
/*  57 */     this.a = new HashMap<>();
/*  58 */     this.f = new ArrayList<>();
/*     */   }
/*     */   
/*     */   private Rectangle2D a(ab paramab, f paramf, float paramFloat, AffineTransform paramAffineTransform) {
/*  62 */     f f1 = paramf;
/*     */     
/*     */     f f2;
/*  65 */     while ((f2 = f1.S()) != null && f2.ai() == paramf.ai())
/*     */     {
/*     */ 
/*     */       
/*  69 */       f1 = f2;
/*     */     }
/*     */     
/*  72 */     Rectangle2D rectangle2D = a(paramab, f1, paramFloat, paramAffineTransform, this.e);
/*     */     
/*  74 */     f1 = f1.T();
/*  75 */     while (f1 != null && f1.ai() == paramf.ai()) {
/*  76 */       rectangle2D = a(rectangle2D, a(paramab, f1, paramFloat, paramAffineTransform, this.e));
/*     */       
/*  78 */       f1 = f1.T();
/*     */     } 
/*     */     
/*  81 */     return rectangle2D;
/*     */   }
/*     */   
/*     */   private static Rectangle2D a(Rectangle2D paramRectangle2D1, Rectangle2D paramRectangle2D2) {
/*  85 */     return paramRectangle2D1.createUnion(paramRectangle2D2);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String a(Rectangle2D paramRectangle2D, Shape paramShape, AffineTransform paramAffineTransform) {
/*  90 */     StringBuilder stringBuilder = new StringBuilder(paramRectangle2D.getMinX() + ":" + paramRectangle2D.getMaxY() + ":" + paramRectangle2D.getMaxX() + ":" + paramRectangle2D.getMinY());
/*  91 */     if (paramShape != null) {
/*  92 */       PathIterator pathIterator = paramShape.getPathIterator(paramAffineTransform);
/*  93 */       double[] arrayOfDouble = new double[6];
/*  94 */       while (!pathIterator.isDone()) {
/*     */         int i;
/*  96 */         switch (i = pathIterator.currentSegment(arrayOfDouble)) {
/*     */           case 3:
/*  98 */             stringBuilder.append("C");
/*  99 */             stringBuilder.append(arrayOfDouble[0]).append(":").append(arrayOfDouble[1]).append(":").append(arrayOfDouble[2]).append(":")
/* 100 */               .append(arrayOfDouble[3]).append(":").append(arrayOfDouble[4]).append(":").append(arrayOfDouble[5]);
/*     */             break;
/*     */           case 1:
/* 103 */             stringBuilder.append("L");
/* 104 */             stringBuilder.append(arrayOfDouble[0]).append(":").append(arrayOfDouble[1]).append(":");
/*     */             break;
/*     */           case 0:
/* 107 */             stringBuilder.append("M");
/* 108 */             stringBuilder.append(arrayOfDouble[0]).append(":").append(arrayOfDouble[1]).append(":");
/*     */             break;
/*     */           case 2:
/* 111 */             stringBuilder.append("Q");
/* 112 */             stringBuilder.append(arrayOfDouble[0]).append(":").append(arrayOfDouble[1]).append(":").append(arrayOfDouble[2]).append(":")
/* 113 */               .append(arrayOfDouble[3]);
/*     */             break;
/*     */           case 4:
/* 116 */             stringBuilder.append("cp");
/*     */             break;
/*     */         } 
/*     */ 
/*     */         
/* 121 */         pathIterator.next();
/*     */       } 
/*     */     } 
/* 124 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private Rectangle2D a(e parame, ab paramab, f paramf, float paramFloat, AffineTransform paramAffineTransform, Shape paramShape) {
/*     */     Rectangle2D rectangle2D;
/* 130 */     String str = a(rectangle2D = a(paramab, paramf, paramFloat, paramAffineTransform), paramShape, paramAffineTransform);
/*     */     Set<String> set;
/* 132 */     if ((set = this.a.get(parame)) == null) {
/* 133 */       set = new HashSet();
/* 134 */       this.a.put(parame, set);
/*     */     } 
/* 136 */     if (set.contains(str)) {
/* 137 */       return null;
/*     */     }
/* 139 */     set.add(str);
/* 140 */     return rectangle2D;
/*     */   } private void b(ab paramab, f paramf, e parame, float paramFloat, AffineTransform paramAffineTransform) {
/*     */     Element element;
/*     */     l l;
/*     */     String str;
/* 145 */     if ((element = paramf.ai()) != null && (
/*     */ 
/*     */       
/* 148 */       str = (l = this.b.l()).f(element)) != null)
/* 149 */       a(paramab, paramf, parame, paramFloat, paramAffineTransform, element, l, str, null); 
/*     */     n n;
/*     */     Map<Shape, String> map;
/* 152 */     if (paramf instanceof c && 
/*     */       
/* 154 */       n = ((c)paramf).E() instanceof a && (
/*     */       
/* 156 */       map = ((a)n).d()) != null) {
/* 157 */       for (Iterator<Map.Entry> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
/* 158 */         Map.Entry<Shape, ?> entry; Shape shape = (entry = iterator.next()).getKey();
/* 159 */         String str1 = (String)entry.getValue();
/* 160 */         l l1 = this.b.l();
/* 161 */         a(paramab, paramf, parame, paramFloat, paramAffineTransform, element, l1, str1, shape);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(Point2D.Float paramFloat1, Point2D.Float paramFloat2) {
/* 170 */     return (Math.abs(paramFloat1.x - paramFloat2.x) < 1.0E-6D && Math.abs(paramFloat1.y - paramFloat2.y) < 1.0E-6D);
/*     */   }
/*     */   
/*     */   private static void a(List<Point2D.Float> paramList) {
/*     */     boolean bool;
/*     */     do {
/* 176 */       bool = false;
/*     */ 
/*     */       
/*     */       byte b;
/*     */       
/* 181 */       for (b = 0; b < paramList.size() - 1; b++) {
/* 182 */         Point2D.Float float_1 = paramList.get(b);
/* 183 */         Point2D.Float float_2 = paramList.get(b + 1);
/* 184 */         if (a(float_1, float_2)) {
/* 185 */           paramList.remove(b);
/* 186 */           bool = true;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 192 */       for (b = 0; b < paramList.size() - 2; b++) {
/* 193 */         Point2D.Float float_1 = paramList.get(b);
/* 194 */         Point2D.Float float_2 = paramList.get(b + 2);
/* 195 */         if (a(float_1, float_2)) {
/* 196 */           paramList.remove(b);
/* 197 */           bool = true;
/*     */         } 
/*     */       } 
/* 200 */     } while (bool);
/*     */   }
/*     */   private void a(ab paramab, f paramf, e parame, float paramFloat, AffineTransform paramAffineTransform, Element paramElement, l paraml, String paramString, Shape paramShape) {
/*     */     e e1;
/*     */     f f1;
/* 205 */     if (paramString.length() > 1 && paramString.charAt(0) == '#') {
/* 206 */       String str = paramString.substring(1);
/*     */       
/* 208 */       if ((f1 = this.b.a(str)) != null) {
/* 209 */         c c; d d = a(paramab, f1);
/*     */ 
/*     */         
/* 212 */         if (paraml.a(paramElement, "onclick") != null && 
/* 213 */           !"".equals(paraml.a(paramElement, "onclick"))) {
/* 214 */           f f2 = new f(paraml.a(paramElement, "onclick"));
/*     */         } else {
/*     */           c c1;
/* 217 */           (c1 = new c()).a((org.a.c.h.g.d.a.a)d);
/* 218 */           c = c1;
/*     */         } 
/*     */         
/*     */         Rectangle2D rectangle2D;
/* 222 */         if ((rectangle2D = a(parame, paramab, paramf, paramFloat, paramAffineTransform, paramShape)) == null) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/* 227 */         (e1 = new e()).a((org.a.c.h.g.a.a)c);
/* 228 */         if (!a(paramAffineTransform, paramShape, rectangle2D, e1)) {
/*     */           return;
/*     */         }
/* 231 */         a(parame, e1);
/*     */       }  return;
/* 233 */     }  if (f1.contains("://")) {
/*     */       o o;
/* 235 */       (o = new o()).b((String)f1);
/*     */       
/*     */       Rectangle2D rectangle2D;
/* 238 */       if ((rectangle2D = a(parame, (ab)e1, paramf, paramFloat, paramAffineTransform, paramShape)) == null) {
/*     */         return;
/*     */       }
/*     */       e e2;
/* 242 */       (e2 = new e()).a((org.a.c.h.g.a.a)o);
/* 243 */       if (!a(paramAffineTransform, paramShape, rectangle2D, e2)) {
/*     */         return;
/*     */       }
/* 246 */       a(parame, e2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(AffineTransform paramAffineTransform, Shape paramShape, Rectangle2D paramRectangle2D, e parame) {
/* 253 */     parame.a(new h((float)paramRectangle2D.getMinX(), (float)paramRectangle2D.getMinY(), 
/* 254 */           (float)paramRectangle2D.getWidth(), (float)paramRectangle2D.getHeight()));
/* 255 */     if (paramShape != null) {
/*     */       float[] arrayOfFloat;
/*     */ 
/*     */ 
/*     */       
/* 260 */       if ((arrayOfFloat = a(paramAffineTransform, paramShape, paramRectangle2D)).length == 0)
/* 261 */         return false; 
/* 262 */       parame.a(arrayOfFloat);
/*     */     } 
/* 264 */     return true;
/*     */   }
/*     */   
/*     */   private static float[] a(AffineTransform paramAffineTransform, Shape paramShape, Rectangle2D paramRectangle2D) {
/* 268 */     ArrayList<Point2D.Float> arrayList = new ArrayList();
/*     */     AffineTransform affineTransform;
/* 270 */     (affineTransform = new AffineTransform()).translate(paramRectangle2D.getMinX(), paramRectangle2D.getMinY());
/*     */     
/* 272 */     affineTransform.translate(0.0D, paramRectangle2D.getHeight());
/* 273 */     affineTransform.scale(1.0D, -1.0D);
/* 274 */     affineTransform.concatenate(paramAffineTransform);
/*     */     Area area;
/* 276 */     PathIterator pathIterator = (area = new Area(paramShape)).getPathIterator(affineTransform, 1.0D);
/* 277 */     double[] arrayOfDouble = new double[6];
/* 278 */     while (!pathIterator.isDone()) {
/*     */       int i;
/* 280 */       switch (i = pathIterator.currentSegment(arrayOfDouble)) {
/*     */         case 3:
/* 282 */           throw new RuntimeException("Invalid State, Area should never give us a curve here!");
/*     */         case 1:
/* 284 */           arrayList.add(new Point2D.Float((float)arrayOfDouble[0], (float)arrayOfDouble[1]));
/*     */           break;
/*     */         case 0:
/* 287 */           arrayList.add(new Point2D.Float((float)arrayOfDouble[0], (float)arrayOfDouble[1]));
/*     */           break;
/*     */         case 2:
/* 290 */           throw new RuntimeException("Invalid State, Area should never give us a curve here!");
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 296 */       pathIterator.next();
/*     */     } 
/*     */     
/* 299 */     a(arrayList);
/*     */     
/*     */     a a;
/* 302 */     (a = new a(arrayList)).a();
/*     */     
/* 304 */     float[] arrayOfFloat = new float[a.b().size() << 3];
/* 305 */     byte b = 0;
/* 306 */     for (b b1 : a.b()) {
/* 307 */       arrayOfFloat[b++] = b1.a.x;
/* 308 */       arrayOfFloat[b++] = b1.a.y;
/* 309 */       arrayOfFloat[b++] = b1.b.x;
/* 310 */       arrayOfFloat[b++] = b1.b.y;
/*     */ 
/*     */ 
/*     */       
/* 314 */       arrayOfFloat[b++] = b1.b.x + (b1.c.x - b1.b.x) / 2.0F;
/* 315 */       arrayOfFloat[b++] = b1.b.y + (b1.c.y - b1.b.y) / 2.0F;
/*     */       
/* 317 */       arrayOfFloat[b++] = b1.c.x;
/* 318 */       arrayOfFloat[b++] = b1.c.y;
/*     */     } 
/*     */     
/* 321 */     if (arrayOfFloat.length % 8 != 0)
/* 322 */       throw new IllegalStateException("Not exact 8xn QuadPoints!"); 
/* 323 */     for (; b < arrayOfFloat.length; b += 2) {
/* 324 */       if (arrayOfFloat[b] < paramRectangle2D.getMinX() || arrayOfFloat[b] > paramRectangle2D.getMaxX())
/* 325 */         throw new IllegalStateException("Invalid rectangle calculation. Map shape is out of bound."); 
/* 326 */       if (arrayOfFloat[b + 1] < paramRectangle2D.getMinY() || arrayOfFloat[b + 1] > paramRectangle2D.getMaxY())
/* 327 */         throw new IllegalStateException("Invalid rectangle calculation. Map shape is out of bound."); 
/*     */     } 
/* 329 */     return arrayOfFloat;
/*     */   }
/*     */   
/*     */   private static void a(e parame, e parame1) {
/*     */     r r;
/* 334 */     (r = new r()).a(0.0F);
/* 335 */     r.a("S");
/* 336 */     parame1.a(r);
/*     */     
/*     */     try {
/*     */       List<e> list;
/*     */       
/* 341 */       if ((list = parame.i()) == null) {
/* 342 */         list = new ArrayList();
/* 343 */         parame.a(list);
/*     */       } 
/*     */       
/* 346 */       list.add(parame1); return;
/* 347 */     } catch (IOException iOException) {
/* 348 */       throw new w.a("processLink", iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private d a(ab paramab, f paramf) {
/* 353 */     d d = new d();
/*     */     
/*     */     aa aa1;
/*     */     
/* 357 */     int i = (int)((i = (aa1 = this.d.Z().a((d)paramab, this.e.b(paramf))).d((d)paramab, 3)) + paramf.aa() + paramf.n((d)paramab).t() - aa1.b());
/*     */     
/* 359 */     d.a((int)(aa1.b((d)paramab) / this.c - i / this.c));
/* 360 */     d.a(this.e.j().a(this.e.l() + aa1.i()));
/*     */     
/* 362 */     return d;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Rectangle2D a(ab paramab, f paramf, float paramFloat, AffineTransform paramAffineTransform, m paramm) {
/* 367 */     Rectangle rectangle = paramf.c(paramf.ab(), paramf.aa(), (d)paramab);
/*     */     
/* 369 */     Point2D.Float float_ = new Point2D.Float(rectangle.x, (float)rectangle.getMaxY());
/* 370 */     Point2D point2D = paramAffineTransform.transform(float_, null);
/*     */     
/* 372 */     return new Rectangle2D.Float((float)point2D.getX(), paramm
/* 373 */         .a((float)point2D.getY(), paramFloat), paramm
/* 374 */         .a(rectangle.width), paramm
/* 375 */         .a(rectangle.height));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class b
/*     */   {
/*     */     ab a;
/*     */     
/*     */     f b;
/*     */     e c;
/*     */     float d;
/*     */     AffineTransform e;
/*     */   }
/*     */   
/*     */   public final void a(ab paramab, f paramf, e parame, float paramFloat, AffineTransform paramAffineTransform) {
/* 390 */     if ((paramf instanceof c && ((c)paramf)
/* 391 */       .E() != null) || (paramf
/* 392 */       .ai() != null && paramf.ai().getNodeName().equals("a"))) {
/*     */       b b;
/*     */       
/* 395 */       (b = new b()).a = paramab;
/* 396 */       b.b = paramf;
/* 397 */       b.c = parame;
/* 398 */       b.d = paramFloat;
/* 399 */       b.e = (AffineTransform)paramAffineTransform.clone();
/*     */       
/* 401 */       this.f.add(b);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void a() {
/* 406 */     for (b b : this.f)
/* 407 */       b(b.a, b.b, b.c, b.d, b.e); 
/*     */   }
/*     */   
/*     */   public static interface a {
/*     */     Map<Shape, String> d();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */