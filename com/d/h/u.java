/*     */ package com.d.h;
/*     */ 
/*     */ import com.d.d.m;
/*     */ import com.d.d.r;
/*     */ import com.d.i.k;
/*     */ import com.d.i.l;
/*     */ import com.d.i.t;
/*     */ import com.d.m.i;
/*     */ import com.d.m.l;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class u
/*     */   implements r
/*     */ {
/*  43 */   private static float a = 0.01F;
/*     */   
/*     */   private com.d.a.a b;
/*     */   
/*     */   public final void a(com.d.a.a parama) {
/*  48 */     this.b = parama;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(m paramm, String paramString, float paramFloat1, float paramFloat2) {
/*  53 */     ((m)paramm).a(paramString, paramFloat1, paramFloat2, (t)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(m paramm, String paramString, float paramFloat1, float paramFloat2, t paramt) {
/*  59 */     ((m)paramm).a(paramString, paramFloat1, paramFloat2, paramt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final l a(k paramk) {
/*  64 */     List<f.b> list = ((b)paramk).b();
/*  65 */     float f1 = paramk.a();
/*  66 */     c c = new c();
/*     */     
/*  68 */     float f2 = -3.4028235E38F;
/*  69 */     float f3 = -3.4028235E38F;
/*  70 */     float f4 = -3.4028235E38F;
/*  71 */     float f5 = -3.4028235E38F;
/*  72 */     float f6 = -3.4028235E38F;
/*  73 */     float f7 = -3.4028235E38F;
/*     */     
/*  75 */     for (Iterator<f.b> iterator = list.iterator(); iterator.hasNext(); ) {
/*     */       p p;
/*     */       f.b b;
/*  78 */       if ((p = (b = iterator.next()).e()) == null) {
/*  79 */         l.c("Font metrics not available. Probably a bug.");
/*     */         
/*     */         continue;
/*     */       } 
/*  83 */       float f9 = p.a;
/*  84 */       float f10 = p.b;
/*  85 */       float f11 = p.c;
/*  86 */       float f12 = p.d;
/*  87 */       float f13 = p.e;
/*  88 */       float f8 = p.f;
/*     */       
/*  90 */       if (f9 > f2) {
/*  91 */         f2 = f9;
/*     */       }
/*     */       
/*  94 */       if (f10 > f3) {
/*  95 */         f3 = f10;
/*     */       }
/*     */       
/*  98 */       if (f11 > f4) {
/*  99 */         f4 = f11;
/*     */       }
/*     */       
/* 102 */       if (f12 > f5) {
/* 103 */         f5 = f12;
/*     */       }
/*     */       
/* 106 */       if (f13 > f6) {
/* 107 */         f6 = f13;
/*     */       }
/*     */       
/* 110 */       if (f8 > f7) {
/* 111 */         f7 = f8;
/*     */       }
/*     */     } 
/*     */     
/* 115 */     c.a(f2 / 1000.0F * f1);
/* 116 */     c.b(f3 / 1000.0F * f1);
/* 117 */     c.c(f4 / 1000.0F * f1);
/*     */     
/* 119 */     if (f5 > 0.0F) {
/* 120 */       c.d(f5 / 1000.0F * f1);
/*     */     } else {
/* 122 */       c.d(f1 / 12.0F);
/*     */     } 
/*     */     
/* 125 */     c.e(f6 / 1000.0F * f1);
/* 126 */     c.f(f7 / 1000.0F * f1);
/*     */     
/* 128 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(int paramInt) {
/* 137 */     return (paramInt == 32 || paramInt == 160 || paramInt == 12288);
/*     */   } static class a {
/*     */     String a; f.b b; private a() {} }
/*     */   private static a b(k paramk) {
/* 141 */     String str = i.a().a().x();
/*     */     
/*     */     List<f.b> list;
/* 144 */     for (f.b b : list = ((b)paramk).b()) {
/*     */       try {
/* 146 */         b.c().b(str);
/*     */         
/*     */         a a2;
/*     */         
/* 150 */         (a2 = new a((byte)0)).a = str;
/* 151 */         a2.b = b;
/* 152 */         return a2;
/* 153 */       } catch (Exception exception) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     str = " ";
/* 161 */     for (f.b b : list) {
/*     */       try {
/* 163 */         b.c().b(str);
/*     */         
/*     */         a a2;
/*     */         
/* 167 */         (a2 = new a((byte)0)).a = " ";
/* 168 */         a2.b = b;
/* 169 */         return a2;
/* 170 */       } catch (Exception exception) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     l.d("Specified fonts don't contain a space character!");
/*     */     a a1;
/* 179 */     (a1 = new a((byte)0)).a = "";
/* 180 */     a1.b = list.get(0);
/* 181 */     return a1;
/*     */   }
/*     */   
/*     */   public static List<t.b> a(k paramk, String paramString, com.d.a.a parama) {
/* 185 */     StringBuilder stringBuilder = new StringBuilder();
/* 186 */     a a1 = b(paramk);
/* 187 */     List<f.b> list = ((b)paramk).b();
/* 188 */     ArrayList<t.b> arrayList = new ArrayList();
/* 189 */     t.b b = new t.b();
/*     */     
/* 191 */     for (int i = 0; i < paramString.length(); ) {
/* 192 */       int j = paramString.codePointAt(i);
/* 193 */       i += Character.charCount(j);
/* 194 */       String str = String.valueOf(Character.toChars(j));
/* 195 */       boolean bool = false;
/*     */ 
/*     */       
/* 198 */       for (f.b b1 : list) {
/*     */         try {
/* 200 */           b1.c().b(str);
/*     */           
/* 202 */           if (b.b == null) {
/*     */             
/* 204 */             b.b = b1;
/*     */           }
/* 206 */           else if (b1 != b.b) {
/*     */             
/* 208 */             b.a = stringBuilder.toString();
/* 209 */             arrayList.add(b);
/*     */             
/* 211 */             (b = new t.b()).b = b1;
/* 212 */             stringBuilder = new StringBuilder();
/*     */           } 
/*     */           
/* 215 */           if (a(j)) {
/* 216 */             b.c++;
/*     */           } else {
/* 218 */             b.d++;
/*     */           } 
/*     */           
/* 221 */           stringBuilder.append(str);
/* 222 */           bool = true;
/*     */           
/*     */           break;
/* 225 */         } catch (Exception exception) {
/* 226 */           if (parama.b()) {
/*     */             
/* 228 */             String str1 = parama.c(str);
/*     */             try {
/* 230 */               b1.c().b(str1);
/*     */               
/* 232 */               if (b.b == null) {
/*     */                 
/* 234 */                 b.b = b1;
/*     */               }
/* 236 */               else if (b1 != b.b) {
/*     */                 
/* 238 */                 b.a = stringBuilder.toString();
/* 239 */                 arrayList.add(b);
/*     */                 
/* 241 */                 (b = new t.b()).b = b1;
/* 242 */                 stringBuilder = new StringBuilder();
/*     */               } 
/*     */               
/* 245 */               if (a(j)) {
/* 246 */                 b.c++;
/*     */               } else {
/* 248 */                 b.d++;
/*     */               } 
/*     */               
/* 251 */               stringBuilder.append(str1);
/* 252 */               bool = true;
/*     */               
/*     */               break;
/* 255 */             } catch (Exception exception1) {}
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 262 */       if (!bool) {
/*     */         
/* 264 */         if (b.b == null) {
/*     */           
/* 266 */           b.b = a1.b;
/*     */         }
/* 268 */         else if (a1.b != b.b) {
/*     */           
/* 270 */           b.a = stringBuilder.toString();
/* 271 */           arrayList.add(b);
/*     */           
/* 273 */           (b = new t.b()).b = a1.b;
/* 274 */           stringBuilder = new StringBuilder();
/*     */         } 
/*     */         
/* 277 */         if (Character.isSpaceChar(j) || Character.isWhitespace(j)) {
/* 278 */           b.c++;
/* 279 */           stringBuilder.append(' '); continue;
/*     */         } 
/* 281 */         if (com.a.a.b.c.a.b(j)) {
/*     */ 
/*     */ 
/*     */           
/* 285 */           b.d++;
/* 286 */           stringBuilder.append(a1.a);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 291 */     if (stringBuilder.length() > 0) {
/* 292 */       b.a = stringBuilder.toString();
/* 293 */       arrayList.add(b);
/*     */     } 
/*     */     
/* 296 */     return arrayList;
/*     */   }
/*     */   
/*     */   private float b(k paramk, String paramString) {
/* 300 */     List<t.b> list = a(paramk, paramString, this.b);
/* 301 */     float f = 0.0F;
/*     */     
/* 303 */     for (t.b b : list) {
/*     */       try {
/* 305 */         f += b.b.c().b(b.a);
/* 306 */       } catch (Exception exception) {
/* 307 */         l.g(Level.WARNING, "BUG. Font didn't contain expected character.", exception);
/*     */       } 
/*     */     } 
/*     */     
/* 311 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int a(k paramk, String paramString) {
/* 316 */     float f = 0.0F;
/*     */     
/*     */     try {
/* 319 */       if (((b)paramk).b() == null || ((b)paramk)
/* 320 */         .b().isEmpty()) {
/* 321 */         l.h(Level.WARNING, "Font list is empty.");
/*     */       } else {
/*     */         
/* 324 */         for (Iterator<f.b> iterator = ((b)paramk).b().iterator(); iterator.hasNext(); ) {
/* 325 */           f.b b; if ((b = iterator.next()).c() != null) {
/* 326 */             f = b.c().b(paramString) / 1000.0F * paramk.a();
/*     */             break;
/*     */           } 
/* 329 */           l.h(Level.WARNING, "Font is null.");
/*     */         }
/*     */       
/*     */       } 
/* 333 */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */       
/* 336 */       f = b(paramk, paramString) / 1000.0F * paramk.a();
/* 337 */     } catch (IOException iOException) {
/* 338 */       throw new w.a("getWidth", iOException);
/*     */     } 
/*     */     
/* 341 */     if (f - Math.floor(f) < a) {
/* 342 */       return (int)f;
/*     */     }
/* 344 */     return (int)Math.ceil(f);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */