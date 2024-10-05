/*     */ package com.badlogic.gdx.graphics.g3d;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
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
/*     */ public class Attributes
/*     */   implements Comparable<Attributes>, Iterable<Attribute>, Comparator<Attribute>
/*     */ {
/*     */   protected long mask;
/*  26 */   protected final Array<Attribute> attributes = new Array();
/*     */   
/*     */   protected boolean sorted = true;
/*     */ 
/*     */   
/*     */   public final void sort() {
/*  32 */     if (!this.sorted) {
/*  33 */       this.attributes.sort(this);
/*  34 */       this.sorted = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final long getMask() {
/*  40 */     return this.mask;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Attribute get(long paramLong) {
/*  46 */     if (has(paramLong)) for (byte b = 0; b < this.attributes.size; b++) {
/*  47 */         if (((Attribute)this.attributes.get(b)).type == paramLong) return (Attribute)this.attributes.get(b); 
/*  48 */       }   return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T extends Attribute> T get(Class<T> paramClass, long paramLong) {
/*  54 */     return (T)get(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Array<Attribute> get(Array<Attribute> paramArray, long paramLong) {
/*  60 */     for (byte b = 0; b < this.attributes.size; b++) {
/*  61 */       if ((((Attribute)this.attributes.get(b)).type & paramLong) != 0L) paramArray.add(this.attributes.get(b)); 
/*  62 */     }  return paramArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  67 */     this.mask = 0L;
/*  68 */     this.attributes.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  73 */     return this.attributes.size;
/*     */   }
/*     */   
/*     */   private final void enable(long paramLong) {
/*  77 */     this.mask |= paramLong;
/*     */   }
/*     */   
/*     */   private final void disable(long paramLong) {
/*  81 */     this.mask &= paramLong ^ 0xFFFFFFFFFFFFFFFFL;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void set(Attribute paramAttribute) {
/*     */     int i;
/*  87 */     if ((i = indexOf(paramAttribute.type)) < 0) {
/*  88 */       enable(paramAttribute.type);
/*  89 */       this.attributes.add(paramAttribute);
/*  90 */       this.sorted = false;
/*     */     } else {
/*  92 */       this.attributes.set(i, paramAttribute);
/*     */     } 
/*  94 */     sort();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void set(Attribute paramAttribute1, Attribute paramAttribute2) {
/* 100 */     set(paramAttribute1);
/* 101 */     set(paramAttribute2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void set(Attribute paramAttribute1, Attribute paramAttribute2, Attribute paramAttribute3) {
/* 107 */     set(paramAttribute1);
/* 108 */     set(paramAttribute2);
/* 109 */     set(paramAttribute3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void set(Attribute paramAttribute1, Attribute paramAttribute2, Attribute paramAttribute3, Attribute paramAttribute4) {
/* 116 */     set(paramAttribute1);
/* 117 */     set(paramAttribute2);
/* 118 */     set(paramAttribute3);
/* 119 */     set(paramAttribute4);
/*     */   }
/*     */   
/*     */   public final void set(Attribute... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/* 125 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Attribute attribute = paramVarArgs[b];
/* 126 */       set(attribute);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public final void set(Iterable<Attribute> paramIterable) {
/* 132 */     for (Attribute attribute : paramIterable) {
/* 133 */       set(attribute);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void remove(long paramLong) {
/* 139 */     for (int i = this.attributes.size - 1; i >= 0; i--) {
/* 140 */       long l = ((Attribute)this.attributes.get(i)).type;
/* 141 */       if ((paramLong & l) == l) {
/* 142 */         this.attributes.removeIndex(i);
/* 143 */         disable(l);
/* 144 */         this.sorted = false;
/*     */       } 
/*     */     } 
/* 147 */     sort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean has(long paramLong) {
/* 154 */     return (paramLong != 0L && (this.mask & paramLong) == paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int indexOf(long paramLong) {
/* 159 */     if (has(paramLong)) for (byte b = 0; b < this.attributes.size; b++) {
/* 160 */         if (((Attribute)this.attributes.get(b)).type == paramLong) return b; 
/* 161 */       }   return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean same(Attributes paramAttributes, boolean paramBoolean) {
/* 169 */     if (paramAttributes == this) return true; 
/* 170 */     if (paramAttributes == null || this.mask != paramAttributes.mask) return false; 
/* 171 */     if (!paramBoolean) return true; 
/* 172 */     sort();
/* 173 */     paramAttributes.sort();
/* 174 */     for (paramBoolean = false; paramBoolean < this.attributes.size; paramBoolean++) {
/* 175 */       if (!((Attribute)this.attributes.get(paramBoolean)).equals((Attribute)paramAttributes.attributes.get(paramBoolean))) return false; 
/* 176 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean same(Attributes paramAttributes) {
/* 182 */     return same(paramAttributes, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int compare(Attribute paramAttribute1, Attribute paramAttribute2) {
/* 188 */     return (int)(paramAttribute1.type - paramAttribute2.type);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Iterator<Attribute> iterator() {
/* 194 */     return (Iterator<Attribute>)this.attributes.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int attributesHash() {
/* 200 */     sort();
/* 201 */     int i = this.attributes.size;
/* 202 */     long l = 71L + this.mask;
/* 203 */     int j = 1;
/* 204 */     for (byte b = 0; b < i; b++)
/* 205 */       l += this.mask * ((Attribute)this.attributes.get(b)).hashCode() * (j = j * 7 & 0xFFFF); 
/* 206 */     return (int)(l ^ l >> 32L);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 211 */     return attributesHash();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 216 */     if (!(paramObject instanceof Attributes)) return false; 
/* 217 */     if (paramObject == this) return true; 
/* 218 */     return same((Attributes)paramObject, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(Attributes paramAttributes) {
/* 223 */     if (paramAttributes == this) return 0; 
/* 224 */     if (this.mask != paramAttributes.mask) return (this.mask < paramAttributes.mask) ? -1 : 1; 
/* 225 */     sort();
/* 226 */     paramAttributes.sort();
/* 227 */     for (byte b = 0; b < this.attributes.size; b++) {
/*     */       int i;
/* 229 */       if ((i = ((Attribute)this.attributes.get(b)).compareTo((Attribute)paramAttributes.attributes.get(b))) != 0) return (i < 0) ? -1 : ((i > 0) ? 1 : 0); 
/*     */     } 
/* 231 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\Attributes.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */