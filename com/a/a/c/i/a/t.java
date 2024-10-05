/*     */ package com.a.a.c.i.a;
/*     */ 
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.d;
/*     */ import com.a.a.c.i.b;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.q;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.TreeSet;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class t
/*     */   extends s
/*     */ {
/*     */   private q<?> c;
/*     */   private ConcurrentHashMap<String, String> d;
/*     */   private Map<String, j> e;
/*     */   private boolean f;
/*     */   
/*     */   private t(q<?> paramq, j paramj, ConcurrentHashMap<String, String> paramConcurrentHashMap, HashMap<String, j> paramHashMap) {
/*  42 */     super(paramj, paramq.p());
/*  43 */     this.c = paramq;
/*  44 */     this.d = paramConcurrentHashMap;
/*  45 */     this.e = paramHashMap;
/*  46 */     this.f = paramq.a(q.x);
/*     */   }
/*     */ 
/*     */   
/*     */   public static t a(q<?> paramq, j paramj, Collection<b> paramCollection, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     ConcurrentHashMap<Object, Object> concurrentHashMap;
/*     */     HashMap<Object, Object> hashMap;
/*  53 */     if (paramBoolean1 == paramBoolean2) throw new IllegalArgumentException();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     if (paramBoolean1) {
/*     */ 
/*     */       
/*  61 */       concurrentHashMap = new ConcurrentHashMap<>();
/*  62 */       hashMap = null;
/*     */     } else {
/*  64 */       hashMap = new HashMap<>();
/*     */ 
/*     */ 
/*     */       
/*  68 */       concurrentHashMap = new ConcurrentHashMap<>(4);
/*     */     } 
/*  70 */     boolean bool = paramq.a(q.x);
/*     */     
/*  72 */     if (paramCollection != null)
/*  73 */       for (Iterator<b> iterator = paramCollection.iterator(); iterator.hasNext(); ) {
/*     */         b b;
/*     */         
/*  76 */         Class<?> clazz = (b = iterator.next()).a();
/*  77 */         String str = b.c() ? b.b() : b(clazz);
/*  78 */         if (paramBoolean1) {
/*  79 */           concurrentHashMap.put(clazz.getName(), str);
/*     */         }
/*  81 */         if (paramBoolean2) {
/*     */           
/*  83 */           if (bool) {
/*  84 */             str = str.toLowerCase();
/*     */           }
/*     */           
/*     */           j j1;
/*     */           
/*  89 */           if ((j1 = (j)hashMap.get(str)) == null || 
/*  90 */             !clazz.isAssignableFrom(j1.b()))
/*     */           {
/*     */ 
/*     */             
/*  94 */             hashMap.put(str, paramq.b(clazz));
/*     */           }
/*     */         } 
/*     */       }  
/*  98 */     return new t(paramq, paramj, (ConcurrentHashMap)concurrentHashMap, (HashMap)hashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(Object paramObject) {
/* 106 */     return a(paramObject.getClass());
/*     */   }
/*     */ 
/*     */   
/*     */   private String a(Class<?> paramClass) {
/* 111 */     if (paramClass == null) {
/* 112 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 116 */     String str1 = paramClass.getName();
/*     */     
/*     */     String str2;
/* 119 */     if ((str2 = this.d.get(str1)) == null) {
/*     */ 
/*     */       
/* 122 */       paramClass = this.a.a(paramClass).b();
/*     */ 
/*     */       
/* 125 */       if (this.c.f()) {
/* 126 */         b b = this.c.c(paramClass);
/* 127 */         str2 = this.c.j().d(b.d());
/*     */       } 
/* 129 */       if (str2 == null)
/*     */       {
/* 131 */         str2 = b(paramClass);
/*     */       }
/* 133 */       this.d.put(str1, str2);
/*     */     } 
/* 135 */     return str2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(Object paramObject, Class<?> paramClass) {
/* 142 */     if (paramObject == null) {
/* 143 */       return a(paramClass);
/*     */     }
/* 145 */     return a(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public final j a(d paramd, String paramString) {
/* 150 */     return a(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   private j a(String paramString) {
/* 155 */     if (this.f) {
/* 156 */       paramString = paramString.toLowerCase();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 162 */     return this.e.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b() {
/* 169 */     TreeSet treeSet = new TreeSet();
/* 170 */     for (Iterator<Map.Entry> iterator = this.e.entrySet().iterator(); iterator.hasNext();) {
/* 171 */       if (((j)(entry = iterator.next()).getValue()).e()) {
/* 172 */         treeSet.add(entry.getKey());
/*     */       }
/*     */     } 
/* 175 */     return treeSet.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 180 */     return String.format("[%s; id-to-type=%s]", new Object[] { getClass().getName(), this.e });
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
/*     */   private static String b(Class<?> paramClass) {
/*     */     String str;
/*     */     int i;
/* 197 */     return ((i = (str = paramClass.getName()).lastIndexOf('.')) < 0) ? str : str.substring(i + 1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */