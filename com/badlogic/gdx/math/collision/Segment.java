/*    */ package com.badlogic.gdx.math.collision;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector3;
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
/*    */ public class Segment
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 2739667069736519602L;
/* 30 */   public final Vector3 a = new Vector3();
/*    */ 
/*    */   
/* 33 */   public final Vector3 b = new Vector3();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Segment(Vector3 paramVector31, Vector3 paramVector32) {
/* 40 */     this.a.set(paramVector31);
/* 41 */     this.b.set(paramVector32);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Segment(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 52 */     this.a.set(paramFloat1, paramFloat2, paramFloat3);
/* 53 */     this.b.set(paramFloat4, paramFloat5, paramFloat6);
/*    */   }
/*    */   
/*    */   public float len() {
/* 57 */     return this.a.dst(this.b);
/*    */   }
/*    */   
/*    */   public float len2() {
/* 61 */     return this.a.dst2(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 66 */     if (paramObject == this) return true; 
/* 67 */     if (paramObject == null || paramObject.getClass() != getClass()) return false; 
/* 68 */     paramObject = paramObject;
/* 69 */     return (this.a.equals(((Segment)paramObject).a) && this.b.equals(((Segment)paramObject).b));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 76 */     int i = 71 + this.a.hashCode();
/*    */     
/* 78 */     return i = i * 71 + this.b.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\collision\Segment.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */