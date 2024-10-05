/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*     */ import com.badlogic.gdx.utils.reflect.Constructor;
/*     */ import com.badlogic.gdx.utils.reflect.ReflectionException;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SafePools
/*     */ {
/*  21 */   private static final TLog a = TLog.forClass(SafePools.class);
/*     */   
/*  23 */   private static final ThreadLocal<SafePools> b = new ThreadLocal<SafePools>()
/*     */     {
/*     */       private static SafePools a() {
/*  26 */         return new SafePools((byte)0);
/*     */       }
/*     */     };
/*     */   
/*     */   public static SafePools getInstance() {
/*  31 */     return b.get();
/*     */   }
/*     */   
/*  34 */   private final ObjectMap<Class<?>, Pool<?>> c = new ObjectMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> Pool<T> create(int paramInt1, int paramInt2, ObjectSupplier<T> paramObjectSupplier) {
/*  43 */     return new RegularPool<T>(this, paramInt1, paramInt2, paramObjectSupplier)
/*     */       {
/*     */         public T newObject() {
/*  46 */           return this.a.get();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public final <T> Pool<T> get(Class<T> paramClass, int paramInt) {
/*     */     Pool<T> pool;
/*  54 */     if ((pool = (Pool)this.c.get(paramClass)) == null) {
/*  55 */       pool = new ReflectionPool(paramClass, 4, paramInt, (byte)0);
/*  56 */       this.c.put(paramClass, pool);
/*  57 */       a.i("Creating ReflectionPool for " + paramClass, new Object[0]);
/*     */     } 
/*     */     
/*  60 */     return pool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> Pool<T> get(Class<T> paramClass) {
/*  66 */     return get(paramClass, 100);
/*     */   }
/*     */ 
/*     */   
/*     */   public final <T> void set(Class<T> paramClass, Pool<T> paramPool) {
/*  71 */     this.c.put(paramClass, paramPool);
/*     */   }
/*     */ 
/*     */   
/*     */   public final <T> T obtain(Class<T> paramClass) {
/*  76 */     return get(paramClass).obtain();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void free(Object paramObject) {
/*  82 */     if (paramObject == null) throw new IllegalArgumentException("object cannot be null."); 
/*     */     Pool<Object> pool;
/*  84 */     if ((pool = (Pool)this.c.get(paramObject.getClass())) == null)
/*  85 */       return;  pool.free(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void freeAll(Array paramArray) {
/*  92 */     freeAll(paramArray, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void freeAll(Array paramArray, boolean paramBoolean) {
/*  99 */     if (paramArray == null) throw new IllegalArgumentException("objects cannot be null."); 
/* 100 */     Pool<Object> pool = null; byte b; int i;
/* 101 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Object object;
/* 103 */       if ((object = paramArray.get(b)) != null && (
/* 104 */         pool != null || (
/*     */         
/* 106 */         pool = (Pool)this.c.get(object.getClass())) != null)) {
/*     */         
/* 108 */         pool.free(object);
/* 109 */         if (!paramBoolean) pool = null;
/*     */       
/*     */       } 
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
/*     */   private SafePools() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class AlwaysAllocatingPool<T>
/*     */     implements Pool<T>
/*     */   {
/*     */     private final Constructor a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final T newObject() {
/*     */       try {
/* 146 */         return (T)this.a.newInstance((Object[])null);
/* 147 */       } catch (Exception exception) {
/* 148 */         throw new GdxRuntimeException("Unable to create new instance: " + this.a.getDeclaringClass().getName(), exception);
/*     */       } 
/*     */     }
/*     */     
/*     */     public final T obtain() {
/* 153 */       return newObject();
/*     */     }
/*     */     
/*     */     public final void free(T param1T) {}
/*     */   }
/*     */   
/*     */   public static abstract class RegularPool<T>
/*     */     implements Pool<T> {
/*     */     private int a;
/*     */     private Object[] b;
/*     */     private int c;
/*     */     
/*     */     private RegularPool(int param1Int1, int param1Int2) {
/* 166 */       param1Int1 = Math.min(param1Int1, 4);
/* 167 */       this.b = new Object[param1Int1];
/* 168 */       this.a = param1Int2;
/*     */     }
/*     */     
/*     */     public T obtain() {
/* 172 */       synchronized (this) {
/*     */         
/* 174 */         return (this.c == 0) ? newObject() : (T)this.b[--this.c];
/*     */       } 
/*     */     }
/*     */     
/*     */     public void free(T param1T) {
/* 179 */       if (param1T == null) throw new IllegalArgumentException("object cannot be null."); 
/* 180 */       if (this.c < this.a) {
/* 181 */         synchronized (this) {
/* 182 */           if (this.c == this.b.length) {
/* 183 */             Object[] arrayOfObject = this.b;
/* 184 */             this.b = new Object[Math.min((int)(arrayOfObject.length * 1.5F), this.a)];
/* 185 */             System.arraycopy(arrayOfObject, 0, this.b, 0, arrayOfObject.length);
/*     */           } 
/* 187 */           this.b[this.c++] = param1T;
/*     */         } 
/* 189 */         a(param1T); return;
/*     */       } 
/* 191 */       b(param1T);
/*     */     }
/*     */ 
/*     */     
/*     */     private static void a(T param1T) {
/* 196 */       if (param1T instanceof com.badlogic.gdx.utils.Pool.Poolable) ((com.badlogic.gdx.utils.Pool.Poolable)param1T).reset(); 
/*     */     }
/*     */     
/*     */     private void b(T param1T) {
/* 200 */       a(param1T);
/*     */     }
/*     */     
/*     */     public void clear() {
/* 204 */       synchronized (this) {
/* 205 */         Object[] arrayOfObject; int i; byte b; for (i = (arrayOfObject = this.b).length, b = 0; b < i; ) { Object object = arrayOfObject[b];
/*     */           
/* 207 */           b((T)object); b++; }
/*     */         
/* 209 */         Arrays.fill(this.b, (Object)null);
/*     */         return;
/*     */       } 
/*     */     }
/*     */     public int getFree() {
/* 214 */       return this.c;
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class ReflectionPool<T> extends RegularPool<T> {
/*     */     private final Constructor a;
/*     */     
/*     */     private ReflectionPool(Class<T> param1Class, int param1Int1, int param1Int2) {
/* 222 */       super(param1Int1, param1Int2, (byte)0);
/* 223 */       this.a = a(param1Class);
/* 224 */       if (this.a == null) {
/* 225 */         throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + param1Class.getName());
/*     */       }
/*     */       try {
/* 228 */         this.a.setAccessible(true); return;
/* 229 */       } catch (Exception exception) {
/*     */         return;
/*     */       }  } @Null
/*     */     private static Constructor a(Class<T> param1Class) {
/*     */       try {
/* 234 */         return ClassReflection.getConstructor(param1Class, (Class[])null);
/* 235 */       } catch (Exception exception) {
/*     */         try {
/*     */           Constructor constructor;
/* 238 */           (constructor = ClassReflection.getDeclaredConstructor(param1Class, (Class[])null)).setAccessible(true);
/* 239 */           return constructor;
/* 240 */         } catch (ReflectionException reflectionException) {
/* 241 */           return null;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final T newObject() {
/*     */       try {
/* 250 */         return (T)this.a.newInstance((Object[])null);
/* 251 */       } catch (Exception exception) {
/* 252 */         throw new GdxRuntimeException("Unable to create new instance: " + this.a.getDeclaringClass().getName(), exception);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface Pool<T> {
/*     */     T newObject();
/*     */     
/*     */     T obtain();
/*     */     
/*     */     void free(T param1T);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\SafePools.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */