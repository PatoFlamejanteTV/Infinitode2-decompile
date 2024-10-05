/*     */ package com.vladsch.flexmark.util.html;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.Immutable;
/*     */ import com.vladsch.flexmark.util.misc.Mutable;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.function.BiConsumer;
/*     */ 
/*     */ public class MutableAttributeImpl implements MutableAttribute {
/*     */   private final String name;
/*     */   private final char valueListDelimiter;
/*     */   private final char valueNameDelimiter;
/*     */   private String value;
/*     */   private LinkedHashMap<String, String> values;
/*     */   
/*     */   private MutableAttributeImpl(CharSequence paramCharSequence1, CharSequence paramCharSequence2, char paramChar1, char paramChar2) {
/*  18 */     this.name = String.valueOf(paramCharSequence1);
/*  19 */     this.valueListDelimiter = paramChar1;
/*  20 */     this.valueNameDelimiter = paramChar2;
/*  21 */     this.value = (paramCharSequence2 == null) ? "" : String.valueOf(paramCharSequence2);
/*  22 */     this.values = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public char getValueListDelimiter() {
/*  27 */     return this.valueListDelimiter;
/*     */   }
/*     */ 
/*     */   
/*     */   public char getValueNameDelimiter() {
/*  32 */     return this.valueNameDelimiter;
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute toImmutable() {
/*  37 */     return AttributeImpl.of(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public MutableAttribute toMutable() {
/*  42 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public MutableAttribute copy() {
/*  47 */     return of(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  52 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getValue() {
/*  57 */     if (this.value == null) {
/*  58 */       this.value = valueFromMap();
/*     */     }
/*  60 */     return this.value;
/*     */   }
/*     */   
/*     */   public void resetToValuesMap() {
/*  64 */     if (this.values == null) throw new IllegalStateException("resetToValuesMap called when values is null"); 
/*  65 */     this.value = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Map<String, String> getValueMap() {
/*  70 */     if (this.values == null) {
/*  71 */       this.values = new LinkedHashMap<>();
/*  72 */       if (this.valueListDelimiter != '\000') {
/*  73 */         if (!this.value.isEmpty()) {
/*  74 */           int i = 0;
/*  75 */           while (i < this.value.length()) {
/*     */ 
/*     */             
/*  78 */             int j, k = ((j = this.value.indexOf(this.valueListDelimiter, i)) == -1) ? this.value.length() : j;
/*  79 */             if (i < k) {
/*  80 */               String str = this.value.substring(i, k);
/*     */               
/*     */               byte b;
/*  83 */               if ((b = (this.valueNameDelimiter != '\000') ? str.indexOf(this.valueNameDelimiter) : -1) == -1) {
/*  84 */                 this.values.put(str, "");
/*     */               } else {
/*  86 */                 this.values.put(str.substring(0, b), str.substring(b + 1));
/*     */               } 
/*     */             } 
/*  89 */             if (j != -1)
/*  90 */               i = k + 1; 
/*     */           } 
/*     */         } 
/*     */       } else {
/*  94 */         this.values.put(this.value, "");
/*     */       } 
/*     */     } 
/*  97 */     return this.values;
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
/*     */   protected String valueFromMap() {
/* 110 */     StringBuilder stringBuilder = new StringBuilder();
/* 111 */     if (this.valueNameDelimiter != '\000') {
/* 112 */       String str1 = "";
/* 113 */       String str2 = String.valueOf(this.valueListDelimiter);
/* 114 */       for (Iterator<Map.Entry> iterator = this.values.entrySet().iterator(); iterator.hasNext();) {
/* 115 */         if (!((String)(entry = iterator.next()).getKey()).isEmpty()) {
/* 116 */           stringBuilder.append(str1);
/* 117 */           str1 = str2;
/* 118 */           stringBuilder.append(entry.getKey()).append(this.valueNameDelimiter).append((String)entry.getValue());
/*     */         } 
/*     */       } 
/*     */     } else {
/* 122 */       String str1 = "";
/* 123 */       String str2 = String.valueOf(this.valueListDelimiter);
/* 124 */       for (Iterator<String> iterator = this.values.keySet().iterator(); iterator.hasNext();) {
/* 125 */         if (!(str = iterator.next()).isEmpty()) {
/* 126 */           stringBuilder.append(str1);
/* 127 */           stringBuilder.append(str);
/* 128 */           str1 = str2;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 134 */     this.value = (this.valueListDelimiter != '\000') ? stringBuilder.toString() : ((this.values == null || this.values.isEmpty()) ? "" : this.values.keySet().iterator().next());
/*     */     
/* 136 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNonRendering() {
/* 141 */     return (this.name.indexOf(' ') != -1 || (this.value.isEmpty() && NON_RENDERING_WHEN_EMPTY.contains(this.name)));
/*     */   }
/*     */   
/*     */   public MutableAttributeImpl replaceValue(CharSequence paramCharSequence) {
/* 145 */     String str = (paramCharSequence == null) ? "" : String.valueOf(paramCharSequence);
/* 146 */     if (this.value == null || paramCharSequence == null || !this.value.equals(str)) {
/* 147 */       this.value = str;
/* 148 */       this.values = null;
/*     */     } 
/* 150 */     return this;
/*     */   }
/*     */   
/*     */   public MutableAttributeImpl setValue(CharSequence paramCharSequence) {
/* 154 */     if (this.valueListDelimiter != '\000') {
/* 155 */       if (paramCharSequence != null && paramCharSequence.length() != 0) {
/* 156 */         Map<String, String> map = getValueMap();
/*     */         
/* 158 */         forEachValue(paramCharSequence, (paramString1, paramString2) -> {
/*     */               if (this.valueNameDelimiter != '\000' && paramString2.isEmpty()) {
/*     */                 paramMap.remove(paramString1);
/*     */                 
/*     */                 return;
/*     */               } 
/*     */               paramMap.put(paramString1, paramString2);
/*     */             });
/* 166 */         this.value = null;
/*     */       }
/*     */     
/* 169 */     } else if (this.value == null || !this.value.contentEquals(paramCharSequence)) {
/* 170 */       this.value = (paramCharSequence == null) ? "" : String.valueOf(paramCharSequence);
/* 171 */       this.values = null;
/*     */     } 
/*     */ 
/*     */     
/* 175 */     return this;
/*     */   }
/*     */   
/*     */   private void forEachValue(CharSequence paramCharSequence, BiConsumer<String, String> paramBiConsumer) {
/* 179 */     paramCharSequence = (paramCharSequence == null) ? "" : String.valueOf(paramCharSequence);
/* 180 */     byte b = 0;
/* 181 */     while (b < paramCharSequence.length()) {
/*     */ 
/*     */       
/* 184 */       int i, j = ((i = paramCharSequence.indexOf(this.valueListDelimiter, b)) == -1) ? paramCharSequence.length() : i; String str;
/* 185 */       if (b < j && 
/*     */         
/* 187 */         !(str = paramCharSequence.substring(b, j).trim()).isEmpty()) {
/*     */         byte b1;
/* 189 */         String str1 = ((b1 = (this.valueNameDelimiter == '\000') ? -1 : str.indexOf(this.valueNameDelimiter)) == -1) ? str : str.substring(0, b1);
/* 190 */         str = (b1 == -1) ? "" : str.substring(b1 + 1);
/*     */         
/* 192 */         paramBiConsumer.accept(str1, str);
/*     */       } 
/*     */ 
/*     */       
/* 196 */       if (i != -1)
/* 197 */         int k = j + 1; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public MutableAttributeImpl removeValue(CharSequence paramCharSequence) {
/* 202 */     if (this.valueListDelimiter != '\000') {
/* 203 */       if (paramCharSequence != null && paramCharSequence.length() != 0) {
/* 204 */         Map<String, String> map = getValueMap();
/* 205 */         boolean[] arrayOfBoolean = { false };
/*     */         
/* 207 */         forEachValue(paramCharSequence, (paramString1, paramString2) -> {
/*     */               if (paramMap.remove(paramString1) != null) {
/*     */                 paramArrayOfboolean[0] = true;
/*     */               }
/*     */             });
/*     */         
/* 213 */         if (arrayOfBoolean[0]) this.value = null;
/*     */       
/*     */       } 
/* 216 */     } else if (this.value == null || !this.value.contentEquals(paramCharSequence)) {
/* 217 */       this.value = "";
/* 218 */       this.values = null;
/*     */     } 
/*     */     
/* 221 */     return this;
/*     */   }
/*     */   
/*     */   public boolean containsValue(CharSequence paramCharSequence) {
/* 225 */     return (AttributeImpl.indexOfValue(this.value, paramCharSequence, this.valueListDelimiter, this.valueNameDelimiter) != -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 230 */     if (this == paramObject) return true; 
/* 231 */     if (!(paramObject instanceof Attribute)) return false;
/*     */     
/* 233 */     paramObject = paramObject;
/*     */     
/* 235 */     if (!this.name.equals(paramObject.getName())) return false; 
/* 236 */     return getValue().equals(paramObject.getValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 241 */     int i = this.name.hashCode();
/*     */     
/* 243 */     return i = i * 31 + getValue().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 248 */     return "MutableAttributeImpl { name='" + this.name + '\'' + ", value='" + 
/*     */       
/* 250 */       getValue() + '\'' + " }";
/*     */   }
/*     */ 
/*     */   
/*     */   public static MutableAttributeImpl of(Attribute paramAttribute) {
/* 255 */     return of(paramAttribute.getName(), paramAttribute.getValue(), paramAttribute.getValueListDelimiter(), paramAttribute.getValueNameDelimiter());
/*     */   }
/*     */   
/*     */   public static MutableAttributeImpl of(CharSequence paramCharSequence) {
/* 259 */     return of(paramCharSequence, paramCharSequence, false, false);
/*     */   }
/*     */   
/*     */   public static MutableAttributeImpl of(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 263 */     return of(paramCharSequence1, paramCharSequence2, false, false);
/*     */   }
/*     */   
/*     */   public static MutableAttributeImpl of(CharSequence paramCharSequence1, CharSequence paramCharSequence2, char paramChar) {
/* 267 */     return of(paramCharSequence1, paramCharSequence2, paramChar, false);
/*     */   }
/*     */   
/*     */   public static MutableAttributeImpl of(CharSequence paramCharSequence1, CharSequence paramCharSequence2, char paramChar1, char paramChar2) {
/* 271 */     if ("class".contentEquals(paramCharSequence1))
/* 272 */       return new MutableAttributeImpl(paramCharSequence1, paramCharSequence2, ' ', false); 
/* 273 */     if ("style".contentEquals(paramCharSequence1)) {
/* 274 */       return new MutableAttributeImpl(paramCharSequence1, paramCharSequence2, ';', ':');
/*     */     }
/* 276 */     return new MutableAttributeImpl(paramCharSequence1, paramCharSequence2, paramChar1, paramChar2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\html\MutableAttributeImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */