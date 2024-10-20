package org.example.common;

/**
 * @author : zhangxueqiu
 * @date : 2024/10/20 20:05
 * @Version: 1.0
 * @Desc :
 */
public class RangeUtil {
    public static final String SEPARATOR_HEAD = "--35bcf444-e65f-4c76-9430-7e4a68dd3d26\n";
    public static final String SEPARATOR_CONTENT_TYPE = "Content-type: binary/octet-stream\n";
    public static final String SEPARATOR_CONTENT_RANGE = "Content-range: bytes 20-30/4583\n";

    public static final String SEPARATOR_RANGE = SEPARATOR_HEAD + SEPARATOR_CONTENT_TYPE + SEPARATOR_CONTENT_RANGE;

    public static final String SEPARATOR_TAIL = "\r\n";

    public static final int BUF_SIZE_NETWORK = 8 * 1024;
    public static final int BUF_SIZE_DECRY = 512 * 1024;
}
