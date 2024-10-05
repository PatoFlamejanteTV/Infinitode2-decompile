/*     */ package com.prineside.tdi2.pathfinding;
/*     */ 
/*     */ import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = Path.Serializer.class)
/*     */ public final class Path
/*     */ {
/*  21 */   private static final TLog a = TLog.forClass(Path.class);
/*     */   
/*  23 */   public static final Path EMPTY = new Path(new HeavyPathNode[0]);
/*     */   
/*  25 */   public static final SideFunction[][] SIDE_FUNCTIONS = new SideFunction[20][11]; static {
/*     */     byte b;
/*  27 */     for (b = 0; b < 11; b++) {
/*     */       
/*  29 */       float f = (b - 5) * 0.0625F;
/*  30 */       SIDE_FUNCTIONS[0][b] = new BezierSideFunction(-0.5F, -f, f, -f, f, 0.5F, f);
/*  31 */       SIDE_FUNCTIONS[1][b] = new LinearSideFunction(-0.5F, -f, 0.5F, -f);
/*  32 */       SIDE_FUNCTIONS[2][b] = new BezierSideFunction(-0.5F, -f, -f, -f, -f, -0.5F, -f);
/*  33 */       SIDE_FUNCTIONS[3][b] = new BezierSideFunction(-0.5F, -f, 0.0F, -f, 0.0F, 0.0F, 0.0F);
/*     */       
/*  35 */       SIDE_FUNCTIONS[4][b] = new BezierSideFunction(-f, 0.5F, -f, f, -0.5F, f, -f);
/*  36 */       SIDE_FUNCTIONS[5][b] = new BezierSideFunction(-f, 0.5F, -f, -f, 0.5F, -f, f);
/*  37 */       SIDE_FUNCTIONS[6][b] = new LinearSideFunction(-f, 0.5F, -f, -0.5F);
/*  38 */       SIDE_FUNCTIONS[7][b] = new BezierSideFunction(-f, 0.5F, -f, 0.0F, 0.0F, 0.0F, 0.0F);
/*     */       
/*  40 */       SIDE_FUNCTIONS[8][b] = new LinearSideFunction(0.5F, f, -0.5F, f);
/*  41 */       SIDE_FUNCTIONS[9][b] = new BezierSideFunction(0.5F, f, f, f, f, 0.5F, -f);
/*  42 */       SIDE_FUNCTIONS[10][b] = new BezierSideFunction(0.5F, f, -f, f, -f, -0.5F, f);
/*  43 */       SIDE_FUNCTIONS[11][b] = new BezierSideFunction(0.5F, f, 0.0F, f, 0.0F, 0.0F, 0.0F);
/*     */       
/*  45 */       SIDE_FUNCTIONS[12][b] = new BezierSideFunction(f, -0.5F, f, f, -0.5F, f, f);
/*  46 */       SIDE_FUNCTIONS[13][b] = new LinearSideFunction(f, -0.5F, f, 0.5F);
/*  47 */       SIDE_FUNCTIONS[14][b] = new BezierSideFunction(f, -0.5F, f, -f, 0.5F, -f, -f);
/*  48 */       SIDE_FUNCTIONS[15][b] = new BezierSideFunction(f, -0.5F, f, 0.0F, 0.0F, 0.0F, 0.0F);
/*     */       
/*  50 */       SIDE_FUNCTIONS[16][b] = new BezierSideFunction(0.0F, 0.0F, 0.0F, f, -0.5F, f, 0.0F);
/*  51 */       SIDE_FUNCTIONS[17][b] = new BezierSideFunction(0.0F, 0.0F, f, 0.0F, f, 0.5F, 0.0F);
/*  52 */       SIDE_FUNCTIONS[18][b] = new BezierSideFunction(0.0F, 0.0F, 0.0F, -f, 0.5F, -f, 0.0F);
/*  53 */       SIDE_FUNCTIONS[19][b] = new BezierSideFunction(0.0F, 0.0F, -f, 0.0F, -f, -0.5F, 0.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   public static final SideFunction[][] SIDE_SIMPLE_FUNCTIONS = new SideFunction[20][11]; private final PathNode[] b;
/*     */   static {
/*  63 */     for (b = 0; b < 11; b++) {
/*     */       
/*  65 */       float f = (b - 5) * 0.0625F;
/*  66 */       SIDE_SIMPLE_FUNCTIONS[0][b] = new SharpCornerSideFunction(-0.5F, -f, f, -f, f, 0.5F);
/*  67 */       SIDE_SIMPLE_FUNCTIONS[1][b] = new LinearSideFunction(-0.5F, -f, 0.5F, -f);
/*  68 */       SIDE_SIMPLE_FUNCTIONS[2][b] = new SharpCornerSideFunction(-0.5F, -f, -f, -f, -f, -0.5F);
/*  69 */       SIDE_SIMPLE_FUNCTIONS[3][b] = new LinearSideFunction(-0.5F, -f, 0.0F, 0.0F);
/*     */       
/*  71 */       SIDE_SIMPLE_FUNCTIONS[4][b] = new SharpCornerSideFunction(-f, 0.5F, -f, f, -0.5F, f);
/*  72 */       SIDE_SIMPLE_FUNCTIONS[5][b] = new SharpCornerSideFunction(-f, 0.5F, -f, -f, 0.5F, -f);
/*  73 */       SIDE_SIMPLE_FUNCTIONS[6][b] = new LinearSideFunction(-f, 0.5F, -f, -0.5F);
/*  74 */       SIDE_SIMPLE_FUNCTIONS[7][b] = new LinearSideFunction(-f, 0.5F, 0.0F, 0.0F);
/*     */       
/*  76 */       SIDE_SIMPLE_FUNCTIONS[8][b] = new LinearSideFunction(0.5F, f, -0.5F, f);
/*  77 */       SIDE_SIMPLE_FUNCTIONS[9][b] = new SharpCornerSideFunction(0.5F, f, f, f, f, 0.5F);
/*  78 */       SIDE_SIMPLE_FUNCTIONS[10][b] = new SharpCornerSideFunction(0.5F, f, -f, f, -f, -0.5F);
/*  79 */       SIDE_SIMPLE_FUNCTIONS[11][b] = new LinearSideFunction(0.5F, f, 0.0F, 0.0F);
/*     */       
/*  81 */       SIDE_SIMPLE_FUNCTIONS[12][b] = new SharpCornerSideFunction(f, -0.5F, f, f, -0.5F, f);
/*  82 */       SIDE_SIMPLE_FUNCTIONS[13][b] = new LinearSideFunction(f, -0.5F, f, 0.5F);
/*  83 */       SIDE_SIMPLE_FUNCTIONS[14][b] = new SharpCornerSideFunction(f, -0.5F, f, -f, 0.5F, -f);
/*  84 */       SIDE_SIMPLE_FUNCTIONS[15][b] = new LinearSideFunction(f, -0.5F, 0.0F, 0.0F);
/*     */       
/*  86 */       SIDE_SIMPLE_FUNCTIONS[16][b] = new LinearSideFunction(0.0F, 0.0F, -0.5F, f);
/*  87 */       SIDE_SIMPLE_FUNCTIONS[17][b] = new LinearSideFunction(0.0F, 0.0F, f, 0.5F);
/*  88 */       SIDE_SIMPLE_FUNCTIONS[18][b] = new LinearSideFunction(0.0F, 0.0F, 0.5F, -f);
/*  89 */       SIDE_SIMPLE_FUNCTIONS[19][b] = new LinearSideFunction(0.0F, 0.0F, -f, -0.5F);
/*     */     } 
/*     */   }
/*     */   
/*     */   private final byte[] c;
/*     */   private final int d;
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<Path>
/*     */   {
/*     */     public void write(Kryo param1Kryo, Output param1Output, Path param1Path) {
/* 100 */       param1Kryo.writeObject(param1Output, Path.a(param1Path));
/* 101 */       param1Kryo.writeObject(param1Output, Path.b(param1Path));
/*     */     }
/*     */ 
/*     */     
/*     */     public Path read(Kryo param1Kryo, Input param1Input, Class<? extends Path> param1Class) {
/* 106 */       PathNode[] arrayOfPathNode = (PathNode[])param1Kryo.readObject(param1Input, PathNode[].class);
/* 107 */       byte[] arrayOfByte = (byte[])param1Kryo.readObject(param1Input, byte[].class);
/* 108 */       return new Path(arrayOfPathNode, arrayOfByte, (byte)0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 114 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 119 */     if (paramObject == this) return true; 
/* 120 */     if (!(paramObject instanceof Path)) return false;
/*     */     
/* 122 */     if (((Path)(paramObject = paramObject)).b.length != this.b.length) return false;  byte b;
/* 123 */     for (b = 0; b < this.c.length; b++) {
/* 124 */       if (((Path)paramObject).c[b] != this.c[b]) {
/* 125 */         return false;
/*     */       }
/*     */     } 
/* 128 */     for (b = 0; b < this.b.length; b++) {
/* 129 */       if (!this.b[b].equals(((Path)paramObject).b[b])) {
/* 130 */         return false;
/*     */       }
/*     */     } 
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final PathNode[] getNodes() {
/* 141 */     return this.b;
/*     */   }
/*     */   
/*     */   private Path(PathNode[] paramArrayOfPathNode, byte[] paramArrayOfbyte) {
/* 145 */     this.b = paramArrayOfPathNode;
/* 146 */     this.c = paramArrayOfbyte;
/* 147 */     this.d = b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Path(DefaultGraphPath<HeavyPathNode> paramDefaultGraphPath) {
/* 155 */     this.b = new PathNode[paramDefaultGraphPath.nodes.size];
/* 156 */     this.c = new byte[this.b.length];
/* 157 */     for (byte b = 0; b < paramDefaultGraphPath.nodes.size; b++) {
/* 158 */       this.b[b] = ((HeavyPathNode)paramDefaultGraphPath.nodes.get(b)).toLightNode();
/*     */     }
/* 160 */     a();
/* 161 */     this.d = b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Path(Array<HeavyPathNode> paramArray) {
/* 169 */     this.b = new PathNode[paramArray.size];
/* 170 */     this.c = new byte[this.b.length];
/*     */     
/* 172 */     for (byte b = 0; b < paramArray.size; b++) {
/* 173 */       this.b[b] = ((HeavyPathNode)paramArray.get(b)).toLightNode();
/*     */     }
/* 175 */     a();
/* 176 */     this.d = b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Path(HeavyPathNode[] paramArrayOfHeavyPathNode) {
/* 184 */     this.b = new PathNode[paramArrayOfHeavyPathNode.length];
/* 185 */     this.c = new byte[this.b.length];
/*     */     
/* 187 */     for (byte b = 0; b < paramArrayOfHeavyPathNode.length; b++) {
/* 188 */       this.b[b] = paramArrayOfHeavyPathNode[b].toLightNode();
/*     */     }
/* 190 */     a();
/* 191 */     this.d = b();
/*     */   }
/*     */   
/*     */   public Path(HeavyPathNode[] paramArrayOfHeavyPathNode, byte[] paramArrayOfbyte) {
/* 195 */     if (paramArrayOfHeavyPathNode.length != paramArrayOfbyte.length) {
/* 196 */       throw new IllegalArgumentException("Number of nodes != number of move sides, " + paramArrayOfHeavyPathNode.length + " != " + paramArrayOfbyte.length);
/*     */     }
/* 198 */     this.b = new PathNode[paramArrayOfHeavyPathNode.length];
/* 199 */     paramArrayOfbyte = new byte[this.b.length];
/*     */     
/* 201 */     for (byte b = 0; b < paramArrayOfHeavyPathNode.length; b++) {
/* 202 */       this.b[b] = paramArrayOfHeavyPathNode[b].toLightNode();
/*     */     }
/* 204 */     this.c = new byte[paramArrayOfbyte.length];
/* 205 */     System.arraycopy(paramArrayOfbyte, 0, this.c, 0, paramArrayOfbyte.length);
/* 206 */     this.d = b();
/*     */   }
/*     */   
/*     */   public final int getCount() {
/* 210 */     return this.b.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte getMoveSideByIdx(int paramInt) {
/* 218 */     return this.c[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte[] getMoveSides() {
/* 225 */     return this.c;
/*     */   }
/*     */   
/*     */   public final byte getMoveSideByPassedTiles(float paramFloat) {
/* 229 */     return getMoveSideByIdx((int)(paramFloat + 0.5F));
/*     */   }
/*     */   
/*     */   public final Path copyWithStartingMoveSide(byte paramByte) {
/* 233 */     MoveSide.assertValid(paramByte);
/*     */     
/* 235 */     PathNode[] arrayOfPathNode = new PathNode[this.b.length];
/* 236 */     byte[] arrayOfByte = new byte[this.c.length];
/* 237 */     System.arraycopy(this.b, 0, arrayOfPathNode, 0, this.b.length);
/* 238 */     System.arraycopy(this.c, 0, arrayOfByte, 0, this.c.length);
/* 239 */     arrayOfByte[0] = paramByte;
/*     */     
/* 241 */     return new Path(arrayOfPathNode, arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Path copyWithCustomMoveSides(int[] paramArrayOfint) {
/* 249 */     Preconditions.checkNotNull(paramArrayOfint, "sides can not be null");
/*     */     
/* 251 */     PathNode[] arrayOfPathNode = new PathNode[this.b.length];
/* 252 */     byte[] arrayOfByte = new byte[this.c.length];
/* 253 */     System.arraycopy(this.b, 0, arrayOfPathNode, 0, this.b.length);
/* 254 */     System.arraycopy(this.c, 0, arrayOfByte, 0, this.c.length);
/* 255 */     if (paramArrayOfint.length % 2 != 0) {
/* 256 */       throw new IllegalArgumentException("Array must contain pairs [idx,side,idx,side...]");
/*     */     }
/* 258 */     for (byte b = 0; b < paramArrayOfint.length; b += 2) {
/* 259 */       int i = paramArrayOfint[b];
/*     */       byte b1;
/* 261 */       MoveSide.assertValid(b1 = (byte)paramArrayOfint[b + 1]);
/* 262 */       if (i < 0 || i >= this.b.length) {
/* 263 */         throw new IllegalArgumentException("Invalid node idx: " + i + ", valid range for this path is 0.." + (this.b.length - 1));
/*     */       }
/* 265 */       arrayOfByte[i] = b1;
/*     */     } 
/*     */     
/* 268 */     return new Path(arrayOfPathNode, arrayOfByte);
/*     */   }
/*     */   
/*     */   public final int getLengthInTiles() {
/* 272 */     return this.b.length - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte a(int paramInt) {
/* 279 */     PathNode pathNode1 = this.b[paramInt];
/* 280 */     PathNode pathNode2 = null;
/* 281 */     PathNode pathNode3 = null;
/*     */     
/* 283 */     if (paramInt > 0) {
/* 284 */       pathNode2 = this.b[paramInt - 1];
/*     */     }
/* 286 */     if (paramInt < this.b.length - 1) {
/* 287 */       pathNode3 = this.b[paramInt + 1];
/*     */     }
/*     */     
/* 290 */     return MoveSide.calculateMoveSides(pathNode1, pathNode2, pathNode3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/* 297 */     for (byte b = 0; b < this.b.length; b++) {
/* 298 */       this.c[b] = a(b);
/*     */     }
/*     */   }
/*     */   
/*     */   private int b() {
/* 303 */     int i = 1; byte[] arrayOfByte; int j; byte b;
/* 304 */     for (j = (arrayOfByte = this.c).length, b = 0; b < j; ) { byte b1 = arrayOfByte[b];
/* 305 */       i = i * 31 + b1; b++; }
/*     */      PathNode[] arrayOfPathNode;
/* 307 */     for (j = (arrayOfPathNode = this.b).length, b = 0; b < j; ) { PathNode pathNode = arrayOfPathNode[b];
/* 308 */       i = i * 31 + pathNode.hashCode(); b++; }
/*     */     
/* 310 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Vector2 getPosition(float paramFloat, int paramInt, Vector2 paramVector2) {
/*     */     PathNode pathNode;
/* 321 */     int j = this.b.length - 1;
/* 322 */     float f = 0.99999F;
/* 323 */     if (paramFloat < this.b.length - 0.5D) {
/*     */ 
/*     */       
/* 326 */       j = (int)(paramFloat = paramFloat + 0.5F);
/* 327 */       f = paramFloat - j;
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 332 */       pathNode = this.b[j];
/* 333 */     } catch (Exception exception) {
/* 334 */       throw new IllegalStateException("can't get current node, currentNodeIdx = " + j + ", passedTiles = " + paramFloat + ", nodes.size = " + this.b.length, exception);
/*     */     } 
/* 336 */     byte b = this.c[j];
/* 337 */     SIDE_FUNCTIONS[b][paramInt].position(f, paramVector2);
/*     */ 
/*     */     
/* 340 */     int i = (pathNode.getX() << 7) + 64;
/* 341 */     paramInt = (pathNode.getY() << 7) + 64;
/* 342 */     paramVector2.x += i;
/* 343 */     paramVector2.y += paramInt;
/*     */ 
/*     */     
/* 346 */     if ((int)paramVector2.x > i + 64 - 1) {
/* 347 */       paramVector2.x = (i + 64 - 1);
/*     */     }
/* 349 */     if ((int)paramVector2.y > paramInt + 64 - 1) {
/* 350 */       paramVector2.y = (paramInt + 64 - 1);
/*     */     }
/*     */     
/* 353 */     return paramVector2;
/*     */   } public final boolean passesThroughTileType(Map paramMap, TileType paramTileType) {
/*     */     byte b;
/*     */     int i;
/* 357 */     for (b = 0, i = getLengthInTiles(); b <= i; b++) {
/* 358 */       PathNode pathNode = this.b[b];
/*     */       Tile tile;
/* 360 */       if ((tile = paramMap.getTile(pathNode.getX(), pathNode.getY())) != null && tile.type == paramTileType) return true;
/*     */     
/*     */     } 
/* 363 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getPositionSimpleSegmentsForGraphics(int paramInt, Array<PathSegmentForRendering> paramArray) {
/* 370 */     paramArray.clear();
/* 371 */     float f = 0.0F; byte b;
/*     */     int i;
/* 373 */     for (b = 0, i = getLengthInTiles(); b <= i; b++) {
/* 374 */       byte b1 = getMoveSideByIdx(b);
/* 375 */       PathNode pathNode = this.b[b];
/*     */       
/* 377 */       if (MoveSide.isStraightLine(b1)) {
/*     */         
/* 379 */         PathSegmentForRendering pathSegmentForRendering = new PathSegmentForRendering();
/*     */         
/* 381 */         Vector2 vector2 = new Vector2();
/* 382 */         SIDE_SIMPLE_FUNCTIONS[b1][paramInt].position(0.0F, vector2);
/* 383 */         pathSegmentForRendering.x1 = vector2.x + (pathNode.getX() << 7) + 64.0F;
/* 384 */         pathSegmentForRendering.y1 = vector2.y + (pathNode.getY() << 7) + 64.0F;
/* 385 */         SIDE_SIMPLE_FUNCTIONS[b1][paramInt].position(1.0F, vector2);
/* 386 */         pathSegmentForRendering.x2 = vector2.x + (pathNode.getX() << 7) + 64.0F;
/* 387 */         pathSegmentForRendering.y2 = vector2.y + (pathNode.getY() << 7) + 64.0F;
/*     */         
/* 389 */         pathSegmentForRendering.length = PMath.getDistanceBetweenPoints(pathSegmentForRendering.x1, pathSegmentForRendering.y1, pathSegmentForRendering.x2, pathSegmentForRendering.y2);
/* 390 */         pathSegmentForRendering.distanceFromStart = f;
/* 391 */         pathSegmentForRendering.direction = PathSegmentForRendering.getDirection(pathSegmentForRendering.x1, pathSegmentForRendering.y1, pathSegmentForRendering.x2, pathSegmentForRendering.y2);
/* 392 */         paramArray.add(pathSegmentForRendering);
/*     */         
/* 394 */         f += pathSegmentForRendering.length;
/*     */       } else {
/*     */         
/* 397 */         PathSegmentForRendering pathSegmentForRendering1 = new PathSegmentForRendering();
/* 398 */         Vector2 vector2 = new Vector2();
/* 399 */         SIDE_SIMPLE_FUNCTIONS[b1][paramInt].position(0.0F, vector2);
/* 400 */         pathSegmentForRendering1.x1 = vector2.x + (pathNode.getX() << 7) + 64.0F;
/* 401 */         pathSegmentForRendering1.y1 = vector2.y + (pathNode.getY() << 7) + 64.0F;
/* 402 */         SIDE_SIMPLE_FUNCTIONS[b1][paramInt].position(0.5F, vector2);
/* 403 */         pathSegmentForRendering1.x2 = vector2.x + (pathNode.getX() << 7) + 64.0F;
/* 404 */         pathSegmentForRendering1.y2 = vector2.y + (pathNode.getY() << 7) + 64.0F;
/*     */         
/* 406 */         pathSegmentForRendering1.length = PMath.getDistanceBetweenPoints(pathSegmentForRendering1.x1, pathSegmentForRendering1.y1, pathSegmentForRendering1.x2, pathSegmentForRendering1.y2);
/* 407 */         pathSegmentForRendering1.distanceFromStart = f;
/* 408 */         pathSegmentForRendering1.direction = PathSegmentForRendering.getDirection(pathSegmentForRendering1.x1, pathSegmentForRendering1.y1, pathSegmentForRendering1.x2, pathSegmentForRendering1.y2);
/* 409 */         paramArray.add(pathSegmentForRendering1);
/* 410 */         f += pathSegmentForRendering1.length;
/*     */         
/*     */         PathSegmentForRendering pathSegmentForRendering2;
/* 413 */         (pathSegmentForRendering2 = new PathSegmentForRendering()).x1 = pathSegmentForRendering1.x2;
/* 414 */         pathSegmentForRendering2.y1 = pathSegmentForRendering1.y2;
/* 415 */         SIDE_SIMPLE_FUNCTIONS[b1][paramInt].position(1.0F, vector2);
/* 416 */         pathSegmentForRendering2.x2 = vector2.x + (pathNode.getX() << 7) + 64.0F;
/* 417 */         pathSegmentForRendering2.y2 = vector2.y + (pathNode.getY() << 7) + 64.0F;
/*     */         
/* 419 */         pathSegmentForRendering2.length = PMath.getDistanceBetweenPoints(pathSegmentForRendering2.x1, pathSegmentForRendering2.y1, pathSegmentForRendering2.x2, pathSegmentForRendering2.y2);
/* 420 */         pathSegmentForRendering2.distanceFromStart = f;
/* 421 */         pathSegmentForRendering2.direction = PathSegmentForRendering.getDirection(pathSegmentForRendering2.x1, pathSegmentForRendering2.y1, pathSegmentForRendering2.x2, pathSegmentForRendering2.y2);
/* 422 */         paramArray.add(pathSegmentForRendering2);
/* 423 */         f += pathSegmentForRendering2.length;
/*     */       } 
/*     */     } 
/*     */     
/* 427 */     return f;
/*     */   }
/*     */   
/*     */   public final float getSpeedMultiplier(float paramFloat, int paramInt) {
/* 431 */     int i = this.b.length - 1;
/* 432 */     if (paramFloat < this.b.length - 1.0F)
/*     */     {
/* 434 */       i = (int)(paramFloat + 0.5F);
/*     */     }
/*     */ 
/*     */     
/* 438 */     if (i < 0) {
/* 439 */       throw new IllegalStateException("currentNodeIdx = " + i + ", passedTiles: " + paramFloat);
/*     */     }
/*     */     
/* 442 */     return getSpeedMultiplierByNodeIdx(i, paramInt);
/*     */   }
/*     */   
/*     */   public final float getSpeedMultiplierByNodeIdx(int paramInt1, int paramInt2) {
/* 446 */     return SIDE_FUNCTIONS[this.c[paramInt1]][paramInt2].speedMultiplier();
/*     */   }
/*     */   
/*     */   public final float getRotation(float paramFloat, int paramInt) {
/* 450 */     int i = this.b.length - 1;
/* 451 */     float f = 0.99999F;
/* 452 */     if (paramFloat < (this.b.length - 1)) {
/*     */ 
/*     */       
/* 455 */       i = (int)(paramFloat = paramFloat + 0.5F);
/* 456 */       f = paramFloat - i;
/*     */     } 
/*     */     
/* 459 */     byte b = this.c[i];
/* 460 */     return SIDE_FUNCTIONS[b][paramInt].rotation(f);
/*     */   }
/*     */   
/*     */   public final PathNode getByIdx(int paramInt) {
/* 464 */     return this.b[paramInt];
/*     */   }
/*     */   
/*     */   public final PathNode getByPassedTiles(float paramFloat) {
/* 468 */     return this.b[(int)(paramFloat + 0.5F)];
/*     */   }
/*     */   
/*     */   public final int getNodeIdxByPassedTiles(float paramFloat) {
/* 472 */     return (int)(paramFloat + 0.5D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isPassedTilesOnPath(float paramFloat) {
/* 479 */     return (paramFloat < getCount() - 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String describe() {
/*     */     StringBuilder stringBuilder;
/* 485 */     (stringBuilder = new StringBuilder()).append("nodes: ").append(this.b.length).append("\n");
/* 486 */     for (byte b = 0; b < this.b.length; b++) {
/* 487 */       if (b != 0) stringBuilder.append(" > "); 
/* 488 */       stringBuilder.append(this.b[b].getX()).append(":").append(this.b[b].getY()).append(" (").append(MoveSide.getName(this.c[b])).append(")");
/*     */     } 
/*     */     
/* 491 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public final void debugDump() {
/* 495 */     if (getCount() == 0) {
/* 496 */       a.i("path his empty", new Object[0]);
/*     */     }
/* 498 */     for (byte b = 0; b < getCount(); b++) {
/* 499 */       a.i(b + ": " + this.b[b].toString(), new Object[0]);
/*     */     }
/*     */   }
/*     */   
/*     */   public final float getPassedTilesDelta(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3) {
/* 504 */     if (paramFloat3 > 0.0F) {
/* 505 */       int i = getNodeIdxByPassedTiles(paramFloat2);
/* 506 */       double d1 = getSpeedMultiplierByNodeIdx(i, paramInt);
/* 507 */       double d2 = 1.0D - (paramFloat2 + 0.5D) % 1.0D;
/*     */ 
/*     */       
/* 510 */       if ((paramFloat2 = (float)((paramFloat3 * paramFloat1) * d1)) > d2)
/*     */       {
/*     */         
/* 513 */         if (i + 1 < getCount()) {
/*     */ 
/*     */           
/* 516 */           double d = getSpeedMultiplierByNodeIdx(i + 1, paramInt);
/* 517 */           if (d1 != d) {
/*     */             
/* 519 */             double d3 = d2 / paramFloat3 * d1;
/* 520 */             double d4 = paramFloat1 - d3;
/*     */ 
/*     */ 
/*     */             
/* 524 */             return paramFloat1 = (float)(d2 + paramFloat3 * d4 * d);
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 529 */       return paramFloat2;
/* 530 */     }  if (paramFloat3 < 0.0F)
/*     */     {
/*     */       
/* 533 */       return paramFloat3 * paramFloat1;
/*     */     }
/* 535 */     return 0.0F;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\Path.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */