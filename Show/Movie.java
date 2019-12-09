/**
 * Represents a show that consists of the screening of a single movie.
 */
public class Movie extends AbstractShow
{
	private int aYear;
	
	public Movie(String pTitle, int pYear, int pTime)
	{
		super(pTitle, pTime);
		aYear = pYear;
	}

	@Override
	public String extra() {
		return "in " + aYear;
	}

	@Override
	public int time() {
		return time();
	}

	@Override
	public Movie clone() {
		Movie clone = (Movie) super.clone();
		return clone;

	}

}
