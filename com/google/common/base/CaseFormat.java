/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Objects;
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
/*     */ @ElementTypesAreNonnullByDefault
/*     */ public enum CaseFormat
/*     */ {
/*  35 */   LOWER_HYPHEN(CharMatcher.is('-'), "-")
/*     */   {
/*     */     final String normalizeWord(String param1String) {
/*  38 */       return Ascii.toLowerCase(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     final String convert(CaseFormat param1CaseFormat, String param1String) {
/*  43 */       if (param1CaseFormat == LOWER_UNDERSCORE) {
/*  44 */         return param1String.replace('-', '_');
/*     */       }
/*  46 */       if (param1CaseFormat == UPPER_UNDERSCORE) {
/*  47 */         return Ascii.toUpperCase(param1String.replace('-', '_'));
/*     */       }
/*  49 */       return super.convert(param1CaseFormat, param1String);
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  54 */   LOWER_UNDERSCORE(CharMatcher.is('_'), "_")
/*     */   {
/*     */     final String normalizeWord(String param1String) {
/*  57 */       return Ascii.toLowerCase(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     final String convert(CaseFormat param1CaseFormat, String param1String) {
/*  62 */       if (param1CaseFormat == LOWER_HYPHEN) {
/*  63 */         return param1String.replace('_', '-');
/*     */       }
/*  65 */       if (param1CaseFormat == UPPER_UNDERSCORE) {
/*  66 */         return Ascii.toUpperCase(param1String);
/*     */       }
/*  68 */       return super.convert(param1CaseFormat, param1String);
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  73 */   LOWER_CAMEL(CharMatcher.inRange('A', 'Z'), "")
/*     */   {
/*     */     final String normalizeWord(String param1String) {
/*  76 */       return firstCharOnlyToUpper(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     final String normalizeFirstWord(String param1String) {
/*  81 */       return Ascii.toLowerCase(param1String);
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  86 */   UPPER_CAMEL(CharMatcher.inRange('A', 'Z'), "")
/*     */   {
/*     */     final String normalizeWord(String param1String) {
/*  89 */       return firstCharOnlyToUpper(param1String);
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  94 */   UPPER_UNDERSCORE(CharMatcher.is('_'), "_")
/*     */   {
/*     */     final String normalizeWord(String param1String) {
/*  97 */       return Ascii.toUpperCase(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     final String convert(CaseFormat param1CaseFormat, String param1String) {
/* 102 */       if (param1CaseFormat == LOWER_HYPHEN) {
/* 103 */         return Ascii.toLowerCase(param1String.replace('_', '-'));
/*     */       }
/* 105 */       if (param1CaseFormat == LOWER_UNDERSCORE) {
/* 106 */         return Ascii.toLowerCase(param1String);
/*     */       }
/* 108 */       return super.convert(param1CaseFormat, param1String);
/*     */     }
/*     */   };
/*     */   
/*     */   private final CharMatcher wordBoundary;
/*     */   private final String wordSeparator;
/*     */   
/*     */   CaseFormat(CharMatcher paramCharMatcher, String paramString1) {
/* 116 */     this.wordBoundary = paramCharMatcher;
/* 117 */     this.wordSeparator = paramString1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String to(CaseFormat paramCaseFormat, String paramString) {
/* 126 */     Preconditions.checkNotNull(paramCaseFormat);
/* 127 */     Preconditions.checkNotNull(paramString);
/* 128 */     return (paramCaseFormat == this) ? paramString : convert(paramCaseFormat, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   String convert(CaseFormat paramCaseFormat, String paramString) {
/* 134 */     StringBuilder stringBuilder = null;
/* 135 */     int i = 0;
/* 136 */     int j = -1;
/* 137 */     while ((j = this.wordBoundary.indexIn(paramString, ++j)) != -1) {
/* 138 */       if (!i) {
/*     */ 
/*     */         
/* 141 */         (stringBuilder = new StringBuilder(paramString.length() + 4 * paramCaseFormat.wordSeparator.length())).append(paramCaseFormat.normalizeFirstWord(paramString.substring(i, j)));
/*     */       } else {
/* 143 */         ((StringBuilder)Objects.<StringBuilder>requireNonNull(stringBuilder)).append(paramCaseFormat.normalizeWord(paramString.substring(i, j)));
/*     */       } 
/* 145 */       stringBuilder.append(paramCaseFormat.wordSeparator);
/* 146 */       i = j + this.wordSeparator.length();
/*     */     } 
/* 148 */     if (i == 0)
/* 149 */       return paramCaseFormat.normalizeFirstWord(paramString); 
/* 150 */     return ((StringBuilder)Objects.<StringBuilder>requireNonNull(stringBuilder)).append(paramCaseFormat.normalizeWord(paramString.substring(i))).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Converter<String, String> converterTo(CaseFormat paramCaseFormat) {
/* 159 */     return new StringConverter(this, paramCaseFormat);
/*     */   }
/*     */   
/*     */   private static final class StringConverter
/*     */     extends Converter<String, String> implements Serializable {
/*     */     private final CaseFormat sourceFormat;
/*     */     private final CaseFormat targetFormat;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     StringConverter(CaseFormat param1CaseFormat1, CaseFormat param1CaseFormat2) {
/* 169 */       this.sourceFormat = Preconditions.<CaseFormat>checkNotNull(param1CaseFormat1);
/* 170 */       this.targetFormat = Preconditions.<CaseFormat>checkNotNull(param1CaseFormat2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final String doForward(String param1String) {
/* 175 */       return this.sourceFormat.to(this.targetFormat, param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final String doBackward(String param1String) {
/* 180 */       return this.targetFormat.to(this.sourceFormat, param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 185 */       if (param1Object instanceof StringConverter) {
/* 186 */         param1Object = param1Object;
/* 187 */         return (this.sourceFormat.equals(((StringConverter)param1Object).sourceFormat) && this.targetFormat.equals(((StringConverter)param1Object).targetFormat));
/*     */       } 
/* 189 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 194 */       return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 199 */       String str1 = String.valueOf(this.sourceFormat), str2 = String.valueOf(this.targetFormat); return (new StringBuilder(14 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".converterTo(").append(str2).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String normalizeFirstWord(String paramString) {
/* 208 */     return normalizeWord(paramString);
/*     */   }
/*     */   
/*     */   private static String firstCharOnlyToUpper(String paramString) {
/* 212 */     if (paramString.isEmpty())
/* 213 */       return paramString; 
/* 214 */     char c = Ascii.toUpperCase(paramString.charAt(0)); paramString = Ascii.toLowerCase(paramString.substring(1)); return (new StringBuilder(1 + String.valueOf(paramString).length())).append(c).append(paramString).toString();
/*     */   }
/*     */   
/*     */   abstract String normalizeWord(String paramString);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\CaseFormat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */