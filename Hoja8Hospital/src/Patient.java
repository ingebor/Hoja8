/**
 * @author Ingebor Rubio 19003
 * @date 05/04/2020
 * Hoja de trabajo 8, estructura de datos
 */

public class Patient implements Comparable<Patient>{

	private String name;
	private String illness;
	private String priority;
	
	/**
	 * Constructor
	 * @param name
	 * @param illness
	 * @param priority
	 */
	public Patient(String name, String illness, String priority) {
		super();
		this.name = name;
		this.illness = illness;
		this.priority = priority;
	}
	
	@Override
	public int compareTo(Patient priority) {
		// TODO Auto-generated method stub
		return this.priority.compareTo(priority.getPriority());
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the illness
	 */
	public String getIllness() {
		return illness;
	}

	/**
	 * @param illness the illness to set
	 */
	public void setIllness(String illness) {
		this.illness = illness;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return paciente con todos sus datos
	 */
	@Override
	public String toString() {
		return  name + ","+ illness + ","+ priority ;
	}
	

}
