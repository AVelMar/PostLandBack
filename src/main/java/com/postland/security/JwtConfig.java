package com.postland.security;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIBOgIBAAJBAJMKCZ8sejFPXfTNe0RFon2Pirt/b4x5gdQA/aJf4drWxPy1TZ+D\r\n"
			+ "NFY8z/4ttUS9pEw27a0B/El/uheHI0yzGN8CAwEAAQJARyrMjWYRnlwztZDe4KRz\r\n"
			+ "iSI4m5eKfgsxc1Mnb7fIsQoShwgyyjRp+0bPR8SBC1MSCGsp3grBQRtmAI+4pKHk\r\n"
			+ "gQIhAO3PnI4R2G6ngyLDGAAvIGedU30YIbPROFyjBmvhGVW5AiEAnkkYijQOr1h1\r\n"
			+ "zFzSXAz+bblvZespgWKMIkgZucYqL1cCIEUpgCqBXiSwax8NBknnatE3nDRhdEvL\r\n"
			+ "qUynzRJK4QdhAiA5y8L0I9IA4LISrwn4pp34fq9Ybae4IL2+fsk19k/M/QIhAMFH\r\n"
			+ "7DD5+R7XiElxxiBofHJCqOdCXZKtM6WpFDHl8Kcu\r\n" + "-----END RSA PRIVATE KEY-----";

	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJMKCZ8sejFPXfTNe0RFon2Pirt/b4x5\r\n"
			+ "gdQA/aJf4drWxPy1TZ+DNFY8z/4ttUS9pEw27a0B/El/uheHI0yzGN8CAwEAAQ==\r\n" + "-----END PUBLIC KEY-----";
}