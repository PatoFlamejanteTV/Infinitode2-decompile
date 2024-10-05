/*    */ package com.badlogic.gdx.graphics.g3d.attributes;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*    */ import com.badlogic.gdx.graphics.g3d.environment.PointLight;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PointLightsAttribute
/*    */   extends Attribute
/*    */ {
/*    */   public static final String Alias = "pointLights";
/* 15 */   public static final long Type = register("pointLights");
/*    */   
/*    */   public static final boolean is(long paramLong) {
/* 18 */     return ((paramLong & Type) == paramLong);
/*    */   }
/*    */   
/*    */   public final Array<PointLight> lights;
/*    */   
/*    */   public PointLightsAttribute() {
/* 24 */     super(Type);
/* 25 */     this.lights = new Array(1);
/*    */   }
/*    */   
/*    */   public PointLightsAttribute(PointLightsAttribute paramPointLightsAttribute) {
/* 29 */     this();
/* 30 */     this.lights.addAll(paramPointLightsAttribute.lights);
/*    */   }
/*    */ 
/*    */   
/*    */   public PointLightsAttribute copy() {
/* 35 */     return new PointLightsAttribute(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 40 */     int i = super.hashCode();
/* 41 */     for (Array.ArrayIterator<PointLight> arrayIterator = this.lights.iterator(); arrayIterator.hasNext(); ) { PointLight pointLight = arrayIterator.next();
/* 42 */       i = i * 1231 + ((pointLight == null) ? 0 : pointLight.hashCode()); }
/* 43 */      return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(Attribute paramAttribute) {
/* 48 */     if (this.type != paramAttribute.type) return (this.type < paramAttribute.type) ? -1 : 1; 
/* 49 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\attributes\PointLightsAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */