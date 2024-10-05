/*     */ package com.badlogic.gdx.graphics.g3d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.VertexAttributes;
/*     */ import com.badlogic.gdx.graphics.g3d.model.MeshPart;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.RenderableSorter;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.FlushablePool;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelCache
/*     */   implements RenderableProvider, Disposable
/*     */ {
/*     */   public static class SimpleMeshPool
/*     */     implements MeshPool
/*     */   {
/*  62 */     private Array<Mesh> freeMeshes = new Array();
/*  63 */     private Array<Mesh> usedMeshes = new Array();
/*     */ 
/*     */     
/*     */     public void flush() {
/*  67 */       this.freeMeshes.addAll(this.usedMeshes);
/*  68 */       this.usedMeshes.clear();
/*     */     }
/*     */     public Mesh obtain(VertexAttributes param1VertexAttributes, int param1Int1, int param1Int2) {
/*     */       byte b;
/*     */       int i;
/*  73 */       for (b = 0, i = this.freeMeshes.size; b < i; b++) {
/*     */         Mesh mesh1;
/*  75 */         if ((mesh1 = (Mesh)this.freeMeshes.get(b)).getVertexAttributes().equals(param1VertexAttributes) && mesh1.getMaxVertices() >= param1Int1 && mesh1
/*  76 */           .getMaxIndices() >= param1Int2) {
/*  77 */           this.freeMeshes.removeIndex(b);
/*  78 */           this.usedMeshes.add(mesh1);
/*  79 */           return mesh1;
/*     */         } 
/*     */       } 
/*     */       
/*  83 */       param1Int2 = Math.max(65536, 1 << 32 - Integer.numberOfLeadingZeros(param1Int2 - 1));
/*  84 */       Mesh mesh = new Mesh(false, 65536, param1Int2, param1VertexAttributes);
/*  85 */       this.usedMeshes.add(mesh);
/*  86 */       return mesh;
/*     */     }
/*     */     
/*     */     public void dispose() {
/*     */       Array.ArrayIterator<Mesh> arrayIterator;
/*  91 */       for (arrayIterator = this.usedMeshes.iterator(); arrayIterator.hasNext();)
/*  92 */         (mesh = arrayIterator.next()).dispose(); 
/*  93 */       this.usedMeshes.clear();
/*  94 */       for (arrayIterator = this.freeMeshes.iterator(); arrayIterator.hasNext();)
/*  95 */         (mesh = arrayIterator.next()).dispose(); 
/*  96 */       this.freeMeshes.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class TightMeshPool
/*     */     implements MeshPool
/*     */   {
/* 103 */     private Array<Mesh> freeMeshes = new Array();
/* 104 */     private Array<Mesh> usedMeshes = new Array();
/*     */ 
/*     */     
/*     */     public void flush() {
/* 108 */       this.freeMeshes.addAll(this.usedMeshes);
/* 109 */       this.usedMeshes.clear();
/*     */     }
/*     */     public Mesh obtain(VertexAttributes param1VertexAttributes, int param1Int1, int param1Int2) {
/*     */       byte b;
/*     */       int i;
/* 114 */       for (b = 0, i = this.freeMeshes.size; b < i; b++) {
/*     */         Mesh mesh1;
/* 116 */         if ((mesh1 = (Mesh)this.freeMeshes.get(b)).getVertexAttributes().equals(param1VertexAttributes) && mesh1.getMaxVertices() == param1Int1 && mesh1
/* 117 */           .getMaxIndices() == param1Int2) {
/* 118 */           this.freeMeshes.removeIndex(b);
/* 119 */           this.usedMeshes.add(mesh1);
/* 120 */           return mesh1;
/*     */         } 
/*     */       } 
/* 123 */       Mesh mesh = new Mesh(true, param1Int1, param1Int2, param1VertexAttributes);
/* 124 */       this.usedMeshes.add(mesh);
/* 125 */       return mesh;
/*     */     }
/*     */     
/*     */     public void dispose() {
/*     */       Array.ArrayIterator<Mesh> arrayIterator;
/* 130 */       for (arrayIterator = this.usedMeshes.iterator(); arrayIterator.hasNext();)
/* 131 */         (mesh = arrayIterator.next()).dispose(); 
/* 132 */       this.usedMeshes.clear();
/* 133 */       for (arrayIterator = this.freeMeshes.iterator(); arrayIterator.hasNext();)
/* 134 */         (mesh = arrayIterator.next()).dispose(); 
/* 135 */       this.freeMeshes.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Sorter
/*     */     implements RenderableSorter, Comparator<Renderable>
/*     */   {
/*     */     public void sort(Camera param1Camera, Array<Renderable> param1Array) {
/* 145 */       param1Array.sort(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public int compare(Renderable param1Renderable1, Renderable param1Renderable2) {
/* 150 */       VertexAttributes vertexAttributes1 = param1Renderable1.meshPart.mesh.getVertexAttributes();
/* 151 */       VertexAttributes vertexAttributes2 = param1Renderable2.meshPart.mesh.getVertexAttributes();
/*     */       int i;
/* 153 */       if ((i = vertexAttributes1.compareTo(vertexAttributes2)) == 0) {
/*     */         
/* 155 */         if ((i = param1Renderable1.material.compareTo(param1Renderable2.material)) == 0) {
/* 156 */           return param1Renderable1.meshPart.primitiveType - param1Renderable2.meshPart.primitiveType;
/*     */         }
/* 158 */         return i;
/*     */       } 
/* 160 */       return i;
/*     */     }
/*     */   }
/*     */   
/* 164 */   private Array<Renderable> renderables = new Array();
/* 165 */   private FlushablePool<Renderable> renderablesPool = new FlushablePool<Renderable>()
/*     */     {
/*     */       protected Renderable newObject() {
/* 168 */         return new Renderable();
/*     */       }
/*     */     };
/* 171 */   private FlushablePool<MeshPart> meshPartPool = new FlushablePool<MeshPart>()
/*     */     {
/*     */       protected MeshPart newObject() {
/* 174 */         return new MeshPart();
/*     */       }
/*     */     };
/*     */   
/* 178 */   private Array<Renderable> items = new Array();
/* 179 */   private Array<Renderable> tmp = new Array();
/*     */   
/*     */   private MeshBuilder meshBuilder;
/*     */   
/*     */   private boolean building;
/*     */   
/*     */   private RenderableSorter sorter;
/*     */   private MeshPool meshPool;
/*     */   private Camera camera;
/*     */   
/*     */   public ModelCache() {
/* 190 */     this(new Sorter(), new SimpleMeshPool());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelCache(RenderableSorter paramRenderableSorter, MeshPool paramMeshPool) {
/* 198 */     this.sorter = paramRenderableSorter;
/* 199 */     this.meshPool = paramMeshPool;
/* 200 */     this.meshBuilder = new MeshBuilder();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void begin() {
/* 208 */     begin(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void begin(Camera paramCamera) {
/* 217 */     if (this.building) throw new GdxRuntimeException("Call end() after calling begin()"); 
/* 218 */     this.building = true;
/*     */     
/* 220 */     this.camera = paramCamera;
/* 221 */     this.renderablesPool.flush();
/* 222 */     this.renderables.clear();
/* 223 */     this.items.clear();
/* 224 */     this.meshPartPool.flush();
/* 225 */     this.meshPool.flush();
/*     */   }
/*     */   
/*     */   private Renderable obtainRenderable(Material paramMaterial, int paramInt) {
/*     */     Renderable renderable;
/* 230 */     (renderable = (Renderable)this.renderablesPool.obtain()).bones = null;
/* 231 */     renderable.environment = null;
/* 232 */     renderable.material = paramMaterial;
/* 233 */     renderable.meshPart.mesh = null;
/* 234 */     renderable.meshPart.offset = 0;
/* 235 */     renderable.meshPart.size = 0;
/* 236 */     renderable.meshPart.primitiveType = paramInt;
/* 237 */     renderable.meshPart.center.set(0.0F, 0.0F, 0.0F);
/* 238 */     renderable.meshPart.halfExtents.set(0.0F, 0.0F, 0.0F);
/* 239 */     renderable.meshPart.radius = -1.0F;
/* 240 */     renderable.shader = null;
/* 241 */     renderable.userData = null;
/* 242 */     renderable.worldTransform.idt();
/* 243 */     return renderable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void end() {
/* 250 */     if (!this.building) throw new GdxRuntimeException("Call begin() prior to calling end()"); 
/* 251 */     this.building = false;
/*     */     
/* 253 */     if (this.items.size == 0)
/* 254 */       return;  this.sorter.sort(this.camera, this.items);
/*     */ 
/*     */     
/*     */     Renderable renderable1;
/*     */ 
/*     */     
/* 260 */     VertexAttributes vertexAttributes = (renderable1 = (Renderable)this.items.get(0)).meshPart.mesh.getVertexAttributes();
/* 261 */     Material material = renderable1.material;
/* 262 */     int i = renderable1.meshPart.primitiveType;
/* 263 */     int j = this.renderables.size;
/*     */     
/* 265 */     this.meshBuilder.begin(vertexAttributes);
/* 266 */     MeshPart meshPart = this.meshBuilder.part("", i, (MeshPart)this.meshPartPool.obtain());
/* 267 */     this.renderables.add(obtainRenderable(material, i)); byte b;
/*     */     int k;
/* 269 */     for (b = 0, k = this.items.size; b < k; b++) {
/*     */       Renderable renderable;
/* 271 */       VertexAttributes vertexAttributes1 = (renderable = (Renderable)this.items.get(b)).meshPart.mesh.getVertexAttributes();
/* 272 */       Material material1 = renderable.material;
/* 273 */       int m = renderable.meshPart.primitiveType;
/*     */       
/* 275 */       boolean bool = vertexAttributes1.equals(vertexAttributes);
/*     */       
/* 277 */       int n = (n = (renderable.meshPart.mesh.getNumIndices() > 0) ? 1 : 0) ? renderable.meshPart.mesh.getNumVertices() : renderable.meshPart.size;
/* 278 */       n = (this.meshBuilder.getNumVertices() + n <= 65536) ? 1 : 0;
/*     */ 
/*     */ 
/*     */       
/* 282 */       if ((n = ((bool = (bool && n != 0)) && m == i && material1.same(material, true)) ? 1 : 0) == 0) {
/* 283 */         if (!bool) {
/*     */           
/* 285 */           Mesh mesh1 = this.meshBuilder.end(this.meshPool.obtain(vertexAttributes, this.meshBuilder.getNumVertices(), this.meshBuilder.getNumIndices()));
/* 286 */           while (j < this.renderables.size)
/* 287 */             ((Renderable)this.renderables.get(j++)).meshPart.mesh = mesh1; 
/* 288 */           this.meshBuilder.begin(vertexAttributes = vertexAttributes1);
/*     */         } 
/*     */         
/* 291 */         MeshPart meshPart1 = this.meshBuilder.part("", m, (MeshPart)this.meshPartPool.obtain());
/*     */         Renderable renderable3;
/* 293 */         (renderable3 = (Renderable)this.renderables.get(this.renderables.size - 1)).meshPart.offset = meshPart.offset;
/* 294 */         renderable3.meshPart.size = meshPart.size;
/* 295 */         meshPart = meshPart1; int i1;
/*     */         Material material2;
/* 297 */         this.renderables.add(obtainRenderable(material2 = material1, i1 = m));
/*     */       } 
/*     */       
/* 300 */       this.meshBuilder.setVertexTransform(renderable.worldTransform);
/* 301 */       this.meshBuilder.addMesh(renderable.meshPart.mesh, renderable.meshPart.offset, renderable.meshPart.size);
/*     */     } 
/*     */ 
/*     */     
/* 305 */     Mesh mesh = this.meshBuilder.end(this.meshPool.obtain(vertexAttributes, this.meshBuilder.getNumVertices(), this.meshBuilder.getNumIndices()));
/* 306 */     while (j < this.renderables.size) {
/* 307 */       ((Renderable)this.renderables.get(j++)).meshPart.mesh = mesh;
/*     */     }
/*     */     Renderable renderable2;
/* 310 */     (renderable2 = (Renderable)this.renderables.get(this.renderables.size - 1)).meshPart.offset = meshPart.offset;
/* 311 */     renderable2.meshPart.size = meshPart.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Renderable paramRenderable) {
/* 322 */     if (!this.building) throw new GdxRuntimeException("Can only add items to the ModelCache in between .begin() and .end()"); 
/* 323 */     if (paramRenderable.bones == null) {
/* 324 */       this.items.add(paramRenderable); return;
/*     */     } 
/* 326 */     this.renderables.add(paramRenderable);
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(RenderableProvider paramRenderableProvider) {
/* 331 */     paramRenderableProvider.getRenderables(this.tmp, (Pool<Renderable>)this.renderablesPool); byte b; int i;
/* 332 */     for (b = 0, i = this.tmp.size; b < i; b++)
/* 333 */       add((Renderable)this.tmp.get(b)); 
/* 334 */     this.tmp.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends RenderableProvider> void add(Iterable<T> paramIterable) {
/* 339 */     for (RenderableProvider renderableProvider : paramIterable) {
/* 340 */       add(renderableProvider);
/*     */     }
/*     */   }
/*     */   
/*     */   public void getRenderables(Array<Renderable> paramArray, Pool<Renderable> paramPool) {
/* 345 */     if (this.building) throw new GdxRuntimeException("Cannot render a ModelCache in between .begin() and .end()"); 
/* 346 */     for (Array.ArrayIterator<Renderable> arrayIterator = this.renderables.iterator(); arrayIterator.hasNext(); ) {
/* 347 */       Renderable renderable; (renderable = arrayIterator.next()).shader = null;
/* 348 */       renderable.environment = null;
/*     */     } 
/* 350 */     paramArray.addAll(this.renderables);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 355 */     if (this.building) throw new GdxRuntimeException("Cannot dispose a ModelCache in between .begin() and .end()"); 
/* 356 */     this.meshPool.dispose();
/*     */   }
/*     */   
/*     */   public static interface MeshPool extends Disposable {
/*     */     Mesh obtain(VertexAttributes param1VertexAttributes, int param1Int1, int param1Int2);
/*     */     
/*     */     void flush();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\ModelCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */