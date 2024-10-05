/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.l.o;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
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
/*     */ public final class i
/*     */   extends u
/*     */ {
/*     */   private final o d;
/*     */   private final t.a e;
/*     */   private final boolean f;
/*     */   
/*     */   private i(com.a.a.c.a parama, o paramo, t.a parama1, boolean paramBoolean) {
/*  31 */     super(parama);
/*  32 */     this.d = paramo;
/*  33 */     this.e = (parama == null) ? null : parama1;
/*  34 */     this.f = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<h> a(com.a.a.c.a parama, an paraman, t.a parama1, o paramo, j paramj, boolean paramBoolean) {
/*  42 */     return (new i(parama, paramo, parama1, paramBoolean))
/*  43 */       .a(paraman, paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   private List<h> a(an paraman, j paramj) {
/*     */     Map<String, a> map;
/*  49 */     if ((map = a(paraman, paramj, (Map<String, a>)null)) == null) {
/*  50 */       return Collections.emptyList();
/*     */     }
/*  52 */     ArrayList<h> arrayList = new ArrayList(map.size());
/*  53 */     for (a a1 : map.values()) {
/*  54 */       arrayList.add(a1.a());
/*     */     }
/*  56 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, a> a(an paraman, j paramj, Map<String, a> paramMap) {
/*     */     j j1;
/*  66 */     if ((j1 = paramj.y()) == null) {
/*  67 */       return paramMap;
/*     */     }
/*  69 */     Class<?> clazz1 = paramj.b();
/*     */     
/*  71 */     paramMap = a(new an.a(this.d, j1.x()), j1, paramMap); Field[] arrayOfField; int k;
/*     */     byte b;
/*  73 */     for (k = (arrayOfField = clazz1.getDeclaredFields()).length, b = 0; b < k; b++) {
/*     */       Field field;
/*  75 */       if (a(field = arrayOfField[b])) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  81 */         if (paramMap == null) {
/*  82 */           paramMap = new LinkedHashMap<>();
/*     */         }
/*  84 */         a a1 = new a(paraman, field);
/*  85 */         if (this.f) {
/*  86 */           a1.a = a(a1.a, field.getDeclaredAnnotations());
/*     */         }
/*  88 */         paramMap.put(field.getName(), a1);
/*     */       } 
/*     */     }  Class<?> clazz2;
/*  91 */     if (paramMap != null && this.e != null && (
/*     */       
/*  93 */       clazz2 = this.e.i(clazz1)) != null) {
/*  94 */       a(clazz2, clazz1, paramMap);
/*     */     }
/*     */     
/*  97 */     return paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Class<?> paramClass1, Class<?> paramClass2, Map<String, a> paramMap) {
/*     */     List<?> list;
/* 109 */     for (Iterator<?> iterator = (list = com.a.a.c.m.i.b(paramClass1, paramClass2, true)).iterator(); iterator.hasNext();) {
/* 110 */       for (j = (arrayOfField = (paramClass2 = (Class)iterator.next()).getDeclaredFields()).length, b = 0; b < j; b++) {
/*     */         Field field;
/* 112 */         if (a(field = arrayOfField[b])) {
/*     */ 
/*     */           
/* 115 */           String str = field.getName();
/*     */           
/*     */           a a1;
/* 118 */           if ((a1 = paramMap.get(str)) != null) {
/* 119 */             a1.a = a(a1.a, field.getDeclaredAnnotations());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(Field paramField) {
/* 128 */     if (paramField.isSynthetic()) {
/* 129 */       return false;
/*     */     }
/*     */     
/*     */     int j;
/*     */     
/* 134 */     if (Modifier.isStatic(j = paramField.getModifiers())) {
/* 135 */       return false;
/*     */     }
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   static final class a
/*     */   {
/*     */     private an b;
/*     */     private Field c;
/*     */     public p a;
/*     */     
/*     */     public a(an param1an, Field param1Field) {
/* 147 */       this.b = param1an;
/* 148 */       this.c = param1Field;
/* 149 */       this.a = p.b();
/*     */     }
/*     */     
/*     */     public final h a() {
/* 153 */       return new h(this.b, this.c, this.a.d());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */