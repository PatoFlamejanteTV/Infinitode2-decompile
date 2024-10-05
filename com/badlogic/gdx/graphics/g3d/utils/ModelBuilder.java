/*     */ package com.badlogic.gdx.graphics.g3d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.VertexAttributes;
/*     */ import com.badlogic.gdx.graphics.g3d.Material;
/*     */ import com.badlogic.gdx.graphics.g3d.Model;
/*     */ import com.badlogic.gdx.graphics.g3d.model.MeshPart;
/*     */ import com.badlogic.gdx.graphics.g3d.model.Node;
/*     */ import com.badlogic.gdx.graphics.g3d.model.NodePart;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
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
/*     */ public class ModelBuilder
/*     */ {
/*     */   private Model model;
/*     */   private Node node;
/*  47 */   private Array<MeshBuilder> builders = new Array();
/*     */   
/*  49 */   private Matrix4 tmpTransform = new Matrix4();
/*     */   
/*     */   private MeshBuilder getBuilder(VertexAttributes paramVertexAttributes) {
/*  52 */     for (Array.ArrayIterator<MeshBuilder> arrayIterator = this.builders.iterator(); arrayIterator.hasNext();) {
/*  53 */       if ((meshBuilder1 = arrayIterator.next()).getAttributes().equals(paramVertexAttributes) && meshBuilder1.lastIndex() < 32768) return meshBuilder1; 
/*     */     }  MeshBuilder meshBuilder;
/*  55 */     (meshBuilder = new MeshBuilder()).begin(paramVertexAttributes);
/*  56 */     this.builders.add(meshBuilder);
/*  57 */     return meshBuilder;
/*     */   }
/*     */ 
/*     */   
/*     */   public void begin() {
/*  62 */     if (this.model != null) throw new GdxRuntimeException("Call end() first"); 
/*  63 */     this.node = null;
/*  64 */     this.model = new Model();
/*  65 */     this.builders.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Model end() {
/*  71 */     if (this.model == null) throw new GdxRuntimeException("Call begin() first"); 
/*  72 */     Model model = this.model;
/*  73 */     endnode();
/*  74 */     this.model = null;
/*     */     
/*  76 */     for (Array.ArrayIterator<MeshBuilder> arrayIterator = this.builders.iterator(); arrayIterator.hasNext();)
/*  77 */       (meshBuilder = arrayIterator.next()).end(); 
/*  78 */     this.builders.clear();
/*     */     
/*  80 */     rebuildReferences(model);
/*  81 */     return model;
/*     */   }
/*     */   
/*     */   private void endnode() {
/*  85 */     if (this.node != null) {
/*  86 */       this.node = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected Node node(Node paramNode) {
/*  92 */     if (this.model == null) throw new GdxRuntimeException("Call begin() first");
/*     */     
/*  94 */     endnode();
/*     */     
/*  96 */     this.model.nodes.add(paramNode);
/*  97 */     this.node = paramNode;
/*     */     
/*  99 */     return paramNode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Node node() {
/* 105 */     Node node = new Node();
/* 106 */     node(node);
/* 107 */     node.id = "node" + this.model.nodes.size;
/* 108 */     return node;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node node(String paramString, Model paramModel) {
/*     */     Node node;
/* 116 */     (node = new Node()).id = paramString;
/* 117 */     node.addChildren((Iterable)paramModel.nodes);
/* 118 */     node(node);
/* 119 */     for (Disposable disposable : paramModel.getManagedDisposables())
/* 120 */       manage(disposable); 
/* 121 */     return node;
/*     */   }
/*     */ 
/*     */   
/*     */   public void manage(Disposable paramDisposable) {
/* 126 */     if (this.model == null) throw new GdxRuntimeException("Call begin() first"); 
/* 127 */     this.model.manageDisposable(paramDisposable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void part(MeshPart paramMeshPart, Material paramMaterial) {
/* 134 */     if (this.node == null) node(); 
/* 135 */     this.node.parts.add(new NodePart(paramMeshPart, paramMaterial));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MeshPart part(String paramString, Mesh paramMesh, int paramInt1, int paramInt2, int paramInt3, Material paramMaterial) {
/*     */     MeshPart meshPart;
/* 144 */     (meshPart = new MeshPart()).id = paramString;
/* 145 */     meshPart.primitiveType = paramInt1;
/* 146 */     meshPart.mesh = paramMesh;
/* 147 */     meshPart.offset = paramInt2;
/* 148 */     meshPart.size = paramInt3;
/* 149 */     part(meshPart, paramMaterial);
/* 150 */     return meshPart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MeshPart part(String paramString, Mesh paramMesh, int paramInt, Material paramMaterial) {
/* 158 */     return part(paramString, paramMesh, paramInt, 0, paramMesh.getNumIndices(), paramMaterial);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MeshPartBuilder part(String paramString, int paramInt, VertexAttributes paramVertexAttributes, Material paramMaterial) {
/* 167 */     MeshBuilder meshBuilder = getBuilder(paramVertexAttributes);
/* 168 */     part(meshBuilder.part(paramString, paramInt), paramMaterial);
/* 169 */     return meshBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MeshPartBuilder part(String paramString, int paramInt, long paramLong, Material paramMaterial) {
/* 180 */     return part(paramString, paramInt, MeshBuilder.createAttributes(paramLong), paramMaterial);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createBox(float paramFloat1, float paramFloat2, float paramFloat3, Material paramMaterial, long paramLong) {
/* 188 */     return createBox(paramFloat1, paramFloat2, paramFloat3, 4, paramMaterial, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createBox(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Material paramMaterial, long paramLong) {
/* 197 */     begin();
/* 198 */     part("box", paramInt, paramLong, paramMaterial).box(paramFloat1, paramFloat2, paramFloat3);
/* 199 */     return end();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, Material paramMaterial, long paramLong) {
/* 209 */     return createRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, 4, paramMaterial, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, int paramInt, Material paramMaterial, long paramLong) {
/* 220 */     begin();
/* 221 */     part("rect", paramInt, paramLong, paramMaterial).rect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15);
/*     */     
/* 223 */     return end();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createCylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Material paramMaterial, long paramLong) {
/* 232 */     return createCylinder(paramFloat1, paramFloat2, paramFloat3, paramInt, 4, paramMaterial, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createCylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong) {
/* 241 */     return createCylinder(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramMaterial, paramLong, 0.0F, 360.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createCylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5) {
/* 250 */     return createCylinder(paramFloat1, paramFloat2, paramFloat3, paramInt, 4, paramMaterial, paramLong, paramFloat4, paramFloat5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createCylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5) {
/* 259 */     begin();
/* 260 */     part("cylinder", paramInt2, paramLong, paramMaterial).cylinder(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramFloat4, paramFloat5);
/* 261 */     return end();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createCone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Material paramMaterial, long paramLong) {
/* 270 */     return createCone(paramFloat1, paramFloat2, paramFloat3, paramInt, 4, paramMaterial, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createCone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong) {
/* 279 */     return createCone(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramMaterial, paramLong, 0.0F, 360.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createCone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5) {
/* 288 */     return createCone(paramFloat1, paramFloat2, paramFloat3, paramInt, 4, paramMaterial, paramLong, paramFloat4, paramFloat5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createCone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5) {
/* 297 */     begin();
/* 298 */     part("cone", paramInt2, paramLong, paramMaterial).cone(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramFloat4, paramFloat5);
/* 299 */     return end();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createSphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong) {
/* 308 */     return createSphere(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, 4, paramMaterial, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createSphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, int paramInt3, Material paramMaterial, long paramLong) {
/* 317 */     return createSphere(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramInt3, paramMaterial, paramLong, 0.0F, 360.0F, 0.0F, 180.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createSphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 326 */     return createSphere(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, 4, paramMaterial, paramLong, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createSphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, int paramInt3, Material paramMaterial, long paramLong, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 336 */     begin();
/* 337 */     part("sphere", paramInt3, paramLong, paramMaterial).sphere(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
/*     */     
/* 339 */     return end();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createCapsule(float paramFloat1, float paramFloat2, int paramInt, Material paramMaterial, long paramLong) {
/* 347 */     return createCapsule(paramFloat1, paramFloat2, paramInt, 4, paramMaterial, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createCapsule(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, Material paramMaterial, long paramLong) {
/* 356 */     begin();
/* 357 */     part("capsule", paramInt2, paramLong, paramMaterial).capsule(paramFloat1, paramFloat2, paramInt1);
/* 358 */     return end();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void rebuildReferences(Model paramModel) {
/* 364 */     paramModel.materials.clear();
/* 365 */     paramModel.meshes.clear();
/* 366 */     paramModel.meshParts.clear();
/* 367 */     for (Array.ArrayIterator<Node> arrayIterator = paramModel.nodes.iterator(); arrayIterator.hasNext(); ) { Node node = arrayIterator.next();
/* 368 */       rebuildReferences(paramModel, node); }
/*     */   
/*     */   }
/*     */   private static void rebuildReferences(Model paramModel, Node paramNode) {
/* 372 */     for (Array.ArrayIterator<NodePart> arrayIterator = paramNode.parts.iterator(); arrayIterator.hasNext(); ) { NodePart nodePart = arrayIterator.next();
/* 373 */       if (!paramModel.materials.contains(nodePart.material, true)) paramModel.materials.add(nodePart.material); 
/* 374 */       if (!paramModel.meshParts.contains(nodePart.meshPart, true)) {
/* 375 */         paramModel.meshParts.add(nodePart.meshPart);
/* 376 */         if (!paramModel.meshes.contains(nodePart.meshPart.mesh, true)) paramModel.meshes.add(nodePart.meshPart.mesh); 
/* 377 */         paramModel.manageDisposable((Disposable)nodePart.meshPart.mesh);
/*     */       }  }
/*     */     
/* 380 */     for (Node node : paramNode.getChildren()) {
/* 381 */       rebuildReferences(paramModel, node);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createXYZCoordinates(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Material paramMaterial, long paramLong) {
/* 392 */     begin();
/*     */     
/* 394 */     node();
/*     */     
/*     */     MeshPartBuilder meshPartBuilder;
/* 397 */     (meshPartBuilder = part("xyz", paramInt2, paramLong, paramMaterial)).setColor(Color.RED);
/* 398 */     meshPartBuilder.arrow(0.0F, 0.0F, 0.0F, paramFloat1, 0.0F, 0.0F, paramFloat2, paramFloat3, paramInt1);
/* 399 */     meshPartBuilder.setColor(Color.GREEN);
/* 400 */     meshPartBuilder.arrow(0.0F, 0.0F, 0.0F, 0.0F, paramFloat1, 0.0F, paramFloat2, paramFloat3, paramInt1);
/* 401 */     meshPartBuilder.setColor(Color.BLUE);
/* 402 */     meshPartBuilder.arrow(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, paramFloat1, paramFloat2, paramFloat3, paramInt1);
/*     */     
/* 404 */     return end();
/*     */   }
/*     */   
/*     */   public Model createXYZCoordinates(float paramFloat, Material paramMaterial, long paramLong) {
/* 408 */     return createXYZCoordinates(paramFloat, 0.1F, 0.1F, 5, 4, paramMaterial, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createArrow(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2, Material paramMaterial, long paramLong) {
/* 419 */     begin();
/* 420 */     part("arrow", paramInt2, paramLong, paramMaterial).arrow(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramInt1);
/* 421 */     return end();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createArrow(Vector3 paramVector31, Vector3 paramVector32, Material paramMaterial, long paramLong) {
/* 427 */     return createArrow(paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, 0.1F, 0.1F, 5, 4, paramMaterial, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model createLineGrid(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Material paramMaterial, long paramLong) {
/* 437 */     begin();
/* 438 */     MeshPartBuilder meshPartBuilder = part("lines", 1, paramLong, paramMaterial);
/* 439 */     float f2 = paramInt1 * paramFloat1, f3 = paramInt2 * paramFloat2; f2 /= 2.0F; f3 /= 2.0F;
/* 440 */     float f4 = -f2, f5 = f4, f6 = -f3; byte b;
/* 441 */     for (b = 0; b <= paramInt1; b++) {
/* 442 */       meshPartBuilder.line(f4, 0.0F, f3, f5, 0.0F, f6);
/* 443 */       f4 += paramFloat1;
/* 444 */       f5 += paramFloat1;
/*     */     } 
/*     */     
/* 447 */     f4 = -f2;
/*     */     
/* 449 */     float f1 = f6;
/*     */ 
/*     */ 
/*     */     
/* 453 */     for (b = 0; b <= paramInt2; b++) {
/* 454 */       meshPartBuilder.line(f4, 0.0F, f1, f2, 0.0F, f6);
/* 455 */       f1 += paramFloat2;
/* 456 */       f6 += paramFloat2;
/*     */     } 
/*     */     
/* 459 */     return end();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\ModelBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */