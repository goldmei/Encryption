// Copyright (c) 1998-2016 YuYing Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION XBJOBS.1.0.0
// ============================================================================
// CHANGE LOG
// XBJOBS.1.0.0 : 2016年11月22日-下午4:18:32, meijianjun, creation
// ============================================================================

package com.goldmei.base64;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/** 
 * @ClassName: Base64 
 * @Description: Base64加密 
 * @author meijianjun
 * @date 2016年11月22日 下午4:18:32 
 *  
 */

public class Base64 {
    
    private static String str = "goldmeihua";
    
    public static void jdkBase64(){
        try {
            //Base64加密
            BASE64Encoder encoder = new BASE64Encoder();
            String encode = encoder.encode(str.getBytes());
            System.out.println("jdkencode:" + encode);

            //Base64解密
            BASE64Decoder decoder = new BASE64Decoder();
//            String decode = decoder.decodeBuffer(encode).toString();
            String decode = new String(decoder.decodeBuffer(encode));
            System.out.println("jdkdecode:" + decode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void commonsCodesBase64(){
        byte[] encodeBytes = org.apache.commons.codec.binary.Base64.encodeBase64(str.getBytes());
        System.out.println("commonencode:" + new String(encodeBytes));
        
        byte[] decodeBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encodeBytes);
        System.out.println("commondecode:" + new String(decodeBytes));
    }

    public static void bouncyCastleBase64(){
        byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(str.getBytes());
        System.out.println("bouncyencode:" + new String(encodeBytes));
        
        byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
        System.out.println("bouncydecode:" + new String(decodeBytes));
    
    }
    /** 
     * @Title: main 
     * @Description: Base64加密算法 
     * @param @param args  参数说明 
     * @return void    返回类型 
     * @throws 
     */

    public static void main(String[] args) {
        jdkBase64();
        System.out.println();
        commonsCodesBase64();
        System.out.println();
        bouncyCastleBase64();
    }

}
