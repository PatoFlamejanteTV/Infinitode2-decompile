/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
/*     */ import com.esotericsoftware.kryo.ClassResolver;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.Registration;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultClassResolver
/*     */   implements ClassResolver
/*     */ {
/*     */   public static final byte NAME = -1;
/*     */   protected Kryo kryo;
/*  39 */   protected final IntMap<Registration> idToRegistration = new IntMap<>();
/*  40 */   protected final IdentityMap<Class, Registration> classToRegistration = new IdentityMap<>();
/*     */   
/*     */   protected IdentityObjectIntMap<Class> classToNameId;
/*     */   
/*     */   protected IntMap<Class> nameIdToClass;
/*     */   protected ObjectMap<String, Class> nameToClass;
/*     */   protected int nextNameId;
/*  47 */   private int memoizedClassId = -1;
/*     */   private Registration memoizedClassIdValue;
/*     */   private Class memoizedClass;
/*     */   private Registration memoizedClassValue;
/*     */   
/*     */   public void setKryo(Kryo paramKryo) {
/*  53 */     this.kryo = paramKryo;
/*     */   }
/*     */   
/*     */   public Registration register(Registration paramRegistration) {
/*  57 */     this.memoizedClassId = -1;
/*  58 */     this.memoizedClass = null;
/*  59 */     if (paramRegistration == null) throw new IllegalArgumentException("registration cannot be null."); 
/*  60 */     if (paramRegistration.getId() != -1) {
/*  61 */       if (Log.TRACE) {
/*  62 */         Log.trace("kryo", "Register class ID " + paramRegistration.getId() + ": " + Util.className(paramRegistration.getType()) + " (" + paramRegistration
/*  63 */             .getSerializer().getClass().getName() + ")");
/*     */       }
/*  65 */       this.idToRegistration.put(paramRegistration.getId(), paramRegistration);
/*  66 */     } else if (Log.TRACE) {
/*  67 */       Log.trace("kryo", "Register class name: " + Util.className(paramRegistration.getType()) + " (" + paramRegistration
/*  68 */           .getSerializer().getClass().getName() + ")");
/*     */     } 
/*  70 */     this.classToRegistration.put(paramRegistration.getType(), paramRegistration);
/*     */     Class clazz;
/*  72 */     if ((clazz = Util.getWrapperClass(paramRegistration.getType())) != paramRegistration.getType()) this.classToRegistration.put(clazz, paramRegistration); 
/*  73 */     return paramRegistration;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Registration unregister(int paramInt) {
/*  79 */     this.classToRegistration.remove(registration.getType());
/*  80 */     this.memoizedClassId = -1;
/*  81 */     this.memoizedClass = null; Registration registration;
/*     */     Class clazz;
/*  83 */     if ((registration = this.idToRegistration.remove(paramInt)) != null && (clazz = Util.getWrapperClass(registration.getType())) != registration.getType()) this.classToRegistration.remove(clazz);
/*     */     
/*  85 */     return registration;
/*     */   }
/*     */   
/*     */   public Registration registerImplicit(Class paramClass) {
/*  89 */     return register(new Registration(paramClass, this.kryo.getDefaultSerializer(paramClass), -1));
/*     */   }
/*     */   
/*     */   public Registration getRegistration(Class<?> paramClass) {
/*  93 */     if (paramClass == this.memoizedClass) return this.memoizedClassValue; 
/*     */     Registration registration;
/*  95 */     if ((registration = this.classToRegistration.<Class>get(paramClass)) != null) {
/*  96 */       this.memoizedClass = paramClass;
/*  97 */       this.memoizedClassValue = registration;
/*     */     } 
/*  99 */     return registration;
/*     */   }
/*     */   
/*     */   public Registration getRegistration(int paramInt) {
/* 103 */     return this.idToRegistration.get(paramInt);
/*     */   }
/*     */   
/*     */   public Registration writeClass(Output paramOutput, Class paramClass) {
/* 107 */     if (paramClass == null) {
/* 108 */       if (Log.TRACE || (Log.DEBUG && this.kryo.getDepth() == 1)) Util.log("Write", null, paramOutput.position()); 
/* 109 */       paramOutput.writeByte((byte)0);
/* 110 */       return null;
/*     */     } 
/*     */     Registration registration;
/* 113 */     if ((registration = this.kryo.getRegistration(paramClass)).getId() == -1) {
/* 114 */       writeName(paramOutput, paramClass, registration);
/*     */     } else {
/* 116 */       if (Log.TRACE) Log.trace("kryo", "Write class " + registration.getId() + ": " + Util.className(paramClass) + Util.pos(paramOutput.position())); 
/* 117 */       paramOutput.writeVarInt(registration.getId() + 2, true);
/*     */     } 
/* 119 */     return registration;
/*     */   }
/*     */   
/*     */   protected void writeName(Output paramOutput, Class paramClass, Registration paramRegistration) {
/* 123 */     paramOutput.writeByte(1); int i;
/* 124 */     if (this.classToNameId != null && (
/*     */       
/* 126 */       i = this.classToNameId.get(paramClass, -1)) != -1) {
/* 127 */       if (Log.TRACE) Log.trace("kryo", "Write class name reference " + i + ": " + Util.className(paramClass) + Util.pos(paramOutput.position())); 
/* 128 */       paramOutput.writeVarInt(i, true);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 133 */     if (Log.TRACE) Log.trace("kryo", "Write class name: " + Util.className(paramClass) + Util.pos(paramOutput.position())); 
/* 134 */     i = this.nextNameId++;
/* 135 */     if (this.classToNameId == null) this.classToNameId = new IdentityObjectIntMap<>(); 
/* 136 */     this.classToNameId.put(paramClass, i);
/* 137 */     paramOutput.writeVarInt(i, true);
/* 138 */     if (paramRegistration.isTypeNameAscii()) {
/* 139 */       paramOutput.writeAscii(paramClass.getName()); return;
/*     */     } 
/* 141 */     paramOutput.writeString(paramClass.getName());
/*     */   }
/*     */   
/*     */   public Registration readClass(Input paramInput) {
/*     */     int i;
/* 146 */     switch (i = paramInput.readVarInt(true)) {
/*     */       case 0:
/* 148 */         if (Log.TRACE || (Log.DEBUG && this.kryo.getDepth() == 1)) Util.log("Read", null, paramInput.position()); 
/* 149 */         return null;
/*     */       case 1:
/* 151 */         return readName(paramInput);
/*     */     } 
/* 153 */     if (i == this.memoizedClassId) {
/* 154 */       if (Log.TRACE) Log.trace("kryo", "Read class " + (i - 2) + ": " + 
/* 155 */             Util.className(this.memoizedClassIdValue.getType()) + Util.pos(paramInput.position())); 
/* 156 */       return this.memoizedClassIdValue;
/*     */     } 
/*     */     Registration registration;
/* 159 */     if ((registration = this.idToRegistration.get(i - 2)) == null) throw new KryoException("Encountered unregistered class ID: " + (i - 2)); 
/* 160 */     if (Log.TRACE) Log.trace("kryo", "Read class " + (i - 2) + ": " + Util.className(registration.getType()) + Util.pos(paramInput.position())); 
/* 161 */     this.memoizedClassId = i;
/* 162 */     this.memoizedClassIdValue = registration;
/* 163 */     return registration;
/*     */   }
/*     */   
/*     */   protected Registration readName(Input paramInput) {
/* 167 */     int i = paramInput.readVarInt(true);
/* 168 */     if (this.nameIdToClass == null) this.nameIdToClass = new IntMap<>(); 
/*     */     Class<?> clazz;
/* 170 */     if ((clazz = this.nameIdToClass.get(i)) == null)
/*     */     
/* 172 */     { String str = paramInput.readString();
/*     */       
/* 174 */       if ((clazz = getTypeByName(str)) == null) {
/*     */         try {
/* 176 */           clazz = Class.forName(str, false, this.kryo.getClassLoader());
/* 177 */         } catch (ClassNotFoundException classNotFoundException) {
/*     */           
/*     */           try {
/* 180 */             clazz = Class.forName(str, false, Kryo.class.getClassLoader());
/* 181 */           } catch (ClassNotFoundException classNotFoundException1) {
/* 182 */             throw new KryoException("Unable to find class: " + str, classNotFoundException);
/*     */           } 
/*     */         } 
/* 185 */         if (this.nameToClass == null) this.nameToClass = new ObjectMap<>(); 
/* 186 */         this.nameToClass.put(str, clazz);
/*     */       } 
/* 188 */       this.nameIdToClass.put(i, clazz);
/* 189 */       if (Log.TRACE) Log.trace("kryo", "Read class name: " + str + Util.pos(paramInput.position()));
/*     */        }
/* 191 */     else if (Log.TRACE) { Log.trace("kryo", "Read class name reference " + i + ": " + Util.className(clazz) + Util.pos(paramInput.position())); }
/*     */     
/* 193 */     return this.kryo.getRegistration(clazz);
/*     */   }
/*     */   
/*     */   protected Class getTypeByName(String paramString) {
/* 197 */     return (this.nameToClass != null) ? this.nameToClass.<String>get(paramString) : null;
/*     */   }
/*     */   
/*     */   public void reset() {
/* 201 */     if (!this.kryo.isRegistrationRequired()) {
/* 202 */       if (this.classToNameId != null) this.classToNameId.clear(2048); 
/* 203 */       if (this.nameIdToClass != null) this.nameIdToClass.clear(); 
/* 204 */       this.nextNameId = 0;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\DefaultClassResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */