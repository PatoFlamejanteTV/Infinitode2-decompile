/*     */ package com.vladsch.flexmark.util.misc;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Stack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DelimitedBuilder
/*     */ {
/*     */   private String delimiter;
/*     */   private StringBuilder out;
/*     */   private boolean pending = false;
/*  32 */   private int lastLen = 0;
/*  33 */   private Stack<String> delimiterStack = null;
/*     */   
/*     */   public DelimitedBuilder() {
/*  36 */     this(",", 0);
/*     */   }
/*     */   
/*     */   public DelimitedBuilder(String paramString) {
/*  40 */     this(paramString, 0);
/*     */   }
/*     */   
/*     */   public DelimitedBuilder(String paramString, int paramInt) {
/*  44 */     this.delimiter = paramString;
/*  45 */     this.out = (paramInt == 0) ? null : new StringBuilder(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  50 */     if (this.delimiterStack != null && !this.delimiterStack.isEmpty()) throw new IllegalStateException("Delimiter stack is not empty"); 
/*  51 */     return (this.out == null) ? "" : this.out.toString();
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  55 */     return (!this.pending && (this.out == null || this.out.length() == 0));
/*     */   }
/*     */   
/*     */   public String getAndClear() {
/*  59 */     if (this.delimiterStack != null && !this.delimiterStack.isEmpty()) throw new IllegalStateException("Delimiter stack is not empty"); 
/*  60 */     String str = (this.out == null) ? "" : this.out.toString();
/*  61 */     clear();
/*  62 */     return str;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder clear() {
/*  66 */     this.out = null;
/*  67 */     unmark();
/*  68 */     return this;
/*     */   }
/*     */   
/*     */   public String toStringOrNull() {
/*  72 */     if (this.delimiterStack != null && !this.delimiterStack.isEmpty()) throw new IllegalStateException("Delimiter stack is not empty"); 
/*  73 */     return (this.out == null) ? null : this.out.toString();
/*     */   }
/*     */   
/*     */   public DelimitedBuilder mark() {
/*  77 */     boolean bool = (this.out != null) ? this.out.length() : false;
/*  78 */     if (this.lastLen != bool) this.pending = true; 
/*  79 */     this.lastLen = bool;
/*  80 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder unmark() {
/*  84 */     this.pending = false;
/*  85 */     this.lastLen = (this.out != null) ? this.out.length() : 0;
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder push() {
/*  90 */     return push(this.delimiter);
/*     */   }
/*     */   
/*     */   public DelimitedBuilder push(String paramString) {
/*  94 */     unmark();
/*  95 */     if (this.delimiterStack == null) this.delimiterStack = new Stack<>(); 
/*  96 */     this.delimiterStack.push(this.delimiter);
/*  97 */     this.delimiter = paramString;
/*  98 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder pop() {
/* 102 */     if (this.delimiterStack == null || this.delimiterStack.isEmpty()) throw new IllegalStateException("Nothing on the delimiter stack"); 
/* 103 */     this.delimiter = this.delimiterStack.pop();
/* 104 */     return this;
/*     */   }
/*     */   
/*     */   private void doPending() {
/* 108 */     if (this.out == null) this.out = new StringBuilder();
/*     */     
/* 110 */     if (this.pending) {
/* 111 */       this.out.append(this.delimiter);
/* 112 */       this.pending = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(char paramChar) {
/* 117 */     doPending();
/* 118 */     this.out.append(paramChar);
/* 119 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(int paramInt) {
/* 123 */     doPending();
/* 124 */     this.out.append(paramInt);
/* 125 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(boolean paramBoolean) {
/* 129 */     doPending();
/* 130 */     this.out.append(paramBoolean);
/* 131 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(long paramLong) {
/* 135 */     doPending();
/* 136 */     this.out.append(paramLong);
/* 137 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(float paramFloat) {
/* 141 */     doPending();
/* 142 */     this.out.append(paramFloat);
/* 143 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(double paramDouble) {
/* 147 */     doPending();
/* 148 */     this.out.append(paramDouble);
/* 149 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(String paramString) {
/* 153 */     if (paramString != null && !paramString.isEmpty()) {
/* 154 */       doPending();
/* 155 */       this.out.append(paramString);
/*     */     } 
/* 157 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(String paramString, int paramInt1, int paramInt2) {
/* 161 */     if (paramString != null && paramInt1 < paramInt2) {
/* 162 */       doPending();
/* 163 */       this.out.append(paramString, paramInt1, paramInt2);
/*     */     } 
/* 165 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(CharSequence paramCharSequence) {
/* 169 */     if (paramCharSequence != null && paramCharSequence.length() > 0) {
/* 170 */       doPending();
/* 171 */       this.out.append(paramCharSequence);
/*     */     } 
/* 173 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 177 */     if (paramCharSequence != null && paramInt1 < paramInt2) {
/* 178 */       doPending();
/* 179 */       this.out.append(paramCharSequence, paramInt1, paramInt2);
/*     */     } 
/* 181 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(char[] paramArrayOfchar) {
/* 185 */     if (paramArrayOfchar.length > 0) {
/* 186 */       doPending();
/* 187 */       this.out.append(paramArrayOfchar);
/*     */     } 
/* 189 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 193 */     if (paramInt1 < paramInt2) {
/* 194 */       doPending();
/* 195 */       this.out.append(paramArrayOfchar, paramInt1, paramInt2);
/*     */     } 
/* 197 */     return this;
/*     */   }
/*     */   
/*     */   public DelimitedBuilder append(Object paramObject) {
/* 201 */     return append(paramObject.toString());
/*     */   }
/*     */   
/*     */   public DelimitedBuilder appendCodePoint(int paramInt) {
/* 205 */     doPending();
/* 206 */     this.out.appendCodePoint(paramInt);
/* 207 */     return this;
/*     */   }
/*     */   
/*     */   public <V> DelimitedBuilder appendAll(V[] paramArrayOfV) {
/* 211 */     return appendAll(paramArrayOfV, 0, paramArrayOfV.length);
/*     */   }
/*     */   
/*     */   public <V> DelimitedBuilder appendAll(V[] paramArrayOfV, int paramInt1, int paramInt2) {
/* 215 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/* 216 */       V v = paramArrayOfV[paramInt1];
/* 217 */       append(v.toString());
/* 218 */       mark();
/*     */     } 
/* 220 */     return this;
/*     */   }
/*     */   
/*     */   public <V> DelimitedBuilder appendAll(String paramString, V[] paramArrayOfV) {
/* 224 */     return appendAll(paramString, paramArrayOfV, 0, paramArrayOfV.length);
/*     */   }
/*     */   
/*     */   public <V> DelimitedBuilder appendAll(String paramString, V[] paramArrayOfV, int paramInt1, int paramInt2) {
/* 228 */     boolean bool = (this.out != null) ? this.out.length() : false;
/* 229 */     push(paramString);
/* 230 */     appendAll(paramArrayOfV, paramInt1, paramInt2);
/* 231 */     pop();
/*     */     
/* 233 */     if (bool != ((this.out != null) ? this.out.length() : false)) { mark(); }
/* 234 */     else { unmark(); }
/*     */     
/* 236 */     return this;
/*     */   }
/*     */   
/*     */   public <V> DelimitedBuilder appendAll(List<? extends V> paramList) {
/* 240 */     return appendAll(paramList, 0, paramList.size());
/*     */   }
/*     */   
/*     */   public <V> DelimitedBuilder appendAll(List<? extends V> paramList, int paramInt1, int paramInt2) {
/* 244 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/* 245 */       V v = paramList.get(paramInt1);
/* 246 */       append(v.toString());
/* 247 */       mark();
/*     */     } 
/* 249 */     return this;
/*     */   }
/*     */   
/*     */   public <V> DelimitedBuilder appendAll(String paramString, List<? extends V> paramList) {
/* 253 */     return appendAll(paramString, paramList, 0, paramList.size());
/*     */   }
/*     */   
/*     */   public <V> DelimitedBuilder appendAll(String paramString, List<? extends V> paramList, int paramInt1, int paramInt2) {
/* 257 */     boolean bool = (this.out != null) ? this.out.length() : false;
/* 258 */     push(paramString);
/* 259 */     appendAll(paramList, paramInt1, paramInt2);
/* 260 */     pop();
/*     */     
/* 262 */     if (bool != ((this.out != null) ? this.out.length() : false)) { mark(); }
/* 263 */     else { unmark(); }
/*     */     
/* 265 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\DelimitedBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */