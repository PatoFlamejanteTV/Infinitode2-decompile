/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.lib.MathLib;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(serializer = LuaString.Serializer.class)
/*     */ public final class LuaString
/*     */   extends LuaValue
/*     */ {
/*     */   public static LuaValue s_metatable;
/*     */   @NAGS
/*     */   public final byte[] m_bytes;
/*     */   public final int m_offset;
/*     */   public final int m_length;
/*     */   private final int a;
/*     */   @NAGS
/*     */   private String b;
/*     */   
/*     */   private static final class RecentShortStrings
/*     */   {
/* 111 */     private static final LuaString[] a = new LuaString[256];
/*     */   }
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<LuaString>
/*     */   {
/*     */     public void write(Kryo param1Kryo, Output param1Output, LuaString param1LuaString) {
/* 118 */       param1Output.writeString(param1LuaString.tojstring());
/*     */     }
/*     */ 
/*     */     
/*     */     public LuaString read(Kryo param1Kryo, Input param1Input, Class<? extends LuaString> param1Class) {
/*     */       String str;
/* 124 */       return LuaString.valueOf(str = param1Input.readString());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LuaString valueOf(String paramString) {
/*     */     char[] arrayOfChar;
/* 136 */     byte[] arrayOfByte = new byte[lengthAsUtf8(arrayOfChar = paramString.toCharArray())];
/* 137 */     encodeToUtf8(arrayOfChar, arrayOfChar.length, arrayOfByte, 0);
/* 138 */     return valueUsing(arrayOfByte, 0, arrayOfByte.length);
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
/*     */   public static LuaString valueOf(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 154 */     if (paramInt2 > 64) {
/* 155 */       return a(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     }
/* 157 */     int i, j = (i = hashCode(paramArrayOfbyte, paramInt1, paramInt2)) & 0xFF;
/*     */     
/* 159 */     synchronized (RecentShortStrings.a()) {
/*     */       LuaString luaString2;
/* 161 */       if ((luaString2 = RecentShortStrings.a()[j]) != null && luaString2.a == i && luaString2.b(paramArrayOfbyte, paramInt1, paramInt2)) return luaString2; 
/* 162 */       LuaString luaString1 = a(paramArrayOfbyte, paramInt1, paramInt2);
/* 163 */       RecentShortStrings.a()[j] = luaString1;
/*     */     } 
/* 165 */     return (LuaString)paramArrayOfbyte;
/*     */   }
/*     */ 
/*     */   
/*     */   private static LuaString a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 170 */     byte[] arrayOfByte = new byte[paramInt2];
/* 171 */     System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
/* 172 */     return new LuaString(arrayOfByte, 0, paramInt2);
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
/*     */   public static LuaString valueUsing(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 186 */     if (paramArrayOfbyte.length > 64) {
/* 187 */       return new LuaString(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     }
/* 189 */     int i, j = (i = hashCode(paramArrayOfbyte, paramInt1, paramInt2)) & 0xFF;
/*     */     
/*     */     LuaString luaString;
/* 192 */     if ((luaString = RecentShortStrings.a()[j]) != null && luaString.a == i && luaString.b(paramArrayOfbyte, paramInt1, paramInt2)) return luaString; 
/* 193 */     synchronized (RecentShortStrings.a()) {
/* 194 */       LuaString luaString1 = new LuaString(paramArrayOfbyte, paramInt1, paramInt2);
/* 195 */       RecentShortStrings.a()[j] = luaString1;
/*     */     } 
/* 197 */     return (LuaString)paramArrayOfbyte;
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
/*     */   public static LuaString valueOf(char[] paramArrayOfchar) {
/* 209 */     return valueOf(paramArrayOfchar, 0, paramArrayOfchar.length);
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
/*     */   public static LuaString valueOf(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 221 */     byte[] arrayOfByte = new byte[paramInt2];
/* 222 */     for (byte b = 0; b < paramInt2; b++)
/* 223 */       arrayOfByte[b] = (byte)paramArrayOfchar[b + paramInt1]; 
/* 224 */     return valueUsing(arrayOfByte, 0, paramInt2);
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
/*     */   public static LuaString valueOf(byte[] paramArrayOfbyte) {
/* 236 */     return valueOf(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public static LuaString valueUsing(byte[] paramArrayOfbyte) {
/* 251 */     return valueUsing(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   private LuaString(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 264 */     this.m_bytes = paramArrayOfbyte;
/* 265 */     this.m_offset = paramInt1;
/* 266 */     this.m_length = paramInt2;
/* 267 */     this.a = hashCode(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isstring() {
/* 272 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaValue getmetatable() {
/* 277 */     return s_metatable;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int type() {
/* 282 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String typename() {
/* 287 */     return "string";
/*     */   }
/*     */ 
/*     */   
/*     */   public final String tojstring() {
/* 292 */     if (this.b == null) {
/* 293 */       this.b = decodeAsUtf8(this.m_bytes, this.m_offset, this.m_length);
/*     */     }
/*     */     
/* 296 */     return this.b;
/*     */   }
/*     */   
/*     */   public final LuaValue neg() {
/*     */     double d;
/* 301 */     return Double.isNaN(d = scannumber()) ? super.neg() : valueOf(-d);
/*     */   }
/*     */   public final LuaValue add(LuaValue paramLuaValue) {
/*     */     double d;
/* 305 */     return Double.isNaN(d = scannumber()) ? b(ADD, paramLuaValue) : paramLuaValue.add(d);
/*     */   } public final LuaValue add(double paramDouble) {
/* 307 */     return valueOf(d() + paramDouble);
/*     */   }
/* 309 */   public final LuaValue add(int paramInt) { return valueOf(d() + paramInt); } public final LuaValue sub(LuaValue paramLuaValue) {
/*     */     double d;
/* 311 */     return Double.isNaN(d = scannumber()) ? b(SUB, paramLuaValue) : paramLuaValue.subFrom(d);
/*     */   } public final LuaValue sub(double paramDouble) {
/* 313 */     return valueOf(d() - paramDouble);
/*     */   } public final LuaValue sub(int paramInt) {
/* 315 */     return valueOf(d() - paramInt);
/*     */   }
/* 317 */   public final LuaValue subFrom(double paramDouble) { return valueOf(paramDouble - d()); } public final LuaValue mul(LuaValue paramLuaValue) {
/*     */     double d;
/* 319 */     return Double.isNaN(d = scannumber()) ? b(MUL, paramLuaValue) : paramLuaValue.mul(d);
/*     */   } public final LuaValue mul(double paramDouble) {
/* 321 */     return valueOf(d() * paramDouble);
/*     */   }
/* 323 */   public final LuaValue mul(int paramInt) { return valueOf(d() * paramInt); } public final LuaValue pow(LuaValue paramLuaValue) {
/*     */     double d;
/* 325 */     return Double.isNaN(d = scannumber()) ? b(POW, paramLuaValue) : paramLuaValue.powWith(d);
/*     */   } public final LuaValue pow(double paramDouble) {
/* 327 */     return MathLib.dpow(d(), paramDouble);
/*     */   } public final LuaValue pow(int paramInt) {
/* 329 */     return MathLib.dpow(d(), paramInt);
/*     */   } public final LuaValue powWith(double paramDouble) {
/* 331 */     return MathLib.dpow(paramDouble, d());
/*     */   }
/* 333 */   public final LuaValue powWith(int paramInt) { return MathLib.dpow(paramInt, d()); } public final LuaValue div(LuaValue paramLuaValue) {
/*     */     double d;
/* 335 */     return Double.isNaN(d = scannumber()) ? b(DIV, paramLuaValue) : paramLuaValue.divInto(d);
/*     */   } public final LuaValue div(double paramDouble) {
/* 337 */     return LuaNumber.ddiv(d(), paramDouble);
/*     */   } public final LuaValue div(int paramInt) {
/* 339 */     return LuaNumber.ddiv(d(), paramInt);
/*     */   }
/* 341 */   public final LuaValue divInto(double paramDouble) { return LuaNumber.ddiv(paramDouble, d()); } public final LuaValue mod(LuaValue paramLuaValue) {
/*     */     double d;
/* 343 */     return Double.isNaN(d = scannumber()) ? b(MOD, paramLuaValue) : paramLuaValue.modFrom(d);
/*     */   } public final LuaValue mod(double paramDouble) {
/* 345 */     return LuaNumber.dmod(d(), paramDouble);
/*     */   } public final LuaValue mod(int paramInt) {
/* 347 */     return LuaNumber.dmod(d(), paramInt);
/*     */   } public final LuaValue modFrom(double paramDouble) {
/* 349 */     return LuaNumber.dmod(paramDouble, d());
/*     */   }
/*     */   
/*     */   public final LuaValue lt(LuaValue paramLuaValue) {
/* 353 */     return paramLuaValue.isstring() ? ((paramLuaValue.strcmp(this) > 0) ? LuaValue.TRUE : FALSE) : super.lt(paramLuaValue);
/*     */   } public final boolean lt_b(LuaValue paramLuaValue) {
/* 355 */     return paramLuaValue.isstring() ? ((paramLuaValue.strcmp(this) > 0)) : super.lt_b(paramLuaValue);
/*     */   } public final boolean lt_b(int paramInt) {
/* 357 */     b("attempt to compare string with number"); return false;
/*     */   } public final boolean lt_b(double paramDouble) {
/* 359 */     b("attempt to compare string with number"); return false;
/*     */   } public final LuaValue lteq(LuaValue paramLuaValue) {
/* 361 */     return paramLuaValue.isstring() ? ((paramLuaValue.strcmp(this) >= 0) ? LuaValue.TRUE : FALSE) : super.lteq(paramLuaValue);
/*     */   } public final boolean lteq_b(LuaValue paramLuaValue) {
/* 363 */     return paramLuaValue.isstring() ? ((paramLuaValue.strcmp(this) >= 0)) : super.lteq_b(paramLuaValue);
/*     */   } public final boolean lteq_b(int paramInt) {
/* 365 */     b("attempt to compare string with number"); return false;
/*     */   } public final boolean lteq_b(double paramDouble) {
/* 367 */     b("attempt to compare string with number"); return false;
/*     */   } public final LuaValue gt(LuaValue paramLuaValue) {
/* 369 */     return paramLuaValue.isstring() ? ((paramLuaValue.strcmp(this) < 0) ? LuaValue.TRUE : FALSE) : super.gt(paramLuaValue);
/*     */   } public final boolean gt_b(LuaValue paramLuaValue) {
/* 371 */     return paramLuaValue.isstring() ? ((paramLuaValue.strcmp(this) < 0)) : super.gt_b(paramLuaValue);
/*     */   } public final boolean gt_b(int paramInt) {
/* 373 */     b("attempt to compare string with number"); return false;
/*     */   } public final boolean gt_b(double paramDouble) {
/* 375 */     b("attempt to compare string with number"); return false;
/*     */   } public final LuaValue gteq(LuaValue paramLuaValue) {
/* 377 */     return paramLuaValue.isstring() ? ((paramLuaValue.strcmp(this) <= 0) ? LuaValue.TRUE : FALSE) : super.gteq(paramLuaValue);
/*     */   } public final boolean gteq_b(LuaValue paramLuaValue) {
/* 379 */     return paramLuaValue.isstring() ? ((paramLuaValue.strcmp(this) <= 0)) : super.gteq_b(paramLuaValue);
/*     */   } public final boolean gteq_b(int paramInt) {
/* 381 */     b("attempt to compare string with number"); return false;
/*     */   } public final boolean gteq_b(double paramDouble) {
/* 383 */     b("attempt to compare string with number"); return false;
/*     */   }
/*     */   
/*     */   public final LuaValue concat(LuaValue paramLuaValue) {
/* 387 */     return paramLuaValue.concatTo(this);
/*     */   } public final Buffer concat(Buffer paramBuffer) {
/* 389 */     return paramBuffer.concatTo(this);
/*     */   } public final LuaValue concatTo(LuaNumber paramLuaNumber) {
/* 391 */     return concatTo(paramLuaNumber.strvalue());
/*     */   }
/*     */   public final LuaValue concatTo(LuaString paramLuaString) {
/* 394 */     byte[] arrayOfByte = new byte[paramLuaString.m_length + this.m_length];
/* 395 */     System.arraycopy(paramLuaString.m_bytes, paramLuaString.m_offset, arrayOfByte, 0, paramLuaString.m_length);
/* 396 */     System.arraycopy(this.m_bytes, this.m_offset, arrayOfByte, paramLuaString.m_length, this.m_length);
/* 397 */     return valueUsing(arrayOfByte, 0, arrayOfByte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int strcmp(LuaValue paramLuaValue) {
/* 402 */     return -paramLuaValue.strcmp(this);
/*     */   }
/*     */   public final int strcmp(LuaString paramLuaString) {
/* 405 */     for (byte b1 = 0, b2 = 0; b1 < this.m_length && b2 < paramLuaString.m_length; b1++, b2++) {
/* 406 */       if (this.m_bytes[this.m_offset + b1] != paramLuaString.m_bytes[paramLuaString.m_offset + b2]) {
/* 407 */         return this.m_bytes[this.m_offset + b1] - paramLuaString.m_bytes[paramLuaString.m_offset + b2];
/*     */       }
/*     */     } 
/* 410 */     return this.m_length - paramLuaString.m_length;
/*     */   }
/*     */ 
/*     */   
/*     */   private double d() {
/*     */     double d;
/* 416 */     if (Double.isNaN(d = scannumber()))
/* 417 */       b(); 
/* 418 */     return d;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int checkint() {
/* 423 */     return (int)(long)checkdouble();
/*     */   }
/*     */   
/*     */   public final long checklong() {
/* 427 */     return (long)checkdouble();
/*     */   }
/*     */   
/*     */   public final double checkdouble() {
/*     */     double d;
/* 432 */     if (Double.isNaN(d = scannumber()))
/* 433 */       a("number"); 
/* 434 */     return d;
/*     */   }
/*     */   
/*     */   public final LuaNumber checknumber() {
/* 438 */     return valueOf(checkdouble());
/*     */   }
/*     */   
/*     */   public final LuaNumber checknumber(String paramString) {
/*     */     double d;
/* 443 */     if (Double.isNaN(d = scannumber()))
/* 444 */       error(paramString); 
/* 445 */     return valueOf(d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isnumber() {
/*     */     double d;
/* 451 */     return !Double.isNaN(d = scannumber());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isint() {
/*     */     double d;
/* 457 */     if (Double.isNaN(d = scannumber()))
/* 458 */       return false; 
/*     */     int i;
/* 460 */     return ((i = (int)d) == d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean islong() {
/*     */     double d;
/* 466 */     if (Double.isNaN(d = scannumber()))
/* 467 */       return false; 
/*     */     long l;
/* 469 */     return ((l = (long)d) == d);
/*     */   }
/*     */   
/*     */   public final byte tobyte() {
/* 473 */     return (byte)toint();
/*     */   }
/* 475 */   public final char tochar() { return (char)toint(); } public final double todouble() {
/*     */     double d;
/* 477 */     return Double.isNaN(d = scannumber()) ? 0.0D : d;
/*     */   } public final float tofloat() {
/* 479 */     return (float)todouble();
/*     */   } public final int toint() {
/* 481 */     return (int)tolong();
/*     */   } public final long tolong() {
/* 483 */     return (long)todouble();
/*     */   } public final short toshort() {
/* 485 */     return (short)toint();
/*     */   }
/*     */   
/*     */   public final double optdouble(double paramDouble) {
/* 489 */     return checkdouble();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int optint(int paramInt) {
/* 494 */     return checkint();
/*     */   }
/*     */ 
/*     */   
/*     */   public final long optlong(long paramLong) {
/* 499 */     return checklong();
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaNumber optnumber(LuaNumber paramLuaNumber) {
/* 504 */     return checknumber();
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaString optstring(LuaString paramLuaString) {
/* 509 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaValue tostring() {
/* 514 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String optjstring(String paramString) {
/* 519 */     return tojstring();
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaString strvalue() {
/* 524 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaString substring(int paramInt1, int paramInt2) {
/* 534 */     int i = this.m_offset + paramInt1;
/*     */     
/* 536 */     if ((paramInt1 = paramInt2 - paramInt1) >= this.m_length / 2)
/* 537 */       return valueUsing(this.m_bytes, i, paramInt1); 
/* 538 */     return valueOf(this.m_bytes, i, paramInt1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 543 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hashCode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 554 */     int i = paramInt2;
/* 555 */     int j = (paramInt2 >> 5) + 1;
/* 556 */     for (paramInt2 = paramInt2; paramInt2 >= j; paramInt2 -= j)
/* 557 */       i ^= (i << 5) + (i >> 2) + (paramArrayOfbyte[paramInt1 + paramInt2 - 1] & 0xFF); 
/* 558 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 564 */     if (paramObject instanceof LuaString) {
/* 565 */       return raweq((LuaString)paramObject);
/*     */     }
/* 567 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaValue eq(LuaValue paramLuaValue) {
/* 572 */     return paramLuaValue.raweq(this) ? TRUE : FALSE;
/*     */   } public final boolean eq_b(LuaValue paramLuaValue) {
/* 574 */     return paramLuaValue.raweq(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean raweq(LuaValue paramLuaValue) {
/* 579 */     return paramLuaValue.raweq(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean raweq(LuaString paramLuaString) {
/* 584 */     if (this == paramLuaString)
/* 585 */       return true; 
/* 586 */     if (paramLuaString.m_length != this.m_length)
/* 587 */       return false; 
/* 588 */     if (paramLuaString.m_bytes == this.m_bytes && paramLuaString.m_offset == this.m_offset)
/* 589 */       return true; 
/* 590 */     if (paramLuaString.hashCode() != hashCode())
/* 591 */       return false; 
/* 592 */     for (byte b = 0; b < this.m_length; b++) {
/* 593 */       if (paramLuaString.m_bytes[paramLuaString.m_offset + b] != this.m_bytes[this.m_offset + b])
/* 594 */         return false; 
/* 595 */     }  return true;
/*     */   }
/*     */   
/*     */   public static boolean equals(LuaString paramLuaString1, int paramInt1, LuaString paramLuaString2, int paramInt2, int paramInt3) {
/* 599 */     return equals(paramLuaString1.m_bytes, paramLuaString1.m_offset + paramInt1, paramLuaString2.m_bytes, paramLuaString2.m_offset + paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 604 */     return (this.m_length == paramInt2 && equals(this.m_bytes, this.m_offset, paramArrayOfbyte, paramInt1, paramInt2));
/*     */   }
/*     */   
/*     */   public static boolean equals(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2, int paramInt3) {
/* 608 */     if (paramArrayOfbyte1.length < paramInt1 + paramInt3 || paramArrayOfbyte2.length < paramInt2 + paramInt3)
/* 609 */       return false; 
/* 610 */     while (--paramInt3 >= 0) {
/* 611 */       if (paramArrayOfbyte1[paramInt1++] != paramArrayOfbyte2[paramInt2++])
/* 612 */         return false; 
/* 613 */     }  return true;
/*     */   }
/*     */   
/*     */   public final void write(DataOutputStream paramDataOutputStream, int paramInt1, int paramInt2) {
/* 617 */     paramDataOutputStream.write(this.m_bytes, this.m_offset + paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaValue len() {
/* 622 */     return LuaNumber.valueOf(this.m_length);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int length() {
/* 627 */     return this.m_length;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int rawlen() {
/* 632 */     return this.m_length;
/*     */   }
/*     */   
/*     */   public final int luaByte(int paramInt) {
/* 636 */     return this.m_bytes[this.m_offset + paramInt] & 0xFF;
/*     */   }
/*     */   
/*     */   public final int charAt(int paramInt) {
/* 640 */     if (paramInt < 0 || paramInt >= this.m_length)
/* 641 */       throw new IndexOutOfBoundsException(); 
/* 642 */     return luaByte(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String checkjstring() {
/* 647 */     return tojstring();
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaString checkstring() {
/* 652 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final InputStream toInputStream() {
/* 660 */     return new ByteArrayInputStream(this.m_bytes, this.m_offset, this.m_length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void copyInto(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
/* 671 */     System.arraycopy(this.m_bytes, this.m_offset + paramInt1, paramArrayOfbyte, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int indexOfAny(LuaString paramLuaString) {
/* 679 */     int i = this.m_offset + this.m_length;
/* 680 */     int j = paramLuaString.m_offset + paramLuaString.m_length;
/* 681 */     for (int k = this.m_offset; k < i; k++) {
/* 682 */       for (int m = paramLuaString.m_offset; m < j; m++) {
/* 683 */         if (this.m_bytes[k] == paramLuaString.m_bytes[m]) {
/* 684 */           return k - this.m_offset;
/*     */         }
/*     */       } 
/*     */     } 
/* 688 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int indexOf(byte paramByte, int paramInt) {
/* 698 */     for (paramInt = paramInt; paramInt < this.m_length; paramInt++) {
/* 699 */       if (this.m_bytes[this.m_offset + paramInt] == paramByte)
/* 700 */         return paramInt; 
/*     */     } 
/* 702 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int indexOf(LuaString paramLuaString, int paramInt) {
/* 712 */     int i = paramLuaString.length();
/* 713 */     int j = this.m_length - i;
/* 714 */     for (paramInt = paramInt; paramInt <= j; paramInt++) {
/* 715 */       if (equals(this.m_bytes, this.m_offset + paramInt, paramLuaString.m_bytes, paramLuaString.m_offset, i))
/* 716 */         return paramInt; 
/*     */     } 
/* 718 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int lastIndexOf(LuaString paramLuaString) {
/* 727 */     int i = paramLuaString.length();
/*     */     
/* 729 */     for (int j = this.m_length - i; j >= 0; j--) {
/* 730 */       if (equals(this.m_bytes, this.m_offset + j, paramLuaString.m_bytes, paramLuaString.m_offset, i))
/* 731 */         return j; 
/*     */     } 
/* 733 */     return -1;
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
/*     */   public static String decodeAsUtf8(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     int i;
/*     */     byte b;
/* 750 */     for (i = paramInt1, paramInt2 = paramInt1 + paramInt2, b = 0; i < paramInt2; b++) {
/* 751 */       switch (0xE0 & paramArrayOfbyte[i++]) { case 224:
/* 752 */           i++;
/* 753 */         case 192: i++; break; }
/*     */     
/*     */     } 
/* 756 */     char[] arrayOfChar = new char[b];
/* 757 */     for (i = paramInt1, b = 0; i < paramInt2;) {
/* 758 */       arrayOfChar[b++] = 
/*     */ 
/*     */         
/* 761 */         (char)(((paramInt1 = paramArrayOfbyte[i++]) >= 0 || i >= paramInt2) ? paramInt1 : ((paramInt1 < -32 || i + 1 >= paramInt2) ? ((paramInt1 & 0x3F) << 6 | paramArrayOfbyte[i++] & 0x3F) : ((paramInt1 & 0xF) << 12 | (paramArrayOfbyte[i++] & 0x3F) << 6 | paramArrayOfbyte[i++] & 0x3F)));
/*     */     }
/* 763 */     return new String(arrayOfChar);
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
/*     */   public static int lengthAsUtf8(char[] paramArrayOfchar) {
/*     */     int j;
/* 777 */     for (int i = j = paramArrayOfchar.length; --i >= 0;) {
/* 778 */       if ((c = paramArrayOfchar[i]) >= '')
/* 779 */         j += (c >= 'ࠀ') ? 2 : 1; 
/* 780 */     }  return j;
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
/*     */   public static int encodeToUtf8(char[] paramArrayOfchar, int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
/* 800 */     int i = paramInt2;
/* 801 */     for (byte b = 0; b < paramInt1; b++) {
/* 802 */       char c; if ((c = paramArrayOfchar[b]) < '') {
/* 803 */         paramArrayOfbyte[i++] = (byte)c;
/* 804 */       } else if (c < 'ࠀ') {
/* 805 */         paramArrayOfbyte[i++] = (byte)(0xC0 | c >> 6 & 0x1F);
/* 806 */         paramArrayOfbyte[i++] = (byte)(0x80 | c & 0x3F);
/*     */       } else {
/* 808 */         paramArrayOfbyte[i++] = (byte)(0xE0 | c >> 12 & 0xF);
/* 809 */         paramArrayOfbyte[i++] = (byte)(0x80 | c >> 6 & 0x3F);
/* 810 */         paramArrayOfbyte[i++] = (byte)(0x80 | c & 0x3F);
/*     */       } 
/*     */     } 
/* 813 */     return i - paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isValidUtf8() {
/* 823 */     for (int i = this.m_offset, j = this.m_offset + this.m_length; i < j;) {
/*     */       
/* 825 */       if ((b = this.m_bytes[i++]) < 0 && ((
/* 826 */         b & 0xE0) != 192 || i >= j || (this.m_bytes[i++] & 0xC0) != 128))
/*     */       {
/*     */         
/* 829 */         if ((b & 0xF0) != 224 || i + 1 >= j || (this.m_bytes[i++] & 0xC0) != 128 || (this.m_bytes[i++] & 0xC0) != 128)
/*     */         {
/*     */ 
/*     */           
/* 833 */           return false; }  } 
/*     */     } 
/* 835 */     return true;
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
/*     */   public final LuaValue tonumber() {
/*     */     double d;
/* 849 */     return Double.isNaN(d = scannumber()) ? NIL : valueOf(d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaValue tonumber(int paramInt) {
/*     */     double d;
/* 860 */     return Double.isNaN(d = scannumber(paramInt)) ? NIL : valueOf(d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double scannumber() {
/* 869 */     int i = this.m_offset, j = this.m_offset + this.m_length;
/* 870 */     while (i < j && this.m_bytes[i] == 32)
/* 871 */       i++; 
/* 872 */     while (i < j && this.m_bytes[j - 1] == 32)
/* 873 */       j--; 
/* 874 */     if (i >= j)
/* 875 */       return Double.NaN; 
/* 876 */     if (this.m_bytes[i] == 48 && i + 1 < j && (this.m_bytes[i + 1] == 120 || this.m_bytes[i + 1] == 88))
/* 877 */       return a(16, i + 2, j); 
/*     */     double d;
/* 879 */     return Double.isNaN(d = a(10, i, j)) ? a(i, j) : d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double scannumber(int paramInt) {
/* 888 */     if (paramInt < 2 || paramInt > 36)
/* 889 */       return Double.NaN; 
/* 890 */     int i = this.m_offset, j = this.m_offset + this.m_length;
/* 891 */     while (i < j && this.m_bytes[i] == 32)
/* 892 */       i++; 
/* 893 */     while (i < j && this.m_bytes[j - 1] == 32)
/* 894 */       j--; 
/* 895 */     if (i >= j)
/* 896 */       return Double.NaN; 
/* 897 */     return a(paramInt, i, j);
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
/*     */   private double a(int paramInt1, int paramInt2, int paramInt3) {
/* 909 */     long l = 0L;
/*     */     boolean bool;
/* 911 */     for (paramInt2 = (bool = (this.m_bytes[paramInt2] == 45) ? true : false) ? (paramInt2 + 1) : paramInt2; paramInt2 < paramInt3; paramInt2++) {
/*     */       int i;
/*     */       
/* 914 */       if ((i = this.m_bytes[paramInt2] - ((paramInt1 <= 10 || (this.m_bytes[paramInt2] >= 48 && this.m_bytes[paramInt2] <= 57)) ? 48 : ((this.m_bytes[paramInt2] >= 65 && this.m_bytes[paramInt2] <= 90) ? 55 : 87))) < 0 || i >= paramInt1) {
/* 915 */         return Double.NaN;
/*     */       }
/* 917 */       if ((l = l * paramInt1 + i) < 0L)
/* 918 */         return Double.NaN; 
/*     */     } 
/* 920 */     return bool ? -l : l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double a(int paramInt1, int paramInt2) {
/* 931 */     if (paramInt2 > paramInt1 + 64)
/* 932 */       paramInt2 = paramInt1 + 64; 
/* 933 */     for (int i = paramInt1; i < paramInt2; i++) {
/* 934 */       switch (this.m_bytes[i]) {
/*     */         case 43:
/*     */         case 45:
/*     */         case 46:
/*     */         case 48:
/*     */         case 49:
/*     */         case 50:
/*     */         case 51:
/*     */         case 52:
/*     */         case 53:
/*     */         case 54:
/*     */         case 55:
/*     */         case 56:
/*     */         case 57:
/*     */         case 69:
/*     */         case 101:
/*     */           break;
/*     */         default:
/* 952 */           return Double.NaN;
/*     */       } 
/*     */     } 
/* 955 */     char[] arrayOfChar = new char[paramInt2 - paramInt1];
/* 956 */     for (int j = paramInt1; j < paramInt2; j++)
/* 957 */       arrayOfChar[j - paramInt1] = (char)this.m_bytes[j]; 
/*     */     try {
/* 959 */       return Double.parseDouble(new String(arrayOfChar));
/* 960 */     } catch (Exception exception) {
/* 961 */       return Double.NaN;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void printToStream(PrintStream paramPrintStream) {
/*     */     byte b;
/*     */     int i;
/* 971 */     for (b = 0, i = this.m_length; b < i; b++) {
/* 972 */       byte b1 = this.m_bytes[this.m_offset + b];
/* 973 */       paramPrintStream.print((char)b1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\LuaString.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */