/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.lib.MathLib;
/*     */ import com.prineside.luaj.lib.TwoArgFunction;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JseMathLib
/*     */   extends MathLib
/*     */ {
/*     */   public final LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/*  72 */     super.call(paramLuaValue1, paramLuaValue2);
/*     */     
/*  74 */     (paramLuaValue1 = paramLuaValue2.get("math")).set("acos", (LuaValue)new acos());
/*  75 */     paramLuaValue1.set("asin", (LuaValue)new asin());
/*  76 */     atan2 atan2 = new atan2();
/*  77 */     paramLuaValue1.set("atan", (LuaValue)atan2);
/*  78 */     paramLuaValue1.set("atan2", (LuaValue)atan2);
/*  79 */     paramLuaValue1.set("cosh", (LuaValue)new cosh());
/*  80 */     paramLuaValue1.set("exp", (LuaValue)new exp());
/*  81 */     paramLuaValue1.set("log", (LuaValue)new log());
/*  82 */     paramLuaValue1.set("pow", (LuaValue)new pow());
/*  83 */     paramLuaValue1.set("sinh", (LuaValue)new sinh());
/*  84 */     paramLuaValue1.set("tanh", (LuaValue)new tanh());
/*  85 */     return paramLuaValue1;
/*     */   }
/*     */   @REGS
/*     */   public static final class acos extends MathLib.UnaryOp { protected final double a(double param1Double) {
/*  89 */       return StrictMath.acos(param1Double);
/*     */     } } @REGS
/*     */   public static final class asin extends MathLib.UnaryOp { protected final double a(double param1Double) {
/*  92 */       return StrictMath.asin(param1Double);
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static final class atan2 extends TwoArgFunction { public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/*  97 */       return (LuaValue)valueOf(StrictMath.atan2(param1LuaValue1.checkdouble(), param1LuaValue2.optdouble(1.0D)));
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static final class cosh extends MathLib.UnaryOp { protected final double a(double param1Double) {
/* 102 */       return StrictMath.cosh(param1Double);
/*     */     } } @REGS
/*     */   public static final class exp extends MathLib.UnaryOp { protected final double a(double param1Double) {
/* 105 */       return StrictMath.exp(param1Double);
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static final class log extends TwoArgFunction { public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/* 110 */       double d1 = StrictMath.log(param1LuaValue1.checkdouble());
/*     */       double d2;
/* 112 */       if ((d2 = param1LuaValue2.optdouble(Math.E)) != Math.E) d1 /= StrictMath.log(d2); 
/* 113 */       return (LuaValue)valueOf(d1);
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static final class pow extends MathLib.BinaryOp { protected final double a(double param1Double1, double param1Double2) {
/* 118 */       return StrictMath.pow(param1Double1, param1Double2);
/*     */     } } @REGS
/*     */   public static final class sinh extends MathLib.UnaryOp { protected final double a(double param1Double) {
/* 121 */       return StrictMath.sinh(param1Double);
/*     */     } } @REGS
/*     */   public static final class tanh extends MathLib.UnaryOp { protected final double a(double param1Double) {
/* 124 */       return StrictMath.tanh(param1Double);
/*     */     } }
/*     */   
/*     */   public final double dpow_lib(double paramDouble1, double paramDouble2) {
/* 128 */     return StrictMath.pow(paramDouble1, paramDouble2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JseMathLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */