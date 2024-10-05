/*     */ package org.jsoup.safety;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.Normalizer;
/*     */ import org.jsoup.nodes.Attribute;
/*     */ import org.jsoup.nodes.Attributes;
/*     */ import org.jsoup.nodes.Element;
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
/*     */ public class Safelist
/*     */ {
/*     */   private static final String All = ":all";
/*     */   private final Set<TagName> tagNames;
/*     */   private final Map<TagName, Set<AttributeKey>> attributes;
/*     */   private final Map<TagName, Map<AttributeKey, AttributeValue>> enforcedAttributes;
/*     */   private final Map<TagName, Map<AttributeKey, Set<Protocol>>> protocols;
/*     */   private boolean preserveRelativeLinks;
/*     */   
/*     */   public static Safelist none() {
/*  96 */     return new Safelist();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Safelist simpleText() {
/* 106 */     return (new Safelist())
/* 107 */       .addTags(new String[] { "b", "em", "i", "strong", "u" });
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
/*     */   public static Safelist basic() {
/* 127 */     return (new Safelist())
/* 128 */       .addTags(new String[] { 
/*     */           "a", "b", "blockquote", "br", "cite", "code", "dd", "dl", "dt", "em",
/*     */           
/*     */           "i", "li", "ol", "p", "pre", "q", "small", "span", "strike", "strong", 
/*     */           "sub", "sup", "u", "ul"
/* 133 */         }).addAttributes("a", new String[] { "href"
/* 134 */         }).addAttributes("blockquote", new String[] { "cite"
/* 135 */         }).addAttributes("q", new String[] { "cite"
/*     */         
/* 137 */         }).addProtocols("a", "href", new String[] { "ftp", "http", "https", "mailto"
/* 138 */         }).addProtocols("blockquote", "cite", new String[] { "http", "https"
/* 139 */         }).addProtocols("cite", "cite", new String[] { "http", "https"
/*     */         
/* 141 */         }).addEnforcedAttribute("a", "rel", "nofollow");
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
/*     */   public static Safelist basicWithImages() {
/* 153 */     return basic()
/* 154 */       .addTags(new String[] { "img"
/* 155 */         }).addAttributes("img", new String[] { "align", "alt", "height", "src", "title", "width"
/* 156 */         }).addProtocols("img", "src", new String[] { "http", "https" });
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
/*     */   public static Safelist relaxed() {
/* 171 */     return (new Safelist())
/* 172 */       .addTags(new String[] { 
/*     */           "a", "b", "blockquote", "br", "caption", "cite", "code", "col", "colgroup", "dd",
/*     */           
/*     */           "div", "dl", "dt", "em", "h1", "h2", "h3", "h4", "h5", "h6", 
/*     */           "i", "img", "li", "ol", "p", "pre", "q", "small", "span", "strike", 
/*     */           "strong", "sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", 
/*     */           "u", "ul"
/* 179 */         }).addAttributes("a", new String[] { "href", "title"
/* 180 */         }).addAttributes("blockquote", new String[] { "cite"
/* 181 */         }).addAttributes("col", new String[] { "span", "width"
/* 182 */         }).addAttributes("colgroup", new String[] { "span", "width"
/* 183 */         }).addAttributes("img", new String[] { "align", "alt", "height", "src", "title", "width"
/* 184 */         }).addAttributes("ol", new String[] { "start", "type"
/* 185 */         }).addAttributes("q", new String[] { "cite"
/* 186 */         }).addAttributes("table", new String[] { "summary", "width"
/* 187 */         }).addAttributes("td", new String[] { "abbr", "axis", "colspan", "rowspan", "width"
/* 188 */         }).addAttributes("th", new String[] {
/*     */           
/*     */           "abbr", "axis", "colspan", "rowspan", "scope", "width"
/* 191 */         }).addAttributes("ul", new String[] { "type"
/*     */         
/* 193 */         }).addProtocols("a", "href", new String[] { "ftp", "http", "https", "mailto"
/* 194 */         }).addProtocols("blockquote", "cite", new String[] { "http", "https"
/* 195 */         }).addProtocols("cite", "cite", new String[] { "http", "https"
/* 196 */         }).addProtocols("img", "src", new String[] { "http", "https"
/* 197 */         }).addProtocols("q", "cite", new String[] { "http", "https" });
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
/*     */   public Safelist() {
/* 210 */     this.tagNames = new HashSet<>();
/* 211 */     this.attributes = new HashMap<>();
/* 212 */     this.enforcedAttributes = new HashMap<>();
/* 213 */     this.protocols = new HashMap<>();
/* 214 */     this.preserveRelativeLinks = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Safelist(Safelist paramSafelist) {
/* 222 */     this();
/* 223 */     this.tagNames.addAll(paramSafelist.tagNames);
/* 224 */     for (Map.Entry<TagName, Set<AttributeKey>> entry : paramSafelist.attributes.entrySet()) {
/* 225 */       this.attributes.put((TagName)entry.getKey(), new HashSet<>((Collection<? extends AttributeKey>)entry.getValue()));
/*     */     }
/* 227 */     for (Map.Entry<TagName, Map<AttributeKey, AttributeValue>> entry : paramSafelist.enforcedAttributes.entrySet()) {
/* 228 */       this.enforcedAttributes.put((TagName)entry.getKey(), new HashMap<>((Map<? extends AttributeKey, ? extends AttributeValue>)entry.getValue()));
/*     */     }
/* 230 */     for (Map.Entry<TagName, Map<AttributeKey, Set<Protocol>>> entry : paramSafelist.protocols.entrySet()) {
/* 231 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 232 */       for (Map.Entry entry1 : ((Map)entry.getValue()).entrySet()) {
/* 233 */         hashMap.put(entry1.getKey(), new HashSet((Collection)entry1.getValue()));
/*     */       }
/* 235 */       this.protocols.put((TagName)entry.getKey(), hashMap);
/*     */     } 
/* 237 */     this.preserveRelativeLinks = paramSafelist.preserveRelativeLinks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Safelist addTags(String... paramVarArgs) {
/* 247 */     Validate.notNull(paramVarArgs); int i;
/*     */     byte b;
/* 249 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 250 */       String str; Validate.notEmpty(str = paramVarArgs[b]);
/* 251 */       Validate.isFalse(str.equalsIgnoreCase("noscript"), "noscript is unsupported in Safelists, due to incompatibilities between parsers with and without script-mode enabled");
/*     */       
/* 253 */       this.tagNames.add(TagName.valueOf(str));
/*     */     } 
/* 255 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Safelist removeTags(String... paramVarArgs) {
/* 265 */     Validate.notNull(paramVarArgs); int i;
/*     */     byte b;
/* 267 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 268 */       String str; Validate.notEmpty(str = paramVarArgs[b]);
/* 269 */       TagName tagName = TagName.valueOf(str);
/*     */       
/* 271 */       if (this.tagNames.remove(tagName)) {
/* 272 */         this.attributes.remove(tagName);
/* 273 */         this.enforcedAttributes.remove(tagName);
/* 274 */         this.protocols.remove(tagName);
/*     */       } 
/*     */     } 
/* 277 */     return this;
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
/*     */   public Safelist addAttributes(String paramString, String... paramVarArgs) {
/* 296 */     Validate.notEmpty(paramString);
/* 297 */     Validate.notNull(paramVarArgs);
/* 298 */     Validate.isTrue((paramVarArgs.length > 0), "No attribute names supplied.");
/*     */     
/* 300 */     addTags(new String[] { paramString });
/* 301 */     TagName tagName = TagName.valueOf(paramString);
/* 302 */     HashSet<AttributeKey> hashSet = new HashSet(); int i; byte b;
/* 303 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 304 */       String str; Validate.notEmpty(str = paramVarArgs[b]);
/* 305 */       hashSet.add(AttributeKey.valueOf(str));
/*     */     } 
/* 307 */     if (this.attributes.containsKey(tagName)) {
/*     */       Set<AttributeKey> set;
/* 309 */       (set = this.attributes.get(tagName)).addAll(hashSet);
/*     */     } else {
/* 311 */       this.attributes.put(tagName, hashSet);
/*     */     } 
/* 313 */     return this;
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
/*     */   public Safelist removeAttributes(String paramString, String... paramVarArgs) {
/* 332 */     Validate.notEmpty(paramString);
/* 333 */     Validate.notNull(paramVarArgs);
/* 334 */     Validate.isTrue((paramVarArgs.length > 0), "No attribute names supplied.");
/*     */     
/* 336 */     TagName tagName = TagName.valueOf(paramString);
/* 337 */     HashSet<AttributeKey> hashSet = new HashSet(); int i; byte b;
/* 338 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 339 */       String str; Validate.notEmpty(str = paramVarArgs[b]);
/* 340 */       hashSet.add(AttributeKey.valueOf(str));
/*     */     } 
/* 342 */     if (this.tagNames.contains(tagName) && this.attributes.containsKey(tagName)) {
/*     */       Set<?> set;
/* 344 */       (set = this.attributes.get(tagName)).removeAll(hashSet);
/*     */       
/* 346 */       if (set.isEmpty())
/* 347 */         this.attributes.remove(tagName); 
/*     */     } 
/* 349 */     if (paramString.equals(":all")) {
/* 350 */       Iterator<Map.Entry> iterator = this.attributes.entrySet().iterator();
/* 351 */       while (iterator.hasNext()) {
/*     */         Map.Entry<?, Set> entry;
/*     */         Set<?> set;
/* 354 */         (set = (entry = iterator.next()).getValue()).removeAll(hashSet);
/* 355 */         if (set.isEmpty())
/* 356 */           iterator.remove(); 
/*     */       } 
/*     */     } 
/* 359 */     return this;
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
/*     */   public Safelist addEnforcedAttribute(String paramString1, String paramString2, String paramString3) {
/* 376 */     Validate.notEmpty(paramString1);
/* 377 */     Validate.notEmpty(paramString2);
/* 378 */     Validate.notEmpty(paramString3);
/*     */     
/* 380 */     TagName tagName = TagName.valueOf(paramString1);
/* 381 */     this.tagNames.add(tagName);
/* 382 */     AttributeKey attributeKey = AttributeKey.valueOf(paramString2);
/* 383 */     AttributeValue attributeValue = AttributeValue.valueOf(paramString3);
/*     */     
/* 385 */     if (this.enforcedAttributes.containsKey(tagName)) {
/* 386 */       ((Map<AttributeKey, AttributeValue>)this.enforcedAttributes.get(tagName)).put(attributeKey, attributeValue);
/*     */     } else {
/*     */       HashMap<Object, Object> hashMap;
/* 389 */       (hashMap = new HashMap<>()).put(attributeKey, attributeValue);
/* 390 */       this.enforcedAttributes.put(tagName, hashMap);
/*     */     } 
/* 392 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Safelist removeEnforcedAttribute(String paramString1, String paramString2) {
/* 403 */     Validate.notEmpty(paramString1);
/* 404 */     Validate.notEmpty(paramString2);
/*     */     
/* 406 */     TagName tagName = TagName.valueOf(paramString1);
/* 407 */     if (this.tagNames.contains(tagName) && this.enforcedAttributes.containsKey(tagName)) {
/* 408 */       AttributeKey attributeKey = AttributeKey.valueOf(paramString2);
/*     */       Map<?, ?> map;
/* 410 */       (map = this.enforcedAttributes.get(tagName)).remove(attributeKey);
/*     */       
/* 412 */       if (map.isEmpty())
/* 413 */         this.enforcedAttributes.remove(tagName); 
/*     */     } 
/* 415 */     return this;
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
/*     */   public Safelist preserveRelativeLinks(boolean paramBoolean) {
/* 434 */     this.preserveRelativeLinks = paramBoolean;
/* 435 */     return this;
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
/*     */   public Safelist addProtocols(String paramString1, String paramString2, String... paramVarArgs) {
/*     */     Set<Protocol> set;
/*     */     Map<AttributeKey, HashSet> map;
/* 455 */     Validate.notEmpty(paramString1);
/* 456 */     Validate.notEmpty(paramString2);
/* 457 */     Validate.notNull(paramVarArgs);
/*     */     
/* 459 */     TagName tagName = TagName.valueOf(paramString1);
/* 460 */     AttributeKey attributeKey = AttributeKey.valueOf(paramString2);
/*     */ 
/*     */ 
/*     */     
/* 464 */     if (this.protocols.containsKey(tagName)) {
/* 465 */       map = (Map)this.protocols.get(tagName);
/*     */     } else {
/* 467 */       map = (Map)new HashMap<>();
/* 468 */       this.protocols.put(tagName, map);
/*     */     } 
/* 470 */     if (map.containsKey(attributeKey)) {
/* 471 */       set = (Set)map.get(attributeKey);
/*     */     } else {
/* 473 */       set = new HashSet();
/* 474 */       map.put(attributeKey, (HashSet)set);
/*     */     }  String[] arrayOfString; int i; byte b;
/* 476 */     for (i = (arrayOfString = paramVarArgs).length, b = 0; b < i; b++) {
/* 477 */       String str; Validate.notEmpty(str = arrayOfString[b]);
/* 478 */       Protocol protocol = Protocol.valueOf(str);
/* 479 */       set.add(protocol);
/*     */     } 
/* 481 */     return this;
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
/*     */   public Safelist removeProtocols(String paramString1, String paramString2, String... paramVarArgs) {
/* 497 */     Validate.notEmpty(paramString1);
/* 498 */     Validate.notEmpty(paramString2);
/* 499 */     Validate.notNull(paramVarArgs);
/*     */     
/* 501 */     TagName tagName = TagName.valueOf(paramString1);
/* 502 */     AttributeKey attributeKey = AttributeKey.valueOf(paramString2);
/*     */ 
/*     */ 
/*     */     
/* 506 */     Validate.isTrue(this.protocols.containsKey(tagName), "Cannot remove a protocol that is not set.");
/*     */     Map<?, ?> map;
/* 508 */     Validate.isTrue((map = this.protocols.get(tagName)).containsKey(attributeKey), "Cannot remove a protocol that is not set.");
/*     */     
/* 510 */     Set set = (Set)map.get(attributeKey); int i; byte b;
/* 511 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 512 */       String str; Validate.notEmpty(str = paramVarArgs[b]);
/* 513 */       set.remove(Protocol.valueOf(str));
/*     */     } 
/*     */     
/* 516 */     if (set.isEmpty()) {
/* 517 */       map.remove(attributeKey);
/* 518 */       if (map.isEmpty())
/* 519 */         this.protocols.remove(tagName); 
/*     */     } 
/* 521 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSafeTag(String paramString) {
/* 530 */     return this.tagNames.contains(TagName.valueOf(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSafeAttribute(String paramString, Element paramElement, Attribute paramAttribute) {
/* 541 */     TagName tagName = TagName.valueOf(paramString);
/* 542 */     AttributeKey attributeKey = AttributeKey.valueOf(paramAttribute.getKey());
/*     */     
/*     */     Set set;
/* 545 */     if ((set = this.attributes.get(tagName)) != null && set.contains(attributeKey)) {
/* 546 */       if (this.protocols.containsKey(tagName)) {
/*     */ 
/*     */         
/* 549 */         if (!(map = this.protocols.get(tagName)).containsKey(attributeKey) || testValidProtocol(paramElement, paramAttribute, (Set<Protocol>)map.get(attributeKey))) return true;  return false;
/*     */       } 
/* 551 */       return true;
/*     */     } 
/*     */     
/*     */     Map<?, ?> map;
/*     */     
/* 556 */     if ((map = this.enforcedAttributes.get(map)) != null) {
/* 557 */       Attributes attributes = getEnforcedAttributes(paramString);
/* 558 */       String str = paramAttribute.getKey();
/* 559 */       if (attributes.hasKeyIgnoreCase(str)) {
/* 560 */         return attributes.getIgnoreCase(str).equals(paramAttribute.getValue());
/*     */       }
/*     */     } 
/*     */     
/* 564 */     return (!paramString.equals(":all") && isSafeAttribute(":all", paramElement, paramAttribute));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean testValidProtocol(Element paramElement, Attribute paramAttribute, Set<Protocol> paramSet) {
/*     */     String str;
/* 571 */     if ((str = paramElement.absUrl(paramAttribute.getKey())).length() == 0)
/* 572 */       str = paramAttribute.getValue(); 
/* 573 */     if (!this.preserveRelativeLinks) {
/* 574 */       paramAttribute.setValue(str);
/*     */     }
/* 576 */     for (Iterator<Protocol> iterator = paramSet.iterator(); iterator.hasNext(); ) {
/*     */       String str1;
/*     */       Protocol protocol;
/* 579 */       if ((str1 = (protocol = iterator.next()).toString()).equals("#")) {
/* 580 */         if (isValidAnchor(str)) {
/* 581 */           return true;
/*     */         }
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 587 */       str1 = str1 + ":";
/*     */       
/* 589 */       if (Normalizer.lowerCase(str).startsWith(str1)) {
/* 590 */         return true;
/*     */       }
/*     */     } 
/* 593 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isValidAnchor(String paramString) {
/* 597 */     return (paramString.startsWith("#") && !paramString.matches(".*\\s.*"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes getEnforcedAttributes(String paramString) {
/* 606 */     Attributes attributes = new Attributes();
/* 607 */     TagName tagName = TagName.valueOf(paramString);
/* 608 */     if (this.enforcedAttributes.containsKey(tagName)) {
/*     */       Map<?, ?> map;
/* 610 */       for (Map.Entry<?, ?> entry : (map = this.enforcedAttributes.get(tagName)).entrySet()) {
/* 611 */         attributes.put(((AttributeKey)entry.getKey()).toString(), ((AttributeValue)entry.getValue()).toString());
/*     */       }
/*     */     } 
/* 614 */     return attributes;
/*     */   }
/*     */   
/*     */   static class TagName
/*     */     extends TypedValue
/*     */   {
/*     */     TagName(String param1String) {
/* 621 */       super(param1String);
/*     */     }
/*     */     
/*     */     static TagName valueOf(String param1String) {
/* 625 */       return new TagName(Normalizer.lowerCase(param1String));
/*     */     }
/*     */   }
/*     */   
/*     */   static class AttributeKey extends TypedValue {
/*     */     AttributeKey(String param1String) {
/* 631 */       super(param1String);
/*     */     }
/*     */     
/*     */     static AttributeKey valueOf(String param1String) {
/* 635 */       return new AttributeKey(Normalizer.lowerCase(param1String));
/*     */     }
/*     */   }
/*     */   
/*     */   static class AttributeValue extends TypedValue {
/*     */     AttributeValue(String param1String) {
/* 641 */       super(param1String);
/*     */     }
/*     */     
/*     */     static AttributeValue valueOf(String param1String) {
/* 645 */       return new AttributeValue(param1String);
/*     */     }
/*     */   }
/*     */   
/*     */   static class Protocol extends TypedValue {
/*     */     Protocol(String param1String) {
/* 651 */       super(param1String);
/*     */     }
/*     */     
/*     */     static Protocol valueOf(String param1String) {
/* 655 */       return new Protocol(param1String);
/*     */     }
/*     */   }
/*     */   
/*     */   static abstract class TypedValue {
/*     */     private final String value;
/*     */     
/*     */     TypedValue(String param1String) {
/* 663 */       Validate.notNull(param1String);
/* 664 */       this.value = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       int i;
/* 672 */       return i = 31 + ((this.value == null) ? 0 : this.value.hashCode());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 677 */       if (this == param1Object) return true; 
/* 678 */       if (param1Object == null) return false; 
/* 679 */       if (getClass() != param1Object.getClass()) return false; 
/* 680 */       param1Object = param1Object;
/* 681 */       if (this.value == null)
/* 682 */         return (((TypedValue)param1Object).value == null); 
/* 683 */       return this.value.equals(((TypedValue)param1Object).value);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 688 */       return this.value;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\safety\Safelist.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */