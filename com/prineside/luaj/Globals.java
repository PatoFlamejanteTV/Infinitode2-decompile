/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.compiler.LuaC;
/*     */ import com.prineside.luaj.debug.CallStack;
/*     */ import com.prineside.luaj.lib.BaseLib;
/*     */ import com.prineside.luaj.lib.DebugLib;
/*     */ import com.prineside.luaj.lib.PackageLib;
/*     */ import com.prineside.luaj.lib.ResourceFinder;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Reader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class Globals
/*     */   extends LuaTable
/*     */ {
/*     */   @NAGS
/* 118 */   public InputStream STDIN = null;
/*     */   
/*     */   @NAGS
/* 121 */   public PrintStream STDOUT = System.out;
/*     */   
/*     */   @NAGS
/* 124 */   public PrintStream STDERR = System.err;
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceFinder finder;
/*     */ 
/*     */ 
/*     */   
/*     */   public BaseLib baselib;
/*     */ 
/*     */ 
/*     */   
/*     */   public PackageLib package_;
/*     */ 
/*     */ 
/*     */   
/*     */   private DebugLib a;
/*     */ 
/*     */ 
/*     */   
/*     */   public Loader loader;
/*     */ 
/*     */ 
/*     */   
/*     */   public Compiler compiler;
/*     */ 
/*     */ 
/*     */   
/*     */   @NAGS
/*     */   public Undumper undumper;
/*     */ 
/*     */ 
/*     */   
/*     */   public final Globals checkglobals() {
/* 158 */     return this;
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
/*     */   @NAGS
/* 175 */   private final ThreadLocal<CallStack> b = new ThreadLocal<>();
/*     */   
/*     */   @NAGS
/* 178 */   private final ThreadLocal<LuaValue> c = new ThreadLocal<>();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 182 */     super.write(paramKryo, paramOutput);
/*     */     
/* 184 */     paramKryo.writeClassAndObject(paramOutput, this.finder);
/* 185 */     paramKryo.writeClassAndObject(paramOutput, this.baselib);
/* 186 */     paramKryo.writeClassAndObject(paramOutput, this.package_);
/* 187 */     paramKryo.writeClassAndObject(paramOutput, this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 192 */     super.read(paramKryo, paramInput);
/*     */     
/* 194 */     this.finder = (ResourceFinder)paramKryo.readClassAndObject(paramInput);
/* 195 */     this.baselib = (BaseLib)paramKryo.readClassAndObject(paramInput);
/* 196 */     this.package_ = (PackageLib)paramKryo.readClassAndObject(paramInput);
/* 197 */     this.a = (DebugLib)paramKryo.readClassAndObject(paramInput);
/*     */     
/* 199 */     LuaC luaC = new LuaC();
/* 200 */     this.loader = (Loader)luaC;
/* 201 */     this.compiler = (Compiler)luaC;
/* 202 */     this.undumper = new LoadState.GlobalsUndumper();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setDebugLib(@Null DebugLib paramDebugLib) {
/* 209 */     this.a = paramDebugLib;
/*     */   }
/*     */   @Null
/*     */   public final DebugLib getDebugLib() {
/* 213 */     return this.a;
/*     */   }
/*     */   
/*     */   public final CallStack getCallstack() {
/*     */     CallStack callStack;
/* 218 */     if ((callStack = this.b.get()) == null) {
/* 219 */       callStack = new CallStack();
/* 220 */       this.b.set(callStack);
/*     */     } 
/* 222 */     return callStack;
/*     */   }
/*     */   @Null
/*     */   public final LuaValue getErrorFunc() {
/* 226 */     return this.c.get();
/*     */   }
/*     */   
/*     */   public final void setErrorFunc(@Null LuaValue paramLuaValue) {
/* 230 */     this.c.set(paramLuaValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaValue loadfile(String paramString) {
/*     */     try {
/* 240 */       return load(this.finder.findResource(paramString), "@" + paramString, "bt", this);
/* 241 */     } catch (Exception exception) {
/* 242 */       return error("load " + paramString + ": " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaValue load(String paramString1, String paramString2) {
/* 253 */     return load(new StrReader(paramString1), paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaValue load(String paramString) {
/* 262 */     return load(new StrReader(paramString), paramString);
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
/*     */   public final LuaValue load(String paramString1, String paramString2, LuaTable paramLuaTable) {
/* 274 */     return load(new StrReader(paramString1), paramString2, paramLuaTable);
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
/*     */   public final LuaValue load(Reader paramReader, String paramString) {
/* 286 */     return load(new UTF8Stream(paramReader), paramString, "t", this);
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
/*     */   public final LuaValue load(Reader paramReader, String paramString, LuaTable paramLuaTable) {
/* 300 */     return load(new UTF8Stream(paramReader), paramString, "t", paramLuaTable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaValue load(InputStream paramInputStream, String paramString1, String paramString2, LuaValue paramLuaValue) {
/*     */     try {
/* 311 */       Prototype prototype = loadPrototype(paramInputStream, paramString1, paramString2);
/* 312 */       return this.loader.load(prototype, paramString1, paramLuaValue);
/* 313 */     } catch (LuaError luaError) {
/* 314 */       throw paramInputStream = null;
/* 315 */     } catch (Exception exception) {
/* 316 */       return error("load " + paramString1 + ": " + exception);
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
/*     */   public final Prototype loadPrototype(InputStream paramInputStream, String paramString1, String paramString2) {
/* 328 */     if (paramString2.indexOf('b') >= 0) {
/* 329 */       if (this.undumper == null)
/* 330 */         error("No undumper."); 
/* 331 */       if (!paramInputStream.markSupported())
/* 332 */         paramInputStream = new BufferedStream(paramInputStream); 
/* 333 */       paramInputStream.mark(4);
/*     */       Prototype prototype;
/* 335 */       if ((prototype = this.undumper.undump(paramInputStream, paramString1)) != null)
/* 336 */         return prototype; 
/* 337 */       paramInputStream.reset();
/*     */     } 
/* 339 */     if (paramString2.indexOf('t') >= 0) {
/* 340 */       return compilePrototype(paramInputStream, paramString1);
/*     */     }
/* 342 */     error("Failed to load prototype " + paramString1 + " using mode '" + paramString2 + "'");
/* 343 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Prototype compilePrototype(Reader paramReader, String paramString) {
/* 351 */     return compilePrototype(new UTF8Stream(paramReader), paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Prototype compilePrototype(InputStream paramInputStream, String paramString) {
/* 359 */     if (this.compiler == null)
/* 360 */       error("No compiler."); 
/* 361 */     return this.compiler.compile(paramInputStream, paramString);
/*     */   }
/*     */   
/*     */   static class StrReader
/*     */     extends Reader {
/*     */     private String a;
/* 367 */     private int b = 0; private int c;
/*     */     
/*     */     StrReader(String param1String) {
/* 370 */       this.a = param1String;
/* 371 */       this.c = param1String.length();
/*     */     }
/*     */     public void close() {
/* 374 */       this.b = this.c;
/*     */     }
/*     */     public int read() {
/* 377 */       return (this.b < this.c) ? this.a.charAt(this.b++) : -1;
/*     */     }
/*     */     public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 380 */       byte b = 0;
/* 381 */       for (; b < param1Int2 && this.b < this.c; b++, this.b++)
/* 382 */         param1ArrayOfchar[param1Int1 + b] = this.a.charAt(this.b); 
/* 383 */       return (b > 0 || param1Int2 == 0) ? b : -1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static abstract class AbstractBufferedStream
/*     */     extends InputStream
/*     */   {
/*     */     protected byte[] a;
/* 392 */     protected int b = 0, c = 0;
/*     */     protected AbstractBufferedStream(int param1Int) {
/* 394 */       this.a = new byte[param1Int];
/*     */     }
/*     */     
/*     */     public int read() {
/*     */       int i;
/* 399 */       return ((i = a()) <= 0) ? -1 : (0xFF & this.a[this.b++]);
/*     */     } protected abstract int a();
/*     */     public int read(byte[] param1ArrayOfbyte) {
/* 402 */       return read(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
/*     */     }
/*     */     public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/*     */       int i;
/* 406 */       if ((i = a()) <= 0) return -1; 
/* 407 */       param1Int2 = Math.min(i, param1Int2);
/* 408 */       System.arraycopy(this.a, this.b, param1ArrayOfbyte, param1Int1, param1Int2);
/* 409 */       this.b += param1Int2;
/* 410 */       return param1Int2;
/*     */     }
/*     */     public long skip(long param1Long) {
/* 413 */       long l = Math.min(param1Long, (this.c - this.b));
/* 414 */       this.b = (int)(this.b + l);
/* 415 */       return l;
/*     */     }
/*     */     public int available() {
/* 418 */       return this.c - this.b;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class UTF8Stream
/*     */     extends AbstractBufferedStream
/*     */   {
/* 427 */     private final char[] d = new char[32]; private final Reader e;
/*     */     
/*     */     UTF8Stream(Reader param1Reader) {
/* 430 */       super(96);
/* 431 */       this.e = param1Reader;
/*     */     }
/*     */     protected final int a() {
/* 434 */       if (this.b < this.c) return this.c - this.b; 
/*     */       int i;
/* 436 */       if ((i = this.e.read(this.d)) < 0)
/* 437 */         return -1; 
/* 438 */       if (i == 0) {
/*     */         
/* 440 */         if ((i = this.e.read()) < 0)
/* 441 */           return -1; 
/* 442 */         this.d[0] = (char)i;
/* 443 */         i = 1;
/*     */       } 
/* 445 */       this.c = LuaString.encodeToUtf8(this.d, i, this.a, this.b = 0);
/* 446 */       return this.c;
/*     */     }
/*     */     public void close() {
/* 449 */       this.e.close();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class BufferedStream
/*     */     extends AbstractBufferedStream
/*     */   {
/*     */     private final InputStream d;
/*     */ 
/*     */     
/*     */     public BufferedStream(InputStream param1InputStream) {
/* 462 */       this(128, param1InputStream);
/*     */     }
/*     */     private BufferedStream(int param1Int, InputStream param1InputStream) {
/* 465 */       super(128);
/* 466 */       this.d = param1InputStream;
/*     */     }
/*     */     protected final int a() {
/* 469 */       if (this.b < this.c) return this.c - this.b; 
/* 470 */       if (this.c >= this.a.length) this.b = this.c = 0;
/*     */       
/*     */       int i;
/* 473 */       if ((i = this.d.read(this.a, this.c, this.a.length - this.c)) < 0)
/* 474 */         return -1; 
/* 475 */       if (i == 0) {
/*     */         
/* 477 */         if ((i = this.d.read()) < 0)
/* 478 */           return -1; 
/* 479 */         this.a[this.c] = (byte)i;
/* 480 */         i = 1;
/*     */       } 
/* 482 */       this.c += i;
/* 483 */       return i;
/*     */     }
/*     */     public void close() {
/* 486 */       this.d.close();
/*     */     }
/*     */     public void mark(int param1Int) {
/* 489 */       if (this.b > 0 || param1Int > this.a.length) {
/* 490 */         byte[] arrayOfByte = (param1Int > this.a.length) ? new byte[param1Int] : this.a;
/* 491 */         System.arraycopy(this.a, this.b, arrayOfByte, 0, this.c - this.b);
/* 492 */         this.c -= this.b;
/* 493 */         this.b = 0;
/* 494 */         this.a = arrayOfByte;
/*     */       } 
/*     */     }
/*     */     public boolean markSupported() {
/* 498 */       return true;
/*     */     }
/*     */     public void reset() {
/* 501 */       this.b = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface Loader {
/*     */     LuaFunction load(Prototype param1Prototype, String param1String, LuaValue param1LuaValue);
/*     */   }
/*     */   
/*     */   public static interface Compiler {
/*     */     Prototype compile(InputStream param1InputStream, String param1String);
/*     */   }
/*     */   
/*     */   public static interface Undumper {
/*     */     Prototype undump(InputStream param1InputStream, String param1String);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\Globals.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */