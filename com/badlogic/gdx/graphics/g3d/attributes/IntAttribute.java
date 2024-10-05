/*    */ package com.badlogic.gdx.graphics.g3d.attributes;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.Attribute;
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
/*    */ public class IntAttribute
/*    */   extends Attribute
/*    */ {
/*    */   public static final String CullFaceAlias = "cullface";
/* 23 */   public static final long CullFace = register("cullface");
/*    */ 
/*    */   
/*    */   public int value;
/*    */ 
/*    */   
/*    */   public static IntAttribute createCullFace(int paramInt) {
/* 30 */     return new IntAttribute(CullFace, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IntAttribute(long paramLong) {
/* 36 */     super(paramLong);
/*    */   }
/*    */   
/*    */   public IntAttribute(long paramLong, int paramInt) {
/* 40 */     super(paramLong);
/* 41 */     this.value = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public Attribute copy() {
/* 46 */     return new IntAttribute(this.type, this.value);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 51 */     int i = super.hashCode();
/*    */     
/* 53 */     return i = i * 983 + this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(Attribute paramAttribute) {
/* 58 */     if (this.type != paramAttribute.type) return (int)(this.type - paramAttribute.type); 
/* 59 */     return this.value - ((IntAttribute)paramAttribute).value;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\attributes\IntAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */