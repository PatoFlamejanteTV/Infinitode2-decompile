/*     */ package com.vladsch.flexmark.util.format;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TrackedOffset
/*     */   implements Comparable<TrackedOffset>
/*     */ {
/*     */   private enum Flags
/*     */   {
/*  15 */     AFTER_SPACE_EDIT,
/*  16 */     AFTER_INSERT,
/*  17 */     AFTER_DELETE;
/*     */   }
/*     */   
/*  20 */   private static final int F_AFTER_SPACE_EDIT = BitFieldSet.intMask(Flags.AFTER_SPACE_EDIT);
/*  21 */   private static final int F_AFTER_INSERT = BitFieldSet.intMask(Flags.AFTER_INSERT);
/*  22 */   private static final int F_AFTER_DELETE = BitFieldSet.intMask(Flags.AFTER_DELETE);
/*     */   
/*     */   private final TrackedOffset original;
/*     */   private final int offset;
/*     */   private final int flags;
/*     */   private int spacesBefore;
/*     */   private int spacesAfter;
/*     */   private boolean isSpliced;
/*     */   private int index;
/*     */   
/*     */   private TrackedOffset(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  33 */     this.original = null;
/*  34 */     this.offset = paramInt;
/*  35 */     paramInt = 0;
/*  36 */     if (paramBoolean1) paramInt = 0x0 | F_AFTER_SPACE_EDIT; 
/*  37 */     if (paramBoolean2) paramInt |= F_AFTER_INSERT; 
/*  38 */     if (paramBoolean3) paramInt |= F_AFTER_DELETE; 
/*  39 */     this.flags = paramInt;
/*  40 */     this.index = -1;
/*  41 */     this.spacesBefore = -1;
/*  42 */     this.spacesAfter = -1;
/*     */   }
/*     */   
/*     */   private TrackedOffset(TrackedOffset paramTrackedOffset) {
/*  46 */     this.original = paramTrackedOffset.original;
/*  47 */     this.offset = paramTrackedOffset.offset;
/*  48 */     this.flags = paramTrackedOffset.flags;
/*  49 */     this.index = -1;
/*  50 */     this.spacesBefore = paramTrackedOffset.spacesBefore;
/*  51 */     this.spacesAfter = paramTrackedOffset.spacesAfter;
/*     */   }
/*     */   
/*     */   private TrackedOffset(TrackedOffset paramTrackedOffset, int paramInt) {
/*  55 */     this.original = paramTrackedOffset;
/*  56 */     this.offset = paramInt;
/*  57 */     this.flags = paramTrackedOffset.flags;
/*  58 */     this.index = -1;
/*  59 */     this.spacesBefore = paramTrackedOffset.spacesBefore;
/*  60 */     this.spacesAfter = paramTrackedOffset.spacesAfter;
/*     */   }
/*     */   
/*     */   public final int getOffset() {
/*  64 */     return this.offset;
/*     */   }
/*     */   
/*     */   public final int getSpacesBefore() {
/*  68 */     return this.spacesBefore;
/*     */   }
/*     */   
/*     */   public final void setSpacesBefore(int paramInt) {
/*  72 */     this.spacesBefore = paramInt;
/*     */   }
/*     */   
/*     */   public final int getSpacesAfter() {
/*  76 */     return this.spacesAfter;
/*     */   }
/*     */   
/*     */   public final void setSpacesAfter(int paramInt) {
/*  80 */     this.spacesAfter = paramInt;
/*     */   }
/*     */   
/*     */   public final boolean isSpliced() {
/*  84 */     return this.isSpliced;
/*     */   }
/*     */   
/*     */   public final void setSpliced(boolean paramBoolean) {
/*  88 */     this.isSpliced = paramBoolean;
/*     */   }
/*     */   
/*     */   public final boolean isResolved() {
/*  92 */     return (this.index != -1);
/*     */   }
/*     */   
/*     */   public final int getIndex() {
/*  96 */     return (this.index == -1) ? this.offset : this.index;
/*     */   }
/*     */   
/*     */   public final void setIndex(int paramInt) {
/* 100 */     if (this.original != null) this.original.index = paramInt; 
/* 101 */     this.index = paramInt;
/*     */   }
/*     */   
/*     */   public final boolean isAfterSpaceEdit() {
/* 105 */     return BitFieldSet.any(this.flags, F_AFTER_SPACE_EDIT);
/*     */   }
/*     */   
/*     */   public final boolean isAfterInsert() {
/* 109 */     return BitFieldSet.any(this.flags, F_AFTER_INSERT);
/*     */   }
/*     */   
/*     */   public final boolean isAfterDelete() {
/* 113 */     return BitFieldSet.any(this.flags, F_AFTER_DELETE);
/*     */   }
/*     */ 
/*     */   
/*     */   public final TrackedOffset plusOffsetDelta(int paramInt) {
/* 118 */     return new TrackedOffset(this, this.offset + paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final TrackedOffset withOffset(int paramInt) {
/* 123 */     return new TrackedOffset(this, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int compareTo(TrackedOffset paramTrackedOffset) {
/* 128 */     return Integer.compare(this.offset, paramTrackedOffset.offset);
/*     */   }
/*     */   
/*     */   public final int compareTo(Integer paramInteger) {
/* 132 */     return Integer.compare(this.offset, paramInteger.intValue());
/*     */   }
/*     */   
/*     */   public final int compareTo(int paramInt) {
/* 136 */     return Integer.compare(this.offset, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 141 */     if (this == paramObject) return true; 
/* 142 */     if (paramObject == null || (getClass() != paramObject.getClass() && !(paramObject instanceof Integer))) return false;
/*     */     
/* 144 */     if (paramObject instanceof Integer) {
/* 145 */       return (((Integer)paramObject).intValue() == this.offset);
/*     */     }
/*     */     
/* 148 */     paramObject = paramObject;
/* 149 */     return (this.offset == ((TrackedOffset)paramObject).offset);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 154 */     return this.offset;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 159 */     return "{" + this.offset + (
/* 160 */       isSpliced() ? " ><" : "") + ((this.spacesBefore >= 0 || this.spacesAfter >= 0) ? (" " + ((this.spacesBefore >= 0) ? 
/* 161 */       Integer.toString(this.spacesBefore) : "?") + "|" + ((this.spacesAfter >= 0) ? Integer.toString(this.spacesAfter) : "?")) : "") + (
/* 162 */       BitFieldSet.any(this.flags, (F_AFTER_SPACE_EDIT | F_AFTER_INSERT | F_AFTER_DELETE)) ? (" " + (isAfterSpaceEdit() ? "s" : "") + (isAfterInsert() ? "i" : "") + (isAfterDelete() ? "d" : "")) : "") + (
/* 163 */       isResolved() ? (" -> " + this.index) : "") + "}";
/*     */   }
/*     */ 
/*     */   
/*     */   public static TrackedOffset track(TrackedOffset paramTrackedOffset) {
/* 168 */     return new TrackedOffset(paramTrackedOffset);
/*     */   }
/*     */   
/*     */   public static TrackedOffset track(int paramInt) {
/* 172 */     return track(paramInt, false, false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static TrackedOffset track(int paramInt, Character paramCharacter, boolean paramBoolean) {
/* 177 */     return track(paramInt, (paramCharacter != null && paramCharacter.charValue() == ' '), (paramCharacter != null && !paramBoolean), paramBoolean);
/*     */   }
/*     */   
/*     */   public static TrackedOffset track(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 181 */     assert paramBoolean2 != paramBoolean3 : "Cannot have both afterInsert and afterDelete true";
/* 182 */     return new TrackedOffset(paramInt, paramBoolean1, paramBoolean2, paramBoolean3);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TrackedOffset.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */