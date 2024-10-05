/*     */ package nonapi.io.github.classgraph.json;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReferenceEqualityKey<K>
/*     */ {
/*     */   private final K wrappedKey;
/*     */   
/*     */   public ReferenceEqualityKey(K paramK) {
/*  50 */     this.wrappedKey = paramK;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K get() {
/*  59 */     return this.wrappedKey;
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
/*     */   public int hashCode() {
/*     */     K k;
/*  75 */     return ((k = this.wrappedKey) == null) ? 0 : System.identityHashCode(k);
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
/*     */   public boolean equals(Object paramObject) {
/*  90 */     if (paramObject == this)
/*  91 */       return true; 
/*  92 */     if (!(paramObject instanceof ReferenceEqualityKey)) {
/*  93 */       return false;
/*     */     }
/*  95 */     return (this.wrappedKey == ((ReferenceEqualityKey)paramObject).wrappedKey);
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
/*     */   public String toString() {
/*     */     K k;
/* 109 */     return ((k = this.wrappedKey) == null) ? "null" : k.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\ReferenceEqualityKey.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */