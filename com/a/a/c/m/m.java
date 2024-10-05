/*     */ package com.a.a.c.m;
/*     */ 
/*     */ import com.a.a.b.r;
/*     */ import com.a.a.c.b.q;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class m
/*     */   implements Serializable
/*     */ {
/*     */   private final Class<Enum<?>> a;
/*     */   private final r[] b;
/*     */   
/*     */   private m(Class<Enum<?>> paramClass, r[] paramArrayOfr) {
/*  27 */     this.a = paramClass;
/*  28 */     paramClass.getEnumConstants();
/*  29 */     this.b = paramArrayOfr;
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
/*     */   public static m a(q<?> paramq, Class<Enum<?>> paramClass) {
/*     */     Class<? extends Enum<?>> clazz;
/*     */     Enum[] arrayOfEnum;
/*  48 */     if ((arrayOfEnum = (Enum[])(clazz = i.l(paramClass)).getEnumConstants()) == null) {
/*  49 */       throw new IllegalArgumentException("Cannot determine enum constants for Class " + paramClass.getName());
/*     */     }
/*  51 */     String[] arrayOfString = paramq.j().a(clazz, arrayOfEnum, new String[arrayOfEnum.length]);
/*  52 */     r[] arrayOfR = new r[arrayOfEnum.length]; byte b; int i;
/*  53 */     for (b = 0, i = arrayOfEnum.length; b < i; b++) {
/*  54 */       Enum enum_ = arrayOfEnum[b];
/*     */       String str;
/*  56 */       if ((str = arrayOfString[b]) == null) {
/*  57 */         str = enum_.name();
/*     */       }
/*  59 */       arrayOfR[enum_.ordinal()] = q.a(str);
/*     */     } 
/*  61 */     return a(paramClass, arrayOfR);
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
/*     */   private static m a(Class<Enum<?>> paramClass, r[] paramArrayOfr) {
/*  96 */     return new m(paramClass, paramArrayOfr);
/*     */   }
/*     */   
/*     */   public final r a(Enum<?> paramEnum) {
/* 100 */     return this.b[paramEnum.ordinal()];
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
/*     */   public final Class<Enum<?>> a() {
/* 136 */     return this.a;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */