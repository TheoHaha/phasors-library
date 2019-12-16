package theo.phasors;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The {@code Complex} class represents a complex number <i>(rectangular form)</i>. Complex numbers look like this:
 * <p><b>c = x + y*i</b></p>
 * Where:<nl>
 * <li>{@code x} is the real part</li>
 * <li>{@code y} is the imaginary part</li>
 * <li>{@code i} is the imaginary square root of -1</li>
 * </nl>
 * <p>
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Complex_number">The wiki article about complex numbers</a>
 */
public class Complex extends MyNumber
{
	
	/** The x. */
	double x;
	/** The y. */
	double y;
	
	/**
	 * Instantiates a new, empty complex number with values x=0 and y=0.
	 */
	public Complex()
	{
		x=0;
		y=0;
	}
	
	/**
	 * Instantiates a new complex number with the given values.
	 *
	 * @param x
	 * @param y
	 */
	public Complex(double x, double y)
	{
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public double getX()
	{
		return x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public double getY()
	{
		return y;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(double x)
	{
		this.x = x;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(double y)
	{
		this.y = y;
	}
	
	/**	
	 *	Prints the complex number on the console. Useful for debugging purposes.
	 */
	public void show()
	{
		String xS = Double.toString(x);
		String yS = Double.toString(y);
		if (x != 0)
		{
			if (y > 0)
			{
				System.out.println(xS+"+"+yS+"i");
			}
			else if (y < 0)
			{
				System.out.println(xS+yS+"i");
			}
			else
			{
				System.out.println(xS);
			}
		}
		else
		{
			if (y != 0)
			{
				System.out.println(yS+"i");
			}
			else
			{
				System.out.println(0);
			}
		}
	}
	
	/**
	 * Converts the complex number to a readable {@code String}.
	 *
	 * @return the string
	 */
	public String toString()
	{
		String xS = Double.toString(x);
		String yS = Double.toString(y);
		if (x != 0)
		{
			if (y > 0)
			{
				return xS+"+"+yS+"i";
			}
			else if (y < 0)
			{
				 return xS+yS+"i";
			}
			else
			{
				return xS;
			}
		}
		else
		{
			if (y != 0)
			{
				return yS+"i";
			}
			else
			{
				return "0";
			}
		}
	}
	
	/**
	 * Parses a complex number from a given string (essentially converts from {@code String} to {@link Complex})
	 *
	 * @param s the given {@code String}
	 * @return the parsed {@code Complex}
	 */
	public static Complex parseComplex(String s)
	{
		String sanitizedText = s.replaceAll(regex, " ");
		sanitizedText = sanitizedText.replaceAll("-"," -");
		Scanner scanner = new Scanner(sanitizedText);
		
		int i;
		Double[] xyList = {0.0 , 0.0};
		for(i=0; scanner.hasNextDouble(); i++)
		{
			xyList[i] = scanner.nextDouble();
		}
		scanner.close();
		
		if(i==1)
		{
			if (s.contains("i"))
			{
				return new Complex(0,xyList[0]);
			}
			else
			{
				return new Complex(xyList[0],0);
			}
		}
		else
		{
			return new Complex(xyList[0],xyList[1]);
		}
	}
	
	//	Operations
	
	/**
	 * Adds the.
	 *
	 * @param a1 the a 1
	 * @param a2 the a 2
	 * @return the complex
	 */
	public static Complex add(Complex a1, Complex a2)
	{
		return new Complex(a1.x + a2.x, a1.y + a2.y);
	}
	
	/**
	 * Adds the.
	 *
	 * @param a1 the a 1
	 * @param b2 the b 2
	 * @return the complex
	 */
	// 	Phasors invlolved
	private static Complex add(Complex a1, Phasor b2)
	{
		Complex a2 = Convert.toComplex(b2);
		return Complex.add(a1, a2);
	}
	
	/**
	 * Adds the.
	 *
	 * @param b1 the b 1
	 * @param a2 the a 2
	 * @return the complex
	 */
	private static Complex add(Phasor b1, Complex a2)
	{
		Complex a1 = Convert.toComplex(b1);
		return Complex.add(a1, a2);
	}
	
	/**
	 * Adds the.
	 *
	 * @param b1 the b 1
	 * @param b2 the b 2
	 * @return the complex
	 */
	private static Complex add(Phasor b1, Phasor b2)
	{
		Complex a1 = Convert.toComplex(b1);
		Complex a2 = Convert.toComplex(b2);
		return Complex.add(a1, a2);
	}
	
	/**
	 * Adds the.
	 *
	 * @param n1 the n 1
	 * @param n2 the n 2
	 * @return the complex
	 */
	public static Complex add(MyNumber n1, MyNumber n2)
	{
		if(n1.isComplex())
		{
			if(n2.isComplex())
				return Complex.add((Complex)n1, (Complex)n2);
			else
				return Complex.add((Complex)n1, (Phasor)n2);
		}
		else
		{
			if(n2.isComplex())
				return Complex.add((Phasor)n1, (Complex)n2);
			else
				return Complex.add((Phasor)n1, (Phasor)n2);
		}
	}
	
	/**
	 * Sub.
	 *
	 * @param a1 the a 1
	 * @param a2 the a 2
	 * @return the complex
	 */
	//	Subtraction
	private static Complex sub(Complex a1, Complex a2)
	{
		return new Complex(a1.x - a2.x, a1.y - a2.y);
	}
	
	/**
	 * Sub.
	 *
	 * @param a1 the a 1
	 * @param b2 the b 2
	 * @return the complex
	 */
	// 	Phasors invlolved
	private static Complex sub(Complex a1, Phasor b2)
	{
		Complex a2 = Convert.toComplex(b2);
		return Complex.sub(a1, a2);
	}
	
	/**
	 * Sub.
	 *
	 * @param b1 the b 1
	 * @param a2 the a 2
	 * @return the complex
	 */
	private static Complex sub(Phasor b1, Complex a2)
	{
		Complex a1 = Convert.toComplex(b1);
		return Complex.sub(a1, a2);
	}
	
	/**
	 * Sub.
	 *
	 * @param b1 the b 1
	 * @param b2 the b 2
	 * @return the complex
	 */
	private static Complex sub(Phasor b1, Phasor b2)
	{
		Complex a1 = Convert.toComplex(b1);
		Complex a2 = Convert.toComplex(b2);
		return Complex.sub(a1, a2);
	}
	
	/**
	 * Sub.
	 *
	 * @param n1 the n 1
	 * @param n2 the n 2
	 * @return the complex
	 */
	public static Complex sub(MyNumber n1, MyNumber n2)
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
				return Complex.sub(a1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Complex.sub(a1, b2);
			}
		}
		else if(n1.getClass()==b1.getClass())
		{
			b1 = (Phasor)n1;
			if(n2.getClass()==a2.getClass())
			{
				a2 = (Complex)n2;
				return Complex.sub(b1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Complex.sub(b1, b2);
			}
		}
		return new Complex();
	}
	
	/**
	 * Mul.
	 *
	 * @param a1 the a 1
	 * @param a2 the a 2
	 * @return the complex
	 */
	//	Multiplication
	private static Complex mul(Complex a1, Complex a2)
	{
		return new Complex(a1.x * a2.x - a1.y * a2.y, a1.y * a2.x + a1.x * a2.y);
	}
	
	/**
	 * Mul.
	 *
	 * @param a1 the a 1
	 * @param b2 the b 2
	 * @return the complex
	 */
	// 	Phasors invlolved
	private static Complex mul(Complex a1, Phasor b2)
	{
		Complex a2 = Convert.toComplex(b2);
		return Complex.mul(a1, a2);
	}
	
	/**
	 * Mul.
	 *
	 * @param b1 the b 1
	 * @param a2 the a 2
	 * @return the complex
	 */
	private static Complex mul(Phasor b1, Complex a2)
	{
		Complex a1 = Convert.toComplex(b1);
		return Complex.mul(a1, a2);
	}
	
	/**
	 * Mul.
	 *
	 * @param b1 the b 1
	 * @param b2 the b 2
	 * @return the complex
	 */
	private static Complex mul(Phasor b1, Phasor b2)
	{
		Complex a1 = Convert.toComplex(b1);
		Complex a2 = Convert.toComplex(b2);
		return Complex.mul(a1, a2);
	}
	
	/**
	 * Mul.
	 *
	 * @param n1 the n 1
	 * @param n2 the n 2
	 * @return the complex
	 */
	public static Complex mul(MyNumber n1, MyNumber n2)
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
				return Complex.mul(a1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Complex.mul(a1, b2);
			}
		}
		else if(n1.getClass()==b1.getClass())
		{
			b1 = (Phasor)n1;
			if(n2.getClass()==a2.getClass())
			{
				a2 = (Complex)n2;
				return Complex.mul(b1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Complex.mul(b1, b2);
			}
		}
		return new Complex();
	}
	
	/**
	 * Div.
	 *
	 * @param a1 the a 1
	 * @param a2 the a 2
	 * @return the complex
	 */
	//	Division
	private static Complex div(Complex a1, Complex a2)
	{
		Phasor b1 = Convert.toPhasor(a1);
		Phasor b2 = Convert.toPhasor(a2);
		return Convert.toComplex(Phasor.div(b1, b2));
	}
	
	/**
	 * Div.
	 *
	 * @param a1 the a 1
	 * @param b2 the b 2
	 * @return the complex
	 */
	// 	Phasors invlolved
	private static Complex div(Complex a1, Phasor b2)
	{
		Complex a2 = Convert.toComplex(b2);
		return Complex.div(a1, a2);
	}
	
	/**
	 * Div.
	 *
	 * @param b1 the b 1
	 * @param a2 the a 2
	 * @return the complex
	 */
	private static Complex div(Phasor b1, Complex a2)
	{
		Complex a1 = Convert.toComplex(b1);
		return Complex.div(a1, a2);
	}
	
	/**
	 * Div.
	 *
	 * @param b1 the b 1
	 * @param b2 the b 2
	 * @return the complex
	 */
	private static Complex div(Phasor b1, Phasor b2)
	{
		Complex a1 = Convert.toComplex(b1);
		Complex a2 = Convert.toComplex(b2);
		return Complex.div(a1, a2);
	}
	
	/**
	 * Div.
	 *
	 * @param n1 the n 1
	 * @param n2 the n 2
	 * @return the complex
	 */
	public static Complex div(MyNumber n1, MyNumber n2)
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
				return Complex.div(a1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Complex.div(a1, b2);
			}
		}
		else if(n1.getClass()==b1.getClass())
		{
			b1 = (Phasor)n1;
			if(n2.getClass()==a2.getClass())
			{
				a2 = (Complex)n2;
				return Complex.div(b1, a2);
			}
			else if(n2.getClass()==b2.getClass())
			{
				b2 = (Phasor)n2;
				return Complex.div(b1, b2);
			}
		}
		return new Complex();
	}
	
}
