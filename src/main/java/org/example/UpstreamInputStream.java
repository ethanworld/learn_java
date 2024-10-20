package org.example;

import org.example.common.BaseInputStream;
import org.example.common.Range;
import org.example.common.RangeUtil;

import java.io.IOException;
import java.util.List;

/**
 * @author : zhangxueqiu
 * @date : 2024/10/20 19:42
 * @Version: 1.0
 * @Desc :
 */
public class UpstreamInputStream extends BaseInputStream {

    private StringBuffer stringBuffer = new StringBuffer();
    private String ctx = null;

    private int currCharIdx = 0;

    UpstreamInputStream(List<Range> rangeList) {
        for (Range range : rangeList) {
            this.buildRangeSeparator();
            this.buildRangeBody(range);
            this.buildRangeEnd();
        }
    }

    private void buildRangeSeparator() {
        stringBuffer.append(RangeUtil.SEPARATOR_HEAD);
        stringBuffer.append(RangeUtil.SEPARATOR_CONTENT_TYPE);
        stringBuffer.append(RangeUtil.SEPARATOR_CONTENT_RANGE);
    }

    private void buildRangeBody(Range range) {
        String rangeBody = new String(new byte[range.getEnd() - range.getStart() + 1]);
        stringBuffer.append(rangeBody);
    }

    private void buildRangeEnd() {
        stringBuffer.append(RangeUtil.SEPARATOR_TAIL);
    }

    public String getCheckString() {
        return stringBuffer.toString();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (currCharIdx >= stringBuffer.length()) {
            return -1;
        }
        b[off] = (byte) stringBuffer.charAt(currCharIdx);
        currCharIdx++;
        return 1;
    }
}
