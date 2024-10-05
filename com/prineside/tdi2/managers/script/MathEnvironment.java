/*     */ package com.prineside.tdi2.managers.script;
/*     */ 
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.luaj.Globals;
/*     */ import com.prineside.luaj.LoadState;
/*     */ import com.prineside.luaj.LuaFunction;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.compiler.LuaC;
/*     */ import com.prineside.luaj.lib.Bit32Lib;
/*     */ import com.prineside.luaj.lib.DebugLib;
/*     */ import com.prineside.luaj.lib.jse.JseBaseLib;
/*     */ import com.prineside.luaj.lib.jse.JseMathLib;
/*     */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MathEnvironment
/*     */ {
/*     */   private final Globals a;
/*  21 */   private final ObjectMap<String, PreparedMathExpression> b = new ObjectMap();
/*     */   
/*     */   public MathEnvironment() {
/*  24 */     this.a = new Globals();
/*  25 */     this.a.load((LuaValue)new JseBaseLib());
/*     */ 
/*     */     
/*  28 */     this.a.load((LuaValue)new Bit32Lib());
/*     */ 
/*     */ 
/*     */     
/*  32 */     this.a.load((LuaValue)new JseMathLib());
/*     */ 
/*     */ 
/*     */     
/*  36 */     this.a.load((LuaValue)new DebugLib());
/*  37 */     LoadState.install(this.a);
/*     */     
/*  39 */     LuaC luaC = new LuaC();
/*  40 */     this.a.compiler = (Globals.Compiler)luaC;
/*  41 */     this.a.loader = (Globals.Loader)luaC;
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
/*     */   public synchronized PreparedMathExpression prepare(String paramString) {
/*     */     int i;
/*  54 */     if ((i = paramString.indexOf("->")) == -1) {
/*  55 */       throw new IllegalArgumentException("Must be \"args -> function\", got: " + paramString);
/*     */     }
/*     */     
/*  58 */     String str = paramString.substring(0, i).trim();
/*     */     
/*  60 */     paramString = (paramString = paramString.substring(i + 2).trim()).replaceAll(";", "\n");
/*  61 */     paramString = "return function(" + str + ")\n    " + (paramString.contains("return ") ? "" : "return ") + paramString + "\nend";
/*  62 */     return new PreparedMathExpression((LuaFunction)this.a.load(paramString, "Prepared math expression").call(), (byte)0);
/*     */   }
/*     */   
/*     */   public synchronized PreparedMathExpression cached(String paramString) {
/*     */     PreparedMathExpression preparedMathExpression;
/*  67 */     if ((preparedMathExpression = (PreparedMathExpression)this.b.get(paramString)) == null) {
/*  68 */       preparedMathExpression = prepare(paramString);
/*  69 */       this.b.put(paramString, preparedMathExpression);
/*     */     } 
/*  71 */     return preparedMathExpression;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class PreparedMathExpression
/*     */   {
/*     */     private final LuaFunction a;
/*     */ 
/*     */ 
/*     */     
/*     */     private PreparedMathExpression(LuaFunction param1LuaFunction) {
/*  84 */       this.a = param1LuaFunction;
/*     */     }
/*     */     
/*     */     @IgnoreMethodOverloadLuaDefWarning
/*     */     public final double eval(double param1Double) {
/*  89 */       synchronized (this.a) {
/*  90 */         return this.a.call((LuaValue)LuaValue.cDouble(param1Double)).todouble();
/*     */       } 
/*     */     }
/*     */     
/*     */     @IgnoreMethodOverloadLuaDefWarning
/*     */     public final double eval(double param1Double1, double param1Double2) {
/*  96 */       synchronized (this.a) {
/*  97 */         return this.a.call((LuaValue)LuaValue.cDouble(param1Double1), (LuaValue)LuaValue.cDouble(param1Double2)).todouble();
/*     */       } 
/*     */     }
/*     */     
/*     */     @IgnoreMethodOverloadLuaDefWarning
/*     */     public final double eval(double param1Double1, double param1Double2, double param1Double3) {
/* 103 */       synchronized (this.a) {
/* 104 */         return this.a.call((LuaValue)LuaValue.cDouble(param1Double1), (LuaValue)LuaValue.cDouble(param1Double2), (LuaValue)LuaValue.cDouble(param1Double3)).todouble();
/*     */       } 
/*     */     }
/*     */     
/*     */     @IgnoreMethodOverloadLuaDefWarning
/*     */     public final double eval() {
/* 110 */       synchronized (this.a) {
/* 111 */         return this.a.call().todouble();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\script\MathEnvironment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */