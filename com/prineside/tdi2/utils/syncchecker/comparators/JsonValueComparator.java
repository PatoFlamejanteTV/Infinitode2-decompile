/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.badlogic.gdx.utils.JsonWriter;
/*    */ import com.badlogic.gdx.utils.StringBuilder;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class JsonValueComparator extends DeepClassComparator<JsonValue> {
/*    */   public final Class<JsonValue> forClass() {
/* 11 */     return JsonValue.class;
/*    */   }
/*    */   
/*    */   public final void compare(JsonValue paramJsonValue1, JsonValue paramJsonValue2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 15 */     if (paramJsonValue1 == null && paramJsonValue2 != null) {
/* 16 */       paramDeepClassComparisonConfig.appendPrefix().append(": first object is null\n"); return;
/* 17 */     }  if (paramJsonValue1 != null && paramJsonValue2 == null) {
/* 18 */       paramDeepClassComparisonConfig.appendPrefix().append(": second object is null\n"); return;
/* 19 */     }  if (paramJsonValue1 != null)
/*    */     {
/* 21 */       if (!paramJsonValue1.toJson(JsonWriter.OutputType.minimal).equals(paramJsonValue2.toJson(JsonWriter.OutputType.minimal))) {
/*    */         StringBuilder stringBuilder;
/* 23 */         (stringBuilder = paramDeepClassComparisonConfig.appendPrefix().append(": json contents do not match\n")).append(paramJsonValue1.toJson(JsonWriter.OutputType.minimal)).append("\n");
/* 24 */         stringBuilder.append(paramJsonValue2.toJson(JsonWriter.OutputType.minimal)).append("\n");
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\JsonValueComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */