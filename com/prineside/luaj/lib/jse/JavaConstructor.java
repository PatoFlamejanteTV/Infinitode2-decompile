/*    */ package com.prineside.luaj.lib.jse;
/*    */ 
/*    */ import com.prineside.luaj.LuaError;
/*    */ import com.prineside.luaj.Varargs;
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.Arrays;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class JavaConstructor
/*    */   extends JavaMember
/*    */ {
/* 21 */   private static final ConcurrentHashMap<Constructor<?>, JavaConstructor> a = new ConcurrentHashMap<>();
/*    */   
/*    */   public static JavaConstructor forConstructor(Constructor<?> paramConstructor) {
/*    */     JavaConstructor javaConstructor;
/* 25 */     if ((javaConstructor = a.get(paramConstructor)) == null) {
/* 26 */       a.put(paramConstructor, javaConstructor = new JavaConstructor(paramConstructor));
/*    */     }
/* 28 */     return javaConstructor;
/*    */   }
/*    */   
/*    */   private Constructor<?> b;
/*    */   
/*    */   private JavaConstructor(Constructor<?> paramConstructor) {
/* 34 */     super(paramConstructor.getParameterTypes(), paramConstructor.getModifiers());
/* 35 */     this.b = paramConstructor;
/*    */   }
/*    */   
/*    */   public final Constructor<?> getConstructor() {
/* 39 */     return this.b;
/*    */   }
/*    */   
/*    */   public final Varargs invoke(Varargs paramVarargs) {
/* 43 */     Object[] arrayOfObject = b(paramVarargs);
/*    */     try {
/* 45 */       return (Varargs)CoerceJavaToLua.coerce(this.b.newInstance(arrayOfObject));
/* 46 */     } catch (Exception exception) {
/*    */       LuaError luaError;
/* 48 */       (luaError = new LuaError("Failed to invoke constructor '" + this.b + "' with arguments: " + paramVarargs + "\nCoerced args: " + Arrays.toString(arrayOfObject))).setCause(exception);
/* 49 */       throw luaError;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JavaConstructor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */