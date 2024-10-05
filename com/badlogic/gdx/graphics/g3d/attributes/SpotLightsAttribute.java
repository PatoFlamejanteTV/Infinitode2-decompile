/*    */ package com.badlogic.gdx.graphics.g3d.attributes;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*    */ import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpotLightsAttribute
/*    */   extends Attribute
/*    */ {
/*    */   public static final String Alias = "spotLights";
/* 15 */   public static final long Type = register("spotLights");
/*    */   
/*    */   public static final boolean is(long paramLong) {
/* 18 */     return ((paramLong & Type) == paramLong);
/*    */   }
/*    */   
/*    */   public final Array<SpotLight> lights;
/*    */   
/*    */   public SpotLightsAttribute() {
/* 24 */     super(Type);
/* 25 */     this.lights = new Array(1);
/*    */   }
/*    */   
/*    */   public SpotLightsAttribute(SpotLightsAttribute paramSpotLightsAttribute) {
/* 29 */     this();
/* 30 */     this.lights.addAll(paramSpotLightsAttribute.lights);
/*    */   }
/*    */ 
/*    */   
/*    */   public SpotLightsAttribute copy() {
/* 35 */     return new SpotLightsAttribute(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 40 */     int i = super.hashCode();
/* 41 */     for (Array.ArrayIterator<SpotLight> arrayIterator = this.lights.iterator(); arrayIterator.hasNext(); ) { SpotLight spotLight = arrayIterator.next();
/* 42 */       i = i * 1237 + ((spotLight == null) ? 0 : spotLight.hashCode()); }
/* 43 */      return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(Attribute paramAttribute) {
/* 48 */     if (this.type != paramAttribute.type) return (this.type < paramAttribute.type) ? -1 : 1; 
/* 49 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\attributes\SpotLightsAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */