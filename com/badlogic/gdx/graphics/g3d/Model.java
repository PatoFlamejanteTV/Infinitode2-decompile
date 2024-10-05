/*     */ package com.badlogic.gdx.graphics.g3d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.GLTexture;
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.VertexAttributes;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.model.Animation;
/*     */ import com.badlogic.gdx.graphics.g3d.model.MeshPart;
/*     */ import com.badlogic.gdx.graphics.g3d.model.Node;
/*     */ import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
/*     */ import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
/*     */ import com.badlogic.gdx.graphics.g3d.model.NodePart;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelAnimation;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelMesh;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelNode;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelNodeAnimation;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelNodeKeyframe;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelNodePart;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.TextureProvider;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Quaternion;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.math.collision.BoundingBox;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ArrayMap;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import java.nio.ShortBuffer;
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
/*     */ public class Model
/*     */   implements Disposable
/*     */ {
/*  78 */   public final Array<Material> materials = new Array();
/*     */   
/*  80 */   public final Array<Node> nodes = new Array();
/*     */   
/*  82 */   public final Array<Animation> animations = new Array();
/*     */   
/*  84 */   public final Array<Mesh> meshes = new Array();
/*     */ 
/*     */   
/*  87 */   public final Array<MeshPart> meshParts = new Array();
/*     */   
/*  89 */   protected final Array<Disposable> disposables = new Array();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ObjectMap<NodePart, ArrayMap<String, Matrix4>> nodePartBones;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Model(ModelData paramModelData) {
/* 100 */     this(paramModelData, (TextureProvider)new TextureProvider.FileTextureProvider());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(ModelData paramModelData, TextureProvider paramTextureProvider) {
/* 111 */     loadMeshes((Iterable<ModelMesh>)paramModelData.meshes);
/* 112 */     loadMaterials((Iterable<ModelMaterial>)paramModelData.materials, paramTextureProvider);
/* 113 */     loadNodes((Iterable<ModelNode>)paramModelData.nodes);
/* 114 */     loadAnimations((Iterable<ModelAnimation>)paramModelData.animations);
/* 115 */     calculateTransforms();
/*     */   }
/*     */   
/*     */   protected void loadAnimations(Iterable<ModelAnimation> paramIterable) {
/* 119 */     for (ModelAnimation modelAnimation : paramIterable) {
/*     */       Animation animation;
/* 121 */       (animation = new Animation()).id = modelAnimation.id;
/* 122 */       for (Array.ArrayIterator<ModelNodeAnimation> arrayIterator = modelAnimation.nodeAnimations.iterator(); arrayIterator.hasNext(); ) { ModelNodeAnimation modelNodeAnimation = arrayIterator.next();
/*     */         Node node;
/* 124 */         if ((node = getNode(modelNodeAnimation.nodeId)) != null) {
/*     */           NodeAnimation nodeAnimation;
/* 126 */           (nodeAnimation = new NodeAnimation()).node = node;
/*     */           
/* 128 */           if (modelNodeAnimation.translation != null) {
/* 129 */             nodeAnimation.translation = new Array();
/* 130 */             nodeAnimation.translation.ensureCapacity(modelNodeAnimation.translation.size);
/* 131 */             for (Array.ArrayIterator<ModelNodeKeyframe> arrayIterator1 = modelNodeAnimation.translation.iterator(); arrayIterator1.hasNext(); ) {
/* 132 */               ModelNodeKeyframe modelNodeKeyframe; if ((modelNodeKeyframe = arrayIterator1.next()).keytime > animation.duration) animation.duration = modelNodeKeyframe.keytime; 
/* 133 */               nodeAnimation.translation
/* 134 */                 .add(new NodeKeyframe(modelNodeKeyframe.keytime, new Vector3((modelNodeKeyframe.value == null) ? node.translation : (Vector3)modelNodeKeyframe.value)));
/*     */             } 
/*     */           } 
/*     */           
/* 138 */           if (modelNodeAnimation.rotation != null) {
/* 139 */             nodeAnimation.rotation = new Array();
/* 140 */             nodeAnimation.rotation.ensureCapacity(modelNodeAnimation.rotation.size);
/* 141 */             for (Array.ArrayIterator<ModelNodeKeyframe> arrayIterator1 = modelNodeAnimation.rotation.iterator(); arrayIterator1.hasNext(); ) {
/* 142 */               ModelNodeKeyframe modelNodeKeyframe; if ((modelNodeKeyframe = arrayIterator1.next()).keytime > animation.duration) animation.duration = modelNodeKeyframe.keytime; 
/* 143 */               nodeAnimation.rotation
/* 144 */                 .add(new NodeKeyframe(modelNodeKeyframe.keytime, new Quaternion((modelNodeKeyframe.value == null) ? node.rotation : (Quaternion)modelNodeKeyframe.value)));
/*     */             } 
/*     */           } 
/*     */           
/* 148 */           if (modelNodeAnimation.scaling != null) {
/* 149 */             nodeAnimation.scaling = new Array();
/* 150 */             nodeAnimation.scaling.ensureCapacity(modelNodeAnimation.scaling.size);
/* 151 */             for (Array.ArrayIterator<ModelNodeKeyframe> arrayIterator1 = modelNodeAnimation.scaling.iterator(); arrayIterator1.hasNext(); ) {
/* 152 */               ModelNodeKeyframe modelNodeKeyframe; if ((modelNodeKeyframe = arrayIterator1.next()).keytime > animation.duration) animation.duration = modelNodeKeyframe.keytime; 
/* 153 */               nodeAnimation.scaling
/* 154 */                 .add(new NodeKeyframe(modelNodeKeyframe.keytime, new Vector3((modelNodeKeyframe.value == null) ? node.scale : (Vector3)modelNodeKeyframe.value)));
/*     */             } 
/*     */           } 
/*     */           
/* 158 */           if ((nodeAnimation.translation != null && nodeAnimation.translation.size > 0) || (nodeAnimation.rotation != null && nodeAnimation.rotation.size > 0) || (nodeAnimation.scaling != null && nodeAnimation.scaling.size > 0))
/*     */           {
/* 160 */             animation.nodeAnimations.add(nodeAnimation); } 
/*     */         }  }
/* 162 */        if (animation.nodeAnimations.size > 0) this.animations.add(animation); 
/*     */     } 
/*     */   }
/*     */   
/* 166 */   public Model() { this.nodePartBones = new ObjectMap(); } public Model(ModelData paramModelData, TextureProvider paramTextureProvider) { this.nodePartBones = new ObjectMap();
/*     */     load(paramModelData, paramTextureProvider); }
/*     */    protected void loadNodes(Iterable<ModelNode> paramIterable) {
/* 169 */     this.nodePartBones.clear();
/* 170 */     for (ModelNode modelNode : paramIterable) {
/* 171 */       this.nodes.add(loadNode(modelNode));
/*     */     }
/* 173 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = this.nodePartBones.entries().iterator(); entries.hasNext(); ) {
/* 174 */       ObjectMap.Entry entry; if (((NodePart)(entry = entries.next()).key).invBoneBindTransforms == null)
/* 175 */         ((NodePart)entry.key).invBoneBindTransforms = new ArrayMap(Node.class, Matrix4.class); 
/* 176 */       ((NodePart)entry.key).invBoneBindTransforms.clear();
/* 177 */       for (ObjectMap.Entry entry1 : ((ArrayMap)entry.value).entries())
/* 178 */         ((NodePart)entry.key).invBoneBindTransforms.put(getNode((String)entry1.key), (new Matrix4((Matrix4)entry1.value)).inv()); 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected Node loadNode(ModelNode paramModelNode) {
/*     */     Node node;
/* 184 */     (node = new Node()).id = paramModelNode.id;
/*     */     
/* 186 */     if (paramModelNode.translation != null) node.translation.set(paramModelNode.translation); 
/* 187 */     if (paramModelNode.rotation != null) node.rotation.set(paramModelNode.rotation); 
/* 188 */     if (paramModelNode.scale != null) node.scale.set(paramModelNode.scale);
/*     */     
/* 190 */     if (paramModelNode.parts != null) {
/* 191 */       ModelNodePart[] arrayOfModelNodePart; int i; byte b; for (i = (arrayOfModelNodePart = paramModelNode.parts).length, b = 0; b < i; ) { ModelNodePart modelNodePart = arrayOfModelNodePart[b];
/* 192 */         MeshPart meshPart = null;
/* 193 */         Material material = null;
/*     */         
/* 195 */         if (modelNodePart.meshPartId != null) {
/* 196 */           for (Array.ArrayIterator<MeshPart> arrayIterator = this.meshParts.iterator(); arrayIterator.hasNext(); ) { MeshPart meshPart1 = arrayIterator.next();
/* 197 */             if (modelNodePart.meshPartId.equals(meshPart1.id)) {
/* 198 */               meshPart = meshPart1;
/*     */               
/*     */               break;
/*     */             }  }
/*     */         
/*     */         }
/* 204 */         if (modelNodePart.materialId != null) {
/* 205 */           for (Array.ArrayIterator<Material> arrayIterator = this.materials.iterator(); arrayIterator.hasNext(); ) { Material material1 = arrayIterator.next();
/* 206 */             if (modelNodePart.materialId.equals(material1.id)) {
/* 207 */               material = material1;
/*     */               
/*     */               break;
/*     */             }  }
/*     */         
/*     */         }
/* 213 */         if (meshPart == null || material == null) throw new GdxRuntimeException("Invalid node: " + node.id);
/*     */         
/*     */         NodePart nodePart;
/* 216 */         (nodePart = new NodePart()).meshPart = meshPart;
/* 217 */         nodePart.material = material;
/* 218 */         node.parts.add(nodePart);
/* 219 */         if (modelNodePart.bones != null) this.nodePartBones.put(nodePart, modelNodePart.bones); 
/*     */         b++; }
/*     */     
/*     */     } 
/* 223 */     if (paramModelNode.children != null) {
/* 224 */       ModelNode[] arrayOfModelNode; int i; byte b; for (i = (arrayOfModelNode = paramModelNode.children).length, b = 0; b < i; ) { ModelNode modelNode = arrayOfModelNode[b];
/* 225 */         node.addChild(loadNode(modelNode));
/*     */         b++; }
/*     */     
/*     */     } 
/* 229 */     return node;
/*     */   }
/*     */   
/*     */   protected void loadMeshes(Iterable<ModelMesh> paramIterable) {
/* 233 */     for (ModelMesh modelMesh : paramIterable) {
/* 234 */       convertMesh(modelMesh);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void convertMesh(ModelMesh paramModelMesh) {
/* 239 */     int i = 0; ModelMeshPart[] arrayOfModelMeshPart2; int k;
/* 240 */     for (int j = (arrayOfModelMeshPart2 = paramModelMesh.parts).length; k < j; ) { ModelMeshPart modelMeshPart = arrayOfModelMeshPart2[k];
/* 241 */       i += modelMeshPart.indices.length; k++; }
/*     */     
/* 243 */     boolean bool = (i > 0) ? true : false;
/* 244 */     VertexAttributes vertexAttributes = new VertexAttributes(paramModelMesh.attributes);
/* 245 */     k = paramModelMesh.vertices.length / vertexAttributes.vertexSize / 4;
/*     */     
/* 247 */     Mesh mesh = new Mesh(true, k, i, vertexAttributes);
/* 248 */     this.meshes.add(mesh);
/* 249 */     this.disposables.add(mesh);
/*     */     
/* 251 */     BufferUtils.copy(paramModelMesh.vertices, mesh.getVerticesBuffer(true), paramModelMesh.vertices.length, 0);
/* 252 */     i = 0;
/*     */     ShortBuffer shortBuffer;
/* 254 */     (shortBuffer = mesh.getIndicesBuffer(true)).clear(); ModelMeshPart[] arrayOfModelMeshPart1; int m; byte b;
/* 255 */     for (m = (arrayOfModelMeshPart1 = paramModelMesh.parts).length, b = 0; b < m; ) { ModelMeshPart modelMeshPart = arrayOfModelMeshPart1[b];
/*     */       MeshPart meshPart;
/* 257 */       (meshPart = new MeshPart()).id = modelMeshPart.id;
/* 258 */       meshPart.primitiveType = modelMeshPart.primitiveType;
/* 259 */       meshPart.offset = i;
/* 260 */       meshPart.size = bool ? modelMeshPart.indices.length : k;
/* 261 */       meshPart.mesh = mesh;
/* 262 */       if (bool) {
/* 263 */         shortBuffer.put(modelMeshPart.indices);
/*     */       }
/* 265 */       i += meshPart.size;
/* 266 */       this.meshParts.add(meshPart); b++; }
/*     */     
/* 268 */     shortBuffer.position(0);
/* 269 */     for (Array.ArrayIterator<MeshPart> arrayIterator = this.meshParts.iterator(); arrayIterator.hasNext();)
/* 270 */       (meshPart = arrayIterator.next()).update(); 
/*     */   }
/*     */   
/*     */   protected void loadMaterials(Iterable<ModelMaterial> paramIterable, TextureProvider paramTextureProvider) {
/* 274 */     for (ModelMaterial modelMaterial : paramIterable) {
/* 275 */       this.materials.add(convertMaterial(modelMaterial, paramTextureProvider));
/*     */     }
/*     */   }
/*     */   
/*     */   protected Material convertMaterial(ModelMaterial paramModelMaterial, TextureProvider paramTextureProvider) {
/*     */     Material material;
/* 281 */     (material = new Material()).id = paramModelMaterial.id;
/* 282 */     if (paramModelMaterial.ambient != null) material.set((Attribute)new ColorAttribute(ColorAttribute.Ambient, paramModelMaterial.ambient)); 
/* 283 */     if (paramModelMaterial.diffuse != null) material.set((Attribute)new ColorAttribute(ColorAttribute.Diffuse, paramModelMaterial.diffuse)); 
/* 284 */     if (paramModelMaterial.specular != null) material.set((Attribute)new ColorAttribute(ColorAttribute.Specular, paramModelMaterial.specular)); 
/* 285 */     if (paramModelMaterial.emissive != null) material.set((Attribute)new ColorAttribute(ColorAttribute.Emissive, paramModelMaterial.emissive)); 
/* 286 */     if (paramModelMaterial.reflection != null) material.set((Attribute)new ColorAttribute(ColorAttribute.Reflection, paramModelMaterial.reflection)); 
/* 287 */     if (paramModelMaterial.shininess > 0.0F) material.set((Attribute)new FloatAttribute(FloatAttribute.Shininess, paramModelMaterial.shininess)); 
/* 288 */     if (paramModelMaterial.opacity != 1.0F) material.set((Attribute)new BlendingAttribute(770, 771, paramModelMaterial.opacity));
/*     */     
/* 290 */     ObjectMap objectMap = new ObjectMap();
/*     */ 
/*     */     
/* 293 */     if (paramModelMaterial.textures != null) {
/* 294 */       for (Array.ArrayIterator<ModelTexture> arrayIterator = paramModelMaterial.textures.iterator(); arrayIterator.hasNext(); ) { Texture texture; ModelTexture modelTexture = arrayIterator.next();
/*     */         
/* 296 */         if (objectMap.containsKey(modelTexture.fileName)) {
/* 297 */           texture = (Texture)objectMap.get(modelTexture.fileName);
/*     */         } else {
/* 299 */           texture = paramTextureProvider.load(modelTexture.fileName);
/* 300 */           objectMap.put(modelTexture.fileName, texture);
/* 301 */           this.disposables.add(texture);
/*     */         } 
/*     */         
/*     */         TextureDescriptor textureDescriptor;
/* 305 */         (textureDescriptor = new TextureDescriptor((GLTexture)texture)).minFilter = texture.getMinFilter();
/* 306 */         textureDescriptor.magFilter = texture.getMagFilter();
/* 307 */         textureDescriptor.uWrap = texture.getUWrap();
/* 308 */         textureDescriptor.vWrap = texture.getVWrap();
/*     */         
/* 310 */         float f1 = (modelTexture.uvTranslation == null) ? 0.0F : modelTexture.uvTranslation.x;
/* 311 */         float f2 = (modelTexture.uvTranslation == null) ? 0.0F : modelTexture.uvTranslation.y;
/* 312 */         float f3 = (modelTexture.uvScaling == null) ? 1.0F : modelTexture.uvScaling.x;
/* 313 */         float f4 = (modelTexture.uvScaling == null) ? 1.0F : modelTexture.uvScaling.y;
/*     */         
/* 315 */         switch (modelTexture.usage) {
/*     */           case 2:
/* 317 */             material.set((Attribute)new TextureAttribute(TextureAttribute.Diffuse, textureDescriptor, f1, f2, f3, f4));
/*     */           
/*     */           case 5:
/* 320 */             material.set((Attribute)new TextureAttribute(TextureAttribute.Specular, textureDescriptor, f1, f2, f3, f4));
/*     */           
/*     */           case 8:
/* 323 */             material.set((Attribute)new TextureAttribute(TextureAttribute.Bump, textureDescriptor, f1, f2, f3, f4));
/*     */           
/*     */           case 7:
/* 326 */             material.set((Attribute)new TextureAttribute(TextureAttribute.Normal, textureDescriptor, f1, f2, f3, f4));
/*     */           
/*     */           case 4:
/* 329 */             material.set((Attribute)new TextureAttribute(TextureAttribute.Ambient, textureDescriptor, f1, f2, f3, f4));
/*     */           
/*     */           case 3:
/* 332 */             material.set((Attribute)new TextureAttribute(TextureAttribute.Emissive, textureDescriptor, f1, f2, f3, f4));
/*     */           
/*     */           case 10:
/* 335 */             material.set((Attribute)new TextureAttribute(TextureAttribute.Reflection, textureDescriptor, f1, f2, f3, f4));
/*     */         } 
/*     */         
/*     */          }
/*     */     
/*     */     }
/* 341 */     return material;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void manageDisposable(Disposable paramDisposable) {
/* 348 */     if (!this.disposables.contains(paramDisposable, true)) this.disposables.add(paramDisposable);
/*     */   
/*     */   }
/*     */   
/*     */   public Iterable<Disposable> getManagedDisposables() {
/* 353 */     return (Iterable<Disposable>)this.disposables;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 358 */     for (Array.ArrayIterator<Disposable> arrayIterator = this.disposables.iterator(); arrayIterator.hasNext();) {
/* 359 */       (disposable = arrayIterator.next()).dispose();
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
/* 372 */     int i = this.nodes.size; byte b;
/* 373 */     for (b = 0; b < i; b++) {
/* 374 */       ((Node)this.nodes.get(b)).calculateTransforms(true);
/*     */     }
/* 376 */     for (b = 0; b < i; b++) {
/* 377 */       ((Node)this.nodes.get(b)).calculateBoneTransforms(true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox calculateBoundingBox(BoundingBox paramBoundingBox) {
/* 385 */     paramBoundingBox.inf();
/* 386 */     return extendBoundingBox(paramBoundingBox);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox extendBoundingBox(BoundingBox paramBoundingBox) {
/* 394 */     int i = this.nodes.size;
/* 395 */     for (byte b = 0; b < i; b++)
/* 396 */       ((Node)this.nodes.get(b)).extendBoundingBox(paramBoundingBox); 
/* 397 */     return paramBoundingBox;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation getAnimation(String paramString) {
/* 403 */     return getAnimation(paramString, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation getAnimation(String paramString, boolean paramBoolean) {
/* 410 */     int i = this.animations.size;
/*     */     
/* 412 */     if (paramBoolean)
/* 413 */     { for (byte b = 0; b < i; b++) {
/* 414 */         Animation animation; if ((animation = (Animation)this.animations.get(b)).id.equalsIgnoreCase(paramString)) return animation; 
/*     */       }  }
/* 416 */     else { for (byte b = 0; b < i; b++) {
/* 417 */         Animation animation; if ((animation = (Animation)this.animations.get(b)).id.equals(paramString)) return animation; 
/*     */       }  }
/* 419 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Material getMaterial(String paramString) {
/* 425 */     return getMaterial(paramString, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Material getMaterial(String paramString, boolean paramBoolean) {
/* 432 */     int i = this.materials.size;
/*     */     
/* 434 */     if (paramBoolean)
/* 435 */     { for (byte b = 0; b < i; b++) {
/* 436 */         Material material; if ((material = (Material)this.materials.get(b)).id.equalsIgnoreCase(paramString)) return material; 
/*     */       }  }
/* 438 */     else { for (byte b = 0; b < i; b++) {
/* 439 */         Material material; if ((material = (Material)this.materials.get(b)).id.equals(paramString)) return material; 
/*     */       }  }
/* 441 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getNode(String paramString) {
/* 447 */     return getNode(paramString, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getNode(String paramString, boolean paramBoolean) {
/* 454 */     return getNode(paramString, paramBoolean, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getNode(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 462 */     return Node.getNode(this.nodes, paramString, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\Model.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */