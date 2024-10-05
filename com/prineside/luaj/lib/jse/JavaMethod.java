/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.LuaError;
/*     */ import com.prineside.luaj.LuaFunction;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.ReflectionUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
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
/*     */ @REGS(serializer = JavaMethod.Serializer.class, arrayLevels = 1)
/*     */ public final class JavaMethod
/*     */   extends JavaMember
/*     */ {
/*     */   static {
/*  40 */     SyncChecker.SYNC_SHAREABLE_CLASSES.add(JavaMethod.class);
/*     */     
/*  42 */     TLog.forClass(JavaMethod.class);
/*     */   }
/*  44 */   private static Map<Method, JavaMethod> b = Collections.synchronizedMap(new HashMap<>()); final Method a;
/*     */   
/*     */   static JavaMethod a(Method paramMethod) {
/*     */     JavaMethod javaMethod;
/*  48 */     if ((javaMethod = b.get(paramMethod)) == null)
/*  49 */       b.put(paramMethod, javaMethod = new JavaMethod(paramMethod)); 
/*  50 */     return javaMethod;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<JavaMethod>
/*     */   {
/*     */     public void write(Kryo param1Kryo, Output param1Output, JavaMethod param1JavaMethod) {
/*  58 */       Method method = param1JavaMethod.a;
/*  59 */       param1Output.writeString(method.getDeclaringClass().getName());
/*  60 */       param1Output.writeString(method.getName());
/*  61 */       Class[] arrayOfClass = method.getParameterTypes();
/*  62 */       param1Output.writeVarInt(arrayOfClass.length, true); int i; byte b;
/*  63 */       for (i = (arrayOfClass = arrayOfClass).length, b = 0; b < i; ) { Class clazz = arrayOfClass[b];
/*  64 */         param1Output.writeString(clazz.getName());
/*     */         b++; }
/*     */     
/*     */     }
/*     */ 
/*     */     
/*     */     public JavaMethod read(Kryo param1Kryo, Input param1Input, Class<? extends JavaMethod> param1Class) {
/*     */       String str1;
/*  72 */       if ((param1Class = ReflectionUtils.getClassByName(str1 = param1Input.readString())) == null) {
/*  73 */         throw new IllegalArgumentException("Failed to find class " + str1);
/*     */       }
/*  75 */       String str2 = param1Input.readString();
/*     */       int i;
/*  77 */       Class[] arrayOfClass = new Class[i = param1Input.readVarInt(true)];
/*  78 */       for (byte b1 = 0; b1 < i; b1++) {
/*     */         String str;
/*     */         Class clazz;
/*  81 */         if ((clazz = ReflectionUtils.getClassByName(str = param1Input.readString())) == null) {
/*  82 */           throw new IllegalArgumentException("Failed to find parameter class " + str);
/*     */         }
/*  84 */         arrayOfClass[b1] = clazz;
/*     */       }  Method[] arrayOfMethod; int j;
/*     */       byte b2;
/*  87 */       for (j = (arrayOfMethod = param1Class.getMethods()).length, b2 = 0; b2 < j; b2++) {
/*     */         Method method; Class[] arrayOfClass1;
/*  89 */         if ((arrayOfClass1 = (method = arrayOfMethod[b2]).getParameterTypes()).length == i) {
/*  90 */           byte b = 0; while (true) { if (b < i) {
/*  91 */               if (arrayOfClass1[b] == arrayOfClass[b]) {
/*     */                 b++; continue;
/*     */               }  break;
/*     */             } 
/*  95 */             return JavaMethod.a(method); }
/*     */         
/*     */         } 
/*     */       } 
/*  99 */       throw new IllegalArgumentException("Failed to find method with signature " + str1 + "#" + str2 + "(" + Arrays.toString(arrayOfClass) + ")");
/*     */     }
/*     */   }
/*     */   
/*     */   private JavaMethod(Method paramMethod) {
/* 104 */     super(paramMethod.getParameterTypes(), paramMethod.getModifiers());
/* 105 */     this.a = paramMethod;
/*     */     try {
/* 107 */       if (!paramMethod.isAccessible())
/* 108 */         paramMethod.setAccessible(true);  return;
/* 109 */     } catch (SecurityException securityException) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public final Method getJavaMethod() {
/* 114 */     return this.a;
/*     */   }
/*     */   
/*     */   public final LuaValue call() {
/* 118 */     return error("method cannot be called without instance");
/*     */   }
/*     */   
/*     */   public final LuaValue call(LuaValue paramLuaValue) {
/* 122 */     return a(paramLuaValue.checkuserdata(), (Varargs)LuaValue.NONE);
/*     */   }
/*     */   
/*     */   public final LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 126 */     return a(paramLuaValue1.checkuserdata(), (Varargs)paramLuaValue2);
/*     */   }
/*     */   
/*     */   public final LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3) {
/* 130 */     return a(paramLuaValue1.checkuserdata(), varargsOf(paramLuaValue2, (Varargs)paramLuaValue3));
/*     */   }
/*     */   
/*     */   public final Varargs invoke(Varargs paramVarargs) {
/* 134 */     return (Varargs)a(paramVarargs.checkuserdata(1), paramVarargs.subargs(2));
/*     */   }
/*     */ 
/*     */   
/*     */   final LuaValue a(Object paramObject, Varargs paramVarargs) {
/* 139 */     Object[] arrayOfObject = b(paramVarargs);
/*     */ 
/*     */     
/*     */     try {
/* 143 */       return CoerceJavaToLua.coerce(this.a.invoke(paramObject, arrayOfObject));
/* 144 */     } catch (Exception exception) {
/*     */       LuaError luaError;
/* 146 */       (luaError = new LuaError("Failed to invoke method '" + this.a + "' with arguments: " + paramVarargs + "\nCoerced args: " + Arrays.toString(arrayOfObject))).setCause(exception);
/* 147 */       throw luaError;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final String tojstring() {
/* 153 */     return "function: JavaMethod (" + (Modifier.isStatic(this.a.getModifiers()) ? "static " : "") + this.a.getDeclaringClass().getSimpleName() + "#" + this.a.getName() + ")";
/*     */   }
/*     */   @REGS(serializer = Overload.Serializer.class)
/*     */   public static final class Overload extends LuaFunction { public final JavaMethod[] methods;
/*     */     
/*     */     static {
/* 159 */       SyncChecker.SYNC_SHAREABLE_CLASSES.add(Overload.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 176 */       a = ((param1JavaMethod1, param1JavaMethod2) -> {
/*     */           Method method1 = param1JavaMethod1.a;
/*     */           Method method2 = param1JavaMethod2.a;
/*     */           int i;
/*     */           if ((i = method1.getName().compareTo(method2.getName())) == 0) {
/*     */             Class[] arrayOfClass1 = method1.getParameterTypes();
/*     */             Class[] arrayOfClass2 = method2.getParameterTypes();
/*     */             if ((i = Integer.compare(arrayOfClass1.length, arrayOfClass2.length)) == 0) {
/*     */               for (byte b = 0; b < arrayOfClass1.length; b++) {
/*     */                 Class clazz1 = arrayOfClass1[b];
/*     */                 Class clazz2 = arrayOfClass2[b];
/*     */                 String str2 = clazz1.getSimpleName();
/*     */                 String str1 = clazz2.getSimpleName();
/*     */                 if ((i = Integer.compare(str2.length(), str1.length())) != 0)
/*     */                   return i; 
/*     */                 for (byte b1 = 0; b1 < str2.length(); b1++) {
/*     */                   if ((i = Integer.compare(str2.charAt(b1), str1.charAt(b1))) != 0)
/*     */                     return i; 
/*     */                 } 
/*     */               } 
/*     */               return 0;
/*     */             } 
/*     */             return i;
/*     */           } 
/*     */           return i;
/*     */         });
/*     */     }
/*     */     
/*     */     private static final Comparator<JavaMethod> a;
/*     */     
/*     */     public static class Serializer extends com.esotericsoftware.kryo.Serializer<Overload> {
/*     */       public void write(Kryo param2Kryo, Output param2Output, JavaMethod.Overload param2Overload) {
/*     */         param2Kryo.writeObject(param2Output, param2Overload.methods);
/*     */       }
/*     */       
/*     */       public JavaMethod.Overload read(Kryo param2Kryo, Input param2Input, Class<? extends JavaMethod.Overload> param2Class) {
/*     */         return new JavaMethod.Overload((JavaMethod[])param2Kryo.readObject(param2Input, JavaMethod[].class));
/*     */       } }
/*     */     
/*     */     public Overload(JavaMethod[] param1ArrayOfJavaMethod) {
/* 216 */       this.methods = param1ArrayOfJavaMethod;
/* 217 */       Arrays.sort(this.methods, a);
/*     */     }
/*     */     
/*     */     public final LuaValue call() {
/* 221 */       return error("method cannot be called without instance");
/*     */     }
/*     */     
/*     */     private void a(LuaError param1LuaError, Varargs param1Varargs) {
/* 225 */       param1LuaError.appendExtraMessage("trying to invoke one of " + this.methods.length + " methods for parameters " + param1Varargs + ": "); JavaMethod[] arrayOfJavaMethod; int i; byte b;
/* 226 */       for (i = (arrayOfJavaMethod = this.methods).length, b = 0; b < i; ) { JavaMethod javaMethod = arrayOfJavaMethod[b];
/* 227 */         param1LuaError.appendExtraMessage("- " + javaMethod.a.getName() + "(" + Arrays.toString((Object[])javaMethod.a.getParameterTypes()) + ") of class " + javaMethod.a.getDeclaringClass());
/*     */         b++; }
/*     */     
/*     */     }
/*     */     public final LuaValue call(LuaValue param1LuaValue) {
/*     */       try {
/* 233 */         return invokeBestMethod(param1LuaValue.checkuserdata(), (Varargs)LuaValue.NONE);
/* 234 */       } catch (LuaError luaError) {
/* 235 */         a(luaError, (Varargs)param1LuaValue);
/* 236 */         throw luaError;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/*     */       try {
/* 242 */         return invokeBestMethod(param1LuaValue1.checkuserdata(), (Varargs)param1LuaValue2);
/* 243 */       } catch (LuaError luaError) {
/* 244 */         a(luaError, varargsOf(param1LuaValue1, (Varargs)param1LuaValue2));
/* 245 */         throw luaError;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2, LuaValue param1LuaValue3) {
/*     */       try {
/* 251 */         return invokeBestMethod(param1LuaValue1.checkuserdata(), varargsOf(param1LuaValue2, (Varargs)param1LuaValue3));
/* 252 */       } catch (LuaError luaError) {
/* 253 */         a(luaError, varargsOf(param1LuaValue1, param1LuaValue2, (Varargs)param1LuaValue3));
/* 254 */         throw luaError;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/*     */       try {
/* 260 */         return (Varargs)invokeBestMethod(param1Varargs.checkuserdata(1), param1Varargs.subargs(2));
/* 261 */       } catch (LuaError luaError) {
/* 262 */         a(luaError, param1Varargs);
/* 263 */         throw luaError;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final LuaValue invokeBestMethod(Object param1Object, Varargs param1Varargs) {
/* 278 */       JavaMethod javaMethod = null;
/* 279 */       long l = CoerceLuaToJava.c; JavaMethod[] arrayOfJavaMethod; int i, j;
/* 280 */       for (i = (arrayOfJavaMethod = this.methods).length, j = 0; j < i; j++) {
/*     */         JavaMethod javaMethod1;
/*     */         
/*     */         long l1;
/*     */         
/* 285 */         if ((l1 = (javaMethod1 = arrayOfJavaMethod[j]).a(param1Varargs)) < l) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 290 */           l = l1;
/* 291 */           javaMethod = javaMethod1;
/* 292 */           if (l != 0L)
/*     */             continue; 
/*     */           break;
/*     */         } 
/*     */         continue;
/*     */       } 
/* 298 */       if (javaMethod == null) {
/* 299 */         l = CoerceLuaToJava.c;
/* 300 */         for (i = (arrayOfJavaMethod = this.methods).length, j = 0; j < i; j++) {
/*     */           JavaMethod javaMethod1; long l1;
/* 302 */           if ((l1 = (javaMethod1 = arrayOfJavaMethod[j]).a(param1Varargs)) < l) {
/* 303 */             l = l1;
/* 304 */             javaMethod = javaMethod1;
/* 305 */             if (l != 0L)
/*     */               continue; 
/*     */             break;
/*     */           } 
/*     */           continue;
/*     */         } 
/* 311 */         StringBuilder stringBuilder = new StringBuilder();
/* 312 */         l = CoerceLuaToJava.c;
/* 313 */         stringBuilder.append("- Starting score ").append(String.valueOf(l)).append(", args: ").append(param1Varargs.toString()).append("\n"); JavaMethod[] arrayOfJavaMethod1; byte b;
/* 314 */         for (j = (arrayOfJavaMethod1 = this.methods).length, b = 0; b < j; b++) {
/* 315 */           JavaMethod javaMethod1; long l1 = (javaMethod1 = arrayOfJavaMethod1[b]).a(param1Varargs);
/* 316 */           stringBuilder.append("- Score of ").append(String.valueOf(javaMethod1.a)).append(": ").append(l1).append("\n");
/* 317 */           if (l1 < l) {
/* 318 */             l = l1;
/* 319 */             javaMethod = javaMethod1;
/* 320 */             if (l != 0L)
/*     */               continue;  break;
/*     */           } 
/*     */           continue;
/*     */         } 
/* 325 */         LuaValue.error("no coercible public method in JavaMethod.Overload\n" + stringBuilder);
/*     */       } 
/*     */ 
/*     */       
/* 329 */       return javaMethod.a(param1Object, param1Varargs);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JavaMethod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */