/*    */ package com.prineside.tdi2.ibxm;
/*    */ 
/*    */ public class Instrument {
/*  4 */   public String name = "";
/*  5 */   public int numSamples = 1;
/*  6 */   public int vibratoType = 0, vibratoSweep = 0, vibratoDepth = 0, vibratoRate = 0;
/*  7 */   public int volumeFadeOut = 0;
/*  8 */   public Envelope volumeEnvelope = new Envelope();
/*  9 */   public Envelope panningEnvelope = new Envelope();
/* 10 */   public int[] keyToSample = new int[97];
/* 11 */   public Sample[] samples = new Sample[] { new Sample() };
/*    */   
/*    */   public Instrument() {}
/*    */   
/*    */   public Instrument(Instrument paramInstrument) {
/* 16 */     this.name = paramInstrument.name;
/* 17 */     this.numSamples = paramInstrument.numSamples;
/* 18 */     this.vibratoType = paramInstrument.vibratoType;
/* 19 */     this.vibratoSweep = paramInstrument.vibratoSweep;
/* 20 */     this.vibratoDepth = paramInstrument.vibratoDepth;
/* 21 */     this.vibratoRate = paramInstrument.vibratoRate;
/* 22 */     this.volumeFadeOut = paramInstrument.volumeFadeOut;
/* 23 */     this.volumeEnvelope = new Envelope(paramInstrument.volumeEnvelope);
/* 24 */     this.panningEnvelope = new Envelope(paramInstrument.panningEnvelope);
/* 25 */     this.keyToSample = new int[paramInstrument.keyToSample.length];
/* 26 */     System.arraycopy(paramInstrument.keyToSample, 0, this.keyToSample, 0, this.keyToSample.length);
/* 27 */     this.samples = new Sample[paramInstrument.samples.length];
/* 28 */     for (byte b = 0; b < paramInstrument.samples.length; b++) {
/* 29 */       this.samples[b] = new Sample(paramInstrument.samples[b]);
/*    */     }
/*    */   }
/*    */   
/*    */   public void toStringBuffer(StringBuffer paramStringBuffer) {
/* 34 */     paramStringBuffer.append("Name: " + this.name + '\n');
/* 35 */     if (this.numSamples > 0) {
/* 36 */       paramStringBuffer.append("Num Samples: " + this.numSamples + '\n');
/* 37 */       paramStringBuffer.append("Vibrato Type: " + this.vibratoType + '\n');
/* 38 */       paramStringBuffer.append("Vibrato Sweep: " + this.vibratoSweep + '\n');
/* 39 */       paramStringBuffer.append("Vibrato Depth: " + this.vibratoDepth + '\n');
/* 40 */       paramStringBuffer.append("Vibrato Rate: " + this.vibratoRate + '\n');
/* 41 */       paramStringBuffer.append("Volume Fade Out: " + this.volumeFadeOut + '\n');
/* 42 */       paramStringBuffer.append("Volume Envelope:\n");
/* 43 */       this.volumeEnvelope.toStringBuffer(paramStringBuffer);
/* 44 */       paramStringBuffer.append("Panning Envelope:\n");
/* 45 */       this.panningEnvelope.toStringBuffer(paramStringBuffer); byte b;
/* 46 */       for (b = 0; b < this.numSamples; b++) {
/* 47 */         paramStringBuffer.append("Sample " + b + ":\n");
/* 48 */         this.samples[b].toStringBuffer(paramStringBuffer);
/*    */       } 
/* 50 */       paramStringBuffer.append("Key To Sample: ");
/* 51 */       for (b = 1; b < 97; b++)
/* 52 */         paramStringBuffer.append(this.keyToSample[b] + ", "); 
/* 53 */       paramStringBuffer.append('\n');
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ibxm\Instrument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */