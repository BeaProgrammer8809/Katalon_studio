package practice;

public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		String s="Mahabharat";
		s=s.toLowerCase();
		String res="";
		
		for(int i=0;i<s.length();i++) {
			int count=0;
			for(int j=0;j<s.length();j++) {
				if(s.charAt(i)==s.charAt(j) && i>j) {
					break;
				}
				if(s.charAt(i)==s.charAt(j)) {
					count++;
				}
			}
			if(count==1) {
				res=res+s.charAt(i);
				System.out.println(s.charAt(i)+" Present "+count+" Times");
			}
		}
		System.out.println("String Without duplicates :"+res);
	}
}
