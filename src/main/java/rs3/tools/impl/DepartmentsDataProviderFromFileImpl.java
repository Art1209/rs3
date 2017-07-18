package rs3.tools.impl;


import org.springframework.stereotype.Component;
import rs3.tools.interf.DepartmentsDataProvider;

import java.io.*;

@Component
public class DepartmentsDataProviderFromFileImpl implements DepartmentsDataProvider {
    public static final String INPUT_JSON_FILE_PATH = "C:\\Users\\aalbutov\\IdeaProjects\\SIA\\src\\main\\resources\\deps_array.json";
    @Override
    public InputStreamReader returnData() {
        try {
            return new InputStreamReader(
                    new FileInputStream(INPUT_JSON_FILE_PATH),
                    "UTF-8");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return new InputStreamReader(new ByteArrayInputStream("".getBytes()));
        }
    }
