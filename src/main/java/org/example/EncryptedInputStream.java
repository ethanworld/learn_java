package org.example;

import org.example.common.BaseInputStream;
import org.example.common.Range;
import org.example.common.RangeUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.example.common.RangeUtil.BUF_SIZE_DECRY;

/**
 * @author : zhangxueqiu
 * @date : 2024/10/20 20:15
 * @Version: 1.0
 * @Desc :
 */
public class EncryptedInputStream extends BaseInputStream {

    private UpstreamInputStream upstreamInputStream;
    private List<Range> rangeList;

    EncryptedInputStream(UpstreamInputStream upstreamInputStream, List<Range> rangeList) {
        this.upstreamInputStream = upstreamInputStream;
        this.rangeList = rangeList;
    }

    private void readSeparator() throws IOException {
        int tmpBufSize = 64;
        byte[] tmfBuf = new byte[tmpBufSize];
        int off = 0, realLen = 0;
        int bufRemaining = tmpBufSize;
        while (realLen < RangeUtil.SEPARATOR_RANGE.length()) {
            int len = this.upstreamInputStream.read(tmfBuf, off, bufRemaining);
            off += len;
            realLen += len;
            bufRemaining -= len;
            if (bufRemaining <= 0) {
                bufRemaining = tmpBufSize;
                off = 0;
            }
        }
        System.out.print("read separator: " + realLen);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        this.readSeparator();
        return this.upstreamInputStream.read(b, off, len);
    }
}
