import hec.heclib.dss.HecDSSUtilities;
import hec.heclib.dss.HecDataManager;

import java.util.Arrays;
import java.util.Vector;

/// This class was used to grab test data from the SDI dss file. The file is too big to do this op manually

public class TestDataGrabber {


    public static void main(String[] args){
        String _oldDss = "\\\\NRC-Ctrl01\\D$\\WG_Grid1\\NRCPilotStudy_L01G01.dss";
        String _newDss = "C:\\Temp\\test.dss";
        String CNasString = String.format("%06d",40);
        String pathWithWildChars = "/*/*/*/*/*/C:"+ CNasString+"*/";


        HecDSSUtilities utils = new HecDSSUtilities();
        utils.setDSSFileName(_oldDss);
        HecDataManager oldDSSManager = new HecDataManager();
        oldDSSManager.setDSSFileName(_oldDss);
        String[] pathnames = oldDSSManager.getCatalog(false,pathWithWildChars);
        Vector<String> vector = new Vector<>(Arrays.asList(pathnames));
        utils.copyRecordsFrom(_newDss,vector);
        }
    }
