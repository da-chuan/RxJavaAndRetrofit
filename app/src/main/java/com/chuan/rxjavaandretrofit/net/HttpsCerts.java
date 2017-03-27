package com.chuan.rxjavaandretrofit.net;

import com.chuan.rxjavaandretrofit.app.CustomApp;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/**
 * Created by admin on 2017/3/27.
 */

public class HttpsCerts {

    public static SSLSocketFactory getSocketFactory() {
        try {
            List<InputStream> certsList = new ArrayList<>();
            try {
                String[] certsFiles = CustomApp.getInstance().getAssets().list("certs");
                if (certsFiles != null){
                    for (String cert : certsFiles){
                        InputStream is = CustomApp.getInstance().getAssets().open("certs/" + cert);
                        certsList.add(is);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            try {
                for (int i = 0, size = certsList.size(); i < size; ) {
                    InputStream certificate = certsList.get(i);
                    String certificateAlias = Integer.toString(i++);
                    keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));
                    if (certificate != null)
                        certificate.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            sslContext.init(null,trustManagerFactory.getTrustManagers(), new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
