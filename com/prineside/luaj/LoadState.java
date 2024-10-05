/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import java.io.DataInputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class LoadState
/*     */ {
/*  83 */   public static final Globals.Undumper instance = new GlobalsUndumper();
/*     */   
/*     */   public static final int NUMBER_FORMAT_FLOATS_OR_DOUBLES = 0;
/*     */   
/*     */   public static final int NUMBER_FORMAT_INTS_ONLY = 1;
/*     */   
/*     */   public static final int NUMBER_FORMAT_NUM_PATCH_INT32 = 4;
/*     */   
/*     */   public static final int LUA_TINT = -2;
/*     */   
/*     */   public static final int LUA_TNONE = -1;
/*     */   
/*     */   public static final int LUA_TNIL = 0;
/*     */   
/*     */   public static final int LUA_TBOOLEAN = 1;
/*     */   
/*     */   public static final int LUA_TLIGHTUSERDATA = 2;
/*     */   
/*     */   public static final int LUA_TNUMBER = 3;
/*     */   
/*     */   public static final int LUA_TSTRING = 4;
/*     */   public static final int LUA_TTABLE = 5;
/*     */   public static final int LUA_TFUNCTION = 6;
/*     */   public static final int LUA_TUSERDATA = 7;
/*     */   public static final int LUA_TTHREAD = 8;
/*     */   public static final int LUA_TVALUE = 9;
/* 109 */   public static final byte[] LUA_SIGNATURE = new byte[] { 27, 76, 117, 97 };
/*     */ 
/*     */   
/* 112 */   public static final byte[] LUAC_TAIL = new byte[] { 25, -109, 13, 10, 26, 10 };
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SOURCE_BINARY_STRING = "binary string";
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LUAC_VERSION = 82;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LUAC_FORMAT = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LUAC_HEADERSIZE = 12;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a;
/*     */ 
/*     */   
/*     */   private int b;
/*     */ 
/*     */   
/*     */   private int c;
/*     */ 
/*     */   
/*     */   public final DataInputStream is;
/*     */ 
/*     */   
/* 144 */   private static final LuaValue[] d = new LuaValue[0];
/* 145 */   private static final Prototype[] e = new Prototype[0];
/* 146 */   private static final LocVars[] f = new LocVars[0];
/* 147 */   private static final Upvaldesc[] g = new Upvaldesc[0];
/* 148 */   private static final int[] h = new int[0];
/*     */ 
/*     */   
/* 151 */   private byte[] i = new byte[512];
/*     */ 
/*     */   
/*     */   public static void install(Globals paramGlobals) {
/* 155 */     paramGlobals.undumper = instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a() {
/* 162 */     this.is.readFully(this.i, 0, 4);
/* 163 */     if (this.a)
/* 164 */       return this.i[3] << 24 | (0xFF & this.i[2]) << 16 | (0xFF & this.i[1]) << 8 | 0xFF & this.i[0]; 
/* 165 */     return this.i[0] << 24 | (0xFF & this.i[1]) << 16 | (0xFF & this.i[2]) << 8 | 0xFF & this.i[3];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[] b() {
/*     */     int i;
/* 173 */     if ((i = a()) == 0) {
/* 174 */       return h;
/*     */     }
/*     */     
/* 177 */     int j = i << 2;
/* 178 */     if (this.i.length < j)
/* 179 */       this.i = new byte[j]; 
/* 180 */     this.is.readFully(this.i, 0, j);
/* 181 */     int[] arrayOfInt = new int[i];
/* 182 */     for (byte b1 = 0, b2 = 0; b1 < i; b1++, b2 += 4) {
/* 183 */       arrayOfInt[b1] = this.a ? (
/* 184 */         this.i[b2 + 3] << 24 | (0xFF & this.i[b2 + 2]) << 16 | (0xFF & this.i[b2 + 1]) << 8 | 0xFF & this.i[b2]) : (
/* 185 */         this.i[b2] << 24 | (0xFF & this.i[b2 + 1]) << 16 | (0xFF & this.i[b2 + 2]) << 8 | 0xFF & this.i[b2 + 3]);
/*     */     }
/* 187 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private long c() {
/*     */     int i;
/*     */     int j;
/* 195 */     if (this.a) {
/* 196 */       i = a();
/* 197 */       j = a();
/*     */     } else {
/* 199 */       j = a();
/* 200 */       i = a();
/*     */     } 
/* 202 */     return j << 32L | i & 0xFFFFFFFFL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LuaString d() {
/*     */     int i;
/* 210 */     if ((i = (this.b == 8) ? (int)c() : a()) == 0)
/* 211 */       return null; 
/* 212 */     byte[] arrayOfByte = new byte[i];
/* 213 */     this.is.readFully(arrayOfByte, 0, i);
/* 214 */     return LuaString.valueUsing(arrayOfByte, 0, arrayOfByte.length - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LuaValue longBitsToLuaNumber(long paramLong) {
/* 222 */     if ((paramLong & Long.MAX_VALUE) == 0L) {
/* 223 */       return LuaValue.ZERO;
/*     */     }
/*     */     
/*     */     int i;
/*     */     
/* 228 */     if ((i = (int)(paramLong >> 52L & 0x7FFL) - 1023) >= 0 && i < 31) {
/* 229 */       long l1 = paramLong & 0xFFFFFFFFFFFFFL;
/* 230 */       int j = 52 - i;
/* 231 */       long l2 = (1L << j) - 1L;
/* 232 */       if ((l1 & l2) == 0L) {
/* 233 */         i = (int)(l1 >> j) | 1 << i;
/* 234 */         return LuaNumber.valueOf((paramLong >> 63L != 0L) ? -i : i);
/*     */       } 
/*     */     } 
/*     */     
/* 238 */     return LuaValue.valueOf(Double.longBitsToDouble(paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LuaValue e() {
/* 247 */     if (this.c == 1) {
/* 248 */       return LuaNumber.valueOf(a());
/*     */     }
/* 250 */     return longBitsToLuaNumber(c());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Prototype paramPrototype) {
/*     */     int i;
/* 261 */     LuaValue[] arrayOfLuaValue = ((i = a()) > 0) ? new LuaValue[i] : d;
/* 262 */     for (byte b2 = 0; b2 < i; b2++) {
/* 263 */       switch (this.is.readByte()) {
/*     */         case 0:
/* 265 */           arrayOfLuaValue[b2] = LuaValue.NIL;
/*     */           break;
/*     */         case 1:
/* 268 */           arrayOfLuaValue[b2] = (0 != this.is.readUnsignedByte()) ? LuaValue.TRUE : LuaValue.FALSE;
/*     */           break;
/*     */         case -2:
/* 271 */           arrayOfLuaValue[b2] = LuaNumber.valueOf(a());
/*     */           break;
/*     */         case 3:
/* 274 */           arrayOfLuaValue[b2] = e();
/*     */           break;
/*     */         case 4:
/* 277 */           arrayOfLuaValue[b2] = d();
/*     */           break;
/*     */         default:
/* 280 */           throw new IllegalStateException("bad constant");
/*     */       } 
/*     */     } 
/* 283 */     paramPrototype.k = arrayOfLuaValue;
/*     */ 
/*     */     
/* 286 */     Prototype[] arrayOfPrototype = ((i = a()) > 0) ? new Prototype[i] : e;
/* 287 */     for (byte b1 = 0; b1 < i; b1++)
/* 288 */       arrayOfPrototype[b1] = loadFunction(paramPrototype.source); 
/* 289 */     paramPrototype.p = arrayOfPrototype;
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(Prototype paramPrototype) {
/* 294 */     int i = a();
/* 295 */     paramPrototype.upvalues = (i > 0) ? new Upvaldesc[i] : g;
/* 296 */     for (byte b = 0; b < i; b++) {
/* 297 */       boolean bool = (this.is.readByte() != 0) ? true : false;
/* 298 */       int j = this.is.readByte() & 0xFF;
/* 299 */       paramPrototype.upvalues[b] = new Upvaldesc(null, bool, j);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(Prototype paramPrototype) {
/* 309 */     paramPrototype.source = d();
/* 310 */     paramPrototype.lineinfo = b();
/* 311 */     int i = a();
/* 312 */     paramPrototype.locvars = (i > 0) ? new LocVars[i] : f; byte b;
/* 313 */     for (b = 0; b < i; b++) {
/* 314 */       LuaString luaString = d();
/* 315 */       int j = a();
/* 316 */       int k = a();
/* 317 */       paramPrototype.locvars[b] = new LocVars(luaString, j, k);
/*     */     } 
/*     */     
/* 320 */     i = a();
/* 321 */     for (b = 0; b < i; b++) {
/* 322 */       (paramPrototype.upvalues[b]).name = d();
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
/*     */   public final Prototype loadFunction(LuaString paramLuaString) {
/*     */     Prototype prototype;
/* 336 */     (prototype = new Prototype()).linedefined = a();
/* 337 */     prototype.lastlinedefined = a();
/* 338 */     prototype.numparams = this.is.readUnsignedByte();
/* 339 */     prototype.is_vararg = this.is.readUnsignedByte();
/* 340 */     prototype.maxstacksize = this.is.readUnsignedByte();
/* 341 */     prototype.code = b();
/* 342 */     a(prototype);
/* 343 */     b(prototype);
/* 344 */     c(prototype);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 350 */     return prototype;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void loadHeader() {
/* 358 */     this.is.readByte();
/* 359 */     this.is.readByte();
/* 360 */     this.a = (0 != this.is.readByte());
/* 361 */     this.is.readByte();
/* 362 */     this.b = this.is.readByte();
/* 363 */     this.is.readByte();
/* 364 */     this.is.readByte();
/* 365 */     this.c = this.is.readByte();
/* 366 */     for (byte b = 0; b < LUAC_TAIL.length; b++) {
/* 367 */       if (this.is.readByte() != LUAC_TAIL[b]) {
/* 368 */         throw new LuaError("Unexpeted byte in luac tail of header, index=" + b);
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
/*     */   public static Prototype undump(InputStream paramInputStream, String paramString) {
/* 380 */     if (paramInputStream.read() != LUA_SIGNATURE[0] || paramInputStream
/* 381 */       .read() != LUA_SIGNATURE[1] || paramInputStream
/* 382 */       .read() != LUA_SIGNATURE[2] || paramInputStream
/* 383 */       .read() != LUA_SIGNATURE[3]) {
/* 384 */       return null;
/*     */     }
/*     */     
/* 387 */     paramString = getSourceName(paramString);
/*     */     LoadState loadState;
/* 389 */     (loadState = new LoadState(paramInputStream, paramString)).loadHeader();
/*     */ 
/*     */     
/* 392 */     switch (loadState.c) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 0:
/*     */       case 1:
/*     */       case 4:
/* 400 */         return loadState.loadFunction(LuaString.valueOf(paramString));
/*     */     } 
/*     */     throw new LuaError("unsupported int size");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getSourceName(String paramString) {
/* 409 */     String str = paramString;
/* 410 */     if (paramString.startsWith("@") || paramString.startsWith("=")) {
/* 411 */       str = paramString.substring(1);
/* 412 */     } else if (paramString.startsWith("\033")) {
/* 413 */       str = "binary string";
/* 414 */     }  return str;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private LoadState(InputStream paramInputStream, String paramString) {
/* 420 */     this.is = new DataInputStream(paramInputStream);
/*     */   }
/*     */   
/*     */   public static final class GlobalsUndumper
/*     */     implements Globals.Undumper {
/*     */     public final Prototype undump(InputStream param1InputStream, String param1String) {
/* 426 */       return LoadState.undump(param1InputStream, param1String);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\LoadState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */