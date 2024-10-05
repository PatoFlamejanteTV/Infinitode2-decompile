/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.math.collision.BoundingBox;
/*     */ import com.badlogic.gdx.math.collision.Ray;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
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
/*     */ public class Octree<T>
/*     */ {
/*     */   final int maxItemsPerNode;
/*     */   
/*  70 */   final Pool<OctreeNode> nodePool = new Pool<OctreeNode>()
/*     */     {
/*     */       protected Octree<T>.OctreeNode newObject() {
/*  73 */         return new Octree.OctreeNode();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   protected OctreeNode root;
/*     */   final Collider<T> collider;
/*  80 */   static final Vector3 tmp = new Vector3();
/*     */ 
/*     */ 
/*     */   
/*     */   public Octree(Vector3 paramVector31, Vector3 paramVector32, int paramInt1, int paramInt2, Collider<T> paramCollider) {
/*  85 */     Vector3 vector3 = new Vector3(Math.min(paramVector31.x, paramVector32.x), Math.min(paramVector31.y, paramVector32.y), Math.min(paramVector31.z, paramVector32.z));
/*     */     
/*  87 */     paramVector31 = new Vector3(Math.max(paramVector31.x, paramVector32.x), Math.max(paramVector31.y, paramVector32.y), Math.max(paramVector31.z, paramVector32.z));
/*     */     
/*  89 */     this.root = createNode(vector3, paramVector31, paramInt1);
/*  90 */     this.collider = paramCollider;
/*  91 */     this.maxItemsPerNode = paramInt2;
/*     */   }
/*     */   
/*     */   OctreeNode createNode(Vector3 paramVector31, Vector3 paramVector32, int paramInt) {
/*     */     OctreeNode octreeNode;
/*  96 */     (octreeNode = (OctreeNode)this.nodePool.obtain()).bounds.set(paramVector31, paramVector32);
/*  97 */     octreeNode.level = paramInt;
/*  98 */     octreeNode.leaf = true;
/*  99 */     return octreeNode;
/*     */   }
/*     */   
/*     */   public void add(T paramT) {
/* 103 */     this.root.add(paramT);
/*     */   }
/*     */   
/*     */   public void remove(T paramT) {
/* 107 */     this.root.remove(paramT);
/*     */   }
/*     */   
/*     */   public void update(T paramT) {
/* 111 */     this.root.remove(paramT);
/* 112 */     this.root.add(paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectSet<T> getAll(ObjectSet<T> paramObjectSet) {
/* 119 */     this.root.getAll(paramObjectSet);
/* 120 */     return paramObjectSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectSet<T> query(BoundingBox paramBoundingBox, ObjectSet<T> paramObjectSet) {
/* 127 */     this.root.query(paramBoundingBox, paramObjectSet);
/* 128 */     return paramObjectSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectSet<T> query(Frustum paramFrustum, ObjectSet<T> paramObjectSet) {
/* 135 */     this.root.query(paramFrustum, paramObjectSet);
/* 136 */     return paramObjectSet;
/*     */   }
/*     */   
/*     */   public T rayCast(Ray paramRay, RayCastResult<T> paramRayCastResult) {
/* 140 */     paramRayCastResult.distance = paramRayCastResult.maxDistanceSq;
/* 141 */     this.root.rayCast(paramRay, paramRayCastResult);
/* 142 */     return paramRayCastResult.geometry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectSet<BoundingBox> getNodesBoxes(ObjectSet<BoundingBox> paramObjectSet) {
/* 149 */     this.root.getBoundingBox(paramObjectSet);
/* 150 */     return paramObjectSet;
/*     */   }
/*     */   protected class OctreeNode { int level;
/*     */     final BoundingBox bounds;
/*     */     
/*     */     protected OctreeNode() {
/* 156 */       this.bounds = new BoundingBox();
/*     */ 
/*     */       
/* 159 */       this.geometries = new Array(Math.min(16, Octree.this.maxItemsPerNode));
/*     */     } boolean leaf; private OctreeNode[] children; private final Array<T> geometries;
/*     */     private void split() {
/* 162 */       float f1 = (this.bounds.max.x + this.bounds.min.x) * 0.5F;
/* 163 */       float f2 = (this.bounds.max.y + this.bounds.min.y) * 0.5F;
/* 164 */       float f3 = (this.bounds.max.z + this.bounds.min.z) * 0.5F;
/*     */       
/* 166 */       int j = this.level - 1;
/*     */       
/* 168 */       this.leaf = false;
/* 169 */       if (this.children == null) this.children = new OctreeNode[8]; 
/* 170 */       this.children[0] = Octree.this.createNode(new Vector3(this.bounds.min.x, f2, f3), new Vector3(f1, this.bounds.max.y, this.bounds.max.z), j);
/*     */       
/* 172 */       this.children[1] = Octree.this.createNode(new Vector3(f1, f2, f3), new Vector3(this.bounds.max.x, this.bounds.max.y, this.bounds.max.z), j);
/*     */       
/* 174 */       this.children[2] = Octree.this.createNode(new Vector3(f1, f2, this.bounds.min.z), new Vector3(this.bounds.max.x, this.bounds.max.y, f3), j);
/*     */       
/* 176 */       this.children[3] = Octree.this.createNode(new Vector3(this.bounds.min.x, f2, this.bounds.min.z), new Vector3(f1, this.bounds.max.y, f3), j);
/*     */       
/* 178 */       this.children[4] = Octree.this.createNode(new Vector3(this.bounds.min.x, this.bounds.min.y, f3), new Vector3(f1, f2, this.bounds.max.z), j);
/*     */       
/* 180 */       this.children[5] = Octree.this.createNode(new Vector3(f1, this.bounds.min.y, f3), new Vector3(this.bounds.max.x, f2, this.bounds.max.z), j);
/*     */       
/* 182 */       this.children[6] = Octree.this.createNode(new Vector3(f1, this.bounds.min.y, this.bounds.min.z), new Vector3(this.bounds.max.x, f2, f3), j);
/*     */       
/* 184 */       this.children[7] = Octree.this.createNode(new Vector3(this.bounds.min.x, this.bounds.min.y, this.bounds.min.z), new Vector3(f1, f2, f3), j);
/*     */       OctreeNode[] arrayOfOctreeNode;
/*     */       int i;
/*     */       byte b;
/* 188 */       for (i = (arrayOfOctreeNode = this.children).length, b = 0; b < i; ) { OctreeNode octreeNode = arrayOfOctreeNode[b];
/* 189 */         for (Array.ArrayIterator<Object> arrayIterator = this.geometries.iterator(); arrayIterator.hasNext(); ) { T t = (T)arrayIterator.next();
/* 190 */           octreeNode.add(t); }
/*     */          b++; }
/*     */       
/* 193 */       this.geometries.clear();
/*     */     }
/*     */     
/*     */     private void merge() {
/* 197 */       clearChildren();
/* 198 */       this.leaf = true;
/*     */     }
/*     */ 
/*     */     
/*     */     private void free() {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: getfield geometries : Lcom/badlogic/gdx/utils/Array;
/*     */       //   4: invokevirtual clear : ()V
/*     */       //   7: aload_0
/*     */       //   8: getfield leaf : Z
/*     */       //   11: ifne -> 18
/*     */       //   14: aload_0
/*     */       //   15: invokespecial clearChildren : ()V
/*     */       //   18: aload_0
/*     */       //   19: getfield this$0 : Lcom/badlogic/gdx/math/Octree;
/*     */       //   22: getfield nodePool : Lcom/badlogic/gdx/utils/Pool;
/*     */       //   25: aload_0
/*     */       //   26: invokevirtual free : (Ljava/lang/Object;)V
/*     */       //   29: return
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #202	-> 0
/*     */       //   #203	-> 7
/*     */       //   #204	-> 18
/*     */       //   #205	-> 29
/*     */     }
/*     */ 
/*     */     
/*     */     private void clearChildren() {
/* 208 */       for (byte b = 0; b < 8; b++) {
/* 209 */         this.children[b].free();
/* 210 */         this.children[b] = null;
/*     */       } 
/*     */     }
/*     */     
/*     */     protected void add(T param1T) {
/* 215 */       if (!Octree.this.collider.intersects(this.bounds, param1T)) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 220 */       if (!this.leaf) {
/* 221 */         OctreeNode[] arrayOfOctreeNode; int i; byte b; for (i = (arrayOfOctreeNode = this.children).length, b = 0; b < i; b++) {
/* 222 */           OctreeNode octreeNode; (octreeNode = arrayOfOctreeNode[b]).add(param1T);
/*     */         }  return;
/*     */       } 
/* 225 */       if (this.geometries.size >= Octree.this.maxItemsPerNode && this.level > 0) {
/* 226 */         split(); OctreeNode[] arrayOfOctreeNode; int i; byte b;
/* 227 */         for (i = (arrayOfOctreeNode = this.children).length, b = 0; b < i; b++) {
/* 228 */           OctreeNode octreeNode; (octreeNode = arrayOfOctreeNode[b]).add(param1T);
/*     */         }  return;
/*     */       } 
/* 231 */       this.geometries.add(param1T);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean remove(T param1T) {
/*     */       OctreeNode octreeNode;
/* 237 */       if (!this.leaf) {
/* 238 */         boolean bool = false; OctreeNode[] arrayOfOctreeNode; int j;
/* 239 */         for (int i = (arrayOfOctreeNode = this.children).length; j < i; ) { OctreeNode octreeNode1 = arrayOfOctreeNode[j];
/* 240 */           bool |= octreeNode1.remove(param1T);
/*     */           j++; }
/*     */         
/* 243 */         if (bool) {
/* 244 */           ObjectSet<T> objectSet = new ObjectSet(); OctreeNode[] arrayOfOctreeNode1; byte b;
/* 245 */           for (j = (arrayOfOctreeNode1 = this.children).length, b = 0; b < j; b++) {
/* 246 */             (octreeNode = arrayOfOctreeNode1[b]).getAll(objectSet);
/*     */           }
/* 248 */           if (objectSet.size <= Octree.this.maxItemsPerNode) {
/* 249 */             for (ObjectSet.ObjectSetIterator<int> objectSetIterator = objectSet.iterator(); objectSetIterator.hasNext(); ) { j = objectSetIterator.next();
/* 250 */               this.geometries.add(j); }
/*     */             
/* 252 */             merge();
/*     */           } 
/*     */         } 
/*     */         
/* 256 */         return bool;
/*     */       } 
/* 258 */       return this.geometries.removeValue(octreeNode, true);
/*     */     }
/*     */     
/*     */     protected boolean isLeaf() {
/* 262 */       return this.leaf;
/*     */     }
/*     */     
/*     */     protected void query(BoundingBox param1BoundingBox, ObjectSet<T> param1ObjectSet) {
/* 266 */       if (!param1BoundingBox.intersects(this.bounds)) {
/*     */         return;
/*     */       }
/*     */       
/* 270 */       if (!this.leaf) {
/* 271 */         OctreeNode[] arrayOfOctreeNode; int i; byte b; for (i = (arrayOfOctreeNode = this.children).length, b = 0; b < i; b++) {
/* 272 */           OctreeNode octreeNode; (octreeNode = arrayOfOctreeNode[b]).query(param1BoundingBox, param1ObjectSet);
/*     */         }  return;
/*     */       } 
/* 275 */       for (Array.ArrayIterator<Object> arrayIterator = this.geometries.iterator(); arrayIterator.hasNext(); ) { Object object = arrayIterator.next();
/*     */         
/* 277 */         if (Octree.this.collider.intersects(this.bounds, object)) {
/* 278 */           param1ObjectSet.add(object);
/*     */         } }
/*     */     
/*     */     }
/*     */ 
/*     */     
/*     */     protected void query(Frustum param1Frustum, ObjectSet<T> param1ObjectSet) {
/* 285 */       if (!Intersector.intersectFrustumBounds(param1Frustum, this.bounds)) {
/*     */         return;
/*     */       }
/* 288 */       if (!this.leaf) {
/* 289 */         OctreeNode[] arrayOfOctreeNode; int i; byte b; for (i = (arrayOfOctreeNode = this.children).length, b = 0; b < i; b++) {
/* 290 */           OctreeNode octreeNode; (octreeNode = arrayOfOctreeNode[b]).query(param1Frustum, param1ObjectSet);
/*     */         }  return;
/*     */       } 
/* 293 */       for (Array.ArrayIterator<Object> arrayIterator = this.geometries.iterator(); arrayIterator.hasNext(); ) { Object object = arrayIterator.next();
/*     */         
/* 295 */         if (Octree.this.collider.intersects(param1Frustum, object)) {
/* 296 */           param1ObjectSet.add(object);
/*     */         } }
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void rayCast(Ray param1Ray, Octree.RayCastResult<T> param1RayCastResult) {
/*     */       boolean bool;
/* 305 */       if (!(bool = Intersector.intersectRayBounds(param1Ray, this.bounds, Octree.tmp))) {
/*     */         return;
/*     */       }
/*     */       float f;
/* 309 */       if ((f = Octree.tmp.dst2(param1Ray.origin)) >= param1RayCastResult.maxDistanceSq) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 315 */       if (!this.leaf) {
/* 316 */         OctreeNode[] arrayOfOctreeNode; int i; byte b; for (i = (arrayOfOctreeNode = this.children).length, b = 0; b < i; b++) {
/* 317 */           OctreeNode octreeNode; (octreeNode = arrayOfOctreeNode[b]).rayCast(param1Ray, param1RayCastResult);
/*     */         }  return;
/*     */       } 
/* 320 */       for (Array.ArrayIterator<Object> arrayIterator = this.geometries.iterator(); arrayIterator.hasNext(); ) { T t = (T)arrayIterator.next();
/*     */         
/* 322 */         float f1 = Octree.this.collider.intersects(param1Ray, t);
/* 323 */         if (param1RayCastResult.geometry == null || f1 < param1RayCastResult.distance) {
/* 324 */           param1RayCastResult.geometry = t;
/* 325 */           param1RayCastResult.distance = f1;
/*     */         }  }
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void getAll(ObjectSet<T> param1ObjectSet) {
/* 334 */       if (!this.leaf) {
/* 335 */         OctreeNode[] arrayOfOctreeNode; int i; byte b; for (i = (arrayOfOctreeNode = this.children).length, b = 0; b < i; b++) {
/* 336 */           OctreeNode octreeNode; (octreeNode = arrayOfOctreeNode[b]).getAll(param1ObjectSet);
/*     */         } 
/*     */       } 
/* 339 */       param1ObjectSet.addAll(this.geometries);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void getBoundingBox(ObjectSet<BoundingBox> param1ObjectSet) {
/* 345 */       if (!this.leaf) {
/* 346 */         OctreeNode[] arrayOfOctreeNode; int i; byte b; for (i = (arrayOfOctreeNode = this.children).length, b = 0; b < i; b++) {
/* 347 */           OctreeNode octreeNode; (octreeNode = arrayOfOctreeNode[b]).getBoundingBox(param1ObjectSet);
/*     */         } 
/*     */       } 
/* 350 */       param1ObjectSet.add(this.bounds);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Collider<T>
/*     */   {
/*     */     boolean intersects(BoundingBox param1BoundingBox, T param1T);
/*     */ 
/*     */ 
/*     */     
/*     */     boolean intersects(Frustum param1Frustum, T param1T);
/*     */ 
/*     */ 
/*     */     
/*     */     float intersects(Ray param1Ray, T param1T);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class RayCastResult<T>
/*     */   {
/*     */     T geometry;
/*     */ 
/*     */     
/*     */     float distance;
/*     */ 
/*     */     
/* 380 */     float maxDistanceSq = Float.MAX_VALUE;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Octree.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */