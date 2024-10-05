/*     */ package net.bytebuddy.jar.asm;
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
/*     */ public final class Handle
/*     */ {
/*     */   private final int tag;
/*     */   private final String owner;
/*     */   private final String name;
/*     */   private final String descriptor;
/*     */   private final boolean isInterface;
/*     */   
/*     */   @Deprecated
/*     */   public Handle(int paramInt, String paramString1, String paramString2, String paramString3) {
/*  76 */     this(paramInt, paramString1, paramString2, paramString3, (paramInt == 9));
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
/*     */   public Handle(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/*  99 */     this.tag = paramInt;
/* 100 */     this.owner = paramString1;
/* 101 */     this.name = paramString2;
/* 102 */     this.descriptor = paramString3;
/* 103 */     this.isInterface = paramBoolean;
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
/*     */   public final int getTag() {
/* 115 */     return this.tag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getOwner() {
/* 125 */     return this.owner;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getName() {
/* 134 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getDesc() {
/* 143 */     return this.descriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isInterface() {
/* 152 */     return this.isInterface;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 157 */     if (paramObject == this) {
/* 158 */       return true;
/*     */     }
/* 160 */     if (!(paramObject instanceof Handle)) {
/* 161 */       return false;
/*     */     }
/* 163 */     paramObject = paramObject;
/* 164 */     if (this.tag == ((Handle)paramObject).tag && this.isInterface == ((Handle)paramObject).isInterface && this.owner
/*     */       
/* 166 */       .equals(((Handle)paramObject).owner) && this.name
/* 167 */       .equals(((Handle)paramObject).name) && this.descriptor
/* 168 */       .equals(((Handle)paramObject).descriptor)) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/* 173 */     return this.tag + (
/* 174 */       this.isInterface ? 64 : 0) + this.owner
/* 175 */       .hashCode() * this.name.hashCode() * this.descriptor.hashCode();
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
/*     */   public final String toString() {
/* 188 */     return this.owner + '.' + this.name + this.descriptor + " (" + this.tag + (this.isInterface ? " itf" : "") + ')';
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\Handle.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */