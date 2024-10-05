/*     */ package com.badlogic.gdx.ai.msg;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Pool;
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
/*     */ 
/*     */ 
/*     */ public class Telegram
/*     */   implements Pool.Poolable, Comparable<Telegram>
/*     */ {
/*     */   public static final int RETURN_RECEIPT_UNNEEDED = 0;
/*     */   public static final int RETURN_RECEIPT_NEEDED = 1;
/*     */   public static final int RETURN_RECEIPT_SENT = 2;
/*     */   public Telegraph sender;
/*     */   public Telegraph receiver;
/*     */   public int message;
/*     */   public int returnReceiptStatus;
/*     */   private float timestamp;
/*     */   public Object extraInfo;
/*     */   
/*     */   public float getTimestamp() {
/*  60 */     return this.timestamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTimestamp(float paramFloat) {
/*  65 */     this.timestamp = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/*  70 */     this.sender = null;
/*  71 */     this.receiver = null;
/*  72 */     this.message = 0;
/*  73 */     this.returnReceiptStatus = 0;
/*  74 */     this.extraInfo = null;
/*  75 */     this.timestamp = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(Telegram paramTelegram) {
/*  80 */     if (equals(paramTelegram)) return 0; 
/*  81 */     return (this.timestamp - paramTelegram.timestamp < 0.0F) ? -1 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  88 */     int i = 31 + this.message;
/*  89 */     i = i * 31 + ((this.receiver == null) ? 0 : this.receiver.hashCode());
/*  90 */     i = i * 31 + ((this.sender == null) ? 0 : this.sender.hashCode());
/*     */     
/*  92 */     return i = i * 31 + Float.floatToIntBits(this.timestamp);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  97 */     if (this == paramObject) return true; 
/*  98 */     if (paramObject == null) return false; 
/*  99 */     if (getClass() != paramObject.getClass()) return false; 
/* 100 */     paramObject = paramObject;
/* 101 */     if (this.message != ((Telegram)paramObject).message) return false; 
/* 102 */     if (Float.floatToIntBits(this.timestamp) != Float.floatToIntBits(((Telegram)paramObject).timestamp)) return false; 
/* 103 */     if (this.sender == null)
/* 104 */     { if (((Telegram)paramObject).sender != null) return false;  }
/* 105 */     else if (!this.sender.equals(((Telegram)paramObject).sender)) { return false; }
/* 106 */      if (this.receiver == null)
/* 107 */     { if (((Telegram)paramObject).receiver != null) return false;  }
/* 108 */     else if (!this.receiver.equals(((Telegram)paramObject).receiver)) { return false; }
/* 109 */      return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\msg\Telegram.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */