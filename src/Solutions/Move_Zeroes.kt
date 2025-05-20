package Solutions


class Move_Zeroes {
    fun moveZeroes(nums: IntArray): Unit{
        var left = 0
        val sz = nums.size
        for(i in 0..<sz){
            if(left == sz) break
            if(nums[i] == 0){
                while(nums[left] == 0 || left == sz) left++
                nums[i] = nums[left]
                nums[left] = 0
            }
        }
    }
}