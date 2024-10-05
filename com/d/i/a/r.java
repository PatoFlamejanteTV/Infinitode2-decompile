/*      */ package com.d.i.a;
/*      */ import com.d.c.d.j;
/*      */ import com.d.c.e.b;
/*      */ import com.d.c.e.c;
/*      */ import com.d.c.e.d;
/*      */ import com.d.c.f.a.e;
/*      */ import com.d.c.f.a.f;
/*      */ import com.d.c.f.d;
/*      */ import com.d.c.f.g;
/*      */ import com.d.i.aa;
/*      */ import com.d.i.ab;
/*      */ import com.d.i.f;
/*      */ import com.d.l.b;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.geom.AffineTransform;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class r implements e {
/*      */   private final String a;
/*      */   private final int b;
/*      */   
/*      */   enum a {
/*   25 */     a,
/*   26 */     b,
/*   27 */     c;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static AffineTransform a(ab paramab, f paramf, aa paramaa, int paramInt) {
/*   35 */     a a = paramab.p().f() ? a.c : a.b;
/*      */     
/*   37 */     AffineTransform affineTransform = new AffineTransform();
/*      */     
/*   39 */     a((d)paramab, paramf, paramaa, affineTransform, a, paramInt);
/*      */     
/*   41 */     return affineTransform;
/*      */   }
/*      */   public static AffineTransform a(ab paramab, f paramf, aa paramaa, int paramInt1, int paramInt2) {
/*      */     float f1, f2, f3;
/*   45 */     g g = paramf.a().i(com.d.c.a.a.ay);
/*      */     
/*   47 */     float f4 = paramf.a().b(com.d.c.a.a.az, paramf
/*   48 */         .Q(), (d)paramab);
/*   49 */     float f5 = paramf.a().c(com.d.c.a.a.aA, paramf
/*   50 */         .as(), (d)paramab);
/*      */     
/*   52 */     float f6 = paramab.p().f() ? -1.0F : 1.0F;
/*      */     
/*   54 */     f4 += paramf.ab();
/*   55 */     f5 += paramf.aa();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   60 */     if (paramab.p().f()) {
/*      */       
/*   62 */       f2 = f4 + paramInt1;
/*   63 */       f3 = f5 + paramInt2;
/*   64 */       f1 = paramaa.b((d)paramab) - f3;
/*      */     } else {
/*      */       
/*   67 */       f2 = f4 + f2;
/*   68 */       f1 = f5 + f3;
/*      */     } 
/*      */     
/*   71 */     AffineTransform affineTransform2 = AffineTransform.getTranslateInstance(f2, f1);
/*   72 */     AffineTransform affineTransform1 = AffineTransform.getTranslateInstance(-f2, -f1);
/*      */ 
/*      */     
/*   75 */     List<j> list = ((f)g).j();
/*      */     
/*      */     AffineTransform affineTransform3;
/*   78 */     (affineTransform3 = new AffineTransform()).concatenate(affineTransform2);
/*   79 */     a(f6, list, affineTransform3, paramf, (d)paramab);
/*   80 */     affineTransform3.concatenate(affineTransform1);
/*      */     
/*   82 */     return affineTransform3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static AffineTransform a(f paramf, d paramd, AffineTransform paramAffineTransform) {
/*   91 */     paramAffineTransform = (paramAffineTransform == null) ? new AffineTransform() : (AffineTransform)paramAffineTransform.clone();
/*      */     
/*   93 */     a(paramd, paramf, null, paramAffineTransform, a.a, -1);
/*      */     
/*   95 */     return paramAffineTransform;
/*      */   }
/*      */   
/*      */   private static float a(float paramFloat, int paramInt, aa paramaa, d paramd, f paramf) {
/*   99 */     if (paramInt == -1 || paramf.af().c()) {
/*  100 */       return paramFloat + paramaa.d(paramd, 1);
/*      */     }
/*      */     
/*  103 */     Rectangle rectangle = paramaa.b(paramd, paramInt);
/*      */     
/*  105 */     return paramFloat - (float)rectangle.getMinX() + paramaa.d(paramd, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(d paramd, f paramf, aa paramaa, AffineTransform paramAffineTransform, a parama, int paramInt) {
/*      */     AffineTransform affineTransform1, affineTransform2;
/*  114 */     g g = paramf.a().i(com.d.c.a.a.ay);
/*      */     
/*  116 */     float f1 = paramf.a().b(com.d.c.a.a.az, paramf
/*  117 */         .Q(), paramd);
/*  118 */     float f2 = paramf.a().c(com.d.c.a.a.aA, paramf
/*  119 */         .as(), paramd);
/*      */     
/*  121 */     float f3 = (parama == a.c) ? -1.0F : 1.0F;
/*      */     
/*  123 */     f1 += paramf.ab();
/*  124 */     f2 += paramf.aa();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  129 */     if (parama == a.c || parama == a.b) {
/*      */       float f4, f5;
/*      */ 
/*      */       
/*  133 */       if (parama == a.c) {
/*      */         
/*  135 */         f5 = a(f1, paramInt, paramaa, paramd, paramf);
/*  136 */         f4 = f2 + paramaa.d(paramd, 3) - paramaa.d();
/*  137 */         f4 = paramaa.b(paramd) - f4;
/*      */       } else {
/*      */         
/*  140 */         f5 = a(f1, f5, paramaa, paramd, paramf);
/*  141 */         f4 = f2 - paramaa.d() + paramaa.d(paramd, 3);
/*      */       } 
/*      */       
/*  144 */       affineTransform1 = AffineTransform.getTranslateInstance(f5, f4);
/*  145 */       affineTransform2 = AffineTransform.getTranslateInstance(-f5, -f4);
/*      */     } else {
/*  147 */       affineTransform1 = AffineTransform.getTranslateInstance(f1, f2);
/*  148 */       affineTransform2 = AffineTransform.getTranslateInstance(-f1, -f2);
/*      */     } 
/*      */     
/*  151 */     List<j> list = ((f)g).j();
/*      */     
/*  153 */     paramAffineTransform.concatenate(affineTransform1);
/*  154 */     a(f3, list, paramAffineTransform, paramf, paramd);
/*  155 */     paramAffineTransform.concatenate(affineTransform2);
/*      */   }
/*      */   
/*      */   private static void a(float paramFloat, List<j> paramList, AffineTransform paramAffineTransform, f paramf, d paramd) {
/*  159 */     for (Iterator<j> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*  160 */       j j; String str = (j = iterator.next()).n().a();
/*  161 */       List<j> list = j.n().b();
/*      */       
/*  163 */       if ("rotate".equalsIgnoreCase(str)) {
/*  164 */         float f1 = paramFloat * a(list.get(0));
/*  165 */         paramAffineTransform.concatenate(AffineTransform.getRotateInstance(f1)); continue;
/*  166 */       }  if ("scale".equalsIgnoreCase(str) || "scalex"
/*  167 */         .equalsIgnoreCase(str) || "scaley"
/*  168 */         .equalsIgnoreCase(str)) {
/*  169 */         float f1 = ((j)list.get(0)).f();
/*  170 */         float f2 = ((j)list.get(0)).f();
/*  171 */         if (list.size() > 1)
/*  172 */           f2 = ((j)list.get(1)).f(); 
/*  173 */         if ("scalex".equalsIgnoreCase(str))
/*  174 */           f2 = 1.0F; 
/*  175 */         if ("scaley".equalsIgnoreCase(str))
/*  176 */           f1 = 1.0F; 
/*  177 */         paramAffineTransform.concatenate(AffineTransform.getScaleInstance(f1, f2)); continue;
/*  178 */       }  if ("skew".equalsIgnoreCase(str)) {
/*  179 */         float f1 = paramFloat * a(list.get(0));
/*  180 */         float f2 = 0.0F;
/*  181 */         if (list.size() > 1)
/*  182 */           f2 = a(list.get(1)); 
/*  183 */         paramAffineTransform.concatenate(AffineTransform.getShearInstance(Math.tan(f1), Math.tan(f2))); continue;
/*  184 */       }  if ("skewx".equalsIgnoreCase(str)) {
/*  185 */         float f1 = paramFloat * a(list.get(0));
/*  186 */         paramAffineTransform.concatenate(AffineTransform.getShearInstance(Math.tan(f1), 0.0D)); continue;
/*  187 */       }  if ("skewy".equalsIgnoreCase(str)) {
/*  188 */         float f1 = paramFloat * a(list.get(0));
/*  189 */         paramAffineTransform.concatenate(AffineTransform.getShearInstance(0.0D, Math.tan(f1))); continue;
/*  190 */       }  if ("matrix".equalsIgnoreCase(str)) {
/*  191 */         paramAffineTransform.concatenate(new AffineTransform(((j)list.get(0)).f(), ((j)list.get(1)).f(), ((j)list
/*  192 */               .get(2)).f(), ((j)list.get(3)).f(), ((j)list
/*  193 */               .get(4)).f(), ((j)list.get(5)).f())); continue;
/*  194 */       }  if ("translate".equalsIgnoreCase(str)) {
/*  195 */         float f1 = e.a(paramf.a(), null, null, ((j)list
/*  196 */             .get(0)).f(), ((j)list.get(0)).a(), paramf.Q(), paramd);
/*      */ 
/*      */ 
/*      */         
/*  200 */         float f2 = (list.size() > 1) ? e.a(paramf.a(), null, null, ((j)list.get(1)).f(), ((j)list.get(0)).a(), paramf.Q(), paramd) : f1;
/*      */         
/*  202 */         paramAffineTransform.concatenate(AffineTransform.getTranslateInstance(f1, (paramFloat * f2))); continue;
/*  203 */       }  if ("translateX".equalsIgnoreCase(str)) {
/*  204 */         float f1 = e.a(paramf.a(), null, null, ((j)list
/*  205 */             .get(0)).f(), ((j)list.get(0)).a(), paramf.Q(), paramd);
/*      */         
/*  207 */         paramAffineTransform.concatenate(AffineTransform.getTranslateInstance(f1, 0.0D)); continue;
/*  208 */       }  if ("translateY".equalsIgnoreCase(str)) {
/*  209 */         float f1 = e.a(paramf.a(), null, null, ((j)list
/*  210 */             .get(0)).f(), ((j)list.get(0)).a(), paramf.as(), paramd);
/*      */         
/*  212 */         paramAffineTransform.concatenate(AffineTransform.getTranslateInstance(0.0D, (paramFloat * f1)));
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static float a(j paramj) {
/*  218 */     if (paramj.a() == 11)
/*  219 */       return (float)Math.toRadians(paramj.f()); 
/*  220 */     if (paramj.a() == 12) {
/*  221 */       return paramj.f();
/*      */     }
/*  223 */     return (float)(paramj.f() * 0.015707963267948967D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1046 */   private final List<com.d.c.e.a> c = new ArrayList<>();
/* 1047 */   private final List<b> d = new ArrayList<>();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1052 */   private final List<Object> e = new ArrayList();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public r(String paramString, int paramInt) {
/* 1061 */     this.a = paramString;
/* 1062 */     this.b = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int a() {
/* 1071 */     return this.b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String b() {
/* 1080 */     return this.a;
/*      */   }
/*      */   
/*      */   public void a(d paramd) {
/* 1084 */     this.e.add(paramd);
/*      */   }
/*      */   
/*      */   public void a(b paramb) {
/* 1088 */     this.e.add(paramb);
/*      */   }
/*      */   
/*      */   public void a(c paramc) {
/* 1092 */     this.e.add(paramc);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<Object> c() {
/* 1099 */     return this.e;
/*      */   }
/*      */   
/*      */   public void a(b paramb) {
/* 1103 */     this.d.add(paramb);
/*      */   }
/*      */   
/*      */   public List<b> d() {
/* 1107 */     return this.d;
/*      */   }
/*      */   
/*      */   public void a(com.d.c.e.a parama) {
/* 1111 */     this.c.add(parama);
/*      */   }
/*      */   
/*      */   public List<com.d.c.e.a> e() {
/* 1115 */     return this.c;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\a\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */