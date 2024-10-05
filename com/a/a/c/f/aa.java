/*      */ package com.a.a.c.f;
/*      */ 
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.l.n;
/*      */ import com.a.a.c.l.o;
/*      */ import com.a.a.c.m.b;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.ParameterizedType;
/*      */ import java.lang.reflect.Type;
/*      */ import java.lang.reflect.TypeVariable;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Objects;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class aa
/*      */   implements b
/*      */ {
/*      */   private HashMap<Class<?>, Annotation> a;
/*      */   
/*      */   public static an a(Method paramMethod, j paramj, o paramo, an paraman) {
/*      */     n n;
/*   43 */     return ((n = a(paramMethod, paramj, paraman)) == null) ? paraman : new an.a(paramo, n);
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
/*      */   private static n a(Method paramMethod, j paramj, an paraman) {
/*      */     TypeVariable[] arrayOfTypeVariable;
/*   57 */     if ((arrayOfTypeVariable = (TypeVariable[])paramMethod.getTypeParameters()).length == 0 || paramj
/*      */       
/*   59 */       .x().b())
/*      */     {
/*   61 */       return null;
/*      */     }
/*      */     Type type;
/*   64 */     if (!(type = paramMethod.getGenericReturnType() instanceof ParameterizedType))
/*      */     {
/*      */       
/*   67 */       return null;
/*      */     }
/*      */     
/*   70 */     type = type;
/*      */ 
/*      */     
/*   73 */     if (!Objects.equals(paramj.b(), type.getRawType())) {
/*   74 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   81 */     Type[] arrayOfType = type.getActualTypeArguments();
/*   82 */     ArrayList<boolean> arrayList = new ArrayList(arrayOfTypeVariable.length);
/*   83 */     ArrayList<j> arrayList1 = new ArrayList(arrayOfTypeVariable.length);
/*   84 */     for (byte b1 = 0; b1 < arrayOfType.length; b1++) {
/*      */       Type<?> type1;
/*      */ 
/*      */ 
/*      */       
/*   89 */       if ((type1 = a(type1 = arrayOfType[b1])) != null) {
/*      */         String str;
/*   91 */         if ((str = type1.getName()) == null) {
/*   92 */           return null;
/*      */         }
/*      */         
/*      */         j j1;
/*   96 */         if ((j1 = paramj.x().a(b1)) == null) {
/*   97 */           return null;
/*      */         }
/*      */         
/*      */         TypeVariable<?> typeVariable;
/*      */         
/*  102 */         if ((typeVariable = a((TypeVariable<?>[])arrayOfTypeVariable, str)) == null) {
/*  103 */           return null;
/*      */         }
/*  105 */         if (a(paraman, j1, typeVariable.getBounds())) {
/*      */           boolean bool;
/*      */           int i;
/*  108 */           if ((i = arrayList.indexOf(str)) != -1) {
/*  109 */             j j2 = arrayList1.get(i);
/*  110 */             if (!j1.equals(j2)) {
/*      */ 
/*      */               
/*  113 */               boolean bool1 = j2.b(j1.b());
/*  114 */               bool = j1.b(j2.b());
/*  115 */               if (!bool1 && !bool)
/*      */               {
/*  117 */                 return null;
/*      */               }
/*  119 */               if (bool1 ^ bool && bool)
/*      */               {
/*  121 */                 arrayList1.set(i, j1); } 
/*      */             } 
/*      */           } else {
/*  124 */             arrayList.add(bool);
/*  125 */             arrayList1.add(j1);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  131 */     if (arrayList.isEmpty()) {
/*  132 */       return null;
/*      */     }
/*  134 */     return n.a(arrayList, arrayList1);
/*      */   }
/*      */ 
/*      */   
/*      */   private static TypeVariable<?> a(Type paramType) {
/*  139 */     if (paramType instanceof TypeVariable) {
/*  140 */       return (TypeVariable)paramType;
/*      */     }
/*      */     
/*  143 */     if (paramType instanceof java.lang.reflect.WildcardType) {
/*      */ 
/*      */       
/*  146 */       if (((paramType = paramType).getLowerBounds()).length != 0) {
/*  147 */         return null;
/*      */       }
/*      */       Type[] arrayOfType;
/*  150 */       if ((arrayOfType = paramType.getUpperBounds()).length == 1) {
/*  151 */         return a(arrayOfType[0]);
/*      */       }
/*      */     } 
/*  154 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private static ParameterizedType b(Type paramType) {
/*  159 */     if (paramType instanceof ParameterizedType) {
/*  160 */       return (ParameterizedType)paramType;
/*      */     }
/*      */     
/*  163 */     if (paramType instanceof java.lang.reflect.WildcardType) {
/*      */ 
/*      */       
/*  166 */       if (((paramType = paramType).getLowerBounds()).length != 0) {
/*  167 */         return null;
/*      */       }
/*      */       Type[] arrayOfType;
/*  170 */       if ((arrayOfType = paramType.getUpperBounds()).length == 1) {
/*  171 */         return b(arrayOfType[0]);
/*      */       }
/*      */     } 
/*  174 */     return null;
/*      */   }
/*      */   private static boolean a(an paraman, j paramj, Type[] paramArrayOfType) {
/*      */     int i;
/*      */     byte b1;
/*  179 */     for (i = (paramArrayOfType = paramArrayOfType).length, b1 = 0; b1 < i; ) { Type type = paramArrayOfType[b1];
/*  180 */       if (!a(paraman, paramj, type))
/*  181 */         return false; 
/*      */       b1++; }
/*      */     
/*  184 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean a(an paraman, j paramj, Type paramType) {
/*  189 */     if (!paramj.b(paraman.a(paramType).b())) {
/*  190 */       return false;
/*      */     }
/*      */     
/*  193 */     if ((paramType = b(paramType)) != null && 
/*      */ 
/*      */       
/*  196 */       Objects.equals(paramj.b(), paramType.getRawType())) {
/*  197 */       Type[] arrayOfType = paramType.getActualTypeArguments();
/*      */       n n;
/*  199 */       if ((n = paramj.x()).c() != arrayOfType.length) {
/*  200 */         return false;
/*      */       }
/*  202 */       for (byte b1 = 0; b1 < n.c(); b1++) {
/*  203 */         j j1 = n.a(b1);
/*  204 */         Type type = arrayOfType[b1];
/*  205 */         if (!a(paraman, j1, type)) {
/*  206 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/*  210 */     return true;
/*      */   }
/*      */   
/*      */   private static TypeVariable<?> a(TypeVariable<?>[] paramArrayOfTypeVariable, String paramString) {
/*  214 */     if (paramArrayOfTypeVariable == null || paramString == null)
/*  215 */       return null;  int i;
/*      */     byte b1;
/*  217 */     for (i = (paramArrayOfTypeVariable = paramArrayOfTypeVariable).length, b1 = 0; b1 < i; ) { TypeVariable<?> typeVariable = paramArrayOfTypeVariable[b1];
/*  218 */       if (paramString.equals(typeVariable.getName()))
/*  219 */         return typeVariable; 
/*      */       b1++; }
/*      */     
/*  222 */     return null;
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
/*      */   public aa() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static aa a(Class<?> paramClass, Annotation paramAnnotation) {
/*      */     HashMap<Object, Object> hashMap;
/* 1022 */     (hashMap = new HashMap<>(4)).put(paramClass, paramAnnotation);
/* 1023 */     return new aa((HashMap)hashMap);
/*      */   }
/*      */   
/*      */   aa(HashMap<Class<?>, Annotation> paramHashMap) {
/* 1027 */     this.a = paramHashMap;
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
/*      */   public <A extends Annotation> A a(Class<A> paramClass) {
/* 1040 */     if (this.a == null) {
/* 1041 */       return null;
/*      */     }
/* 1043 */     return (A)this.a.get(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean b(Class<?> paramClass) {
/* 1049 */     if (this.a == null) {
/* 1050 */       return false;
/*      */     }
/* 1052 */     return this.a.containsKey(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean a(Class<? extends Annotation>[] paramArrayOfClass) {
/* 1063 */     if (this.a != null) {
/* 1064 */       byte b1; int i; for (b1 = 0, i = paramArrayOfClass.length; b1 < i; b1++) {
/* 1065 */         if (this.a.containsKey(paramArrayOfClass[b1])) {
/* 1066 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/* 1070 */     return false;
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
/*      */   public static aa a(aa paramaa1, aa paramaa2) {
/* 1091 */     if (paramaa1 == null || paramaa1.a == null || paramaa1.a.isEmpty()) {
/* 1092 */       return paramaa2;
/*      */     }
/* 1094 */     if (paramaa2 == null || paramaa2.a == null || paramaa2.a.isEmpty()) {
/* 1095 */       return paramaa1;
/*      */     }
/* 1097 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*      */     
/* 1099 */     for (Annotation annotation : paramaa2.a.values()) {
/* 1100 */       hashMap.put(annotation.annotationType(), annotation);
/*      */     }
/*      */     
/* 1103 */     for (Annotation annotation : paramaa1.a.values()) {
/* 1104 */       hashMap.put(annotation.annotationType(), annotation);
/*      */     }
/* 1106 */     return new aa((HashMap)hashMap);
/*      */   }
/*      */ 
/*      */   
/*      */   public int a() {
/* 1111 */     return (this.a == null) ? 0 : this.a.size();
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
/*      */   public boolean a(Annotation paramAnnotation) {
/* 1134 */     return b(paramAnnotation);
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1139 */     if (this.a == null) {
/* 1140 */       return "[null]";
/*      */     }
/* 1142 */     return this.a.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean b(Annotation paramAnnotation) {
/* 1152 */     if (this.a == null) {
/* 1153 */       this.a = new HashMap<>();
/*      */     }
/*      */     Annotation annotation;
/* 1156 */     if ((annotation = this.a.put(paramAnnotation.annotationType(), paramAnnotation)) == null || !annotation.equals(paramAnnotation)) return true;  return false;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\aa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */