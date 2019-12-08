public interface Show extends Iterable<Movie>, Cloneable
{
    /**
     * @return A description of the show.
     */
    String description();


    /**
     * @return The running time of the show.
     */
    int runningTime();

    /**
     * Support for the null object pattern. By default
     * the object is not-null. Should be overriden in the
     * NullObject class.
     * @return True If it's a reference to the NullShow instance
     */
    default boolean isNull()
    {
        return false;
    }

    /**
     * @return a clone
     */
    Show clone();
}