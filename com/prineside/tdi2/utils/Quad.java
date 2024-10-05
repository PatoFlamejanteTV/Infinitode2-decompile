/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.a.a.c.j.a;
/*     */ import com.a.a.c.j.m;
/*     */ import com.a.a.c.m;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteCache;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.kryo.FixedInput;
/*     */ import com.prineside.kryo.FixedOutput;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.scene2d.utils.TransformDrawable;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ public final class Quad
/*     */   extends AbstractDrawable implements TransformDrawable {
/*  28 */   private static final TLog b = TLog.forClass(Quad.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final float BINARY_FLOAT_PRECISION = 100.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final float BINARY_FLOAT_PRECISION_MUL = 0.01F;
/*     */ 
/*     */ 
/*     */   
/*  42 */   private static Quad c = null;
/*     */   public static Quad getNoQuad() {
/*  44 */     if (c == null) {
/*  45 */       c = fromString("YxQVYDYVEPj//z8/gykHR2PDN3YGWw4gALM4OAA=");
/*     */     }
/*     */     
/*  48 */     return c;
/*     */   }
/*     */   
/*  51 */   private static final byte[][] d = new byte[][] { { 0, 1, 0, 0 }, { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 0 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   private final Array<QuadRegion> e = new Array(true, 1, QuadRegion.class);
/*     */   
/*     */   private float f;
/*     */   
/*     */   private float g;
/*     */   private float h;
/*     */   private float i;
/*     */   private float j;
/*     */   private float k;
/*     */   public boolean debugging;
/*  73 */   private static final StringBuilder l = new StringBuilder();
/*  74 */   public static final FixedOutput outputHelper = new FixedOutput(1024, -1);
/*  75 */   private static final FixedInput m = new FixedInput(8);
/*     */   
/*     */   private Quad() {}
/*     */   
/*  79 */   private static final class Prepared { private static final Array<QuadRegion> a = new Array(true, 8, QuadRegion.class);
/*  80 */     private static final FloatArray b = new FloatArray(true, 32);
/*     */     
/*     */     private static int c;
/*     */     
/*     */     private static float d;
/*     */     
/*     */     private static float e; }
/*     */ 
/*     */ 
/*     */   
/*     */   public Quad(float paramFloat1, float paramFloat2) {
/*  91 */     setWidth(paramFloat1);
/*  92 */     setHeight(paramFloat2);
/*  93 */     setPivot(paramFloat1 * 0.5F, paramFloat2 * 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quad(Quad paramQuad, boolean paramBoolean) {
/* 100 */     set(paramQuad, paramBoolean);
/*     */   }
/*     */   
/*     */   public Quad(ResourcePack.AtlasTextureRegion paramAtlasTextureRegion) {
/* 104 */     QuadRegion quadRegion = new QuadRegion(paramAtlasTextureRegion, 0.0F, 0.0F, paramAtlasTextureRegion.getRegionWidth(), paramAtlasTextureRegion.getRegionHeight());
/* 105 */     addRegion(quadRegion);
/*     */     
/* 107 */     setWidth(paramAtlasTextureRegion.getRegionWidth());
/* 108 */     setHeight(paramAtlasTextureRegion.getRegionHeight());
/* 109 */     setPivot(this.f * 0.5F, this.g * 0.5F);
/*     */   }
/*     */   
/*     */   public final boolean sameAs(Quad paramQuad) {
/* 113 */     if (this == paramQuad) return true;
/*     */     
/* 115 */     if (this.f != paramQuad.f) return false; 
/* 116 */     if (this.g != paramQuad.g) return false; 
/* 117 */     if (this.h != paramQuad.h) return false; 
/* 118 */     if (this.i != paramQuad.i) return false;
/*     */     
/* 120 */     if (getMinWidth() != paramQuad.getMinWidth()) return false; 
/* 121 */     if (getMinHeight() != paramQuad.getMinHeight()) return false; 
/* 122 */     if (getLeftWidth() != paramQuad.getLeftWidth()) return false; 
/* 123 */     if (getRightWidth() != paramQuad.getRightWidth()) return false; 
/* 124 */     if (getTopHeight() != paramQuad.getTopHeight()) return false; 
/* 125 */     if (getBottomHeight() != paramQuad.getBottomHeight()) return false;
/*     */     
/* 127 */     if (this.e.size != paramQuad.e.size) return false;
/*     */     
/* 129 */     for (byte b = 0; b < this.e.size; b++) {
/* 130 */       QuadRegion quadRegion1 = ((QuadRegion[])this.e.items)[b];
/* 131 */       QuadRegion quadRegion2 = ((QuadRegion[])paramQuad.e.items)[b];
/* 132 */       if (!quadRegion1.sameAs(quadRegion2)) {
/* 133 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   public final void set(Quad paramQuad, boolean paramBoolean) {
/* 141 */     this.e.clear();
/*     */     
/* 143 */     if (paramBoolean) {
/* 144 */       for (paramBoolean = false; paramBoolean < paramQuad.e.size; paramBoolean++) {
/* 145 */         this.e.add(new QuadRegion(((QuadRegion[])paramQuad.e.items)[paramBoolean]));
/*     */       }
/*     */     } else {
/* 148 */       this.e.addAll(paramQuad.e);
/*     */     } 
/* 150 */     setWidth(paramQuad.f);
/* 151 */     setHeight(paramQuad.g);
/* 152 */     this.h = paramQuad.h;
/* 153 */     this.i = paramQuad.i;
/*     */     
/* 155 */     if (paramQuad.a != null) {
/* 156 */       a();
/* 157 */       System.arraycopy(paramQuad.a, 0, this.a, 0, this.a.length);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void addRegion(QuadRegion paramQuadRegion) {
/* 162 */     this.e.add(paramQuadRegion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void appendSet(Quad paramQuad, Color paramColor, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 169 */     paramFloat3 /= paramQuad.f;
/* 170 */     paramFloat4 /= paramQuad.g;
/*     */     
/* 172 */     for (Array.ArrayIterator<QuadRegion> arrayIterator = paramQuad.e.iterator(); arrayIterator.hasNext(); ) { QuadRegion quadRegion = arrayIterator.next();
/*     */       
/* 174 */       (quadRegion = new QuadRegion(quadRegion)).multiplyCornerColors(paramColor);
/*     */       
/* 176 */       float[] arrayOfFloat = quadRegion.getCornerPositions();
/* 177 */       for (byte b = 0; b < 4; b++) {
/* 178 */         arrayOfFloat[b << 1] = arrayOfFloat[b << 1] * paramFloat3 + paramFloat1;
/* 179 */         arrayOfFloat[(b << 1) + 1] = arrayOfFloat[(b << 1) + 1] * paramFloat4 + paramFloat2;
/*     */       } 
/* 181 */       quadRegion.setCornerPositions(arrayOfFloat);
/*     */       
/* 183 */       this.e.add(quadRegion); }
/*     */   
/*     */   }
/*     */   
/*     */   public final void replaceRegionsColor(Color paramColor1, Color paramColor2) {
/* 188 */     for (Array.ArrayIterator<QuadRegion> arrayIterator = this.e.iterator(); arrayIterator.hasNext();) {
/*     */       
/* 190 */       if ((cornerColors = (quadRegion = arrayIterator.next()).getCornerColors()).isSingleColor()) {
/* 191 */         quadRegion.setSameCornerColors(paramColor2);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public final Array<QuadRegion> getRegions() {
/* 197 */     return this.e;
/*     */   }
/*     */   
/*     */   public final Quad multiplyRegionColors(Color paramColor) {
/* 201 */     for (byte b = 0; b < this.e.size; b++) {
/* 202 */       ((QuadRegion[])this.e.items)[b].multiplyCornerColors(paramColor);
/*     */     }
/* 204 */     return this;
/*     */   }
/*     */   
/*     */   public final float getWidth() {
/* 208 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void setWidth(float paramFloat) {
/* 212 */     this.f = paramFloat;
/* 213 */     this.j = 1.0F / Math.max(1.0E-4F, paramFloat);
/*     */   }
/*     */   
/*     */   public final float getHeight() {
/* 217 */     return this.g;
/*     */   }
/*     */   
/*     */   public final void setHeight(float paramFloat) {
/* 221 */     this.g = paramFloat;
/* 222 */     this.k = 1.0F / Math.max(1.0E-4F, paramFloat);
/*     */   }
/*     */   
/*     */   public final void setPivot(float paramFloat1, float paramFloat2) {
/* 226 */     this.h = paramFloat1;
/* 227 */     this.i = paramFloat2;
/*     */   }
/*     */   
/*     */   public final float getPivotX() {
/* 231 */     return this.h;
/*     */   }
/*     */   
/*     */   public final float getPivotY() {
/* 235 */     return this.i;
/*     */   }
/*     */   
/*     */   public final void setSize(float paramFloat1, float paramFloat2) {
/* 239 */     setWidth(paramFloat1);
/* 240 */     setHeight(paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Quad fromString(String paramString) {
/* 247 */     for (byte b = 0; b < paramString.length(); exception++) {
/*     */       char c;
/* 249 */       if ((c = paramString.charAt(b)) != ' ' && c != '\t' && c != '\r' && c != '\n') {
/* 250 */         if (c == '[') {
/*     */           
/*     */           try {
/* 253 */             return fromJson((new JsonReader()).parse(paramString));
/* 254 */           } catch (Exception exception) {
/* 255 */             throw new IllegalArgumentException("Failed to read QuadRegionSet from string '" + paramString + "'", exception);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 264 */     return fromByteArray(StringFormatter.fromCompactBase64(paramString));
/*     */   }
/*     */   
/*     */   public static Quad fromJson(a parama, AssetProvider<TextureRegion> paramAssetProvider) {
/* 268 */     Quad quad = new Quad();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 273 */     JsonAssertUtils.checkJsonType(m = parama.a(0), m.a, "[QRS][size]");
/* 274 */     if (m.a() == 2) {
/* 275 */       quad.setWidth((float)m.a(0).k());
/* 276 */       quad.setHeight((float)m.a(1).k());
/* 277 */     } else if (m.a() == 1) {
/*     */       
/* 279 */       float f = (float)m.a(0).k();
/* 280 */       quad.setWidth(f);
/* 281 */       quad.setHeight(f);
/*     */     } 
/*     */     
/* 284 */     JsonAssertUtils.checkJsonType(m = parama.a(1), m.a, "[QRS][regions]");
/* 285 */     for (m m : m) {
/* 286 */       quad.e.add(QuadRegion.fromJson(m, paramAssetProvider));
/*     */     }
/* 288 */     boolean bool = false;
/* 289 */     if (parama.a() >= 3)
/*     */     {
/*     */       
/* 292 */       if ((m = parama.a(2)).d() == m.a) {
/*     */         
/* 294 */         quad.h = (float)m.a(0).k();
/* 295 */         quad.i = (float)m.a(1).k();
/* 296 */         bool = true;
/*     */       } else {
/* 298 */         JsonAssertUtils.checkJsonType(m, m.g, "[QRS][extras]");
/* 299 */         for (Iterator<Map.Entry> iterator = m.n(); iterator.hasNext(); ) {
/*     */           Map.Entry<?, m> entry;
/* 301 */           m m1 = (entry = iterator.next()).getValue();
/* 302 */           switch ((String)entry.getKey()) {
/*     */             
/*     */             case "p":
/* 305 */               quad.h = (float)m1.a(0).k();
/* 306 */               quad.i = (float)m1.a(1).k();
/*     */ 
/*     */ 
/*     */             
/*     */             case "lw":
/* 311 */               quad.setLeftWidth((float)m1.k());
/*     */ 
/*     */ 
/*     */             
/*     */             case "rw":
/* 316 */               quad.setRightWidth((float)m1.k());
/*     */ 
/*     */ 
/*     */             
/*     */             case "th":
/* 321 */               quad.setTopHeight((float)m1.k());
/*     */ 
/*     */ 
/*     */             
/*     */             case "bh":
/* 326 */               quad.setBottomHeight((float)m1.k());
/*     */ 
/*     */ 
/*     */             
/*     */             case "mw":
/* 331 */               quad.setMinWidth((float)m1.k());
/*     */ 
/*     */ 
/*     */             
/*     */             case "mh":
/* 336 */               quad.setMinHeight((float)m1.k());
/*     */           } 
/*     */ 
/*     */ 
/*     */         
/*     */         } 
/*     */       } 
/*     */     }
/* 344 */     if (!bool) {
/* 345 */       quad.h = quad.f * 0.5F;
/* 346 */       quad.i = quad.g * 0.5F;
/*     */     } 
/*     */     
/* 349 */     return quad;
/*     */   }
/*     */   
/*     */   public static Quad fromJson(JsonValue paramJsonValue) {
/* 353 */     Quad quad = new Quad();
/*     */ 
/*     */     
/*     */     JsonValue jsonValue;
/*     */     
/* 358 */     if ((jsonValue = paramJsonValue.get(0)).size == 2) {
/* 359 */       quad.setWidth((float)jsonValue.get(0).asDouble());
/* 360 */       quad.setHeight((float)jsonValue.get(1).asDouble());
/* 361 */     } else if (jsonValue.size == 1) {
/*     */       
/* 363 */       float f = (float)jsonValue.get(0).asDouble();
/* 364 */       quad.setWidth(f);
/* 365 */       quad.setHeight(f);
/*     */     } 
/*     */     
/* 368 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = paramJsonValue.get(1)).iterator(); jsonIterator.hasNext(); ) { jsonValue = jsonIterator.next();
/* 369 */       quad.e.add(QuadRegion.fromJson(jsonValue)); }
/*     */     
/* 371 */     boolean bool = false;
/* 372 */     if (paramJsonValue.size >= 3)
/*     */     {
/*     */       
/* 375 */       if ((jsonValue = paramJsonValue.get(2)).isArray()) {
/*     */         
/* 377 */         quad.h = (float)jsonValue.get(0).asDouble();
/* 378 */         quad.i = (float)jsonValue.get(1).asDouble();
/* 379 */         bool = true;
/*     */       } else {
/* 381 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue.iterator(); jsonIterator1.hasNext();) {
/* 382 */           switch ((paramJsonValue = jsonIterator1.next()).name) {
/*     */             
/*     */             case "p":
/* 385 */               quad.h = (float)paramJsonValue.get(0).asDouble();
/* 386 */               quad.i = (float)paramJsonValue.get(1).asDouble();
/*     */ 
/*     */ 
/*     */             
/*     */             case "lw":
/* 391 */               quad.setLeftWidth((float)paramJsonValue.asDouble());
/*     */ 
/*     */ 
/*     */             
/*     */             case "rw":
/* 396 */               quad.setRightWidth((float)paramJsonValue.asDouble());
/*     */ 
/*     */ 
/*     */             
/*     */             case "th":
/* 401 */               quad.setTopHeight((float)paramJsonValue.asDouble());
/*     */ 
/*     */ 
/*     */             
/*     */             case "bh":
/* 406 */               quad.setBottomHeight((float)paramJsonValue.asDouble());
/*     */ 
/*     */ 
/*     */             
/*     */             case "mw":
/* 411 */               quad.setMinWidth((float)paramJsonValue.asDouble());
/*     */ 
/*     */ 
/*     */             
/*     */             case "mh":
/* 416 */               quad.setMinHeight((float)paramJsonValue.asDouble());
/*     */           } 
/*     */ 
/*     */ 
/*     */         
/*     */         } 
/*     */       } 
/*     */     }
/* 424 */     if (!bool) {
/* 425 */       quad.h = quad.f * 0.5F;
/* 426 */       quad.i = quad.g * 0.5F;
/*     */     } 
/*     */     
/* 429 */     return quad;
/*     */   }
/*     */   
/*     */   public final void toJson5String(StringBuilder paramStringBuilder) {
/* 433 */     toJson5StringWithIndent(paramStringBuilder, 0);
/*     */   }
/*     */   
/*     */   public final void toJson5StringWithIndent(StringBuilder paramStringBuilder, int paramInt) {
/* 437 */     paramStringBuilder.append("[\n");
/*     */     byte b;
/* 439 */     for (b = 0; b < paramInt; ) { paramStringBuilder.append(' '); b++; }
/* 440 */      paramStringBuilder.append("  [");
/* 441 */     sbWriteIntOrFloat(paramStringBuilder, this.f);
/* 442 */     if (this.f != this.g) {
/* 443 */       paramStringBuilder.append(',');
/* 444 */       sbWriteIntOrFloat(paramStringBuilder, this.g);
/*     */     } 
/* 446 */     paramStringBuilder.append("],[\n");
/*     */ 
/*     */     
/* 449 */     for (b = 0; b < this.e.size; b++) {
/* 450 */       QuadRegion quadRegion = ((QuadRegion[])this.e.items)[b];
/* 451 */       for (byte b1 = 0; b1 < paramInt; ) { paramStringBuilder.append(' '); b1++; }
/* 452 */        paramStringBuilder.append("    ");
/* 453 */       quadRegion.toJson5String(paramStringBuilder);
/* 454 */       if (b != this.e.size - 1) {
/* 455 */         paramStringBuilder.append(',');
/*     */       }
/* 457 */       paramStringBuilder.append('\n');
/*     */     } 
/* 459 */     for (b = 0; b < paramInt; ) { paramStringBuilder.append(' '); b++; }
/* 460 */      paramStringBuilder.append("  ]");
/*     */ 
/*     */     
/* 463 */     if (b()) {
/* 464 */       paramStringBuilder.append(",{");
/* 465 */       b = 0;
/* 466 */       if (this.h != this.f * 0.5F || this.i != this.g * 0.5F) {
/*     */         
/* 468 */         paramStringBuilder.append("p:[");
/* 469 */         sbWriteIntOrFloat(paramStringBuilder, this.h);
/* 470 */         paramStringBuilder.append(',');
/* 471 */         sbWriteIntOrFloat(paramStringBuilder, this.i);
/* 472 */         paramStringBuilder.append(']');
/* 473 */         b = 1;
/*     */       } 
/* 475 */       if (getLeftWidth() != 0.0F) {
/* 476 */         if (b != 0) paramStringBuilder.append(','); 
/* 477 */         paramStringBuilder.append("lw:");
/* 478 */         sbWriteIntOrFloat(paramStringBuilder, getLeftWidth());
/* 479 */         b = 1;
/*     */       } 
/* 481 */       if (getRightWidth() != 0.0F) {
/* 482 */         if (b != 0) paramStringBuilder.append(','); 
/* 483 */         paramStringBuilder.append("rw:");
/* 484 */         sbWriteIntOrFloat(paramStringBuilder, getRightWidth());
/* 485 */         b = 1;
/*     */       } 
/* 487 */       if (getTopHeight() != 0.0F) {
/* 488 */         if (b != 0) paramStringBuilder.append(','); 
/* 489 */         paramStringBuilder.append("th:");
/* 490 */         sbWriteIntOrFloat(paramStringBuilder, getTopHeight());
/* 491 */         b = 1;
/*     */       } 
/* 493 */       if (getBottomHeight() != 0.0F) {
/* 494 */         if (b != 0) paramStringBuilder.append(','); 
/* 495 */         paramStringBuilder.append("bh:");
/* 496 */         sbWriteIntOrFloat(paramStringBuilder, getBottomHeight());
/* 497 */         b = 1;
/*     */       } 
/* 499 */       if (getMinWidth() != 0.0F) {
/* 500 */         if (b != 0) paramStringBuilder.append(','); 
/* 501 */         paramStringBuilder.append("mw:");
/* 502 */         sbWriteIntOrFloat(paramStringBuilder, getMinWidth());
/* 503 */         b = 1;
/*     */       } 
/* 505 */       if (getMinHeight() != 0.0F) {
/* 506 */         if (b != 0) paramStringBuilder.append(','); 
/* 507 */         paramStringBuilder.append("mh:");
/* 508 */         sbWriteIntOrFloat(paramStringBuilder, getMinHeight());
/*     */       } 
/* 510 */       paramStringBuilder.append('}');
/*     */     } 
/* 512 */     paramStringBuilder.append("\n");
/* 513 */     for (b = 0; b < paramInt; ) { paramStringBuilder.append(' '); b++; }
/* 514 */      paramStringBuilder.append("]");
/*     */   }
/*     */   
/*     */   public static boolean floatIsInt(float paramFloat) {
/* 518 */     return (MathUtils.round(paramFloat * 100.0F) % 100 == 0);
/*     */   }
/*     */   
/*     */   public static String stripNonAscii(String paramString) {
/* 522 */     char c = '\001';
/* 523 */     int i = paramString.length();
/* 524 */     for (byte b1 = 0; b1 < i; b1++) {
/*     */       char c1;
/* 526 */       if ((c1 = paramString.charAt(b1)) > '') {
/* 527 */         c = Character.MIN_VALUE;
/*     */         break;
/*     */       } 
/*     */     } 
/* 531 */     if (c) {
/* 532 */       return paramString;
/*     */     }
/*     */     
/* 535 */     StringBuilder stringBuilder = new StringBuilder();
/* 536 */     for (byte b2 = 0; b2 < i; b2++) {
/*     */       
/* 538 */       if ((c = paramString.charAt(b2)) <= '') {
/* 539 */         stringBuilder.append((char)c);
/*     */       }
/*     */     } 
/*     */     
/* 543 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static void jsonWriteIntOrFloat(Json paramJson, float paramFloat) {
/* 547 */     if (floatIsInt(paramFloat)) {
/* 548 */       paramJson.writeValue(Integer.valueOf(MathUtils.round(paramFloat))); return;
/*     */     } 
/* 550 */     paramJson.writeValue(Float.valueOf(paramFloat));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sbWriteIntOrFloat(StringBuilder paramStringBuilder, float paramFloat) {
/* 555 */     if (floatIsInt(paramFloat)) {
/* 556 */       paramStringBuilder.append(MathUtils.round(paramFloat)); return;
/*     */     } 
/* 558 */     paramStringBuilder.append((int)paramFloat).append('.');
/*     */     int i;
/* 560 */     if ((i = Math.abs(MathUtils.round((paramFloat - (int)paramFloat) * 100.0F))) < 10) {
/* 561 */       paramStringBuilder.append('0');
/*     */     }
/* 563 */     if (i % 10 == 0) {
/* 564 */       paramStringBuilder.append(i / 10); return;
/*     */     } 
/* 566 */     paramStringBuilder.append(i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String intOrFloatString(float paramFloat) {
/* 572 */     l.setLength(0);
/* 573 */     sbWriteIntOrFloat(l, paramFloat);
/* 574 */     return l.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void toBytes(FixedOutput paramFixedOutput) {
/* 579 */     paramFixedOutput.writeByte((byte)1);
/*     */     
/* 581 */     boolean bool1 = (this.f == this.g) ? true : false;
/* 582 */     boolean bool2 = (this.e.size == 1) ? true : false;
/* 583 */     boolean bool3 = (this.h != this.f * 0.5F || this.i != this.g * 0.5F) ? true : false;
/* 584 */     boolean bool4 = (getMinWidth() != 0.0F || getMinHeight() != 0.0F) ? true : false;
/* 585 */     boolean bool5 = (getLeftWidth() != 0.0F || getRightWidth() != 0.0F) ? true : false;
/* 586 */     boolean bool6 = (getBottomHeight() != 0.0F || getTopHeight() != 0.0F) ? true : false;
/*     */ 
/*     */     
/* 589 */     boolean bool7 = (floatIsInt(this.f) && floatIsInt(this.g) && floatIsInt(getMinWidth()) && floatIsInt(getMinHeight()) && floatIsInt(getLeftWidth()) && floatIsInt(getRightWidth()) && floatIsInt(getBottomHeight()) && floatIsInt(getTopHeight())) ? true : false;
/*     */     
/* 591 */     if (bool3) bool7 = (bool7 && floatIsInt(this.h) && floatIsInt(this.i)) ? true : false;
/*     */     
/* 593 */     byte b = 0;
/* 594 */     if (bool1) b = 1; 
/* 595 */     if (bool2) b = (byte)(b | 0x2); 
/* 596 */     if (bool7) b = (byte)(b | 0x4); 
/* 597 */     if (bool3) b = (byte)(b | 0x8); 
/* 598 */     if (bool4) b = (byte)(b | 0x10); 
/* 599 */     if (bool5) b = (byte)(b | 0x20); 
/* 600 */     if (bool6) b = (byte)(b | 0x40);
/*     */     
/* 602 */     paramFixedOutput.writeByte(b);
/*     */     
/* 604 */     if (bool1) {
/* 605 */       if (bool7) {
/* 606 */         paramFixedOutput.writeVarInt(MathUtils.round(this.f), true);
/*     */       } else {
/* 608 */         paramFixedOutput.writeVarInt(MathUtils.round(this.f * 100.0F), true);
/*     */       }
/*     */     
/* 611 */     } else if (bool7) {
/* 612 */       paramFixedOutput.writeVarInt(MathUtils.round(this.f), true);
/* 613 */       paramFixedOutput.writeVarInt(MathUtils.round(this.g), true);
/*     */     } else {
/* 615 */       paramFixedOutput.writeVarInt(MathUtils.round(this.f * 100.0F), true);
/* 616 */       paramFixedOutput.writeVarInt(MathUtils.round(this.g * 100.0F), true);
/*     */     } 
/*     */     
/* 619 */     if (bool2) {
/* 620 */       ((QuadRegion)this.e.first()).toBytes(paramFixedOutput);
/*     */     } else {
/* 622 */       paramFixedOutput.writeVarInt(this.e.size, true);
/* 623 */       for (Array.ArrayIterator<QuadRegion> arrayIterator = this.e.iterator(); arrayIterator.hasNext();) {
/* 624 */         (quadRegion = arrayIterator.next()).toBytes(paramFixedOutput);
/*     */       }
/*     */     } 
/* 627 */     if (bool3) {
/* 628 */       if (bool7) {
/* 629 */         paramFixedOutput.writeVarInt(MathUtils.round(this.h), true);
/* 630 */         paramFixedOutput.writeVarInt(MathUtils.round(this.i), true);
/*     */       } else {
/* 632 */         paramFixedOutput.writeVarInt(MathUtils.round(this.h * 100.0F), true);
/* 633 */         paramFixedOutput.writeVarInt(MathUtils.round(this.i * 100.0F), true);
/*     */       } 
/*     */     }
/* 636 */     if (bool4) {
/* 637 */       if (bool7) {
/* 638 */         paramFixedOutput.writeVarInt(MathUtils.round(getMinWidth()), true);
/* 639 */         paramFixedOutput.writeVarInt(MathUtils.round(getMinHeight()), true);
/*     */       } else {
/* 641 */         paramFixedOutput.writeVarInt(MathUtils.round(getMinWidth() * 100.0F), true);
/* 642 */         paramFixedOutput.writeVarInt(MathUtils.round(getMinHeight() * 100.0F), true);
/*     */       } 
/*     */     }
/* 645 */     if (bool5) {
/* 646 */       if (bool7) {
/* 647 */         paramFixedOutput.writeVarInt(MathUtils.round(getLeftWidth()), true);
/* 648 */         paramFixedOutput.writeVarInt(MathUtils.round(getRightWidth()), true);
/*     */       } else {
/* 650 */         paramFixedOutput.writeVarInt(MathUtils.round(getLeftWidth() * 100.0F), true);
/* 651 */         paramFixedOutput.writeVarInt(MathUtils.round(getRightWidth() * 100.0F), true);
/*     */       } 
/*     */     }
/* 654 */     if (bool6) {
/* 655 */       if (bool7) {
/* 656 */         paramFixedOutput.writeVarInt(MathUtils.round(getBottomHeight()), true);
/* 657 */         paramFixedOutput.writeVarInt(MathUtils.round(getTopHeight()), true); return;
/*     */       } 
/* 659 */       paramFixedOutput.writeVarInt(MathUtils.round(getBottomHeight() * 100.0F), true);
/* 660 */       paramFixedOutput.writeVarInt(MathUtils.round(getTopHeight() * 100.0F), true);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Quad fromByteArray(byte[] paramArrayOfbyte) {
/* 666 */     m.setBuffer(paramArrayOfbyte);
/* 667 */     m.setPosition(0);
/*     */     
/* 669 */     return fromBytes(m);
/*     */   }
/*     */   
/*     */   public static Quad fromBytes(FixedInput paramFixedInput) {
/*     */     float f1, f2;
/*     */     byte b;
/* 675 */     if ((b = paramFixedInput.readByte()) != 1) {
/* 676 */       throw new IllegalArgumentException("Version not supported");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 681 */     boolean bool1 = (((b = paramFixedInput.readByte()) & 0x1) != 0) ? true : false;
/* 682 */     int i = ((b & 0x2) != 0) ? 1 : 0;
/* 683 */     boolean bool2 = ((b & 0x4) != 0) ? true : false;
/* 684 */     boolean bool3 = ((b & 0x8) != 0) ? true : false;
/* 685 */     boolean bool4 = ((b & 0x10) != 0) ? true : false;
/* 686 */     boolean bool5 = ((b & 0x20) != 0) ? true : false;
/* 687 */     b = ((b & 0x40) != 0) ? 1 : 0;
/*     */ 
/*     */     
/* 690 */     if (bool1) {
/* 691 */       if (bool2) {
/* 692 */         f1 = f2 = paramFixedInput.readVarInt(true);
/*     */       } else {
/* 694 */         f1 = f2 = paramFixedInput.readVarInt(true) * 0.01F;
/*     */       }
/*     */     
/* 697 */     } else if (bool2) {
/* 698 */       f1 = paramFixedInput.readVarInt(true);
/* 699 */       f2 = paramFixedInput.readVarInt(true);
/*     */     } else {
/* 701 */       f1 = paramFixedInput.readVarInt(true) * 0.01F;
/* 702 */       f2 = paramFixedInput.readVarInt(true) * 0.01F;
/*     */     } 
/*     */     
/* 705 */     Quad quad = new Quad(f1, f2);
/*     */     
/* 707 */     if (i) {
/* 708 */       quad.addRegion(QuadRegion.fromBytes(paramFixedInput));
/*     */     } else {
/* 710 */       i = paramFixedInput.readVarInt(true);
/* 711 */       for (byte b1 = 0; b1 < i; b1++) {
/* 712 */         quad.addRegion(QuadRegion.fromBytes(paramFixedInput));
/*     */       }
/*     */     } 
/* 715 */     if (bool3) {
/* 716 */       if (bool2) {
/* 717 */         quad.h = paramFixedInput.readVarInt(true);
/* 718 */         quad.i = paramFixedInput.readVarInt(true);
/*     */       } else {
/* 720 */         quad.h = paramFixedInput.readVarInt(true) * 0.01F;
/* 721 */         quad.i = paramFixedInput.readVarInt(true) * 0.01F;
/*     */       } 
/*     */     }
/* 724 */     if (bool4) {
/* 725 */       if (bool2) {
/* 726 */         quad.setMinWidth(paramFixedInput.readVarInt(true));
/* 727 */         quad.setMinHeight(paramFixedInput.readVarInt(true));
/*     */       } else {
/* 729 */         quad.setMinWidth(paramFixedInput.readVarInt(true) * 0.01F);
/* 730 */         quad.setMinHeight(paramFixedInput.readVarInt(true) * 0.01F);
/*     */       } 
/*     */     }
/* 733 */     if (bool5) {
/* 734 */       if (bool2) {
/* 735 */         quad.setLeftWidth(paramFixedInput.readVarInt(true));
/* 736 */         quad.setRightWidth(paramFixedInput.readVarInt(true));
/*     */       } else {
/* 738 */         quad.setLeftWidth(paramFixedInput.readVarInt(true) * 0.01F);
/* 739 */         quad.setRightWidth(paramFixedInput.readVarInt(true) * 0.01F);
/*     */       } 
/*     */     }
/* 742 */     if (b != 0) {
/* 743 */       if (bool2) {
/* 744 */         quad.setBottomHeight(paramFixedInput.readVarInt(true));
/* 745 */         quad.setTopHeight(paramFixedInput.readVarInt(true));
/*     */       } else {
/* 747 */         quad.setBottomHeight(paramFixedInput.readVarInt(true) * 0.01F);
/* 748 */         quad.setTopHeight(paramFixedInput.readVarInt(true) * 0.01F);
/*     */       } 
/*     */     }
/*     */     
/* 752 */     return quad;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean b() {
/* 759 */     return (getMinWidth() != 0.0F || getMinHeight() != 0.0F || getLeftWidth() != 0.0F || getRightWidth() != 0.0F || getTopHeight() != 0.0F || getBottomHeight() != 0.0F || this.h != this.f * 0.5F || this.i != this.g * 0.5F);
/*     */   }
/*     */   
/*     */   public final String toBase64() {
/* 763 */     outputHelper.setPosition(0);
/* 764 */     toBytes(outputHelper);
/* 765 */     return StringFormatter.toCompactBase64(outputHelper.getBuffer(), 0, outputHelper.position());
/*     */   }
/*     */   
/*     */   public final void toJson(Json paramJson) {
/* 769 */     paramJson.writeArrayStart();
/*     */ 
/*     */     
/* 772 */     paramJson.writeArrayStart();
/* 773 */     jsonWriteIntOrFloat(paramJson, this.f);
/* 774 */     if (this.f != this.g) {
/* 775 */       jsonWriteIntOrFloat(paramJson, this.g);
/*     */     }
/* 777 */     paramJson.writeArrayEnd();
/*     */ 
/*     */     
/* 780 */     paramJson.writeArrayStart();
/* 781 */     for (Array.ArrayIterator<QuadRegion> arrayIterator = this.e.iterator(); arrayIterator.hasNext();) {
/* 782 */       (quadRegion = arrayIterator.next()).toJson(paramJson);
/*     */     }
/* 784 */     paramJson.writeArrayEnd();
/*     */ 
/*     */     
/* 787 */     if (b()) {
/* 788 */       paramJson.writeObjectStart();
/* 789 */       if (this.h != this.f * 0.5F || this.i != this.g * 0.5F) {
/*     */         
/* 791 */         paramJson.writeArrayStart("p");
/* 792 */         jsonWriteIntOrFloat(paramJson, this.h);
/* 793 */         jsonWriteIntOrFloat(paramJson, this.i);
/* 794 */         paramJson.writeArrayEnd();
/*     */       } 
/* 796 */       if (getMinWidth() != 0.0F) paramJson.writeValue("mw", Float.valueOf(getMinWidth())); 
/* 797 */       if (getMinHeight() != 0.0F) paramJson.writeValue("mh", Float.valueOf(getMinHeight())); 
/* 798 */       if (getLeftWidth() != 0.0F) paramJson.writeValue("lw", Float.valueOf(getLeftWidth())); 
/* 799 */       if (getRightWidth() != 0.0F) paramJson.writeValue("rw", Float.valueOf(getRightWidth())); 
/* 800 */       if (getTopHeight() != 0.0F) paramJson.writeValue("th", Float.valueOf(getTopHeight())); 
/* 801 */       if (getBottomHeight() != 0.0F) paramJson.writeValue("bh", Float.valueOf(getBottomHeight())); 
/* 802 */       paramJson.writeObjectEnd();
/*     */     } 
/*     */     
/* 805 */     paramJson.writeArrayEnd();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 812 */     if (this.debugging) {
/* 813 */       b.i("prepareDrawConfigs", new Object[0]);
/*     */     }
/* 815 */     float f1 = MathUtils.cosDeg(paramFloat7);
/* 816 */     float f2 = MathUtils.sinDeg(paramFloat7);
/* 817 */     float f3 = paramFloat3 * this.j;
/* 818 */     float f4 = paramFloat4 * this.k;
/*     */     
/* 820 */     Prepared.a(f1);
/* 821 */     Prepared.b(f2);
/*     */     
/* 823 */     if ((Prepared.a()).size < this.e.size) {
/* 824 */       Prepared.a().setSize(this.e.size);
/*     */     }
/* 826 */     if ((Prepared.b()).size < this.e.size << 2) {
/* 827 */       Prepared.b().setSize(this.e.size << 2);
/*     */     }
/* 829 */     float[] arrayOfFloat = (Prepared.b()).items;
/*     */     
/* 831 */     byte b1 = 0;
/* 832 */     for (byte b2 = 0; b2 < this.e.size; b2++) {
/*     */       QuadRegion quadRegion;
/* 834 */       if ((quadRegion = ((QuadRegion[])this.e.items)[b2]).isVisible()) {
/*     */ 
/*     */ 
/*     */         
/* 838 */         Prepared.a().set(b1, quadRegion);
/*     */         
/* 840 */         if (quadRegion.getNinePathRegion() == 0) {
/*     */           
/* 842 */           float f5 = quadRegion.getX() * f3 * paramFloat5;
/* 843 */           float f6 = quadRegion.getY() * f4 * paramFloat6;
/* 844 */           if (paramFloat7 != 0.0F) {
/* 845 */             float f7 = f5;
/* 846 */             float f8 = f6;
/* 847 */             f5 = f1 * f7 - f2 * f8;
/* 848 */             f6 = f2 * f7 + f1 * f8;
/*     */             
/* 850 */             if (this.debugging) {
/* 851 */               b.d("apply rotation: pXo: %s, pYo: %s, pX: %s, pY: %s, cos: %s, sin: %s", new Object[] { Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f1), Float.valueOf(f2) });
/* 852 */               b.d("  r.x: %s, r.y: %s, rsX: %s, rsY: %s, scaleX: %s, scaleY: %s", new Object[] { Float.valueOf(quadRegion.getX()), Float.valueOf(quadRegion.getY()), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(paramFloat5), Float.valueOf(paramFloat6) });
/*     */             } 
/*     */           } 
/*     */           
/* 856 */           arrayOfFloat[b1 << 2] = paramFloat1 + f5;
/* 857 */           arrayOfFloat[(b1 << 2) + 1] = paramFloat2 + f6;
/* 858 */           arrayOfFloat[(b1 << 2) + 2] = quadRegion.getWidth() * f3;
/* 859 */           arrayOfFloat[(b1 << 2) + 3] = quadRegion.getHeight() * f4;
/*     */           
/* 861 */           if (this.debugging) {
/* 862 */             b.d("x: %s, y: %s, w: %s, h: %s", new Object[] { Float.valueOf(arrayOfFloat[b1 << 2]), Float.valueOf(arrayOfFloat[(b1 << 2) + 1]), Float.valueOf(arrayOfFloat[(b1 << 2) + 2]), Float.valueOf(arrayOfFloat[(b1 << 2) + 3]) });
/*     */           }
/*     */         } else {
/*     */           
/* 866 */           byte[] arrayOfByte = d[quadRegion.getNinePathRegion() - 1];
/* 867 */           float f7 = paramFloat3 - this.f;
/* 868 */           float f8 = paramFloat4 - this.g;
/* 869 */           float f9 = arrayOfByte[0] * f7 + quadRegion.getX();
/* 870 */           float f10 = arrayOfByte[1] * f8 + quadRegion.getY();
/* 871 */           arrayOfFloat[(b1 << 2) + 2] = arrayOfByte[2] * f7 + quadRegion.getWidth();
/* 872 */           arrayOfFloat[(b1 << 2) + 3] = arrayOfByte[3] * f8 + quadRegion.getHeight();
/*     */           
/* 874 */           float f5 = f9 * paramFloat5;
/* 875 */           float f6 = f10 * paramFloat6;
/* 876 */           if (paramFloat7 != 0.0F) {
/* 877 */             f7 = f5;
/* 878 */             f6 = f6;
/* 879 */             f5 = f1 * f7 - f2 * f6;
/* 880 */             f6 = f2 * f7 + f1 * f6;
/*     */           } 
/*     */           
/* 883 */           arrayOfFloat[b1 << 2] = paramFloat1 + f5;
/* 884 */           arrayOfFloat[(b1 << 2) + 1] = paramFloat2 + f6;
/*     */         } 
/* 886 */         b1++;
/*     */       } 
/* 888 */     }  Prepared.a(b1);
/*     */   }
/*     */   
/*     */   public final void drawToCache(SpriteCache paramSpriteCache, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 892 */     a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F, 0.0F);
/* 893 */     for (byte b = 0; b < Prepared.c(); b++) {
/* 894 */       float[] arrayOfFloat = (Prepared.b()).items;
/* 895 */       ((QuadRegion[])(Prepared.a()).items)[b].drawToCache(paramSpriteCache, arrayOfFloat[b << 2], arrayOfFloat[(b << 2) + 1], arrayOfFloat[(b << 2) + 2], arrayOfFloat[(b << 2) + 3]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 902 */     if (this.debugging) {
/* 903 */       b.i("draw 4f", new Object[0]);
/*     */     }
/* 905 */     a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F, 0.0F);
/* 906 */     for (byte b = 0; b < Prepared.c(); b++) {
/* 907 */       float[] arrayOfFloat = (Prepared.b()).items;
/* 908 */       ((QuadRegion[])(Prepared.a()).items)[b].draw(paramBatch, arrayOfFloat[b << 2], arrayOfFloat[(b << 2) + 1], arrayOfFloat[(b << 2) + 2], arrayOfFloat[(b << 2) + 3]);
/*     */     } 
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 914 */     if (this.debugging) {
/* 915 */       b.d("draw B7f", new Object[0]);
/*     */     }
/* 917 */     draw(paramBatch, paramFloat1, paramFloat2, this.h, this.i, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 923 */     if (this.debugging) {
/* 924 */       b.d("draw B9f", new Object[0]);
/*     */     }
/* 926 */     a(paramFloat1, paramFloat2, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
/* 927 */     for (byte b = 0; b < Prepared.c(); b++) {
/* 928 */       float[] arrayOfFloat = (Prepared.b()).items;
/* 929 */       ((QuadRegion[])(Prepared.a()).items)[b].a(paramBatch, arrayOfFloat[b << 2], arrayOfFloat[(b << 2) + 1], paramFloat3, paramFloat4, arrayOfFloat[(b << 2) + 2], arrayOfFloat[(b << 2) + 3], paramFloat7, paramFloat8, Prepared.d(), Prepared.e());
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void drawDebug(ShapeRenderer paramShapeRenderer, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 934 */     a(paramFloat1, paramFloat2, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
/* 935 */     for (byte b = 0; b < Prepared.c(); b++) {
/* 936 */       float[] arrayOfFloat = (Prepared.b()).items;
/* 937 */       ((QuadRegion[])(Prepared.a()).items)[b].drawDebug(paramShapeRenderer, arrayOfFloat[b << 2], arrayOfFloat[(b << 2) + 1], paramFloat3, paramFloat4, arrayOfFloat[(b << 2) + 2], arrayOfFloat[(b << 2) + 3], paramFloat7, paramFloat8, Prepared.d(), Prepared.e());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\Quad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */