/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
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
/*     */ @REGS(serializer = LuaNil.Serializer.class)
/*     */ public class LuaNil
/*     */   extends LuaValue
/*     */ {
/*  45 */   static final LuaNil a = new LuaNil();
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<LuaNil> {
/*     */     public Serializer() {
/*  49 */       setImmutable(true);
/*     */     }
/*     */ 
/*     */     
/*     */     public LuaNil read() {
/*  54 */       return LuaNil.a;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int type() {
/*  61 */     return 0;
/*     */   }
/*     */   
/*     */   public final String toString() {
/*  65 */     return "nil";
/*     */   }
/*     */   
/*     */   public final String typename() {
/*  69 */     return "nil";
/*     */   }
/*     */   
/*     */   public String tojstring() {
/*  73 */     return "nil";
/*     */   }
/*     */   
/*     */   public final LuaValue not() {
/*  77 */     return LuaValue.TRUE;
/*     */   }
/*     */   
/*     */   public final boolean toboolean() {
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean isnil() {
/*  85 */     return true;
/*     */   }
/*     */   
/*     */   public final LuaValue getmetatable() {
/*  89 */     return null;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/*  93 */     return paramObject instanceof LuaNil;
/*     */   }
/*     */   
/*     */   public final LuaValue checknotnil() {
/*  97 */     return a("value");
/*     */   }
/*     */   
/*     */   public final boolean isvalidkey() {
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean optboolean(boolean paramBoolean) {
/* 105 */     return paramBoolean;
/* 106 */   } public final LuaClosure optclosure(LuaClosure paramLuaClosure) { return paramLuaClosure; }
/* 107 */   public final double optdouble(double paramDouble) { return paramDouble; }
/* 108 */   public final LuaFunction optfunction(LuaFunction paramLuaFunction) { return paramLuaFunction; }
/* 109 */   public final int optint(int paramInt) { return paramInt; }
/* 110 */   public final long optlong(long paramLong) { return paramLong; }
/* 111 */   public final LuaNumber optnumber(LuaNumber paramLuaNumber) { return paramLuaNumber; }
/* 112 */   public final LuaTable opttable(LuaTable paramLuaTable) { return paramLuaTable; }
/* 113 */   public final String optjstring(String paramString) { return paramString; }
/* 114 */   public final LuaString optstring(LuaString paramLuaString) { return paramLuaString; }
/* 115 */   public final Object optuserdata(Object paramObject) { return paramObject; }
/* 116 */   public final Object optuserdata(Class paramClass, Object paramObject) { return paramObject; } public final LuaValue optvalue(LuaValue paramLuaValue) {
/* 117 */     return paramLuaValue;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\LuaNil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */