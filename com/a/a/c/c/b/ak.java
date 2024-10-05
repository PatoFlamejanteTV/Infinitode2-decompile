/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.b.b;
/*     */ import com.a.a.c.b.f;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.a.q;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.a;
/*     */ import com.a.a.c.m.f;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class ak
/*     */   extends ae<String[]>
/*     */   implements k
/*     */ {
/*  37 */   private static final String[] b = new String[0];
/*     */   
/*  39 */   public static final ak a = new ak();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private k<String> c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private s d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Boolean e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ak() {
/*  71 */     this((k<?>)null, (s)null, (Boolean)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ak(k<?> paramk, s params, Boolean paramBoolean) {
/*  77 */     super(String[].class);
/*  78 */     this.c = (k)paramk;
/*  79 */     this.d = params;
/*  80 */     this.e = paramBoolean;
/*  81 */     this.f = q.a(params);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f b() {
/*  86 */     return f.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Boolean a(f paramf) {
/*  91 */     return Boolean.TRUE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final a e() {
/*  97 */     return a.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object c(g paramg) {
/* 102 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<?> a(g paramg, c paramc) {
/* 113 */     k<String> k1 = this.c;
/*     */     
/* 115 */     k1 = (k)a(paramg, paramc, k1);
/* 116 */     j j = paramg.b(String.class);
/* 117 */     if (k1 == null) {
/* 118 */       k1 = paramg.a(j, paramc);
/*     */     } else {
/* 120 */       k1 = paramg.b(k1, paramc, j);
/*     */     } 
/*     */     
/* 123 */     Boolean bool = a(paramg, paramc, String[].class, l.a.a);
/*     */     
/* 125 */     s s1 = b(paramg, paramc, k1);
/*     */     
/* 127 */     if (k1 != null && a(k1)) {
/* 128 */       k1 = null;
/*     */     }
/* 130 */     if (this.c == k1 && 
/* 131 */       Objects.equals(this.e, bool) && this.d == s1)
/*     */     {
/* 133 */       return this;
/*     */     }
/* 135 */     return new ak(k1, s1, bool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] c(l paraml, g paramg) {
/* 142 */     if (!paraml.p()) {
/* 143 */       return e(paraml, paramg);
/*     */     }
/* 145 */     if (this.c != null) {
/* 146 */       return a(paraml, paramg, (String[])null);
/*     */     }
/*     */     
/*     */     f f;
/* 150 */     Object[] arrayOfObject = (f = paramg.n()).a();
/*     */     
/* 152 */     byte b = 0;
/*     */     
/*     */     try {
/*     */       while (true) {
/*     */         String str;
/* 157 */         if ((str = paraml.i()) == null) {
/*     */           o o;
/* 159 */           if ((o = paraml.k()) != o.e)
/*     */           
/*     */           { 
/* 162 */             if (o == o.m)
/* 163 */             { if (!this.f)
/*     */               
/*     */               { 
/* 166 */                 String str1 = (String)this.d.a(paramg); } else { continue; }
/*     */                }
/* 168 */             else { str = a(paraml, paramg, this.d); }  }
/*     */           else { break; }
/*     */         
/* 171 */         }  if (b >= arrayOfObject.length) {
/* 172 */           arrayOfObject = f.a(arrayOfObject);
/* 173 */           b = 0;
/*     */         } 
/* 175 */         arrayOfObject[b++] = str;
/*     */       } 
/* 177 */     } catch (Exception exception2) {
/* 178 */       Exception exception1; throw l.a(exception1 = null, arrayOfObject, f.c() + b);
/*     */     } 
/* 180 */     String[] arrayOfString = (String[])f.a(arrayOfObject, b, String.class);
/* 181 */     paramg.a(f);
/* 182 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] a(l paraml, g paramg, String[] paramArrayOfString) {
/*     */     Object[] arrayOfObject;
/*     */     int i;
/* 191 */     f f = paramg.n();
/*     */ 
/*     */ 
/*     */     
/* 195 */     if (paramArrayOfString == null) {
/* 196 */       i = 0;
/* 197 */       arrayOfObject = f.a();
/*     */     } else {
/* 199 */       i = arrayOfObject.length;
/* 200 */       arrayOfObject = f.a(arrayOfObject, i);
/*     */     } 
/*     */     
/* 203 */     k<String> k1 = this.c;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*     */       while (true) {
/*     */         String str;
/*     */ 
/*     */ 
/*     */         
/* 213 */         if (paraml.i() == null)
/*     */         { o o;
/* 215 */           if ((o = paraml.k()) != o.e)
/*     */           
/*     */           { 
/*     */             
/* 219 */             if (o == o.m)
/* 220 */             { if (!this.f)
/*     */               
/*     */               { 
/* 223 */                 str = (String)this.d.a(paramg); } else { continue; }
/*     */                }
/* 225 */             else { str = (String)k1.a(paraml, paramg); }  }
/*     */           else { break; }
/*     */            }
/* 228 */         else { str = (String)k1.a(paraml, paramg); }
/*     */         
/* 230 */         if (i >= arrayOfObject.length) {
/* 231 */           arrayOfObject = f.a(arrayOfObject);
/* 232 */           i = 0;
/*     */         } 
/* 234 */         arrayOfObject[i++] = str;
/*     */       } 
/* 236 */     } catch (Exception exception2) {
/*     */       Exception exception1;
/* 238 */       throw l.a(exception1 = null, String.class, i);
/*     */     } 
/* 240 */     String[] arrayOfString = (String[])f.a(arrayOfObject, i, String.class);
/* 241 */     paramg.a(f);
/* 242 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, e parame) {
/* 247 */     return parame.b(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] b(l paraml, g paramg, String[] paramArrayOfString) {
/* 255 */     if (!paraml.p()) {
/*     */       String[] arrayOfString1;
/* 257 */       if ((arrayOfString1 = e(paraml, paramg)) == null) {
/* 258 */         return paramArrayOfString;
/*     */       }
/*     */       int j;
/* 261 */       String[] arrayOfString2 = new String[(j = paramArrayOfString.length) + arrayOfString1.length];
/* 262 */       System.arraycopy(paramArrayOfString, 0, arrayOfString2, 0, j);
/* 263 */       System.arraycopy(arrayOfString1, 0, arrayOfString2, j, arrayOfString1.length);
/* 264 */       return arrayOfString2;
/*     */     } 
/*     */     
/* 267 */     if (this.c != null) {
/* 268 */       return a(paraml, paramg, paramArrayOfString);
/*     */     }
/* 270 */     f f = paramg.n();
/* 271 */     int i = paramArrayOfString.length;
/* 272 */     Object[] arrayOfObject = f.a((Object[])paramArrayOfString, i);
/*     */     
/*     */     try {
/*     */       while (true) {
/*     */         String str;
/* 277 */         if ((str = paraml.i()) == null) {
/*     */           o o;
/* 279 */           if ((o = paraml.k()) != o.e)
/*     */           
/*     */           { 
/* 282 */             if (o == o.m)
/*     */             
/* 284 */             { if (this.f) {
/* 285 */                 return b;
/*     */               }
/* 287 */               String str1 = (String)this.d.a(paramg); }
/*     */             else
/* 289 */             { str = a(paraml, paramg, this.d); }  }
/*     */           else { break; }
/*     */         
/* 292 */         }  if (i >= arrayOfObject.length) {
/* 293 */           arrayOfObject = f.a(arrayOfObject);
/* 294 */           i = 0;
/*     */         } 
/* 296 */         arrayOfObject[i++] = str;
/*     */       } 
/* 298 */     } catch (Exception exception) {
/* 299 */       throw l.a(paramArrayOfString = null, arrayOfObject, f.c() + i);
/*     */     } 
/* 301 */     paramArrayOfString = (String[])f.a(arrayOfObject, i, String.class);
/* 302 */     paramg.a(f);
/* 303 */     return paramArrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String[] e(l paraml, g paramg) {
/*     */     String str;
/*     */     boolean bool;
/* 312 */     if (bool = (this.e == Boolean.TRUE || (this.e == null && paramg.a(i.p))) ? true : false) {
/*     */       
/* 314 */       if (paraml.a(o.m)) {
/* 315 */         str = (String)this.d.a(paramg);
/*     */       } else {
/* 317 */         if (str.a(o.h)) {
/*     */           b b;
/*     */           String str1;
/* 320 */           if ((str1 = str.w()).isEmpty()) {
/*     */ 
/*     */             
/* 323 */             if ((b = paramg.a(b(), a(), f.f)) != b.a) {
/* 324 */               return (String[])a(paramg, b, a());
/*     */             }
/*     */           }
/* 327 */           else if (h((String)b) && (
/*     */ 
/*     */             
/* 330 */             b = paramg.a(b(), a(), b.a)) != b.a) {
/* 331 */             return (String[])a(paramg, b, a());
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 338 */         str = a((l)str, paramg, this.d);
/*     */       } 
/* 340 */       return new String[] { str };
/*     */     } 
/* 342 */     if (str.a(o.h)) {
/* 343 */       return m((l)str, paramg);
/*     */     }
/* 345 */     return (String[])paramg.a(this.s, (l)str);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\ak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */