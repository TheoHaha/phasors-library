package theo.phasors;

import java.lang.Math;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * This is a class that contains a bunch of methods all about converting {@link MyNumber} objects
 * into different types, such as {@code String}.
 */
public class Convert
{
	/**
     * Don't let anyone instantiate this class.
     */
	private Convert() {}
	
	/**
	 * Converts a given {@link Complex} to {@link Phasor}. Displays an error message dialog if it fails.
	 * Private method, used by {@code toPhasor(MyNumber n)}.
	 *
	 * @param a the given {@code Complex}
	 * @return the given number converted to {@code Phasor}
	 * @see <a href="https://youtu.be/yRDyXImmrVo">A quick video on the formula</a>
	 */
	private static Phasor toPhasor(Complex a)
	{
		try
		{
			double z = Math.hypot(a.x, a.y);
			double phase = Math.atan(a.y/a.x);
			phase = Math.toDegrees(phase);
			return new Phasor(z, phase);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(new JPanel(), "Error! Division by zero.\nComplex number conversion failed!", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	/**
	 * Converts a given {@link MyNumber} object from {@link Complex} to {@link Phasor}. Displays an error message dialog if it fails.
	 *
	 * @param n the given {@code MyNumber}
	 * @return the given {@code MyNumber} converted to {@code Phasor} (if it is a {@code Complex}) 
	 * <p><b>or</b>
	 * <p>the given {@code MyNumber} as is (if it already is a {@code Phasor})
	 * @see <a href="https://youtu.be/yRDyXImmrVo">A quick video on the formula</a>
	 */
	public static Phasor toPhasor(MyNumber n)
	{
		if(n.isComplex())
			return Convert.toPhasor((Complex)n);
		else
			return (Phasor)n;
	}
	
	/**
	 * Converts a given {@link Phasor} to {@link Complex}. Private method, used by {@code toPhasor(MyNumber n)}.
	 *
	 * @param b the given {@code Phasor}
	 * @return the given number converted to {@code Complex}
	 * @see <a href="https://youtu.be/yMYXbWNau2Y">A quick video on the formula</a>
	 */
	private static Complex toComplex(Phasor b)
	{
		double phaseB = Math.toRadians(b.phase);
		double x = b.z * Math.cos(phaseB);
		double y = b.z * Math.sin(phaseB);
		return new Complex(x,y);
	}
	
	/**
	 * Converts a given {@link MyNumber} object from {@link Phasor} to {@link Complex}.
	 *
	 * @param n the given {@code MyNumber}
	 * @return the given {@code MyNumber} converted to {@code Complex} (if it is a {@code Phasor}) 
	 * <p><b>or</b>
	 * <p>the given {@code MyNumber} as is (if it already is a {@code Complex})
	 * @see <a href="https://youtu.be/yMYXbWNau2Y">A quick video on the formula</a>
	 */
	public static Complex toComplex(MyNumber n)
	{
		if(n.isPhasor())
			return Convert.toComplex((Phasor)n);
		else
			return (Complex)n;
	}

	/**
	 * Converts the given {@link MyNumber} object to a readable string.
	 *
	 * @param n the given {@code MyNumber}
	 * @return the string
	 */
	public static String toString(MyNumber n)
	{
		return n.toString();
	}
}
