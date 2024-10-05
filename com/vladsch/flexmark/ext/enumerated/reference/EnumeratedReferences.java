/*     */ package com.vladsch.flexmark.ext.enumerated.reference;
/*     */ 
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class EnumeratedReferences
/*     */ {
/*     */   public static final String EMPTY_TYPE = "";
/*  11 */   public static final int[] EMPTY_ORDINALS = new int[0];
/*     */   
/*     */   private final EnumeratedReferenceRepository referenceRepository;
/*     */   private final HashMap<String, Integer> enumerationCounters;
/*     */   private final HashMap<String, int[]> enumeratedReferenceOrdinals;
/*     */   
/*     */   public EnumeratedReferences(DataHolder paramDataHolder) {
/*  18 */     this.referenceRepository = (EnumeratedReferenceRepository)EnumeratedReferenceExtension.ENUMERATED_REFERENCES.get(paramDataHolder);
/*  19 */     this.enumerationCounters = new HashMap<>();
/*  20 */     this.enumeratedReferenceOrdinals = (HashMap)new HashMap<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(String paramString) {
/*     */     String arrayOfString[], str;
/*  27 */     int[] arrayOfInt = new int[(arrayOfString = (str = EnumeratedReferenceRepository.getType(paramString)).split(":")).length];
/*     */ 
/*     */     
/*  30 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  32 */     int i = arrayOfString.length;
/*  33 */     for (byte b = 0; b < i; b++) {
/*  34 */       boolean bool; String str1 = arrayOfString[b];
/*  35 */       stringBuilder.append(str1);
/*     */       
/*  37 */       str1 = stringBuilder.toString();
/*     */       
/*  39 */       if (b < i - 1) {
/*     */         Integer integer;
/*  41 */         bool = ((integer = this.enumerationCounters.get(str1)) == null) ? false : integer.intValue();
/*     */         
/*  43 */         stringBuilder.append(':').append(bool).append(':');
/*  44 */         arrayOfInt[b] = bool;
/*     */       } else {
/*     */         int j;
/*     */ 
/*     */         
/*  49 */         if (!this.enumerationCounters.containsKey(bool)) {
/*  50 */           this.enumerationCounters.put(bool, Integer.valueOf(1));
/*  51 */           j = 1;
/*     */         } else {
/*  53 */           j = ((Integer)this.enumerationCounters.get(bool)).intValue() + 1;
/*  54 */           this.enumerationCounters.put(bool, Integer.valueOf(j));
/*     */         } 
/*     */         
/*  57 */         arrayOfInt[b] = j;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  62 */     this.enumeratedReferenceOrdinals.put(paramString, arrayOfInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumeratedReferenceRendering[] getEnumeratedReferenceOrdinals(String paramString) {
/*     */     String str, arrayOfString[];
/*  69 */     EnumeratedReferenceRendering[] arrayOfEnumeratedReferenceRendering = new EnumeratedReferenceRendering[(arrayOfString = (str = EnumeratedReferenceRepository.getType(paramString)).split(":")).length];
/*     */     
/*     */     int[] arrayOfInt;
/*     */     
/*  73 */     if ((arrayOfInt = this.enumeratedReferenceOrdinals.get(paramString)) == null) {
/*  74 */       arrayOfInt = EMPTY_ORDINALS;
/*     */     }
/*     */     
/*  77 */     int i = arrayOfString.length;
/*  78 */     for (byte b = 0; b < i; b++) {
/*  79 */       String str1 = arrayOfString[b];
/*  80 */       EnumeratedReferenceBlock enumeratedReferenceBlock = (EnumeratedReferenceBlock)this.referenceRepository.get(str1);
/*  81 */       boolean bool = (b < arrayOfInt.length) ? arrayOfInt[b] : false;
/*  82 */       arrayOfEnumeratedReferenceRendering[b] = new EnumeratedReferenceRendering(enumeratedReferenceBlock, str1, bool);
/*     */     } 
/*     */     
/*  85 */     return arrayOfEnumeratedReferenceRendering;
/*     */   }
/*     */   
/*     */   public void renderReferenceOrdinals(String paramString, EnumeratedOrdinalRenderer paramEnumeratedOrdinalRenderer) {
/*     */     EnumeratedReferenceRendering[] arrayOfEnumeratedReferenceRendering;
/*  90 */     renderReferenceOrdinals(arrayOfEnumeratedReferenceRendering = getEnumeratedReferenceOrdinals(paramString), paramEnumeratedOrdinalRenderer);
/*     */   }
/*     */   
/*     */   public static void renderReferenceOrdinals(EnumeratedReferenceRendering[] paramArrayOfEnumeratedReferenceRendering, EnumeratedOrdinalRenderer paramEnumeratedOrdinalRenderer) {
/*  94 */     paramEnumeratedOrdinalRenderer.startRendering(paramArrayOfEnumeratedReferenceRendering);
/*     */ 
/*     */     
/*  97 */     ArrayList<CompoundEnumeratedReferenceRendering> arrayList = new ArrayList();
/*     */     
/*  99 */     EnumeratedReferenceRendering enumeratedReferenceRendering = paramArrayOfEnumeratedReferenceRendering[paramArrayOfEnumeratedReferenceRendering.length - 1]; int j;
/*     */     byte b;
/* 101 */     for (j = (paramArrayOfEnumeratedReferenceRendering = paramArrayOfEnumeratedReferenceRendering).length, b = 0; b < j; b++) {
/* 102 */       EnumeratedReferenceRendering enumeratedReferenceRendering1; int k = (enumeratedReferenceRendering1 = paramArrayOfEnumeratedReferenceRendering[b]).referenceOrdinal;
/*     */       
/* 104 */       String str = enumeratedReferenceRendering1.referenceType;
/*     */       
/* 106 */       boolean bool = false;
/*     */       
/* 108 */       if (enumeratedReferenceRendering1 != enumeratedReferenceRendering) {
/* 109 */         if (enumeratedReferenceRendering1.referenceFormat != null) {
/* 110 */           Node node = enumeratedReferenceRendering1.referenceFormat.getLastChild();
/* 111 */           while (node != null && !(node instanceof EnumeratedReferenceBase)) {
/* 112 */             node = node.getLastChild();
/*     */           }
/* 114 */           boolean bool1 = (node instanceof EnumeratedReferenceBase && ((EnumeratedReferenceBase)node).getText().isEmpty()) ? true : false;
/*     */         } else {
/* 116 */           bool = true;
/*     */         } 
/*     */       }
/*     */       
/* 120 */       arrayList.add(new CompoundEnumeratedReferenceRendering(k, enumeratedReferenceRendering1.referenceFormat, str, bool));
/*     */     } 
/*     */     
/* 123 */     int i = arrayList.size() - 1;
/* 124 */     Runnable runnable = paramEnumeratedOrdinalRenderer.getEnumOrdinalRunnable();
/*     */     
/* 126 */     paramEnumeratedOrdinalRenderer.setEnumOrdinalRunnable(() -> {
/*     */           for (byte b = 0; b < paramInt; b++) {
/*     */             CompoundEnumeratedReferenceRendering compoundEnumeratedReferenceRendering = paramArrayList.get(b);
/*     */             
/*     */             Runnable runnable = paramEnumeratedOrdinalRenderer.getEnumOrdinalRunnable();
/*     */             paramEnumeratedOrdinalRenderer.setEnumOrdinalRunnable(null);
/*     */             paramEnumeratedOrdinalRenderer.render(compoundEnumeratedReferenceRendering.ordinal, compoundEnumeratedReferenceRendering.referenceFormat, compoundEnumeratedReferenceRendering.defaultText, compoundEnumeratedReferenceRendering.needSeparator);
/*     */             paramEnumeratedOrdinalRenderer.setEnumOrdinalRunnable(runnable);
/*     */           } 
/*     */         });
/* 136 */     CompoundEnumeratedReferenceRendering compoundEnumeratedReferenceRendering = arrayList.get(i);
/* 137 */     paramEnumeratedOrdinalRenderer.render(compoundEnumeratedReferenceRendering.ordinal, compoundEnumeratedReferenceRendering.referenceFormat, compoundEnumeratedReferenceRendering.defaultText, compoundEnumeratedReferenceRendering.needSeparator);
/* 138 */     paramEnumeratedOrdinalRenderer.setEnumOrdinalRunnable(runnable);
/*     */     
/* 140 */     paramEnumeratedOrdinalRenderer.endRendering();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\EnumeratedReferences.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */