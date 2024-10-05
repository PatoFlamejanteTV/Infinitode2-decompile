/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class MultiReasonBool
/*     */   implements KryoSerializable
/*     */ {
/*  21 */   private Entry[] a = new Entry[0];
/*     */   
/*     */   private byte b;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  26 */     paramKryo.writeObject(paramOutput, this.a);
/*  27 */     paramOutput.writeByte(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  32 */     this.a = (Entry[])paramKryo.readObject(paramInput, Entry[].class);
/*  33 */     this.b = paramInput.readByte();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean addReason(String paramString) {
/*  41 */     return addReasonForDuration(paramString, 2.1474836E9F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean addReasonForDuration(String paramString, float paramFloat) {
/*  48 */     Preconditions.checkNotNull(paramString, "reason can not be null"); int i;
/*  49 */     for (i = 0; i < this.b; i++) {
/*  50 */       if (Entry.a(this.a[i]).equals(paramString)) {
/*  51 */         if (Entry.b(this.a[i]) < paramFloat) {
/*  52 */           Entry.a(this.a[i], paramFloat);
/*  53 */           return true;
/*     */         } 
/*  55 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/*  59 */     if (this.b >= this.a.length) {
/*     */       
/*  61 */       if ((i = MathUtils.ceil(this.b * 0.2F)) == 0) i = 1;
/*     */       
/*  63 */       Entry[] arrayOfEntry = this.a;
/*  64 */       this.a = new Entry[this.a.length + i];
/*  65 */       System.arraycopy(arrayOfEntry, 0, this.a, 0, this.b);
/*     */     } 
/*  67 */     this.b = (byte)(this.b + 1); this.a[this.b] = new Entry(paramString, paramFloat);
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean hasReason(String paramString) {
/*  72 */     if (this.b == 0) return false;
/*     */     
/*  74 */     Preconditions.checkNotNull(paramString);
/*  75 */     for (byte b = 0; b < this.b; b++) {
/*  76 */       if (Entry.a(this.a[b]).equals(paramString)) {
/*  77 */         return (Entry.b(this.a[b]) > 0.0F);
/*     */       }
/*     */     } 
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean removeReason(String paramString) {
/*  87 */     if (this.b == 0) return false;
/*     */     
/*  89 */     Preconditions.checkNotNull(paramString);
/*  90 */     for (byte b = 0; b < this.b; b++) {
/*  91 */       if (Entry.a(this.a[b]).equals(paramString)) {
/*  92 */         this.b = (byte)(this.b - 1);
/*  93 */         this.a[b] = this.a[this.b];
/*  94 */         this.a[this.b] = null;
/*  95 */         return true;
/*     */       } 
/*     */     } 
/*  98 */     return false;
/*     */   }
/*     */   
/*     */   public final int getReasonCount() {
/* 102 */     return this.b;
/*     */   }
/*     */   
/*     */   public final boolean isTrue() {
/* 106 */     return (this.b != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 113 */     IntArray intArray = null; byte b;
/* 114 */     for (b = 0; b < this.b; b++) {
/*     */       Entry entry;
/* 116 */       Entry.b(entry = this.a[b], paramFloat);
/* 117 */       if (Entry.b(entry) <= 0.0F) {
/* 118 */         if (intArray == null) {
/* 119 */           intArray = new IntArray();
/*     */         }
/* 121 */         intArray.add(b);
/*     */       } 
/*     */     } 
/* 124 */     if (intArray != null) {
/* 125 */       intArray.reverse();
/* 126 */       for (b = 0; b < intArray.size; b++) {
/* 127 */         int i = intArray.items[b];
/* 128 */         this.b = (byte)(this.b - 1);
/* 129 */         this.a[i] = this.a[this.b];
/* 130 */         this.a[this.b] = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void clear() {
/* 136 */     Arrays.fill((Object[])this.a, (Object)null);
/* 137 */     this.b = 0;
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
/*     */   public final Entry[] getReasonsBuffer() {
/* 152 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @REGS(arrayLevels = 1)
/*     */   public static final class Entry
/*     */     implements KryoSerializable
/*     */   {
/*     */     private String a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private float b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 183 */       param1Output.writeString(this.a);
/* 184 */       param1Output.writeFloat(this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 189 */       this.a = param1Input.readString();
/* 190 */       this.b = param1Input.readFloat();
/*     */     }
/*     */ 
/*     */     
/*     */     public Entry() {}
/*     */     
/*     */     public Entry(String param1String, float param1Float) {
/* 197 */       this.a = param1String;
/* 198 */       this.b = param1Float;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\MultiReasonBool.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */