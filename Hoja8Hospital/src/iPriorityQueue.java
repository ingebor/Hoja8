/**
 * @author Ingebor Rubio 19003
 * @date 05/04/2020
 * Hoja de trabajo 8, estructura de datos
 */

//Obtenido de https://instructure-uploads.s3.amazonaws.com/account_111400000000000001/attachments/10551/interfacePriorityQueue.java?response
//-content-disposition=inline%3B%20filename%3D%22interfacePriorityQueue.java%22%3B%20filename%2A%3DUTF-8%27%27interfacePriorityQueue.java&X
//-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAJDW777BLV26JM2MQ%2F20200405%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=
//20200405T220058Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=
//78b583f8c85cc74d9ade071abaa58e1af6a19823430c719a08555dcb920e5463

public interface iPriorityQueue<E extends Comparable<E>>
{
	/**
	 * primer elemento
	 * @return E
	 */
	public E getFirst();
	// pre: !isEmpty()
	// post: returns the minimum value in priority queue
	
	/**
	 * Elimina el primer elemento y lo muestra
	 * @return E
	 */
	public E remove();
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	
	/**
	 * agrega un nodo al queue
	 * @param value, valor que desea agregarse
	 */
	public void add(E value);
	// pre: value is non-null comparable
	// post: value is added to priority queue
	
	/**
	 * Verifica si el queue esta vacio
	 * @return boolean
	 */
	public boolean isEmpty();
	// post: returns true iff no elements are in queue
	
	/**
	 * verifica el tamanio del queue
	 * @return int
	 */
	public int size();
	// post: returns number of elements within queue
	
	/**
	 * remueve los elementos del queue
	 */
	public void clear();
	// post: removes all elements from queue
}