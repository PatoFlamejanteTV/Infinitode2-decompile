/*     */ package com.badlogic.gdx.graphics.g3d.loader;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
/*     */ import com.badlogic.gdx.utils.Array;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class MtlLoader
/*     */ {
/* 334 */   public Array<ModelMaterial> materials = new Array();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileHandle paramFileHandle) {
/* 341 */     ObjMaterial objMaterial = new ObjMaterial();
/*     */     
/* 343 */     if (paramFileHandle == null || !paramFileHandle.exists())
/*     */       return; 
/* 345 */     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramFileHandle.read()), 4096); try {
/*     */       String str;
/* 347 */       while ((str = bufferedReader.readLine()) != null) {
/*     */         
/* 349 */         if (str.length() > 0 && str.charAt(0) == '\t') str = str.substring(1).trim();
/*     */ 
/*     */         
/*     */         String[] arrayOfString;
/* 353 */         if ((arrayOfString = str.split("\\s+"))[0].length() != 0)
/*     */         {
/* 355 */           if (arrayOfString[0].charAt(0) != '#') {
/*     */             ModelMaterial modelMaterial1;
/*     */             
/*     */             String str1;
/* 359 */             if ((str1 = arrayOfString[0].toLowerCase()).equals("newmtl")) {
/* 360 */               modelMaterial1 = objMaterial.build();
/* 361 */               this.materials.add(modelMaterial1);
/*     */               
/* 363 */               if (arrayOfString.length > 1) {
/* 364 */                 objMaterial.materialName = arrayOfString[1];
/* 365 */                 objMaterial.materialName = objMaterial.materialName.replace('.', '_');
/*     */               } else {
/* 367 */                 objMaterial.materialName = "default";
/*     */               } 
/*     */               
/* 370 */               objMaterial.reset(); continue;
/* 371 */             }  if (modelMaterial1.equals("ka")) {
/* 372 */               objMaterial.ambientColor = parseColor(arrayOfString); continue;
/* 373 */             }  if (modelMaterial1.equals("kd")) {
/* 374 */               objMaterial.diffuseColor = parseColor(arrayOfString); continue;
/* 375 */             }  if (modelMaterial1.equals("ks")) {
/* 376 */               objMaterial.specularColor = parseColor(arrayOfString); continue;
/* 377 */             }  if (modelMaterial1.equals("tr") || modelMaterial1.equals("d")) {
/* 378 */               objMaterial.opacity = Float.parseFloat(arrayOfString[1]); continue;
/* 379 */             }  if (modelMaterial1.equals("ns")) {
/* 380 */               objMaterial.shininess = Float.parseFloat(arrayOfString[1]); continue;
/* 381 */             }  if (modelMaterial1.equals("map_d")) {
/* 382 */               objMaterial.alphaTexFilename = paramFileHandle.parent().child(arrayOfString[1]).path(); continue;
/* 383 */             }  if (modelMaterial1.equals("map_ka")) {
/* 384 */               objMaterial.ambientTexFilename = paramFileHandle.parent().child(arrayOfString[1]).path(); continue;
/* 385 */             }  if (modelMaterial1.equals("map_kd")) {
/* 386 */               objMaterial.diffuseTexFilename = paramFileHandle.parent().child(arrayOfString[1]).path(); continue;
/* 387 */             }  if (modelMaterial1.equals("map_ks")) {
/* 388 */               objMaterial.specularTexFilename = paramFileHandle.parent().child(arrayOfString[1]).path(); continue;
/* 389 */             }  if (modelMaterial1.equals("map_ns"))
/* 390 */               objMaterial.shininessTexFilename = paramFileHandle.parent().child(arrayOfString[1]).path(); 
/*     */           } 
/*     */         }
/*     */       } 
/* 394 */       bufferedReader.close();
/* 395 */     } catch (IOException iOException) {
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 400 */     ModelMaterial modelMaterial = objMaterial.build();
/* 401 */     this.materials.add(modelMaterial);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Color parseColor(String[] paramArrayOfString) {
/* 407 */     float f1 = Float.parseFloat(paramArrayOfString[1]);
/* 408 */     float f2 = Float.parseFloat(paramArrayOfString[2]);
/* 409 */     float f3 = Float.parseFloat(paramArrayOfString[3]);
/* 410 */     float f4 = 1.0F;
/* 411 */     if (paramArrayOfString.length > 4) {
/* 412 */       f4 = Float.parseFloat(paramArrayOfString[4]);
/*     */     }
/*     */     
/* 415 */     return new Color(f1, f2, f3, f4);
/*     */   }
/*     */   
/*     */   public ModelMaterial getMaterial(String paramString) {
/* 419 */     for (Array.ArrayIterator<ModelMaterial> arrayIterator = this.materials.iterator(); arrayIterator.hasNext();) {
/* 420 */       if ((modelMaterial1 = arrayIterator.next()).id.equals(paramString)) return modelMaterial1; 
/*     */     }  ModelMaterial modelMaterial;
/* 422 */     (modelMaterial = new ModelMaterial()).id = paramString;
/* 423 */     modelMaterial.diffuse = new Color(Color.WHITE);
/* 424 */     this.materials.add(modelMaterial);
/* 425 */     return modelMaterial;
/*     */   }
/*     */   
/*     */   private static class ObjMaterial {
/* 429 */     String materialName = "default";
/*     */     Color ambientColor;
/*     */     Color diffuseColor;
/*     */     Color specularColor;
/*     */     float opacity;
/*     */     float shininess;
/*     */     String alphaTexFilename;
/*     */     String ambientTexFilename;
/*     */     String diffuseTexFilename;
/*     */     String shininessTexFilename;
/*     */     String specularTexFilename;
/*     */     
/*     */     public ObjMaterial() {
/* 442 */       reset();
/*     */     }
/*     */     
/*     */     public ModelMaterial build() {
/*     */       ModelMaterial modelMaterial;
/* 447 */       (modelMaterial = new ModelMaterial()).id = this.materialName;
/* 448 */       modelMaterial.ambient = (this.ambientColor == null) ? null : new Color(this.ambientColor);
/* 449 */       modelMaterial.diffuse = new Color(this.diffuseColor);
/* 450 */       modelMaterial.specular = new Color(this.specularColor);
/* 451 */       modelMaterial.opacity = this.opacity;
/* 452 */       modelMaterial.shininess = this.shininess;
/* 453 */       addTexture(modelMaterial, this.alphaTexFilename, 9);
/* 454 */       addTexture(modelMaterial, this.ambientTexFilename, 4);
/* 455 */       addTexture(modelMaterial, this.diffuseTexFilename, 2);
/* 456 */       addTexture(modelMaterial, this.specularTexFilename, 5);
/* 457 */       addTexture(modelMaterial, this.shininessTexFilename, 6);
/*     */       
/* 459 */       return modelMaterial;
/*     */     }
/*     */     
/*     */     private void addTexture(ModelMaterial param1ModelMaterial, String param1String, int param1Int) {
/* 463 */       if (param1String != null) {
/*     */         ModelTexture modelTexture;
/* 465 */         (modelTexture = new ModelTexture()).usage = param1Int;
/* 466 */         modelTexture.fileName = param1String;
/* 467 */         if (param1ModelMaterial.textures == null) param1ModelMaterial.textures = new Array(1); 
/* 468 */         param1ModelMaterial.textures.add(modelTexture);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void reset() {
/* 473 */       this.ambientColor = null;
/* 474 */       this.diffuseColor = Color.WHITE;
/* 475 */       this.specularColor = Color.WHITE;
/* 476 */       this.opacity = 1.0F;
/* 477 */       this.shininess = 0.0F;
/* 478 */       this.alphaTexFilename = null;
/* 479 */       this.ambientTexFilename = null;
/* 480 */       this.diffuseTexFilename = null;
/* 481 */       this.shininessTexFilename = null;
/* 482 */       this.specularTexFilename = null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\loader\MtlLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */