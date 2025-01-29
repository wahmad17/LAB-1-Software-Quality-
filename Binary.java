package com.ontariotechu.sofe3980U;


public class Binary
{
    private String number="0";  
    
    public Binary(String number) {
        if (number == null || number.isEmpty()) {
            this.number = "0"; 
            return;
        }
    
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0"; 
                return;
            }
        }
    
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0') {
                break;
            }
        }
    
        this.number = (beg == number.length()) ? "0" : number.substring(beg);
    }
    
    public String getValue()
    {
        return this.number;
    }
    
    public static Binary add(Binary num1,Binary num2)
    {
        int ind1=num1.number.length()-1;
        int ind2=num2.number.length()-1;
        int carry=0;
        String num3="";  
        while(ind1>=0 ||  ind2>=0 || carry!=0) 
        {
            int sum=carry; 
            if(ind1>=0){ 
                sum += (num1.number.charAt(ind1)=='1')? 1:0; 
                ind1--; 
            }
            if(ind2>=0){ 
                sum += (num2.number.charAt(ind2)=='1')? 1:0; 
                ind2--; 
            }
            carry=sum/2; 
            sum=sum%2;  
            num3 =( (sum==0)? "0":"1")+num3; 
        }
        Binary result=new Binary(num3);  
        return result;
    }
    
    public static Binary and(Binary num1, Binary num2) {
    int len1 = num1.number.length();
    int len2 = num2.number.length();
    int maxLength = Math.max(len1, len2);
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < maxLength; i++) {
        char bit1 = (i < len1) ? num1.number.charAt(len1 - i - 1) : '0';
        char bit2 = (i < len2) ? num2.number.charAt(len2 - i - 1) : '0';

        result.insert(0, (bit1 == '1' && bit2 == '1') ? '1' : '0');
    }
    return new Binary(result.toString());
}

public static Binary multiply(Binary num1, Binary num2) {
    Binary result = new Binary("0");
    String num1Str = num1.number;
    String num2Str = num2.number;

    for (int i = num2Str.length() - 1; i >= 0; i--) {
        if (num2Str.charAt(i) == '1') {
            String shifted = num1Str + "0".repeat(num2Str.length() - 1 - i);
            result = add(result, new Binary(shifted));
        }
    }
    return result;
}

public static Binary or(Binary num1, Binary num2) {
    int len1 = num1.number.length();
    int len2 = num2.number.length();
    int maxLength = Math.max(len1, len2);
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < maxLength; i++) {
        char bit1 = (i < len1) ? num1.number.charAt(len1 - i - 1) : '0';
        char bit2 = (i < len2) ? num2.number.charAt(len2 - i - 1) : '0';

        result.insert(0, (bit1 == '1' || bit2 == '1') ? '1' : '0');
    }
    return new Binary(result.toString());
}
}
