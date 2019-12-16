package theo.phasors;

// TODO: Convert all numbers from double to BigDecimal
// import java.math.BigDecimal;

/**
 * The class MyNumber represents either a {@link Phasor} or a {@link Complex}. It is the superclass of both of them.
 */
public class MyNumber
{
	
	/** A regular expression which is useful for the parsing methods. Accessible only by this package's classes. */
	protected static String regex = "[^[0-9]\\\\.\\\\-]";
	
	/**
	 * Parses a {@code Complex} or a {@code Phasor} from the given {@code String}.
	 *
	 * @param s the {@code String} from which we parse
	 * @return a new {@code Phasor} or {@code Complex}
	 */
	public static MyNumber parseMyNumber(String s)
	{
		if (s.contains("|"))
			return Phasor.parsePhasor(s);
		else
			return Complex.parseComplex(s);
	}
	
	/**
	 * Prints the number on the console. Useful for debugging purposes.
	 */
	public void show()
	{
		if (this.getClass()==Phasor.class)
			((Phasor)this).show();
		else if (this.getClass()==Complex.class)
			((Complex)this).show();
	}
	
	/**
	 * Converts the {@code MyNumber} object to a readable string.
	 *
	 * @return the string
	 */
	public String toString()
	{
		if (this.isPhasor())
			return ((Phasor)this).toString();
		else
			return ((Complex)this).toString();
	}
	
	/**
	 * Checks if the {@code MyNumber} object is {@link Complex}.
	 *
	 * @return true, if it is a complex number
	 */
	public boolean isComplex()
	{
		if (this.getClass()==Complex.class)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if the {@code MyNumber} object is {@link Phasor}.
	 *
	 * @return true, if it is a phasor
	 */
	public boolean isPhasor()
	{
		if (this.getClass()==Phasor.class)
			return true;
		else
			return false;
	}
}
