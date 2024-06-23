/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package com.classicmodels.javafx.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/**
 *
 * @author dhiihd
 */
public class ClassicModelsSSL {

    private ClassicModelsSSL() {
    }

    public static ClassicModelsSSL getInstance() {
        return ClassicModelSSLHolder.INSTANCE;
    }

    private static class ClassicModelSSLHolder {

        private static final ClassicModelsSSL INSTANCE = new ClassicModelsSSL();
    }

    public SSLContext getSSLContext() throws IOException, FileNotFoundException, KeyStoreException, NoSuchAlgorithmException, CertificateException, KeyManagementException, UnrecoverableKeyException {

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        // KeyStore trustStore = KeyStore.getInstance("JKS");
        String trustStorePasswd = "ulctest";
        String truststoreFile = "META-INF/classicModelsKeyStore.client.truststore";

        //  trustStore.load(new FileInputStream(truststoreFile), trustStorePasswd.toCharArray());
        trustStore.load(ClassicModelsSSL.class.getResourceAsStream(truststoreFile), trustStorePasswd.toCharArray());
        kmf.init(trustStore, trustStorePasswd.toCharArray());
        // Default trust manager is PKIX (No SunX509)
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, null);
        return sslContext;

    }
}
