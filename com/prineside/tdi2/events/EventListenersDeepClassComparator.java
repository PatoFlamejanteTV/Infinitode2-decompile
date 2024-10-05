/*    */ package com.prineside.tdi2.events;
/*    */ 
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*    */ 
/*    */ public final class EventListenersDeepClassComparator
/*    */   extends DeepClassComparator<EventListeners> {
/*    */   public final Class<EventListeners> forClass() {
/* 10 */     return EventListeners.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(EventListeners paramEventListeners1, EventListeners paramEventListeners2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 15 */     paramDeepClassComparisonConfig.addPrefix(new String[] { ".entries" });
/*    */     
/* 17 */     byte b1 = 0; byte b2;
/* 18 */     for (b2 = 0; b2 < paramEventListeners1.size(); b2++) {
/*    */       EventListeners.Entry<T> entry;
/* 20 */       if ((entry = paramEventListeners1.getEntriesBackingArray()[b2]) != null && 
/* 21 */         entry.isStateAffecting()) {
/* 22 */         b1++;
/*    */       }
/*    */     } 
/* 25 */     b2 = 0; byte b3;
/* 26 */     for (b3 = 0; b3 < paramEventListeners2.size(); b3++) {
/*    */       EventListeners.Entry<T> entry;
/* 28 */       if ((entry = paramEventListeners2.getEntriesBackingArray()[b3]) != null && 
/* 29 */         entry.isStateAffecting()) {
/* 30 */         b2++;
/*    */       }
/*    */     } 
/* 33 */     if (b1 != b2) {
/* 34 */       paramDeepClassComparisonConfig.appendPrefix().append(": entry count differ (").append(b1).append(", ").append(b2).append(")\no1: ").append(paramEventListeners1.describe()).append("\no2: ").append(paramEventListeners2.describe());
/*    */     } else {
/* 36 */       b3 = 0;
/* 37 */       byte b4 = 0;
/* 38 */       EventListeners.Entry[] arrayOfEntry1 = paramEventListeners1.getEntriesBackingArray();
/* 39 */       EventListeners.Entry[] arrayOfEntry2 = paramEventListeners2.getEntriesBackingArray();
/* 40 */       for (byte b5 = 0; b5 < paramEventListeners1.size(); b5++) {
/*    */         EventListeners.Entry entry;
/* 42 */         if ((entry = arrayOfEntry1[b5]) != null && entry.isStateAffecting()) {
/*    */           
/* 44 */           EventListeners.Entry entry1 = null;
/* 45 */           while (b3 < paramEventListeners2.size()) {
/* 46 */             EventListeners.Entry entry2 = arrayOfEntry2[b3];
/* 47 */             b3++;
/*    */             
/* 49 */             if (entry2 != null && entry2.isStateAffecting()) {
/* 50 */               entry1 = entry2;
/*    */ 
/*    */               
/*    */               break;
/*    */             } 
/*    */           } 
/*    */           
/* 57 */           paramDeepClassComparisonConfig.addPrefix(new String[] { "[", SyncChecker.toString(b4), "]" });
/* 58 */           if (entry1 == null) {
/* 59 */             paramDeepClassComparisonConfig.appendPrefix().append(": state affecting listener not exists in the second group (").append(entry).append(")\no1: ").append(paramEventListeners1.describe()).append("\no2: ").append(paramEventListeners2.describe());
/*    */           } else {
/* 61 */             SyncChecker.compareObjects(entry, entry1, paramDeepClassComparisonConfig);
/*    */           } 
/* 63 */           paramDeepClassComparisonConfig.popPrefix(3);
/* 64 */           b4++;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 69 */     paramDeepClassComparisonConfig.popPrefix(1);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\EventListenersDeepClassComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */