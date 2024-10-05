/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.awt.geom.GeneralPath;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.a.b.f.aa;
/*     */ import org.a.b.f.ag;
/*     */ import org.a.b.f.al;
/*     */ import org.a.b.f.am;
/*     */ import org.a.b.f.ap;
/*     */ import org.a.b.f.c;
/*     */ import org.a.b.f.q;
/*     */ import org.a.b.f.r;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.g;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.a.i;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class aj
/*     */ {
/*     */   private final b d;
/*     */   protected ap a;
/*     */   protected v b;
/*     */   protected final c c;
/*  71 */   private final Set<Integer> e = new HashSet<Integer>();
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean f;
/*     */ 
/*     */ 
/*     */   
/*     */   aj(b paramb, d paramd, ap paramap, boolean paramBoolean) {
/*  80 */     this.d = paramb;
/*  81 */     this.f = paramBoolean;
/*  82 */     this.a = paramap;
/*  83 */     this.b = c(paramap);
/*     */     
/*  85 */     if (!a(paramap))
/*     */     {
/*  87 */       throw new IOException("This font does not permit embedding");
/*     */     }
/*     */     
/*  90 */     if (!paramBoolean) {
/*     */       i i;
/*     */ 
/*     */       
/*  94 */       (i = new i(paramb, paramap.u(), j.bc)).a().a(j.bY, paramap.v());
/*  95 */       this.b.a(i);
/*     */     } 
/*     */     
/*  98 */     paramd.a(j.v, paramap.b());
/*     */ 
/*     */     
/* 101 */     paramap.y();
/* 102 */     this.c = paramap.z();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(InputStream paramInputStream) {
/* 107 */     null = new i(this.d, paramInputStream, j.bc);
/*     */ 
/*     */     
/* 110 */     g g = null;
/*     */     
/*     */     try {
/* 113 */       g = null.c();
/* 114 */       this.a = (new al()).c((InputStream)g);
/* 115 */       if (!a(this.a))
/*     */       {
/* 117 */         throw new IOException("This font does not permit embedding");
/*     */       }
/* 119 */       if (this.b == null)
/*     */       {
/* 121 */         this.b = c(this.a);
/*     */       }
/*     */     }
/*     */     finally {
/*     */       
/* 126 */       am.a((Closeable)g);
/*     */     } 
/* 128 */     paramInputStream.a().a(j.bY, this.a.v());
/* 129 */     this.b.a((i)paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(ap paramap) {
/* 137 */     if (paramap.l() != null) {
/*     */       int i;
/*     */       
/*     */       short s;
/*     */       
/* 142 */       if (((i = (s = paramap.l().g()) & 0x8) & 0x1) == 1)
/*     */       {
/*     */ 
/*     */         
/* 146 */         return false;
/*     */       }
/* 148 */       if ((i & 0x200) == 512)
/*     */       {
/*     */ 
/*     */         
/* 152 */         return false;
/*     */       }
/*     */     } 
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean b(ap paramap) {
/* 163 */     if (paramap.l() != null) {
/*     */       short s;
/*     */       
/* 166 */       if (((s = paramap.l().g()) & 0x100) == 256)
/*     */       {
/*     */         
/* 169 */         return false;
/*     */       }
/*     */     } 
/* 172 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static v c(ap paramap) {
/*     */     v v1;
/* 181 */     (v1 = new v()).a(paramap.b());
/*     */     
/* 183 */     aa aa = paramap.l();
/* 184 */     ag ag = paramap.k();
/*     */ 
/*     */     
/* 187 */     v1.a((ag.a() > 0L || paramap
/* 188 */         .o().j() == 1));
/*     */     
/* 190 */     int i = aa.f();
/* 191 */     v1.f(((i & 0x201) != 0));
/*     */     
/* 193 */     switch (aa.e()) {
/*     */       
/*     */       case 1:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 7:
/* 200 */         v1.b(true);
/*     */         break;
/*     */       case 10:
/* 203 */         v1.d(true);
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 209 */     v1.a(aa.w());
/*     */     
/* 211 */     v1.c(true);
/* 212 */     v1.e(false);
/*     */ 
/*     */     
/* 215 */     v1.b(ag.b());
/*     */ 
/*     */     
/* 218 */     q q = paramap.n();
/* 219 */     h h = new h();
/* 220 */     float f = 1000.0F / q.k();
/* 221 */     h.a(q.n() * f);
/* 222 */     h.b(q.p() * f);
/* 223 */     h.c(q.m() * f);
/* 224 */     h.d(q.o() * f);
/* 225 */     v1.a(h);
/*     */ 
/*     */     
/* 228 */     r r = paramap.o();
/* 229 */     v1.c(r.b() * f);
/* 230 */     v1.d(r.e() * f);
/*     */ 
/*     */     
/* 233 */     if (aa.v() >= 1.2D) {
/*     */       
/* 235 */       v1.e(aa.B() * f);
/* 236 */       v1.f(aa.A() * f);
/*     */     } else {
/*     */       GeneralPath generalPath2;
/*     */ 
/*     */       
/* 241 */       if ((generalPath2 = paramap.c("H")) != null) {
/*     */         
/* 243 */         v1.e((float)Math.round(generalPath2.getBounds2D().getMaxY()) * f);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 248 */         v1.e((aa.t() + aa.u()) * f);
/*     */       } 
/*     */       GeneralPath generalPath1;
/* 251 */       if ((generalPath1 = paramap.c("x")) != null) {
/*     */         
/* 253 */         v1.f((float)Math.round(generalPath1.getBounds2D().getMaxY()) * f);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 258 */         v1.f(aa.t() / 2.0F * f);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 263 */     v1.g(v1.j().h() * 0.13F);
/*     */     
/* 265 */     return v1;
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
/*     */   public final void a(int paramInt) {
/* 290 */     this.e.add(Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b() {
/* 296 */     if (!b(this.a))
/*     */     {
/* 298 */       throw new IOException("This font does not permit subsetting");
/*     */     }
/*     */     
/* 301 */     if (!this.f)
/*     */     {
/* 303 */       throw new IllegalStateException("Subsetting is disabled");
/*     */     }
/*     */     
/*     */     ArrayList<String> arrayList;
/*     */     
/* 308 */     (arrayList = new ArrayList<String>()).add("head");
/* 309 */     arrayList.add("hhea");
/* 310 */     arrayList.add("loca");
/* 311 */     arrayList.add("maxp");
/* 312 */     arrayList.add("cvt ");
/* 313 */     arrayList.add("prep");
/* 314 */     arrayList.add("glyf");
/* 315 */     arrayList.add("hmtx");
/* 316 */     arrayList.add("fpgm");
/*     */     
/* 318 */     arrayList.add("gasp");
/*     */     
/*     */     am am;
/*     */     
/* 322 */     (am = new am(this.a, arrayList)).a(this.e);
/*     */     
/*     */     Map<Integer, Integer> map;
/*     */     
/* 326 */     String str = a(map = am.a());
/* 327 */     am.a(str);
/*     */ 
/*     */     
/* 330 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 331 */     am.a(byteArrayOutputStream);
/*     */ 
/*     */     
/* 334 */     a(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), str, map);
/* 335 */     this.a.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 343 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void a(InputStream paramInputStream, String paramString, Map<Integer, Integer> paramMap);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String a(Map<Integer, Integer> paramMap) {
/*     */     int i;
/* 358 */     long l3, l2 = paramMap.hashCode();
/*     */ 
/*     */     
/* 361 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     long l1;
/*     */     do {
/* 364 */       l3 = l2 / 25L;
/* 365 */       i = (int)(l2 % 25L);
/* 366 */       stringBuilder.append("BCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(i));
/*     */     }
/* 368 */     while ((l1 = l3) != 0L && stringBuilder.length() < 6);
/*     */ 
/*     */     
/* 371 */     while (stringBuilder.length() < 6)
/*     */     {
/* 373 */       stringBuilder.insert(0, 'A');
/*     */     }
/*     */     
/* 376 */     stringBuilder.append('+');
/* 377 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */