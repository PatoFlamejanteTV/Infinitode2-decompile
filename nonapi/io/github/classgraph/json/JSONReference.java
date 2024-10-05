/*    */ package nonapi.io.github.classgraph.json;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class JSONReference
/*    */ {
/*    */   Object idObject;
/*    */   
/*    */   public JSONReference(Object paramObject) {
/* 43 */     if (paramObject == null) {
/* 44 */       throw new IllegalArgumentException("idObject cannot be null");
/*    */     }
/* 46 */     this.idObject = paramObject;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\JSONReference.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */