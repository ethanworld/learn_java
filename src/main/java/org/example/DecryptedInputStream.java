package org.example;

import org.example.common.BaseInputStream;

import java.io.IOException;

/**
 * @author : zhangxueqiu
 * @date : 2024/10/20 20:15
 * @Version: 1.0
 * @Desc :
 */
public class DecryptedInputStream extends BaseInputStream {


    private final EncryptedInputStream encryptedInputStream;

    DecryptedInputStream(EncryptedInputStream encryptedInputStream) {
        this.encryptedInputStream = encryptedInputStream;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return this.encryptedInputStream.read(b, off, len);
    }
}
