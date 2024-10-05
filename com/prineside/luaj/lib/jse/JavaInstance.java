/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.LuaError;
/*     */ import com.prineside.luaj.LuaNumber;
/*     */ import com.prineside.luaj.LuaUserdata;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class JavaInstance
/*     */   extends LuaUserdata
/*     */ {
/*     */   @NAGS
/*     */   @Null
/*     */   protected JavaClass a;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  57 */     super.write(paramKryo, paramOutput);
/*  58 */     paramKryo.writeObjectOrNull(paramOutput, this.a, JavaClass.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  63 */     super.read(paramKryo, paramInput);
/*  64 */     this.a = (JavaClass)paramKryo.readObjectOrNull(paramInput, JavaClass.class);
/*     */   }
/*     */   
/*     */   protected JavaInstance() {}
/*     */   
/*     */   public JavaInstance(Object paramObject) {
/*  70 */     super(paramObject);
/*     */   }
/*     */   
/*     */   public JavaClass getJavaClass() {
/*  74 */     if (this.a == null) {
/*  75 */       this.a = JavaClass.forClass(this.m_instance.getClass());
/*     */     }
/*     */ 
/*     */     
/*  79 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public LuaValue len() {
/*     */     JavaClass javaClass;
/*  85 */     if ((javaClass = getJavaClass()) == null)
/*     */     {
/*  87 */       return super.len();
/*     */     }
/*  89 */     if (((Class)javaClass.m_instance).isArray())
/*  90 */       return (LuaValue)valueOf(Array.getLength(this.m_instance)); 
/*  91 */     if (this.m_instance instanceof Array) {
/*  92 */       return (LuaValue)valueOf(((Array)this.m_instance).size);
/*     */     }
/*  94 */     return super.len();
/*     */   }
/*     */ 
/*     */   
/*     */   public LuaValue get(LuaValue paramLuaValue) {
/*     */     Field field;
/* 100 */     JavaClass javaClass = getJavaClass();
/*     */ 
/*     */     
/* 103 */     if (!(paramLuaValue instanceof com.prineside.luaj.LuaString))
/*     */     {
/* 105 */       return super.get(paramLuaValue);
/*     */     }
/*     */     
/*     */     JavaClass.NamedClassEntry namedClassEntry;
/*     */     
/* 110 */     if ((namedClassEntry = javaClass.getObjectFieldOrMethod(paramLuaValue)) != null) {
/* 111 */       if (namedClassEntry.isField) {
/*     */         
/* 113 */         field = (Field)namedClassEntry.entry;
/*     */         try {
/* 115 */           switch (namedClassEntry.fieldType) { case 0:
/* 116 */               return (LuaValue)LuaNumber.valueOf(field.getInt(this.m_instance));
/* 117 */             case 1: return (LuaValue)LuaNumber.valueOf(field.getFloat(this.m_instance));
/* 118 */             case 2: return (LuaValue)LuaNumber.valueOf(field.getDouble(this.m_instance));
/* 119 */             case 3: return (LuaValue)(field.getBoolean(this.m_instance) ? LuaValue.TRUE : LuaValue.FALSE);
/* 120 */             case 4: return (LuaValue)LuaNumber.valueOf(field.getByte(this.m_instance));
/* 121 */             case 5: return (LuaValue)LuaNumber.valueOf(field.getShort(this.m_instance));
/* 122 */             case 6: return (LuaValue)LuaNumber.valueOf(field.getChar(this.m_instance));
/* 123 */             case 7: return (LuaValue)LuaNumber.valueOf(field.getLong(this.m_instance)); }
/* 124 */            return CoerceJavaToLua.coerce(field.get(this.m_instance));
/*     */         }
/* 126 */         catch (Exception exception) {
/* 127 */           throw new LuaError("Failed to access field " + field, 1, exception);
/*     */         } 
/*     */       } 
/*     */       
/* 131 */       return (LuaValue)((JavaClass.NamedClassEntry)exception).entry;
/*     */     } 
/*     */     
/* 134 */     if (this.m_metatable == null) {
/* 135 */       throw new LuaError("Field / method / inner class '" + field.typename() + " " + field + "' not found in " + this.m_instance.getClass() + " " + this + " and no metatable is set");
/*     */     }
/*     */ 
/*     */     
/* 139 */     return super.get((LuaValue)field);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 147 */     if (!(paramLuaValue1 instanceof com.prineside.luaj.LuaString)) {
/*     */       
/* 149 */       super.set(paramLuaValue1, paramLuaValue2);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     Field field;
/* 155 */     if ((field = (Field)getJavaClass().getInstanceFields().get(paramLuaValue1)) != null) {
/* 156 */       if (Modifier.isFinal(field.getModifiers())) {
/* 157 */         throw new LuaError("Final field " + field.getName() + " of class " + field.getDeclaringClass() + " can not be changed");
/*     */       }
/*     */       
/*     */       try {
/*     */         Class<?> clazz;
/* 162 */         if ((clazz = field.getType()) == int.class) {
/* 163 */           field.setInt(this.m_instance, paramLuaValue2.toint()); return;
/* 164 */         }  if (clazz == float.class) {
/* 165 */           field.setFloat(this.m_instance, paramLuaValue2.tofloat()); return;
/* 166 */         }  if (clazz == double.class) {
/* 167 */           field.setDouble(this.m_instance, paramLuaValue2.todouble()); return;
/* 168 */         }  if (clazz == boolean.class) {
/* 169 */           field.setBoolean(this.m_instance, paramLuaValue2.toboolean()); return;
/* 170 */         }  if (clazz == byte.class) {
/* 171 */           field.setByte(this.m_instance, paramLuaValue2.tobyte()); return;
/* 172 */         }  if (clazz == short.class) {
/* 173 */           field.setShort(this.m_instance, paramLuaValue2.toshort()); return;
/* 174 */         }  if (clazz == char.class) {
/* 175 */           field.setChar(this.m_instance, paramLuaValue2.tochar()); return;
/* 176 */         }  if (clazz == long.class) {
/* 177 */           field.setLong(this.m_instance, paramLuaValue2.tolong()); return;
/*     */         } 
/* 179 */         field.set(this.m_instance, CoerceLuaToJava.coerce(paramLuaValue2, clazz));
/*     */ 
/*     */         
/*     */         return;
/* 183 */       } catch (Exception exception) {
/* 184 */         throw new LuaError(exception);
/*     */       } 
/*     */     } 
/*     */     
/* 188 */     super.set((LuaValue)exception, paramLuaValue2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JavaInstance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */