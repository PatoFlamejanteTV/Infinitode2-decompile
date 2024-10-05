/*     */ package com.vladsch.flexmark.util.sequence.builder;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.DelimitedBuilder;
/*     */ 
/*     */ public class SegmentStats
/*     */ {
/*     */   public static final int NULL_REPEATED_CHAR = -1;
/*     */   public static final int NOT_REPEATED_CHAR = -2;
/*   9 */   protected int textLength = 0;
/*  10 */   protected int textSegments = 0;
/*  11 */   protected int textSegmentLength = 0;
/*     */   
/*  13 */   protected int textSpaceLength = 0;
/*  14 */   protected int textSpaceSegments = 0;
/*  15 */   protected int textSpaceSegmentLength = 0;
/*     */   
/*  17 */   protected int textFirst256Length = 0;
/*  18 */   protected int textFirst256Segments = 0;
/*  19 */   protected int textFirst256SegmentLength = 0;
/*     */   
/*  21 */   protected int repeatedChar = -1;
/*     */   
/*     */   protected final boolean trackFirst256;
/*     */   
/*     */   public SegmentStats(boolean paramBoolean) {
/*  26 */     this.trackFirst256 = paramBoolean;
/*     */   }
/*     */   
/*     */   public int getTextLength() {
/*  30 */     return this.textLength;
/*     */   }
/*     */   
/*     */   public int getTextSpaceLength() {
/*  34 */     return this.textSpaceLength;
/*     */   }
/*     */   
/*     */   public int getTextFirst256Length() {
/*  38 */     return this.textFirst256Length;
/*     */   }
/*     */   
/*     */   public boolean isTrackTextFirst256() {
/*  42 */     return this.trackFirst256;
/*     */   }
/*     */   
/*     */   public int getTextSegments() {
/*  46 */     return this.textSegments;
/*     */   }
/*     */   
/*     */   public int getTextSpaceSegments() {
/*  50 */     return this.textSpaceSegments;
/*     */   }
/*     */   
/*     */   public int getTextFirst256Segments() {
/*  54 */     return this.textFirst256Segments;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  58 */     return (this.textLength == 0 && this.textSegments == 0 && this.textSegmentLength == 0 && (!this.trackFirst256 || (this.textSpaceLength == 0 && this.textSpaceSegments == 0 && this.textSpaceSegmentLength == 0 && this.textFirst256Length == 0 && this.textFirst256Segments == 0 && this.textFirst256SegmentLength == 0)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/*  69 */     return (this.textLength >= this.textSegments && (!this.trackFirst256 || (this.textLength >= this.textFirst256Length && this.textSegments >= this.textFirst256Segments && this.textFirst256Length >= this.textFirst256Segments && this.textFirst256Length >= this.textSpaceLength && this.textFirst256Segments >= this.textSpaceSegments && this.textSpaceLength >= this.textSpaceSegments)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SegmentStats committedCopy() {
/*     */     SegmentStats segmentStats;
/*  78 */     (segmentStats = new SegmentStats(this.trackFirst256)).textLength = this.textLength;
/*  79 */     segmentStats.textSegments = this.textSegments;
/*  80 */     segmentStats.textSegmentLength = this.textSegmentLength;
/*     */     
/*  82 */     if (this.trackFirst256) {
/*  83 */       segmentStats.textSpaceLength = this.textSpaceLength;
/*  84 */       segmentStats.textSpaceSegments = this.textSpaceSegments;
/*  85 */       segmentStats.textSpaceSegmentLength = this.textSpaceSegmentLength;
/*  86 */       segmentStats.textFirst256Length = this.textFirst256Length;
/*  87 */       segmentStats.textFirst256Segments = this.textFirst256Segments;
/*  88 */       segmentStats.textFirst256SegmentLength = this.textFirst256SegmentLength;
/*     */     } 
/*     */     
/*  91 */     segmentStats.commitText();
/*  92 */     return segmentStats;
/*     */   }
/*     */   
/*     */   public void clear() {
/*  96 */     this.textLength = 0;
/*  97 */     this.textSegments = 0;
/*  98 */     this.textSegmentLength = 0;
/*  99 */     this.repeatedChar = -1;
/*     */     
/* 101 */     if (this.trackFirst256) {
/* 102 */       this.textSpaceLength = 0;
/* 103 */       this.textSpaceSegments = 0;
/* 104 */       this.textSpaceSegmentLength = 0;
/* 105 */       this.textFirst256Length = 0;
/* 106 */       this.textFirst256Segments = 0;
/* 107 */       this.textFirst256SegmentLength = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void add(SegmentStats paramSegmentStats) {
/* 112 */     this.textLength += paramSegmentStats.textLength;
/* 113 */     this.textSegments += paramSegmentStats.textSegments;
/*     */     
/* 115 */     if (this.trackFirst256 && paramSegmentStats.trackFirst256) {
/* 116 */       this.textSpaceLength += paramSegmentStats.textSpaceLength;
/* 117 */       this.textSpaceSegments += paramSegmentStats.textSpaceSegments;
/* 118 */       this.textFirst256Length += paramSegmentStats.textFirst256Length;
/* 119 */       this.textFirst256Segments += paramSegmentStats.textFirst256Segments;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void remove(SegmentStats paramSegmentStats) {
/* 124 */     assert this.textLength >= paramSegmentStats.textLength;
/* 125 */     assert this.textSegments >= paramSegmentStats.textSegments;
/* 126 */     this.textLength -= paramSegmentStats.textLength;
/* 127 */     this.textSegments -= paramSegmentStats.textSegments;
/*     */ 
/*     */     
/* 130 */     this.textSegmentLength = this.textLength;
/*     */     
/* 132 */     if (this.trackFirst256 && paramSegmentStats.trackFirst256) {
/* 133 */       assert this.textSpaceLength >= paramSegmentStats.textSpaceLength;
/* 134 */       assert this.textSpaceSegments >= paramSegmentStats.textSpaceSegments;
/* 135 */       assert this.textFirst256Length >= paramSegmentStats.textFirst256Length;
/* 136 */       assert this.textFirst256Segments >= paramSegmentStats.textFirst256Segments;
/*     */       
/* 138 */       this.textSpaceLength -= paramSegmentStats.textSpaceLength;
/* 139 */       this.textSpaceSegments -= paramSegmentStats.textSpaceSegments;
/* 140 */       this.textFirst256Length -= paramSegmentStats.textFirst256Length;
/* 141 */       this.textFirst256Segments -= paramSegmentStats.textFirst256Segments;
/*     */ 
/*     */       
/* 144 */       this.textSpaceSegmentLength = this.textSpaceLength;
/* 145 */       this.textFirst256SegmentLength = this.textFirst256Length;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isTextFirst256() {
/* 150 */     int i = this.textLength - this.textSegmentLength;
/* 151 */     return (this.textFirst256Length - this.textFirst256SegmentLength == i);
/*     */   }
/*     */   
/*     */   public boolean isTextRepeatedSpace() {
/* 155 */     int i = this.textLength - this.textSegmentLength;
/* 156 */     return (this.textSpaceLength - this.textSpaceSegmentLength == i);
/*     */   }
/*     */   
/*     */   public boolean isRepeatedText() {
/* 160 */     return (this.repeatedChar >= 0);
/*     */   }
/*     */   
/*     */   public void commitText() {
/* 164 */     if (this.textLength > this.textSegmentLength) {
/* 165 */       this.textSegments++;
/* 166 */       this.repeatedChar = -1;
/*     */       
/* 168 */       if (this.trackFirst256) {
/* 169 */         int i = this.textLength - this.textSegmentLength;
/*     */         
/* 171 */         if (this.textSpaceLength - this.textSpaceSegmentLength == i) this.textSpaceSegments++; 
/* 172 */         if (this.textFirst256Length - this.textFirst256SegmentLength == i) this.textFirst256Segments++;
/*     */       
/*     */       } 
/* 175 */       this.textSegmentLength = this.textLength;
/* 176 */       if (this.trackFirst256) {
/* 177 */         this.textSpaceSegmentLength = this.textSpaceLength;
/* 178 */         this.textFirst256SegmentLength = this.textFirst256Length;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addText(CharSequence paramCharSequence) {
/* 185 */     this.textLength += paramCharSequence.length();
/*     */     
/* 187 */     if (this.trackFirst256) {
/* 188 */       int i = paramCharSequence.length();
/* 189 */       for (byte b = 0; b < i; b++) {
/* 190 */         char c = paramCharSequence.charAt(b);
/*     */         
/* 192 */         if (this.repeatedChar == -1) {
/* 193 */           this.repeatedChar = c;
/* 194 */         } else if (this.repeatedChar != c) {
/* 195 */           this.repeatedChar = -2;
/*     */         } 
/*     */         
/* 198 */         if (c < 'Ā') {
/* 199 */           if (c == ' ') this.textSpaceLength++; 
/* 200 */           this.textFirst256Length++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addText(char paramChar) {
/* 208 */     this.textLength++;
/*     */     
/* 210 */     if (this.trackFirst256) {
/* 211 */       if (this.repeatedChar == -1) {
/* 212 */         this.repeatedChar = paramChar;
/* 213 */       } else if (this.repeatedChar != paramChar) {
/* 214 */         this.repeatedChar = -2;
/*     */       } 
/*     */       
/* 217 */       if (paramChar < 'Ā') {
/* 218 */         if (paramChar == ' ') this.textSpaceLength++; 
/* 219 */         this.textFirst256Length++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addText(char paramChar, int paramInt) {
/* 225 */     assert paramInt > 0;
/*     */ 
/*     */     
/* 228 */     this.textLength += paramInt;
/*     */     
/* 230 */     if (this.trackFirst256) {
/* 231 */       if (this.repeatedChar == -1) {
/* 232 */         this.repeatedChar = paramChar;
/* 233 */       } else if (this.repeatedChar != paramChar) {
/* 234 */         this.repeatedChar = -2;
/*     */       } 
/*     */       
/* 237 */       if (paramChar < 'Ā') {
/* 238 */         if (paramChar == ' ') this.textSpaceLength += paramInt; 
/* 239 */         this.textFirst256Length += paramInt;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removeText(CharSequence paramCharSequence) {
/* 245 */     this.textLength -= paramCharSequence.length();
/*     */     
/* 247 */     if (this.trackFirst256) {
/* 248 */       int i = paramCharSequence.length();
/* 249 */       for (byte b = 0; b < i; b++) {
/* 250 */         char c = paramCharSequence.charAt(b);
/* 251 */         if (this.repeatedChar == -1) {
/* 252 */           this.repeatedChar = c;
/* 253 */         } else if (this.repeatedChar != c) {
/* 254 */           this.repeatedChar = -2;
/*     */         } 
/*     */         
/* 257 */         if (c < 'Ā') {
/* 258 */           if (c == ' ') {
/* 259 */             assert this.textSpaceLength > 0;
/* 260 */             this.textSpaceLength--;
/*     */           } 
/*     */           
/* 263 */           assert this.textFirst256Length > 0;
/* 264 */           this.textFirst256Length--;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 270 */     if (this.textLength == this.textSegmentLength) this.repeatedChar = -1;
/*     */   
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     DelimitedBuilder delimitedBuilder;
/* 276 */     (delimitedBuilder = new DelimitedBuilder(", ")).append("s=").append(this.textSpaceSegments).append(":").append(this.textSpaceLength).mark()
/* 277 */       .append("u=").append(this.textFirst256Segments).append(":").append(this.textFirst256Length).mark()
/* 278 */       .append("t=").append(this.textSegments).append(":").append(this.textLength);
/*     */ 
/*     */     
/* 281 */     return delimitedBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\SegmentStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */