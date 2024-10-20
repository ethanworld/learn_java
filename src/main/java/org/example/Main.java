package org.example;

import org.example.common.Range;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.common.RangeUtil.BUF_SIZE_NETWORK;

/**
 * @author : zhangxueqiu
 * @date : 2024/10/19 20:54
 * @Version: 1.0
 * @Desc :
 */

public class Main {
    public static void main(String[] args) throws IOException {
        List<Range> rangeList = new ArrayList<>();
        rangeList.add(new Range(0, 15));
        rangeList.add(new Range(32, 63));

        UpstreamInputStream upstreamInputStream = new UpstreamInputStream(rangeList);
        String checkStr = upstreamInputStream.getCheckString();

        EncryptedInputStream encryptedInputStream = new EncryptedInputStream(upstreamInputStream, rangeList);
        DecryptedInputStream decryptedInputStream = new DecryptedInputStream(encryptedInputStream);
        ComposedInputStream composedInputStream = new ComposedInputStream(decryptedInputStream);

        StringBuilder builder = new StringBuilder();
        while (true) {
            byte[] buf = new byte[BUF_SIZE_NETWORK];
            int len = composedInputStream.read(buf, 0, BUF_SIZE_NETWORK);
            builder.append(Arrays.toString(buf));
            if (len == -1) {
                break;
            }
        }

        if (checkStr.contentEquals(builder)) {
            System.out.println("successful");
        } else {
            System.out.println("failed");
        }

    }
}