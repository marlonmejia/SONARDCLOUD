package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> part){
        String valuef= part.get(1);
        for (int i=1;i<part.size();i++){
            for (int j=0;j<valuef.length();j++) {
                if(valuef.charAt(j)!= part.get(i).charAt(j)){
                    valuef=valuef+part.get(i).charAt(j);
                }
            }
        }
        return valuef;
    }
}
