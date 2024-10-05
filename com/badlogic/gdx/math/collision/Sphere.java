/*    */ package com.badlogic.gdx.math.collision;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector3;
/*    */ import com.badlogic.gdx.utils.NumberUtils;
/*    */ import java.io.Serializable;
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
/*    */ public class Sphere
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -6487336868908521596L;
/*    */   public float radius;
/*    */   public final Vector3 center;
/*    */   private static final float PI_4_3 = 4.1887903F;
/*    */   
/*    */   public Sphere(Vector3 paramVector3, float paramFloat) {
/* 41 */     this.center = new Vector3(paramVector3);
/* 42 */     this.radius = paramFloat;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean overlaps(Sphere paramSphere) {
/* 48 */     return (this.center.dst2(paramSphere.center) < (this.radius + paramSphere.radius) * (this.radius + paramSphere.radius));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 55 */     int i = 71 + this.center.hashCode();
/*    */     
/* 57 */     return i = i * 71 + NumberUtils.floatToRawIntBits(this.radius);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 62 */     if (this == paramObject) return true; 
/* 63 */     if (paramObject == null || paramObject.getClass() != getClass()) return false; 
/* 64 */     paramObject = paramObject;
/* 65 */     return (this.radius == ((Sphere)paramObject).radius && this.center.equals(((Sphere)paramObject).center));
/*    */   }
/*    */   
/*    */   public float volume() {
/* 69 */     return 4.1887903F * this.radius * this.radius * this.radius;
/*    */   }
/*    */   
/*    */   public float surfaceArea() {
/* 73 */     return 12.566371F * this.radius * this.radius;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\collision\Sphere.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */