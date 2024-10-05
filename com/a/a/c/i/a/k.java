/*     */ package com.a.a.c.i.a;
/*     */ 
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.d;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.c;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.m.i;
/*     */ import java.util.EnumMap;
/*     */ import java.util.EnumSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class k
/*     */   extends s
/*     */ {
/*     */   private c c;
/*     */   
/*     */   public k(j paramj, o paramo, c paramc) {
/*  38 */     super(paramj, paramo);
/*  39 */     this.c = paramc;
/*     */   }
/*     */ 
/*     */   
/*     */   public static k a(j paramj, q<?> paramq, c paramc) {
/*  44 */     return new k(paramj, paramq.p(), paramc);
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
/*     */   public String a(Object paramObject) {
/*  56 */     return a(paramObject, paramObject.getClass(), this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String a(Object paramObject, Class<?> paramClass) {
/*  61 */     return a(paramObject, paramClass, this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final j a(d paramd, String paramString) {
/*  66 */     return a(paramString, paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected j a(String paramString, d paramd) {
/*     */     j j;
/*  73 */     if ((j = paramd.a(this.b, paramString, this.c)) == null && 
/*  74 */       paramd instanceof g)
/*     */     {
/*  76 */       return ((g)paramd).a(this.b, paramString, this, "no such class found");
/*     */     }
/*     */ 
/*     */     
/*  80 */     return j;
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
/*     */   private String a(Object paramObject, Class<?> paramClass, o paramo) {
/*  92 */     if (i.k(paramClass))
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  97 */       if (!paramClass.isEnum())
/*     */       {
/*  99 */         paramClass = paramClass.getSuperclass();
/*     */       }
/*     */     }
/*     */     String str;
/* 103 */     if ((str = paramClass.getName()).startsWith("java.util.")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 110 */       if (paramObject instanceof EnumSet) {
/* 111 */         paramObject = i.a((EnumSet)paramObject);
/*     */         
/* 113 */         str = paramo.a(EnumSet.class, (Class)paramObject).G();
/* 114 */       } else if (paramObject instanceof EnumMap) {
/* 115 */         paramObject = i.a((EnumMap)paramObject);
/* 116 */         paramClass = Object.class;
/*     */         
/* 118 */         str = paramo.a(EnumMap.class, (Class)paramObject, paramClass).G();
/*     */       }
/*     */     
/*     */     }
/* 122 */     else if (str.indexOf('$') >= 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 131 */       if ((paramObject = i.b(paramClass)) != null)
/*     */       {
/*     */ 
/*     */         
/* 135 */         if (i.b(paramClass = this.b.b()) == null)
/*     */         {
/*     */           
/* 138 */           str = (paramClass = this.b.b()).getName();
/*     */         }
/*     */       }
/*     */     } 
/* 142 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String b() {
/* 147 */     return "class name used as type id";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */