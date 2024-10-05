/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.b.b;
/*     */ import com.a.a.c.b.f;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.f.o;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.l.f;
/*     */ import java.util.Collection;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class al
/*     */   extends i<Collection<String>>
/*     */   implements k
/*     */ {
/*     */   private k<String> a;
/*     */   private x f;
/*     */   private k<Object> g;
/*     */   
/*     */   public al(j paramj, k<?> paramk, x paramx) {
/*  66 */     this(paramj, paramx, (k<?>)null, paramk, (s)paramk, (Boolean)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private al(j paramj, x paramx, k<?> paramk1, k<?> paramk2, s params, Boolean paramBoolean) {
/*  75 */     super(paramj, params, paramBoolean);
/*  76 */     this.a = (k)paramk2;
/*  77 */     this.f = paramx;
/*  78 */     this.g = (k)paramk1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private al a(k<?> paramk1, k<?> paramk2, s params, Boolean paramBoolean) {
/*  85 */     if (Objects.equals(this.e, paramBoolean) && this.c == params && this.a == paramk2 && this.g == paramk1)
/*     */     {
/*  87 */       return this;
/*     */     }
/*  89 */     return new al(this.b, this.f, paramk1, paramk2, params, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/*  97 */     return (this.a == null && this.g == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f b() {
/* 102 */     return f.b;
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
/*     */   public final k<?> a(g paramg, c paramc) {
/* 115 */     k<?> k1 = null;
/* 116 */     if (this.f != null) {
/*     */       o o;
/*     */       
/* 119 */       if ((o = this.f.t()) != null) {
/* 120 */         paramg.c(); j j1 = this.f.q();
/* 121 */         k1 = a(paramg, j1, paramc);
/* 122 */       } else if (this.f.s() != null) {
/* 123 */         paramg.c(); j j1 = this.f.p();
/* 124 */         k1 = a(paramg, j1, paramc);
/*     */       } 
/*     */     } 
/* 127 */     k<String> k2 = this.a;
/* 128 */     j j = this.b.u();
/* 129 */     if (k2 == null) {
/*     */ 
/*     */       
/* 132 */       if ((k2 = (k)a(paramg, paramc, k2)) == null)
/*     */       {
/* 134 */         k2 = paramg.a(j, paramc);
/*     */       }
/*     */     } else {
/* 137 */       k2 = paramg.b(k2, paramc, j);
/*     */     } 
/*     */ 
/*     */     
/* 141 */     Boolean bool = a(paramg, paramc, Collection.class, l.a.a);
/*     */     
/* 143 */     s s = b(paramg, paramc, k2);
/* 144 */     if (a(k2)) {
/* 145 */       k2 = null;
/*     */     }
/* 147 */     return a(k1, k2, s, bool);
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
/*     */   public final k<Object> g() {
/*     */     k<String> k1;
/* 160 */     return (k)(k1 = this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final x i() {
/* 165 */     return this.f;
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
/*     */   private Collection<String> c(l paraml, g paramg) {
/* 179 */     if (this.g != null) {
/* 180 */       return (Collection<String>)this.f.a(paramg, this.g
/* 181 */           .a(paraml, paramg));
/*     */     }
/* 183 */     Collection<String> collection = (Collection)this.f.a(paramg);
/* 184 */     return a(paraml, paramg, collection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Collection<String> a(l paraml, g paramg, Collection<String> paramCollection) {
/* 193 */     if (!paraml.p()) {
/* 194 */       return b(paraml, paramg, paramCollection);
/*     */     }
/*     */     
/* 197 */     if (this.a != null) {
/* 198 */       return a(paraml, paramg, paramCollection, this.a);
/*     */     }
/*     */     
/*     */     try {
/*     */       while (true) {
/*     */         String str;
/* 204 */         while ((str = paraml.i()) != null) {
/* 205 */           paramCollection.add(str);
/*     */         }
/*     */         
/*     */         o o;
/* 209 */         if ((o = paraml.k()) != o.e)
/*     */         { String str1;
/*     */           
/* 212 */           if (o == o.m)
/* 213 */           { if (!this.d)
/*     */             
/*     */             { 
/* 216 */               str1 = (String)this.c.a(paramg); } else { continue; }
/*     */              }
/* 218 */           else { str1 = a(paraml, paramg, this.c); }
/*     */           
/* 220 */           paramCollection.add(str1); continue; }  break;
/*     */       } 
/* 222 */     } catch (Exception exception2) {
/* 223 */       Exception exception1; throw l.a(exception1 = null, paramCollection, paramCollection.size());
/*     */     } 
/* 225 */     return paramCollection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Collection<String> a(l paraml, g paramg, Collection<String> paramCollection, k<String> paramk) {
/*     */     try {
/*     */       while (true) {
/*     */         String str;
/* 239 */         if (paraml.i() == null)
/*     */         { o o;
/* 241 */           if ((o = paraml.k()) != o.e)
/*     */           
/*     */           { 
/*     */             
/* 245 */             if (o == o.m)
/* 246 */             { if (!this.d)
/*     */               
/*     */               { 
/* 249 */                 str = (String)this.c.a(paramg); } else { continue; }
/*     */                }
/* 251 */             else { str = (String)paramk.a(paraml, paramg); }  }
/*     */           else { break; }
/*     */            }
/* 254 */         else { str = (String)paramk.a(paraml, paramg); }
/*     */         
/* 256 */         paramCollection.add(str);
/*     */       } 
/* 258 */     } catch (Exception exception2) {
/* 259 */       Exception exception1; throw l.a(exception1 = null, paramCollection, paramCollection.size());
/*     */     } 
/* 261 */     return paramCollection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, e parame) {
/* 268 */     return parame.b(paraml, paramg);
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
/*     */   private final Collection<String> b(l paraml, g paramg, Collection<String> paramCollection) {
/*     */     String str;
/*     */     boolean bool;
/* 284 */     if (!(bool = (this.e == Boolean.TRUE || (this.e == null && paramg.a(i.p))) ? true : false)) {
/* 285 */       if (paraml.a(o.h)) {
/* 286 */         return m(paraml, paramg);
/*     */       }
/* 288 */       return (Collection<String>)paramg.a(this.b, paraml);
/*     */     } 
/*     */     
/* 291 */     k<String> k1 = this.a;
/*     */ 
/*     */     
/*     */     o o;
/*     */     
/* 296 */     if ((o = paraml.k()) == o.m) {
/*     */       
/* 298 */       if (this.d) {
/* 299 */         return paramCollection;
/*     */       }
/* 301 */       str = (String)this.c.a(paramg);
/*     */     } else {
/* 303 */       if (str.a(o.h)) {
/*     */         b b;
/*     */         String str1;
/* 306 */         if ((str1 = str.w()).isEmpty()) {
/*     */ 
/*     */           
/* 309 */           if ((b = paramg.a(b(), a(), f.f)) != b.a) {
/* 310 */             return (Collection<String>)a(paramg, b, a());
/*     */           }
/*     */         }
/* 313 */         else if (h((String)b) && (
/*     */ 
/*     */           
/* 316 */           b = paramg.a(b(), a(), b.a)) != b.a) {
/* 317 */           return (Collection<String>)a(paramg, b, a());
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 325 */         str = (k1 == null) ? a((l)str, paramg, this.c) : (String)k1.a((l)str, paramg);
/* 326 */       } catch (Exception exception) {
/* 327 */         throw l.a(o = null, paramCollection, paramCollection.size());
/*     */       } 
/*     */     } 
/* 330 */     paramCollection.add(str);
/* 331 */     return paramCollection;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\al.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */