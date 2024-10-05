/*    */ package com.badlogic.gdx.graphics.g3d.attributes;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.badlogic.gdx.utils.NumberUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlendingAttribute
/*    */   extends Attribute
/*    */ {
/*    */   public static final String Alias = "blended";
/* 26 */   public static final long Type = register("blended");
/*    */   
/*    */   public static final boolean is(long paramLong) {
/* 29 */     return ((paramLong & Type) == paramLong);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean blended;
/*    */ 
/*    */   
/*    */   public int sourceFunction;
/*    */   
/*    */   public int destFunction;
/*    */   
/* 41 */   public float opacity = 1.0F;
/*    */   
/*    */   public BlendingAttribute() {
/* 44 */     this((BlendingAttribute)null);
/*    */   }
/*    */   
/*    */   public BlendingAttribute(boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat) {
/* 48 */     super(Type);
/* 49 */     this.blended = paramBoolean;
/* 50 */     this.sourceFunction = paramInt1;
/* 51 */     this.destFunction = paramInt2;
/* 52 */     this.opacity = paramFloat;
/*    */   }
/*    */   
/*    */   public BlendingAttribute(int paramInt1, int paramInt2, float paramFloat) {
/* 56 */     this(true, paramInt1, paramInt2, paramFloat);
/*    */   }
/*    */   
/*    */   public BlendingAttribute(int paramInt1, int paramInt2) {
/* 60 */     this(paramInt1, paramInt2, 1.0F);
/*    */   }
/*    */   
/*    */   public BlendingAttribute(boolean paramBoolean, float paramFloat) {
/* 64 */     this(paramBoolean, 770, 771, paramFloat);
/*    */   }
/*    */   
/*    */   public BlendingAttribute(float paramFloat) {
/* 68 */     this(true, paramFloat);
/*    */   }
/*    */   
/*    */   public BlendingAttribute(BlendingAttribute paramBlendingAttribute) {
/* 72 */     this((paramBlendingAttribute == null || paramBlendingAttribute.blended), (paramBlendingAttribute == null) ? 770 : paramBlendingAttribute.sourceFunction, 
/* 73 */         (paramBlendingAttribute == null) ? 771 : paramBlendingAttribute.destFunction, (paramBlendingAttribute == null) ? 1.0F : paramBlendingAttribute.opacity);
/*    */   }
/*    */ 
/*    */   
/*    */   public BlendingAttribute copy() {
/* 78 */     return new BlendingAttribute(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 83 */     int i = super.hashCode();
/* 84 */     i = i * 947 + (this.blended ? 1 : 0);
/* 85 */     i = i * 947 + this.sourceFunction;
/* 86 */     i = i * 947 + this.destFunction;
/*    */     
/* 88 */     return i = i * 947 + NumberUtils.floatToRawIntBits(this.opacity);
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(Attribute paramAttribute) {
/* 93 */     if (this.type != paramAttribute.type) return (int)(this.type - paramAttribute.type); 
/* 94 */     paramAttribute = paramAttribute;
/* 95 */     if (this.blended != ((BlendingAttribute)paramAttribute).blended) return this.blended ? 1 : -1; 
/* 96 */     if (this.sourceFunction != ((BlendingAttribute)paramAttribute).sourceFunction) return this.sourceFunction - ((BlendingAttribute)paramAttribute).sourceFunction; 
/* 97 */     if (this.destFunction != ((BlendingAttribute)paramAttribute).destFunction) return this.destFunction - ((BlendingAttribute)paramAttribute).destFunction; 
/* 98 */     return MathUtils.isEqual(this.opacity, ((BlendingAttribute)paramAttribute).opacity) ? 0 : ((this.opacity < ((BlendingAttribute)paramAttribute).opacity) ? 1 : -1);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\attributes\BlendingAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */