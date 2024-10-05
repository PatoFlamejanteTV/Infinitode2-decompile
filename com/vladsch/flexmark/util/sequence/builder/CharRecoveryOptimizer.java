/*     */ package com.vladsch.flexmark.util.sequence.builder;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.PositionAnchor;
/*     */ import com.vladsch.flexmark.util.sequence.Range;
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ 
/*     */ public class CharRecoveryOptimizer
/*     */   implements SegmentOptimizer
/*     */ {
/*     */   private final PositionAnchor anchor;
/*     */   private int prevEolPos;
/*     */   
/*     */   public CharRecoveryOptimizer(PositionAnchor paramPositionAnchor) {
/*  15 */     this.anchor = paramPositionAnchor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int prevMatchPos(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2) {
/*  21 */     int i = paramCharSequence2.length();
/*     */     
/*  23 */     paramInt2 = Math.min((paramInt2 = Math.min(paramCharSequence1.length(), paramInt2)) - paramInt1, i);
/*     */     
/*  25 */     for (i = 0; i < paramInt2; i++) {
/*  26 */       char c1 = paramCharSequence1.charAt(i + paramInt1);
/*  27 */       char c2 = paramCharSequence2.charAt(i);
/*     */       
/*  29 */       if (c1 == SequenceUtils.EOL_CHAR) this.prevEolPos = i + 1; 
/*  30 */       if (c2 != c1) return i; 
/*     */     } 
/*  32 */     return paramInt2;
/*     */   }
/*     */   
/*     */   int nextMatchPos(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2) {
/*  36 */     paramInt1 = Math.max(0, paramInt1);
/*  37 */     paramInt2 = Math.min(paramCharSequence1.length(), paramInt2);
/*     */     
/*  39 */     int i = paramCharSequence2.length();
/*  40 */     paramInt1 = Math.min(paramInt2 - paramInt1, i);
/*     */     
/*  42 */     paramInt2 -= paramInt1;
/*  43 */     i -= paramInt1;
/*     */     
/*  45 */     for (paramInt1 = paramInt1; paramInt1-- > 0; ) {
/*  46 */       char c1 = paramCharSequence1.charAt(paramInt2 + paramInt1);
/*     */       
/*     */       char c2;
/*  49 */       if ((c2 = paramCharSequence2.charAt(i + paramInt1)) != c1) return i + paramInt1 + 1; 
/*     */     } 
/*  51 */     return i;
/*     */   }
/*     */   
/*     */   public Object[] apply(CharSequence paramCharSequence, Object[] paramArrayOfObject) {
/*     */     Range range5;
/*  56 */     if (paramArrayOfObject.length != 3 || !(paramArrayOfObject[0] instanceof Range) || !(paramArrayOfObject[1] instanceof CharSequence) || !(paramArrayOfObject[2] instanceof Range)) return paramArrayOfObject;
/*     */     
/*  58 */     Range range1 = (Range)paramArrayOfObject[0];
/*  59 */     CharSequence charSequence = (CharSequence)paramArrayOfObject[1];
/*  60 */     Range range2 = (Range)paramArrayOfObject[2];
/*     */ 
/*     */     
/*  63 */     int i = charSequence.length();
/*  64 */     if ((range1.isNull() && range2.isNull()) || i == 0) return paramArrayOfObject;
/*     */     
/*  66 */     int j = paramCharSequence.length();
/*     */     
/*  68 */     Range range3 = range1;
/*  69 */     charSequence = charSequence;
/*  70 */     Range range4 = range2;
/*     */     
/*  72 */     this.prevEolPos = -1;
/*     */     
/*  74 */     int k = range3.isNull() ? 0 : prevMatchPos(paramCharSequence, charSequence, range3.getEnd(), range4.isNotNull() ? range4.getStart() : j);
/*  75 */     int n = range4.isNull() ? i : nextMatchPos(paramCharSequence, charSequence, range3.isNotNull() ? range3.getEnd() : 0, range4.getStart());
/*     */ 
/*     */     
/*  78 */     if (!k && n == i) {
/*     */       
/*  80 */       if (range3.isNotNull() && !SequenceUtils.endsWithEOL(paramCharSequence.subSequence(range3.getStart(), range3.getEnd())) && SequenceUtils.startsWith(charSequence, "\n"))
/*     */       {
/*     */         
/*  83 */         if ((k = SequenceUtils.endOfLine(paramCharSequence, range3.getEnd())) < j && SequenceUtils.isBlank(paramCharSequence.subSequence(range3.getEnd(), k))) {
/*     */           
/*  85 */           range5 = Range.ofLength(k, 1);
/*  86 */           charSequence = charSequence.subSequence(1, i);
/*     */           
/*  88 */           if (range4.isEmpty() && range4.getStart() < range5.getEnd())
/*     */           {
/*  90 */             range4 = Range.NULL;
/*     */           }
/*     */ 
/*     */           
/*  94 */           if (charSequence.length() == 0) {
/*     */             
/*  96 */             paramArrayOfObject[1] = range5;
/*  97 */             paramArrayOfObject[2] = range4;
/*     */           
/*     */           }
/* 100 */           else if (range3.isNull()) {
/*     */             
/* 102 */             paramArrayOfObject[0] = range5;
/* 103 */             paramArrayOfObject[1] = charSequence;
/* 104 */             paramArrayOfObject[2] = range4;
/* 105 */           } else if (range4.isNull()) {
/*     */             
/* 107 */             paramArrayOfObject[1] = range5;
/* 108 */             paramArrayOfObject[2] = charSequence;
/*     */           }
/*     */           else {
/*     */             
/* 112 */             (paramArrayOfObject = new Object[paramArrayOfObject.length + 1])[0] = range3;
/* 113 */             paramArrayOfObject[1] = range5;
/* 114 */             paramArrayOfObject[2] = charSequence;
/* 115 */             paramArrayOfObject[3] = range4;
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 120 */       return paramArrayOfObject;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 125 */     if (this.prevEolPos != -1 && this.prevEolPos < k) {
/* 126 */       k = this.prevEolPos;
/*     */ 
/*     */       
/* 129 */       if (range5 < k) {
/* 130 */         m = k;
/*     */       }
/*     */     } 
/*     */     
/* 134 */     assert m <= i : "prevRange: " + range1 + ", '" + Utils.escapeJavaString(charSequence) + "', nextRange: " + range2;
/*     */     
/* 136 */     k = k;
/* 137 */     int m = i - m;
/* 138 */     int i1 = Math.min(i, (range4.isNotNull() ? range4.getStart() : j) - (range3.isNotNull() ? range3.getEnd() : 0));
/*     */ 
/*     */     
/* 141 */     if ((i1 = k + m - i1) > 0) {
/*     */       int i2;
/*     */       
/*     */       int i3;
/*     */       
/* 146 */       assert m > 0 && k > 0 : "prevRange: " + range1 + ", '" + Utils.escapeJavaString(charSequence) + "', nextRange: " + range2;
/*     */ 
/*     */       
/* 149 */       switch (this.anchor) {
/*     */         
/*     */         case PREVIOUS:
/* 152 */           i2 = Math.min(k, i1);
/* 153 */           k -= i2;
/* 154 */           m -= i1 - i2;
/*     */           break;
/*     */ 
/*     */         
/*     */         case NEXT:
/* 159 */           i3 = Math.min(m, i1);
/* 160 */           m -= i3;
/* 161 */           k -= i1 - i3;
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 167 */           i2 = Math.min(k, i1 >> 1);
/* 168 */           k -= i2;
/* 169 */           m -= i1 - i2;
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 175 */     if (k > 0) {
/* 176 */       range3 = range3.endPlus(k);
/*     */     }
/*     */     
/* 179 */     if (m > 0) {
/* 180 */       range4 = range4.startMinus(m);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 197 */     charSequence = charSequence.subSequence(k, i - m);
/*     */     
/* 199 */     range1 = Range.NULL;
/*     */     
/* 201 */     if (range3.isNotNull() && !SequenceUtils.endsWithEOL(paramCharSequence.subSequence(range3.getStart(), range3.getEnd())) && SequenceUtils.startsWith(charSequence, "\n")) {
/*     */       int i2;
/*     */       
/* 204 */       if ((i2 = SequenceUtils.endOfLine(paramCharSequence, range3.getEnd())) < j && (range4.isNull() || i2 < range4.getStart()) && SequenceUtils.isBlank(paramCharSequence.subSequence(range3.getEnd(), i2))) {
/*     */         
/* 206 */         range1 = Range.ofLength(i2, 1);
/* 207 */         charSequence = charSequence.subSequence(1, charSequence.length());
/*     */       } 
/*     */     } 
/*     */     
/* 211 */     if (range3.isNotNull() && range4.isNotNull() && charSequence.length() == 0 && range3.isAdjacentBefore(range4)) {
/*     */       
/* 213 */       paramArrayOfObject[0] = range3.expandToInclude(range4);
/* 214 */       paramArrayOfObject[1] = null;
/* 215 */       paramArrayOfObject[2] = null;
/*     */     }
/* 217 */     else if (range1.isNotNull()) {
/*     */       
/* 219 */       if (range4.isEmpty() && range4.getStart() < range1.getEnd())
/*     */       {
/* 221 */         range4 = Range.NULL;
/*     */       }
/*     */       
/* 224 */       if (charSequence.length() == 0) {
/* 225 */         paramArrayOfObject[0] = range3;
/* 226 */         paramArrayOfObject[1] = range1;
/* 227 */         paramArrayOfObject[2] = range4;
/* 228 */       } else if (range3.isNull()) {
/* 229 */         paramArrayOfObject[0] = range1;
/* 230 */         paramArrayOfObject[1] = charSequence;
/* 231 */         paramArrayOfObject[2] = range4;
/* 232 */       } else if (range4.isNull()) {
/* 233 */         paramArrayOfObject[0] = range3;
/* 234 */         paramArrayOfObject[1] = range1;
/* 235 */         paramArrayOfObject[2] = charSequence;
/*     */       }
/*     */       else {
/*     */         
/* 239 */         (paramArrayOfObject = new Object[paramArrayOfObject.length + 1])[0] = range3;
/* 240 */         paramArrayOfObject[1] = range1;
/* 241 */         paramArrayOfObject[2] = charSequence;
/* 242 */         paramArrayOfObject[3] = range4;
/*     */       } 
/*     */     } else {
/* 245 */       paramArrayOfObject[0] = range3;
/* 246 */       paramArrayOfObject[1] = charSequence;
/* 247 */       paramArrayOfObject[2] = range4;
/*     */     } 
/*     */ 
/*     */     
/* 251 */     return paramArrayOfObject;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\CharRecoveryOptimizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */