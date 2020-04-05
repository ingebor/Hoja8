/**
 * @author Ingebor Rubio 19003
 * @date 05/04/2020
 * Hoja de trabajo 8, estructura de datos
 */

//Obtenido de https://instructure-uploads.s3.amazonaws.com/account_111400000000000001/attachments/10550/VectorHeap.java?response
//-content-disposition=inline%3B%20filename%3D%22VectorHeap.java%22%3B%20filename%2A%3DUTF-8%27%27VectorHeap.java&X-Amz-Algorithm
//=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAJDW777BLV26JM2MQ%2F20200405%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200405T220003Z&X
//-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=6dc844fd0860bb28de6ae14343b30de92da0cbd93498ba9589b9c1912115a639

import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements iPriorityQueue<E>
{

	protected Vector<E> data; // the data, kept in heap order

	/**
	 * Constructor
	 */
	public VectorHeap()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}

	/**
	 * Nuevo vector sin ordenar por prioridad
	 * @param v
	 */
	public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}
	
	/**
	 * 
	 * @param i
	 * @return devuelve el padre 
	 */
	protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
		return (i-1)/2;
	}

	/**
	 * 
	 * @param i
	 * @return hijo en el nodo izquierdo
	 */
	protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2*i+1;
	}

	/**
	 * 
	 * @param i
	 * @return hijo en el nodo izquierdo
	 */
	protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
		return (2*i+1) + 1;
	}

	/**
	 * mueve un nodo a su posicion adecuada
	 * @param leaf
	 */
	protected void percolateUp(int leaf)
	// pre: 0 <= leaf < size
	// post: moves node at index leaf up to appropriate position
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
		(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}

	/**
	 * @param value, valor que desea agregarse al vector
	 * se agrega un nuevo nodo al vector
	 */
	public void add(E value)
	// pre: value is non-null comparable
	// post: value is added to priority queue
	{
		data.add(value);
		percolateUp(data.size()-1);
	}

	/**
	 * Coloca un nodo en su posición adecuada
	 * @param root
	 */
	protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo
				(data.get(childpos)) < 0))
				{
					childpos++;
				}
			// Assert: childpos indexes smaller of two children
			if ((data.get(childpos)).compareTo
				(value) < 0)
			{
				data.set(root,data.get(childpos));
				root = childpos; // keep moving down
			} else { // found right location
				data.set(root,value);
				return;
			}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}

	/**
	 * Devuelve y elimina el valor menor 
	 */
	public E remove()
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	{
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}

	/**
	 * obtiene el valor menor
	 */
	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return data.get(0);
	}

	/**
	 * verifica si el queue esta vacio
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return data.size()==0;
	}
	
/**
 * Devuelve el tamaño del queue
 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.size();
	}

	/**
	 * Remueve los elementos del queue, no se utiliza
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Listado total de pacientes
	 * @return patients, listado de pacientes
	 */
	public String listOfPatients() {
		String patients = "";
		for(E info : data) {
			patients += info + "\n";
		}
		return patients;
	}
	
	
	
}