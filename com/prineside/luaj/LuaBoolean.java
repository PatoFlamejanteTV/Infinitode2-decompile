/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(serializer = LuaBoolean.Serializer.class)
/*     */ public final class LuaBoolean
/*     */   extends LuaValue
/*     */ {
/*  52 */   static final LuaBoolean a = new LuaBoolean(true);
/*     */   
/*     */   public final boolean v;
/*  55 */   static final LuaBoolean b = new LuaBoolean(false);
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<LuaBoolean> {
/*     */     public Serializer() {
/*  59 */       setImmutable(true);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, LuaBoolean param1LuaBoolean) {
/*  64 */       param1Output.writeBoolean(param1LuaBoolean.v);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public LuaBoolean read(Kryo param1Kryo, Input param1Input, Class<? extends LuaBoolean> param1Class) {
/*     */       boolean bool;
/*  71 */       return (bool = param1Input.readBoolean()) ? LuaBoolean.a : LuaBoolean.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public LuaBoolean read() {
/*  76 */       throw new IllegalStateException("Unused");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LuaBoolean(boolean paramBoolean) {
/*  84 */     this.v = paramBoolean;
/*     */   }
/*     */   
/*     */   public final int type() {
/*  88 */     return 1;
/*     */   }
/*     */   
/*     */   public final String typename() {
/*  92 */     return "boolean";
/*     */   }
/*     */   
/*     */   public final boolean isboolean() {
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   public final LuaValue not() {
/* 100 */     return this.v ? FALSE : LuaValue.TRUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean booleanValue() {
/* 108 */     return this.v;
/*     */   }
/*     */   
/*     */   public final boolean toboolean() {
/* 112 */     return this.v;
/*     */   }
/*     */   
/*     */   public final String tojstring() {
/* 116 */     return this.v ? "true" : "false";
/*     */   }
/*     */   
/*     */   public final boolean optboolean(boolean paramBoolean) {
/* 120 */     return this.v;
/*     */   }
/*     */   
/*     */   public final boolean checkboolean() {
/* 124 */     return this.v;
/*     */   }
/*     */   
/*     */   public final LuaValue getmetatable() {
/* 128 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\LuaBoolean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */