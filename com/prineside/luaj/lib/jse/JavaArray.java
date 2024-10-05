/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.LuaBoolean;
/*     */ import com.prineside.luaj.LuaError;
/*     */ import com.prineside.luaj.LuaNumber;
/*     */ import com.prineside.luaj.LuaValue;
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
/*     */ @REGS(serializer = JavaArray.Serializer.class)
/*     */ public final class JavaArray
/*     */   extends JavaInstance
/*     */ {
/*  24 */   public static final LuaValue LENGTH = (LuaValue)valueOf("length");
/*     */   private final byte b;
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<JavaArray>
/*     */   {
/*     */     public void write(Kryo param1Kryo, Output param1Output, JavaArray param1JavaArray) {
/*  31 */       param1Kryo.writeClassAndObject(param1Output, param1JavaArray.m_instance);
/*  32 */       param1Kryo.writeClassAndObject(param1Output, param1JavaArray.m_metatable);
/*     */     }
/*     */ 
/*     */     
/*     */     public JavaArray read(Kryo param1Kryo, Input param1Input, Class<? extends JavaArray> param1Class) {
/*  37 */       Object object = param1Kryo.readClassAndObject(param1Input);
/*  38 */       LuaValue luaValue = (LuaValue)param1Kryo.readClassAndObject(param1Input);
/*  39 */       JavaArray javaArray = new JavaArray(object);
/*  40 */       if (luaValue != null) {
/*  41 */         javaArray.setmetatable(luaValue);
/*     */       }
/*  43 */       return javaArray;
/*     */     }
/*     */   }
/*     */   
/*     */   public JavaArray(Object<?> paramObject) {
/*  48 */     super(paramObject);
/*     */ 
/*     */     
/*  51 */     if (!(paramObject = (Object<?>)paramObject.getClass()).isArray()) {
/*  52 */       throw new IllegalArgumentException("Class is not an array: " + paramObject);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     if ((paramObject = (Object<?>)paramObject.getComponentType()) == float.class) {
/*  59 */       this.b = 0; return;
/*  60 */     }  if (paramObject == int.class) {
/*  61 */       this.b = 1; return;
/*  62 */     }  if (paramObject == boolean.class) {
/*  63 */       this.b = 2; return;
/*  64 */     }  if (paramObject == double.class) {
/*  65 */       this.b = 3; return;
/*  66 */     }  if (paramObject == long.class) {
/*  67 */       this.b = 4; return;
/*  68 */     }  if (paramObject == byte.class) {
/*  69 */       this.b = 5; return;
/*  70 */     }  if (paramObject == short.class) {
/*  71 */       this.b = 6; return;
/*  72 */     }  if (paramObject == char.class) {
/*  73 */       this.b = 7; return;
/*     */     } 
/*  75 */     this.b = 8;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaValue len() {
/*  81 */     switch (this.b) { case 0:
/*  82 */         return CoerceJavaToLua.coerce(Integer.valueOf(((float[])this.m_instance).length));
/*  83 */       case 1: return CoerceJavaToLua.coerce(Integer.valueOf(((int[])this.m_instance).length));
/*  84 */       case 2: return CoerceJavaToLua.coerce(Integer.valueOf(((boolean[])this.m_instance).length));
/*  85 */       case 3: return CoerceJavaToLua.coerce(Integer.valueOf(((double[])this.m_instance).length));
/*  86 */       case 4: return CoerceJavaToLua.coerce(Integer.valueOf(((long[])this.m_instance).length));
/*  87 */       case 5: return CoerceJavaToLua.coerce(Integer.valueOf(((byte[])this.m_instance).length));
/*  88 */       case 6: return CoerceJavaToLua.coerce(Integer.valueOf(((short[])this.m_instance).length));
/*  89 */       case 7: return CoerceJavaToLua.coerce(Integer.valueOf(((char[])this.m_instance).length)); }
/*  90 */      return CoerceJavaToLua.coerce(Integer.valueOf(((Object[])this.m_instance).length));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void set(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/*     */     int i;
/*  96 */     if (paramLuaValue1.isint()) {
/*  97 */       float[] arrayOfFloat; int[] arrayOfInt; boolean[] arrayOfBoolean; double[] arrayOfDouble; long[] arrayOfLong; byte[] arrayOfByte; short[] arrayOfShort; char[] arrayOfChar; i = paramLuaValue1.checkint() - 1;
/*     */       
/*  99 */       switch (this.b) {
/*     */         case 0:
/* 101 */           arrayOfFloat = (float[])this.m_instance;
/* 102 */           a(i, arrayOfFloat.length);
/* 103 */           arrayOfFloat[i] = paramLuaValue2.tofloat();
/*     */           return;
/*     */         
/*     */         case 1:
/* 107 */           arrayOfInt = (int[])this.m_instance;
/* 108 */           a(i, arrayOfInt.length);
/* 109 */           arrayOfInt[i] = paramLuaValue2.toint();
/*     */           return;
/*     */         
/*     */         case 2:
/* 113 */           arrayOfBoolean = (boolean[])this.m_instance;
/* 114 */           a(i, arrayOfBoolean.length);
/* 115 */           arrayOfBoolean[i] = paramLuaValue2.toboolean();
/*     */           return;
/*     */         
/*     */         case 3:
/* 119 */           arrayOfDouble = (double[])this.m_instance;
/* 120 */           a(i, arrayOfDouble.length);
/* 121 */           arrayOfDouble[i] = paramLuaValue2.todouble();
/*     */           return;
/*     */         
/*     */         case 4:
/* 125 */           arrayOfLong = (long[])this.m_instance;
/* 126 */           a(i, arrayOfLong.length);
/* 127 */           arrayOfLong[i] = paramLuaValue2.tolong();
/*     */           return;
/*     */         
/*     */         case 5:
/* 131 */           arrayOfByte = (byte[])this.m_instance;
/* 132 */           a(i, arrayOfByte.length);
/* 133 */           arrayOfByte[i] = paramLuaValue2.tobyte();
/*     */           return;
/*     */         
/*     */         case 6:
/* 137 */           arrayOfShort = (short[])this.m_instance;
/* 138 */           a(i, arrayOfShort.length);
/* 139 */           arrayOfShort[i] = paramLuaValue2.toshort();
/*     */           return;
/*     */         
/*     */         case 7:
/* 143 */           arrayOfChar = (char[])this.m_instance;
/* 144 */           a(i, arrayOfChar.length);
/* 145 */           arrayOfChar[i] = paramLuaValue2.tochar();
/*     */           return;
/*     */       } 
/*     */       
/* 149 */       Object[] arrayOfObject = (Object[])this.m_instance;
/* 150 */       a(i, arrayOfObject.length);
/* 151 */       switch (paramLuaValue2.type()) {
/*     */         case 5:
/*     */         case 6:
/* 154 */           arrayOfObject[i] = paramLuaValue2;
/*     */           return;
/*     */       } 
/* 157 */       arrayOfObject[i] = paramLuaValue2.touserdata();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 164 */     super.set(i, paramLuaValue2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaValue get(LuaValue paramLuaValue) {
/*     */     int i;
/* 170 */     if (paramLuaValue.isnumber()) {
/* 171 */       float[] arrayOfFloat; int[] arrayOfInt; boolean[] arrayOfBoolean; double[] arrayOfDouble; long[] arrayOfLong; byte[] arrayOfByte; short[] arrayOfShort; char[] arrayOfChar; i = paramLuaValue.toint() - 1;
/* 172 */       switch (this.b) {
/*     */         case 0:
/* 174 */           arrayOfFloat = (float[])this.m_instance;
/* 175 */           a(i, arrayOfFloat.length);
/* 176 */           return (LuaValue)LuaNumber.valueOf(arrayOfFloat[i]);
/*     */         
/*     */         case 1:
/* 179 */           arrayOfInt = (int[])this.m_instance;
/* 180 */           a(i, arrayOfInt.length);
/* 181 */           return (LuaValue)LuaNumber.valueOf(arrayOfInt[i]);
/*     */         
/*     */         case 2:
/* 184 */           arrayOfBoolean = (boolean[])this.m_instance;
/* 185 */           a(i, arrayOfBoolean.length);
/* 186 */           return (LuaValue)LuaBoolean.valueOf(arrayOfBoolean[i]);
/*     */         
/*     */         case 3:
/* 189 */           arrayOfDouble = (double[])this.m_instance;
/* 190 */           a(i, arrayOfDouble.length);
/* 191 */           return (LuaValue)LuaNumber.valueOf(arrayOfDouble[i]);
/*     */         
/*     */         case 4:
/* 194 */           arrayOfLong = (long[])this.m_instance;
/* 195 */           a(i, arrayOfLong.length);
/* 196 */           return (LuaValue)LuaNumber.valueOf(arrayOfLong[i]);
/*     */         
/*     */         case 5:
/* 199 */           arrayOfByte = (byte[])this.m_instance;
/* 200 */           a(i, arrayOfByte.length);
/* 201 */           return (LuaValue)LuaNumber.valueOf(arrayOfByte[i]);
/*     */         
/*     */         case 6:
/* 204 */           arrayOfShort = (short[])this.m_instance;
/* 205 */           a(i, arrayOfShort.length);
/* 206 */           return (LuaValue)LuaNumber.valueOf(arrayOfShort[i]);
/*     */         
/*     */         case 7:
/* 209 */           arrayOfChar = (char[])this.m_instance;
/* 210 */           a(i, arrayOfChar.length);
/* 211 */           return (LuaValue)LuaNumber.valueOf(arrayOfChar[i]);
/*     */       } 
/*     */       
/* 214 */       Object[] arrayOfObject = (Object[])this.m_instance;
/* 215 */       a(i, arrayOfObject.length);
/* 216 */       return CoerceJavaToLua.coerce(arrayOfObject[i]);
/*     */     } 
/*     */     
/* 219 */     if (i.equals(LENGTH)) {
/* 220 */       return len();
/*     */     }
/* 222 */     return super.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(int paramInt1, int paramInt2) {
/* 227 */     if (paramInt1 < 0 || paramInt1 >= paramInt2)
/* 228 */       throw new LuaError("Accessing index " + (paramInt1 + 1) + " in array of length " + paramInt2 + " (valid range is 1 <> " + paramInt2 + ")"); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JavaArray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */