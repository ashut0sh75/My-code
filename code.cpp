#include <iostream>

using namespace std;

int main() {
    int *a[4];

    int p, q, r, s;

    a[0] = &p;
    a[1] = &q;
    a[2] = &r;
    a[3] = &s;

    for(int m = 0; m < 4; m++) {
        cout << *a[m] <<" "<<*m[a]<<" " <<*(a+m)<< endl;
    }

    return 0;
}
