/*    */ package com.vladsch.flexmark.html.renderer;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ResolvedContent
/*    */ {
/*    */   private final ResolvedLink resolvedLink;
/*    */   private final LinkStatus status;
/*    */   private final byte[] content;
/*    */   
/*    */   public ResolvedContent(ResolvedLink paramResolvedLink, LinkStatus paramLinkStatus, byte[] paramArrayOfbyte) {
/* 14 */     this.resolvedLink = paramResolvedLink;
/* 15 */     this.status = paramLinkStatus;
/* 16 */     this.content = paramArrayOfbyte;
/*    */   }
/*    */ 
/*    */   
/*    */   public ResolvedContent withStatus(LinkStatus paramLinkStatus) {
/* 21 */     return (paramLinkStatus == this.status) ? this : new ResolvedContent(this.resolvedLink, paramLinkStatus, this.content); } public ResolvedContent withContent(byte[] paramArrayOfbyte) {
/* 22 */     return Arrays.equals(this.content, paramArrayOfbyte) ? this : new ResolvedContent(this.resolvedLink, this.status, paramArrayOfbyte);
/*    */   }
/*    */   
/*    */   public ResolvedLink getResolvedLink() {
/* 26 */     return this.resolvedLink;
/*    */   }
/*    */   
/*    */   public LinkStatus getStatus() {
/* 30 */     return this.status;
/*    */   }
/*    */   
/*    */   public byte[] getContent() {
/* 34 */     return this.content;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 39 */     if (this == paramObject) return true; 
/* 40 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*    */     
/* 42 */     paramObject = paramObject;
/*    */     
/* 44 */     if (!this.resolvedLink.equals(((ResolvedContent)paramObject).resolvedLink)) return false; 
/* 45 */     if (!this.status.equals(((ResolvedContent)paramObject).status)) return false; 
/* 46 */     return Arrays.equals(this.content, ((ResolvedContent)paramObject).content);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 51 */     int i = this.resolvedLink.hashCode();
/* 52 */     i = i * 31 + this.status.hashCode();
/*    */     
/* 54 */     return i = i * 31 + Arrays.hashCode(this.content);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\ResolvedContent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */