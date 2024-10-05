/*    */ package com.badlogic.gdx.graphics.g3d.model.data;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*    */ public class ModelData
/*    */ {
/*    */   public String id;
/* 28 */   public final short[] version = new short[2];
/* 29 */   public final Array<ModelMesh> meshes = new Array();
/* 30 */   public final Array<ModelMaterial> materials = new Array();
/* 31 */   public final Array<ModelNode> nodes = new Array();
/* 32 */   public final Array<ModelAnimation> animations = new Array();
/*    */   
/*    */   public void addMesh(ModelMesh paramModelMesh) {
/* 35 */     for (Array.ArrayIterator<ModelMesh> arrayIterator = this.meshes.iterator(); arrayIterator.hasNext();) {
/* 36 */       if ((modelMesh = arrayIterator.next()).id.equals(paramModelMesh.id)) {
/* 37 */         throw new GdxRuntimeException("Mesh with id '" + modelMesh.id + "' already in model");
/*    */       }
/*    */     } 
/* 40 */     this.meshes.add(paramModelMesh);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\model\data\ModelData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */