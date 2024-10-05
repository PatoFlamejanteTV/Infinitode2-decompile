/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c.d;
/*     */ import com.a.a.c.c.f;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.r;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class an
/*     */   extends d
/*     */ {
/*     */   @Deprecated
/*     */   private an(d paramd) {
/*  34 */     super((f)paramd);
/*     */     
/*  36 */     this.g = false;
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
/*     */   public static an a(d paramd) {
/*  50 */     return new an(paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private an(d paramd, r paramr) {
/*  58 */     super((f)paramd, paramr);
/*     */   }
/*     */ 
/*     */   
/*     */   public final k<Object> a(r paramr) {
/*  63 */     if (getClass() != an.class) {
/*  64 */       return (k<Object>)this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  69 */     return (k<Object>)new an(this, paramr);
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
/*     */   public final Object b(l paraml, g paramg) {
/*  82 */     if (this.e != null) {
/*  83 */       return c(paraml, paramg);
/*     */     }
/*  85 */     if (this.c != null) {
/*  86 */       return this.b.a(paramg, this.c
/*  87 */           .a(paraml, paramg));
/*     */     }
/*  89 */     if (this.a.d()) {
/*  90 */       return paramg.a(a(), i(), paraml, "abstract type (need to add/enable type information?)", new Object[0]);
/*     */     }
/*     */     
/*  93 */     boolean bool1 = this.b.e();
/*  94 */     boolean bool2 = this.b.l();
/*     */     
/*  96 */     if (!bool1 && !bool2) {
/*  97 */       return paramg.a(a(), i(), paraml, "Throwable needs a default constructor, a single-String-arg constructor; or explicit @JsonCreator", new Object[0]);
/*     */     }
/*     */ 
/*     */     
/* 101 */     Throwable throwable = null;
/* 102 */     Object[] arrayOfObject = null;
/* 103 */     Throwable[] arrayOfThrowable = null;
/* 104 */     byte b = 0;
/*     */     
/* 106 */     for (; !paraml.a(o.c); paraml.g()) {
/* 107 */       String str = paraml.v();
/* 108 */       v v = this.h.a(str);
/* 109 */       paraml.g();
/*     */       
/* 111 */       if (v != null) {
/* 112 */         if (throwable != null) {
/* 113 */           v.a(paraml, paramg, throwable);
/*     */         }
/*     */         else {
/*     */           
/* 117 */           if (arrayOfObject == null) {
/*     */             int i;
/* 119 */             arrayOfObject = new Object[(i = this.h.b()) + i];
/*     */           } 
/* 121 */           arrayOfObject[b++] = v;
/* 122 */           arrayOfObject[b++] = v.a(paraml, paramg);
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 131 */       else if ("message".equalsIgnoreCase(str) && 
/* 132 */         bool1) {
/* 133 */         throwable = (Throwable)this.b.a(paramg, paraml.R());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 140 */       else if (this.k != null && this.k.contains(str)) {
/* 141 */         paraml.j();
/*     */       
/*     */       }
/* 144 */       else if ("suppressed".equalsIgnoreCase(str)) {
/* 145 */         arrayOfThrowable = (Throwable[])paramg.b(paraml, Throwable[].class);
/*     */       
/*     */       }
/* 148 */       else if ("localizedMessage".equalsIgnoreCase(str)) {
/* 149 */         paraml.j();
/*     */       
/*     */       }
/* 152 */       else if (this.j != null) {
/* 153 */         this.j.a(paraml, paramg, throwable, str);
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */ 
/*     */         
/* 161 */         b(paraml, paramg, throwable, str);
/*     */       } 
/*     */     } 
/* 164 */     if (throwable == null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       if (bool1) {
/* 172 */         throwable = (Throwable)this.b.a(paramg, null);
/*     */       } else {
/* 174 */         throwable = (Throwable)this.b.a(paramg);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 179 */     if (arrayOfObject != null) {
/* 180 */       for (byte b1 = 0, b2 = b; b1 < b2; b1 += 2) {
/*     */         v v;
/* 182 */         (v = (v)arrayOfObject[b1]).a(throwable, arrayOfObject[b1 + 1]);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 187 */     if (arrayOfThrowable != null) {
/* 188 */       Throwable[] arrayOfThrowable1; int i; byte b1; for (i = (arrayOfThrowable1 = arrayOfThrowable).length, b1 = 0; b1 < i; ) { Throwable throwable1 = arrayOfThrowable1[b1];
/* 189 */         throwable.addSuppressed(throwable1);
/*     */         b1++; }
/*     */     
/*     */     } 
/* 193 */     return throwable;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\an.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */