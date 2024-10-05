/*     */ package com.badlogic.gdx.graphics.g3d.attributes;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.NumberUtils;
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
/*     */ public class DepthTestAttribute
/*     */   extends Attribute
/*     */ {
/*     */   public static final String Alias = "depthStencil";
/*     */   public static final long Type;
/*  29 */   protected static long Mask = Type = register("depthStencil");
/*     */   
/*     */   public static final boolean is(long paramLong) {
/*  32 */     return ((paramLong & Mask) != 0L);
/*     */   }
/*     */ 
/*     */   
/*     */   public int depthFunc;
/*     */   
/*     */   public float depthRangeNear;
/*     */   
/*     */   public float depthRangeFar;
/*     */   
/*     */   public boolean depthMask;
/*     */   
/*     */   public DepthTestAttribute() {
/*  45 */     this(515);
/*     */   }
/*     */   
/*     */   public DepthTestAttribute(boolean paramBoolean) {
/*  49 */     this(515, paramBoolean);
/*     */   }
/*     */   
/*     */   public DepthTestAttribute(int paramInt) {
/*  53 */     this(paramInt, true);
/*     */   }
/*     */   
/*     */   public DepthTestAttribute(int paramInt, boolean paramBoolean) {
/*  57 */     this(paramInt, 0.0F, 1.0F, paramBoolean);
/*     */   }
/*     */   
/*     */   public DepthTestAttribute(int paramInt, float paramFloat1, float paramFloat2) {
/*  61 */     this(paramInt, paramFloat1, paramFloat2, true);
/*     */   }
/*     */   
/*     */   public DepthTestAttribute(int paramInt, float paramFloat1, float paramFloat2, boolean paramBoolean) {
/*  65 */     this(Type, paramInt, paramFloat1, paramFloat2, paramBoolean);
/*     */   }
/*     */   
/*     */   public DepthTestAttribute(long paramLong, int paramInt, float paramFloat1, float paramFloat2, boolean paramBoolean) {
/*  69 */     super(paramLong);
/*  70 */     if (!is(paramLong)) throw new GdxRuntimeException("Invalid type specified"); 
/*  71 */     this.depthFunc = paramInt;
/*  72 */     this.depthRangeNear = paramFloat1;
/*  73 */     this.depthRangeFar = paramFloat2;
/*  74 */     this.depthMask = paramBoolean;
/*     */   }
/*     */   
/*     */   public DepthTestAttribute(DepthTestAttribute paramDepthTestAttribute) {
/*  78 */     this(paramDepthTestAttribute.type, paramDepthTestAttribute.depthFunc, paramDepthTestAttribute.depthRangeNear, paramDepthTestAttribute.depthRangeFar, paramDepthTestAttribute.depthMask);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute copy() {
/*  83 */     return new DepthTestAttribute(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  88 */     int i = super.hashCode();
/*  89 */     i = i * 971 + this.depthFunc;
/*  90 */     i = i * 971 + NumberUtils.floatToRawIntBits(this.depthRangeNear);
/*  91 */     i = i * 971 + NumberUtils.floatToRawIntBits(this.depthRangeFar);
/*     */     
/*  93 */     return i = i * 971 + (this.depthMask ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(Attribute paramAttribute) {
/*  98 */     if (this.type != paramAttribute.type) return (int)(this.type - paramAttribute.type); 
/*  99 */     paramAttribute = paramAttribute;
/* 100 */     if (this.depthFunc != ((DepthTestAttribute)paramAttribute).depthFunc) return this.depthFunc - ((DepthTestAttribute)paramAttribute).depthFunc; 
/* 101 */     if (this.depthMask != ((DepthTestAttribute)paramAttribute).depthMask) return this.depthMask ? -1 : 1; 
/* 102 */     if (!MathUtils.isEqual(this.depthRangeNear, ((DepthTestAttribute)paramAttribute).depthRangeNear)) return (this.depthRangeNear < ((DepthTestAttribute)paramAttribute).depthRangeNear) ? -1 : 1; 
/* 103 */     if (!MathUtils.isEqual(this.depthRangeFar, ((DepthTestAttribute)paramAttribute).depthRangeFar)) return (this.depthRangeFar < ((DepthTestAttribute)paramAttribute).depthRangeFar) ? -1 : 1; 
/* 104 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\attributes\DepthTestAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */