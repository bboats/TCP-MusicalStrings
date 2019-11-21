package tcp_tf;

public class Volume {
	private int valor;
	
	public static final int DEFAULT_VOLUME = 31;
	public static final int MAX_VOLUME = 127;
	
	public Volume() {
		this.valor = DEFAULT_VOLUME;
	}
	
	public void setValorDefault() {
		this.valor = DEFAULT_VOLUME;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void increaseVolume() {
		if(this.valor*2 <= MAX_VOLUME)
			this.valor *= 2;
		else
			this.valor = DEFAULT_VOLUME;
	}
	
	
}
