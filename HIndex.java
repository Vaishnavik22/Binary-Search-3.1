/*
Problem: https://leetcode.com/problems/h-index-ii/
*/


// Approach 1: Linear
// TC: O(n)
// SC: O(1)
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int n = citations.length;
        for (int i = 0; i < n; ++i) {
            int papersWithCitationsGreaterThanOrEqualToI = n - i;
            
            if (citations[i] >= papersWithCitationsGreaterThanOrEqualToI) {
                int HIndex = papersWithCitationsGreaterThanOrEqualToI;
                return HIndex;
            }
        }
        
        return 0;
    }
}

// Approach 2
// TC: O(log n)
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int n = citations.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int papersWithCitationsGreaterThanOrEqualToI = n - mid;
            
            if (citations[mid] == papersWithCitationsGreaterThanOrEqualToI) {
                return papersWithCitationsGreaterThanOrEqualToI;
            }
            
            if (citations[mid] < papersWithCitationsGreaterThanOrEqualToI) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return n - low;
    }
}