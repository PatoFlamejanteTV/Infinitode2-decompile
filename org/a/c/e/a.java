/*     */ package org.a.c.e;
/*     */ 
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.a.i;
/*     */ import org.a.c.h.b;
/*     */ import org.a.c.h.c;
/*     */ import org.a.c.h.e;
/*     */ import org.a.c.h.j;
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
/*     */ public class a
/*     */ {
/*     */   private final b a;
/*     */   private final b b;
/*     */   
/*     */   static {
/*  54 */     c.a(a.class);
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
/*     */   public a(b paramb) {
/*  67 */     this.a = paramb;
/*  68 */     this.b = new b(paramb);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 145 */   private static final Set<String> c = new HashSet<String>(
/* 146 */       Arrays.asList(new String[] { "Group", "LastModified", "Metadata" }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final org.a.c.h.f.b.a a(b paramb, e parame) {
/* 162 */     a(paramb);
/*     */     
/* 164 */     i i = new i(this.a, parame.a(), j.bc);
/* 165 */     org.a.c.h.f.b.a a1 = new org.a.c.h.f.b.a(i);
/*     */ 
/*     */     
/* 168 */     j j1 = parame.d();
/* 169 */     j j2 = new j();
/* 170 */     this.b.a((c)j1, (c)j2);
/* 171 */     a1.a(j2);
/*     */ 
/*     */     
/* 174 */     a(parame.b(), (d)a1.b(), c, true);
/*     */     
/*     */     d d;
/* 177 */     AffineTransform affineTransform = (d = a1.h()).a();
/* 178 */     h h1 = parame.e();
/*     */     
/* 180 */     h h2 = ((h2 = parame.g()) != null) ? h2 : h1;
/*     */ 
/*     */     
/* 183 */     int j = parame.h();
/*     */ 
/*     */ 
/*     */     
/* 187 */     affineTransform.translate((h1.c() - h2.c()), (h1
/* 188 */         .d() - h2.d()));
/* 189 */     switch (j) {
/*     */       
/*     */       case 90:
/* 192 */         affineTransform.scale((h2.h() / h2.i()), (h2.i() / h2.h()));
/* 193 */         affineTransform.translate(0.0D, h2.h());
/* 194 */         affineTransform.rotate(-1.5707963267948966D);
/*     */         break;
/*     */       case 180:
/* 197 */         affineTransform.translate(h2.h(), h2.i());
/* 198 */         affineTransform.rotate(-3.141592653589793D);
/*     */         break;
/*     */       case 270:
/* 201 */         affineTransform.scale((h2.h() / h2.i()), (h2.i() / h2.h()));
/* 202 */         affineTransform.translate(h2.i(), 0.0D);
/* 203 */         affineTransform.rotate(-4.71238898038469D);
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 209 */     affineTransform.translate(-h2.c(), -h2.d());
/* 210 */     if (!affineTransform.isIdentity())
/*     */     {
/* 212 */       a1.a(affineTransform);
/*     */     }
/*     */     
/*     */     org.a.b.h.a a2;
/* 216 */     (a2 = new org.a.b.h.a()).a(h2.c());
/* 217 */     a2.b(h2.d());
/* 218 */     a2.c(h2.e());
/* 219 */     a2.d(h2.g());
/* 220 */     a1.a(new h(a2));
/*     */     
/* 222 */     return a1;
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
/*     */   private void a(d paramd1, d paramd2, Set<String> paramSet, boolean paramBoolean) {
/* 286 */     for (Iterator<Map.Entry> iterator = paramd1.e().iterator(); iterator.hasNext(); ) {
/*     */       Map.Entry<j, ?> entry;
/* 288 */       j j = (entry = iterator.next()).getKey();
/* 289 */       if (paramSet.contains(j.a()))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 297 */         paramd2.a(j, this.b
/* 298 */             .a(entry.getValue()));
/*     */       }
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
/*     */   private void a(b paramb) {
/*     */     org.a.c.h.f.d.a a1;
/*     */     c c1;
/* 313 */     if ((a1 = (c1 = paramb.c()).e()) == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     c c2;
/*     */     
/*     */     org.a.c.h.f.d.a a2;
/*     */     
/* 321 */     if ((a2 = (c2 = this.a.c()).e()) == null) {
/*     */       
/* 323 */       c2.a(new org.a.c.h.f.d.a((d)this.b
/* 324 */             .a(a1)));
/*     */       
/*     */       return;
/*     */     } 
/* 328 */     this.b.a((c)a1, (c)a2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */