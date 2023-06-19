#include <stdio.h>
#include <stdbool.h>

#define MAX_PROCESSES 10
#define MAX_RESOURCES 10

int available[MAX_RESOURCES];
int maximum[MAX_PROCESSES][MAX_RESOURCES];
int allocation[MAX_PROCESSES][MAX_RESOURCES];
int need[MAX_PROCESSES][MAX_RESOURCES];
bool finish[MAX_PROCESSES];

bool is_safe(int process_count, int resource_count) {
    int work[MAX_RESOURCES];
    for (int i = 0; i < resource_count; i++) {
        work[i] = available[i];
    }

    bool found;
    do {
        found = false;
        for (int i = 0; i < process_count; i++) {
            if (!finish[i]) {
                bool can_allocate = true;
                for (int j = 0; j < resource_count; j++) {
                    if (need[i][j] > work[j]) {
                        can_allocate = false;
                        break;
                    }
                }

                if (can_allocate) {
                    for (int j = 0; j < resource_count; j++) {
                        work[j] += allocation[i][j];
                    }
                    finish[i] = true;
                    found = true;
                }
            }
        }
    } while (found);

    for (int i = 0; i < process_count; i++) {
        if (!finish[i]) {
            return false;
        }
    }

    return true;
}

bool request_resources(int process_count, int resource_count, int process, int request[]) {
    for (int i = 0; i < resource_count; i++) {
        if (request[i] > need[process][i] || request[i] > available[i]) {
            return false;
        }
    }

    for (int i = 0; i < resource_count; i++) {
        available[i] -= request[i];
        allocation[process][i] += request[i];
        need[process][i] -= request[i];
    }

    if (!is_safe(process_count, resource_count)) {
        for (int i = 0; i < resource_count; i++) {
            available[i] += request[i];
            allocation[process][i] -= request[i];
            need[process][i] += request[i];
        }
        return false;
    }

    return true;
}

bool release_resources(int process_count, int resource_count, int process, int release[]) {
    for (int i = 0; i < resource_count; i++) {
        if (release[i] > allocation[process][i]) {
            return false;
        }
    }

    for (int i = 0; i < resource_count; i++) {
        available[i] += release[i];
        allocation[process][i] -= release[i];
        need[process][i] += release[i];
    }

    return true;
}

int main() {
    int process_count, resource_count;

    printf("Enter the number of processes: ");
    scanf("%d", &process_count);

    printf("Enter the number of resources: ");
    scanf("%d", &resource_count);

    printf("Enter the available resources:\n");
    for (int i = 0; i < resource_count; i++) {
        scanf("%d", &available[i]);
    }

    printf("Enter the maximum resource need for each process:\n");
    for (int i = 0; i < process_count; i++) {
        for (int j = 0; j < resource_count; j++) {
            scanf("%d", &maximum[i][j]);
        }
    }

    printf("Enter the allocated resources for each process:\n");
    for (int i = 0; i < process_count; i++) {
        for (int j = 0; j < resource_count; j++) {
            scanf("%d", &allocation[i][j]);
            need[i][j] = maximum[i][j] - allocation[i][j];
        }
        finish[i] = false;
    }

    if (is_safe(process_count, resource_count)) {
        printf("The system is in a safe state.\n");
    } else {
        printf("The system is not in a safe state.\n");
    }

    return 0;
}
