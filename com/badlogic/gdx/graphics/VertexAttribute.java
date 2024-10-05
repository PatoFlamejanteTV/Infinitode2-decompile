/*     */ package com.badlogic.gdx.graphics;
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
/*     */ public final class VertexAttribute
/*     */ {
/*     */   public final int usage;
/*     */   public final int numComponents;
/*     */   public final boolean normalized;
/*     */   public final int type;
/*     */   public int offset;
/*     */   public String alias;
/*     */   public int unit;
/*     */   private final int usageIndex;
/*     */   
/*     */   public VertexAttribute(int paramInt1, int paramInt2, String paramString) {
/*  51 */     this(paramInt1, paramInt2, paramString, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VertexAttribute(int paramInt1, int paramInt2, String paramString, int paramInt3) {
/*  61 */     this(paramInt1, paramInt2, (paramInt1 == 4) ? 5121 : 5126, (paramInt1 == 4), paramString, paramInt3);
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
/*     */   public VertexAttribute(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString) {
/*  75 */     this(paramInt1, paramInt2, paramInt3, paramBoolean, paramString, 0);
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
/*     */   public VertexAttribute(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString, int paramInt4) {
/*  89 */     this.usage = paramInt1;
/*  90 */     this.numComponents = paramInt2;
/*  91 */     this.type = paramInt3;
/*  92 */     this.normalized = paramBoolean;
/*  93 */     this.alias = paramString;
/*  94 */     this.unit = paramInt4;
/*  95 */     this.usageIndex = Integer.numberOfTrailingZeros(paramInt1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final VertexAttribute copy() {
/* 101 */     return new VertexAttribute(this.usage, this.numComponents, this.type, this.normalized, this.alias, this.unit);
/*     */   }
/*     */   
/*     */   public static VertexAttribute Position() {
/* 105 */     return new VertexAttribute(1, 3, "a_position");
/*     */   }
/*     */   
/*     */   public static VertexAttribute TexCoords(int paramInt) {
/* 109 */     return new VertexAttribute(16, 2, "a_texCoord" + paramInt, paramInt);
/*     */   }
/*     */   
/*     */   public static VertexAttribute Normal() {
/* 113 */     return new VertexAttribute(8, 3, "a_normal");
/*     */   }
/*     */   
/*     */   public static VertexAttribute ColorPacked() {
/* 117 */     return new VertexAttribute(4, 4, 5121, true, "a_color");
/*     */   }
/*     */   
/*     */   public static VertexAttribute ColorUnpacked() {
/* 121 */     return new VertexAttribute(2, 4, 5126, false, "a_color");
/*     */   }
/*     */   
/*     */   public static VertexAttribute Tangent() {
/* 125 */     return new VertexAttribute(128, 3, "a_tangent");
/*     */   }
/*     */   
/*     */   public static VertexAttribute Binormal() {
/* 129 */     return new VertexAttribute(256, 3, "a_binormal");
/*     */   }
/*     */   
/*     */   public static VertexAttribute BoneWeight(int paramInt) {
/* 133 */     return new VertexAttribute(64, 2, "a_boneWeight" + paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 139 */     if (!(paramObject instanceof VertexAttribute)) {
/* 140 */       return false;
/*     */     }
/* 142 */     return equals((VertexAttribute)paramObject);
/*     */   }
/*     */   
/*     */   public final boolean equals(VertexAttribute paramVertexAttribute) {
/* 146 */     if (paramVertexAttribute != null && this.usage == paramVertexAttribute.usage && this.numComponents == paramVertexAttribute.numComponents && this.type == paramVertexAttribute.type && this.normalized == paramVertexAttribute.normalized && this.alias
/* 147 */       .equals(paramVertexAttribute.alias) && this.unit == paramVertexAttribute.unit) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public final int getKey() {
/* 152 */     return (this.usageIndex << 8) + (this.unit & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getSizeInBytes() {
/* 157 */     switch (this.type) {
/*     */       case 5126:
/*     */       case 5132:
/* 160 */         return 4 * this.numComponents;
/*     */       case 5120:
/*     */       case 5121:
/* 163 */         return this.numComponents;
/*     */       case 5122:
/*     */       case 5123:
/* 166 */         return 2 * this.numComponents;
/*     */     } 
/* 168 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 173 */     int i = getKey();
/* 174 */     i = i * 541 + this.numComponents;
/*     */     
/* 176 */     return i = i * 541 + this.alias.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\VertexAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */