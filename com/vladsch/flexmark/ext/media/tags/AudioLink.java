/*    */ package com.vladsch.flexmark.ext.media.tags;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Link;
/*    */ import com.vladsch.flexmark.ext.media.tags.internal.AbstractMediaLink;
/*    */ 
/*    */ public class AudioLink
/*    */   extends AbstractMediaLink {
/*    */   public static final String PREFIX = "!A";
/*    */   private static final String TYPE = "Audio";
/*    */   
/*    */   public AudioLink() {
/* 12 */     super("!A", "Audio");
/*    */   }
/*    */   
/*    */   public AudioLink(Link paramLink) {
/* 16 */     super("!A", "Audio", paramLink);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\media\tags\AudioLink.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */