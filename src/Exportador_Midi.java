package tcp_tf;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import java.io.File;

public class Exportador_Midi {
	//com nome default
	public void salva_Midi(String jfugueString) {
		Pattern jfuguePattern = new Pattern(jfugueString);
		try {
			MidiFileManager.savePatternToMidi(jfuguePattern, new File("DefaultName.mid"));	
		}
		catch (Exception e) {
			System.out.println("Erro ao exportar arquivo midi: " + e);
		}	
		
	}
		
	//com nome fornecido pelo usuario
	public void salva_Midi(String jfugueString, String nomeArquivo) {
		Pattern jfuguePattern = new Pattern(jfugueString);
		try {
			MidiFileManager.savePatternToMidi(jfuguePattern, new File(nomeArquivo+".mid"));	
		}
		catch (Exception e) {
			System.out.println("Erro ao exportar arquivo midi: " + e);
		}	
		
	}

}
