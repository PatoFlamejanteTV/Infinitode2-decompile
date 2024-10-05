/*     */ package com.a.a.c.l;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.i;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.TypeVariable;
/*     */ import java.util.AbstractList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public final class n implements Serializable {
/*  17 */   private static final String[] a = new String[0];
/*     */   
/*  19 */   private static final j[] b = new j[0];
/*     */   
/*  21 */   private static final n c = new n(a, b, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String[] d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final j[] e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String[] f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private n(String[] paramArrayOfString1, j[] paramArrayOfj, String[] paramArrayOfString2) {
/*  54 */     this.d = (paramArrayOfString1 == null) ? a : paramArrayOfString1;
/*  55 */     this.e = (paramArrayOfj == null) ? b : paramArrayOfj;
/*  56 */     if (this.d.length != this.e.length) {
/*  57 */       throw new IllegalArgumentException("Mismatching names (" + this.d.length + "), types (" + this.e.length + ")");
/*     */     }
/*  59 */     int i = 1; byte b; int k;
/*  60 */     for (b = 0, k = this.e.length; b < k; b++) {
/*  61 */       i += this.e[b].hashCode();
/*     */     }
/*  63 */     this.f = paramArrayOfString2;
/*  64 */     this.g = i;
/*     */   }
/*     */   
/*     */   public static n a() {
/*  68 */     return c;
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
/*     */   public static n a(Class<?> paramClass, List<j> paramList) {
/*  86 */     j[] arrayOfJ = (paramList == null || paramList.isEmpty()) ? b : paramList.<j>toArray(b);
/*  87 */     return a(paramClass, arrayOfJ);
/*     */   }
/*     */   
/*     */   public static n a(Class<?> paramClass, j[] paramArrayOfj) {
/*     */     String[] arrayOfString;
/*  92 */     if (paramArrayOfj == null)
/*  93 */     { paramArrayOfj = b; }
/*  94 */     else { switch (paramArrayOfj.length) {
/*     */         case 1:
/*  96 */           return a(paramClass, paramArrayOfj[0]);
/*     */         case 2:
/*  98 */           return a(paramClass, paramArrayOfj[0], paramArrayOfj[1]);
/*     */       }  }
/*     */     
/*     */     TypeVariable[] arrayOfTypeVariable;
/* 102 */     if ((arrayOfTypeVariable = (TypeVariable[])paramClass.getTypeParameters()) == null || arrayOfTypeVariable.length == 0) {
/* 103 */       arrayOfString = a;
/*     */     } else {
/*     */       int i;
/* 106 */       arrayOfString = new String[i = arrayOfTypeVariable.length];
/* 107 */       for (byte b = 0; b < i; b++) {
/* 108 */         arrayOfString[b] = arrayOfTypeVariable[b].getName();
/*     */       }
/*     */     } 
/*     */     
/* 112 */     if (arrayOfString.length != paramArrayOfj.length) {
/* 113 */       throw new IllegalArgumentException("Cannot create TypeBindings for class " + paramClass.getName() + " with " + paramArrayOfj.length + " type parameter" + ((paramArrayOfj.length == 1) ? "" : "s") + ": class expects " + arrayOfString.length);
/*     */     }
/*     */ 
/*     */     
/* 117 */     return new n(arrayOfString, paramArrayOfj, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static n a(Class<?> paramClass, j paramj) {
/*     */     TypeVariable[] arrayOfTypeVariable;
/*     */     boolean bool;
/* 125 */     if ((bool = ((arrayOfTypeVariable = (TypeVariable[])b.a(paramClass)) == null) ? false : arrayOfTypeVariable.length) != true) {
/* 126 */       throw new IllegalArgumentException("Cannot create TypeBindings for class " + paramClass.getName() + " with 1 type parameter: class expects " + bool);
/*     */     }
/*     */     
/* 129 */     return new n(new String[] { arrayOfTypeVariable[0].getName() }, new j[] { paramj }, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static n a(Class<?> paramClass, j paramj1, j paramj2) {
/*     */     TypeVariable[] arrayOfTypeVariable;
/*     */     boolean bool;
/* 138 */     if ((bool = ((arrayOfTypeVariable = (TypeVariable[])b.b(paramClass)) == null) ? false : arrayOfTypeVariable.length) != 2) {
/* 139 */       throw new IllegalArgumentException("Cannot create TypeBindings for class " + paramClass.getName() + " with 2 type parameters: class expects " + bool);
/*     */     }
/*     */     
/* 142 */     return new n(new String[] { arrayOfTypeVariable[0].getName(), arrayOfTypeVariable[1].getName() }, new j[] { paramj1, paramj2 }, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static n a(List<String> paramList, List<j> paramList1) {
/* 151 */     if (paramList.isEmpty() || paramList1.isEmpty()) {
/* 152 */       return c;
/*     */     }
/* 154 */     return new n(paramList.<String>toArray(a), paramList1.<j>toArray(b), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static n b(Class<?> paramClass, j paramj) {
/*     */     TypeVariable[] arrayOfTypeVariable;
/*     */     boolean bool;
/* 166 */     if (!(bool = ((arrayOfTypeVariable = (TypeVariable[])paramClass.getTypeParameters()) == null) ? false : arrayOfTypeVariable.length)) {
/* 167 */       return c;
/*     */     }
/* 169 */     if (bool != true) {
/* 170 */       throw new IllegalArgumentException("Cannot create TypeBindings for class " + paramClass.getName() + " with 1 type parameter: class expects " + bool);
/*     */     }
/*     */     
/* 173 */     return new n(new String[] { arrayOfTypeVariable[0].getName() }, new j[] { paramj }, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static n b(Class<?> paramClass, j[] paramArrayOfj) {
/*     */     TypeVariable[] arrayOfTypeVariable;
/* 185 */     if ((arrayOfTypeVariable = (TypeVariable[])paramClass.getTypeParameters()) == null || arrayOfTypeVariable.length == 0) {
/* 186 */       return c;
/*     */     }
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 192 */     String[] arrayOfString = new String[i = arrayOfTypeVariable.length];
/* 193 */     for (byte b = 0; b < i; b++) {
/* 194 */       arrayOfString[b] = arrayOfTypeVariable[b].getName();
/*     */     }
/*     */     
/* 197 */     if (i != 2) {
/* 198 */       throw new IllegalArgumentException("Cannot create TypeBindings for class " + paramClass.getName() + " with 2" + " type parameters" + ": class expects " + i);
/*     */     }
/*     */ 
/*     */     
/* 202 */     return new n(arrayOfString, paramArrayOfj, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final n a(String paramString) {
/*     */     byte b;
/*     */     String[] arrayOfString;
/* 215 */     (arrayOfString = !(b = (this.f == null) ? 0 : this.f.length) ? new String[1] : Arrays.<String>copyOf(this.f, b + 1))[b] = paramString;
/* 216 */     return new n(this.d, this.e, arrayOfString);
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
/*     */   public final j b(String paramString) {
/*     */     byte b;
/*     */     int i;
/* 230 */     for (b = 0, i = this.d.length; b < i; j1++) {
/* 231 */       j j1; if (paramString.equals(this.d[b])) {
/*     */         j j2; k k;
/* 233 */         if (j2 = this.e[b] instanceof k && (
/*     */ 
/*     */           
/* 236 */           j1 = (k = (k)j2).H()) != null) {
/* 237 */           j2 = j1;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 250 */         return j2;
/*     */       } 
/*     */     } 
/* 253 */     return null;
/*     */   }
/*     */   
/*     */   public final boolean b() {
/* 257 */     return (this.e.length == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int c() {
/* 264 */     return this.e.length;
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
/*     */   public final j a(int paramInt) {
/* 277 */     if (paramInt < 0 || paramInt >= this.e.length) {
/* 278 */       return null;
/*     */     }
/* 280 */     return this.e[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<j> d() {
/* 288 */     if (this.e.length == 0) {
/* 289 */       return Collections.emptyList();
/*     */     }
/* 291 */     return Arrays.asList(this.e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c(String paramString) {
/* 298 */     if (this.f != null) {
/* 299 */       for (int i = this.f.length; --i >= 0;) {
/* 300 */         if (paramString.equals(this.f[i])) {
/* 301 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/* 305 */     return false;
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
/*     */   public final Object a(Class<?> paramClass) {
/* 317 */     return new a(paramClass, this.e, this.g);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 328 */     if (this.e.length == 0) {
/* 329 */       return "<>";
/*     */     }
/*     */     StringBuilder stringBuilder;
/* 332 */     (stringBuilder = new StringBuilder()).append('<'); byte b; int i;
/* 333 */     for (b = 0, i = this.e.length; b < i; b++) {
/* 334 */       if (b > 0) {
/* 335 */         stringBuilder.append(',');
/*     */       }
/*     */       
/* 338 */       String str = this.e[b].D();
/* 339 */       stringBuilder.append(str);
/*     */     } 
/* 341 */     stringBuilder.append('>');
/* 342 */     return stringBuilder.toString();
/*     */   }
/*     */   public final int hashCode() {
/* 345 */     return this.g;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 349 */     if (paramObject == this) return true; 
/* 350 */     if (!i.a(paramObject, getClass())) {
/* 351 */       return false;
/*     */     }
/* 353 */     paramObject = paramObject;
/*     */     int i;
/* 355 */     if ((i = this.e.length) != paramObject.c()) {
/* 356 */       return false;
/*     */     }
/* 358 */     paramObject = ((n)paramObject).e;
/* 359 */     for (byte b = 0; b < i; b++) {
/* 360 */       if (!paramObject[b].equals(this.e[b])) {
/* 361 */         return false;
/*     */       }
/*     */     } 
/* 364 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final j[] e() {
/* 374 */     return this.e;
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
/*     */   static class b
/*     */   {
/* 395 */     private static final TypeVariable<?>[] a = (TypeVariable<?>[])AbstractList.class.getTypeParameters();
/* 396 */     private static final TypeVariable<?>[] b = (TypeVariable<?>[])Collection.class.getTypeParameters();
/* 397 */     private static final TypeVariable<?>[] c = (TypeVariable<?>[])Iterable.class.getTypeParameters();
/* 398 */     private static final TypeVariable<?>[] d = (TypeVariable<?>[])List.class.getTypeParameters();
/* 399 */     private static final TypeVariable<?>[] e = (TypeVariable<?>[])ArrayList.class.getTypeParameters();
/*     */     
/* 401 */     private static final TypeVariable<?>[] f = (TypeVariable<?>[])Map.class.getTypeParameters();
/* 402 */     private static final TypeVariable<?>[] g = (TypeVariable<?>[])HashMap.class.getTypeParameters();
/* 403 */     private static final TypeVariable<?>[] h = (TypeVariable<?>[])LinkedHashMap.class.getTypeParameters();
/*     */ 
/*     */     
/*     */     public static TypeVariable<?>[] a(Class<?> param1Class) {
/* 407 */       if (param1Class == Collection.class) {
/* 408 */         return b;
/*     */       }
/* 410 */       if (param1Class == List.class) {
/* 411 */         return d;
/*     */       }
/* 413 */       if (param1Class == ArrayList.class) {
/* 414 */         return e;
/*     */       }
/* 416 */       if (param1Class == AbstractList.class) {
/* 417 */         return a;
/*     */       }
/* 419 */       if (param1Class == Iterable.class) {
/* 420 */         return c;
/*     */       }
/* 422 */       return (TypeVariable<?>[])param1Class.getTypeParameters();
/*     */     }
/*     */ 
/*     */     
/*     */     public static TypeVariable<?>[] b(Class<?> param1Class) {
/* 427 */       if (param1Class == Map.class) {
/* 428 */         return f;
/*     */       }
/* 430 */       if (param1Class == HashMap.class) {
/* 431 */         return g;
/*     */       }
/* 433 */       if (param1Class == LinkedHashMap.class) {
/* 434 */         return h;
/*     */       }
/* 436 */       return (TypeVariable<?>[])param1Class.getTypeParameters();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static final class a
/*     */   {
/*     */     private final Class<?> a;
/*     */     
/*     */     private final j[] b;
/*     */     
/*     */     private final int c;
/*     */ 
/*     */     
/*     */     public a(Class<?> param1Class, j[] param1ArrayOfj, int param1Int) {
/* 451 */       this.a = param1Class;
/* 452 */       this.b = param1ArrayOfj;
/* 453 */       this.c = param1Int;
/*     */     }
/*     */     
/*     */     public final int hashCode() {
/* 457 */       return this.c;
/*     */     }
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 461 */       if (param1Object == this) return true; 
/* 462 */       if (param1Object == null) return false; 
/* 463 */       if (param1Object.getClass() != getClass()) return false; 
/* 464 */       param1Object = param1Object;
/*     */ 
/*     */       
/* 467 */       param1Object = ((a)param1Object).b;
/*     */       
/*     */       int i;
/* 470 */       if (this.c == ((a)param1Object).c && this.a == ((a)param1Object).a && (i = this.b.length) == param1Object.length) {
/* 471 */         for (byte b = 0; b < i; b++) {
/* 472 */           if (!this.b[b].equals(param1Object[b])) {
/* 473 */             return false;
/*     */           }
/*     */         } 
/* 476 */         return true;
/*     */       } 
/*     */       
/* 479 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 484 */       return this.a.getName() + "<>";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */