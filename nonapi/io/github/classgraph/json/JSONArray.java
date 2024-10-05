/*     */ package nonapi.io.github.classgraph.json;
/*     */ 
/*     */ import java.util.ArrayList;
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
/*     */ class JSONArray
/*     */ {
/*     */   List<Object> items;
/*     */   
/*     */   public JSONArray() {
/*  44 */     this.items = new ArrayList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JSONArray(List<Object> paramList) {
/*  54 */     this.items = paramList;
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
/*     */   void toJSONString(Map<ReferenceEqualityKey<JSONReference>, CharSequence> paramMap, boolean paramBoolean, int paramInt1, int paramInt2, StringBuilder paramStringBuilder) {
/*  74 */     boolean bool = (paramInt2 > 0) ? true : false;
/*     */     int i;
/*  76 */     if ((i = this.items.size()) == 0) {
/*  77 */       paramStringBuilder.append("[]"); return;
/*     */     } 
/*  79 */     paramStringBuilder.append('[');
/*  80 */     if (bool) {
/*  81 */       paramStringBuilder.append('\n');
/*     */     }
/*  83 */     for (byte b = 0; b < i; b++) {
/*  84 */       Object object = this.items.get(b);
/*  85 */       if (bool) {
/*  86 */         JSONUtils.indent(paramInt1 + 1, paramInt2, paramStringBuilder);
/*     */       }
/*  88 */       JSONSerializer.jsonValToJSONString(object, paramMap, paramBoolean, paramInt1 + 1, paramInt2, paramStringBuilder);
/*     */       
/*  90 */       if (b < i - 1) {
/*  91 */         paramStringBuilder.append(',');
/*     */       }
/*  93 */       if (bool) {
/*  94 */         paramStringBuilder.append('\n');
/*     */       }
/*     */     } 
/*  97 */     if (bool) {
/*  98 */       JSONUtils.indent(paramInt1, paramInt2, paramStringBuilder);
/*     */     }
/* 100 */     paramStringBuilder.append(']');
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\JSONArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */