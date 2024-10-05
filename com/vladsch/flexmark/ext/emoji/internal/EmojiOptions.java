/*    */ package com.vladsch.flexmark.ext.emoji.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.emoji.EmojiExtension;
/*    */ import com.vladsch.flexmark.ext.emoji.EmojiImageType;
/*    */ import com.vladsch.flexmark.ext.emoji.EmojiShortcutType;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ public class EmojiOptions {
/*    */   public final String rootImagePath;
/*    */   public final EmojiShortcutType useShortcutType;
/*    */   public final EmojiImageType useImageType;
/*    */   public final String attrImageSize;
/*    */   public final String attrAlign;
/*    */   public final String attrImageClass;
/*    */   
/*    */   public EmojiOptions(DataHolder paramDataHolder) {
/* 17 */     this.useShortcutType = (EmojiShortcutType)EmojiExtension.USE_SHORTCUT_TYPE.get(paramDataHolder);
/* 18 */     this.attrAlign = (String)EmojiExtension.ATTR_ALIGN.get(paramDataHolder);
/* 19 */     this.attrImageSize = (String)EmojiExtension.ATTR_IMAGE_SIZE.get(paramDataHolder);
/* 20 */     this.rootImagePath = (String)EmojiExtension.ROOT_IMAGE_PATH.get(paramDataHolder);
/* 21 */     this.useImageType = (EmojiImageType)EmojiExtension.USE_IMAGE_TYPE.get(paramDataHolder);
/* 22 */     this.attrImageClass = (String)EmojiExtension.ATTR_IMAGE_CLASS.get(paramDataHolder);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\internal\EmojiOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */