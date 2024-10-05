/*     */ package com.vladsch.flexmark.util.html;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class Attributes {
/*   7 */   public static final Attributes EMPTY = new Attributes();
/*     */   
/*     */   protected LinkedHashMap<String, Attribute> attributes;
/*     */   
/*     */   public Attributes() {
/*  12 */     this.attributes = null;
/*     */   }
/*     */   
/*     */   public Attributes(Attributes paramAttributes) {
/*  16 */     this.attributes = (paramAttributes == null || paramAttributes.attributes == null) ? null : new LinkedHashMap<>(paramAttributes.attributes);
/*     */   }
/*     */   
/*     */   public MutableAttributes toMutable() {
/*  20 */     return new MutableAttributes(this);
/*     */   }
/*     */   
/*     */   public Attributes toImmutable() {
/*  24 */     return this;
/*     */   }
/*     */   
/*     */   public Attribute get(CharSequence paramCharSequence) {
/*  28 */     if (this.attributes == null || paramCharSequence == null || paramCharSequence.length() == 0) return null;
/*     */     
/*  30 */     paramCharSequence = String.valueOf(paramCharSequence);
/*  31 */     return this.attributes.get(paramCharSequence);
/*     */   }
/*     */   
/*     */   public String getValue(CharSequence paramCharSequence) {
/*  35 */     if (this.attributes == null || paramCharSequence == null || paramCharSequence.length() == 0) return "";
/*     */     
/*  37 */     paramCharSequence = String.valueOf(paramCharSequence);
/*     */     Attribute attribute;
/*  39 */     if ((attribute = this.attributes.get(paramCharSequence)) == null) return ""; 
/*  40 */     return attribute.getValue();
/*     */   }
/*     */   
/*     */   public boolean contains(CharSequence paramCharSequence) {
/*  44 */     if (this.attributes == null || paramCharSequence == null || paramCharSequence.length() == 0) return false;
/*     */     
/*  46 */     paramCharSequence = String.valueOf(paramCharSequence);
/*  47 */     return this.attributes.containsKey(paramCharSequence);
/*     */   }
/*     */   
/*     */   public boolean containsValue(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  51 */     if (this.attributes == null) return false; 
/*  52 */     paramCharSequence1 = String.valueOf(paramCharSequence1);
/*     */     Attribute attribute;
/*  54 */     if ((attribute = this.attributes.get(paramCharSequence1)) != null && attribute.containsValue(paramCharSequence2)) return true;  return false;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  58 */     return (this.attributes == null || this.attributes.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> keySet() {
/*  64 */     return (this.attributes != null) ? this.attributes.keySet() : Collections.EMPTY_SET;
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<Attribute> values() {
/*  69 */     return (this.attributes != null) ? this.attributes.values() : Collections.EMPTY_LIST;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<String, Attribute>> entrySet() {
/*  75 */     return (this.attributes != null) ? this.attributes.entrySet() : Collections.EMPTY_SET;
/*     */   }
/*     */   
/*     */   public void forEach(BiConsumer<String, Attribute> paramBiConsumer) {
/*  79 */     if (this.attributes != null) {
/*  80 */       for (Map.Entry<String, Attribute> entry : this.attributes.entrySet()) {
/*  81 */         paramBiConsumer.accept((String)entry.getKey(), (Attribute)entry.getValue());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public int size() {
/*  87 */     return (this.attributes == null) ? 0 : this.attributes.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder stringBuilder = new StringBuilder();
/*  93 */     String str = "";
/*  94 */     for (String str2 : keySet()) {
/*  95 */       stringBuilder.append(str).append(str2);
/*     */       Attribute attribute;
/*  97 */       if (!(attribute = this.attributes.get(str2)).getValue().isEmpty()) stringBuilder.append("=\"").append(attribute.getValue().replace("\"", "\\\"")).append("\""); 
/*  98 */       String str1 = " ";
/*     */     } 
/*     */     
/* 101 */     return "Attributes{" + stringBuilder.toString() + '}';
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\html\Attributes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */