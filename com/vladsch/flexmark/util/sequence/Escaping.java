/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Escaping
/*     */ {
/*     */   public static final String ESCAPABLE_CHARS = "\"#$%&'()*+,./:;<=>?@[]\\^_`{|}~-";
/*  19 */   public static final String ESCAPABLE = "[!" + "\"#$%&'()*+,./:;<=>?@[]\\^_`{|}~-"
/*     */     
/*  21 */     .replace("\\", "\\\\")
/*  22 */     .replace("[", "\\[")
/*  23 */     .replace("]", "\\]") + "]";
/*     */ 
/*     */   
/*     */   private static final String ENTITY = "&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});";
/*     */   
/*  28 */   private static final Pattern BACKSLASH_ONLY = Pattern.compile("[\\\\]");
/*     */ 
/*     */   
/*  31 */   private static final Pattern ESCAPED_CHAR = Pattern.compile("\\\\" + ESCAPABLE, 2);
/*     */   
/*  33 */   private static final Pattern BACKSLASH_OR_AMP = Pattern.compile("[\\\\&]");
/*     */   
/*  35 */   private static final Pattern AMP_ONLY = Pattern.compile("[\\&]");
/*     */ 
/*     */   
/*  38 */   private static final Pattern ENTITY_OR_ESCAPED_CHAR = Pattern.compile("\\\\" + ESCAPABLE + '|' + "&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});", 2);
/*     */ 
/*     */   
/*  41 */   private static final Pattern ENTITY_ONLY = Pattern.compile("&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});", 2);
/*     */   
/*     */   private static final String XML_SPECIAL = "[&<>\"]";
/*     */   
/*  45 */   private static final Pattern XML_SPECIAL_RE = Pattern.compile("[&<>\"]");
/*     */ 
/*     */   
/*  48 */   private static final Pattern XML_SPECIAL_OR_ENTITY = Pattern.compile("&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});|[&<>\"]", 2);
/*     */ 
/*     */ 
/*     */   
/*  52 */   private static final Pattern ESCAPE_IN_URI = Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
/*     */ 
/*     */   
/*  55 */   private static final Pattern ESCAPE_URI_DECODE = Pattern.compile("(%[a-fA-F0-9]{2})");
/*     */   
/*  57 */   static final char[] HEX_DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */ 
/*     */   
/*  60 */   private static final Pattern WHITESPACE = Pattern.compile("[ \t\r\n]+");
/*     */   
/*  62 */   private static final Pattern COLLAPSE_WHITESPACE = Pattern.compile("[ \t]{2,}");
/*     */   
/*  64 */   private static final Replacer UNSAFE_CHAR_REPLACER = new Replacer()
/*     */     {
/*     */       public final void replace(String param1String, StringBuilder param1StringBuilder) {
/*  67 */         if (param1String.equals("&")) {
/*  68 */           param1StringBuilder.append("&amp;"); return;
/*  69 */         }  if (param1String.equals("<")) {
/*  70 */           param1StringBuilder.append("&lt;"); return;
/*  71 */         }  if (param1String.equals(">")) {
/*  72 */           param1StringBuilder.append("&gt;"); return;
/*  73 */         }  if (param1String.equals("\"")) {
/*  74 */           param1StringBuilder.append("&quot;"); return;
/*     */         } 
/*  76 */         param1StringBuilder.append(param1String);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public final void replace(BasedSequence param1BasedSequence, int param1Int1, int param1Int2, ReplacedTextMapper param1ReplacedTextMapper) {
/*     */         String str;
/*  83 */         if ((str = param1BasedSequence.subSequence(param1Int1, param1Int2).toString()).equals("&")) {
/*  84 */           param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int2, PrefixedSubSequence.prefixOf("&amp;", BasedSequence.NULL)); return;
/*  85 */         }  if (str.equals("<")) {
/*  86 */           param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int2, PrefixedSubSequence.prefixOf("&lt;", BasedSequence.NULL)); return;
/*  87 */         }  if (str.equals(">")) {
/*  88 */           param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int2, PrefixedSubSequence.prefixOf("&gt;", BasedSequence.NULL)); return;
/*  89 */         }  if (str.equals("\"")) {
/*  90 */           param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int2, PrefixedSubSequence.prefixOf("&quot;", BasedSequence.NULL)); return;
/*     */         } 
/*  92 */         param1ReplacedTextMapper.addOriginalText(param1Int1, param1Int2);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  97 */   private static final Replacer COLLAPSE_WHITESPACE_REPLACER = new Replacer()
/*     */     {
/*     */       public final void replace(String param1String, StringBuilder param1StringBuilder) {
/* 100 */         param1StringBuilder.append(" ");
/*     */       }
/*     */ 
/*     */       
/*     */       public final void replace(BasedSequence param1BasedSequence, int param1Int1, int param1Int2, ReplacedTextMapper param1ReplacedTextMapper) {
/* 105 */         param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int2, param1BasedSequence.subSequence(param1Int1, param1Int1 + 1));
/*     */       }
/*     */     };
/*     */   
/* 109 */   private static final Replacer UNESCAPE_REPLACER = new Replacer()
/*     */     {
/*     */       public final void replace(String param1String, StringBuilder param1StringBuilder) {
/* 112 */         if (param1String.charAt(0) == '\\') {
/* 113 */           param1StringBuilder.append(param1String, 1, param1String.length()); return;
/*     */         } 
/* 115 */         param1StringBuilder.append(Html5Entities.entityToString(param1String));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public final void replace(BasedSequence param1BasedSequence, int param1Int1, int param1Int2, ReplacedTextMapper param1ReplacedTextMapper) {
/* 121 */         if (param1BasedSequence.charAt(param1Int1) == '\\') {
/* 122 */           param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int2, param1BasedSequence.subSequence(param1Int1 + 1, param1Int2)); return;
/*     */         } 
/* 124 */         param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int2, Html5Entities.entityToSequence(param1BasedSequence.subSequence(param1Int1, param1Int2)));
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 129 */   private static final Replacer REMOVE_REPLACER = new Replacer()
/*     */     {
/*     */       public final void replace(String param1String, StringBuilder param1StringBuilder) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final void replace(BasedSequence param1BasedSequence, int param1Int1, int param1Int2, ReplacedTextMapper param1ReplacedTextMapper) {
/* 137 */         param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int2, param1BasedSequence.subSequence(param1Int2, param1Int2));
/*     */       }
/*     */     };
/*     */   
/* 141 */   private static final Replacer ENTITY_REPLACER = new Replacer()
/*     */     {
/*     */       public final void replace(String param1String, StringBuilder param1StringBuilder) {
/* 144 */         param1StringBuilder.append(Html5Entities.entityToString(param1String));
/*     */       }
/*     */ 
/*     */       
/*     */       public final void replace(BasedSequence param1BasedSequence, int param1Int1, int param1Int2, ReplacedTextMapper param1ReplacedTextMapper) {
/* 149 */         param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int2, Html5Entities.entityToSequence(param1BasedSequence.subSequence(param1Int1, param1Int2)));
/*     */       }
/*     */     };
/*     */   
/* 153 */   private static final Replacer URL_ENCODE_REPLACER = new Replacer()
/*     */     {
/*     */       public final void replace(String param1String, StringBuilder param1StringBuilder) {
/* 156 */         if (param1String.startsWith("%")) {
/* 157 */           if (param1String.length() == 3) {
/*     */             
/* 159 */             param1StringBuilder.append(param1String);
/*     */             return;
/*     */           } 
/* 162 */           param1StringBuilder.append("%25");
/* 163 */           param1StringBuilder.append(param1String, 1, param1String.length()); return;
/*     */         }  byte[] arrayOfByte;
/*     */         int i;
/*     */         byte b;
/* 167 */         for (i = (arrayOfByte = arrayOfByte = param1String.getBytes(StandardCharsets.UTF_8)).length, b = 0; b < i; ) { byte b1 = arrayOfByte[b];
/* 168 */           param1StringBuilder.append('%');
/* 169 */           param1StringBuilder.append(Escaping.HEX_DIGITS[b1 >> 4 & 0xF]);
/* 170 */           param1StringBuilder.append(Escaping.HEX_DIGITS[b1 & 0xF]);
/*     */           b++; }
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public final void replace(BasedSequence param1BasedSequence, int param1Int1, int param1Int2, ReplacedTextMapper param1ReplacedTextMapper) {
/* 178 */         if ((param1BasedSequence = param1BasedSequence.subSequence(param1Int1, param1Int2)).startsWith("%")) {
/* 179 */           if (param1BasedSequence.length() == 3) {
/*     */             
/* 181 */             param1ReplacedTextMapper.addOriginalText(param1Int1, param1Int2);
/*     */             return;
/*     */           } 
/* 184 */           param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int1 + 1, PrefixedSubSequence.prefixOf("%25", BasedSequence.NULL));
/* 185 */           param1ReplacedTextMapper.addOriginalText(param1Int1 + 1, param1Int2);
/*     */           return;
/*     */         } 
/* 188 */         byte[] arrayOfByte = param1BasedSequence.toString().getBytes(StandardCharsets.UTF_8);
/* 189 */         StringBuilder stringBuilder = new StringBuilder(); int i;
/*     */         byte b;
/* 191 */         for (i = (arrayOfByte = arrayOfByte).length, b = 0; b < i; ) { byte b1 = arrayOfByte[b];
/* 192 */           stringBuilder.append('%');
/* 193 */           stringBuilder.append(Escaping.HEX_DIGITS[b1 >> 4 & 0xF]);
/* 194 */           stringBuilder.append(Escaping.HEX_DIGITS[b1 & 0xF]); b++; }
/*     */         
/* 196 */         param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int2, PrefixedSubSequence.prefixOf(stringBuilder.toString(), BasedSequence.NULL));
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 201 */   private static final Replacer URL_DECODE_REPLACER = new Replacer()
/*     */     {
/*     */       public final void replace(String param1String, StringBuilder param1StringBuilder) {
/* 204 */         param1String = Utils.urlDecode(param1String, null);
/* 205 */         param1StringBuilder.append(param1String);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public final void replace(BasedSequence param1BasedSequence, int param1Int1, int param1Int2, ReplacedTextMapper param1ReplacedTextMapper) {
/* 211 */         String str = Utils.urlDecode((param1BasedSequence = param1BasedSequence.subSequence(param1Int1, param1Int2)).toString(), null);
/* 212 */         param1ReplacedTextMapper.addReplacedText(param1Int1, param1Int2, PrefixedSubSequence.prefixOf(str, BasedSequence.NULL));
/*     */       }
/*     */     };
/*     */   
/* 216 */   public static final CharPredicate AMP_BACKSLASH_SET = CharPredicate.anyOf(new char[] { '\\', '&' });
/*     */   
/*     */   public static String escapeHtml(CharSequence paramCharSequence, boolean paramBoolean) {
/*     */     Pattern pattern;
/* 220 */     return replaceAll(pattern = paramBoolean ? XML_SPECIAL_OR_ENTITY : XML_SPECIAL_RE, paramCharSequence, UNSAFE_CHAR_REPLACER);
/*     */   }
/*     */ 
/*     */   
/*     */   public static BasedSequence escapeHtml(BasedSequence paramBasedSequence, boolean paramBoolean, ReplacedTextMapper paramReplacedTextMapper) {
/*     */     Pattern pattern;
/* 226 */     return replaceAll(pattern = paramBoolean ? XML_SPECIAL_OR_ENTITY : XML_SPECIAL_RE, paramBasedSequence, UNSAFE_CHAR_REPLACER, paramReplacedTextMapper);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String unescapeString(CharSequence paramCharSequence) {
/* 237 */     if (BACKSLASH_OR_AMP.matcher(paramCharSequence).find()) {
/* 238 */       return replaceAll(ENTITY_OR_ESCAPED_CHAR, paramCharSequence, UNESCAPE_REPLACER);
/*     */     }
/* 240 */     return String.valueOf(paramCharSequence);
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
/*     */   public static String unescapeString(CharSequence paramCharSequence, boolean paramBoolean) {
/* 253 */     if (paramBoolean) {
/* 254 */       if (BACKSLASH_OR_AMP.matcher(paramCharSequence).find()) {
/* 255 */         return replaceAll(ESCAPED_CHAR, paramCharSequence, UNESCAPE_REPLACER);
/*     */       }
/* 257 */       return String.valueOf(paramCharSequence);
/*     */     } 
/*     */     
/* 260 */     if (BACKSLASH_ONLY.matcher(paramCharSequence).find()) {
/* 261 */       return replaceAll(ENTITY_OR_ESCAPED_CHAR, paramCharSequence, UNESCAPE_REPLACER);
/*     */     }
/* 263 */     return String.valueOf(paramCharSequence);
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
/*     */   public static BasedSequence unescape(BasedSequence paramBasedSequence, ReplacedTextMapper paramReplacedTextMapper) {
/*     */     int i;
/* 278 */     if ((i = paramBasedSequence.indexOfAny(AMP_BACKSLASH_SET)) != -1) {
/* 279 */       return replaceAll(ENTITY_OR_ESCAPED_CHAR, paramBasedSequence, UNESCAPE_REPLACER, paramReplacedTextMapper);
/*     */     }
/* 281 */     return paramBasedSequence;
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
/*     */   public static BasedSequence removeAll(BasedSequence paramBasedSequence, CharSequence paramCharSequence, ReplacedTextMapper paramReplacedTextMapper) {
/*     */     int i;
/* 296 */     if ((i = paramBasedSequence.indexOf(paramCharSequence)) != -1) {
/* 297 */       return replaceAll(Pattern.compile("\\Q" + paramCharSequence + "\\E"), paramBasedSequence, REMOVE_REPLACER, paramReplacedTextMapper);
/*     */     }
/* 299 */     return paramBasedSequence;
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
/*     */   public static String unescapeHtml(CharSequence paramCharSequence) {
/* 311 */     if (AMP_ONLY.matcher(paramCharSequence).find()) {
/* 312 */       return replaceAll(ENTITY_ONLY, paramCharSequence, ENTITY_REPLACER);
/*     */     }
/* 314 */     return String.valueOf(paramCharSequence);
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
/*     */   public static BasedSequence unescapeHtml(BasedSequence paramBasedSequence, ReplacedTextMapper paramReplacedTextMapper) {
/*     */     int i;
/* 328 */     if ((i = paramBasedSequence.indexOf('&')) != -1) {
/* 329 */       return replaceAll(ENTITY_ONLY, paramBasedSequence, ENTITY_REPLACER, paramReplacedTextMapper);
/*     */     }
/* 331 */     return paramBasedSequence;
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
/*     */   public static BasedSequence unescapeHtml(BasedSequence paramBasedSequence, List<Range> paramList, ReplacedTextMapper paramReplacedTextMapper) {
/*     */     int i;
/* 345 */     if ((i = paramBasedSequence.indexOf('&')) != -1) {
/* 346 */       return replaceAll(ENTITY_ONLY, paramBasedSequence, paramList, ENTITY_REPLACER, paramReplacedTextMapper);
/*     */     }
/* 348 */     return paramBasedSequence;
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
/*     */   public static String normalizeEndWithEOL(CharSequence paramCharSequence) {
/* 362 */     return normalizeEOL(paramCharSequence, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String normalizeEOL(CharSequence paramCharSequence) {
/* 373 */     return normalizeEOL(paramCharSequence, false);
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
/*     */   public static String normalizeEOL(CharSequence paramCharSequence, boolean paramBoolean) {
/* 385 */     StringBuilder stringBuilder = new StringBuilder(paramCharSequence.length());
/* 386 */     int i = paramCharSequence.length();
/* 387 */     boolean bool1 = false;
/* 388 */     boolean bool2 = false;
/*     */     
/* 390 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/* 392 */       if ((c = paramCharSequence.charAt(b)) == '\r') {
/* 393 */         bool1 = true;
/* 394 */       } else if (c == '\n') {
/* 395 */         stringBuilder.append("\n");
/* 396 */         bool1 = false;
/* 397 */         bool2 = true;
/*     */       } else {
/* 399 */         if (bool1) stringBuilder.append('\n'); 
/* 400 */         stringBuilder.append(c);
/* 401 */         bool1 = false;
/* 402 */         bool2 = false;
/*     */       } 
/*     */     } 
/* 405 */     if (paramBoolean && !bool2) stringBuilder.append('\n'); 
/* 406 */     return stringBuilder.toString();
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
/*     */   public static BasedSequence normalizeEndWithEOL(BasedSequence paramBasedSequence, ReplacedTextMapper paramReplacedTextMapper) {
/* 420 */     return normalizeEOL(paramBasedSequence, paramReplacedTextMapper, true);
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
/*     */   public static BasedSequence normalizeEOL(BasedSequence paramBasedSequence, ReplacedTextMapper paramReplacedTextMapper) {
/* 432 */     return normalizeEOL(paramBasedSequence, paramReplacedTextMapper, false);
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
/*     */   public static BasedSequence normalizeEOL(BasedSequence paramBasedSequence, ReplacedTextMapper paramReplacedTextMapper, boolean paramBoolean) {
/* 447 */     int i = paramBasedSequence.length();
/* 448 */     byte b1 = 0;
/* 449 */     boolean bool1 = false;
/* 450 */     boolean bool2 = false;
/*     */     
/* 452 */     if (paramReplacedTextMapper.isModified()) paramReplacedTextMapper.startNestedReplacement(paramBasedSequence);
/*     */     
/* 454 */     for (byte b2 = 0; b2 < i; b2++) {
/*     */       char c;
/* 456 */       if ((c = paramBasedSequence.charAt(b2)) == '\r') {
/* 457 */         bool1 = true;
/* 458 */       } else if (c == '\n') {
/* 459 */         if (bool1)
/*     */         {
/* 461 */           if (b1 < b2 - 1) paramReplacedTextMapper.addOriginalText(b1, b2 - 1); 
/* 462 */           b1 = b2;
/* 463 */           bool1 = false;
/* 464 */           bool2 = true;
/*     */         }
/*     */       
/* 467 */       } else if (bool1) {
/* 468 */         if (b1 < b2 - 1) paramReplacedTextMapper.addOriginalText(b1, b2 + 1); 
/* 469 */         paramReplacedTextMapper.addReplacedText(b2 - 1, b2, BasedSequence.EOL);
/* 470 */         b1 = b2;
/* 471 */         bool1 = false;
/* 472 */         bool2 = false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 477 */     if (!bool1) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 482 */       if (b1 < i) paramReplacedTextMapper.addOriginalText(b1, i); 
/* 483 */       if (!bool2 && paramBoolean) paramReplacedTextMapper.addReplacedText(i - 1, i, BasedSequence.EOL);
/*     */     
/*     */     } 
/* 486 */     return paramReplacedTextMapper.getReplacedSequence();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String percentEncodeUrl(CharSequence paramCharSequence) {
/* 495 */     return replaceAll(ESCAPE_IN_URI, paramCharSequence, URL_ENCODE_REPLACER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BasedSequence percentEncodeUrl(BasedSequence paramBasedSequence, ReplacedTextMapper paramReplacedTextMapper) {
/* 505 */     return replaceAll(ESCAPE_IN_URI, paramBasedSequence, URL_ENCODE_REPLACER, paramReplacedTextMapper);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String percentDecodeUrl(CharSequence paramCharSequence) {
/* 514 */     return replaceAll(ESCAPE_URI_DECODE, paramCharSequence, URL_DECODE_REPLACER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BasedSequence percentDecodeUrl(BasedSequence paramBasedSequence, ReplacedTextMapper paramReplacedTextMapper) {
/* 524 */     return replaceAll(ESCAPE_URI_DECODE, paramBasedSequence, URL_DECODE_REPLACER, paramReplacedTextMapper);
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
/*     */   public static String normalizeReference(CharSequence paramCharSequence, boolean paramBoolean) {
/* 536 */     if (paramBoolean) return collapseWhitespace(paramCharSequence.toString(), true).toLowerCase(); 
/* 537 */     return collapseWhitespace(paramCharSequence.toString(), true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String encode(char paramChar) {
/* 542 */     switch (paramChar) {
/*     */       case '&':
/* 544 */         return "&amp;";
/*     */       case '<':
/* 546 */         return "&lt;";
/*     */       case '>':
/* 548 */         return "&gt;";
/*     */       case '"':
/* 550 */         return "&quot;";
/*     */       case '\'':
/* 552 */         return "&#39;";
/*     */     } 
/* 554 */     return null;
/*     */   }
/*     */   
/* 557 */   private static Random random = new Random(9766L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String obfuscate(String paramString, boolean paramBoolean) {
/* 568 */     if (!paramBoolean) random = new Random(0L);
/*     */     
/* 570 */     StringBuilder stringBuilder = new StringBuilder();
/* 571 */     for (byte b = 0; b < paramString.length(); b++) {
/* 572 */       String str; char c = paramString.charAt(b);
/* 573 */       switch (random.nextInt(5)) {
/*     */         case 0:
/*     */         case 1:
/* 576 */           stringBuilder.append("&#").append(c).append(';');
/*     */           break;
/*     */         case 2:
/*     */         case 3:
/* 580 */           stringBuilder.append("&#x").append(Integer.toHexString(c)).append(';');
/*     */           break;
/*     */         
/*     */         case 4:
/* 584 */           if ((str = encode(c)) != null) { stringBuilder.append(str); break; }
/* 585 */            stringBuilder.append(c); break;
/*     */       } 
/*     */     } 
/* 588 */     return stringBuilder.toString();
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
/*     */   public static String normalizeReferenceChars(CharSequence paramCharSequence, boolean paramBoolean) {
/* 603 */     if (paramCharSequence.length() > 1) {
/* 604 */       byte b = (paramCharSequence.charAt(paramCharSequence.length() - 1) == ':') ? 2 : 1;
/* 605 */       boolean bool = (paramCharSequence.charAt(0) == '!') ? true : true;
/* 606 */       return normalizeReference(paramCharSequence.subSequence(bool, paramCharSequence.length() - b), paramBoolean);
/*     */     } 
/* 608 */     return String.valueOf(paramCharSequence);
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
/*     */   public static String collapseWhitespace(CharSequence paramCharSequence, boolean paramBoolean) {
/* 620 */     StringBuilder stringBuilder = new StringBuilder(paramCharSequence.length());
/* 621 */     int i = paramCharSequence.length();
/* 622 */     boolean bool = false;
/*     */     
/* 624 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/* 626 */       if ((c = paramCharSequence.charAt(b)) == ' ' || c == '\t' || c == '\n' || c == '\r') {
/* 627 */         bool = true;
/*     */       } else {
/* 629 */         if (bool && (!paramBoolean || stringBuilder.length() > 0)) stringBuilder.append(' '); 
/* 630 */         stringBuilder.append(c);
/* 631 */         bool = false;
/*     */       } 
/*     */     } 
/* 634 */     if (bool && !paramBoolean) stringBuilder.append(' '); 
/* 635 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static BasedSequence collapseWhitespace(BasedSequence paramBasedSequence, ReplacedTextMapper paramReplacedTextMapper) {
/* 640 */     return replaceAll(COLLAPSE_WHITESPACE, paramBasedSequence, COLLAPSE_WHITESPACE_REPLACER, paramReplacedTextMapper);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String replaceAll(Pattern paramPattern, CharSequence paramCharSequence, Replacer paramReplacer) {
/*     */     Matcher matcher;
/* 647 */     if (!(matcher = paramPattern.matcher(paramCharSequence)).find()) {
/* 648 */       return String.valueOf(paramCharSequence);
/*     */     }
/*     */     
/* 651 */     StringBuilder stringBuilder = new StringBuilder(paramCharSequence.length() + 16);
/* 652 */     int i = 0;
/*     */     do {
/* 654 */       stringBuilder.append(paramCharSequence, i, matcher.start());
/* 655 */       paramReplacer.replace(matcher.group(), stringBuilder);
/* 656 */       i = matcher.end();
/* 657 */     } while (matcher.find());
/*     */     
/* 659 */     if (i != paramCharSequence.length()) {
/* 660 */       stringBuilder.append(paramCharSequence, i, paramCharSequence.length());
/*     */     }
/* 662 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static BasedSequence replaceAll(Pattern paramPattern, BasedSequence paramBasedSequence, Replacer paramReplacer, ReplacedTextMapper paramReplacedTextMapper) {
/* 667 */     return replaceAll(paramPattern, paramBasedSequence, 0, paramBasedSequence.length(), paramReplacer, paramReplacedTextMapper);
/*     */   }
/*     */ 
/*     */   
/*     */   private static BasedSequence replaceAll(Pattern paramPattern, BasedSequence paramBasedSequence, int paramInt1, int paramInt2, Replacer paramReplacer, ReplacedTextMapper paramReplacedTextMapper) {
/*     */     Matcher matcher;
/* 673 */     (matcher = paramPattern.matcher(paramBasedSequence)).region(paramInt1, paramInt2);
/* 674 */     matcher.useTransparentBounds(false);
/*     */     
/* 676 */     if (paramReplacedTextMapper.isModified()) {
/* 677 */       paramReplacedTextMapper.startNestedReplacement(paramBasedSequence);
/*     */     }
/*     */     
/* 680 */     if (!matcher.find()) {
/* 681 */       paramReplacedTextMapper.addOriginalText(0, paramBasedSequence.length());
/* 682 */       return paramBasedSequence;
/*     */     } 
/*     */     
/* 685 */     paramInt1 = 0;
/*     */     do {
/* 687 */       paramReplacedTextMapper.addOriginalText(paramInt1, matcher.start());
/* 688 */       paramReplacer.replace(paramBasedSequence, matcher.start(), matcher.end(), paramReplacedTextMapper);
/* 689 */       paramInt1 = matcher.end();
/* 690 */     } while (matcher.find());
/*     */     
/* 692 */     if (paramInt1 < paramBasedSequence.length()) {
/* 693 */       paramReplacedTextMapper.addOriginalText(paramInt1, paramBasedSequence.length());
/*     */     }
/*     */     
/* 696 */     return paramReplacedTextMapper.getReplacedSequence();
/*     */   }
/*     */ 
/*     */   
/*     */   private static BasedSequence replaceAll(Pattern paramPattern, BasedSequence paramBasedSequence, List<Range> paramList, Replacer paramReplacer, ReplacedTextMapper paramReplacedTextMapper) {
/*     */     Matcher matcher;
/* 702 */     (matcher = paramPattern.matcher(paramBasedSequence)).useTransparentBounds(false);
/*     */     
/* 704 */     if (paramReplacedTextMapper.isModified()) {
/* 705 */       paramReplacedTextMapper.startNestedReplacement(paramBasedSequence);
/*     */     }
/*     */     
/* 708 */     int i = 0;
/*     */     
/* 710 */     for (Iterator<Range> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 711 */       Range range; int k = Utils.rangeLimit((range = iterator.next()).getStart(), i, paramBasedSequence.length());
/* 712 */       int j = Utils.rangeLimit(range.getEnd(), k, paramBasedSequence.length());
/* 713 */       matcher.region(k, j);
/*     */       
/* 715 */       while (matcher.find()) {
/* 716 */         paramReplacedTextMapper.addOriginalText(i, matcher.start());
/* 717 */         paramReplacer.replace(paramBasedSequence, matcher.start(), matcher.end(), paramReplacedTextMapper);
/* 718 */         i = matcher.end();
/*     */       } 
/*     */     } 
/*     */     
/* 722 */     if (i < paramBasedSequence.length()) {
/* 723 */       paramReplacedTextMapper.addOriginalText(i, paramBasedSequence.length());
/*     */     }
/*     */     
/* 726 */     return paramReplacedTextMapper.getReplacedSequence();
/*     */   }
/*     */   
/*     */   static interface Replacer {
/*     */     void replace(String param1String, StringBuilder param1StringBuilder);
/*     */     
/*     */     void replace(BasedSequence param1BasedSequence, int param1Int1, int param1Int2, ReplacedTextMapper param1ReplacedTextMapper);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\Escaping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */