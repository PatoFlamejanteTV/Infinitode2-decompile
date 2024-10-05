/*    */ package com.badlogic.gdx.graphics.g3d.attributes;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*    */ import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DirectionalLightsAttribute
/*    */   extends Attribute
/*    */ {
/*    */   public static final String Alias = "directionalLights";
/* 15 */   public static final long Type = register("directionalLights");
/*    */   
/*    */   public static final boolean is(long paramLong) {
/* 18 */     return ((paramLong & Type) == paramLong);
/*    */   }
/*    */   
/*    */   public final Array<DirectionalLight> lights;
/*    */   
/*    */   public DirectionalLightsAttribute() {
/* 24 */     super(Type);
/* 25 */     this.lights = new Array(1);
/*    */   }
/*    */   
/*    */   public DirectionalLightsAttribute(DirectionalLightsAttribute paramDirectionalLightsAttribute) {
/* 29 */     this();
/* 30 */     this.lights.addAll(paramDirectionalLightsAttribute.lights);
/*    */   }
/*    */ 
/*    */   
/*    */   public DirectionalLightsAttribute copy() {
/* 35 */     return new DirectionalLightsAttribute(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 40 */     int i = super.hashCode();
/* 41 */     for (Array.ArrayIterator<DirectionalLight> arrayIterator = this.lights.iterator(); arrayIterator.hasNext(); ) { DirectionalLight directionalLight = arrayIterator.next();
/* 42 */       i = i * 1229 + ((directionalLight == null) ? 0 : directionalLight.hashCode()); }
/* 43 */      return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(Attribute paramAttribute) {
/* 48 */     if (this.type != paramAttribute.type) return (this.type < paramAttribute.type) ? -1 : 1; 
/* 49 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\attributes\DirectionalLightsAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */