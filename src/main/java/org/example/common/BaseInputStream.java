package org.example.common;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : zhangxueqiu
 * @date : 2024/10/20 19:52
 * @Version: 1.0
 * @Desc :
 */
public class BaseInputStream extends InputStream {
    @Override
    public int read() throws IOException {
        throw new IOException("DO NOT SUPPORT");
    }

    @Override
    public String toString() {
        return "BaseInputStream";
    }
}
