/*     */ package com.badlogic.gdx.graphics.g3d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.model.Animation;
/*     */ import com.badlogic.gdx.graphics.g3d.model.Node;
/*     */ import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
/*     */ import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
/*     */ import com.badlogic.gdx.graphics.g3d.model.NodePart;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.math.collision.BoundingBox;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ArrayMap;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelInstance
/*     */   implements RenderableProvider
/*     */ {
/*     */   public static boolean defaultShareKeyframes = true;
/*  47 */   public final Array<Material> materials = new Array();
/*     */   
/*  49 */   public final Array<Node> nodes = new Array();
/*     */   
/*  51 */   public final Array<Animation> animations = new Array();
/*     */ 
/*     */   
/*     */   public final Model model;
/*     */   
/*     */   public Matrix4 transform;
/*     */   
/*     */   public Object userData;
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel) {
/*  62 */     this(paramModel, (String[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, String paramString, boolean paramBoolean) {
/*  69 */     this(paramModel, null, paramString, false, false, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, Matrix4 paramMatrix4, String paramString, boolean paramBoolean) {
/*  77 */     this(paramModel, paramMatrix4, paramString, false, false, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/*  86 */     this(paramModel, null, paramString, true, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, Matrix4 paramMatrix4, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/*  97 */     this(paramModel, paramMatrix4, paramString, true, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 107 */     this(paramModel, null, paramString, paramBoolean1, paramBoolean2, paramBoolean3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, Matrix4 paramMatrix4, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 118 */     this(paramModel, paramMatrix4, paramString, paramBoolean1, paramBoolean2, paramBoolean3, defaultShareKeyframes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, Matrix4 paramMatrix4, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/* 129 */     this.model = paramModel;
/* 130 */     this.transform = (paramMatrix4 == null) ? new Matrix4() : paramMatrix4;
/* 131 */     Node node2 = paramModel.getNode(paramString, paramBoolean1); Node node1;
/* 132 */     this.nodes.add(node1 = node2.copy());
/* 133 */     if (paramBoolean3)
/* 134 */     { this.transform.mul(paramBoolean2 ? node2.globalTransform : node2.localTransform);
/* 135 */       node1.translation.set(0.0F, 0.0F, 0.0F);
/* 136 */       node1.rotation.idt();
/* 137 */       node1.scale.set(1.0F, 1.0F, 1.0F); }
/* 138 */     else if (paramBoolean2 && node1.hasParent()) { this.transform.mul((node2.getParent()).globalTransform); }
/* 139 */      invalidate();
/* 140 */     copyAnimations((Iterable<Animation>)paramModel.animations, paramBoolean4);
/* 141 */     calculateTransforms();
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, String... paramVarArgs) {
/* 146 */     this(paramModel, (Matrix4)null, paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, Matrix4 paramMatrix4, String... paramVarArgs) {
/* 151 */     this.model = paramModel;
/* 152 */     this.transform = (paramMatrix4 == null) ? new Matrix4() : paramMatrix4;
/* 153 */     if (paramVarArgs == null) {
/* 154 */       copyNodes(paramModel.nodes);
/*     */     } else {
/* 156 */       copyNodes(paramModel.nodes, paramVarArgs);
/* 157 */     }  copyAnimations((Iterable<Animation>)paramModel.animations, defaultShareKeyframes);
/* 158 */     calculateTransforms();
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, Array<String> paramArray) {
/* 163 */     this(paramModel, (Matrix4)null, paramArray);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, Matrix4 paramMatrix4, Array<String> paramArray) {
/* 168 */     this(paramModel, paramMatrix4, paramArray, defaultShareKeyframes);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, Matrix4 paramMatrix4, Array<String> paramArray, boolean paramBoolean) {
/* 173 */     this.model = paramModel;
/* 174 */     this.transform = (paramMatrix4 == null) ? new Matrix4() : paramMatrix4;
/* 175 */     copyNodes(paramModel.nodes, paramArray);
/* 176 */     copyAnimations((Iterable<Animation>)paramModel.animations, paramBoolean);
/* 177 */     calculateTransforms();
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, Vector3 paramVector3) {
/* 182 */     this(paramModel);
/* 183 */     this.transform.setToTranslation(paramVector3);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 188 */     this(paramModel);
/* 189 */     this.transform.setToTranslation(paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance(Model paramModel, Matrix4 paramMatrix4) {
/* 194 */     this(paramModel, paramMatrix4, (String[])null);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance(ModelInstance paramModelInstance) {
/* 199 */     this(paramModelInstance, paramModelInstance.transform.cpy());
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance(ModelInstance paramModelInstance, Matrix4 paramMatrix4) {
/* 204 */     this(paramModelInstance, paramMatrix4, defaultShareKeyframes);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance(ModelInstance paramModelInstance, Matrix4 paramMatrix4, boolean paramBoolean) {
/* 209 */     this.model = paramModelInstance.model;
/* 210 */     this.transform = (paramMatrix4 == null) ? new Matrix4() : paramMatrix4;
/* 211 */     copyNodes(paramModelInstance.nodes);
/* 212 */     copyAnimations((Iterable<Animation>)paramModelInstance.animations, paramBoolean);
/* 213 */     calculateTransforms();
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelInstance copy() {
/* 218 */     return new ModelInstance(this);
/*     */   } private void copyNodes(Array<Node> paramArray) {
/*     */     byte b;
/*     */     int i;
/* 222 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 223 */       Node node = (Node)paramArray.get(b);
/* 224 */       this.nodes.add(node.copy());
/*     */     } 
/* 226 */     invalidate();
/*     */   } private void copyNodes(Array<Node> paramArray, String... paramVarArgs) {
/*     */     byte b;
/*     */     int i;
/* 230 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 231 */       Node node = (Node)paramArray.get(b); String[] arrayOfString; int j; byte b1;
/* 232 */       for (j = (arrayOfString = paramVarArgs).length, b1 = 0; b1 < j; b1++) {
/* 233 */         String str; if ((str = arrayOfString[b1]).equals(node.id)) {
/* 234 */           this.nodes.add(node.copy());
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 239 */     invalidate();
/*     */   } private void copyNodes(Array<Node> paramArray, Array<String> paramArray1) {
/*     */     byte b;
/*     */     int i;
/* 243 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 244 */       Node node = (Node)paramArray.get(b);
/* 245 */       for (Array.ArrayIterator<String> arrayIterator = paramArray1.iterator(); arrayIterator.hasNext();) {
/* 246 */         if ((str = arrayIterator.next()).equals(node.id)) {
/* 247 */           this.nodes.add(node.copy());
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 252 */     invalidate();
/*     */   }
/*     */   
/*     */   private void invalidate(Node paramNode) {
/*     */     byte b;
/*     */     int i;
/* 258 */     for (b = 0, i = paramNode.parts.size; b < i; b++) {
/*     */       NodePart nodePart;
/*     */       ArrayMap arrayMap;
/* 261 */       if ((arrayMap = (nodePart = (NodePart)paramNode.parts.get(b)).invBoneBindTransforms) != null) {
/* 262 */         for (byte b1 = 0; b1 < arrayMap.size; b1++) {
/* 263 */           ((Node[])arrayMap.keys)[b1] = getNode((((Node[])arrayMap.keys)[b1]).id);
/*     */         }
/*     */       }
/* 266 */       if (!this.materials.contains(nodePart.material, true)) {
/*     */         int j;
/* 268 */         if ((j = this.materials.indexOf(nodePart.material, false)) < 0) {
/* 269 */           this.materials.add(nodePart.material = nodePart.material.copy());
/*     */         } else {
/* 271 */           nodePart.material = (Material)this.materials.get(j);
/*     */         } 
/*     */       } 
/* 274 */     }  for (b = 0, i = paramNode.getChildCount(); b < i; b++) {
/* 275 */       invalidate(paramNode.getChild(b));
/*     */     }
/*     */   }
/*     */   
/*     */   private void invalidate() {
/*     */     byte b;
/*     */     int i;
/* 282 */     for (b = 0, i = this.nodes.size; b < i; b++) {
/* 283 */       invalidate((Node)this.nodes.get(b));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyAnimations(Iterable<Animation> paramIterable) {
/* 290 */     for (Animation animation : paramIterable) {
/* 291 */       copyAnimation(animation, defaultShareKeyframes);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyAnimations(Iterable<Animation> paramIterable, boolean paramBoolean) {
/* 299 */     for (Animation animation : paramIterable) {
/* 300 */       copyAnimation(animation, paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyAnimation(Animation paramAnimation) {
/* 307 */     copyAnimation(paramAnimation, defaultShareKeyframes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyAnimation(Animation paramAnimation, boolean paramBoolean) {
/*     */     Animation animation;
/* 315 */     (animation = new Animation()).id = paramAnimation.id;
/* 316 */     animation.duration = paramAnimation.duration;
/* 317 */     for (Array.ArrayIterator<NodeAnimation> arrayIterator = paramAnimation.nodeAnimations.iterator(); arrayIterator.hasNext(); ) { NodeAnimation nodeAnimation = arrayIterator.next();
/*     */       Node node;
/* 319 */       if ((node = getNode(nodeAnimation.node.id)) != null) {
/*     */         NodeAnimation nodeAnimation1;
/* 321 */         (nodeAnimation1 = new NodeAnimation()).node = node;
/* 322 */         if (paramBoolean) {
/* 323 */           nodeAnimation1.translation = nodeAnimation.translation;
/* 324 */           nodeAnimation1.rotation = nodeAnimation.rotation;
/* 325 */           nodeAnimation1.scaling = nodeAnimation.scaling;
/*     */         } else {
/* 327 */           if (nodeAnimation.translation != null) {
/* 328 */             nodeAnimation1.translation = new Array();
/* 329 */             for (Array.ArrayIterator<NodeKeyframe> arrayIterator1 = nodeAnimation.translation.iterator(); arrayIterator1.hasNext(); ) { NodeKeyframe nodeKeyframe = arrayIterator1.next();
/* 330 */               nodeAnimation1.translation.add(new NodeKeyframe(nodeKeyframe.keytime, nodeKeyframe.value)); }
/*     */           
/* 332 */           }  if (nodeAnimation.rotation != null) {
/* 333 */             nodeAnimation1.rotation = new Array();
/* 334 */             for (Array.ArrayIterator<NodeKeyframe> arrayIterator1 = nodeAnimation.rotation.iterator(); arrayIterator1.hasNext(); ) { NodeKeyframe nodeKeyframe = arrayIterator1.next();
/* 335 */               nodeAnimation1.rotation.add(new NodeKeyframe(nodeKeyframe.keytime, nodeKeyframe.value)); }
/*     */           
/* 337 */           }  if (nodeAnimation.scaling != null) {
/* 338 */             nodeAnimation1.scaling = new Array();
/* 339 */             for (Array.ArrayIterator<NodeKeyframe> arrayIterator1 = nodeAnimation.scaling.iterator(); arrayIterator1.hasNext(); ) { NodeKeyframe nodeKeyframe = arrayIterator1.next();
/* 340 */               nodeAnimation1.scaling.add(new NodeKeyframe(nodeKeyframe.keytime, nodeKeyframe.value)); }
/*     */           
/*     */           } 
/* 343 */         }  if (nodeAnimation1.translation != null || nodeAnimation1.rotation != null || nodeAnimation1.scaling != null)
/* 344 */           animation.nodeAnimations.add(nodeAnimation1); 
/*     */       }  }
/* 346 */      if (animation.nodeAnimations.size > 0) this.animations.add(animation);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getRenderables(Array<Renderable> paramArray, Pool<Renderable> paramPool) {
/* 355 */     for (Array.ArrayIterator<Node> arrayIterator = this.nodes.iterator(); arrayIterator.hasNext(); ) { Node node = arrayIterator.next();
/* 356 */       getRenderables(node, paramArray, paramPool); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public Renderable getRenderable(Renderable paramRenderable) {
/* 362 */     return getRenderable(paramRenderable, (Node)this.nodes.get(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public Renderable getRenderable(Renderable paramRenderable, Node paramNode) {
/* 367 */     return getRenderable(paramRenderable, paramNode, (NodePart)paramNode.parts.get(0));
/*     */   }
/*     */   
/*     */   public Renderable getRenderable(Renderable paramRenderable, Node paramNode, NodePart paramNodePart) {
/* 371 */     paramNodePart.setRenderable(paramRenderable);
/* 372 */     if (paramNodePart.bones == null && this.transform != null) {
/* 373 */       paramRenderable.worldTransform.set(this.transform).mul(paramNode.globalTransform);
/* 374 */     } else if (this.transform != null) {
/* 375 */       paramRenderable.worldTransform.set(this.transform);
/*     */     } else {
/* 377 */       paramRenderable.worldTransform.idt();
/* 378 */     }  paramRenderable.userData = this.userData;
/* 379 */     return paramRenderable;
/*     */   }
/*     */   
/*     */   protected void getRenderables(Node paramNode, Array<Renderable> paramArray, Pool<Renderable> paramPool) {
/* 383 */     if (paramNode.parts.size > 0) {
/* 384 */       for (Array.ArrayIterator<NodePart> arrayIterator = paramNode.parts.iterator(); arrayIterator.hasNext();) {
/* 385 */         if ((nodePart = arrayIterator.next()).enabled) paramArray.add(getRenderable((Renderable)paramPool.obtain(), paramNode, nodePart));
/*     */       
/*     */       } 
/*     */     }
/* 389 */     for (Node node : paramNode.getChildren()) {
/* 390 */       getRenderables(node, paramArray, paramPool);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void calculateTransforms() {
/* 403 */     int i = this.nodes.size; byte b;
/* 404 */     for (b = 0; b < i; b++) {
/* 405 */       ((Node)this.nodes.get(b)).calculateTransforms(true);
/*     */     }
/* 407 */     for (b = 0; b < i; b++) {
/* 408 */       ((Node)this.nodes.get(b)).calculateBoneTransforms(true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox calculateBoundingBox(BoundingBox paramBoundingBox) {
/* 416 */     paramBoundingBox.inf();
/* 417 */     return extendBoundingBox(paramBoundingBox);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox extendBoundingBox(BoundingBox paramBoundingBox) {
/* 425 */     int i = this.nodes.size;
/* 426 */     for (byte b = 0; b < i; b++)
/* 427 */       ((Node)this.nodes.get(b)).extendBoundingBox(paramBoundingBox); 
/* 428 */     return paramBoundingBox;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation getAnimation(String paramString) {
/* 434 */     return getAnimation(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation getAnimation(String paramString, boolean paramBoolean) {
/* 441 */     int i = this.animations.size;
/*     */     
/* 443 */     if (paramBoolean)
/* 444 */     { for (byte b = 0; b < i; b++) {
/* 445 */         Animation animation; if ((animation = (Animation)this.animations.get(b)).id.equalsIgnoreCase(paramString)) return animation; 
/*     */       }  }
/* 447 */     else { for (byte b = 0; b < i; b++) {
/* 448 */         Animation animation; if ((animation = (Animation)this.animations.get(b)).id.equals(paramString)) return animation; 
/*     */       }  }
/* 450 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Material getMaterial(String paramString) {
/* 456 */     return getMaterial(paramString, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Material getMaterial(String paramString, boolean paramBoolean) {
/* 463 */     int i = this.materials.size;
/*     */     
/* 465 */     if (paramBoolean)
/* 466 */     { for (byte b = 0; b < i; b++) {
/* 467 */         Material material; if ((material = (Material)this.materials.get(b)).id.equalsIgnoreCase(paramString)) return material; 
/*     */       }  }
/* 469 */     else { for (byte b = 0; b < i; b++) {
/* 470 */         Material material; if ((material = (Material)this.materials.get(b)).id.equals(paramString)) return material; 
/*     */       }  }
/* 472 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getNode(String paramString) {
/* 478 */     return getNode(paramString, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getNode(String paramString, boolean paramBoolean) {
/* 485 */     return getNode(paramString, paramBoolean, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getNode(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 493 */     return Node.getNode(this.nodes, paramString, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\ModelInstance.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */