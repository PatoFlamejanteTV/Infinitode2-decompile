/*     */ package com.vladsch.flexmark.ast.util;
/*     */ 
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.format.TableFormatOptions;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.sequence.Escaping;
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ import java.util.HashMap;
/*     */ import java.util.function.Function;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Parsing
/*     */ {
/*     */   public static final char INTELLIJ_DUMMY_IDENTIFIER_CHAR = '\037';
/*  20 */   public static final String INTELLIJ_DUMMY_IDENTIFIER = TableFormatOptions.INTELLIJ_DUMMY_IDENTIFIER;
/*     */   
/*     */   public final DataHolder options;
/*     */   
/*     */   private static final String ST_EOL = "(?:\r\n|\r|\n)";
/*     */   
/*  26 */   private static final String ST_ESCAPED_CHAR = "\\\\" + Escaping.ESCAPABLE;
/*  27 */   private static final Pattern ST_LINK_LABEL = Pattern.compile("^\\[(?:[^\\\\\\[\\]]|" + ST_ESCAPED_CHAR + "|\\\\){0,999}\\]");
/*  28 */   private static final String ST_LINK_TITLE_STRING = "(?:\"(" + ST_ESCAPED_CHAR + "|[^\"\\x00])*\"|" + "'(" + ST_ESCAPED_CHAR + "|[^'\\x00])*'|" + "\\((" + ST_ESCAPED_CHAR + "|[^)\\x00])*\\))";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   private static final Pattern ST_LINK_TITLE = Pattern.compile("^" + ST_LINK_TITLE_STRING);
/*  34 */   public final String EOL = "(?:\r\n|\r|\n)";
/*  35 */   public final String ESCAPED_CHAR = ST_ESCAPED_CHAR;
/*  36 */   public final Pattern LINK_LABEL = ST_LINK_LABEL;
/*     */   public final Pattern LINK_DESTINATION_ANGLES;
/*  38 */   public final String LINK_TITLE_STRING = ST_LINK_TITLE_STRING;
/*  39 */   public final Pattern LINK_TITLE = ST_LINK_TITLE;
/*     */   
/*     */   public final Pattern LINK_DESTINATION;
/*     */   
/*     */   public final Pattern LINK_DESTINATION_MATCHED_PARENS;
/*     */   
/*     */   public final Pattern LINK_DESTINATION_MATCHED_PARENS_NOSP;
/*     */   private static final String ST_EXCLUDED_0_TO_SPACE_IDI = "\000-\036 ";
/*     */   private static final String ST_EXCLUDED_0_TO_SPACE_NO_IDI = "\000- ";
/*     */   private static final String ST_ADDITIONAL_CHARS_IDI = "\037";
/*     */   private static final String ST_ADDITIONAL_CHARS_NO_IDI = "";
/*     */   private static final String ST_ADDITIONAL_CHARS_SET_IDI = "[\037]";
/*     */   private static final String ST_ADDITIONAL_CHARS_SET_NO_IDI = "";
/*     */   public static final String ST_HTMLCOMMENT = "<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->";
/*     */   public static final String ST_PROCESSINGINSTRUCTION = "[<][?].*?[?][>]";
/*     */   public static final String ST_CDATA = "<!\\[CDATA\\[[\\s\\S]*?\\]\\]>";
/*     */   public static final String ST_SINGLEQUOTEDVALUE = "'[^']*'";
/*     */   public static final String ST_DOUBLEQUOTEDVALUE = "\"[^\"]*\"";
/*  57 */   public final String HTMLCOMMENT = "<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->";
/*  58 */   public final String PROCESSINGINSTRUCTION = "[<][?].*?[?][>]";
/*  59 */   public final String CDATA = "<!\\[CDATA\\[[\\s\\S]*?\\]\\]>";
/*  60 */   public final String SINGLEQUOTEDVALUE = "'[^']*'";
/*  61 */   public final String DOUBLEQUOTEDVALUE = "\"[^\"]*\"";
/*     */   
/*     */   private static final String ST_ASCII_PUNCTUATION = "'!\"#\\$%&\\*\\+,\\-\\./:;=\\?@\\\\\\^_`\\|~";
/*     */   private static final String ST_ASCII_OPEN_PUNCTUATION = "\\(<\\[\\{";
/*     */   private static final String ST_ASCII_CLOSE_PUNCTUATION = "\\)>\\]\\}";
/*  66 */   private static final Pattern ST_PUNCTUATION = Pattern.compile("^['!\"#\\$%&\\*\\+,\\-\\./:;=\\?@\\\\\\^_`\\|~\\(<\\[\\{\\)>\\]\\}\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
/*     */   
/*  68 */   private static final Pattern ST_PUNCTUATION_OPEN = Pattern.compile("^['!\"#\\$%&\\*\\+,\\-\\./:;=\\?@\\\\\\^_`\\|~\\(<\\[\\{]|[\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]&&[^\\)>\\]\\}]");
/*     */   
/*  70 */   private static final Pattern ST_PUNCTUATION_CLOSE = Pattern.compile("^['!\"#\\$%&\\*\\+,\\-\\./:;=\\?@\\\\\\^_`\\|~\\)>\\]\\}]|[\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]&&[^\\(<\\[\\{]");
/*     */   
/*  72 */   private static final Pattern ST_PUNCTUATION_ONLY = Pattern.compile("^['!\"#\\$%&\\*\\+,\\-\\./:;=\\?@\\\\\\^_`\\|~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]&&[^\\(<\\[\\{\\)>\\]\\}]");
/*     */   
/*  74 */   private static final Pattern ST_PUNCTUATION_OPEN_ONLY = Pattern.compile("^[\\(<\\[\\{]");
/*     */   
/*  76 */   private static final Pattern ST_PUNCTUATION_CLOSE_ONLY = Pattern.compile("^[\\)>\\]\\}]");
/*     */ 
/*     */   
/*  79 */   public final String ASCII_PUNCTUATION = "'!\"#\\$%&\\*\\+,\\-\\./:;=\\?@\\\\\\^_`\\|~";
/*  80 */   public final String ASCII_OPEN_PUNCTUATION = "\\(<\\[\\{";
/*  81 */   public final String ASCII_CLOSE_PUNCTUATION = "\\)>\\]\\}";
/*     */   
/*  83 */   public final Pattern PUNCTUATION = ST_PUNCTUATION;
/*  84 */   public final Pattern PUNCTUATION_OPEN = ST_PUNCTUATION_OPEN;
/*  85 */   public final Pattern PUNCTUATION_CLOSE = ST_PUNCTUATION_CLOSE;
/*  86 */   public final Pattern PUNCTUATION_ONLY = ST_PUNCTUATION_ONLY;
/*  87 */   public final Pattern PUNCTUATION_OPEN_ONLY = ST_PUNCTUATION_OPEN_ONLY;
/*  88 */   public final Pattern PUNCTUATION_CLOSE_ONLY = ST_PUNCTUATION_CLOSE_ONLY;
/*     */   
/*  90 */   private static final Pattern ST_ESCAPABLE = Pattern.compile("^" + Escaping.ESCAPABLE);
/*  91 */   private static final Pattern ST_TICKS = Pattern.compile("`+");
/*  92 */   private static final Pattern ST_TICKS_HERE = Pattern.compile("^`+");
/*  93 */   private static final Pattern ST_SPNL = Pattern.compile("^(?:[ \t])*(?:(?:\r\n|\r|\n)(?:[ \t])*)?");
/*  94 */   private static final Pattern ST_SPNL_URL = Pattern.compile("^(?:[ \t])*(?:\r\n|\r|\n)");
/*  95 */   private static final Pattern ST_SPNI = Pattern.compile("^ {0,3}");
/*  96 */   private static final Pattern ST_SP = Pattern.compile("^(?:[ \t])*");
/*  97 */   private static final Pattern ST_REST_OF_LINE = Pattern.compile("^.*(?:\r\n|\r|\n)");
/*  98 */   private static final Pattern ST_UNICODE_WHITESPACE_CHAR = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
/*  99 */   private static final Pattern ST_WHITESPACE = Pattern.compile("\\s+");
/* 100 */   private static final Pattern ST_FINAL_SPACE = Pattern.compile(" *$");
/* 101 */   private static final Pattern ST_LINE_END = Pattern.compile("^[ \t]*(?:(?:\r\n|\r|\n)|$)");
/* 102 */   private static final Pattern ST_LINK_DESTINATION_ANGLES_SPC = Pattern.compile("^(?:[<](?:[^<> \\t\\n\\\\\\x00]|" + ST_ESCAPED_CHAR + '|' + "\\\\| (?![\"']))*[>])");
/* 103 */   private static final Pattern ST_LINK_DESTINATION_ANGLES_NO_SPC = Pattern.compile("^(?:[<](?:[^<> \\t\\n\\\\\\x00]|" + ST_ESCAPED_CHAR + '|' + "\\\\)*[>])");
/*     */   
/* 105 */   public final Pattern ESCAPABLE = ST_ESCAPABLE;
/* 106 */   public final Pattern TICKS = ST_TICKS;
/* 107 */   public final Pattern TICKS_HERE = ST_TICKS_HERE;
/*     */   public final Pattern EMAIL_AUTOLINK;
/*     */   public final Pattern AUTOLINK;
/*     */   public final Pattern WWW_AUTOLINK;
/* 111 */   public final Pattern SPNL = ST_SPNL;
/* 112 */   public final Pattern SPNL_URL = ST_SPNL_URL;
/* 113 */   public final Pattern SPNI = ST_SPNI;
/* 114 */   public final Pattern SP = ST_SP;
/* 115 */   public final Pattern REST_OF_LINE = ST_REST_OF_LINE;
/* 116 */   public final Pattern UNICODE_WHITESPACE_CHAR = ST_UNICODE_WHITESPACE_CHAR;
/* 117 */   public final Pattern WHITESPACE = ST_WHITESPACE;
/* 118 */   public final Pattern FINAL_SPACE = ST_FINAL_SPACE;
/* 119 */   public final Pattern LINE_END = ST_LINE_END;
/*     */   
/*     */   private static final String ST_TAGNAME_IDI = "[A-Za-z\037][A-Za-z0-9\037-]*";
/*     */   
/*     */   private static final String ST_TAGNAME_NO_IDI = "[A-Za-z][A-Za-z0-9-]*";
/*     */   
/*     */   private static final String ST_UNQUOTEDVALUE_IDI = "[^\"'=<>{}`\000-\036 ]+";
/*     */   
/*     */   private static final String ST_UNQUOTEDVALUE_NO_IDI = "[^\"'=<>{}`\000- ]+";
/*     */   
/*     */   private static final String ST_ATTRIBUTENAME_IDI = "[a-zA-Z\037_:][a-zA-Z0-9\037:._-]*";
/*     */   
/*     */   private static final String ST_ATTRIBUTENAME_NO_IDI = "[a-zA-Z_:][a-zA-Z0-9:._-]*";
/*     */   
/*     */   private static final String ST_ATTRIBUTEVALUE_IDI = "(?:[^\"'=<>{}`\000-\036 ]+|'[^']*'|\"[^\"]*\")";
/*     */   
/*     */   private static final String ST_ATTRIBUTEVALUE_NO_IDI = "(?:[^\"'=<>{}`\000- ]+|'[^']*'|\"[^\"]*\")";
/*     */   
/*     */   private static final String ST_ATTRIBUTEVALUESPEC_IDI = "(?:\\s*=\\s*(?:[^\"'=<>{}`\000-\036 ]+|'[^']*'|\"[^\"]*\"))";
/*     */   
/*     */   private static final String ST_ATTRIBUTEVALUESPEC_NO_IDI = "(?:\\s*=\\s*(?:[^\"'=<>{}`\000- ]+|'[^']*'|\"[^\"]*\"))";
/*     */   
/*     */   private static final String ST_CLOSETAG_IDI = "</[A-Za-z\037][A-Za-z0-9\037-]*\\s*[>]";
/*     */   
/*     */   private static final String ST_CLOSETAG_NO_IDI = "</[A-Za-z][A-Za-z0-9-]*\\s*[>]";
/*     */   
/*     */   private static final String ST_ATTRIBUTE_IDI = "(?:\\s+[a-zA-Z\037_:][a-zA-Z0-9\037:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\000-\036 ]+|'[^']*'|\"[^\"]*\"))?)";
/*     */   private static final String ST_ATTRIBUTE_NO_IDI = "(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\000- ]+|'[^']*'|\"[^\"]*\"))?)";
/*     */   private static final String ST_DECLARATION_IDI = "<![A-Z\037]+\\s+[^>]*>";
/*     */   private static final String ST_DECLARATION_NO_IDI = "<![A-Z]+\\s+[^>]*>";
/*     */   private static final String ST_ENTITY_IDI = "&(?:#x[a-f0-9\037]{1,8}|#[0-9]{1,8}|[a-z\037][a-z0-9\037]{1,31});";
/*     */   private static final String ST_ENTITY_NO_IDI = "&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});";
/*     */   private static final String ST_IN_BRACES_W_SP_IDI = "\\{\\{(?:[^{}\\\\\000-\036 ]| |\t)*\\}\\}";
/*     */   private static final String ST_IN_BRACES_W_SP_NO_IDI = "\\{\\{(?:[^{}\\\\\000- ]| |\t)*\\}\\}";
/*     */   private static final String ST_REG_CHAR_IDI = "[^\\\\()\000-\036 ]";
/*     */   private static final String ST_REG_CHAR_NO_IDI = "[^\\\\()\000- ]";
/* 155 */   private static final String ST_IN_MATCHED_PARENS_NOSP_IDI = "\\(([^\\\\()\000-\036 ]|" + ST_ESCAPED_CHAR + ")*\\)";
/* 156 */   private static final String ST_IN_MATCHED_PARENS_NOSP_NO_IDI = "\\(([^\\\\()\000- ]|" + ST_ESCAPED_CHAR + ")*\\)";
/*     */   
/*     */   private static final String ST_REG_CHAR_SP_IDI = "[^\\\\()\000-\036 ]| (?![\"'])";
/*     */   
/*     */   private static final String ST_REG_CHAR_SP_NO_IDI = "[^\\\\()\000- ]| (?![\"'])";
/* 161 */   private static final String ST_IN_MATCHED_PARENS_W_SP_IDI = "\\(([^\\\\()\000-\036 ]| (?![\"'])|" + ST_ESCAPED_CHAR + ")*\\)";
/* 162 */   private static final String ST_IN_MATCHED_PARENS_W_SP_NO_IDI = "\\(([^\\\\()\000- ]| (?![\"'])|" + ST_ESCAPED_CHAR + ")*\\)";
/*     */   
/* 164 */   private static final String ST_IN_PARENS_NOSP_IDI = "\\(([^\\\\()\000-\036 ]|" + ST_ESCAPED_CHAR + ")*\\)";
/* 165 */   private static final String ST_IN_PARENS_NOSP_NO_IDI = "\\(([^\\\\()\000- ]|" + ST_ESCAPED_CHAR + ")*\\)";
/*     */   
/* 167 */   private static final String ST_IN_PARENS_W_SP_IDI = "\\(([^\\\\()\000-\036 ]| (?![\"'])|" + ST_ESCAPED_CHAR + ")*\\)";
/* 168 */   private static final String ST_IN_PARENS_W_SP_NO_IDI = "\\(([^\\\\()\000- ]| (?![\"'])|" + ST_ESCAPED_CHAR + ")*\\)";
/*     */   
/*     */   private static final String ST_OPENTAG_IDI = "<[A-Za-z\037][A-Za-z0-9\037-]*(?:\\s+[a-zA-Z\037_:][a-zA-Z0-9\037:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\000-\036 ]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>";
/*     */   
/*     */   private static final String ST_OPENTAG_NO_IDI = "<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\000- ]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>";
/*     */   
/*     */   private static final String ST_REG_CHAR_PARENS_IDI = "[^\\\\\000-\036 ]";
/*     */   
/*     */   private static final String ST_REG_CHAR_PARENS_NO_IDI = "[^\\\\\000- ]";
/*     */   private static final String ST_REG_CHAR_SP_PARENS_IDI = "[^\\\\\000-\036 ]| (?![\"'])";
/*     */   private static final String ST_REG_CHAR_SP_PARENS_NO_IDI = "[^\\\\\000- ]| (?![\"'])";
/* 179 */   private static final Pattern ST_ENTITY_HERE_IDI = Pattern.compile("^&(?:#x[a-f0-9\037]{1,8}|#[0-9]{1,8}|[a-z\037][a-z0-9\037]{1,31});", 2);
/* 180 */   private static final Pattern ST_ENTITY_HERE_NO_IDI = Pattern.compile("^&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});", 2);
/*     */   
/*     */   public final String ADDITIONAL_CHARS;
/*     */   
/*     */   public final String EXCLUDED_0_TO_SPACE;
/*     */   
/*     */   public final String REG_CHAR;
/*     */   
/*     */   public final String REG_CHAR_PARENS;
/*     */   public final String REG_CHAR_SP;
/*     */   public final String REG_CHAR_SP_PARENS;
/*     */   public final String IN_PARENS_NOSP;
/*     */   public final String IN_PARENS_W_SP;
/*     */   public final String IN_MATCHED_PARENS_NOSP;
/*     */   public final String IN_MATCHED_PARENS_W_SP;
/*     */   public final String IN_BRACES_W_SP;
/*     */   public final String DECLARATION;
/*     */   public final String ENTITY;
/*     */   public final String TAGNAME;
/*     */   public final String ATTRIBUTENAME;
/*     */   public final String UNQUOTEDVALUE;
/*     */   public final String ATTRIBUTEVALUE;
/*     */   public final String ATTRIBUTEVALUESPEC;
/*     */   public final String ATTRIBUTE;
/*     */   public final String OPENTAG;
/*     */   public final String CLOSETAG;
/*     */   public final String HTMLTAG;
/*     */   public final Pattern ENTITY_HERE;
/*     */   public final Pattern HTML_TAG;
/*     */   public final Pattern LIST_ITEM_MARKER;
/*     */   public final int CODE_BLOCK_INDENT;
/*     */   public final boolean intellijDummyIdentifier;
/*     */   public final boolean htmlForTranslator;
/*     */   public final String translationHtmlInlineTagPattern;
/*     */   public final String translationAutolinkTagPattern;
/*     */   public final boolean spaceInLinkUrl;
/*     */   public final boolean parseJekyllMacroInLinkUrl;
/*     */   public final String itemPrefixChars;
/*     */   public final boolean listsItemMarkerSpace;
/*     */   public final boolean listsOrderedItemDotOnly;
/*     */   
/*     */   private static class PatternTypeFlags
/*     */   {
/*     */     final Boolean intellijDummyIdentifier;
/*     */     final Boolean htmlForTranslator;
/*     */     final String translationHtmlInlineTagPattern;
/*     */     final String translationAutolinkTagPattern;
/*     */     final Boolean spaceInLinkUrl;
/*     */     final Boolean parseJekyllMacroInLinkUrl;
/*     */     final String itemPrefixChars;
/*     */     final Boolean listsItemMarkerSpace;
/*     */     final Boolean listsOrderedItemDotOnly;
/*     */     
/*     */     PatternTypeFlags(DataHolder param1DataHolder) {
/* 234 */       this.intellijDummyIdentifier = (Boolean)Parser.INTELLIJ_DUMMY_IDENTIFIER.get(param1DataHolder);
/* 235 */       this.htmlForTranslator = (Boolean)Parser.HTML_FOR_TRANSLATOR.get(param1DataHolder);
/* 236 */       this.translationHtmlInlineTagPattern = (String)Parser.TRANSLATION_HTML_INLINE_TAG_PATTERN.get(param1DataHolder);
/* 237 */       this.translationAutolinkTagPattern = (String)Parser.TRANSLATION_AUTOLINK_TAG_PATTERN.get(param1DataHolder);
/* 238 */       this.spaceInLinkUrl = (Boolean)Parser.SPACE_IN_LINK_URLS.get(param1DataHolder);
/* 239 */       this.parseJekyllMacroInLinkUrl = (Boolean)Parser.PARSE_JEKYLL_MACROS_IN_URLS.get(param1DataHolder);
/* 240 */       this.itemPrefixChars = (String)Parser.LISTS_ITEM_PREFIX_CHARS.get(param1DataHolder);
/* 241 */       this.listsItemMarkerSpace = (Boolean)Parser.LISTS_ITEM_MARKER_SPACE.get(param1DataHolder);
/* 242 */       this.listsOrderedItemDotOnly = (Boolean)Parser.LISTS_ORDERED_ITEM_DOT_ONLY.get(param1DataHolder);
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
/*     */     public PatternTypeFlags(Boolean param1Boolean1, Boolean param1Boolean2, String param1String1, String param1String2, Boolean param1Boolean3, Boolean param1Boolean4, String param1String3, Boolean param1Boolean5, Boolean param1Boolean6) {
/* 256 */       this.intellijDummyIdentifier = param1Boolean1;
/* 257 */       this.htmlForTranslator = param1Boolean2;
/* 258 */       this.translationHtmlInlineTagPattern = param1String1;
/* 259 */       this.translationAutolinkTagPattern = param1String2;
/* 260 */       this.spaceInLinkUrl = param1Boolean3;
/* 261 */       this.parseJekyllMacroInLinkUrl = param1Boolean4;
/* 262 */       this.itemPrefixChars = param1String3;
/* 263 */       this.listsItemMarkerSpace = param1Boolean5;
/* 264 */       this.listsOrderedItemDotOnly = param1Boolean6;
/*     */     }
/*     */     PatternTypeFlags withJekyllMacroInLinkUrl() {
/* 267 */       return new PatternTypeFlags(this.intellijDummyIdentifier, null, null, null, null, this.parseJekyllMacroInLinkUrl, null, null, null);
/*     */     } PatternTypeFlags withJekyllMacroSpaceInLinkUrl() {
/* 269 */       return new PatternTypeFlags(this.intellijDummyIdentifier, null, null, null, this.spaceInLinkUrl, this.parseJekyllMacroInLinkUrl, null, null, null);
/*     */     } PatternTypeFlags withHtmlTranslator() {
/* 271 */       return new PatternTypeFlags(this.intellijDummyIdentifier, this.htmlForTranslator, this.translationHtmlInlineTagPattern, this.translationAutolinkTagPattern, null, null, null, null, null);
/*     */     } PatternTypeFlags withItemPrefixChars() {
/* 273 */       return new PatternTypeFlags(null, null, null, null, null, null, this.itemPrefixChars, this.listsItemMarkerSpace, this.listsOrderedItemDotOnly);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 283 */       if (this == param1Object) return true; 
/* 284 */       if (param1Object == null || getClass() != param1Object.getClass()) return false;
/*     */       
/* 286 */       param1Object = param1Object;
/*     */       
/* 288 */       if (this.intellijDummyIdentifier != null && !this.intellijDummyIdentifier.equals(((PatternTypeFlags)param1Object).intellijDummyIdentifier)) return false; 
/* 289 */       if (this.htmlForTranslator != null && !this.htmlForTranslator.equals(((PatternTypeFlags)param1Object).htmlForTranslator)) return false; 
/* 290 */       if (this.translationHtmlInlineTagPattern != null && !this.translationHtmlInlineTagPattern.equals(((PatternTypeFlags)param1Object).translationHtmlInlineTagPattern)) return false; 
/* 291 */       if (this.translationAutolinkTagPattern != null && !this.translationAutolinkTagPattern.equals(((PatternTypeFlags)param1Object).translationAutolinkTagPattern)) return false; 
/* 292 */       if (this.spaceInLinkUrl != null && !this.spaceInLinkUrl.equals(((PatternTypeFlags)param1Object).spaceInLinkUrl)) return false; 
/* 293 */       if (this.parseJekyllMacroInLinkUrl != null && !this.parseJekyllMacroInLinkUrl.equals(((PatternTypeFlags)param1Object).parseJekyllMacroInLinkUrl)) return false; 
/* 294 */       if (this.itemPrefixChars != null && !this.itemPrefixChars.equals(((PatternTypeFlags)param1Object).itemPrefixChars)) return false; 
/* 295 */       if (this.listsItemMarkerSpace != null && !this.listsItemMarkerSpace.equals(((PatternTypeFlags)param1Object).listsItemMarkerSpace)) return false;
/*     */       
/* 297 */       return (this.listsOrderedItemDotOnly == null || this.listsOrderedItemDotOnly.equals(((PatternTypeFlags)param1Object).listsOrderedItemDotOnly));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 302 */       int i = (this.intellijDummyIdentifier != null) ? this.intellijDummyIdentifier.hashCode() : 0;
/* 303 */       i = i * 31 + ((this.htmlForTranslator != null) ? this.htmlForTranslator.hashCode() : 0);
/* 304 */       i = i * 31 + ((this.translationHtmlInlineTagPattern != null) ? this.translationHtmlInlineTagPattern.hashCode() : 0);
/* 305 */       i = i * 31 + ((this.translationAutolinkTagPattern != null) ? this.translationAutolinkTagPattern.hashCode() : 0);
/* 306 */       i = i * 31 + ((this.spaceInLinkUrl != null) ? this.spaceInLinkUrl.hashCode() : 0);
/* 307 */       i = i * 31 + ((this.parseJekyllMacroInLinkUrl != null) ? this.parseJekyllMacroInLinkUrl.hashCode() : 0);
/* 308 */       i = i * 31 + ((this.itemPrefixChars != null) ? this.itemPrefixChars.hashCode() : 0);
/* 309 */       i = i * 31 + ((this.listsItemMarkerSpace != null) ? this.listsItemMarkerSpace.hashCode() : 0);
/*     */       
/* 311 */       return i = i * 31 + ((this.listsOrderedItemDotOnly != null) ? this.listsOrderedItemDotOnly.hashCode() : 0);
/*     */     }
/*     */   }
/*     */   
/* 315 */   static final HashMap<String, HashMap<PatternTypeFlags, Pattern>> cachedPatterns = new HashMap<>();
/*     */   
/*     */   static Pattern getCachedPattern(String paramString, PatternTypeFlags paramPatternTypeFlags, Function<PatternTypeFlags, Pattern> paramFunction) {
/*     */     HashMap<PatternTypeFlags, Pattern> hashMap;
/* 319 */     return (hashMap = cachedPatterns.computeIfAbsent(paramString, paramString -> new HashMap<>())).computeIfAbsent(paramPatternTypeFlags, paramFunction);
/*     */   }
/*     */   
/*     */   public Parsing(DataHolder paramDataHolder) {
/* 323 */     this.options = paramDataHolder;
/* 324 */     this.CODE_BLOCK_INDENT = ((Integer)Parser.CODE_BLOCK_INDENT.get(paramDataHolder)).intValue();
/* 325 */     null = new PatternTypeFlags(paramDataHolder);
/* 326 */     this.intellijDummyIdentifier = null.intellijDummyIdentifier.booleanValue();
/* 327 */     this.htmlForTranslator = null.htmlForTranslator.booleanValue();
/* 328 */     this.translationHtmlInlineTagPattern = null.translationHtmlInlineTagPattern;
/* 329 */     this.translationAutolinkTagPattern = null.translationAutolinkTagPattern;
/* 330 */     this.spaceInLinkUrl = null.spaceInLinkUrl.booleanValue();
/* 331 */     this.parseJekyllMacroInLinkUrl = null.parseJekyllMacroInLinkUrl.booleanValue();
/* 332 */     this.itemPrefixChars = null.itemPrefixChars;
/* 333 */     this.listsItemMarkerSpace = null.listsItemMarkerSpace.booleanValue();
/* 334 */     this.listsOrderedItemDotOnly = null.listsOrderedItemDotOnly.booleanValue();
/*     */     
/* 336 */     if (this.intellijDummyIdentifier) {
/* 337 */       this.ADDITIONAL_CHARS = "\037";
/* 338 */       this.EXCLUDED_0_TO_SPACE = "\000-\036 ";
/* 339 */       this.REG_CHAR = "[^\\\\()\000-\036 ]";
/* 340 */       this.REG_CHAR_PARENS = "[^\\\\\000-\036 ]";
/* 341 */       this.REG_CHAR_SP = "[^\\\\()\000-\036 ]| (?![\"'])";
/* 342 */       this.REG_CHAR_SP_PARENS = "[^\\\\\000-\036 ]| (?![\"'])";
/* 343 */       this.IN_PARENS_NOSP = ST_IN_PARENS_NOSP_IDI;
/* 344 */       this.IN_PARENS_W_SP = ST_IN_PARENS_W_SP_IDI;
/* 345 */       this.IN_MATCHED_PARENS_NOSP = ST_IN_MATCHED_PARENS_NOSP_IDI;
/* 346 */       this.IN_MATCHED_PARENS_W_SP = ST_IN_MATCHED_PARENS_W_SP_IDI;
/* 347 */       this.IN_BRACES_W_SP = "\\{\\{(?:[^{}\\\\\000-\036 ]| |\t)*\\}\\}";
/* 348 */       this.DECLARATION = "<![A-Z\037]+\\s+[^>]*>";
/* 349 */       this.ENTITY = "&(?:#x[a-f0-9\037]{1,8}|#[0-9]{1,8}|[a-z\037][a-z0-9\037]{1,31});";
/* 350 */       this.TAGNAME = "[A-Za-z\037][A-Za-z0-9\037-]*";
/* 351 */       this.ATTRIBUTENAME = "[a-zA-Z\037_:][a-zA-Z0-9\037:._-]*";
/* 352 */       this.UNQUOTEDVALUE = "[^\"'=<>{}`\000-\036 ]+";
/* 353 */       this.ATTRIBUTEVALUE = "(?:[^\"'=<>{}`\000-\036 ]+|'[^']*'|\"[^\"]*\")";
/* 354 */       this.ATTRIBUTEVALUESPEC = "(?:\\s*=\\s*(?:[^\"'=<>{}`\000-\036 ]+|'[^']*'|\"[^\"]*\"))";
/* 355 */       this.ATTRIBUTE = "(?:\\s+[a-zA-Z\037_:][a-zA-Z0-9\037:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\000-\036 ]+|'[^']*'|\"[^\"]*\"))?)";
/* 356 */       this.OPENTAG = "<[A-Za-z\037][A-Za-z0-9\037-]*(?:\\s+[a-zA-Z\037_:][a-zA-Z0-9\037:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\000-\036 ]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>";
/* 357 */       this.CLOSETAG = "</[A-Za-z\037][A-Za-z0-9\037-]*\\s*[>]";
/*     */     } else {
/* 359 */       this.ADDITIONAL_CHARS = "";
/* 360 */       this.EXCLUDED_0_TO_SPACE = "\000- ";
/* 361 */       this.REG_CHAR = "[^\\\\()\000- ]";
/* 362 */       this.REG_CHAR_PARENS = "[^\\\\\000- ]";
/* 363 */       this.REG_CHAR_SP = "[^\\\\()\000- ]| (?![\"'])";
/* 364 */       this.REG_CHAR_SP_PARENS = "[^\\\\\000- ]| (?![\"'])";
/* 365 */       this.IN_PARENS_NOSP = ST_IN_PARENS_NOSP_NO_IDI;
/* 366 */       this.IN_PARENS_W_SP = ST_IN_PARENS_W_SP_NO_IDI;
/* 367 */       this.IN_MATCHED_PARENS_NOSP = ST_IN_MATCHED_PARENS_NOSP_NO_IDI;
/* 368 */       this.IN_MATCHED_PARENS_W_SP = ST_IN_MATCHED_PARENS_W_SP_NO_IDI;
/* 369 */       this.IN_BRACES_W_SP = "\\{\\{(?:[^{}\\\\\000- ]| |\t)*\\}\\}";
/* 370 */       this.DECLARATION = "<![A-Z]+\\s+[^>]*>";
/* 371 */       this.ENTITY = "&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});";
/* 372 */       this.TAGNAME = "[A-Za-z][A-Za-z0-9-]*";
/* 373 */       this.ATTRIBUTENAME = "[a-zA-Z_:][a-zA-Z0-9:._-]*";
/* 374 */       this.UNQUOTEDVALUE = "[^\"'=<>{}`\000- ]+";
/* 375 */       this.ATTRIBUTEVALUE = "(?:[^\"'=<>{}`\000- ]+|'[^']*'|\"[^\"]*\")";
/* 376 */       this.ATTRIBUTEVALUESPEC = "(?:\\s*=\\s*(?:[^\"'=<>{}`\000- ]+|'[^']*'|\"[^\"]*\"))";
/* 377 */       this.ATTRIBUTE = "(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\000- ]+|'[^']*'|\"[^\"]*\"))?)";
/* 378 */       this.OPENTAG = "<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\000- ]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>";
/* 379 */       this.CLOSETAG = "</[A-Za-z][A-Za-z0-9-]*\\s*[>]";
/*     */     } 
/*     */ 
/*     */     
/* 383 */     this.LINK_DESTINATION_ANGLES = this.spaceInLinkUrl ? ST_LINK_DESTINATION_ANGLES_SPC : ST_LINK_DESTINATION_ANGLES_NO_SPC;
/* 384 */     this.ENTITY_HERE = this.intellijDummyIdentifier ? ST_ENTITY_HERE_IDI : ST_ENTITY_HERE_NO_IDI;
/*     */ 
/*     */     
/* 387 */     synchronized (cachedPatterns) {
/* 388 */       this.LINK_DESTINATION_MATCHED_PARENS_NOSP = getCachedPattern("LINK_DESTINATION_MATCHED_PARENS_NOSP", null.withJekyllMacroInLinkUrl(), paramPatternTypeFlags -> Pattern.compile("^(?:" + (this.parseJekyllMacroInLinkUrl ? (this.IN_BRACES_W_SP + "|") : "") + this.REG_CHAR + "|" + this.ESCAPED_CHAR + "|\\\\|\\(|\\))*"));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 393 */       this.LINK_DESTINATION = getCachedPattern("LINK_DESTINATION", null.withJekyllMacroSpaceInLinkUrl(), paramPatternTypeFlags -> Pattern.compile("^(?:" + (this.parseJekyllMacroInLinkUrl ? (this.IN_BRACES_W_SP + "|") : "") + (this.spaceInLinkUrl ? ("(?:" + this.REG_CHAR_SP + ")|") : (this.REG_CHAR + "|")) + this.ESCAPED_CHAR + "|\\\\|" + (this.spaceInLinkUrl ? this.IN_PARENS_W_SP : this.IN_PARENS_NOSP) + ")*"));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 398 */       this.LINK_DESTINATION_MATCHED_PARENS = getCachedPattern("LINK_DESTINATION_MATCHED_PARENS", null.withJekyllMacroSpaceInLinkUrl(), paramPatternTypeFlags -> Pattern.compile("^(?:" + (this.parseJekyllMacroInLinkUrl ? (this.IN_BRACES_W_SP + "|") : "") + (this.spaceInLinkUrl ? ("(?:" + this.REG_CHAR_SP + ")|") : (this.REG_CHAR + "|")) + this.ESCAPED_CHAR + "|\\\\|\\(|\\))*"));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 403 */       this.EMAIL_AUTOLINK = getCachedPattern("EMAIL_AUTOLINK", null.withHtmlTranslator(), paramPatternTypeFlags -> Pattern.compile("^<((?:[a-zA-Z0-9" + this.ADDITIONAL_CHARS + ".!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9" + this.ADDITIONAL_CHARS + "](?:[a-zA-Z0-9" + this.ADDITIONAL_CHARS + "-]{0,61}[a-zA-Z0-9" + this.ADDITIONAL_CHARS + "])?(?:\\.[a-zA-Z0-9" + this.ADDITIONAL_CHARS + "](?:[a-zA-Z0-9" + this.ADDITIONAL_CHARS + "-]{0,61}[a-zA-Z0-9" + this.ADDITIONAL_CHARS + "])?)*)" + (this.htmlForTranslator ? ("|(?:" + this.translationAutolinkTagPattern + ")") : "") + ")>"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 409 */       this.AUTOLINK = getCachedPattern("AUTOLINK", null.withHtmlTranslator(), paramPatternTypeFlags -> Pattern.compile("^<((?:[a-zA-Z][a-zA-Z0-9" + this.ADDITIONAL_CHARS + ".+-]{1,31}:[^<>" + this.EXCLUDED_0_TO_SPACE + "]*)" + (this.htmlForTranslator ? ("|(?:" + this.translationAutolinkTagPattern + ")") : "") + ")>"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 415 */       this.WWW_AUTOLINK = getCachedPattern("WWW_AUTOLINK", null.withHtmlTranslator(), paramPatternTypeFlags -> Pattern.compile("^<((?:w" + this.ADDITIONAL_CHARS + "?){3,3}\\.[^<>" + this.EXCLUDED_0_TO_SPACE + "]*" + (this.htmlForTranslator ? ("|(?:" + this.translationAutolinkTagPattern + ")") : "") + ")>"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 421 */       this.HTML_TAG = getCachedPattern("HTML_TAG", null.withHtmlTranslator(), paramPatternTypeFlags -> Pattern.compile("^" + "(?:" + this.OPENTAG + "|" + this.CLOSETAG + "|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->" + "|[<][?].*?[?][>]" + "|" + this.DECLARATION + "|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>" + (this.htmlForTranslator ? ("|<(?:" + this.translationHtmlInlineTagPattern + ")>|</(?:" + this.translationHtmlInlineTagPattern + ")>") : "") + ")", 2));
/*     */ 
/*     */ 
/*     */       
/* 425 */       this.LIST_ITEM_MARKER = getCachedPattern("LIST_ITEM_MARKER", null.withItemPrefixChars(), paramPatternTypeFlags -> this.listsItemMarkerSpace ? (this.listsOrderedItemDotOnly ? Pattern.compile("^([\\Q" + this.itemPrefixChars + "\\E])(?=[ \t])|^(\\d{1,9})([.])(?=[ \t])") : Pattern.compile("^([\\Q" + this.itemPrefixChars + "\\E])(?=[ \t])|^(\\d{1,9})([.)])(?=[ \t])")) : (this.listsOrderedItemDotOnly ? Pattern.compile("^([\\Q" + this.itemPrefixChars + "\\E])(?= |\t|$)|^(\\d{1,9})([.])(?= |\t|$)") : Pattern.compile("^([\\Q" + this.itemPrefixChars + "\\E])(?= |\t|$)|^(\\d{1,9})([.)])(?= |\t|$)")));
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
/* 442 */     this.HTMLTAG = this.HTML_TAG.pattern();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public String EXCLUDED_0_TO_SPACE() {
/* 450 */     return this.intellijDummyIdentifier ? "\000-\036 " : "\000- ";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public String ADDITIONAL_CHARS() {
/* 458 */     return this.intellijDummyIdentifier ? "\037" : "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public String ADDITIONAL_CHARS_SET(String paramString) {
/* 466 */     return this.intellijDummyIdentifier ? ("[\037]" + paramString) : "";
/*     */   }
/*     */ 
/*     */   
/*     */   public static int columnsToNextTabStop(int paramInt) {
/* 471 */     return 4 - paramInt % 4;
/*     */   }
/*     */   
/*     */   public static int findLineBreak(CharSequence paramCharSequence, int paramInt) {
/* 475 */     return SequenceUtils.indexOfAny(paramCharSequence, CharPredicate.ANY_EOL, paramInt);
/*     */   }
/*     */   
/*     */   public static boolean isBlank(CharSequence paramCharSequence) {
/* 479 */     return (SequenceUtils.indexOfAnyNot(paramCharSequence, CharPredicate.BLANKSPACE) == -1);
/*     */   }
/*     */   
/*     */   public static boolean isLetter(CharSequence paramCharSequence, int paramInt) {
/*     */     int i;
/* 484 */     return Character.isLetter(i = Character.codePointAt(paramCharSequence, paramInt));
/*     */   }
/*     */   
/*     */   public static boolean isSpaceOrTab(CharSequence paramCharSequence, int paramInt) {
/* 488 */     return CharPredicate.SPACE_TAB.test(SequenceUtils.safeCharAt(paramCharSequence, paramInt));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\Parsing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */