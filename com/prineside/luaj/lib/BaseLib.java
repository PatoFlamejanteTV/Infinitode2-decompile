/*     */ package com.prineside.luaj.lib;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.Globals;
/*     */ import com.prineside.luaj.LuaError;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.LuaTable;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.luaj.debug.CallStack;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
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
/*     */ public abstract class BaseLib
/*     */   extends TwoArgFunction
/*     */   implements KryoSerializable, ResourceFinder
/*     */ {
/*  81 */   private static final TLog b = TLog.forClass(BaseLib.class);
/*     */   
/*     */   Globals a;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  86 */     paramKryo.writeObjectOrNull(paramOutput, this.a, Globals.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  91 */     this.a = (Globals)paramKryo.readObjectOrNull(paramInput, Globals.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 100 */     this.a = paramLuaValue2.checkglobals();
/* 101 */     this.a.finder = this;
/* 102 */     this.a.baselib = this;
/* 103 */     paramLuaValue2.set("_G", paramLuaValue2);
/* 104 */     paramLuaValue2.set("_VERSION", "Lua 5.2");
/* 105 */     paramLuaValue2.set("_LUAJ_VERSION", "Luaj 3.0.2 custom");
/* 106 */     paramLuaValue2.set("assert", (LuaValue)new _assert());
/* 107 */     paramLuaValue2.set("collectgarbage", (LuaValue)new collectgarbage());
/* 108 */     paramLuaValue2.set("dofile", (LuaValue)new dofile(this, (byte)0));
/* 109 */     paramLuaValue2.set("error", (LuaValue)new error());
/* 110 */     paramLuaValue2.set("getmetatable", (LuaValue)new getmetatable());
/* 111 */     paramLuaValue2.set("load", (LuaValue)new load(this, (byte)0));
/* 112 */     paramLuaValue2.set("loadfile", (LuaValue)new loadfile(this, (byte)0));
/* 113 */     paramLuaValue2.set("pcall", (LuaValue)new pcall(this, (byte)0));
/* 114 */     paramLuaValue2.set("print", (LuaValue)new print(this));
/* 115 */     paramLuaValue2.set("rawequal", (LuaValue)new rawequal());
/* 116 */     paramLuaValue2.set("rawget", (LuaValue)new rawget());
/* 117 */     paramLuaValue2.set("rawlen", (LuaValue)new rawlen());
/* 118 */     paramLuaValue2.set("rawset", (LuaValue)new rawset());
/* 119 */     paramLuaValue2.set("select", (LuaValue)new select());
/* 120 */     paramLuaValue2.set("setmetatable", (LuaValue)new setmetatable());
/* 121 */     paramLuaValue2.set("tonumber", (LuaValue)new tonumber());
/* 122 */     paramLuaValue2.set("tostring", (LuaValue)new tostring());
/* 123 */     paramLuaValue2.set("type", (LuaValue)new type());
/* 124 */     paramLuaValue2.set("xpcall", (LuaValue)new xpcall(this, (byte)0));
/*     */     
/*     */     next next;
/* 127 */     paramLuaValue2.set("next", (LuaValue)(next = new next()));
/* 128 */     paramLuaValue2.set("pairs", (LuaValue)new pairs(next));
/* 129 */     paramLuaValue2.set("ipairs", (LuaValue)new ipairs());
/*     */     
/* 131 */     return paramLuaValue2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream findResource(String paramString) {
/* 141 */     if (paramString.contains("..")) {
/* 142 */       b.e("filename should not contain ../", new Object[0]);
/* 143 */       return null;
/*     */     } 
/*     */     
/*     */     FileHandle fileHandle;
/* 147 */     if (!(fileHandle = Gdx.files.local(paramString)).exists()) {
/* 148 */       fileHandle = Gdx.files.internal(paramString);
/*     */     }
/* 150 */     if (!fileHandle.exists()) {
/* 151 */       return null;
/*     */     }
/*     */     
/* 154 */     if (fileHandle.isDirectory()) {
/* 155 */       b.e("Cannot open a stream to a directory: " + paramString, new Object[0]);
/* 156 */       return null;
/*     */     } 
/*     */     
/* 159 */     return fileHandle.read();
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class _assert
/*     */     extends VarArgFunction {
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/* 166 */       if (!param1Varargs.arg1().toboolean())
/* 167 */         error((param1Varargs.narg() > 1) ? param1Varargs.optjstring(2, "assertion failed!") : "assertion failed!"); 
/* 168 */       return param1Varargs;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class collectgarbage extends VarArgFunction {
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/*     */       Runtime runtime;
/* 176 */       String str = param1Varargs.optjstring(1, "collect");
/* 177 */       if ("collect".equals(str)) {
/* 178 */         System.gc();
/* 179 */         return (Varargs)ZERO;
/* 180 */       }  if ("count".equals(str)) {
/*     */         long l;
/*     */         
/* 183 */         return varargsOf((LuaValue)valueOf((l = (runtime = Runtime.getRuntime()).totalMemory() - runtime.freeMemory()) / 1024.0D), (Varargs)valueOf((l % 1024L)));
/* 184 */       }  if ("step".equals(runtime)) {
/* 185 */         System.gc();
/* 186 */         return (Varargs)LuaValue.TRUE;
/* 187 */       }  if ("stop".equals(runtime) || "restart".equals(runtime) || "setpause".equals(runtime) || "setstepmul".equals(runtime)) {
/*     */         
/* 189 */         BaseLib.d().i("collectgarbage option " + runtime + " is ignored - Java's GC is used. Only 'collect' (System.gc()) and 'count' (total - free memory of Java) options are available", new Object[0]);
/* 190 */         return (Varargs)LuaValue.TRUE;
/*     */       } 
/* 192 */       argerror(1, "invalid option '" + runtime + "'");
/*     */       
/* 194 */       return (Varargs)NIL;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class dofile
/*     */     extends VarArgFunction
/*     */     implements KryoSerializable {
/*     */     private BaseLib a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 205 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 210 */       this.a = (BaseLib)param1Kryo.readClassAndObject(param1Input);
/*     */     }
/*     */     
/*     */     private dofile() {}
/*     */     
/*     */     private dofile(BaseLib param1BaseLib) {
/* 216 */       if (param1BaseLib == null) throw new IllegalArgumentException("baseLib cannot be null"); 
/* 217 */       this.a = param1BaseLib;
/*     */     }
/*     */     
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/* 221 */       param1Varargs.argcheck((param1Varargs.isstring(1) || param1Varargs.isnil(1)), 1, "filename must be string or nil");
/*     */ 
/*     */       
/*     */       String str;
/*     */       
/* 226 */       return (Varargs)((param1Varargs = ((str = (String)(param1Varargs.isstring(1) ? param1Varargs.tojstring(1) : null)) == null) ? this.a.loadStream(this.a.a.STDIN, "=stdin", "bt", (LuaValue)this.a.a) : this.a.loadFile(param1Varargs.checkjstring(1), "bt", (LuaValue)this.a.a)).isnil(1) ? error(param1Varargs.tojstring(2)) : param1Varargs.arg1().invoke());
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class error
/*     */     extends TwoArgFunction {
/*     */     public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/* 234 */       if (param1LuaValue1.isnil()) throw new LuaError(NIL); 
/* 235 */       if (!param1LuaValue1.isstring() || param1LuaValue2.optint(1) == 0) throw new LuaError(param1LuaValue1); 
/* 236 */       throw new LuaError(param1LuaValue1.tojstring(), param1LuaValue2.optint(1));
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class getmetatable
/*     */     extends LibFunction {
/*     */     public final LuaValue call() {
/* 244 */       return argerror(1, "value expected");
/*     */     }
/*     */     
/*     */     public final LuaValue call(LuaValue param1LuaValue) {
/* 248 */       return ((param1LuaValue = param1LuaValue.getmetatable()) != null) ? param1LuaValue.rawget((LuaValue)METATABLE).optvalue(param1LuaValue) : NIL;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class load
/*     */     extends VarArgFunction implements KryoSerializable {
/*     */     private BaseLib a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 258 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 263 */       this.a = (BaseLib)param1Kryo.readClassAndObject(param1Input);
/*     */     }
/*     */     
/*     */     private load() {}
/*     */     
/*     */     private load(BaseLib param1BaseLib) {
/* 269 */       if (param1BaseLib == null) throw new IllegalArgumentException("baseLib cannot be null");
/*     */       
/* 271 */       this.a = param1BaseLib;
/*     */     }
/*     */     
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/*     */       LuaValue luaValue2;
/* 276 */       if (!(luaValue2 = param1Varargs.arg1()).isstring() && !luaValue2.isfunction()) {
/* 277 */         throw new LuaError("bad argument #1 to 'load' (string or function expected, got " + luaValue2.typename() + ")");
/*     */       }
/* 279 */       String str1 = param1Varargs.optjstring(2, luaValue2.isstring() ? luaValue2.tojstring() : "=(load)");
/* 280 */       String str2 = param1Varargs.optjstring(3, "bt");
/* 281 */       LuaValue luaValue1 = param1Varargs.optvalue(4, (LuaValue)this.a.a);
/* 282 */       return this.a.loadStream(luaValue2.isstring() ? luaValue2.strvalue().toInputStream() : 
/* 283 */           new BaseLib.StringInputStream((LuaValue)luaValue2.checkfunction()), str1, str2, luaValue1);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class loadfile
/*     */     extends VarArgFunction
/*     */     implements KryoSerializable {
/*     */     private BaseLib a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 294 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 299 */       this.a = (BaseLib)param1Kryo.readClassAndObject(param1Input);
/*     */     }
/*     */ 
/*     */     
/*     */     private loadfile() {}
/*     */ 
/*     */     
/*     */     private loadfile(BaseLib param1BaseLib) {
/* 307 */       this.a = param1BaseLib;
/*     */     }
/*     */     
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/* 311 */       param1Varargs.argcheck((param1Varargs.isstring(1) || param1Varargs.isnil(1)), 1, "filename must be string or nil");
/* 312 */       String str1 = param1Varargs.isstring(1) ? param1Varargs.tojstring(1) : null;
/* 313 */       String str2 = param1Varargs.optjstring(2, "bt");
/* 314 */       LuaValue luaValue = param1Varargs.optvalue(3, (LuaValue)this.a.a);
/* 315 */       if (str1 == null)
/* 316 */         return this.a.loadStream(this.a.a.STDIN, "=stdin", str2, luaValue); 
/* 317 */       return this.a.loadFile(str1, str2, luaValue);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class pcall
/*     */     extends VarArgFunction
/*     */     implements KryoSerializable {
/*     */     private BaseLib a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 328 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 333 */       this.a = (BaseLib)param1Kryo.readClassAndObject(param1Input);
/*     */     }
/*     */ 
/*     */     
/*     */     private pcall() {}
/*     */ 
/*     */     
/*     */     private pcall(BaseLib param1BaseLib) {
/* 341 */       this.a = param1BaseLib;
/*     */     }
/*     */     
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/* 345 */       LuaValue luaValue = param1Varargs.checkvalue(1);
/* 346 */       CallStack callStack = CallStack.DUMMY;
/* 347 */       if (this.a.a != null)
/*     */       {
/* 349 */         (callStack = this.a.a.getCallstack()).onCall(this);
/*     */       }
/*     */       
/*     */       try {
/* 353 */         if ((param1Varargs = luaValue.invoke(param1Varargs.subargs(2))).narg() == 0) {
/* 354 */           return (Varargs)TRUE;
/*     */         }
/* 356 */         return varargsOf((LuaValue)TRUE, param1Varargs);
/*     */       }
/* 358 */       catch (LuaError luaError) {
/* 359 */         luaValue = (param1Varargs = null).getMessageObject();
/* 360 */         param1Varargs = varargsOf((LuaValue)FALSE, (luaValue != null) ? (Varargs)luaValue : (Varargs)NIL); return param1Varargs;
/* 361 */       } catch (Exception exception) {
/* 362 */         String str = (param1Varargs = null).getMessage();
/* 363 */         param1Varargs = varargsOf((LuaValue)FALSE, (Varargs)valueOf((str != null) ? str : param1Varargs.toString())); return param1Varargs;
/*     */       } finally {
/* 365 */         callStack.onReturn();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class print
/*     */     extends VarArgFunction
/*     */     implements KryoSerializable {
/*     */     private BaseLib a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 377 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 382 */       this.a = (BaseLib)param1Kryo.readClassAndObject(param1Input);
/*     */     }
/*     */     
/*     */     private print() {}
/*     */     
/*     */     print(BaseLib param1BaseLib) {
/* 388 */       this.a = param1BaseLib;
/*     */     }
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/* 391 */       StringBuilder stringBuilder = new StringBuilder();
/* 392 */       LuaValue luaValue = this.a.a.get("tostring"); byte b; int i;
/* 393 */       for (b = 1, i = param1Varargs.narg(); b <= i; b++) {
/* 394 */         if (b > 1) {
/* 395 */           stringBuilder.append("\t");
/*     */         }
/* 397 */         LuaString luaString = luaValue.call(param1Varargs.arg(b)).strvalue();
/* 398 */         stringBuilder.append(luaString.tojstring());
/*     */       } 
/* 400 */       TLog.forTag("Script_Print").i(stringBuilder.toString(), new Object[0]);
/* 401 */       return (Varargs)NONE;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class rawequal
/*     */     extends LibFunction
/*     */   {
/*     */     public final LuaValue call() {
/* 410 */       return argerror(1, "value expected");
/*     */     }
/*     */     public final LuaValue call(LuaValue param1LuaValue) {
/* 413 */       return argerror(2, "value expected");
/*     */     }
/*     */     public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/* 416 */       return (LuaValue)valueOf(param1LuaValue1.raweq(param1LuaValue2));
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class rawget
/*     */     extends TableLibFunction {
/*     */     public final LuaValue call(LuaValue param1LuaValue) {
/* 424 */       return argerror(2, "value expected");
/*     */     }
/*     */     public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/* 427 */       return param1LuaValue1.checktable().rawget(param1LuaValue2);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class rawlen
/*     */     extends LibFunction
/*     */   {
/*     */     public final LuaValue call(LuaValue param1LuaValue) {
/* 436 */       return (LuaValue)valueOf(param1LuaValue.rawlen());
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class rawset
/*     */     extends TableLibFunction {
/*     */     public final LuaValue call(LuaValue param1LuaValue) {
/* 444 */       return argerror(2, "value expected");
/*     */     }
/*     */     public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/* 447 */       return argerror(3, "value expected");
/*     */     }
/*     */     public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2, LuaValue param1LuaValue3) {
/* 450 */       LuaTable luaTable = param1LuaValue1.checktable();
/* 451 */       if (!param1LuaValue2.isvalidkey()) argerror(2, "table index is nil"); 
/* 452 */       luaTable.rawset(param1LuaValue2, param1LuaValue3);
/* 453 */       return (LuaValue)luaTable;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class select
/*     */     extends VarArgFunction {
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/* 461 */       int i = param1Varargs.narg() - 1;
/* 462 */       if (param1Varargs.arg1().equals(valueOf("#")))
/* 463 */         return (Varargs)valueOf(i); 
/*     */       int j;
/* 465 */       if ((j = param1Varargs.checkint(1)) == 0 || j < -i)
/* 466 */         argerror(1, "index out of range"); 
/* 467 */       return param1Varargs.subargs((j < 0) ? (i + j + 2) : (j + 1));
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class setmetatable
/*     */     extends TableLibFunction {
/*     */     public final LuaValue call(LuaValue param1LuaValue) {
/* 475 */       return argerror(2, "nil or table expected");
/*     */     }
/*     */     public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/*     */       LuaValue luaValue;
/* 479 */       if ((luaValue = param1LuaValue1.checktable().getmetatable()) != null && !luaValue.rawget((LuaValue)METATABLE).isnil()) {
/* 480 */         error("cannot change a protected metatable");
/*     */       }
/* 482 */       return param1LuaValue1.setmetatable(param1LuaValue2.isnil() ? null : (LuaValue)param1LuaValue2.checktable());
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class tonumber
/*     */     extends LibFunction {
/*     */     public final LuaValue call(LuaValue param1LuaValue) {
/* 490 */       return param1LuaValue.tonumber();
/*     */     }
/*     */     public final LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/* 493 */       if (param1LuaValue2.isnil())
/* 494 */         return param1LuaValue1.tonumber(); 
/*     */       int i;
/* 496 */       if ((i = param1LuaValue2.checkint()) < 2 || i > 36)
/* 497 */         argerror(2, "base out of range"); 
/* 498 */       return param1LuaValue1.checkstring().tonumber(i);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class tostring
/*     */     extends LibFunction {
/*     */     public final LuaValue call(LuaValue param1LuaValue) {
/*     */       LuaValue luaValue;
/* 507 */       if (!(luaValue = param1LuaValue.metatag((LuaValue)TOSTRING)).isnil()) {
/* 508 */         return luaValue.call(param1LuaValue);
/*     */       }
/* 510 */       if (!(luaValue = param1LuaValue.tostring()).isnil()) {
/* 511 */         return luaValue;
/*     */       }
/* 513 */       return (LuaValue)valueOf(param1LuaValue.tojstring());
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class type
/*     */     extends LibFunction {
/*     */     public final LuaValue call(LuaValue param1LuaValue) {
/* 521 */       return (LuaValue)valueOf(param1LuaValue.typename());
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class xpcall
/*     */     extends VarArgFunction
/*     */     implements KryoSerializable {
/*     */     private BaseLib a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 532 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 537 */       this.a = (BaseLib)param1Kryo.readClassAndObject(param1Input);
/*     */     }
/*     */     
/*     */     private xpcall() {}
/*     */     
/*     */     private xpcall(BaseLib param1BaseLib) {
/* 543 */       this.a = param1BaseLib;
/*     */     }
/*     */     
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/* 547 */       LuaValue luaValue = this.a.a.getErrorFunc();
/* 548 */       this.a.a.setErrorFunc(param1Varargs.checkvalue(2));
/*     */       try {
/* 550 */         CallStack callStack = CallStack.DUMMY;
/* 551 */         if (this.a.a != null)
/*     */         {
/* 553 */           (callStack = this.a.a.getCallstack()).onCall(this);
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       finally {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 567 */         if (this.a.a != null)
/* 568 */           this.a.a.setErrorFunc(luaValue); 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class pairs
/*     */     extends VarArgFunction
/*     */     implements KryoSerializable
/*     */   {
/*     */     private BaseLib.next a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 581 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 586 */       this.a = (BaseLib.next)param1Kryo.readClassAndObject(param1Input);
/*     */     }
/*     */     
/*     */     private pairs() {}
/*     */     
/*     */     pairs(BaseLib.next param1next) {
/* 592 */       this.a = param1next;
/*     */     }
/*     */ 
/*     */     
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/*     */       LuaValue luaValue;
/* 598 */       if ((luaValue = param1Varargs.arg1().getmetatable()) != null && (luaValue = luaValue.get((LuaValue)LuaValue.PAIRS)).isfunction()) {
/* 599 */         return luaValue.invoke(param1Varargs);
/*     */       }
/* 601 */       return varargsOf((LuaValue)this.a, (LuaValue)param1Varargs.checktable(1), (Varargs)NIL);
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static final class ipairs extends VarArgFunction { private BaseLib.inext a;
/*     */     
/*     */     public ipairs() {
/* 608 */       this.a = new BaseLib.inext();
/*     */     }
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/*     */       LuaValue luaValue;
/* 612 */       if ((luaValue = param1Varargs.arg1().getmetatable()) != null && (luaValue = luaValue.get((LuaValue)LuaValue.IPAIRS)).isfunction()) {
/* 613 */         return luaValue.invoke(param1Varargs);
/*     */       }
/* 615 */       return varargsOf((LuaValue)this.a, (LuaValue)param1Varargs.checktable(1), (Varargs)ZERO);
/*     */     } }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static final class next
/*     */     extends VarArgFunction {
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/* 623 */       return param1Varargs.checktable(1).next(param1Varargs.arg(2));
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class inext
/*     */     extends VarArgFunction {
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/* 631 */       return param1Varargs.checktable(1).inext(param1Varargs.arg(2));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Varargs loadFile(String paramString1, String paramString2, LuaValue paramLuaValue) {
/*     */     InputStream inputStream;
/* 643 */     if ((inputStream = this.a.finder.findResource(paramString1)) == null)
/* 644 */       return varargsOf(NIL, (Varargs)valueOf("cannot open " + paramString1 + ": No such file or directory")); 
/*     */     try {
/* 646 */       return loadStream(inputStream, "@" + paramString1, paramString2, paramLuaValue);
/*     */     } finally {
/*     */       try {
/* 649 */         inputStream.close();
/* 650 */       } catch (Exception exception) {
/* 651 */         (paramString2 = null).printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Varargs loadStream(InputStream paramInputStream, String paramString1, String paramString2, LuaValue paramLuaValue) {
/*     */     try {
/* 658 */       if (paramInputStream == null)
/* 659 */         return varargsOf(NIL, (Varargs)valueOf("not found: " + paramString1)); 
/* 660 */       return (Varargs)this.a.load(paramInputStream, paramString1, paramString2, paramLuaValue);
/* 661 */     } catch (Exception exception) {
/* 662 */       return varargsOf(NIL, (Varargs)valueOf(exception.getMessage()));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class StringInputStream extends InputStream {
/*     */     private LuaValue a;
/*     */     private byte[] b;
/*     */     private int c;
/* 670 */     private int d = 0;
/*     */     StringInputStream(LuaValue param1LuaValue) {
/* 672 */       this.a = param1LuaValue;
/*     */     }
/*     */     public int read() {
/* 675 */       if (this.d < 0)
/* 676 */         return -1; 
/* 677 */       if (this.d == 0) {
/*     */         LuaValue luaValue;
/* 679 */         if ((luaValue = this.a.call()).isnil())
/* 680 */           return this.d = -1; 
/* 681 */         LuaString luaString = luaValue.strvalue();
/* 682 */         this.b = luaString.m_bytes;
/* 683 */         this.c = luaString.m_offset;
/* 684 */         this.d = luaString.m_length;
/* 685 */         if (this.d <= 0)
/* 686 */           return -1; 
/*     */       } 
/* 688 */       this.d--;
/* 689 */       return 0xFF & this.b[this.c++];
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\BaseLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */