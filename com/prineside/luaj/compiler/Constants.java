/*     */ package com.prineside.luaj.compiler;
/*     */ 
/*     */ import com.prineside.luaj.LocVars;
/*     */ import com.prineside.luaj.Lua;
/*     */ import com.prineside.luaj.LuaError;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Prototype;
/*     */ import com.prineside.luaj.Upvaldesc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Constants
/*     */   extends Lua
/*     */ {
/*     */   public static final int MAXSTACK = 150;
/*     */   
/*     */   protected static void a(boolean paramBoolean) {
/*  63 */     if (!paramBoolean)
/*  64 */       throw new LuaError("compiler assert failed"); 
/*     */   }
/*     */   
/*     */   static void a(InstructionPtr paramInstructionPtr, int paramInt) {
/*  68 */     paramInstructionPtr.a(paramInstructionPtr.a() & 0xFFFFFFC0 | 0x1E);
/*     */   }
/*     */   
/*     */   static void a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  72 */     paramArrayOfint[paramInt1] = paramArrayOfint[paramInt1] & 0xFFFFC03F | paramInt2 << 6 & 0x3FC0;
/*     */   }
/*     */   
/*     */   static void b(InstructionPtr paramInstructionPtr, int paramInt) {
/*  76 */     paramInstructionPtr.a(paramInstructionPtr.a() & 0xFFFFC03F | paramInt << 6 & 0x3FC0);
/*     */   }
/*     */   
/*     */   static void c(InstructionPtr paramInstructionPtr, int paramInt) {
/*  80 */     paramInstructionPtr.a(paramInstructionPtr.a() & 0x7FFFFF | paramInt << 23 & 0xFF800000);
/*     */   }
/*     */   
/*     */   static void d(InstructionPtr paramInstructionPtr, int paramInt) {
/*  84 */     paramInstructionPtr.a(paramInstructionPtr.a() & 0xFF803FFF | paramInt << 14 & 0x7FC000);
/*     */   }
/*     */   
/*     */   private static void f(InstructionPtr paramInstructionPtr, int paramInt) {
/*  88 */     paramInstructionPtr.a(paramInstructionPtr.a() & 0x3FFF | paramInt << 14 & 0xFFFFC000);
/*     */   }
/*     */   
/*     */   static void e(InstructionPtr paramInstructionPtr, int paramInt) {
/*  92 */     f(paramInstructionPtr, paramInt + 131071);
/*     */   }
/*     */   
/*     */   static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  96 */     return paramInt1 & 0x3F | paramInt2 << 6 & 0x3FC0 | paramInt3 << 23 & 0xFF800000 | paramInt4 << 14 & 0x7FC000;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int a(int paramInt1, int paramInt2, int paramInt3) {
/* 103 */     return paramInt1 & 0x3F | paramInt2 << 6 & 0x3FC0 | paramInt3 << 14 & 0xFFFFC000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static int a(int paramInt1, int paramInt2) {
/* 109 */     return 0x27 | paramInt2 << 6 & 0xFFFFFFC0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static LuaValue[] a(LuaValue[] paramArrayOfLuaValue, int paramInt) {
/* 116 */     LuaValue[] arrayOfLuaValue = new LuaValue[paramInt];
/* 117 */     if (paramArrayOfLuaValue != null)
/* 118 */       System.arraycopy(paramArrayOfLuaValue, 0, arrayOfLuaValue, 0, Math.min(paramArrayOfLuaValue.length, paramInt)); 
/* 119 */     return arrayOfLuaValue;
/*     */   }
/*     */   
/*     */   static Prototype[] a(Prototype[] paramArrayOfPrototype, int paramInt) {
/* 123 */     Prototype[] arrayOfPrototype = new Prototype[paramInt];
/* 124 */     if (paramArrayOfPrototype != null)
/* 125 */       System.arraycopy(paramArrayOfPrototype, 0, arrayOfPrototype, 0, Math.min(paramArrayOfPrototype.length, paramInt)); 
/* 126 */     return arrayOfPrototype;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static LocVars[] a(LocVars[] paramArrayOfLocVars, int paramInt) {
/* 137 */     LocVars[] arrayOfLocVars = new LocVars[paramInt];
/* 138 */     if (paramArrayOfLocVars != null)
/* 139 */       System.arraycopy(paramArrayOfLocVars, 0, arrayOfLocVars, 0, Math.min(paramArrayOfLocVars.length, paramInt)); 
/* 140 */     return arrayOfLocVars;
/*     */   }
/*     */   
/*     */   static Upvaldesc[] a(Upvaldesc[] paramArrayOfUpvaldesc, int paramInt) {
/* 144 */     Upvaldesc[] arrayOfUpvaldesc = new Upvaldesc[paramInt];
/* 145 */     if (paramArrayOfUpvaldesc != null)
/* 146 */       System.arraycopy(paramArrayOfUpvaldesc, 0, arrayOfUpvaldesc, 0, Math.min(paramArrayOfUpvaldesc.length, paramInt)); 
/* 147 */     return arrayOfUpvaldesc;
/*     */   }
/*     */   
/*     */   static LexState.Vardesc[] a(LexState.Vardesc[] paramArrayOfVardesc, int paramInt) {
/* 151 */     LexState.Vardesc[] arrayOfVardesc = new LexState.Vardesc[paramInt];
/* 152 */     if (paramArrayOfVardesc != null)
/* 153 */       System.arraycopy(paramArrayOfVardesc, 0, arrayOfVardesc, 0, Math.min(paramArrayOfVardesc.length, paramInt)); 
/* 154 */     return arrayOfVardesc;
/*     */   }
/*     */   
/*     */   static LexState.Labeldesc[] a(LexState.Labeldesc[] paramArrayOfLabeldesc, int paramInt) {
/* 158 */     return (paramArrayOfLabeldesc == null) ? new LexState.Labeldesc[2] : ((paramArrayOfLabeldesc.length < paramInt) ? b(paramArrayOfLabeldesc, paramArrayOfLabeldesc.length << 1) : paramArrayOfLabeldesc);
/*     */   }
/*     */   
/*     */   private static LexState.Labeldesc[] b(LexState.Labeldesc[] paramArrayOfLabeldesc, int paramInt) {
/* 162 */     LexState.Labeldesc[] arrayOfLabeldesc = new LexState.Labeldesc[paramInt];
/* 163 */     if (paramArrayOfLabeldesc != null)
/* 164 */       System.arraycopy(paramArrayOfLabeldesc, 0, arrayOfLabeldesc, 0, Math.min(paramArrayOfLabeldesc.length, paramInt)); 
/* 165 */     return arrayOfLabeldesc;
/*     */   }
/*     */   
/*     */   static int[] a(int[] paramArrayOfint, int paramInt) {
/* 169 */     int[] arrayOfInt = new int[paramInt];
/* 170 */     if (paramArrayOfint != null)
/* 171 */       System.arraycopy(paramArrayOfint, 0, arrayOfInt, 0, Math.min(paramArrayOfint.length, paramInt)); 
/* 172 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static char[] a(char[] paramArrayOfchar, int paramInt) {
/* 183 */     char[] arrayOfChar = new char[paramInt];
/* 184 */     if (paramArrayOfchar != null)
/* 185 */       System.arraycopy(paramArrayOfchar, 0, arrayOfChar, 0, Math.min(paramArrayOfchar.length, paramInt)); 
/* 186 */     return arrayOfChar;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\compiler\Constants.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */