import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excel {

    private ArrayList<Double> input = new ArrayList<>(); 

    public Excel(ArrayList<Double> numbers){
        this.input= numbers;
    }
    public Excel(String num){

        //converting string into array of strings
        String[] strNumArray= num.split(" ");

        //converting array to list
        List<String> strNumList = Arrays.asList(strNumArray);

        //declaring the arraylist of double type
        ArrayList <Double> strNumArrayList= new ArrayList<>();

        //converting items of list into double and adding them into above created arraylist
        strNumList.forEach(strNum->{
            double number= Double.parseDouble(strNum);
            strNumArrayList.add(number);
            this.input=strNumArrayList;
        });

    }

    public double findTotal(){
        double num=0.0;
        for(int i =0; i<input.size(); i++){
             num=+input.get(i);
            
        }
      return num;
    }

    public double findAvg(){
        double num=0.0;
        for(int i =0; i<input.size(); i++){
             num=+input.get(i);
            
        }
        return num / input.size();
    }

    public double findMax(){
        double num=0.0;
        for(int i =0; i<input.size(); i++){
            if (num<=input.get(i)||i==0){
                num=input.get(i);
            }
        }
        return num;     
    }
    public double findMin(){
        double num=0.0;
        for(int i =0; i<input.size(); i++){
            if (num>=input.get(i)||i==0){
                num=input.get(i);
            }
        }
        return num; 
    }

}
