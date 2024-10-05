/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.n;
/*     */ import com.a.a.c.m.r;
/*     */ import com.a.a.c.w;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */   implements Serializable, Iterable<v>
/*     */ {
/*     */   private boolean a;
/*     */   private int b;
/*     */   private int c;
/*     */   private int d;
/*     */   private Object[] e;
/*     */   private final v[] f;
/*     */   private final Map<String, List<w>> g;
/*     */   private final Map<String, String> h;
/*     */   private final Locale i;
/*     */   
/*     */   private c(boolean paramBoolean, Collection<v> paramCollection, Map<String, List<w>> paramMap, Locale paramLocale) {
/*  99 */     this.a = paramBoolean;
/* 100 */     this.f = paramCollection.<v>toArray(new v[paramCollection.size()]);
/* 101 */     this.g = paramMap;
/* 102 */     this.i = paramLocale;
/* 103 */     this.h = a(paramMap, paramBoolean, paramLocale);
/* 104 */     a(paramCollection);
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
/*     */   private c(c paramc, v paramv, int paramInt1, int paramInt2) {
/* 125 */     this.a = paramc.a;
/* 126 */     this.i = paramc.i;
/* 127 */     this.b = paramc.b;
/* 128 */     this.c = paramc.c;
/* 129 */     this.d = paramc.d;
/* 130 */     this.g = paramc.g;
/* 131 */     this.h = paramc.h;
/*     */ 
/*     */     
/* 134 */     this.e = Arrays.copyOf(paramc.e, paramc.e.length);
/* 135 */     this.f = Arrays.<v>copyOf(paramc.f, paramc.f.length);
/* 136 */     this.e[paramInt1] = paramv;
/* 137 */     this.f[paramInt2] = paramv;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private c(c paramc, v paramv, String paramString, int paramInt) {
/* 148 */     this.a = paramc.a;
/* 149 */     this.i = paramc.i;
/* 150 */     this.b = paramc.b;
/* 151 */     this.c = paramc.c;
/* 152 */     this.d = paramc.d;
/* 153 */     this.g = paramc.g;
/* 154 */     this.h = paramc.h;
/*     */ 
/*     */     
/* 157 */     this.e = Arrays.copyOf(paramc.e, paramc.e.length);
/* 158 */     int j = paramc.f.length;
/*     */     
/* 160 */     this.f = Arrays.<v>copyOf(paramc.f, j + 1);
/* 161 */     this.f[j] = paramv;
/*     */     
/* 163 */     int i = this.b + 1;
/* 164 */     j = paramInt << 1;
/*     */ 
/*     */     
/* 167 */     if (this.e[j] != null) {
/*     */       
/* 169 */       j = i + (paramInt >> 1) << 1;
/* 170 */       if (this.e[j] != null) {
/*     */         
/* 172 */         j = (i + (i >> 1) << 1) + this.d;
/* 173 */         this.d += 2;
/* 174 */         if (j >= this.e.length) {
/* 175 */           this.e = Arrays.copyOf(this.e, this.e.length + 4);
/*     */         }
/*     */       } 
/*     */     } 
/* 179 */     this.e[j] = paramString;
/* 180 */     this.e[j + 1] = paramv;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private c(c paramc, boolean paramBoolean) {
/* 188 */     this.a = paramBoolean;
/* 189 */     this.i = paramc.i;
/* 190 */     this.g = paramc.g;
/* 191 */     this.h = paramc.h;
/*     */ 
/*     */     
/* 194 */     this.f = Arrays.<v>copyOf(paramc.f, paramc.f.length);
/* 195 */     a(Arrays.asList(this.f));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final c a(boolean paramBoolean) {
/* 206 */     if (this.a == paramBoolean) {
/* 207 */       return this;
/*     */     }
/* 209 */     return new c(this, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Collection<v> paramCollection) {
/* 214 */     this.c = paramCollection.size();
/*     */ 
/*     */     
/* 217 */     int i = a(this.c);
/* 218 */     this.b = i - 1;
/*     */     
/*     */     int j;
/*     */     
/* 222 */     Object[] arrayOfObject = new Object[j = i + (i >> 1) << 1];
/* 223 */     byte b = 0;
/*     */     
/* 225 */     for (Iterator<v> iterator = paramCollection.iterator(); iterator.hasNext();) {
/*     */       
/* 227 */       if ((v1 = iterator.next()) != null) {
/*     */ 
/*     */ 
/*     */         
/* 231 */         String str = c(v1);
/*     */         
/* 233 */         int k, m = (k = c(str)) << 1;
/*     */ 
/*     */         
/* 236 */         if (arrayOfObject[m] != null) {
/*     */           
/* 238 */           m = i + (k >> 1) << 1;
/* 239 */           if (arrayOfObject[m] != null) {
/*     */             
/* 241 */             m = (i + (i >> 1) << 1) + b;
/* 242 */             b += 2;
/* 243 */             if (m >= arrayOfObject.length) {
/* 244 */               arrayOfObject = Arrays.copyOf(arrayOfObject, arrayOfObject.length + 4);
/*     */             }
/*     */           } 
/*     */         } 
/* 248 */         arrayOfObject[m] = str;
/* 249 */         arrayOfObject[m + 1] = v1;
/*     */       } 
/*     */     } 
/*     */     
/* 253 */     this.e = arrayOfObject;
/* 254 */     this.d = b;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final int a(int paramInt) {
/* 259 */     if (paramInt <= 5) {
/* 260 */       return 8;
/*     */     }
/* 262 */     if (paramInt <= 12) {
/* 263 */       return 16;
/*     */     }
/* 265 */     paramInt += paramInt >> 2;
/* 266 */     int i = 32;
/* 267 */     while (i < paramInt) {
/* 268 */       i += i;
/*     */     }
/* 270 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static c a(q<?> paramq, Collection<v> paramCollection, Map<String, List<w>> paramMap, boolean paramBoolean) {
/* 280 */     return new c(paramBoolean, paramCollection, paramMap, paramq
/*     */         
/* 282 */         .t());
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
/*     */   public final c a(v paramv) {
/* 317 */     String str = c(paramv);
/*     */     int i, j;
/* 319 */     for (i = 1, j = this.e.length; i < j; i += 2) {
/*     */       v v1;
/* 321 */       if ((v1 = (v)this.e[i]) != null && v1.a().equals(str)) {
/* 322 */         return new c(this, paramv, i, d(v1));
/*     */       }
/*     */     } 
/*     */     
/* 326 */     i = c(str);
/*     */     
/* 328 */     return new c(this, paramv, str, i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final c a() {
/* 334 */     byte b1 = 0; byte b2; int i;
/* 335 */     for (b2 = 1, i = this.e.length; b2 < i; b2 += 2) {
/*     */       v v1;
/* 337 */       if ((v1 = (v)this.e[b2]) != null) {
/* 338 */         v1.a(b1++);
/*     */       }
/*     */     } 
/* 341 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final c a(r paramr) {
/* 350 */     if (paramr == null || paramr == r.a) {
/* 351 */       return this;
/*     */     }
/*     */     
/* 354 */     int i = this.f.length;
/* 355 */     ArrayList<v> arrayList = new ArrayList(i);
/*     */     
/* 357 */     for (byte b = 0; b < i; b++) {
/*     */       v v1;
/*     */ 
/*     */       
/* 361 */       if ((v1 = this.f[b]) == null) {
/* 362 */         arrayList.add(v1);
/*     */       } else {
/*     */         
/* 365 */         arrayList.add(a(v1, paramr));
/*     */       } 
/*     */     } 
/*     */     
/* 369 */     return new c(this.a, arrayList, this.g, this.i);
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
/*     */   public final c a(Collection<String> paramCollection1, Collection<String> paramCollection2) {
/* 400 */     if ((paramCollection1 == null || paramCollection1.isEmpty()) && paramCollection2 == null) {
/* 401 */       return this;
/*     */     }
/* 403 */     int i = this.f.length;
/* 404 */     ArrayList<v> arrayList = new ArrayList(i);
/*     */     
/* 406 */     for (byte b = 0; b < i; b++) {
/*     */       v v1;
/*     */ 
/*     */ 
/*     */       
/* 411 */       if ((v1 = this.f[b]) != null && 
/* 412 */         !n.a(v1.a(), paramCollection1, paramCollection2)) {
/* 413 */         arrayList.add(v1);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 418 */     return new c(this.a, arrayList, this.g, this.i);
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
/*     */   public final void a(v paramv1, v paramv2) {
/* 430 */     byte b = 1;
/* 431 */     int i = this.e.length;
/*     */     
/* 433 */     for (;; b += 2) {
/* 434 */       if (b >= i) {
/* 435 */         throw new NoSuchElementException("No entry '" + paramv1.a() + "' found, can't replace");
/*     */       }
/* 437 */       if (this.e[b] == paramv1) {
/* 438 */         this.e[b] = paramv2;
/*     */         break;
/*     */       } 
/*     */     } 
/* 442 */     this.f[d(paramv1)] = paramv2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(v paramv) {
/* 451 */     ArrayList<v> arrayList = new ArrayList(this.c);
/* 452 */     String str = c(paramv);
/* 453 */     boolean bool = false; byte b;
/*     */     int i;
/* 455 */     for (b = 1, i = this.e.length; b < i; b += true) {
/*     */       v v1;
/* 457 */       if ((v1 = (v)this.e[b]) != null) {
/*     */ 
/*     */         
/* 460 */         if (!bool)
/*     */         {
/*     */ 
/*     */           
/* 464 */           if (bool = str.equals(this.e[b - 1])) {
/*     */             
/* 466 */             this.f[d(v1)] = null;
/*     */             continue;
/*     */           } 
/*     */         }
/* 470 */         arrayList.add(v1);
/*     */       }  continue;
/* 472 */     }  if (!bool) {
/* 473 */       throw new NoSuchElementException("No entry '" + paramv.a() + "' found, can't remove");
/*     */     }
/* 475 */     a(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/* 484 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 490 */     return this.a;
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
/*     */   public final Iterator<v> iterator() {
/* 505 */     return e().iterator();
/*     */   }
/*     */   
/*     */   private List<v> e() {
/* 509 */     ArrayList<v> arrayList = new ArrayList(this.c); byte b; int i;
/* 510 */     for (b = 1, i = this.e.length; b < i; b += 2) {
/*     */       v v1;
/* 512 */       if ((v1 = (v)this.e[b]) != null) {
/* 513 */         arrayList.add(v1);
/*     */       }
/*     */     } 
/* 516 */     return arrayList;
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
/*     */   public final v[] d() {
/* 528 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String c(v paramv) {
/* 534 */     return this.a ? paramv.a().toLowerCase(this.i) : paramv.a();
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
/*     */   public final v a(String paramString) {
/* 561 */     if (paramString == null) {
/* 562 */       throw new IllegalArgumentException("Cannot pass null property name");
/*     */     }
/* 564 */     if (this.a) {
/* 565 */       paramString = paramString.toLowerCase(this.i);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 573 */     int i, j = (i = paramString.hashCode() & this.b) << 1;
/*     */     Object object;
/* 575 */     if ((object = this.e[j]) == paramString || paramString.equals(object)) {
/* 576 */       return (v)this.e[j + 1];
/*     */     }
/* 578 */     return a(paramString, i, object);
/*     */   }
/*     */ 
/*     */   
/*     */   private final v a(String paramString, int paramInt, Object paramObject) {
/* 583 */     if (paramObject == null)
/*     */     {
/* 585 */       return b(this.h.get(paramString));
/*     */     }
/*     */     
/*     */     int i;
/* 589 */     paramInt = (i = this.b + 1) + (paramInt >> 1) << 1;
/* 590 */     paramObject = this.e[paramInt];
/* 591 */     if (paramString.equals(paramObject)) {
/* 592 */       return (v)this.e[paramInt + 1];
/*     */     }
/* 594 */     if (paramObject != null)
/*     */     {
/* 596 */       for (i = (paramInt = i + (i >> 1) << 1) + this.d; paramInt < i; paramInt += 2) {
/*     */         
/* 598 */         if ((paramObject = this.e[paramInt]) == paramString || paramString.equals(paramObject)) {
/* 599 */           return (v)this.e[paramInt + 1];
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 604 */     return b(this.h.get(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   private v b(String paramString) {
/* 609 */     if (paramString == null) {
/* 610 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 615 */     int i, j = (i = c(paramString)) << 1;
/* 616 */     Object object = this.e[j];
/* 617 */     if (paramString.equals(object)) {
/* 618 */       return (v)this.e[j + 1];
/*     */     }
/* 620 */     if (object == null) {
/* 621 */       return null;
/*     */     }
/* 623 */     return a(paramString, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private v a(String paramString, int paramInt) {
/* 630 */     int i, j = (i = this.b + 1) + (paramInt >> 1) << 1;
/* 631 */     Object object = this.e[j];
/* 632 */     if (paramString.equals(object)) {
/* 633 */       return (v)this.e[j + 1];
/*     */     }
/* 635 */     if (object != null)
/*     */     {
/* 637 */       for (j = (i = i + (i >> 1) << 1) + this.d; i < j; i += 2) {
/*     */         
/* 639 */         if ((object = this.e[i]) == paramString || paramString.equals(object)) {
/* 640 */           return (v)this.e[i + 1];
/*     */         }
/*     */       } 
/*     */     }
/* 644 */     return null;
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
/*     */   public final String toString() {
/*     */     StringBuilder stringBuilder;
/* 687 */     (stringBuilder = new StringBuilder()).append("Properties=[");
/* 688 */     byte b = 0;
/*     */     
/* 690 */     Iterator<v> iterator = iterator();
/* 691 */     while (iterator.hasNext()) {
/* 692 */       v v1 = iterator.next();
/* 693 */       if (b++ > 0) {
/* 694 */         stringBuilder.append(", ");
/*     */       }
/* 696 */       stringBuilder.append(v1.a());
/* 697 */       stringBuilder.append('(');
/* 698 */       stringBuilder.append(v1.c());
/* 699 */       stringBuilder.append(')');
/*     */     } 
/* 701 */     stringBuilder.append(']');
/* 702 */     if (!this.g.isEmpty()) {
/* 703 */       stringBuilder.append("(aliases: ");
/* 704 */       stringBuilder.append(this.g);
/* 705 */       stringBuilder.append(")");
/*     */     } 
/* 707 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static v a(v paramv, r paramr) {
/* 718 */     if (paramv == null) {
/* 719 */       return paramv;
/*     */     }
/* 721 */     String str = paramr.a(paramv.a());
/*     */     
/*     */     k k;
/* 724 */     if ((k = (paramv = paramv.a(str)).p()) != null) {
/*     */       k k1;
/*     */ 
/*     */       
/* 728 */       if ((k1 = k.a(paramr)) != k) {
/* 729 */         paramv = paramv.a(k1);
/*     */       }
/*     */     } 
/* 732 */     return paramv;
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
/*     */   private final int d(v paramv) {
/*     */     byte b;
/*     */     int i;
/* 793 */     for (b = 0, i = this.f.length; b < i; b++) {
/* 794 */       if (this.f[b] == paramv) {
/* 795 */         return b;
/*     */       }
/*     */     } 
/* 798 */     throw new IllegalStateException("Illegal state: property '" + paramv.a() + "' missing from _propsInOrder");
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
/*     */   private final int c(String paramString) {
/* 812 */     return paramString.hashCode() & this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, String> a(Map<String, List<w>> paramMap, boolean paramBoolean, Locale paramLocale) {
/* 819 */     if (paramMap == null || paramMap.isEmpty()) {
/* 820 */       return Collections.emptyMap();
/*     */     }
/* 822 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 823 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/* 824 */       Map.Entry<String, ?> entry; String str = (entry = iterator.next()).getKey();
/* 825 */       if (paramBoolean) {
/* 826 */         str = str.toLowerCase(paramLocale);
/*     */       }
/* 828 */       for (Iterator<w> iterator1 = ((List)entry.getValue()).iterator(); iterator1.hasNext(); ) {
/* 829 */         w w; String str1 = (w = iterator1.next()).b();
/* 830 */         if (paramBoolean) {
/* 831 */           str1 = str1.toLowerCase(paramLocale);
/*     */         }
/* 833 */         hashMap.put(str1, str);
/*     */       } 
/*     */     } 
/* 836 */     return (Map)hashMap;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */