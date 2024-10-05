/*    */ package com.badlogic.gdx.graphics.g3d.model.data;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelMaterial
/*    */ {
/*    */   public String id;
/*    */   public MaterialType type;
/*    */   public Color ambient;
/*    */   public Color diffuse;
/*    */   public Color specular;
/*    */   public Color emissive;
/*    */   public Color reflection;
/*    */   public float shininess;
/*    */   
/*    */   public enum MaterialType
/*    */   {
/* 24 */     Lambert, Phong;
/*    */   }
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
/* 38 */   public float opacity = 1.0F;
/*    */   public Array<ModelTexture> textures;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\model\data\ModelMaterial.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */