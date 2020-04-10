import java.util.Vector;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   int[] as= {7, 9, 4, 5};
	   
       System.out.println(new Test2().median(as));
	}
	
    int getMidIndex(int[] nums,int low,int high){
        int tmp=nums[low];//选中轴
        while(low<high){
           while(low<high&&nums[high]>=tmp){//找到第一个比temp小的nums[high]退出while,
              high--;
           }
           nums[low]=nums[high];
            
           while(low<high&&nums[low]<tmp){//找到第一个比temp大的nums[low]退出while
              low++;
           }
           nums[high]=nums[low];
        }
                   
       nums[low]=tmp;// 中轴元素归位,
	return low; // 返回中轴的位置
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
