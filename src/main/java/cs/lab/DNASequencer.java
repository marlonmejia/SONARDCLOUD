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
            for (int j=0;j<part.get(i).length();j++) {
                if(valuef.substring(j)==part.get(i)){
                    valuef=valuef+part.get(i+1);
                }
                for(int k=part.get(i).length();k>=0;k--){
                    if (valuef.substring(k)==part.get(i).substring(j)){
                        valuef=valuef+part.get(i).substring(j+1);
                    }
                }
            }
        }
        return valuef;
    }
}
