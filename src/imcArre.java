import javax.swing.JOptionPane;

public class imcArre {


	String nombres[];
	String telefono[];
	Double imcArray[];
	String resultadoImc[];
	
	public void iniciar() {
		menu();
		ValidarOpc(0);		
	}

	public void menu() {
		
		int opc = 0;

		
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("----------MENU----------\n"
					+ "1.registar persona \n" 
					+ "2.imprimir datos\n" 
					+ "3.salir\n\n" 
					+ "--------------------"));
			ValidarOpc(opc);
		}while(opc != 3);
		
		
		
	}

	public void ValidarOpc(int menu) {
		switch (menu) {
		case 1:
			Ingresardatos();
			break;
		case 2:
			imprimirDatos();
			break;
			
		case 3:
			System.out.println("Hasta luego!");
			break;
			
		default:
			System.out.println("Opcion incorrecta");
			break;
		}

	}

	public void Ingresardatos() {

		double peso = 0;
		double altura = 0;

		int cant = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de personas a registrar: "));

		nombres = new String[cant];
		telefono = new String[cant];
		resultadoImc = new String[cant];
		imcArray= new Double[cant];
		
		double imc = 0;

		String resultado;

		for (int i = 0; i < cant; i++) {
			nombres[i] = JOptionPane.showInputDialog("Ingrese nombre: ");
			telefono[i] = JOptionPane.showInputDialog("Ingrese número de telefono:");
			peso = Double.parseDouble(JOptionPane.showInputDialog("ingrese peso: "));
			altura = Double.parseDouble(JOptionPane.showInputDialog("ingrese altura: "));

			imc = CalcularImc(peso, altura);

			imcArray[i]=imc;
			
			resultado = Resultado(imc);

			resultadoImc[i] = resultado;

		}
		
	}

	private double CalcularImc(double peso, double altura) {


		double imc = 0;

		imc = peso / (altura * altura);

		return imc;

	}
	
	private String Resultado(double imc) {

		String res = "";

		if (imc < 18) {
			res = "anorexia";
		} else if (imc >= 18 && imc < 20) {
			res = "Delgades";
		} else if (imc >= 20 && imc < 27) {
			res = "Normalidad";
		} else if (imc >= 27 && imc < 30) {
			res= "Obesidad grado 1";
		} else if (imc >= 30 && imc < 35) {
			res= "Obesidad grado 2";
		} else if (imc >= 35 && imc < 40) {
			res= "Obesidad grado 3";
		} else {
			res= "Obesidad morbida";
		}

		return res;

	}
	
	private void imprimirDatos() {

		for (int i = 0; i < nombres.length; i++) {
			System.out.println("nombre: " +nombres[i] +"\n El telefono: "+ telefono[i] + "\n resultado :"+ resultadoImc[i]+ "\n su imc es: "+imcArray[i]);
			
		}

	}

	

	

}




	

