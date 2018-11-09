
public class csvClass implements Comparable<csvClass>{

public int GID,ENTRY_NO,EH_cm,PH_cm,DTA_days__obs,DTS_days__obs, GW_g__FieldWB,EarsHvst_ears_plot,RLodg_pl_plot,SLodg_pl_plot,REP_NO,PLOT_NO,column,row;
public String ENTRY_TYPE, PlantingDate,DESIGNATION;
public Float Moi_pct__STD;


public csvClass(String ENTRY_TYPE, String PlantingDate, Integer GID, 
		String DESIGNATION, Integer ENTRY_NO, Integer EH_cm, 
		Integer PH_cm, Integer DTA_days__obs, 
		Integer DTS_days__obs,Float Moi_pct__STD,Integer GW_g__FieldWB, Integer EarsHvst_ears_plot,
		Integer RLodg_pl_plot, Integer SLodg_pl_plot, Integer REP_NO,
		Integer PLOT_NO, Integer column,Integer row) {
    super();
    
    this.ENTRY_TYPE = ENTRY_TYPE;
    this.PlantingDate = PlantingDate;
    this.GID = GID;
    this.DESIGNATION = DESIGNATION;
    this.EH_cm = EH_cm;
    this.PH_cm = PH_cm;
    this.DTA_days__obs = DTA_days__obs;
    this.DTS_days__obs = DTS_days__obs;
    this.Moi_pct__STD = Moi_pct__STD;
    this.GW_g__FieldWB = GW_g__FieldWB;
    this.EarsHvst_ears_plot = EarsHvst_ears_plot;
    this.RLodg_pl_plot = RLodg_pl_plot;
    this.SLodg_pl_plot = SLodg_pl_plot;
    this.REP_NO = REP_NO;
    this.PLOT_NO = PLOT_NO;
    this.column = column;
    this.row = row;
}

@Override
public int compareTo (csvClass c) {
	//compares argument1 "EH_cm" first in descending order then argument2 "PH_cm"
	//change the arguments here to suit the purpose
    if (this.EH_cm == c.EH_cm) {
    	//System.out.println("cPH: "+c.PH_cm+" thisPH: "+this.PH_cm+" = "+Integer.compare(c.PH_cm, this.PH_cm));
    	return Integer.compare(c.PH_cm, this.PH_cm);
    } else {
    	//System.out.println("cEH: "+c.EH_cm+" thisEH: "+this.EH_cm+" = "+Integer.compare(c.EH_cm,this.EH_cm));
        return Integer.compare(c.EH_cm,this.EH_cm);
    }
}

@Override
public String toString() {
	//returns how it is stored in "data" arraylist
    return "-row: " + row + "\ncolumn: " + column + "\ndata: EH_cm=" + EH_cm + " PH_cm=" + PH_cm;
}

}