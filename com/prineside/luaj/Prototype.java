/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(arrayLevels = 1)
/*     */ public final class Prototype
/*     */   implements KryoSerializable
/*     */ {
/*     */   public LuaValue[] k;
/*     */   public int[] code;
/*     */   public Prototype[] p;
/*     */   public int[] lineinfo;
/*     */   public LocVars[] locvars;
/*     */   public Upvaldesc[] upvalues;
/*     */   public LuaString source;
/*     */   public int linedefined;
/*     */   public int lastlinedefined;
/*     */   public int numparams;
/*     */   public int is_vararg;
/*     */   public int maxstacksize;
/* 105 */   private static final Upvaldesc[] a = new Upvaldesc[0];
/* 106 */   private static final Prototype[] b = new Prototype[0];
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 110 */     LuaValue.NILLABLE_SERIALIZER.writeClassAndObject(paramKryo, paramOutput, this.k);
/* 111 */     paramKryo.writeObjectOrNull(paramOutput, this.code, int[].class);
/* 112 */     paramKryo.writeClassAndObject(paramOutput, this.p);
/* 113 */     paramKryo.writeObjectOrNull(paramOutput, this.lineinfo, int[].class);
/* 114 */     paramKryo.writeClassAndObject(paramOutput, this.locvars);
/* 115 */     paramKryo.writeClassAndObject(paramOutput, this.upvalues);
/* 116 */     paramKryo.writeObjectOrNull(paramOutput, this.source, LuaString.class);
/* 117 */     paramOutput.writeInt(this.linedefined);
/* 118 */     paramOutput.writeInt(this.lastlinedefined);
/* 119 */     paramOutput.writeInt(this.numparams);
/* 120 */     paramOutput.writeInt(this.is_vararg);
/* 121 */     paramOutput.writeInt(this.maxstacksize);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 126 */     this.k = (LuaValue[])paramKryo.readClassAndObject(paramInput);
/* 127 */     this.code = (int[])paramKryo.readObjectOrNull(paramInput, int[].class);
/* 128 */     this.p = (Prototype[])paramKryo.readClassAndObject(paramInput);
/* 129 */     this.lineinfo = (int[])paramKryo.readObjectOrNull(paramInput, int[].class);
/* 130 */     this.locvars = (LocVars[])paramKryo.readClassAndObject(paramInput);
/* 131 */     this.upvalues = (Upvaldesc[])paramKryo.readClassAndObject(paramInput);
/* 132 */     this.source = (LuaString)paramKryo.readObjectOrNull(paramInput, LuaString.class);
/* 133 */     this.linedefined = paramInput.readInt();
/* 134 */     this.lastlinedefined = paramInput.readInt();
/* 135 */     this.numparams = paramInput.readInt();
/* 136 */     this.is_vararg = paramInput.readInt();
/* 137 */     this.maxstacksize = paramInput.readInt();
/*     */   }
/*     */   
/*     */   public final FPrototype toFixedProto() {
/* 141 */     FPrototype[] arrayOfFPrototype = new FPrototype[this.p.length];
/* 142 */     for (byte b1 = 0; b1 < this.p.length; b1++) {
/* 143 */       arrayOfFPrototype[b1] = this.p[b1].toFixedProto();
/*     */     }
/* 145 */     short[] arrayOfShort = new short[this.lineinfo.length];
/* 146 */     for (byte b2 = 0; b2 < this.lineinfo.length; b2++) {
/* 147 */       arrayOfShort[b2] = (short)this.lineinfo[b2];
/*     */     }
/* 149 */     return new FPrototype(this.k, this.code, arrayOfFPrototype, arrayOfShort, this.locvars, this.upvalues, this.source, (short)this.linedefined, (short)this.lastlinedefined, (byte)this.numparams, (this.is_vararg != 0), (byte)this.maxstacksize);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Prototype() {
/* 157 */     this.p = b;
/* 158 */     this.upvalues = a;
/*     */   }
/*     */   
/*     */   public Prototype(int paramInt) {
/* 162 */     this.p = b;
/* 163 */     this.upvalues = new Upvaldesc[paramInt];
/*     */   }
/*     */   
/*     */   public final String toString() {
/* 167 */     return this.source + ":" + this.linedefined + "-" + this.lastlinedefined;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaString getlocalname(int paramInt1, int paramInt2) {
/* 178 */     for (byte b = 0; b < this.locvars.length && (this.locvars[b]).startpc <= paramInt2; b++) {
/*     */       
/* 180 */       paramInt1--;
/* 181 */       if (paramInt2 < (this.locvars[b]).endpc && paramInt1 == 0) {
/* 182 */         return (this.locvars[b]).varname;
/*     */       }
/*     */     } 
/* 185 */     return null;
/*     */   }
/*     */   
/*     */   public final String shortsource() {
/* 189 */     if (this.source == null) {
/* 190 */       return "no source";
/*     */     }
/*     */     
/*     */     String str;
/* 194 */     if ((str = this.source.tojstring()).startsWith("@") || str.startsWith("=")) {
/* 195 */       str = str.substring(1);
/* 196 */     } else if (str.startsWith("\033")) {
/* 197 */       str = "binary string";
/* 198 */     }  return str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\Prototype.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */