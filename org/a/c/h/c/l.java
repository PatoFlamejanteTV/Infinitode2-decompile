/*     */ package org.a.c.h.c;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
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
/*     */ public final class l
/*     */ {
/*  38 */   public static final l a = new l();
/*     */   
/*  40 */   private final Map<String, Class<? extends k>> b = new HashMap<String, Class<? extends k>>();
/*     */ 
/*     */   
/*  43 */   private final Map<Class<? extends e>, Class<? extends k>> c = new HashMap<Class<? extends e>, Class<? extends k>>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private l() {
/*  50 */     a("Standard", (Class)p.class, (Class)o.class);
/*     */ 
/*     */ 
/*     */     
/*  54 */     a("Adobe.PubSec", (Class)h.class, (Class)g.class);
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
/*     */   private void a(String paramString, Class<? extends k> paramClass, Class<? extends e> paramClass1) {
/*  74 */     if (this.b.containsKey(paramString))
/*     */     {
/*  76 */       throw new IllegalStateException("The security handler name is already registered");
/*     */     }
/*     */     
/*  79 */     this.b.put(paramString, paramClass);
/*  80 */     this.c.put(paramClass1, paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a(e parame) {
/*     */     Class<? extends k> clazz;
/*  91 */     if ((clazz = this.c.get(parame.getClass())) == null)
/*     */     {
/*  93 */       return null;
/*     */     }
/*     */     
/*  96 */     Class[] arrayOfClass = { parame.getClass() };
/*  97 */     Object[] arrayOfObject = { parame };
/*  98 */     return a(clazz, arrayOfClass, arrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a(String paramString) {
/*     */     Class<? extends k> clazz;
/* 109 */     if ((clazz = this.b.get(paramString)) == null)
/*     */     {
/* 111 */       return null;
/*     */     }
/*     */     
/* 114 */     Class[] arrayOfClass = new Class[0];
/* 115 */     Object[] arrayOfObject = new Object[0];
/* 116 */     return a(clazz, arrayOfClass, arrayOfObject);
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
/*     */   private static k a(Class<? extends k> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/*     */     try {
/*     */       Constructor<? extends k> constructor;
/* 133 */       return (constructor = paramClass.getDeclaredConstructor(paramArrayOfClass)).newInstance(paramArrayOfObject);
/*     */     }
/* 135 */     catch (NoSuchMethodException noSuchMethodException) {
/*     */ 
/*     */       
/* 138 */       throw new RuntimeException(noSuchMethodException);
/*     */     }
/* 140 */     catch (IllegalAccessException illegalAccessException) {
/*     */ 
/*     */       
/* 143 */       throw new RuntimeException(illegalAccessException);
/*     */     }
/* 145 */     catch (InstantiationException instantiationException) {
/*     */ 
/*     */       
/* 148 */       throw new RuntimeException(instantiationException);
/*     */     }
/* 150 */     catch (InvocationTargetException invocationTargetException) {
/*     */ 
/*     */       
/* 153 */       throw new RuntimeException(invocationTargetException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */