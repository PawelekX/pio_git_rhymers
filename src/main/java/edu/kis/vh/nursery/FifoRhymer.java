package edu.kis.vh.nursery;

public class FifoRhymer extends DefaultCountingOutRhymer {

    public DefaultCountingOutRhymer bufferRhymer = new DefaultCountingOutRhymer();

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
