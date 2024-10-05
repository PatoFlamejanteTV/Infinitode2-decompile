/*    */ package com.vladsch.flexmark.ext.attributes.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.attributes.AttributesExtension;
/*    */ import com.vladsch.flexmark.ext.attributes.FencedCodeAddType;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*    */ 
/*    */ class AttributesOptions
/*    */   implements MutableDataSetter {
/*    */   public final boolean assignTextAttributes;
/*    */   public final boolean wrapNonAttributeText;
/*    */   public final boolean useEmptyImplicitAsSpanDelimiter;
/*    */   public final boolean fencedCodeInfoAttributes;
/*    */   public final FencedCodeAddType fencedCodeAddAttributes;
/*    */   
/*    */   public AttributesOptions(DataHolder paramDataHolder) {
/* 18 */     this.assignTextAttributes = ((Boolean)AttributesExtension.ASSIGN_TEXT_ATTRIBUTES.get(paramDataHolder)).booleanValue();
/* 19 */     this.wrapNonAttributeText = ((Boolean)AttributesExtension.WRAP_NON_ATTRIBUTE_TEXT.get(paramDataHolder)).booleanValue();
/* 20 */     this.useEmptyImplicitAsSpanDelimiter = ((Boolean)AttributesExtension.USE_EMPTY_IMPLICIT_AS_SPAN_DELIMITER.get(paramDataHolder)).booleanValue();
/* 21 */     this.fencedCodeInfoAttributes = ((Boolean)AttributesExtension.FENCED_CODE_INFO_ATTRIBUTES.get(paramDataHolder)).booleanValue();
/* 22 */     this.fencedCodeAddAttributes = (FencedCodeAddType)AttributesExtension.FENCED_CODE_ADD_ATTRIBUTES.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 28 */     paramMutableDataHolder.set(AttributesExtension.ASSIGN_TEXT_ATTRIBUTES, Boolean.valueOf(this.assignTextAttributes));
/* 29 */     paramMutableDataHolder.set(AttributesExtension.WRAP_NON_ATTRIBUTE_TEXT, Boolean.valueOf(this.wrapNonAttributeText));
/* 30 */     paramMutableDataHolder.set(AttributesExtension.USE_EMPTY_IMPLICIT_AS_SPAN_DELIMITER, Boolean.valueOf(this.useEmptyImplicitAsSpanDelimiter));
/* 31 */     paramMutableDataHolder.set(AttributesExtension.FENCED_CODE_INFO_ATTRIBUTES, Boolean.valueOf(this.fencedCodeInfoAttributes));
/* 32 */     paramMutableDataHolder.set(AttributesExtension.FENCED_CODE_ADD_ATTRIBUTES, this.fencedCodeAddAttributes);
/* 33 */     return paramMutableDataHolder;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\internal\AttributesOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */