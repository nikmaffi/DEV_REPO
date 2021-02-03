public class ColpisciBersaglio {
	private static final int MAX = 100;
	private static long istanze = 0;
	private BersaglioGrafico[] bersagli;
	private int quanti;
	private long punteggioTotale;
	
	public ColpisciBersaglio() {
		this.istanze++;
		this.bersagli = new BersaglioGrafico[ColpisciBersaglio.MAX];
		this.quanti = 0;
		this.punteggioTotale = 0;
	}
	
	public long getPunteggioTotale() {
		return this.punteggioTotale;
	}
	
	public long getIstanze() {
		return ColpisciBersaglio.istanze;
	}
	
	public void aggiungiBersaglio(BersaglioGrafico b) throws Exception {
		if(this.quanti >= this.bersagli.length) {
			throw new Exception("Errore: Numero massimo di bersagli raggiunto!");
		}
		if(b == null) {
			throw new Exception("Errore: Bersaglio nullo!");
		}
		
		this.bersagli[quanti++] = b;
	}
	
	public void spara(float mx, float my) {
		int i = 0;
		boolean colpito = false;
		
		while(i < this.quanti && !colpito) {
			if((colpito = this.bersagli[i].eColpito(mx, my))) {
				this.punteggioTotale += this.bersagli[i].getPunteggio();
			}
			
			i++;
		}
	}
	
	public void draw() {
		for(int i = 0; i < this.quanti; i++) {
			this.bersagli[i].draw();
		}
	}
}