package processing;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class parse {

    public static void main(String[] args) {
        //readFile();
        readFile1();
    }

    static void readFile1(){

        HashMap<String,Integer> hashRecipients = new HashMap<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("recipients.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null){
                if (hashRecipients.get(line) == null){
                    hashRecipients.put(line,1);
                }
                line = bufferedReader.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try (FileWriter fileWriter = new FileWriter("recientsNew.txt")){
            for (String str:
                    hashRecipients.keySet()) {
                fileWriter.write(str);
                fileWriter.write("\n");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    private static ArrayList readFile(){

        String path = "1C-send.txt";

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), "UTF-8"))){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            FileWriter fileWriter = new FileWriter("recipients.txt");

            List<String> recipients = new ArrayList<>();

            while (line != null) {

                if (!(line.indexOf("Timestamp") == -1)) {
                    ArrayList<String> stringArrayList = decomposeString(sb.toString());
                    if (stringArrayList.size()>1) {
                        //boolean needMessage = stringArrayList.get(5).equals("MessageSubject : Компания «КВС» приглашает на Клиентский день 21 мая!");
                        String subject = stringArrayList.get(5);

                        boolean needMessage = subject.indexOf("30") > 0;

                        if (needMessage) {
                            String recipient = stringArrayList.get(4);
                            recipient = recipient.replace("Recipients     : { ", "");
                            recipient = recipient.replace("}", "");

                            fileWriter.write(recipient);
                            fileWriter.write("\n");

                            recipients.add(recipient);
                        }
                    }
                    sb = new StringBuilder();
                }

                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return new ArrayList();
    }

    private static ArrayList<String>decomposeString(String decomposeString){

        Integer beginInt = -1;
        ArrayList<String> stringArrayList = new ArrayList<>();

        for (int i = 0; i < decomposeString.length(); i++) {
            if (decomposeString.substring(i,i+1).equals("\n")){
                stringArrayList.add(decomposeString.substring(beginInt+1,i));
                beginInt = i;
            }
        }

        return stringArrayList;
    }

}
