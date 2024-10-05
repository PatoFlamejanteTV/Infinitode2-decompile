/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.Normalizer;
/*     */ import org.jsoup.nodes.Attributes;
/*     */ import org.jsoup.nodes.Range;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class Token
/*     */ {
/*     */   final TokenType type;
/*     */   static final int Unset = -1;
/*     */   private int startPos;
/*  21 */   private int endPos = -1;
/*     */   
/*     */   private Token(TokenType paramTokenType) {
/*  24 */     this.type = paramTokenType;
/*     */   }
/*     */   
/*     */   String tokenType() {
/*  28 */     return getClass().getSimpleName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Token reset() {
/*  36 */     this.startPos = -1;
/*  37 */     this.endPos = -1;
/*  38 */     return this;
/*     */   }
/*     */   
/*     */   int startPos() {
/*  42 */     return this.startPos;
/*     */   }
/*     */   
/*     */   void startPos(int paramInt) {
/*  46 */     this.startPos = paramInt;
/*     */   }
/*     */   
/*     */   int endPos() {
/*  50 */     return this.endPos;
/*     */   }
/*     */   
/*     */   void endPos(int paramInt) {
/*  54 */     this.endPos = paramInt;
/*     */   }
/*     */   
/*     */   static void reset(StringBuilder paramStringBuilder) {
/*  58 */     if (paramStringBuilder != null)
/*  59 */       paramStringBuilder.delete(0, paramStringBuilder.length()); 
/*     */   }
/*     */   
/*     */   static final class Doctype
/*     */     extends Token {
/*  64 */     final StringBuilder name = new StringBuilder();
/*  65 */     String pubSysKey = null;
/*  66 */     final StringBuilder publicIdentifier = new StringBuilder();
/*  67 */     final StringBuilder systemIdentifier = new StringBuilder();
/*     */     boolean forceQuirks = false;
/*     */     
/*     */     Doctype() {
/*  71 */       super(Token.TokenType.Doctype);
/*     */     }
/*     */ 
/*     */     
/*     */     final Token reset() {
/*  76 */       super.reset();
/*  77 */       reset(this.name);
/*  78 */       this.pubSysKey = null;
/*  79 */       reset(this.publicIdentifier);
/*  80 */       reset(this.systemIdentifier);
/*  81 */       this.forceQuirks = false;
/*  82 */       return this;
/*     */     }
/*     */     
/*     */     final String getName() {
/*  86 */       return this.name.toString();
/*     */     }
/*     */     
/*     */     final String getPubSysKey() {
/*  90 */       return this.pubSysKey;
/*     */     }
/*     */     
/*     */     final String getPublicIdentifier() {
/*  94 */       return this.publicIdentifier.toString();
/*     */     }
/*     */     
/*     */     public final String getSystemIdentifier() {
/*  98 */       return this.systemIdentifier.toString();
/*     */     }
/*     */     
/*     */     public final boolean isForceQuirks() {
/* 102 */       return this.forceQuirks;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 107 */       return "<!doctype " + getName() + ">";
/*     */     }
/*     */   }
/*     */   
/*     */   static abstract class Tag
/*     */     extends Token {
/*     */     protected String tagName;
/*     */     protected String normalName;
/*     */     boolean selfClosing = false;
/*     */     Attributes attributes;
/*     */     private String attrName;
/* 118 */     private final StringBuilder attrNameSb = new StringBuilder();
/*     */     
/*     */     private boolean hasAttrName = false;
/*     */     private String attrValue;
/* 122 */     private final StringBuilder attrValueSb = new StringBuilder();
/*     */     
/*     */     private boolean hasAttrValue = false;
/*     */     
/*     */     private boolean hasEmptyAttrValue = false;
/*     */     
/*     */     final TreeBuilder treeBuilder;
/*     */     final boolean trackSource;
/*     */     
/*     */     Tag(Token.TokenType param1TokenType, TreeBuilder param1TreeBuilder) {
/* 132 */       super(param1TokenType);
/* 133 */       this.treeBuilder = param1TreeBuilder;
/* 134 */       this.trackSource = param1TreeBuilder.trackSourceRange;
/*     */     }
/*     */     int attrNameStart; int attrNameEnd; int attrValStart; int attrValEnd; private static final int MaxAttributes = 512;
/*     */     
/*     */     Tag reset() {
/* 139 */       super.reset();
/* 140 */       this.tagName = null;
/* 141 */       this.normalName = null;
/* 142 */       this.selfClosing = false;
/* 143 */       this.attributes = null;
/* 144 */       resetPendingAttr();
/* 145 */       return this;
/*     */     }
/*     */     
/*     */     private void resetPendingAttr() {
/* 149 */       reset(this.attrNameSb);
/* 150 */       this.attrName = null;
/* 151 */       this.hasAttrName = false;
/*     */       
/* 153 */       reset(this.attrValueSb);
/* 154 */       this.attrValue = null;
/* 155 */       this.hasEmptyAttrValue = false;
/* 156 */       this.hasAttrValue = false;
/*     */       
/* 158 */       if (this.trackSource) {
/* 159 */         this.attrNameStart = this.attrNameEnd = this.attrValStart = this.attrValEnd = -1;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final void newAttribute() {
/* 168 */       if (this.attributes == null) {
/* 169 */         this.attributes = new Attributes();
/*     */       }
/* 171 */       if (this.hasAttrName && this.attributes.size() < 512) {
/*     */         String str;
/*     */ 
/*     */         
/* 175 */         if ((str = (str = (this.attrNameSb.length() > 0) ? this.attrNameSb.toString() : this.attrName).trim()).length() > 0) {
/*     */           String str1;
/* 177 */           if (this.hasAttrValue) {
/* 178 */             str1 = (this.attrValueSb.length() > 0) ? this.attrValueSb.toString() : this.attrValue;
/* 179 */           } else if (this.hasEmptyAttrValue) {
/* 180 */             str1 = "";
/*     */           } else {
/* 182 */             str1 = null;
/*     */           } 
/* 184 */           this.attributes.add(str, str1);
/*     */           
/* 186 */           trackAttributeRange(str);
/*     */         } 
/*     */       } 
/* 189 */       resetPendingAttr();
/*     */     }
/*     */     
/*     */     private void trackAttributeRange(String param1String) {
/* 193 */       if (this.trackSource && isStartTag()) {
/*     */         Token.StartTag startTag;
/* 195 */         CharacterReader characterReader = (startTag = asStartTag()).treeBuilder.reader;
/* 196 */         boolean bool = startTag.treeBuilder.settings.preserveAttributeCase();
/*     */         
/* 198 */         assert this.attributes != null;
/*     */         
/*     */         Map<Object, Object> map;
/*     */         
/* 202 */         if ((map = (Map)this.attributes.userData("jsoup.attrs")) == null) {
/* 203 */           map = new HashMap<>();
/* 204 */           this.attributes.userData("jsoup.attrs", map);
/*     */         } 
/*     */         
/* 207 */         if (!bool) param1String = Normalizer.lowerCase(param1String); 
/* 208 */         if (map.containsKey(param1String)) {
/*     */           return;
/*     */         }
/* 211 */         if (!this.hasAttrValue) this.attrValStart = this.attrValEnd = this.attrNameEnd;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 219 */         Range.AttributeRange attributeRange = new Range.AttributeRange(new Range(new Range.Position(this.attrNameStart, characterReader.lineNumber(this.attrNameStart), characterReader.columnNumber(this.attrNameStart)), new Range.Position(this.attrNameEnd, characterReader.lineNumber(this.attrNameEnd), characterReader.columnNumber(this.attrNameEnd))), new Range(new Range.Position(this.attrValStart, characterReader.lineNumber(this.attrValStart), characterReader.columnNumber(this.attrValStart)), new Range.Position(this.attrValEnd, characterReader.lineNumber(this.attrValEnd), characterReader.columnNumber(this.attrValEnd))));
/*     */         
/* 221 */         map.put(param1String, attributeRange);
/*     */       } 
/*     */     }
/*     */     
/*     */     final boolean hasAttributes() {
/* 226 */       return (this.attributes != null);
/*     */     }
/*     */ 
/*     */     
/*     */     final boolean hasAttribute(String param1String) {
/* 231 */       return (this.attributes != null && this.attributes.hasKey(param1String));
/*     */     }
/*     */     
/*     */     final boolean hasAttributeIgnoreCase(String param1String) {
/* 235 */       return (this.attributes != null && this.attributes.hasKeyIgnoreCase(param1String));
/*     */     }
/*     */ 
/*     */     
/*     */     final void finaliseTag() {
/* 240 */       if (this.hasAttrName) {
/* 241 */         newAttribute();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     final String name() {
/* 247 */       Validate.isFalse((this.tagName == null || this.tagName.length() == 0));
/* 248 */       return this.tagName;
/*     */     }
/*     */ 
/*     */     
/*     */     final String normalName() {
/* 253 */       return this.normalName;
/*     */     }
/*     */     
/*     */     final String toStringName() {
/* 257 */       return (this.tagName != null) ? this.tagName : "[unset]";
/*     */     }
/*     */     
/*     */     final Tag name(String param1String) {
/* 261 */       this.tagName = param1String;
/* 262 */       this.normalName = ParseSettings.normalName(this.tagName);
/* 263 */       return this;
/*     */     }
/*     */     
/*     */     final boolean isSelfClosing() {
/* 267 */       return this.selfClosing;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     final void appendTagName(String param1String) {
/* 273 */       param1String = param1String.replace(false, '�');
/* 274 */       this.tagName = (this.tagName == null) ? param1String : this.tagName.concat(param1String);
/* 275 */       this.normalName = ParseSettings.normalName(this.tagName);
/*     */     }
/*     */     
/*     */     final void appendTagName(char param1Char) {
/* 279 */       appendTagName(String.valueOf(param1Char));
/*     */     }
/*     */ 
/*     */     
/*     */     final void appendAttributeName(String param1String, int param1Int1, int param1Int2) {
/* 284 */       param1String = param1String.replace(false, '�');
/*     */       
/* 286 */       ensureAttrName(param1Int1, param1Int2);
/* 287 */       if (this.attrNameSb.length() == 0) {
/* 288 */         this.attrName = param1String; return;
/*     */       } 
/* 290 */       this.attrNameSb.append(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     final void appendAttributeName(char param1Char, int param1Int1, int param1Int2) {
/* 295 */       ensureAttrName(param1Int1, param1Int2);
/* 296 */       this.attrNameSb.append(param1Char);
/*     */     }
/*     */     
/*     */     final void appendAttributeValue(String param1String, int param1Int1, int param1Int2) {
/* 300 */       ensureAttrValue(param1Int1, param1Int2);
/* 301 */       if (this.attrValueSb.length() == 0) {
/* 302 */         this.attrValue = param1String; return;
/*     */       } 
/* 304 */       this.attrValueSb.append(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     final void appendAttributeValue(char param1Char, int param1Int1, int param1Int2) {
/* 309 */       ensureAttrValue(param1Int1, param1Int2);
/* 310 */       this.attrValueSb.append(param1Char);
/*     */     }
/*     */     
/*     */     final void appendAttributeValue(int[] param1ArrayOfint, int param1Int1, int param1Int2) {
/* 314 */       ensureAttrValue(param1Int1, param1Int2);
/* 315 */       for (param1Int1 = (param1ArrayOfint = param1ArrayOfint).length, param1Int2 = 0; param1Int2 < param1Int1; ) { int i = param1ArrayOfint[param1Int2];
/* 316 */         this.attrValueSb.appendCodePoint(i);
/*     */         param1Int2++; }
/*     */     
/*     */     }
/*     */     final void setEmptyAttributeValue() {
/* 321 */       this.hasEmptyAttrValue = true;
/*     */     }
/*     */     
/*     */     private void ensureAttrName(int param1Int1, int param1Int2) {
/* 325 */       this.hasAttrName = true;
/*     */       
/* 327 */       if (this.attrName != null) {
/* 328 */         this.attrNameSb.append(this.attrName);
/* 329 */         this.attrName = null;
/*     */       } 
/* 331 */       if (this.trackSource) {
/* 332 */         this.attrNameStart = (this.attrNameStart >= 0) ? this.attrNameStart : param1Int1;
/* 333 */         this.attrNameEnd = param1Int2;
/*     */       } 
/*     */     }
/*     */     
/*     */     private void ensureAttrValue(int param1Int1, int param1Int2) {
/* 338 */       this.hasAttrValue = true;
/*     */       
/* 340 */       if (this.attrValue != null) {
/* 341 */         this.attrValueSb.append(this.attrValue);
/* 342 */         this.attrValue = null;
/*     */       } 
/* 344 */       if (this.trackSource) {
/* 345 */         this.attrValStart = (this.attrValStart >= 0) ? this.attrValStart : param1Int1;
/* 346 */         this.attrValEnd = param1Int2;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract String toString();
/*     */   }
/*     */   
/*     */   static final class StartTag
/*     */     extends Tag
/*     */   {
/*     */     StartTag(TreeBuilder param1TreeBuilder) {
/* 358 */       super(Token.TokenType.StartTag, param1TreeBuilder);
/*     */     }
/*     */ 
/*     */     
/*     */     final Token.Tag reset() {
/* 363 */       super.reset();
/* 364 */       this.attributes = null;
/* 365 */       return this;
/*     */     }
/*     */     
/*     */     final StartTag nameAttr(String param1String, Attributes param1Attributes) {
/* 369 */       this.tagName = param1String;
/* 370 */       this.attributes = param1Attributes;
/* 371 */       this.normalName = ParseSettings.normalName(this.tagName);
/* 372 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 377 */       String str = isSelfClosing() ? "/>" : ">";
/* 378 */       if (hasAttributes() && this.attributes.size() > 0) {
/* 379 */         return "<" + toStringName() + " " + this.attributes.toString() + str;
/*     */       }
/* 381 */       return "<" + toStringName() + str;
/*     */     }
/*     */   }
/*     */   
/*     */   static final class EndTag extends Tag {
/*     */     EndTag(TreeBuilder param1TreeBuilder) {
/* 387 */       super(Token.TokenType.EndTag, param1TreeBuilder);
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 392 */       return "</" + toStringName() + ">";
/*     */     }
/*     */   }
/*     */   
/*     */   static final class Comment extends Token {
/* 397 */     private final StringBuilder data = new StringBuilder();
/*     */     
/*     */     private String dataS;
/*     */     boolean bogus = false;
/*     */     
/*     */     final Token reset() {
/* 403 */       super.reset();
/* 404 */       reset(this.data);
/* 405 */       this.dataS = null;
/* 406 */       this.bogus = false;
/* 407 */       return this;
/*     */     }
/*     */     
/*     */     Comment() {
/* 411 */       super(Token.TokenType.Comment);
/*     */     }
/*     */     
/*     */     final String getData() {
/* 415 */       return (this.dataS != null) ? this.dataS : this.data.toString();
/*     */     }
/*     */     
/*     */     final Comment append(String param1String) {
/* 419 */       ensureData();
/* 420 */       if (this.data.length() == 0) {
/* 421 */         this.dataS = param1String;
/*     */       } else {
/* 423 */         this.data.append(param1String);
/*     */       } 
/* 425 */       return this;
/*     */     }
/*     */     
/*     */     final Comment append(char param1Char) {
/* 429 */       ensureData();
/* 430 */       this.data.append(param1Char);
/* 431 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     private void ensureData() {
/* 436 */       if (this.dataS != null) {
/* 437 */         this.data.append(this.dataS);
/* 438 */         this.dataS = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 444 */       return "<!--" + getData() + "-->";
/*     */     }
/*     */   }
/*     */   
/*     */   static class Character extends Token implements Cloneable {
/*     */     private String data;
/*     */     
/*     */     Character() {
/* 452 */       super(Token.TokenType.Character);
/*     */     }
/*     */ 
/*     */     
/*     */     Token reset() {
/* 457 */       super.reset();
/* 458 */       this.data = null;
/* 459 */       return this;
/*     */     }
/*     */     
/*     */     Character data(String param1String) {
/* 463 */       this.data = param1String;
/* 464 */       return this;
/*     */     }
/*     */     
/*     */     String getData() {
/* 468 */       return this.data;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 473 */       return getData();
/*     */     }
/*     */     
/*     */     protected Character clone() {
/*     */       try {
/* 478 */         return (Character)super.clone();
/* 479 */       } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 480 */         throw new RuntimeException(cloneNotSupportedException);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static final class CData
/*     */     extends Character {
/*     */     CData(String param1String) {
/* 488 */       data(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 493 */       return "<![CDATA[" + getData() + "]]>";
/*     */     }
/*     */   }
/*     */   
/*     */   static final class EOF
/*     */     extends Token {
/*     */     EOF() {
/* 500 */       super(Token.TokenType.EOF);
/*     */     }
/*     */ 
/*     */     
/*     */     final Token reset() {
/* 505 */       super.reset();
/* 506 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 511 */       return "";
/*     */     }
/*     */   }
/*     */   
/*     */   final boolean isDoctype() {
/* 516 */     return (this.type == TokenType.Doctype);
/*     */   }
/*     */   
/*     */   final Doctype asDoctype() {
/* 520 */     return (Doctype)this;
/*     */   }
/*     */   
/*     */   final boolean isStartTag() {
/* 524 */     return (this.type == TokenType.StartTag);
/*     */   }
/*     */   
/*     */   final StartTag asStartTag() {
/* 528 */     return (StartTag)this;
/*     */   }
/*     */   
/*     */   final boolean isEndTag() {
/* 532 */     return (this.type == TokenType.EndTag);
/*     */   }
/*     */   
/*     */   final EndTag asEndTag() {
/* 536 */     return (EndTag)this;
/*     */   }
/*     */   
/*     */   final boolean isComment() {
/* 540 */     return (this.type == TokenType.Comment);
/*     */   }
/*     */   
/*     */   final Comment asComment() {
/* 544 */     return (Comment)this;
/*     */   }
/*     */   
/*     */   final boolean isCharacter() {
/* 548 */     return (this.type == TokenType.Character);
/*     */   }
/*     */   
/*     */   final boolean isCData() {
/* 552 */     return this instanceof CData;
/*     */   }
/*     */   
/*     */   final Character asCharacter() {
/* 556 */     return (Character)this;
/*     */   }
/*     */   
/*     */   final boolean isEOF() {
/* 560 */     return (this.type == TokenType.EOF);
/*     */   }
/*     */   
/*     */   public enum TokenType {
/* 564 */     Doctype,
/* 565 */     StartTag,
/* 566 */     EndTag,
/* 567 */     Comment,
/* 568 */     Character,
/* 569 */     EOF;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\Token.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */