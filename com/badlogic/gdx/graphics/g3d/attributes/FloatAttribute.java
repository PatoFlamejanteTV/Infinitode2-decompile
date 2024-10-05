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
/*    */ public class FloatAttribute
/*    */   extends Attribute
/*    */ {
/*    */   public static final String ShininessAlias = "shininess";
/* 25 */   public static final long Shininess = register("shininess");
/*    */   
/*    */   public static FloatAttribute createShininess(float paramFloat) {
/* 28 */     return new FloatAttribute(Shininess, paramFloat);
/*    */   }
/*    */   
/*    */   public static final String AlphaTestAlias = "alphaTest";
/* 32 */   public static final long AlphaTest = register("alphaTest");
/*    */   
/*    */   public static FloatAttribute createAlphaTest(float paramFloat) {
/* 35 */     return new FloatAttribute(AlphaTest, paramFloat);
/*    */   }
/*    */   
/*    */   public float value;
/*    */   
/*    */   public FloatAttribute(long paramLong) {
/* 41 */     super(paramLong);
/*    */   }
/*    */   
/*    */   public FloatAttribute(long paramLong, float paramFloat) {
/* 45 */     super(paramLong);
/* 46 */     this.value = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public Attribute copy() {
/* 51 */     return new FloatAttribute(this.type, this.value);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 56 */     int i = super.hashCode();
/*    */     
/* 58 */     return i = i * 977 + NumberUtils.floatToRawIntBits(this.value);
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(Attribute paramAttribute) {
/* 63 */     if (this.type != paramAttribute.type) return (int)(this.type - paramAttribute.type); 
/* 64 */     float f = ((FloatAttribute)paramAttribute).value;
/* 65 */     return MathUtils.isEqual(this.value, f) ? 0 : ((this.value < f) ? -1 : 1);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\attributes\FloatAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */