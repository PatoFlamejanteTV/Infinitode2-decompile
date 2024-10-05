/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class STBRectPack
/*     */ {
/*     */   public static final int STBRP__MAXVAL = 2147483647;
/*     */   public static final int STBRP_HEURISTIC_Skyline_default = 0;
/*     */   public static final int STBRP_HEURISTIC_Skyline_BL_sortHeight = 0;
/*     */   public static final int STBRP_HEURISTIC_Skyline_BF_sortHeight = 1;
/*     */   
/*     */   static {
/*  20 */     LibSTB.initialize();
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
/*     */ 
/*     */   
/*     */   protected STBRectPack() {
/*  42 */     throw new UnsupportedOperationException();
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
/*     */   public static int stbrp_pack_rects(@NativeType("stbrp_context *") STBRPContext paramSTBRPContext, @NativeType("stbrp_rect *") STBRPRect.Buffer paramBuffer) {
/*  75 */     return nstbrp_pack_rects(paramSTBRPContext.address(), paramBuffer.address(), paramBuffer.remaining());
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
/*     */   public static void stbrp_init_target(@NativeType("stbrp_context *") STBRPContext paramSTBRPContext, int paramInt1, int paramInt2, @NativeType("stbrp_node *") STBRPNode.Buffer paramBuffer) {
/* 114 */     nstbrp_init_target(paramSTBRPContext.address(), paramInt1, paramInt2, paramBuffer.address(), paramBuffer.remaining());
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
/*     */   public static void stbrp_setup_allow_out_of_mem(@NativeType("stbrp_context *") STBRPContext paramSTBRPContext, @NativeType("int") boolean paramBoolean) {
/* 130 */     nstbrp_setup_allow_out_of_mem(paramSTBRPContext.address(), paramBoolean ? 1 : 0);
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
/*     */   public static void stbrp_setup_heuristic(@NativeType("stbrp_context *") STBRPContext paramSTBRPContext, int paramInt) {
/* 146 */     nstbrp_setup_heuristic(paramSTBRPContext.address(), paramInt);
/*     */   }
/*     */   
/*     */   public static native int nstbrp_pack_rects(long paramLong1, long paramLong2, int paramInt);
/*     */   
/*     */   public static native void nstbrp_init_target(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
/*     */   
/*     */   public static native void nstbrp_setup_allow_out_of_mem(long paramLong, int paramInt);
/*     */   
/*     */   public static native void nstbrp_setup_heuristic(long paramLong, int paramInt);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBRectPack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */