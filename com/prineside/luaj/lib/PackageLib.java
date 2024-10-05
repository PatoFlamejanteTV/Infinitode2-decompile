/*     */ package com.prineside.luaj.lib;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.Globals;
/*     */ import com.prineside.luaj.LuaBoolean;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.LuaTable;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class PackageLib
/*     */   extends TwoArgFunction
/*     */   implements KryoSerializable
/*     */ {
/*     */   public static final String DEFAULT_LUA_PATH = "?.lua";
/*  85 */   static final LuaString a = valueOf("loaded");
/*  86 */   private static final LuaString j = valueOf("loadlib");
/*  87 */   static final LuaString b = valueOf("preload");
/*  88 */   static final LuaString e = valueOf("path");
/*  89 */   static final LuaString f = valueOf("searchpath");
/*  90 */   static final LuaString g = valueOf("searchers");
/*     */ 
/*     */   
/*     */   Globals h;
/*     */ 
/*     */   
/*     */   LuaTable i;
/*     */ 
/*     */   
/*     */   public preload_searcher preload_searcher;
/*     */ 
/*     */   
/*     */   public lua_searcher lua_searcher;
/*     */   
/* 104 */   private static final LuaString k = valueOf("\001");
/*     */   
/* 106 */   private static final String l = System.getProperty("file.separator");
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/* 110 */     paramKryo.writeClassAndObject(paramOutput, this.h);
/* 111 */     paramKryo.writeClassAndObject(paramOutput, this.i);
/* 112 */     paramKryo.writeClassAndObject(paramOutput, this.preload_searcher);
/* 113 */     paramKryo.writeClassAndObject(paramOutput, this.lua_searcher);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/* 118 */     this.h = (Globals)paramKryo.readClassAndObject(paramInput);
/* 119 */     this.i = (LuaTable)paramKryo.readClassAndObject(paramInput);
/* 120 */     this.preload_searcher = (preload_searcher)paramKryo.readClassAndObject(paramInput);
/* 121 */     this.lua_searcher = (lua_searcher)paramKryo.readClassAndObject(paramInput);
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
/*     */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 134 */     this.h = paramLuaValue2.checkglobals();
/* 135 */     this.h.set("require", (LuaValue)new require(this, (byte)0));
/* 136 */     this.i = new LuaTable();
/* 137 */     this.i.set((LuaValue)a, (LuaValue)new LuaTable());
/* 138 */     this.i.set((LuaValue)b, (LuaValue)new LuaTable());
/* 139 */     this.i.set((LuaValue)e, (LuaValue)LuaValue.valueOf("?.lua"));
/* 140 */     this.i.set((LuaValue)j, (LuaValue)new loadlib());
/* 141 */     this.i.set((LuaValue)f, (LuaValue)new searchpath(this, (byte)0));
/*     */     LuaTable luaTable;
/* 143 */     (luaTable = new LuaTable()).set(1, (LuaValue)(this.preload_searcher = new preload_searcher(this, (byte)0)));
/* 144 */     luaTable.set(2, (LuaValue)(this.lua_searcher = new lua_searcher(this, (byte)0)));
/* 145 */     this.i.set((LuaValue)g, (LuaValue)luaTable);
/* 146 */     this.i.set("config", l + "\n;\n?\n!\n-\n");
/* 147 */     this.i.get((LuaValue)a).set("package", (LuaValue)this.i);
/* 148 */     paramLuaValue2.set("package", (LuaValue)this.i);
/* 149 */     this.h.package_ = this;
/* 150 */     return paramLuaValue2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIsLoaded(String paramString, LuaTable paramLuaTable) {
/* 155 */     this.i.get((LuaValue)a).set(paramString, (LuaValue)paramLuaTable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLuaPath(String paramString) {
/* 162 */     this.i.set((LuaValue)e, (LuaValue)LuaValue.valueOf(paramString));
/*     */   }
/*     */   
/*     */   public final String tojstring() {
/* 166 */     return "package";
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
/*     */   @REGS
/*     */   public static class require
/*     */     extends OneArgFunction
/*     */     implements KryoSerializable
/*     */   {
/*     */     private PackageLib a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 204 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 209 */       this.a = (PackageLib)param1Kryo.readObject(param1Input, PackageLib.class);
/*     */     }
/*     */     
/*     */     private require() {}
/*     */     
/*     */     private require(PackageLib param1PackageLib) {
/* 215 */       this.a = param1PackageLib;
/*     */     } public LuaValue call(LuaValue param1LuaValue) {
/*     */       LuaBoolean luaBoolean;
/*     */       Varargs varargs;
/* 219 */       LuaString luaString = param1LuaValue.checkstring();
/*     */       
/*     */       LuaValue luaValue1, luaValue3;
/* 222 */       if ((luaValue3 = (luaValue1 = this.a.i.get((LuaValue)PackageLib.a)).get((LuaValue)luaString)).toboolean()) {
/*     */         
/* 224 */         if (luaValue3 == PackageLib.d())
/* 225 */           error("loop or previous error loading module '" + luaString + "'"); 
/* 226 */         return luaValue3;
/*     */       } 
/*     */ 
/*     */       
/* 230 */       LuaTable luaTable = this.a.i.get((LuaValue)PackageLib.g).checktable();
/* 231 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/* 233 */       byte b = 1;
/*     */       while (true) {
/*     */         LuaValue luaValue;
/* 236 */         if ((luaValue = luaTable.get(b)).isnil())
/*     */         {
/* 238 */           error("module '" + luaString + "' not found: " + luaString + stringBuilder);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 243 */         if (!(varargs = luaValue.invoke((Varargs)luaString)).isfunction(1)) {
/*     */ 
/*     */ 
/*     */           
/* 247 */           if (varargs.isstring(1))
/* 248 */             stringBuilder.append(varargs.tojstring(1));  b++;
/*     */         } 
/*     */         break;
/*     */       } 
/* 252 */       luaValue1.set((LuaValue)luaString, (LuaValue)PackageLib.d());
/*     */       LuaValue luaValue2;
/* 254 */       if (!(luaValue2 = varargs.arg1().call((LuaValue)luaString, varargs.arg(2))).isnil()) {
/* 255 */         luaValue1.set((LuaValue)luaString, luaValue2);
/* 256 */       } else if ((luaValue2 = luaValue1.get((LuaValue)luaString)) == PackageLib.d()) {
/* 257 */         luaValue1.set((LuaValue)luaString, (LuaValue)(luaBoolean = LuaValue.TRUE));
/* 258 */       }  return (LuaValue)luaBoolean;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class loadlib extends VarArgFunction {
/*     */     public Varargs invoke(Varargs param1Varargs) {
/* 265 */       param1Varargs.checkstring(1);
/* 266 */       return LuaValue.varargsOf(NIL, (LuaValue)valueOf("dynamic libraries not enabled"), (Varargs)valueOf("absent"));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static class preload_searcher
/*     */     extends VarArgFunction
/*     */     implements KryoSerializable
/*     */   {
/*     */     private PackageLib a;
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 280 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 285 */       this.a = (PackageLib)param1Kryo.readObject(param1Input, PackageLib.class);
/*     */     }
/*     */     
/*     */     private preload_searcher() {}
/*     */     
/*     */     private preload_searcher(PackageLib param1PackageLib) {
/* 291 */       this.a = param1PackageLib;
/*     */     }
/*     */     
/*     */     public Varargs invoke(Varargs param1Varargs) {
/* 295 */       LuaString luaString = param1Varargs.checkstring(1);
/*     */       LuaValue luaValue;
/* 297 */       if ((luaValue = this.a.i.get((LuaValue)PackageLib.b).get((LuaValue)luaString)).isnil())
/* 298 */         return (Varargs)valueOf("\n\tno field package.preload['" + luaString + "']"); 
/* 299 */       return (Varargs)luaValue;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static class lua_searcher
/*     */     extends VarArgFunction
/*     */     implements KryoSerializable
/*     */   {
/*     */     private PackageLib a;
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 313 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 318 */       this.a = (PackageLib)param1Kryo.readObject(param1Input, PackageLib.class);
/*     */     }
/*     */     
/*     */     private lua_searcher() {}
/*     */     
/*     */     private lua_searcher(PackageLib param1PackageLib) {
/* 324 */       this.a = param1PackageLib;
/*     */     }
/*     */     
/*     */     public Varargs invoke(Varargs param1Varargs) {
/* 328 */       LuaString luaString1 = param1Varargs.checkstring(1);
/*     */       
/*     */       LuaValue luaValue2;
/*     */       
/* 332 */       if (!(luaValue2 = this.a.i.get((LuaValue)PackageLib.e)).isstring()) {
/* 333 */         return (Varargs)valueOf("package.path is not a string");
/*     */       }
/*     */ 
/*     */       
/*     */       Varargs varargs;
/*     */       
/* 339 */       if (!(varargs = this.a.i.get((LuaValue)PackageLib.f).invoke(varargsOf((LuaValue)luaString1, (Varargs)luaValue2))).isstring(1))
/* 340 */         return (Varargs)varargs.arg(2).tostring(); 
/* 341 */       LuaString luaString2 = varargs.arg1().strvalue();
/*     */       
/*     */       LuaValue luaValue1;
/*     */       
/* 345 */       if ((luaValue1 = this.a.h.loadfile(luaString2.tojstring())).arg1().isfunction()) {
/* 346 */         return varargsOf(luaValue1.arg1(), (Varargs)luaString2);
/*     */       }
/*     */       
/* 349 */       return varargsOf(NIL, (Varargs)valueOf("'" + luaString2 + "': " + luaValue1.arg(2).tojstring()));
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class searchpath
/*     */     extends VarArgFunction implements KryoSerializable {
/*     */     private PackageLib a;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 359 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 364 */       this.a = (PackageLib)param1Kryo.readObject(param1Input, PackageLib.class);
/*     */     }
/*     */     
/*     */     private searchpath() {}
/*     */     
/*     */     private searchpath(PackageLib param1PackageLib) {
/* 370 */       this.a = param1PackageLib;
/*     */     }
/*     */     
/*     */     public Varargs invoke(Varargs param1Varargs) {
/* 374 */       String str2 = param1Varargs.checkjstring(1);
/* 375 */       String str3 = param1Varargs.checkjstring(2);
/* 376 */       String str4 = param1Varargs.optjstring(3, ".");
/* 377 */       String str1 = param1Varargs.optjstring(4, PackageLib.e());
/*     */ 
/*     */       
/* 380 */       int i = -1;
/* 381 */       int j = str3.length();
/* 382 */       StringBuffer stringBuffer = null;
/* 383 */       str2 = str2.replace(str4.charAt(0), str1.charAt(0));
/* 384 */       while (i < j) {
/*     */ 
/*     */         
/* 387 */         int k = i + 1;
/*     */         
/* 389 */         if ((i = str3.indexOf(';', k)) < 0) {
/* 390 */           i = str3.length();
/*     */         }
/*     */         
/*     */         String str5;
/* 394 */         int m = (str5 = str3.substring(k, i)).indexOf('?');
/* 395 */         String str6 = str5;
/* 396 */         if (m >= 0) {
/* 397 */           str6 = str5.substring(0, m) + str2 + str5.substring(m + 1);
/*     */         }
/*     */         
/*     */         InputStream inputStream;
/*     */         
/* 402 */         if ((inputStream = this.a.h.finder.findResource(str6)) != null) { 
/* 403 */           try { inputStream.close(); } catch (IOException iOException) {}
/* 404 */           return (Varargs)valueOf(str6); }
/*     */ 
/*     */ 
/*     */         
/* 408 */         if (stringBuffer == null)
/* 409 */           stringBuffer = new StringBuffer(); 
/* 410 */         stringBuffer.append("\n\t" + str6);
/*     */       } 
/* 412 */       return varargsOf(NIL, (Varargs)valueOf(stringBuffer.toString()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\PackageLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */