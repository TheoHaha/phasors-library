package theo.phasors;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The {@code Phasor} class represents a phasor <i>(polar form)</i>. Phasors look like this:
 * <p><b>p = z | φ°</b></p>
 * Where:
 * <nl><li>{@code z} is the amplitude</li>
 * <li>{@code φ} is the phase in degrees</li></nl>
 * <p>
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Phasor">The wiki article about phasors</a>
 */
public class Phasor extends MyNumber
{

	/** The amplitude z. */
	double z;
	
	/** The phase φ (in degrees). */
	double phase;

	/**
	 * Instantiates a new, empty phasor with values z=0 and φ=0°.
	 */
	public Phasor()
	{
		this.z=0;
		this.phase=0;
	}
	
	/**
	 * Instantiates a new phasor with the given numbers.
	 *
	 * @param z
	 * @param phase
	 */
	public Phasor(double z, double phase)
	{
		this.z=z;
		this.phase=phase;
	}
	
	/**
	 * Gets the z.
	 *
	 * @return the z
	 */
	public double getZ()
	{
		return z;
	}
	
	/**
	 * Gets the phase (in degrees).
	 *
	 * @return the phase
	 */
	public double getPhase()
	{
		return phase;
	}
	
	/**
	 * Sets the z.
	 *
	 * @param z the new z
	 */
	public void setZ(double z)
	{
		this.z = z;
	}
	
	/**
	 * Sets the phase (in degrees).
	 *
	 * @param phase the new phase
	 */
	public void setPhase(double phase)
	{
		this.phase = phase;
	}

	/**
	 * Show.
	 */
	public void show()
	{
		System.out.println(z+" |"+phase+"°");
	}

	/**
	 * Converts the phasor to a readable {@code String}.
	 *
	 * @return the string
	 */
	public String toString()
	{
		String zS = Double.toString(z);
		String oS = Double.toString(phase);
		
		return zS+" |"+oS+"°";
	}
	
	/**
	 * Parses a phasor from a given string (essentially converts from {@code String} to {@link Phasor})
	 *
	 * @param s the given {@code String}
	 * @return the parsed {@code Phasor}
	 */
	public static Phasor parsePhasor(String s)
	{
		String sanitizedText = s.replaceAll(regex, " ");
		Scanner scanner = new Scanner(sanitizedText);
		
		int i;
		Double[] xyList = {0.0 , 0.0};
		for(i=0; scanner.hasNextDouble(); i++)
		{
			xyList[i] = scanner.nextDouble();
		}
		scanner.close();
		
		return new Phasor(xyList[0],xyList[1]);
	}

	/**
	 * Adds the.
	 *
	 * @param b1 the b 1
	 * @param b2 the b 2
	 * @return the phasor
	 */
	private static Phasor add(Phasor b1, Phasor b2)
	{
		Complex temp1 = Convert.toComplex(b1);
		Complex temp2 = Convert.toComplex(b2);
		Complex result = Complex.add(temp1, temp2);
		return Convert.toPhasor(result);
	}
	
	/**
	 * Adds the.
	 *
	 * @param b1 the b 1
	 * @param a2 the a 2
	 * @return the phasor
	 */
	private static Phasor add(Phasor b1, Complex a2)
	{
		Complex a1 = Convert.toComplex(b1);
		Complex result = Complex.add(a1, a2);
		return Convert.toPhasor(result);
	}
	
	/**
	 * Adds the.
	 *
	 * @param a1 the a 1
	 * @param b2 the b 2
	 * @return the phasor
	 */
	private static Phasor add(Complex a1, Phasor b2)
	{
		Complex a2 = Convert.toComplex(b2);
		Complex result = Complex.add(a1, a2);
		return Convert.toPhasor(result);
	}
	
	/**
	 * Adds the.
	 *
	 * @param a1 the a 1
	 * @param a2 the a 2
	 * @return the phasor
	 */
	private static Phasor add(Complex a1, Complex a2)
	{
		Complex result = Complex.add(a1, a2);
		return Convert.toPhasor(result);
	}
	
	/**
	 * Adds the.
	 *
	 * @param n1 the n 1
	 * @param n2 the n 2
	 * @return the phasor
	 */
	public static Phasor add(MyNumber n1, MyNumber n2)
	{
		Complex a1 = new Complex();
		Complex a2 = new Complex();
		Phasor b1 = new Phasor();
		Phasor b2 = new Phasor();
		if(n1.getClass()==a1.getClass())
		{
			a1 = (Complex)n1;
			if(n2.getClass()==a2.getClass())
			{
				a2 = (Complex)n2;
				return Phasor.add(a1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Phasor.add(a1, b2);
			}
		}
		else if(n1.getClass()==b1.getClass())
		{
			b1 = (Phasor)n1;
			if(n2.getClass()==a2.getClass())
			{
				a2 = (Complex)n2;
				return Phasor.add(b1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Phasor.add(b1, b2);
			}
		}
		return new Phasor();
	}

	/**
	 * Sub.
	 *
	 * @param b1 the b 1
	 * @param b2 the b 2
	 * @return the phasor
	 */
	private static Phasor sub(Phasor b1, Phasor b2)
	{
		Complex temp1 = Convert.toComplex(b1);
		Complex temp2 = Convert.toComplex(b2);
		Complex result = Complex.sub(temp1, temp2);
		return Convert.toPhasor(result);
	}
	
	/**
	 * Sub.
	 *
	 * @param b1 the b 1
	 * @param a2 the a 2
	 * @return the phasor
	 */
	private static Phasor sub(Phasor b1, Complex a2)
	{
		Complex a1 = Convert.toComplex(b1);
		Complex result = Complex.sub(a1, a2);
		return Convert.toPhasor(result);
	}
	
	/**
	 * Sub.
	 *
	 * @param a1 the a 1
	 * @param b2 the b 2
	 * @return the phasor
	 */
	private static Phasor sub(Complex a1, Phasor b2)
	{
		Complex a2 = Convert.toComplex(b2);
		Complex result = Complex.sub(a1, a2);
		return Convert.toPhasor(result);
	}
	
	/**
	 * Sub.
	 *
	 * @param a1 the a 1
	 * @param a2 the a 2
	 * @return the phasor
	 */
	private static Phasor sub(Complex a1, Complex a2)
	{
		Complex result = Complex.sub(a1, a2);
		return Convert.toPhasor(result);
	}
	
	/**
	 * Sub.
	 *
	 * @param n1 the n 1
	 * @param n2 the n 2
	 * @return the phasor
	 */
	public static Phasor sub(MyNumber n1, MyNumber n2)
	{
		Complex a1 = new Complex();
		Complex a2 = new Complex();
		Phasor b1 = new Phasor();
		Phasor b2 = new Phasor();
		if(n1.getClass()==a1.getClass())
		{
			a1 = (Complex)n1;
			if(n2.getClass()==a2.getClass())
			{
				a2 = (Complex)n2;
				return Phasor.sub(a1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Phasor.sub(a1, b2);
			}
		}
		else if(n1.getClass()==b1.getClass())
		{
			b1 = (Phasor)n1;
			if(n2.getClass()==a2.getClass())
			{
				a2 = (Complex)n2;
				return Phasor.sub(b1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Phasor.sub(b1, b2);
			}
		}
		return new Phasor();
	}

	/**
	 * Mul.
	 *
	 * @param b1 the b 1
	 * @param b2 the b 2
	 * @return the phasor
	 */
	private static Phasor mul(Phasor b1, Phasor b2)
	{
		return new Phasor(b1.z*b2.z, b1.phase+b2.phase);
	}
	
	/**
	 * Mul.
	 *
	 * @param b1 the b 1
	 * @param a2 the a 2
	 * @return the phasor
	 */
	private static Phasor mul(Phasor b1, Complex a2)
	{
		Phasor b2 = Convert.toPhasor(a2);
		return Phasor.mul(b1,b2);
	}
	
	/**
	 * Mul.
	 *
	 * @param a1 the a 1
	 * @param b2 the b 2
	 * @return the phasor
	 */
	private static Phasor mul(Complex a1, Phasor b2)
	{
		Phasor b1 = Convert.toPhasor(a1);
		return Phasor.mul(b1,b2);
	}
	
	/**
	 * Mul.
	 *
	 * @param a1 the a 1
	 * @param a2 the a 2
	 * @return the phasor
	 */
	private static Phasor mul(Complex a1, Complex a2)
	{
		Phasor b1 = Convert.toPhasor(a1);
		Phasor b2 = Convert.toPhasor(a2);
		return Phasor.mul(b1,b2);
	}
	
	/**
	 * Mul.
	 *
	 * @param n1 the n 1
	 * @param n2 the n 2
	 * @return the phasor
	 */
	public static Phasor mul(MyNumber n1, MyNumber n2)
	{
		Complex a1 = new Complex();
		Complex a2 = new Complex();
		Phasor b1 = new Phasor();
		Phasor b2 = new Phasor();
		if(n1.getClass()==a1.getClass())
		{
			a1 = (Complex)n1;
			if(n2.getClass()==a2.getClass())
			{
				a2 = (Complex)n2;
				return Phasor.mul(a1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Phasor.mul(a1, b2);
			}
		}
		else if(n1.getClass()==b1.getClass())
		{
			b1 = (Phasor)n1;
			if(n2.getClass()==a2.getClass())
			{
				a2 = (Complex)n2;
				return Phasor.mul(b1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Phasor.mul(b1, b2);
			}
		}
		return new Phasor();
	}

	/**
	 * Div.
	 *
	 * @param b1 the b 1
	 * @param b2 the b 2
	 * @return the phasor
	 */
	private static Phasor div(Phasor b1, Phasor b2)
	{
		try 
		{
			return new Phasor(b1.z/b2.z, b1.phase-b2.phase);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JPanel(), "Error! Division by zero.\nPhasor division failed!", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	/**
	 * Div.
	 *
	 * @param b1 the b 1
	 * @param a2 the a 2
	 * @return the phasor
	 */
	private static Phasor div(Phasor b1, Complex a2)
	{
		Phasor b2 = Convert.toPhasor(a2);
		return Phasor.div(b1,b2);
	}
	
	/**
	 * Div.
	 *
	 * @param a1 the a 1
	 * @param b2 the b 2
	 * @return the phasor
	 */
	private static Phasor div(Complex a1, Phasor b2)
	{
		Phasor b1 = Convert.toPhasor(a1);
		return Phasor.div(b1,b2);
	}
	
	/**
	 * Div.
	 *
	 * @param a1 the a 1
	 * @param a2 the a 2
	 * @return the phasor
	 */
	private static Phasor div(Complex a1, Complex a2)
	{
		Phasor b1 = Convert.toPhasor(a1);
		Phasor b2 = Convert.toPhasor(a2);
		return Phasor.div(b1,b2);
	}
	
	/**
	 * Div.
	 *
	 * @param n1 the n 1
	 * @param n2 the n 2
	 * @return the phasor
	 */
	public static Phasor div(MyNumber n1, MyNumber n2)
	{
		Complex a1 = new Complex();
		Complex a2 = new Complex();
		Phasor b1 = new Phasor();
		Phasor b2 = new Phasor();
		if(n1.getClass()==a1.getClass())
		{
			a1 = (Complex)n1;
			if(n2.getClass()==a2.getClass())
			{
				a2 = (Complex)n2;
				return Phasor.div(a1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Phasor.div(a1, b2);
			}
		}
		else if(n1.getClass()==b1.getClass())
		{
			b1 = (Phasor)n1;
			if(n2.getClass()==a2.getClass())
			{
				a2 = (Complex)n2;
				return Phasor.div(b1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Phasor.div(b1, b2);
			}
		}
		return new Phasor();
	}

}
