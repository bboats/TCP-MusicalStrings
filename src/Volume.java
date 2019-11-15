package tcp_tf;

public class Volume {
	private int valor;
	private int step = 10; // valor de incremento/decremento
	
	public Volume() {
		this.valor = 100;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void increaseVolume() {
		this.valor += step;
	}
	
	public void decreaseVolume() {
		this.valor -= step;
	}
}
