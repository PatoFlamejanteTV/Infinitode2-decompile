/*     */ package com.vladsch.flexmark.util.html;
/*     */ 
/*     */ import java.util.LinkedHashMap;
/*     */ 
/*     */ public class MutableAttributes
/*     */   extends Attributes
/*     */ {
/*     */   public MutableAttributes() {}
/*     */   
/*     */   public MutableAttributes(Attributes paramAttributes) {
/*  11 */     super(paramAttributes);
/*     */   }
/*     */ 
/*     */   
/*     */   public MutableAttributes toMutable() {
/*  16 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes toImmutable() {
/*  21 */     return new Attributes(this);
/*     */   }
/*     */   
/*     */   protected LinkedHashMap<String, Attribute> getAttributes() {
/*  25 */     if (this.attributes == null) {
/*  26 */       this.attributes = new LinkedHashMap<>();
/*     */     }
/*  28 */     return this.attributes;
/*     */   }
/*     */   
/*     */   public Attribute replaceValue(Attribute paramAttribute) {
/*  32 */     return replaceValue(paramAttribute.getName(), paramAttribute.getValue());
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
/*     */   public Attribute replaceValue(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  45 */     paramCharSequence1 = String.valueOf(paramCharSequence1);
/*     */     
/*  47 */     if (this.attributes != null)
/*     */     { Attribute attribute;
/*     */ 
/*     */       
/*  51 */       if ((attribute = this.attributes.get(paramCharSequence1)) != null) { attribute = attribute.replaceValue(paramCharSequence2);
/*     */ 
/*     */         
/*  54 */         getAttributes().put(paramCharSequence1, attribute);
/*  55 */         return attribute; }  }  AttributeImpl attributeImpl = AttributeImpl.of(paramCharSequence1, paramCharSequence2); getAttributes().put(paramCharSequence1, attributeImpl); return attributeImpl;
/*     */   }
/*     */   
/*     */   public Attribute addValue(Attribute paramAttribute) {
/*  59 */     return addValue(paramAttribute.getName(), paramAttribute.getValue());
/*     */   }
/*     */   
/*     */   public MutableAttributes addValues(Attributes paramAttributes) {
/*  63 */     for (Attribute attribute : paramAttributes.values()) {
/*  64 */       addValue(attribute.getName(), attribute.getValue());
/*     */     }
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public Attribute addValue(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*     */     Attribute attribute;
/*  71 */     String str = String.valueOf(paramCharSequence1);
/*  72 */     if (this.attributes == null)
/*  73 */     { attribute = AttributeImpl.of(paramCharSequence1, paramCharSequence2);
/*     */        }
/*     */     
/*  76 */     else if ((attribute = this.attributes.get(str)) != null) { attribute = attribute.setValue(paramCharSequence2); }
/*  77 */     else { attribute = AttributeImpl.of(str, paramCharSequence2); }
/*     */     
/*  79 */     getAttributes().put(str, attribute);
/*  80 */     return attribute;
/*     */   }
/*     */   
/*     */   public Attribute removeValue(Attribute paramAttribute) {
/*  84 */     return removeValue(paramAttribute.getName(), paramAttribute.getValue());
/*     */   }
/*     */   
/*     */   public Attribute remove(Attribute paramAttribute) {
/*  88 */     return remove(paramAttribute.getName());
/*     */   }
/*     */   
/*     */   public Attribute removeValue(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  92 */     if (this.attributes == null || paramCharSequence1 == null || paramCharSequence1.length() == 0) return null;
/*     */     
/*  94 */     paramCharSequence1 = String.valueOf(paramCharSequence1);
/*     */     
/*  96 */     Attribute attribute2, attribute1 = (attribute2 = this.attributes.get(paramCharSequence1)).removeValue(paramCharSequence2);
/*  97 */     getAttributes().put(paramCharSequence1, attribute1);
/*  98 */     return attribute1;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 102 */     this.attributes = null;
/*     */   }
/*     */   
/*     */   public Attribute remove(CharSequence paramCharSequence) {
/* 106 */     if (this.attributes == null || paramCharSequence == null || paramCharSequence.length() == 0) return null;
/*     */     
/* 108 */     paramCharSequence = String.valueOf(paramCharSequence);
/* 109 */     Attribute attribute = this.attributes.get(paramCharSequence);
/* 110 */     this.attributes.remove(paramCharSequence);
/* 111 */     return attribute;
/*     */   }
/*     */   
/*     */   public void replaceValues(MutableAttributes paramMutableAttributes) {
/* 115 */     if (this.attributes == null) {
/* 116 */       this.attributes = new LinkedHashMap<>(paramMutableAttributes.attributes); return;
/*     */     } 
/* 118 */     this.attributes.putAll(paramMutableAttributes.attributes);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 124 */     StringBuilder stringBuilder = new StringBuilder();
/* 125 */     String str = "";
/* 126 */     for (String str2 : keySet()) {
/* 127 */       stringBuilder.append(str).append(str2);
/*     */       Attribute attribute;
/* 129 */       if (!(attribute = this.attributes.get(str2)).getValue().isEmpty()) stringBuilder.append("=\"").append(attribute.getValue().replace("\"", "\\\"")).append("\""); 
/* 130 */       String str1 = " ";
/*     */     } 
/*     */     
/* 133 */     return "MutableAttributes{" + stringBuilder.toString() + '}';
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\html\MutableAttributes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */