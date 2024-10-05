/*     */ package com.badlogic.gdx.ai.steer.utils.paths;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.utils.Path;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LinePath<T extends Vector<T>>
/*     */   implements Path<T, LinePath.LinePathParam>
/*     */ {
/*     */   private Array<Segment<T>> segments;
/*     */   private boolean isOpen;
/*     */   private float pathLength;
/*     */   private T nearestPointOnCurrentSegment;
/*     */   private T nearestPointOnPath;
/*     */   private T tmpB;
/*     */   private T tmpC;
/*     */   
/*     */   public LinePath(Array<T> paramArray) {
/*  46 */     this(paramArray, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LinePath(Array<T> paramArray, boolean paramBoolean) {
/*  54 */     this.isOpen = paramBoolean;
/*  55 */     createPath(paramArray);
/*  56 */     this.nearestPointOnCurrentSegment = (T)((Vector)paramArray.first()).cpy();
/*  57 */     this.nearestPointOnPath = (T)((Vector)paramArray.first()).cpy();
/*  58 */     this.tmpB = (T)((Vector)paramArray.first()).cpy();
/*  59 */     this.tmpC = (T)((Vector)paramArray.first()).cpy();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpen() {
/*  64 */     return this.isOpen;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getLength() {
/*  69 */     return this.pathLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getStartPoint() {
/*  74 */     return ((Segment)this.segments.first()).begin;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getEndPoint() {
/*  79 */     return ((Segment)this.segments.peek()).end;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float calculatePointSegmentSquareDistance(T paramT1, T paramT2, T paramT3, T paramT4) {
/*  89 */     paramT1.set((Vector)paramT2);
/*  90 */     this.tmpB.set((Vector)paramT3);
/*  91 */     this.tmpC.set((Vector)paramT4);
/*     */     
/*     */     Vector vector;
/*     */     float f;
/*  95 */     if ((f = (vector = this.tmpB.sub((Vector)paramT2)).len2()) != 0.0F) {
/*  96 */       float f1 = this.tmpC.sub((Vector)paramT2).dot(vector) / f;
/*  97 */       paramT1.mulAdd(vector, MathUtils.clamp(f1, 0.0F, 1.0F));
/*     */     } 
/*     */     
/* 100 */     return paramT1.dst2((Vector)paramT4);
/*     */   }
/*     */ 
/*     */   
/*     */   public LinePathParam createParam() {
/* 105 */     return new LinePathParam();
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
/*     */   
/*     */   public float calculateDistance(T paramT, LinePathParam paramLinePathParam) {
/* 118 */     float f1 = Float.POSITIVE_INFINITY;
/* 119 */     Segment segment = null;
/* 120 */     for (byte b = 0; b < this.segments.size; b++) {
/* 121 */       Segment segment1 = (Segment)this.segments.get(b);
/*     */ 
/*     */       
/*     */       float f;
/*     */       
/* 126 */       if ((f = calculatePointSegmentSquareDistance(this.nearestPointOnCurrentSegment, segment1.begin, segment1.end, paramT)) < f1) {
/* 127 */         this.nearestPointOnPath.set((Vector)this.nearestPointOnCurrentSegment);
/* 128 */         f1 = f;
/* 129 */         segment = segment1;
/* 130 */         paramLinePathParam.segmentIndex = b;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 135 */     float f2 = segment.cumulativeLength - this.nearestPointOnPath.dst((Vector)segment.end);
/*     */     
/* 137 */     paramLinePathParam.setDistance(f2);
/*     */     
/* 139 */     return f2;
/*     */   }
/*     */   
/*     */   public void calculateTargetPosition(T paramT, LinePathParam paramLinePathParam, float paramFloat) {
/*     */     Segment segment;
/* 144 */     if (this.isOpen) {
/*     */       
/* 146 */       if (paramFloat < 0.0F) {
/*     */         
/* 148 */         paramFloat = 0.0F;
/* 149 */       } else if (paramFloat > this.pathLength) {
/*     */         
/* 151 */         paramFloat = this.pathLength;
/*     */       }
/*     */     
/*     */     }
/* 155 */     else if (paramFloat < 0.0F) {
/*     */       
/* 157 */       paramFloat = this.pathLength + paramFloat % this.pathLength;
/* 158 */     } else if (paramFloat > this.pathLength) {
/*     */       
/* 160 */       paramFloat %= this.pathLength;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 165 */     paramLinePathParam = null;
/* 166 */     for (byte b = 0; b < this.segments.size; b++) {
/*     */       Segment segment1;
/* 168 */       if ((segment1 = (Segment)this.segments.get(b)).cumulativeLength >= paramFloat) {
/* 169 */         segment = segment1;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 175 */     float f = segment.cumulativeLength - paramFloat;
/*     */     
/* 177 */     paramT.set((Vector)segment.begin).sub((Vector)segment.end).scl(f / segment.length).add((Vector)segment.end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createPath(Array<T> paramArray) {
/* 184 */     if (paramArray == null || paramArray.size < 2) {
/* 185 */       throw new IllegalArgumentException("waypoints cannot be null and must contain at least two (2) waypoints");
/*     */     }
/* 187 */     this.segments = new Array(paramArray.size);
/* 188 */     this.pathLength = 0.0F;
/* 189 */     Vector vector = (Vector)paramArray.first();
/*     */     
/* 191 */     for (byte b = 1; b <= paramArray.size; b++) {
/* 192 */       Vector vector1 = vector;
/* 193 */       if (b < paramArray.size)
/* 194 */       { vector = (Vector)paramArray.get(b); }
/* 195 */       else if (!this.isOpen)
/*     */       
/*     */       { 
/* 198 */         vector = (Vector)paramArray.first(); } else { break; }
/* 199 */        Segment<Vector> segment = new Segment<>(vector1, vector);
/* 200 */       this.pathLength += segment.length;
/* 201 */       segment.cumulativeLength = this.pathLength;
/* 202 */       this.segments.add(segment);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Array<Segment<T>> getSegments() {
/* 207 */     return this.segments;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class LinePathParam
/*     */     implements Path.PathParam
/*     */   {
/*     */     int segmentIndex;
/*     */     
/*     */     float distance;
/*     */     
/*     */     public float getDistance() {
/* 219 */       return this.distance;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setDistance(float param1Float) {
/* 224 */       this.distance = param1Float;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSegmentIndex() {
/* 229 */       return this.segmentIndex;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Segment<T extends Vector<T>>
/*     */   {
/*     */     T begin;
/*     */ 
/*     */     
/*     */     T end;
/*     */ 
/*     */     
/*     */     float length;
/*     */     
/*     */     float cumulativeLength;
/*     */ 
/*     */     
/*     */     Segment(T param1T1, T param1T2) {
/* 249 */       this.begin = param1T1;
/* 250 */       this.end = param1T2;
/* 251 */       this.length = param1T1.dst((Vector)param1T2);
/*     */     }
/*     */ 
/*     */     
/*     */     public T getBegin() {
/* 256 */       return this.begin;
/*     */     }
/*     */ 
/*     */     
/*     */     public T getEnd() {
/* 261 */       return this.end;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getLength() {
/* 266 */       return this.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getCumulativeLength() {
/* 271 */       return this.cumulativeLength;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\stee\\utils\paths\LinePath.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */