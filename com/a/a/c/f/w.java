/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.a.e;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.q;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Shape;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class w
/*     */   extends a
/*     */ {
/*     */   private a a;
/*     */   private boolean b;
/*     */   private boolean c;
/*     */   private String d;
/*     */   private String e;
/*     */   private String f;
/*     */   
/*     */   protected w(q<?> paramq, d paramd, String paramString1, String paramString2, String paramString3, a parama) {
/*  66 */     this.b = paramq.a(q.z);
/*  67 */     this.c = paramq.a(q.B);
/*  68 */     this.f = paramString1;
/*  69 */     this.d = paramString2;
/*  70 */     this.e = paramString3;
/*  71 */     this.a = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(k paramk, String paramString) {
/*  77 */     if (this.e != null) {
/*  78 */       Class<?> clazz = paramk.d();
/*  79 */       if ((this.c || clazz == Boolean.class || clazz == boolean.class) && 
/*  80 */         paramString.startsWith(this.e)) {
/*  81 */         if (this.b)
/*  82 */           return b(paramString, 2); 
/*  83 */         return a(paramString, 2);
/*     */       } 
/*     */     } 
/*     */     
/*  87 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String b(k paramk, String paramString) {
/*  93 */     if (this.d != null && paramString.startsWith(this.d)) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  98 */       if ("getCallbacks".equals(paramString)) {
/*  99 */         if (a(paramk)) {
/* 100 */           return null;
/*     */         }
/* 102 */       } else if ("getMetaClass".equals(paramString)) {
/*     */         
/* 104 */         if (b(paramk)) {
/* 105 */           return null;
/*     */         }
/*     */       } 
/* 108 */       if (this.b)
/* 109 */         return b(paramString, this.d.length()); 
/* 110 */       return a(paramString, this.d.length());
/*     */     } 
/* 112 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(String paramString) {
/* 118 */     if (this.f != null && paramString.startsWith(this.f)) {
/* 119 */       if (this.b)
/* 120 */         return b(paramString, this.f.length()); 
/* 121 */       return a(paramString, this.f.length());
/*     */     } 
/* 123 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b(String paramString) {
/* 129 */     return paramString;
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
/*     */   private String a(String paramString, int paramInt) {
/*     */     int i;
/* 148 */     if ((i = paramString.length()) == paramInt) {
/* 149 */       return null;
/*     */     }
/* 151 */     char c1 = paramString.charAt(paramInt);
/*     */ 
/*     */     
/* 154 */     if (this.a != null && 
/* 155 */       !this.a.a()) {
/* 156 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 161 */     char c2 = Character.toLowerCase(c1);
/*     */     
/* 163 */     if (c1 == c2) {
/* 164 */       return paramString.substring(paramInt);
/*     */     }
/*     */     
/*     */     StringBuilder stringBuilder;
/* 168 */     (stringBuilder = new StringBuilder(i - paramInt)).append(c2);
/* 169 */     paramInt++;
/* 170 */     for (; paramInt < i; paramInt++) {
/*     */       
/* 172 */       c2 = Character.toLowerCase(c1 = paramString.charAt(paramInt));
/* 173 */       if (c1 == c2) {
/* 174 */         stringBuilder.append(paramString, paramInt, i);
/*     */         break;
/*     */       } 
/* 177 */       stringBuilder.append(c2);
/*     */     } 
/* 179 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private String b(String paramString, int paramInt) {
/*     */     int i;
/* 185 */     if ((i = paramString.length()) == paramInt) {
/* 186 */       return null;
/*     */     }
/*     */     
/* 189 */     char c1 = paramString.charAt(paramInt);
/*     */ 
/*     */     
/* 192 */     if (this.a != null && 
/* 193 */       !this.a.a()) {
/* 194 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 198 */     char c2 = Character.toLowerCase(c1);
/* 199 */     if (c1 == c2) {
/* 200 */       return paramString.substring(paramInt);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 205 */     if (paramInt + 1 < i && 
/* 206 */       Character.isUpperCase(paramString.charAt(paramInt + 1))) {
/* 207 */       return paramString.substring(paramInt);
/*     */     }
/*     */     
/*     */     StringBuilder stringBuilder;
/* 211 */     (stringBuilder = new StringBuilder(i - paramInt)).append(c2);
/* 212 */     stringBuilder.append(paramString, paramInt + 1, i);
/* 213 */     return stringBuilder.toString();
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
/*     */   private static boolean a(k paramk) {
/*     */     Class<?> clazz;
/* 231 */     if ((clazz = paramk.d()).isArray()) {
/*     */       String str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 239 */       if ((str = (clazz = clazz.getComponentType()).getName()).contains(".cglib")) {
/* 240 */         if (str.startsWith("net.sf.cglib") || str
/*     */           
/* 242 */           .startsWith("org.hibernate.repackage.cglib") || str
/*     */           
/* 244 */           .startsWith("org.springframework.cglib")) return true;  return false;
/*     */       } 
/*     */     } 
/* 247 */     return false;
/*     */   } public static interface a {
/*     */     boolean a(); String b(); k<?> c(); k<?> d(); k<?> e(); k<?> f(); k<?> g(); k<?> h(); k<?> i(); k<?> j(); k<?> k(); x l(); o<?> m(); o<?> n(); o<?> o(); o<?> p(); o<?> q(); o<?> r(); o<?> s(); Rectangle t(); int u(); int v(); Map<Shape, String> w(); a x();
/*     */     boolean y(); }
/*     */   private static boolean b(k paramk) {
/* 252 */     return paramk.d().getName().startsWith("groovy.lang");
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
/*     */   public static class b
/*     */     extends a.a
/*     */     implements Serializable
/*     */   {
/*     */     public b() {
/* 294 */       this("set", "with", "get", "is", null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private String a;
/*     */ 
/*     */     
/*     */     private String b;
/*     */ 
/*     */     
/*     */     private String c;
/*     */ 
/*     */     
/*     */     private String d;
/*     */ 
/*     */     
/*     */     private w.a e;
/*     */ 
/*     */ 
/*     */     
/*     */     private b(String param1String1, String param1String2, String param1String3, String param1String4, w.a param1a) {
/* 316 */       this.a = param1String1;
/* 317 */       this.b = param1String2;
/* 318 */       this.c = param1String3;
/* 319 */       this.d = param1String4;
/* 320 */       this.e = param1a;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final a a(q<?> param1q, d param1d) {
/* 436 */       return new w(param1q, param1d, this.a, this.c, this.d, this.e);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final a b(q<?> param1q, d param1d) {
/*     */       e.a a1;
/*     */       com.a.a.c.a a2;
/* 447 */       String str = ((a1 = (e.a)(((a2 = (com.a.a.c.a)(param1q.f() ? param1q.j() : null)) == null) ? null : a2.h(param1d))) == null) ? this.b : a1.b;
/* 448 */       return new w(param1q, param1d, str, this.c, this.d, this.e);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final a c(q<?> param1q, d param1d) {
/* 456 */       return new w.c(param1q, param1d);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class c
/*     */     extends w
/*     */   {
/*     */     private Set<String> a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public c(q<?> param1q, d param1d) {
/* 532 */       super(param1q, param1d, null, "get", "is", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 538 */       String[] arrayOfString = com.a.a.c.g.a.a(param1d.d());
/*     */       
/* 540 */       this
/*     */         
/* 542 */         .a = (arrayOfString == null) ? Collections.<String>emptySet() : new HashSet<>(Arrays.asList(arrayOfString));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String b(k param1k, String param1String) {
/* 551 */       if (this.a.contains(param1String)) {
/* 552 */         return param1String;
/*     */       }
/*     */       
/* 555 */       return super.b(param1k, param1String);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */