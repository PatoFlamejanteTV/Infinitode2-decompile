/*    */ package org.lwjgl.system;public final class JNI { public static native byte invokePB(long paramLong1, long paramLong2); public static native short invokeC(long paramLong); public static native short invokeC(int paramInt, long paramLong); public static native short invokePC(long paramLong1, long paramLong2); public static native short invokeCC(int paramInt, short paramShort, long paramLong); public static native short invokeCC(short paramShort, boolean paramBoolean, long paramLong); public static native short invokeJC(int paramInt1, int paramInt2, long paramLong1, long paramLong2); public static native short invokeCUC(short paramShort, byte paramByte, long paramLong); public static native short invokePCC(long paramLong1, short paramShort, long paramLong2); public static native short invokeCCC(short paramShort1, short paramShort2, boolean paramBoolean, long paramLong); public static native short invokePCC(int paramInt, long paramLong1, short paramShort, long paramLong2); public static native short invokePCC(long paramLong1, int paramInt, short paramShort, long paramLong2); public static native short invokeUPC(byte paramByte, long paramLong1, boolean paramBoolean, long paramLong2); public static native short invokeCJC(int paramInt1, boolean paramBoolean, short paramShort, int paramInt2, long paramLong1, long paramLong2); public static native short invokeCPCC(short paramShort1, long paramLong1, short paramShort2, long paramLong2); public static native short invokePPCC(long paramLong1, long paramLong2, short paramShort, long paramLong3); public static native short invokeCCJC(short paramShort1, short paramShort2, int paramInt, long paramLong1, long paramLong2); public static native short invokePCCC(long paramLong1, short paramShort1, short paramShort2, int paramInt1, int paramInt2, long paramLong2); public static native short invokeCCCCC(short paramShort1, short paramShort2, short paramShort3, short paramShort4, long paramLong); public static native short invokePJUPC(long paramLong1, long paramLong2, byte paramByte, long paramLong3, long paramLong4); public static native short invokeCCJPC(short paramShort1, boolean paramBoolean, short paramShort2, int paramInt, long paramLong1, long paramLong2, long paramLong3); public static native short invokePCCCCC(long paramLong1, short paramShort1, short paramShort2, short paramShort3, short paramShort4, long paramLong2); public static native short invokeCCCJPC(short paramShort1, short paramShort2, short paramShort3, boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, long paramLong3); public static native short invokeCCCJPC(short paramShort1, short paramShort2, boolean paramBoolean, short paramShort3, int paramInt, long paramLong1, long paramLong2, long paramLong3); public static native double invokeD(long paramLong); public static native double invokeD(int paramInt, long paramLong); public static native double invokePD(long paramLong1, long paramLong2); public static native double invokePD(long paramLong1, int paramInt, long paramLong2); public static native double invokePD(long paramLong1, int paramInt1, int paramInt2, long paramLong2); public static native double invokePPD(long paramLong1, long paramLong2, long paramLong3); public static native float invokeF(int paramInt, long paramLong); public static native float invokePF(long paramLong1, long paramLong2); public static native float invokePF(long paramLong1, int paramInt, long paramLong2); public static native float invokePF(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2); public static native float invokePF(long paramLong1, int paramInt1, int paramInt2, long paramLong2); public static native float invokePPF(long paramLong1, long paramLong2, long paramLong3); public static native float invokePPF(long paramLong1, int paramInt, long paramLong2, long paramLong3); public static native float invokePPF(long paramLong1, float paramFloat, long paramLong2, int paramInt, long paramLong3); public static native int invokeI(long paramLong); public static native int invokeI(int paramInt, long paramLong); public static native int invokeI(boolean paramBoolean, long paramLong); public static native int invokeI(int paramInt1, int paramInt2, long paramLong); public static native int invokeI(int paramInt, boolean paramBoolean, long paramLong); public static native int invokeI(int paramInt1, int paramInt2, int paramInt3, long paramLong); public static native int invokePI(long paramLong1, long paramLong2); public static native int invokeCI(int paramInt, short paramShort, long paramLong); public static native int invokePI(int paramInt, long paramLong1, long paramLong2); public static native int invokePI(long paramLong1, int paramInt, long paramLong2); public static native int invokePI(long paramLong1, int paramInt1, int paramInt2, long paramLong2); public static native int invokePI(long paramLong1, int paramInt, boolean paramBoolean, long paramLong2); public static native int invokePI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2); public static native int invokeCPI(short paramShort, long paramLong1, long paramLong2); public static native int invokePCI(long paramLong1, short paramShort, long paramLong2); public static native int invokePJI(long paramLong1, long paramLong2, long paramLong3); public static native int invokePNI(long paramLong1, long paramLong2, long paramLong3); public static native int invokePPI(long paramLong1, long paramLong2, long paramLong3); public static native int invokePJI(long paramLong1, long paramLong2, int paramInt, long paramLong3); public static native int invokePNI(long paramLong1, int paramInt, long paramLong2, long paramLong3); public static native int invokePNI(long paramLong1, long paramLong2, int paramInt, long paramLong3); public static native int invokePPI(int paramInt, long paramLong1, long paramLong2, long paramLong3); public static native int invokePPI(long paramLong1, int paramInt, long paramLong2, long paramLong3); public static native int invokePPI(long paramLong1, long paramLong2, float paramFloat, long paramLong3); public static native int invokePPI(long paramLong1, long paramLong2, int paramInt, long paramLong3); public static native int invokePPI(long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3); public static native int invokePPI(long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3); public static native int invokePPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3); public static native int invokePPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*    */   public static native int invokePPI(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean, long paramLong3);
/*    */   public static native int invokePPI(long paramLong1, int paramInt, boolean paramBoolean, long paramLong2, long paramLong3);
/*    */   public static native int invokePPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*    */   public static native int invokePPI(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, long paramLong3);
/*    */   public static native int invokePPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3);
/*    */   public static native int invokePPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, long paramLong3);
/*    */   public static native int invokePPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long paramLong3);
/*    */   public static native int invokePPI(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, boolean paramBoolean, long paramLong3);
/*    */   public static native int invokePPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, long paramLong3);
/*    */   public static native int invokePPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, int paramInt5, long paramLong3);
/*    */   public static native int invokeCPUI(short paramShort, long paramLong1, byte paramByte, long paramLong2);
/*    */   public static native int invokePCPI(long paramLong1, short paramShort, long paramLong2, long paramLong3);
/*    */   public static native int invokePNNI(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   public static native int invokePNPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   public static native int invokePPCI(long paramLong1, long paramLong2, short paramShort, long paramLong3);
/*    */   public static native int invokePPJI(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   public static native int invokePPNI(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   public static native int invokePNPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   public static native int invokePNPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   public static native int invokePPNI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   public static native int invokePNNI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4);
/*    */   public static native int invokePPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, long paramLong4);
/*    */   static {
/* 36 */     Library.initialize();
/*    */   }
/*    */   
/*    */   public static native int invokePPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, int paramInt3, long paramLong4);
/*    */   
/*    */   public static native int invokePPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean, float paramFloat, long paramLong4);
/*    */   
/*    */   public static native int invokePPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int invokePPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, int paramInt4, long paramLong4);
/*    */   
/*    */   public static native int invokePPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, long paramLong3, int paramInt4, int paramInt5, long paramLong4);
/*    */   
/*    */   public static native int invokePNPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPNNI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPNPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPNI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePNNPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPNI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int paramInt2, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, int paramInt3, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, long paramLong3, long paramLong4, int paramInt4, int paramInt5, long paramLong5);
/*    */   
/*    */   public static native int invokePNNPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPNNPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPNNI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPNI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePJPPNI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPNPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPNPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPNJI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPNNI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPNPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPNI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPNI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, long paramLong6);
/*    */   
/*    */   public static native int invokePNPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4, int paramInt3, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, float paramFloat, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int invokePPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int invokePJJJJPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int invokePPNPPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int invokePPPPPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int invokePPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt, long paramLong7);
/*    */   
/*    */   public static native int invokePNNPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int invokePPPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int invokePPPPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, float paramFloat1, float paramFloat2, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native int invokePPPPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4, long paramLong5, int paramInt3, long paramLong6, int paramInt4, long paramLong7, int paramInt5, long paramLong8);
/*    */   
/*    */   public static native int invokePPPPPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native long invokeJ(long paramLong);
/*    */   
/*    */   public static native long invokePJ(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long invokePJ(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native long invokePJJ(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePPJ(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePPJ(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native long invokeNN(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long invokePN(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long invokePN(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native long invokeNNN(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePPN(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokeNNNN(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePNPN(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePNPN(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native long invokePPNN(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePNPNN(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePNPNPN(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long invokeP(long paramLong);
/*    */   
/*    */   public static native long invokeP(int paramInt, long paramLong);
/*    */   
/*    */   public static native long invokeP(boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native long invokeP(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native long invokeCP(short paramShort, long paramLong);
/*    */   
/*    */   public static native long invokePP(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long invokePP(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long invokePP(long paramLong1, double paramDouble, long paramLong2);
/*    */   
/*    */   public static native long invokePP(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native long invokePP(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long invokePP(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native long invokePP(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long invokePP(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native long invokePP(long paramLong1, float paramFloat1, int paramInt1, float paramFloat2, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native long invokePP(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong2);
/*    */   
/*    */   public static native long invokeCPP(short paramShort, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long invokePJP(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePNP(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePPP(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePUP(long paramLong1, byte paramByte, long paramLong2);
/*    */   
/*    */   public static native long invokeCPP(int paramInt, short paramShort, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long invokePCP(long paramLong1, short paramShort, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native long invokePJP(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePJP(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native long invokePPP(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePPP(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePPP(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native long invokePPP(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePPP(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native long invokePPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native long invokePPP(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, long paramLong3);
/*    */   
/*    */   public static native long invokePPP(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePPP(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePPP(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePUP(long paramLong1, int paramInt1, byte paramByte, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, long paramLong2);
/*    */   
/*    */   public static native long invokePPP(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePJJP(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePPUP(long paramLong1, long paramLong2, byte paramByte, long paramLong3);
/*    */   
/*    */   public static native long invokePPPP(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native long invokePPUP(long paramLong1, long paramLong2, int paramInt, byte paramByte, long paramLong3);
/*    */   
/*    */   public static native long invokePPPP(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native long invokeJPPP(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int paramInt3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int paramInt3, int paramInt4, long paramLong4);
/*    */   
/*    */   public static native long invokePBPPP(long paramLong1, byte paramByte, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long invokePNNPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePPJPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePPNNP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePPPJP(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePPPJP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPP(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5);
/*    */   
/*    */   public static native long invokePJPPP(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePJPPP(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int paramInt2, long paramLong5);
/*    */   
/*    */   public static native long invokePPPJP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPP(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, int paramInt3, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPP(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, int paramInt4, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePJPJPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long invokePNNNPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long invokePPBPPP(long paramLong1, long paramLong2, byte paramByte, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long invokePPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long invokeCCCUJP(short paramShort1, short paramShort2, short paramShort3, byte paramByte, int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long invokePPPPNP(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long invokePPPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long invokePPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long invokePPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, long paramLong6);
/*    */   
/*    */   public static native long invokePPJPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long invokePPPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long invokePPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, long paramLong5, int paramInt2, long paramLong6);
/*    */   
/*    */   public static native long invokePPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong6);
/*    */   
/*    */   public static native long invokePPJJPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native long invokePPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native long invokePSSCCPP(long paramLong1, short paramShort1, short paramShort2, short paramShort3, short paramShort4, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long invokePPPPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native long invokePPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native long invokePPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt, long paramLong7);
/*    */   
/*    */   public static native long invokePPPPPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native long invokePPPPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native long invokePPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, long paramLong6, int paramInt2, long paramLong7);
/*    */   
/*    */   public static native long invokePPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, long paramLong5, int paramInt2, long paramLong6, int paramInt3, int paramInt4, long paramLong7);
/*    */   
/*    */   public static native long invokePPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, long paramLong6, int paramInt2, int paramInt3, int paramInt4, long paramLong7);
/*    */   
/*    */   public static native long invokePPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native long invokePPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, long paramLong5, long paramLong6, long paramLong7, int paramInt2, long paramLong8);
/*    */   
/*    */   public static native long invokePPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, long paramLong6, int paramInt2, long paramLong7, int paramInt3, long paramLong8);
/*    */   
/*    */   public static native long invokePPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native long invokePPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native long invokePPPPJJPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, long paramLong5, int paramInt2, long paramLong6, int paramInt3, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native long invokePPPPPJJPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, long paramLong6, int paramInt2, long paramLong7, int paramInt3, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native long invokePPPPPJPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, long paramLong6, int paramInt2, long paramLong7, int paramInt3, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native long invokePPPPPJPPP(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, int paramInt3, long paramLong6, int paramInt4, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native long invokePPPPPJPPP(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, int paramInt3, long paramLong6, int paramInt4, int paramInt5, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native long invokePPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt1, long paramLong8, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong9);
/*    */   
/*    */   public static native long invokePPPPPJJJPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, long paramLong6, long paramLong7, long paramLong8, int paramInt2, long paramLong9, long paramLong10);
/*    */   
/*    */   public static native long invokePPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, long paramLong5, long paramLong6, long paramLong7, long paramLong8, int paramInt2, long paramLong9, long paramLong10);
/*    */   
/*    */   public static native long invokePPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt1, long paramLong8, int paramInt2, long paramLong9, int paramInt3, long paramLong10);
/*    */   
/*    */   public static native long invokePPPPPJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, long paramLong6, int paramInt2, int paramInt3, long paramLong7, int paramInt4, int paramInt5, long paramLong8, long paramLong9, long paramLong10);
/*    */   
/*    */   public static native long invokePPPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11);
/*    */   
/*    */   public static native long invokePPPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt1, long paramLong8, int paramInt2, long paramLong9, long paramLong10, int paramInt3, long paramLong11);
/*    */   
/*    */   public static native long invokePPPPPJPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, long paramLong6, int paramInt2, int paramInt3, long paramLong7, long paramLong8, int paramInt4, int paramInt5, long paramLong9, long paramLong10, long paramLong11, long paramLong12);
/*    */   
/*    */   public static native long invokePPPPPPPPPPPPP(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2, long paramLong5, long paramLong6, int paramInt3, long paramLong7, long paramLong8, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong9, long paramLong10, long paramLong11, long paramLong12, long paramLong13);
/*    */   
/*    */   public static native long invokePPPPPJJPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, long paramLong6, int paramInt2, long paramLong7, int paramInt3, long paramLong8, long paramLong9, int paramInt4, long paramLong10, long paramLong11, long paramLong12, long paramLong13, long paramLong14);
/*    */   
/*    */   public static native byte invokeU(int paramInt, long paramLong);
/*    */   
/*    */   public static native byte invokeUPU(byte paramByte, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokeV(long paramLong);
/*    */   
/*    */   public static native void invokeV(double paramDouble, long paramLong);
/*    */   
/*    */   public static native void invokeV(float paramFloat, long paramLong);
/*    */   
/*    */   public static native void invokeV(int paramInt, long paramLong);
/*    */   
/*    */   public static native void invokeV(int paramInt, float paramFloat, long paramLong);
/*    */   
/*    */   public static native void invokeV(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void invokeV(int paramInt1, int paramInt2, double paramDouble, long paramLong);
/*    */   
/*    */   public static native void invokeV(int paramInt1, int paramInt2, float paramFloat, long paramLong);
/*    */   
/*    */   public static native void invokeV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void invokeV(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
/*    */   
/*    */   public static native void invokeV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*    */   
/*    */   public static native void invokeV(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3, long paramLong);
/*    */   
/*    */   public static native void invokeV(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
/*    */   
/*    */   public static native void invokeV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*    */   
/*    */   public static native void invokeCV(short paramShort, long paramLong);
/*    */   
/*    */   public static native void invokePV(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokeUV(byte paramByte, long paramLong);
/*    */   
/*    */   public static native void invokeCV(int paramInt, short paramShort, long paramLong);
/*    */   
/*    */   public static native void invokeCV(short paramShort, int paramInt, long paramLong);
/*    */   
/*    */   public static native void invokeCV(short paramShort, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void invokeJV(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokeJV(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void invokePV(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, float paramFloat, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native void invokeUV(byte paramByte, int paramInt, long paramLong);
/*    */   
/*    */   public static native void invokeUV(byte paramByte, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void invokeCV(short paramShort, int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void invokeJV(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokePV(int paramInt, long paramLong1, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, double paramDouble1, double paramDouble2, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, int paramInt, double paramDouble, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, int paramInt, float paramFloat, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, int paramInt, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, float paramFloat1, float paramFloat2, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, int paramInt1, int paramInt2, double paramDouble, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, int paramInt1, int paramInt2, float paramFloat, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokePV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokeCCV(short paramShort1, short paramShort2, long paramLong);
/*    */   
/*    */   public static native void invokeCPV(short paramShort, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokePCV(long paramLong1, short paramShort, long paramLong2);
/*    */   
/*    */   public static native void invokePJV(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePNV(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePUV(long paramLong1, byte paramByte, long paramLong2);
/*    */   
/*    */   public static native void invokeUPV(byte paramByte, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokeCPV(short paramShort, int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokeCPV(short paramShort, long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void invokePCV(long paramLong1, int paramInt, short paramShort, long paramLong2);
/*    */   
/*    */   public static native void invokePCV(long paramLong1, short paramShort, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native void invokePJV(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePJV(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePJV(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, long paramLong2, float paramFloat, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3);
/*    */   
/*    */   public static native void invokeUCV(byte paramByte, short paramShort, int paramInt, long paramLong);
/*    */   
/*    */   public static native void invokePBV(long paramLong1, int paramInt1, int paramInt2, byte paramByte, long paramLong2);
/*    */   
/*    */   public static native void invokePCV(long paramLong1, int paramInt1, int paramInt2, short paramShort, long paramLong2);
/*    */   
/*    */   public static native void invokePCV(long paramLong1, short paramShort, int paramInt1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void invokePPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native void invokePSV(long paramLong1, int paramInt1, int paramInt2, short paramShort, long paramLong2);
/*    */   
/*    */   public static native void invokePUV(long paramLong1, int paramInt1, int paramInt2, byte paramByte, long paramLong2);
/*    */   
/*    */   public static native void invokeUCV(byte paramByte, short paramShort, int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void invokeUPV(byte paramByte, long paramLong1, int paramInt1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void invokePCV(long paramLong1, short paramShort, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native void invokePPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, float paramFloat, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong3);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, long paramLong3);
/*    */   
/*    */   public static native void invokeCCPV(short paramShort1, short paramShort2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokeCPCV(short paramShort1, long paramLong1, short paramShort2, long paramLong2);
/*    */   
/*    */   public static native void invokeCPPV(short paramShort, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePNNV(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePNPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPNV(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokeCCCV(short paramShort1, short paramShort2, short paramShort3, int paramInt, long paramLong);
/*    */   
/*    */   public static native void invokeCCUV(short paramShort1, short paramShort2, int paramInt, byte paramByte, long paramLong);
/*    */   
/*    */   public static native void invokePJPV(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, long paramLong3, float paramFloat, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native void invokePUCV(long paramLong1, byte paramByte, short paramShort, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void invokeUCCV(byte paramByte, short paramShort1, short paramShort2, int paramInt, long paramLong);
/*    */   
/*    */   public static native void invokeCCUV(short paramShort1, short paramShort2, int paramInt, float paramFloat, byte paramByte, long paramLong);
/*    */   
/*    */   public static native void invokeJJJV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePNNV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean1, boolean paramBoolean2, long paramLong4);
/*    */   
/*    */   public static native void invokePUCV(long paramLong1, byte paramByte, short paramShort, int paramInt1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void invokePUPV(long paramLong1, byte paramByte, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native void invokeUCCV(byte paramByte, short paramShort1, int paramInt1, int paramInt2, short paramShort2, long paramLong);
/*    */   
/*    */   public static native void invokeUCUV(byte paramByte1, short paramShort, byte paramByte2, int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void invokeUPCV(byte paramByte, long paramLong1, int paramInt1, int paramInt2, short paramShort, long paramLong2);
/*    */   
/*    */   public static native void invokeCCUV(short paramShort1, short paramShort2, int paramInt1, int paramInt2, int paramInt3, byte paramByte, long paramLong);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, boolean paramBoolean, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, long paramLong3, int paramInt4, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, int paramInt4, boolean paramBoolean, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, long paramLong4);
/*    */   
/*    */   public static native void invokeCCUPV(short paramShort1, short paramShort2, byte paramByte, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokePCPCV(long paramLong1, short paramShort1, long paramLong2, short paramShort2, long paramLong3);
/*    */   
/*    */   public static native void invokePNPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokePPPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokeCCCUV(short paramShort1, short paramShort2, short paramShort3, int paramInt, byte paramByte, long paramLong);
/*    */   
/*    */   public static native void invokePCCUV(long paramLong1, short paramShort1, short paramShort2, int paramInt, byte paramByte, long paramLong2);
/*    */   
/*    */   public static native void invokePJJPV(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokePPCPV(long paramLong1, long paramLong2, short paramShort, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void invokePPPCV(long paramLong1, long paramLong2, int paramInt, long paramLong3, short paramShort, long paramLong4);
/*    */   
/*    */   public static native void invokePPPPV(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokePPPPV(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokePPPPV(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokePPPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5);
/*    */   
/*    */   public static native void invokePUCCV(long paramLong1, byte paramByte, short paramShort1, short paramShort2, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void invokePPPPV(long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokePUCCV(long paramLong1, byte paramByte, short paramShort1, int paramInt1, int paramInt2, short paramShort2, long paramLong2);
/*    */   
/*    */   public static native void invokePUCUV(long paramLong1, byte paramByte1, short paramShort, byte paramByte2, int paramInt1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void invokePUPCV(long paramLong1, byte paramByte, long paramLong2, int paramInt1, int paramInt2, short paramShort, long paramLong3);
/*    */   
/*    */   public static native void invokePCCUV(long paramLong1, short paramShort1, short paramShort2, int paramInt1, int paramInt2, int paramInt3, byte paramByte, long paramLong2);
/*    */   
/*    */   public static native void invokePPPPV(long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokePPPPV(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, float paramFloat, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokePPPPV(long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokeCCCCCV(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, long paramLong);
/*    */   
/*    */   public static native void invokeCCUPPV(short paramShort1, short paramShort2, byte paramByte, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void invokePPCPPV(long paramLong1, long paramLong2, short paramShort, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokePPPPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void invokePCCCUV(long paramLong1, short paramShort1, short paramShort2, short paramShort3, int paramInt, byte paramByte, long paramLong2);
/*    */   
/*    */   public static native void invokePPPPPV(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void invokePPPPPV(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void invokePPPPPV(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void invokePPPPPV(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void invokePCCCCV(long paramLong1, short paramShort1, short paramShort2, short paramShort3, boolean paramBoolean1, boolean paramBoolean2, short paramShort4, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void invokePPPPPV(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4, int paramInt3, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void invokePPPPPV(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int paramInt2, int paramInt3, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void invokePPPPPV(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, int paramInt3, long paramLong5, int paramInt4, boolean paramBoolean, long paramLong6);
/*    */   
/*    */   public static native void invokeCCCCCUV(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, byte paramByte, long paramLong);
/*    */   
/*    */   public static native void invokeCCCCPCV(short paramShort1, short paramShort2, short paramShort3, short paramShort4, long paramLong1, short paramShort5, long paramLong2);
/*    */   
/*    */   public static native void invokePPPPPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native void invokeCCCCCUV(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, int paramInt, byte paramByte, long paramLong);
/*    */   
/*    */   public static native void invokePCCCCUV(long paramLong1, short paramShort1, int paramInt, short paramShort2, short paramShort3, short paramShort4, byte paramByte, long paramLong2);
/*    */   
/*    */   public static native void invokePCCCCCUV(long paramLong1, short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, byte paramByte, long paramLong2);
/*    */   
/*    */   public static native void invokePPPPPPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native void invokePCCCCCUV(long paramLong1, short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, int paramInt, byte paramByte, long paramLong2);
/*    */   
/*    */   public static native void invokePPPPPPPV(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native void invokeCCCCCCUV(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, int paramInt1, short paramShort6, int paramInt2, byte paramByte, long paramLong);
/*    */   
/*    */   public static native void invokePCCCCCCUV(long paramLong1, short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, int paramInt1, short paramShort6, int paramInt2, byte paramByte, long paramLong2);
/*    */   
/*    */   public static native void invokeCCUCCCCPCV(short paramShort1, short paramShort2, byte paramByte, short paramShort3, short paramShort4, short paramShort5, short paramShort6, long paramLong1, short paramShort7, long paramLong2);
/*    */   
/*    */   public static native void invokeCUCCCCCCPV(short paramShort1, byte paramByte, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6, short paramShort7, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokeCCUUCCCCPCV(short paramShort1, short paramShort2, byte paramByte1, byte paramByte2, short paramShort3, short paramShort4, short paramShort5, short paramShort6, long paramLong1, short paramShort7, long paramLong2);
/*    */   
/*    */   public static native void invokeCCUUUUUUUUUV(short paramShort1, short paramShort2, float paramFloat, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9, long paramLong);
/*    */   
/*    */   public static native void invokeCCUCCCCUCCCCCCV(short paramShort1, short paramShort2, byte paramByte1, short paramShort3, short paramShort4, short paramShort5, short paramShort6, byte paramByte2, short paramShort7, short paramShort8, short paramShort9, short paramShort10, short paramShort11, short paramShort12, long paramLong);
/*    */   
/*    */   public static native void invokePCCUCCCCUCCCCCCV(long paramLong1, short paramShort1, short paramShort2, byte paramByte1, short paramShort3, short paramShort4, short paramShort5, short paramShort6, byte paramByte2, short paramShort7, short paramShort8, short paramShort9, short paramShort10, short paramShort11, short paramShort12, long paramLong2);
/*    */   
/*    */   public static native boolean invokeZ(long paramLong);
/*    */   
/*    */   public static native boolean invokeZ(int paramInt, long paramLong);
/*    */   
/*    */   public static native boolean invokePZ(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native boolean invokePZ(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native boolean invokePZ(long paramLong1, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native boolean invokePZ(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native boolean invokePZ(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native boolean invokePPZ(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native boolean invokeUPZ(byte paramByte, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native boolean invokePPZ(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native boolean invokePPZ(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native boolean invokePPPZ(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native boolean invokePJPZ(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native boolean invokePPPZ(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native boolean invokeCCJZ(short paramShort1, boolean paramBoolean, short paramShort2, int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native boolean invokePPPZ(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, int paramInt, long paramLong4);
/*    */   
/*    */   public static native boolean invokePPPZ(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, boolean paramBoolean, long paramLong4);
/*    */   
/*    */   public static native boolean invokePPPPZ(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native boolean invokePPPPZ(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native boolean invokePPPUPZ(long paramLong1, long paramLong2, long paramLong3, byte paramByte, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native boolean invokePPPPPZ(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, long paramLong6);
/*    */   
/*    */   public static native boolean invokePPPPPZ(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean, int paramInt, long paramLong6);
/*    */   
/*    */   public static native short callC(int paramInt, long paramLong);
/*    */   
/*    */   public static native float callF(long paramLong);
/*    */   
/*    */   public static native float callF(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native float callPF(long paramLong1, float paramFloat, long paramLong2);
/*    */   
/*    */   public static native float callPF(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native float callPPPF(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callI(long paramLong);
/*    */   
/*    */   public static native int callI(int paramInt, long paramLong);
/*    */   
/*    */   public static native int callI(int paramInt, float paramFloat, long paramLong);
/*    */   
/*    */   public static native int callI(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native int callI(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native int callJI(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int callJI(long paramLong1, float paramFloat, long paramLong2);
/*    */   
/*    */   public static native int callJI(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native int callPI(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, float paramFloat, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native int callJI(long paramLong1, int paramInt, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native int callPI(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int callPI(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, float paramFloat, int paramInt, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, int paramInt, float paramFloat, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native int callJI(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native int callJI(long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong2);
/*    */   
/*    */   public static native int callPI(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int callPI(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native int callPI(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native int callPI(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
/*    */   
/*    */   public static native int callPI(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int callPI(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int callPI(int paramInt1, long paramLong1, int paramInt2, int paramInt3, float paramFloat, int paramInt4, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2);
/*    */   
/*    */   public static native int callPI(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, long paramLong2);
/*    */   
/*    */   public static native int callPI(long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, long paramLong2);
/*    */   
/*    */   public static native int callJJI(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callJPI(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPJI(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callJPI(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callJPI(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native int callPJI(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPJI(long paramLong1, long paramLong2, float paramFloat, long paramLong3);
/*    */   
/*    */   public static native int callPJI(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native int callPPI(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, float paramFloat, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, long paramLong2, float paramFloat, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native int callJPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native int callJPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native int callPJI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt, float paramFloat, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, long paramLong2, float paramFloat, int paramInt, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native int callJPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, long paramLong3);
/*    */   
/*    */   public static native int callJPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3);
/*    */   
/*    */   public static native int callPPI(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong3);
/*    */   
/*    */   public static native int callJJI(long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(int paramInt1, long paramLong1, int paramInt2, int paramInt3, float paramFloat, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt3, long paramLong2, int paramInt4, long paramLong3);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, long paramLong3);
/*    */   
/*    */   public static native int callJPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPCPI(long paramLong1, short paramShort, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPJJI(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPJPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPJI(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPUPI(long paramLong1, byte paramByte, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callJJPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native int callJPJI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callJPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callJPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callJPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native int callPJJI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPJJI(long paramLong1, long paramLong2, long paramLong3, float paramFloat, long paramLong4);
/*    */   
/*    */   public static native int callPJJI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native int callPJJI(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, long paramLong4);
/*    */   
/*    */   public static native int callPJPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPJPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPJI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPJI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPJI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native int callPPNI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native int callJPJI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callJPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callJPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native int callJPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callJPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native int callPJJI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native int callPJPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native int callPPJI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native int callJPJI(long paramLong1, int paramInt1, float paramFloat, long paramLong2, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callJPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, int paramInt4, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callJPPI(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPJI(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callJJPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callJPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPCPPI(long paramLong1, short paramShort, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPJJJI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPJJPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPJPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPNPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPJI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPUPPI(long paramLong1, byte paramByte, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callJPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPJJJI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPJPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPJI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5);
/*    */   
/*    */   public static native int callJPPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2, long paramLong5);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, long paramLong5);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callJPPJI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, long paramLong3, boolean paramBoolean, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPI(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, int paramInt18, int paramInt19, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callJPPPJI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPJJPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPJPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPCPPI(long paramLong1, long paramLong2, short paramShort, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPJPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPJJI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPJI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPUPPI(long paramLong1, long paramLong2, byte paramByte, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPJJJPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPJPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, long paramLong6);
/*    */   
/*    */   public static native int callJJPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPJPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPJPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, int paramInt2, long paramLong6);
/*    */   
/*    */   public static native int callJPPPPI(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPJPPJI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4, long paramLong5, int paramInt3, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callJPJPPJI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPJJJJPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPCPPPI(long paramLong1, long paramLong2, short paramShort, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPPPPJPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPUPPPI(long paramLong1, long paramLong2, byte paramByte, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native int callPJJPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPJPPPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPJPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPJPPPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPJPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPI(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, long paramLong5, long paramLong6, int paramInt2, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt, long paramLong8);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, int paramInt2, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, long paramLong5, int paramInt2, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt3, int paramInt4, long paramLong7, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong8);
/*    */   
/*    */   public static native int callPPPPPJPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native int callPPJPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, long paramLong6, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native int callPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native int callPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, long paramLong5, long paramLong6, int paramInt2, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native int callPPPPPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt3, long paramLong6, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native int callJPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10);
/*    */   
/*    */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt, long paramLong7, long paramLong8, long paramLong9, long paramLong10);
/*    */   
/*    */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt2, long paramLong8, long paramLong9, long paramLong10);
/*    */   
/*    */   public static native int callPPPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt, long paramLong8, long paramLong9, long paramLong10, long paramLong11);
/*    */   
/*    */   public static native int callPPPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, long paramLong5, long paramLong6, long paramLong7, int paramInt2, long paramLong8, long paramLong9, long paramLong10, long paramLong11);
/*    */   
/*    */   public static native int callPPPPPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, int paramInt, long paramLong11, long paramLong12, long paramLong13);
/*    */   
/*    */   public static native int callPPPPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, int paramInt2, long paramLong11, long paramLong12, long paramLong13);
/*    */   
/*    */   public static native int callPPPPPPPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, int paramInt, long paramLong12, long paramLong13, long paramLong14, long paramLong15);
/*    */   
/*    */   public static native long callJ(long paramLong);
/*    */   
/*    */   public static native long callJ(int paramInt, long paramLong);
/*    */   
/*    */   public static native long callJ(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native long callJ(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, long paramLong);
/*    */   
/*    */   public static native long callJJ(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long callPJ(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long callPJ(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long callPPJ(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long callPPJ(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long callPJJ(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native long callPN(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long callP(long paramLong);
/*    */   
/*    */   public static native long callP(int paramInt, long paramLong);
/*    */   
/*    */   public static native long callP(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native long callP(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
/*    */   
/*    */   public static native long callPP(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long callPP(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long callPP(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native long callPP(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native long callPP(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native long callPP(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native long callPP(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native long callPNP(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long callPPP(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long callPPP(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long callPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long callPPP(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native long callPPP(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native long callPPP(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long callPPP(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long callPPP(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long callPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3);
/*    */   
/*    */   public static native long callPPNP(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long callPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long callPJPP(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long callPJPP(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native long callPPPP(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long callPPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long callPPPP(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long callPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native long callPPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long callPPPP(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native long callPJPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native long callPPJPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long callPPNPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long callPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long callPJPPP(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long callPJPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long callPPPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long callPPPPP(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long callPPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long callPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5);
/*    */   
/*    */   public static native long callPJPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long callPJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long callPPPJPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long callPPPPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long callPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native long callPJJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native long callPJPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native long callPPJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native long callPPPJPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native long callPPPPPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native long callPPJPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native long callPPPPJPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native long callPPPPPPPP(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native long callPPPPPPPP(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong3, long paramLong4, long paramLong5, int paramInt6, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native long callPJPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native long callPPJPPPPPP(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, int paramInt2, long paramLong6, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native long callPJPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11);
/*    */   
/*    */   public static native long callPPJPPPPPPPP(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt2, long paramLong8, long paramLong9, long paramLong10, long paramLong11);
/*    */   
/*    */   public static native short callS(int paramInt, long paramLong);
/*    */   
/*    */   public static native short callPS(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native short callPCS(long paramLong1, short paramShort, long paramLong2);
/*    */   
/*    */   public static native short callPPS(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native short callPSS(long paramLong1, short paramShort, long paramLong2);
/*    */   
/*    */   public static native short callSPS(short paramShort, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native short callPPS(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native short callPPS(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native short callPCPS(long paramLong1, short paramShort, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native short callPPCS(long paramLong1, long paramLong2, short paramShort, long paramLong3);
/*    */   
/*    */   public static native short callPPPS(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native short callPPSS(long paramLong1, long paramLong2, short paramShort, long paramLong3);
/*    */   
/*    */   public static native short callPSPS(long paramLong1, short paramShort, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native short callSPPS(short paramShort, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native short callSPSS(short paramShort1, long paramLong1, short paramShort2, long paramLong2);
/*    */   
/*    */   public static native short callPPPS(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native short callPJCCS(long paramLong1, long paramLong2, short paramShort1, short paramShort2, long paramLong3);
/*    */   
/*    */   public static native short callPPSPS(long paramLong1, long paramLong2, short paramShort, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native short callPSSPS(long paramLong1, short paramShort1, short paramShort2, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native short callPPPPS(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native short callPCPPPS(long paramLong1, short paramShort, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native short callPCPSPS(long paramLong1, short paramShort1, long paramLong2, short paramShort2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native short callPSSPPS(long paramLong1, short paramShort1, short paramShort2, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native short callPCPPPPS(long paramLong1, short paramShort, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native short callPCSPPPS(long paramLong1, short paramShort1, short paramShort2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native short callPPSPSPS(long paramLong1, long paramLong2, short paramShort1, long paramLong3, short paramShort2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native short callPCCPSPPS(long paramLong1, short paramShort1, short paramShort2, long paramLong2, short paramShort3, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native short callPPSPSPSS(long paramLong1, long paramLong2, short paramShort1, long paramLong3, short paramShort2, long paramLong4, short paramShort3, long paramLong5);
/*    */   
/*    */   public static native short callSPSSPSPS(short paramShort1, long paramLong1, short paramShort2, short paramShort3, long paramLong2, short paramShort4, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native short callPCPSPPSPS(long paramLong1, short paramShort1, long paramLong2, short paramShort2, long paramLong3, long paramLong4, short paramShort3, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native short callPPPSPSPCS(long paramLong1, long paramLong2, long paramLong3, short paramShort1, long paramLong4, short paramShort2, long paramLong5, short paramShort3, long paramLong6);
/*    */   
/*    */   public static native short callSPSPPPSPS(short paramShort1, long paramLong1, short paramShort2, long paramLong2, long paramLong3, long paramLong4, short paramShort3, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native short callPCPSPPPPPS(long paramLong1, short paramShort1, long paramLong2, short paramShort2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native short callPPSPSPSCCS(long paramLong1, long paramLong2, short paramShort1, long paramLong3, short paramShort2, long paramLong4, short paramShort3, short paramShort4, short paramShort5, long paramLong5);
/*    */   
/*    */   public static native short callPPSPSPSPSS(long paramLong1, long paramLong2, short paramShort1, long paramLong3, short paramShort2, long paramLong4, short paramShort3, long paramLong5, short paramShort4, long paramLong6);
/*    */   
/*    */   public static native short callPCPSPSPSCCS(long paramLong1, short paramShort1, long paramLong2, short paramShort2, long paramLong3, short paramShort3, long paramLong4, short paramShort4, short paramShort5, short paramShort6, long paramLong5);
/*    */   
/*    */   public static native short callPCSSSPSPPPS(long paramLong1, short paramShort1, short paramShort2, short paramShort3, short paramShort4, long paramLong2, short paramShort5, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native short callPSSSPSSPPPS(long paramLong1, short paramShort1, short paramShort2, short paramShort3, long paramLong2, short paramShort4, short paramShort5, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native short callPSPSPPPPPPPS(long paramLong1, short paramShort1, long paramLong2, short paramShort2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10);
/*    */   
/*    */   public static native short callPPSPSPSPSPSPSS(long paramLong1, long paramLong2, short paramShort1, long paramLong3, short paramShort2, long paramLong4, short paramShort3, long paramLong5, short paramShort4, long paramLong6, short paramShort5, long paramLong7, short paramShort6, long paramLong8);
/*    */   
/*    */   public static native void callV(long paramLong);
/*    */   
/*    */   public static native void callV(double paramDouble, long paramLong);
/*    */   
/*    */   public static native void callV(float paramFloat, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, long paramLong);
/*    */   
/*    */   public static native void callV(boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callV(double paramDouble1, double paramDouble2, long paramLong);
/*    */   
/*    */   public static native void callV(float paramFloat1, float paramFloat2, long paramLong);
/*    */   
/*    */   public static native void callV(float paramFloat, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, double paramDouble, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, float paramFloat, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callV(double paramDouble1, double paramDouble2, double paramDouble3, long paramLong);
/*    */   
/*    */   public static native void callV(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, double paramDouble1, double paramDouble2, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, float paramFloat1, float paramFloat2, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, double paramDouble, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, float paramFloat, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callV(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, long paramLong);
/*    */   
/*    */   public static native void callV(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, float paramFloat, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, double paramDouble, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, float paramFloat, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void callV(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong);
/*    */   
/*    */   public static native void callV(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, long paramLong);
/*    */   
/*    */   public static native void callV(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, double paramDouble3, double paramDouble4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3, float paramFloat4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*    */   
/*    */   public static native void callV(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, long paramLong);
/*    */   
/*    */   public static native void callV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, long paramLong);
/*    */   
/*    */   public static native void callJV(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callSV(short paramShort, long paramLong);
/*    */   
/*    */   public static native void callUV(byte paramByte, long paramLong);
/*    */   
/*    */   public static native void callCV(int paramInt, short paramShort, long paramLong);
/*    */   
/*    */   public static native void callJV(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callJV(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(long paramLong1, float paramFloat, long paramLong2);
/*    */   
/*    */   public static native void callPV(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void callSV(int paramInt, short paramShort, long paramLong);
/*    */   
/*    */   public static native void callCV(int paramInt1, int paramInt2, short paramShort, long paramLong);
/*    */   
/*    */   public static native void callJV(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void callPV(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2);
/*    */   
/*    */   public static native void callPV(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void callJV(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native void callNV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, float paramFloat, long paramLong1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native void callPV(long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong2);
/*    */   
/*    */   public static native void callPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
/*    */   
/*    */   public static native void callJV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, int paramInt5, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong2);
/*    */   
/*    */   public static native void callJV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, int paramInt6, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, int paramInt5, int paramInt6, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2);
/*    */   
/*    */   public static native void callPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2);
/*    */   
/*    */   public static native void callJV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callJV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callJV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, double paramDouble3, double paramDouble4, int paramInt4, int paramInt5, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callJV(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong2);
/*    */   
/*    */   public static native void callJV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong1, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callJPV(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPJV(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callSSV(short paramShort1, short paramShort2, long paramLong);
/*    */   
/*    */   public static native void callJJV(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPCV(long paramLong1, int paramInt, short paramShort, long paramLong2);
/*    */   
/*    */   public static native void callPJV(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPJV(long paramLong1, long paramLong2, float paramFloat, long paramLong3);
/*    */   
/*    */   public static native void callPJV(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native void callSSV(int paramInt, short paramShort1, short paramShort2, long paramLong);
/*    */   
/*    */   public static native void callJJV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callJPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callJPV(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPJV(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPJV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native void callPJV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3);
/*    */   
/*    */   public static native void callPPV(long paramLong1, int paramInt, float paramFloat, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native void callPJV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3);
/*    */   
/*    */   public static native void callPPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, long paramLong3);
/*    */   
/*    */   public static native void callPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, int paramInt5, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int paramInt5, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, int paramInt6, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, long paramLong2, int paramInt6, int paramInt7, float paramFloat, long paramLong3);
/*    */   
/*    */   public static native void callBBBV(byte paramByte1, byte paramByte2, byte paramByte3, long paramLong);
/*    */   
/*    */   public static native void callCCCV(short paramShort1, short paramShort2, short paramShort3, long paramLong);
/*    */   
/*    */   public static native void callPJJV(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPNV(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callSSSV(short paramShort1, short paramShort2, short paramShort3, long paramLong);
/*    */   
/*    */   public static native void callUUUV(byte paramByte1, byte paramByte2, byte paramByte3, long paramLong);
/*    */   
/*    */   public static native void callJJJV(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPJJV(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, long paramLong2, float paramFloat, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callSSSV(int paramInt, short paramShort1, short paramShort2, short paramShort3, long paramLong);
/*    */   
/*    */   public static native void callJJJV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPJJV(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native void callPJJV(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPJPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPJV(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, boolean paramBoolean, long paramLong4);
/*    */   
/*    */   public static native void callPPJV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPJJV(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, int paramInt3, int paramInt4, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong3, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, long paramLong4);
/*    */   
/*    */   public static native void callBBBBV(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, long paramLong);
/*    */   
/*    */   public static native void callCCCCV(short paramShort1, short paramShort2, short paramShort3, short paramShort4, long paramLong);
/*    */   
/*    */   public static native void callPJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPJPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPNV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callSSSSV(short paramShort1, short paramShort2, short paramShort3, short paramShort4, long paramLong);
/*    */   
/*    */   public static native void callUUUUV(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, long paramLong);
/*    */   
/*    */   public static native void callJJJJV(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPJJJV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5);
/*    */   
/*    */   public static native void callPJJPV(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPJJPV(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPPV(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPPV(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPPV(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5);
/*    */   
/*    */   public static native void callSSSSV(int paramInt, short paramShort1, short paramShort2, short paramShort3, short paramShort4, long paramLong);
/*    */   
/*    */   public static native void callUUUUV(int paramInt, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, long paramLong);
/*    */   
/*    */   public static native void callJJJJV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPJJPV(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPJJPV(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPJPPV(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPPV(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPPV(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt2, long paramLong5);
/*    */   
/*    */   public static native void callPPPPV(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPJJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int paramInt3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPJJPV(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, int paramInt3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPJPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt3, long paramLong5);
/*    */   
/*    */   public static native void callPJJPV(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, int paramInt3, long paramLong4, int paramInt4, long paramLong5);
/*    */   
/*    */   public static native void callPJPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, int paramInt4, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, int paramInt5, long paramLong3, int paramInt6, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPJJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void callPPPPPV(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void callPJJJJV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, int paramInt2, long paramLong6);
/*    */   
/*    */   public static native void callPPPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void callPPPPPV(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void callPJJJJV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4, long paramLong5, int paramInt3, long paramLong6);
/*    */   
/*    */   public static native void callPJPPPV(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, int paramInt3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void callPPPPPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, int paramInt2, int paramInt3, long paramLong6);
/*    */   
/*    */   public static native void callPPPPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, long paramLong3, int paramInt5, long paramLong4, int paramInt6, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native void callPPPPPJV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native void callPPPPPPV(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native void callPPPPPPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native void callPPJJJJJJV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native void callPJJJJJJJJJJJV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, int paramInt1, int paramInt2, int paramInt3, long paramLong13);
/*    */   
/*    */   public static native boolean callZ(long paramLong);
/*    */   
/*    */   public static native boolean callZ(int paramInt, long paramLong);
/*    */   
/*    */   public static native boolean callZ(boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native boolean callZ(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native boolean callZ(int paramInt, float paramFloat1, float paramFloat2, long paramLong);
/*    */   
/*    */   public static native boolean callZ(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, long paramLong);
/*    */   
/*    */   public static native boolean callJZ(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native boolean callPZ(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native boolean callJZ(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native boolean callPZ(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native boolean callPZ(long paramLong1, int paramInt, long paramLong2);
/*    */   
/*    */   public static native boolean callJZ(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native boolean callPZ(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native boolean callPZ(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native boolean callPZ(int paramInt, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native boolean callPPZ(long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native boolean callJPZ(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native boolean callPPZ(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native boolean callPPZ(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native boolean callPPZ(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*    */   
/*    */   public static native boolean callPPZ(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native boolean callPPZ(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native boolean callJPPZ(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native boolean callPPPZ(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native boolean callPPPPZ(int paramInt1, int paramInt2, int paramInt3, float paramFloat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native boolean callPPJPPZ(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native boolean callPPPPPZ(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   public static native short invokeUPC(byte paramByte, short[] paramArrayOfshort, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native short invokeCPCC(short paramShort1, short[] paramArrayOfshort, short paramShort2, long paramLong);
/*    */   
/*    */   public static native int invokeCPI(short paramShort, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native int invokePCI(float[] paramArrayOffloat, short paramShort, long paramLong);
/*    */   
/*    */   public static native int invokePPI(int paramInt, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native int invokePPI(int paramInt1, int[] paramArrayOfint1, int paramInt2, int[] paramArrayOfint2, int paramInt3, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native int invokePPI(int paramInt1, short[] paramArrayOfshort1, int paramInt2, short[] paramArrayOfshort2, int paramInt3, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native int invokeCPUI(short paramShort, float[] paramArrayOffloat, byte paramByte, long paramLong);
/*    */   
/*    */   public static native int invokeCPUI(short paramShort, int[] paramArrayOfint, byte paramByte, long paramLong);
/*    */   
/*    */   public static native int invokeCPUI(short paramShort, short[] paramArrayOfshort, byte paramByte, long paramLong);
/*    */   
/*    */   public static native int invokePPCI(long paramLong1, float[] paramArrayOffloat, short paramShort, long paramLong2);
/*    */   
/*    */   public static native int invokePPPI(int[] paramArrayOfint, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, float paramFloat, long paramLong3);
/*    */   
/*    */   public static native int invokePPPI(short[] paramArrayOfshort, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, float paramFloat, long paramLong3);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native int invokePPPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong3);
/*    */   
/*    */   public static native int invokePPPPPI(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int invokePNNPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int invokePPPPPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, float[] paramArrayOffloat, int[] paramArrayOfint3, int[] paramArrayOfint4, int[] paramArrayOfint5, long paramLong3);
/*    */   
/*    */   public static native long invokePP(double[] paramArrayOfdouble, int paramInt, long paramLong);
/*    */   
/*    */   public static native long invokePP(float[] paramArrayOffloat, int paramInt, long paramLong);
/*    */   
/*    */   public static native long invokePP(int[] paramArrayOfint, int paramInt, long paramLong);
/*    */   
/*    */   public static native long invokePP(long[] paramArrayOflong, int paramInt, long paramLong);
/*    */   
/*    */   public static native long invokePP(short[] paramArrayOfshort, int paramInt, long paramLong);
/*    */   
/*    */   public static native long invokePPP(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native byte invokeUPU(byte paramByte, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, long[] paramArrayOflong, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt, int[] paramArrayOfint, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3, int paramInt4, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3, int paramInt4, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, short[] paramArrayOfshort, int paramInt3, int paramInt4, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void invokeUPV(byte paramByte, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void invokePJV(int paramInt, int[] paramArrayOfint, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, float[] paramArrayOffloat, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, int[] paramArrayOfint, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, short[] paramArrayOfshort, int paramInt, long paramLong2);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong, long paramLong2);
/*    */   
/*    */   public static native void invokeCCPV(short paramShort1, short paramShort2, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void invokeCPCV(short paramShort1, double[] paramArrayOfdouble, short paramShort2, long paramLong);
/*    */   
/*    */   public static native void invokeCPCV(short paramShort1, float[] paramArrayOffloat, short paramShort2, long paramLong);
/*    */   
/*    */   public static native void invokeCPCV(short paramShort1, int[] paramArrayOfint, short paramShort2, long paramLong);
/*    */   
/*    */   public static native void invokeCPCV(short paramShort1, long[] paramArrayOflong, short paramShort2, long paramLong);
/*    */   
/*    */   public static native void invokeCPCV(short paramShort1, short[] paramArrayOfshort, short paramShort2, long paramLong);
/*    */   
/*    */   public static native void invokeCPPV(short paramShort, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong);
/*    */   
/*    */   public static native void invokePNPV(long paramLong1, long paramLong2, short[] paramArrayOfshort, long paramLong3);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, long paramLong2);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong2);
/*    */   
/*    */   public static native void invokePPPV(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*    */   
/*    */   public static native void invokePPPV(int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong);
/*    */   
/*    */   public static native void invokePPPV(int paramInt, float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, long paramLong);
/*    */   
/*    */   public static native void invokePPPV(int paramInt1, int paramInt2, double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, double[] paramArrayOfdouble3, long paramLong);
/*    */   
/*    */   public static native void invokePPPV(int paramInt1, int paramInt2, float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, long paramLong);
/*    */   
/*    */   public static native void invokePPPV(int paramInt1, int paramInt2, long[] paramArrayOflong1, long[] paramArrayOflong2, long[] paramArrayOflong3, long paramLong);
/*    */   
/*    */   public static native void invokePPPV(float[] paramArrayOffloat, int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native void invokePPPV(float[] paramArrayOffloat, boolean paramBoolean, int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3);
/*    */   
/*    */   public static native void invokePCPCV(long paramLong1, short paramShort1, double[] paramArrayOfdouble, short paramShort2, long paramLong2);
/*    */   
/*    */   public static native void invokePCPCV(long paramLong1, short paramShort1, float[] paramArrayOffloat, short paramShort2, long paramLong2);
/*    */   
/*    */   public static native void invokePCPCV(long paramLong1, short paramShort1, int[] paramArrayOfint, short paramShort2, long paramLong2);
/*    */   
/*    */   public static native void invokePCPCV(long paramLong1, short paramShort1, long[] paramArrayOflong, short paramShort2, long paramLong2);
/*    */   
/*    */   public static native void invokePCPCV(long paramLong1, short paramShort1, short[] paramArrayOfshort, short paramShort2, long paramLong2);
/*    */   
/*    */   public static native void invokePNPPV(long paramLong1, long paramLong2, long paramLong3, short[] paramArrayOfshort, long paramLong4);
/*    */   
/*    */   public static native void invokePPPPPV(long paramLong1, long paramLong2, long paramLong3, float[] paramArrayOffloat, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokePPPPPV(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, long paramLong2);
/*    */   
/*    */   public static native void invokePPPPPV(long paramLong1, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void invokePPPPPV(int paramInt1, long paramLong1, int paramInt2, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong2, int paramInt3, long paramLong3, int paramInt4, boolean paramBoolean, long paramLong4);
/*    */   
/*    */   public static native void invokePPPPPV(int paramInt1, int[] paramArrayOfint1, int paramInt2, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong1, int paramInt3, int[] paramArrayOfint2, int paramInt4, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native void invokePPPPPV(int paramInt1, short[] paramArrayOfshort1, int paramInt2, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong1, int paramInt3, short[] paramArrayOfshort2, int paramInt4, boolean paramBoolean, long paramLong2);
/*    */   
/*    */   public static native boolean invokePPZ(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native boolean invokePPPZ(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native int callPI(int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native int callPI(int paramInt, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native int callPI(int[] paramArrayOfint, int paramInt, long paramLong);
/*    */   
/*    */   public static native int callPI(int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native int callPI(int paramInt1, int[] paramArrayOfint, int paramInt2, long paramLong);
/*    */   
/*    */   public static native int callPI(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native int callPI(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native int callPI(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native int callPPI(long paramLong1, long[] paramArrayOflong, long paramLong2);
/*    */   
/*    */   public static native int callPPI(int[] paramArrayOfint, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int callPPI(int paramInt, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt, double[] paramArrayOfdouble, long paramLong2);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt, float[] paramArrayOffloat, long paramLong2);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt, long[] paramArrayOflong, long paramLong2);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt, short[] paramArrayOfshort, long paramLong2);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native int callPPI(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong, long paramLong2);
/*    */   
/*    */   public static native int callPPI(int paramInt1, long paramLong1, int paramInt2, int paramInt3, float paramFloat, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native int callPJPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native int callPJPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long[] paramArrayOflong1, long[] paramArrayOflong2, long paramLong2);
/*    */   
/*    */   public static native int callPPPI(int[] paramArrayOfint1, long paramLong1, int[] paramArrayOfint2, long paramLong2);
/*    */   
/*    */   public static native int callPJPI(long paramLong1, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native int callPJPI(long paramLong1, long paramLong2, int paramInt, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt, long paramLong2, double[] paramArrayOfdouble, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt, long paramLong2, float[] paramArrayOffloat, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt, long paramLong2, short[] paramArrayOfshort, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong2);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, int paramInt, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, int paramInt, long paramLong3);
/*    */   
/*    */   public static native int callPPJI(long paramLong1, int paramInt1, long[] paramArrayOflong, int paramInt2, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, float[] paramArrayOffloat, long paramLong2);
/*    */   
/*    */   public static native int callPPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong3);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native int callPPNPI(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong3);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOflong, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOflong1, long[] paramArrayOflong2, long paramLong3);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, int paramInt, long[] paramArrayOflong, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int[] paramArrayOfint1, long paramLong2, int paramInt, int[] paramArrayOfint2, long paramLong3);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, long[] paramArrayOflong, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong3);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long[] paramArrayOflong, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*    */   
/*    */   public static native int callPJPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native int callPPPPI(int paramInt1, int[] paramArrayOfint1, long[] paramArrayOflong1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, int paramInt18, int paramInt19, int[] paramArrayOfint2, long[] paramArrayOflong2, long paramLong);
/*    */   
/*    */   public static native int callPJPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long[] paramArrayOflong, long paramLong5);
/*    */   
/*    */   public static native int callPPJPPI(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong3);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native int callPJPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long[] paramArrayOflong, long paramLong5);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, int[] paramArrayOfint, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long[] paramArrayOflong, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint1, int paramInt, int[] paramArrayOfint2, long paramLong4);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, int[] paramArrayOfint1, float[] paramArrayOffloat, int paramInt, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong2);
/*    */   
/*    */   public static native int callPPPPPI(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, int paramInt1, long paramLong2, long[] paramArrayOflong, int paramInt2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPPPPPI(long paramLong1, int paramInt1, long[] paramArrayOflong, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native int callPJPPJI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int[] paramArrayOfint, long paramLong4, int paramInt3, long paramLong5);
/*    */   
/*    */   public static native int callPJPPJI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long[] paramArrayOflong, long paramLong4, int paramInt3, long paramLong5);
/*    */   
/*    */   public static native int callPJJJJPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int[] paramArrayOfint, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPPI(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, int[] paramArrayOfint5, long paramLong2);
/*    */   
/*    */   public static native int callPJJPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5, long[] paramArrayOflong, long paramLong6);
/*    */   
/*    */   public static native int callPPPPPPI(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, int[] paramArrayOfint5, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, int[] paramArrayOfint, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, float[] paramArrayOffloat, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, double[] paramArrayOfdouble, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, float[] paramArrayOffloat, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int[] paramArrayOfint, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, short[] paramArrayOfshort, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPJPPPPPI(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native int callPPJPPPPPI(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, int[] paramArrayOfint, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, float[] paramArrayOffloat, long paramLong4, long paramLong5, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint1, long paramLong4, long paramLong5, int paramInt, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong6, long paramLong7);
/*    */   
/*    */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, double[] paramArrayOfdouble, int paramInt2, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, float[] paramArrayOffloat, int paramInt2, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int[] paramArrayOfint, int paramInt2, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, short[] paramArrayOfshort, int paramInt2, long paramLong7, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native int callPPPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong8, long paramLong9);
/*    */   
/*    */   public static native int callPPPPPPPPPPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3, int paramInt1, long paramLong4, long paramLong5, long paramLong6, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong7, long paramLong8);
/*    */   
/*    */   public static native int callPPPPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, double[] paramArrayOfdouble, int paramInt2, long paramLong10, long paramLong11, long paramLong12);
/*    */   
/*    */   public static native int callPPPPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, float[] paramArrayOffloat, int paramInt2, long paramLong10, long paramLong11, long paramLong12);
/*    */   
/*    */   public static native int callPPPPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, int[] paramArrayOfint, int paramInt2, long paramLong10, long paramLong11, long paramLong12);
/*    */   
/*    */   public static native int callPPPPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, short[] paramArrayOfshort, int paramInt2, long paramLong10, long paramLong11, long paramLong12);
/*    */   
/*    */   public static native int callPPPPPPPPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong12, long paramLong13);
/*    */   
/*    */   public static native long callPP(int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native long callPPP(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native long callPPP(int paramInt, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native long callPPP(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native long callPPP(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*    */   
/*    */   public static native long callPPP(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native long callPPPP(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native long callPPPP(long paramLong1, long[] paramArrayOflong, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native long callPJPP(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native long callPPPP(int paramInt, long paramLong1, long[] paramArrayOflong, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native long callPPPP(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native long callPPPP(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native long callPPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native long callPJPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native long callPPJPP(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPPNPP(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPPPPP(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPPPPP(long paramLong1, long paramLong2, long[] paramArrayOflong, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native long callPJPPP(long paramLong1, long paramLong2, int paramInt, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPJPPP(long paramLong1, long paramLong2, int[] paramArrayOfint1, int paramInt, int[] paramArrayOfint2, long paramLong3);
/*    */   
/*    */   public static native long callPPPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPPPPP(long paramLong1, long paramLong2, int paramInt, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, int paramInt, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native long callPJPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint, long paramLong5);
/*    */   
/*    */   public static native long callPJPPPP(long paramLong1, long paramLong2, long paramLong3, double[] paramArrayOfdouble, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPJPPPP(long paramLong1, long paramLong2, long paramLong3, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPJPPPP(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong4);
/*    */   
/*    */   public static native long callPJPPPP(long paramLong1, long paramLong2, long paramLong3, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPPPPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint, long paramLong5);
/*    */   
/*    */   public static native long callPPPPPP(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3, int paramInt, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPJJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int[] paramArrayOfint, long paramLong6);
/*    */   
/*    */   public static native long callPJJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, double[] paramArrayOfdouble, int[] paramArrayOfint, long paramLong5);
/*    */   
/*    */   public static native long callPJJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong5);
/*    */   
/*    */   public static native long callPJJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong5);
/*    */   
/*    */   public static native long callPJJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong5);
/*    */   
/*    */   public static native long callPJPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int[] paramArrayOfint, long paramLong6);
/*    */   
/*    */   public static native long callPJPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong5);
/*    */   
/*    */   public static native long callPJPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong5);
/*    */   
/*    */   public static native long callPJPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong5);
/*    */   
/*    */   public static native long callPPJPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint, long paramLong5);
/*    */   
/*    */   public static native long callPPJPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, double[] paramArrayOfdouble, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPPJPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPPJPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong4);
/*    */   
/*    */   public static native long callPPJPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong4);
/*    */   
/*    */   public static native long callPPPJPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int[] paramArrayOfint, long paramLong6);
/*    */   
/*    */   public static native long callPPPPPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong5);
/*    */   
/*    */   public static native long callPPJPPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int[] paramArrayOfint, long paramLong6);
/*    */   
/*    */   public static native long callPPJPPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong5);
/*    */   
/*    */   public static native long callPPJPPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong5);
/*    */   
/*    */   public static native long callPPJPPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong5);
/*    */   
/*    */   public static native long callPPPPPPPP(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, long paramLong5, long paramLong6, int[] paramArrayOfint, long paramLong7);
/*    */   
/*    */   public static native long callPPPPPPPP(int paramInt1, int[] paramArrayOfint1, long[] paramArrayOflong1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, long paramLong3, int paramInt6, int[] paramArrayOfint2, long[] paramArrayOflong2, long paramLong4);
/*    */   
/*    */   public static native long callPJPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int[] paramArrayOfint, long paramLong8);
/*    */   
/*    */   public static native long callPJPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong7);
/*    */   
/*    */   public static native long callPJPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong7);
/*    */   
/*    */   public static native long callPJPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong7);
/*    */   
/*    */   public static native long callPPJPPPPPP(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, int paramInt2, long paramLong6, long paramLong7, int[] paramArrayOfint, long paramLong8);
/*    */   
/*    */   public static native long callPJPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, int[] paramArrayOfint, long paramLong10);
/*    */   
/*    */   public static native long callPJPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong9);
/*    */   
/*    */   public static native long callPJPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong9);
/*    */   
/*    */   public static native long callPJPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong9);
/*    */   
/*    */   public static native long callPPJPPPPPPPP(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt2, long paramLong8, long paramLong9, int[] paramArrayOfint, long paramLong10);
/*    */   
/*    */   public static native void callPV(double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt, long[] paramArrayOflong, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, long[] paramArrayOflong, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int[] paramArrayOfint, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, long[] paramArrayOflong, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, boolean paramBoolean, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int[] paramArrayOfint, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long[] paramArrayOflong, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3, int paramInt4, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, boolean paramBoolean, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, double paramDouble3, double paramDouble4, int paramInt4, int paramInt5, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, double[] paramArrayOfdouble, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int[] paramArrayOfint, long paramLong);
/*    */   
/*    */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, short[] paramArrayOfshort, long paramLong);
/*    */   
/*    */   public static native void callPPV(long paramLong1, float[] paramArrayOffloat, long paramLong2);
/*    */   
/*    */   public static native void callPPV(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native void callPPV(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, long paramLong);
/*    */   
/*    */   public static native void callPPV(float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong);
/*    */   
/*    */   public static native void callPPV(int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*    */   
/*    */   public static native void callPPV(short[] paramArrayOfshort1, short[] paramArrayOfshort2, long paramLong);
/*    */   
/*    */   public static native void callPPV(int paramInt, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt, int[] paramArrayOfint, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPPV(int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*    */   
/*    */   public static native void callPPV(int paramInt, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong);
/*    */   
/*    */   public static native void callPPV(long paramLong1, int paramInt, float[] paramArrayOffloat, long paramLong2);
/*    */   
/*    */   public static native void callPPV(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int[] paramArrayOfint1, int paramInt, int[] paramArrayOfint2, long paramLong);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long paramLong1, int paramInt2, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long paramLong1, double[] paramArrayOfdouble, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long paramLong1, float[] paramArrayOffloat, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long paramLong1, int[] paramArrayOfint, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long paramLong1, long[] paramArrayOflong, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long paramLong1, short[] paramArrayOfshort, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void callPPV(int paramInt1, long[] paramArrayOflong, int[] paramArrayOfint, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void callPPV(long paramLong1, int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int[] paramArrayOfint, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint1, int paramInt3, int[] paramArrayOfint2, long paramLong);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int[] paramArrayOfint, int paramInt2, long paramLong1, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int[] paramArrayOfint1, int paramInt2, int[] paramArrayOfint2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int[] paramArrayOfint, long paramLong1, int paramInt2, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native void callPPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, float[] paramArrayOffloat, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, short[] paramArrayOfshort, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong1, int paramInt3, int paramInt4, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, int paramInt5, float[] paramArrayOffloat, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, float[] paramArrayOffloat, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, int paramInt6, float[] paramArrayOffloat, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, int paramInt6, short[] paramArrayOfshort, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float[] paramArrayOffloat, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, float[] paramArrayOffloat, long paramLong2);
/*    */   
/*    */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOffloat, long paramLong2);
/*    */   
/*    */   public static native void callPJPV(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt, long paramLong1, long paramLong2, double[] paramArrayOfdouble, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt, long paramLong1, long paramLong2, float[] paramArrayOffloat, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt, long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt, long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt, long paramLong1, long paramLong2, short[] paramArrayOfshort, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong2);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt, long[] paramArrayOflong, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, double[] paramArrayOfdouble, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, float[] paramArrayOffloat, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, short[] paramArrayOfshort, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, int[] paramArrayOfint1, long paramLong1, int[] paramArrayOfint2, long paramLong2);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, long paramLong1, int paramInt2, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, long paramLong1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt2, int[] paramArrayOfint3, long paramLong);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong1, long[] paramArrayOflong2, long paramLong2);
/*    */   
/*    */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, double[] paramArrayOfdouble, long paramLong3);
/*    */   
/*    */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat, long paramLong3);
/*    */   
/*    */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, short[] paramArrayOfshort, long paramLong3);
/*    */   
/*    */   public static native void callPPJV(long paramLong1, int paramInt1, long[] paramArrayOflong, int paramInt2, long paramLong2, int paramInt3, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong1, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint1, long paramLong1, int[] paramArrayOfint2, long paramLong2);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, int[] paramArrayOfint1, int paramInt3, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int[] paramArrayOfint1, int paramInt2, long paramLong1, int paramInt3, int[] paramArrayOfint2, long paramLong2);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, float[] paramArrayOffloat, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, short[] paramArrayOfshort, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint1, int paramInt5, int[] paramArrayOfint2, float[] paramArrayOffloat, long paramLong);
/*    */   
/*    */   public static native void callPPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint1, int paramInt5, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong);
/*    */   
/*    */   public static native void callPPPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*    */   
/*    */   public static native void callPJPPV(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPPV(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPJJPV(long paramLong1, int paramInt, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*    */   
/*    */   public static native void callPPPPV(long paramLong1, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPPV(long[] paramArrayOflong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt, long paramLong);
/*    */   
/*    */   public static native void callPPPPV(int paramInt1, long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void callPPPPV(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong1, long[] paramArrayOflong2, long[] paramArrayOflong3, long paramLong2);
/*    */   
/*    */   public static native void callPJPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native void callPPPPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void callPPPPV(int paramInt1, int paramInt2, long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt3, long paramLong2);
/*    */   
/*    */   public static native void callPJPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long[] paramArrayOflong, int paramInt4, int[] paramArrayOfint, long paramLong3);
/*    */   
/*    */   public static native void callPJJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, double[] paramArrayOfdouble, long paramLong5);
/*    */   
/*    */   public static native void callPJJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, float[] paramArrayOffloat, long paramLong5);
/*    */   
/*    */   public static native void callPJJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint, long paramLong5);
/*    */   
/*    */   public static native void callPJJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long[] paramArrayOflong, long paramLong5);
/*    */   
/*    */   public static native void callPJJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, short[] paramArrayOfshort, long paramLong5);
/*    */   
/*    */   public static native void callPPPPPV(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOflong, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*    */   
/*    */   public static native void callPPPPPV(int paramInt1, int paramInt2, long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, long paramLong2);
/*    */   
/*    */   public static native void callPPPPPV(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong1, long[] paramArrayOflong2, long[] paramArrayOflong3, long[] paramArrayOflong4, long paramLong2);
/*    */   
/*    */   public static native void callPPPPPV(long paramLong1, int paramInt1, long[] paramArrayOflong, int paramInt2, int paramInt3, int paramInt4, long paramLong2, int paramInt5, long paramLong3, int paramInt6, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native void callPPPPPPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, long[] paramArrayOflong, long paramLong3);
/*    */   
/*    */   public static native boolean callPPZ(int paramInt, int[] paramArrayOfint, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native boolean callPPPPZ(int paramInt1, int paramInt2, int paramInt3, float paramFloat, float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, float[] paramArrayOffloat4, long paramLong); }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\JNI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */