public class SponsoredConcert extends Concert {

    private String aSponsor;
    private int sponsorTime;

    public SponsoredConcert(String pTitle, String pPerformer, int pTime, String pSponsor, int pSponsorTime) {
        super(pTitle, pPerformer, pTime);
        aSponsor = pSponsor;
        sponsorTime = pSponsorTime;
    }


    @Override
    public int time() {
        return time() + sponsorTime;
    }

    @Override
    public String extra() {
        return " by " + performer() + " and sponsored by " + aSponsor;
    }

}
