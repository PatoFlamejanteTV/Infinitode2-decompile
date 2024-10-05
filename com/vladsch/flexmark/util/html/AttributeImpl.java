/*     */ package com.vladsch.flexmark.util.html;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.Mutable;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ public class AttributeImpl implements Attribute {
/*     */   private final String name;
/*     */   private final char valueListDelimiter;
/*     */   private final char valueNameDelimiter;
/*     */   private final String value;
/*     */   
/*     */   private AttributeImpl(CharSequence paramCharSequence1, CharSequence paramCharSequence2, char paramChar1, char paramChar2) {
/*  13 */     this.name = String.valueOf(paramCharSequence1);
/*  14 */     this.valueListDelimiter = paramChar1;
/*  15 */     this.valueNameDelimiter = paramChar2;
/*  16 */     this.value = (paramCharSequence2 == null) ? "" : String.valueOf(paramCharSequence2);
/*     */   }
/*     */ 
/*     */   
/*     */   public MutableAttribute toMutable() {
/*  21 */     return MutableAttributeImpl.of(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public char getValueListDelimiter() {
/*  26 */     return this.valueListDelimiter;
/*     */   }
/*     */ 
/*     */   
/*     */   public char getValueNameDelimiter() {
/*  31 */     return this.valueNameDelimiter;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  36 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getValue() {
/*  41 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNonRendering() {
/*  46 */     return (this.name.indexOf(' ') != -1 || (this.value.isEmpty() && NON_RENDERING_WHEN_EMPTY.contains(this.name)));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int indexOfValue(CharSequence paramCharSequence1, CharSequence paramCharSequence2, char paramChar1, char paramChar2) {
/*  51 */     if (paramCharSequence2.length() == 0 || paramCharSequence1.length() == 0) return -1;
/*     */     
/*  53 */     if (paramChar1 == '\000') {
/*  54 */       return paramCharSequence1.equals(paramCharSequence2) ? 0 : -1;
/*     */     }
/*  56 */     int i = 0;
/*  57 */     BasedSequence basedSequence = BasedSequence.of(paramCharSequence1);
/*  58 */     while (i < paramCharSequence1.length() && (
/*     */       
/*  60 */       i = basedSequence.indexOf(paramCharSequence2, i)) != -1) {
/*     */       
/*  62 */       int j = i + paramCharSequence2.length();
/*  63 */       if ((i == 0 || paramCharSequence1
/*  64 */         .charAt(i - 1) == paramChar1 || (paramChar2 != '\000' && paramCharSequence1
/*  65 */         .charAt(i - 1) == paramChar2)) && (
/*  66 */         j >= paramCharSequence1.length() || paramCharSequence1
/*  67 */         .charAt(j) == paramChar1 || (paramChar2 != '\000' && paramCharSequence1
/*  68 */         .charAt(j) == paramChar2))) {
/*  69 */         return i;
/*     */       }
/*     */ 
/*     */       
/*  73 */       i = j + 1;
/*     */     } 
/*     */     
/*  76 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(CharSequence paramCharSequence) {
/*  81 */     return (indexOfValue(this.value, paramCharSequence, this.valueListDelimiter, this.valueNameDelimiter) != -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute replaceValue(CharSequence paramCharSequence) {
/*  86 */     return paramCharSequence.equals(this.value) ? this : of(this.name, paramCharSequence, this.valueListDelimiter, this.valueNameDelimiter);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute setValue(CharSequence paramCharSequence) {
/*     */     MutableAttribute mutableAttribute;
/*  92 */     return (mutableAttribute = toMutable().setValue(paramCharSequence)).equals(this) ? this : (Attribute)mutableAttribute.toImmutable();
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute removeValue(CharSequence paramCharSequence) {
/*     */     MutableAttribute mutableAttribute;
/*  98 */     return (mutableAttribute = toMutable().removeValue(paramCharSequence)).equals(this) ? this : (Attribute)mutableAttribute.toImmutable();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 103 */     if (this == paramObject) return true; 
/* 104 */     if (!(paramObject instanceof Attribute)) return false;
/*     */     
/* 106 */     paramObject = paramObject;
/*     */     
/* 108 */     if (!this.name.equals(paramObject.getName())) return false; 
/* 109 */     return this.value.equals(paramObject.getValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 114 */     int i = this.name.hashCode();
/*     */     
/* 116 */     return i = i * 31 + this.value.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 121 */     return "AttributeImpl { name='" + this.name + '\'' + ", value='" + this.value + '\'' + " }";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AttributeImpl of(Attribute paramAttribute) {
/* 128 */     return of(paramAttribute.getName(), paramAttribute.getValue(), paramAttribute.getValueListDelimiter(), paramAttribute.getValueNameDelimiter());
/*     */   }
/*     */   
/*     */   public static AttributeImpl of(CharSequence paramCharSequence) {
/* 132 */     return of(paramCharSequence, paramCharSequence, false, false);
/*     */   }
/*     */   
/*     */   public static AttributeImpl of(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 136 */     return of(paramCharSequence1, paramCharSequence2, false, false);
/*     */   }
/*     */   
/*     */   public static AttributeImpl of(CharSequence paramCharSequence1, CharSequence paramCharSequence2, char paramChar) {
/* 140 */     return of(paramCharSequence1, paramCharSequence2, paramChar, false);
/*     */   }
/*     */   
/*     */   public static AttributeImpl of(CharSequence paramCharSequence1, CharSequence paramCharSequence2, char paramChar1, char paramChar2) {
/* 144 */     if (paramCharSequence1.equals("class"))
/* 145 */       return new AttributeImpl(paramCharSequence1, paramCharSequence2, ' ', false); 
/* 146 */     if (paramCharSequence1.equals("style")) {
/* 147 */       return new AttributeImpl(paramCharSequence1, paramCharSequence2, ';', ':');
/*     */     }
/* 149 */     return new AttributeImpl(paramCharSequence1, paramCharSequence2, paramChar1, paramChar2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\html\AttributeImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */