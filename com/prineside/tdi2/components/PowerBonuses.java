/*     */ package com.prineside.tdi2.components;
/*     */ 
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(arrayLevels = 1)
/*     */ public final class PowerBonuses
/*     */   implements KryoSerializable
/*     */ {
/*     */   public static final int SOURCE_BASIC_SPECIAL_ABILITY = 0;
/*  19 */   private IntMap<Entry[]> a = new IntMap();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  23 */     paramKryo.writeObject(paramOutput, this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  28 */     this.a = (IntMap<Entry[]>)paramKryo.readObject(paramInput, IntMap.class);
/*     */   }
/*     */   @Null
/*     */   public final Entry[] getEffects(int paramInt) {
/*  32 */     return (Entry[])this.a.get(paramInt);
/*     */   }
/*     */   @Null
/*     */   public final Entry[] getBonuses(int paramInt) {
/*  36 */     return (Entry[])this.a.get(paramInt);
/*     */   }
/*     */   
/*     */   public final boolean hasBonuses(int paramInt) {
/*  40 */     return this.a.containsKey(paramInt);
/*     */   }
/*     */   
/*     */   public final boolean hasBonusesFromSource(int paramInt1, int paramInt2) {
/*     */     Entry[] arrayOfEntry;
/*  45 */     if ((arrayOfEntry = (Entry[])this.a.get(paramInt1)) != null) {
/*  46 */       int i; byte b; for (i = (arrayOfEntry = arrayOfEntry).length, b = 0; b < i; b++) {
/*  47 */         Entry entry; if ((entry = arrayOfEntry[b]).sourceId == paramInt2) {
/*  48 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*  52 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean removeBonus(int paramInt) {
/*  56 */     return (this.a.remove(paramInt) != null);
/*     */   }
/*     */   
/*     */   public final boolean removeBonusFromSource(int paramInt1, int paramInt2) {
/*     */     Entry[] arrayOfEntry;
/*  61 */     if ((arrayOfEntry = (Entry[])this.a.get(paramInt1)) != null) {
/*  62 */       Entry[] arrayOfEntry1; int i; byte b; for (i = (arrayOfEntry1 = arrayOfEntry).length, b = 0; b < i; b++) {
/*  63 */         Entry entry; if ((entry = arrayOfEntry1[b]).sourceId == paramInt2) {
/*     */           
/*  65 */           if (arrayOfEntry.length == 1) {
/*     */             
/*  67 */             removeBonus(paramInt1);
/*     */           } else {
/*     */             
/*  70 */             Entry[] arrayOfEntry2 = new Entry[arrayOfEntry.length - 1];
/*  71 */             byte b1 = 0;
/*  72 */             for (i = (arrayOfEntry = arrayOfEntry).length, b = 0; b < i; b++) {
/*  73 */               Entry entry1; if ((entry1 = arrayOfEntry[b]) != entry)
/*     */               {
/*     */                 
/*  76 */                 arrayOfEntry2[b1++] = entry1;
/*     */               }
/*     */             } 
/*  79 */             this.a.put(paramInt1, arrayOfEntry2);
/*     */           } 
/*     */           
/*  82 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean addOrReplaceBonus(int paramInt1, int paramInt2, float paramFloat) {
/*     */     Entry[] arrayOfEntry;
/*  91 */     if ((arrayOfEntry = (Entry[])this.a.get(paramInt1)) != null) {
/*     */       Entry[] arrayOfEntry1; int i; byte b;
/*  93 */       for (i = (arrayOfEntry1 = arrayOfEntry).length, b = 0; b < i; b++) {
/*  94 */         Entry entry1; if ((entry1 = arrayOfEntry1[b]).sourceId == paramInt2) {
/*     */           
/*  96 */           if (entry1.delta != paramFloat) {
/*  97 */             entry1.delta = paramFloat;
/*  98 */             return true;
/*     */           } 
/* 100 */           return false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*     */     Entry entry;
/*     */     
/* 107 */     (entry = new Entry()).sourceId = paramInt2;
/* 108 */     entry.delta = paramFloat;
/*     */ 
/*     */     
/* 111 */     if (arrayOfEntry == null) {
/*     */ 
/*     */       
/* 114 */       (arrayOfEntry = new Entry[1])[0] = entry;
/*     */     } else {
/*     */       
/* 117 */       Entry[] arrayOfEntry1 = new Entry[arrayOfEntry.length + 1];
/* 118 */       System.arraycopy(arrayOfEntry, 0, arrayOfEntry1, 0, arrayOfEntry.length);
/* 119 */       arrayOfEntry = arrayOfEntry1;
/*     */     } 
/* 121 */     arrayOfEntry[arrayOfEntry.length - 1] = entry;
/* 122 */     this.a.put(paramInt1, arrayOfEntry);
/*     */     
/* 124 */     return true;
/*     */   }
/*     */   
/*     */   public final float getBonusesSum() {
/* 128 */     float f = 0.0F;
/* 129 */     for (Iterator<IntMap.Entry> iterator = this.a.iterator(); iterator.hasNext();) {
/* 130 */       for (i = (arrayOfEntry = (Entry[])(entry = iterator.next()).value).length, b = 0; b < i; ) { Entry entry1 = arrayOfEntry[b];
/* 131 */         f += entry1.delta;
/*     */         b++; }
/*     */     
/*     */     } 
/* 135 */     return f;
/*     */   }
/*     */   
/*     */   @REGS(arrayLevels = 1)
/*     */   public static final class Entry
/*     */     implements KryoSerializable {
/*     */     public int sourceId;
/*     */     public float delta;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 145 */       param1Output.writeVarInt(this.sourceId, true);
/* 146 */       param1Output.writeFloat(this.delta);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 151 */       this.sourceId = param1Input.readVarInt(true);
/* 152 */       this.delta = param1Input.readFloat();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\components\PowerBonuses.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */