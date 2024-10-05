/*     */ package com.prineside.luaj.compiler;
/*     */ 
/*     */ import com.prineside.luaj.FPrototype;
/*     */ import com.prineside.luaj.LoadState;
/*     */ import com.prineside.luaj.LocVars;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DumpState
/*     */ {
/*     */   public static boolean ALLOW_INTEGER_CASTING = false;
/*     */   public static final int NUMBER_FORMAT_FLOATS_OR_DOUBLES = 0;
/*     */   public static final int NUMBER_FORMAT_INTS_ONLY = 1;
/*     */   public static final int NUMBER_FORMAT_NUM_PATCH_INT32 = 4;
/*     */   public static final int NUMBER_FORMAT_DEFAULT = 0;
/*     */   private boolean a = true;
/*  89 */   private int b = 0;
/*  90 */   private int c = 8;
/*     */   
/*     */   private DataOutputStream d;
/*     */   
/*     */   private boolean e;
/*     */   
/*     */   private int f;
/*     */ 
/*     */   
/*     */   public DumpState(OutputStream paramOutputStream, boolean paramBoolean) {
/* 100 */     this.d = new DataOutputStream(paramOutputStream);
/* 101 */     this.e = paramBoolean;
/* 102 */     this.f = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(int paramInt) {
/* 110 */     this.d.write(paramInt);
/*     */   }
/*     */   
/*     */   private void b(int paramInt) {
/* 114 */     if (this.a) {
/* 115 */       this.d.writeByte(paramInt & 0xFF);
/* 116 */       this.d.writeByte(paramInt >> 8 & 0xFF);
/* 117 */       this.d.writeByte(paramInt >> 16 & 0xFF);
/* 118 */       this.d.writeByte(paramInt >>> 24); return;
/*     */     } 
/* 120 */     this.d.writeInt(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(LuaString paramLuaString) {
/* 125 */     int i = paramLuaString.len().toint();
/* 126 */     b(i + 1);
/* 127 */     paramLuaString.write(this.d, 0, i);
/* 128 */     this.d.write(0);
/*     */   }
/*     */   
/*     */   private void a(double paramDouble) {
/* 132 */     long l = Double.doubleToLongBits(paramDouble);
/* 133 */     if (this.a) {
/* 134 */       b((int)l);
/* 135 */       b((int)(l >> 32L)); return;
/*     */     } 
/* 137 */     this.d.writeLong(l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(FPrototype paramFPrototype) {
/* 143 */     int arrayOfInt[], i = (arrayOfInt = paramFPrototype.code).length;
/* 144 */     b(i);
/* 145 */     for (byte b = 0; b < i; b++)
/* 146 */       b(arrayOfInt[b]); 
/*     */   }
/*     */   
/*     */   private void b(FPrototype paramFPrototype) {
/*     */     LuaValue[] arrayOfLuaValue;
/* 151 */     int i = (arrayOfLuaValue = paramFPrototype.k).length;
/* 152 */     b(i); byte b;
/* 153 */     for (b = 0; b < i; b++) {
/*     */       LuaValue luaValue;
/* 155 */       switch ((luaValue = arrayOfLuaValue[b]).type()) {
/*     */         case 0:
/* 157 */           this.d.write(0);
/*     */           break;
/*     */         case 1:
/* 160 */           this.d.write(1);
/* 161 */           a(luaValue.toboolean() ? 1 : 0);
/*     */           break;
/*     */         case 3:
/* 164 */           switch (this.b) {
/*     */             case 0:
/* 166 */               this.d.write(3);
/* 167 */               a(luaValue.todouble());
/*     */               break;
/*     */             case 1:
/* 170 */               if (!ALLOW_INTEGER_CASTING && !luaValue.isint())
/* 171 */                 throw new IllegalArgumentException("not an integer: " + luaValue); 
/* 172 */               this.d.write(3);
/* 173 */               b(luaValue.toint());
/*     */               break;
/*     */             case 4:
/* 176 */               if (luaValue.isint()) {
/* 177 */                 this.d.write(-2);
/* 178 */                 b(luaValue.toint()); break;
/*     */               } 
/* 180 */               this.d.write(3);
/* 181 */               a(luaValue.todouble());
/*     */               break;
/*     */           } 
/*     */           
/* 185 */           throw new IllegalArgumentException("number format not supported: " + this.b);
/*     */ 
/*     */         
/*     */         case 4:
/* 189 */           this.d.write(4);
/* 190 */           a((LuaString)luaValue);
/*     */           break;
/*     */         default:
/* 193 */           throw new IllegalArgumentException("bad type for " + luaValue);
/*     */       } 
/*     */     } 
/* 196 */     i = paramFPrototype.p.length;
/* 197 */     b(i);
/* 198 */     for (b = 0; b < i; b++)
/* 199 */       e(paramFPrototype.p[b]); 
/*     */   }
/*     */   
/*     */   private void c(FPrototype paramFPrototype) {
/* 203 */     int i = paramFPrototype.upvalues.length;
/* 204 */     b(i);
/* 205 */     for (byte b = 0; b < i; b++) {
/* 206 */       this.d.writeByte((paramFPrototype.upvalues[b]).instack ? 1 : 0);
/* 207 */       this.d.writeByte((paramFPrototype.upvalues[b]).idx);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void d(FPrototype paramFPrototype) {
/* 213 */     if (this.e) {
/* 214 */       b(0);
/*     */     } else {
/* 216 */       a(paramFPrototype.source);
/* 217 */     }  byte b2 = this.e ? 0 : paramFPrototype.lineinfo.length;
/* 218 */     b(b2); byte b1;
/* 219 */     for (b1 = 0; b1 < b2; b1++)
/* 220 */       b(paramFPrototype.lineinfo[b1]); 
/* 221 */     b2 = this.e ? 0 : paramFPrototype.locvars.length;
/* 222 */     b(b2);
/* 223 */     for (b1 = 0; b1 < b2; b1++) {
/* 224 */       LocVars locVars = paramFPrototype.locvars[b1];
/* 225 */       a(locVars.varname);
/* 226 */       b(locVars.startpc);
/* 227 */       b(locVars.endpc);
/*     */     } 
/* 229 */     b2 = this.e ? 0 : paramFPrototype.upvalues.length;
/* 230 */     b(b2);
/* 231 */     for (b1 = 0; b1 < b2; b1++)
/* 232 */       a((paramFPrototype.upvalues[b1]).name); 
/*     */   }
/*     */   
/*     */   private void e(FPrototype paramFPrototype) {
/* 236 */     b(paramFPrototype.linedefined);
/* 237 */     b(paramFPrototype.lastlinedefined);
/* 238 */     a(paramFPrototype.numparams);
/* 239 */     a(paramFPrototype.is_vararg ? 1 : 0);
/* 240 */     a(paramFPrototype.maxstacksize);
/* 241 */     a(paramFPrototype);
/* 242 */     b(paramFPrototype);
/* 243 */     c(paramFPrototype);
/* 244 */     d(paramFPrototype);
/*     */   }
/*     */   
/*     */   private void a() {
/* 248 */     this.d.write(LoadState.LUA_SIGNATURE);
/* 249 */     this.d.write(82);
/* 250 */     this.d.write(0);
/* 251 */     this.d.write(this.a ? 1 : 0);
/* 252 */     this.d.write(4);
/* 253 */     this.d.write(4);
/* 254 */     this.d.write(4);
/* 255 */     this.d.write(this.c);
/* 256 */     this.d.write(this.b);
/* 257 */     this.d.write(LoadState.LUAC_TAIL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int dump(FPrototype paramFPrototype, OutputStream paramOutputStream, boolean paramBoolean) {
/*     */     DumpState dumpState;
/* 265 */     (dumpState = new DumpState(paramOutputStream, paramBoolean)).a();
/* 266 */     dumpState.e(paramFPrototype);
/* 267 */     return 0;
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
/*     */   public static int dump(FPrototype paramFPrototype, OutputStream paramOutputStream, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
/* 282 */     switch (paramInt) {
/*     */       case 0:
/*     */       case 1:
/*     */       case 4:
/*     */         break;
/*     */       default:
/* 288 */         throw new IllegalArgumentException("number format not supported: " + paramInt);
/*     */     } 
/*     */     DumpState dumpState;
/* 291 */     (dumpState = new DumpState(paramOutputStream, paramBoolean1)).a = paramBoolean2;
/* 292 */     dumpState.b = paramInt;
/* 293 */     dumpState.c = (paramInt == 1) ? 4 : 8;
/* 294 */     dumpState.a();
/* 295 */     dumpState.e(paramFPrototype);
/* 296 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\compiler\DumpState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */