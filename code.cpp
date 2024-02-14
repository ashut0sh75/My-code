#include <iostream>
#include <vector>

using namespace std;

void countingSort(std::vector<int>& arr) {
    int maxElement = *std::max_element(arr.begin(), arr.end());

    std::vector<int> count(maxElement + 1, 0);
    std::vector<int> result(arr.size());

    for (int num : arr)
        count[num]++;

    for (int i = 1; i <= maxElement; ++i)
        count[i] += count[i - 1];

    for (int i = arr.size() - 1; i >= 0; --i) {
        result[count[arr[i]] - 1] = arr[i];
        count[arr[i]]--;
    }

    arr = result;
}

int main() {
    std::vector<int> arr = {4, 2, 7, 1, 3, 5};
    countingSort(arr);

    std::cout << "Sorted Array: ";
    for (int num : arr)
        std::cout << num << " ";
    
    return 0;
}
