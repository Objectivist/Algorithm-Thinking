class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        for(int i = 0; i < 4; i++){
            key = rotate(key);
            for(int x = -(lock.length-1); x < (lock.length-1); x++){
                for(int y = -(lock.length-1); y < (lock.length-1); y++){
                    if(isValid(key, lock, y, x)) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isValid(int[][] key, int[][] lock, int y, int x){
        for(int i = 0; i < lock.length; i++){
            for(int j = 0; j < lock.length; j++){
                if(i + y < 0 || i + y >= key.length || j + x < 0 || j + x >= key.length){
                    if(lock[i][j] == 0) return false;
                }else{
                    if(lock[i][j] == key[i+y][j+x]) return false;
                }
            }
        }
        return true;
    }
    
    public int[][] rotate(int[][] key){
        int[][] tmp = new int[key.length][key.length];
        for(int i = 0; i < key.length; i++){
            for(int j = 0; j < key.length; j++){
                tmp[i][j] = key[key.length-1-j][i];
            }
        }
        
        return tmp;
    }
}
