/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Collections;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
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
/*     */ public final class VertexAttributes
/*     */   implements Comparable<VertexAttributes>, Iterable<VertexAttribute>
/*     */ {
/*     */   private final VertexAttribute[] attributes;
/*     */   public final int vertexSize;
/*     */   
/*     */   public static final class Usage
/*     */   {
/*     */     public static final int Position = 1;
/*     */     public static final int ColorUnpacked = 2;
/*     */     public static final int ColorPacked = 4;
/*     */     public static final int Normal = 8;
/*     */     public static final int TextureCoordinates = 16;
/*     */     public static final int Generic = 32;
/*     */     public static final int BoneWeight = 64;
/*     */     public static final int Tangent = 128;
/*     */     public static final int BiNormal = 256;
/*     */   }
/*  52 */   private long mask = -1L;
/*     */ 
/*     */   
/*  55 */   private int boneWeightUnits = -1;
/*     */ 
/*     */   
/*  58 */   private int textureCoordinates = -1;
/*     */   
/*     */   private ReadonlyIterable<VertexAttribute> iterable;
/*     */ 
/*     */   
/*     */   public VertexAttributes(VertexAttribute... paramVarArgs) {
/*  64 */     if (paramVarArgs.length == 0) throw new IllegalArgumentException("attributes must be >= 1");
/*     */     
/*  66 */     VertexAttribute[] arrayOfVertexAttribute = new VertexAttribute[paramVarArgs.length];
/*  67 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*  68 */       arrayOfVertexAttribute[b] = paramVarArgs[b];
/*     */     }
/*  70 */     this.attributes = arrayOfVertexAttribute;
/*  71 */     this.vertexSize = calculateOffsets();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getOffset(int paramInt1, int paramInt2) {
/*     */     VertexAttribute vertexAttribute;
/*  78 */     if ((vertexAttribute = findByUsage(paramInt1)) == null) return paramInt2; 
/*  79 */     return vertexAttribute.offset / 4;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getOffset(int paramInt) {
/*  85 */     return getOffset(paramInt, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final VertexAttribute findByUsage(int paramInt) {
/*  91 */     int i = size();
/*  92 */     for (byte b = 0; b < i; b++) {
/*  93 */       if ((get(b)).usage == paramInt) return get(b); 
/*  94 */     }  return null;
/*     */   }
/*     */   
/*     */   private int calculateOffsets() {
/*  98 */     int i = 0;
/*  99 */     for (byte b = 0; b < this.attributes.length; b++) {
/*     */       VertexAttribute vertexAttribute;
/* 101 */       (vertexAttribute = this.attributes[b]).offset = i;
/* 102 */       i += vertexAttribute.getSizeInBytes();
/*     */     } 
/*     */     
/* 105 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int size() {
/* 110 */     return this.attributes.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final VertexAttribute get(int paramInt) {
/* 116 */     return this.attributes[paramInt];
/*     */   }
/*     */   
/*     */   public final String toString() {
/*     */     StringBuilder stringBuilder;
/* 121 */     (stringBuilder = new StringBuilder()).append("[");
/* 122 */     for (byte b = 0; b < this.attributes.length; b++) {
/* 123 */       stringBuilder.append("(");
/* 124 */       stringBuilder.append((this.attributes[b]).alias);
/* 125 */       stringBuilder.append(", ");
/* 126 */       stringBuilder.append((this.attributes[b]).usage);
/* 127 */       stringBuilder.append(", ");
/* 128 */       stringBuilder.append((this.attributes[b]).numComponents);
/* 129 */       stringBuilder.append(", ");
/* 130 */       stringBuilder.append((this.attributes[b]).offset);
/* 131 */       stringBuilder.append(")");
/* 132 */       stringBuilder.append("\n");
/*     */     } 
/* 134 */     stringBuilder.append("]");
/* 135 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 140 */     if (paramObject == this) return true; 
/* 141 */     if (!(paramObject instanceof VertexAttributes)) return false; 
/* 142 */     paramObject = paramObject;
/* 143 */     if (this.attributes.length != ((VertexAttributes)paramObject).attributes.length) return false; 
/* 144 */     for (byte b = 0; b < this.attributes.length; b++) {
/* 145 */       if (!this.attributes[b].equals(((VertexAttributes)paramObject).attributes[b])) return false; 
/*     */     } 
/* 147 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 152 */     long l = (61 * this.attributes.length);
/* 153 */     for (byte b = 0; b < this.attributes.length; b++)
/* 154 */       l = l * 61L + this.attributes[b].hashCode(); 
/* 155 */     return (int)(l ^ l >> 32L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long getMask() {
/* 162 */     if (this.mask == -1L) {
/* 163 */       long l = 0L;
/* 164 */       for (byte b = 0; b < this.attributes.length; b++) {
/* 165 */         l |= (this.attributes[b]).usage;
/*     */       }
/* 167 */       this.mask = l;
/*     */     } 
/* 169 */     return this.mask;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final long getMaskWithSizePacked() {
/* 175 */     return getMask() | this.attributes.length << 32L;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getBoneWeights() {
/* 180 */     if (this.boneWeightUnits < 0) {
/* 181 */       this.boneWeightUnits = 0;
/* 182 */       for (byte b = 0; b < this.attributes.length; b++) {
/*     */         VertexAttribute vertexAttribute;
/* 184 */         if ((vertexAttribute = this.attributes[b]).usage == 64) {
/* 185 */           this.boneWeightUnits = Math.max(this.boneWeightUnits, vertexAttribute.unit + 1);
/*     */         }
/*     */       } 
/*     */     } 
/* 189 */     return this.boneWeightUnits;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getTextureCoordinates() {
/* 194 */     if (this.textureCoordinates < 0) {
/* 195 */       this.textureCoordinates = 0;
/* 196 */       for (byte b = 0; b < this.attributes.length; b++) {
/*     */         VertexAttribute vertexAttribute;
/* 198 */         if ((vertexAttribute = this.attributes[b]).usage == 16) {
/* 199 */           this.textureCoordinates = Math.max(this.textureCoordinates, vertexAttribute.unit + 1);
/*     */         }
/*     */       } 
/*     */     } 
/* 203 */     return this.textureCoordinates;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int compareTo(VertexAttributes paramVertexAttributes) {
/* 208 */     if (this.attributes.length != paramVertexAttributes.attributes.length) return this.attributes.length - paramVertexAttributes.attributes.length; 
/* 209 */     long l1 = getMask();
/* 210 */     long l2 = paramVertexAttributes.getMask();
/* 211 */     if (l1 != l2) return (l1 < l2) ? -1 : 1; 
/* 212 */     for (int i = this.attributes.length - 1; i >= 0; i--) {
/* 213 */       VertexAttribute vertexAttribute1 = this.attributes[i];
/* 214 */       VertexAttribute vertexAttribute2 = paramVertexAttributes.attributes[i];
/* 215 */       if (vertexAttribute1.usage != vertexAttribute2.usage) return vertexAttribute1.usage - vertexAttribute2.usage; 
/* 216 */       if (vertexAttribute1.unit != vertexAttribute2.unit) return vertexAttribute1.unit - vertexAttribute2.unit; 
/* 217 */       if (vertexAttribute1.numComponents != vertexAttribute2.numComponents) return vertexAttribute1.numComponents - vertexAttribute2.numComponents; 
/* 218 */       if (vertexAttribute1.normalized != vertexAttribute2.normalized) return vertexAttribute1.normalized ? 1 : -1; 
/* 219 */       if (vertexAttribute1.type != vertexAttribute2.type) return vertexAttribute1.type - vertexAttribute2.type; 
/*     */     } 
/* 221 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Iterator<VertexAttribute> iterator() {
/* 227 */     if (this.iterable == null) this.iterable = new ReadonlyIterable<>(this.attributes); 
/* 228 */     return this.iterable.iterator();
/*     */   }
/*     */   
/*     */   private static class ReadonlyIterator<T> implements Iterable<T>, Iterator<T> {
/*     */     private final T[] array;
/*     */     int index;
/*     */     boolean valid = true;
/*     */     
/*     */     public ReadonlyIterator(T[] param1ArrayOfT) {
/* 237 */       this.array = param1ArrayOfT;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 242 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 243 */       return (this.index < this.array.length);
/*     */     }
/*     */ 
/*     */     
/*     */     public T next() {
/* 248 */       if (this.index >= this.array.length) throw new NoSuchElementException(String.valueOf(this.index)); 
/* 249 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 250 */       return this.array[this.index++];
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 255 */       throw new GdxRuntimeException("Remove not allowed.");
/*     */     }
/*     */     
/*     */     public void reset() {
/* 259 */       this.index = 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<T> iterator() {
/* 264 */       return this;
/*     */     } }
/*     */   
/*     */   private static class ReadonlyIterable<T> implements Iterable<T> {
/*     */     private final T[] array;
/*     */     private VertexAttributes.ReadonlyIterator iterator1;
/*     */     private VertexAttributes.ReadonlyIterator iterator2;
/*     */     
/*     */     public ReadonlyIterable(T[] param1ArrayOfT) {
/* 273 */       this.array = param1ArrayOfT;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<T> iterator() {
/* 278 */       if (Collections.allocateIterators) return new VertexAttributes.ReadonlyIterator<>(this.array); 
/* 279 */       if (this.iterator1 == null) {
/* 280 */         this.iterator1 = new VertexAttributes.ReadonlyIterator<>(this.array);
/* 281 */         this.iterator2 = new VertexAttributes.ReadonlyIterator<>(this.array);
/*     */       } 
/* 283 */       if (!this.iterator1.valid) {
/* 284 */         this.iterator1.index = 0;
/* 285 */         this.iterator1.valid = true;
/* 286 */         this.iterator2.valid = false;
/* 287 */         return this.iterator1;
/*     */       } 
/* 289 */       this.iterator2.index = 0;
/* 290 */       this.iterator2.valid = true;
/* 291 */       this.iterator1.valid = false;
/* 292 */       return this.iterator2;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\VertexAttributes.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */