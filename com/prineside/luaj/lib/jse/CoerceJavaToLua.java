/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import com.prineside.luaj.LuaNumber;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.LuaValue;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CoerceJavaToLua
/*     */ {
/*     */   public static interface Coercion
/*     */   {
/*     */     LuaValue coerce(Object param1Object);
/*     */   }
/*     */   
/*     */   private static final class BoolCoercion
/*     */     implements Coercion
/*     */   {
/*     */     private BoolCoercion() {}
/*     */     
/*     */     public final LuaValue coerce(Object param1Object) {
/*  46 */       return (LuaValue)((param1Object = param1Object).booleanValue() ? LuaValue.TRUE : LuaValue.FALSE);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class IntCoercion implements Coercion { private IntCoercion() {}
/*     */     
/*     */     public final LuaValue coerce(Object param1Object) {
/*  53 */       return (LuaValue)LuaNumber.valueOf((param1Object = param1Object).intValue());
/*     */     } }
/*     */   
/*     */   private static final class CharCoercion implements Coercion {
/*     */     private CharCoercion() {}
/*     */     
/*     */     public final LuaValue coerce(Object param1Object) {
/*  60 */       return (LuaValue)LuaNumber.valueOf((param1Object = param1Object).charValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class DoubleCoercion implements Coercion { private DoubleCoercion() {}
/*     */     
/*     */     public final LuaValue coerce(Object param1Object) {
/*  67 */       return (LuaValue)LuaNumber.valueOf((param1Object = param1Object).doubleValue());
/*     */     } }
/*     */ 
/*     */   
/*     */   private static final class StringCoercion implements Coercion {
/*     */     public final LuaValue coerce(Object param1Object) {
/*  73 */       return (LuaValue)LuaString.valueOf(param1Object.toString());
/*     */     }
/*     */     private StringCoercion() {} }
/*     */   private static final class BytesCoercion implements Coercion { private BytesCoercion() {}
/*     */     
/*     */     public final LuaValue coerce(Object param1Object) {
/*  79 */       return (LuaValue)LuaValue.valueOf((byte[])param1Object);
/*     */     } }
/*     */   
/*     */   private static final class ClassCoercion implements Coercion { private ClassCoercion() {}
/*     */     
/*     */     public final LuaValue coerce(Object param1Object) {
/*  85 */       return (LuaValue)JavaClass.forClass((Class)param1Object);
/*     */     } }
/*     */ 
/*     */   
/*     */   public static final class InstanceCoercion implements Coercion {
/*     */     public final LuaValue coerce(Object param1Object) {
/*  91 */       return (LuaValue)new JavaInstance(param1Object);
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class ArrayCoercion implements Coercion {
/*     */     public final LuaValue coerce(Object param1Object) {
/*  97 */       return (LuaValue)new JavaArray(param1Object);
/*     */     } }
/*     */   
/*     */   private static final class LuaCoercion implements Coercion { private LuaCoercion() {}
/*     */     
/*     */     public final LuaValue coerce(Object param1Object) {
/* 103 */       return (LuaValue)param1Object;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/* 108 */   private static ConcurrentHashMap<Class<?>, Coercion> a = new ConcurrentHashMap<>();
/*     */   
/*     */   static {
/* 111 */     BoolCoercion boolCoercion = new BoolCoercion((byte)0);
/* 112 */     IntCoercion intCoercion = new IntCoercion((byte)0);
/* 113 */     CharCoercion charCoercion = new CharCoercion((byte)0);
/* 114 */     DoubleCoercion doubleCoercion = new DoubleCoercion((byte)0);
/* 115 */     StringCoercion stringCoercion = new StringCoercion((byte)0);
/* 116 */     BytesCoercion bytesCoercion = new BytesCoercion((byte)0);
/* 117 */     ClassCoercion classCoercion = new ClassCoercion((byte)0);
/* 118 */     a.put(Boolean.class, boolCoercion);
/* 119 */     a.put(Byte.class, intCoercion);
/* 120 */     a.put(Character.class, charCoercion);
/* 121 */     a.put(Short.class, intCoercion);
/* 122 */     a.put(Integer.class, intCoercion);
/* 123 */     a.put(Long.class, doubleCoercion);
/* 124 */     a.put(Float.class, doubleCoercion);
/* 125 */     a.put(Double.class, doubleCoercion);
/* 126 */     a.put(String.class, stringCoercion);
/* 127 */     a.put(byte[].class, bytesCoercion);
/* 128 */     a.put(Class.class, classCoercion);
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
/*     */   public static LuaValue coerce(Object paramObject) {
/* 147 */     if (paramObject == null)
/* 148 */       return LuaValue.NIL; 
/*     */     Class<?> clazz;
/* 150 */     if ((clazz = paramObject.getClass()).isArray()) {
/* 151 */       return arrayCoercion.coerce(paramObject);
/*     */     }
/*     */     
/*     */     Coercion coercion;
/* 155 */     if ((coercion = a.get(clazz)) == null) {
/* 156 */       coercion = (paramObject instanceof LuaValue) ? b : instanceCoercion;
/* 157 */       a.put(clazz, coercion);
/*     */     } 
/* 159 */     return coercion.coerce(paramObject);
/*     */   }
/*     */   
/* 162 */   public static final Coercion instanceCoercion = new InstanceCoercion();
/* 163 */   public static final Coercion arrayCoercion = new ArrayCoercion();
/*     */   
/* 165 */   private static Coercion b = new LuaCoercion((byte)0);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\CoerceJavaToLua.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */