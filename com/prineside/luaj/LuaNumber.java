/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.lib.MathLib;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class LuaNumber extends LuaValue implements KryoSerializable {
/*  12 */   public static final LuaNumber NAN = new LuaNumber(Double.NaN);
/*  13 */   public static final LuaNumber POSINF = new LuaNumber(Double.POSITIVE_INFINITY);
/*  14 */   public static final LuaNumber NEGINF = new LuaNumber(Double.NEGATIVE_INFINITY);
/*     */   
/*     */   public static final String JSTR_NAN = "nan";
/*     */   
/*     */   public static final String JSTR_POSINF = "inf";
/*     */   public static final String JSTR_NEGINF = "-inf";
/*     */   double a;
/*     */   public static LuaValue s_metatable;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  24 */     if ((byte)(int)this.a == this.a) {
/*  25 */       paramOutput.writeByte(0);
/*  26 */       paramOutput.writeByte((byte)(int)this.a); return;
/*  27 */     }  if ((short)(int)this.a == this.a) {
/*  28 */       paramOutput.writeByte(1);
/*  29 */       paramOutput.writeShort((short)(int)this.a); return;
/*  30 */     }  if ((int)this.a == this.a) {
/*  31 */       paramOutput.writeByte(2);
/*  32 */       paramOutput.writeInt((int)this.a); return;
/*  33 */     }  if ((float)this.a == this.a) {
/*  34 */       paramOutput.writeByte(3);
/*  35 */       paramOutput.writeFloat((float)this.a); return;
/*     */     } 
/*  37 */     paramOutput.writeByte(4);
/*  38 */     paramOutput.writeDouble(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*     */     byte b;
/*  45 */     switch (b = paramInput.readByte()) { case 0:
/*  46 */         this.a = paramInput.readByte(); return;
/*  47 */       case 1: this.a = paramInput.readShort(); return;
/*  48 */       case 2: this.a = paramInput.readInt(); return;
/*  49 */       case 3: this.a = paramInput.readFloat(); return; }
/*  50 */      this.a = paramInput.readDouble();
/*     */   }
/*     */ 
/*     */   
/*     */   private LuaNumber() {}
/*     */   
/*     */   private LuaNumber(double paramDouble) {
/*  57 */     this.a = paramDouble;
/*     */   }
/*     */   
/*     */   public static int hashCode(int paramInt) {
/*  61 */     return paramInt;
/*     */   }
/*     */   
/*     */   public static LuaNumber valueOf(double paramDouble) {
/*  65 */     return new LuaNumber(paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LuaNumber valueOf(int paramInt) {
/*  70 */     return valueOf(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setDirectly(double paramDouble) {
/*  75 */     this.a = paramDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/*  80 */     if (isint()) {
/*  81 */       return (int)this.a;
/*     */     }
/*  83 */     return super.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int originalHashCode() {
/*  88 */     return super.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean islong() {
/*  93 */     return (this.a == (long)this.a);
/*     */   }
/*     */   
/*     */   public final boolean isinttype() {
/*  97 */     return ((int)this.a == this.a);
/*     */   }
/*     */   public final boolean isint() {
/* 100 */     return ((int)this.a == this.a);
/*     */   }
/*     */   public final byte tobyte() {
/* 103 */     return (byte)(int)(long)this.a;
/*     */   }
/*     */   public final char tochar() {
/* 106 */     return (char)(int)(long)this.a;
/*     */   }
/*     */   public final double todouble() {
/* 109 */     return this.a;
/*     */   }
/*     */   public final float tofloat() {
/* 112 */     return (float)this.a;
/*     */   }
/*     */   public final int toint() {
/* 115 */     return (int)(long)this.a;
/*     */   }
/*     */   public final long tolong() {
/* 118 */     return (long)this.a;
/*     */   }
/*     */   public final short toshort() {
/* 121 */     return (short)(int)(long)this.a;
/*     */   }
/*     */   public final double optdouble(double paramDouble) {
/* 124 */     return this.a;
/*     */   }
/*     */   public final int optint(int paramInt) {
/* 127 */     return (int)(long)this.a;
/*     */   }
/*     */   public final long optlong(long paramLong) {
/* 130 */     return (long)this.a;
/*     */   }
/*     */   
/*     */   public final LuaValue neg() {
/* 134 */     return valueOf(-this.a);
/*     */   }
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 138 */     return (paramObject instanceof LuaNumber && ((LuaNumber)paramObject).a == this.a);
/*     */   }
/*     */   
/*     */   public final LuaValue eq(LuaValue paramLuaValue) {
/* 142 */     return paramLuaValue.raweq(this.a) ? TRUE : FALSE;
/*     */   }
/*     */   public final boolean eq_b(LuaValue paramLuaValue) {
/* 145 */     return paramLuaValue.raweq(this.a);
/*     */   }
/*     */   
/*     */   public final boolean raweq(LuaValue paramLuaValue) {
/* 149 */     return paramLuaValue.raweq(this.a);
/*     */   }
/*     */   public final boolean raweq(double paramDouble) {
/* 152 */     return (this.a == paramDouble);
/*     */   }
/*     */   public final boolean raweq(int paramInt) {
/* 155 */     return (this.a == paramInt);
/*     */   }
/*     */   
/*     */   public final LuaValue add(LuaValue paramLuaValue) {
/* 159 */     return paramLuaValue.add(this.a);
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
/*     */   public final LuaValue add(double paramDouble) {
/* 175 */     return valueOf(paramDouble + this.a);
/*     */   } public final LuaValue sub(LuaValue paramLuaValue) {
/* 177 */     return paramLuaValue.subFrom(this.a);
/*     */   } public final LuaValue sub(double paramDouble) {
/* 179 */     return valueOf(this.a - paramDouble);
/*     */   } public final LuaValue sub(int paramInt) {
/* 181 */     return valueOf(this.a - paramInt);
/*     */   } public final LuaValue subFrom(double paramDouble) {
/* 183 */     return valueOf(paramDouble - this.a);
/*     */   } public final LuaValue mul(LuaValue paramLuaValue) {
/* 185 */     return paramLuaValue.mul(this.a);
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
/*     */   public final LuaValue mul(double paramDouble) {
/* 201 */     return valueOf(paramDouble * this.a);
/*     */   } public final LuaValue mul(int paramInt) {
/* 203 */     return valueOf(paramInt * this.a);
/*     */   } public final LuaValue pow(LuaValue paramLuaValue) {
/* 205 */     return paramLuaValue.powWith(this.a);
/*     */   } public final LuaValue pow(double paramDouble) {
/* 207 */     return MathLib.dpow(this.a, paramDouble);
/*     */   } public final LuaValue pow(int paramInt) {
/* 209 */     return MathLib.dpow(this.a, paramInt);
/*     */   } public final LuaValue powWith(double paramDouble) {
/* 211 */     return MathLib.dpow(paramDouble, this.a);
/*     */   } public final LuaValue powWith(int paramInt) {
/* 213 */     return MathLib.dpow(paramInt, this.a);
/*     */   } public final LuaValue div(LuaValue paramLuaValue) {
/* 215 */     return paramLuaValue.divInto(this.a);
/*     */   } public final LuaValue div(double paramDouble) {
/* 217 */     return ddiv(this.a, paramDouble);
/*     */   } public final LuaValue div(int paramInt) {
/* 219 */     return ddiv(this.a, paramInt);
/*     */   } public final LuaValue divInto(double paramDouble) {
/* 221 */     return ddiv(paramDouble, this.a);
/*     */   } public final LuaValue mod(LuaValue paramLuaValue) {
/* 223 */     return paramLuaValue.modFrom(this.a);
/*     */   } public final LuaValue mod(double paramDouble) {
/* 225 */     return dmod(this.a, paramDouble);
/*     */   } public final LuaValue mod(int paramInt) {
/* 227 */     return dmod(this.a, paramInt);
/*     */   } public final LuaValue modFrom(double paramDouble) {
/* 229 */     return dmod(paramDouble, this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LuaValue ddiv(double paramDouble1, double paramDouble2) {
/* 240 */     return (paramDouble2 != 0.0D) ? valueOf(paramDouble1 / paramDouble2) : ((paramDouble1 > 0.0D) ? POSINF : ((paramDouble1 == 0.0D) ? NAN : NEGINF));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double ddiv_d(double paramDouble1, double paramDouble2) {
/* 250 */     return (paramDouble2 != 0.0D) ? (paramDouble1 / paramDouble2) : ((paramDouble1 > 0.0D) ? Double.POSITIVE_INFINITY : ((paramDouble1 == 0.0D) ? Double.NaN : Double.NEGATIVE_INFINITY));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LuaValue dmod(double paramDouble1, double paramDouble2) {
/* 261 */     if (paramDouble2 == 0.0D || paramDouble1 == Double.POSITIVE_INFINITY || paramDouble1 == Double.NEGATIVE_INFINITY) return NAN; 
/* 262 */     if (paramDouble2 == Double.POSITIVE_INFINITY) {
/* 263 */       return (paramDouble1 < 0.0D) ? POSINF : valueOf(paramDouble1);
/*     */     }
/* 265 */     if (paramDouble2 == Double.NEGATIVE_INFINITY) {
/* 266 */       return (paramDouble1 > 0.0D) ? NEGINF : valueOf(paramDouble1);
/*     */     }
/* 268 */     return valueOf(paramDouble1 - paramDouble2 * Math.floor(paramDouble1 / paramDouble2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double dmod_d(double paramDouble1, double paramDouble2) {
/* 279 */     if (paramDouble2 == 0.0D || paramDouble1 == Double.POSITIVE_INFINITY || paramDouble1 == Double.NEGATIVE_INFINITY) return Double.NaN; 
/* 280 */     if (paramDouble2 == Double.POSITIVE_INFINITY) {
/* 281 */       return (paramDouble1 < 0.0D) ? Double.POSITIVE_INFINITY : paramDouble1;
/*     */     }
/* 283 */     if (paramDouble2 == Double.NEGATIVE_INFINITY) {
/* 284 */       return (paramDouble1 > 0.0D) ? Double.NEGATIVE_INFINITY : paramDouble1;
/*     */     }
/* 286 */     return paramDouble1 - paramDouble2 * Math.floor(paramDouble1 / paramDouble2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaValue lt(LuaValue paramLuaValue) {
/* 291 */     return (paramLuaValue instanceof LuaNumber) ? (paramLuaValue.gt_b(this.a) ? TRUE : FALSE) : super.lt(paramLuaValue);
/*     */   } public final LuaValue lt(double paramDouble) {
/* 293 */     return (this.a < paramDouble) ? TRUE : FALSE;
/*     */   } public final LuaValue lt(int paramInt) {
/* 295 */     return (this.a < paramInt) ? TRUE : FALSE;
/*     */   } public final boolean lt_b(LuaValue paramLuaValue) {
/* 297 */     return (paramLuaValue instanceof LuaNumber) ? paramLuaValue.gt_b(this.a) : super.lt_b(paramLuaValue);
/*     */   } public final boolean lt_b(int paramInt) {
/* 299 */     return (this.a < paramInt);
/*     */   } public final boolean lt_b(double paramDouble) {
/* 301 */     return (this.a < paramDouble);
/*     */   } public final LuaValue lteq(LuaValue paramLuaValue) {
/* 303 */     return (paramLuaValue instanceof LuaNumber) ? (paramLuaValue.gteq_b(this.a) ? TRUE : FALSE) : super.lteq(paramLuaValue);
/*     */   } public final LuaValue lteq(double paramDouble) {
/* 305 */     return (this.a <= paramDouble) ? TRUE : FALSE;
/*     */   } public final LuaValue lteq(int paramInt) {
/* 307 */     return (this.a <= paramInt) ? TRUE : FALSE;
/*     */   } public final boolean lteq_b(LuaValue paramLuaValue) {
/* 309 */     return (paramLuaValue instanceof LuaNumber) ? paramLuaValue.gteq_b(this.a) : super.lteq_b(paramLuaValue);
/*     */   } public final boolean lteq_b(int paramInt) {
/* 311 */     return (this.a <= paramInt);
/*     */   } public final boolean lteq_b(double paramDouble) {
/* 313 */     return (this.a <= paramDouble);
/*     */   } public final LuaValue gt(LuaValue paramLuaValue) {
/* 315 */     return (paramLuaValue instanceof LuaNumber) ? (paramLuaValue.lt_b(this.a) ? TRUE : FALSE) : super.gt(paramLuaValue);
/*     */   } public final LuaValue gt(double paramDouble) {
/* 317 */     return (this.a > paramDouble) ? TRUE : FALSE;
/*     */   } public final LuaValue gt(int paramInt) {
/* 319 */     return (this.a > paramInt) ? TRUE : FALSE;
/*     */   } public final boolean gt_b(LuaValue paramLuaValue) {
/* 321 */     return (paramLuaValue instanceof LuaNumber) ? paramLuaValue.lt_b(this.a) : super.gt_b(paramLuaValue);
/*     */   } public final boolean gt_b(int paramInt) {
/* 323 */     return (this.a > paramInt);
/*     */   } public final boolean gt_b(double paramDouble) {
/* 325 */     return (this.a > paramDouble);
/*     */   } public final LuaValue gteq(LuaValue paramLuaValue) {
/* 327 */     return (paramLuaValue instanceof LuaNumber) ? (paramLuaValue.lteq_b(this.a) ? TRUE : FALSE) : super.gteq(paramLuaValue);
/*     */   } public final LuaValue gteq(double paramDouble) {
/* 329 */     return (this.a >= paramDouble) ? TRUE : FALSE;
/*     */   } public final LuaValue gteq(int paramInt) {
/* 331 */     return (this.a >= paramInt) ? TRUE : FALSE;
/*     */   } public final boolean gteq_b(LuaValue paramLuaValue) {
/* 333 */     return (paramLuaValue instanceof LuaNumber) ? paramLuaValue.lteq_b(this.a) : super.gteq_b(paramLuaValue);
/*     */   } public final boolean gteq_b(int paramInt) {
/* 335 */     return (this.a >= paramInt);
/*     */   } public final boolean gteq_b(double paramDouble) {
/* 337 */     return (this.a >= paramDouble);
/*     */   }
/*     */   
/*     */   public final int strcmp(LuaString paramLuaString) {
/* 341 */     b("attempt to compare number with string"); return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String tojstring() {
/*     */     long l;
/* 352 */     if ((l = (long)this.a) == this.a)
/* 353 */       return Long.toString(l); 
/* 354 */     if (Double.isNaN(this.a))
/* 355 */       return "nan"; 
/* 356 */     if (Double.isInfinite(this.a))
/* 357 */       return (this.a < 0.0D) ? "-inf" : "inf"; 
/* 358 */     return Float.toString((float)this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaString strvalue() {
/* 363 */     return LuaString.valueOf(tojstring());
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaString optstring(LuaString paramLuaString) {
/* 368 */     return LuaString.valueOf(tojstring());
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaValue tostring() {
/* 373 */     return LuaString.valueOf(tojstring());
/*     */   }
/*     */ 
/*     */   
/*     */   public final String optjstring(String paramString) {
/* 378 */     return tojstring();
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaNumber optnumber(LuaNumber paramLuaNumber) {
/* 383 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isnumber() {
/* 388 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isstring() {
/* 393 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaValue tonumber() {
/* 398 */     return this;
/*     */   }
/*     */   public final int checkint() {
/* 401 */     return (int)(long)this.a;
/*     */   } public final long checklong() {
/* 403 */     return (long)this.a;
/*     */   } public final LuaNumber checknumber() {
/* 405 */     return this;
/*     */   } public final double checkdouble() {
/* 407 */     return this.a;
/*     */   }
/*     */   public final String checkjstring() {
/* 410 */     return tojstring();
/*     */   }
/*     */   
/*     */   public final LuaString checkstring() {
/* 414 */     return LuaString.valueOf(tojstring());
/*     */   }
/*     */   
/*     */   public final boolean isvalidkey() {
/* 418 */     return !Double.isNaN(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int type() {
/* 426 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String typename() {
/* 431 */     return "number";
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaNumber checknumber(String paramString) {
/* 436 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaValue getmetatable() {
/* 441 */     return s_metatable;
/*     */   }
/*     */   
/*     */   public final LuaValue concat(LuaValue paramLuaValue) {
/* 445 */     return paramLuaValue.concatTo(this);
/*     */   } public final Buffer concat(Buffer paramBuffer) {
/* 447 */     return paramBuffer.concatTo(this);
/*     */   } public final LuaValue concatTo(LuaNumber paramLuaNumber) {
/* 449 */     return strvalue().concatTo(paramLuaNumber.strvalue());
/*     */   } public final LuaValue concatTo(LuaString paramLuaString) {
/* 451 */     return strvalue().concatTo(paramLuaString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\LuaNumber.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */