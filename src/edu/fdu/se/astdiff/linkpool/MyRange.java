package edu.fdu.se.astdiff.linkpool;

/**
 * Created by huangkaifeng on 2018/3/12.
 *
 */
public class MyRange {


    public int type;

    public int startLineNo;
    public int endLineNo;

    public MyRange(int start,int end,int type){
        this.startLineNo = start;
        this.endLineNo = end;
        this.type = type;
    }

}
