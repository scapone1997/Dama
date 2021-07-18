package it.uniba.main;

import it.uniba.main.Costanti.Comandi;
import it.uniba.main.Dama.Gioco;
import it.uniba.main.InterfacciaUtente.ComunicazioneEsterna;
import it.uniba.main.InterfacciaUtente.LettoreComandi;

/**
 * <<Control>>
 * The main class for the project. It must be customized to meet the project
 * assignment specifications.
 *
 * <b>DO NOT RENAME</b>
 */
public final class AppMain {

	/**
	 * Private constructor. Change if needed.
	 */
	private AppMain() {

	}

	/**
	 * 	 * This is the main entry of the application.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(final String[] args) {

		int flagUscita = 0;
		ComunicazioneEsterna.currentWorkingDir();

		if (args.length > 0) {
			switch (args[0]) {

				case "--help":
					ComunicazioneEsterna.help();
					break;

				case "-h":
					ComunicazioneEsterna.help();
					break;

				default:
					ComunicazioneEsterna.erroreFlag();
					ComunicazioneEsterna.benvenuto();
					break;
			}
		} else {
			ComunicazioneEsterna.benvenuto();
		}

		String comando;
		//menù principale
		while (flagUscita != -1) {
			comando = LettoreComandi.getComando();
			if (comando.compareTo(Comandi.HELP) == 0) {
				ComunicazioneEsterna.help();
			} else if (comando.compareTo(Comandi.GIOCA) == 0) {
				ComunicazioneEsterna.avvioPartita();
				Gioco g = new Gioco();
				flagUscita = 0;
				while (flagUscita == 0) { //continua fino ad un vincitore o uscita
					g.gestisciTurno();
					flagUscita = g.gioca(LettoreComandi.getComando());
				}
				ComunicazioneEsterna.finePartita(g.leggiVincitore());
			} else if (comando.compareTo(Comandi.NUMERI) == 0) {
				ComunicazioneEsterna.numeri();
			} else if (comando.compareTo(Comandi.DAMIERA) == 0) {
				ComunicazioneEsterna.suggerisciGioca();
			} else if (comando.compareTo(Comandi.TEMPO) == 0) {
				ComunicazioneEsterna.suggerisciGioca();
			} else if (comando.compareTo(Comandi.ABBANDONA) == 0) {
				ComunicazioneEsterna.suggerisciGioca();
			} else if (comando.compareTo(Comandi.MOSSE) == 0) {
				ComunicazioneEsterna.suggerisciGioca();
			} else if (comando.compareTo(Comandi.PRESE) == 0) {
				ComunicazioneEsterna.suggerisciGioca();
			} else if (comando.compareTo(Comandi.ESCI) == 0) {
				if (ComunicazioneEsterna.confermaEsci()) {
					flagUscita = -1;
				}
			} else {
				ComunicazioneEsterna.erroreComando();
			}

		}

	}

}
