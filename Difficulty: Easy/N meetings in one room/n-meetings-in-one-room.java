class Solution {
    class Meetings{
        int s;
        int e;
        
        public Meetings(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        
        Meetings[] meets = new Meetings[n];
        
        // new Pairs has been added
        for(int i = 0; i < n; i++){
            meets[i] = new Meetings(start[i], end[i]);
        }
        
        Arrays.sort(meets, (a, b) -> a.e - b.e); // sort on the basis of start time
        
        int count = 0;
        int lastEnd = -1;
        
        for(int i = 0; i < n; i++){
            if(lastEnd < meets[i].s){
                lastEnd = meets[i].e;
                count++;
            }
        }
        
        return count;
    }
}
