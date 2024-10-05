/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(arrayLevels = 1, serializer = FPrototype.Serializer.class)
/*     */ public final class FPrototype
/*     */ {
/*     */   public final LuaValue[] k;
/*     */   
/*     */   static {
/*  14 */     new Upvaldesc[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public final int[] code;
/*     */   
/*     */   public final FPrototype[] p;
/*     */   
/*     */   public final short[] lineinfo;
/*     */   
/*     */   public final LocVars[] locvars;
/*     */   
/*     */   public final Upvaldesc[] upvalues;
/*     */   public final LuaString source;
/*     */   public final short linedefined;
/*     */   public final short lastlinedefined;
/*     */   public final byte numparams;
/*     */   public final boolean is_vararg;
/*     */   public final byte maxstacksize;
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<FPrototype>
/*     */   {
/*     */     public void write(Kryo param1Kryo, Output param1Output, FPrototype param1FPrototype) {
/*  38 */       LuaValue.NILLABLE_SERIALIZER.writeClassAndObject(param1Kryo, param1Output, param1FPrototype.k);
/*  39 */       param1Kryo.writeObjectOrNull(param1Output, param1FPrototype.code, int[].class);
/*  40 */       param1Kryo.writeClassAndObject(param1Output, param1FPrototype.p);
/*  41 */       param1Kryo.writeObjectOrNull(param1Output, param1FPrototype.lineinfo, short[].class);
/*  42 */       param1Kryo.writeClassAndObject(param1Output, param1FPrototype.locvars);
/*  43 */       param1Kryo.writeClassAndObject(param1Output, param1FPrototype.upvalues);
/*  44 */       param1Kryo.writeObjectOrNull(param1Output, param1FPrototype.source, LuaString.class);
/*  45 */       param1Output.writeShort(param1FPrototype.linedefined);
/*  46 */       param1Output.writeShort(param1FPrototype.lastlinedefined);
/*  47 */       param1Output.writeByte(param1FPrototype.numparams);
/*  48 */       param1Output.writeBoolean(param1FPrototype.is_vararg);
/*  49 */       param1Output.writeByte(param1FPrototype.maxstacksize);
/*     */     }
/*     */ 
/*     */     
/*     */     public FPrototype read(Kryo param1Kryo, Input param1Input, Class<? extends FPrototype> param1Class) {
/*  54 */       LuaValue[] arrayOfLuaValue = (LuaValue[])param1Kryo.readClassAndObject(param1Input);
/*  55 */       int[] arrayOfInt = (int[])param1Kryo.readObjectOrNull(param1Input, int[].class);
/*  56 */       FPrototype[] arrayOfFPrototype = (FPrototype[])param1Kryo.readClassAndObject(param1Input);
/*  57 */       short[] arrayOfShort = (short[])param1Kryo.readObjectOrNull(param1Input, short[].class);
/*  58 */       LocVars[] arrayOfLocVars = (LocVars[])param1Kryo.readClassAndObject(param1Input);
/*  59 */       Upvaldesc[] arrayOfUpvaldesc = (Upvaldesc[])param1Kryo.readClassAndObject(param1Input);
/*  60 */       LuaString luaString = (LuaString)param1Kryo.readObjectOrNull(param1Input, LuaString.class);
/*  61 */       short s1 = param1Input.readShort();
/*  62 */       short s2 = param1Input.readShort();
/*  63 */       byte b2 = param1Input.readByte();
/*  64 */       boolean bool = param1Input.readBoolean();
/*  65 */       byte b1 = param1Input.readByte();
/*  66 */       return new FPrototype(arrayOfLuaValue, arrayOfInt, arrayOfFPrototype, arrayOfShort, arrayOfLocVars, arrayOfUpvaldesc, luaString, s1, s2, b2, bool, b1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FPrototype(LuaValue[] paramArrayOfLuaValue, int[] paramArrayOfint, FPrototype[] paramArrayOfFPrototype, short[] paramArrayOfshort, LocVars[] paramArrayOfLocVars, Upvaldesc[] paramArrayOfUpvaldesc, LuaString paramLuaString, short paramShort1, short paramShort2, byte paramByte1, boolean paramBoolean, byte paramByte2) {
/*  73 */     this.k = paramArrayOfLuaValue;
/*  74 */     this.code = paramArrayOfint;
/*  75 */     this.p = paramArrayOfFPrototype;
/*  76 */     this.lineinfo = paramArrayOfshort;
/*  77 */     this.locvars = paramArrayOfLocVars;
/*  78 */     this.upvalues = paramArrayOfUpvaldesc;
/*  79 */     this.source = paramLuaString;
/*  80 */     this.linedefined = paramShort1;
/*  81 */     this.lastlinedefined = paramShort2;
/*  82 */     this.numparams = paramByte1;
/*  83 */     this.is_vararg = paramBoolean;
/*  84 */     this.maxstacksize = paramByte2;
/*     */   }
/*     */   
/*     */   public final String toString() {
/*  88 */     return this.source + ":" + this.linedefined + "-" + this.lastlinedefined;
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
/*  99 */     for (byte b = 0; b < this.locvars.length && (this.locvars[b]).startpc <= paramInt2; b++) {
/*     */       
/* 101 */       paramInt1--;
/* 102 */       if (paramInt2 < (this.locvars[b]).endpc && paramInt1 == 0) {
/* 103 */         return (this.locvars[b]).varname;
/*     */       }
/*     */     } 
/* 106 */     return null;
/*     */   }
/*     */   
/*     */   public final String shortsource() {
/* 110 */     if (this.source == null) {
/* 111 */       return "no source";
/*     */     }
/*     */     
/*     */     String str;
/* 115 */     if ((str = this.source.tojstring()).startsWith("@") || str.startsWith("=")) {
/* 116 */       str = str.substring(1);
/* 117 */     } else if (str.startsWith("\033")) {
/* 118 */       str = "binary string";
/* 119 */     }  return str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\FPrototype.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */