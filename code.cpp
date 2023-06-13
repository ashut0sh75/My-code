#include <iostream>
#include <string>

int noneRepeat(std::string S) {
    for (int i = 0; i < S.length(); i++) {
        char ch = S[i];
        int flag = 0;

        for (int j = 0; j < S.length(); j++){
            if (ch == S[j] && j != i) {
                flag = 0;
                break;
            } else {
                flag = 1;
            }
        }

        if (flag == 1)
            return i;
    }

    return -1;
}

int main() {
    std::string st = "abracadara";

    std::cout << noneRepeat(st);

    return 0;
}
