/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import com.badlogic.gdx.utils.ObjectIntMap;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.reflect.Array;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CoerceLuaToJava
/*     */ {
/*     */   static {
/*  62 */     TLog.forClass(CoerceLuaToJava.class);
/*     */   }
/*  64 */   static int a = 256;
/*  65 */   static int b = 4096;
/*  66 */   static int c = 1048576;
/*  67 */   static int d = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object coerce(LuaValue paramLuaValue, Class<?> paramClass) {
/*  91 */     return a(paramClass).coerce(paramLuaValue);
/*     */   }
/*     */   
/*  94 */   private static Map<Class<?>, Coercion> e = new HashMap<>();
/*     */   
/*     */   static final class BoolCoercion implements Coercion {
/*     */     public final String toString() {
/*  98 */       return "BoolCoercion()";
/*     */     }
/*     */     public final int score(LuaValue param1LuaValue) {
/* 101 */       if (param1LuaValue.type() == 1) {
/* 102 */         return 0;
/*     */       }
/* 104 */       return 1;
/*     */     }
/*     */     
/*     */     public final Object coerce(LuaValue param1LuaValue) {
/* 108 */       return param1LuaValue.toboolean() ? Boolean.TRUE : Boolean.FALSE;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class NumericCoercion
/*     */     implements Coercion
/*     */   {
/* 120 */     private static String[] a = new String[] { "byte", "char", "short", "int", "long", "float", "double" };
/*     */     private int b;
/*     */     
/*     */     public final String toString() {
/* 124 */       return "NumericCoercion(" + a[this.b] + ")";
/*     */     }
/*     */     
/*     */     NumericCoercion(int param1Int) {
/* 128 */       this.b = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int score(LuaValue param1LuaValue) {
/* 133 */       byte b = 0;
/* 134 */       if (param1LuaValue.type() == 4) {
/*     */         
/* 136 */         if ((param1LuaValue = param1LuaValue.tonumber()).isnil())
/*     */         {
/* 138 */           return CoerceLuaToJava.c;
/*     */         }
/* 140 */         b = 64;
/*     */       } 
/*     */       
/* 143 */       if (param1LuaValue.isint()) {
/*     */         int i;
/* 145 */         switch (this.b) {
/*     */           case 0:
/* 147 */             i = param1LuaValue.toint();
/*     */             
/* 149 */             return b + ((i == (byte)i) ? 0 : CoerceLuaToJava.b);
/*     */           
/*     */           case 1:
/* 152 */             i = param1LuaValue.toint();
/*     */             
/* 154 */             return b + ((i == (byte)i) ? 1 : ((i == (char)i) ? 0 : CoerceLuaToJava.b));
/*     */           
/*     */           case 2:
/* 157 */             i = param1LuaValue.toint();
/*     */             
/* 159 */             return b + (
/* 160 */               (i == (byte)i) ? 1 : ((i == (short)i) ? 0 : CoerceLuaToJava.b));
/*     */           
/*     */           case 3:
/* 163 */             i = param1LuaValue.toint();
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 168 */             return b + (
/* 169 */               (i == (byte)i) ? 2 : ((i == (char)i || i == (short)i) ? 1 : 0));
/*     */ 
/*     */           
/*     */           case 5:
/* 173 */             return b + 16;
/*     */ 
/*     */           
/*     */           case 4:
/* 177 */             return b + 16;
/*     */ 
/*     */           
/*     */           case 6:
/* 181 */             return b + 32;
/*     */         } 
/*     */ 
/*     */         
/* 185 */         return CoerceLuaToJava.b;
/*     */       } 
/*     */       
/* 188 */       if (param1LuaValue.isnumber()) {
/*     */         double d;
/* 190 */         switch (this.b) {
/*     */           case 4:
/* 192 */             d = param1LuaValue.todouble();
/*     */             
/* 194 */             return b + ((d == (long)d) ? 0 : CoerceLuaToJava.b);
/*     */           
/*     */           case 5:
/* 197 */             d = param1LuaValue.todouble();
/*     */             
/* 199 */             return b + ((d == (float)d) ? 0 : CoerceLuaToJava.b);
/*     */           
/*     */           case 6:
/* 202 */             d = param1LuaValue.todouble();
/*     */             
/* 204 */             return b + ((d == (long)d || d == (float)d) ? 16 : 0);
/*     */         } 
/*     */ 
/*     */         
/* 208 */         return CoerceLuaToJava.b;
/*     */       } 
/*     */ 
/*     */       
/* 212 */       return CoerceLuaToJava.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public final Object coerce(LuaValue param1LuaValue) {
/* 217 */       switch (this.b) { case 0:
/* 218 */           return Byte.valueOf((byte)param1LuaValue.toint());
/* 219 */         case 1: return Character.valueOf((char)param1LuaValue.toint());
/* 220 */         case 2: return Short.valueOf((short)param1LuaValue.toint());
/* 221 */         case 3: return Integer.valueOf(param1LuaValue.toint());
/* 222 */         case 4: return Long.valueOf((long)param1LuaValue.todouble());
/* 223 */         case 5: return Float.valueOf((float)param1LuaValue.todouble());
/* 224 */         case 6: return Double.valueOf(param1LuaValue.todouble()); }
/* 225 */        return null;
/*     */     }
/*     */   }
/*     */   
/*     */   static final class StringCoercion implements Coercion {
/*     */     public static final int TARGET_TYPE_STRING = 0;
/*     */     public static final int TARGET_TYPE_BYTES = 1;
/*     */     private int a;
/*     */     
/*     */     public StringCoercion(int param1Int) {
/* 235 */       this.a = param1Int;
/*     */     }
/*     */     public final String toString() {
/* 238 */       return "StringCoercion(" + ((this.a == 0) ? "String" : "byte[]") + ")";
/*     */     }
/*     */     public final int score(LuaValue param1LuaValue) {
/* 241 */       switch (param1LuaValue.type()) {
/*     */         case 4:
/* 243 */           if (param1LuaValue.checkstring().isValidUtf8())
/* 244 */             return (this.a == 0) ? 0 : 1; 
/* 245 */           if (this.a == 1) return 0;  return CoerceLuaToJava.b;
/*     */         case 0:
/* 247 */           return CoerceLuaToJava.a;
/*     */       } 
/* 249 */       return (this.a == 0) ? CoerceLuaToJava.b : CoerceLuaToJava.c;
/*     */     }
/*     */     
/*     */     public final Object coerce(LuaValue param1LuaValue) {
/* 253 */       if (param1LuaValue.isnil())
/* 254 */         return null; 
/* 255 */       if (this.a == 0) {
/* 256 */         return param1LuaValue.tojstring();
/*     */       }
/*     */       LuaString luaString;
/* 259 */       byte[] arrayOfByte = new byte[(luaString = param1LuaValue.checkstring()).m_length];
/* 260 */       luaString.copyInto(0, arrayOfByte, 0, arrayOfByte.length);
/* 261 */       return arrayOfByte;
/*     */     }
/*     */   }
/*     */   
/*     */   static final class ArrayCoercion implements Coercion {
/*     */     final Class a;
/*     */     final CoerceLuaToJava.Coercion b;
/*     */     
/*     */     public ArrayCoercion(Class<?> param1Class) {
/* 270 */       this.a = param1Class;
/* 271 */       this.b = CoerceLuaToJava.a(param1Class);
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 275 */       return "ArrayCoercion(" + this.a.getName() + ")";
/*     */     }
/*     */     
/*     */     public final int score(LuaValue param1LuaValue) {
/* 279 */       switch (param1LuaValue.type()) {
/*     */         case 5:
/* 281 */           return (param1LuaValue.length() == 0) ? 0 : this.b.score(param1LuaValue.get(1));
/*     */         
/*     */         case 7:
/* 284 */           return CoerceLuaToJava.a(this.a, param1LuaValue.touserdata().getClass().getComponentType());
/*     */         
/*     */         case 0:
/* 287 */           return CoerceLuaToJava.a;
/*     */       } 
/*     */       
/* 290 */       return CoerceLuaToJava.c;
/*     */     }
/*     */     
/*     */     public final Object coerce(LuaValue param1LuaValue) {
/*     */       int i;
/*     */       Object object;
/*     */       byte b;
/* 297 */       switch (param1LuaValue.type()) {
/*     */         
/*     */         case 5:
/* 300 */           i = param1LuaValue.length();
/* 301 */           object = Array.newInstance(this.a, i);
/* 302 */           for (b = 0; b < i; b++)
/* 303 */             Array.set(object, b, this.b.coerce(param1LuaValue.get(b + 1))); 
/* 304 */           return object;
/*     */         
/*     */         case 7:
/* 307 */           return param1LuaValue.touserdata();
/*     */       } 
/* 309 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 314 */   private static final ObjectMap<Class<?>, ObjectIntMap<Class<?>>> f = new ObjectMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static synchronized int a(Class<?> paramClass1, Class<?> paramClass2) {
/* 324 */     if (paramClass2 == null)
/* 325 */       return c; 
/* 326 */     if (paramClass1 == paramClass2)
/* 327 */       return 0;  ObjectIntMap objectIntMap;
/*     */     int i;
/* 329 */     if ((objectIntMap = (ObjectIntMap)f.get(paramClass1)) != null && (
/*     */       
/* 331 */       i = objectIntMap.get(paramClass2, -1)) != -1)
/*     */     {
/* 333 */       return i;
/*     */     }
/*     */ 
/*     */     
/* 337 */     i = Math.min(c, a(paramClass1, paramClass2.getSuperclass()) + 1); Class[] arrayOfClass; int j;
/*     */     byte b;
/* 339 */     for (j = (arrayOfClass = arrayOfClass = paramClass2.getInterfaces()).length, b = 0; b < j; ) { Class<?> clazz = arrayOfClass[b];
/* 340 */       i = Math.min(i, a(paramClass1, clazz) + 1);
/*     */       b++; }
/*     */     
/* 343 */     if (objectIntMap == null) {
/* 344 */       objectIntMap = new ObjectIntMap();
/* 345 */       f.put(paramClass1, objectIntMap);
/*     */     } 
/* 347 */     objectIntMap.put(paramClass2, i);
/*     */     
/* 349 */     return i;
/*     */   }
/*     */   
/*     */   static final class ObjectCoercion implements Coercion { private Class a;
/*     */     
/*     */     ObjectCoercion(Class param1Class) {
/* 355 */       this.a = param1Class;
/*     */     }
/*     */     public final String toString() {
/* 358 */       return "ObjectCoercion(" + this.a.getName() + ")";
/*     */     }
/*     */     public final int score(LuaValue param1LuaValue) {
/* 361 */       switch (param1LuaValue.type()) {
/*     */         case 3:
/* 363 */           return CoerceLuaToJava.a(this.a, param1LuaValue.isint() ? Integer.class : Double.class);
/*     */         case 1:
/* 365 */           return CoerceLuaToJava.a(this.a, Boolean.class);
/*     */         case 4:
/* 367 */           return CoerceLuaToJava.a(this.a, String.class);
/*     */         case 7:
/* 369 */           return CoerceLuaToJava.a(this.a, param1LuaValue.touserdata().getClass());
/*     */         case 0:
/* 371 */           return CoerceLuaToJava.a;
/*     */       } 
/* 373 */       return CoerceLuaToJava.a(this.a, param1LuaValue.getClass());
/*     */     }
/*     */ 
/*     */     
/*     */     public final Object coerce(LuaValue param1LuaValue) {
/* 378 */       switch (param1LuaValue.type()) {
/*     */         
/*     */         case 3:
/* 381 */           if (param1LuaValue.isint())
/*     */           {
/* 383 */             return Integer.valueOf(param1LuaValue.toint());
/*     */           }
/*     */           
/* 386 */           return Double.valueOf(param1LuaValue.todouble());
/*     */         
/*     */         case 1:
/* 389 */           return param1LuaValue.toboolean() ? Boolean.TRUE : Boolean.FALSE;
/*     */         case 4:
/* 391 */           return param1LuaValue.tojstring();
/*     */         case 7:
/* 393 */           return param1LuaValue.optuserdata(this.a, null);
/*     */         case 0:
/* 395 */           return null;
/*     */       } 
/* 397 */       return param1LuaValue;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 403 */     BoolCoercion boolCoercion = new BoolCoercion();
/* 404 */     NumericCoercion numericCoercion1 = new NumericCoercion(0);
/* 405 */     NumericCoercion numericCoercion2 = new NumericCoercion(1);
/* 406 */     NumericCoercion numericCoercion3 = new NumericCoercion(2);
/* 407 */     NumericCoercion numericCoercion4 = new NumericCoercion(3);
/* 408 */     NumericCoercion numericCoercion5 = new NumericCoercion(4);
/* 409 */     NumericCoercion numericCoercion6 = new NumericCoercion(5);
/* 410 */     NumericCoercion numericCoercion7 = new NumericCoercion(6);
/* 411 */     StringCoercion stringCoercion1 = new StringCoercion(0);
/* 412 */     StringCoercion stringCoercion2 = new StringCoercion(1);
/*     */     
/* 414 */     e.put(boolean.class, boolCoercion);
/* 415 */     e.put(Boolean.class, boolCoercion);
/* 416 */     e.put(byte.class, numericCoercion1);
/* 417 */     e.put(Byte.class, numericCoercion1);
/* 418 */     e.put(char.class, numericCoercion2);
/* 419 */     e.put(Character.class, numericCoercion2);
/* 420 */     e.put(short.class, numericCoercion3);
/* 421 */     e.put(Short.class, numericCoercion3);
/* 422 */     e.put(int.class, numericCoercion4);
/* 423 */     e.put(Integer.class, numericCoercion4);
/* 424 */     e.put(long.class, numericCoercion5);
/* 425 */     e.put(Long.class, numericCoercion5);
/* 426 */     e.put(float.class, numericCoercion6);
/* 427 */     e.put(Float.class, numericCoercion6);
/* 428 */     e.put(double.class, numericCoercion7);
/* 429 */     e.put(Double.class, numericCoercion7);
/* 430 */     e.put(String.class, stringCoercion1);
/* 431 */     e.put(byte[].class, stringCoercion2);
/*     */   }
/*     */   
/*     */   static Coercion a(Class<?> paramClass) {
/*     */     Coercion coercion;
/* 436 */     if ((coercion = e.get(paramClass)) != null) {
/* 437 */       return coercion;
/*     */     }
/* 439 */     synchronized (e) {
/* 440 */       if (paramClass.isArray()) {
/* 441 */         coercion = new ArrayCoercion(paramClass.getComponentType());
/*     */       } else {
/* 443 */         coercion = new ObjectCoercion(paramClass);
/*     */       } 
/* 445 */       e.put(paramClass, coercion);
/*     */     } 
/* 447 */     return coercion;
/*     */   }
/*     */   
/*     */   static interface Coercion {
/*     */     int score(LuaValue param1LuaValue);
/*     */     
/*     */     Object coerce(LuaValue param1LuaValue);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\CoerceLuaToJava.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */