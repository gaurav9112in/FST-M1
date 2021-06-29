package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
	int[] numArr = { 10,77,10,54,-11,10};
	int searchNum = 10;
	int fixedSum=30;
	
	System.out.println("Result : " + result(numArr,searchNum,fixedSum));
	
}
public static boolean result(int[] numbers , int searchNum , int fixedSum)
{
	int sum = 0;
	for ( int num : numbers )
	{
		if(num==searchNum)
		{
			sum += num;
		}
	}
/*	if ( sum == fixedSum)
		return true;
	else
		return false;  */
	
	return sum==fixedSum;
	
}
}

