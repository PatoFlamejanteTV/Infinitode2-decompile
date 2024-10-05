/*     */ package com.prineside.tdi2.utils.mapeditor;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.utils.IntRectangle;
/*     */ 
/*     */ public final class Selection {
/*  19 */   public Array<Tile> tiles = new Array(true, 1, Tile.class);
/*  20 */   public Array<Gate> gates = new Array(true, 1, Gate.class);
/*     */   
/*     */   private boolean a;
/*     */   
/*     */   private boolean b;
/*  25 */   private final IntRectangle c = new IntRectangle();
/*  26 */   private SelectionOutline d = new SelectionOutline();
/*     */   private int e;
/*     */   
/*     */   public final int count() {
/*  30 */     return this.tiles.size + this.gates.size;
/*     */   }
/*     */   
/*     */   public final Selection cpy() {
/*  34 */     Selection selection = new Selection(); Array.ArrayIterator<Tile> arrayIterator;
/*  35 */     for (arrayIterator = this.tiles.iterator(); arrayIterator.hasNext(); ) { Tile tile = arrayIterator.next();
/*  36 */       selection.addTile(tile); }
/*     */     
/*  38 */     for (arrayIterator = this.gates.iterator(); arrayIterator.hasNext(); ) { Gate gate = (Gate)arrayIterator.next();
/*  39 */       selection.addGate(gate); }
/*     */     
/*  41 */     selection.a = this.a;
/*  42 */     return selection;
/*     */   }
/*     */   
/*     */   public final int hash() {
/*  46 */     a();
/*  47 */     return this.e;
/*     */   }
/*     */   
/*     */   public final boolean hasTileOn(int paramInt1, int paramInt2) {
/*  51 */     for (Array.ArrayIterator<Tile> arrayIterator = this.tiles.iterator(); arrayIterator.hasNext();) {
/*  52 */       if ((tile = arrayIterator.next()).getX() == paramInt1 && tile.getY() == paramInt2) {
/*  53 */         return true;
/*     */       }
/*     */     } 
/*  56 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setFromInventory(boolean paramBoolean) {
/*  63 */     if (this.a != paramBoolean) {
/*  64 */       clear();
/*  65 */       this.a = paramBoolean;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final boolean isFromInventory() {
/*  70 */     return this.a;
/*     */   }
/*     */   
/*     */   public final IntRectangle dimensions() {
/*  74 */     a();
/*  75 */     return this.c;
/*     */   }
/*     */   
/*     */   private void a() {
/*  79 */     if (this.b) {
/*  80 */       b();
/*     */     }
/*     */   }
/*     */   
/*     */   private void b() {
/*  85 */     this.b = false;
/*     */ 
/*     */     
/*  88 */     this.c.set(0, 0, 0, 0);
/*  89 */     int i = Integer.MAX_VALUE;
/*  90 */     int j = Integer.MAX_VALUE;
/*  91 */     int k = Integer.MIN_VALUE;
/*  92 */     int m = Integer.MIN_VALUE;
/*     */     
/*  94 */     this.e = this.a ? 1 : 2;
/*  95 */     this.tiles.sort((paramTile1, paramTile2) -> {
/*     */           int i;
/*     */           
/*     */           return ((i = Integer.compare(paramTile1.getX(), paramTile2.getX())) != 0) ? i : Integer.compare(paramTile1.getY(), paramTile2.getY());
/*     */         });
/*     */     
/* 101 */     this.gates.sort((paramGate1, paramGate2) -> {
/*     */           int i;
/*     */           
/*     */           return ((i = Integer.compare(paramGate1.getX(), paramGate2.getX())) != 0) ? i : (((i = Integer.compare(paramGate1.getY(), paramGate2.getY())) != 0) ? i : Boolean.compare(paramGate1.isLeftSide(), paramGate2.isLeftSide()));
/*     */         });
/*     */     
/*     */     Array.ArrayIterator<Tile> arrayIterator;
/*     */     
/* 109 */     for (arrayIterator = this.tiles.iterator(); arrayIterator.hasNext(); ) { Tile tile = arrayIterator.next();
/* 110 */       i = Math.min(i, tile.getX());
/* 111 */       j = Math.min(j, tile.getY());
/* 112 */       k = Math.max(k, tile.getX());
/* 113 */       m = Math.max(m, tile.getY());
/*     */       
/* 115 */       this.e = this.e * 31 + tile.getX();
/* 116 */       this.e = this.e * 31 + tile.getY();
/* 117 */       this.e = this.e * 31 + tile.generateSeedSalt(); }
/*     */     
/* 119 */     for (arrayIterator = this.gates.iterator(); arrayIterator.hasNext(); ) { Gate gate = (Gate)arrayIterator.next();
/* 120 */       this.e = this.e * 31 + gate.getX();
/* 121 */       this.e = this.e * 31 + gate.getY();
/* 122 */       this.e = this.e * 31 + (gate.isLeftSide() ? 0 : 1);
/* 123 */       i = Math.min(i, gate.getX());
/* 124 */       j = Math.min(j, gate.getY());
/* 125 */       k = Math.max(k, gate.getX());
/* 126 */       m = Math.max(m, gate.getY()); }
/*     */     
/* 128 */     if (i != Integer.MAX_VALUE) {
/* 129 */       this.c.set(i, k, j, m);
/*     */     }
/*     */ 
/*     */     
/* 133 */     this.d = new SelectionOutline();
/*     */     
/* 135 */     if (this.tiles.size > 1) {
/*     */       
/* 137 */       for (arrayIterator = this.tiles.iterator(); arrayIterator.hasNext(); ) { Tile tile = arrayIterator.next();
/* 138 */         i = 0;
/* 139 */         j = 0;
/* 140 */         k = 0;
/* 141 */         m = 0;
/* 142 */         for (byte b = 0; b < this.tiles.size; b++) {
/* 143 */           Tile tile1 = (Tile)this.tiles.get(b);
/* 144 */           j = (j != 0 || (tile.getY() == tile1.getY() && tile.getX() + 1 == tile1.getX())) ? 1 : 0;
/* 145 */           i = (i != 0 || (tile.getY() == tile1.getY() && tile.getX() - 1 == tile1.getX())) ? 1 : 0;
/* 146 */           k = (k != 0 || (tile.getX() == tile1.getX() && tile.getY() + 1 == tile1.getY())) ? 1 : 0;
/* 147 */           m = (m != 0 || (tile.getX() == tile1.getX() && tile.getY() - 1 == tile1.getY())) ? 1 : 0;
/*     */         } 
/* 149 */         if (i == 0) this.d.add(tile.getX(), tile.getY(), SelectionOutline.Edge.Side.LEFT); 
/* 150 */         if (k == 0) this.d.add(tile.getX(), tile.getY(), SelectionOutline.Edge.Side.TOP); 
/* 151 */         if (j == 0) this.d.add(tile.getX(), tile.getY(), SelectionOutline.Edge.Side.RIGHT); 
/* 152 */         if (m == 0) this.d.add(tile.getX(), tile.getY(), SelectionOutline.Edge.Side.BOTTOM);
/*     */          }
/*     */ 
/*     */       
/* 156 */       for (arrayIterator = this.gates.iterator(); arrayIterator.hasNext(); ) { Gate gate = (Gate)arrayIterator.next();
/* 157 */         this.d.removeOverGate(gate); }
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void clear() {
/* 163 */     this.tiles.clear();
/* 164 */     this.gates.clear();
/* 165 */     this.b = true;
/*     */   }
/*     */   
/*     */   public final void drawOutline(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor1, @Null Color paramColor2) {
/* 169 */     a();
/*     */     
/* 171 */     paramFloat3 = 128.0F * paramFloat3;
/* 172 */     paramFloat4 = 128.0F * paramFloat4;
/*     */     
/* 174 */     ResourcePack.AtlasTextureRegion atlasTextureRegion = Game.i.assetManager.getBlankWhiteTextureRegion();
/*     */     
/* 176 */     if (paramColor2 != null) {
/* 177 */       paramBatch.setColor(paramColor2);
/* 178 */       for (byte b = 0; b < this.tiles.size; b++) {
/* 179 */         Tile tile = (Tile)this.tiles.get(b);
/* 180 */         paramBatch.draw((TextureRegion)atlasTextureRegion, (tile.getX() << 7), (tile.getY() << 7), 128.0F, 128.0F);
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     if (this.tiles.size > 1) {
/*     */ 
/*     */       
/* 187 */       paramBatch.setColor(paramColor1);
/* 188 */       for (Array.ArrayIterator<SelectionOutline.Edge> arrayIterator1 = this.d.edges.iterator(); arrayIterator1.hasNext(); ) { boolean bool2; float f3; boolean bool1; float f2; boolean bool3; SelectionOutline.Edge edge = arrayIterator1.next();
/* 189 */         float f4 = paramFloat1 + (edge.x - this.c.minX) * paramFloat3;
/* 190 */         float f1 = paramFloat2 + (edge.y - this.c.minY) * paramFloat4;
/*     */         
/* 192 */         switch (null.a[edge.side.ordinal()]) {
/*     */           case 1:
/* 194 */             bool3 = (hasTileOn(edge.x, edge.y + 1) || hasTileOn(edge.x - 1, edge.y + 1)) ? true : false;
/* 195 */             bool2 = (hasTileOn(edge.x, edge.y - 1) || hasTileOn(edge.x - 1, edge.y - 1)) ? true : false;
/* 196 */             f1 -= bool2 ? 0.0F : 4.0F;
/* 197 */             f3 = paramFloat4 + (bool2 ? 0.0F : 4.0F) + (bool3 ? 0.0F : 4.0F);
/* 198 */             paramBatch.draw((TextureRegion)atlasTextureRegion, f4 - 4.0F, f1, 4.0F, f3);
/*     */ 
/*     */           
/*     */           case 2:
/* 202 */             paramBatch.draw((TextureRegion)atlasTextureRegion, f4, f1 + paramFloat4, paramFloat3, 4.0F);
/*     */ 
/*     */           
/*     */           case 3:
/* 206 */             bool3 = (hasTileOn(f3.x, f3.y + 1) || hasTileOn(f3.x + 1, f3.y + 1)) ? true : false;
/* 207 */             bool1 = (hasTileOn(f3.x, f3.y - 1) || hasTileOn(f3.x + 1, f3.y - 1)) ? true : false;
/* 208 */             f1 -= bool1 ? 0.0F : 4.0F;
/* 209 */             f2 = paramFloat4 + (bool1 ? 0.0F : 4.0F) + (bool3 ? 0.0F : 4.0F);
/* 210 */             paramBatch.draw((TextureRegion)atlasTextureRegion, f4 + paramFloat3, f1, 4.0F, f2);
/*     */ 
/*     */           
/*     */           case 4:
/* 214 */             paramBatch.draw((TextureRegion)atlasTextureRegion, f4, f1 - 4.0F, paramFloat3, 4.0F);
/*     */         } 
/*     */         
/*     */          }
/*     */     
/* 219 */     } else if (this.tiles.size == 1) {
/*     */       
/* 221 */       float f1 = paramFloat1 + (((Tile)this.tiles.first()).getX() - this.c.minX) * paramFloat3;
/* 222 */       float f2 = paramFloat2 + (((Tile)this.tiles.first()).getY() - this.c.minY) * paramFloat4;
/* 223 */       paramBatch.setColor(paramColor1);
/* 224 */       Game.i.assetManager.getQuad("tile.outlineSelected").draw(paramBatch, f1, f2, 128.0F, 128.0F);
/*     */     } 
/*     */     
/* 227 */     paramBatch.setColor(paramColor1);
/* 228 */     for (Array.ArrayIterator<Gate> arrayIterator = this.gates.iterator(); arrayIterator.hasNext(); ) { Gate gate = arrayIterator.next();
/* 229 */       float f1 = paramFloat1 + (gate.getX() - this.c.minX) * paramFloat3;
/* 230 */       float f2 = paramFloat2 + (gate.getY() - this.c.minY) * paramFloat4;
/*     */       
/* 232 */       if (gate.isLeftSide()) {
/*     */         
/* 234 */         Game.i.assetManager.getQuad("gate.outlineLeftSelected").draw(paramBatch, f1, f2, 128.0F, 128.0F);
/*     */         continue;
/*     */       } 
/* 237 */       Game.i.assetManager.getQuad("gate.outlineBottomSelected").draw(paramBatch, f1, f2, 128.0F, 128.0F); }
/*     */ 
/*     */     
/* 240 */     paramBatch.setColor(Color.WHITE);
/*     */   }
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Map paramMap) {
/* 244 */     a();
/*     */     
/* 246 */     paramFloat3 = 128.0F * paramFloat3;
/* 247 */     paramFloat4 = 128.0F * paramFloat4;
/*     */     
/* 249 */     float f = Gdx.graphics.getDeltaTime();
/*     */     Array.ArrayIterator<Tile> arrayIterator;
/* 251 */     for (arrayIterator = this.tiles.iterator(); arrayIterator.hasNext(); ) { Tile tile = arrayIterator.next();
/* 252 */       float f1 = paramFloat1 + (tile.getX() - this.c.minX) * paramFloat3;
/* 253 */       float f2 = paramFloat2 + (tile.getY() - this.c.minY) * paramFloat4;
/* 254 */       tile.drawStatic(paramBatch, f1, f2, paramFloat3, paramFloat4, paramMap, MapRenderingSystem.DrawMode.FULL);
/* 255 */       tile.drawExtras(paramBatch, f1, f2, paramFloat3, paramFloat4, MapRenderingSystem.DrawMode.FULL);
/* 256 */       tile.drawBatch(paramBatch, f, f1, f2, paramFloat3, paramFloat4, MapRenderingSystem.DrawMode.FULL);
/* 257 */       tile.postDrawBatch(paramBatch, f, f1, f2, paramFloat3, paramFloat4, MapRenderingSystem.DrawMode.FULL); }
/*     */     
/* 259 */     for (arrayIterator = this.gates.iterator(); arrayIterator.hasNext(); ) { Gate gate = (Gate)arrayIterator.next();
/* 260 */       float f1 = paramFloat1 + (gate.getX() - this.c.minX) * paramFloat3;
/* 261 */       float f2 = paramFloat2 + (gate.getY() - this.c.minY) * paramFloat4;
/* 262 */       gate.drawStatic(paramBatch, f1, f2, paramFloat3, paramFloat4);
/* 263 */       gate.drawBatch(paramBatch, f, f1, f2, paramFloat3, paramFloat4); }
/*     */   
/*     */   }
/*     */   public final void addAll(Selection paramSelection) {
/*     */     Array.ArrayIterator<Tile> arrayIterator;
/* 268 */     for (arrayIterator = paramSelection.tiles.iterator(); arrayIterator.hasNext(); ) { Tile tile = arrayIterator.next();
/* 269 */       addTile(tile); }
/*     */     
/* 271 */     for (arrayIterator = paramSelection.gates.iterator(); arrayIterator.hasNext(); ) { Gate gate = (Gate)arrayIterator.next();
/* 272 */       addGate(gate); }
/*     */   
/*     */   }
/*     */   
/*     */   public final boolean addTile(Tile paramTile) {
/* 277 */     for (Array.ArrayIterator<Tile> arrayIterator = this.tiles.iterator(); arrayIterator.hasNext();) {
/* 278 */       if ((tile = arrayIterator.next()).getX() == paramTile.getX() && tile.getY() == paramTile.getY()) return false; 
/*     */     } 
/* 280 */     this.tiles.add(paramTile.cloneTile());
/* 281 */     this.b = true;
/*     */     
/* 283 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean addGate(Gate paramGate) {
/* 287 */     for (Array.ArrayIterator<Gate> arrayIterator = this.gates.iterator(); arrayIterator.hasNext();) {
/* 288 */       if ((gate = arrayIterator.next()).getX() == paramGate.getX() && gate.getY() == paramGate.getY() && gate.isLeftSide() == paramGate.isLeftSide()) return false; 
/*     */     } 
/* 290 */     this.gates.add(paramGate.cloneGate());
/* 291 */     this.b = true;
/*     */     
/* 293 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean removeTile(Tile paramTile) {
/* 297 */     for (byte b = 0; b < this.tiles.size; b++) {
/*     */       Tile tile;
/* 299 */       if ((tile = (Tile)this.tiles.get(b)).getX() == paramTile.getX() && tile.getY() == paramTile.getY()) {
/* 300 */         this.tiles.removeIndex(b);
/* 301 */         this.b = true;
/* 302 */         return true;
/*     */       } 
/*     */     } 
/* 305 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean containsTile(Tile paramTile) {
/* 312 */     for (byte b = 0; b < this.tiles.size; b++) {
/*     */       Tile tile;
/* 314 */       if ((tile = (Tile)this.tiles.get(b)).getX() == paramTile.getX() && tile.getY() == paramTile.getY() && paramTile.sameAs(tile)) {
/* 315 */         return true;
/*     */       }
/*     */     } 
/* 318 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean containsGate(Gate paramGate) {
/* 325 */     for (byte b = 0; b < this.gates.size; b++) {
/*     */       Gate gate;
/* 327 */       if ((gate = (Gate)this.gates.get(b)).getX() == paramGate.getX() && gate.getY() == paramGate.getY() && gate.isLeftSide() == paramGate.isLeftSide() && paramGate.sameAs(gate)) {
/* 328 */         return true;
/*     */       }
/*     */     } 
/* 331 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean removeGate(Gate paramGate) {
/* 335 */     for (byte b = 0; b < this.gates.size; b++) {
/*     */       Gate gate;
/* 337 */       if ((gate = (Gate)this.gates.get(b)).getX() == paramGate.getX() && gate.getY() == paramGate.getY() && gate.isLeftSide() == paramGate.isLeftSide()) {
/* 338 */         this.gates.removeIndex(b);
/* 339 */         this.b = true;
/* 340 */         return true;
/*     */       } 
/*     */     } 
/* 343 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Item getCurrentItem() {
/* 353 */     if (this.gates.size != 0)
/* 354 */       return (Item)Item.D.F_GATE.create((Gate)this.gates.first()); 
/* 355 */     return (Item)Item.D.F_TILE.create((Tile)this.tiles.first());
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 360 */     return "Selection (count: " + count() + ", tiles: " + this.tiles.toString(",") + ", gates: " + this.gates.toString(",") + ")";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\mapeditor\Selection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */