/*    */ package com.prineside.tdi2.utils.syncchecker;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.StringBuilder;
/*    */ import java.util.IdentityHashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class DeepClassComparisonConfig {
/* 11 */   final Array<String> a = new Array(true, 1, String.class);
/*    */   
/* 13 */   public final StringBuilder sb = new StringBuilder();
/*    */   
/* 15 */   public int depth = 8;
/* 16 */   public final IdentityHashMap<Object, Set<Object>> comparesMap = new IdentityHashMap<>();
/*    */   
/*    */   public boolean debug;
/*    */   public Enum<?>[] keyEnum;
/*    */   
/*    */   public StringBuilder appendPrefix() {
/* 22 */     for (byte b = 0; b < this.a.size; b++) {
/* 23 */       this.sb.append(((String[])this.a.items)[b]);
/*    */     }
/*    */     
/* 26 */     return this.sb;
/*    */   }
/*    */   
/*    */   public DeepClassComparisonConfig addPrefix(String... paramVarArgs) {
/* 30 */     this.a.addAll((Object[])paramVarArgs);
/*    */     
/* 32 */     return this;
/*    */   }
/*    */   
/*    */   public void popPrefix(int paramInt) {
/* 36 */     this.a.removeRange(this.a.size - paramInt, this.a.size - 1);
/*    */   }
/*    */   
/*    */   public void free() {
/* 40 */     for (Iterator<Map.Entry> iterator = this.comparesMap.entrySet().iterator(); iterator.hasNext();) {
/*    */       
/* 42 */       if ((set = (entry = iterator.next()).getValue()) != null) {
/* 43 */         SyncChecker.a.free(set);
/*    */       }
/*    */     } 
/* 46 */     this.comparesMap.clear();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\DeepClassComparisonConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */