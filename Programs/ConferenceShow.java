import java.util.Iterator;

/**
 * A show that is introduced by a guest speaker. Realizes the
 * role of a concrete decorator in the Decorator design pattern.
 */
public class ConferenceShow implements Show, Cloneable
{
    private Show aDecorated;
    private int aTime;
    private String aSpeaker;

    /**
     * @param pSpeaker The name of the speaker.
     * @param pTime The amount of time the speaker will speak.
     * @param pDecorated The show being discussed by the speaker.
     */
    public ConferenceShow(String pSpeaker, int pTime, Show pDecorated)
    {
        aDecorated = pDecorated;
        aTime = pTime;
        aSpeaker = pSpeaker;
    }

    /* (non-Javadoc)
     * Perform a deep copy of the object, resulting in a distinct object graph.
     * @see java.lang.Object#clone()
     */

    @Override
    public Iterator<Movie> iterator()
    {
        return aDecorated.iterator(); // Example of undecorated delegation.
    }

    @Override
    public String description()
    {
        return String.format("%s introducing %s", aSpeaker, aDecorated.description());
    }

    @Override
    public int runningTime()
    {
        return aTime + aDecorated.runningTime();
    }

    @Override
    public ConferenceShow clone() {
        try {
            ConferenceShow clone = (ConferenceShow) super.clone();
            clone.aDecorated = aDecorated.clone();
            return clone;

        }

        catch(CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}