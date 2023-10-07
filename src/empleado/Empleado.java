package empleado;

public class Empleado {

	private static float hExtraValor = 30;
	
	public static float calculanominabruta(TipoEmpleado tipo, float ventasMes, float horasExtra)
	{
		float salario;
		
		//Tipo de empleado
		
		if(tipo == TipoEmpleado.encargado)
		{
			salario = 2500;
		}
		else if(tipo == TipoEmpleado.vendedor)
		{
			salario = 2000;
		}
		else
		{
			salario = -1;
		}
		
		//Cantidad de ventas
		
		if(ventasMes >= 1000 && ventasMes < 1500)
		{
			salario = salario + 100;
		}
		else if(ventasMes >= 1500)
		{
			salario = salario + 200;
		}
		
		
		//Horas extra
		
		if( horasExtra > 0)
		{
			salario = salario + hExtraValor * horasExtra;
		}
		
		return salario;
	}
	
	public static float calculoNominaNeta(float nominaBruta)
	{
		float salarioNeto;
		
		//Sin Comisión
		
		if(nominaBruta < 2100 && nominaBruta > 0) {
			salarioNeto = nominaBruta;
		}
		else if (nominaBruta >= 2100 && nominaBruta < 2500)//Comision 15%
		{
			salarioNeto = nominaBruta * (float) 0.85;
		}
		else if (nominaBruta > 2500)//Comision 18%
		{
			salarioNeto = nominaBruta * (float) 0.82;
		}
		else
		{
			salarioNeto = -1;
		}
		
		return salarioNeto;
	}

}
