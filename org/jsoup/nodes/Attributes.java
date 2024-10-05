/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.ConcurrentModificationException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import org.jsoup.SerializationException;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.Normalizer;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.parser.ParseSettings;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Attributes
/*     */   implements Cloneable, Iterable<Attribute>
/*     */ {
/*     */   static final char InternalPrefix = '/';
/*     */   protected static final String dataPrefix = "data-";
/*     */   private static final int InitialCapacity = 3;
/*     */   private static final int GrowthFactor = 2;
/*     */   static final int NotFound = -1;
/*     */   private static final String EmptyString = "";
/*  59 */   private int size = 0;
/*  60 */   String[] keys = new String[3];
/*  61 */   Object[] vals = new Object[3];
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkCapacity(int paramInt) {
/*  66 */     Validate.isTrue((paramInt >= this.size));
/*     */     int i;
/*  68 */     if ((i = this.keys.length) >= paramInt)
/*     */       return; 
/*  70 */     i = (i >= 3) ? (this.size << 1) : 3;
/*  71 */     if (paramInt > i) {
/*  72 */       i = paramInt;
/*     */     }
/*  74 */     this.keys = Arrays.<String>copyOf(this.keys, i);
/*  75 */     this.vals = Arrays.copyOf(this.vals, i);
/*     */   }
/*     */   
/*     */   int indexOfKey(String paramString) {
/*  79 */     Validate.notNull(paramString);
/*  80 */     for (byte b = 0; b < this.size; b++) {
/*  81 */       if (paramString.equals(this.keys[b]))
/*  82 */         return b; 
/*     */     } 
/*  84 */     return -1;
/*     */   }
/*     */   
/*     */   private int indexOfKeyIgnoreCase(String paramString) {
/*  88 */     Validate.notNull(paramString);
/*  89 */     for (byte b = 0; b < this.size; b++) {
/*  90 */       if (paramString.equalsIgnoreCase(this.keys[b]))
/*  91 */         return b; 
/*     */     } 
/*  93 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static String checkNotNull(Object paramObject) {
/*  99 */     return (paramObject == null) ? "" : (String)paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(String paramString) {
/*     */     int i;
/* 110 */     return ((i = indexOfKey(paramString)) == -1) ? "" : checkNotNull(this.vals[i]);
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
/*     */   public Attribute attribute(String paramString) {
/*     */     int i;
/* 123 */     return ((i = indexOfKey(paramString)) == -1) ? null : new Attribute(paramString, checkNotNull(this.vals[i]), this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIgnoreCase(String paramString) {
/*     */     int i;
/* 133 */     return ((i = indexOfKeyIgnoreCase(paramString)) == -1) ? "" : checkNotNull(this.vals[i]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes add(String paramString1, String paramString2) {
/* 141 */     addObject(paramString1, paramString2);
/* 142 */     return this;
/*     */   }
/*     */   
/*     */   private void addObject(String paramString, Object paramObject) {
/* 146 */     checkCapacity(this.size + 1);
/* 147 */     this.keys[this.size] = paramString;
/* 148 */     this.vals[this.size] = paramObject;
/* 149 */     this.size++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes put(String paramString1, String paramString2) {
/* 159 */     Validate.notNull(paramString1);
/*     */     int i;
/* 161 */     if ((i = indexOfKey(paramString1)) != -1) {
/* 162 */       this.vals[i] = paramString2;
/*     */     } else {
/* 164 */       add(paramString1, paramString2);
/* 165 */     }  return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Map<String, Object> userData() {
/*     */     Map<String, Object> map;
/*     */     int i;
/* 177 */     if ((i = indexOfKey("/jsoup.userdata")) == -1) {
/* 178 */       map = (Map)new HashMap<>();
/* 179 */       addObject("/jsoup.userdata", map);
/*     */     } else {
/*     */       
/* 182 */       map = (Map)this.vals[map];
/*     */     } 
/* 184 */     return map;
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
/*     */   public Object userData(String paramString) {
/* 196 */     Validate.notNull(paramString);
/* 197 */     if (!hasKey("/jsoup.userdata")) return null; 
/*     */     Map<String, Object> map;
/* 199 */     return (map = userData()).get(paramString);
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
/*     */   public Attributes userData(String paramString, Object paramObject) {
/* 211 */     Validate.notNull(paramString);
/* 212 */     userData().put(paramString, paramObject);
/* 213 */     return this;
/*     */   }
/*     */   
/*     */   void putIgnoreCase(String paramString1, String paramString2) {
/*     */     int i;
/* 218 */     if ((i = indexOfKeyIgnoreCase(paramString1)) != -1) {
/* 219 */       this.vals[i] = paramString2;
/* 220 */       if (!this.keys[i].equals(paramString1)) {
/* 221 */         this.keys[i] = paramString1; return;
/*     */       } 
/*     */     } else {
/* 224 */       add(paramString1, paramString2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes put(String paramString, boolean paramBoolean) {
/* 234 */     if (paramBoolean) {
/* 235 */       putIgnoreCase(paramString, null);
/*     */     } else {
/* 237 */       remove(paramString);
/* 238 */     }  return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes put(Attribute paramAttribute) {
/* 247 */     Validate.notNull(paramAttribute);
/* 248 */     put(paramAttribute.getKey(), paramAttribute.getValue());
/* 249 */     paramAttribute.parent = this;
/* 250 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void remove(int paramInt) {
/* 256 */     Validate.isFalse((paramInt >= this.size));
/*     */     int i;
/* 258 */     if ((i = this.size - paramInt - 1) > 0) {
/* 259 */       System.arraycopy(this.keys, paramInt + 1, this.keys, paramInt, i);
/* 260 */       System.arraycopy(this.vals, paramInt + 1, this.vals, paramInt, i);
/*     */     } 
/* 262 */     this.size--;
/* 263 */     this.keys[this.size] = null;
/* 264 */     this.vals[this.size] = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(String paramString) {
/*     */     int i;
/* 273 */     if ((i = indexOfKey(paramString)) != -1) {
/* 274 */       remove(i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeIgnoreCase(String paramString) {
/*     */     int i;
/* 283 */     if ((i = indexOfKeyIgnoreCase(paramString)) != -1) {
/* 284 */       remove(i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasKey(String paramString) {
/* 293 */     return (indexOfKey(paramString) != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasKeyIgnoreCase(String paramString) {
/* 302 */     return (indexOfKeyIgnoreCase(paramString) != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasDeclaredValueForKey(String paramString) {
/*     */     int i;
/* 312 */     if ((i = indexOfKey(paramString)) != -1 && this.vals[i] != null) return true;  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasDeclaredValueForKeyIgnoreCase(String paramString) {
/*     */     int i;
/* 322 */     if ((i = indexOfKeyIgnoreCase(paramString)) != -1 && this.vals[i] != null) return true;  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 331 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 339 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAll(Attributes paramAttributes) {
/* 347 */     if (paramAttributes.size() == 0)
/*     */       return; 
/* 349 */     checkCapacity(this.size + paramAttributes.size);
/*     */     
/* 351 */     boolean bool = (this.size != 0) ? true : false;
/*     */     
/* 353 */     for (Attribute attribute : paramAttributes) {
/* 354 */       if (bool) {
/* 355 */         put(attribute); continue;
/*     */       } 
/* 357 */       add(attribute.getKey(), attribute.getValue());
/*     */     } 
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
/*     */   public Range.AttributeRange sourceRange(String paramString) {
/* 375 */     if (!hasKey(paramString)) return Range.AttributeRange.UntrackedAttr; 
/*     */     Map<String, Range.AttributeRange> map;
/* 377 */     if ((map = getRanges()) == null) return Range.AttributeRange.UntrackedAttr; 
/*     */     Range.AttributeRange attributeRange;
/* 379 */     return ((attributeRange = map.get(paramString)) != null) ? attributeRange : Range.AttributeRange.UntrackedAttr;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Map<String, Range.AttributeRange> getRanges() {
/* 385 */     return (Map<String, Range.AttributeRange>)userData("jsoup.attrs");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Attribute> iterator() {
/* 391 */     return new Iterator<Attribute>() {
/* 392 */         int expectedSize = Attributes.this.size;
/* 393 */         int i = 0;
/*     */ 
/*     */         
/*     */         public boolean hasNext() {
/* 397 */           checkModified();
/* 398 */           while (this.i < Attributes.this.size && 
/* 399 */             Attributes.isInternalKey(Attributes.this.keys[this.i])) {
/* 400 */             this.i++;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 405 */           return (this.i < Attributes.this.size);
/*     */         }
/*     */ 
/*     */         
/*     */         public Attribute next() {
/* 410 */           checkModified();
/* 411 */           if (this.i >= Attributes.this.size) throw new NoSuchElementException(); 
/* 412 */           Attribute attribute = new Attribute(Attributes.this.keys[this.i], (String)Attributes.this.vals[this.i], Attributes.this);
/* 413 */           this.i++;
/* 414 */           return attribute;
/*     */         }
/*     */         
/*     */         private void checkModified() {
/* 418 */           if (Attributes.this.size != this.expectedSize) throw new ConcurrentModificationException("Use Iterator#remove() instead to remove attributes while iterating.");
/*     */         
/*     */         }
/*     */         
/*     */         public void remove() {
/* 423 */           Attributes.this.remove(--this.i);
/* 424 */           this.expectedSize--;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Attribute> asList() {
/* 434 */     ArrayList<Attribute> arrayList = new ArrayList(this.size);
/* 435 */     for (byte b = 0; b < this.size; b++) {
/* 436 */       if (!isInternalKey(this.keys[b])) {
/*     */         
/* 438 */         Attribute attribute = new Attribute(this.keys[b], (String)this.vals[b], this);
/* 439 */         arrayList.add(attribute);
/*     */       } 
/* 441 */     }  return Collections.unmodifiableList(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> dataset() {
/* 450 */     return new Dataset(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String html() {
/* 458 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/*     */     try {
/* 460 */       html(stringBuilder, (new Document("")).outputSettings());
/* 461 */     } catch (IOException iOException) {
/* 462 */       throw new SerializationException(iOException);
/*     */     } 
/* 464 */     return StringUtil.releaseBuilder((StringBuilder)iOException);
/*     */   }
/*     */   
/*     */   final void html(Appendable paramAppendable, Document.OutputSettings paramOutputSettings) {
/* 468 */     int i = this.size;
/* 469 */     for (byte b = 0; b < i; b++) {
/* 470 */       if (!isInternalKey(this.keys[b])) {
/*     */         String str;
/*     */         
/* 473 */         if ((str = Attribute.getValidKey(this.keys[b], paramOutputSettings.syntax())) != null)
/* 474 */           Attribute.htmlNoValidate(str, (String)this.vals[b], paramAppendable.append(' '), paramOutputSettings); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String toString() {
/* 480 */     return html();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 491 */     if (this == paramObject) return true; 
/* 492 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 494 */     paramObject = paramObject;
/* 495 */     if (this.size != ((Attributes)paramObject).size) return false; 
/* 496 */     for (byte b = 0; b < this.size; b++) {
/* 497 */       String str = this.keys[b];
/*     */       int i;
/* 499 */       if ((i = paramObject.indexOfKey(str)) == -1)
/* 500 */         return false; 
/* 501 */       Object object2 = this.vals[b];
/* 502 */       Object object1 = ((Attributes)paramObject).vals[i];
/* 503 */       if (object2 == null) {
/* 504 */         if (object1 != null)
/* 505 */           return false; 
/* 506 */       } else if (!object2.equals(object1)) {
/* 507 */         return false;
/*     */       } 
/* 509 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 518 */     int i = this.size;
/* 519 */     i = i * 31 + Arrays.hashCode((Object[])this.keys);
/*     */     
/* 521 */     return i = i * 31 + Arrays.hashCode(this.vals);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes clone() {
/*     */     try {
/* 528 */       Attributes attributes = (Attributes)super.clone();
/* 529 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 530 */       throw new RuntimeException(cloneNotSupportedException);
/*     */     } 
/* 532 */     ((Attributes)cloneNotSupportedException).size = this.size;
/* 533 */     ((Attributes)cloneNotSupportedException).keys = Arrays.<String>copyOf(this.keys, this.size);
/* 534 */     ((Attributes)cloneNotSupportedException).vals = Arrays.copyOf(this.vals, this.size);
/* 535 */     return (Attributes)cloneNotSupportedException;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void normalize() {
/* 542 */     for (byte b = 0; b < this.size; b++) {
/* 543 */       if (!isInternalKey(this.keys[b])) {
/* 544 */         this.keys[b] = Normalizer.lowerCase(this.keys[b]);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int deduplicate(ParseSettings paramParseSettings) {
/* 554 */     if (isEmpty())
/* 555 */       return 0; 
/* 556 */     boolean bool = paramParseSettings.preserveAttributeCase();
/* 557 */     byte b1 = 0;
/* 558 */     for (byte b2 = 0; b2 < this.keys.length; b2++) {
/* 559 */       for (int i = b2 + 1; i < this.keys.length && 
/* 560 */         this.keys[i] != null; i++) {
/*     */         
/* 562 */         if ((bool && this.keys[b2].equals(this.keys[i])) || (!bool && this.keys[b2].equalsIgnoreCase(this.keys[i]))) {
/* 563 */           b1++;
/* 564 */           remove(i);
/* 565 */           i--;
/*     */         } 
/*     */       } 
/*     */     } 
/* 569 */     return b1;
/*     */   }
/*     */   
/*     */   private static class Dataset extends AbstractMap<String, String> {
/*     */     private final Attributes attributes;
/*     */     
/*     */     private Dataset(Attributes param1Attributes) {
/* 576 */       this.attributes = param1Attributes;
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<Map.Entry<String, String>> entrySet() {
/* 581 */       return new EntrySet();
/*     */     }
/*     */ 
/*     */     
/*     */     public String put(String param1String1, String param1String2) {
/* 586 */       param1String1 = Attributes.dataKey(param1String1);
/* 587 */       String str = this.attributes.hasKey(param1String1) ? this.attributes.get(param1String1) : null;
/* 588 */       this.attributes.put(param1String1, param1String2);
/* 589 */       return str;
/*     */     }
/*     */     
/*     */     private class EntrySet extends AbstractSet<Map.Entry<String, String>> {
/*     */       private EntrySet() {}
/*     */       
/*     */       public Iterator<Map.Entry<String, String>> iterator() {
/* 596 */         return new Attributes.Dataset.DatasetIterator();
/*     */       }
/*     */ 
/*     */       
/*     */       public int size() {
/* 601 */         byte b = 0;
/* 602 */         Attributes.Dataset.DatasetIterator datasetIterator = new Attributes.Dataset.DatasetIterator();
/* 603 */         while (datasetIterator.hasNext())
/* 604 */           b++; 
/* 605 */         return b;
/*     */       } }
/*     */     private class DatasetIterator implements Iterator<Map.Entry<String, String>> { private Iterator<Attribute> attrIter;
/*     */       
/*     */       private DatasetIterator() {
/* 610 */         this.attrIter = Attributes.Dataset.this.attributes.iterator();
/*     */       } private Attribute attr;
/*     */       public boolean hasNext() {
/* 613 */         while (this.attrIter.hasNext()) {
/* 614 */           this.attr = this.attrIter.next();
/* 615 */           if (this.attr.isDataAttribute()) return true; 
/*     */         } 
/* 617 */         return false;
/*     */       }
/*     */       
/*     */       public Map.Entry<String, String> next() {
/* 621 */         return new Attribute(this.attr.getKey().substring(5), this.attr.getValue());
/*     */       }
/*     */       
/*     */       public void remove() {
/* 625 */         Attributes.Dataset.this.attributes.remove(this.attr.getKey());
/*     */       } }
/*     */   
/*     */   }
/*     */   
/*     */   private static String dataKey(String paramString) {
/* 631 */     return "data-" + paramString;
/*     */   }
/*     */   
/*     */   static String internalKey(String paramString) {
/* 635 */     return "/" + paramString;
/*     */   }
/*     */   
/*     */   static boolean isInternalKey(String paramString) {
/* 639 */     return (paramString != null && paramString.length() > 1 && paramString.charAt(0) == '/');
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\Attributes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */