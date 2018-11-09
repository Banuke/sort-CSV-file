import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader; 
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Challenge {

	public static final String PATH = "maize-with-data.csv"; //.csv file path
	public static ArrayList<String> aList = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		
    readAllLinesFromFile(PATH); // method to read file content and store in array list 
    
    //method to separate each values from the array list to a class and sort on EH_cm and PH_cm
    ArrayList<csvClass> data = convertToListedData(aList); 

    //method to output top 3 sorted results to yaml file
    writeTop3ToFile(data);
    
    for(int i=0; i<3; i++){
    	System.out.println(data.get(i));
    }
}

	public static ArrayList<String> readAllLinesFromFile(String path) throws IOException{

    FileReader fileReader = new FileReader(path);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String line = null;
    while( (line = bufferedReader.readLine()) != null){
        aList.add(line);
    }
    bufferedReader.close();
    return aList;
}

	public static ArrayList<csvClass> convertToListedData(ArrayList<String> Lines) {
    ArrayList<csvClass> data = new ArrayList<>(); // array list of csvClass type
    Lines.remove(0); // remove the heading row
    for(String each : Lines) {
        String[] divided = each.split(",");
        for(int i =0; i<divided.length;i++) {
        	if (divided[i].equals("")){
        		divided[i] = "0";
        	}
        }
        String ENTRY_TYPE = divided[0];
        String PlantingDate = divided[1];
        Integer GID = Integer.valueOf(divided[2]);
        String DESIGNATION = divided[3];
        Integer ENTRY_NO = Integer.valueOf(divided[4]);
        Integer EH_cm = Integer.valueOf(divided[5]);
        Integer PH_cm = Integer.valueOf(divided[6]);
        Integer DTA_days__obs = Integer.valueOf(divided[7]);
        Integer DTS_days__obs = Integer.valueOf(divided[8]);
        
        Float Moi_pct__STD = Float.valueOf(divided[9]);
        Integer GW_g__FieldWB = Integer.valueOf(divided[10]);
        Integer EarsHvst_ears_plot = Integer.valueOf(divided[11]);
        Integer RLodg_pl_plot = Integer.valueOf(divided[12]);
        Integer SLodg_pl_plot = Integer.valueOf(divided[13]);
        Integer REP_NO = Integer.valueOf(divided[14]);
        Integer PLOT_NO = Integer.valueOf(divided[15]);
        Integer column = Integer.valueOf(divided[16]);
        Integer row = Integer.valueOf(divided[17]);
        
	    //send the obtained values to the data list
        data.add(new csvClass( ENTRY_TYPE,  PlantingDate,  GID, DESIGNATION,  ENTRY_NO, 
        		EH_cm, PH_cm,  DTA_days__obs,DTS_days__obs, Moi_pct__STD, GW_g__FieldWB,  
        		EarsHvst_ears_plot,RLodg_pl_plot,  SLodg_pl_plot,  REP_NO,PLOT_NO,  column, row));
    }

    Collections.sort(data,new Comparator<csvClass>() {
        @Override
        public int compare(csvClass o1, csvClass o2) {
            return o1.compareTo(o2);
        } 
    });
    return data;
}

	public static void writeTop3ToFile(ArrayList<csvClass> data) throws IOException {
		Writer writer = null;
		    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.yaml")));
		    // for loop to write only top three results
		    for(int i=0; i<3; i++){
		    	writer.write("---\n"+data.get(i)+"\n");
		    }
		    writer.write("...");
		    writer.close();
	}

}
