/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c.f;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.k;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.j;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */   extends f
/*     */ {
/*     */   private f t;
/*     */   private v[] u;
/*     */   private k v;
/*     */   private j w;
/*     */   
/*     */   public a(f paramf, j paramj, v[] paramArrayOfv, k paramk) {
/*  56 */     super(paramf);
/*  57 */     this.t = paramf;
/*  58 */     this.w = paramj;
/*  59 */     this.u = paramArrayOfv;
/*  60 */     this.v = paramk;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<Object> a(r paramr) {
/*  70 */     return this.t.a(paramr);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f a(s params) {
/*  75 */     return new a(this.t.a(params), this.w, this.u, this.v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f a(Set<String> paramSet1, Set<String> paramSet2) {
/*  82 */     return new a(this.t.a(paramSet1, paramSet2), this.w, this.u, this.v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final f a(boolean paramBoolean) {
/*  88 */     return new a(this.t.a(paramBoolean), this.w, this.u, this.v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final f a(c paramc) {
/*  94 */     return new a(this.t.a(paramc), this.w, this.u, this.v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final f g() {
/* 100 */     return this;
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
/*     */   public final Boolean a(f paramf) {
/* 112 */     return Boolean.FALSE;
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
/*     */   private Object b(g paramg, Object paramObject) {
/*     */     try {
/* 125 */       return this.v.l().invoke(paramObject, (Object[])null);
/* 126 */     } catch (Exception exception) {
/* 127 */       return a(exception, paramg);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg) {
/* 136 */     if (!paraml.p()) {
/* 137 */       return b(paramg, w(paraml, paramg));
/*     */     }
/* 139 */     if (!this.g) {
/* 140 */       return b(paramg, v(paraml, paramg));
/*     */     }
/* 142 */     Object object = this.b.a(paramg);
/* 143 */     v[] arrayOfV = this.u;
/* 144 */     int i = 0;
/* 145 */     int m = arrayOfV.length;
/*     */     while (true) {
/* 147 */       if (paraml.g() == o.e) {
/* 148 */         return b(paramg, object);
/*     */       }
/* 150 */       if (i != m) {
/*     */         v v1;
/*     */ 
/*     */         
/* 154 */         if ((v1 = arrayOfV[i]) != null) {
/*     */           try {
/* 156 */             object = v1.b(paraml, paramg, object);
/* 157 */           } catch (Exception exception) {
/* 158 */             a(exception, object, v1.a(), paramg);
/*     */           } 
/*     */         } else {
/* 161 */           paraml.j();
/*     */         } 
/* 163 */         i++; continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 167 */     if (!this.m && paramg.a(i.e)) {
/* 168 */       paramg.a(a(), "Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[] {
/*     */             
/* 170 */             Integer.valueOf(m)
/*     */           });
/*     */     }
/*     */     
/* 174 */     while (paraml.g() != o.e) {
/* 175 */       paraml.j();
/*     */     }
/* 177 */     return b(paramg, object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, Object paramObject) {
/* 185 */     return this.t.a(paraml, paramg, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg) {
/* 192 */     return w(paraml, paramg);
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
/*     */   private Object v(l paraml, g paramg) {
/* 211 */     if (this.f) {
/* 212 */       return g(paraml, paramg);
/*     */     }
/* 214 */     Object object = this.b.a(paramg);
/* 215 */     if (this.i != null) {
/* 216 */       a(paramg, object);
/*     */     }
/* 218 */     Class clazz = this.n ? paramg.d() : null;
/* 219 */     v[] arrayOfV = this.u;
/* 220 */     int i = 0;
/* 221 */     int m = arrayOfV.length;
/*     */     while (true) {
/* 223 */       if (paraml.g() == o.e) {
/* 224 */         return object;
/*     */       }
/* 226 */       if (i != m) {
/*     */ 
/*     */         
/* 229 */         v v1 = arrayOfV[i];
/* 230 */         i++;
/* 231 */         if (v1 != null && (
/* 232 */           clazz == null || v1.a(clazz))) {
/*     */           try {
/* 234 */             v1.b(paraml, paramg, object);
/* 235 */           } catch (Exception exception) {
/* 236 */             a(exception, object, v1.a(), paramg);
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 242 */         paraml.j(); continue;
/*     */       }  break;
/*     */     } 
/* 245 */     if (!this.m && paramg.a(i.e)) {
/* 246 */       paramg.a((k)this, o.e, "Unexpected JSON value(s); expected at most %d properties (in JSON Array)", new Object[] {
/*     */             
/* 248 */             Integer.valueOf(m)
/*     */           });
/*     */     }
/*     */     
/* 252 */     while (paraml.g() != o.e) {
/* 253 */       paraml.j();
/*     */     }
/* 255 */     return object;
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
/*     */   protected final Object c(l paraml, g paramg) {
/*     */     v v1;
/* 272 */     y y = (v1 = this.e).a(paraml, paramg, this.q);
/*     */     
/*     */     v[] arrayOfV;
/* 275 */     int i = (arrayOfV = this.u).length;
/* 276 */     Class clazz = this.n ? paramg.d() : null;
/* 277 */     byte b = 0;
/* 278 */     Object object = null;
/*     */     
/* 280 */     for (; paraml.g() != o.e; b++) {
/*     */       v v2;
/* 282 */       if ((v2 = (v)((b < i) ? arrayOfV[b] : null)) == null) {
/* 283 */         paraml.j();
/*     */       
/*     */       }
/* 286 */       else if (clazz != null && !v2.a(clazz)) {
/* 287 */         paraml.j();
/*     */ 
/*     */       
/*     */       }
/* 291 */       else if (object != null) {
/*     */         try {
/* 293 */           object = v2.b(paraml, paramg, object);
/* 294 */         } catch (Exception exception) {
/* 295 */           a(exception, object, v2.a(), paramg);
/*     */         } 
/*     */       } else {
/*     */         
/* 299 */         String str = v2.a();
/*     */         
/* 301 */         v v3 = v1.a(str);
/*     */         
/* 303 */         if (!y.a(str) || v3 != null)
/*     */         {
/*     */           
/* 306 */           if (v3 != null) {
/*     */             
/* 308 */             if (y.a(v3, v3.a(paraml, paramg))) {
/*     */               try {
/* 310 */                 object = v1.a(paramg, y);
/* 311 */               } catch (Exception exception) {
/* 312 */                 a(exception, this.a.b(), str, paramg);
/*     */               } 
/*     */ 
/*     */               
/* 316 */               if (object.getClass() != this.a.b())
/*     */               {
/*     */ 
/*     */ 
/*     */                 
/* 321 */                 return paramg.a(this.a, String.format("Cannot support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type %s, actual type %s", new Object[] {
/*     */                         
/* 323 */                         i.b(this.a), object
/* 324 */                         .getClass().getName()
/*     */                       }));
/*     */               }
/*     */             } 
/*     */           } else {
/*     */             
/* 330 */             y.b((v)exception, exception.a(paraml, paramg));
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 334 */     if (object == null) {
/*     */       try {
/* 336 */         object = v1.a(paramg, y);
/* 337 */       } catch (Exception exception) {
/* 338 */         return a(exception, paramg);
/*     */       } 
/*     */     }
/* 341 */     return object;
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
/*     */   private Object w(l paraml, g paramg) {
/* 354 */     String str = "Cannot deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array";
/*     */     
/* 356 */     return paramg.a(e(paramg), paraml.k(), paraml, str, new Object[] { this.a.b().getName(), paraml.k() });
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */