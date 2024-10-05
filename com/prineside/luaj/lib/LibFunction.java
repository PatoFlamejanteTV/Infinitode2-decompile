/*     */ package com.prineside.luaj.lib;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.LuaError;
/*     */ import com.prineside.luaj.LuaFunction;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class LibFunction
/*     */   extends LuaFunction
/*     */   implements KryoSerializable
/*     */ {
/*     */   protected int c;
/*     */   protected String d;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/* 144 */     paramOutput.writeInt(this.c);
/* 145 */     paramKryo.writeObjectOrNull(paramOutput, this.d, String.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/* 150 */     this.c = paramInput.readInt();
/* 151 */     this.d = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String tojstring() {
/* 159 */     return (this.d != null) ? ("function: " + this.d) : super.tojstring();
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
/*     */   protected final void a(LuaValue paramLuaValue, Class<?> paramClass, String[] paramArrayOfString) {
/* 173 */     a(paramLuaValue, paramClass, paramArrayOfString, 0);
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
/*     */   protected static Array<LibFunction> a(LuaValue paramLuaValue, Class<?> paramClass, String[] paramArrayOfString, int paramInt) {
/*     */     try {
/* 189 */       Array<LibFunction> array = new Array(LibFunction.class); byte b; int i;
/* 190 */       for (b = 0, i = paramArrayOfString.length; b < i; b++) {
/*     */         LibFunction libFunction;
/* 192 */         (libFunction = paramClass.getConstructor(new Class[0]).newInstance(new Object[0])).c = paramInt + b;
/* 193 */         libFunction.d = paramArrayOfString[b];
/* 194 */         paramLuaValue.set(libFunction.d, (LuaValue)libFunction);
/* 195 */         array.add(libFunction);
/*     */       } 
/* 197 */       return array;
/* 198 */     } catch (Exception exception) {
/* 199 */       throw new LuaError("bind failed: " + exception);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaValue call() {
/* 219 */     return argerror(1, "value expected");
/*     */   }
/*     */   public LuaValue call(LuaValue paramLuaValue) {
/* 222 */     return call();
/*     */   }
/*     */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 225 */     return call(paramLuaValue1);
/*     */   }
/*     */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3) {
/* 228 */     return call(paramLuaValue1, paramLuaValue2);
/*     */   }
/*     */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3, LuaValue paramLuaValue4) {
/* 231 */     return call(paramLuaValue1, paramLuaValue2, paramLuaValue3);
/*     */   }
/*     */   public Varargs invoke(Varargs paramVarargs) {
/* 234 */     switch (paramVarargs.narg()) { case 0:
/* 235 */         return (Varargs)call();
/* 236 */       case 1: return (Varargs)call(paramVarargs.arg1());
/* 237 */       case 2: return (Varargs)call(paramVarargs.arg1(), paramVarargs.arg(2));
/* 238 */       case 3: return (Varargs)call(paramVarargs.arg1(), paramVarargs.arg(2), paramVarargs.arg(3)); }
/* 239 */      return (Varargs)call(paramVarargs.arg1(), paramVarargs.arg(2), paramVarargs.arg(3), paramVarargs.arg(4));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\LibFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */