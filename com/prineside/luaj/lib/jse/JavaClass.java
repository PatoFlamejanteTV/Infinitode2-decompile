/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.luaj.LuaError;
/*     */ import com.prineside.luaj.LuaNumber;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.luaj.lib.VarArgFunction;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.script.Whitelist;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.ReflectionUtils;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(serializer = JavaClass.Serializer.class)
/*     */ public final class JavaClass
/*     */   extends JavaInstance
/*     */   implements CoerceJavaToLua.Coercion
/*     */ {
/*  68 */   private static LuaString b = valueOf("new");
/*  69 */   private static LuaString c = valueOf("_findMethod");
/*     */   
/*  71 */   private static final _findMethod d = new _findMethod();
/*     */   
/*  73 */   private static final ConcurrentHashMap<Class<?>, JavaClass> e = new ConcurrentHashMap<>(); @NAGS private LuaString f; @NAGS private Map<LuaString, LuaValue> g; @NAGS
/*     */   private Map<LuaString, LuaValue> h; @NAGS
/*     */   private ObjectMap<LuaString, Field> i; @NAGS
/*     */   private ObjectMap<LuaString, Field> j; @NAGS
/*  77 */   private Map<LuaString, Class<?>> k; private final HashMap<LuaValue, NamedClassEntry> l; private final HashMap<LuaValue, NamedClassEntry> m; public static class Serializer extends com.esotericsoftware.kryo.Serializer<JavaClass> { public Serializer() { setImmutable(true); }
/*     */ 
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, JavaClass param1JavaClass) {
/*  82 */       Class clazz = (Class)param1JavaClass.m_instance;
/*  83 */       param1Output.writeString(clazz.getName());
/*     */     }
/*     */ 
/*     */     
/*     */     public JavaClass read(Kryo param1Kryo, Input param1Input, Class<? extends JavaClass> param1Class) {
/*  88 */       String str = param1Input.readString();
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/*  93 */         JavaClass javaClass = JavaClass.forClass(param1Class = (Class)LuajavaLib.classForName(str));
/*  94 */         param1Kryo.reference(javaClass);
/*  95 */         return javaClass;
/*  96 */       } catch (ClassNotFoundException classNotFoundException) {
/*  97 */         throw new IllegalStateException("Failed to deserialize JavaClass for " + str, classNotFoundException);
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JavaClass forClass(Class<?> paramClass) {
/*     */     JavaClass javaClass;
/* 112 */     if ((javaClass = e.get(paramClass)) == null) {
/* 113 */       e.put(paramClass, javaClass = new JavaClass(paramClass));
/*     */     }
/*     */     
/* 116 */     return javaClass;
/*     */   }
/*     */   public final LuaValue call() { return getConstructor().call(); }
/*     */   public final LuaValue call(LuaValue paramLuaValue) { Object object; Class<?> clazz; if ((clazz = (Class)this.m_instance).isInterface()) { if (Game.i == null || Game.i.scriptManager.getWhitelist().isInterfaceProxyWhiteListed(clazz)) { LuajavaLib.ProxyInvocationHandler proxyInvocationHandler; if (this.f != null) { if (paramLuaValue.istable()) { if ((paramLuaValue = paramLuaValue.get((LuaValue)this.f)).isnil()) throw new LuaError("Interface proxy is instantiated with table but has no field called after method '" + this.f + "'");  proxyInvocationHandler = new LuajavaLib.ProxyInvocationHandler(this.f.toString(), paramLuaValue.checkfunction()); } else if (proxyInvocationHandler.isfunction()) { proxyInvocationHandler = new LuajavaLib.ProxyInvocationHandler(this.f.toString(), proxyInvocationHandler.checkfunction()); } else { throw new LuaError("Table or function expected, got " + proxyInvocationHandler.typename() + " " + proxyInvocationHandler); }  } else { proxyInvocationHandler = new LuajavaLib.ProxyInvocationHandler(proxyInvocationHandler.checktable()); }  return CoerceJavaToLua.coerce(object = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { clazz }, proxyInvocationHandler)); }  throw new LuaError(clazz + " (interface) is not on the white list and can not be proxied with Lua"); }  return getConstructor().call((LuaValue)object); }
/* 120 */   public final LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) { return getConstructor().call(paramLuaValue1, paramLuaValue2); } public final LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3) { return getConstructor().call(paramLuaValue1, paramLuaValue2, paramLuaValue3); } private JavaClass(Class<?> paramClass) { super(paramClass);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 436 */     this.l = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 502 */     this.m = new HashMap<>(); if (paramClass == Class.class) { this.a = null; } else { this.a = forClass(Class.class); }  if (paramClass.isInterface() && (paramClass.getDeclaredMethods()).length == 1) this.f = LuaString.valueOf(paramClass.getDeclaredMethods()[0].getName());  }
/*     */   public final LuaValue get(LuaValue paramLuaValue) { Field field; if (!(paramLuaValue instanceof LuaString)) return super.get(paramLuaValue);  LuaString luaString = (LuaString)paramLuaValue; if (c.raweq(luaString)) return (LuaValue)d;  NamedClassEntry namedClassEntry; if ((namedClassEntry = f(paramLuaValue)) != null) { if (namedClassEntry.isField) { field = (Field)namedClassEntry.entry; try { switch (namedClassEntry.fieldType) { case 0: return (LuaValue)LuaNumber.valueOf(field.getInt(this.m_instance));case 1: return (LuaValue)LuaNumber.valueOf(field.getFloat(this.m_instance));case 2: return (LuaValue)LuaNumber.valueOf(field.getDouble(this.m_instance));case 3: return (LuaValue)(field.getBoolean(this.m_instance) ? LuaValue.TRUE : LuaValue.FALSE);case 4: return (LuaValue)LuaNumber.valueOf(field.getByte(this.m_instance));case 5: return (LuaValue)LuaNumber.valueOf(field.getShort(this.m_instance));case 6: return (LuaValue)LuaNumber.valueOf(field.getChar(this.m_instance));case 7: return (LuaValue)LuaNumber.valueOf(field.getLong(this.m_instance)); }  return CoerceJavaToLua.coerce(field.get(this.m_instance)); } catch (Exception exception) { throw new LuaError("Failed to access field " + field, 1, exception); }  }  return (LuaValue)((NamedClassEntry)exception).entry; }  if (this.m_metatable == null) throw new LuaError("Field / method / inner class '" + field.typename() + " " + field + "' not found in " + this.m_instance.getClass() + " " + this + " and no metatable is set");  return super.get((LuaValue)field); }
/*     */   public final void set(LuaValue paramLuaValue1, LuaValue paramLuaValue2) { if (!(paramLuaValue1 instanceof LuaString)) { super.set(paramLuaValue1, paramLuaValue2); return; }  Field field; if ((field = (Field)getClassFields().get(paramLuaValue1)) != null) { if (Modifier.isFinal(field.getModifiers())) throw new LuaError("Final field " + field.getName() + " of class " + field.getDeclaringClass() + " can not be changed");  try { Class<?> clazz; if ((clazz = field.getType()) == int.class) { field.setInt(this.m_instance, paramLuaValue2.toint()); return; }  if (clazz == float.class) { field.setFloat(this.m_instance, paramLuaValue2.tofloat()); return; }  if (clazz == double.class) { field.setDouble(this.m_instance, paramLuaValue2.todouble()); return; }  if (clazz == boolean.class) { field.setBoolean(this.m_instance, paramLuaValue2.toboolean()); return; }  if (clazz == byte.class) { field.setByte(this.m_instance, paramLuaValue2.tobyte()); return; }  if (clazz == short.class) { field.setShort(this.m_instance, paramLuaValue2.toshort()); return; }  if (clazz == char.class) { field.setChar(this.m_instance, paramLuaValue2.tochar()); return; }  if (clazz == long.class) { field.setLong(this.m_instance, paramLuaValue2.tolong()); return; }  field.set(this.m_instance, CoerceLuaToJava.coerce(paramLuaValue2, clazz)); return; } catch (Exception exception) { throw new LuaError(exception); }  }  super.set((LuaValue)exception, paramLuaValue2); }
/* 505 */   public final Varargs invoke(Varargs paramVarargs) { if (((Class)this.m_instance).isInterface()) { if (paramVarargs.narg() != 1) throw new LuaError("Interface must be called with one argument only (table of methods or a single function if interface has one method), " + paramVarargs.narg() + " arguments passed");  return (Varargs)call(paramVarargs.arg(1)); }  return (Varargs)getConstructor().invoke(paramVarargs).arg1(); } public final NamedClassEntry getObjectFieldOrMethod(LuaValue paramLuaValue) { NamedClassEntry namedClassEntry; if ((namedClassEntry = this.m.get(paramLuaValue)) != null) {
/* 506 */       if (namedClassEntry == NamedClassEntry.NULL) {
/* 507 */         return null;
/*     */       }
/* 509 */       return namedClassEntry;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 514 */     if (paramLuaValue.isstring()) {
/*     */       NamedClassEntry namedClassEntry1; String str;
/* 516 */       if ((str = paramLuaValue.tojstring()).startsWith("_M_")) {
/*     */ 
/*     */         
/* 519 */         if ((namedClassEntry1 = d((LuaValue)LuaString.valueOf(str.substring(3)))) == null) {
/*     */           
/* 521 */           this.m.put(paramLuaValue, NamedClassEntry.NULL);
/* 522 */           return null;
/*     */         } 
/* 524 */         this.m.put(paramLuaValue, namedClassEntry1);
/* 525 */         return namedClassEntry1;
/*     */       } 
/* 527 */       if (namedClassEntry1.startsWith("_F_")) {
/*     */ 
/*     */         
/* 530 */         if ((namedClassEntry1 = a((LuaValue)LuaString.valueOf(namedClassEntry1.substring(3)))) == null) {
/*     */           
/* 532 */           this.m.put(paramLuaValue, NamedClassEntry.NULL);
/* 533 */           return null;
/*     */         } 
/* 535 */         this.m.put(paramLuaValue, namedClassEntry1);
/* 536 */         return namedClassEntry1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 543 */     if ((namedClassEntry = a(paramLuaValue)) == null)
/*     */     {
/* 545 */       namedClassEntry = d(paramLuaValue);
/*     */     }
/* 547 */     if (namedClassEntry == null) {
/*     */       
/* 549 */       this.m.put(paramLuaValue, NamedClassEntry.NULL);
/* 550 */       return null;
/*     */     } 
/* 552 */     this.m.put(paramLuaValue, namedClassEntry);
/* 553 */     return namedClassEntry; } public final LuaValue coerce(Object paramObject) { return (LuaValue)this; }
/*     */   public final ObjectMap<LuaString, Field> getInstanceFields() { if (this.i == null) { ObjectMap<LuaString, Field> objectMap = new ObjectMap(); Field[] arrayOfField; int i; byte b; for (i = (arrayOfField = arrayOfField = ((Class)this.m_instance).getFields()).length, b = 0; b < i; b++) { Field field; if (!Modifier.isStatic((field = arrayOfField[b]).getModifiers())) if (Game.i == null || Game.i.scriptManager.getWhitelist().isFieldWhiteListed(field)) objectMap.put(LuaString.valueOf(field.getName()), field);   }  this.i = objectMap; }  return this.i; }
/*     */   public final ObjectMap<LuaString, Field> getClassFields() { if (this.j == null) { ObjectMap<LuaString, Field> objectMap = new ObjectMap(); Field[] arrayOfField; int i; byte b; for (i = (arrayOfField = arrayOfField = ((Class)this.m_instance).getFields()).length, b = 0; b < i; b++) { Field field; if (Modifier.isStatic((field = arrayOfField[b]).getModifiers()))
/*     */           if (Game.i == null || Game.i.scriptManager.getWhitelist().isFieldWhiteListed(field))
/*     */             objectMap.put(LuaString.valueOf(field.getName()), field);   }  this.j = objectMap; }  return this.j; }
/*     */   @Null private NamedClassEntry a(LuaValue paramLuaValue) { Field field; if ((field = (Field)getInstanceFields().get(paramLuaValue)) != null) { NamedClassEntry namedClassEntry; (namedClassEntry = new NamedClassEntry()).isField = true; namedClassEntry.entry = field; Class<?> clazz; if ((clazz = field.getType()) == int.class) { namedClassEntry.fieldType = 0; } else if (clazz == float.class) { namedClassEntry.fieldType = 1; } else if (clazz == double.class) { namedClassEntry.fieldType = 2; } else if (clazz == boolean.class) { namedClassEntry.fieldType = 3; } else if (clazz == byte.class) { namedClassEntry.fieldType = 4; } else if (clazz == short.class) { namedClassEntry.fieldType = 5; } else if (clazz == char.class) { namedClassEntry.fieldType = 6; } else if (clazz == long.class) { namedClassEntry.fieldType = 7; } else { namedClassEntry.fieldType = 8; }  return namedClassEntry; }  return null; }
/* 559 */   public final Map<LuaString, LuaValue> getInstanceMethods() { if (this.g == null) {
/* 560 */       Whitelist whitelist = (Game.i == null) ? null : Game.i.scriptManager.getWhitelist();
/*     */       
/* 562 */       HashMap<Object, Object> hashMap1 = new HashMap<>(); Method[] arrayOfMethod; int i;
/*     */       byte b;
/* 564 */       for (i = (arrayOfMethod = arrayOfMethod = ((Class)this.m_instance).getMethods()).length, b = 0; b < i; ) {
/* 565 */         Method method; if (Modifier.isPublic((method = arrayOfMethod[b]).getModifiers()) && !Modifier.isStatic(method.getModifiers()) && (
/* 566 */           whitelist == null || whitelist.isMethodWhiteListed(method))) {
/*     */ 
/*     */ 
/*     */           
/* 570 */           String str = method.getName();
/* 571 */           if (this.m_instance == Class.class) {
/* 572 */             str = "_" + str;
/*     */           }
/*     */           Array array;
/* 575 */           if ((array = (Array)hashMap1.get(str)) == null) {
/* 576 */             hashMap1.put(str, array = new Array(true, 1, Method.class));
/*     */           }
/* 578 */           array.add(method);
/*     */         }  b++;
/*     */       } 
/* 581 */       HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 582 */       for (Iterator<Map.Entry> iterator = hashMap1.entrySet().iterator(); iterator.hasNext(); ) {
/* 583 */         Map.Entry<String, ?> entry; String str = (entry = iterator.next()).getKey();
/*     */         Array array;
/* 585 */         if ((array = (Array)entry.getValue()).size != 0) {
/* 586 */           if (array.size == 1) {
/* 587 */             hashMap2.put(LuaValue.valueOf(str), JavaMethod.a((Method)array.get(0)));
/*     */             continue;
/*     */           } 
/* 590 */           JavaMethod[] arrayOfJavaMethod = new JavaMethod[array.size];
/* 591 */           for (byte b1 = 0; b1 < array.size; b1++) {
/* 592 */             arrayOfJavaMethod[b1] = JavaMethod.a((Method)array.get(b1));
/*     */           }
/* 594 */           hashMap2.put(LuaValue.valueOf(str), new JavaMethod.Overload(arrayOfJavaMethod));
/*     */         } 
/*     */       } 
/*     */       
/* 598 */       this.g = (Map)hashMap2;
/*     */     } 
/* 600 */     return this.g; } @Null private NamedClassEntry c(LuaValue paramLuaValue) { Field field; if ((field = (Field)getClassFields().get(paramLuaValue)) != null) { NamedClassEntry namedClassEntry; (namedClassEntry = new NamedClassEntry()).isField = true; namedClassEntry.entry = field; Class<?> clazz; if ((clazz = field.getType()) == int.class) { namedClassEntry.fieldType = 0; } else if (clazz == float.class) { namedClassEntry.fieldType = 1; } else if (clazz == double.class) { namedClassEntry.fieldType = 2; } else if (clazz == boolean.class) { namedClassEntry.fieldType = 3; } else if (clazz == byte.class) { namedClassEntry.fieldType = 4; } else if (clazz == short.class) { namedClassEntry.fieldType = 5; } else if (clazz == char.class) { namedClassEntry.fieldType = 6; } else if (clazz == long.class) { namedClassEntry.fieldType = 7; } else { namedClassEntry.fieldType = 8; }  return namedClassEntry; }  return null; }
/*     */   @Null private NamedClassEntry d(LuaValue paramLuaValue) { if ((paramLuaValue = getInstanceMethods().get(paramLuaValue)) != null) { NamedClassEntry namedClassEntry; (namedClassEntry = new NamedClassEntry()).entry = paramLuaValue; return namedClassEntry; }  return null; }
/*     */   @Null private NamedClassEntry e(LuaValue paramLuaValue) { if ((paramLuaValue = getClassMethods().get(paramLuaValue)) != null) { NamedClassEntry namedClassEntry; (namedClassEntry = new NamedClassEntry()).entry = paramLuaValue; return namedClassEntry; }  return null; }
/*     */   private NamedClassEntry f(LuaValue paramLuaValue) { NamedClassEntry namedClassEntry; if ((namedClassEntry = this.l.get(paramLuaValue)) != null) { if (namedClassEntry == NamedClassEntry.NULL) return null;  return namedClassEntry; }  if (paramLuaValue.isstring()) { NamedClassEntry namedClassEntry1; String str; if ((str = paramLuaValue.tojstring()).startsWith("_M_")) { LuaValue luaValue; if ((luaValue = g((LuaValue)LuaString.valueOf(str.substring(3)))) != null) { (namedClassEntry1 = new NamedClassEntry()).entry = luaValue; this.l.put(paramLuaValue, namedClassEntry1); return namedClassEntry1; }  this.l.put(paramLuaValue, NamedClassEntry.NULL); return null; }  if (namedClassEntry1.startsWith("_F_")) { if ((namedClassEntry = c((LuaValue)LuaString.valueOf(namedClassEntry1.substring(3)))) == null) { this.l.put(paramLuaValue, NamedClassEntry.NULL); return null; }  this.l.put(paramLuaValue, namedClassEntry); return namedClassEntry; }  }  if ((namedClassEntry = c(paramLuaValue)) == null) namedClassEntry = e(paramLuaValue);  if (namedClassEntry == null) { Class<?> clazz; if ((clazz = h(paramLuaValue)) != null)
/*     */         (namedClassEntry = new NamedClassEntry()).entry = forClass(clazz);  }  if (namedClassEntry == null) { this.l.put(paramLuaValue, NamedClassEntry.NULL); return null; }  this.l.put(paramLuaValue, namedClassEntry); return namedClassEntry; }
/* 605 */   public final Map<LuaString, LuaValue> getClassMethods() { if (this.h == null) {
/*     */       Array array2;
/* 607 */       HashMap<LuaString, LuaValue> hashMap = new HashMap<>(forClass(Class.class).getInstanceMethods());
/* 608 */       if (((Class)this.m_instance).isInterface())
/*     */       {
/* 610 */         return hashMap;
/*     */       }
/* 612 */       Whitelist whitelist = (Game.i == null) ? null : Game.i.scriptManager.getWhitelist();
/*     */       
/* 614 */       HashMap<Object, Object> hashMap1 = new HashMap<>(); Method[] arrayOfMethod; int i;
/*     */       byte b1;
/* 616 */       for (i = (arrayOfMethod = arrayOfMethod = ((Class)this.m_instance).getMethods()).length, b1 = 0; b1 < i; ) {
/* 617 */         Method method; if (Modifier.isPublic((method = arrayOfMethod[b1]).getModifiers()) && Modifier.isStatic(method.getModifiers()) && (
/* 618 */           whitelist == null || whitelist.isMethodWhiteListed(method))) {
/*     */ 
/*     */ 
/*     */           
/* 622 */           String str = method.getName();
/*     */           Array array;
/* 624 */           if ((array = (Array)hashMap1.get(str)) == null) {
/* 625 */             hashMap1.put(str, array = new Array(true, 1, Method.class));
/*     */           }
/* 627 */           array.add(method);
/*     */         } 
/*     */         b1++;
/*     */       } 
/* 631 */       for (Iterator<Map.Entry> iterator = hashMap1.entrySet().iterator(); iterator.hasNext(); ) {
/* 632 */         Map.Entry<String, ?> entry; String str = (entry = iterator.next()).getKey();
/*     */         Array array;
/* 634 */         if ((array = (Array)entry.getValue()).size != 0) {
/* 635 */           if (array.size == 1) {
/* 636 */             hashMap.put(LuaValue.valueOf(str), JavaMethod.a((Method)array.get(0)));
/*     */             
/*     */             continue;
/*     */           } 
/* 640 */           Array array3, array4 = ReflectionUtils.LuaRelated.generateOverloadSuffixForMethods(array3 = (Array)entry.getValue());
/* 641 */           for (byte b = 0; b < array3.size; b++) {
/* 642 */             Method method = (Method)array3.get(b);
/* 643 */             String str1 = (String)array4.get(b);
/* 644 */             hashMap.put(LuaValue.valueOf(str + str1), JavaMethod.a(method));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 652 */       Constructor[] arrayOfConstructor1 = (Constructor[])((Class)this.m_instance).getConstructors();
/* 653 */       Array array1 = new Array(true, 1, Constructor.class); Constructor[] arrayOfConstructor2; int j; byte b2;
/* 654 */       for (j = (arrayOfConstructor2 = arrayOfConstructor1).length, b2 = 0; b2 < j; ) {
/* 655 */         Constructor<?> constructor; if (Modifier.isPublic((constructor = arrayOfConstructor2[b2]).getModifiers()) && (
/* 656 */           whitelist == null || whitelist.isConstructorWhiteListed(constructor))) {
/* 657 */           array1.add(constructor);
/*     */         }
/*     */         b2++;
/*     */       } 
/* 661 */       switch (array1.size) { case 0: break;
/*     */         case 1:
/* 663 */           hashMap.put(b, JavaConstructor.forConstructor((Constructor)array1.get(0))); break;
/*     */         default:
/* 665 */           array2 = ReflectionUtils.LuaRelated.generateOverloadSuffixForConstructors(array1);
/* 666 */           for (j = 0; j < array1.size; j++) {
/* 667 */             String str = (String)array2.get(j);
/* 668 */             Constructor<?> constructor = (Constructor)array1.get(j);
/* 669 */             hashMap.put(LuaString.valueOf("new" + str), JavaConstructor.forConstructor(constructor));
/*     */           } 
/*     */           break; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 678 */       this.h = hashMap;
/*     */     } 
/* 680 */     return this.h; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LuaValue g(LuaValue paramLuaValue) {
/* 688 */     return getClassMethods().get(paramLuaValue);
/*     */   }
/*     */   
/*     */   private Class<?> h(LuaValue paramLuaValue) {
/* 692 */     if (this.k == null) {
/* 693 */       HashMap<Object, Object> hashMap = new HashMap<>(); Class[] arrayOfClass; int i;
/*     */       byte b;
/* 695 */       for (i = (arrayOfClass = arrayOfClass = ((Class)this.m_instance).getClasses()).length, b = 0; b < i; b++) {
/*     */         Class<?> clazz;
/* 697 */         String str = (str = (clazz = arrayOfClass[b]).getName()).substring(Math.max(str.lastIndexOf('$'), str.lastIndexOf('.')) + 1);
/* 698 */         hashMap.put(LuaValue.valueOf(str), clazz);
/*     */       } 
/* 700 */       this.k = (Map)hashMap;
/*     */     } 
/* 702 */     return this.k.get(paramLuaValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaValue getConstructor() {
/* 709 */     return g((LuaValue)b);
/*     */   }
/*     */   
/*     */   public static class NamedClassEntry {
/* 713 */     public static final NamedClassEntry NULL = new NamedClassEntry();
/*     */     
/*     */     public static final byte FIELD_TYPE_INT = 0;
/*     */     
/*     */     public static final byte FIELD_TYPE_FLOAT = 1;
/*     */     
/*     */     public static final byte FIELD_TYPE_DOUBLE = 2;
/*     */     
/*     */     public static final byte FIELD_TYPE_BOOLEAN = 3;
/*     */     
/*     */     public static final byte FIELD_TYPE_BYTE = 4;
/*     */     
/*     */     public static final byte FIELD_TYPE_SHORT = 5;
/*     */     
/*     */     public static final byte FIELD_TYPE_CHAR = 6;
/*     */     public static final byte FIELD_TYPE_LONG = 7;
/*     */     public static final byte FIELD_TYPE_OTHER = 8;
/*     */     public boolean isField;
/*     */     public Object entry;
/*     */     public byte fieldType;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class LuaMethodHandle
/*     */     extends VarArgFunction
/*     */     implements KryoSerializable
/*     */   {
/*     */     static {
/* 741 */       SyncChecker.SYNC_SHAREABLE_CLASSES.add(LuaMethodHandle.class);
/*     */     }
/* 743 */     private static Map<Method, LuaMethodHandle> a = Collections.synchronizedMap(new HashMap<>());
/*     */     
/*     */     private JavaMethod b;
/*     */ 
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 749 */       super.write(param1Kryo, param1Output);
/* 750 */       param1Kryo.writeObject(param1Output, this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 755 */       super.read(param1Kryo, param1Input);
/* 756 */       this.b = (JavaMethod)param1Kryo.readObject(param1Input, JavaMethod.class);
/*     */     }
/*     */     
/*     */     public static LuaMethodHandle forMethod(Method param1Method) {
/*     */       LuaMethodHandle luaMethodHandle;
/* 761 */       if ((luaMethodHandle = a.get(param1Method)) == null)
/* 762 */         a.put(param1Method, luaMethodHandle = new LuaMethodHandle(JavaMethod.a(param1Method))); 
/* 763 */       return luaMethodHandle;
/*     */     }
/*     */     
/*     */     private LuaMethodHandle() {}
/*     */     
/*     */     private LuaMethodHandle(JavaMethod param1JavaMethod) {
/* 769 */       Preconditions.checkNotNull(param1JavaMethod, "javaMethod can not be null");
/* 770 */       this.b = param1JavaMethod;
/*     */     }
/*     */ 
/*     */     
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/* 775 */       return this.b.invoke(param1Varargs);
/*     */     }
/*     */ 
/*     */     
/*     */     public final String tojstring() {
/* 780 */       return super.tojstring() + " (" + this.b.a + ")";
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class _findMethod
/*     */     extends VarArgFunction {
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/*     */       Class<?> clazz;
/* 788 */       JavaClass javaClass = JavaClass.forClass(clazz = (Class)param1Varargs.checkuserdata(1));
/*     */       
/* 790 */       String str = param1Varargs.checkstring(2).tojstring();
/* 791 */       param1Varargs = param1Varargs.subargs(3);
/*     */       
/* 793 */       LuaString luaString = LuaString.valueOf(str);
/*     */       
/* 795 */       Array array = new Array();
/*     */       
/*     */       LuaValue luaValue;
/*     */       
/* 799 */       if (luaValue = javaClass.getInstanceMethods().get(luaString) instanceof JavaMethod.Overload) {
/*     */         
/* 801 */         array.addAll((Object[])((JavaMethod.Overload)luaValue).methods);
/*     */       } else {
/* 803 */         array.add(luaValue);
/*     */       }  Class[] arrayOfClass;
/*     */       int i;
/*     */       byte b;
/* 807 */       for (i = (arrayOfClass = clazz.getInterfaces()).length, b = 0; b < i; b++) {
/*     */         LuaValue luaValue1; Class<?> clazz1;
/*     */         JavaClass javaClass1;
/* 810 */         if (luaValue1 = (javaClass1 = JavaClass.forClass(clazz1 = arrayOfClass[b])).getInstanceMethods().get(luaString) instanceof JavaMethod.Overload) {
/*     */           
/* 812 */           array.addAll((Object[])((JavaMethod.Overload)luaValue1).methods);
/*     */         } else {
/* 814 */           array.add(luaValue1);
/*     */         } 
/*     */       } 
/*     */       
/* 818 */       if (array.size == 0)
/*     */       {
/* 820 */         return null; } 
/* 821 */       if (array.size == 1)
/*     */       {
/* 823 */         return (Varargs)JavaClass.LuaMethodHandle.forMethod(((JavaMethod)array.first()).a);
/*     */       }
/*     */       
/*     */       Array.ArrayIterator<JavaMethod> arrayIterator;
/*     */       
/* 828 */       label35: for (arrayIterator = array.iterator(); arrayIterator.hasNext();) {
/*     */ 
/*     */ 
/*     */         
/* 832 */         if ((arrayOfClass1 = (method = (javaMethod = arrayIterator.next()).getJavaMethod()).getParameterTypes()).length == param1Varargs.narg()) {
/*     */ 
/*     */           
/* 835 */           for (byte b1 = 0; b1 < param1Varargs.narg(); ) {
/* 836 */             Class clazz1 = (Class)param1Varargs.arg(b1 + 1).checkuserdata(Class.class);
/* 837 */             if (arrayOfClass1[b1] == clazz1) {
/*     */               b1++;
/*     */               continue;
/*     */             } 
/*     */             continue label35;
/*     */           } 
/* 843 */           return (Varargs)JavaClass.LuaMethodHandle.forMethod(javaMethod.a);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 848 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JavaClass.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */