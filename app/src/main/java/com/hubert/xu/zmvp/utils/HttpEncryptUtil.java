package com.hubert.xu.zmvp.utils;

import android.util.Base64;
import android.util.Log;

import com.hubert.xu.zmvp.base.MApplication;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/14
 * Desc  : AES加密请求参数
 */

public class HttpEncryptUtil {

    /**
     * 1. App生成AES对称加密密匙。
     * 2. 使用AES密匙对请求参数加密。
     * 3. 使用RSA公钥对AES密匙进行加密。
     * 4. 发送AES加密后的请求参数以及RSA加密后的AES密匙。
     * 5. 服务端使用RSA私钥加密后的AES密匙进行解密得到AES密匙。
     * 6. 使用解密后得到的AES密匙对请求参数进行解密。
     */

    /**
     * 生成对称密匙
     *
     * @return
     */
    public static SecretKeySpec generateSymmetric() {
        // Set up secret key spec for 128-bit AES encryption and decryption
        SecretKeySpec sks = null;
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            // 设置生成随机数的种子
            sr.setSeed("any data used as random seed".getBytes());
            // 生成Key
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            // AES密匙长度最少为128位，推荐为256位
            kg.init(256, sr);
            // 产生密匙
            sks = new SecretKeySpec((kg.generateKey()).getEncoded(), "AES");
            System.out.println("AES KEY: " + sks);
        } catch (Exception e) {
            Log.e("generateSymmetric", "AES secret key spec error");
        }
        return sks;
    }

    /**
     * 将对称密匙转为Base64字符串格式
     *
     * @param key
     * @return
     */
    public static String ConvertSymmetricKeyToString(SecretKeySpec key) {
        String symmetricKey = null;
        symmetricKey = Base64.encodeToString(key.getEncoded(), Base64.DEFAULT);
        return symmetricKey;
    }

    /**
     * 使用AES加密数据
     *
     * @param symmKey 密匙
     * @param data    待加密数据
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static String encryptDataWithSymmetricKey(SecretKeySpec symmKey, String data) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] toBeCiphred = data.getBytes("UTF-8");
        String encryptedData = null;
        try {
            // 指定加密模式为CBC或CFB模式，可带上PKCS5Padding填充，因为默认使用的ECB模式不安全。
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, symmKey);
            byte[] encodedBytes = c.doFinal(toBeCiphred);
            System.out.println("BYTE STRING (ASYMM): " + encodedBytes);
            encryptedData = Base64.encodeToString(encodedBytes, Base64.DEFAULT);
        } catch (Exception e) {
            Log.e("encryptDataException", "AES encryption error");
            throw new RuntimeException(e);
        }
        return encryptedData;
    }

    /**
     * 添加Https证书，暂时未添加到RetrofitClient
     */
    public static void getUnSafeOkHttpClient() {
        try {
            String cername = "test";
            BufferedInputStream certInput = new BufferedInputStream(MApplication.getApplication().getAssets().open(cername));
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate serverCert = (X509Certificate) certificateFactory.generateCertificate(certInput);
            X509TrustManager[] trustAllCerts = new X509TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                            // 不校验客户端证书
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String authType) throws CertificateException {
                            // 不校验服务端证书
                            if (x509Certificates == null) {
                                throw new IllegalArgumentException("Check server x509Certificates is null");
                            }

                            if (x509Certificates.length < 0) {
                                throw new IllegalArgumentException("Check server x509Certificates is empty");
                            }
                            String cername = "test";
                            try {
                                BufferedInputStream certInput = new BufferedInputStream(MApplication.getApplication().getAssets().open(cername));
                                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                                X509Certificate serverCert = (X509Certificate) certificateFactory.generateCertificate(certInput);
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (CertificateException e) {
                                e.printStackTrace();
                            }
                            for (X509Certificate x509Certificate : x509Certificates) {
                                x509Certificate.checkValidity();
                                try {
                                    x509Certificate.verify(serverCert.getPublicKey());
                                } catch (NoSuchAlgorithmException e) {
                                    e.printStackTrace();
                                } catch (InvalidKeyException e) {
                                    e.printStackTrace();
                                } catch (NoSuchProviderException e) {
                                    e.printStackTrace();
                                } catch (SignatureException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, null);
            // 指定支持的Host
            HostnameVerifier hostnameVerifier = (hostname, session) -> {
                // 校验服务端证书域名
                HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
                boolean verify = defaultHostnameVerifier.verify("域名", session);
                return verify;
            };
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .hostnameVerifier(hostnameVerifier)
                    .sslSocketFactory(sslContext.getSocketFactory(), trustAllCerts[0])
                    .build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
