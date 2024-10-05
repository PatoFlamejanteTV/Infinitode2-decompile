/*     */ package com.badlogic.gdx.graphics.g3d.model;
/*     */ 
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Quaternion;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.math.collision.BoundingBox;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class Node
/*     */ {
/*     */   public String id;
/*     */   public boolean inheritTransform = true;
/*     */   public boolean isAnimated;
/*  41 */   public final Vector3 translation = new Vector3();
/*     */   
/*  43 */   public final Quaternion rotation = new Quaternion(0.0F, 0.0F, 0.0F, 1.0F);
/*     */   
/*  45 */   public final Vector3 scale = new Vector3(1.0F, 1.0F, 1.0F);
/*     */   
/*  47 */   public final Matrix4 localTransform = new Matrix4();
/*     */ 
/*     */   
/*  50 */   public final Matrix4 globalTransform = new Matrix4();
/*     */   
/*  52 */   public Array<NodePart> parts = new Array(2);
/*     */   
/*     */   protected Node parent;
/*  55 */   private final Array<Node> children = new Array(2);
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix4 calculateLocalTransform() {
/*  60 */     if (!this.isAnimated) this.localTransform.set(this.translation, this.rotation, this.scale); 
/*  61 */     return this.localTransform;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix4 calculateWorldTransform() {
/*  67 */     if (this.inheritTransform && this.parent != null) {
/*  68 */       this.globalTransform.set(this.parent.globalTransform).mul(this.localTransform);
/*     */     } else {
/*  70 */       this.globalTransform.set(this.localTransform);
/*  71 */     }  return this.globalTransform;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void calculateTransforms(boolean paramBoolean) {
/*  78 */     calculateLocalTransform();
/*  79 */     calculateWorldTransform();
/*     */     
/*  81 */     if (paramBoolean)
/*  82 */       for (Array.ArrayIterator<Node> arrayIterator = this.children.iterator(); arrayIterator.hasNext();) {
/*  83 */         (node = arrayIterator.next()).calculateTransforms(true);
/*     */       } 
/*     */   }
/*     */   
/*     */   public void calculateBoneTransforms(boolean paramBoolean) {
/*     */     Array.ArrayIterator<NodePart> arrayIterator;
/*  89 */     for (arrayIterator = this.parts.iterator(); arrayIterator.hasNext();) {
/*  90 */       if ((nodePart = arrayIterator.next()).invBoneBindTransforms != null && nodePart.bones != null && nodePart.invBoneBindTransforms.size == nodePart.bones.length) {
/*     */         
/*  92 */         int i = nodePart.invBoneBindTransforms.size;
/*  93 */         for (byte b = 0; b < i; b++)
/*  94 */           nodePart.bones[b].set((((Node[])nodePart.invBoneBindTransforms.keys)[b]).globalTransform).mul(((Matrix4[])nodePart.invBoneBindTransforms.values)[b]); 
/*     */       } 
/*  96 */     }  if (paramBoolean) {
/*  97 */       for (arrayIterator = this.children.iterator(); arrayIterator.hasNext();) {
/*  98 */         (node = (Node)arrayIterator.next()).calculateBoneTransforms(true);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BoundingBox calculateBoundingBox(BoundingBox paramBoundingBox) {
/* 105 */     paramBoundingBox.inf();
/* 106 */     return extendBoundingBox(paramBoundingBox);
/*     */   }
/*     */ 
/*     */   
/*     */   public BoundingBox calculateBoundingBox(BoundingBox paramBoundingBox, boolean paramBoolean) {
/* 111 */     paramBoundingBox.inf();
/* 112 */     return extendBoundingBox(paramBoundingBox, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox extendBoundingBox(BoundingBox paramBoundingBox) {
/* 118 */     return extendBoundingBox(paramBoundingBox, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox extendBoundingBox(BoundingBox paramBoundingBox, boolean paramBoolean) {
/* 124 */     int i = this.parts.size; int j;
/* 125 */     for (j = 0; j < i; j++) {
/*     */       NodePart nodePart;
/* 127 */       if ((nodePart = (NodePart)this.parts.get(j)).enabled) {
/* 128 */         MeshPart meshPart = nodePart.meshPart;
/* 129 */         if (paramBoolean) {
/* 130 */           meshPart.mesh.extendBoundingBox(paramBoundingBox, meshPart.offset, meshPart.size, this.globalTransform);
/*     */         } else {
/* 132 */           meshPart.mesh.extendBoundingBox(paramBoundingBox, meshPart.offset, meshPart.size);
/*     */         } 
/*     */       } 
/* 135 */     }  j = this.children.size;
/* 136 */     for (byte b = 0; b < j; b++)
/* 137 */       ((Node)this.children.get(b)).extendBoundingBox(paramBoundingBox); 
/* 138 */     return paramBoundingBox;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Node> void attachTo(T paramT) {
/* 144 */     paramT.addChild(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void detach() {
/* 149 */     if (this.parent != null) {
/* 150 */       this.parent.removeChild(this);
/* 151 */       this.parent = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasChildren() {
/* 157 */     return (this.children != null && this.children.size > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getChildCount() {
/* 163 */     return this.children.size;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getChild(int paramInt) {
/* 169 */     return (Node)this.children.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getChild(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 175 */     return getNode(this.children, paramString, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Node> int addChild(T paramT) {
/* 183 */     return insertChild(-1, paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Node> int addChildren(Iterable<T> paramIterable) {
/* 191 */     return insertChildren(-1, paramIterable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Node> int insertChild(int paramInt, T paramT) {
/*     */     Node node;
/* 201 */     for (node = this; node != null; node = node.getParent()) {
/* 202 */       if (node == paramT) throw new GdxRuntimeException("Cannot add a parent as a child");
/*     */     
/*     */     } 
/* 205 */     if ((node = paramT.getParent()) != null && !node.removeChild(paramT)) throw new GdxRuntimeException("Could not remove child from its current parent"); 
/* 206 */     if (paramInt < 0 || paramInt >= this.children.size) {
/* 207 */       paramInt = this.children.size;
/* 208 */       this.children.add(paramT);
/*     */     } else {
/* 210 */       this.children.insert(paramInt, paramT);
/* 211 */     }  ((Node)paramT).parent = this;
/* 212 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Node> int insertChildren(int paramInt, Iterable<T> paramIterable) {
/* 222 */     if (paramInt < 0 || paramInt > this.children.size) paramInt = this.children.size; 
/* 223 */     int i = paramInt;
/* 224 */     for (Node node : paramIterable)
/* 225 */       insertChild(i++, node); 
/* 226 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Node> boolean removeChild(T paramT) {
/* 235 */     if (!this.children.removeValue(paramT, true)) return false; 
/* 236 */     ((Node)paramT).parent = null;
/* 237 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterable<Node> getChildren() {
/* 242 */     return (Iterable<Node>)this.children;
/*     */   }
/*     */ 
/*     */   
/*     */   public Node getParent() {
/* 247 */     return this.parent;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasParent() {
/* 252 */     return (this.parent != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node copy() {
/* 263 */     return (new Node()).set(this);
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
/*     */   protected Node set(Node paramNode) {
/* 275 */     detach();
/* 276 */     this.id = paramNode.id;
/* 277 */     this.isAnimated = paramNode.isAnimated;
/* 278 */     this.inheritTransform = paramNode.inheritTransform;
/* 279 */     this.translation.set(paramNode.translation);
/* 280 */     this.rotation.set(paramNode.rotation);
/* 281 */     this.scale.set(paramNode.scale);
/* 282 */     this.localTransform.set(paramNode.localTransform);
/* 283 */     this.globalTransform.set(paramNode.globalTransform);
/* 284 */     this.parts.clear();
/* 285 */     for (Array.ArrayIterator<NodePart> arrayIterator = paramNode.parts.iterator(); arrayIterator.hasNext(); ) { NodePart nodePart = arrayIterator.next();
/* 286 */       this.parts.add(nodePart.copy()); }
/*     */     
/* 288 */     this.children.clear();
/* 289 */     for (Node node : paramNode.getChildren()) {
/* 290 */       addChild(node.copy());
/*     */     }
/* 292 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Node getNode(Array<Node> paramArray, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 299 */     int i = paramArray.size;
/*     */     
/* 301 */     if (paramBoolean2)
/* 302 */     { for (byte b = 0; b < i; b++) {
/* 303 */         Node node; if ((node = (Node)paramArray.get(b)).id.equalsIgnoreCase(paramString)) return node; 
/*     */       }  }
/* 305 */     else { for (byte b = 0; b < i; b++) {
/* 306 */         Node node; if ((node = (Node)paramArray.get(b)).id.equals(paramString)) return node; 
/*     */       }  }
/* 308 */      if (paramBoolean1)
/* 309 */       for (byte b = 0; b < i; b++) {
/* 310 */         Node node; if ((node = getNode(((Node)paramArray.get(b)).children, paramString, true, paramBoolean2)) != null) return node; 
/*     */       }  
/* 312 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\model\Node.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */