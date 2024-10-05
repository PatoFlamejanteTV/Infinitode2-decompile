/*    */ package com.vladsch.flexmark.ext.attributes.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.attributes.AttributeImplicitName;
/*    */ import com.vladsch.flexmark.ext.attributes.AttributeValueQuotes;
/*    */ import com.vladsch.flexmark.ext.attributes.AttributesExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*    */ import com.vladsch.flexmark.util.format.options.DiscretionaryText;
/*    */ 
/*    */ class AttributesFormatOptions
/*    */   implements MutableDataSetter {
/*    */   public final boolean attributesCombineConsecutive;
/*    */   public final boolean attributesSort;
/*    */   public final DiscretionaryText attributesSpaces;
/*    */   public final DiscretionaryText attributeEqualSpace;
/*    */   public final AttributeValueQuotes attributeValueQuotes;
/*    */   public final AttributeImplicitName attributeIdFormat;
/*    */   public final AttributeImplicitName attributeClassFormat;
/*    */   
/*    */   public AttributesFormatOptions(DataHolder paramDataHolder) {
/* 22 */     this.attributesCombineConsecutive = ((Boolean)AttributesExtension.FORMAT_ATTRIBUTES_COMBINE_CONSECUTIVE.get(paramDataHolder)).booleanValue();
/* 23 */     this.attributesSort = ((Boolean)AttributesExtension.FORMAT_ATTRIBUTES_SORT.get(paramDataHolder)).booleanValue();
/* 24 */     this.attributesSpaces = (DiscretionaryText)AttributesExtension.FORMAT_ATTRIBUTES_SPACES.get(paramDataHolder);
/* 25 */     this.attributeEqualSpace = (DiscretionaryText)AttributesExtension.FORMAT_ATTRIBUTE_EQUAL_SPACE.get(paramDataHolder);
/* 26 */     this.attributeValueQuotes = (AttributeValueQuotes)AttributesExtension.FORMAT_ATTRIBUTE_VALUE_QUOTES.get(paramDataHolder);
/* 27 */     this.attributeIdFormat = (AttributeImplicitName)AttributesExtension.FORMAT_ATTRIBUTE_ID.get(paramDataHolder);
/* 28 */     this.attributeClassFormat = (AttributeImplicitName)AttributesExtension.FORMAT_ATTRIBUTE_CLASS.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 34 */     paramMutableDataHolder.set(AttributesExtension.FORMAT_ATTRIBUTES_COMBINE_CONSECUTIVE, Boolean.valueOf(this.attributesCombineConsecutive));
/* 35 */     paramMutableDataHolder.set(AttributesExtension.FORMAT_ATTRIBUTES_SORT, Boolean.valueOf(this.attributesSort));
/* 36 */     paramMutableDataHolder.set(AttributesExtension.FORMAT_ATTRIBUTES_SPACES, this.attributesSpaces);
/* 37 */     paramMutableDataHolder.set(AttributesExtension.FORMAT_ATTRIBUTE_EQUAL_SPACE, this.attributeEqualSpace);
/* 38 */     paramMutableDataHolder.set(AttributesExtension.FORMAT_ATTRIBUTE_VALUE_QUOTES, this.attributeValueQuotes);
/* 39 */     paramMutableDataHolder.set(AttributesExtension.FORMAT_ATTRIBUTE_ID, this.attributeIdFormat);
/* 40 */     paramMutableDataHolder.set(AttributesExtension.FORMAT_ATTRIBUTE_CLASS, this.attributeClassFormat);
/* 41 */     return paramMutableDataHolder;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\internal\AttributesFormatOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */