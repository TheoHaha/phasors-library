import theo.phasors.*;

public class main_testing {

	public static void main(String[] args) {

		MyNumber n1 = new Phasor(1, 0);
		MyNumber n2 = new Phasor(1, -120);
		MyNumber n3 = new Phasor(1, -240);
		
		Convert.toComplex(n1).show();
		Convert.toComplex(n2).show();
		Convert.toComplex(n3).show();
		
		MyNumber N = Complex.add(Convert.toComplex(n1), Convert.toComplex(n2));
		N.show();
		MyNumber N2 = Convert.toComplex(n3);
		Complex.add(N,N2).show();
	}

}
