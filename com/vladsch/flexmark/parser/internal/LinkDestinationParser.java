/*     */ package com.vladsch.flexmark.parser.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.BitSet;
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
/*     */ public class LinkDestinationParser
/*     */ {
/*     */   public final BitSet EXCLUDED_0_TO_SPACE_CHARS;
/*     */   public final BitSet JEKYLL_EXCLUDED_CHARS;
/*     */   public final BitSet PAREN_EXCLUDED_CHARS;
/*     */   public final BitSet PAREN_ESCAPABLE_CHARS;
/*     */   public final BitSet PAREN_QUOTE_CHARS;
/*     */   public final boolean allowMatchedParentheses;
/*     */   public final boolean spaceInUrls;
/*     */   public final boolean parseJekyllMacrosInUrls;
/*     */   public final boolean intellijDummyIdentifier;
/*     */   
/*     */   public LinkDestinationParser(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/*  80 */     this.allowMatchedParentheses = (paramBoolean1 || paramBoolean3);
/*  81 */     this.spaceInUrls = paramBoolean2;
/*  82 */     this.parseJekyllMacrosInUrls = paramBoolean3;
/*  83 */     this.intellijDummyIdentifier = paramBoolean4;
/*     */ 
/*     */     
/*  86 */     this.EXCLUDED_0_TO_SPACE_CHARS = getCharSet(false, ' ');
/*  87 */     if (paramBoolean4) this.EXCLUDED_0_TO_SPACE_CHARS.clear(31);
/*     */     
/*  89 */     this.JEKYLL_EXCLUDED_CHARS = getCharSet("{}\\");
/*  90 */     this.JEKYLL_EXCLUDED_CHARS.or(this.EXCLUDED_0_TO_SPACE_CHARS);
/*  91 */     this.JEKYLL_EXCLUDED_CHARS.clear(32);
/*  92 */     this.JEKYLL_EXCLUDED_CHARS.clear(9);
/*     */     
/*  94 */     this.PAREN_EXCLUDED_CHARS = getCharSet("()\\");
/*  95 */     this.PAREN_EXCLUDED_CHARS.or(this.EXCLUDED_0_TO_SPACE_CHARS);
/*     */     
/*  97 */     this.PAREN_ESCAPABLE_CHARS = getCharSet("\"#$%&'()*+,./:;<=>?@[]\\^_`{|}~-");
/*  98 */     this.PAREN_QUOTE_CHARS = getCharSet("\"'");
/*     */   }
/*     */   
/*     */   public BasedSequence parseLinkDestination(BasedSequence paramBasedSequence, int paramInt) {
/* 102 */     int i = paramBasedSequence.length();
/* 103 */     int j = paramInt;
/*     */     
/* 105 */     int k = 0;
/* 106 */     byte b = 0;
/* 107 */     byte b1 = 0;
/*     */     
/* 109 */     byte b2 = this.parseJekyllMacrosInUrls ? 0 : -1;
/*     */     
/* 111 */     for (int m = paramInt; m < i; ) {
/* 112 */       char c = paramBasedSequence.charAt(m);
/*     */       
/* 114 */       int n = m + 1;
/*     */       
/* 116 */       if (b2) {
/* 117 */         switch (b2) {
/*     */           
/*     */           case false:
/* 120 */             if (b != 1)
/*     */             {
/*     */               
/* 123 */               if (c == '{' && paramBasedSequence.safeCharAt(n) == '{') {
/* 124 */                 b2 = 1;
/*     */               }
/*     */             }
/*     */             break;
/*     */ 
/*     */           
/*     */           case true:
/* 131 */             if (b != 1)
/*     */             {
/*     */               
/* 134 */               if (c == '{') {
/* 135 */                 b1 = 0;
/* 136 */                 b2 = 2;
/*     */                 break;
/*     */               } 
/*     */             }
/* 140 */             b2 = 0;
/*     */             break;
/*     */           
/*     */           case true:
/* 144 */             if (b != 1) {
/*     */ 
/*     */               
/* 147 */               if (c == '}') {
/* 148 */                 b2 = 3; break;
/* 149 */               }  if (c == '(') {
/* 150 */                 b1++; break;
/* 151 */               }  if (c == ')') {
/* 152 */                 if (b1 > 0) {
/*     */                   
/* 154 */                   if (b != -1) j = n;
/*     */                   
/* 156 */                   b1--;
/*     */                   
/*     */                   break;
/*     */                 } 
/* 160 */                 b2 = 0; break;
/* 161 */               }  if (this.JEKYLL_EXCLUDED_CHARS.get(c)) {
/* 162 */                 k += b1;
/* 163 */                 b2 = 0;
/*     */               } 
/*     */             } 
/*     */             break;
/*     */           
/*     */           case true:
/* 169 */             if (b != 1) {
/*     */ 
/*     */               
/* 172 */               if (c == '}') {
/* 173 */                 j = n;
/* 174 */                 b = 0;
/* 175 */                 b2 = 0; break;
/*     */               } 
/* 177 */               if (this.JEKYLL_EXCLUDED_CHARS.get(c)) {
/* 178 */                 k += b1;
/* 179 */                 b2 = 0;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/* 184 */             b2 = 2;
/*     */             break;
/*     */           default:
/* 187 */             throw new IllegalStateException("Illegal Jekyll Macro Parsing State");
/*     */         } 
/*     */ 
/*     */       
/*     */       }
/* 192 */       if (b) {
/* 193 */         switch (b) {
/*     */           case false:
/* 195 */             if (c == '\\') {
/* 196 */               if (this.PAREN_ESCAPABLE_CHARS.get(paramBasedSequence.safeCharAt(n)))
/*     */               {
/* 198 */                 b = 1;
/*     */               }
/*     */               
/* 201 */               j = n; break;
/*     */             } 
/* 203 */             if (c == '(') {
/* 204 */               if (b2 != 2) {
/* 205 */                 if (this.allowMatchedParentheses) {
/* 206 */                   k++;
/*     */                 }
/* 208 */                 else if (k == 0) {
/* 209 */                   k++;
/*     */                 } else {
/*     */                   
/* 212 */                   j = paramInt;
/* 213 */                   b = -1;
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */               }
/* 218 */               j = n; break;
/*     */             } 
/* 220 */             if (c == ')') {
/* 221 */               if (b2 != 2)
/*     */               
/*     */               { 
/*     */                 
/* 225 */                 if (k > 0) {
/* 226 */                   k--;
/* 227 */                   j = n; break;
/*     */                 } 
/* 229 */                 if (!this.allowMatchedParentheses) {
/* 230 */                   b = -1; break;
/*     */                 }  }
/*     */               else { break; }
/*     */             
/* 234 */             } else if (c == ' ') {
/* 235 */               if (this.spaceInUrls && !this.PAREN_QUOTE_CHARS.get(paramBasedSequence.safeCharAt(n)))
/*     */               {
/*     */                 break;
/*     */               }
/*     */             }
/* 240 */             else if (!this.PAREN_EXCLUDED_CHARS.get(c)) {
/* 241 */               j = n;
/*     */ 
/*     */               
/*     */               break;
/*     */             } 
/*     */             
/* 247 */             b = -1;
/*     */             break;
/*     */ 
/*     */           
/*     */           case true:
/* 252 */             j = n;
/* 253 */             b = 0;
/*     */             break;
/*     */           
/*     */           default:
/* 257 */             throw new IllegalStateException("Illegal Jekyll Macro Parsing State");
/*     */         } 
/*     */       
/*     */       }
/* 261 */       if (b2 > 0 || b != -1) {
/*     */         m++;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 267 */     return paramBasedSequence.subSequence(paramInt, j);
/*     */   }
/*     */   
/*     */   public static BitSet getCharSet(CharSequence paramCharSequence) {
/* 271 */     BitSet bitSet = new BitSet(paramCharSequence.length());
/* 272 */     int i = paramCharSequence.length();
/* 273 */     for (byte b = 0; b < i; b++) {
/* 274 */       bitSet.set(paramCharSequence.charAt(b));
/*     */     }
/* 276 */     return bitSet;
/*     */   }
/*     */   
/*     */   public static BitSet getCharSet(char paramChar1, char paramChar2) {
/* 280 */     BitSet bitSet = new BitSet();
/* 281 */     for (paramChar1 = paramChar1; paramChar1 <= paramChar2; paramChar1++) {
/* 282 */       bitSet.set(paramChar1);
/*     */     }
/* 284 */     return bitSet;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\internal\LinkDestinationParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */