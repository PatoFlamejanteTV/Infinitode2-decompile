/*    */ package com.vladsch.flexmark.ext.media.tags;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Link;
/*    */ import com.vladsch.flexmark.ext.media.tags.internal.AbstractMediaLink;
/*    */ 
/*    */ public class VideoLink
/*    */   extends AbstractMediaLink {
/*    */   public static final String PREFIX = "!V";
/*    */   private static final String TYPE = "Video";
/*    */   
/*    */   public VideoLink() {
/* 12 */     super("!V", "Video");
/*    */   }
/*    */   
/*    */   public VideoLink(Link paramLink) {
/* 16 */     super("!V", "Video", paramLink);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\media\tags\VideoLink.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */