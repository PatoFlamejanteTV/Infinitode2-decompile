/*     */ package com.a.a.c.m;
/*     */ 
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.q;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class l
/*     */   implements Serializable
/*     */ {
/*     */   private Class<Enum<?>> a;
/*     */   private Enum<?>[] b;
/*     */   private HashMap<String, Enum<?>> c;
/*     */   private Enum<?> d;
/*     */   private boolean e;
/*     */   private boolean f;
/*     */   
/*     */   private l(Class<Enum<?>> paramClass, Enum<?>[] paramArrayOfEnum, HashMap<String, Enum<?>> paramHashMap, Enum<?> paramEnum, boolean paramBoolean1, boolean paramBoolean2) {
/*  52 */     this.a = paramClass;
/*  53 */     this.b = paramArrayOfEnum;
/*  54 */     this.c = paramHashMap;
/*  55 */     this.d = paramEnum;
/*  56 */     this.e = paramBoolean1;
/*  57 */     this.f = paramBoolean2;
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
/*     */   public static l a(f paramf, Class<?> paramClass) {
/*  78 */     return a(paramClass, paramf.j(), paramf
/*  79 */         .a(q.w));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static l a(Class<?> paramClass, a parama, boolean paramBoolean) {
/*  88 */     Class<Enum<?>> clazz = a(paramClass);
/*  89 */     Enum[] arrayOfEnum = (Enum[])b(paramClass);
/*     */     
/*  91 */     String arrayOfString[], arrayOfString1[][] = new String[(arrayOfString = parama.a(clazz, arrayOfEnum, new String[arrayOfEnum.length])).length][];
/*  92 */     parama.a(clazz, arrayOfEnum, arrayOfString1);
/*  93 */     HashMap<Object, Object> hashMap = new HashMap<>(); byte b; int i;
/*  94 */     for (b = 0, i = arrayOfEnum.length; b < i; b++) {
/*  95 */       Enum enum_ = arrayOfEnum[b];
/*     */       String str;
/*  97 */       if ((str = arrayOfString[b]) == null) {
/*  98 */         str = enum_.name();
/*     */       }
/* 100 */       hashMap.put(str, enum_);
/*     */       String[] arrayOfString2;
/* 102 */       if ((arrayOfString2 = arrayOfString1[b]) != null) {
/* 103 */         int j; byte b1; for (j = (arrayOfString2 = arrayOfString2).length, b1 = 0; b1 < j; ) { String str1 = arrayOfString2[b1];
/*     */ 
/*     */           
/* 106 */           if (!hashMap.containsKey(str1))
/* 107 */             hashMap.put(str1, enum_); 
/*     */           b1++; }
/*     */       
/*     */       } 
/*     */     } 
/* 112 */     return new l(clazz, (Enum<?>[])arrayOfEnum, (HashMap)hashMap, 
/* 113 */         a(parama, clazz), paramBoolean, false);
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
/*     */   public static l b(f paramf, Class<?> paramClass) {
/* 125 */     return b(paramClass, paramf.j(), paramf
/* 126 */         .a(q.w));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static l b(Class<?> paramClass, a parama, boolean paramBoolean) {
/* 135 */     Class<Enum<?>> clazz = a(paramClass);
/* 136 */     Enum[] arrayOfEnum = (Enum[])b(paramClass);
/* 137 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 138 */     String[][] arrayOfString = new String[arrayOfEnum.length][];
/* 139 */     if (parama != null) {
/* 140 */       parama.a(clazz, arrayOfEnum, arrayOfString);
/*     */     }
/*     */ 
/*     */     
/* 144 */     for (int i = arrayOfEnum.length; --i >= 0; ) {
/* 145 */       Enum enum_ = arrayOfEnum[i];
/* 146 */       hashMap.put(enum_.toString(), enum_);
/*     */       String[] arrayOfString1;
/* 148 */       if ((arrayOfString1 = arrayOfString[i]) != null) {
/* 149 */         int j; byte b; for (j = (arrayOfString1 = arrayOfString1).length, b = 0; b < j; ) { String str = arrayOfString1[b];
/*     */ 
/*     */           
/* 152 */           if (!hashMap.containsKey(str))
/* 153 */             hashMap.put(str, enum_); 
/*     */           b++; }
/*     */       
/*     */       } 
/*     */     } 
/* 158 */     return new l(clazz, (Enum<?>[])arrayOfEnum, (HashMap)hashMap, 
/* 159 */         a(parama, clazz), paramBoolean, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(f paramf, Class<?> paramClass, j paramj) {
/* 170 */     return a(paramClass, paramj, paramf.j(), paramf
/* 171 */         .a(q.w));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static l a(Class<?> paramClass, j paramj, a parama, boolean paramBoolean) {
/* 180 */     Class<Enum<?>> clazz = a(paramClass);
/* 181 */     Enum[] arrayOfEnum = (Enum[])b(paramClass);
/* 182 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 184 */     for (int i = arrayOfEnum.length; --i >= 0; ) {
/* 185 */       Enum enum_ = arrayOfEnum[i];
/*     */       try {
/*     */         Object object;
/* 188 */         if ((object = paramj.b(enum_)) != null) {
/* 189 */           hashMap.put(object.toString(), enum_);
/*     */         }
/* 191 */       } catch (Exception exception) {
/* 192 */         throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + enum_ + ": " + exception.getMessage());
/*     */       } 
/*     */     } 
/* 195 */     return new l(clazz, (Enum<?>[])arrayOfEnum, (HashMap)hashMap, 
/* 196 */         a(parama, clazz), paramBoolean, 
/*     */         
/* 198 */         c(paramj.d()));
/*     */   }
/*     */ 
/*     */   
/*     */   public final j a() {
/* 203 */     return j.a(this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Class<Enum<?>> a(Class<?> paramClass) {
/* 208 */     return (Class)paramClass;
/*     */   }
/*     */   
/*     */   private static Enum<?>[] b(Class<?> paramClass) {
/*     */     Enum[] arrayOfEnum;
/* 213 */     if ((arrayOfEnum = (Enum[])a(paramClass).getEnumConstants()) == null) {
/* 214 */       throw new IllegalArgumentException("No enum constants for class " + paramClass.getName());
/*     */     }
/* 216 */     return (Enum<?>[])arrayOfEnum;
/*     */   }
/*     */   
/*     */   private static Enum<?> a(a parama, Class<?> paramClass) {
/* 220 */     return (parama != null) ? parama.a(a(paramClass)) : null;
/*     */   }
/*     */   
/*     */   private static boolean c(Class<?> paramClass) {
/* 224 */     if (paramClass.isPrimitive()) {
/* 225 */       paramClass = i.i(paramClass);
/*     */     }
/* 227 */     return (paramClass == Long.class || paramClass == Integer.class || paramClass == Short.class || paramClass == Byte.class);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Enum<?> a(String paramString) {
/*     */     Enum<?> enum_;
/* 319 */     if ((enum_ = this.c.get(paramString)) == null && 
/* 320 */       this.e) {
/* 321 */       return b(paramString);
/*     */     }
/*     */     
/* 324 */     return enum_;
/*     */   }
/*     */ 
/*     */   
/*     */   private Enum<?> b(String paramString) {
/* 329 */     for (Map.Entry<String, Enum<?>> entry : this.c.entrySet()) {
/* 330 */       if (paramString.equalsIgnoreCase((String)entry.getKey())) {
/* 331 */         return (Enum)entry.getValue();
/*     */       }
/*     */     } 
/* 334 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Enum<?> b() {
/* 345 */     return this.d;
/*     */   }
/*     */   
/*     */   public final Enum<?>[] c() {
/* 349 */     return this.b;
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
/*     */   public final Collection<String> d() {
/* 364 */     return this.c.keySet();
/*     */   }
/*     */   public final Class<Enum<?>> e() {
/* 367 */     return this.a;
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
/*     */   public final boolean f() {
/* 380 */     return this.f;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */