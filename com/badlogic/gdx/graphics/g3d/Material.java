/*    */ package com.badlogic.gdx.graphics.g3d;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
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
/*    */ public class Material
/*    */   extends Attributes
/*    */ {
/* 22 */   private static int counter = 0;
/*    */   
/*    */   public String id;
/*    */ 
/*    */   
/*    */   public Material() {
/* 28 */     this("mtl" + ++counter);
/*    */   }
/*    */ 
/*    */   
/*    */   public Material(String paramString) {
/* 33 */     this.id = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public Material(Attribute... paramVarArgs) {
/* 38 */     this();
/* 39 */     set(paramVarArgs);
/*    */   }
/*    */ 
/*    */   
/*    */   public Material(String paramString, Attribute... paramVarArgs) {
/* 44 */     this(paramString);
/* 45 */     set(paramVarArgs);
/*    */   }
/*    */ 
/*    */   
/*    */   public Material(Array<Attribute> paramArray) {
/* 50 */     this();
/* 51 */     set((Iterable<Attribute>)paramArray);
/*    */   }
/*    */ 
/*    */   
/*    */   public Material(String paramString, Array<Attribute> paramArray) {
/* 56 */     this(paramString);
/* 57 */     set((Iterable<Attribute>)paramArray);
/*    */   }
/*    */ 
/*    */   
/*    */   public Material(Material paramMaterial) {
/* 62 */     this(paramMaterial.id, paramMaterial);
/*    */   }
/*    */ 
/*    */   
/*    */   public Material(String paramString, Material paramMaterial) {
/* 67 */     this(paramString);
/* 68 */     for (Attribute attribute : paramMaterial) {
/* 69 */       set(attribute.copy());
/*    */     }
/*    */   }
/*    */   
/*    */   public Material copy() {
/* 74 */     return new Material(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 79 */     return super.hashCode() + 3 * this.id.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 84 */     return (paramObject instanceof Material && (paramObject == this || (((Material)paramObject).id.equals(this.id) && super.equals(paramObject))));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\Material.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */