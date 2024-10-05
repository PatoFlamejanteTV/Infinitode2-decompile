/*     */ package com.badlogic.gdx.graphics.g3d.decals;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.SortedIntList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DecalBatch
/*     */   implements Disposable
/*     */ {
/*     */   private static final int DEFAULT_SIZE = 1000;
/*     */   private float[] vertices;
/*     */   private Mesh mesh;
/*     */   private GroupStrategy groupStrategy;
/*  57 */   private final SortedIntList<Array<Decal>> groupList = new SortedIntList();
/*     */   
/*  59 */   private final Pool<Array<Decal>> groupPool = new Pool<Array<Decal>>(16)
/*     */     {
/*     */       protected Array<Decal> newObject() {
/*  62 */         return new Array(false, 100);
/*     */       }
/*     */     };
/*  65 */   private final Array<Array<Decal>> usedGroups = new Array(16);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DecalBatch(GroupStrategy paramGroupStrategy) {
/*  71 */     this(1000, paramGroupStrategy);
/*     */   }
/*     */   
/*     */   public DecalBatch(int paramInt, GroupStrategy paramGroupStrategy) {
/*  75 */     initialize(paramInt);
/*  76 */     setGroupStrategy(paramGroupStrategy);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupStrategy(GroupStrategy paramGroupStrategy) {
/*  82 */     this.groupStrategy = paramGroupStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(int paramInt) {
/*  89 */     this.vertices = new float[paramInt * 24];
/*     */     
/*  91 */     Mesh.VertexDataType vertexDataType = Mesh.VertexDataType.VertexArray;
/*  92 */     if (Gdx.gl30 != null) {
/*  93 */       vertexDataType = Mesh.VertexDataType.VertexBufferObjectWithVAO;
/*     */     }
/*  95 */     this.mesh = new Mesh(vertexDataType, false, paramInt << 2, paramInt * 6, new VertexAttribute[] { new VertexAttribute(1, 3, "a_position"), new VertexAttribute(4, 4, "a_color"), new VertexAttribute(16, 2, "a_texCoord0") });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     short[] arrayOfShort = new short[paramInt * 6];
/* 101 */     byte b1 = 0;
/* 102 */     for (byte b2 = 0; b2 < arrayOfShort.length; b2 += 6, b1 += 4) {
/* 103 */       arrayOfShort[b2] = (short)b1;
/* 104 */       arrayOfShort[b2 + 1] = (short)(b1 + 2);
/* 105 */       arrayOfShort[b2 + 2] = (short)(b1 + 1);
/* 106 */       arrayOfShort[b2 + 3] = (short)(b1 + 1);
/* 107 */       arrayOfShort[b2 + 4] = (short)(b1 + 2);
/* 108 */       arrayOfShort[b2 + 5] = (short)(b1 + 3);
/*     */     } 
/* 110 */     this.mesh.setIndices(arrayOfShort);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSize() {
/* 115 */     return this.vertices.length / 24;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Decal paramDecal) {
/* 122 */     int i = this.groupStrategy.decideGroup(paramDecal);
/*     */     Array array;
/* 124 */     if ((array = (Array)this.groupList.get(i)) == null) {
/*     */       
/* 126 */       (array = (Array)this.groupPool.obtain()).clear();
/* 127 */       this.usedGroups.add(array);
/* 128 */       this.groupList.insert(i, array);
/*     */     } 
/* 130 */     array.add(paramDecal);
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() {
/* 135 */     render();
/* 136 */     clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render() {
/* 141 */     this.groupStrategy.beforeGroups();
/* 142 */     for (SortedIntList.Node node : this.groupList) {
/* 143 */       this.groupStrategy.beforeGroup(node.index, (Array<Decal>)node.value);
/* 144 */       ShaderProgram shaderProgram = this.groupStrategy.getGroupShader(node.index);
/* 145 */       render(shaderProgram, (Array<Decal>)node.value);
/* 146 */       this.groupStrategy.afterGroup(node.index);
/*     */     } 
/* 148 */     this.groupStrategy.afterGroups();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void render(ShaderProgram paramShaderProgram, Array<Decal> paramArray) {
/* 156 */     DecalMaterial decalMaterial = null;
/* 157 */     int i = 0;
/* 158 */     for (Array.ArrayIterator<Decal> arrayIterator = paramArray.iterator(); arrayIterator.hasNext(); ) { Decal decal = arrayIterator.next();
/* 159 */       if (decalMaterial == null || !decalMaterial.equals(decal.getMaterial())) {
/* 160 */         if (i) {
/* 161 */           flush(paramShaderProgram, i);
/* 162 */           i = 0;
/*     */         } 
/* 164 */         decal.material.set();
/* 165 */         decalMaterial = decal.material;
/*     */       } 
/* 167 */       decal.update();
/* 168 */       System.arraycopy(decal.vertices, 0, this.vertices, i, decal.vertices.length);
/*     */ 
/*     */       
/* 171 */       if ((i = i + decal.vertices.length) == this.vertices.length) {
/* 172 */         flush(paramShaderProgram, i);
/* 173 */         i = 0;
/*     */       }  }
/*     */ 
/*     */     
/* 177 */     if (i > 0) {
/* 178 */       flush(paramShaderProgram, i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void flush(ShaderProgram paramShaderProgram, int paramInt) {
/* 186 */     this.mesh.setVertices(this.vertices, 0, paramInt);
/* 187 */     this.mesh.render(paramShaderProgram, 4, 0, paramInt / 4);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 192 */     this.groupList.clear();
/* 193 */     this.groupPool.freeAll(this.usedGroups);
/* 194 */     this.usedGroups.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 200 */     clear();
/* 201 */     this.vertices = null;
/* 202 */     this.mesh.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\decals\DecalBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */