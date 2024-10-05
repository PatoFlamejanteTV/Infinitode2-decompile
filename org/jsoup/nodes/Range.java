/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Range
/*     */ {
/*  13 */   private static final Position UntrackedPos = new Position(-1, -1, -1);
/*     */   
/*     */   private final Position start;
/*     */   private final Position end;
/*  17 */   static final Range Untracked = new Range(UntrackedPos, UntrackedPos);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Range(Position paramPosition1, Position paramPosition2) {
/*  25 */     this.start = paramPosition1;
/*  26 */     this.end = paramPosition2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Position start() {
/*  34 */     return this.start;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int startPos() {
/*  43 */     return this.start.pos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Position end() {
/*  51 */     return this.end;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int endPos() {
/*  60 */     return this.end.pos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTracked() {
/*  68 */     return (this != Untracked);
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
/*     */   public boolean isImplicit() {
/*  81 */     if (!isTracked()) return false; 
/*  82 */     return this.start.equals(this.end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Range of(Node paramNode, boolean paramBoolean) {
/*  92 */     String str = paramBoolean ? "jsoup.start" : "jsoup.end";
/*  93 */     if (!paramNode.hasAttributes()) return Untracked; 
/*     */     Object object;
/*  95 */     return ((object = paramNode.attributes().userData(str)) != null) ? (Range)object : Untracked;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void track(Node paramNode, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 106 */     if (this == paramObject) return true; 
/* 107 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 109 */     paramObject = paramObject;
/*     */     
/* 111 */     if (!this.start.equals(((Range)paramObject).start)) return false; 
/* 112 */     return this.end.equals(((Range)paramObject).end);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 117 */     int i = this.start.hashCode();
/*     */     
/* 119 */     return i = i * 31 + this.end.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 128 */     return this.start + "-" + this.end;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Position
/*     */   {
/*     */     private final int pos;
/*     */ 
/*     */     
/*     */     private final int lineNumber;
/*     */ 
/*     */     
/*     */     private final int columnNumber;
/*     */ 
/*     */ 
/*     */     
/*     */     public Position(int param1Int1, int param1Int2, int param1Int3) {
/* 147 */       this.pos = param1Int1;
/* 148 */       this.lineNumber = param1Int2;
/* 149 */       this.columnNumber = param1Int3;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int pos() {
/* 158 */       return this.pos;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int lineNumber() {
/* 166 */       return this.lineNumber;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int columnNumber() {
/* 175 */       return this.columnNumber;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isTracked() {
/* 183 */       return (this != Range.UntrackedPos);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 192 */       return this.lineNumber + "," + this.columnNumber + ":" + this.pos;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 197 */       if (this == param1Object) return true; 
/* 198 */       if (param1Object == null || getClass() != param1Object.getClass()) return false; 
/* 199 */       param1Object = param1Object;
/* 200 */       if (this.pos != ((Position)param1Object).pos) return false; 
/* 201 */       if (this.lineNumber != ((Position)param1Object).lineNumber) return false; 
/* 202 */       return (this.columnNumber == ((Position)param1Object).columnNumber);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 207 */       int i = this.pos;
/* 208 */       i = i * 31 + this.lineNumber;
/*     */       
/* 210 */       return i = i * 31 + this.columnNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class AttributeRange {
/* 215 */     static final AttributeRange UntrackedAttr = new AttributeRange(Range.Untracked, Range.Untracked);
/*     */     
/*     */     private final Range nameRange;
/*     */     
/*     */     private final Range valueRange;
/*     */     
/*     */     public AttributeRange(Range param1Range1, Range param1Range2) {
/* 222 */       this.nameRange = param1Range1;
/* 223 */       this.valueRange = param1Range2;
/*     */     }
/*     */ 
/*     */     
/*     */     public Range nameRange() {
/* 228 */       return this.nameRange;
/*     */     }
/*     */ 
/*     */     
/*     */     public Range valueRange() {
/* 233 */       return this.valueRange;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 240 */       return nameRange().toString() + "=" + valueRange().toString();
/*     */     }
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 244 */       if (this == param1Object) return true; 
/* 245 */       if (param1Object == null || getClass() != param1Object.getClass()) return false;
/*     */       
/* 247 */       param1Object = param1Object;
/*     */       
/* 249 */       if (!this.nameRange.equals(((AttributeRange)param1Object).nameRange)) return false; 
/* 250 */       return this.valueRange.equals(((AttributeRange)param1Object).valueRange);
/*     */     }
/*     */     
/*     */     public int hashCode() {
/* 254 */       int i = this.nameRange.hashCode();
/*     */       
/* 256 */       return i = i * 31 + this.valueRange.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\Range.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */