/*     */ package com.badlogic.gdx.graphics.g3d.loader;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*     */ import com.badlogic.gdx.assets.loaders.ModelLoader;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.Material;
/*     */ import com.badlogic.gdx.graphics.g3d.Model;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelMesh;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelNode;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelNodePart;
/*     */ import com.badlogic.gdx.math.Quaternion;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ObjLoader
/*     */   extends ModelLoader<ObjLoader.ObjLoaderParameters>
/*     */ {
/*     */   public static boolean logWarning = false;
/*     */   
/*     */   public static class ObjLoaderParameters
/*     */     extends ModelLoader.ModelParameters
/*     */   {
/*     */     public boolean flipV;
/*     */     
/*     */     public ObjLoaderParameters() {}
/*     */     
/*     */     public ObjLoaderParameters(boolean param1Boolean) {
/*  80 */       this.flipV = param1Boolean;
/*     */     }
/*     */   }
/*     */   
/*  84 */   final FloatArray verts = new FloatArray(300);
/*  85 */   final FloatArray norms = new FloatArray(300);
/*  86 */   final FloatArray uvs = new FloatArray(200);
/*  87 */   final Array<Group> groups = new Array(10);
/*     */   
/*     */   public ObjLoader() {
/*  90 */     this(null);
/*     */   }
/*     */   
/*     */   public ObjLoader(FileHandleResolver paramFileHandleResolver) {
/*  94 */     super(paramFileHandleResolver);
/*     */   }
/*     */ 
/*     */   
/*     */   public Model loadModel(FileHandle paramFileHandle, boolean paramBoolean) {
/*  99 */     return loadModel(paramFileHandle, new ObjLoaderParameters(paramBoolean));
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelData loadModelData(FileHandle paramFileHandle, ObjLoaderParameters paramObjLoaderParameters) {
/* 104 */     return loadModelData(paramFileHandle, (paramObjLoaderParameters != null && paramObjLoaderParameters.flipV));
/*     */   }
/*     */   
/*     */   protected ModelData loadModelData(FileHandle paramFileHandle, boolean paramBoolean) {
/* 108 */     if (logWarning) {
/* 109 */       Gdx.app.error("ObjLoader", "Wavefront (OBJ) is not fully supported, consult the documentation for more information");
/*     */     }
/*     */ 
/*     */     
/* 113 */     MtlLoader mtlLoader = new MtlLoader();
/*     */ 
/*     */ 
/*     */     
/* 117 */     Group group = new Group("default");
/* 118 */     this.groups.add(group);
/*     */     
/* 120 */     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramFileHandle.read()), 4096);
/* 121 */     byte b1 = 0; try {
/*     */       String str;
/* 123 */       while ((str = bufferedReader.readLine()) != null) {
/*     */         String[] arrayOfString;
/*     */         
/* 126 */         if ((arrayOfString = str.split("\\s+")).length <= 0)
/*     */           break; 
/* 128 */         if (arrayOfString[0].length() != 0) {
/*     */           char c;
/* 130 */           if ((c = arrayOfString[0].toLowerCase().charAt(0)) != '#') {
/*     */             String[] arrayOfString1;
/* 132 */             if (c == 'v') {
/* 133 */               if (arrayOfString[0].length() == 1) {
/* 134 */                 this.verts.add(Float.parseFloat(arrayOfString[1]));
/* 135 */                 this.verts.add(Float.parseFloat(arrayOfString[2]));
/* 136 */                 this.verts.add(Float.parseFloat(arrayOfString[3])); continue;
/* 137 */               }  if (arrayOfString[0].charAt(1) == 'n') {
/* 138 */                 this.norms.add(Float.parseFloat(arrayOfString[1]));
/* 139 */                 this.norms.add(Float.parseFloat(arrayOfString[2]));
/* 140 */                 this.norms.add(Float.parseFloat(arrayOfString[3])); continue;
/* 141 */               }  if (arrayOfString[0].charAt(1) == 't') {
/* 142 */                 this.uvs.add(Float.parseFloat(arrayOfString[1]));
/* 143 */                 this.uvs.add(paramBoolean ? (1.0F - Float.parseFloat(arrayOfString[2])) : Float.parseFloat(arrayOfString[2]));
/*     */               }  continue;
/* 145 */             }  if (c == 'f') {
/*     */               
/* 147 */               Array<Integer> array = group.faces;
/* 148 */               for (byte b = 1; b < arrayOfString.length - 2; b--) {
/* 149 */                 arrayOfString1 = arrayOfString[1].split("/");
/* 150 */                 array.add(Integer.valueOf(getIndex(arrayOfString1[0], this.verts.size)));
/* 151 */                 if (arrayOfString1.length > 2) {
/* 152 */                   if (b == 1) group.hasNorms = true; 
/* 153 */                   array.add(Integer.valueOf(getIndex(arrayOfString1[2], this.norms.size)));
/*     */                 } 
/* 155 */                 if (arrayOfString1.length > 1 && arrayOfString1[1].length() > 0) {
/* 156 */                   if (b == 1) group.hasUVs = true; 
/* 157 */                   array.add(Integer.valueOf(getIndex(arrayOfString1[1], this.uvs.size)));
/*     */                 } 
/* 159 */                 arrayOfString1 = arrayOfString[++b].split("/");
/* 160 */                 array.add(Integer.valueOf(getIndex(arrayOfString1[0], this.verts.size)));
/* 161 */                 if (arrayOfString1.length > 2) array.add(Integer.valueOf(getIndex(arrayOfString1[2], this.norms.size))); 
/* 162 */                 if (arrayOfString1.length > 1 && arrayOfString1[1].length() > 0) array.add(Integer.valueOf(getIndex(arrayOfString1[1], this.uvs.size))); 
/* 163 */                 arrayOfString1 = arrayOfString[++b].split("/");
/* 164 */                 array.add(Integer.valueOf(getIndex(arrayOfString1[0], this.verts.size)));
/* 165 */                 if (arrayOfString1.length > 2) array.add(Integer.valueOf(getIndex(arrayOfString1[2], this.norms.size))); 
/* 166 */                 if (arrayOfString1.length > 1 && arrayOfString1[1].length() > 0) array.add(Integer.valueOf(getIndex(arrayOfString1[1], this.uvs.size))); 
/* 167 */                 group.numFaces++;
/*     */               }  continue;
/* 169 */             }  if (arrayOfString1 == 111 || arrayOfString1 == 103) {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 174 */               if (arrayOfString.length > 1) {
/* 175 */                 group = setActiveGroup(arrayOfString[1]); continue;
/*     */               } 
/* 177 */               group = setActiveGroup("default"); continue;
/* 178 */             }  if (arrayOfString[0].equals("mtllib")) {
/* 179 */               mtlLoader.load(paramFileHandle.parent().child(arrayOfString[1])); continue;
/* 180 */             }  if (arrayOfString[0].equals("usemtl"))
/* 181 */             { if (arrayOfString.length == 1) {
/* 182 */                 group.materialName = "default"; continue;
/*     */               } 
/* 184 */               group.materialName = arrayOfString[1].replace('.', '_'); } 
/*     */           } 
/*     */         } 
/* 187 */       }  bufferedReader.close();
/* 188 */     } catch (IOException iOException) {
/* 189 */       return null;
/*     */     } 
/*     */     
/*     */     int i;
/* 193 */     for (i = 0; i < this.groups.size; i++) {
/* 194 */       if (((Group)this.groups.get(i)).numFaces <= 0) {
/* 195 */         this.groups.removeIndex(i);
/* 196 */         i--;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 201 */     if (this.groups.size <= 0) return null;
/*     */ 
/*     */     
/* 204 */     i = this.groups.size;
/*     */     
/* 206 */     ModelData modelData = new ModelData();
/*     */     
/* 208 */     for (byte b2 = 0; b2 < i; b2++) {
/*     */       Group group1;
/*     */       Array<Integer> array;
/* 211 */       int j = (array = (group1 = (Group)this.groups.get(b2)).faces).size;
/* 212 */       int k = group1.numFaces;
/* 213 */       boolean bool1 = group1.hasNorms;
/* 214 */       boolean bool2 = group1.hasUVs;
/*     */       
/* 216 */       float[] arrayOfFloat = new float[k * 3 * (3 + (bool1 ? 3 : 0) + (bool2 ? 2 : 0))];
/*     */       byte b3, b4;
/* 218 */       for (b3 = 0, b4 = 0; b3 < j; ) {
/* 219 */         int m = ((Integer)array.get(b3++)).intValue() * 3;
/* 220 */         arrayOfFloat[b4++] = this.verts.get(m++);
/* 221 */         arrayOfFloat[b4++] = this.verts.get(m++);
/* 222 */         arrayOfFloat[b4++] = this.verts.get(m);
/* 223 */         if (bool1) {
/* 224 */           int n = ((Integer)array.get(b3++)).intValue() * 3;
/* 225 */           arrayOfFloat[b4++] = this.norms.get(n++);
/* 226 */           arrayOfFloat[b4++] = this.norms.get(n++);
/* 227 */           arrayOfFloat[b4++] = this.norms.get(n);
/*     */         } 
/* 229 */         if (bool2) {
/* 230 */           int n = ((Integer)array.get(b3++)).intValue() << 1;
/* 231 */           arrayOfFloat[b4++] = this.uvs.get(n++);
/* 232 */           arrayOfFloat[b4++] = this.uvs.get(n);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 237 */       short[] arrayOfShort = new short[b3 = (k * 3 >= 32767) ? 0 : (k * 3)];
/*     */       
/* 239 */       if (b3 > 0) {
/* 240 */         for (byte b = 0; b < b3; b++) {
/* 241 */           arrayOfShort[b] = (short)b;
/*     */         }
/*     */       }
/*     */       
/*     */       Array array1;
/* 246 */       (array1 = new Array()).add(new VertexAttribute(1, 3, "a_position"));
/* 247 */       if (bool1) array1.add(new VertexAttribute(8, 3, "a_normal")); 
/* 248 */       if (bool2) array1.add(new VertexAttribute(16, 2, "a_texCoord0"));
/*     */       
/* 250 */       String str4 = Integer.toString(++b1);
/* 251 */       String str1 = "default".equals(group1.name) ? ("node" + str4) : group1.name;
/* 252 */       String str2 = "default".equals(group1.name) ? ("mesh" + str4) : group1.name;
/* 253 */       String str3 = "default".equals(group1.name) ? ("part" + str4) : group1.name;
/*     */       ModelNode modelNode;
/* 255 */       (modelNode = new ModelNode()).id = str1;
/* 256 */       modelNode.meshId = str2;
/* 257 */       modelNode.scale = new Vector3(1.0F, 1.0F, 1.0F);
/* 258 */       modelNode.translation = new Vector3();
/* 259 */       modelNode.rotation = new Quaternion();
/*     */       ModelNodePart modelNodePart;
/* 261 */       (modelNodePart = new ModelNodePart()).meshPartId = str3;
/* 262 */       modelNodePart.materialId = group1.materialName;
/* 263 */       modelNode.parts = new ModelNodePart[] { modelNodePart };
/*     */       ModelMeshPart modelMeshPart;
/* 265 */       (modelMeshPart = new ModelMeshPart()).id = str3;
/* 266 */       modelMeshPart.indices = arrayOfShort;
/* 267 */       modelMeshPart.primitiveType = 4;
/*     */       ModelMesh modelMesh;
/* 269 */       (modelMesh = new ModelMesh()).id = str2;
/* 270 */       modelMesh.attributes = (VertexAttribute[])array1.toArray(VertexAttribute.class);
/* 271 */       modelMesh.vertices = arrayOfFloat;
/* 272 */       modelMesh.parts = new ModelMeshPart[] { modelMeshPart };
/* 273 */       modelData.nodes.add(modelNode);
/* 274 */       modelData.meshes.add(modelMesh);
/* 275 */       ModelMaterial modelMaterial = mtlLoader.getMaterial(group1.materialName);
/* 276 */       modelData.materials.add(modelMaterial);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     if (this.verts.size > 0) this.verts.clear(); 
/* 287 */     if (this.norms.size > 0) this.norms.clear(); 
/* 288 */     if (this.uvs.size > 0) this.uvs.clear(); 
/* 289 */     if (this.groups.size > 0) this.groups.clear();
/*     */     
/* 291 */     return modelData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Group setActiveGroup(String paramString) {
/* 297 */     for (Array.ArrayIterator<Group> arrayIterator = this.groups.iterator(); arrayIterator.hasNext();) {
/* 298 */       if ((group1 = arrayIterator.next()).name.equals(paramString)) return group1; 
/*     */     } 
/* 300 */     Group group = new Group(paramString);
/* 301 */     this.groups.add(group);
/* 302 */     return group;
/*     */   }
/*     */   
/*     */   private int getIndex(String paramString, int paramInt) {
/* 306 */     if (paramString == null || paramString.length() == 0) return 0; 
/*     */     int i;
/* 308 */     if ((i = Integer.parseInt(paramString)) < 0) {
/* 309 */       return paramInt + i;
/*     */     }
/* 311 */     return i - 1;
/*     */   }
/*     */   
/*     */   private static class Group {
/*     */     final String name;
/*     */     String materialName;
/*     */     Array<Integer> faces;
/*     */     int numFaces;
/*     */     boolean hasNorms;
/*     */     boolean hasUVs;
/*     */     Material mat;
/*     */     
/*     */     Group(String param1String) {
/* 324 */       this.name = param1String;
/* 325 */       this.faces = new Array(200);
/* 326 */       this.numFaces = 0;
/* 327 */       this.mat = new Material("");
/* 328 */       this.materialName = "default";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\loader\ObjLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */