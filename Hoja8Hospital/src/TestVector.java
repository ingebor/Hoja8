import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestVector {

	VectorHeap<Patient> vector = new VectorHeap<Patient>();
	
	public String Test() throws Exception {
		String answer = "";
		vector.add(new Patient("Juan Perez","fractura de pierna","C"));
		vector.add(new Patient("Maria Ramirez","apendicitis","A"));
		vector.add(new Patient("Lorenzo Toledo","chikunguya","E"));
		try {
			vector.remove();
			answer = "a, maria ramirez, apendicitis";
		}
		catch(Exception E) {
			answer = "No logrado";
		}
		return answer;
	}
	@Test
	void test() throws Exception {
		String resultado = Test();
		String esperado = "a, maria ramirez, apendicitis";
		assertEquals(esperado,resultado);
	}
}
