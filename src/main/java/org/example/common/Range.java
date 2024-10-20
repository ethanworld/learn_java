package org.example.common;

/**
 * @author : zhangxueqiu
 * @date : 2024/10/20 18:33
 * @Version: 1.0
 * @Desc :
 */
public class Range {
    private int start;
    private int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
