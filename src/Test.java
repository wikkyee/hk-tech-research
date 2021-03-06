import java.util.Vector;
/*
* this is a test class
* */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   int[] as= {7, 9, 4, 5};
	   
       System.out.println(new Test().median(as));
	}
	
    int getMidIndex(int[] nums,int low,int high){
        int tmp=nums[low];
        while(low<high){
           while(low<high&&nums[high]>=tmp){
              high--;
           }
           nums[low]=nums[high];
            
           while(low<high&&nums[low]<tmp){
              low++;
           }
           nums[high]=nums[low];
        }
                   
       nums[low]=tmp;
	return low;
    }
     
    void quickSort(int[] nums,int low,int high){
        if(low<high){
           int mid=getMidIndex(nums,low,high); 
           quickSort(nums,low,mid);
           quickSort(nums,mid+1,high);
        }
    } 
    
    int median(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        quickSort(nums,0,len-1);
        return nums[(len-1)/2];
    }

}
