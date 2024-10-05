/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.function.Consumer;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.Normalizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Tag
/*     */   implements Cloneable
/*     */ {
/*  16 */   private static final Map<String, Tag> Tags = new HashMap<>();
/*     */   
/*     */   private String tagName;
/*     */   private final String normalName;
/*     */   private String namespace;
/*     */   private boolean isBlock = true;
/*     */   private boolean formatAsBlock = true;
/*     */   private boolean empty = false;
/*     */   private boolean selfClosing = false;
/*     */   private boolean preserveWhitespace = false;
/*     */   private boolean formList = false;
/*     */   private boolean formSubmit = false;
/*     */   
/*     */   private Tag(String paramString1, String paramString2) {
/*  30 */     this.tagName = paramString1;
/*  31 */     this.normalName = Normalizer.lowerCase(paramString1);
/*  32 */     this.namespace = paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  41 */     return this.tagName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String normalName() {
/*  49 */     return this.normalName;
/*     */   }
/*     */   
/*     */   public String namespace() {
/*  53 */     return this.namespace;
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
/*     */   public static Tag valueOf(String paramString1, String paramString2, ParseSettings paramParseSettings) {
/*  68 */     Validate.notEmpty(paramString1);
/*  69 */     Validate.notNull(paramString2);
/*     */     Tag tag;
/*  71 */     if ((tag = Tags.get(paramString1)) != null && tag.namespace.equals(paramString2)) {
/*  72 */       return tag;
/*     */     }
/*     */     
/*  75 */     Validate.notEmpty(paramString1 = paramParseSettings.normalizeTag(paramString1));
/*  76 */     String str = Normalizer.lowerCase(paramString1);
/*     */     
/*  78 */     if ((tag = Tags.get(str)) != null && tag.namespace.equals(paramString2)) {
/*  79 */       if (paramParseSettings.preserveTagCase() && !paramString1.equals(str))
/*     */       {
/*  81 */         (tag = tag.clone()).tagName = paramString1;
/*     */       }
/*  83 */       return tag;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  88 */     (tag = new Tag(paramString1, paramString2)).isBlock = false;
/*     */     
/*  90 */     return tag;
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
/*     */   public static Tag valueOf(String paramString) {
/* 104 */     return valueOf(paramString, "http://www.w3.org/1999/xhtml", ParseSettings.preserveCase);
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
/*     */   public static Tag valueOf(String paramString, ParseSettings paramParseSettings) {
/* 119 */     return valueOf(paramString, "http://www.w3.org/1999/xhtml", paramParseSettings);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBlock() {
/* 128 */     return this.isBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean formatAsBlock() {
/* 137 */     return this.formatAsBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInline() {
/* 146 */     return !this.isBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 155 */     return this.empty;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSelfClosing() {
/* 164 */     return (this.empty || this.selfClosing);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isKnownTag() {
/* 173 */     return Tags.containsKey(this.tagName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isKnownTag(String paramString) {
/* 183 */     return Tags.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean preserveWhitespace() {
/* 192 */     return this.preserveWhitespace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFormListed() {
/* 200 */     return this.formList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFormSubmittable() {
/* 208 */     return this.formSubmit;
/*     */   }
/*     */   
/*     */   Tag setSelfClosing() {
/* 212 */     this.selfClosing = true;
/* 213 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 218 */     if (this == paramObject) return true; 
/* 219 */     if (!(paramObject instanceof Tag)) return false;
/*     */     
/* 221 */     paramObject = paramObject;
/*     */     
/* 223 */     if (!this.tagName.equals(((Tag)paramObject).tagName)) return false; 
/* 224 */     if (this.empty != ((Tag)paramObject).empty) return false; 
/* 225 */     if (this.formatAsBlock != ((Tag)paramObject).formatAsBlock) return false; 
/* 226 */     if (this.isBlock != ((Tag)paramObject).isBlock) return false; 
/* 227 */     if (this.preserveWhitespace != ((Tag)paramObject).preserveWhitespace) return false; 
/* 228 */     if (this.selfClosing != ((Tag)paramObject).selfClosing) return false; 
/* 229 */     if (this.formList != ((Tag)paramObject).formList) return false; 
/* 230 */     return (this.formSubmit == ((Tag)paramObject).formSubmit);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 235 */     int i = this.tagName.hashCode();
/* 236 */     i = i * 31 + (this.isBlock ? 1 : 0);
/* 237 */     i = i * 31 + (this.formatAsBlock ? 1 : 0);
/* 238 */     i = i * 31 + (this.empty ? 1 : 0);
/* 239 */     i = i * 31 + (this.selfClosing ? 1 : 0);
/* 240 */     i = i * 31 + (this.preserveWhitespace ? 1 : 0);
/* 241 */     i = i * 31 + (this.formList ? 1 : 0);
/*     */     
/* 243 */     return i = i * 31 + (this.formSubmit ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 248 */     return this.tagName;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Tag clone() {
/*     */     try {
/* 254 */       return (Tag)super.clone();
/* 255 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 256 */       throw new RuntimeException(cloneNotSupportedException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 262 */   private static final String[] blockTags = new String[] { "html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math", "center", "template", "dir", "applet", "marquee", "listing" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 271 */   private static final String[] inlineTags = new String[] { "object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "rtc", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s", "strike", "nobr", "rb", "text", "mi", "mo", "msup", "mn", "mtext" };
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
/* 282 */   private static final String[] emptyTags = new String[] { "meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 287 */   private static final String[] formatAsInlineTags = new String[] { "title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s" };
/*     */ 
/*     */ 
/*     */   
/* 291 */   private static final String[] preserveWhitespaceTags = new String[] { "pre", "plaintext", "title", "textarea" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 296 */   private static final String[] formListedTags = new String[] { "button", "fieldset", "input", "keygen", "object", "output", "select", "textarea" };
/*     */ 
/*     */   
/* 299 */   private static final String[] formSubmitTags = new String[] { "input", "keygen", "object", "select", "textarea" };
/*     */   
/*     */   private static final Map<String, String[]> namespaces;
/*     */ 
/*     */   
/*     */   static {
/* 305 */     (namespaces = (Map)new HashMap<>()).put("http://www.w3.org/1998/Math/MathML", new String[] { "math", "mi", "mo", "msup", "mn", "mtext" });
/* 306 */     namespaces.put("http://www.w3.org/2000/svg", new String[] { "svg", "text" });
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
/* 322 */     setupTags(blockTags, paramTag -> {
/*     */           paramTag.isBlock = true;
/*     */           
/*     */           paramTag.formatAsBlock = true;
/*     */         });
/* 327 */     setupTags(inlineTags, paramTag -> {
/*     */           paramTag.isBlock = false;
/*     */           
/*     */           paramTag.formatAsBlock = false;
/*     */         });
/* 332 */     setupTags(emptyTags, paramTag -> paramTag.empty = true);
/* 333 */     setupTags(formatAsInlineTags, paramTag -> paramTag.formatAsBlock = false);
/* 334 */     setupTags(preserveWhitespaceTags, paramTag -> paramTag.preserveWhitespace = true);
/* 335 */     setupTags(formListedTags, paramTag -> paramTag.formList = true);
/* 336 */     setupTags(formSubmitTags, paramTag -> paramTag.formSubmit = true);
/* 337 */     for (Iterator<Map.Entry> iterator = namespaces.entrySet().iterator(); iterator.hasNext();)
/* 338 */       setupTags((entry = iterator.next()).getValue(), paramTag -> paramTag.namespace = (String)paramEntry.getKey()); 
/*     */   }
/*     */   
/*     */   private static void setupTags(String[] paramArrayOfString, Consumer<Tag> paramConsumer) {
/*     */     int i;
/*     */     byte b;
/*     */     for (i = (paramArrayOfString = paramArrayOfString).length, b = 0; b < i; ) {
/*     */       String str = paramArrayOfString[b];
/*     */       Tag tag;
/*     */       if ((tag = Tags.get(str)) == null) {
/*     */         tag = new Tag(str, "http://www.w3.org/1999/xhtml");
/*     */         Tags.put(tag.tagName, tag);
/*     */       } 
/*     */       paramConsumer.accept(tag);
/*     */       b++;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\Tag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */