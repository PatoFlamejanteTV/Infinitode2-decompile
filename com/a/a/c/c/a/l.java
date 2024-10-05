/*      */ package com.a.a.c.c.a;
/*      */ 
/*      */ import com.a.a.c.c.b.ad;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k;
/*      */ import com.a.a.c.m.k;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class l
/*      */ {
/*      */   public static k<?> c(j paramj) {
/*      */     a a;
/*      */     String str1;
/*   46 */     if (!(str1 = paramj.b().getName()).startsWith("java.util.")) {
/*   47 */       return null;
/*      */     }
/*      */     
/*      */     String str2;
/*      */     
/*   52 */     if ((str2 = b(str1)) != null) {
/*   53 */       str1 = null;
/*      */       
/*      */       String str;
/*   56 */       if ((str = f(str2)) != null) {
/*   57 */         if (str.endsWith("Set")) {
/*   58 */           a = a(4, paramj, Set.class);
/*   59 */         } else if (str.endsWith("List")) {
/*   60 */           a = a(5, paramj, List.class);
/*      */         } 
/*   62 */       } else if ((str = d(str2)) != null) {
/*   63 */         if (str.endsWith("Set")) {
/*   64 */           a = a(1, paramj, Set.class);
/*   65 */         } else if (str.endsWith("List")) {
/*   66 */           a = a(2, paramj, List.class);
/*      */         } 
/*   68 */       } else if ((str = e(str2)) != null) {
/*      */         
/*   70 */         if (str.endsWith("Set")) {
/*   71 */           a = a(7, paramj, Set.class);
/*   72 */         } else if (str.endsWith("List")) {
/*   73 */           a = a(9, paramj, List.class);
/*   74 */         } else if (str.endsWith("Collection")) {
/*   75 */           a = a(8, paramj, Collection.class);
/*      */         } 
/*      */       } 
/*      */       
/*   79 */       return (k<?>)((a == null) ? null : new ad(a));
/*      */     } 
/*   81 */     if ((str2 = a((String)a)) != null) {
/*      */       
/*   83 */       if (str2.contains("List"))
/*      */       {
/*      */ 
/*      */         
/*   87 */         return (k<?>)new ad(
/*   88 */             a(11, paramj, List.class));
/*      */       }
/*   90 */       return null;
/*      */     } 
/*      */     
/*   93 */     if ((str2 = c((String)a)) != null) {
/*      */       
/*   95 */       if (str2.contains("List")) {
/*   96 */         return (k<?>)new ad(
/*   97 */             a(11, paramj, List.class));
/*      */       }
/*   99 */       if (str2.contains("Set")) {
/*  100 */         return (k<?>)new ad(
/*  101 */             a(4, paramj, Set.class));
/*      */       }
/*  103 */       return null;
/*      */     } 
/*      */     
/*  106 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static k<?> d(j paramj) {
/*  113 */     String str1 = paramj.b().getName();
/*      */     
/*  115 */     a a = null;
/*      */     String str2;
/*  117 */     if ((str2 = b(str1)) != null) {
/*      */ 
/*      */       
/*  120 */       if ((str1 = f(str2)) != null) {
/*  121 */         if (str1.contains("Map")) {
/*  122 */           a = a(6, paramj, Map.class);
/*      */         }
/*  124 */       } else if ((str1 = d(str2)) != null) {
/*  125 */         if (str1.contains("Map")) {
/*  126 */           a = a(3, paramj, Map.class);
/*      */         }
/*  128 */       } else if ((str1 = e(str2)) != null) {
/*      */         
/*  130 */         if (str1.contains("Map")) {
/*  131 */           a = a(10, paramj, Map.class);
/*      */         }
/*      */       } 
/*  134 */     } else if ((str2 = c(str1)) != null && 
/*  135 */       str2.contains("Map")) {
/*  136 */       a = a(6, paramj, Map.class);
/*      */     } 
/*      */     
/*  139 */     return (k<?>)((a == null) ? null : new ad(a));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static a a(int paramInt, j paramj, Class<?> paramClass) {
/*  145 */     return new a(paramInt, paramj.d(paramClass));
/*      */   }
/*      */   
/*      */   private static String a(String paramString) {
/*  149 */     if (paramString.startsWith("java.util.Arrays$")) {
/*  150 */       return paramString.substring(17);
/*      */     }
/*  152 */     return null;
/*      */   }
/*      */   
/*      */   private static String b(String paramString) {
/*  156 */     if (paramString.startsWith("java.util.Collections$")) {
/*  157 */       return paramString.substring(22);
/*      */     }
/*  159 */     return null;
/*      */   }
/*      */   
/*      */   private static String c(String paramString) {
/*  163 */     if (paramString.startsWith("java.util.ImmutableCollections$")) {
/*  164 */       return paramString.substring(31);
/*      */     }
/*  166 */     return null;
/*      */   }
/*      */   
/*      */   private static String d(String paramString) {
/*  170 */     return paramString.startsWith("Singleton") ? paramString.substring(9) : null;
/*      */   }
/*      */   
/*      */   private static String e(String paramString) {
/*  174 */     return paramString.startsWith("Synchronized") ? paramString.substring(12) : null;
/*      */   }
/*      */   
/*      */   private static String f(String paramString) {
/*  178 */     return paramString.startsWith("Unmodifiable") ? paramString.substring(12) : null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static class a
/*      */     implements k<Object, Object>
/*      */   {
/*      */     private final j a;
/*      */ 
/*      */     
/*      */     private final int b;
/*      */ 
/*      */     
/*      */     a(int param1Int, j param1j) {
/*  193 */       this.a = param1j;
/*  194 */       this.b = param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public final Object a(Object param1Object) {
/*  199 */       if (param1Object == null) {
/*  200 */         return null;
/*      */       }
/*      */       
/*  203 */       switch (this.b) {
/*      */ 
/*      */         
/*      */         case 1:
/*  207 */           a((param1Object = param1Object).size());
/*  208 */           return Collections.singleton(param1Object.iterator().next());
/*      */ 
/*      */ 
/*      */         
/*      */         case 2:
/*  213 */           a((param1Object = param1Object).size());
/*  214 */           return Collections.singletonList(param1Object.get(0));
/*      */ 
/*      */ 
/*      */         
/*      */         case 3:
/*  219 */           a((param1Object = param1Object).size());
/*      */           
/*  221 */           return Collections.singletonMap((param1Object = param1Object.entrySet().iterator().next()).getKey(), param1Object.getValue());
/*      */ 
/*      */         
/*      */         case 4:
/*  225 */           return Collections.unmodifiableSet((Set)param1Object);
/*      */         case 5:
/*  227 */           return Collections.unmodifiableList((List)param1Object);
/*      */         case 6:
/*  229 */           return Collections.unmodifiableMap((Map<?, ?>)param1Object);
/*      */         
/*      */         case 7:
/*  232 */           return Collections.synchronizedSet((Set)param1Object);
/*      */         case 9:
/*  234 */           return Collections.synchronizedList((List)param1Object);
/*      */         case 8:
/*  236 */           return Collections.synchronizedCollection((Collection)param1Object);
/*      */         case 10:
/*  238 */           return Collections.synchronizedMap((Map<?, ?>)param1Object);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  243 */       return param1Object;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final j a() {
/*  249 */       return this.a;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final j b() {
/*  255 */       return this.a;
/*      */     }
/*      */     
/*      */     private static void a(int param1Int) {
/*  259 */       if (param1Int != 1)
/*      */       {
/*  261 */         throw new IllegalArgumentException("Can not deserialize Singleton container from " + param1Int + " entries");
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean F() {
/* 1061 */     return (E() != null);
/*      */   }
/*      */   
/*      */   public abstract l E();
/*      */   
/*      */   public abstract String G();
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */