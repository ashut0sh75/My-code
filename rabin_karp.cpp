#include<bits/stdc++.h>

using namespace std;
class Solution {
  public:
    void printSquare(int n) {
      
      
        for(int i=0;i<n;i++)
   cout<<"*";

   for(int j=0;j<n-2;j++) {
      cout<<endl;
      cout<<"*";

      for(int k=0;k<n-2;k++) 
      cout<<" ";
      cout<<"*";
   }
   cout<<endl;
   
   for(int j=0;j<n;j++)
   cout<<"*";

    }
};

int main() {

   int t;

   cin>>t;

   while(t-- >0) {
      int n;
      cin>>n;

      Solution ob;

      ob.printSquare(n);
   }
   return 0;
}