/*    */ package com.vladsch.flexmark.ext.media.tags;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Link;
/*    */ import com.vladsch.flexmark.ext.media.tags.internal.AbstractMediaLink;
/*    */ 
/*    */ public class EmbedLink
/*    */   extends AbstractMediaLink {
/*    */   public static final String PREFIX = "!E";
/*    */   private static final String TYPE = "Embed";
/*    */   
/*    */   public EmbedLink() {
/* 12 */     super("!E", "Embed");
/*    */   }
/*    */   
/*    */   public EmbedLink(Link paramLink) {
/* 16 */     super("!E", "Embed", paramLink);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\media\tags\EmbedLink.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */