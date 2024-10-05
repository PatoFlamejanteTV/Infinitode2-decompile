/*     */ package com.prineside.luaj.compiler;
/*     */ 
/*     */ import com.prineside.luaj.Globals;
/*     */ import com.prineside.luaj.LuaClosure;
/*     */ import com.prineside.luaj.LuaFunction;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Prototype;
/*     */ import java.io.InputStream;
/*     */ import java.util.Hashtable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LuaC
/*     */   extends Constants
/*     */   implements Globals.Compiler, Globals.Loader
/*     */ {
/*  74 */   public static final LuaC instance = new LuaC();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void install(Globals paramGlobals) {
/*  82 */     paramGlobals.compiler = instance;
/*  83 */     paramGlobals.loader = instance;
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
/*     */   public Prototype compile(InputStream paramInputStream, String paramString) {
/*  95 */     return (new CompileState()).a(paramInputStream, paramString);
/*     */   }
/*     */   
/*     */   public LuaFunction load(Prototype paramPrototype, String paramString, LuaValue paramLuaValue) {
/*  99 */     return (LuaFunction)new LuaClosure(paramPrototype.toFixedProto(), paramLuaValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaValue load(InputStream paramInputStream, String paramString, Globals paramGlobals) {
/* 107 */     return (LuaValue)new LuaClosure(compile(paramInputStream, paramString).toFixedProto(), (LuaValue)paramGlobals);
/*     */   }
/*     */   
/*     */   static class CompileState {
/* 111 */     int a = 0;
/* 112 */     private Hashtable b = new Hashtable<>();
/*     */ 
/*     */ 
/*     */     
/*     */     final Prototype a(InputStream param1InputStream, String param1String) {
/* 117 */       LexState lexState = new LexState(this, param1InputStream);
/* 118 */       FuncState funcState = new FuncState();
/*     */       
/* 120 */       lexState.b = funcState;
/* 121 */       lexState.a(this, param1InputStream.read(), param1InputStream, LuaValue.valueOf(param1String));
/*     */       
/* 123 */       funcState.a = new Prototype();
/* 124 */       funcState.a.source = LuaValue.valueOf(param1String);
/* 125 */       lexState.mainfunc(funcState);
/* 126 */       LuaC.a((funcState.b == null));
/*     */       
/* 128 */       LuaC.a((lexState.d == null || (lexState.d.b == 0 && lexState.d.d == 0 && lexState.d.f == 0)));
/*     */       
/* 130 */       return funcState.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public LuaString newTString(String param1String) {
/* 135 */       return cachedLuaString(LuaString.valueOf(param1String));
/*     */     }
/*     */ 
/*     */     
/*     */     public LuaString newTString(LuaString param1LuaString) {
/* 140 */       return cachedLuaString(param1LuaString);
/*     */     }
/*     */     
/*     */     public LuaString cachedLuaString(LuaString param1LuaString) {
/*     */       LuaString luaString;
/* 145 */       if ((luaString = (LuaString)this.b.get(param1LuaString)) != null)
/* 146 */         return luaString; 
/* 147 */       this.b.put(param1LuaString, param1LuaString);
/* 148 */       return param1LuaString;
/*     */     }
/*     */     
/*     */     public String pushfstring(String param1String) {
/* 152 */       return param1String;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\compiler\LuaC.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */