/*     */ package com.prineside.luaj;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Buffer
/*     */ {
/*  44 */   private static final byte[] a = new byte[0];
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] b;
/*     */ 
/*     */ 
/*     */   
/*     */   private int c;
/*     */ 
/*     */   
/*     */   private int d;
/*     */ 
/*     */   
/*     */   private LuaValue e;
/*     */ 
/*     */ 
/*     */   
/*     */   public Buffer() {
/*  63 */     this(64);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Buffer(int paramInt) {
/*  71 */     this.b = new byte[paramInt];
/*  72 */     this.c = 0;
/*  73 */     this.d = 0;
/*  74 */     this.e = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Buffer(LuaValue paramLuaValue) {
/*  82 */     this.b = a;
/*  83 */     this.c = this.d = 0;
/*  84 */     this.e = paramLuaValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaValue value() {
/*  92 */     return (this.e != null) ? this.e : tostring();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Buffer setvalue(LuaValue paramLuaValue) {
/* 100 */     this.b = a;
/* 101 */     this.d = this.c = 0;
/* 102 */     this.e = paramLuaValue;
/* 103 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaString tostring() {
/* 111 */     a(this.c, 0);
/* 112 */     return LuaString.valueOf(this.b, this.d, this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String tojstring() {
/* 120 */     return value().tojstring();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 128 */     return tojstring();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Buffer append(byte paramByte) {
/* 136 */     makeroom(0, 1);
/* 137 */     this.b[this.d + this.c++] = paramByte;
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Buffer append(LuaValue paramLuaValue) {
/* 146 */     append(paramLuaValue.strvalue());
/* 147 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Buffer append(LuaString paramLuaString) {
/* 155 */     int i = paramLuaString.m_length;
/* 156 */     makeroom(0, i);
/* 157 */     paramLuaString.copyInto(0, this.b, this.d + this.c, i);
/* 158 */     this.c += i;
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Buffer append(String paramString) {
/*     */     char[] arrayOfChar;
/* 170 */     int i = LuaString.lengthAsUtf8(arrayOfChar = paramString.toCharArray());
/* 171 */     makeroom(0, i);
/* 172 */     LuaString.encodeToUtf8(arrayOfChar, arrayOfChar.length, this.b, this.d + this.c);
/* 173 */     this.c += i;
/* 174 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Buffer concatTo(LuaValue paramLuaValue) {
/* 182 */     return setvalue(paramLuaValue.concat(value()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Buffer concatTo(LuaString paramLuaString) {
/* 190 */     return (this.e != null && !this.e.isstring()) ? setvalue(paramLuaString.concat(this.e)) : prepend(paramLuaString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Buffer concatTo(LuaNumber paramLuaNumber) {
/* 200 */     return (this.e != null && !this.e.isstring()) ? setvalue(paramLuaNumber.concat(this.e)) : prepend(paramLuaNumber.strvalue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Buffer prepend(LuaString paramLuaString) {
/* 208 */     int i = paramLuaString.m_length;
/* 209 */     makeroom(i, 0);
/* 210 */     System.arraycopy(paramLuaString.m_bytes, paramLuaString.m_offset, this.b, this.d - i, i);
/* 211 */     this.d -= i;
/* 212 */     this.c += i;
/* 213 */     this.e = null;
/* 214 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void makeroom(int paramInt1, int paramInt2) {
/* 222 */     if (this.e != null) {
/* 223 */       LuaString luaString = this.e.strvalue();
/* 224 */       this.e = null;
/* 225 */       this.c = luaString.m_length;
/* 226 */       this.d = paramInt1;
/* 227 */       this.b = new byte[paramInt1 + this.c + paramInt2];
/* 228 */       System.arraycopy(luaString.m_bytes, luaString.m_offset, this.b, this.d, this.c); return;
/* 229 */     }  if (this.d + this.c + paramInt2 > this.b.length || this.d < paramInt1) {
/*     */       
/* 231 */       int i = ((i = paramInt1 + this.c + paramInt2) < 32) ? 32 : ((i < this.c << 1) ? (this.c << 1) : i);
/* 232 */       a(i, (paramInt1 == 0) ? 0 : (i - this.c - paramInt2));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void a(int paramInt1, int paramInt2) {
/* 241 */     if (paramInt1 != this.b.length) {
/* 242 */       byte[] arrayOfByte = new byte[paramInt1];
/* 243 */       System.arraycopy(this.b, this.d, arrayOfByte, paramInt2, this.c);
/* 244 */       this.b = arrayOfByte;
/* 245 */       this.d = paramInt2;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\Buffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */