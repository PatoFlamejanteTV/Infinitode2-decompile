/*     */ package com.prineside.luaj.debug;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.FPrototype;
/*     */ import com.prineside.luaj.Lua;
/*     */ import com.prineside.luaj.LuaClosure;
/*     */ import com.prineside.luaj.LuaFunction;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ @REGS(arrayLevels = 1)
/*     */ public final class CallFrame
/*     */   implements KryoSerializable
/*     */ {
/*  21 */   private static final LuaString b = LuaValue.valueOf("?");
/*     */   
/*     */   public LuaFunction f;
/*     */   
/*     */   public int pc;
/*     */   private int c;
/*     */   private Varargs d;
/*     */   private LuaValue[] e;
/*     */   CallFrame a;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  32 */     paramKryo.writeClassAndObject(paramOutput, this.f);
/*  33 */     paramOutput.writeInt(this.pc);
/*  34 */     paramOutput.writeInt(this.c);
/*  35 */     paramKryo.writeClassAndObject(paramOutput, this.d);
/*  36 */     LuaValue.NILLABLE_SERIALIZER.writeClassAndObject(paramKryo, paramOutput, this.e);
/*  37 */     paramKryo.writeObjectOrNull(paramOutput, this.a, CallFrame.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  42 */     this.f = (LuaFunction)paramKryo.readClassAndObject(paramInput);
/*  43 */     this.pc = paramInput.readInt();
/*  44 */     this.c = paramInput.readInt();
/*  45 */     this.d = (Varargs)paramKryo.readClassAndObject(paramInput);
/*  46 */     this.e = (LuaValue[])paramKryo.readClassAndObject(paramInput);
/*  47 */     this.a = (CallFrame)paramKryo.readObjectOrNull(paramInput, CallFrame.class);
/*     */   }
/*     */   
/*     */   final void a(LuaClosure paramLuaClosure, Varargs paramVarargs, LuaValue[] paramArrayOfLuaValue) {
/*  51 */     this.f = (LuaFunction)paramLuaClosure;
/*  52 */     this.d = paramVarargs;
/*  53 */     this.e = paramArrayOfLuaValue;
/*     */   }
/*     */   public final String shortsource() {
/*  56 */     return this.f.isclosure() ? (this.f.checkclosure()).p.shortsource() : "[Java]";
/*     */   }
/*     */   final void a(LuaFunction paramLuaFunction) {
/*  59 */     this.f = paramLuaFunction;
/*     */   }
/*     */   final void a() {
/*  62 */     this.f = null;
/*  63 */     this.d = null;
/*  64 */     this.e = null;
/*     */   }
/*     */   final void a(int paramInt1, Varargs paramVarargs, int paramInt2) {
/*  67 */     this.pc = paramInt1;
/*  68 */     this.d = paramVarargs;
/*  69 */     this.c = paramInt2;
/*     */   }
/*     */   public final int currentline() {
/*  72 */     if (!this.f.isclosure()) return -1; 
/*     */     short[] arrayOfShort;
/*  74 */     if ((arrayOfShort = (this.f.checkclosure()).p.lineinfo) == null || this.pc < 0 || this.pc >= arrayOfShort.length) return -1;  return arrayOfShort[this.pc];
/*     */   }
/*     */   final int b() {
/*  77 */     return this.f.isclosure() ? (this.f.checkclosure()).p.linedefined : -1;
/*     */   }
/*     */   
/*     */   public static NameWhat getfuncname(CallFrame paramCallFrame) {
/*     */     LuaString luaString;
/*  82 */     if (!paramCallFrame.f.isclosure())
/*  83 */       return new NameWhat(paramCallFrame.f.classnamestub(), "Java"); 
/*  84 */     FPrototype fPrototype = (paramCallFrame.f.checkclosure()).p;
/*  85 */     int i = paramCallFrame.pc;
/*     */     
/*     */     int j;
/*  88 */     switch (Lua.GET_OPCODE(j = fPrototype.code[i])) {
/*     */       case 29:
/*     */       case 30:
/*  91 */         return getobjname(fPrototype, i, Lua.GETARG_A(j));
/*     */       case 34:
/*  93 */         return new NameWhat("(for iterator)", "(for iterator");
/*     */       case 6:
/*     */       case 7:
/*     */       case 12:
/*  97 */         luaString = LuaValue.INDEX;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 115 */         return new NameWhat(luaString.tojstring(), "metamethod");case 8: case 10: luaString = LuaValue.NEWINDEX; return new NameWhat(luaString.tojstring(), "metamethod");case 24: luaString = LuaValue.EQ; return new NameWhat(luaString.tojstring(), "metamethod");case 13: luaString = LuaValue.ADD; return new NameWhat(luaString.tojstring(), "metamethod");case 14: luaString = LuaValue.SUB; return new NameWhat(luaString.tojstring(), "metamethod");case 15: luaString = LuaValue.MUL; return new NameWhat(luaString.tojstring(), "metamethod");case 16: luaString = LuaValue.DIV; return new NameWhat(luaString.tojstring(), "metamethod");case 17: luaString = LuaValue.MOD; return new NameWhat(luaString.tojstring(), "metamethod");case 18: luaString = LuaValue.POW; return new NameWhat(luaString.tojstring(), "metamethod");case 19: luaString = LuaValue.UNM; return new NameWhat(luaString.tojstring(), "metamethod");case 21: luaString = LuaValue.LEN; return new NameWhat(luaString.tojstring(), "metamethod");case 25: luaString = LuaValue.LT; return new NameWhat(luaString.tojstring(), "metamethod");case 26: luaString = LuaValue.LE; return new NameWhat(luaString.tojstring(), "metamethod");case 22: luaString = LuaValue.CONCAT; return new NameWhat(luaString.tojstring(), "metamethod");
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public static NameWhat getobjname(FPrototype paramFPrototype, int paramInt1, int paramInt2) {
/*     */     LuaString luaString;
/* 122 */     if ((luaString = paramFPrototype.getlocalname(paramInt2 + 1, paramInt1)) != null) {
/* 123 */       return new NameWhat(luaString.tojstring(), "local");
/*     */     }
/*     */ 
/*     */     
/* 127 */     if ((paramInt1 = findsetreg(paramFPrototype, paramInt1, paramInt2)) != -1) {
/*     */       String str1; LuaString luaString1; int j; LuaString luaString2; int i; int k; String str2;
/* 129 */       switch (Lua.GET_OPCODE(paramInt2 = paramFPrototype.code[paramInt1])) {
/*     */         case 0:
/* 131 */           j = Lua.GETARG_A(paramInt2);
/*     */           
/* 133 */           if ((k = Lua.GETARG_B(paramInt2)) < j) {
/* 134 */             return getobjname(paramFPrototype, paramInt1, k);
/*     */           }
/*     */           break;
/*     */         case 6:
/*     */         case 7:
/* 139 */           j = Lua.GETARG_C(paramInt2);
/* 140 */           k = Lua.GETARG_B(paramInt2);
/*     */ 
/*     */           
/* 143 */           luaString1 = (Lua.GET_OPCODE(paramInt2) == 7) ? paramFPrototype.getlocalname(k + 1, paramInt1) : ((k < paramFPrototype.upvalues.length) ? (paramFPrototype.upvalues[k]).name : b);
/* 144 */           str1 = kname(paramFPrototype, paramInt1, j);
/* 145 */           return new NameWhat(str1, (luaString1 != null && luaString1.eq_b((LuaValue)LuaValue.ENV)) ? "global" : "field");
/*     */ 
/*     */ 
/*     */         
/*     */         case 5:
/* 150 */           return ((luaString2 = (LuaString)(((j = Lua.GETARG_B(luaString1)) < ((FPrototype)str1).upvalues.length) ? (((FPrototype)str1).upvalues[j]).name : b)) == null) ? null : new NameWhat(luaString2.tojstring(), "upvalue");
/*     */ 
/*     */         
/*     */         case 1:
/*     */         case 2:
/* 155 */           i = (Lua.GET_OPCODE(luaString1) == 1) ? Lua.GETARG_Bx(luaString1) : Lua.GETARG_Ax(((FPrototype)str1).code[paramInt1 + 1]);
/* 156 */           if (((FPrototype)str1).k[i].isstring()) {
/* 157 */             LuaString luaString3 = ((FPrototype)str1).k[i].strvalue();
/* 158 */             return new NameWhat(luaString3.tojstring(), "constant");
/*     */           } 
/*     */           break;
/*     */         
/*     */         case 12:
/* 163 */           i = Lua.GETARG_C(luaString1);
/* 164 */           str2 = kname((FPrototype)str1, paramInt1, i);
/* 165 */           return new NameWhat(str2, "method");
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 171 */     return null;
/*     */   }
/*     */   public static String kname(FPrototype paramFPrototype, int paramInt1, int paramInt2) {
/*     */     LuaValue luaValue;
/* 175 */     if (Lua.ISK(paramInt2)) {
/*     */       
/* 177 */       if ((luaValue = paramFPrototype.k[Lua.INDEXK(paramInt2)]).isstring()) {
/* 178 */         return luaValue.tojstring();
/*     */       }
/*     */     } else {
/*     */       NameWhat nameWhat;
/* 182 */       if ((nameWhat = getobjname((FPrototype)luaValue, paramInt1, paramInt2)) != null && "constant".equals(nameWhat.namewhat)) {
/* 183 */         return nameWhat.name;
/*     */       }
/*     */     } 
/*     */     
/* 187 */     return "?";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int findsetreg(FPrototype paramFPrototype, int paramInt1, int paramInt2) {
/* 195 */     int j = -1;
/* 196 */     for (int i = 0; i < paramInt1; i++) {
/*     */       
/* 198 */       int k, m = Lua.GET_OPCODE(k = paramFPrototype.code[i]);
/* 199 */       int n = Lua.GETARG_A(k);
/* 200 */       switch (m) {
/*     */         case 4:
/* 202 */           k = Lua.GETARG_B(k);
/* 203 */           if (n <= paramInt2 && paramInt2 <= n + k) {
/* 204 */             j = i;
/*     */           }
/*     */           break;
/*     */         case 34:
/* 208 */           if (paramInt2 >= n + 2) j = i;
/*     */           
/*     */           break;
/*     */         case 29:
/*     */         case 30:
/* 213 */           if (paramInt2 >= n) j = i;
/*     */           
/*     */           break;
/*     */         case 23:
/* 217 */           k = Lua.GETARG_sBx(k);
/* 218 */           m = i + 1 + k;
/*     */           
/* 220 */           if (i < m && m <= paramInt1) {
/* 221 */             i += k;
/*     */           }
/*     */           break;
/*     */         case 27:
/* 225 */           if (paramInt2 == n) j = i;
/*     */           
/*     */           break;
/*     */         case 36:
/* 229 */           if ((k >> 14 & 0x1FF) == 0) i++;
/*     */           
/*     */           break;
/*     */         default:
/* 233 */           if (Lua.testAMode(m) && paramInt2 == n)
/* 234 */             j = i; 
/*     */           break;
/*     */       } 
/*     */     } 
/* 238 */     return j;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\debug\CallFrame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */