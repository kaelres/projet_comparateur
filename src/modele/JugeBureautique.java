package modele;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class JugeBureautique implements Juge {

	private Ordinateur souhait;
	private Map<String, ArrayList<String>> disque;
	private Map<String, ArrayList<String>> type;
	private Map<String, ArrayList<String>> CG;
	private Map<String, ArrayList<String>> CM;
	
	public JugeBureautique(Ordinateur o) {
		setSouhait(o);
		
		ArrayList<String> famille_Mécanique = new ArrayList<>();
		famille_Mécanique.add("SSD");
		ArrayList<String> famille_SSD = new ArrayList<>(); // vide
		disque = new TreeMap<>();
		disque.put("Mécanique", famille_Mécanique); disque.put("SSD", famille_SSD);
		
		ArrayList<String> famille_Fixe = new ArrayList<>(); //vide
		famille_Fixe.add("Portable");
		ArrayList<String> famille_Portable = new ArrayList<>();
		type = new TreeMap<>();
		type.put("Fixe", famille_Fixe); type.put("Portable", famille_Portable);
		
		ArrayList<String> famille_MSI = new ArrayList<>();
		famille_MSI.add("ASUS");
		ArrayList<String> famille_PNY = new ArrayList<>();
		famille_PNY.add("EVGA"); famille_MSI.add("MSI"); famille_MSI.add("ASUS"); 
		ArrayList<String> famille_ASUS = new ArrayList<>();
		ArrayList<String> famille_EVGA = new ArrayList<>();
		famille_EVGA.add("PNY"); famille_EVGA.add("MSI"); famille_EVGA.add("ASUS");
		CG = new TreeMap<>();
		CG.put("MSI", famille_MSI); CG.put("PNY", famille_PNY); CG.put("ASUS", famille_ASUS); CG.put("EVGA", famille_EVGA);
		
		ArrayList<String> famille_standard = new ArrayList<>();
		ArrayList<String> famille_micro = new ArrayList<>();
		famille_micro.add("ATX_standard");
		ArrayList<String> famille_mini = new ArrayList<>();
		famille_mini.add("ATX_standard"); famille_mini.add("micro_ATX");
		CM = new TreeMap<>();
		CM.put("ATX_standard", famille_standard); CM.put("micro_ATX", famille_micro); CM.put("mini_ITX", famille_mini);
	}
	
	@Override
	public void juger(Ordinateur o) {
		double score = 0;
		//prix;
		double marge = Math.max(50, 0.15*o.getPrix());
		if (souhait.getPrix() >= o.getPrix()) score += 10;
		else if (souhait.getPrix() >= marge+o.getPrix()) score += 5;
		
		//ram
		if (souhait.getRAM() == o.getRAM()) score += 10;
		else if ( (souhait.getRAM() == 2*o.getRAM()) || (2*souhait.getRAM() == o.getRAM()) ) score += 5;
		
		//disque
		if (souhait.getDisque().equals(o.getDisque())) score += 10;
		else if (disque.get(souhait.getDisque()).contains(o.getDisque())) score += 5;
		//Si l'ordi actuel poss�de un disque appartenant � la famille du disque de celui souhait� par le client => +5
		
		
		//type
		if (souhait.getType().equals(o.getType())) score += 10;
		else if (type.get(souhait.getType()).contains(o.getType())) score += 5;
		
		
		//cg
		if (souhait.getCg().equals(o.getCg())) score += 10;
		else if (CG.get(souhait.getCg()).contains(o.getCg())) score += 5;
		
		//cm
		if (souhait.getCm().equals(o.getCm())) score += 10;
		else if (CM.get(souhait.getCm()).contains(o.getCm())) score += 5;
		
		//conclusion
		o.setScore(score);
	}

	public Ordinateur getSouhait() { return souhait;}
	public void setSouhait(Ordinateur souhait) { this.souhait = souhait;}

}
