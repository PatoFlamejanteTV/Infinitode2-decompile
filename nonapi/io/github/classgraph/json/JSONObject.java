/*     */ package nonapi.io.github.classgraph.json;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ class JSONObject
/*     */ {
/*     */   List<Map.Entry<String, Object>> items;
/*     */   CharSequence objectId;
/*     */   
/*     */   public JSONObject(int paramInt) {
/*  51 */     this.items = new ArrayList<>(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JSONObject(List<Map.Entry<String, Object>> paramList) {
/*  61 */     this.items = paramList;
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
/*     */   void toJSONString(Map<ReferenceEqualityKey<JSONReference>, CharSequence> paramMap, boolean paramBoolean, int paramInt1, int paramInt2, StringBuilder paramStringBuilder) {
/*     */     byte b1;
/*  81 */     boolean bool = (paramInt2 > 0) ? true : false;
/*  82 */     int i = this.items.size();
/*     */     
/*  84 */     if (paramBoolean) {
/*  85 */       b1 = i;
/*     */     } else {
/*  87 */       b1 = 0;
/*  88 */       for (Iterator<Map.Entry<String, Object>> iterator = this.items.iterator(); iterator.hasNext();) {
/*  89 */         if ((entry = iterator.next()).getValue() != null) {
/*  90 */           b1++;
/*     */         }
/*     */       } 
/*     */     } 
/*  94 */     if (this.objectId == null && b1 == 0) {
/*  95 */       paramStringBuilder.append("{}"); return;
/*     */     } 
/*  97 */     paramStringBuilder.append(bool ? "{\n" : "{");
/*  98 */     if (this.objectId != null) {
/*     */ 
/*     */       
/* 101 */       if (bool) {
/* 102 */         JSONUtils.indent(paramInt1 + 1, paramInt2, paramStringBuilder);
/*     */       }
/* 104 */       paramStringBuilder.append('"');
/* 105 */       paramStringBuilder.append("__ID");
/* 106 */       paramStringBuilder.append(bool ? "\": " : "\":");
/* 107 */       JSONSerializer.jsonValToJSONString(this.objectId, paramMap, paramBoolean, paramInt1 + 1, paramInt2, paramStringBuilder);
/*     */       
/* 109 */       if (b1 > 0) {
/* 110 */         paramStringBuilder.append(',');
/*     */       }
/* 112 */       if (bool) {
/* 113 */         paramStringBuilder.append('\n');
/*     */       }
/*     */     } 
/* 116 */     for (byte b2 = 0, b3 = 0; b2 < i; b2++) {
/*     */       Map.Entry<?, Object> entry;
/*     */       Object object;
/* 119 */       if ((object = (entry = this.items.get(b2)).getValue()) != null || paramBoolean) {
/*     */         String str;
/* 121 */         if ((str = (String)entry.getKey()) == null)
/*     */         {
/*     */           
/* 124 */           throw new IllegalArgumentException("Cannot serialize JSON object with null key");
/*     */         }
/* 126 */         if (bool) {
/* 127 */           JSONUtils.indent(paramInt1 + 1, paramInt2, paramStringBuilder);
/*     */         }
/* 129 */         paramStringBuilder.append('"');
/* 130 */         JSONUtils.escapeJSONString(str, paramStringBuilder);
/* 131 */         paramStringBuilder.append(bool ? "\": " : "\":");
/* 132 */         JSONSerializer.jsonValToJSONString(object, paramMap, paramBoolean, paramInt1 + 1, paramInt2, paramStringBuilder);
/*     */         
/* 134 */         if (++b3 < b1) {
/* 135 */           paramStringBuilder.append(',');
/*     */         }
/* 137 */         if (bool) {
/* 138 */           paramStringBuilder.append('\n');
/*     */         }
/*     */       } 
/*     */     } 
/* 142 */     if (bool) {
/* 143 */       JSONUtils.indent(paramInt1, paramInt2, paramStringBuilder);
/*     */     }
/* 145 */     paramStringBuilder.append('}');
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\JSONObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */