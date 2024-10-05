/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class LuaUserdata
/*     */   extends LuaValue
/*     */   implements KryoSerializable
/*     */ {
/*     */   public Object m_instance;
/*     */   public LuaValue m_metatable;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  42 */     paramKryo.writeClassAndObject(paramOutput, this.m_instance);
/*  43 */     LuaValue.NILLABLE_SERIALIZER.writeClassAndObject(paramKryo, paramOutput, this.m_metatable);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  48 */     this.m_instance = paramKryo.readClassAndObject(paramInput);
/*  49 */     if (this.m_instance == null) {
/*  50 */       throw new IllegalArgumentException("m_instance is nil after deserialization");
/*     */     }
/*  52 */     this.m_metatable = (LuaValue)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */   
/*     */   protected LuaUserdata() {}
/*     */   
/*     */   public LuaUserdata(Object paramObject) {
/*  58 */     if (paramObject == null) throw new IllegalStateException("obj is null");
/*     */     
/*  60 */     this.m_instance = paramObject;
/*     */   }
/*     */   
/*     */   public LuaUserdata(Object paramObject, LuaValue paramLuaValue) {
/*  64 */     if (paramObject == null) throw new IllegalStateException("obj is null");
/*     */     
/*  66 */     this.m_instance = paramObject;
/*  67 */     this.m_metatable = paramLuaValue;
/*     */   }
/*     */   
/*     */   public String tojstring() {
/*     */     Class<?> clazz;
/*  72 */     if ((clazz = this.m_instance.getClass()).isArray()) {
/*     */       
/*  74 */       if ((clazz = clazz.getComponentType()) == float.class)
/*  75 */         return this.m_instance + " " + Arrays.toString((float[])this.m_instance); 
/*  76 */       if (clazz == int.class)
/*  77 */         return this.m_instance + " " + Arrays.toString((int[])this.m_instance); 
/*  78 */       if (clazz == boolean.class)
/*  79 */         return this.m_instance + " " + Arrays.toString((boolean[])this.m_instance); 
/*  80 */       if (clazz == double.class)
/*  81 */         return this.m_instance + " " + Arrays.toString((double[])this.m_instance); 
/*  82 */       if (clazz == long.class)
/*  83 */         return this.m_instance + " " + Arrays.toString((long[])this.m_instance); 
/*  84 */       if (clazz == char.class)
/*  85 */         return this.m_instance + " " + Arrays.toString((char[])this.m_instance); 
/*  86 */       if (clazz == byte.class)
/*  87 */         return this.m_instance + " " + Arrays.toString((byte[])this.m_instance); 
/*  88 */       if (clazz == short.class) {
/*  89 */         return this.m_instance + " " + Arrays.toString((short[])this.m_instance);
/*     */       }
/*     */       try {
/*  92 */         return this.m_instance + " " + Arrays.toString((Object[])this.m_instance);
/*  93 */       } catch (Exception exception) {
/*  94 */         return this.m_instance.toString();
/*     */       } 
/*     */     } 
/*     */     
/*  98 */     return this.m_instance.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int type() {
/* 103 */     return 7;
/*     */   }
/*     */   
/*     */   public final String typename() {
/* 107 */     return "userdata";
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/* 111 */     return this.m_instance.hashCode();
/*     */   }
/*     */   
/*     */   public final Object userdata() {
/* 115 */     return this.m_instance;
/*     */   }
/*     */   
/* 118 */   public final boolean isuserdata() { return true; }
/* 119 */   public final boolean isuserdata(Class paramClass) { return paramClass.isAssignableFrom(this.m_instance.getClass()); }
/* 120 */   public final Object touserdata() { return this.m_instance; }
/* 121 */   public final Object touserdata(Class paramClass) { return paramClass.isAssignableFrom(this.m_instance.getClass()) ? this.m_instance : null; } public final Object optuserdata(Object paramObject) {
/* 122 */     return this.m_instance;
/*     */   } public final Object optuserdata(Class paramClass, Object paramObject) {
/* 124 */     if (!paramClass.isAssignableFrom(this.m_instance.getClass()))
/* 125 */       b(paramClass.getName()); 
/* 126 */     return this.m_instance;
/*     */   }
/*     */   
/*     */   public final LuaValue getmetatable() {
/* 130 */     return this.m_metatable;
/*     */   }
/*     */   
/*     */   public final LuaValue setmetatable(LuaValue paramLuaValue) {
/* 134 */     this.m_metatable = paramLuaValue;
/* 135 */     return this;
/*     */   }
/*     */   
/*     */   public final Object checkuserdata() {
/* 139 */     return this.m_instance;
/*     */   }
/*     */   
/*     */   public final Object checkuserdata(Class<?> paramClass) {
/*     */     Class<?> clazz;
/* 144 */     if ((clazz = this.m_instance.getClass()) == paramClass || paramClass.isAssignableFrom(clazz))
/* 145 */       return this.m_instance; 
/* 146 */     return b(paramClass.getName());
/*     */   }
/*     */   
/*     */   public LuaValue get(LuaValue paramLuaValue) {
/* 150 */     return (this.m_metatable != null) ? c(this, paramLuaValue) : NIL;
/*     */   }
/*     */   
/*     */   public void set(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 154 */     if (this.m_metatable == null || !a(this, paramLuaValue1, paramLuaValue2))
/* 155 */       error("cannot set '" + paramLuaValue1 + "' for userdata " + this); 
/*     */   }
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 159 */     if (this == paramObject)
/* 160 */       return true; 
/* 161 */     if (!(paramObject instanceof LuaUserdata))
/* 162 */       return false; 
/* 163 */     paramObject = paramObject;
/* 164 */     return this.m_instance.equals(((LuaUserdata)paramObject).m_instance);
/*     */   }
/*     */   
/*     */   public final LuaValue eq(LuaValue paramLuaValue) {
/* 168 */     return eq_b(paramLuaValue) ? TRUE : FALSE;
/*     */   } public final boolean eq_b(LuaValue paramLuaValue) {
/* 170 */     if (paramLuaValue.raweq(this)) return true; 
/* 171 */     if (this.m_metatable == null || !paramLuaValue.isuserdata()) return false; 
/*     */     LuaValue luaValue;
/* 173 */     if ((luaValue = paramLuaValue.getmetatable()) != null && LuaValue.eqmtcall(this, this.m_metatable, paramLuaValue, luaValue)) return true;  return false;
/*     */   }
/*     */   
/*     */   public final boolean raweq(LuaValue paramLuaValue) {
/* 177 */     return paramLuaValue.raweq(this);
/*     */   } public final boolean raweq(LuaUserdata paramLuaUserdata) {
/* 179 */     return (this == paramLuaUserdata || (this.m_metatable == paramLuaUserdata.m_metatable && this.m_instance.equals(paramLuaUserdata.m_instance)));
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean eqmt(LuaValue paramLuaValue) {
/* 184 */     return (this.m_metatable != null && paramLuaValue.isuserdata()) ? LuaValue.eqmtcall(this, this.m_metatable, paramLuaValue, paramLuaValue.getmetatable()) : false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\LuaUserdata.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */