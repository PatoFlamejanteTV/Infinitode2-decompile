/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c.f;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.r;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */   extends f
/*     */ {
/*     */   private f t;
/*     */   private v[] u;
/*     */   
/*     */   public b(f paramf, v[] paramArrayOfv) {
/*  48 */     super(paramf);
/*  49 */     this.t = paramf;
/*  50 */     this.u = paramArrayOfv;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<Object> a(r paramr) {
/*  60 */     return this.t.a(paramr);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f a(s params) {
/*  65 */     return new b(this.t.a(params), this.u);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f a(Set<String> paramSet1, Set<String> paramSet2) {
/*  72 */     return new b(this.t.a(paramSet1, paramSet2), this.u);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final f a(boolean paramBoolean) {
/*  78 */     return new b(this.t.a(paramBoolean), this.u);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final f a(c paramc) {
/*  84 */     return new b(this.t.a(paramc), this.u);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final f g() {
/*  90 */     return this;
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
/*     */   public final Object a(l paraml, g paramg) {
/* 104 */     if (!paraml.p()) {
/* 105 */       return w(paraml, paramg);
/*     */     }
/* 107 */     if (!this.g) {
/* 108 */       return v(paraml, paramg);
/*     */     }
/* 110 */     Object object = this.b.a(paramg);
/*     */     
/* 112 */     paraml.a(object);
/*     */     
/* 114 */     v[] arrayOfV = this.u;
/* 115 */     int i = 0;
/* 116 */     int j = arrayOfV.length;
/*     */     while (true) {
/* 118 */       if (paraml.g() == o.e) {
/* 119 */         return object;
/*     */       }
/* 121 */       if (i != j) {
/*     */         v v1;
/*     */ 
/*     */         
/* 125 */         if ((v1 = arrayOfV[i]) != null) {
/*     */           try {
/* 127 */             v1.a(paraml, paramg, object);
/* 128 */           } catch (Exception exception) {
/* 129 */             a(exception, object, v1.a(), paramg);
/*     */           } 
/*     */         } else {
/* 132 */           paraml.j();
/*     */         } 
/* 134 */         i++; continue;
/*     */       }  break;
/*     */     } 
/* 137 */     if (!this.m && paramg.a(i.e)) {
/* 138 */       paramg.a((k)this, o.e, "Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[] {
/*     */             
/* 140 */             Integer.valueOf(j)
/*     */           });
/*     */     }
/*     */     
/*     */     while (true) {
/* 145 */       paraml.j();
/* 146 */       if (paraml.g() == o.e) {
/* 147 */         return object;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, Object paramObject) {
/* 155 */     paraml.a(paramObject);
/*     */     
/* 157 */     if (!paraml.p()) {
/* 158 */       return w(paraml, paramg);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     if (this.i != null) {
/* 165 */       a(paramg, paramObject);
/*     */     }
/* 167 */     v[] arrayOfV = this.u;
/* 168 */     int i = 0;
/* 169 */     int j = arrayOfV.length;
/*     */     while (true) {
/* 171 */       if (paraml.g() == o.e) {
/* 172 */         return paramObject;
/*     */       }
/* 174 */       if (i != j) {
/*     */         v v1;
/*     */ 
/*     */         
/* 178 */         if ((v1 = arrayOfV[i]) != null) {
/*     */           try {
/* 180 */             v1.a(paraml, paramg, paramObject);
/* 181 */           } catch (Exception exception) {
/* 182 */             a(exception, paramObject, v1.a(), paramg);
/*     */           } 
/*     */         } else {
/* 185 */           paraml.j();
/*     */         } 
/* 187 */         i++; continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 191 */     if (!this.m && paramg.a(i.e)) {
/* 192 */       paramg.a((k)this, o.e, "Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[] {
/*     */             
/* 194 */             Integer.valueOf(j)
/*     */           });
/*     */     }
/*     */     
/*     */     while (true) {
/* 199 */       paraml.j();
/* 200 */       if (paraml.g() == o.e) {
/* 201 */         return paramObject;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg) {
/* 209 */     return w(paraml, paramg);
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
/*     */   private Object v(l paraml, g paramg) {
/* 225 */     if (this.f) {
/* 226 */       return g(paraml, paramg);
/*     */     }
/* 228 */     Object object = this.b.a(paramg);
/*     */     
/* 230 */     paraml.a(object);
/* 231 */     if (this.i != null) {
/* 232 */       a(paramg, object);
/*     */     }
/* 234 */     Class clazz = this.n ? paramg.d() : null;
/* 235 */     v[] arrayOfV = this.u;
/* 236 */     int i = 0;
/* 237 */     int j = arrayOfV.length;
/*     */     
/*     */     while (true) {
/* 240 */       if (paraml.g() == o.e) {
/* 241 */         return object;
/*     */       }
/* 243 */       if (i != j) {
/*     */ 
/*     */         
/* 246 */         v v1 = arrayOfV[i];
/* 247 */         i++;
/* 248 */         if (v1 != null && (
/* 249 */           clazz == null || v1.a(clazz))) {
/*     */           try {
/* 251 */             v1.a(paraml, paramg, object);
/* 252 */           } catch (Exception exception) {
/* 253 */             a(exception, object, v1.a(), paramg);
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 259 */         paraml.j(); continue;
/*     */       }  break;
/*     */     } 
/* 262 */     if (!this.m) {
/* 263 */       paramg.a((k)this, o.e, "Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[] {
/*     */             
/* 265 */             Integer.valueOf(j)
/*     */           });
/*     */     }
/*     */     
/*     */     while (true) {
/* 270 */       paraml.j();
/* 271 */       if (paraml.g() == o.e) {
/* 272 */         return object;
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
/*     */ 
/*     */   
/*     */   protected final Object c(l paraml, g paramg) {
/*     */     v v1;
/* 288 */     y y = (v1 = this.e).a(paraml, paramg, this.q);
/*     */     
/*     */     v[] arrayOfV;
/* 291 */     int i = (arrayOfV = this.u).length;
/* 292 */     byte b1 = 0;
/* 293 */     Object object = null;
/* 294 */     Class clazz = this.n ? paramg.d() : null;
/*     */     
/* 296 */     for (; paraml.g() != o.e; b1++) {
/*     */       v v2;
/* 298 */       if ((v2 = (v)((b1 < i) ? arrayOfV[b1] : null)) == null) {
/* 299 */         paraml.j();
/*     */       
/*     */       }
/* 302 */       else if (clazz != null && !v2.a(clazz)) {
/* 303 */         paraml.j();
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 308 */       else if (object != null) {
/*     */         try {
/* 310 */           v2.a(paraml, paramg, object);
/* 311 */         } catch (Exception exception) {
/* 312 */           a(exception, object, v2.a(), paramg);
/*     */         } 
/*     */       } else {
/*     */         
/* 316 */         String str = v2.a();
/*     */         
/* 318 */         v v3 = v1.a(str);
/*     */         
/* 320 */         if (!y.a(str) || v3 != null)
/*     */         {
/*     */           
/* 323 */           if (v3 != null) {
/*     */             
/* 325 */             if (y.a(v3, v3.a(paraml, paramg))) {
/*     */               try {
/* 327 */                 object = v1.a(paramg, y);
/* 328 */               } catch (Exception exception) {
/* 329 */                 a(exception, this.a.b(), str, paramg);
/*     */               } 
/*     */ 
/*     */               
/* 333 */               paraml.a(object);
/*     */ 
/*     */               
/* 336 */               if (object.getClass() != this.a.b())
/*     */               {
/*     */ 
/*     */ 
/*     */                 
/* 341 */                 paramg.a(this.a, String.format("Cannot support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type %s, actual type %s", new Object[] {
/*     */ 
/*     */                         
/* 344 */                         i.b(this.a), 
/* 345 */                         i.c(object)
/*     */                       }));
/*     */               }
/*     */             } 
/*     */           } else {
/*     */             
/* 351 */             y.b((v)exception, exception.a(paraml, paramg));
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 355 */     if (object == null) {
/*     */       try {
/* 357 */         object = v1.a(paramg, y);
/* 358 */       } catch (Exception exception) {
/* 359 */         return a(exception, paramg);
/*     */       } 
/*     */     }
/* 362 */     return object;
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
/*     */   private Object w(l paraml, g paramg) {
/* 374 */     String str = "Cannot deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array";
/*     */     
/* 376 */     return paramg.a(e(paramg), paraml.k(), paraml, str, new Object[] {
/* 377 */           i.b(this.a), paraml.k()
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */