package source;

public class ArrayStack<E> implements Stack<E> {
	
	private static final int TAM_VETOR_INICIAL = 100;
	
	private E[] vetor; 
	private int top = -1;
	// Construtor vazio
	public ArrayStack() {
		this.vetor = (E[]) new Object[TAM_VETOR_INICIAL];
	}
	// Construtor com o tamnaho do vetor sendo apssado
	public ArrayStack(int tamanhoVetor) {
		this.vetor = (E[]) new Object[tamanhoVetor];
	}
	
	@Override
	public int size() {
		return top + 1 ;
	}

	@Override
	public boolean isEmpty() {
		return top < 0;
	}

	@Override
	public E top() throws EmptyStackException {
		if(isEmpty())throw new EmptyStackException(" Stack is empty");
		return this.vetor[top];
	}

	@Override
	public void push(E elemento) throws FullStackException {
		// Usa o tamanho do vetor e o numero de elementos inseritos
		// para determianr se ultrapassou
		if(size() == this.vetor.length)throw new FullStackException("Stack is Full");
		
		this.vetor[++top] = elemento;
		
	}

	@Override
	public E pop() throws EmptyStackException {
		E elemento =  null;
		
		if(isEmpty())throw new EmptyStackException("Stack is empty");
		
		// Retira o elemento e manda o garbage collector limpar usando  a atribuição null 
		elemento = this.vetor[ top ];
		this.vetor[top--] = null;
		
		return elemento;
	}
	
	
	public String toString(){
		String retorno = null;		
		
		retorno = "[";
        if (size() > 0) retorno += this.vetor[0];
        if (size() > 1) {
            for (int i = 1; i <= size() - 1; i++) {
            	retorno += ", " + this.vetor[i];
            }
        }
        return retorno + "]";
		
	}

}
