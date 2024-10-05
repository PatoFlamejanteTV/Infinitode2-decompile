/*     */ package com.prineside.luaj.lib;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.Globals;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.LuaTable;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class IoLib
/*     */   extends TwoArgFunction
/*     */ {
/*     */   protected abstract class File
/*     */     extends LuaValue
/*     */   {
/*     */     protected File(IoLib this$0) {}
/*     */     
/*     */     public abstract void write(LuaString param1LuaString);
/*     */     
/*     */     public abstract void flush();
/*     */     
/*     */     public abstract boolean isstdfile();
/*     */     
/*     */     public abstract void close();
/*     */     
/*     */     public abstract boolean isclosed();
/*     */     
/*     */     public abstract int seek(String param1String, int param1Int);
/*     */     
/*     */     public abstract void setvbuf(String param1String, int param1Int);
/*     */     
/*     */     public abstract int remaining();
/*     */     
/*     */     public abstract int peek();
/*     */     
/*     */     public abstract int read();
/*     */     
/*     */     public abstract int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2);
/*     */     
/*     */     public boolean eof() {
/*     */       
/*  99 */       try { return (peek() < 0); }
/* 100 */       catch (EOFException eOFException) { return true; }
/*     */     
/*     */     }
/*     */     
/*     */     public LuaValue get(LuaValue param1LuaValue) {
/* 105 */       return this.a.a.get(param1LuaValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public final int type() {
/* 110 */       return 7;
/*     */     }
/*     */     public final String typename() {
/* 113 */       return "userdata";
/*     */     }
/*     */ 
/*     */     
/*     */     public String tojstring() {
/* 118 */       return "file: " + Integer.toHexString(hashCode());
/*     */     }
/*     */     
/*     */     public void finalize() {
/* 122 */       if (!isclosed()) {
/*     */         try {
/* 124 */           close(); return;
/* 125 */         } catch (IOException iOException) {}
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 188 */   private File e = null;
/* 189 */   private File f = null;
/* 190 */   private File g = null;
/*     */   
/* 192 */   private static final LuaValue h = (LuaValue)valueOf("stdin");
/* 193 */   private static final LuaValue i = (LuaValue)valueOf("stdout");
/* 194 */   private static final LuaValue j = (LuaValue)valueOf("stderr");
/* 195 */   private static final LuaValue k = (LuaValue)valueOf("file");
/* 196 */   private static final LuaValue l = (LuaValue)valueOf("closed file");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 221 */   public static final String[] IO_NAMES = new String[] { "close", "flush", "input", "lines", "open", "output", "popen", "read", "tmpfile", "type", "write" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 235 */   public static final String[] FILE_NAMES = new String[] { "close", "flush", "lines", "read", "seek", "setvbuf", "write" };
/*     */ 
/*     */   
/*     */   LuaTable a;
/*     */   
/*     */   protected Globals b;
/*     */ 
/*     */   
/*     */   protected abstract File d();
/*     */ 
/*     */   
/*     */   protected abstract File e();
/*     */ 
/*     */   
/*     */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 250 */     this.b = paramLuaValue2.checkglobals();
/*     */ 
/*     */     
/* 253 */     LuaTable luaTable1 = new LuaTable();
/* 254 */     a((LuaValue)luaTable1, IoLibV.class, IO_NAMES);
/*     */ 
/*     */     
/* 257 */     this.a = new LuaTable();
/* 258 */     a((LuaValue)this.a, IoLibV.class, FILE_NAMES, 11);
/*     */     
/*     */     LuaTable luaTable2;
/*     */     
/* 262 */     a((LuaValue)(luaTable2 = new LuaTable()), IoLibV.class, new String[] { "__index" }, 18);
/* 263 */     luaTable1.setmetatable((LuaValue)luaTable2);
/*     */ 
/*     */     
/* 266 */     a(luaTable1);
/* 267 */     a(this.a);
/* 268 */     a(luaTable2);
/*     */ 
/*     */     
/* 271 */     paramLuaValue2.set("io", (LuaValue)luaTable1);
/* 272 */     if (!paramLuaValue2.get("package").isnil()) paramLuaValue2.get("package").get("loaded").set("io", (LuaValue)luaTable1); 
/* 273 */     return (LuaValue)luaTable1;
/*     */   } protected abstract File f(); protected abstract File a(String paramString, boolean paramBoolean1, boolean paramBoolean2); protected abstract File g();
/*     */   protected abstract File b(String paramString1, String paramString2);
/*     */   private void a(LuaTable paramLuaTable) {
/* 277 */     LuaValue[] arrayOfLuaValue = paramLuaTable.keys(); byte b; int i;
/* 278 */     for (b = 0, i = arrayOfLuaValue.length; b < i; b++) {
/* 279 */       ((IoLibV)paramLuaTable.get(arrayOfLuaValue[b])).iolib = this;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static final class IoLibV
/*     */     extends VarArgFunction
/*     */     implements KryoSerializable
/*     */   {
/*     */     private IoLib.File a;
/*     */     
/*     */     public IoLib iolib;
/*     */     private boolean b;
/*     */     private Varargs e;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {}
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {}
/*     */     
/*     */     public IoLibV() {}
/*     */     
/*     */     public IoLibV(IoLib.File param1File, String param1String, int param1Int, IoLib param1IoLib, boolean param1Boolean, Varargs param1Varargs) {
/* 302 */       this(param1File, param1String, param1Int, param1IoLib);
/* 303 */       this.b = param1Boolean;
/* 304 */       this.e = param1Varargs.dealias();
/*     */     }
/*     */     
/*     */     public IoLibV(IoLib.File param1File, String param1String, int param1Int, IoLib param1IoLib) {
/* 308 */       this.a = param1File;
/* 309 */       this.d = param1String;
/* 310 */       this.c = param1Int;
/* 311 */       this.iolib = param1IoLib;
/*     */     }
/*     */     
/*     */     public final Varargs invoke(Varargs param1Varargs) {
/*     */       try {
/* 316 */         switch (this.c) { case 1:
/* 317 */             return this.iolib._io_flush();
/* 318 */           case 8: return this.iolib._io_tmpfile();
/* 319 */           case 0: return this.iolib._io_close(param1Varargs.arg1());
/* 320 */           case 2: return this.iolib._io_input(param1Varargs.arg1());
/* 321 */           case 5: return this.iolib._io_output(param1Varargs.arg1());
/* 322 */           case 9: return this.iolib._io_type(param1Varargs.arg1());
/* 323 */           case 6: return this.iolib._io_popen(param1Varargs.checkjstring(1), param1Varargs.optjstring(2, "r"));
/* 324 */           case 4: return this.iolib._io_open(param1Varargs.checkjstring(1), param1Varargs.optjstring(2, "r"));
/* 325 */           case 3: return this.iolib._io_lines(param1Varargs);
/* 326 */           case 7: return this.iolib._io_read(param1Varargs);
/* 327 */           case 10: return this.iolib._io_write(param1Varargs);
/*     */           case 11:
/* 329 */             return this.iolib._file_close(param1Varargs.arg1());
/* 330 */           case 12: return this.iolib._file_flush(param1Varargs.arg1());
/* 331 */           case 16: return this.iolib._file_setvbuf(param1Varargs.arg1(), param1Varargs.checkjstring(2), param1Varargs.optint(3, 8192));
/* 332 */           case 13: return this.iolib._file_lines(param1Varargs);
/* 333 */           case 14: return this.iolib._file_read(param1Varargs.arg1(), param1Varargs.subargs(2));
/* 334 */           case 15: return this.iolib._file_seek(param1Varargs.arg1(), param1Varargs.optjstring(2, "cur"), param1Varargs.optint(3, 0));
/* 335 */           case 17: return this.iolib._file_write(param1Varargs.arg1(), param1Varargs.subargs(2));
/*     */           case 18:
/* 337 */             return this.iolib._io_index(param1Varargs.arg(2));
/* 338 */           case 19: return this.iolib._lines_iter(this.a, this.b, this.e); }
/*     */       
/* 340 */       } catch (IOException iOException) {
/* 341 */         if (this.c == 19) {
/*     */           String str;
/* 343 */           error(((str = iOException.getMessage()) != null) ? str : iOException.toString());
/*     */         } 
/* 345 */         return IoLib.a(iOException);
/*     */       } 
/* 347 */       return (Varargs)NONE;
/*     */     }
/*     */   }
/*     */   
/*     */   private File h() {
/* 352 */     return (this.e != null) ? this.e : (this.e = a(0, "-", "r"));
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _io_flush() {
/* 357 */     b(i());
/* 358 */     this.f.flush();
/* 359 */     return (Varargs)LuaValue.TRUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _io_tmpfile() {
/* 364 */     return (Varargs)g();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Varargs _io_close(LuaValue paramLuaValue) {
/* 370 */     b((File)(paramLuaValue = paramLuaValue.isnil() ? i() : a(paramLuaValue)));
/* 371 */     return a((File)paramLuaValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _io_input(LuaValue paramLuaValue) {
/* 376 */     this
/*     */       
/* 378 */       .e = paramLuaValue.isnil() ? h() : (paramLuaValue.isstring() ? a(3, paramLuaValue.checkjstring(), "r") : a(paramLuaValue));
/* 379 */     return (Varargs)this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _io_output(LuaValue paramLuaValue) {
/* 384 */     this
/*     */       
/* 386 */       .f = paramLuaValue.isnil() ? i() : (paramLuaValue.isstring() ? a(3, paramLuaValue.checkjstring(), "w") : a(paramLuaValue));
/* 387 */     return (Varargs)this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Varargs _io_type(LuaValue paramLuaValue) {
/* 393 */     if ((paramLuaValue = c(paramLuaValue)) != null)
/* 394 */       return (Varargs)(paramLuaValue.isclosed() ? l : k); 
/* 395 */     return (Varargs)NIL;
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _io_popen(String paramString1, String paramString2) {
/* 400 */     if (!"r".equals(paramString2) && !"w".equals(paramString2)) argerror(2, "invalid value: '" + paramString2 + "'; must be one of 'r' or 'w'"); 
/* 401 */     return (Varargs)b(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _io_open(String paramString1, String paramString2) {
/* 406 */     return (Varargs)b(3, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _io_lines(Varargs paramVarargs) {
/*     */     String str;
/*     */     File file;
/* 413 */     b(file = ((str = paramVarargs.optjstring(1, null)) == null) ? h() : a(3, str, "r"));
/* 414 */     return a(file, (str != null), paramVarargs.subargs(2));
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _io_read(Varargs paramVarargs) {
/* 419 */     b(h());
/* 420 */     return b(this.e, paramVarargs);
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _io_write(Varargs paramVarargs) {
/* 425 */     b(i());
/* 426 */     return a(this.f, paramVarargs);
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _file_close(LuaValue paramLuaValue) {
/* 431 */     return a(a(paramLuaValue));
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _file_flush(LuaValue paramLuaValue) {
/* 436 */     a(paramLuaValue).flush();
/* 437 */     return (Varargs)LuaValue.TRUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _file_setvbuf(LuaValue paramLuaValue, String paramString, int paramInt) {
/* 442 */     if (!"no".equals(paramString) && 
/* 443 */       !"full".equals(paramString) && 
/* 444 */       !"line".equals(paramString))
/*     */     {
/* 446 */       argerror(1, "invalid value: '" + paramString + "'; must be one of 'no', 'full' or 'line'");
/*     */     }
/* 448 */     a(paramLuaValue).setvbuf(paramString, paramInt);
/* 449 */     return (Varargs)LuaValue.TRUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _file_lines(Varargs paramVarargs) {
/* 454 */     return a(a(paramVarargs.arg1()), false, paramVarargs.subargs(2));
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _file_read(LuaValue paramLuaValue, Varargs paramVarargs) {
/* 459 */     return b(a(paramLuaValue), paramVarargs);
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _file_seek(LuaValue paramLuaValue, String paramString, int paramInt) {
/* 464 */     if (!"set".equals(paramString) && 
/* 465 */       !"end".equals(paramString) && 
/* 466 */       !"cur".equals(paramString))
/*     */     {
/* 468 */       argerror(1, "invalid value: '" + paramString + "'; must be one of 'set', 'cur' or 'end'");
/*     */     }
/* 470 */     return (Varargs)valueOf(a(paramLuaValue).seek(paramString, paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _file_write(LuaValue paramLuaValue, Varargs paramVarargs) {
/* 475 */     return a(a(paramLuaValue), paramVarargs);
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _io_index(LuaValue paramLuaValue) {
/* 480 */     if (paramLuaValue.equals(i)) return (Varargs)i(); 
/* 481 */     if (paramLuaValue.equals(h)) return (Varargs)h(); 
/* 482 */     if (paramLuaValue.equals(j)) return (Varargs)j();  return (Varargs)NIL;
/*     */   }
/*     */ 
/*     */   
/*     */   public Varargs _lines_iter(LuaValue paramLuaValue, boolean paramBoolean, Varargs paramVarargs) {
/*     */     File file;
/* 488 */     if ((file = c(paramLuaValue)) == null) argerror(1, "not a file: " + paramLuaValue); 
/* 489 */     if (file.isclosed()) error("file is already closed"); 
/* 490 */     Varargs varargs = b(file, paramVarargs);
/* 491 */     if (paramBoolean && varargs.isnil(1) && file.eof()) file.close(); 
/* 492 */     return varargs;
/*     */   }
/*     */   
/*     */   private File i() {
/* 496 */     return (this.f != null) ? this.f : (this.f = a(1, "-", "w"));
/*     */   }
/*     */   
/*     */   private File j() {
/* 500 */     return (this.g != null) ? this.g : (this.g = a(2, "-", "w"));
/*     */   }
/*     */   
/*     */   private File a(int paramInt, String paramString1, String paramString2) {
/*     */     try {
/* 505 */       return b(paramInt, paramString1, paramString2);
/* 506 */     } catch (Exception exception) {
/* 507 */       error("io error: " + exception.getMessage());
/* 508 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Varargs a(File paramFile) {
/* 513 */     if (paramFile.isstdfile()) {
/* 514 */       return c("cannot close standard file");
/*     */     }
/* 516 */     paramFile.close();
/* 517 */     return k();
/*     */   }
/*     */ 
/*     */   
/*     */   private static Varargs k() {
/* 522 */     return (Varargs)LuaValue.TRUE;
/*     */   }
/*     */   
/*     */   static Varargs a(Exception paramException) {
/* 526 */     String str = paramException.getMessage();
/* 527 */     return c("io error: " + ((str != null) ? str : paramException.toString()));
/*     */   }
/*     */   
/*     */   private static Varargs c(String paramString) {
/* 531 */     return varargsOf(NIL, (Varargs)valueOf(paramString));
/*     */   }
/*     */   
/*     */   private Varargs a(File paramFile, boolean paramBoolean, Varargs paramVarargs) {
/*     */     try {
/* 536 */       return (Varargs)new IoLibV(paramFile, "lnext", 19, this, paramBoolean, paramVarargs);
/* 537 */     } catch (Exception exception) {
/* 538 */       return (Varargs)error("lines: " + exception);
/*     */     } 
/*     */   } private static Varargs a(File paramFile, Varargs paramVarargs) {
/*     */     byte b;
/*     */     int i;
/* 543 */     for (b = 1, i = paramVarargs.narg(); b <= i; b++)
/* 544 */       paramFile.write(paramVarargs.checkstring(b)); 
/* 545 */     return (Varargs)paramFile;
/*     */   }
/*     */   
/*     */   private static Varargs b(File paramFile, Varargs paramVarargs) {
/*     */     int i;
/* 550 */     if ((i = paramVarargs.narg()) == 0) return (Varargs)freadline(paramFile, false); 
/* 551 */     LuaValue[] arrayOfLuaValue = new LuaValue[i];
/*     */     
/*     */     byte b;
/* 554 */     for (b = 0; b < i; ) {
/* 555 */       LuaString luaString; LuaValue luaValue1, luaValue2; switch ((luaValue2 = paramVarargs.arg(b + 1)).type()) {
/*     */         case 3:
/* 557 */           luaValue2 = freadbytes(paramFile, luaValue2.toint());
/*     */           break;
/*     */         
/*     */         case 4:
/* 561 */           if ((luaString = luaValue2.checkstring()).m_length >= 2 && luaString.m_bytes[luaString.m_offset] == 42)
/* 562 */             switch (luaString.m_bytes[luaString.m_offset + 1]) { case 110:
/* 563 */                 luaValue1 = freadnumber(paramFile); break;
/* 564 */               case 108: luaValue1 = freadline(paramFile, false); break;
/* 565 */               case 76: luaValue1 = freadline(paramFile, true); break;
/* 566 */               case 97: luaValue1 = freadall(paramFile);
/*     */                 break; }
/*     */              
/*     */         default:
/* 570 */           return (Varargs)argerror(b + 1, "(invalid format)");
/*     */       } 
/* 572 */       arrayOfLuaValue[b++] = luaValue1; if (luaValue1.isnil())
/*     */         break; 
/*     */     } 
/* 575 */     return (Varargs)((b == 0) ? NIL : varargsOf(arrayOfLuaValue, 0, b));
/*     */   }
/*     */ 
/*     */   
/*     */   private static File a(LuaValue paramLuaValue) {
/* 580 */     if ((paramLuaValue = c(paramLuaValue)) == null)
/* 581 */       argerror(1, "file"); 
/* 582 */     b((File)paramLuaValue);
/* 583 */     return (File)paramLuaValue;
/*     */   }
/*     */   
/*     */   private static File c(LuaValue paramLuaValue) {
/* 587 */     return (paramLuaValue instanceof File) ? (File)paramLuaValue : null;
/*     */   }
/*     */   
/*     */   private static File b(File paramFile) {
/* 591 */     if (paramFile.isclosed())
/* 592 */       error("attempt to use a closed file"); 
/* 593 */     return paramFile;
/*     */   }
/*     */   
/*     */   private File b(int paramInt, String paramString1, String paramString2) {
/* 597 */     int i = paramString2.length();
/* 598 */     for (byte b = 0; b < i; b++) {
/* 599 */       char c = paramString2.charAt(b);
/* 600 */       if ((b != 0 || "rwa".indexOf(c) < 0) && (
/* 601 */         b != 1 || c != '+') && (
/* 602 */         b <= 0 || c != 'b')) {
/* 603 */         i = -1; break;
/*     */       } 
/*     */     } 
/* 606 */     if (i <= 0) argerror(2, "invalid mode: '" + paramString2 + "'");
/*     */     
/* 608 */     switch (paramInt) { case 0:
/* 609 */         return d();
/* 610 */       case 1: return e();
/* 611 */       case 2: return f(); }
/*     */     
/* 613 */     boolean bool1 = paramString2.startsWith("r");
/* 614 */     boolean bool2 = paramString2.startsWith("a");
/* 615 */     paramString2.indexOf('+');
/* 616 */     paramString2.endsWith("b");
/* 617 */     return a(paramString1, bool1, bool2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LuaValue freadbytes(File paramFile, int paramInt) {
/* 624 */     if (paramInt == 0) return (LuaValue)(paramFile.eof() ? NIL : EMPTYSTRING); 
/* 625 */     byte[] arrayOfByte = new byte[paramInt];
/*     */     int i;
/* 627 */     if ((i = paramFile.read(arrayOfByte, 0, paramInt)) < 0)
/* 628 */       return NIL; 
/* 629 */     return (LuaValue)LuaString.valueUsing(arrayOfByte, 0, i);
/*     */   } public static LuaValue freaduntil(File paramFile, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     byte b;
/* 632 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     
/*     */     try {
/* 635 */       if (paramBoolean1) {
/* 636 */         while ((b = paramFile.read()) >= 0) {
/* 637 */           switch (b) { case 13:
/* 638 */               if (paramBoolean2) byteArrayOutputStream.write(b);  continue;
/* 639 */             case 10: if (paramBoolean2) byteArrayOutputStream.write(b);  break; }
/* 640 */            byteArrayOutputStream.write(b);
/*     */         } 
/*     */       } else {
/*     */         
/* 644 */         while ((b = paramFile.read()) >= 0)
/* 645 */           byteArrayOutputStream.write(b); 
/*     */       } 
/* 647 */     } catch (EOFException eOFException) {
/* 648 */       b = -1;
/*     */     } 
/* 650 */     if (b < 0 && byteArrayOutputStream.size() == 0)
/* 651 */       return NIL; 
/* 652 */     return (LuaValue)LuaString.valueUsing(byteArrayOutputStream.toByteArray());
/*     */   }
/*     */   public static LuaValue freadline(File paramFile, boolean paramBoolean) {
/* 655 */     return freaduntil(paramFile, true, paramBoolean);
/*     */   }
/*     */   public static LuaValue freadall(File paramFile) {
/*     */     int i;
/* 659 */     if ((i = paramFile.remaining()) >= 0) {
/* 660 */       return (LuaValue)((i == 0) ? EMPTYSTRING : freadbytes(paramFile, i));
/*     */     }
/* 662 */     return freaduntil(paramFile, false, false);
/*     */   }
/*     */   
/*     */   public static LuaValue freadnumber(File paramFile) {
/* 666 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 667 */     a(paramFile, " \t\r\n", (ByteArrayOutputStream)null);
/* 668 */     a(paramFile, "-+", byteArrayOutputStream);
/*     */ 
/*     */     
/* 671 */     a(paramFile, "0123456789", byteArrayOutputStream);
/* 672 */     a(paramFile, ".", byteArrayOutputStream);
/* 673 */     a(paramFile, "0123456789", byteArrayOutputStream);
/*     */ 
/*     */     
/*     */     String str;
/*     */     
/* 678 */     return (LuaValue)(((str = byteArrayOutputStream.toString()).length() > 0) ? valueOf(Double.parseDouble(str)) : NIL);
/*     */   }
/*     */   
/*     */   private static void a(File paramFile, String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {
/*     */     while (true) {
/* 683 */       int i = paramFile.peek();
/* 684 */       if (paramString.indexOf(i) < 0) {
/*     */         return;
/*     */       }
/* 687 */       paramFile.read();
/* 688 */       if (paramByteArrayOutputStream != null)
/* 689 */         paramByteArrayOutputStream.write(i); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\IoLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */