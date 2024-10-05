/*    */ package com.prineside.tdi2.ibxm;
/*    */ 
/*    */ public class Envelope {
/*    */   public boolean enabled = false;
/*  5 */   public int sustainTick = 0, loopStartTick = 0, loopEndTick = 0; public boolean sustain = false; public boolean looped = false;
/*  6 */   public int numPoints = 1;
/*  7 */   public int[] pointsTick = new int[1];
/*  8 */   public int[] pointsAmpl = new int[1];
/*    */   
/*    */   public Envelope() {}
/*    */   
/*    */   public Envelope(Envelope paramEnvelope) {
/* 13 */     this.enabled = paramEnvelope.enabled;
/* 14 */     this.sustain = paramEnvelope.sustain;
/* 15 */     this.looped = paramEnvelope.looped;
/* 16 */     this.sustainTick = paramEnvelope.sustainTick;
/* 17 */     this.loopStartTick = paramEnvelope.loopStartTick;
/* 18 */     this.loopEndTick = paramEnvelope.loopEndTick;
/* 19 */     this.numPoints = paramEnvelope.numPoints;
/* 20 */     this.pointsTick = new int[paramEnvelope.pointsTick.length];
/* 21 */     System.arraycopy(paramEnvelope.pointsTick, 0, this.pointsTick, 0, this.pointsTick.length);
/* 22 */     this.pointsAmpl = new int[paramEnvelope.pointsAmpl.length];
/* 23 */     System.arraycopy(paramEnvelope.pointsAmpl, 0, this.pointsAmpl, 0, this.pointsAmpl.length);
/*    */   }
/*    */   
/*    */   public int nextTick(int paramInt, boolean paramBoolean) {
/* 27 */     paramInt++;
/* 28 */     if (this.looped && paramInt >= this.loopEndTick) paramInt = this.loopStartTick; 
/* 29 */     if (this.sustain && paramBoolean && paramInt >= this.sustainTick) paramInt = this.sustainTick; 
/* 30 */     return paramInt;
/*    */   }
/*    */   
/*    */   public int calculateAmpl(int paramInt) {
/* 34 */     int i = this.pointsAmpl[this.numPoints - 1];
/* 35 */     if (paramInt < this.pointsTick[this.numPoints - 1]) {
/* 36 */       int j = 0; int k;
/* 37 */       for (k = 1; k < this.numPoints; k++) {
/* 38 */         if (this.pointsTick[k] <= paramInt) j = k; 
/* 39 */       }  k = this.pointsTick[j + 1] - this.pointsTick[j];
/* 40 */       int m = this.pointsAmpl[j + 1] - this.pointsAmpl[j];
/*    */       
/* 42 */       i = (i = this.pointsAmpl[j]) + ((m << 24) / k * (paramInt - this.pointsTick[j]) >> 24);
/*    */     } 
/* 44 */     return i;
/*    */   }
/*    */   
/*    */   public void toStringBuffer(StringBuffer paramStringBuffer) {
/* 48 */     paramStringBuffer.append("Enabled: " + this.enabled + '\n');
/* 49 */     paramStringBuffer.append("Sustain: " + this.sustain + '\n');
/* 50 */     paramStringBuffer.append("Looped: " + this.looped + '\n');
/* 51 */     paramStringBuffer.append("Sustain Tick: " + this.sustainTick + '\n');
/* 52 */     paramStringBuffer.append("Loop Start Tick: " + this.loopStartTick + '\n');
/* 53 */     paramStringBuffer.append("Loop End Tick: " + this.loopEndTick + '\n');
/* 54 */     paramStringBuffer.append("Num Points: " + this.numPoints + '\n');
/* 55 */     paramStringBuffer.append("Points: ");
/* 56 */     for (byte b = 0; b < this.numPoints; b++) {
/* 57 */       paramStringBuffer.append("(" + this.pointsTick[b] + ", " + this.pointsAmpl[b] + "), ");
/*    */     }
/* 59 */     paramStringBuffer.append('\n');
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ibxm\Envelope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */