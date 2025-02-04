package edu.kis.vh.nursery;

public class FIFORhymer extends defaultCountingOutRhymer {

    public defaultCountingOutRhymer bufferRhymer = new defaultCountingOutRhymer();

    @Override
    public int countOut() {
        while (!callCheck())
            bufferRhymer.countIn(super.countOut());

        int ret = bufferRhymer.countOut();

        while (!bufferRhymer.callCheck())
            countIn(bufferRhymer.countOut());

        return ret;
    }
}
