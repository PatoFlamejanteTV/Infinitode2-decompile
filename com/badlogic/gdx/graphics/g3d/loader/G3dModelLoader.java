/*     */ package com.badlogic.gdx.graphics.g3d.loader;
/*     */ 
/*     */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*     */ import com.badlogic.gdx.assets.loaders.ModelLoader;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
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
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Quaternion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ArrayMap;
/*     */ import com.badlogic.gdx.utils.BaseJsonReader;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.JsonValue;
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
/*     */ public class G3dModelLoader
/*     */   extends ModelLoader<ModelLoader.ModelParameters>
/*     */ {
/*     */   public static final short VERSION_HI = 0;
/*     */   public static final short VERSION_LO = 1;
/*     */   protected final BaseJsonReader reader;
/*     */   protected final Quaternion tempQ;
/*     */   
/*     */   public G3dModelLoader(BaseJsonReader paramBaseJsonReader) {
/*  51 */     this(paramBaseJsonReader, null);
/*     */   }
/*     */   public ModelData loadModelData(FileHandle paramFileHandle, ModelLoader.ModelParameters paramModelParameters) { return parseModel(paramFileHandle); }
/*     */   public ModelData parseModel(FileHandle paramFileHandle) { JsonValue jsonValue1 = this.reader.parse(paramFileHandle); ModelData modelData = new ModelData(); JsonValue jsonValue2 = jsonValue1.require("version"); modelData.version[0] = jsonValue2.getShort(0); modelData.version[1] = jsonValue2.getShort(1); if (modelData.version[0] != 0 || modelData.version[1] != 1) throw new GdxRuntimeException("Model version not supported");  modelData.id = jsonValue1.getString("id", ""); parseMeshes(modelData, jsonValue1); parseMaterials(modelData, jsonValue1, paramFileHandle.parent().path()); parseNodes(modelData, jsonValue1); parseAnimations(modelData, jsonValue1); return modelData; } protected void parseMeshes(ModelData paramModelData, JsonValue paramJsonValue) { if ((paramJsonValue = paramJsonValue.get("meshes")) != null) { paramModelData.meshes.ensureCapacity(paramJsonValue.size); for (paramJsonValue = paramJsonValue.child; paramJsonValue != null; paramJsonValue = paramJsonValue.next) { ModelMesh modelMesh = new ModelMesh(); String str = paramJsonValue.getString("id", ""); modelMesh.id = str; JsonValue jsonValue = paramJsonValue.require("attributes"); modelMesh.attributes = parseAttributes(jsonValue); modelMesh.vertices = paramJsonValue.require("vertices").asFloatArray(); jsonValue = paramJsonValue.require("parts"); Array array = new Array(); for (jsonValue = jsonValue.child; jsonValue != null; jsonValue = jsonValue.next) { ModelMeshPart modelMeshPart = new ModelMeshPart(); String str1; if ((str1 = jsonValue.getString("id", null)) == null) throw new GdxRuntimeException("Not id given for mesh part");  for (Array.ArrayIterator<ModelMeshPart> arrayIterator = array.iterator(); arrayIterator.hasNext();) { if ((modelMeshPart1 = arrayIterator.next()).id.equals(str1)) throw new GdxRuntimeException("Mesh part with id '" + str1 + "' already in defined");  }  modelMeshPart.id = str1; String str2; if ((str2 = jsonValue.getString("type", null)) == null)
/*  55 */             throw new GdxRuntimeException("No primitive type given for mesh part '" + str1 + "'");  modelMeshPart.primitiveType = parseType(str2); modelMeshPart.indices = jsonValue.require("indices").asShortArray(); array.add(modelMeshPart); }  modelMesh.parts = (ModelMeshPart[])array.toArray(ModelMeshPart.class); paramModelData.meshes.add(modelMesh); }  }  } public G3dModelLoader(BaseJsonReader paramBaseJsonReader, FileHandleResolver paramFileHandleResolver) { super(paramFileHandleResolver);
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
/* 288 */     this.tempQ = new Quaternion(); this.reader = paramBaseJsonReader; }
/*     */   protected int parseType(String paramString) { if (paramString.equals("TRIANGLES")) return 4;  if (paramString.equals("LINES")) return 1;  if (paramString.equals("POINTS")) return 0;  if (paramString.equals("TRIANGLE_STRIP")) return 5;  if (paramString.equals("LINE_STRIP"))
/*     */       return 3;  throw new GdxRuntimeException("Unknown primitive type '" + paramString + "', should be one of triangle, trianglestrip, line, linestrip or point"); }
/* 291 */   protected VertexAttribute[] parseAttributes(JsonValue paramJsonValue) { Array array = new Array(); byte b1 = 0; byte b2 = 0; for (paramJsonValue = paramJsonValue.child; paramJsonValue != null; paramJsonValue = paramJsonValue.next) { String str; if ((str = str = paramJsonValue.asString()).equals("POSITION")) { array.add(VertexAttribute.Position()); } else if (str.equals("NORMAL")) { array.add(VertexAttribute.Normal()); } else if (str.equals("COLOR")) { array.add(VertexAttribute.ColorUnpacked()); } else if (str.equals("COLORPACKED")) { array.add(VertexAttribute.ColorPacked()); } else if (str.equals("TANGENT")) { array.add(VertexAttribute.Tangent()); } else if (str.equals("BINORMAL")) { array.add(VertexAttribute.Binormal()); } else if (str.startsWith("TEXCOORD")) { array.add(VertexAttribute.TexCoords(b1++)); } else if (str.startsWith("BLENDWEIGHT")) { array.add(VertexAttribute.BoneWeight(b2++)); } else { throw new GdxRuntimeException("Unknown vertex attribute '" + str + "', should be one of position, normal, uv, tangent or binormal"); }  }  return (VertexAttribute[])array.toArray(VertexAttribute.class); } protected ModelNode parseNodesRecursively(JsonValue paramJsonValue) { ModelNode modelNode = new ModelNode();
/*     */     
/*     */     String str1;
/* 294 */     if ((str1 = paramJsonValue.getString("id", null)) == null) throw new GdxRuntimeException("Node id missing."); 
/* 295 */     modelNode.id = str1;
/*     */     
/*     */     JsonValue jsonValue2;
/* 298 */     if ((jsonValue2 = paramJsonValue.get("translation")) != null && jsonValue2.size != 3) throw new GdxRuntimeException("Node translation incomplete"); 
/* 299 */     modelNode
/* 300 */       .translation = (jsonValue2 == null) ? null : new Vector3(jsonValue2.getFloat(0), jsonValue2.getFloat(1), jsonValue2.getFloat(2));
/*     */ 
/*     */     
/* 303 */     if ((jsonValue2 = paramJsonValue.get("rotation")) != null && jsonValue2.size != 4) throw new GdxRuntimeException("Node rotation incomplete"); 
/* 304 */     modelNode
/* 305 */       .rotation = (jsonValue2 == null) ? null : new Quaternion(jsonValue2.getFloat(0), jsonValue2.getFloat(1), jsonValue2.getFloat(2), jsonValue2.getFloat(3));
/*     */ 
/*     */     
/* 308 */     if ((jsonValue2 = paramJsonValue.get("scale")) != null && jsonValue2.size != 3) throw new GdxRuntimeException("Node scale incomplete"); 
/* 309 */     modelNode.scale = (jsonValue2 == null) ? null : new Vector3(jsonValue2.getFloat(0), jsonValue2.getFloat(1), jsonValue2.getFloat(2));
/*     */     
/*     */     String str2;
/* 312 */     if ((str2 = paramJsonValue.getString("mesh", null)) != null) modelNode.meshId = str2;
/*     */     
/*     */     JsonValue jsonValue1;
/* 315 */     if ((jsonValue1 = paramJsonValue.get("parts")) != null) {
/* 316 */       modelNode.parts = new ModelNodePart[jsonValue1.size];
/* 317 */       byte b = 0;
/* 318 */       for (jsonValue1 = jsonValue1.child; jsonValue1 != null; jsonValue1 = jsonValue1.next, b++) {
/* 319 */         ModelNodePart modelNodePart = new ModelNodePart();
/*     */         
/* 321 */         String str3 = jsonValue1.getString("meshpartid", null);
/* 322 */         String str4 = jsonValue1.getString("materialid", null);
/* 323 */         if (str3 == null || str4 == null) {
/* 324 */           throw new GdxRuntimeException("Node " + str1 + " part is missing meshPartId or materialId");
/*     */         }
/* 326 */         modelNodePart.materialId = str4;
/* 327 */         modelNodePart.meshPartId = str3;
/*     */         
/*     */         JsonValue jsonValue;
/* 330 */         if ((jsonValue = jsonValue1.get("bones")) != null) {
/* 331 */           modelNodePart.bones = new ArrayMap(true, jsonValue.size, String.class, Matrix4.class);
/*     */           
/* 333 */           for (jsonValue = jsonValue.child; jsonValue != null; jsonValue = jsonValue.next) {
/*     */             
/* 335 */             if ((str4 = jsonValue.getString("node", null)) == null) throw new GdxRuntimeException("Bone node ID missing");
/*     */             
/* 337 */             Matrix4 matrix4 = new Matrix4();
/*     */             
/*     */             JsonValue jsonValue4;
/* 340 */             if ((jsonValue4 = jsonValue.get("translation")) != null && jsonValue4.size >= 3) matrix4.translate(jsonValue4.getFloat(0), jsonValue4.getFloat(1), jsonValue4.getFloat(2));
/*     */ 
/*     */             
/* 343 */             if ((jsonValue4 = jsonValue.get("rotation")) != null && jsonValue4.size >= 4) {
/* 344 */               matrix4.rotate(this.tempQ.set(jsonValue4.getFloat(0), jsonValue4.getFloat(1), jsonValue4.getFloat(2), jsonValue4.getFloat(3)));
/*     */             }
/*     */             
/* 347 */             if ((jsonValue4 = jsonValue.get("scale")) != null && jsonValue4.size >= 3) matrix4.scale(jsonValue4.getFloat(0), jsonValue4.getFloat(1), jsonValue4.getFloat(2));
/*     */             
/* 349 */             modelNodePart.bones.put(str4, matrix4);
/*     */           } 
/*     */         } 
/*     */         
/* 353 */         modelNode.parts[b] = modelNodePart;
/*     */       } 
/*     */     } 
/*     */     
/*     */     JsonValue jsonValue3;
/* 358 */     if ((jsonValue3 = paramJsonValue.get("children")) != null) {
/* 359 */       modelNode.children = new ModelNode[jsonValue3.size];
/*     */       
/* 361 */       byte b = 0;
/* 362 */       for (JsonValue jsonValue = jsonValue3.child; jsonValue != null; jsonValue = jsonValue.next, b++) {
/* 363 */         modelNode.children[b] = parseNodesRecursively(jsonValue);
/*     */       }
/*     */     } 
/*     */     
/* 367 */     return modelNode; } protected void parseMaterials(ModelData paramModelData, JsonValue paramJsonValue, String paramString) { if ((paramJsonValue = paramJsonValue.get("materials")) != null) { paramModelData.materials.ensureCapacity(paramJsonValue.size); for (paramJsonValue = paramJsonValue.child; paramJsonValue != null; paramJsonValue = paramJsonValue.next) { ModelMaterial modelMaterial = new ModelMaterial(); String str; if ((str = paramJsonValue.getString("id", null)) == null) throw new GdxRuntimeException("Material needs an id.");  modelMaterial.id = str; JsonValue jsonValue; if ((jsonValue = paramJsonValue.get("diffuse")) != null) modelMaterial.diffuse = parseColor(jsonValue);  if ((jsonValue = paramJsonValue.get("ambient")) != null) modelMaterial.ambient = parseColor(jsonValue);  if ((jsonValue = paramJsonValue.get("emissive")) != null) modelMaterial.emissive = parseColor(jsonValue);  if ((jsonValue = paramJsonValue.get("specular")) != null) modelMaterial.specular = parseColor(jsonValue);  if ((jsonValue = paramJsonValue.get("reflection")) != null) modelMaterial.reflection = parseColor(jsonValue);  modelMaterial.shininess = paramJsonValue.getFloat("shininess", 0.0F); modelMaterial.opacity = paramJsonValue.getFloat("opacity", 1.0F); if ((jsonValue = paramJsonValue.get("textures")) != null) for (jsonValue = jsonValue.child; jsonValue != null; jsonValue = jsonValue.next) { ModelTexture modelTexture = new ModelTexture(); String str1; if ((str1 = jsonValue.getString("id", null)) == null) throw new GdxRuntimeException("Texture has no id.");  modelTexture.id = str1; if ((str1 = jsonValue.getString("filename", null)) == null) throw new GdxRuntimeException("Texture needs filename.");  modelTexture.fileName = paramString + ((paramString.length() == 0 || paramString.endsWith("/")) ? "" : "/") + str1; modelTexture.uvTranslation = readVector2(jsonValue.get("uvTranslation"), 0.0F, 0.0F); modelTexture.uvScaling = readVector2(jsonValue.get("uvScaling"), 1.0F, 1.0F); if ((str1 = jsonValue.getString("type", null)) == null) throw new GdxRuntimeException("Texture needs type.");  modelTexture.usage = parseTextureUsage(str1); if (modelMaterial.textures == null) modelMaterial.textures = new Array();  modelMaterial.textures.add(modelTexture); }   paramModelData.materials.add(modelMaterial); }  }  }
/*     */   protected int parseTextureUsage(String paramString) { if (paramString.equalsIgnoreCase("AMBIENT")) return 4;  if (paramString.equalsIgnoreCase("BUMP")) return 8;  if (paramString.equalsIgnoreCase("DIFFUSE")) return 2;  if (paramString.equalsIgnoreCase("EMISSIVE")) return 3;  if (paramString.equalsIgnoreCase("NONE")) return 1;  if (paramString.equalsIgnoreCase("NORMAL")) return 7;  if (paramString.equalsIgnoreCase("REFLECTION")) return 10;  if (paramString.equalsIgnoreCase("SHININESS")) return 6;  if (paramString.equalsIgnoreCase("SPECULAR")) return 5;  if (paramString.equalsIgnoreCase("TRANSPARENCY")) return 9;  return 0; }
/*     */   protected Color parseColor(JsonValue paramJsonValue) { if (paramJsonValue.size >= 3) return new Color(paramJsonValue.getFloat(0), paramJsonValue.getFloat(1), paramJsonValue.getFloat(2), 1.0F);  throw new GdxRuntimeException("Expected Color values <> than three."); }
/*     */   protected Vector2 readVector2(JsonValue paramJsonValue, float paramFloat1, float paramFloat2) { if (paramJsonValue == null) return new Vector2(paramFloat1, paramFloat2);  if (paramJsonValue.size == 2) return new Vector2(paramJsonValue.getFloat(0), paramJsonValue.getFloat(1));  throw new GdxRuntimeException("Expected Vector2 values <> than two."); }
/*     */   protected Array<ModelNode> parseNodes(ModelData paramModelData, JsonValue paramJsonValue) { if ((paramJsonValue = paramJsonValue.get("nodes")) != null) { paramModelData.nodes.ensureCapacity(paramJsonValue.size); for (paramJsonValue = paramJsonValue.child; paramJsonValue != null; paramJsonValue = paramJsonValue.next) paramModelData.nodes.add(parseNodesRecursively(paramJsonValue));  }  return paramModelData.nodes; }
/* 372 */   protected void parseAnimations(ModelData paramModelData, JsonValue paramJsonValue) { if ((paramJsonValue = paramJsonValue.get("animations")) == null)
/*     */       return; 
/* 374 */     paramModelData.animations.ensureCapacity(paramJsonValue.size);
/*     */     
/* 376 */     for (paramJsonValue = paramJsonValue.child; paramJsonValue != null; paramJsonValue = paramJsonValue.next) {
/*     */       JsonValue jsonValue;
/* 378 */       if ((jsonValue = paramJsonValue.get("bones")) != null) {
/* 379 */         ModelAnimation modelAnimation = new ModelAnimation();
/* 380 */         paramModelData.animations.add(modelAnimation);
/* 381 */         modelAnimation.nodeAnimations.ensureCapacity(jsonValue.size);
/* 382 */         modelAnimation.id = paramJsonValue.getString("id");
/* 383 */         for (jsonValue = jsonValue.child; jsonValue != null; jsonValue = jsonValue.next) {
/* 384 */           ModelNodeAnimation modelNodeAnimation = new ModelNodeAnimation();
/* 385 */           modelAnimation.nodeAnimations.add(modelNodeAnimation);
/* 386 */           modelNodeAnimation.nodeId = jsonValue.getString("boneId");
/*     */           
/*     */           JsonValue jsonValue1;
/*     */           
/* 390 */           if ((jsonValue1 = jsonValue.get("keyframes")) != null && jsonValue1.isArray()) {
/* 391 */             for (jsonValue1 = jsonValue1.child; jsonValue1 != null; jsonValue1 = jsonValue1.next) {
/* 392 */               float f = jsonValue1.getFloat("keytime", 0.0F) / 1000.0F;
/*     */               JsonValue jsonValue2;
/* 394 */               if ((jsonValue2 = jsonValue1.get("translation")) != null && jsonValue2.size == 3) {
/* 395 */                 if (modelNodeAnimation.translation == null) modelNodeAnimation.translation = new Array(); 
/*     */                 ModelNodeKeyframe modelNodeKeyframe;
/* 397 */                 (modelNodeKeyframe = new ModelNodeKeyframe()).keytime = f;
/* 398 */                 modelNodeKeyframe.value = new Vector3(jsonValue2.getFloat(0), jsonValue2.getFloat(1), jsonValue2.getFloat(2));
/* 399 */                 modelNodeAnimation.translation.add(modelNodeKeyframe);
/*     */               } 
/*     */               JsonValue jsonValue3;
/* 402 */               if ((jsonValue3 = jsonValue1.get("rotation")) != null && jsonValue3.size == 4) {
/* 403 */                 if (modelNodeAnimation.rotation == null) modelNodeAnimation.rotation = new Array(); 
/*     */                 ModelNodeKeyframe modelNodeKeyframe;
/* 405 */                 (modelNodeKeyframe = new ModelNodeKeyframe()).keytime = f;
/* 406 */                 modelNodeKeyframe
/* 407 */                   .value = new Quaternion(jsonValue3.getFloat(0), jsonValue3.getFloat(1), jsonValue3.getFloat(2), jsonValue3.getFloat(3));
/* 408 */                 modelNodeAnimation.rotation.add(modelNodeKeyframe);
/*     */               } 
/*     */               JsonValue jsonValue4;
/* 411 */               if ((jsonValue4 = jsonValue1.get("scale")) != null && jsonValue4.size == 3) {
/* 412 */                 if (modelNodeAnimation.scaling == null) modelNodeAnimation.scaling = new Array(); 
/*     */                 ModelNodeKeyframe modelNodeKeyframe;
/* 414 */                 (modelNodeKeyframe = new ModelNodeKeyframe()).keytime = f;
/* 415 */                 modelNodeKeyframe.value = new Vector3(jsonValue4.getFloat(0), jsonValue4.getFloat(1), jsonValue4.getFloat(2));
/* 416 */                 modelNodeAnimation.scaling.add(modelNodeKeyframe);
/*     */               } 
/*     */             } 
/*     */           } else {
/*     */             
/* 421 */             if ((jsonValue1 = jsonValue.get("translation")) != null && jsonValue1.isArray()) {
/* 422 */               modelNodeAnimation.translation = new Array();
/* 423 */               modelNodeAnimation.translation.ensureCapacity(jsonValue1.size);
/* 424 */               for (JsonValue jsonValue4 = jsonValue1.child; jsonValue4 != null; jsonValue4 = jsonValue4.next) {
/* 425 */                 ModelNodeKeyframe modelNodeKeyframe = new ModelNodeKeyframe();
/* 426 */                 modelNodeAnimation.translation.add(modelNodeKeyframe);
/* 427 */                 modelNodeKeyframe.keytime = jsonValue4.getFloat("keytime", 0.0F) / 1000.0F;
/*     */                 JsonValue jsonValue5;
/* 429 */                 if ((jsonValue5 = jsonValue4.get("value")) != null && jsonValue5.size >= 3) {
/* 430 */                   modelNodeKeyframe.value = new Vector3(jsonValue5.getFloat(0), jsonValue5.getFloat(1), jsonValue5.getFloat(2));
/*     */                 }
/*     */               } 
/*     */             } 
/*     */             JsonValue jsonValue2;
/* 435 */             if ((jsonValue2 = jsonValue.get("rotation")) != null && jsonValue2.isArray()) {
/* 436 */               modelNodeAnimation.rotation = new Array();
/* 437 */               modelNodeAnimation.rotation.ensureCapacity(jsonValue2.size);
/* 438 */               for (JsonValue jsonValue4 = jsonValue2.child; jsonValue4 != null; jsonValue4 = jsonValue4.next) {
/* 439 */                 ModelNodeKeyframe modelNodeKeyframe = new ModelNodeKeyframe();
/* 440 */                 modelNodeAnimation.rotation.add(modelNodeKeyframe);
/* 441 */                 modelNodeKeyframe.keytime = jsonValue4.getFloat("keytime", 0.0F) / 1000.0F;
/*     */                 JsonValue jsonValue5;
/* 443 */                 if ((jsonValue5 = jsonValue4.get("value")) != null && jsonValue5.size >= 4) modelNodeKeyframe
/* 444 */                     .value = new Quaternion(jsonValue5.getFloat(0), jsonValue5.getFloat(1), jsonValue5.getFloat(2), jsonValue5.getFloat(3));
/*     */               
/*     */               } 
/*     */             } 
/*     */             JsonValue jsonValue3;
/* 449 */             if ((jsonValue3 = jsonValue.get("scaling")) != null && jsonValue3.isArray()) {
/* 450 */               modelNodeAnimation.scaling = new Array();
/* 451 */               modelNodeAnimation.scaling.ensureCapacity(jsonValue3.size);
/* 452 */               for (JsonValue jsonValue4 = jsonValue3.child; jsonValue4 != null; jsonValue4 = jsonValue4.next) {
/* 453 */                 ModelNodeKeyframe modelNodeKeyframe = new ModelNodeKeyframe();
/* 454 */                 modelNodeAnimation.scaling.add(modelNodeKeyframe);
/* 455 */                 modelNodeKeyframe.keytime = jsonValue4.getFloat("keytime", 0.0F) / 1000.0F;
/*     */                 
/* 457 */                 if ((jsonValue3 = jsonValue4.get("value")) != null && jsonValue3.size >= 3)
/* 458 */                   modelNodeKeyframe.value = new Vector3(jsonValue3.getFloat(0), jsonValue3.getFloat(1), jsonValue3.getFloat(2)); 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }  }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\loader\G3dModelLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */