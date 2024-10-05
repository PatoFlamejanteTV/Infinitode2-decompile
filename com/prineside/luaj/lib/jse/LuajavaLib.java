/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.LuaError;
/*     */ import com.prineside.luaj.LuaFunction;
/*     */ import com.prineside.luaj.LuaNumber;
/*     */ import com.prineside.luaj.LuaTable;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.luaj.lib.VarArgFunction;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.script.ScriptEnvironment;
/*     */ import com.prineside.tdi2.managers.script.Whitelist;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.ReflectionUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS
/*     */ public final class LuajavaLib
/*     */   extends VarArgFunction
/*     */ {
/*     */   static {
/*  31 */     TLog.forClass(LuajavaLib.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   private static String[] a = new String[] { "bindClass", "newInstance", "new", "createProxy", "ofClass", "hashCode" }; public final Varargs invoke(Varargs paramVarargs) { try {
/*     */       LuaValue luaValue1; int i;
/*     */       Object object1;
/*     */       LuaTable luaTable2;
/*     */       Class<?> clazz1;
/*     */       LuaTable luaTable1;
/*     */       LuaValue luaValue2;
/*     */       Varargs varargs;
/*     */       Class[] arrayOfClass;
/*     */       Class<?> clazz2;
/*     */       Whitelist whitelist;
/*     */       byte b;
/*     */       ProxyInvocationHandler proxyInvocationHandler;
/*     */       Object object2;
/*  55 */       switch (this.c) {
/*     */         
/*     */         case 0:
/*  58 */           luaValue1 = paramVarargs.arg(2);
/*     */           
/*  60 */           a((LuaValue)(luaTable2 = new LuaTable()), getClass(), a, 1);
/*  61 */           luaValue1.set("luajava", (LuaValue)luaTable2);
/*  62 */           if (!luaValue1.get("package").isnil()) luaValue1.get("package").get("loaded").set("luajava", (LuaValue)luaTable2); 
/*  63 */           return (Varargs)luaTable2;
/*     */         
/*     */         case 1:
/*  66 */           return (Varargs)JavaClass.forClass(classForName(paramVarargs.checkjstring(1)));
/*     */ 
/*     */         
/*     */         case 2:
/*     */         case 3:
/*  71 */           luaValue1 = paramVarargs.checkvalue(1);
/*  72 */           clazz1 = (this.c == 2) ? classForName(luaValue1.tojstring()) : (Class)luaValue1.checkuserdata(Class.class);
/*  73 */           varargs = paramVarargs.subargs(2);
/*  74 */           return JavaClass.forClass(clazz1).getConstructor().invoke(varargs);
/*     */ 
/*     */ 
/*     */         
/*     */         case 4:
/*  79 */           if ((i = paramVarargs.narg() - 1) <= 0)
/*  80 */             throw new LuaError("no interfaces"); 
/*  81 */           luaTable1 = paramVarargs.checktable(i + 1);
/*     */ 
/*     */           
/*  84 */           arrayOfClass = new Class[i];
/*  85 */           whitelist = (Game.i == null) ? null : Game.i.scriptManager.getWhitelist();
/*  86 */           for (b = 0; b < i; b++) {
/*     */             LuaValue luaValue;
/*  88 */             if ((luaValue = paramVarargs.arg(b + 1)).isstring()) {
/*  89 */               arrayOfClass[b] = classForName(luaValue.checkjstring());
/*     */             } else {
/*  91 */               arrayOfClass[b] = (Class)luaValue.checkuserdata(Class.class);
/*     */             } 
/*  93 */             if (!arrayOfClass[b].isInterface()) {
/*  94 */               throw new LuaError(arrayOfClass[b] + " is not an interface");
/*     */             }
/*  96 */             if (whitelist != null && !whitelist.isInterfaceProxyWhiteListed(arrayOfClass[b])) {
/*  97 */               throw new LuaError(arrayOfClass[b] + " (interface) is not on the white list and can not be proxied with Lua");
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 102 */           proxyInvocationHandler = new ProxyInvocationHandler(luaTable1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 108 */           return (Varargs)CoerceJavaToLua.coerce(object2 = Proxy.newProxyInstance(getClass().getClassLoader(), arrayOfClass, proxyInvocationHandler));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 5:
/* 162 */           if (paramVarargs.arg(1).isnil()) {
/* 163 */             return (Varargs)LuaValue.FALSE;
/*     */           }
/*     */           
/* 166 */           object1 = paramVarargs.checkuserdata(1);
/*     */ 
/*     */ 
/*     */           
/* 170 */           if (luaValue2 = paramVarargs.checkvalue(2) instanceof JavaClass) {
/* 171 */             clazz2 = (Class)((JavaClass)luaValue2).m_instance;
/*     */           } else {
/* 173 */             clazz2 = classForName(luaValue2.tojstring());
/*     */           } 
/*     */           
/* 176 */           return (Varargs)LuaValue.valueOf(clazz2.isAssignableFrom(object1.getClass()));
/*     */ 
/*     */         
/*     */         case 6:
/* 180 */           return (Varargs)LuaValue.valueOf((object1 = paramVarargs.arg1() instanceof LuaNumber) ? ((LuaNumber)object1).originalHashCode() : object1.hashCode());
/*     */       } 
/*     */       
/* 183 */       throw new LuaError("not supported: " + this);
/*     */     }
/* 185 */     catch (LuaError luaError2) {
/* 186 */       LuaError luaError1; throw luaError1 = null;
/* 187 */     } catch (Exception exception) {
/* 188 */       throw new LuaError(exception);
/*     */     }  }
/*     */ 
/*     */   
/*     */   public static Class<?> classForName(String paramString) {
/* 193 */     if (paramString.startsWith("class ") || paramString.startsWith("interface ")) {
/* 194 */       throw new ClassNotFoundException("maybe Class object passed instead of its name (class name looks like Class#toString()): '" + paramString + "'");
/*     */     }
/* 196 */     switch (paramString) { case "float":
/* 197 */         return float.class;
/* 198 */       case "int": return int.class;
/* 199 */       case "double": return double.class;
/* 200 */       case "long": return long.class;
/* 201 */       case "byte": return byte.class;
/* 202 */       case "short": return short.class;
/* 203 */       case "boolean": return boolean.class;
/* 204 */       case "char": return char.class; }
/* 205 */      return ReflectionUtils.getClassByName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static class ProxyInvocationHandler
/*     */     implements KryoSerializable, InvocationHandler
/*     */   {
/*     */     private LuaTable a;
/*     */     
/*     */     private boolean b;
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 220 */       param1Kryo.writeObject(param1Output, this.a);
/* 221 */       param1Output.writeBoolean(this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 226 */       this.a = (LuaTable)param1Kryo.readObject(param1Input, LuaTable.class);
/* 227 */       this.b = param1Input.readBoolean();
/*     */     }
/*     */     
/*     */     private ProxyInvocationHandler() {}
/*     */     
/*     */     public ProxyInvocationHandler(LuaTable param1LuaTable) {
/* 233 */       this.a = param1LuaTable;
/* 234 */       this.b = false;
/*     */     }
/*     */     
/*     */     public ProxyInvocationHandler(String param1String, LuaFunction param1LuaFunction) {
/* 238 */       this.a = new LuaTable();
/* 239 */       this.a.set(param1String, (LuaValue)param1LuaFunction);
/* 240 */       this.b = true;
/*     */     }
/*     */     public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) {
/*     */       LuaValue[] arrayOfLuaValue;
/* 244 */       String str = param1Method.getName();
/*     */       
/*     */       LuaValue luaValue;
/*     */       
/* 248 */       if ((luaValue = this.a.get(str)).isnil())
/*     */       {
/* 250 */         luaValue = this.a.get("_M_" + str);
/*     */       }
/* 252 */       if (luaValue.isnil()) {
/*     */         
/* 254 */         switch (str) {
/*     */           case "toString":
/* 256 */             return "Proxy (lobj: " + this.a + ")@" + Integer.toHexString(this.a.hashCode());
/*     */           
/*     */           case "hashCode":
/* 259 */             return Integer.valueOf(this.a.hashCode());
/*     */           
/*     */           case "clone":
/* 262 */             throw new CloneNotSupportedException();
/*     */           
/*     */           case "equals":
/* 265 */             return Boolean.valueOf((param1ArrayOfObject[0] == this.a));
/*     */         } 
/*     */ 
/*     */         
/* 269 */         return null;
/*     */       } 
/*     */       
/* 272 */       boolean bool = ((param1Method.getModifiers() & 0x80) != 0) ? true : false;
/* 273 */       byte b = (param1ArrayOfObject != null) ? param1ArrayOfObject.length : 0;
/*     */       
/* 275 */       if (bool) {
/*     */         Object object;
/* 277 */         int i = Array.getLength(object = param1ArrayOfObject[--b]);
/* 278 */         arrayOfLuaValue = new LuaValue[b + i]; byte b1;
/* 279 */         for (b1 = 0; b1 < b; b1++)
/* 280 */           arrayOfLuaValue[b1] = CoerceJavaToLua.coerce(param1ArrayOfObject[b1]); 
/* 281 */         for (b1 = 0; b1 < i; b1++)
/* 282 */           arrayOfLuaValue[b1 + b] = CoerceJavaToLua.coerce(Array.get(object, b1)); 
/*     */       } else {
/* 284 */         arrayOfLuaValue = new LuaValue[b];
/* 285 */         for (byte b1 = 0; b1 < b; b1++)
/* 286 */           arrayOfLuaValue[b1] = CoerceJavaToLua.coerce(param1ArrayOfObject[b1]); 
/*     */       } 
/*     */       try {
/* 289 */         if (this.b) {
/*     */           LuaValue luaValue2;
/* 291 */           return CoerceLuaToJava.coerce(luaValue2 = luaValue.invoke(LuaValue.varargsOf(arrayOfLuaValue, 0, arrayOfLuaValue.length)).arg1(), param1Method.getReturnType());
/*     */         } 
/* 293 */         this.a.rawset("this", CoerceJavaToLua.coerce(param1Object));
/* 294 */         LuaValue luaValue1 = luaValue.invoke(LuaValue.varargsOf((LuaValue)this.a, LuaValue.varargsOf(arrayOfLuaValue, 0, arrayOfLuaValue.length))).arg1();
/* 295 */         this.a.rawset("this", LuaValue.NIL);
/* 296 */         return CoerceLuaToJava.coerce(luaValue1, param1Method.getReturnType());
/*     */       }
/* 298 */       catch (LuaError luaError2) {
/* 299 */         LuaError luaError1; (luaError1 = null).appendExtraMessage("failed to invoke method '" + param1Method + "' with arguments: " + Arrays.toString(param1ArrayOfObject));
/* 300 */         ScriptEnvironment.handleLuaError(luaError1);
/* 301 */         return null;
/* 302 */       } catch (Exception exception) {
/*     */         LuaError luaError;
/* 304 */         (luaError = new LuaError(exception)).appendExtraMessage("failed to invoke method '" + param1Method + "' with arguments: " + Arrays.toString(param1ArrayOfObject));
/* 305 */         ScriptEnvironment.handleLuaError(luaError);
/* 306 */         return null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\LuajavaLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */