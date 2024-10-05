/*    */ package nonapi.io.github.classgraph.recycler;
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
/*    */ public class RecycleOnClose<T, E extends Exception>
/*    */   implements AutoCloseable
/*    */ {
/*    */   private final Recycler<T, E> recycler;
/*    */   private final T instance;
/*    */   
/*    */   RecycleOnClose(Recycler<T, E> paramRecycler, T paramT) {
/* 59 */     this.recycler = paramRecycler;
/* 60 */     this.instance = paramT;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T get() {
/* 69 */     return this.instance;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() {
/* 75 */     this.recycler.recycle(this.instance);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\recycler\RecycleOnClose.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */