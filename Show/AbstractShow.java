public abstract class AbstractShow implements Show{
    private String aTitle;
    private int aTime;

    private Show aRecommended;


    protected AbstractShow(String pTitle, int pTime) {
        aTitle = pTitle;
        aTime = pTime;

    }

    public void setRecommended(Show pShow) {
        aRecommended = pShow;
    }

    public String getTitle()
    {
        return aTitle;
    }

    public void setTitle(String pTitle)
    {
        aTitle = pTitle;
    }

    public String title()
    {
        return aTitle;
    }

    public abstract int time();

    public void setTime(int pTime)
    {
        aTime = pTime;
    }

    @Override
    public String description()
    {
        return String.format("%s %s (%s minutes)", title(), extra(), time());
    }

    protected abstract String extra();

    @Override
    public AbstractShow clone() {
        try {
            AbstractShow clone = (AbstractShow) super.clone();
            return clone;
        }
        catch(CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }


}
