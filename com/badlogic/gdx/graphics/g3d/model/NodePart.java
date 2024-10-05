/*    */ package com.badlogic.gdx.graphics.g3d.model;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.Material;
/*    */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*    */ import com.badlogic.gdx.math.Matrix4;
/*    */ import com.badlogic.gdx.utils.ArrayMap;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodePart
/*    */ {
/*    */   public MeshPart meshPart;
/*    */   public Material material;
/*    */   public ArrayMap<Node, Matrix4> invBoneBindTransforms;
/*    */   public Matrix4[] bones;
/*    */   public boolean enabled = true;
/*    */   
/*    */   public NodePart() {}
/*    */   
/*    */   public NodePart(MeshPart paramMeshPart, Material paramMaterial) {
/* 52 */     this.meshPart = paramMeshPart;
/* 53 */     this.material = paramMaterial;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Renderable setRenderable(Renderable paramRenderable) {
/* 64 */     paramRenderable.material = this.material;
/* 65 */     paramRenderable.meshPart.set(this.meshPart);
/* 66 */     paramRenderable.bones = this.bones;
/* 67 */     return paramRenderable;
/*    */   }
/*    */   
/*    */   public NodePart copy() {
/* 71 */     return (new NodePart()).set(this);
/*    */   }
/*    */   
/*    */   protected NodePart set(NodePart paramNodePart) {
/* 75 */     this.meshPart = new MeshPart(paramNodePart.meshPart);
/* 76 */     this.material = paramNodePart.material;
/* 77 */     this.enabled = paramNodePart.enabled;
/* 78 */     if (paramNodePart.invBoneBindTransforms == null) {
/* 79 */       this.invBoneBindTransforms = null;
/* 80 */       this.bones = null;
/*    */     } else {
/* 82 */       if (this.invBoneBindTransforms == null) {
/* 83 */         this.invBoneBindTransforms = new ArrayMap(true, paramNodePart.invBoneBindTransforms.size, Node.class, Matrix4.class);
/*    */       } else {
/*    */         
/* 86 */         this.invBoneBindTransforms.clear();
/* 87 */       }  this.invBoneBindTransforms.putAll(paramNodePart.invBoneBindTransforms);
/*    */       
/* 89 */       if (this.bones == null || this.bones.length != this.invBoneBindTransforms.size) this.bones = new Matrix4[this.invBoneBindTransforms.size];
/*    */       
/* 91 */       for (byte b = 0; b < this.bones.length; b++) {
/* 92 */         if (this.bones[b] == null) this.bones[b] = new Matrix4(); 
/*    */       } 
/*    */     } 
/* 95 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\model\NodePart.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */