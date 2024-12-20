class Time {

    public String timeConversion(String s) {

        //12:01:00PM => 12:01:00 
        //12:01:00AM => 00:01:00
        for(int i =0;i<=12;i++){
            if(s.substring(8,10).equals("AM")){
                
               if(i == Integer.parseInt(s.substring(0,2))){
                if(i<10){
                    return "0"+i +s.substring(2, s.length()-2);
                }else{
                    return i +s.substring(2, s.length()-2);
                }
               } 
               else if(Integer.parseInt(s.substring(0,2)) == 12){
                return "00"+s.substring(2, s.length()-2);
               }
            }else{
                if(Integer.parseInt(s.substring(0,2)) == 12){
                    return "12"+s.substring(2, s.length()-2);
                   }
                   else if(i == Integer.parseInt(s.substring(0,2))){
                    return i +12 +s.substring(2, s.length()-2);
                   }
            }
        }
        return null;
    }
}

class TimeConverter {
    public static void main(String[] args) {

        System.out.println("Start");
        Time time = new Time();
        System.out.println(time.timeConversion("12:01:00PM"));
        System.out.println(time.timeConversion("12:01:00AM"));
    }
}