/*    */ package com.vladsch.flexmark.ext.media.tags;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Link;
/*    */ import com.vladsch.flexmark.ext.media.tags.internal.AbstractMediaLink;
/*    */ 
/*    */ public class PictureLink
/*    */   extends AbstractMediaLink {
/*    */   public static final String PREFIX = "!P";
/*    */   private static final String TYPE = "Picture";
/*    */   
/*    */   public PictureLink() {
/* 12 */     super("!P", "Picture");
/*    */   }
/*    */   
/*    */   public PictureLink(Link paramLink) {
/* 16 */     super("!P", "Picture", paramLink);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\media\tags\PictureLink.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */