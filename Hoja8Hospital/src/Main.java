/**
 * @author Ingebor Rubio 19003
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		PriorityQueue<String> priority = new PriorityQueue<String>();
		// TODO Auto-generated method stub
		System.out.println("------------------");
		System.out.println("|   Bienvenido   |");
		System.out.println("------------------");
		
		File archive = new File("pacientes.txt");
		if(archive.exists()) {
			FileReader fileRe = new FileReader(archive);
			BufferedReader buffRea = new BufferedReader(fileRe);
			Scanner read = new Scanner(System.in);
			String reading = "";
			System.out.println("Este es el listado de pacientes sin ordenar por prioridad: ");
			while((reading = buffRea.readLine()) != null) {
				String[] eachLine = reading.split(",");
				String name = eachLine[0].toLowerCase();
				String illness = eachLine[1].toLowerCase();
				String prior = eachLine[2].toLowerCase();
				String patient = prior+", "+name+", "+illness;
				System.out.println(patient);
				priority.add(patient);
			}
			
			System.out.println("\n¿Cual implementacion desea utilizar?\n1. JCF\n2. VectorHeap");
			try {
				int firstOp = read.nextInt();
				if(firstOp == 1) {
					boolean flag = true;
					while(flag) {
						try {
							System.out.println("\n¿Que desea realizar?\n1. Ver pacientes en lista\n2. Ver paciente siguiente\n3. Salir");
							int secondOp = read.nextInt();
							if(secondOp==1) {
								System.out.println("\n----------------------------------------------------");
								while(!priority.isEmpty()) { 
									System.out.println(priority.poll());
								}
								System.out.println("----------------------------------------------------\n");
								flag = false;
							}
							else if (secondOp==2) {
								System.out.println("\n------------------------------------------------------------------------");
								System.out.println("El siguiente paciente es: "+ priority.remove());
								System.out.println("------------------------------------------------------------------------\n");
								}
							else if (secondOp==3) {
								flag=false;
							}
							else {
								System.out.println("Ha sido ingresada una opcion no válida");
							}
						}
						catch (Exception a) {
							System.out.println("No ha sido ingresada una opcion correcta");
							flag = false;
						}
					}
				}
				else if (firstOp==2) {
					System.out.println("Segunda opcion");
				}
				else {
					System.out.println("No ha sido ingresada una opción correcta");
				}
				
			}
			catch(Exception E) {
				System.out.println("No ha sido ingresada una opción válida");
			}
		}
		else {
			System.out.println("No hay datos en el archivo");
		}
	}

}
