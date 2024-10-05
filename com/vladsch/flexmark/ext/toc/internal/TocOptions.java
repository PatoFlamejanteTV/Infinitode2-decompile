/*     */ package com.vladsch.flexmark.ext.toc.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.toc.TocExtension;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.misc.Immutable;
/*     */ import com.vladsch.flexmark.util.misc.Mutable;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ 
/*     */ 
/*     */ public class TocOptions
/*     */   implements MutableDataSetter, Immutable<TocOptions, TocOptions.AsMutable>
/*     */ {
/*  17 */   public static final TocOptions DEFAULT = new TocOptions(); public static final int DEFAULT_LEVELS = 12; public static final String DEFAULT_TITLE = "Table of Contents"; public static final int DEFAULT_TITLE_LEVEL = 1; public static final int VALID_LEVELS = 126; public final int levels; public final boolean isTextOnly;
/*     */   public final boolean isNumbered;
/*     */   public final ListType listType;
/*     */   public final boolean isHtml;
/*     */   public final int titleLevel;
/*  22 */   public static final ListType LIST_TYPE = ListType.HIERARCHY; public final String title; public final boolean isAstAddOptions; public final boolean isBlankLineSpacer; public final String divClass; public final String listClass;
/*     */   public final boolean isCaseSensitiveTocTag;
/*     */   
/*  25 */   public enum ListType { HIERARCHY,
/*  26 */     FLAT,
/*  27 */     FLAT_REVERSED,
/*  28 */     SORTED,
/*  29 */     SORTED_REVERSED; }
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
/*     */   public AsMutable toMutable() {
/*  47 */     return new AsMutable(this);
/*     */   }
/*     */   
/*     */   public TocOptions() {
/*  51 */     this(12, false, false, false, 1, "Table of Contents", ListType.HIERARCHY, false, true, "", "", true);
/*     */   }
/*     */   
/*     */   public TocOptions(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ListType paramListType) {
/*  55 */     this(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, 1, "Table of Contents", paramListType, false, true, "", "", true);
/*     */   }
/*     */   
/*     */   public TocOptions(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, String paramString, ListType paramListType) {
/*  59 */     this(paramInt1, paramBoolean1, paramBoolean2, paramBoolean3, paramInt2, paramString, paramListType, false, true, "", "", true);
/*     */   }
/*     */   
/*     */   public TocOptions(AsMutable paramAsMutable) {
/*  63 */     this(paramAsMutable.levels, paramAsMutable.isHtml, paramAsMutable.isTextOnly, paramAsMutable.isNumbered, paramAsMutable.titleLevel, paramAsMutable.title, paramAsMutable.listType, paramAsMutable.isAstAddOptions, paramAsMutable.isBlankLineSpacer, paramAsMutable.divClass, paramAsMutable.listClass, paramAsMutable.isCaseSensitiveTocTag);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TocOptions(TocOptions paramTocOptions) {
/*  80 */     this(paramTocOptions.levels, paramTocOptions.isHtml, paramTocOptions.isTextOnly, paramTocOptions.isNumbered, paramTocOptions.titleLevel, paramTocOptions.title, paramTocOptions.listType, paramTocOptions.isAstAddOptions, paramTocOptions.isBlankLineSpacer, paramTocOptions.divClass, paramTocOptions.listClass, paramTocOptions.isCaseSensitiveTocTag);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TocOptions(DataHolder paramDataHolder, boolean paramBoolean) {
/* 101 */     this(((Integer)TocExtension.LEVELS
/* 102 */         .get(paramDataHolder)).intValue(), ((Boolean)TocExtension.IS_HTML
/* 103 */         .get(paramDataHolder)).booleanValue(), ((Boolean)TocExtension.IS_TEXT_ONLY
/* 104 */         .get(paramDataHolder)).booleanValue(), ((Boolean)TocExtension.IS_NUMBERED
/* 105 */         .get(paramDataHolder)).booleanValue(), ((Integer)TocExtension.TITLE_LEVEL
/* 106 */         .get(paramDataHolder)).intValue(), 
/* 107 */         (TocExtension.TITLE.get(paramDataHolder) == null) ? (paramBoolean ? "Table of Contents" : "") : (CharSequence)TocExtension.TITLE.get(paramDataHolder), (ListType)TocExtension.LIST_TYPE
/* 108 */         .get(paramDataHolder), ((Boolean)TocExtension.AST_INCLUDE_OPTIONS
/* 109 */         .get(paramDataHolder)).booleanValue(), ((Boolean)TocExtension.BLANK_LINE_SPACER
/* 110 */         .get(paramDataHolder)).booleanValue(), (CharSequence)TocExtension.DIV_CLASS
/* 111 */         .get(paramDataHolder), (CharSequence)TocExtension.LIST_CLASS
/* 112 */         .get(paramDataHolder), ((Boolean)TocExtension.CASE_SENSITIVE_TOC_TAG
/* 113 */         .get(paramDataHolder)).booleanValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 120 */     paramMutableDataHolder.set(TocExtension.LEVELS, Integer.valueOf(this.levels));
/* 121 */     paramMutableDataHolder.set(TocExtension.IS_TEXT_ONLY, Boolean.valueOf(this.isTextOnly));
/* 122 */     paramMutableDataHolder.set(TocExtension.IS_NUMBERED, Boolean.valueOf(this.isNumbered));
/* 123 */     paramMutableDataHolder.set(TocExtension.LIST_TYPE, this.listType);
/* 124 */     paramMutableDataHolder.set(TocExtension.IS_HTML, Boolean.valueOf(this.isHtml));
/* 125 */     paramMutableDataHolder.set(TocExtension.TITLE_LEVEL, Integer.valueOf(this.titleLevel));
/* 126 */     paramMutableDataHolder.set(TocExtension.TITLE, this.title);
/* 127 */     paramMutableDataHolder.set(TocExtension.AST_INCLUDE_OPTIONS, Boolean.valueOf(this.isAstAddOptions));
/* 128 */     paramMutableDataHolder.set(TocExtension.BLANK_LINE_SPACER, Boolean.valueOf(this.isBlankLineSpacer));
/* 129 */     paramMutableDataHolder.set(TocExtension.DIV_CLASS, this.divClass);
/* 130 */     paramMutableDataHolder.set(TocExtension.LIST_CLASS, this.listClass);
/* 131 */     paramMutableDataHolder.set(TocExtension.CASE_SENSITIVE_TOC_TAG, Boolean.valueOf(this.isCaseSensitiveTocTag));
/* 132 */     return paramMutableDataHolder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TocOptions(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, CharSequence paramCharSequence1, ListType paramListType, boolean paramBoolean4, boolean paramBoolean5, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean6) {
/* 149 */     this.levels = 0x7E & paramInt1;
/* 150 */     this.isTextOnly = paramBoolean2;
/* 151 */     this.isNumbered = paramBoolean3;
/* 152 */     this.listType = paramListType;
/* 153 */     this.isHtml = paramBoolean1;
/*     */     
/* 155 */     if (paramCharSequence1 != null) {
/*     */       int i;
/*     */       CharSequence charSequence;
/* 158 */       if ((i = BasedSequence.of(charSequence = SequenceUtils.trim(paramCharSequence1)).countLeading(CharPredicate.HASH)) > 0)
/*     */       {
/* 160 */         i = paramInt2 = Math.min(i, 6);
/*     */       }
/* 162 */       String str = SequenceUtils.trim(paramCharSequence1.subSequence(i, paramCharSequence1.length())).toString();
/* 163 */       this.title = str.isEmpty() ? " " : str;
/*     */     } else {
/* 165 */       this.title = "";
/*     */     } 
/*     */     
/* 168 */     this.titleLevel = Math.max(1, Math.min(paramInt2, 6));
/* 169 */     this.isAstAddOptions = paramBoolean4;
/* 170 */     this.isBlankLineSpacer = paramBoolean5;
/* 171 */     this.divClass = (paramCharSequence2 instanceof String) ? (String)paramCharSequence2 : String.valueOf(paramCharSequence2);
/* 172 */     this.listClass = (paramCharSequence3 instanceof String) ? (String)paramCharSequence3 : String.valueOf(paramCharSequence3);
/* 173 */     this.isCaseSensitiveTocTag = paramBoolean6;
/*     */   }
/*     */   
/*     */   public boolean isLevelIncluded(int paramInt) {
/* 177 */     return (paramInt > 0 && paramInt <= 6 && (this.levels & 1 << paramInt) != 0);
/*     */   }
/*     */   
/*     */   public TocOptions withLevels(int paramInt) {
/* 181 */     return new TocOptions(paramInt, this.isHtml, this.isTextOnly, this.isNumbered, this.titleLevel, this.title, this.listType, this.isAstAddOptions, this.isBlankLineSpacer, this.divClass, this.listClass, this.isCaseSensitiveTocTag);
/* 182 */   } public TocOptions withIsHtml(boolean paramBoolean) { return new TocOptions(this.levels, paramBoolean, this.isTextOnly, this.isNumbered, this.titleLevel, this.title, this.listType, this.isAstAddOptions, this.isBlankLineSpacer, this.divClass, this.listClass, this.isCaseSensitiveTocTag); }
/* 183 */   public TocOptions withIsTextOnly(boolean paramBoolean) { return new TocOptions(this.levels, this.isHtml, paramBoolean, this.isNumbered, this.titleLevel, this.title, this.listType, this.isAstAddOptions, this.isBlankLineSpacer, this.divClass, this.listClass, this.isCaseSensitiveTocTag); }
/* 184 */   public TocOptions withIsNumbered(boolean paramBoolean) { return new TocOptions(this.levels, this.isHtml, this.isTextOnly, paramBoolean, this.titleLevel, this.title, this.listType, this.isAstAddOptions, this.isBlankLineSpacer, this.divClass, this.listClass, this.isCaseSensitiveTocTag); }
/* 185 */   public TocOptions withTitleLevel(int paramInt) { return new TocOptions(this.levels, this.isHtml, this.isTextOnly, this.isNumbered, paramInt, this.title, this.listType, this.isAstAddOptions, this.isBlankLineSpacer, this.divClass, this.listClass, this.isCaseSensitiveTocTag); }
/* 186 */   public TocOptions withTitle(CharSequence paramCharSequence) { return new TocOptions(this.levels, this.isHtml, this.isTextOnly, this.isNumbered, this.titleLevel, paramCharSequence, this.listType, this.isAstAddOptions, this.isBlankLineSpacer, this.divClass, this.listClass, this.isCaseSensitiveTocTag); }
/* 187 */   public TocOptions withListType(ListType paramListType) { return new TocOptions(this.levels, this.isHtml, this.isTextOnly, this.isNumbered, this.titleLevel, this.title, paramListType, this.isAstAddOptions, this.isBlankLineSpacer, this.divClass, this.listClass, this.isCaseSensitiveTocTag); }
/* 188 */   public TocOptions withIsAstAddOptions(boolean paramBoolean) { return new TocOptions(this.levels, this.isHtml, this.isTextOnly, this.isNumbered, this.titleLevel, this.title, this.listType, paramBoolean, this.isBlankLineSpacer, this.divClass, this.listClass, this.isCaseSensitiveTocTag); } public TocOptions withIsBlankLineSpacer(boolean paramBoolean) {
/* 189 */     return new TocOptions(this.levels, this.isHtml, this.isTextOnly, this.isNumbered, this.titleLevel, this.title, this.listType, this.isAstAddOptions, paramBoolean, this.divClass, this.listClass, this.isCaseSensitiveTocTag);
/*     */   }
/* 191 */   public TocOptions withRawTitleLevel(int paramInt) { return new TocOptions(this.levels, this.isHtml, this.isTextOnly, this.isNumbered, paramInt, this.title, this.listType, this.isAstAddOptions, this.isBlankLineSpacer, this.divClass, this.listClass, this.isCaseSensitiveTocTag); }
/* 192 */   public TocOptions withRawTitle(CharSequence paramCharSequence) { return new TocOptions(this.levels, this.isHtml, this.isTextOnly, this.isNumbered, this.titleLevel, paramCharSequence, this.listType, this.isAstAddOptions, this.isBlankLineSpacer, this.divClass, this.listClass, this.isCaseSensitiveTocTag); }
/* 193 */   public TocOptions withDivClass(CharSequence paramCharSequence) { return new TocOptions(this.levels, this.isHtml, this.isTextOnly, this.isNumbered, this.titleLevel, this.title, this.listType, this.isAstAddOptions, this.isBlankLineSpacer, paramCharSequence, this.listClass, this.isCaseSensitiveTocTag); } public TocOptions withListClass(CharSequence paramCharSequence) {
/* 194 */     return new TocOptions(this.levels, this.isHtml, this.isTextOnly, this.isNumbered, this.titleLevel, this.title, this.listType, this.isAstAddOptions, this.isBlankLineSpacer, this.divClass, paramCharSequence, this.isCaseSensitiveTocTag);
/*     */   }
/*     */   
/*     */   public TocOptions withLevelList(int... paramVarArgs) {
/* 198 */     int i = getLevels(paramVarArgs);
/* 199 */     return withLevels(i);
/*     */   }
/*     */   
/*     */   public static int getLevels(int... paramVarArgs) {
/* 203 */     int i = 0; int j; byte b;
/* 204 */     for (j = (paramVarArgs = paramVarArgs).length, b = 0; b < j; ) {
/* 205 */       int k; if ((k = paramVarArgs[b]) <= 0 || k > 6) throw new IllegalArgumentException("TocOption level out of range [1, 6]"); 
/* 206 */       i |= 1 << k; b++;
/*     */     } 
/* 208 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitleHeading() {
/*     */     String str;
/* 214 */     if (!(str = this.title).trim().isEmpty()) {
/* 215 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/* 217 */       int i = this.titleLevel;
/* 218 */       for (; i-- > 0; stringBuilder.append('#'));
/* 219 */       stringBuilder.append(' ');
/* 220 */       stringBuilder.append(str);
/* 221 */       return stringBuilder.toString();
/*     */     } 
/* 223 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 228 */     if (this == paramObject) return true; 
/* 229 */     if (!(paramObject instanceof TocOptions) && !(paramObject instanceof AsMutable)) return false;
/*     */     
/* 231 */     paramObject = (paramObject instanceof TocOptions) ? paramObject : ((AsMutable)paramObject).toImmutable();
/*     */     
/* 233 */     if (this.levels != ((TocOptions)paramObject).levels) return false; 
/* 234 */     if (this.isTextOnly != ((TocOptions)paramObject).isTextOnly) return false; 
/* 235 */     if (this.isNumbered != ((TocOptions)paramObject).isNumbered) return false; 
/* 236 */     if (this.listType != ((TocOptions)paramObject).listType) return false; 
/* 237 */     if (this.isHtml != ((TocOptions)paramObject).isHtml) return false; 
/* 238 */     if (this.titleLevel != ((TocOptions)paramObject).titleLevel) return false; 
/* 239 */     if (!this.title.equals(((TocOptions)paramObject).title)) return false; 
/* 240 */     if (!this.divClass.equals(((TocOptions)paramObject).divClass)) return false; 
/* 241 */     if (!this.listClass.equals(((TocOptions)paramObject).listClass)) return false; 
/* 242 */     if (this.isAstAddOptions != ((TocOptions)paramObject).isAstAddOptions) return false; 
/* 243 */     if (this.isBlankLineSpacer != ((TocOptions)paramObject).isBlankLineSpacer) return false; 
/* 244 */     if (this.isCaseSensitiveTocTag != ((TocOptions)paramObject).isCaseSensitiveTocTag) return false; 
/* 245 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 250 */     int i = this.levels;
/* 251 */     i = i * 31 + (this.isTextOnly ? 1 : 0);
/* 252 */     i = i * 31 + (this.isNumbered ? 1 : 0);
/* 253 */     i = i * 31 + this.listType.hashCode();
/* 254 */     i = i * 31 + (this.isHtml ? 1 : 0);
/* 255 */     i = i * 31 + this.titleLevel;
/* 256 */     i = i * 31 + this.title.hashCode();
/* 257 */     i = i * 31 + this.divClass.hashCode();
/* 258 */     i = i * 31 + this.listClass.hashCode();
/* 259 */     i = i * 31 + (this.isAstAddOptions ? 1 : 0);
/* 260 */     i = i * 31 + (this.isBlankLineSpacer ? 1 : 0);
/*     */     
/* 262 */     return i = i * 31 + (this.isCaseSensitiveTocTag ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 267 */     return "TocOptions { levels=" + this.levels + ", isHtml=" + this.isHtml + ", isTextOnly=" + this.isTextOnly + ", isNumbered=" + this.isNumbered + ", titleLevel=" + this.titleLevel + ", title='" + this.title + '\'' + ", listType=" + this.listType + ", divClass='" + this.divClass + '\'' + ", listClass='" + this.listClass + '\'' + " }";
/*     */   }
/*     */ 
/*     */   
/*     */   public static class AsMutable
/*     */     implements MutableDataSetter, Mutable<AsMutable, TocOptions>
/*     */   {
/*     */     public int levels;
/*     */     
/*     */     public boolean isTextOnly;
/*     */     
/*     */     public boolean isNumbered;
/*     */     
/*     */     public TocOptions.ListType listType;
/*     */     
/*     */     public boolean isHtml;
/*     */     
/*     */     public int titleLevel;
/*     */     
/*     */     public String title;
/*     */     
/*     */     public boolean isAstAddOptions;
/*     */     public boolean isBlankLineSpacer;
/*     */     public String divClass;
/*     */     public String listClass;
/*     */     public boolean isCaseSensitiveTocTag;
/*     */     
/*     */     protected AsMutable(TocOptions param1TocOptions) {
/* 295 */       this.levels = param1TocOptions.levels;
/* 296 */       this.isTextOnly = param1TocOptions.isTextOnly;
/* 297 */       this.isNumbered = param1TocOptions.isNumbered;
/* 298 */       this.listType = param1TocOptions.listType;
/* 299 */       this.isHtml = param1TocOptions.isHtml;
/* 300 */       this.titleLevel = param1TocOptions.titleLevel;
/* 301 */       this.title = param1TocOptions.title;
/* 302 */       this.isAstAddOptions = param1TocOptions.isAstAddOptions;
/* 303 */       this.isBlankLineSpacer = param1TocOptions.isBlankLineSpacer;
/* 304 */       this.divClass = param1TocOptions.divClass;
/* 305 */       this.listClass = param1TocOptions.listClass;
/* 306 */       this.isCaseSensitiveTocTag = param1TocOptions.isCaseSensitiveTocTag;
/*     */     }
/*     */ 
/*     */     
/*     */     protected AsMutable(AsMutable param1AsMutable) {
/* 311 */       this(param1AsMutable.toImmutable());
/*     */     }
/*     */ 
/*     */     
/*     */     public TocOptions toImmutable() {
/* 316 */       return new TocOptions(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AsMutable normalizeTitle() {
/* 323 */       TocOptions tocOptions = toImmutable();
/* 324 */       this.title = tocOptions.title;
/* 325 */       this.titleLevel = tocOptions.titleLevel;
/* 326 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public MutableDataHolder setIn(MutableDataHolder param1MutableDataHolder) {
/* 332 */       return toImmutable().setIn(param1MutableDataHolder);
/*     */     }
/*     */     
/*     */     public AsMutable setLevelList(int... param1VarArgs) {
/* 336 */       int i = 0; int j; byte b;
/* 337 */       for (j = (param1VarArgs = param1VarArgs).length, b = 0; b < j; ) {
/* 338 */         int k; if ((k = param1VarArgs[b]) <= 0 || k > 6) throw new IllegalArgumentException("TocOption level out of range [1, 6]"); 
/* 339 */         i |= 1 << k; b++;
/*     */       } 
/* 341 */       this.levels = i;
/* 342 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 347 */       if (this == param1Object) return true; 
/* 348 */       if (!(param1Object instanceof TocOptions) && !(param1Object instanceof AsMutable)) return false;
/*     */       
/* 350 */       param1Object = (param1Object instanceof AsMutable) ? param1Object : ((TocOptions)param1Object).toMutable();
/*     */       
/* 352 */       if (this.levels != ((AsMutable)param1Object).levels) return false; 
/* 353 */       if (this.isTextOnly != ((AsMutable)param1Object).isTextOnly) return false; 
/* 354 */       if (this.isNumbered != ((AsMutable)param1Object).isNumbered) return false; 
/* 355 */       if (this.listType != ((AsMutable)param1Object).listType) return false; 
/* 356 */       if (this.isHtml != ((AsMutable)param1Object).isHtml) return false; 
/* 357 */       if (this.titleLevel != ((AsMutable)param1Object).titleLevel) return false; 
/* 358 */       if (!this.title.equals(((AsMutable)param1Object).title)) return false; 
/* 359 */       if (!this.divClass.equals(((AsMutable)param1Object).divClass)) return false; 
/* 360 */       if (!this.listClass.equals(((AsMutable)param1Object).listClass)) return false; 
/* 361 */       if (this.isAstAddOptions != ((AsMutable)param1Object).isAstAddOptions) return false; 
/* 362 */       if (this.isBlankLineSpacer != ((AsMutable)param1Object).isBlankLineSpacer) return false; 
/* 363 */       if (this.isCaseSensitiveTocTag != ((AsMutable)param1Object).isCaseSensitiveTocTag) return false; 
/* 364 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 369 */       int i = this.levels;
/* 370 */       i = i * 31 + (this.isTextOnly ? 1 : 0);
/* 371 */       i = i * 31 + (this.isNumbered ? 1 : 0);
/* 372 */       i = i * 31 + this.listType.hashCode();
/* 373 */       i = i * 31 + (this.isHtml ? 1 : 0);
/* 374 */       i = i * 31 + this.titleLevel;
/* 375 */       i = i * 31 + this.title.hashCode();
/* 376 */       i = i * 31 + this.divClass.hashCode();
/* 377 */       i = i * 31 + this.listClass.hashCode();
/* 378 */       i = i * 31 + (this.isAstAddOptions ? 1 : 0);
/* 379 */       i = i * 31 + (this.isBlankLineSpacer ? 1 : 0);
/*     */       
/* 381 */       return i = i * 31 + (this.isCaseSensitiveTocTag ? 1 : 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 386 */       return "TocOptions { levels=" + this.levels + ", isHtml=" + this.isHtml + ", isTextOnly=" + this.isTextOnly + ", isNumbered=" + this.isNumbered + ", titleLevel=" + this.titleLevel + ", title='" + this.title + '\'' + ", listType=" + this.listType + ", divClass='" + this.divClass + '\'' + ", listClass='" + this.listClass + '\'' + " }";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\internal\TocOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */