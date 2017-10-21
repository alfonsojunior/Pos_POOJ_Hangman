package br.edu.unidavi.webdev.poo.basics;

public class Hangman extends Jogo<String, Character> {
	
	private String pass = "";
	private char[] placeholder;
	private boolean gotcha = false;
	private int wrongs = 0;
	private int limit = 6;
	private boolean canPlay = false;
	
	public Hangman(String palavra)  {
		this.pass = palavra;
		iniciar();
	}
	
	public void iniciar() {
		this.placeholder = new char[this.pass.length()];
		for (int i = 0; i < this.pass.length(); i++)
			this.placeholder[i] = '*';
		this.gotcha = false;
		this.wrongs = 0;
		this.limit = 6;
		this.canPlay = true;
	}
	
	@Override
	public String jogar(Character letra) {
		if (this.canPlay) {
			boolean hit = false;
			for (int i = 0; i < this.pass.length(); i++) {
				if (pass.charAt(i) == letra) {
					placeholder[i] = letra;
					hit = true;
				}
			}
			this.gotcha = String.valueOf(this.placeholder).equals(this.pass);
			if (!hit) {
				addWrong();
			}
			this.canPlay = this.wrongs < this.limit && !this.gotcha;
		}
		return String.valueOf(placeholder);
	}
	
	public boolean isGotcha() {
		return this.gotcha;
	}
	
	public void addWrong() {
		this.wrongs++;
	}
	
	public int getWrongAttempts() {
		return this.wrongs;
	}
	
	@Override
	public boolean won() {
		return this.gotcha;
	}

	
	/*
	public static void main(String[] args) {
		//
		//String pass = "Ghost";
		char[] placeholder = new char[pass.length()];
		for (int i = 0; i < pass.length(); i++)
			placeholder[i] = '*';
		boolean canPlay = true;
		int wrongs = 0;
		int limit = 6;
		boolean gotcha = false;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.printf("Your attempt: %d/%d", wrongs, limit);
			String attempt = scanner.nextLine();
			boolean hit = false;
			gotcha = true;
			String placeholderAsString = "";
			for (int i = 0; i < pass.length(); i++) {
				if (pass.charAt(i) == attempt.charAt(0)) {
					placeholder[i] = attempt.charAt(0);
					hit = true;
				}
				gotcha = gotcha & (pass.charAt(i) == placeholder[i]);
				placeholderAsString += placeholder[i];
			}
			if (!hit)
				wrongs++;
			canPlay = wrongs < limit && !gotcha;
			System.out.println(placeholderAsString);
		} while (canPlay);
		scanner.close();
		System.out.println("You ".concat(gotcha ? " win" : " lose"));

	}
	*/
}
