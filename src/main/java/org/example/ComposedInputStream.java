package org.example;

import org.example.common.BaseInputStream;

import java.io.IOException;

/**
 * @author : zhangxueqiu
 * @date : 2024/10/20 20:15
 * @Version: 1.0
 * @Desc :
 */
public class ComposedInputStream extends BaseInputStream {
    private final DecryptedInputStream decryptedInputStream;

    public ComposedInputStream(DecryptedInputStream decryptedInputStream) {
        this.decryptedInputStream = decryptedInputStream;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return this.decryptedInputStream.read(b, off, len);
    }
}
