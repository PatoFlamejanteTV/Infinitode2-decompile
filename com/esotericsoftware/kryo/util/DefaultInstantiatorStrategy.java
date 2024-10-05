/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.reflectasm.ConstructorAccess;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Modifier;
/*     */ import org.c.a.a;
/*     */ import org.c.b.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultInstantiatorStrategy
/*     */   implements a
/*     */ {
/*     */   private a fallbackStrategy;
/*     */   
/*     */   public DefaultInstantiatorStrategy() {}
/*     */   
/*     */   public DefaultInstantiatorStrategy(a parama) {
/*  40 */     this.fallbackStrategy = parama;
/*     */   }
/*     */   
/*     */   public void setFallbackInstantiatorStrategy(a parama) {
/*  44 */     this.fallbackStrategy = parama;
/*     */   }
/*     */   
/*     */   public a getFallbackInstantiatorStrategy() {
/*  48 */     return this.fallbackStrategy;
/*     */   }
/*     */   
/*     */   public a newInstantiatorOf(final Class type) {
/*  52 */     if (!Util.isAndroid) {
/*     */       Class<?> clazz;
/*     */       
/*     */       boolean bool;
/*     */       
/*  57 */       if (!(bool = ((clazz = type.getEnclosingClass()) != null && type.isMemberClass() && !Modifier.isStatic(type.getModifiers())) ? true : false)) {
/*     */         try {
/*  59 */           final ConstructorAccess access = ConstructorAccess.get(type);
/*  60 */           return new a() {
/*     */               public Object newInstance() {
/*     */                 try {
/*  63 */                   return access.newInstance();
/*  64 */                 } catch (Exception exception) {
/*  65 */                   throw new KryoException("Error constructing instance of class: " + Util.className(type), exception);
/*     */                 } 
/*     */               }
/*     */             };
/*  69 */         } catch (Exception exception) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*     */       try {
/*  78 */         constructor = type.getConstructor((Class[])null);
/*  79 */       } catch (Exception exception) {
/*     */         
/*  81 */         (constructor = type.getDeclaredConstructor((Class[])null)).setAccessible(true);
/*     */       } 
/*  83 */       final Constructor<?> constructor = constructor;
/*  84 */       return new a() {
/*     */           public Object newInstance() {
/*     */             try {
/*  87 */               return constructor.newInstance(new Object[0]);
/*  88 */             } catch (Exception exception) {
/*  89 */               throw new KryoException("Error constructing instance of class: " + Util.className(type), exception);
/*     */             } 
/*     */           }
/*     */         };
/*  93 */     } catch (Exception exception) {
/*     */ 
/*     */       
/*  96 */       if (this.fallbackStrategy == null) {
/*  97 */         if (type.isMemberClass() && !Modifier.isStatic(type.getModifiers())) {
/*  98 */           throw new KryoException("Class cannot be created (non-static member class): " + Util.className(type));
/*     */         }
/* 100 */         StringBuilder stringBuilder = new StringBuilder("Class cannot be created (missing no-arg constructor): " + Util.className(type));
/* 101 */         if (type.getSimpleName().equals("")) {
/* 102 */           stringBuilder
/* 103 */             .append("\nNote: This is an anonymous class, which is not serializable by default in Kryo. Possible solutions:\n1. Remove uses of anonymous classes, including double brace initialization, from the containing\n")
/*     */ 
/*     */             
/* 106 */             .append("class. This is the safest solution, as anonymous classes don't have predictable names for serialization.\n2. Register a FieldSerializer for the containing class and call FieldSerializer\n")
/*     */ 
/*     */             
/* 109 */             .append("setIgnoreSyntheticFields(false) on it. This is not safe but may be sufficient temporarily.");
/*     */         }
/* 111 */         throw new KryoException(stringBuilder.toString());
/*     */       } 
/*     */ 
/*     */       
/* 115 */       return this.fallbackStrategy.newInstantiatorOf(type);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\DefaultInstantiatorStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */