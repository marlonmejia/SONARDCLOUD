package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> part) throws LenghtException, QuantityException {
        for(String itew:part){
            if(itew.length()>200){
                throw new LenghtException("Sequences not supported");
            }
        }
        if(part.size()>1600000){
            throw new QuantityException("Subsequences not supported");
        }
        StringBuilder result= new StringBuilder(part.get(0));
        for(int i=1;i<part.size();i++ ) {
            String elementlist = part.get(i);
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < elementlist.length(); j++) {
                temp.append(elementlist.charAt(j));
                if (!(result.toString().contains(temp))) {
                    result.append(elementlist.charAt(j));
                }
            }
        }
        return result.toString();
    }
}
